Contents## first

The AI classifier function compares an unknown context vector 
`X`, corresponding to a search exemplar, to the `Xj` from all 
`N` exemplars to find the `k` nearest. The comparison is performed 
against defined structural features of a real token (non-whitespace). 
From these `k` , the classifier then selects the one exemplar 
that appears most often. The whitespace encoded in the selected 
exemplar is then used to direct the formatting of that token.

|A    |B        |       C        |
|:----|:--------|:--------------:|
|stuff|Long line|description of C|



- source file formatting is homogeneous; no discretely formatted 
  sections exist anywhere in the text of the system at home
- formatting is specified by indentation control at
    - line beginnings
    - block delimiters
    - aspects of inline lists
- line length is ignored as a facet of formatting


- any text is added at any time