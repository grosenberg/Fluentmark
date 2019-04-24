lexer grammar MdLexer ;

options {
	superClass = MdLexerBase ;
}

tokens {
	WORD
}

@header {
	package net.certiv.fluent.dt.core.lang.md.gen;
	import net.certiv.fluent.dt.core.lang.md.MdLexerBase;
}

HIDN_COMMENT : HidnComment ;
HTML_COMMENT : HtmlComment ;

META		: ( LN_BLANK | { bof() }? ) Dashes	{ !befBL() }? -> pushMode(Block_Meta) ;

TICS		: LN_BLANK Tics     -> pushMode(Block_Tics) ;
TILDES		: LN_BLANK Tildes   -> pushMode(Block_Tildes) ;
MATH_MARK	: LN_BLANK MathMark -> pushMode(Block_Math) ;
TEX_BEG		: LN_BLANK TexBeg   -> pushMode(Block_Tex) ;
UML_BEG		: LN_BLANK UmlBeg	-> pushMode(Block_Uml) ;

LIST_ITEM 	: ListMark TaskMark? { bol() }? ;
TABLE_DEF 	: Pipe? ColDef ( Pipe ColDef )+ Pipe? { bol() }? ;
DEFINITION	: Colon { bol() }? ;

HRULE	  : LN_BLANK ( Stars | Dashes | Unders ) ;

DASHES	  : Dashes   { bol() }? ;
DOTS	  : Dots     { bol() }? ;
HASHES	  : Hash+    { bol() }? ;
EQUALS	  : Equals   { bol() }? ;
QUOTES	  : RAngle+  { bol() }? ;

UNICODE		: Unicode	  ;
ENTITY		: Entity	  ;
TEX			: TexRaw      ;
HTML		: HtmlPhrase+ ;
INMATH		: InlineMath  ;
URL			: Scheme? UrlPath | LAngle Scheme? UrlPath RAngle ;

// edge specific delimiters
LBOLD	: ( '**' | '__' )	{ leftEdge(2) }? ;
LITALIC	: ( '*'  | '_'  )	{ leftEdge(1) }? ;
LSTRIKE	: '~~'				{ leftEdge(2) }? ;
LSPAN	: '`'				{ leftEdge(1) }? ;
LDQUOTE	: '"'				{ leftEdge(1) }? ;
LSQUOTE	: '\''				{ leftEdge(1) }? ;

RBOLD	: ( '**' | '__' ) 	{ rightEdge(2) }? ;
RITALIC	: ( '*'  | '_'  ) 	{ rightEdge(1) }? ;
RSTRIKE	: '~~'				{ rightEdge(2) }? ;
RSPAN	: '`'				{ rightEdge(1) }? ;
RDQUOTE	: '"'				{ rightEdge(1) }? ;
RSQUOTE	: '\''				{ rightEdge(1) }? ;

LSTYLE	: LBrace 	{ style() }? -> pushMode(Style) ;
LINK	: LBrack	{ link()  }? -> pushMode(Link) ;
LREF	: LBrack	{ lRef()  }? -> pushMode(Link) ; 
LURL	: LBrack	{ lUrl()  }? -> pushMode(Link) ;
LDEF	: LBrack	{ lDef()  }? -> pushMode(Link) ;

HASH	: Hash { inHeader() }? ;
PIPE	: Pipe { inTable()  }? ;

LN_BLANK : Hws* Vws (( Hws* Vws )+ | EOF ) ;
LN_BREAK : Spc Spc Vws					   ;

VWS	: Vws -> channel(HIDDEN) ;
HWS	: Hws -> channel(HIDDEN) ;

CHAR : Char  { more(WORD); } ;
ERR	 : . ;


mode Style;
	RSTYLE : RBrace -> popMode ;

	CLASS : Dot	  ;
	ID	  : Hash  ;
	EQ	  : Equal ;
	QUOTE : Quote ;
	MARK  : Mark  ;

	HWS_sd	: Hws -> type(HWS), channel(HIDDEN) ;
	CHAR_sd	: Char  { more(WORD); }				;


// [word](URL "title")
// [word][ref]
// [URL] 
// [ref]: URL "title"
mode Link ;
	LINK_MARK : RBrack Spc? LParen ;
	REF_MARK  : RBrack Spc? LBrack ;
	DEF_MARK  : RBrack Spc? Colon -> popMode ;
 	RBRACK	  : RBrack -> popMode ; 
	RPAREN	  : RParen -> popMode ;
	
	URL_l	: Scheme? UrlPath -> type(URL) ;
 	QUOTE_l : Quote -> type(QUOTE) ;
 
	HWS_l	: Hws -> type(HWS), channel(HIDDEN) ;
	CHAR_l	: Char  { more(WORD); }				;


