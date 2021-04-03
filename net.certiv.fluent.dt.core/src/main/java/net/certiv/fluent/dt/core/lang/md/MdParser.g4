parser grammar MdParser ;

options {
	tokenVocab = MdLexer ;
}

@header {
	package net.certiv.fluent.dt.core.lang.md.gen;
}

page
	: ( yamlBlock	| dotBlock  | mathBlock | htmlBlock
	  | texBlock	| umlBlock	| codeBlock	| comment
	  | header	| hrule     | paragraph
	  | table	| list		| definition
	  | lnBlank	| lnBreak	| VWS
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
	: CODE_BEG lang=WORD? style? VWS
		( WORD | VWS )* 
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
			| WORD 
			)
		)+ 
	  RSTYLE
	;

// ==== Headings ===========

header
	: HASHES line HASH* style?
	| line style? nl ( EQUALS | DASHES )
	;

hrule : HRULE style? ;

// ==== Tables ============

table
	: ( tableRow nl )*
	  TABLE style? nl
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
	: mark=( BULLET_MARK	
		   | NUMBER_MARK | PAREN_MARK		
		   | UALPHA_MARK | LALPHA_MARK 
		   ) 
	  lines
	;

definition
	: line nl
	  defineItem
	  ( nl defineItem )* 
	;

defineItem
	: COLON lines
	;

// ==== Links ============

// [...](... alt?)
// [...][ref]
// [ref]: url alt?
// [...]
link
	: lnkDef line LNK_SEP url? alt? RPAREN style? 
	| lnkDef line LNK_REF word* RBRACK style?
	| lnkRef word* LNK_DEF ( VWS | LINE_BREAK )? url (( VWS | LINE_BREAK )? alt )? 
	| lnkDef line RBRACK style?
	;

lnkDef : ( IMAGE | FNOTE | LINK ) ;
lnkRef : LINK ;

url
	: URLTAG
	| URL
	;

alt
	: DQUOTE  ( word | SQUOTE )* DQUOTE 
	| SQUOTE  ( word | DQUOTE )* SQUOTE
	| LDQUOTE line? RDQUOTE
	| LSQUOTE line? RSQUOTE
	;

// ==== Text ============

paragraph
	: lines
	;

lines
	: line (nl line )*
	;

line
	: ( word | link )+ 
	;

word
	: attrLeft* 
	  w=( WORD | ENTITY | UNICODE
	  	| URL  | URLTAG 
	  	| SPAN | MATHS 
	  	| HTML | TEX
		)
	  attrRight*
	;

nl	: LINE_BREAK | VWS ;
nl2	: LINE_BREAK | LINE_BREAK | VWS ;

attrLeft  : LBOLD | LITALIC | LSTRIKE | LDQUOTE | LSQUOTE ;
attrRight : RBOLD | RITALIC | RSTRIKE | RDQUOTE | RSQUOTE ;

comment : COMMENT ;

lnBlank : LINE_BLANK ;
lnBreak : LINE_BREAK ;
