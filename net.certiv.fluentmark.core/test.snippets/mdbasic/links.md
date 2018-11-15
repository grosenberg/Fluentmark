# Math

## Test

The [AI classifier](https://www.certiv.net) function compares 
an unknown context vector `X`, corresponding to a search exemplar, 
to the `Xj` from all `N` exemplars to find the `k` nearest. The 
comparison is performed against defined structural features of 
a real token (non-whitespace). From these `k` , the classifier 
then selects the one exemplar that appears most often. The whitespace 
encoded in the selected exemplar is then used to direct the formatting 
of that token. There is little question of what happens next.

## LaTeX support

This document supports inline LaTeX!

Here's the proof: $\frac{n!}{k!(n-k)!} = \binom{n}{k}$

Here's an equation:

$$
  x = a_0 + \cfrac{1}{a_1
          + \cfrac{1}{a_2
          + \cfrac{1}{a_3 + \cfrac{1}{a_4} } } }
$$


Here are some numbered equations:

\begin{equation} 
 f(x)=(x+a)(x+b)
\end{equation}


\begin{equation}
5^2 - 5 = 20
\end{equation}


\begin{equation}
a = bq + r
\end{equation}

Here's some multi-line math stuff:

$$
 u(x) =
  \begin{cases}
   \exp{x} & \text{if } x \geq 0 \\
   1       & \text{if } x < 0
  \end{cases}
$$

\begin{align*}
 f(x) &= (x+a)(x+b) \\
 &= x^2 + (a+b)x + ab
\end{align*}