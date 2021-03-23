<img src="./doc/Logo110x80.png">

# FluentMark

A full-featured Markdown editing environment for Eclipse.

## Features 

+ Standard Markdown syntax 
+ Extended syntax
	+ Html - inline & block
	+ Math - inline & block
	+ Latex - inline & block
	+ Graphs - [Graphviz Dot](http://www.graphviz.org/) language block
	+ Uml - [PlantUml](http://www.graphviz.org/) language block 
+ Liveview - real-time external browser rendered preview
    - reactive rendering using [Vue.js](https://vuejs.org/)
    - math presentation using [MathJax](https://www.mathjax.org/)
    - code highlighting using [highlightjs](https://highlightjs.org/)
+ Spell check with quick-assist correction processor
+ Smart editing behaviors, including intelligent paragraph, list & blank line handling
+ Table editor
+ Text, list and table formatter
+ Stylesheet controlled editor presentation
+ Outline view with drag-and-drop support

## Screenshot

<figure>
  <img src="./doc/ScreenShot.png">
  <figcaption>Graph presentation using Graphviz Dot (old version)</figcaption>
</figure>


## Installation 

Installation:

Certiv Tools update site: `https://www.certiv.net/updates`

Requirements

- Eclipse 2021-03
- JDK 11+

Requirements for Dot and PlantUml language blocks

- [Graphviz](http://www.graphviz.org/download.php). 


Requirements for Html and Pdf export

- [Pandoc](https://pandoc.org) and a _LaTeX_ processor (Pandoc recommends [*MikTeX*](https://miktex.org/)).


## Configuration

Eclipse Preference pages ---

- `Window` -> `Certiv Tools` -> `FluentMark`

To use the Pandoc converter, select the `pandoc` executable from the local filesystem 
on the Pandoc Converter tab. 

To use Graphviz Dot, select the `dot` executable on the Fluentmark preference page.  
If `Graphviz` is installed in a non-default directory, PlantUML requres that the 
`GRAPHVIZ_DOT` environment variable be set to the actual installation directory.

To use the BlackFriday converter, install the customized 
[blackfriday-tool](https://github.com/grosenberg/blackfriday-tool) from GitHub. 
A Windows 64-bit compiled executable is available for download
[blackfriday-tool.zip](http://www.certiv.net/updates/net.certiv.fluentmark.site/blackfriday-tool.zip). 
The `blackfriday-tool` executable can then be selected on the BlackFriday Converter tab.


## Support

Open an [issue on Github](https://github.com/grosenberg/fluentmark/issues). Provide 
as much information as possible

- a minimal Markdown document that demonstrates the issue 
- OS name and version version 
- the error message encountered 

## Resources

1. Markdown Syntax
    - [Pandoc's Markdown Documentation](https://pandoc.org/MANUAL.html#pandocs-markdown)
    - [CommonMark Spec 0.29](https://spec.commonmark.org/0.29/)
1. [TeX Syntax Documentation](https://www.onemathematicalcat.org/MathJaxDocumentation/TeXSyntax.htm)
1. [PlantUML Language Specification](https://plantuml.com/sitemap-language-specification)
1. [Graphviz 'Dot' Language](http://www.graphviz.org/pdf/dot.1.pdf)
1. [LaTex Templates](https://github.com/topics/latex-template "Latex Templates") for Pandoc PDF generation on Github.

## License

EPL 


