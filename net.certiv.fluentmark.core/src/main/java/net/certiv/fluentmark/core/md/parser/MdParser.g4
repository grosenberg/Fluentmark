parser grammar MdParser ;

options {
	tokenVocab = MdLexer ;
}

@header {
	package net.certiv.fluentmark.core.md.parser.gen;
	import net.certiv.fluentmark.core.md.parser.MdToken;
}

page
	: frontMatter? part* EOF
	;

part
	: header
	| html
	| hrule
	| list
	| table
	| codeBlock
	| mathBlock
	| quote
	| definition
	| paragraph

	| comment
	| terminal
	| unknown
	;

frontMatter
	: FRONT_MATTER LINE* FRONT_MATTER
	;

header
	: HEADER ( link | word )* HASH* style? terminal
	| ( word | link )+ SEMARK terminal
	;

list
	: listItem+ terminal
	;

listItem
	: LIST_ITEM content
	;

content
	: word
	| link
	;

word
	: attrLeft*
		( WORD
		| UNICODE
		| ENTITY
		| INMATH
		)
	  attrRight*
	;

style
	: LBRACE
	 	( CLASS WORD
	 	| ID WORD
	 	| WORD EQ QUOTE? WORD QUOTE?
	 	)*
	  RBRACE
	;

link
	: ( LBRACK | IMAGE ) ( link | WORD )* RBRACK
		( LPAREN WORD* RPAREN
		| LBRACK WORD* LBRACK
		)?
		style?
	;

attrLeft	: LBOLD | LITALIC | LSTRIKE ;
attrRight	: RBOLD | RITALIC | RSTRIKE ;

table		: tableRow TABLE_DEF tableRow+ terminal ;

tableRow	: PIPE? tableCell ( PIPE tableCell )+ PIPE? ;

tableCell	: ( word | link | html )* ;

html	: HTML ;
hrule	: HRULE TERM ;

codeBlock
	: CODE_BLOCK_BT ID? style? LINE* CODE_BLOCK_BT
	| CODE_BLOCK_TD ID? style? LINE* CODE_BLOCK_TD
	;

mathBlock : MATH_BLOCK LINE* MATH_BLOCK ;

quote
	: QUOTE_BLOCK ( link | word )* TERM
	;

definition
	: word+ DEFINE_BLOCK ( link | word )* TERM
	;

paragraph
	: ( link | word )* TERM
	;

terminal : TERM ;
comment  : ML_COMMENT | HTML_COMMENT ;
unknown  : ERR+ ;


