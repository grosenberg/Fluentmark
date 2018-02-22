package net.certiv.fluentmark.handlers.dialog;

import java.util.LinkedHashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.handlers.ExportPdfHandler;
import net.certiv.fluentmark.preferences.Prefs;
import net.certiv.fluentmark.util.FileUtils;
import net.certiv.fluentmark.util.SwtUtil;

public class PdfDialog extends MessageDialog {

	private static final String Title = "PDF Save Options";
	private static final String Msg = "PDF Save Options";

	private IPreferenceStore store;
	private ExportPdfHandler handler;
	private IFile source;

	private Text txtTmpl;
	private Button btnTmpl;
	private Text txtSave;
	private Button btnSave;

	public PdfDialog(Shell parent, ExportPdfHandler handler, IFile source) {
		super(parent, Title, null, Msg, MessageDialog.NONE, 1, "Generate", "Cancel");
		this.store = FluentMkUI.getDefault().getCombinedPreferenceStore();
		this.handler = handler;
		this.source = source;
	}

	@Override
	protected Control createCustomArea(Composite parent) {
		Composite comp = SwtUtil.makeComposite(parent, 1, 3);

		// Template select ------------------------------

		SwtUtil.makeLabel(comp, "Template:", 1);

		txtTmpl = SwtUtil.makeText(comp, 1);
		txtTmpl.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				handler.setTemplate(txtTmpl.getText());
			}
		});
		txtTmpl.setText(findLast());

		btnTmpl = SwtUtil.makeButton(comp, "Browse", 1);
		btnTmpl.addSelectionListener(tmplListener);

		// Save destination select ----------------------

		SwtUtil.makeLabel(comp, "Save to:", 1);

		txtSave = SwtUtil.makeText(comp, 1);
		txtSave.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				handler.setDestination(txtSave.getText());
			}
		});
		IPath path = source.getLocation().removeFileExtension().addFileExtension("pdf");
		txtSave.setText(path.toString());

		btnSave = SwtUtil.makeButton(comp, "Browse", 1);
		btnSave.addSelectionListener(saveListener);

		// Options --------------------------------------

		// ----------------------------------------------

		return comp;
	}

	private String findLast() {
		// key=document[pathname|name]; value=template pathname
		LinkedHashMap<String, String> map = FileUtils.getTemplateMap();
		String pathname = map.get(source.getFullPath().toString()); // by WS relative source file pathname
		if (pathname == null) pathname = map.get(source.getName()); // by source filename
		if (pathname == null || pathname.equals("default")) return "";
		return pathname;
	}

	private SelectionListener tmplListener = new SelectionAdapter() {

		@Override
		public void widgetSelected(SelectionEvent e) {
			String base = store.getString(Prefs.EDITOR_PANDOC_TEMPLATES).trim();
			base = base.endsWith("/") ? base : base + "/"; // default template base directory
			String name = ""; // default template name

			IPath tmplPath = new Path(findLast());
			switch (tmplPath.segmentCount()) {
				case 0:
					break;
				case 1:
					name = tmplPath.lastSegment();
					break;
				default:
					base = tmplPath.removeLastSegments(1).addTrailingSeparator().toString();
					name = tmplPath.lastSegment();
			}

			FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
			dialog.setFilterNames(new String[] { "Tex Files", "All Files (*.*)" });
			dialog.setFilterExtensions(new String[] { "*.tex", "*.*" });
			dialog.setFilterPath(base);
			dialog.setFileName(name);

			String pathname = dialog.open();
			if (pathname != null) txtTmpl.setText(pathname);
		}
	};

	private SelectionListener saveListener = new SelectionAdapter() {

		@Override
		public void widgetSelected(SelectionEvent e) {
			IPath path = source.getLocation().removeFileExtension().addFileExtension("pdf");
			String base = path.removeLastSegments(1).addTrailingSeparator().toString();
			String name = path.lastSegment();

			FileDialog dialog = new FileDialog(getShell(), SWT.SAVE);
			dialog.setFilterNames(new String[] { "PDF Files", "All Files (*.*)" });
			dialog.setFilterExtensions(new String[] { "*.pdf", "*.*" });
			dialog.setFilterPath(base);
			dialog.setFileName(name);

			String pathname = dialog.open();
			if (pathname != null) txtSave.setText(pathname);
		}
	};
}
