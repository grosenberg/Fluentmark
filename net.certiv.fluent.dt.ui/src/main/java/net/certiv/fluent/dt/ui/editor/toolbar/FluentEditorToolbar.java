package net.certiv.fluent.dt.ui.editor.toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.actions.ActionGroup;

import net.certiv.common.ex.IType;
import net.certiv.dsl.ui.util.ActionUtil;
import net.certiv.fluent.dt.ui.editor.FluentEditor;

/**
 * The toolbar for the Fluent editor. Requires a Fluent editor.
 */
public class FluentEditorToolbar extends EditorToolbar {

	private static final class JavaEditorEditorToolbarContentProvider implements ITreeContentProvider {

		private final StandardJavaElementContentProvider fParent;
		private Object[] fElements;
		private Object fLastInputElement;

		public JavaEditorEditorToolbarContentProvider(StandardJavaElementContentProvider parent) {
			fParent = parent;
		}

		/*
		 * @see
		 * org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.
		 * Object)
		 */
		@Override
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		/*
		 * @see
		 * org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
		 */
		@Override
		public Object[] getChildren(Object inputElement) {
			if (inputElement == fLastInputElement) return fElements;

			fLastInputElement = inputElement;
			if (inputElement instanceof IPackageFragment) {
				fElements = getPackageContent((IPackageFragment) inputElement);
			} else if (inputElement instanceof IProject) {
				IProject project = (IProject) inputElement;
				if (project.isAccessible()) {
					try {
						fElements = ((IProject) inputElement).members();
					} catch (CoreException e) {
						JavaPlugin.log(e);
					}
				} else {
					fElements = new Object[0];
				}
			} else if (inputElement instanceof IPackageFragmentRoot) {

				ArrayList<Object> packages = new ArrayList<>();
				for (Object object : fParent.getChildren(inputElement)) {
					if (object instanceof IPackageFragment) {
						try {
							if (((IPackageFragment) object).hasChildren()) packages.add(object);
						} catch (JavaModelException e) {
							JavaPlugin.log(e);
							packages.add(object);
						}
					} else
						if (object instanceof ITypeRoot && JavaModelUtil.isModuleInfo((ITypeRoot) object)) {
							try {
								packages.add(((ITypeRoot) object).getModule()); // skip
																				 // the
																				 // compilation
																				 // unit
							} catch (JavaModelException e) {
								JavaPlugin.log(e);
								packages.add(object);
							}
						} else {
							packages.add(object);
						}
				}
				fElements = packages.toArray();
			} else if (inputElement instanceof IJavaModel) {
				fElements = getAccessibleProjects((IJavaModel) inputElement);
			} else {
				fElements = fParent.getChildren(inputElement);
			}

			return fElements;
		}

		/**
		 * Returns all accessible projects of the given Java model.
		 *
		 * @param model the Java model
		 * @return the accessible projects of the given model
		 */
		private Object[] getAccessibleProjects(IJavaModel model) {
			IJavaProject[] javaProjects;
			Object[] nonJavaResources;
			try {
				javaProjects = model.getJavaProjects();
				nonJavaResources = model.getNonJavaResources();
			} catch (JavaModelException e) {
				return fParent.getChildren(model);
			}
			ArrayList<IAdaptable> result = new ArrayList<>(javaProjects.length + nonJavaResources.length);
			for (Object nonJavaResource : nonJavaResources) {
				IProject project = (IProject) nonJavaResource;
				if (project.isAccessible()) result.add(project);
			}
			for (IJavaProject javaProject : javaProjects) {
				if (javaProject.getProject().isAccessible()) result.add(javaProject);
			}
			return result.toArray(new Object[result.size()]);
		}

		/*
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
		 */
		@Override
		public Object getParent(Object element) {
			if (element instanceof IType && ((IType) element).isBinary()) {
				IType declaringType = ((IType) element).getDeclaringType();
				if (declaringType != null) return declaringType;
			}
			if (element instanceof IModuleDescription) {
				IJavaElement parent = ((IModuleDescription) element).getParent();
				if (parent instanceof ITypeRoot && parent.getParent().exists()) // no
																				 // containing
																				 // package
																				 // if not
																				 // on the
																				 // classpath
					element = parent;
			}

			Object result = fParent.getParent(element);

			if (result instanceof ITypeRoot) {
				if (ActionUtil.isOnBuildPath((IJavaElement) result)) {
					result = fParent.getParent(result);
				} else {
					result = ((ITypeRoot) result).getResource();
					if (result instanceof IFile) result = fParent.getParent(result);
				}
			}

			return result;
		}

