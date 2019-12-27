lexer grammar DotLexer ;

@header {
	package net.certiv.fluent.dt.core.lang.dot.gen;
}

DOTCODE	
	: CodeMark Hws*? 'dot' -> pushMode(DOT)
	| CodeMark -> type(OTHER)
	;

DOTUML	: '@startdot' -> pushMode(DOT) ;
DIGRAPH	: 'digraph'	  -> pushMode(DOT) ;
GRAPH	: 'graph'	  -> pushMode(DOT) ;

STRICT	: 'strict' ;

OTHER	: . ;

mode DOT ;
	DGH	: 'digraph'	-> type(DIGRAPH) ;
	GRH	: 'graph'	-> type(GRAPH)   ;
	SCT : 'strict'	-> type(STRICT)  ;

	LBRACE : '{' -> pushMode(DOT) ;
	RBRACE : '}' -> popMode ;

	RGB	   : Quote RgbSeq Quote ;
	HSV	   : Quote HsvSeq Quote ;
	POINT  : Quote Decimal Comma Decimal Bang? Quote ;
	RECT   : Quote Decimal Comma Decimal Comma Decimal Comma Decimal Quote ;
	COLORS : Quote Color ( Colon Color )+ Quote ;
	STRING : Quote ( EscSeq | ~["\r\n\\] )* Quote ;

	SPLINE : SPOINT ( Semi SPOINT )+ ;

	SPOINT : ( SplineEnd )? ( SplineStart )? POINT ( POINT POINT POINT )+ ;

	HTML
		: TagOpen ( TagOpen | TagClose | Html )* TagClose
		;

	NUMBER
		: Minus? ( ( Dot ( Digit )+ ) | (Digit )+ ( Dot ( Digit )* )? )
		;

	ML_COMMENT : '/*' .*? '*/' ;
	SL_COMMENT : ( '//' | Pound ) .*? ( '\r'? '\n' ) | EOF ;

	COMMA  : ',' ;
	SEMI   : ';' ;
	LBRACK : '[' ;
	RBRACK : ']' ;
	COLON  : ':' ;
	EQ	   : '=' ;

	DIRECTED   : '->' ;
	UNDIRECTED : '--' ;

	SUBGRAPH : 'subgraph' ;
	NODE	 : 'node'	  ;
	EDGE	 : 'edge'	  ;

	// Compass Points
	N  : 'n'  ;
	NE : 'ne' ;
	E  : 'e'  ;
	SE : 'se' ;
	S  : 's'  ;
	SW : 'sw' ;
	W  : 'w'  ;
	NW : 'nw' ;
	C  : 'c'  ;

	ID : Alpha ( Alpha | Digit )* ;

	VWS : Vws -> channel(HIDDEN) ;
	HWS : Hws -> channel(HIDDEN) ;

	ERR	: . ;
	
// endMode DOT

fragment CodeMark 
	: '``' '`'+ 
	| '~~' '~'+ 
	;

fragment Vws : [\r\n\f] ;
fragment Hws : [ \t] ;

fragment Alpha
	:   [a-zA-Z_]
	| '\u0080'..'\u00FF'
	;

fragment Html
	: ~[<>]+
	;

fragment RgbSeq
	: Pound HexDigit HexDigit HexDigit HexDigit HexDigit HexDigit ( HexDigit HexDigit )?
	;

fragment HsvSeq
	: HsvDigit HsvDigit HsvDigit
	;

fragment Color
	: Alpha+ ( Semi Fract )?
	;

fragment SplineStart : Quote 'e' Comma Decimal Quote ;
fragment SplineEnd : Quote 's' Comma Decimal Quote
				   ;

// and triple = point point point
// and endp = "e,%f,%f"

// and startp = "s,%f,%f"
fragment Decimal  : [+-]? UDecimal	  ;
fragment UDecimal : Digit+ Dot Digit* ;
fragment Fract	  : '0' Dot Digit+	  ;

fragment Digit	  : [0-9]						;
fragment HexDigit : [0-9a-fA-F]					;
fragment HsvDigit : [0-1] Dot Digit Digit Digit	;

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

fragment Quote		: '"'  ;
fragment TagOpen	: '<'  ;
fragment TagClose	: '>'  ;
fragment Esc		: '\\' ;
fragment Colon		: ':'  ;
fragment LParen		: '('  ;
fragment RParen		: ')'  ;
fragment LBrace		: '{'  ;
fragment RBrace		: '}'  ;
fragment LBrack		: '['  ;
fragment RBrack		: ']'  ;
fragment Question	: '?'  ;
fragment Bang		: '!'  ;
fragment Star		: '*'  ;
fragment Slash		: '/'  ;
fragment Percent	: '%'  ;
fragment Caret		: '^'  ;
fragment Plus		: '+'  ;
fragment Minus		: '-'  ;
fragment Underscore	: '_'  ;
fragment Pipe		: '|'  ;
fragment Dollar		: '$'  ;
fragment Comma		: ','  ;
fragment Semi		: ';'  ;
fragment Dot		: '.'  ;
fragment At			: '@'  ;
fragment Pound		: '#'  ;
fragment Tilde		: '~'  ;

