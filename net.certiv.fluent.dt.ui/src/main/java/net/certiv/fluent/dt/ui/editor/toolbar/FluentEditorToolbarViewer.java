package net.certiv.fluent.dt.ui.editor.toolbar;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPartSite;

import net.certiv.fluent.dt.ui.FluentUI;

public class FluentEditorToolbarViewer extends EditorToolbarViewer {

	private enum ItemDef implements IToolbarItemDef {
		BOLD("net.certiv.fluent.dt.bold", "IMG_OBJ_BOLD", "Bold"),
		ITALIC("net.certiv.fluent.dt.italic", "IMG_OBJ_BOLD", "Italic"),
		UNDERLINE("net.certiv.fluent.dt.underline", "IMG_OBJ_UNDERLINE", "Underline"),
		STRIKE("net.certiv.fluent.dt.strike", "IMG_OBJ_STRIKE", "Strike through"),

		;

		public final String id;
		public final Image img;
		public final String tip;

		ItemDef(String id, String img, String tip) {
			this.id = id;
			this.img = FluentUI.getDefault().getImageManager().get(img);
			this.tip = tip;
		}

		@Override
		public String id() {
			return id;
		}

		@Override
		public Image img() {
			return img;
		}

		@Override
		public String tip() {
			return tip;
		}
	}

	public FluentEditorToolbarViewer(IWorkbenchPartSite site, Composite parent, int style) {
		super(site, parent, style);
	}

	public void install() {
		createCheckItem(ItemDef.BOLD);
		createCheckItem(ItemDef.ITALIC);
		createCheckItem(ItemDef.UNDERLINE);
		createCheckItem(ItemDef.STRIKE);
	}
}