		/*
		 * @see
		 * org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
		 */
		@Override
		public boolean hasChildren(Object element) {
			if (element instanceof IProject) {
				IProject project = (IProject) element;
				if (!project.isAccessible()) {
					return false;
				}
				try {
					return project.members().length > 0;
				} catch (CoreException e) {
					JavaPlugin.log(e);
				}
				return false;
			} else {
				return fParent.hasChildren(element);
			}
		}

		private Object[] getPackageContent(IPackageFragment pack) {
			ArrayList<Object> result = new ArrayList<>();
			try {
				for (ICompilationUnit unit : pack.getCompilationUnits()) {
					if (JavaModelUtil.isPackageInfo(unit)) {
						result.add(unit);
					}
					for (IType type : unit.getTypes()) {
						if (isValidType(type)) {
							result.add(type);
						}
					}
				}

				for (IOrdinaryClassFile classFile : pack.getOrdinaryClassFiles()) {
					if (isValidType(classFile.getType())) {
						result.add(classFile.getType());
					}
				}

				Object[] nonJavaResources = pack.getNonJavaResources();
				result.addAll(Arrays.asList(nonJavaResources));
			} catch (JavaModelException e) {
				JavaPlugin.log(e);
			}

			return result.toArray();
		}

		private boolean isValidType(IType type) {
			if (type.getDeclaringType() != null) return false;

			try {
				return !type.isAnonymous();
			} catch (JavaModelException e) {
				JavaPlugin.log(e);
				return false;
			}
		}

		/*
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 */
		@Override
		public void dispose() {
			fParent.dispose();
		}

		/*
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.
		 * viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			fElements = null;
			fLastInputElement = null;
			fParent.inputChanged(viewer, oldInput, newInput);
		}
	}

	private class ElementChangeListener implements IElementChangedListener {

		private Runnable fRunnable;

		/*
		 * @seeorg.eclipse.jdt.core.IElementChangedListener#elementChanged(org.eclipse.jdt
		 * .core. ElementChangedEvent)
		 */
		@Override
		public void elementChanged(ElementChangedEvent event) {
			if (viewer == null) return;

			Object input = viewer.getInput();
			if (!(input instanceof IJavaElement)) return;

			if (fRunnable != null) return;

			final IJavaElement changedElement = getChangedParentElement((IJavaElement) input,
					event.getDelta());
			if (changedElement == null) return;

			fRunnable = () -> {
				if (viewer == null) return;

				Object newInput = getCurrentInput();
				if (newInput instanceof IJavaElement) newInput = getInput((IJavaElement) newInput);

				viewer.setInput(newInput);
				fRunnable = null;
			};
			viewer.getControl().getDisplay().asyncExec(fRunnable);
		}

		/**
		 * Returns the most generic ancestor of the given input which has a change, or
		 * <b>null</b> if no such ancestor exists.
		 *
		 * @param input the input of which the result must be an ancestor
		 * @param delta the delta describing the model change
		 * @return the changed element or {@code null}
		 */
		private IJavaElement getChangedParentElement(IJavaElement input, IJavaElementDelta delta) {
			IJavaElement element = delta.getElement();

			if (!isAncestor(element, input)) return null;

			if (element instanceof ICompilationUnit) {
				ICompilationUnit cu = (ICompilationUnit) element;
				if (!cu.getPrimary().equals(cu)) return null;

				if (isStructuralChange(delta)) return element;
			} else {
				if (!onlyChildrenChanged(delta)) return element;
			}

			for (IJavaElementDelta affectedChild : delta.getAffectedChildren()) {
				IJavaElement res = getChangedParentElement(input, affectedChild);
				if (res != null) return res;
			}

			return null;
		}

		/**
		 * Tells whether the given element is an ancestor of the given input.
		 *
		 * @param element the element which might be a parent
		 * @param input   the element to resolve the parent chain for
		 * @return {@code true} if {@code element} is a parent of {@code input}
		 */
		private boolean isAncestor(IJavaElement element, IJavaElement input) {
			while (input != null && !input.equals(element)) {
				input = input.getParent();
			}

			return input != null;
		}

		private boolean isStructuralChange(IJavaElementDelta delta) {
			if (delta.getKind() != IJavaElementDelta.CHANGED) return true;

			return (delta.getFlags() & (IJavaElementDelta.F_CONTENT
					| IJavaElementDelta.F_FINE_GRAINED)) == IJavaElementDelta.F_CONTENT;
		}

