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
	: id EQ value
	;

value
	: id
	| STRING | HTML
	| NUMBER | POINT | RECT | SPLINE
	| COLORS | RGB	 | HSV
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
	: name=	( ID | N | NE | E | SE | S | SW | W | NW | C )
	;

compass
	: dir= ( N | NE | E | SE | S | SW | W | NW | C )
	;
