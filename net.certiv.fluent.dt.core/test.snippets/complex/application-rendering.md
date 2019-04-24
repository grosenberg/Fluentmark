# Application rendering

This page describes how to create model-driven web applications leveraging classes and interfaces in [org.nasdanika.cdo.web.routes.app](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.web/apidocs/org/nasdanika/cdo/web/routes/app/package-summary.html) package of the [org.nasdanika.cdo.web](https://github.com/Nasdanika/server/tree/master/org.nasdanika.cdo.web) bundle, [Renderer](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.web/apidocs/org/nasdanika/cdo/web/routes/app/Renderer.html) and [Route](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.web/apidocs/org/nasdanika/cdo/web/routes/app/Route.html) in particular.

The sections below outline the entire process of creating a web application focusing on use and customization of application routes and renderers. You can find a detailed description of the entire process in the [Server-side Java Development for Innovators](https://server-side-java-development-for-innovators.books.nasdanika.org/) online book, which is work in progress at 
the time of this writing.

## Overview

The core concept of the approach described here is that Web UI can be rendered using metadata of the model elements such as
[EClass](http://download.eclipse.org/modeling/emf/emf/javadoc/2.11/org/eclipse/emf/ecore/EClass.html),
[EAttribute](http://download.eclipse.org/modeling/emf/emf/javadoc/2.11/org/eclipse/emf/ecore/EAttribute.html),
[EReference](http://download.eclipse.org/modeling/emf/emf/javadoc/2.11/org/eclipse/emf/ecore/EReference.html),
[EOperation](http://download.eclipse.org/modeling/emf/emf/javadoc/2.11/org/eclipse/emf/ecore/EOperation.html),
and [EParameter](http://download.eclipse.org/modeling/emf/emf/javadoc/2.11/org/eclipse/emf/ecore/EParameter.html). 

Rendering is performed by the Renderer interface with default method implementations or by its sub-interfaces. Renderers shall be registered with ``org.nasdanika.cdo.web.renderer`` extension point in order to be discoverable by ``Renderer.getRenderer()`` methods.

Route class extends [EDispatchingRoute](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.web/apidocs/org/nasdanika/cdo/web/routes/EDispatchingRoute.html) and implements Renderer. It contains
route methods which leverage rendering methods to build the UI.

Rendering can be customized with:

* Model annotations.
* Resource strings from resource bundles.
* Overriding default implementations rendering/routing methods.  

## Difference from Eclipse RAP

[Eclipse RAP](https://www.eclipse.org/rap/) provides means of exposing EMF/CDO web UI in a Web browser. The approach described here is fundamentally different from the one used by Eclipse RAP.

Eclipse RAP exposes SWT API's to the web. It starts a UI thread on the server which handles interactions with the browser. 
Nasdanika CDO Web processes each Web UI interaction as an HTTP request in its own CDO transaction. It also supports WebSockets but they are not used by application renderers and routes described here.

Eclipse RAP provides its own widgets toolkit, here we are going to leverage [Bootstrap](http://getbootstrap.com/) and HTML.

## Development

The development process includes the following steps:

* Set up environment.
* Generate application workspace.
* Create the application domain model. Optionally annotate the model. 
* Generate model code, edit support, and editor.
* Customize editor, e.g. add ``Set password`` action.
* Create the initial application model to be loaded into the repository on first start.
* Create Web UI generator model and generate renderers, routes, resource bundles and renderer/route registrations in ``plugin.xml``.
* Run the application in Eclipse.
* Customize/localize the Web UI.
* Secure the application.
* Additional generation targets.
* Build and deploy.
 
These steps are described in the sections below.

### Set up environment

You'll need to download Eclipse Modeling package and install M2E, Tycho and Nasdanika Application Workspace Wizard. 
You may also install Nasdanika Story Editor, Nasdanika Ecore code generation editor and Web UI generation target so you don't have to do it later.

These steps are explained in [Install prerequisites](https://server-side-java-development-for-innovators.books.nasdanika.org/chapter-0-setup/install-prerequisites.html) chapter. 

Nasdanika plugins can be installed from ``http://www.nasdanika.org/repository`` P2 repository. 
 
### Generate application workspace

This step is explained in the [Nasdanika Application Workspace Wizard Documentation](https://github.com/Nasdanika/workspace-wizard/blob/master/org.nasdanika.workspace.wizard/doc/wizard.md) 
and [Generate Application Projects](https://server-side-java-development-for-innovators.books.nasdanika.org/chapter-0-setup/generate-application-projects.html) chapter. 

### Create the application domain model 

You can create the application domain model using several editors provided by [Ecore Tools](https://www.eclipse.org/ecoretools/) - a diagram editor and two types of tree editors, depending on 
your choice. For example you can start with the diagram editor to visually capture relationships between domain classes and then, after capturing "the big picture", switch to tree editors. 

You may watch this, slightly dated, video - [Create and document an ECore/CDO Model](https://www.youtube.com/watch?v=qfvr6HWo_Ok).

#### Add render annotations

The way the Web UI is rendered can be customized in several ways, one of them being adding render annotations to the model. 
On the one hand it mixes the domain and the UI concerns, but on the other it allows to keep all things in one place - the model. 
This approach might be handy if the model developer is also responsible for the model UI so they have an idea how a particular model element shall appear in the UI.

The up-to date list of supported render annotations can be found in [RenderAnnotation](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.web/apidocs/org/nasdanika/cdo/web/routes/app/Renderer.RenderAnnotation.html) enum. Check the [source code](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.web/apidocs/src-html/org/nasdanika/cdo/web/routes/app/RenderAnnotation.html) for literals to use in the model annotations.

Below is a list of render annotations with short descriptions grouped by the model element type:

* EModelElement
    * ``constraint`` - defines validation constraints using XPath.
    * ``documentation`` - can be used to define model element documentation if it is not defined in the GenModel annotation.
    * ``icon`` - defines model element icon. If icon annotation contains ``/`` it is treated as URL, otherwise it is treated as css class, e.g. Bootstrap's ``glyphicon glyphicon-close``. 
    * ``model-element-label`` - used to customize a model element label.
    * ``sort`` - XPath expression to use for sorting of items in tables and lists.
* ENamedElement
    * ``category`` - element category. Categories are displayed as panels in the view and field sets in edit forms.    
* ETypedElement (e.g. EStructuralFeature, EParameter, EOperation)
    * ``choices`` - a YAML map of values to labels or a list if values and labels are the same.
    * ``choices-selector`` - [JXPath](https://commons.apache.org/proper/commons-jxpath/) selector of choices to assign to the reference or EParameter which type is a subtype of EObject.
    * ``control`` - defines edit form control type - ``input``, ``select``, or ``textarea``.
    * ``content-type`` - set to ``text/html`` on attribute rendered in ``textarea`` to wrap the area into [TinyMCE](https://www.tinymce.com) editor.
    * ``control-configuration`` - a YAML map of control attribute names to values.
    * ``format`` - to use for rendering and parsing number and date values.
    * ``input-type`` - input type if control is set to ``input``.
    * ``type-column`` - indicates that the table listing reference elements shall display elements type in a type column.
    * ``typed-element-location`` - defines typed element location - view, left panel, item container (tabs, pills, accordion), or inline (work in progress).
* EClass
    * ``feature-items-container`` - YAML annotation which defines feature items container and its configuration.
    * ``horizontal-form`` - set to ``false`` to change the default rendering.
    * ``label`` - a pattern which is interpolated with values of object features to generate object label. E.g. ``{{name}} ({{code}})``.
    * ``no-validate`` - disables HTML5 validation in forms.
    * ``view-item`` - if ``true`` then the class view is rendered in the item container (accordion, tabs, or pills) along with references.    
* EStructuralFeature (EAttribute or EReference)
    * ``disabled`` - defines whether an editable feature control shall be disabled.
    * ``editable`` - defines editability of a visible feature.
    * ``deletable`` - defines deletability of feature value/elements.
    * ``form-input-group`` - overrides the default decision of rendering control in a FormGroup or FormInputGroup.
    * ``placeholder`` - XPath expression evaluating to the placeholder value for features. Placeholder value is an implicit application-specific value, different from the default value.
    * ``visible`` - defines visibility of a feature in the object view.
* EReference
    * ``choice-tree`` - allows to display choices in a containment tree. 
    * ``element-types`` - specifies EClass'es of elements which can be instantiated and set/added to the reference.
    * ``view`` - Set this annotation to ``list`` on to have elements rendered in a list instead of a table.
    * ``view-features`` - list of features to show in a reference item table.
* EOperation
    * ``web-operation`` - defines how the operation shall be exposed through the Web 
      UI.
* EParameter
    * ``bind`` - binds value of web operation parameter. 


Consult JavaDoc and source code for details.

The default render annotations source is ``org.nasdanika.cdo.web.render``. It can be customized by setting 
``org.nasdanika.cdo.web.render:annotation-source`` system property or overriding ``Renderer.getRenderAnnotationSource()``. 
One possibility which this customization opens is having multiple sets of render annotations and switching between them from 
deployment to deployment or even at runtime based on some criterion. 

You may also override ``String getRenderAnnotation(C context, EModelElement modelElement, String key)`` method to load annotations from other sources, e.g. from
a database.

#### Constraint example

The below constraint can be defined on user name attribute:

```
condition: count(../users[name=$this/name]) = 1
errorMessage: Duplicate user
errorMessageKey: duplicateUser
```

### Generate model code, edit support, and editor

Edit and editor support are needed to create the initial model for your application. If you are planning building the application model from scratch in the web UI or programmatically then you 
don't need to generate edit/editor.

#### Customize editor, e.g. add ``Set password`` action

You may consider adding the following two modifications to the editor:

* Add master-detail view as described [here](https://github.com/Nasdanika/presentation).
* Add "Set Password" action for model elements which extend [LoginPasswordHashUser](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.security/apidocs/org/nasdanika/cdo/security/LoginPasswordHashUser.html). This [gist](https://gist.github.com/pvlasov/ec2dd1bfa9f8d625c28d59caa5627b78) explains how to add "Set Password" action.

### Create the initial application model

The session initalizer generated by the wizard contains commented out code which loads initial model(s) from file(s) on first start.
To initialize the repository you need to:

* Use the editor to create the initial model.
* Set ``initial-content`` property of the session initializer OSGi component. Property value can contain tokens which are expanded using system properties, e.g. ``<property name="initial-content" type="String" value="${my-initial-model}"/>``. ``my-initial-model`` system property shall be set to the location of the initial model file.
* Make adjustments in the session initializer code if required. 

### Create Web UI generator model and generate code

The simplest way to get going is to register a route which would serve all classes from your application EPackage using default render/route implementations and model annotations. To do so manually register a route for your EPackage in the app project ``plugin.xml``:

```xml
<extension point="org.nasdanika.web.route">
   ... other routes ...
   <eobject-route
         class="org.nasdanika.cdo.web.routes.app.Route"
         method="*"
         path="/"
         target-namespace-uri="...your EPackage NS URI here...">
   </eobject-route>
```   

This approach may work perfectly fine in simple cases. However, if you want to localize your application or provide customizations not supported by annotations, you need to register class-specific renderers and/or routes. It can be done manually as well
 - see the ``Guest renderer`` and ``Guest route`` sections below. 
 
However, if your application model contains more than just a couple of classes, it is easier to generate renderer interfaces, route classes, their registrations, and resource bundles. This is what this section is about.   

First of all you shall install:

* [Nasdanika Ecore Code Generator](https://github.com/Nasdanika/codegen-ecore)
* [Web UI code generation target](https://github.com/Nasdanika/codegen-ecore-web-ui)

As a reminder, you can install them from ``http://www.nasdanika.org/repository``.

After installation read how to create and generate the model in the ``Nasdanika / Code generation`` section in the Eclipse help. This documentation is also available online:

* [Ecore Code Generator](https://github.com/Nasdanika/codegen-ecore/blob/master/org.nasdanika.codegen.ecore.editor/doc/ecore.md)
* [Web UI code generation target](https://github.com/Nasdanika/codegen-ecore-web-ui/blob/master/org.nasdanika.codegen.ecore.web.ui/doc/web-ui-generation-target.md)

### Run the application in Eclipse

See [Run the application in Eclipse](https://server-side-java-development-for-innovators.books.nasdanika.org/chapter-0-setup/run-application-in-eclipse.html) chapter.

### Customize/localize the Web UI

There are three ways to customize the Web UI in addition to annotating the model:

* Resource bundles
* Override renderer methods
* Override route methods

#### Resource bundles

The obvious use of resource bundles is localization. Out-of-the box the framework provides some localized messages for Russian and Spanish (thanks to Google Translate). 
You can use resource bundles to customize the UI if you did not annotate the model and/or to override model-level annotations. Resource property name format is ``<model element type>.<model element name>.<annotation>``, e.g. 

* ``class.Account.label``
* ``reference.transactions.icon``

You can also use resource bundles for contextual customization. For example, let's say you have have class ``Account`` with containment reference to class ``Transaction`` with attribute ``amount``.
 
To define an icon for ``amount`` attribute you can annotate the attribute in the model or add ``attribute.amount.icon=...`` property to  the ``Transaction.properties`` resource. If you want to have a different icon when transactions are displayed in the account view you can set the following property in ``Account.properties`` - ``reference.transactions.attribute.amount.icon``.   

##### Resource references 

Values of some resource properties can be rather large, e.g. localizations of model elements documentation. Such values can be put to their own files and be referenced by adding ``@`` at the end of the property. For example, ``attribute.amount.documentation@=<relative or absolute url of documentation resource>``. 
This technique can also be used for pulling dynamic values, e.g. ``attribute.currency.choices@=http://...`` will pull a list of currencies from an external URL.

#### Renderer methods

Renderer has quite a few methods, which might be scary at first. The reason of having so many methods is to keep them relatively
short and make it easier to override specific parts of functionality. 
A few long methods deal with different permutations of rendering metadata and if you are to override them for a specific model element, the overridden method would typically be much shorter.

The default implementations also serve as reference implementations - you are encouraged to review them, copy the necessary code fragments to your implementation and customize them as needed.
 
The snippet below shows customization for a specific feature and falling back to the default behavior for other typed elements. The code below resolves object from a String attribute.

```java
	@Override
	default Object renderTypedElementValue(
			CDOTransactionHttpServletRequestContext<LoginPasswordCredentials> context,
			ETypedElement typedElement, 
			Object value) throws Exception {
		
		Renderer<CDOTransactionHttpServletRequestContext<LoginPasswordCredentials>, EObject> customerRenderer = getRenderer(MyPackage.Literals.CUSTOMER);
		if (typedElement instanceof EStructuralFeature 
				&& typedElement == MyPackage.Literals.MY_CLASS__CUSTOMER_SSN 
				&& value instanceof String && ((String) value).trim().length() > 0) {
			Customer customer = resolveCustomerBySSN(context, (String) value);
			if (customer != null) {
				return customerRenderer.renderLink(context, myObj, true);
			}
		}
		return Renderer.super.renderTypedElementValue(context, typedElement, value);
	}
```  

This section groups these methods by their purpose and provides quick overview of what each method does. As usual, JavaDoc provides more details, and the source code is the final authority.

##### Method call graphs

The following two graphs may help to grasp the "big picture" of interdependencies of rendering and routing methods:

* [Highlighting](http://www.nasdanika.org/rendering-2.html) - Route methods are red and render methods are green.
    * Use browser find in page (Ctrl-F) to highlight methods of interest on the graph.
    * Dragable nodes.
    * Zoom (mouse wheel) and pan. 
    * Double-click to center node.
    * Hover to highlight 1st-order neighborhood and show a tooltip with method name. Click to fade surroundings.  
* [Layered](http://www.nasdanika.org/rendering.html) - a slightly different graph without highlighting, but with layering. Route methods are blue and render methods are green. 

The graphs do not contain all the Route/Renderer methods - some foundational methods, which are called by a large number of other methods (e.g. ``getRenderAnnotation()``) were excluded from the graph for clarity.

##### General purpose methods

* ``getHTMLFactory(C)`` - returns [HTMLFactory](http://www.nasdanika.org/products/html/apidocs/org.nasdanika.html/apidocs/org/nasdanika/html/HTMLFactory.html) for building Web UI.
* ``getObjectURI(C, T)`` - returns object URI to construct links.

##### Resource (strings) and annotations

* ``chain(ResourceProvider<C>)`` - Returns an instance of renderer chained with the masterResourceProvider.
* ``getLocale(C)`` - Returns locale. The default implementation returns the locale of the HTTP request. You may override it, e.g. to use locale from the user profile. 
* ``getMasterResourceProvider(C)`` - If this method returns non-null value, then the master resource provider is used first to retrieve resources and the renderer's own logic is used only if the provider doesn't contain requested resource. 
* ``getRenderAnnotation(C, EModelElement, RenderAnnotation)`` - Returns render annotation.
* ``getRenderAnnotation(C, EModelElement, String)`` - Returns render annotation. 
* ``getRenderAnnotationSource(C)`` - Returns render annotation source, ``org.nasdanika.cdo.web.render`` by default.
* ``getRenderer(EClass)`` - Returns a renderer instance for a class. The default implementation returns renderer from the renderer registry which is populated by extensions of ``org.nasdanika.cdo.web.renderer`` extension point.
* ``getRenderer(M)`` - Returns a renderer for an object.
* ``getResource(C, ENamedElement, String)`` - Returns named element resource.
* ``getResource(C, String)`` - Returns resource.
* ``getResourceBundleClasses(C)`` - Returns a list of classes to use to look for resources. 
* ``getResourceString(C, ENamedElement, String, boolean)`` - Returns resource string for a named element.
* ``getResourceString(C, String)`` - Returns resource string without interpolation.
* ``getResourceString(C, String, boolean)`` - Returns resource string optionally interpolating ``{{<token name>}}`` tokens with values of other resource strings.
* ``getYamlRenderAnnotation(C, EModelElement, RenderAnnotation)`` - Returns render annotations parsed as [YAML](https://en.wikipedia.org/wiki/YAML) by [SnakeYAML](https://bitbucket.org/asomov/snakeyaml). 
* ``getYamlRenderAnnotation(C, EModelElement, String)`` - Returns render annotations parsed as YAML.

##### Documentation

* ``createPegDownLinkRenderer(C)`` - Creates [Pegdown](https://github.com/weavejester/pegdown) [LinkRenderer](http://static.javadoc.io/org.pegdown/pegdown/1.6.0/org/pegdown/LinkRenderer.html) which opens links in a new window/tab.  
* ``firstHtmlSentence(C, String)`` - Extracts the first sentence from HTML text as plain text.
* ``firstSentence(C, String)`` - Extracts the first sentence from plain text.
* ``getEClassifierDocRef(C, EClassifier)`` - Returns documentation link for EClassifier. Returns null by default. Override as needed. 
* ``getMaxFirstSentenceLength()`` - Returns maximum length of the fist documentation sentence for showing as a tooltip. Defaults to ``250``.  
* ``getMinFirstSentenceLength()`` - Returns minimum length of the fist documentation sentence for showing as a tooltip. Defaults to ``20``.  
* ``markdownToHtml(C, String)`` - Converts [Markdown](http://daringfireball.net/projects/markdown/) to HTML. Used to render model documentation which is expected to be in markdown.
* ``renderDocumentation(C, EModelElement)`` - Renders model element documentation. 
* ``renderDocumentationButton(C, EModelElement, Modal)`` - Renders documentation button for EOperation buttons.
* ``renderDocumentationIcon(C, EModelElement, Modal, boolean)`` - Renders model element documentation icon with a tooltip. Click on the help icon opens either a documentation dialog or a model element documentation page.
* ``renderDocumentationModal(C, EModelElement)`` - Renders model element documentation [Modal Dialog](http://getbootstrap.com/javascript/#modals)
* ``renderEditableFeaturesDocModals(C, T)`` - Renders documentation modal dialogs for editable features.
* ``renderFirstDocumentationSentence(C, EModelElement)`` - Renders the first documentation sentence. 
* ``renderHelpIcon(C)`` - Renders help icon.
* ``renderModelElementFormGroupHelpText(C, T, EModelElement, Modal)`` - Renders help text as the first documentation sentence with a help icon.
* ``renderModelElementsDocModals(C, T, Collection<EStructuralFeature>)`` - Renders documentation modal dialogs for a collection of model elements.
* ``renderVisibleFeaturesDocModals(C, T)`` - Renders documentation modal dialogs for visible features.

##### Viewing

This section lists methods used to render object view. Features in the object view can be displayed in several locations:

* View - attributes and single-references by default.
* Left panel - many references.
* Item container - tabs, pills, or accordion.
* Inline - contained object view is merged with the container view.

"Many" features can be displayed as tables or as lists.

* ``getNamedElementCategory(C, NE, Collection<NE>)`` - returns category for grouping named elements into panels in views and fieldsets in edit forms.
* ``getAutoCategory(C, NE, Collection<NE>)`` - returns auto-category for a named element, which is inferred as a common prefix for two or more elements. 
* ``getTypedElementLocation(C, ETypedElement)`` - returns location where the element value shall be rendered - view, left panel, item container (tabs, pills or accordion), or inline.
* ``getTypedElementSortKey(C, T, ETypedElement, Object)`` - returns an object for sorting values or null if values shall not be sorted. 
* ``getIcon(C, T)`` - returns icon "location" for a given object. If the location contains ``/`` it is treated as icon URL, otherwise it is treated as icon class, e.g. ``fa fa-user``.
* ``getModelElementIcon(C, EModelElement)`` - returns icon location for a model element, e.g. attribute or reference.
* ``getPlaceholder(C, T, EStructuralFeature)`` - returns feature value "placeholder".
* ``getReferenceElementTypes(C, T, EReference)`` - returns a list or EClass'es which can be instantiated and instances can be added to a given reference.
* ``getReferenceRenderer(EReference, M)`` - Returns renderer for a feature. The renderer is chained with this renderer as its master resource provider with ``<feature class>.<feature name>.`` prefix.
* ``getVisibleFeatures(C, T, FeaturePredicate)`` - returns a list of features to include into the the object view.
* ``isDeletable(C, T, EModelElement)`` - returns true if model element value can be deleted and as such a delete button shall be rendered.
* ``isEditable(C, T, EModelElement)`` - returns true if model element value can be edited and as such an edit button shall be rendered.
* ``isObjectPathRoot(C, T, EObject)`` - checks if a given object is the object path root, i.e. it shall be the first entry in the breadcrumbs. 
* ``isSortTypedElementValues(C, T, ETypedElement)`` - returns true if values shall be sorted.
* ``isViewItem(C, T)`` - if this method returns true, then object view is rendered in the item container.
* ``isVisible(C, T, EModelElement)`` - returns true if model element value shall be visible.
* ``nameToLabel(String)`` - Derives label (display name) from a name. The default implementation splits name by camel case, capitalizes the first segment, uncapitalizes the rest and joins them with a space. E.g. ``customerFirstName`` -> ``Customer first name``.
* ``renderAddIcon(C)`` - renders an icon for the ``Add`` button.
* ``renderCancelButton(C, T)`` - renders ``Cancel`` button.
* ``renderCancelIcon(C)`` - renders an icon for ``Cancel`` button.
* ``renderClearIcon(C)`` - renders an icon for ``Clear`` button.
* ``renderCreateIcon(C)`` - renders an icon for ``Create`` button.
* ``renderDeleteButton(C, T)`` - renders ``Delete`` button.
* ``renderDeleteIcon(C)`` - renders an icon for ``Delete`` button.
* ``renderDetailsIcon(C)`` - renders an icon for navigating to object view.
* ``renderEditButton(C, T)`` - renders ``Edit`` button.
* ``renderEditIcon(C)`` - renders an icon for ``Edit`` button.
* ``renderEOperationButton(C, T, EOperation, String, Map<String, Object>)`` - render a button for invoking EOperation.
* ``renderFalse(C)`` - renders ``false``. The default implementation returns an empty string.
* ``renderFeatureAddButton(C, T, EStructuralFeature)`` - Renders feature ``Add`` button.
* ``renderFeatureItemsContainer(C, T, Map<EStructuralFeature, Modal>)`` - renders feature items container - [tabs](http://getbootstrap.com/javascript/#tabs) (default), pills, or [accordion](http://getbootstrap.com/javascript/#collapse-example-accordion).  
* ``renderFeaturePath(C, T, EStructuralFeature, String, Breadcrumbs)`` - renders feature path which includes the object path, feature category (if any) and feature name. 
* ``renderFeatureValueEditButton(C, T, EStructuralFeature, int, Object)`` - renders feature value ``Edit`` button.
* ``renderFeatureViewButtons(C, T, EStructuralFeature)`` - renders buttons for feature view, e.g. "Add" button and EOperation buttons. 
* ``renderIcon(C, T)`` - renders object icon.
* ``renderIconAndLabel(C, T)`` - renders object icon and label.
* ``renderLabel(C, T)`` - renders object label.
* ``renderLeftPanel(C, T)`` - renders the left panel. This implementation renders link groups for visible features with location set to ``leftPanel``.
* ``renderLink(C, T, boolean)`` - renders object link.
* ``renderModelElementIcon(C, EModelElement)`` - renders model element icon.
* ``renderNamedElementCategoryIcon(C, NE, Collection<NE>)`` - renders category icon. 
* ``renderNamedElementCategoryIconAndLabel(C, NE, Collection<NE>)`` - renders category icon and label. 
* ``renderNamedElementCategoryLabel(C, NE, Collection<NE>)`` - renders category label. 
* ``renderNamedElementIconAndLabel(C, ENamedElement)`` - renders model element icon and label.
* ``renderNamedElementIconAndLabel(C, ENamedElement, Collection<EStructuralFeature>)`` - renders named element icon and label. 
* ``renderNamedElementLabel(C, ENamedElement)`` - renders model element label.
* ``renderNamedElementLabel(C, ENamedElement, Collection<EStructuralFeature>)`` - renders named element label. 
* ``renderObjectHeader(C, T, Modal)`` - renders object header. The default implementation renders object class label, object label, and a documentation icon.
* ``renderObjectPath(C, T, Object)`` - renders object path to a fragment with given separator.
* ``renderObjectPath(C, T, String, Breadcrumbs)`` - renders object path to breadcrumbs.
* ``renderReferencesTree(C, T, int, Function<Object, Object>, boolean)`` - Renders an object tree of tree references of the argument object. 
* ``renderTreeItem(C, T, int, Function<Object, Object>, boolean)`` - Renders a tree item for the object with the tree features under.
* ``renderTrue(C)`` - renders ``true``. The default implementation renders a green check mark (Bootstrap's ``glyphicon glyphicon-ok``).
* ``renderTypedElementValue(C, ETypedElement, Object)`` - renders display value of a typed element.
* ``renderTypedElementValueButtons(C, T, ETypedElement, int, Object)`` - renders buttons associated with typed element value, e.g. view, edit, delete, and EOperation buttons. 
* ``renderTypedElementValueDeleteButton(C, T, ETypedElement, int, Object)`` - renders value ``Delete`` button. 
* ``renderTypedElementValueViewButton(C, T, ETypedElement, int, EObject)`` - renders value ``View`` button. 
* ``renderTypedElementView(C, T, ETypedElement, Object, boolean, Predicate<Object>, Comparator<Object>)`` - renders typed element view.
* ``renderView(C, T, Map<EStructuralFeature, Modal>)`` - renders object view.
* ``renderViewButtons(C, T)`` - renders object view buttons bar.
* ``renderViewFeatures(C, T, Map<EStructuralFeature, Modal>)`` - renders object view features.
* ``renderViewItemLabel(C, T)`` - Renders label for the view item, if view is rendered in an item container.
* ``wireDeleteButton(C, T, Button)`` - wires ``Delete`` button.
* ``wireEditButton(C, T, Button)`` - wires ``Edit`` button. 
* ``wireFeatureAddButton(C, T, EStructuralFeature, Button)`` - wires feature value ``Add`` button. 
* ``wireTypedElementValueDeleteButton(C, T, ETypedElement, int, Object, Button)`` - wires typed element value ``Delete`` button. 
* ``wireFeatureValueEditButton(C, T, EStructuralFeature, int, Object, Button)`` - wires feature value ``Edit`` button. 
* ``wireTypedElementValueViewButton(C, T, ETypedElement, int, EObject, Button)`` - wires typed element value ``View`` button.

##### Editing

This section lists methods used to render object edit form. Selection of (multiple) choices for a value can be done with:

* select - many choices for a single value element.
* radio - many choices for a single value element.
* radio tree - hierachical representation of many choices for a single value element.
* checkbox list - many choices for a many value element.
* checkbox tree - hierarchical representation of many choices for a many value element.


* ``compareEditableFeatures(C, T, Consumer<Diagnostic>)`` - Compares feature values from the object with the original values stored in hidden fields. Creates error diagnostics for concurrently modified features.
* ``getEditableFeatures(C, T)`` - returns a list of structural features to include into the object edit form.
* ``getTypedElementChoices(C, T, ETypedElement)`` - invoked for select, radio and checkbox on non-boolean types.
* ``getEObjectTypedElementChoices(C, T, ETypedElement)`` - returns choices for a typed element with a type which is subtype of EObject, e.g. EReference or EParameter.
* ``getFormControlValue(C, T, ETypedElement, Object)`` - Returns typed element value to be used in form controls like input, select, etc.
* ``isRequired(C, T, ETypedElement)`` - return ``true`` if form control for the typed element shall have ``required`` attribute. 
* ``parseTypedElementValue(C, EStructuralFeature, String)`` -  
* ``renderEditableFeaturesFormGroups(C, T, FieldContainer<?>, Map<EStructuralFeature, Modal>, Map<EStructuralFeature, List<ValidationResult>>, boolean)`` - Renders form groups for editable features.
* ``renderEditForm(C, T, List<ValidationResult>, Map<ENamedElement, List<ValidationResult>>, boolean)`` - Renders object edit form with feature documentation modals and error messages if any.
* ``renderFeatureEditForm(C, T, EStructuralFeature, List<ValidationResult>, boolean)`` - Renders an edit form for a single feature, e.g. a reference with checkboxes for selecting multiple values and radios or select for selecting a single value.  
* ``renderInputForm(C, T, Map<EParameter, Object>, List<ValidationResult>, Map<ENamedElement, List<ValidationResult>>, boolean)`` - Renders input form for EOperation.
* ``renderTypedElementControl(C, T, ETypedElement, Object, FieldContainer<?>, Modal, List<ValidationResult>, boolean)`` - Renders control for ETypedElement, e.g. input, select, or text area.
* ``renderTypedElementFormGroup(C, T, ETypedElement, Object, FieldContainer<?>, Modal, List<ValidationResult>, boolean)`` - Renders form group if renderTypedElementControl() returns non-null value.
* ``renderSaveButton(C, T)`` - renders ``Save`` button.
* ``renderSaveIcon(C)`` - renders ``Save`` icon.
* ``renderTinymceInitScript(C, TextArea)`` - renders [TinyMCE](https://www.tinymce.com/) initalization script for textareas with content type ``text/html``.
* ``setEditableFeatures(C, T, Consumer<Diagnostic>)`` - Reads feature values for editable features from the request, parses them and sets feature values. 
* ``setFeatureValue(C, T, EStructuralFeature)`` - Sets feature value from the context to the object. The default implementation loads feature value(s) from the [HttpServletRequest](http://docs.oracle.com/javaee/7/api/javax/servlet/http/HttpServletRequest.html) parameters. 
* ``validate(C, T)`` - Validates object using Ecore validation and ``validate(C,T,EModelElement,DiagnosticChain)`` method.
* ``validate(C, T, EModelElement, DiagnosticChain)`` - Validates model element using ``constraint`` annotations.
* ``validate(C, T, EOperation, Map<String, Object>)`` - Validates EOperation input using ``constraint`` annotations and parameter bounds.
* ``wireCancelButton(C, T, Button)`` - wires ``Cancel`` button. 
* ``wireSaveButton(C, T, Button)`` - wires ``Save`` button.


#### Route methods

Route is responsible for handling HTTP requests and rendering object UI delegating to methods inherited from Renderer.

##### Page rendering

* ``createRenderPageEnvironment(C)`` - creates interpolation environment for page rendering.
* ``renderBody(C, Object, Object, Object, Object)`` - renders page body. 
* ``renderFooter(C, T)`` - renders page footer.
* ``renderHead(C, T)`` - renders custom part of the ``<head>`` element.
* ``renderHeader(C, T)`` - renders page header.
* ``renderPage(C, T, String, Object)`` - renders page.
* ``getPageTemplate(C)`` - returns page template resource.
* ``getTheme(C, T)`` - returns [Bootstrap theme](http://www.nasdanika.org/products/html/apidocs/org.nasdanika.html/apidocs/org/nasdanika/html/Theme.html).
* ``setLeftPanelAndContentColSizes(C, UIElement<?>, UIElement<?>)`` - sets [bootstrap grid column sizes](http://www.nasdanika.org/products/html/apidocs/org.nasdanika.html/apidocs/org/nasdanika/html/Bootstrap.Grid.html#col-org.nasdanika.html.Bootstrap.DeviceSize-int-) for the left panel and content.  

##### Viewing

* ``getIndexHtml(C, T)`` - route method rendering breadcrumbs, object header, object view, object action buttons (e.g. edit and delete), and item container features.
* ``viewFeature(C, String, T)`` - route method for a feature view, e.g. a table of reference elements.

##### Creation

* ``createContainementFeatureElement(C, T, String, String, String, String, String)`` - route method for creation of containment feature elements. Renders create form on GET, validates input on POST and either creates a new object or re-renders the form with error messages. 

##### Editing
 
* ``edit(C, T, String, String, String)`` - route method which renders and processes edit form.
* ``editFeature(C, String, T)`` - route method which renders and processes feature target edit form.
* ``editFeatureElement(C, String, String, T)`` - route method which renders and processes many feature element edit form.
* ``selectReferenceFeatureElement(C, T, String, String, String)`` - route method which renders a page for adding a reference to a non-containment feature. 
 
##### Deleting
 
* ``deleteFeature(C, T, String, String)`` - Clears single-value feature and redirects to the referrer.
* ``deleteFeatureElement(C, T, String, String, String)`` - Removes an element from a multi-value feature and redirects to the referrer.
* ``getDeleteHtml(C, T, String)`` - Deletes this element and redirects either to the referrer or to the parent's index.html if the referrer is one of 'this' object pages.

##### Security

* ``processLogin(C, String, String, String)`` - Processes login. If isPost is true, checks that login and password are not blank and authenticates the user. If authentication is successful, redirects to the returnURL or to the authenticated principal home page.
* ``getLogoutHtml(C, String)`` - route method which invalidates session.

##### Web Operations

EOperations can be annotated to be invocable through the Web UI. EParameters can be annotated to be bound to request and other context values. Before invoking the operation the framework applies a lock to the repository as specified in the annotation. 
If the operation throws an exception, the framework marks rolls back any changes performed by the operation.  

To make an EOperation invocable through the Web UI add ``web-operation`` details entry to the render annotation. The value of the entry shall be a YAML map with the following keys (all optional):

* ``action`` - Security action. Defaults to {@link AuthorizationProvider.StandardAction}.execute.
* ``confirm`` - If set, then click on the button shows this confirmation message before executing the operation. May contain {{object-label}} token. For feature-value operations the message may contain ``{{element-label}}`` token.
* ``consumes`` - Single value or a list or content types which this web operation can consume.
* ``feature`` - Feature name to associate this web operation with. If this value is present, web operation invocation button will be displayed in the corresponding feature view instead of the object view. Feature name is passed to the eOperation as ``feature`` query parameter.
* ``feature-value`` - Feature name to associate this web operation with. If this value is present, web operation invocation button will be displayed in the corresponding feature value element instead of the object view. Feature name is passed to the eOperation as ``feature`` query parameter. Element CDO ID is passed to the eOperation as ``element`` query parameter and its position as ``position`` parameter.
* ``lock`` - Lock to apply on the repository in order to execute the operation 
     * ``path`` - [JXPath](https://commons.apache.org/proper/commons-jxpath/) path of the object to apply the lock to. If not set, the lock is applied to the target object.
     * ``type`` - Lock type, one of ``none``, ``read``, ``write``, or ``imply-from-http-method`` (default). ``imply-from-http-method`` implies ``write`` for ``DELETE``, ``PATCH``, ``POST``, and ``PUT`` and ``read`` otherwise.
     * ``timeout`` - Lock timeout in milliseconds. Defaults to one minute.
* ``method`` - HTTP method which matches the operation. If not set then it defaults to ``GET`` for EOperation invocation (so it can be invoked by clicking on a button). If EOperation has unbound parameters, then ``GET`` method renders a form with those parameters and ``POST`` by the form invokes the operation after input validation against operation and parameter ``constraint``'s. If method is explicitly set, then the operation is considered an "API" operation as opposed to "UI" operation and no buttons are automatically rendered for it.
* ``path`` - Web operation path. It may contain path parameters in the form ``{<parameter name>}``. Defaults to the EOperation name.
* ``produces`` - Content type produced by the operation.
* ``style`` - {@link org.nasdanika.html.Bootstrap.Style} enum value for a button or a left panel item depending on location. Defaults to ``INFO`` for buttons and ``DEFAULT`` for left panel items.

If you have a web operation with all defaults put a comment or a document start (``---``) or both in the details.


By default EOperation parameters have ``form`` binding with the name equal to the parameter name. To customize binding add ``bind`` details entry to the render annotation of EParameter. The value of the entry shall be a single string or a single-entry YAML map as described below:  

* ``body`` - Binds the parameter to request body.
* ``cookie`` - Binds the parameter to a cookie with the same name as the parameter name.
* ``cookie: name`` - Binds the parameter to the named cookie.
* ``expression: expression`` - JXPath expression (which can also be a constant) to evaluate.   
* ``extension`` - Binds the parameter to registered extension(s). This key's value shall be a map with the following elements:
     * ``point`` - Extension point ID.
     * ``configuration-element`` - Configuration element name.
     * ``class-attribute`` - Attribute containing the class name. Defaults to ``class``.
* ``form`` (default) - Binds the parameter to the query parameter with the same name as {@link EParameter} if request method is ``POST``.
* ``form: name`` - Binds the parameter to the named query parameter if request method is ``POST``.
* ``header`` - Binds the parameter to a header with the same name as the parameter name.
* ``header: name`` - Binds the parameter to the named header.
* ``null`` - Binds parameter to ``null``.
* ``part`` - Binds the parameter to a part with the same name as the parameter name. Parameter type shall be Part, {@link InputStream}, byte[], {@link Reader}, or String.
* ``part: name`` - Binds the parameter to the named part.
* ``part-file-name: name`` - Binds the parameter to the named part. Parameter type shall be String. This binding would typically be used with ``part`` binding to avoid introducing dependency on the servlet API in the model.
* ``path`` - Binds the parameter to a path parameter with the same name as the parameter name.
* ``path: name`` - Binds the parameter to the named path parameter.
* ``query`` - Binds the parameter to the query parameter with the same name as {@link EParameter}.
* ``query: name`` - Binds the parameter to the named query parameter.
* ``service`` - Binds the parameter to an OSGi service with the same type as the parameter type.
* ``service: filter`` - Binds the parameter to an OSGi service applying the specified filter.
* ``value: value`` - Binds the parameter to a constant value.

##### Developer routes 

* ``getApiDocPath()`` - returns ``api.html`` so the dispatching route renders API documentation at ``<object path>/api.html``.
* ``xPathEvaluator(C, T, String, String)`` - Renders and processes a form for evaluating XPath expressions. This route method is intended to be used by application/model developers to build/troubleshoot XPath expressions, e.g. constraints. Replace ``/index.html`` with ``XPathEvaluator.html`` for an object to open the evaluator page.

#### Client-side logic

The framework uses the server-side logic and HTML5/Boostrap features on the client side. There is a number of situations where it is desirable to have client-side logic. For example:

* Forms with master-detail relationships between inputs.
* Wizard-like forms where different parts of the form (e.g. fieldsets) appear sequentially.

There is a number of ways to introduce client-side logic. One of them is to override a corresponding method, e.g. ``createContainmentFeatureElement()``, but it will result in a good deal of coding.
This section describes how to introduce client-side logic with minimal amount of coding. The examples below use [KnockoutJS](http://knockoutjs.com/).

##### Bind controls

You can add bindings to form controls using ``control-configuration`` render annotation or programmatically as shown below:

```java
/**
 * Счёт и актив привязаны к KnockoutJS модели чтобы список астивов содержал активы поддерживаемые счётом.
 */
@Override
default <TE extends ETypedElement> UIElement<?> renderTypedElementControl(
        CDOTransactionHttpServletRequestContext<LoginPasswordCredentials> context, T obj, TE typedElement,
        Collection<TE> typedElements, Object value, FieldContainer<?> fieldContainer, Modal docModal,
        List<ValidationResult> validationResults, boolean helpTooltip) throws Exception {

    UIElement<?> control = ЭлементМоделиRenderer.super.renderTypedElementControl(context, obj, typedElement,
            typedElements, value, fieldContainer, docModal, validationResults, helpTooltip);

    if (LedgerPackage.Literals.ПРОВОДКА__СЧЁТ == typedElement) {
        ((Select) control).knockout().bind("value", "счёт", "\'" + value + "\'");
    } else if (LedgerPackage.Literals.ПРОВОДКА__АКТИВ == typedElement) {
        ((Select) control)
            .knockout().bind("options", "активыСчёта", null)
            .knockout().bind("optionsText", "'наименование'", null)
            .knockout().bind("optionsValue", "'cdoID'", null);
    }

    return control;
}
```

##### Write JavaScript module

Example: 

```javascript
function СчётАктивПроводки() {

    var активыСчетов  = {{активыСчетов}};
    this.счёт = ko.observable({{счёт}});
    
    this.активыСчёта = ko.pureComputed(function() {
        return активыСчетов[this.счёт()];
    }.bind(this));
    
}

ko.applyBindings(new СчётАктивПроводки());
```

##### Inject the script into the page

One of possible ways to inject the module script into the page is to override ``renderPage()`` method as in [ОперацияRoute](https://github.com/Nasdanika/ledger/blob/master/org.nasdanika.ledger.app/src/org/nasdanika/ledger/app/routes/ledger/%D0%9E%D0%BF%D0%B5%D1%80%D0%B0%D1%86%D0%B8%D1%8FRoute.java).  
	  
### Secure the application

This section describes how to secure the web application, which includes implementing authentication and authorization.

#### Authentication
##### Set redirection to principal home

In ``plugin.xml`` add the following route:

```xml
<root-route
      class="org.nasdanika.cdo.web.routes.RedirectToPrincipalHomeRoute"
      method="GET"
      path="index.html">
</root-route>
```

And change redirect in the application ``index.html``:
```html
<html>
	<head>
		<title>...</title>
		<META http-equiv="refresh" content="0;URL=/.../router/index.html">
	</head>
	<body>
		Redirecting to the home page.
	</body>
</html>
```

As a result ``index.html`` will redirect to the principal's ``index.html``, which in case of ``Guest`` will display the log-in form.

##### Change default access decision to deny

###### Routing servlet

Open ``plugin.xml`` and set ``default-access-decision`` init parameter to ``deny``. 

Also set ``login-url`` to ``${context-path}/router/index.html``. 

```xml
<servlet
      alias="/router"
      class="org.nasdanika.cdo.web.CDOTransactionRoutingServlet" httpcontextId="...">
   <init-param
         name="json-pretty-print"
         value="true">
   </init-param>
   <init-param
         name="default-access-decision"
         value="deny">
   </init-param>
   <init-param
         name="login-url"
         value="${context-path}/router/index.html">
   </init-param>
   <init-param
         name="ws-session-path"
         value="/session">
   </init-param>
</servlet>
```

##### CDO transaction context provider

Open ``xxx-cdo-transaction-context-provider.xml`` in the application project ``OSGI-INF`` folder and add the following property:

```xml
<property name="default-access-decision" type="String" value="deny"/>
```

Also make sure that your ``<app name>CDOTransactionContextProviderComponent`` class correctly implements ``getSecurityRealm()``. 

##### Implement login form

Create and register ``GuestRenderer`` and ``GuestRoute``.

###### Guest renderer

```java
import org.nasdanika.cdo.security.Guest;
import org.nasdanika.cdo.security.LoginPasswordCredentials;
import org.nasdanika.cdo.web.CDOTransactionHttpServletRequestContext;
import org.nasdanika.cdo.web.routes.app.Renderer;
import org.nasdanika.cdo.web.routes.app.ResourceProvider;

public interface GuestRenderer extends RendererBase<Guest> {

	
	GuestRenderer INSTANCE = new GuestRenderer() {};	
	
	@Override
	default Renderer<CDOTransactionHttpServletRequestContext<LoginPasswordCredentials>, Guest> chain(ResourceProvider<CDOTransactionHttpServletRequestContext<LoginPasswordCredentials>> masterResourceProvider) throws Exception {
		return new GuestRenderer() {
			
			@Override
			public ResourceProvider<CDOTransactionHttpServletRequestContext<LoginPasswordCredentials>> getMasterResourceProvider(CDOTransactionHttpServletRequestContext<LoginPasswordCredentials> context) throws Exception {
				return masterResourceProvider;
			}
			
		};
	}	

}
```

Registration in ``plugin.xml``:
```xml
<extension
      point="org.nasdanika.cdo.web.renderer">
      
... other renderers ...      
   <renderer
         eclass-name="Guest"
         namespace-uri="urn:org.nasdanika.cdo.security"
         renderer="...app.routes.GuestRenderer">
   </renderer>
</extension>
```

###### Guest route

```java
import org.nasdanika.cdo.security.Guest;
import org.nasdanika.cdo.security.LoginPasswordCredentials;
import org.nasdanika.cdo.web.CDOTransactionHttpServletRequestContext;
import org.nasdanika.core.ContextParameter;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Form;
import org.nasdanika.html.Form.Method;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.web.Action;
import org.nasdanika.web.QueryParameter;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.RouteMethod;
import org.nasdanika.web.RouteMethod.Lock.Type;
import org.nasdanika.web.TargetParameter;

public class GuestRoute extends RouteBase<Guest> implements GuestRenderer {

	public GuestRoute() throws Exception {
		super();
	}
	
	@RouteMethod(
			path="index.html", 
			value = { RequestMethod.GET, RequestMethod.POST },
			lock = @RouteMethod.Lock(type = Type.READ, path = ".."), 
			comment="Renders login form on GET, processes it on POST")
	public Object indexHtml(
			@ContextParameter CDOTransactionHttpServletRequestContext<LoginPasswordCredentials> context, 
			@TargetParameter Guest target,
			@QueryParameter("url") String returnURL,
			@QueryParameter("login") String login,
			@QueryParameter("password") String password) throws Exception {
			
		
		Form loginForm = processLogin(context, returnURL, login, password);
		if (loginForm == null) {
			return Action.NOP;
		}
		
		loginForm
			.action("index.html")
			.method(Method.post)
			.bootstrap().grid().col(Bootstrap.DeviceSize.EXTRA_SMALL, 12)
			.bootstrap().grid().col(Bootstrap.DeviceSize.SMALL, 12)
			.bootstrap().grid().col(Bootstrap.DeviceSize.MEDIUM, 9)
			.bootstrap().grid().col(Bootstrap.DeviceSize.LARGE, 7);
		
		HTMLFactory htmlFactory = getHTMLFactory(context);
		Fragment content = htmlFactory.fragment();		
		content.content(content.getFactory().tag(TagName.h3, getResourceString(context, "logIn")));
		content.content(loginForm);
				
		return renderPage(context, target, getResourceString(context, "logIn"), content);				
	}
	
	@Override
	public Object renderLeftPanel(CDOTransactionHttpServletRequestContext<LoginPasswordCredentials> context, Guest obj)	throws Exception {
		return null;
	}

}
```

The code above places the login form to the content. You can may configure and place the login form as required by your application. 
E.g. it can be an inline form in the header or you may put it to the left panel.

Registration in ``plugin.xml``:

```xml
<extension point="org.nasdanika.web.route">
   ... other routes ...
   <eobject-route
         class="...app.routes.GuestRoute"
         method="*"
         path="/"
         target="Guest"
         target-namespace-uri="urn:org.nasdanika.cdo.security">
   </eobject-route>
```   

##### User home

Implement the user route as required by your application.

##### NTLM authentication

This section describes how to set up NTLM authentication by putting the application behind Apache HTTPD (inspired by [Jenkins Reverse Proxy Auth Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Reverse+Proxy+Auth+Plugin). Another option is to use [WAFFLE](https://github.com/Waffle/waffle) or similar products.

###### Apache HTTPD

* Enable proxy, ntlm and rewrite modules, 
* Proxy to your app 
* Set up NTLM/SSPI authentication
* Set up rewrite rule to pass user name in ``X-Forwarded-User`` header.

```
# Required modules
LoadModule proxy_module modules/mod_proxy.so
# Maybe this one is not needed
LoadModule proxy_html_module modules/mod_proxy_html.so 
LoadModule proxy_http_module modules/mod_proxy_http.so
LoadModule rewrite_module modules/mod_rewrite.so

LoadModule auth_ntlm_module modules/mod_authn_ntlm.so

...  

ProxyPass         /myapp  http://localhost:8080/myapp nocanon
ProxyPassReverse  /myapp  http://localhost:8080/myapp
ProxyRequests     Off
AllowEncodedSlashes NoDecode

<Location "/myapp/">
    AllowOverride All
    Options FollowSymLinks
    Order allow,deny
    Allow from all
    
    AuthName "MyOrg"
    AuthType SSPI
    NTLMAuth On
    NTLMAuthoritative On
    NTLMOmitDomain On
    NTLMUsernameCase lower
    NTLMOfferBasic Off

    require valid-user

    RewriteEngine On
    RewriteCond %{LA-U:REMOTE_USER} (.+)
    RewriteRule . - [E=RU:%1]
    RequestHeader add X-Forwarded-User %{RU}e

</Location>
```

###### plugin.xml

Add ``user-name-header`` init parameter to the router servlet:

```xml
<init-param
      name="user-name-header"
      value="X-Forwarded-User">
</init-param>
``` 

#### Authorization

Renderer and Route methods use [Context](http://www.nasdanika.org/server/apidocs/org.nasdanika.core/apidocs/org/nasdanika/core/Context.html).authorizeXXX() methods to customize UI based on the principal permissions. 
E.g. ``Edit`` button would only be rendered if the request principal has ``edit`` permission on the object.

[Security model](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.security/apidocs/index.html) handles authorization is the following way (a simplified description, see [PrincipalAuthorizationHelper](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.security/apidocs/org/nasdanika/cdo/security/PrincipalAuthorizationHelper.html) [source code](https://github.com/Nasdanika/server/blob/master/org.nasdanika.cdo.security/src/org/nasdanika/cdo/security/PrincipalAuthorizationHelper.java) for details):

* If the principal is ``root`` then it has all permissions.
* If the current object is [Protected](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.security/apidocs/org/nasdanika/cdo/security/Protected.html), then its ``authorize()`` method is invoked. By default protected iterates over its permissions and if the permission matches and the access decision is not ``Abstain`` then this decision is used.
* If the current [Principal](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.security/apidocs/org/nasdanika/cdo/security/Principal.html) has a permission associated with the current object then its ``AccessDecisioin`` is used if it is not ``Abstain``.  
* If none of the above is true then authorization on the parent object is checked with the containment feature path as a qualifier. E.g. if ``Customer`` contains ``Account`` in ``accounts`` reference, then check for ``read`` permission on ``Account.amount`` attribute would bubble up as a check for ``read`` permission with ``accounts/amount`` qualifier on the ``Customer`` object. 
* As the last resort the default access decision is used, which should be set to ``deny`` for secured applications.

There are three primary ways to implement authorization in the application:

* Define actions and permissions.
* Override Protected.authorize().
* Override Principal.authorize().

All these approaches can co-exist.

##### Define actions and permissions

* Use the model editor and add Package and Class objects representing classes in your object model on which you would define protected actions.
* If you decide to keep permissions at model objects, have protected objects extend ``Protected``. 
* Define [actions](http://www.nasdanika.org/server/apidocs/org.nasdanika.cdo.security/apidocs/org/nasdanika/cdo/security/Action.html) for classes, designate some actions as grantable and have other fine-grained actions be implied by grantable actions.
* Create Web UI for granting permissions to grantable actions. (Such UI might be implemented as part of Route in future versions).
 
This approach is flexible and declarative, but may not be applicable or require custom actions and permissions in some advanced cases. 

##### Protected

Another way is to override ``Protected.authorize()``. E.g. you may pull authorization information from some external source.  

##### Principal

In a similar fashion you may override ``Principal.authorize()``. 

### Additional generation targets

In the future the following generation targets may be created:

* User stories for application Web UI referencing the domain objects, e.g. "As a <role> I want to create a new Customer object".
* UI Driver and tests for application Web UI referencing the user stories.

### Build and deploy

See the following chapters:

* [Build and launch locally](https://server-side-java-development-for-innovators.books.nasdanika.org/chapter-0-setup/build-and-launch-locally/).
* [Set up an automated build](https://server-side-java-development-for-innovators.books.nasdanika.org/chapter-0-setup/automated-build/).