		private boolean onlyChildrenChanged(IJavaElementDelta delta) {
			if (delta.getKind() != IJavaElementDelta.CHANGED) return false;

			return (delta.getFlags() & ~IJavaElementDelta.F_FINE_GRAINED) == IJavaElementDelta.F_CHILDREN;
		}
	}

	private EditorToolbarViewer viewer;
	private ISelection editorSelection;
	private ElementChangeListener elementChangeListener;

	public FluentEditorToolbar(FluentEditor editor) {
		super(editor);
		setTextViewer(editor.getViewer());
	}

	public IWorkbenchPartSite getSite() {
		return getTextEditor().getSite();
	}

	@Override
	protected void activateEditorToolbar() {
		editorSelection = getTextEditor().getSelectionProvider().getSelection();
	}

	@Override
	protected void deactivateEditorToolbar() {
		editorSelection = null;
	}

	@Override
	protected EditorToolbarViewer createViewer(Composite composite) {
		viewer = new FluentEditorToolbarViewer(getSite(), composite, SWT.HORIZONTAL);

		// viewer.setLabelProvider(createLabelProvider());
		// viewer.setToolTipLabelProvider(createToolTipLabelProvider());

		viewer.setContentProvider(createContentProvider());
		viewer.addSelectionChangedListener(
				event -> fEditorToolbarActionGroup.setContext(new ActionContext(viewer.getSelection())));

		fEditorToolbarActionGroup = new JavaEditorEditorToolbarActionGroup(getJavaEditor(), viewer);

		elementChangeListener = new ElementChangeListener();
		JavaCore.addElementChangedListener(elementChangeListener);

		return viewer;
	}

	/**
	 * Create a new instance of the content provider to use for the Java editor toolbar.
	 *
	 * @return a new content provider
	 */
	private static JavaEditorEditorToolbarContentProvider createContentProvider() {
		StandardJavaElementContentProvider parentContentProvider = new StandardJavaElementContentProvider(
				true);
		return new JavaEditorEditorToolbarContentProvider(parentContentProvider);
	}

