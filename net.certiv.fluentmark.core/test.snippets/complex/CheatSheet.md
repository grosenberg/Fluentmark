### Markdown Markup Cheat Sheet

#### Phrase Modifiers

\`\`inline code\`\` - rendered as ``inline code``  
\`inline code\` - rendered as `inline code`  
\*\*strong\*\* - rendered as **strong**  
\_\_strong\_\_ - rendered as __strong__  
\*emphasis\* - rendered as *emphasis*  
\_emphasis\_ - rendered as _emphasis_  

#### Block Modifiers

##### Code Blocks

To create a code block indent every line by 4 or more spaces, or by a tab.

	int x = 0; // example code block
	x = x + 1;

##### Paragraphs

Paragraphs are consecutive lines of text
separated by one or more blank lines.  End a line with two or
more spaces to create a line break. 

##### Headings

\# This is an H1  
\#\# This is an H2  
\#\# This is also an H2 \#\#    
\#\#\#\#\# This is an H5  

##### Lists

Unordered lists use `*`, `+`, or `-` as bullets.

*   one
*   two

Numbered lists use numbers followed by periods:

1.  one
2.  two

##### Block Quotes

> Block quotes use email-style quoting  
> second quoted line

##### Horizontal Rule

A horizontal rule is created with 3 or more hyphens or stars on a line.

\-\-\-  
\*\*\*

#### Links

&lt;http://www.example.com&gt;  - rendered as <http://www.example.com>  
\[Text\]\(http://www.example.com "Optional title"\) - rendered as [Text](http://www.example.com "Optional title")  
\[an example\]\[id\] - rendered as [an example][id]

##### Link Reference Definition

[id]: http://example.com/  \"Optional Title Here\"

#### Images

\!\[Alt text\]\(path/to/image.png "Optional title"\)  
\!\[Alt text\]\[Reference ID\]

#### HTML Tags

All HTML tags are recognized
 
&lt;tt&gt;teletype&lt;/tt&gt; - <tt>teletype</tt>

#### Reference 

[Complete Markdown syntax guide](http://daringfireball.net/projects/markdown/syntax)

