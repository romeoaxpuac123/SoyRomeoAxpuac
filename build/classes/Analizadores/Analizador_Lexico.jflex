
package Analizadores;
import java_cup.runtime.*;

%%

%{

%}


%public
%class Analizador_Lexico
%cupsym Simbolos
%cup
%char
%column
%full
%ignorecase
%line
%unicode

entero = [0-9]+
decimal={entero}"."{entero}
cadena = [\"]([^\"\n]|(\\\"))*[\"]
id = (([A-Za-z]+)["_"|"."|0-9A-Za-z]*) | (([.][A-Za-z]+)["_"|"."|0-9A-Za-z]*)
//id = ([A-Za-z]*["_"|"."|0-9A-Za-z]*)

COMENT_UNILINEA =("#".*\r\n)|("#".*\n)|("#".*\r)
COMENT_MULTILINEA ="#*""#"* ([^*#]|[^*]"#"|"*"[^#])* "*"*"*#"

%state COMENT_SIMPLE
%state COMENT_MULTI

%%



{COMENT_UNILINEA}        {   System.out.println("--->Comentario 1 línea");} 
{COMENT_MULTILINEA}      {   System.out.println("--->Comentario multilínea");} 


<YYINITIAL> "print"     {   System.out.println("--->"+yytext()+" - Imprimir");
                            return new Symbol(Simbolos.imprimir, yycolumn, yyline, yytext());}

<YYINITIAL> "c("         {   System.out.println("--->"+yytext()+" - FuncionC");
                            return new Symbol(Simbolos.FuncionC, yycolumn, yyline, yytext());}

<YYINITIAL> "true"      {   System.out.println("--->"+yytext()+" - true");
                            return new Symbol(Simbolos.ttrue, yycolumn, yyline, yytext());}

<YYINITIAL> "false"     {   System.out.println("--->"+yytext()+" - false");
                            return new Symbol(Simbolos.tfalse, yycolumn, yyline, yytext());}

<YYINITIAL> "null"      {   System.out.println("--->"+yytext()+" - NULO");
                            return new Symbol(Simbolos.nulo, yycolumn, yyline, yytext());}

<YYINITIAL> "="         {   System.out.println("--->"+yytext()+" - igual");
                            return new Symbol(Simbolos.igual, yycolumn, yyline, yytext());}

<YYINITIAL> "+"         {   System.out.println("--->"+yytext()+" - mas");
                            return new Symbol(Simbolos.mas, yycolumn, yyline, yytext());}     
                            
<YYINITIAL> "-"         {   System.out.println("--->"+yytext()+" - menos");
                            return new Symbol(Simbolos.menos, yycolumn, yyline, yytext());}  

<YYINITIAL> "/"      {   System.out.println("--->"+yytext()+" - dividido");
                            return new Symbol(Simbolos.div, yycolumn, yyline, yytext());}     

<YYINITIAL> "*"      {   System.out.println("--->"+yytext()+" - por");
                            return new Symbol(Simbolos.por, yycolumn, yyline, yytext());}

<YYINITIAL> "^"         {   System.out.println("--->"+yytext()+" - potencia");
                            return new Symbol(Simbolos.potencia, yycolumn, yyline, yytext());}

<YYINITIAL> "%%"        {   System.out.println("--->"+yytext()+" - modulo");
                            return new Symbol(Simbolos.modulo, yycolumn, yyline, yytext());}
<YYINITIAL> "=="        {   System.out.println("--->"+yytext()+" - Igualdad");
                            return new Symbol(Simbolos.igualdad, yycolumn, yyline, yytext());}
<YYINITIAL> ">"         {   System.out.println("--->"+yytext()+" - MayorQue");
                            return new Symbol(Simbolos.MayorQue, yycolumn, yyline, yytext());}
<YYINITIAL> "<"         {   System.out.println("--->"+yytext()+" - MenorQue");
                            return new Symbol(Simbolos.MenorQue, yycolumn, yyline, yytext());}

<YYINITIAL> ">="         {   System.out.println("--->"+yytext()+" - MayorIgualQue");
                            return new Symbol(Simbolos.MayorIgualQue, yycolumn, yyline, yytext());}
<YYINITIAL> "<="         {   System.out.println("--->"+yytext()+" - MenorIgualQue");
                            return new Symbol(Simbolos.MenorIgualQue, yycolumn, yyline, yytext());}


<YYINITIAL> "&"         {   System.out.println("--->"+yytext()+" - AND");
                            return new Symbol(Simbolos.AND, yycolumn, yyline, yytext());}

<YYINITIAL> "|"         {   System.out.println("--->"+yytext()+" - OR");
                            return new Symbol(Simbolos.OR, yycolumn, yyline, yytext());}

<YYINITIAL> "!"         {   System.out.println("--->"+yytext()+" - NOT");
                            return new Symbol(Simbolos.NOT, yycolumn, yyline, yytext());}

<YYINITIAL> "?"         {   System.out.println("--->"+yytext()+" - PREGUNTAC");
                            return new Symbol(Simbolos.PREGUNTAC, yycolumn, yyline, yytext());}

<YYINITIAL> ":"         {   System.out.println("--->"+yytext()+" - DOSP");
                            return new Symbol(Simbolos.DOSP, yycolumn, yyline, yytext());}
<YYINITIAL> "!="        {   System.out.println("--->"+yytext()+" - NoIgualdad");
                            return new Symbol(Simbolos.Noigualdad, yycolumn, yyline, yytext());}
<YYINITIAL> ";"         {   System.out.println("--->"+yytext()+" - punto y coma v*****v*****v*****v*****v*****\n");
                            return new Symbol(Simbolos.puntoycoma, yycolumn, yyline, yytext());}

<YYINITIAL> "{"         {   System.out.println("--->"+yytext()+" - llave abrir");
                            return new Symbol(Simbolos.llaveabrir, yycolumn, yyline, yytext());}

<YYINITIAL> "}"         {   System.out.println("--->"+yytext()+" - llave cerrar");
                            return new Symbol(Simbolos.llavecerrar, yycolumn, yyline, yytext());}

<YYINITIAL> "("         {   System.out.println("--->"+yytext()+" - llave abrir");
                            return new Symbol(Simbolos.parentesisabrir, yycolumn, yyline, yytext());}

<YYINITIAL> ")"         {   System.out.println("--->"+yytext()+" - llave cerrar");
                            return new Symbol(Simbolos.parentesiscerrar, yycolumn, yyline, yytext());}

<YYINITIAL> "["         {   System.out.println("--->"+yytext()+" - Corchete abrir");
                            return new Symbol(Simbolos.corcheteabrir, yycolumn, yyline, yytext());}

<YYINITIAL> "]"         {   System.out.println("--->"+yytext()+" - Corchete cerrar");
                            return new Symbol(Simbolos.corchetecerrar, yycolumn, yyline, yytext());}

<YYINITIAL> ","         {   System.out.println("--->"+yytext()+" - coma");
                            return new Symbol(Simbolos.coma, yycolumn, yyline, yytext());}



<YYINITIAL> {entero}    {   System.out.println("--->"+yytext()+" - entero");
                            return new Symbol(Simbolos.entero, yycolumn, yyline, yytext());}

<YYINITIAL> {decimal}    {   System.out.println("--->"+yytext()+" - decimal");
                            return new Symbol(Simbolos.decimal, yycolumn, yyline, yytext());}                            

<YYINITIAL> {id}        {   System.out.println("--->"+yytext()+" - id");
                            return new Symbol(Simbolos.id, yycolumn, yyline, yytext());}
<YYINITIAL> {cadena}    {   System.out.println("--->"+yytext()+" - CADENA");
                            return new Symbol(Simbolos.cadena, yycolumn, yyline, yytext());}


[ \t\r\n\f]             {/* Se ignora */ }
 

.                       {   System.out.println("#Error léxico: <"+yytext()+"> Linea: "+yyline+" ,Columna: "+yycolumn);}

