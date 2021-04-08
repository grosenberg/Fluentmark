lexer grammar MdLexer ;

options {
	superClass = MdLexerBase ;
}

tokens {
	WORD,

	RBOLD,
	RITALIC,
	RSTRIKE,
	RDQUOTE,
	RSQUOTE
}

@header {
	package net.certiv.fluent.dt.core.lang.md.gen;
	import  net.certiv.fluent.dt.core.lang.md.MdLexerBase;
}

// ----------------------------------------------------------------------

COMMENT	: Comment ; 

// code blocks
CODE_BEG : Tics   { bob() }? -> pushMode(CodeTics)	;
CODE_TLD : Tildes { bob() }? -> type(CODE_BEG), pushMode(CodeTildes) ;

// html blocks
HTML_BLOCK_BEG : HtmlBlockBeg ;
HTML_BLOCK_END : HtmlBlockEnd ;

// other blocks
YAML_BLOCK : YamlBlock { bob() }? ;
DOT_BLOCK  : DotHead  Hws* ( Vws Hws* )?   DotBody  { bob() }? ;
MATH_BLOCK : MathMark ( EscSeq | ~[\\] )*? MathMark { bob() }? ;
TEX_BLOCK  : TexBeg   ( EscSeq | ~[\\] )*? TexEnd   { bob() }? ;
UML_BLOCK  : UmlBeg   ( EscSeq | ~[\\] )*? UmlEnd   { bob() }? ;

// spans
MATHS	: MathSpan { notDigit() }? ;
SPAN	: Span ;

// inline elements
LSTYLE	: LBrace { style() }? -> pushMode(Style) ;
URL		: Url	  ;
URLTAG	: UrlTag  ;
HTML	: HtmlTag ;
TEX		: TexRaw  ;
UNICODE	: Unicode ;
ENTITY	: Entity  ;

// links
IMAGE	: Bang LBrack 	{ link() }?	-> pushMode(Link) ;
FNOTE	: LBrack Caret	{ link() }? -> pushMode(Link) ;
LINK	: LBrack 		{ link() }? -> pushMode(Link) ;

// tables
TABLE : { bol() }? Pipe? ColDef ( Pipe ColDef )+ Pipe? ;
PIPE  : Pipe ;

// headings
HASHES : Hash+  { bob() }? ;
DASHES : Dashes { hdr() }? ;
EQUALS : Equals { hdr() }? ;

HRULE  : HRule  { bob() }? ;

// definition list
COLON  : Colon { hdr() }? ;

// list marks
BULLET_MARK	: { list() }? [*+-] TaskMark? Hws+ ;
NUMBER_MARK : { list() }? (Digit+ Dot | Hash Dot ) TaskMark? Hws+ ;
PAREN_MARK	: { list() }? LParen? Alphanum+ RParen TaskMark? Hws+ ;
UALPHA_MARK : { list() }? UAlpha Dot TaskMark? Hws+ ;
LALPHA_MARK	: { list() }? LAlpha Dot TaskMark? Hws+ ;

// attributes
LBOLD	: Bold   ;
LITALIC	: Italic ;
LSTRIKE	: Strike ;
LDQUOTE	: Quote	 ;
LSQUOTE	: Mark	 ;

BLOCKQUOTE	: { bol() }? BlockQuote	-> channel(HIDDEN) ;
LINE_DENT  	: { bol() }? Dent 		-> channel(HIDDEN) ;

LINE_BLANK : Vws ( Hws* Vws )+ ;
LINE_BREAK : Sp Sp Vws  ;

VWS	: Vws ;
HWS	: Hws -> channel(HIDDEN) ;

CHAR : ( EscChar | Char ) { more(WORD); } ;

// ----------------------------------------------------------------------

mode Header;
	HASH	 : Hash+ ;
	STYLE_h  : LBrace { style() }? -> type(LSTYLE), pushMode(Style) ;
	HWS_h    : Hws -> type(HWS), channel(HIDDEN) ;
	CHAR_h   : ( EscChar | Char ) { more(WORD); } ;

mode Style;
	RSTYLE : RBrace -> popMode ;
	CLASS  : Dot   ;
	ID	   : Hash  ;
	EQ	   : Equal ;
	DASH   : Dash  ;
	DQUOTE : Quote ;
	SQUOTE : Mark  ;
	HWS_s  : Hws -> type(HWS), channel(HIDDEN) ;
	CHAR_s : ( EscChar | Char ) { more(WORD); } ;

mode CodeTics;
	CODE_END : Vws BlockQuote? Tics -> popMode	;
	LSTYLE_c : LBrace { style() }? -> type(LSTYLE), pushMode(Style) ;
	VWS_c	 : Vws	-> type(VWS) ;
	HWS_c	 : Hws	-> type(HWS), channel(HIDDEN) ;
	CHR_c	 : ( Char | EscChar ) { more(WORD); } ;

