parser grammar DotParser ;

options {
	tokenVocab = DotLexer ;
}

@header {
	package net.certiv.fluentmark.dot.gen;
}

graph
	: STRICT? gtype= ( GRAPH | DIGRAPH ) id? LBRACE stmt* RBRACE
	;

stmt
	: (nodeStmt | edgeStmt | attrStmt | attribute | subgraph ) SEMI?
	;

nodeStmt
	: nodeId attrList*
	;

edgeStmt
	: ( nodeId | subgraph ) edgeRhs+ attrList*
	;

attrStmt
	: atype= ( GRAPH | NODE | EDGE ) attrList+
	;

attrList
	: LBRACK ( attribute (COMMA | SEMI )? )* RBRACK
	;

attribute
	:	key=id EQ value=id
	;

subgraph
	:   SUBGRAPH id? LBRACE stmt* RBRACE
	;

edgeRhs
	: op= ( DIRECTED | UNDIRECTED ) ( nodeId | subgraph )
	;

nodeId
	: id port?
	;

port
	: COLON id ( COLON compass )?
	| COLON compass
	;

id
	: ID | compass
	;

compass
	: N | NE | E | SE | S | SW | W | NW | C
	;

//arrowShape
//	: ( O? (L | R ) )? ( BOX | CROW | CURVE | ICURVE | DIAMOND | DOT | INV | NONE | NORMAL | TEE | VEE )
//	;
//
//polygonShape
//	: BOX			| POLYGON		 | ELLIPSE		| OVAL		 | CIRCLE	 | POINT
//	| EGG			| TRIANGLE		 | PLAINTEXT	| PLAIN		 | DIAMOND
//	| TRAPEZIUM		| PARALLELOGRAM	 | HOUSE		| PENTAGON	 | HEXAGON
//	| SEPTAGON		| OCTAGON		 | DOUBLECIRCLE | DOUBLEOCTAGON
//	| TRIPLEOCTAGON | INVTRIANGLE	 | INVTRAPEZIUM | INVHOUSE
//	| MDIAMOND		| MSQUARE		 | MCIRCLE		| RECT		 | RECTANGLE
//	| SQUARE		| STAR			 | NONE			| UNDERLINE	 | CYLINDER
//	| NOTE			| TAB			 | FOLDER		| BOX3D		 | COMPONENT | PROMOTER
//	| CDS			| TERMINATOR	 | UTR			| PRIMERSITE | RESTRICTIONSITE
//	| FIVEPOVERHANG | THREEPOVERHANG | NOVERHANG	| ASSEMBLY
//	| SIGNATURE		| INSULATOR		 | RIBOSITE		| RNASTAB	 | PROTEASESITE
//	| PROTEINSTAB	| RPROMOTER		 | RARROW		| LARROW	 | LPROMOTER
//	;
//
//recordShape : RECORD | MRECORD ;
//
//nodeStyle
//	: BOLD	| DASHED | DIAGONALS | DOTTED | FILLED
//	| INVIS | RADIAL | ROUNDED	 | SOLID  | STRIPED | WEDGED
//	;
//
//edgeStyle
//	: BOLD | DASHED | DOTTED | INVIS | SOLID | TAPERED
//	;
//
//splines
//	: TRUE	 | FALSE | NONE	  | LINE
//	| SPLINE | ORTHO | CURVED | POLYLINE
//	;
//


