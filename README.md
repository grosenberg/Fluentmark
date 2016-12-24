## FluentMark

The full-featured Markdown editing environment for Eclipse.

### Features 

+ Multiple Markdown converters
    - supports [BlackFriday](https://github.com/russross/blackfriday), 
      [CommonMark](https://github.com/jgm/CommonMark), 
      [MarkdownJ](https://github.com/myabc/markdownj), 
      [Pandoc](https://pandoc.org),
      [PegDown](https://github.com/sirthias/pegdown) &
      [TxtMark](https://github.com/rjeschke/txtmark)
+ [Graphviz](http://www.graphviz.org/) DOT diagram generator support built-in
	- renders as SVG images embedded in exported Web documents 
	- renders as PDF images embedded in exported PDF documents
+ Real-time browser-based preview of the generated document
    - customizable stylesheet: multiple choices built-in or specify an external stylesheet
    - full code highlighting using [highlight.js](https://highlightjs.org/)
+ Spell check with quick-assist correction processor
    - can be enabled independent of the platform spell checker
+ Smart editing behaviors
    - table editor and formatter
    - intelligent paragraph, list & blank line handling
    - outline view drag and drop

### Screenshot

<figure>
<a href="http://www.certiv.net/updates/net.certiv.fluentmark.site/ScreenShot-0.8.png">
	<img src="http://www.certiv.net/updates/net.certiv.fluentmark.site/ScreenShot-0.8.png"
		alt="FluentMark v0.8 screenshot" 
		align="left" width="800"></a>
	<figcaption>FluentMark v0.8</figcaption>
</figure>

---

### Install

**FluentMark** can be installed from the Certiv Tools update site 
at [www.certiv.net/updates](http://www.certiv.net/updates/).

The FluentMark *Preferences* can then be found at `Window` -> `Certiv Tools` -> `FluentMark`  

To use **DOT**, install [Graphviz](http://www.graphviz.org/download.php). Then, 
in the FluentMark Converter preferences for DOT, browse to and select the `dot` 
executable.

To use **BlackFriday**, install our customized [blackfriday-tool](https://github.com/grosenberg/blackfriday-tool) 
from its GitHub repository. A Windows 64-bit compiled executable 
is available for download: [blackfriday-tool.zip](http://www.certiv.net/updates/net.certiv.fluentmark.site/blackfriday-tool.zip). 
Then, in the FluentMark Converter preferences for BlackFriday, browse to 
and select the `blackfriday-tool` executable.

To use **Pandoc**, install [Pandoc](https://pandoc.org). Then, 
in the FluentMark Converter preferences for Pandoc, browse to and select the `pandoc` 
executable.

To use the **PDF** exporter, both *Pandoc* and a *LaTeX* processor must be installed. 
Pandoc recommends [*MikTeX*](https://miktex.org/).

### Use

`Double-click` on a table to open the table editor. `Double-click` a cell to edit text. 
`Tab` and the arrow keys navigate between cells. `Return` to end cell editing.

|Key         |Function                                          |
|:-----------|:-------------------------------------------------|
|Ctrl-Space  |Opens the template assist popup                   |
|Ctrl-/      |Toggles Markdown-style commenting of selected text|
|Ctrl-Shift-/|Toggles HTML-style commenting of selected text    |
|Ctrl-Shift-F|Format full page or selected text                 |


### Requirements

Eclipse Neon+  
JDK 1.8

### Development Status

- Version 0.9 - beta
- In active development 
