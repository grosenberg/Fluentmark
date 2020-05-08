lexer grammar MdLexer ;

options {
	superClass = MdLexerBase ;
}

tokens {
	WORD,

	RBOLD,
	RITALIC,
	RSTRIKE,
	RSPAN,
	RDSPAN,
	RDQUOTE,
	RSQUOTE
}

@header {
	package net.certiv.fluent.dt.core.lang.md.gen;
	import  net.certiv.fluent.dt.core.lang.md.MdLexerBase;
}

COMMENT : Comment ; 

URL
	: Url
	| LAngle Url RAngle
	;

LSTYLE : LBrace { style() }? -> pushMode(Style) ;

// link elements
LBRACK	 : LBrack			  ;

IMAGE	 : Bang LBrack		  ;
LINK_SEP : RBrack Spc? LParen ;
REF_SEP	 : RBrack Spc? LBrack ;
DEF_SEP	 : RBrack Spc? Colon  ;
RBRACK	 : RBrack			  ;
RPAREN	 : RParen			  ;

// code blocks
CODE_BEG : Tics   { at(2) }? -> pushMode(CodeTics)	;
CODE_ALT : Tildes { at(2) }? -> type(CODE_BEG), pushMode(CodeTildes) ;

CODE_SPAN
	: Tic Tic ( EscSeq | ~[\\]  )*? Tic Tic
	| Tic	  ( EscSeq | ~[`\\] )* Tic
	;

// other blocks
YAML_BLOCK : YamlBlock { at(2) }? ;
HTML_BLOCK : HtmlBlock { at(2) }? ;

MATH_BLOCK : MathMark .*? MathMark { at(2) }? ;
TEX_BLOCK  : TexBeg   .*? TexEnd { at(2) }?	  ;
UML_BLOCK  : UmlBeg   .*? UmlEnd { at(2) }?   ;

// special inline strings
UNICODE	: Unicode ;
ENTITY	: Entity  ;
TEX		: TexRaw  ;
HTML	: HtmlTag ;

MATH_SPAN : MathSpan { notDigit() }? ;

// tables
TABLE_DEF : Pipe? ColDef ( Pipe ColDef )+ Pipe? { at(1) }? ;
PIPE : Pipe	;

// hrule
HRULE : HRule { at(2) }? ;

// headers
HASHES : Hash+ { at(1) }?  ;
DASHES : Dashes { at(1) }? ;
EQUALS : Equals { at(1) }? ;

COLON  : Colon { at(1) }?  ;

// list marks
UNORDERED_MARK : [*+-] TaskMark? Sps { at(1) }? ;
NUMBER_MARK : (Digit+ Dot | Hash Dot ) TaskMark? Sps { at(1) }? ;
PAREN_MARK	: LParen? Alphanum+ RParen TaskMark? Sps { at(1) }? ;
UALPHA_MARK : UAlpha+ Dot TaskMark? Sps { at(1) }? ;
LALPHA_MARK	: LAlpha+ Dot TaskMark? Sps { at(1) }? ;

// attributes
LBOLD	: '**' | '__' ;
LITALIC	: '*'  | '_'  ;
LSTRIKE	: '~~'		  ;
LSPAN	: '`'		  ;
LDSPAN	: '``'		  ;
LDQUOTE	: '"'		  ;
LSQUOTE	: '\''		  ;

LINE_BLANK : Vws Hws* Vws ;
LINE_BREAK : Spc Spc Vws  ;
LINE_QUOTE : BlockQuote { at(1) }? -> channel(HIDDEN) ;
LINE_DENT  : Dent { at(1) }? -> channel(HIDDEN)	   ;

VWS	: Vws -> channel(HIDDEN) ;
HWS	: Hws -> channel(HIDDEN) ;

CHAR : ( Char | EscChar ) { more(WORD); } ;
ERR	 : . ;

mode Header;
	HASH	 : Hash+ ;
	LSTYLE_h : LBrace { style() }? -> type(LSTYLE), pushMode(Style) ;

	HWS_h  : Hws -> type(HWS), channel(HIDDEN) ;
	CHAR_h : ( Char | EscChar ) { more(WORD); } ;

mode Style;
	RSTYLE : RBrace -> popMode ;
	CLASS : Dot	  ;
	ID	  : Hash  ;
	EQ	  : Equal ;
	QUOTE : Quote ;
	MARK  : Mark  ;
	HWS_s  : Hws -> type(HWS), channel(HIDDEN) ;
	CHAR_s : ( Char | EscChar ) { more(WORD); } ;

mode CodeTics;
	CODE_END : Vws BlockQuote? Tics -> popMode			   ;
	LSTYLE_b : LBrace { style() }? -> type(LSTYLE), pushMode(Style) ;

	VWS_b  : Vws -> type(VWS) ;
	HWS_b  : Hws -> type(HWS), channel(HIDDEN) ;
	CHAR_b : ( Char | EscChar ) { more(WORD); } ;

mode CodeTildes;
	TILDES_t : Vws BlockQuote? Tildes -> type(CODE_END), popMode ;
	LSTYLE_t : LBrace { style() }? -> type(LSTYLE), pushMode(Style)		 ;

	VWS_t : Vws	-> type(VWS) ;
	HWS_t : Hws	-> type(HWS), channel(HIDDEN) ;
	CHR_t : ( Char | EscChar ) { more(WORD); } ;

// ------------------------

fragment BlockQuote	: Spx ( RAngle Spc? )* RAngle Spc Hws* ;
fragment TaskMark	: Sps LBrack [ a-zA-Z0-9_]? RBrack	   ;

// ------------------------
fragment Url
	: UrlScheme UrlHost UrlPath?
	| UrlHost UrlPath?
	| UrlPath
	;

fragment UrlScheme : Letter ( Alphanum |[.+-] )+ '://' ;
fragment UrlHost
	: UrlUser ( UrlName | UrlIp ) UrlPort?
	|		  ( UrlName | UrlIp	) UrlPort?
	;

fragment UrlPath : UrlSegment+ UrlQuery? UrlFrag? ;

fragment UrlSegment	: [./]+ ([%+._-] | Alphanum	)* ;

fragment UrlQuery	: Question ([%+=&;._-] | Alphanum )+  ;
fragment UrlFrag	: Hash ([%+._-] | Alphanum )+ ;
fragment UrlName : UrlTerm ( Dot UrlTerm )+	;
fragment UrlIp
	: Digit+		   ( Dot Digit+		 )+
	| LBrack HexDigit+ ( Colon HexDigit+ )+ RBrack
	;

fragment UrlUser : ~[:@/ \t\r\n\f\\]+ Colon ~[:@/ \t\r\n\f\\]+ At ;
fragment UrlPort : Colon Digit+	;
fragment UrlTerm : Letter ( Alphanum |[_-] )* ;

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

fragment MathMark : '$$'						;
fragment MathSpan : Dollar NotWs NotVws* Dollar	;

fragment NotWs	: ( EscSeq | ~[ \t\r\n\f\\] ) ;
fragment NotVws	: ( EscSeq | ~[\r\n\f\\]	) ;

fragment ColDef : Colon? Dashes Colon? ;

// HTML
fragment HtmlBlock : Html+ ;
fragment Html
	: OpenTag ( Html | EscSeq | ~ '<' )+ CloseTag
	| AutoTag
	;

fragment HtmlTag  : OpenTag | CloseTag | AutoTag ;
fragment OpenTag  : LAngle Letter+ RAngle		 ;
fragment CloseTag : LAngle Slash Letter+ RAngle	 ;
fragment AutoTag  : LAngle Letter+ Slash RAngle  ;

// YAML
fragment YamlBlock : YamlBeg ( YamlKey ( YamlVal )* )+ YamlEnd ;

fragment YamlBeg : Dashes ( Hws* Vws )+	;
fragment YamlKey : Char+ Colon .*? ( Hws* Vws )+ ;
fragment YamlVal : ( ( '  ' | '\t' )+ | '- ' ) .*? ( Hws* Vws )+ ;
fragment YamlEnd : ( Dashes | Dots ) Hws* Vws ;

fragment Comment : '<!--' .*? '-->' ;

// edge specific delimiters
fragment Delimiters : [*_~`"] ;
fragment Vws : '\r'? '\n' ;
fragment Hws : Spc+ | '\t' ;

fragment Dent : Spc Spc Spc Spc+ | '\t'+ ;

fragment Spx : (Spc (Spc Spc? )? )?  ;
fragment Sps : Spc ( Spc Spc?	  )? ;

fragment Spc : ' ' ;

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
