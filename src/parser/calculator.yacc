%{
#import "Function.h"
#import "Constant.h"
#import	"IntegerConstant.h"
#import "FractionConstant.h"
#import "ArithmeticExpression.h"
#import "PowerExpression.h"
#import "ExpPowerExpression.h"
#import "BasicFunction.h"
#import "SpecialConstant.h"

%}

%token SIN COS LN 
%token LBR RBR
%token ADD SUB MUL DIV POWER 
%token VAR DS IS IDS
%token NUMBER E PI

%start exp;

%left LOW
%left ADD SUB
%left MUL DIV
%left POWER SIN COS LN NUMBER VAR DS IS E PI
%left LBR
%left lv3
%left lv2
%left lv1


%%

exp		:	LBR exp RBR 		{return $1;}		
		|	exp ADD exp			{return [Cleaner clean:[[ArithmeticExpression alloc] init:$1 operator:ADD right:$2]];}
		| 	exp SUB	exp 		{return [Cleaner clean:[[ArithmeticExpression alloc] init:$1 operator:SUB right:$2]];}
		|	exp MUL	exp			{return [Cleaner clean:[[ArithmeticExpression alloc] init:$1 operator:MUL right:$2]];}
		|	exp DIV	exp			{return [Cleaner clean:[[ArithmeticExpression alloc] init:$1 operator:DIV right:$2]];}
		|	exp POWER con		{return [[PowerExpression alloc] init:$1 power:$2];}
		|	E POWER exp			{return [[ExpPowerExpression alloc] init:$1];}
		|	DS exp DIV IDS		{return [$1 differentiate];}
		|	IS exp IDS			{return [$1 integrate];}
		|	SIN LBR exp RBR		{return [[BasicFunction alloc] init:SIN base:$1];}
		|	COS LBR exp RBR		{return [[BasicFunction alloc] init:COS base:$1];}
		|	LN LBR exp RBR		{return [[BasicFunction alloc] init:LN base:$1];}
		|	exp exp				{return [Cleaner clean:[[ArithmeticExpression alloc] init:$1 operator:MUL right:$2]];} %prec MUL
		|	con					{return $1;}
		|	VAR					{return [[Variable alloc] init:@"x"];};

		
con		:	NUMBER				{return [IntegerConstant construct:$1];}
		|	PI					{return [SpecialConstant PI];};

%%