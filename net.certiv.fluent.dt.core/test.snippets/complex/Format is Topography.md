# Format is Topography

Topography
: a detailed description or representation on a map of salient features appropriate 
for distinct identification of an area relative to a defined root locus.

## Schema

The map is defined in terms of a grammar-specific decomposition of the source. Whitespace 
is ignored, except where significant (source language dependent). Comments are also 
characterized by the decomposition.

The decomposition identifies the rule contexts, terminal nodes, and characterized 
comments as a set of interrelated structural features.

## Formatting

Only real features, defined as those having a root terminal node or root comment 
token, are subject to formatting. Rule features are only used to provide identification 
context for associated real features.

![Topographical map of a GRAMMAR feature](./GrammarFeature.png)


### Formatting by Type

A source document is described as a set of real features, where each such feature 
is categorically identifiable by a type attribute. For variable content features, 
typically including IDENTs, strings, and numbers, the type is the feature associated 
token type. For all other features, the type is the combined feature associated token 
type and text.

Formatting is the process of matching, per feature type, features from the source 
document with correspondingly typed sets of corpus features. For each source document 
feature, the most similar corpus feature is selected. The formatting control facets 
of the selected feature are then used to adjust the source formatting of the document 
feature.

## Decomposition Operation

A walker visits the rule contexts and terminal nodes of the parse tree representing 
the source.

For each rule context visited, a corresponding rule feature is created and a node 
feature is created for each direct child terminal node.

For each terminal node visited, a corresponding node feature is created.

Comments are extracted from the token stream. For each comment found, a corresponding 
block or line feature is created.

## Edges

For each real feature, edges are added between that root feature and each of the 
other features that exist within a local group defined relative to the root feature.

### Local Group Defined

A local group includes:

+ root node enclosing rule features within a defined parentage range
    - only for root node features
+ current source line features
    - root node to rule features within a defined rule adjacency range
    - root node to node features within a defined node adjacency range
    - root node to comment features within a defined comment adjacency range
+ prior non-blank source line features
    - root node to same type node features within a defined similar node range
    - root comment to same type comment features within a defined similar comment 
      range
+ next non-blank source line features
    - root node to same type node features within a defined similar node range
    - root comment to same type comment features within a defined similar comment 
      range
