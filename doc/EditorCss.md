# Semantic Styling

Semantic text presentation styling within the Fluentmark editor is implemented by 
the application of a CSS stylesheet.

The preference controls are located at

> `Window` -> `Certiv Tools` -> `FluentMark` -> `Stylesheets`

The internally defined stylesheets are listed in the [css/semantic](https://github.com/grosenberg/Fluentmark/tree/master/net.certiv.fluent.dt.ui/css/semantic) 
directory.

Alternately, an externally defined stylesheet can be selected. All such external stylesheets 
must live under a single, accessible directory on the local filesystem.

The `live watch reload` of the external stylesheet directory is experimental and 
should only be enabled when developing and testing external stylesheets.
 

## Defined CSS attributes

|Document Part     |Description    |   Css Element    |
|:-----------------|:--------------|:----------------:|
|Comment           |Comment        |     comment      |
|Page              |Page           |       body       |
|Header            |Header         |        h         |
|Setext            |Header         |        h         |
|Paragraph         |Paragraph      |        p         |
|HRule             |Horizontal Rule|        hr        |
|Bold              |Bold           |        b         |
|Italic            |Italic         |        i         |
|Underline         |Underline      |        u         |
|Span              |Span           |       span       |
|Strike            |Strikethrough  |span.strikethrough|
|CodeSpan          |Code span      |       code       |
|MathSpan          |Math span      |    span.math     |
|Link              |Link           |        a         |
|Cite              |Link cite      |       cite       |
|ListOrdered       |Ordered list   |        ol        |
|ListUnordered     |Unordered list |        ul        |
|ListItem          |List Item      |        li        |
|Table             |Table          |      table       |
|TableRow          |Table Row      |        tr        |
|Quote             |Quote          |        q         |
|Definition        |Definition     |        dl        |
|CodeBlock         |Code Block     |       code       |
|Indented CodeBlock|Indented Block |       code       |
|YamlBlock         |YAML Block     |                  |
|HtmlBlock         |HTML Block     |                  |
|MathBlock         |Math Block     |                  |
|TexBlock          |LaTex Block    |                  |
|DotBlock          |Dot Block      |                  |
|UmlBlock          |UML Block      |                  |

## Styles Engine

The Dsl Editor Framework contains a fully custom CSS style engine that implements substantially 
all of the CSS 2.1 and Selector Level 3 specifications.
