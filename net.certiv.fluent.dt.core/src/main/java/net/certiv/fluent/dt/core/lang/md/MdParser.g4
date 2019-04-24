parser grammar MdParser ;

options {
	superClass = MdParserBase ;
	tokenVocab = MdLexer ;
}

@header {
	package net.certiv.fluent.dt.core.lang.md.gen;
	import net.certiv.fluent.dt.core.lang.md.MdToken;
	import net.certiv.fluent.dt.core.lang.md.MdParserBase;
}

page
	:	( metaBlock | codeBlock	| mathBlock | texBlock   | htmlBlock | umlBlock
		| list	    | table 	| quote		| definition | paragraph
		| header    | hrule		| comment
		| unknown	| lnBreak	| lnBlank
		)*
		EOF
	;

metaBlock
	: META VWS ( line VWS+ )* META
	;

header
	: LN_BLANK HASHES content* HASH* style? 
	| LN_BLANK content* ( EQUALS | DASHES ) 
	;

hrule
	: HRULE style? 
	;

list
	: LN_BLANK listItem+ { befBL() }? 
	;

listItem
	: LIST_ITEM line*
	;

table : LN_BLANK hdr=tableRow tableDef rows+=tableRow+ ;

tableDef : TABLE_DEF ;
tableRow : PIPE? tableCell? ( PIPE tableCell? )+ PIPE? ;
tableCell : content ;

htmlBlock
	: LN_BLANK HTML 
	;

codeBlock
	: TICS   WORD? style? VWS+ ( line VWS+ )* TICS
	| TILDES WORD? style? VWS+ ( line VWS+ )* TILDES
	; 

mathBlock
	: MATH_MARK line* MATH_MARK 
	;

texBlock
	: TEX_BEG line* TEX_END
	;

umlBlock
	: UML_BEG line* UML_END
	;

quote
	: LN_BLANK QUOTES paragraph
	| LN_BLANK ( QUOTES content )+
	;

definition
	: LN_BLANK content ( DEFINITION paragraph )+
	;

paragraph	: LN_BLANK content+ ;
content		: word+ | link | lnBreak;
text 		: word+ ;

line		: WORD+ ;
lnBlank		: LN_BLANK ;
lnBreak		: LN_BREAK ;

word
	: attrLeft* 
		( WORD | UNICODE | ENTITY
		| HTML | TEX | INMATH | URL	
		) 
	  attrRight*
	;

// [word](URL "title") {style}
// [word][ref]
// [URL] {style}
// [ref]:URL "title"
link
	: LINK text LINK_MARK URL ( QUOTE text QUOTE )? RPAREN style? 
	| LREF text REF_MARK text RBRACK style?
	| LURL URL  RBRACK style?
	| LDEF text DEF_MARK URL ( LDQUOTE text RDQUOTE )?
	;

style
	: LSTYLE ( CLASS WORD
			 | ID WORD
			 | WORD EQ ( QUOTE? WORD QUOTE? | MARK? WORD MARK? ) 
			 )+ 
	  RSTYLE
	;

attrLeft  : LBOLD | LITALIC | LSTRIKE | LSPAN | LDQUOTE | LSQUOTE ;
attrRight : RBOLD | RITALIC | RSTRIKE | RSPAN | RDQUOTE | RSQUOTE ;

comment	: HIDN_COMMENT | HTML_COMMENT ;

unknown	: ERR+ ; 