mode CodeTildes;
	TILDES_t : Vws BlockQuote? Tildes -> type(CODE_END), popMode ;
	LSTYLE_t : LBrace { style() }? -> type(LSTYLE), pushMode(Style) ;
	VWS_t	 : Vws	-> type(VWS) ;
	HWS_t	 : Hws	-> type(HWS), channel(HIDDEN) ;
	CHR_t	 : ( Char | EscChar ) { more(WORD); } ;

mode Link ;
	IMAGE_l	: Bang LBrack -> type(IMAGE), pushMode(Link) ;
	LINK_l	: LBrack	  -> type(LINK),  pushMode(Link) ;

	LNK_SEP : RBrack Sp? LParen -> mode(Link_Std) ; // [...](...)
	LNK_REF	: RBrack Sp? LBrack -> mode(Link_Ref) ; // [...][...]
	LNK_DEF	: RBrack Sp? Colon  -> popMode ;		// [...]:...
	RBRACK	: RBrack 			-> popMode ;		// [...]

	URL_l	: Url 	  -> type(URL)  ;
	URLT_l	: UrlTag  -> type(URLTAG) ;
	SPAN_l	: Span	  -> type(SPAN) ;
	HTML_l	: HtmlTag -> type(HTML) ;
	TEX_l	: TexRaw  -> type(TEX)	;
	UCODE_l	: Unicode -> type(UNICODE) ;
	ENTY_l	: Entity  -> type(ENTITY) ;

	LBLD_l	: Bold 	  -> type(LBOLD) ;
	LITC_l	: Italic  -> type(LITALIC) ;
	LSTR_l	: Strike  -> type(LSTRIKE) ;
	LDQT_l	: Quote	  -> type(LDQUOTE) ;
	LSQT_l	: Mark	  -> type(LSQUOTE) ;

	VWS_l	: Vws -> type(VWS), channel(HIDDEN) ;
	HWS_l	: Hws -> type(HWS), channel(HIDDEN) ;
	CHR_l   : ( EscChar | Char ) { more(WORD); } ;

// [...](...)
mode Link_Std ;
	RPAREN	: RParen -> popMode ;

	URL_d	: Url	-> type(URL) ;
	DQT_d	: Quote	-> type(DQUOTE) ;
	SQT_d	: Mark	-> type(SQUOTE) ;
	
	VWS_d	: Vws -> type(VWS), channel(HIDDEN) ;
	HWS_d	: Hws -> type(HWS), channel(HIDDEN) ;
	CHR_d   : ( EscChar | Char ) { more(WORD); } ;

// [...][...]
mode Link_Ref ;
	RB_r	: RBrack -> type(RBRACK), popMode ;
	
	VWS_r	: Vws -> type(VWS), channel(HIDDEN) ;
	HWS_r	: Hws -> type(HWS), channel(HIDDEN) ;
	CHR_r   : ( EscChar | Char ) { more(WORD); } ;

// ----------------------------------------------------------------------

fragment TaskMark	: Sp1_3 LBrack [ a-zA-Z0-9_]? RBrack Hws+ ;
fragment BlockQuote	: Sp0_3 ( RAngle Sp? )* RAngle ;
fragment Dent  
	: Sp Sp Sp Sp 
	| Tab Sp Sp 
	| Sp Sp Tab 
	| Tab Tab 
	;

