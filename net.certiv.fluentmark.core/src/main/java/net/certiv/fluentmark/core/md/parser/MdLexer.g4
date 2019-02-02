lexer grammar MdLexer ;

options {
	superClass = LexerAdaptor ;
}

tokens {
	WORD,
	LINE,
	IMAGE,
	LINK,
	LINK_REF
}

@header {
	package net.certiv.fluentmark.core.md.parser.gen;
	import net.certiv.fluentmark.core.md.parser.LexerAdaptor;
}

INVS_COMMENT  : InvisibleComment ;
HTML_COMMENT  : HtmlComment ;

FRONT_MATTER  : { bof()  }? Dashes	 -> pushMode(frontMatter) ;
CODE_BLOCK_BT : { aftTerm() }? BTicks	 -> pushMode(codeBlockBT) ;
CODE_BLOCK_TD : { aftTerm() }? Tildes	 -> pushMode(codeBlockTD) ;
MATH_BLOCK	  : { aftTerm() }? MathMark -> pushMode(mathBlock)	  ;
TEX_BEG		  : { aftTerm() }? TexBeg   -> pushMode(texBlock)	  ;

HEADER : { aftTerm() }? Hash+ -> pushMode(hdrText) ; 
SEMARK : { !aftTerm() && bol() }? ( Equals | Dashes ) ;

LIST_ITEM : { bol() }? ListMark TaskMark? ;

QUOTE_BLOCK	: { aftTerm() }? RAngle+ ;

DEFINE_BLOCK : { bol() }? Colon ;

HRULE : { aftTerm() }? ( Stars | Dashes | UScores ) { befTerm() }? ;

TABLE_DEF : { bol() }? Pipe? ColDef ( Pipe ColDef )+ Pipe? ;
PIPE	: Pipe	;

UNICODE	: Unicode ;
ENTITY	: Entity  ;
TEX		: TexRaw  ;
HTML	: HtmlPhrase+ ;
INMATH  : InlineMath ;
URL		: Scheme? UrlPath | LAngle Scheme? UrlPath RAngle ;

LBOLD	 : Bold   { left() }? ;
LITALIC	 : Italic { left() }? ;
LSTRIKE	 : Strike { left() }? ;
LSPAN	 : Tic+ { left() }? ;
LQUOTE	 : Quote { left() }? ;
LAPSTP	 : Apostrophe { left() }? ;

RBOLD	 : Bold   { right() }? ;
RITALIC	 : Italic { right() }? ;
RSTRIKE	 : Strike { right() }? ;
RSPAN	 : Tic+ { right() }? ;
RQUOTE	 : Quote { right() }? ;
RAPSTP	 : Apostrophe { right() }? ;

REF 	 : LBrack { linkRef() }? -> pushMode(linkSpec) ; 
LINK	 : LBrack { link() }?    -> pushMode(linkSpec) ;
LBRACK	 : LBrack -> type(WORD) ;

IMAGE	 : Bang { link() }? -> pushMode(linkSpec) ;
BANG	 : Bang -> type(WORD) ;

TERM	: ( Spc Spc )? Vws ( Vws+ | EOF ) ;
LBRK	: Spc Spc Vws ;

VWS		: Vws -> channel(HIDDEN) ;
HWS		: Hws -> channel(HIDDEN) ;

CHAR : Char  { more(WORD); }	;
ERR	: . ;


