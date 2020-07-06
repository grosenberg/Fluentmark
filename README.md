# FluentMark

A full-featured Eclipse-based Markdown editing environment.

## Features 

+ Choice of Markdown converter
    - [Pandoc](https://pandoc.org) (preferred)
    - Commonmark ([Flexmark](https://github.com/vsch/flexmark-java))
    - [BlackFriday](https://github.com/russross/blackfriday)
+ Real-time preview
    - reactively rendered using [Vue.js](https://vuejs.org/)
    - LaTex/Math presentation using [MathJax](https://www.mathjax.org/)
		- Highlighting using [highlightjs](https://highlightjs.org/)
    - stylesheet controlled presentation
        + multiple built-in stylesheets
        + local custom/user defined stylesheets
+ Export to HTML and PDF
  	- PDF export uses Pandoc with custom/user defined latex page templates
 
+ Diagram rendering
    - Graph diagrams using the [Graphviz DOT](http://www.graphviz.org/) language
    - UML and other diagrams using the [PlantUml](http://www.graphviz.org/) language
+ Spell check with quick-assist correction processor
+ Smart editing behaviors, including intelligent paragraph, list & blank line handling
+ Table editor
+ Text, list and table formatter
+ Outline view with drag-and-drop support

## Screenshots

<figure>
<figcaption>1. Dot Graph</figcaption>
<img src="http://www.certiv.net/updates/net.certiv.fluentmark.site/ScreenShot.png">
</figure>

<figure>
<figcaption>2. Sequence Diagram</figcaption>
<img src="http://www.certiv.net/updates/net.certiv.fluentmark.site/ScreenShot1.png">
</figure>


## Installation & Use

Requires Eclipse 2020-06 & JDK 1.8+.

Install from the Certiv Tools update site: [www.certiv.net/updates](http://www.certiv.net/updates/).

Preferences ---

- `Window`&rarr;`Certiv Tools`&rarr;`FluentMark`

Pandoc converter ---

- Install [Pandoc](https://pandoc.org). The `pandoc` executable can then be selected from the local filesystem 
  on the Pandoc Converter preference page.

PDF export ---

- Both *Pandoc* and a _LaTeX_ processor must be installed. Pandoc recommends [*MikTeX*](https://miktex.org/).

DOT graphics ---

- Install [Graphviz](http://www.graphviz.org/download.php). The `dot` executable can then be selected 
  on the Converter preference page.

UML and other diagrams ---

- The basic PlantUml jar is built-in. Diagrams other than sequence diagrams require DOT graphics. If 
  `Graphviz` is installed in a non-default directory, set the `GRAPHVIZ_DOT` environment variable to 
  the actual installation directory.

BlackFriday converter ---

- Install the customized [blackfriday-tool](https://github.com/grosenberg/blackfriday-tool) from GitHub. 
  A Windows 64-bit compiled executable is available for download: [blackfriday-tool.zip](http://www.certiv.net/updates/net.certiv.fluentmark.site/blackfriday-tool.zip). 
  The `blackfriday-tool` executable can then be selected on the BlackFriday Converter preference page.

### Keys

|Key             |Function                                          |
|:---------------|:-------------------------------------------------|
|Ctrl-Space      |Opens the template assist popup                   |
|Ctrl-1          |Spell check quick correct                         |
|Ctrl-b          |Toggles **bold** of selected text                 |
|Ctrl-i          |Toggles _italics_ of selected text                |
|Ctrl-/          |Toggles Markdown-style commenting of selected text|
|Ctrl-Shift-/    |Toggles HTML-style commenting of selected text    |
|Ctrl-Shift-f    |Format - full page or selected text               |
|Ctrl-Shift-Alt-f|Format - with unwrapped text                      |


### Math

In-line Math uses single `$` open/close delimiters. Can be embedded in other markdown features.

The opening `$` _must_ have a non-space character immediately right.  The closing `$` _must_ have a non-space 
character immediately left and _must_ be followed immediately by a non-digit or white 
space. This is an inline math $1+2\neq3$! example.
 
Simple math blocks are delimited using double `$`, *i.e.*, `$$`, marks at the left margin. The open delimiter 
must follow a blank line and the close delimiter must lead a blank line.

$$
 u(x) =
  \begin{cases}
   \exp{x} & \text{if } x \geq 0 \\
   1       & \text{if } x < 0
  \end{cases}
$$

### Latex

Raw LaTex is also supported. Implement in left margin blocks delimited by `blank` lines. Recognized by the presence 
of the standard Latex `\begin` and `\end` keywords. 

\begin{equation} 
 f(x)=(x+a)(x+b)
\end{equation}

### HTML

Raw HTML can be used both in-line and as left margin blocks delimited by `blank` lines.

### Table Editor

`Double-click` on an existing table to open the table editor. While in the editor, `double-click` a cell to edit 
text. `Tab` and arrow keys will navigate between cells. `Return` to end cell editing.

## Support

Open an [issue on Github](https://github.com/grosenberg/fluentmark/issues). Provide as much information as possible

- a minimal Markdown document that demonstrates the issue 
- OS name and version version 
- the error message encountered 

## Resources

1. Markdown Syntax
    - [Pandoc's Markdown](https://pandoc.org/MANUAL.html#pandocs-markdown)
    - [GitHub Flavored Markdown](https://github.github.com/gfm/)
    - [Daring Fireball Markdown](https://daringfireball.net/projects/markdown/syntax)
1. TEX Commands available in [MathJax](https://www.onemathematicalcat.org/MathJaxDocumentation/TeXSyntax.htm)
1. PlantUML [Language Specification](https://plantuml.com/sitemap-language-specification)
1. Dot Language [Man Page](http://www.graphviz.org/pdf/dot.1.pdf)
1. Pandoc Latex Templates (for PDF generation):
    - [Starter](https://github.com/jez/pandoc-starter) Templates
    - [Letter](https://github.com/aaronwolen/pandoc-letter) Template
    - [Notes](https://github.com/Wandmalfarbe/pandoc-latex-template) Oriented Template
    - [Miscellaneous](https://github.com/lauritzsh/pandoc-markdown-template) Templates

## License

EPL v1

