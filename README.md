# FluentMark

A full-featured Markdown editing environment for Eclipse.

## Features 

+ Choice of Markdown converter
    - full support for the [Pandoc](https://pandoc.org) converter (preferred)
    - also supports the popular [BlackFriday](https://github.com/russross/blackfriday) 
      converter
    - includes several built-in converters: [CommonMark](https://github.com/jgm/CommonMark), 
      [MarkdownJ](https://github.com/myabc/markdownj), [PegDown](https://github.com/sirthias/pegdown) 
      and [TxtMark](https://github.com/rjeschke/txtmark)
+ Real-time preview window
    - smooth, fully reactively rendered HTML display
    - stylesheet controlled presentation
        + multiple built-in stylesheets
        + user defined stylesheets can be selected from the filesystem
+ LaTex/Math presentation using [MathJax](https://www.mathjax.org/)
+ Code highlighting using [highlightjs](https://highlightjs.org/)
+ Graphs presentation using the [Graphviz](http://www.graphviz.org/) DOT diagram 
  generator
    - diagram previews are rendered in real-time
    - exported Web and PDF documents include the rendered diagrams as embedded images
+ Spell check with quick-assist correction processor
+ Smart editing behaviors
+ Table editor and formatter
+ Text, list and table formatter
+ Intelligent paragraph, list & blank line handling
+ Outline drag and drop of markdown elements

## Screenshot

<figure>
<a href="http://www.certiv.net/updates/net.certiv.fluentmark.site/ScreenShot-0.9.png">
	<img src="http://www.certiv.net/updates/net.certiv.fluentmark.site/ScreenShot-0.9.png"
		alt="FluentMark v0.9 screenshot" width="640"></a><br/><br/>
	<figcaption>FluentMark v0.22</figcaption>
</figure>

---

## Install

Requires Eclipse Oxygen+ JDK 1.8+.

**FluentMark** can be installed from the Certiv Tools update site at [www.certiv.net/updates](http://www.certiv.net/updates/).

FluentMark _Preferences_ can then be found at `Window` => `Certiv Tools` => `FluentMark`  

To use **Pandoc**, install [Pandoc](https://pandoc.org). Then, in the Converter preferences 
for Pandoc, browse to and select the `pandoc` executable.

To use the **PDF** exporter, both *Pandoc* and a _LaTeX_ processor must be installed. 
Pandoc recommends [*MikTeX*](https://miktex.org/).

To use **DOT**, install [Graphviz](http://www.graphviz.org/download.php). Then, in 
the Converter preferences, browse to and select the `dot` executable. 

To use **BlackFriday**, install our customized [blackfriday-tool](https://github.com/grosenberg/blackfriday-tool) 
from its GitHub repository. A Windows 64-bit compiled executable is available for 
download: [blackfriday-tool.zip](http://www.certiv.net/updates/net.certiv.fluentmark.site/blackfriday-tool.zip). 
Then, in the FluentMark Converter preferences for BlackFriday, browse to and select 
the `blackfriday-tool` executable.

---

## Use

### Keys

|Key         |Function                                          |
|:-----------|:-------------------------------------------------|
|Ctrl-Space  |Opens the template assist popup                   |
|Ctrl-B      |Toggles **bold** of selected text                 |
|Ctrl-I      |Toggles _italics_ of selected text                |
|Ctrl-/      |Toggles Markdown-style commenting of selected text|
|Ctrl-Shift-/|Toggles HTML-style commenting of selected text    |
|Ctrl-Shift-F|Format full page or selected text                 |

### Math

Inline Math is defined using single `$` open/close delimiters with no space after 
the opening delimiter and before the closing delimiter. Can be embedded in other 
markdown features.

Math Blocks are delimited using `$$` marks provided on the left margin.  The open 
delimiter must follow and the close must lead blank lines.

### Table Editor

`Double-click` on a table to open the table editor. While in the editor, `double-click` 
a cell to edit text. `Tab` and the arrow keys navigate between cells. `Return` to 
end cell editing.

