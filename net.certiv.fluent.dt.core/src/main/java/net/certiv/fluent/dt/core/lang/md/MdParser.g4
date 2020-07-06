parser grammar MdParser ;

options {
	tokenVocab = MdLexer ;
}

@header { 
	package net.certiv.fluent.dt.core.lang.md.gen;
}

page
	:	( yamlBlock	| htmlBlock | dotBlock  |  mathBlock
		| texBlock	| umlBlock	| codeBlock
		| header	| hrule
		| table	    | list
		| paragraph | definition
		| lnBlank	| lnBreak
		| comment	| err
		)*
	EOF
	;

// ==== Blocks ============

yamlBlock : YAML_BLOCK ;
htmlBlock : HTML_BLOCK ; 
dotBlock  : DOT_BLOCK  ; 
mathBlock : MATH_BLOCK ;
texBlock  : TEX_BLOCK  ; 
umlBlock  : UML_BLOCK  ;

codeBlock
	: CODE_BEG lang=WORD? style? VWS+ ( WORD | VWS )* CODE_END
	;

// ==== Headers ============

header
	: HASHES line HASH* style?
	| line ( EQUALS | DASHES )
	;

hrule
	: HRULE style?
	;

// ==== Tables ============

table 
	: tableRow* TABLE_DEF style? tableRow*
	;

tableRow
	: PIPE? ( line? PIPE )+ line? PIPE?
	;

// ==== Lists ============

list
	: listItem+
	;

listItem
	: listMark ( line lnBreak? )*
	;

listMark
	: mark=UNORDERED_MARK
	| mark=NUMBER_MARK
	| mark=PAREN_MARK
	| mark=UALPHA_MARK
	| mark=LALPHA_MARK
	;

// ==== Links ============

link
	: linkStd style?
	| linkRef style?
	| linkDef style?
	;

// [text](url altText) 
// [text](text altText)
linkStd
	: kind subject LNK_SEP target altText? RPAREN 
	;

// [text][url]
// [text][text]
// [text][]
// [text]
linkRef
	: kind subject LNK_REF linkText? RBRACK
	| kind subject RBRACK
	;

// [text]: url altText
linkDef
	: LBRACK linkText LNK_DEF target altText? 
	;

kind
	: IMAGE 
	| LBRACK 
	;

subject
	: linkStd
	| linkRef
	| target
	;
		
altText : LDQUOTE text RDQUOTE ;

target
	: URL
	| linkText
	;

linkText : linkWord+ ;

linkWord
	: attrLeft* 
	  w= ( WORD		| TEX | URL
		 | SPAN 	| MATH_SPAN
		 | UNICODE	| ENTITY
		 | HTML 
		 )
	  attrRight*
	;

// ==== Text ============

paragraph
	: line ( lnBreak line )*
	;

definition
	: line ( COLON line ( lnBreak line )* )+
	;

line 
	: ( text | link )+ 
	;

text : word+ ;

word
	: attrLeft* 
	  w= ( WORD		| TEX | URL
		 | SPAN 	| MATH_SPAN
		 | UNICODE	| ENTITY
		 | HTML		| RPAREN 
		 )
	  attrRight*
	;

style
	: LSTYLE 
		( CLASS WORD
		| ID WORD
		| WORD EQ ( QUOTE? WORD QUOTE? | MARK? WORD MARK? )
		)+ 
	  RSTYLE
	;

attrLeft  : LBOLD | LITALIC | LSTRIKE | LSPAN | LDSPAN | LDQUOTE | LSQUOTE ;
attrRight : RBOLD | RITALIC | RSTRIKE | RSPAN | RDSPAN | RDQUOTE | RSQUOTE ;

comment : COMMENT ;
lnBlank : LINE_BLANK ;
lnBreak : LINE_BREAK ;

err : ERR+ ; 
