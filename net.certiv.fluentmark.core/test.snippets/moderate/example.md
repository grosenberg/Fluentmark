# Hello world!

I'm a test Markdown document.

**Here's some bold text** and *here's some italic text*. `This is inline code`.

# Markdown Tables

First Name  |  Last Name  |  Location           |  Allegiance
------------|-------------|---------------------|-----------------
Mance       |  Rayder     |  North of the Wall  |  Wildlings
Margaery    |  Tyrell     |  The Reach          |  House Tyrell
Danerys     |  Targaryen  |  Meereen            |  House Targaryen
Tyrion      |  Lannister  |  King's Landing     |  House Lannister

# Code blocks

    This pseudo-code is in
    an indented code block.

Here's a syntax-highlighted code block:

```python
@requires_authorization
def somefunc(param1='', param2=0):
    r'''A docstring'''
    if param1 > param2: # interesting
        print 'Gre\'ater'
    return (param2 - param1 + 1 + 0b10l) or None

class SomeClass:
    pass

>>> message = '''interpreter
... prompt'''
```

Here's a forced page break.

\pagebreak

# Page Layout with LaTeX Commands

## \LaTeX support

This document supports in-line \LaTeX!

Here's the proof: $\frac{n!}{k!(n-k)!} = \binom{n}{k}$

Creating a footnote is easy.\footnote{An example footnote.}

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
   1 & \text{if } x < 0
  \end{cases}
$$

\begin{align*}
f(x) &= (x+a)(x+b) \\
     &= x^2 + (a+b)x + ab
\end{align*}

