lexer grammar MdLexer ;

options {
	superClass = LexerAdaptor ;
}

tokens {
	WORD,
	LINE
}

@header {
	package net.certiv.fluentmark.core.md.parser.gen;
	import net.certiv.fluentmark.core.md.parser.LexerAdaptor;
}

ML_COMMENT	  : BlockComment ;
HTML_COMMENT  : HtmlComment ;

FRONT_MATTER  : { bof()  }? Dashes	 -> pushMode(frontMatter) ;
CODE_BLOCK_BT : { term() }? BTicks	 -> pushMode(codeBlockBT) ;
CODE_BLOCK_TD : { term() }? Tildes	 -> pushMode(codeBlockTD) ;
MATH_BLOCK	  : { term() }? MathMark -> pushMode(mathBlock)	  ;

HEADER : { term() }? Hash+ -> pushMode(hdrText) ;
SEMARK : { !term() }? ( Equals | Dashes ) ;

LIST_ITEM : { bol() }? ListMark TaskMark? ;

QUOTE_BLOCK	: { term() }? RAngle+ ;

DEFINE_BLOCK : { bol() }? Colon ;

HRULE : { term() }? ( Stars | Dashes | UScores ) ;

HTML  : { term() }? HtmlPhrase+ ;

TABLE_DEF : { bol() }? Pipe? ColDef ( Pipe ColDef )+ Pipe? ;

UNICODE	: Unicode ;
ENTITY	: Entity  ;
IMAGE	: Bang LBrack ;

LBRACK	: LBrack ;
RBRACK	: RBrack ;
LBRACE	: LBrace ;
RBRACE	: RBrace ;
LPAREN	: LParen ;
RPAREN	: RParen ;
PIPE	: Pipe	;
QUOTE	: Quote ;

LBOLD	: Bold   { left() }? ;
LITALIC	: Italic { left() }? ;
LSTRIKE	: Strike { left() }? ;
RBOLD	: Bold   { right() }? ;
RITALIC	: Italic { right() }? ;
RSTRIKE	: Strike { right() }? ;

INCODE : BackTic ;
INMATH : Dollar NotWs ( NotVws* NotWs)? Dollar	;

TERM : { bol() }? Vws ( Vws | EOF ) ;
VWS	 : Vws -> channel(HIDDEN) ;
HWS	 : Hws -> channel(HIDDEN) ;

CHAR : Char  { more(WORD); }	;

ERR	: . ;

mode hdrText;
	STYLE_ht  : LBrace { closed('}') }? -> type(LBRACE), pushMode(styleDef)	  ;
	LBRACK_ht : LBrack { closed(']') }? -> type(LBRACK), pushMode(linkDef)	  ;
	IMAGE_ht  : Bang LBrack { closed(']') }? -> type(IMAGE), pushMode(linkDef) ;

	HASH	  : Hash ;
	UCODE_ht  : Unicode -> type(UNICODE) ;
	ENTITY_ht : Entity	-> type(ENTITY)	 ;

	LBOLD_ht   : Bold   { left() }?  -> type(LBOLD)   ;
	LITALIC_ht : Italic { left() }?  -> type(LITALIC) ;
	LSTRIKE_ht : Strike { left() }?  -> type(LSTRIKE) ;

	RBOLD_ht   : Bold   { right() }? -> type(RBOLD)   ;
	RITALIC_ht : Italic { right() }? -> type(RITALIC) ;
	RSTRIKE_ht : Strike { right() }? -> type(RSTRIKE) ;

	INMATH_ht : Dollar NotWs ( NotVws* NotWs )? Dollar -> type(INMATH) ;

	TERM_ht	: { bol() }? Vws ( Vws | EOF ) -> type(TERM), popMode ;
	VWS_ht	: Vws -> type(VWS), popMode, channel(HIDDEN)   ;
	HWS_ht	: Hws -> type(HWS), channel(HIDDEN)			   ;
	CHAR_ht	: Char  { more(WORD); }									   ;

mode styleDef;
	RBRACE_sd : RBrace -> type(RBRACE), popMode	;
	CLASS : Dot	  ;
	ID	  : Hash  ;
	EQ	  : Equal ;
	QUOTE_sd : Quote ->type(QUOTE);
	TIC	  : Tic	  ;
	HWS_sd	: Hws -> type(HWS), channel(HIDDEN) ;
	VWS_sd	: Vws -> type(ERR), channel(HIDDEN) ;
	CHAR_sd	: Char  { more(WORD); }							;

