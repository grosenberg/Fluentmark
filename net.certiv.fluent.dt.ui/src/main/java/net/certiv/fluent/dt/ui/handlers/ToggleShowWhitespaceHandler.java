package net.certiv.fluent.dt.ui.handlers;

import static org.eclipse.ui.texteditor.AbstractTextEditor.*;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IPainter;
import org.eclipse.jface.text.WhitespaceCharacterPainter;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.IDslUIDef;
import net.certiv.dsl.ui.editor.DslEditor;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.ui.FluentUI;

public class ToggleShowWhitespaceHandler extends AbstractHandler implements IElementUpdater, IDslUIDef {

	private IPreferenceStore store;
	private IPainter painter;

	public ToggleShowWhitespaceHandler() {
		super();
	}

	@Override
	public DslUI getDslUI() {
		return FluentUI.getDefault();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		DslEditor editor = (DslEditor) HandlerUtil.getActiveEditor(event);
		SourceViewer viewer = editor.getViewer();
		store = editor.getPrefsMgr();

		boolean checked = !checked();
		togglePainterState(viewer, checked);
		store.setValue(PREFERENCE_SHOW_WHITESPACE_CHARACTERS, checked);
		return null;
	}

	@Override
	@SuppressWarnings({ "rawtypes" })
	public void updateElement(UIElement element, Map parameters) {
		element.setChecked(checked());
	}

	private boolean checked() {
		if (store == null) {
			store = getDslCore().getPrefsManager();
		}
		return store.getBoolean(PREFERENCE_SHOW_WHITESPACE_CHARACTERS);
	}

	/** Toggles the painter state. */
	private void togglePainterState(SourceViewer viewer, boolean enable) {
		if (enable) {
			installPainter(viewer);
		} else {
			uninstallPainter(viewer);
		}
	}

	/** Install the painter on the editor. */
	private void installPainter(SourceViewer viewer) {
		Assert.isTrue(painter == null);

		boolean leadingSpaces = store.getBoolean(PREFERENCE_SHOW_LEADING_SPACES);
		boolean enclosedSpaces = store.getBoolean(PREFERENCE_SHOW_ENCLOSED_SPACES);
		boolean trailingSpaces = store.getBoolean(PREFERENCE_SHOW_TRAILING_SPACES);
		boolean leadingIdeographicSpaces = store.getBoolean(PREFERENCE_SHOW_LEADING_IDEOGRAPHIC_SPACES);
		boolean enclosedIdeographicSpaces = store.getBoolean(PREFERENCE_SHOW_ENCLOSED_IDEOGRAPHIC_SPACES);
		boolean trailingIdeographicSpaces = store.getBoolean(PREFERENCE_SHOW_TRAILING_IDEOGRAPHIC_SPACES);
		boolean leadingTabs = store.getBoolean(PREFERENCE_SHOW_LEADING_TABS);
		boolean enclosedTabs = store.getBoolean(PREFERENCE_SHOW_ENCLOSED_TABS);
		boolean trailingTabs = store.getBoolean(PREFERENCE_SHOW_TRAILING_TABS);
		boolean carriageReturn = store.getBoolean(PREFERENCE_SHOW_CARRIAGE_RETURN);
		boolean lineFeed = store.getBoolean(PREFERENCE_SHOW_LINE_FEED);
		int alpha = store.getInt(PREFERENCE_WHITESPACE_CHARACTER_ALPHA_VALUE);

		painter = new WhitespaceCharacterPainter(viewer, leadingSpaces, enclosedSpaces, trailingSpaces,
				leadingIdeographicSpaces, enclosedIdeographicSpaces, trailingIdeographicSpaces, leadingTabs,
				enclosedTabs, trailingTabs, carriageReturn, lineFeed, alpha);
		viewer.addPainter(painter);
	}

	/** Remove the painter from the current editor. */
	private void uninstallPainter(SourceViewer viewer) {
		if (painter == null) return;

		viewer.removePainter(painter);
		painter.deactivate(true);
		painter = null;
	}
}