mode hdrText;
	LBRACE	  : LBrace -> pushMode(styleSpec) ;
	
	UNICODE_ht	: Unicode -> type(UNICODE) ;
	ENTITY_ht	: Entity  -> type(ENTITY) ;
	TEX_ht		: TexRaw  -> type(TEX) ;
	HTML_ht		: HtmlPhrase+ -> type(HTML) ;
	INMATH_ht	: InlineMath	-> type(INMATH) ;
	HASH		: Hash	;
	
	LBOLD_ht	: Bold   { left() }? -> type(LBOLD) ;
	LITALIC_ht	: Italic { left() }? -> type(LITALIC) ;
	LSTRIKE_ht	: Strike { left() }? -> type(LSTRIKE) ;
	LSPAN_ht	: Tic+ { left() }? -> type(LSPAN) ;
	LQUOTE_ht	: Quote { left() }? -> type(LQUOTE) ;
	LAPSTP_ht	: Apostrophe { left() }? -> type(LAPSTP) ;

	RBOLD_ht	: Bold   { right() }? -> type(RBOLD) ;
	RITALIC_ht	: Italic { right() }? -> type(RITALIC) ;
	RSTRIKE_ht	: Strike { right() }? -> type(RSTRIKE) ;
	RSPAN_ht	: Tic+ { right() }? -> type(RSPAN) ;
	RQUOTE_ht	: Quote { right() }? -> type(RQUOTE) ;
	RAPSTP_ht	: Apostrophe { right() }? -> type(RAPSTP) ;

	REF_ht 		: LBrack { linkRef() }? -> type(REF), pushMode(linkSpec) ; 
	LINK_ht		: LBrack { link() }?    -> type(LINK), pushMode(linkSpec) ;
	LBRACK_ht	: LBrack -> type(WORD) ;

	IMAGE_ht	: Bang { link() }? -> type(IMAGE), pushMode(linkSpec) ;
	BANG_ht	 	: Bang -> type(WORD) ;

	TERM_ht	: Vws ( Vws | EOF ) -> type(TERM), popMode ;
	VWS_ht	: Vws -> type(VWS), popMode, channel(HIDDEN)   ;
	HWS_ht	: Hws -> type(HWS), channel(HIDDEN)			   ;
	CHAR_ht	: Char  { more(WORD); }						   ;


mode styleSpec;
	RBRACE : RBrace -> popMode ;

	CLASS : Dot	  ;
	ID	  : Hash  ;
	EQ	  : Equal ;
	QUOTE : Quote ;
	APSTP : Apostrophe ;

	HWS_sd	: Hws -> type(HWS), channel(HIDDEN) ;
	VWS_sd	: Vws -> type(ERR), channel(HIDDEN) ;
	CHAR_sd	: Char  { more(WORD); }				;


mode linkSpec ;
	LINK_DEF : RBrack [ ]? LParen ;
	LINK_REF : RBrack [ ]? LBrack ;
	REF_DEF	 : RBrack [ ]? Colon -> popMode ;
	
	URL_lk	 : Scheme? UrlPath -> type(URL) ;
 	QUOTE_lk : Quote -> type(QUOTE) ;
 
 	RBRACK	: RBrack -> popMode ; 
	RPAREN	: RParen -> popMode ;

	HWS_lk	: Hws -> type(HWS), channel(HIDDEN) ;
	VWS_lk	: Vws -> type(ERR), channel(HIDDEN) ;
	CHAR_lk	: Char  { more(WORD); }				;


mode frontMatter;
	FM_fm : { bol() }? ( Dashes | Dots ) -> type(FRONT_MATTER), popMode ;

	VWS_fm	: Vws -> type(VWS), channel(HIDDEN) ;
	CHAR_fm	: ~[\r\n]	{ more(LINE); }			;


mode codeBlockBT;
	CB_bt	: { bol() }? BTicks -> type(CODE_BLOCK_BT), popMode ;
	VWS_bt	: Vws -> type(VWS), channel(HIDDEN), mode(codeBlockBTLines) ;

	LBRACE_bt	: LBrace -> type(LBRACE), pushMode(styleSpec) ;

	HWS_bt	: Hws -> type(HWS), channel(HIDDEN) ;
	CHAR_bt	: Char  { more(WORD); }				;

mode codeBlockBTLines;
	CB_btl 		: { bol() }? BTicks -> type(CODE_BLOCK_BT), popMode ;

	VWS_btl		: Vws -> type(VWS), channel(HIDDEN) ;
	CHAR_btl	: ( Char | Hws )	{ more(LINE); }	;


mode codeBlockTD;
	CB_td : { bol() }? Tildes -> type(CODE_BLOCK_TD), popMode ;
	VWS_td	: Vws -> type(VWS), channel(HIDDEN), mode(codeBlockTDLines) ;

	LBRACE_td	: LBrace -> type(LBRACE), pushMode(styleSpec) ;

	HWS_td	: Hws -> type(HWS), channel(HIDDEN) ;
	CHAR_td	: Char  { more(WORD); }				;

