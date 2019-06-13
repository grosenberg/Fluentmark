# FluentMark

A full-featured Markdown editing environment for Eclipse.

Survey: [Proposal to remove legacy converters](https://github.com/grosenberg/fluentmark/issues/30).

## Features 

+ Choice of Markdown converter
    - full support for the [Pandoc](https://pandoc.org) converter (preferred)
    - supports several alternate converters
        + [BlackFriday](https://github.com/russross/blackfriday), [CommonMark](https://github.com/jgm/CommonMark), 
          [MarkdownJ](https://github.com/myabc/markdownj), [PegDown](https://github.com/sirthias/pegdown) 
          & [TxtMark](https://github.com/rjeschke/txtmark)
+ Real-time preview
    - smooth, reactively rendered HTML display, using [Vue.js](https://vuejs.org/)
    - stylesheet controlled presentation
        + multiple built-in stylesheets
        + local custom/user defined stylesheets
+ PDF export using Pandoc
    - custom/user defined latex page template support
+ LaTex/Math presentation using [MathJax](https://www.mathjax.org/)
+ Code highlighting using [highlightjs](https://highlightjs.org/)
+ Diagram rendering
    - Graph diagrams using the [Graphviz DOT](http://www.graphviz.org/) language
    - UML diagrams using the [PlantUml](http://www.graphviz.org/) language
    - all diagram previews are rendered in real-time
    - exported Web and PDF documents embed the diagrams as scalable images
+ Spell check with quick-assist correction processor
+ Smart editing behaviors, including intelligent paragraph, list & blank line handling
+ Table editor
+ Text, list and table formatter
+ Outline view with drag-and-drop support

## Screenshots

<figure>
<figcaption>1. Dot Graph</figcaption>
[![Fluentmark Dot graph][1]][1]
</figure>

<figure>
<figcaption>2. Sequence Diagram</figcaption>
[![Fluentmark Sequence diagram][2]][2]
</figure>

[1]: http://www.certiv.net/updates/net.certiv.fluentmark.site/ScreenShot.png "FluentMark Dot graph" 
[2]: http://www.certiv.net/updates/net.certiv.fluentmark.site/ScreenShot1.png "FluentMark Sequence diagram" 



## Installation & Use

Requires Eclipse Photon & JDK 1.8+.

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

UML diagrams ---

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
|Ctrl-Shift-f    |Format - full page or selection                   |
|Ctrl-Shift-Alt-f|Format - with unwrapped text                      |

### Math

In-line Math uses single `$` open/close delimiters. Can be embedded in other markdown features.

The opening `$` _must_ have a non-space character immediately right.  The closing `$` _must_ have a non-space 
character immediately left and _must_ be followed immediately by a non-digit. 

Math blocks are delimited using double `$` (*i.e.*, `$$`) marks at the left margin. The open delimiter 
must follow a blank line and the close delimiter must lead a blank line.


### Table Editor

`Double-click` on a table to open the table editor. While in the editor, `double-click` a cell to edit 
text. `Tab` and arrow keys will navigate between cells. `Return` to end cell editing.

## Support

Open an [issue on Github](https://github.com/grosenberg/fluentmark/issues). 

Provide as much information as applicable, including the plugin version number, any error message encountered, 
and a minimal example of the Markdown text at issue.

### Resources

1. Markdown Syntax
    - [Pandoc's Markdown](https://pandoc.org/MANUAL.html#pandocs-markdown)
    - [GitHub Flavored Markdown](https://github.github.com/gfm/)
    - [Daring Fireball Markdown](https://daringfireball.net/projects/markdown/syntax)
1. [TEX Commands available in MathJax](http://www.onemathematicalcat.org/MathJaxDocumentation/TeXSyntax.htm)
1. [PlantUML Language Specification](http://plantuml.com/sitemap-language-specification)
1. [Dot Language Man Page](http://www.graphviz.org/pdf/dot.1.pdf)
1. Pandoc Latex Templates (for PDF generation):
    - [Starter Templates](https://github.com/jez/pandoc-starter)
    - [Letter Template](https://github.com/aaronwolen/pandoc-letter)
    - [Notes Oriented Template](https://github.com/Wandmalfarbe/pandoc-latex-template)
    - [Collection of Templates](https://github.com/lauritzsh/pandoc-markdown-template)

## License

EPL v1

