
package Analizadores;
import java_cup.runtime.*;
import  Analizadores.IDE.TABLA_DE_ERRORES_SINTACTICOS;
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

COMENT_UNILINEA =("#".*\r\n)|("#".*\n)|("#".*\r)
COMENT_MULTILINEA ="#*""#"* ([^*#]|[^*]"#"|"*"[^#])* "*"*"*#"

%state COMENT_SIMPLE
%state COMENT_MULTI

%%



{COMENT_UNILINEA}        {   System.out.println("--->Comentario 1 línea");} 
{COMENT_MULTILINEA}      {   System.out.println("--->Comentario multilínea");} 

<YYINITIAL> "barplot"     {   System.out.println("--->"+yytext()+" - barplot");
                            return new Symbol(Simbolos.barplot, yycolumn, yyline, yytext());}

<YYINITIAL> "pie"     {   System.out.println("--->"+yytext()+" - pie");
                            return new Symbol(Simbolos.pie, yycolumn, yyline, yytext());}

<YYINITIAL> "mean"     {   System.out.println("--->"+yytext()+" - mean");
                            return new Symbol(Simbolos.mean, yycolumn, yyline, yytext());}

<YYINITIAL> "median"     {   System.out.println("--->"+yytext()+" - median");
                            return new Symbol(Simbolos.median, yycolumn, yyline, yytext());}

<YYINITIAL> "mode"     {   System.out.println("--->"+yytext()+" - mode");
                            return new Symbol(Simbolos.mode, yycolumn, yyline, yytext());}


<YYINITIAL> "round"     {   System.out.println("--->"+yytext()+" - round");
                            return new Symbol(Simbolos.round, yycolumn, yyline, yytext());}

<YYINITIAL> "trunk"     {   System.out.println("--->"+yytext()+" - trunk");
                            return new Symbol(Simbolos.trunk, yycolumn, yyline, yytext());}

<YYINITIAL> "touppercase"    {   System.out.println("--->"+yytext()+" - touppercase");
                            return new Symbol(Simbolos.touppercase, yycolumn, yyline, yytext());}

<YYINITIAL> "tolowercase"    {   System.out.println("--->"+yytext()+" - tolowercase");
                            return new Symbol(Simbolos.tolowercase, yycolumn, yyline, yytext());}

<YYINITIAL> "remove"    {   System.out.println("--->"+yytext()+" - remove");
                            return new Symbol(Simbolos.remove, yycolumn, yyline, yytext());}

<YYINITIAL> "stringlength"     {   System.out.println("--->"+yytext()+" - stringlength");
                            return new Symbol(Simbolos.stringlength, yycolumn, yyline, yytext());}

<YYINITIAL> "length"     {   System.out.println("--->"+yytext()+" - length");
                            return new Symbol(Simbolos.length, yycolumn, yyline, yytext());}

<YYINITIAL> "typeof"      {   System.out.println("--->"+yytext()+" - typeof");
                            return new Symbol(Simbolos.typeof, yycolumn, yyline, yytext());}

<YYINITIAL> "list"      {   System.out.println("--->"+yytext()+" - LISTA");
                            return new Symbol(Simbolos.LISTA, yycolumn, yyline, yytext());}

<YYINITIAL> "if"        {   System.out.println("--->"+yytext()+" - IF");
                            return new Symbol(Simbolos.IF, yycolumn, yyline, yytext());}

<YYINITIAL> "else"      {   System.out.println("--->"+yytext()+" - ELSE");
                            return new Symbol(Simbolos.ELSE, yycolumn, yyline, yytext());}

<YYINITIAL> "while"      {   System.out.println("--->"+yytext()+" - WHILE");
                            return new Symbol(Simbolos.WHILE, yycolumn, yyline, yytext());}

<YYINITIAL> "do"      {   System.out.println("--->"+yytext()+" - DO");
                            return new Symbol(Simbolos.DO, yycolumn, yyline, yytext());}

<YYINITIAL> "for"      {   System.out.println("--->"+yytext()+" - FOR");
                            return new Symbol(Simbolos.FOR, yycolumn, yyline, yytext());}

<YYINITIAL> "in"      {   System.out.println("--->"+yytext()+" - IN");
                            return new Symbol(Simbolos.IN, yycolumn, yyline, yytext());}

<YYINITIAL> "break"      {   System.out.println("--->"+yytext()+" - BREAK");
                            return new Symbol(Simbolos.BREAK, yycolumn, yyline, yytext());}

<YYINITIAL> "continue"      {   System.out.println("--->"+yytext()+" - CONTINUE");
                            return new Symbol(Simbolos.CONTINUE, yycolumn, yyline, yytext());}

<YYINITIAL> "switch"      {   System.out.println("--->"+yytext()+" - SWITCH");
                            return new Symbol(Simbolos.SWITCH, yycolumn, yyline, yytext());}

<YYINITIAL> "case"      {   System.out.println("--->"+yytext()+" - CASE");
                            return new Symbol(Simbolos.CASE, yycolumn, yyline, yytext());}

<YYINITIAL> "default"      {   System.out.println("--->"+yytext()+" - DEF");
                            return new Symbol(Simbolos.DEF, yycolumn, yyline, yytext());}



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
 

.                       {   
                            String TipoError = "Lexico ";
                            String Descripcion = "El Caracter:" + yytext() + " no pertenece al lenguaje";
                            String Fila = " Fila: " + yyline;
                            String Columna = " Columna: " + yycolumn;
                            System.out.println("#ERROR"  + TipoError + Descripcion + Fila + Columna );
                            TError ERRORES = new TError(yytext(),yyline,yycolumn,TipoError, Descripcion);
                            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                            System.out.println(" al agran puta");
                        }

