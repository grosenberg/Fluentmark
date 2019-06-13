lexer grammar MdLexer ;

options {
	superClass = MdLexerBase ;
}

tokens {
	WORD,
	HDR_END,

	RBOLD,
	RITALIC,
	RSTRIKE,
	RSPAN,
	RDQUOTE,
	RSQUOTE
}

@header {
	package net.certiv.fluent.dt.core.lang.md.gen;
	import  net.certiv.fluent.dt.core.lang.md.MdLexerBase;
}

HIDN_COMMENT : CommentHidden ;
HTML_COMMENT : CommentHtml	 ;

URL	: Scheme? UrlPath
	| LAngle Scheme? UrlPath RAngle
	;

LSTYLE	: LBrace { style() }? -> pushMode(Style) ;

LINK	: LBrack { link()  }? -> pushMode(Link)	 ;
LDEF	: LBrack { lDef()  }? -> pushMode(Link)	 ;
LREF	: LBrack { lRef()  }? -> pushMode(Link)	 ;
LURL	: LBrack { lUrl()  }? -> pushMode(Link)	 ;
LTXT	: LBrack { lTxt()  }? -> pushMode(Link)	 ;

// code blocks
CODE_BEG : Tics		{ at(2) }? -> pushMode(CodeTics) ;
CODE_ALT : Tildes	{ at(2) }? -> type(CODE_BEG), pushMode(CodeTildes) ;

// other blocks
YAML_BLOCK : YamlBlock { at(2) }? ;
HTML_BLOCK : HtmlBlock { at(2) }? ;

MATH_BLOCK : MathMark .*? Vws+ MathMark	{ at(2) }? ;
TEX_BLOCK  : TexBeg   .*? Vws+ TexEnd	{ at(2) }? ;
UML_BLOCK  : UmlBeg   .*? Vws+ UmlEnd	{ at(2) }? ;

// special strings 
UNICODE	: Unicode	 ;
ENTITY	: Entity	 ;
TEX		: TexRaw	 ;
MATH	: InlineMath ;
HTML	: Html		 ;

// tables
TABLE	: BlockQuote? Pipe? ColDef ( Pipe ColDef )+ Pipe? { at(1) }? ;
PIPE	: Pipe	;

// hrule
HRULE	: BlockQuote? HRule { at(2) }? ;

// headers
HASHES	: BlockQuote? Hash+		{ at(1) }? ;
DASHES	: BlockQuote? Dashes	{ at(1) }? ;
EQUALS	: BlockQuote? Equals	{ at(1) }? ;
COLON	: BlockQuote? Colon		{ at(1) }? ;

// list marks
SIMPLE_MARK	: BlockQuote? Hws* ( [*+-] | Digit+ Dot | Hash Dot ) TaskMark? Sps	{ at(1) }? ;
PAREN_MARK	: BlockQuote? Hws* LParen? Alphanum+ RParen TaskMark? Sps			{ at(1) }? ;
UALPHA_MARK	: BlockQuote? Hws* UAlpha+ Dot TaskMark? Sps						{ at(1) }? ;
LALPHA_MARK	: BlockQuote? Hws* LAlpha+ Dot TaskMark? Sps						{ at(1) }? ;

// attributes
LBOLD	 : '**' | '__' ;
LITALIC	 : '*'  | '_'  ;
LSTRIKE	 : '~~' ;
LSPAN	 : '`'  ;
LDQUOTE	 : '"'  ;
LSQUOTE	 : '\'' ;

BQUOTE	: BlockQuote { at(1) }? ; 
BLANK	: Hws* Vws ( ( Hws* Vws )+ | EOF ) ;
BREAK	: Spc Spc Vws	;

VWS		: Vws -> channel(HIDDEN) ;
HWS		: Hws -> channel(HIDDEN) ;

CHAR	: Char  { more(WORD); } ;
ERR		: . ;

mode Header;
	HASH		: Hash+ ;
	LSTYLE_h	: LBrace { style() }? -> type(LSTYLE), pushMode(Style) ;
	
	HWS_h	: Hws -> type(HWS), channel(HIDDEN) ;
	CHAR_h	: Char  { more(WORD); } ;


mode Style;
	RSTYLE	: RBrace -> popMode ;
	
	CLASS : Dot	  ;
	ID	  : Hash  ;
	EQ	  : Equal ;
	QUOTE : Quote ;
	MARK  : Mark  ;
	
	HWS_sd : Hws -> type(HWS), channel(HIDDEN) ;
	CHAR_sd : Char  { more(WORD); } ;


