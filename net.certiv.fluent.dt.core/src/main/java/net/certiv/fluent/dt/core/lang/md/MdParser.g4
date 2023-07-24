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
	: ( yamlBlock	| dotBlock  | mathBlock | htmlBlock
	  | texBlock	| umlBlock	| codeBlock	| comment
	  | header		| hrule     | table		| definition		
	  | list		| paragraph	  
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
	  defineItem
	  ( VWS defineItem )* 
	;

defineItem
	: DEFINE paragraph
	;

// ==== Links ============

link
	: LBRACK 
		( l_word* LNK_DEF nl? url (nl? alt )?		// [def]: url alt
		| l_line? LNK_SEP url? alt? RPAREN			// [...](url alt)
		| l_line? LNK_REF l_line? RBRACK			// [...][word]
		| l_line RBRACK								// [...]
		)
		style?
	;

imgLink
	: LNK_IMG
		( l_line LNK_SEP url? alt? RPAREN
		| l_line LNK_REF l_line* RBRACK
		| l_line RBRACK   
		)
		style?
	;

fnLink
	: LNK_FN
		( l_word LNK_DEF l_line ( nl { twoSpaces() }? l_line )* 
		| l_line LNK_SEP url? alt? RPAREN 
		| l_line LNK_REF l_line* RBRACK
		| l_line RBRACK   
		)
		style?
	;

alt
	: DQUOTE  ( word | SQUOTE )* DQUOTE 
	| SQUOTE  ( word | DQUOTE )* SQUOTE
	| LDQUOTE line? RDQUOTE
	| LSQUOTE line? RSQUOTE
	;

url 
	: URL 
	| URLTAG 
	;

// ==== Text ============

// top-level: a line group of multiple lines separated by single new lines
paragraph
	: line ( nl line )*
	;

// internal: single line
line
	: ( link | imgLink | fnLink | word )+
	;

// internal: general text word including []
word
	: attrLeft*
	  w=( WORD   | ENTITY | UNICODE
	  	| URL    | URLTAG | HTML 
	  	| SPAN   | MATHS  | TEX 
	  	| LPAREN | RPAREN | PIPE
	  	| LBRACK | RBRACK  
		)
	  attrRight*
	;

// link internal: single line excluding non-link []
l_line
	: ( link | imgLink | fnLink | l_word )+
	;

// link internal: word excluding []
l_word
	: attrLeft*
	  w=( WORD   | ENTITY | UNICODE
	  	| URL    | URLTAG | HTML 
	  	| SPAN   | MATHS  | TEX 
	  	| LPAREN | RPAREN | PIPE
		)
	  attrRight*
	;

nl	: LINE_BREAK | VWS ;

attrLeft  : LBOLD | LITALIC | LSTRIKE | LDQUOTE | LSQUOTE ;
attrRight : RBOLD | RITALIC | RSTRIKE | RDQUOTE | RSQUOTE ;

comment : COMMENT ;

lineBlank  : LINE_BLANK ;
codeBlank  : CODE_BLANK ;
quoteBlank : QUOTE_BLANK ;

lineBreak : LINE_BREAK ;
