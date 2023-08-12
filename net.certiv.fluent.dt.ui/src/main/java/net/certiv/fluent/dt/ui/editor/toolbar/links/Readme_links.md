# Links

## Inline Links

Unified link specification: 

```
  [text](URI "alt")
```

## Reference Links

Two part specification: 

```
  [text][ref]         // first part: reference label
  [ref]: URI "alt"    // second part: reference definition
```

Can be collapsed when the ref is the text:

```
  [ref][]             // first part: reference label
  [ref]: URI "alt"    // second part: reference definition
```

Compact collapsed:

```
  [ref]               // first part: reference label
  [ref]: URI "alt"    // second part: reference definition
```


## Image link

Variation on inline and reference links 

```
  ![text](URI "alt")

or 
  
  ![text][ref]        // first part: reference label

```

## Footnote link

Variation on the compact collapsed reference link 

```
  [^ref]              // first part: footnote label
  [^ref]: text        // second part: footnote content

```


