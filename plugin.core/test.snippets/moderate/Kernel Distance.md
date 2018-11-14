## Kernel Distance

In Adept, the kernel distance between two features A and B is defined as

$$ distance = A.simularity(A) + B.simularity(B) - 2 * A.simularity(B) $$

A distance value of `0` specifies that features A and B are, in effect, identical.

Similarity is determined from a comparison of the labels and edges that distinctly 
define a feature. Each edge is defined by a set of labels and a pair of root and 
leaf features. Commonalities increase and distinctions reduce similarity.

Similarity is only meaningful between equivalent features. Equivalency is defined 
for non-variable features as features that have the same root label type and text. 
A variable feature characteristically represents a variable identifier, string, or 
number whose underlying text is inconsequential to feature distinctness. Only the 
root label type of a variable feature is considered for purposes of determining equivalency.

### Similarity

Similarity is calculated as a positive real, represented by a `double` value. A value 
of `0` indicates no similarity basis exists between two features.

#### Similarity of Features

Similarity of two features A and B is defined as

$$ A.similarity(B) = \sum_{i=0}^{n} (A,B).sim(FL_i) + (A,B).sim(E) $$

- where $FL_i$ is a feature label and E is the edge set of A and B.

#### Similarity of Labels

Similarity of a label $L_x$ is defined as one of 

$$ (A,B).sim(L_x) = \kappa_x * ( A.L_x \oplus B.L_x ) $$

- where the constant $\kappa_x$ is a tunable parameter reflecting the normalized 
  relative similarity significance of the label $L_x$, and
- where the function of the mutuality evaluator $\oplus$ is dependent on the encoding 
  of the label.

#### Similarity of Edge Sets

Similarity of the set of edges E is defined as

$$
\begin{equation} \begin{split}
    (A,B).sim(E) = &\quad\{\,\sum_{edge\,0..n} (A,B).sim(EL_x)\;\}_{A \cap B} \\
                   &- \, \{\,\sum_{edge\,0..n} \alpha_x * \kappa_x 
* ( A.L_x \odot B.L_x )\;\}_{A \setminus B} \end{split} \end{equation} 
$$

- where the constant $\alpha_x$ is a tunable parameter reflecting the reduced significance 
  of edge structural dissimilarities, and
- where the function of the differential evaluator $\odot$ is dependent on the encoding 
  of the label.
- where the calculated value is constrained to a positive real, represented by a 
  `double`. A `0` value indicates that the edge set is more dissimilar than similar 
  by the factor $\alpha$.


#### Similarity of the Format Label

The format label of a feature is represented as a bit-encoded vector specifying the 
formatting facets applicable to the feature.

The base similarity of the formats of two features A and B is defined using Kendall's 
rank correlation coefficient $\tau$

$$ (A,B).sim(format)^\prime = \left\bracevert \dfrac{n_c - n_c}{ 0.5 n * (n-1)} \, 
\right \bracevert^{[0,1\rangle} $$


+ where $n_c$ is the number of concordant pairs of facet bits
+ where $n_d$ is the number of discordant pairs of facet bits, and
+ where the value of $\tau$ is represented as a `double`, normalized and constrained 
  to the interval $[0,1\rangle$.



### Feature Labels

|Label          |Description                                   |
|:--------------|:---------------------------------------------|
|type           |rule number or token type (encoded)           |
|text           |text of the feature (shortened & encoded)     |
|size           |text length of the feature                    |
|weight         |relative frequency of occurrence in the corpus|
|edge count     |number of distinct edges connected            |
|edge type count|number of distinct types of edges connected   |
|format         |logical formatting facets (encoded)           |


### Edge Labels

|Label    |Description                                 |
|:--------|:-------------------------------------------|
|leaf type|rule number or token type (encoded)         |
|leaf text|text of the feature (shortened & encoded)   |
|metric   |length and orientation of the edge (encoded)|
|weight   |relative rarity of occurrence in the corpus |

