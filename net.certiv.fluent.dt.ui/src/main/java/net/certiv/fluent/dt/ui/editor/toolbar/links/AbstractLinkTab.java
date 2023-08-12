package net.certiv.fluent.dt.ui.editor.toolbar.links;

import java.net.URI;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.undo.DocumentUndoManagerRegistry;
import org.eclipse.text.undo.IDocumentUndoManager;

import net.certiv.common.log.Log;
import net.certiv.common.util.Strings;
import net.certiv.dsl.ui.preferences.bind.IntegerValidator;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluent.dt.core.lang.md.model.SpecSubType;
import net.certiv.fluent.dt.core.lang.md.model.SpecializedType;

public abstract class AbstractLinkTab {

	private static final String ERR_REPL = "Failure replacing link [%s]";

	protected final LinksInfo info;
	protected final int idx;

	protected final SpecializedType type;
	protected final SpecSubType subtype;

	private final FieldDecoration registry;

	public AbstractLinkTab(LinksInfo info, int idx, SpecializedType type, SpecSubType subtype) {
		this.info = info;
		this.idx = idx;
		this.type = type;
		this.subtype = subtype;

		registry = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
	}

	protected abstract void createControls(Composite comp);

	protected abstract String getLinkText();

	protected String getDefText() {
		return null;
	}

	public String title() {
		return String.format("%s %s", type, subtype);
	}

	public boolean isRef() {
		return SpecSubType.REF == subtype;
	}

	protected void install() {
		try {
			IDocumentUndoManager mgr = DocumentUndoManagerRegistry.getDocumentUndoManager(info.doc);
			mgr.beginCompoundChange();
			MultiTextEdit edit = new MultiTextEdit();
			edit.addChild(new ReplaceEdit(info.selOff, info.selLen, getLinkText()));
			if (isRef()) {
				if (info.defOff < 0) {
					String def = Strings.EOL.repeat(reqsNL()) + getDefText() + Strings.EOL;
					edit.addChild(new ReplaceEdit(info.doc.getLength(), 0, def));

				} else {
					edit.addChild(new ReplaceEdit(info.defOff, info.defLen, getDefText()));
				}
			}
			edit.apply(info.doc);
			mgr.endCompoundChange();

			info.setCursorOffset(info.pos);

		} catch (MalformedTreeException | BadLocationException e) {
			Log.error(ERR_REPL, e.getMessage());
		}
	}

	private int reqsNL() {
		try {
			int end = info.doc.getLength() - 1;
			int ln = info.doc.getLineOfOffset(end);

			String last = getLine(ln).trim();
			if (!last.isEmpty()) return 2;
			String prior = getLine(ln - 1).trim();
			if (!prior.isEmpty()) return 1;

		} catch (BadLocationException e) {}
		return 0;
	}

	private String getLine(int ln) throws BadLocationException {
		if (ln < 1) return Strings.EMPTY;
		int off = info.doc.getLineOffset(ln);
		int len = info.doc.getLineLength(ln);
		return info.doc.get(off, len);
	}

	protected Text lineNum(Composite comp, String label, int width, int line) {
		return labeledText(comp, SWT.SINGLE | SWT.READ_ONLY, SWT.BEGINNING, label, width, 0,
				String.valueOf(line), new IntegerValidator(1));
	}

	protected Text labeledText(Composite parent, String label, int width, String text,
			IInputValidator validator) {

		return labeledText(parent, SWT.SINGLE, SWT.BEGINNING, label, width, 0, text, validator);
	}

	protected Text labeledText(Composite parent, int style, int align, String label, int width, int height,
			String text, IInputValidator validator) {

		SWTFactory.createLabel(parent, label, SWT.BEGINNING);
		Text field = SWTFactory.createText(parent, style | SWT.BORDER, align, width, height, validator);
		if (validator != null) {
			ControlDecoration decorator = createDecoration(field);
			field.addModifyListener(evt -> validate(field, validator, decorator));
		}
		field.setText(text);
		return field;
	}

	private void validate(Text field, IInputValidator validator, ControlDecoration decorator) {
		String err = validator.isValid(field.getText());
		if (err == null) {
			decorator.hide();
		} else {
			decorator.setDescriptionText(err);
			decorator.show();
		}
	}

	public ControlDecoration createDecoration(Control control) {
		ControlDecoration decorator = new ControlDecoration(control, SWT.LEFT | SWT.TOP);
		decorator.setImage(registry.getImage());
		decorator.setShowOnlyOnFocus(false);
		decorator.setMarginWidth(3);
		return decorator;
	}

	public static class RefValidator implements IInputValidator {

		private final Text txtField;

		public RefValidator() {
			this(null);
		}

		public RefValidator(Text txtField) {
			this.txtField = txtField;
		}

		@Override
		public String isValid(String ref) {
			if (txtField == null) {
				if (!ref.isBlank()) return null;
				return "Reference must not be empty";
			}

			if (!ref.isBlank() || !txtField.getText().isBlank()) return null;
			return "Reference (or text) must not be empty";
		}
	}

	public static class URIValidator implements IInputValidator {

		@Override
		public String isValid(String uri) {

			try {
				URI.create(uri);
				return null;
			} catch (Exception e) {
				return "Not a valid URI";
			}
		}
	}

	public static class AltValidator implements IInputValidator {

		// use look behind '(?<!\\)' to exclude escaping
		private static final Pattern DQUOTE = Pattern.compile("(?<!\\\\)\"");

		@Override
		public String isValid(String alt) {
			if (!DQUOTE.matcher(alt).find()) return null;
			return "Must escape double quotes or use single quotes";
		}
	}
}
