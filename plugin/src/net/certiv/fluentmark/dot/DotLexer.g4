lexer grammar DotLexer ;

@header {
	package net.certiv.fluentmark.dot.gen;
}

COMMA  : ',' ;
SEMI   : ';' ;
LBRACE : '{' ;
RBRACE : '}' ;
LBRACK : '[' ;
RBRACK : ']' ;
COLON  : ':' ;
EQ	   : '=' ;

DIRECTED   : '->' ;
UNDIRECTED : '--' ;

STRICT	: 'strict'	;
DIGRAPH	: 'digraph' ;
GRAPH	: 'graph'	;
NODE	: 'node'	;
EDGE	: 'edge'	;
SUBGRAPH : 'subgraph'
		 ;

// Compass Points
N  : 'n'  ;
NE : 'ne' ;
E  : 'e'  ;
SE : 'se' ;
S  : 's'  ;
SW : 'sw' ;
W  : 'w'  ;
NW : 'nw' ;
C	: 'c'
	;

ID
	: NUMERAL | STRING | QUOTED_STRING | HTML_STRING
	;

NUMERAL
	: Minus? ( ( Dot ( DIGIT )+ ) | (DIGIT )+ ( Dot ( DIGIT )* )? )
	;

STRING : ALPHA ( ALPHA | DIGIT )*			;
ALPHA  :   [a-zA-Z_]   | '\u0080'..'\u00FF' ;
DIGIT : [0-9]
	  ;

QUOTED_STRING : '"' (EscSeq | ~["\r\n\\] )* '"'	;

HTML_STRING	: TagOpen ( TagOpen | TagClose | Html )* TagClose ;
ML_COMMENT	: '/*' .*? '*/' ;
SL_COMMENT	: ('//' | '#' ) .*? ( '\r'? '\n' ) | EOF ;

WS : [ \t\r\n\f'] -> channel(HIDDEN) ;

ERR	: .	-> channel(HIDDEN) ;

fragment Esc	  : '\\'		;
fragment Dot	  : '.'			;
fragment Minus	  : '-'			;
fragment TagOpen  : '<'			;
fragment TagClose : '>'			;
fragment HexDigit : [0-9a-fA-F]	;
fragment Html : ~[<>]+
			  ;

fragment EscSeq
	:	Esc
		( [btnfr"'\\]	// Standard escaped character set such as tab, newline, etc.
		| UnicodeEsc	// Unicode escape sequence
		| .				// Other escaped character
		| EOF			// Incomplete at EOF
		)
	;

fragment UnicodeEsc
	:	'u' (HexDigit (HexDigit (HexDigit HexDigit?	)? )? )?
	;

// // Arrow shapes
// BOX : 'box' ;
// CROW : 'crow' ;
// CURVE : 'curve' ;
// ICURVE : 'icurve' ;
// DIAMOND : 'diamond' ;
// DOT : 'dot' ;
// INV : 'inv' ;
// NONE : 'none' ;
// NORMAL : 'normal' ;
// TEE : 'tee' ;
// VEE : 'vee'
// ;
// // Arrows shape qualifiers
// O : 'o' ;
// L : 'l' ;
// R : 'r'
// ;
// // Node shapes
// POLYGON : 'polygon' ;
// ELLIPSE : 'ellipse' ;
// OVAL : 'oval' ;
// CIRCLE : 'circle' ;
// POINT : 'point' ;
// EGG : 'egg' ;
// TRIANGLE : 'triange' ;
// PLAINTEXT : 'plaintext' ;
// PLAIN : 'plain' ;
// TRAPEZIUM : 'trapezium' ;
// PARALLELOGRAM : 'parallelogram' ;
// HOUSE : 'house' ;
// PENTAGON : 'pentagon' ;
// HEXAGON : 'hexagon' ;
// SEPTAGON : 'septagon' ;
// OCTAGON : 'octagon' ;
// DOUBLECIRCLE : 'doublecircle' ;
// DOUBLEOCTAGON : 'doubleoctagon' ;
// TRIPLEOCTAGON : 'tripleoctagon' ;
// INVTRIANGLE : 'invtriange' ;
// INVTRAPEZIUM : 'invtrapezium' ;
// INVHOUSE : 'invhouse' ;
// MDIAMOND : 'Mdiamond' ;
// MSQUARE : 'Mhouse' ;
// MCIRCLE : 'Mcircle' ;
// RECT : 'rect' ;
// RECTANGLE : 'rectangle' ;
// SQUARE : 'square' ;
// STAR : 'star' ;
// UNDERLINE : 'underline' ;
// CYLINDER : 'cylinder' ;
// NOTE : 'note' ;
// TAB : 'tab' ;
// FOLDER : 'folder' ;
// BOX3D : 'box3d' ;
// COMPONENT : 'component' ;
// PROMOTER : 'promotor' ;
// CDS : 'cds' ;
// TERMINATOR : 'terminator' ;
// UTR : 'utr' ;
// PRIMERSITE : 'primersite' ;
// RESTRICTIONSITE : 'restrictionsite' ;
// FIVEPOVERHANG : 'fivepoverhang' ;
// THREEPOVERHANG : 'threepoverhang' ;
// NOVERHANG : 'noverhang' ;
// ASSEMBLY : 'assembly' ;
// SIGNATURE : 'signature' ;
// INSULATOR : 'insulator' ;
// RIBOSITE : 'ribosite' ;
// RNASTAB : 'rnastab' ;
// PROTEASESITE : 'proteasite' ;
// PROTEINSTAB : 'proteinstab' ;
// RPROMOTER : 'rpromoter' ;
// RARROW : 'rarrow' ;
// LARROW : 'larrow' ;
// LPROMOTER : 'lpromoter' ;
// RECORD : 'record' ;
// MRECORD : 'Mrecord'
// ;
// BOLD : 'bold' ;
// DASHED : 'dashed' ;
// DIAGONALS : 'diagonals' ;
// DOTTED : 'dotted' ;
// FILLED : 'filled' ;
// INVIS : 'invis' ;
// RADIAL : 'radial' ;
// ROUNDED : 'rounded' ;
// SOLID : 'solid' ;
// STRIPED : 'striped' ;
// WEDGED : 'wedged' ;
// TAPERED : 'tapered' ;