mode Link;
	LINK_MARK : RBrack Spc? LParen ;
	REF_MARK  : RBrack Spc? LBrack ;
	DEF_MARK  : RBrack Spc? Colon	-> popMode ;
	RBRACK	  : RBrack 				-> popMode ;
	RPAREN	  : RParen 				-> popMode ;

	URL_l	: Scheme? UrlPath 	-> type(URL)   ;
	QUOTE_l : Quote 			-> type(QUOTE) ;

	HWS_l  : Hws -> type(HWS), channel(HIDDEN) ;
	CHAR_l : Char  { more(WORD); } ;


mode CodeTics;
	CODE_END : Vws+ Tics 			-> popMode	;
	LSTYLE_b : LBrace { style() }?	-> type(LSTYLE), pushMode(Style) ;

	VWS_b  : Vws -> type(VWS) ;
	HWS_b  : Hws -> type(HWS) ;
	WORD_b : Char { more(WORD); } ;


mode CodeTildes;
	TILDES_t : Vws+ Tildes 			-> type(CODE_END), popMode ;
	LSTYLE_t : LBrace { style() }?	-> type(LSTYLE), pushMode(Style) ;

	VWS_t	: Vws	-> type(VWS) ;
	HWS_t	: Hws	-> type(HWS) ;
	WORD_t	: Char { more(WORD); } ;


// ------------------------

fragment BlockQuote	: ( RAngle Spc? )* RAngle Sps 		;
fragment TaskMark	: Sps LBrack [ a-zA-Z0-9_]? RBrack	;

fragment Scheme	 : Letter ( Alphanum | Dash )* '://' ;
fragment UrlPath : ( UrlRoot | UrlFile) UrlFrag?	 ;

fragment UrlRoot : 'www.'? UrlTerm ( Dot UrlTerm )+ Slash?	 ;
fragment UrlFile : [/.]* '/' UrlTerm ( [.+_-] UrlTerm )* Slash? ;
fragment UrlTerm : ( Letter | HexChar ) UrlChar*			 ;
fragment UrlFrag : ([#?&@=/:.-] | UrlTerm )* UrlChar+ Slash? ;
fragment UrlChar : ( Alphanum | HexChar )					 ;

fragment HexChar : Percent HexDigit HexDigit ;

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

fragment MathMark	: '$$' ;
fragment InlineMath : Dollar NotWs ( NotVws* NotWs )? Dollar ;

fragment ColDef : Colon? Dashes Colon? ;

// HTML
fragment HtmlBlock : Html+ ;
fragment Html 
	: OpenTag ( Html | EscSeq | ~'<' )+ CloseTag
	| AutoTag
	;

fragment OpenTag  : LAngle Letter+ RAngle		;
fragment CloseTag : LAngle Slash Letter+ RAngle	;
fragment AutoTag  : LAngle Letter+ Slash RAngle ;

// YAML
fragment YamlBlock : YamlBeg ( YamlKey ( YamlVal )* )+ YamlEnd ;

fragment YamlBeg : Dashes ( Hws* Vws )+	;
fragment YamlKey : Char+ Colon .*? ( Hws* Vws )+ ;
fragment YamlVal : ( ( '  ' | '\t' )+ | '- ' ) .*? ( Hws* Vws )+ ;
fragment YamlEnd : ( Dashes | Dots ) Hws* Vws ;

// may be pandoc specific
fragment CommentHidden	: '<!---' .*? '-->' ;
fragment CommentHtml	: '<!--' .*? '-->'  ;

// edge specific delimiters
fragment Delimiters : [*_~`"] ;

fragment Vws : '\r'? '\n' ;
fragment Hws : Spc+ | '\t' ;
fragment Sps : Spc ( Spc Spc? )? ;
fragment Spc : ' ' ;

fragment TexBeg : Esc 'begin' ( BBrack | BBrace )* ;
fragment TexEnd : Esc 'end'	  ( BBrack | BBrace )* ;

fragment TexRaw : Esc Letter  ( Letter | Digit | TexSym )* ( BBrack | BBrace )* ;
fragment TexSym : [!/_-] ;
fragment UmlBeg : '@startuml' | '@startdot' ;
fragment UmlEnd : '@enduml'	  | '@enddot'	;

fragment Alphanum : Letter | Digit	;
fragment Letter	  : UAlpha | LAlpha ;
fragment UAlpha	  : [A-Z]			;
fragment LAlpha	  : [a-z]			;

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
	:	'u' ( HexDigit ( HexDigit ( HexDigit HexDigit?	)? )? )?
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
