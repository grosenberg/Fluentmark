## Codebuff

A machine learning based system for performing language-agnostic source code formatting. 

### Theory of Operation

CODEBUFF uses a k-Nearest Neighbor (kNN) machine learning model. Exemplars, derived 
from a corpus of well-formatted documents, form the basis of the model. Codebuff works 
well for the __limited__ purpose of testing.   

~~~ dot

digraph M1 { 
    node[shape=box width=1.1]
    
    parser[label="Document\nParser"]
    source[label="Source\nDocumment"]
    corpus[label="Corpus\nModel"] 
    module[label="AI Core"] 
    format[label="Formatter"] 
    output[label="Output\nDocument"]
	
	corpus->module[color=blue constraint=false]
	parser->module[color=blue label="Search\nExemplars\n\n"]
	parser->corpus[color=darkgreen label="\nTraining\nExemplars"]
	source->parser[constraint=false]
	module->format[label="Formatting\nCommands"]
	source->format
	format->output
}

~~~


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


The AI classifier function compares an unknown context vector `X`,
corresponding to a search exemplar, to the `Xj` from all `N` exemplars to find
the `k` nearest. The comparison is performed against defined structural features
of a real token (non-whitespace). From these `k` , the classifier then selects
the one exemplar that appears most often. The whitespace encoded in the selected
exemplar is then used to direct the formatting of that token.


|A   |  B  |C    |
|:---|:---:|:----|
|one | two |three|

---
	
### Design Considerations

~~~ dot

digraph M1{ 
    node[shape=box width=1.1]
    parser[label="Document\nParser2"]
    source[label="Source\nDocument"]
    corpus[label="Corpus\nModel"]
    module[label="AI Core"]
    format[label="Formatter"]
    output[label="Output\nDocument"]
    
    corpus->module[color=blue constraint=false]
    parser->module[color=blue label="Search\nExemplars\n\n"]
    parser->corpus[color=darkgreen label="\nTraining\nExemplars"]
    source->parser[constraint=false]
    module->format[label="Formatting\nCommands"]
    source->format
    format->output
}

~~~

#### -- General

The design intent is to format source code consistent with a defined standard, as represented 
by the corpus.

Given that formating  
 

XXX Key to the design is that exemplars, otherwise independent of context, are directly comparable. XXX


Key to the design is that exemplars, otherwise independent of context, are directly comparable. 

Formatting is driven from an analysis of the individual real tokens that describe the 
source code in functional terms. Each real token is identified and associated with a 
set of structural features that describe the token in context. Together, the real tokens 
and their associated structural features define exemplars.

Exemplars that represent the corpus also include formating features. CODEBUFF effects 
formatting as a function of line break location and indentation control. The formatting 
features are used to capture the relative location of line breaks and 

- source file formatting is homogeneous; no discretely formatted sections exist
- formatting is specified by indentation control at 
	- line beginnings
	- block delimiters 
	- aspects of inline lists
- line length is ignored as a facet of formatting

#### -- Structural Features

- formatting can be derived from consideration of select structural features
- a structural feature defines the relationship between two real tokens
- every structural feature is reducible to a corpus abstracted characterizing int
- line start and end are structural features
- implied block delimiters are structural features
- child index relative to a parent node(^1..^5)  is a structural feature

#### -- Exemplars

- each exemplar is defined for a real token by
	- fixed set of structural features
	- corpus source document 
	- formatting directives: ws and horz positioning 
- individual exemplars are directly comparable; they have no context
- comparison of exemplars is based on real token type and structural feature sets
- exemplars are compare invariant

---

### Process

1. corpus documents are read & parsed
- exemplars are derived for each real corpus token
- corpus exemplars are stored as an in-memory model
- source document is read and parsed
- exemplars are derived for each real source token
- source exemplars are successively used to query the model
- each query returns a corpus exemplar as a formatting directive
- the directive controls the formatted ouput of the real source token

---

### Design Limitations
 
- all formatting information in the existing source is ignored
- does not recognize blocks defined solely by source indentation or other aspects
- limited to the the functional resolution of the real token type set of a corpus
- ignores whether a real token type is text invariant or not
- inline tab alignments are a problem
- inability to handle variant formatting  
- inability to handle discordant formatting  

---

### Future Needs
 
- adding a validly formated source document to the corpus should add variant formatting cases 
