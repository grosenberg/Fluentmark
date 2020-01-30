lexer grammar DotLexer ;

options {
	superClass = LexerBase;
}
    
@header {
	package net.certiv.fluent.dt.core.lang.dot.gen;
	import net.certiv.fluent.dt.core.lang.dot.LexerBase; 
}

DOTCODE	: CodeMark Hws* 'dot' { at() }? -> type(OTHER), pushMode(DOT)	;
DOT_END	: CodeMark { at() }? -> type(OTHER)	;

DOTUML	: '@startdot' { at() }? -> type(OTHER), pushMode(DOT) ;

VWS	: Vws -> channel(HIDDEN) ;
HWS	: Hws -> channel(HIDDEN) ;

OTHER : . ;

mode DOT;
	UMLBEG	: '@startdot' { at() }? -> type(OTHER), pushMode(DOT) ;

    GRAPH	: ( 'strict' Hws+ )? ( 'graph' | 'digraph' ) { at() }? ;
    LBRACE	: '{' -> pushMode(DOT)	;

    RBRACE	: '}' -> popMode		;
	UMLEND	: '@enddot' { at() }? -> type(OTHER), popMode ;
	DOTEND	: CodeMark { at() }? -> type(OTHER), popMode ;

    RGB	   : Quote RgbSeq Quote ;
    HSV	   : Quote HsvSeq Quote ;
    POINT  : Quote Decimal Comma Decimal Bang? Quote ;
    RECT   : Quote Decimal Comma Decimal Comma Decimal Comma Decimal Quote ;
    COLORS : Quote Color ( Colon Color )+ Quote ;
    STRING : Quote ( EscSeq | ~["\r\n\\] )* Quote ;

    SPLINE : SPOINT ( Semi SPOINT )+ ;

    SPOINT : ( SplineEnd )? ( SplineStart )? POINT ( POINT POINT POINT )+ ;

    HTML   : TagOpen ( TagOpen | TagClose | Html )* TagClose ;

    NUMBER : Minus? ( ( Dot ( Digit )+ ) | (Digit )+ ( Dot ( Digit )* )? ) ;

    ML_COMMENT : '/*' .*? '*/' ;
    SL_COMMENT : ( '//' | Pound ) ( EscSeq | ~[\r\n\\] )* | EOF ;

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

    VX	: Vws -> type(VWS), channel(HIDDEN) ;
    HX	: Hws -> type(HWS), channel(HIDDEN) ;

    ERR	: .	-> type(OTHER) ;

// endMode DOT

fragment CodeMark
	: '``' '`'+
	| '~~' '~'+
	;

fragment Vws : [\r\n\f]	;
fragment Hws : [ \t]	;
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

