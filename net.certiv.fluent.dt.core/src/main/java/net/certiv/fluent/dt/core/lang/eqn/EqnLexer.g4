lexer grammar EqnLexer ;

options {
	superClass = LexerBase;
}
    
@header {
	package net.certiv.fluent.dt.core.lang.eqn.gen;
	import net.certiv.fluent.dt.core.lang.eqn.LexerBase; 
}

EQN_BEG : EqnMarkBeg { at() }? -> type(OTHER), pushMode(EQN)	;
EQN_END	: EqnMarkEnd { at() }? -> type(OTHER)	;

VWS	: Vws -> channel(HIDDEN) ;
HWS	: Hws -> channel(HIDDEN) ;

OTHER : . ;

mode EQN;
    GRAPH	: ( 'strict' Hws+ )? ( 'graph' | 'digraph' ) { at() }? ;
	EQNEND	: EqnMarkEnd { at() }? -> type(OTHER), popMode ;

    NUMBER : Minus? ( ( Eqn ( Digit )+ ) | (Digit )+ ( Eqn ( Digit )* )? ) ;

    LITERAL	: Literal ;

    TILDE	: Tilde ;
    CAROT	: Carot ;
    LBRACE	: '{' ;
    RBRACE	: '}' ;

    ID  : Alpha ( Alpha | Digit )* ;

    VX	: Vws -> type(VWS), channel(HIDDEN) ;
    HX	: Hws -> type(HWS), channel(HIDDEN) ;

    ERR	: .	-> type(OTHER) ;

// endMode EQN

fragment EqnMarkBeg : '.EQ' ;
fragment EqnMarkEnd : '.EN'	;

fragment Vws : [\r\n\f]	;
fragment Hws : [ \t]	;
fragment Alpha
	:   [a-zA-Z_]
	| '\u0080'..'\u00FF'
	;

fragment Literal	: Quote ( EscSeq | ~["\r\n\\] )* Quote	;

fragment Decimal  : [+-]? UDecimal	  ;
fragment UDecimal : Digit+ Eqn Digit* ;
fragment Fract	  : '0' Eqn Digit+	  ;

fragment Digit	  : [0-9]						;
fragment HexDigit : [0-9a-fA-F]					;
fragment HsvDigit : [0-1] Eqn Digit Digit Digit	;

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