mode linkDef;
	LBRACK_ld : LBrack -> type(LBRACK), pushMode(linkDef)	  ;
	IMAGE_ld  : Bang LBrack -> type(IMAGE), pushMode(linkDef) ;

	RBRACK_ld1 : RBrack { contLink() }? -> type(RBRACK)			 ;
	RBRACK_ld2 : RBrack		-> type(RBRACK), popMode ;

	LPAREN_ld  : LParen -> type(LPAREN)			 ;
	RPAREN_ld2 : RParen -> type(RPAREN), popMode ;

	CHAR_ld	: Char  { more(WORD); } ;
	HWS_ld	: Hws -> type(HWS), channel(HIDDEN) ;
	VWS_ld	: Vws -> type(VWS), channel(HIDDEN) ;

mode frontMatter;
	FM_fm : { bol() }? Dashes -> type(FRONT_MATTER), popMode ;

	VWS_fm	: Vws -> type(VWS), channel(HIDDEN) ;
	CHAR_fm	: ~[\r\n]	{ more(LINE); }						;

mode codeBlockBT;
	CB_bt : { bol() }? BTicks -> type(CODE_BLOCK_BT), popMode ;

	VWS_bt	: Vws -> type(VWS), channel(HIDDEN) ;
CHAR_bt	: ~[\r\n]	{ more(LINE); }						;

mode codeBlockTD;
	CB_td : { bol() }? Tildes -> type(CODE_BLOCK_TD), popMode ;

	VWS_td	: Vws -> type(VWS), channel(HIDDEN) ;
	CHAR_td	: ~[\r\n]	{ more(LINE); }						;

mode mathBlock;
	MB_mb : { bol() }? MathMark -> type(MATH_BLOCK), popMode ;

	VWS_mb	: Vws -> type(VWS), channel(HIDDEN) ;
	CHAR_mb	: ~[\r\n]	{ more(LINE); }						;

// ------------------------

fragment ListMark : ( [*+-] | [0-9] Dot ) Hws ;
fragment TaskMark : LBrack [ a-zA-Z0-9_]? RBrack Hws ;

fragment Dashes	  : '--' '-'+ ;
fragment Equals	  : '==' '='+ ;
fragment Stars	  : '**' '*'+ ;
fragment UScores  : '__' '_'+ ;
fragment BTicks	  : '``' '`'+ ;
fragment Tildes	  : '~~' '~'+ ;

fragment Bold   : '**' | '__' ;
fragment Italic : '*' | '_' ;
fragment Strike : '~~' ;

fragment MathMark : '$$' ;

fragment ColDef : Colon? Dashes Colon? ;

fragment HtmlPhrase
	: OpenTag ( HtmlPhrase | .? )* CloseTag
	| AutoTag
	;

fragment OpenTag  : LAngle Letter+ RAngle		 ;
fragment CloseTag : LAngle Slash Letter+ RAngle	 ;
fragment AutoTag  : LAngle Letter+ Slash? RAngle ;

fragment BlockComment
	: '/*' .*? '*/'
	;

fragment HtmlComment
	: '<!--' .*? '-->'
	;

fragment Hws : ' '+ | '\t' ;
fragment Vws : '\r'? '\n'  ;

fragment Letter : UAlpha | LAlpha ;
fragment UAlpha : [A-Z]			  ;
fragment LAlpha : [a-z]			  ;

// all chars except control & ws
fragment Char
	: '\u0021'..'\u007E'
	| '\u00A0'..'\u00FF'
	| '\u0100'..'\u02FF'
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

fragment Digit	  : [0-9]		;
fragment HexDigit : [0-9a-fA-F]	;

fragment Unicode : Esc UnicodeEsc ;
fragment UnicodeEsc
	:	'u' (HexDigit (HexDigit (HexDigit HexDigit?	)? )? )?
	;

fragment Entity
	: '&#' Digit+ Semi
	| '&#' [xX] HexDigit+ Semi
	| '&' Letter ( Letter | Digit )+ Semi
	;

fragment NotWs  : ( EscSeq | ~[ \t\r\n\f\\] ) ;
fragment NotVws	: ( EscSeq | ~[\r\n\f\\]	) ;

fragment EscSeq
	:	Esc
		( [btnfr"'\\]	// Standard escaped character set such as tab, newline, etc.
		| UnicodeEsc	// Unicode escape sequence
		| .				// Other escaped character
		| EOF			// Incomplete at EOF
		)
	;

fragment Quote		: '"'  ;
fragment Tic		: '\'' ;
fragment BackTic	: '`'  ;
fragment Tilde		: '~'  ;
fragment Esc		: '\\' ;
fragment Dot		: '.'  ;
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

