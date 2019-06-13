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
	:	( codeBlock	| yamlBlock	| htmlBlock	| mathBlock	| texBlock	| umlBlock 
		| header    | hrule		| list	    | table 	| definition
		| paragraph	| comment	| lnBreak	| lnBlank	| ignore
		)*
		EOF
	;

yamlBlock	: YAML_BLOCK ;
htmlBlock	: HTML_BLOCK ;
mathBlock	: MATH_BLOCK ;
texBlock	: TEX_BLOCK  ;
umlBlock	: UML_BLOCK  ;

codeBlock
	: CODE_BEG ( HWS* lang=WORD )? ( HWS* style )? VWS+ 
		code+=( WORD | HWS | VWS )* 
	  CODE_END
	;

header
	: BLANK HASHES content* HASH* style? 
	| BLANK content* ( EQUALS | DASHES ) 
	;

hrule
	: BLANK HRULE style? 
	;

list
	: BLANK listItem+  
	;

listItem
	: listMark content+
	;

listMark
	: mark=SIMPLE_MARK
	| mark=PAREN_MARK
	| mark=UALPHA_MARK
	| mark=LALPHA_MARK
	;

table : BLANK hdr=tableRow tableDef rows+=tableRow+ ;

tableDef : TABLE ;
tableRow : PIPE? tableCell? ( PIPE tableCell? )+ PIPE? ;
tableCell : content ;

definition
	: BLANK ( word BREAK )+ ( COLON paragraph )+
	;

paragraph	: BLANK ( BQUOTE? content )+ ;

content		: ( word | link )+ ( lnBreak ( word | link )+ )* ;

// [word](URL "title") {style}
// [word][ref]
// [URL] {style}
// [ref]:URL "title"
link
	: LINK text LINK_MARK URL ( QUOTE text QUOTE )? RPAREN style? 
	| LDEF text DEF_MARK URL ( LDQUOTE text RDQUOTE )?
	| LREF text REF_MARK text RBRACK style?
	| LURL URL  RBRACK style?
	| LTXT text RBRACK style?
	;

text : word+ ;

word
	: attrLeft* 
		( WORD | UNICODE | ENTITY
		| HTML | TEX | MATH | URL
		) 
	  attrRight*
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

lnBlank	: BLANK ;
lnBreak	: BREAK ;

ignore	: ( ERR | BLANK | BREAK )+ ; 