fragment Span
	: Tic2 ( EscSeq | ~[\r\n\f\\] )*? Tic2
	| Tic  ( EscSeq | ~[`\r\n\f\\] )*? Tic
	;

// ------------------------

fragment UrlTag : LAngle Url RAngle	;
fragment Url
	: UrlScheme? UrlHost UrlPath?
	| UrlPath
	| UrlFrag
	;

fragment UrlScheme	: Letter   ( Alphanum | [.+-] )+ '://'  ;
fragment UrlHost	: UrlUser? ( UrlName | UrlIp ) UrlPort? ;

fragment UrlPath	: UrlSegment+ UrlQuery? UrlFrag? ;
fragment UrlSegment	: '.'* '/' ( [%+._-] | Alphanum )* ;
fragment UrlQuery	: Question ( [%+=&;._-] | Alphanum )+  ;
fragment UrlFrag	: Hash ( [%+._-] | Alphanum )+ UrlSegment* ;

fragment UrlUser 	: ~[:@/ \t\r\n\f\\]+ Colon ~[:@/ \t\r\n\f\\]+ At ;
fragment UrlName	: UrlTerm ( Dot UrlTerm )+	;
fragment UrlTerm	: Letter ( Alphanum | [_-] )* ;
fragment UrlIp
	: Digit+ ( Dot Digit+ )+
	| LBrack HexDigit+ ( Colon HexDigit+ )+ RBrack
	;
fragment UrlPort : Colon Digit+	;

// ------------------------

fragment HRule
	: '--' '-'+
	| '- -' ' -'+
	| '**' '*'+
	| '* *' ' *'+
	| '__' '_'+
	;

fragment Dashes	: '--' '-'+	;
fragment Dots	: '..' '.'+ ;
fragment Equals	: '==' '='+	;
fragment Stars	: '**' '*'+ ;
fragment Unders	: '__' '_'+	;
fragment Tics	: '``' '`'+ ;
fragment Tildes	: '~~' '~'+	;
fragment Bold	: '**' | '__' ;
fragment Italic	: '*'  | '_'  ;
fragment Strike : '~~' ;

fragment MathMark : '$$' ;
fragment MathSpan : Dollar NotWs NotVws* Dollar	;

fragment NotWs	: ( EscSeq | ~[ \t\r\n\f\\] ) ;
fragment NotVws	: ( EscSeq | ~[\r\n\f\\]	) ;

fragment ColDef : Colon? Dashes Colon? ;

// HTML
// fragment HtmlBlock : AutoTag* HtmlStmt Html? ; 
// fragment Html : ( HtmlStmt | AutoTag )+ ;
// fragment HtmlStmt : OpenTag ( HtmlStmt | OpenTag | AutoTag | EscSeq | ~'<' ) CloseTag ;

fragment HtmlTag  : OpenTag | CloseTag | AutoTag ;
fragment HtmlBlockBeg : LAngle BlockName (HWS+ Attr)*? HWS* RAngle ;
fragment HtmlBlockEnd : LAngle Slash BlockName HWS* RAngle ;

fragment AutoTag  : LAngle Slash? AutoName (HWS+ Attr)*? HWS* Slash? RAngle ;
fragment OpenTag  : LAngle Letter+ (HWS+ Attr)*? HWS* RAngle ;
fragment CloseTag : LAngle Slash Letter+ HWS* RAngle ;

fragment Attr
	: Letter+ HWS* 
	  ( Equal HWS* 
	  	( Quote .*? Quote
	  	| Mark .*? Mark
	  	| [0-9a-zA-Z_./+,?=:;#-]+
	  	| Hash HexDigit+
	  	| Digit+ Percent?
	  	)
	  )?
	;
	
fragment AutoName
	: 'p' | 'dt' | 'dd' | 'li' | 'br' | 'hr' | 'wbr'
	| 'th' | 'tbody' | 'tr' | 'td' | 'tfoot' | 'colgroup' | 'col'
	| 'html' | 'head' | 'body' | 'meta' | 'base' | 'link'
	| 'option' | 'thead' | 'img' | 'input' | 'area'
	| 'embed' | 'param'| 'source' | 'track'
	;


fragment BlockName
	: 'div' | 'ul' | 'ol' | 'pre' | 'dd' | 'dl' | 'dt' 
	| 'blockquote' | 'figcaption' | 'figure' | 'table' | 'tfoot' 
	| 'address' | 'article' | 'aside' | 'footer' | 'form' 
	| 'header' | 'main' | 'nav' | 'section' | 'button' 
	| 'fieldset' | 'optgroup' | 'select'
	| 'canvas'  | 'video' | 'noscript' 
	;

// DOT
fragment DotHead  : ( 'strict' Hws+ )? 'di'? 'graph' Hws+ DotID ;
fragment DotBody
	: LBrace ( DotBody | EscSeq | ~[}\\] )+ RBrace 
	;
fragment DotID
	: Letter ( Alphanum | '_' )*
	| Quote  ( EscSeq | ~["\r\n\\] )* Quote
	| Dash?  ( Dot Digit+ | Digit+ ( Dot Digit* )? )
	;

// YAML
fragment YamlBlock : YamlBeg ( YamlKey ( YamlVal )* )+ YamlEnd ;

fragment YamlBeg : Dashes ( Hws* Vws )+	;
fragment YamlKey : Char+ Colon .*? ( Hws* Vws )+ ;
fragment YamlVal : ( ( Sp Sp | Tab )+ | '- ' ) .*? ( Hws* Vws )+ ;
fragment YamlEnd : ( Dashes | Dots ) Hws* Vws ;

fragment Comment : '<!--' .*? '-->' ;

// edge specific delimiters
fragment Delimiters : [*_~`"] ;
fragment Tab : '\t' ;
fragment Vws : '\r'? '\n' ;
fragment Hws : Sp | Tab ;

fragment Sp    : ' '  ;
fragment Sp1_3 : Sp ( Sp Sp? )? ;
fragment Sp0_3 : Sp1_3? ;

fragment TexBeg : Esc 'begin' ( BBrack | BBrace )* ;
fragment TexEnd : Esc 'end'	  ( BBrack | BBrace )* ;

fragment TexRaw : Esc Letter ( Letter | Digit | TexSym )* ( BBrack | BBrace )* ;
fragment TexSym	: [!/_-] ;
fragment UmlBeg : '@start' Letter Letter Letter+ ;
fragment UmlEnd : '@end' Letter Letter Letter+	 ;

fragment Alphanum : Letter | Digit  ;
fragment Letter	  : UAlpha | LAlpha	;
fragment UAlpha	  : [A-Z] ;
fragment LAlpha	  : [a-z] ;

fragment EscChar  : Esc Char ;

// all chars except control & whitespaces
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
fragment Tic2		: '``' ;
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
