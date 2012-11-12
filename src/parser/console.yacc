%{

#import "Command.h"
#import "ClearCommand.h"

%}

%token CLEAR EQUAL SEMICOLON LBR RBR DASH 
%token ADD SUB MUL ID NUM

%start command

%%

command :	CLEAR					{return [[ClearCommand alloc] init];}
		|	ID EQUAL object			{};

object	:	matrix					{};

matrix	:	LBR rowList	RBR			{};

rowList	:	numList						{}
		|	numList	SEMICOLON rowList	{};

numList	:	NUM						{}
		|	NUM	numList				{};

%%