	/**
	 * Create a new instance of the content provider to use for the Java editor toolbar.
	 *
	 * @return a new content provider
	 * @since 3.5
	 */
	private static JavaEditorEditorToolbarContentProvider createDropDownContentProvider() {
		StandardJavaElementContentProvider parentContentProvider = new StandardJavaElementContentProvider(
				true) {
			@Override
			public Object[] getChildren(Object element) {
				if (element instanceof PackageFragmentRootContainer)
					return getContainerPackageFragmentRoots((PackageFragmentRootContainer) element);
				return super.getChildren(element);
			}

			@Override
			protected Object[] getPackageFragmentRoots(IJavaProject project) throws JavaModelException {
				if (!project.getProject().isOpen()) return NO_CHILDREN;

				List<Object> result = new ArrayList<>();

				for (IPackageFragmentRoot root : project.getPackageFragmentRoots()) {
					IClasspathEntry classpathEntry = JavaModelUtil.getClasspathEntry(root);
					int entryKind = classpathEntry.getEntryKind();
					if (entryKind != IClasspathEntry.CPE_CONTAINER // all
																	 // ClassPathContainers
																	 // are added later
							&& (!SHOW_LIBRARIES_NODE || (entryKind != IClasspathEntry.CPE_LIBRARY
									&& entryKind != IClasspathEntry.CPE_VARIABLE))) { // skip:
																						 // will
																						 // add
																						 // the
																						 // referenced
																						 // library
																						 // node
																						 // later
						if (isProjectPackageFragmentRoot(root)) {
							// filter out package fragments that correspond to projects
							// and
							// replace them with the package fragments directly
							Object[] fragments = getPackageFragmentRootContent(root);
							result.addAll(Arrays.asList(fragments));
						} else {
							result.add(root);
						}
					}
				}

				if (SHOW_LIBRARIES_NODE) {
					result.add(new LibraryContainer(project));
				}

				// separate loop to make sure all containers are on the classpath
				for (IClasspathEntry classpathEntry : project.getRawClasspath()) {
					if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_CONTAINER) {
						result.add(new ClassPathContainer(project, classpathEntry));
					}
				}
				Object[] resources = project.getNonJavaResources();
				result.addAll(Arrays.asList(resources));
				return result.toArray();
			}

			private Object[] getContainerPackageFragmentRoots(PackageFragmentRootContainer container) {
				return container.getChildren();
			}

			@Override
			protected Object internalGetParent(Object element) {
				if (element instanceof IPackageFragmentRoot) {
					// since we insert logical package containers we have to fix
					// up the parent for package fragment roots so that they refer
					// to the container and containers refer to the project
					IPackageFragmentRoot root = (IPackageFragmentRoot) element;

					try {
						IClasspathEntry entry = root.getRawClasspathEntry();
						int entryKind = entry.getEntryKind();
						if (entryKind == IClasspathEntry.CPE_CONTAINER) {
							return new ClassPathContainer(root.getJavaProject(), entry);
						} else if (SHOW_LIBRARIES_NODE && (entryKind == IClasspathEntry.CPE_LIBRARY
								|| entryKind == IClasspathEntry.CPE_VARIABLE)) {
									return new LibraryContainer(root.getJavaProject());
								}
					} catch (JavaModelException e) {
						// fall through
					}
				} else if (element instanceof PackageFragmentRootContainer) {
					return ((PackageFragmentRootContainer) element).getJavaProject();
				}
				return super.internalGetParent(element);
			}

		};
		return new JavaEditorEditorToolbarContentProvider(parentContentProvider);
	}

	/**
	 * Create a new instance of the label provider to use for the Java editor toolbar.
	 *
	 * @return a new label provider
	 */
	private static ILabelProvider createLabelProvider() {
		final AppearanceAwareLabelProvider result = new AppearanceAwareLabelProvider(
				JavaElementLabels.ROOT_VARIABLE | JavaElementLabels.T_TYPE_PARAMETERS
						| JavaElementLabels.M_PARAMETER_TYPES | JavaElementLabels.M_APP_TYPE_PARAMETERS
						| JavaElementLabels.M_APP_RETURNTYPE | JavaElementLabels.F_APP_TYPE_SIGNATURE
						| JavaElementLabels.ALL_CATEGORY2 | JavaElementLabels.P_COMPRESSED,
				JavaElementImageProvider.SMALL_ICONS | AppearanceAwareLabelProvider.DEFAULT_IMAGEFLAGS);

		return new DecoratingJavaLabelProvider(result) {

			/*
			 * @see
			 * org.eclipse.jdt.internal.ui.viewsupport.ColoringLabelProvider#getText(java.
			 * lang.Object )
			 */
			@Override
			public String getText(Object element) {
				if (element instanceof IPackageFragmentRoot) {
					IPackageFragmentRoot root = (IPackageFragmentRoot) element;
					if (root.isArchive() && root.isExternal()) {
						return JavaElementLabels.getElementLabel(root, JavaElementLabels.ALL_DEFAULT);
					}
				}

				return result.getText(element);
			}

			/*
			 * @see
			 * org.eclipse.jface.viewers.DecoratingStyledCellLabelProvider#getStyledText(
			 * java.lang.Object)
			 */
			@Override
			protected StyledString getStyledText(Object element) {
				return new StyledString(getText(element));
			}
		};
	}

	/**
	 * Returns the label provider to use for the tool tips.
	 *
	 * @return a label provider for the tool tips
	 */
	private ILabelProvider createToolTipLabelProvider() {
		final AppearanceAwareLabelProvider result = new AppearanceAwareLabelProvider(
				AppearanceAwareLabelProvider.DEFAULT_TEXTFLAGS | JavaElementLabels.F_APP_TYPE_SIGNATURE
						| JavaElementLabels.ALL_CATEGORY2,
				JavaElementImageProvider.SMALL_ICONS | AppearanceAwareLabelProvider.DEFAULT_IMAGEFLAGS);

		return new DecoratingJavaLabelProvider(result);
	}

	/*
	 * @see org.eclipse.jdt.internal.ui.javaeditor.toolbar.EditorEditorToolbar#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();

		if (viewer != null) {
			fEditorToolbarActionGroup.dispose();
			JavaCore.removeElementChangedListener(elementChangeListener);
			viewer = null;
		}
	}

	/*
	 * @see org.eclipse.jdt.internal.ui.javaeditor.toolbar.EditorEditorToolbar#
	 * createContextMenuActionGroup(org.eclipse.jface.viewers.ISelectionProvider)
	 */
	@Override
	protected ActionGroup createContextMenuActionGroup(ISelectionProvider selectionProvider) {
		return new JavaEditorEditorToolbarActionGroup(getJavaEditor(), selectionProvider);
	}

	/*
	 * @see
	 * org.eclipse.jdt.internal.ui.javaeditor.toolbar.EditorEditorToolbar#setInput(java.
	 * lang.Object)
	 */
	@Override
	public void setInput(Object element) {
		if (element == null) {
			element = getCurrentInput();
			if (element instanceof IType) {
				element = ((IType) element).getDeclaringType();
			}
		}

		if (element instanceof IJavaElement) {
			super.setInput(getInput((IJavaElement) element));
		} else {
			super.setInput(element);
		}
	}

	/*
	 * @see
	 * org.eclipse.jdt.internal.ui.javaeditor.toolbar.EditorEditorToolbar#getCurrentInput(
	 * )
	 */
	@Override
	protected Object getCurrentInput() {
		try {
			ITypeRoot input = SelectionConverter.getInput(getJavaEditor());
			if (input == null) return null;

			ITextSelection selection;
			if (editorSelection instanceof ITextSelection) {
				selection = (ITextSelection) editorSelection;
			} else {
				selection = (ITextSelection) getJavaEditor().getSelectionProvider().getSelection();
			}
			return getInput(SelectionConverter.getElementAtOffset(input, selection));
		} catch (JavaModelException e) {
			return null;
		}
	}

	/**
	 * Returns the input for the given element. The Java toolbar does not show some
	 * elements of the model:
	 * <ul>
	 * <li><code>ITypeRoots</li>
	 * <li><code>IPackageDeclaration</li>
	 * <li><code>IImportContainer</li>
	 * <li><code>IImportDeclaration</li>
	 * </ul>
	 *
	 * @param element the potential input element
	 * @return the element to use as input
	 */
	private IJavaElement getInput(IJavaElement element) {
		try {
			if (element instanceof IImportDeclaration) element = element.getParent();

			if (element instanceof IImportContainer) element = element.getParent();

			if (element instanceof IPackageDeclaration) element = element.getParent();

			if (element instanceof ICompilationUnit) {
				IType[] types = ((ICompilationUnit) element).getTypes();
				if (types.length > 0) element = types[0];
			}

			if (element instanceof IOrdinaryClassFile) element = ((IOrdinaryClassFile) element).getType();

			if (element instanceof IModularClassFile) element = ((IModularClassFile) element).getModule();

			return element;
		} catch (JavaModelException e) {
			return null;
		}
	}

	/*
	 * @see
	 * org.eclipse.jdt.internal.ui.javaeditor.toolbar.EditorEditorToolbar#open(java.lang.
	 * Object)
	 */
	@Override
	protected boolean open(Object element) {
		if (element instanceof IFile) return openInNewEditor(element);

		if (element instanceof IJarEntryResource) {
			if (((IJarEntryResource) element).isFile()) return openInNewEditor(element);
			return false;
		}

		if (!(element instanceof IJavaElement)) return false;

		IJavaElement javaElement = (IJavaElement) element;

		ITypeRoot root = (ITypeRoot) javaElement.getAncestor(IJavaElement.COMPILATION_UNIT);
		if (root == null) root = (ITypeRoot) javaElement.getAncestor(IJavaElement.CLASS_FILE);

		if (root == null) return false;

		return openInNewEditor(element);
	}

	/*
	 * @see
	 * org.eclipse.jdt.internal.ui.javaeditor.toolbar.EditorEditorToolbar#reveal(java.lang
	 * .Object)
	 */
	@Override
	protected boolean reveal(Object element) {
		if (!(element instanceof IJavaElement)) return false;

		IJavaElement javaElement = (IJavaElement) element;

		ITypeRoot inputElement = EditorUtility.getEditorInputJavaElement(getJavaEditor(), false);

		ITypeRoot root = (ITypeRoot) javaElement.getAncestor(IJavaElement.COMPILATION_UNIT);
		if (root == null) root = (ITypeRoot) javaElement.getAncestor(IJavaElement.CLASS_FILE);

		if (root == null) return false;

		if (!root.equals(inputElement)) return false;

		return revealInEditor(javaElement);
	}

	private boolean openInNewEditor(Object element) {
		try {
			IEditorPart newEditor = EditorUtility.openInEditor(element);
			if (newEditor != null && element instanceof IJavaElement)
				EditorUtility.revealInEditor(newEditor, (IJavaElement) element);

			return true;
		} catch (PartInitException e) {
			JavaPlugin.log(e);
			return false;
		}
	}

	private boolean revealInEditor(IJavaElement element) {
		EditorUtility.revealInEditor(getJavaEditor(), element);
		return true;
	}

	private JavaEditor getJavaEditor() {
		return (JavaEditor) getTextEditor();
	}

}