mode codeBlockTDLines;
	CB_tdl 		: { bol() }? Tildes -> type(CODE_BLOCK_TD), popMode ;

	VWS_tdl		: Vws -> type(VWS), channel(HIDDEN) ;
	CHAR_tdl	: ( Char | Hws ) { more(LINE); }	;


mode mathBlock;
	MB_mb : { bol() }? MathMark -> type(MATH_BLOCK), popMode ;

	VWS_mb	: Vws -> type(VWS), channel(HIDDEN) ;
	CHAR_mb	: ( Char | Hws ) { more(LINE); }	;

mode texBlock;
	TEX_END : { bol() }? TexEnd -> popMode ;

	VWS_tb	: Vws -> type(VWS), channel(HIDDEN) ;
	CHAR_tb	: ( Char | Hws ) { more(LINE); }	;

// ------------------------

fragment ListMark  : Hws* ( BasicMark | FancyMark | ParenMark ) Hws ;
fragment BasicMark : [*+-] | [0-9]+ Dot ;
fragment FancyMark : Hash Dot | Letter* LAlpha Dot | Letter* UAlpha Dot Spc ;
fragment ParenMark : LParen? Alphanum+ RParen ;

fragment TaskMark : LBrack [ a-zA-Z0-9_]? RBrack Hws ;

fragment Scheme	 : Letter ( Alphanum | Dash )* '://' ;
fragment UrlPath : UrlBase UrlFrag? ;
fragment UrlBase : 'www'? [/.]* UrlTerm ( Dot UrlTerm )+ Slash? ;
fragment UrlFrag : ( [#?&@=/:.-] | UrlTerm )* ( Alphanum | HexChar ) Slash? ;
fragment UrlTerm : ( Letter | HexChar ) ( Alphanum | HexChar )* ;
fragment HexChar : Percent HexDigit HexDigit ;


fragment Dashes	  : '--' '-'+ ;
fragment Dots     : '..' '.'+ ;
fragment Equals	  : '==' '='+ ;
fragment Stars	  : '**' '*'+ ;
fragment UScores  : '__' '_'+ ;
fragment BTicks	  : '``' '`'+ ;
fragment Tildes	  : '~~' '~'+ ;

fragment Bold   : '**' | '__' ;
fragment Italic : '*' | '_' ;
fragment Strike : '~~' ;

fragment MathMark : '$$' ;
fragment InlineMath : Dollar NotWs ( NotVws* NotWs )? Dollar ;

fragment ColDef : Colon? Dashes Colon? ;

fragment HtmlPhrase
	: OpenTag ( HtmlPhrase | .? )* CloseTag
	| AutoTag
	;

fragment OpenTag  : LAngle Letter+ RAngle		 ;
fragment CloseTag : LAngle Slash Letter+ RAngle	 ;
fragment AutoTag  : LAngle Letter+ Slash? RAngle ;

fragment InvisibleComment	: '<!---' .*? '-->'	;  // may be pandoc specific
fragment HtmlComment		: '<!--'  .*? '-->'	;

fragment Spc : ' ' ;
fragment Hws : ' '+ | '\t' ;
fragment Vws : '\r'? '\n'  ;

fragment TexBeg : Esc 'begin' ( BBrack | BBrace )* ;
fragment TexEnd : Esc 'end'   ( BBrack | BBrace )* ;
fragment TexRaw : Esc Letter  ( Letter | Digit | TexSym )* ( BBrack | BBrace )* ;
fragment TexSym : [!/_-] ;

fragment Alphanum : Letter | Digit ;

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

fragment BBrace : LBrace ( EscSeq | BBrace | ~[{}\r\n\\] )* RBrace ;
fragment BBrack : LBrack ( EscSeq | ~[\]\r\n\\] )* RBrack ;

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
fragment Apostrophe	: '\'' ;
fragment Tic		: '`'  ;
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
