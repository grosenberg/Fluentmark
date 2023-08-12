parser grammar MdParser ;

options {
	superClass = MdParserBase ;
	tokenVocab = MdLexer ;
}

@header {
	package net.certiv.fluent.dt.core.lang.md.gen;
	import net.certiv.fluent.dt.core.lang.md.MdParserBase;
}

page
	: ( yamlBlock	| dotBlock  | mathBlock  | htmlBlock
	  | texBlock	| umlBlock	| codeBlock	 | comment
	  | header		| hrule     | table		 | definition		
	  | list		| paragraph	| refLinkDef | fnLinkDef
	  | lineBlank	| codeBlank | quoteBlank
	  | lineBreak	| VWS
	  )*
	  EOF
	;

// ==== Blocks ============

yamlBlock : YAML_BLOCK ;
dotBlock  : DOT_BLOCK  ; 
mathBlock : MATH_BLOCK ;
texBlock  : TEX_BLOCK  ;
umlBlock  : UML_BLOCK  ;

htmlBlock 
	: HTML_BLOCK_BEG 
		( COMMENT | line | nl )*
	  HTML_BLOCK_END 
	;

codeBlock
	: CODE_BEG lang=CODE_TYPE? style? VWS
		( CODE_LINE | VWS )* 
	  CODE_END
	;

style
	: LSTYLE 
		( DASH
		| CLASS WORD
		| ID WORD
		| WORD EQ 
			( SQUOTE WORD SQUOTE 
			| DQUOTE WORD DQUOTE
			| DASH? WORD
			)
		)+ 
	  RSTYLE
	;

// ==== Headings ===========

header
	: hdr=HASHES line HASHES? style?
	| line style? nl SETEXT
	;

hrule : HRULE style? ;

// ==== Tables ============

table
	: ( tableRow nl )*
	  TABLE_DEF style? nl
	  ( tableRow nl )*
	  tableRow
	;

tableRow
	: PIPE? ( line? PIPE )+ line? PIPE?
	;


// ==== Lists ============

list
	: listItem
	  ( nl listItem )* 
	;

listItem 
	: mark=( BULLET_MARK | NUMBER_MARK ) TASK_MARK?
	  paragraph 
	;

definition
	: line VWS
	  definitionItem
	  ( VWS definitionItem )* 
	;

definitionItem
	: DEFINE paragraph
	;

// ==== Links ============

link
	: LBRACK txt=phrase? LNK_SEP url? quote? RPAREN style?
	;

linkRef
	: LBRACK
		( txt=phrase? LNK_REF ref=phrase RBRACK		// [...][ref]
		| ref=phrase LNK_REF RBRACK					// [ref][]
		| ref=phrase RBRACK							// [ref]
		)
		style?
	;

imgLink
	: LNK_IMG txt=phrase LNK_SEP url? quote? RPAREN style?
	;

imgLinkRef
	: LNK_IMG
		( txt=phrase LNK_REF ref=phrase RBRACK
		| ref=phrase LNK_REF RBRACK
		| ref=phrase RBRACK
		)
		style?
	;

fnLink
	: LNK_FN ref=phrase LNK_SEP url? quote? RPAREN style?
	;

fnLinkRef
	: LNK_FN ref=phrase RBRACK style?
	;

autoLink
	: URLTAG
	| LBRACK URL RBRACK
	| URL
	;

// ==== Link Definitions =======

refLinkDef
	: LBRACK ref=phrase? LNK_DEF nl? url (nl? quote )? style?	// [ref]: url alt
	;

fnLinkDef
	: LNK_FN ref=phrase LNK_DEF
	  def+=line ( nl { twoSpaces() }? def+=line )*
	;


// ==== Text ============

// top-level: a line group of multiple lines separated by single new lines
paragraph
	: line
	  (	nl line )*
	;

// single text line
line
	: (
		attrLeft*
		( quote 
		| WORD   | PIPE	   | LPAREN  | RPAREN | ENTITY
		| SQUOTE | DQUOTE  | ESC_SQUOTE | ESC_DQUOTE 
		| HTML   | SPAN    | MATHS   | TEX    | UNICODE
		| link   | linkRef | imgLink | imgLinkRef | fnLink | fnLinkRef	| autoLink 
	  	| LBRACK | RBRACK   
		)
		attrRight*
	  )+
	;
	
// special line excluding brackets and footnotes
phrase
	: ( 
		attrLeft*
		( quote 
		| WORD   | PIPE	   | LPAREN  | RPAREN | ENTITY 
		| SQUOTE | DQUOTE  | ESC_SQUOTE | ESC_DQUOTE 
		| HTML   | SPAN    | MATHS   | TEX    | UNICODE
		| link   | linkRef | imgLink | imgLinkRef | autoLink 
		)
		attrRight*
	  )+
	;

quote
	: LDQUOTE 
		( 
			( attrLeft | LSQUOTE )* 
			( WORD   | PIPE	   | LPAREN  | RPAREN | ENTITY 
			| HTML   | SPAN    | MATHS   | TEX    | UNICODE
			| link   | linkRef | imgLink | imgLinkRef | fnLink | fnLinkRef	| autoLink 
	  		| LBRACK | RBRACK  | SQUOTE  | ESC_DQUOTE ) 
			( attrRight | RSQUOTE )* 
		)* 
	  RDQUOTE
	| LSQUOTE 
		( 
			( attrLeft | LDQUOTE )* 
			( WORD   | PIPE	   | LPAREN  | RPAREN | ENTITY 
			| HTML   | SPAN    | MATHS   | TEX    | UNICODE
			| link   | linkRef | imgLink | imgLinkRef | fnLink | fnLinkRef	| autoLink 
	  		| LBRACK | RBRACK  | DQUOTE  | ESC_SQUOTE )
			( attrRight | RDQUOTE )* 
		)* 
	  RSQUOTE
	;

url	: URL ;

lineBlank  : LINE_BLANK ;
codeBlank  : CODE_BLANK ;
quoteBlank : QUOTE_BLANK ;

lineBreak  : LINE_BREAK ;
nl		   : LINE_BREAK | VWS ;

attrLeft  : LBOLD | LITALIC | LSTRIKE ;
attrRight : RBOLD | RITALIC | RSTRIKE ;

comment : COMMENT ;
