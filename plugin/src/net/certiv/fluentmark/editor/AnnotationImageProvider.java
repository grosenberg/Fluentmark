package net.certiv.fluentmark.editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.IAnnotationImageProvider;

import net.certiv.fluentmark.FluentImages;
import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.preferences.Prefs;

/** Image provider for problem marker annotations. */
public class AnnotationImageProvider implements IAnnotationImageProvider {

	private static final int NO_IMAGE = 0;
	private static final int GRAY_IMAGE = 1;
	private static final int OVERLAY_IMAGE = 2;
	private static final int QUICKFIX_IMAGE = 3;
	private static final int QUICKFIX_ERROR_IMAGE = 4;

	private static Image quickFixImage;
	private static Image quickFixErrorImage;
	private static ImageRegistry imageRegistry;

	private FluentUI fluentUI;
	private boolean showQuickFixIcon;
	private int cachedImageType;
	private Image cachedImage;

	public AnnotationImageProvider() {
		fluentUI = FluentUI.getDefault();
		showQuickFixIcon = fluentUI.getPreferenceStore().getBoolean(Prefs.EDITOR_CORRECTION_INDICATION);
	}

	@Override
	public Image getManagedImage(Annotation annotation) {
		if (annotation instanceof IFluentAnnotation) {
			IFluentAnnotation fAnnotation = (IFluentAnnotation) annotation;
			int imageType = getImageType(fAnnotation);
			return getImage(fAnnotation, imageType, Display.getCurrent());
		}
		return null;
	}

	@Override
	public String getImageDescriptorId(Annotation annotation) {
		return null; // unmanaged images are not supported
	}

	@Override
	public ImageDescriptor getImageDescriptor(String symbolicName) {
		return null; // unmanaged images are not supported
	}

	private boolean showQuickFix(IFluentAnnotation annotation) {
		return showQuickFixIcon && annotation.isProblem() &&
		/* JavaCorrectionProcessor.hasCorrections((Annotation) annotation) */
				false;
	}

	private Image getQuickFixImage() {
		if (quickFixImage == null)
			quickFixImage = fluentUI.getImageProvider().get(FluentImages.IMG_OBJS_FIXABLE_PROBLEM);
		return quickFixImage;
	}

	private Image getQuickFixErrorImage() {
		if (quickFixErrorImage == null)
			quickFixErrorImage = fluentUI.getImageProvider().get(FluentImages.IMG_OBJS_FIXABLE_ERROR);
		return quickFixErrorImage;
	}

	private ImageRegistry getImageRegistry(Display display) {
		if (imageRegistry == null) imageRegistry = new ImageRegistry(display);
		return imageRegistry;
	}

	private int getImageType(IFluentAnnotation annotation) {
		int imageType = NO_IMAGE;
		if (annotation.hasOverlay()) imageType = OVERLAY_IMAGE;
		else if (!annotation.isMarkedDeleted()) {
			if (showQuickFix(annotation))
				imageType = IFluentAnnotation.ERROR.equals(annotation.getType()) ? QUICKFIX_ERROR_IMAGE
						: QUICKFIX_IMAGE;
		} else {
			imageType = GRAY_IMAGE;
		}
		return imageType;
	}

	private Image getImage(IFluentAnnotation annotation, int imageType, Display display) {
		if ((imageType == QUICKFIX_IMAGE || imageType == QUICKFIX_ERROR_IMAGE) && cachedImageType == imageType)
			return cachedImage;

		Image image = null;
		switch (imageType) {
			case OVERLAY_IMAGE:
				IFluentAnnotation overlay = annotation.getOverlay();
				image = getManagedImage((Annotation) overlay);
				cachedImageType = -1;
				break;
			case QUICKFIX_IMAGE:
				image = getQuickFixImage();
				cachedImageType = imageType;
				cachedImage = image;
				break;
			case QUICKFIX_ERROR_IMAGE:
				image = getQuickFixErrorImage();
				cachedImageType = imageType;
				cachedImage = image;
				break;
			case GRAY_IMAGE: {
				ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
				String annotationType = annotation.getType();
				if (IFluentAnnotation.ERROR.equals(annotationType)) {
					image = sharedImages.getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
				} else if (IFluentAnnotation.WARNING.equals(annotationType)) {
					image = sharedImages.getImage(ISharedImages.IMG_OBJS_WARN_TSK);
				} else if (IFluentAnnotation.INFO.equals(annotationType)) {
					image = sharedImages.getImage(ISharedImages.IMG_OBJS_INFO_TSK);
				}
				if (image != null) {
					ImageRegistry registry = getImageRegistry(display);
					String key = Integer.toString(image.hashCode());
					Image grayImage = registry.get(key);
					if (grayImage == null) {
						grayImage = new Image(display, image, SWT.IMAGE_GRAY);
						registry.put(key, grayImage);
					}
					image = grayImage;
				}
				cachedImageType = -1;
				break;
			}
		}
		return image;
	}
}
