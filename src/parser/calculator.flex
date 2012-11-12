%{
#include <stdio.h>
%}

%%
sin		{return SIN;}
cos		{return COS;}
ln		{return LN;}
\(		{return LBR;}
\)		{return RBR;}
\^		{return POWER;}
\+		{return ADD;}
-		{return SUB;}
\*		{return MUL;}
\/		{return DIV;}
[0-9]+	{yylval.number = atoi(yytext);return NUMBER;}
d		{return DS}
\u222b	{return IS;}
dx		{return IDS;}
x		{return VAR;}
e		{return E;}
\u03c0	{return PI;}
\u
.		{yyerror();}
%%