lexer grammar MdLexer ;

options {
	superClass = MdLexerBase ;
}

tokens {
	WORD,

	CODE_BEG,
	CODE_END,
	CODE_TYPE,
	CODE_LINE,
	CODE_DENT,
	CODE_BLANK,

	QUOTE_BLANK,
	QUOTE_DENT,

	ESC_SQUOTE,
	ESC_DQUOTE,

	LBOLD,
	LITALIC,
	LSTRIKE,
	LDQUOTE,
	LSQUOTE,
	
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
CODE_TIC : Tics   { bob() }? -> type(CODE_BEG), pushMode(CodeTics)	;
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

// headings
HASHES : Hash+  { bob() }? ;
SETEXT : SeText { hdr() }? ;

// horizontal rule
HRULE  : HRule  { hrule() }? ;

// definition list
DEFINE : Colon { define() }? ;

// tables
TABLE_DEF : TblDef { bol() }? ;
PIPE  	  : Pipe ;

// list marks
BULLET_MARK	: [*+-] { isListMark() }? ;
NUMBER_MARK : Alphanum ( Dot | RParen ) { isListMark() }? ;
TASK_MARK	: TaskMark { isTaskMark() }? ;

// links
LNK_IMG	: Bang LBrack  ;	// ![...](...)
LNK_FN	: LBrack Caret ;	// [^...](...)
LNK_SEP : RBrack LParen ;	// [...](...)
LNK_REF	: RBrack LBrack ;	// [...][...]
LNK_DEF	: RBrack Colon  ;	// [...]:...

LBRACK	: LBrack ;
RBRACK	: RBrack ;
LPAREN	: LParen ;
RPAREN	: RParen ; 

// possible attributes
BOLD	: Bold   { attr() }? ;
ITALIC	: Italic { attr() }? ;
STRIKE	: Strike { attr() }? ;

DQUOTE	: Quote	 { dquote() }? ;
SQUOTE	: Mark	 { squote() }? ;

LINE_BLANK : Vws ( Hws* Vws )+ ;
LINE_BREAK : Sp Sp Vws  ;

LINE_DENT
	: BlockQuote { dents() }?
	| Hws+ 	 	 { dents() }? 
	;

VWS	: Vws ;
HWS	: Hws -> channel(HIDDEN) ;

CHAR : ( EscChar | Char ) { more(WORD); } ;

// ----------------------------------------------------------------------

mode Style;
	RSTYLE   : RBrace -> popMode ;
	CLASS    : Dot   ;
	ID	     : Hash  ;
	EQ	     : Equal ;
	DASH     : Dash  ;
	DQUOTE_s : Quote -> type(DQUOTE) ;
	SQUOTE_s : Mark  -> type(SQUOTE) ;
	HWS_s    : Hws -> type(HWS), channel(HIDDEN) ;
	CHAR_s   : ( EscChar | Char ) { more(WORD); } ;

mode CodeTics;
	LST_c	: LBrace { style() }? -> type(LSTYLE), pushMode(Style) ;
	VWS_c	: Vws	-> type(VWS), pushMode(TicsBody) ;
	HWS_c	: Hws	-> type(HWS), channel(HIDDEN) ;
	TYP_c	: ( Char | EscChar ) { more(CODE_TYPE); } ;

mode TicsBody;
	END_cb   : { bol() }? Tics { popMode2(CODE_END); } ;
	VWS_cb	 : Vws	-> type(VWS) ;
	CHR_cb	 : ( Char | Hws | EscChar ) { more(CODE_LINE); } ;

mode CodeTildes;
	LST_d	: LBrace { style() }? -> type(LSTYLE), pushMode(Style) ;
	VWS_d	: Vws	-> type(VWS), pushMode(TildesBody) ;
	HWS_d	: Hws	-> type(HWS), channel(HIDDEN) ;
	TYP_d	: ( Char | EscChar ) { more(CODE_TYPE); } ;

mode TildesBody;
	END_db	: { bol() }? Tildes { popMode2(CODE_END); } ;
	VWS_db	: Vws	-> type(VWS) ;
	CHR_db	: ( Char | Hws | EscChar ) { more(CODE_LINE); } ;

// ----------------------------------------------------------------------

fragment TaskMark	: LBrack ( [ _] | Alphanum | Unicode )? RBrack ;
fragment BlockQuote	: Sp0_3 ( RAngle Sp? )* RAngle ;
fragment LineDent  
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
	: '-' Hws* '-' (Hws* '-')+   
	| '*' Hws* '*' (Hws* '*')+   
	| '_' Hws* '_' (Hws* '_')+   
	;



fragment SeText 
	: '-' '-'+
	| '=' '='+ 	
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

fragment TblDef : 	Sp0_3 ( Pipe HWS* )? ColDef HWS* Pipe 
					( HWS* ColDef HWS* Pipe )* 
					HWS* ColDef HWS* Pipe?
				;
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
		( [btnfr"'\\]	// Standard escaped character set
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