mode Block_Tics ;
	TICS_b		: Tics   { bol() }?   -> type(TICS), popMode ;
	LSTYLE_b	: LBrace { style() }? -> type(LSTYLE), pushMode(Style) ;
	
	VWS_b		: Vws  -> type(VWS) ;
	HWS_b		: Hws  -> type(HWS), channel(HIDDEN) ;
	WORD_b		: Char { more(WORD); } ;


mode Block_Tildes ;
	TILDES_t	: Tildes { bol() }?   -> type(TILDES), popMode ;
	LSTYLE_t	: LBrace { style() }? -> type(LSTYLE), pushMode(Style) ;
	
	VWS_t		: Vws  -> type(VWS) ;
	HWS_t		: Hws  -> type(HWS), channel(HIDDEN) ;
	WORD_t		: Char { more(WORD); } ;


mode Block_Meta ;
	META_y		: ( Dashes | DOTS ) { bol() }? -> type(META), popMode ;
	
	VWS_y		: Vws  -> type(VWS) ;
	HWS_y		: Hws  -> type(HWS), channel(HIDDEN) ;
	WORD_y		: Char { more(WORD); } ;


mode Block_Math ;
	MATH_m		: MathMark { bol() }? -> type(MATH_MARK), popMode ;
	
	VWS_m		: Vws  -> type(VWS), channel(HIDDEN) ;
	HWS_m		: Hws  -> type(HWS), channel(HIDDEN) ;
	WORD_m		: Char { more(WORD); } ;


mode Block_Tex ;
	TEX_END		: TexEnd { bol() }? -> popMode ;
	
	VWS_x		: Vws  -> type(VWS), channel(HIDDEN) ;
	HWS_x		: Hws  -> type(HWS), channel(HIDDEN) ;
	WORD_x		: Char { more(WORD); } ;

mode Block_Uml ;
	UML_END		: UmlEnd { bol() }? -> popMode ;

	VWS_u		: Vws  -> type(VWS), channel(HIDDEN) ;
	HWS_u		: Hws  -> type(HWS), channel(HIDDEN) ;
	WORD_u		: Char { more(WORD); } ;


// ------------------------

fragment ListMark  : Hws* ( BasicMark | FancyMark | ParenMark ) Hws ;
fragment BasicMark : [*+-] | [0-9]+ Dot ;
fragment FancyMark : Hash Dot | Letter* LAlpha Dot | Letter* UAlpha Dot Spc	;
fragment ParenMark : LParen? Alphanum+ RParen ;
fragment TaskMark  : LBrack [ a-zA-Z0-9_]? RBrack Hws ;

fragment Scheme	 : Letter ( Alphanum | Dash )* '://' ;
fragment UrlPath : UrlBase UrlFrag? ;
fragment UrlBase : 'www'? [/.]* UrlTerm ( Dot UrlTerm )+ Slash? ;
fragment UrlFrag : ([#?&@=/:.-] | UrlTerm )* ( Alphanum | HexChar ) Slash? ;
fragment UrlTerm : ( Letter | HexChar ) ( Alphanum | HexChar )*	;

fragment HexChar : Percent HexDigit HexDigit ;

fragment Dashes	: '--' '-'+ ;
fragment Dots	: '..' '.'+ ;
fragment Equals	: '==' '='+ ;
fragment Stars	: '**' '*'+ ;
fragment Unders	: '__' '_'+ ;
fragment Tics	: '``' '`'+ ;
fragment Tildes	: '~~' '~'+ ;

fragment MathMark	: '$$' ;
fragment InlineMath : Dollar NotWs ( NotVws* NotWs )? Dollar ;

fragment ColDef : Colon? Dashes Colon? ;

fragment HtmlPhrase
	: OpenTag ( HtmlPhrase | EscSeq | ~'<' )+ CloseTag
	| AutoTag
	;

fragment OpenTag  : LAngle Letter+ RAngle		 ;
fragment CloseTag : LAngle Slash Letter+ RAngle	 ;
fragment AutoTag  : LAngle Letter+ Slash RAngle ;

// may be pandoc specific
fragment HidnComment : '<!---' .*? '-->' ;
fragment HtmlComment : '<!--'  .*? '-->' ;

fragment Hws : Spc+ | '\t' ;
fragment Vws : '\r'? '\n' ;
fragment Spc : ' ' ;

fragment TexBeg : Esc 'begin' ( BBrack | BBrace )* ;
fragment TexEnd : Esc 'end'	  ( BBrack | BBrace )* ;
fragment TexRaw : Esc Letter  ( Letter | Digit | TexSym )* ( BBrack | BBrace )* ;
fragment TexSym : [!/_-] ;

fragment UmlBeg : '@startuml' | '@startdot' ;
fragment UmlEnd : '@enduml' | '@enddot' ;

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

fragment BBrace	: LBrace ( EscSeq | BBrace | ~[{}\r\n\\] )* RBrace ;
fragment BBrack : LBrack ( EscSeq | ~[\]\r\n\\] )* RBrack ;

fragment NotWs	: ( EscSeq | ~[ \t\r\n\f\\] ) ;
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
fragment Mark		: '\'' ;
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
