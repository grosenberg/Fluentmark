parser grammar MdParser ;

options {
	tokenVocab = MdLexer ;
}

@header {
	package net.certiv.fluentmark.core.md.parser.gen;
	import net.certiv.fluentmark.core.md.parser.MdToken;
}

page
	: comment? frontMatter? 
	  ( header
	  | hrule
	  | list
	  | table
	  | html
	  | codeBlock
	  | mathBlock
	  | texBlock
	  | quote
	  | definition
	  | terminal
	  | paragraph
	  | comment
	  | unknown
	  )*? EOF
	;

frontMatter
	: FRONT_MATTER content FRONT_MATTER
	;

header
	: HEADER ( text | link )* HASH* style? terminal
	| ( text | link )* SEMARK terminal
	;

hrule	
	: HRULE terminal 
	;

list
	: listItem+ terminal
	;

listItem
	: LIST_ITEM ( text | link )*
	;

table		: hdr=tableRow tableDef rows+=tableRow+ terminal ;

tableDef	: TABLE_DEF ;

tableRow	: PIPE? tableCell ( PIPE tableCell )+ PIPE? ;

tableCell	: ( text | link )* ;

html	
	: HTML terminal 
	;

codeBlock
	: CODE_BLOCK_BT WORD* style? content CODE_BLOCK_BT
	| CODE_BLOCK_TD WORD* style? content CODE_BLOCK_TD
	;

mathBlock 
	: MATH_BLOCK content MATH_BLOCK 
	;

texBlock 
	: TEX_BEG content TEX_END 
	;

quote
	: QUOTE_BLOCK ( text | link )* terminal
	;

definition
	: ( text | link )+ DEFINE_BLOCK ( text | link )* terminal
	;

paragraph
	: ( text | link )+ terminal
	;

link
	: IMAGE? LINK text? LINK_DEF text? ( QUOTE text? QUOTE )? RPAREN style?
	| IMAGE? LINK text? LINK_REF text? RBRACK style?
	| LINK text? RBRACK style?
	| REF text? REF_DEF URL ( QUOTE text? QUOTE )? 
	;

text 	: word+ ;

word
	: attrLeft*
		( WORD
		| UNICODE
		| ENTITY
		| HTML
		| TEX
		| INMATH
		| URL
		)
	  attrRight*
	;

style
	: LBRACE
	 	( CLASS WORD
	 	| ID WORD
	 	| WORD EQ ( QUOTE? WORD* QUOTE? | APSTP WORD* APSTP )
	 	)*
	  RBRACE
	;

attrLeft	: LBOLD | LITALIC | LSTRIKE | LSPAN | LQUOTE | LAPSTP ;
attrRight	: RBOLD | RITALIC | RSTRIKE | RSPAN | RQUOTE | RAPSTP ;

content  : LINE* ;

terminal : TERM | EOF ;

comment  : INVS_COMMENT | HTML_COMMENT ;

unknown  : ERR+ ;
