/*
 [The "BSD licence"]
 Copyright (c) 2014 Vlad Shlosberg
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

lexer grammar ScssLexer ;

options {
	superClass = LexerExt ; 
}

@header {
	package net.certiv.fluentmark.core.scss.parser.gen;
	import net.certiv.fluentmark.core.scss.parser.LexerExt;
}


NUMBER
	: Dash? Digit+ ( Dot Digit* )* { atNumber(); }
	;

UNIT
	: { aftNumber() }? 
		( 'px'	| 'cm'	| 'mm'   | 'in'
		| 'pt'	| 'pc'	| 'em'   | 'ex'
		| 'deg' | 'rad' | 'grad' | '%'
		| 'ms'	| 's'	| 'hz'   | 'khz' 
		)
	;

NULL    : 'null' ;
FROM	: 'from'	 ;
THROUGH	: 'through'	 ;
IN	    : 'in'   ;

MIXIN	 : '@mixin'	   ;
FUNCTION : '@function' ;
AT_ELSE	 : '@else'	   ;
IF		 : 'if'		   ;
AT_IF	 : '@if'	   ;
AT_FOR	 : '@for'	   ;
AT_WHILE : '@while'	   ;
AT_EACH	 : '@each'	   ;
INCLUDE	 : '@include'  ;
IMPORT	 : '@import'   ;
RETURN	 : '@return'   ;
DEFAULT	 : '!default' ;


INTERPOLATION_START
	: HASH LBrace -> pushMode(IDENTIFY)
	;

URL_BEG
	: 'url' LPAREN -> pushMode(URL_CONT)
	;

STRING
	: String
	;

COLOR
	: Hash HexDigit+
	;

IDENTIFIER
	: Dash? IdentBeg IdentBody* -> pushMode(IDENTIFY)
	;

LPAREN   : LParen ;
RPAREN   : RParen ;
LBRACE   : LBrace ;
RBRACE   : RBrace ;
LBRACK   : LBrack ;
RBRACK   : RBrack ;
GT	     : RAngle ;
TIL	     : Tilde ;
ELLIPSIS : Ellipsis	  ;
LT		 : LAngle  ;
COLON	 : Colon  ;
SEMI	 : Semi  ;
COMMA	 : Comma  ;
DOT		 : Dot  ;
DOLLAR	 : Dollar  ;
AT		 : At  ;
AND		 : Amp  ;
HASH	 : Hash  ;
PLUS	 : Plus  ;
TIMES	 : Star  ;
DIV		 : Slash  ;
MINUS	 : Dash  ;
PERC	 : Percent  ;
EQ		 : Equal ;
PIPE_EQ	 : '|='	;
TILD_EQ	 : '~='	;
EQIV     : '==' ;
NOTEQ    : '!=' ;

COMBINE_COMPARE : '&&' | '||' ;
COLONCOLON : '::' ;

WS	: ( Vws | Hws )	-> skip	;

LINE_COMMENT  : '//' .*? Vws -> skip  ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip	;

mode URL_CONT;
	URL_END : RPAREN -> popMode ;
	URL     : STRING | ~[)\n\r;]+ ;

mode IDENTIFY ;
	DOLLAR_ID : DOLLAR -> type(DOLLAR)			;
	WS_ID	  : WS	   -> popMode, skip			;

	InterpolationStartAfter	: Dash? IdentBeg IdentBody* -> pushMode(IDENTIFY) ;
	InterpolationEnd_ID		: RBrace -> type(RBRACE) ;

	IdentifierAfter	: IDENTIFIER ;

	LBRACE_ID : LBrace -> popMode, type(LBRACE)	;
	LPAREN_ID : LParen -> popMode, type(LPAREN)	;
	RPAREN_ID : RParen -> popMode, type(RPAREN) ;
	COLON_ID  : Colon -> popMode, type(COLON) ;
	COMMA_ID  : Comma -> popMode, type(COMMA) ;
	SEMI_ID	  : Semi -> popMode, type(SEMI)    ;
	DOT_ID	  : Dot -> popMode, type(DOT)			  ;
	ELLIP_ID  : Ellipsis -> popMode, type(ELLIPSIS) ;



// ------------------------

fragment Vws : [\r\n\f]+ ;
fragment Hws : [ \t]+ ;

fragment String
	: Quote  (EscSeq  | ~["\r\n\\] )* Quote
	| Apostrophe ( EscSeq | ~['\r\n\\] )* Apostrophe
	;

fragment IdentBeg  : Letter | UChar | Underscore ;
fragment IdentBody : IdentBeg | Digit | Dash  ;

// all chars above the ascii set
fragment UChar
	: '\u0100'..'\u02FF'
	| '\u0300'..'\u03FF'
	| '\u0400'..'\u1FFF'
	| '\u200B'..'\u200D'
	| '\u2010'..'\u2027'
	| '\u2030'..'\u205E'
	| '\u2070'..'\u2FFF'
	| '\u3001'..'\uD7FF'
	| '\uF900'..'\uFDCF'
	| '\uFDF0'..'\uFFFD'
	;

fragment Alphanum : Letter | Digit ;
fragment Letter	  : [a-zA-Z]	   ;
fragment Digit	  : [0-9]		   ;
fragment HexDigit : [0-9a-fA-F]	   ;

fragment Unicode : Esc UnicodeEsc ;
fragment UnicodeEsc
	:	'u' (HexDigit (HexDigit (HexDigit HexDigit?	)? )? )?
	;

fragment Entity
	: '&#' Digit+ Semi
	| '&#' [xX] HexDigit+ Semi
	| '&' Letter ( Letter | Digit )+ Semi
	;

fragment EscSeq
	:	Esc
		( [btnfr"'\\]	// Standard escaped character set such as tab, newline, etc.
		| UnicodeEsc	// Unicode escape sequence
		| .				// Other escaped character
		| EOF			// Incomplete at EOF
		)
	;

fragment Quote		: '"'  ;
fragment Apostrophe	: '\'' ;
fragment Tic		: '`'  ;
fragment Tilde		: '~'  ;
fragment Esc		: '\\' ;
fragment Dot		: '.'  ;
fragment Ellipsis	: '...';
fragment Comma		: ','  ;
fragment Colon		: ':'  ;
fragment Semi		: ';'  ;
fragment LParen		: '('  ;
fragment RParen		: ')'  ;
fragment LBrace		: '{'  ;
fragment RBrace		: '}'  ;
fragment LBrack		: '['  ;
fragment RBrack		: ']'  ;
fragment LAngle		: '<'  ;
fragment RAngle		: '>'  ;
fragment Question	: '?'  ;
fragment Bang		: '!'  ;
fragment Star		: '*'  ;
fragment Slash		: '/'  ;
fragment Hash		: '#'  ;
fragment Percent	: '%'  ;
fragment Caret		: '^'  ;
fragment Plus		: '+'  ;
fragment Dash		: '-'  ;
fragment Equal		: '='  ;
fragment Underscore	: '_'  ;
fragment Pipe		: '|'  ;
fragment Dollar		: '$'  ;
fragment At			: '@'  ;
fragment Amp		: '&'  ;
