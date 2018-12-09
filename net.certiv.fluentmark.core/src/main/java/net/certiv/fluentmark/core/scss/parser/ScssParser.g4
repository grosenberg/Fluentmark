/*
 [The "BSD licence"]
 Copyright (c) 2014 Vlad Shlosberg
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

parser grammar ScssParser ;

options {
	tokenVocab = ScssLexer ;
}

@header {
	package net.certiv.fluentmark.core.scss.parser.gen;
}

stylesheet
	: statement* EOF
	;

statement
	: importDeclaration
	| nested
	| ruleset
	| mixinDeclaration
	| functionDeclaration
	| variableDeclaration
	| includeDeclaration
	| ifDeclaration
	| forDeclaration
	| whileDeclaration
	| eachDeclaration
	;

// Params to mixins, includes, etc
params
 	: param ( COMMA param)* ELLIPSIS?
	;

param
	: variableName paramOptionalValue?
	;

variableName
	: DOLLAR IDENTIFIER
	;

paramOptionalValue
	: COLON expression+
	;

// MIXINS
mixinDeclaration
	: MIXIN IDENTIFIER ( LPAREN params? RPAREN )? block
	;

// Includes
includeDeclaration
	: INCLUDE IDENTIFIER ( SEMI | ( LPAREN values? RPAREN SEMI?	)? block? )
	;

// FUNCTIONS
functionDeclaration
	: FUNCTION IDENTIFIER LPAREN params? RPAREN LBRACE functionBody? RBRACE
	;

functionBody
	: functionStatement* functionReturn
	;

functionReturn
	: RETURN commandStatement SEMI
	;

functionStatement
	: commandStatement SEMI | statement
	;

commandStatement
	: ( expression+ | LPAREN commandStatement RPAREN ) mathStatement?
	;

mathCharacter
	: TIMES | PLUS | DIV | MINUS | PERC
	;

mathStatement
	: mathCharacter commandStatement
	;

expression
	: measurement
	| identifier
	| COLOR
	| STRING
	| NULL
	| url
	| variableName
	| functionCall
	;

// If statement
ifDeclaration
	: AT_IF conditions block elseIfStatement* elseStatement?
	;

elseIfStatement
	: AT_ELSE IF conditions block
	;

elseStatement
	: AT_ELSE block
	;

conditions
	: condition ( COMBINE_COMPARE conditions )?
	| NULL
	;

condition
	: commandStatement ( ( EQIV | LT | GT | NOTEQ ) conditions )?
	| LPAREN conditions RPAREN
	;

variableDeclaration
	: variableName COLON values DEFAULT? SEMI
	;

// for
forDeclaration
	: AT_FOR variableName FROM from=NUMBER THROUGH thru=NUMBER block
	;

// while
whileDeclaration
	: AT_WHILE conditions block
	;

// EACH
eachDeclaration
	: AT_EACH variableName ( COMMA variableName )* IN eachValueList block
	;

eachValueList
	: IDENTIFIER ( COMMA IDENTIFIER )*
	| identifierListOrMap ( COMMA identifierListOrMap )*
	;

identifierListOrMap
	: LPAREN identifierValue ( COMMA identifierValue )* RPAREN
	;

identifierValue
	: identifier ( COLON values )?
	;

// Imports
importDeclaration
	: IMPORT referenceUrl mediaTypes? SEMI
	;

referenceUrl
	: STRING
	| url
	;

mediaTypes
	: ( IDENTIFIER (COMMA IDENTIFIER )* )
	;

// Nested (stylesheets, etc)
nested
	: AT nest selectors LBRACE stylesheet RBRACE
	;

nest
	: ( IDENTIFIER | AND ) IDENTIFIER* pseudo*
	;

// Rules
ruleset
	: selectors block
	;

block
	: LBRACE ( property SEMI | statement )* property? RBRACE
	;

selectors
	: selector ( COMMA selector )*
	;

selector
	: element+ ( selectorPrefix element )* attrib* pseudo?
	;

selectorPrefix
	: ( GT | PLUS | TIL )
	;

element
	: identifier
	| HASH identifier
	| DOT identifier
	| AND
	| TIMES
	;

pseudo
	: ( COLON | COLONCOLON ) IDENTIFIER
	| ( COLON | COLONCOLON ) functionCall
	;

attrib
	: LBRACK IDENTIFIER ( attribRelate ( STRING | IDENTIFIER ) )? RBRACK
	;

attribRelate
	: EQ
	| TILD_EQ
	| PIPE_EQ
	;

identifier
	: IDENTIFIER identifierPart*
	| INTERPOLATION_START identifierVariableName RBRACE identifierPart*
	;

identifierPart
	: InterpolationStartAfter identifierVariableName RBRACE
	| IdentifierAfter
	;

identifierVariableName
	: DOLLAR ( IDENTIFIER | IdentifierAfter )
	;

property
	: identifier COLON values
	;

values
	: commandStatement ( COMMA commandStatement )*
	;

url
	: URL_BEG URL URL_END
	;

measurement
	: NUMBER UNIT?
	;

functionCall
	: IDENTIFIER LPAREN values? RPAREN
	;
