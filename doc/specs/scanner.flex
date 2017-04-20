package compiler.lexical;

import compiler.syntax.sym;
import compiler.lexical.Token;
import es.uned.lsi.compiler.lexical.ScannerIF;
import es.uned.lsi.compiler.lexical.LexicalError;
import es.uned.lsi.compiler.lexical.LexicalErrorManager;

// incluir aqui, si es necesario otras importaciones

%%
 
%public
%class Scanner
%char
%line
%column
%cup
%unicode
%full

%implements ScannerIF
%scanerror LexicalError

%{
  LexicalErrorManager lexicalErrorManager = new LexicalErrorManager ();
  private int commentCount = 0;
  private int commentLine = 0;
  private int commentCol = 0;

%} 

%eof{
        if (commentCount > 0) {
              LexicalError error = new LexicalError ("Error lexico.");
              error.setLine (commentLine);
              error.setColumn (commentCol);
              lexicalErrorManager.lexicalFatalError (error);
          }
        
%eof}
 


digito = [0-9]
caracter = [a-zA-Z]


identificador = {caracter}({caracter}|{digito})*

nueva_linea = \r|\n|\r\n
espacio_en_blanco = {nueva_linea}|[ \t\f]

entero = 0|[1-9][0-9]*


texto_comentario = [^/*]|[^*\\]

comillas = \"
cadena = {comillas}.*{comillas}
  
//Estados
%state COMENTARIO  
  
%%



<YYINITIAL> 
{

"/*" {	commentCount = commentCount + 1;
		commentLine = yyline + 1;
		commentCol = yycolumn + 1;
		
		yybegin(COMENTARIO);	}

{espacio_en_blanco}    {}
{nueva_linea} {}								

{entero} {
                           Token token = new Token (sym.NUM);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;

}

 "#define"           {  
                           Token token = new Token (sym.CONSTANT);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }

 "else"           {  
                           Token token = new Token (sym.ELSE);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }
                        
 "for"           {  
                           Token token = new Token (sym.FOR);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }
                        
 "if"           {  
                           Token token = new Token (sym.IF);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }                        
                                                
                                                
 "int"           {  
                           Token token = new Token (sym.INT);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }
                        
 "main"           {  
                           Token token = new Token (sym.MAIN);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }
                        
 "printc"           {  
                           Token token = new Token (sym.PRINTC);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        } 
                        
 "printi"           {  
                           Token token = new Token (sym.PRINTI);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }
                        
 "return"           {  
                           Token token = new Token (sym.RETURN);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }                                                                        
 "struct"           {  
                           Token token = new Token (sym.STRUCT);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }
                        
  "void"           {  
                           Token token = new Token (sym.VOID);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }                          
                                                                                                 

           			       
    "-"                {  
                           Token token = new Token (sym.MINUS);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }
                        
    "="                {  
                           Token token = new Token (sym.ASSIGMENT);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }  
                                              
    ";"                {  
                           Token token = new Token (sym.SEMICOLON);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }
                        
    "("                {  
                           Token token = new Token (sym.OBRACKET);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }  
                           
    ")"                {  
                           Token token = new Token (sym.CBRACKET);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }
                        
    "{"                {  
                           Token token = new Token (sym.OBRACE);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }
                        
    "}"                {  
                           Token token = new Token (sym.CBRACE);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }  
                         
                         
    "."                {  
                           Token token = new Token (sym.POINT);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        } 
                        
    "=="                {  
                           Token token = new Token (sym.EQUAL);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }   
                        
    ">"                {  
                           Token token = new Token (sym.MORE);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        } 
                        
    "||"                {  
                           Token token = new Token (sym.OR);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }  
                        
    ","                {  
                           Token token = new Token (sym.COMMA);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }    
                        
    {cadena}         {  
                           Token token = new Token (sym.TCHAIN);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }  

	{identificador} {  
                           Token token = new Token (sym.ID);
                           token.setLine (yyline + 1);
                           token.setColumn (yycolumn + 1);
                           token.setLexema (yytext ());
           			       return token;
                        }                                                                                                                                                                                                                                                                                                              
                                                                                                                                                                                                                        
                    
    
	[^]     
                        {                                               
                           LexicalError error = new LexicalError ("Error lexico: Por favor revise su codigo");
                           error.setLine (yyline + 1);
                           error.setColumn (yycolumn + 1);
                         
                           lexicalErrorManager.lexicalFatalError (error);
                        }
    
}

<COMENTARIO>{ 

			  "/*" { commentCount = commentCount + 1;}

              "*/" { 
				commentCount = commentCount - 1;
				assert(commentCount >= 0);
				if(commentCount == 0)
					yybegin(YYINITIAL);			
			  }
		
           	  {texto_comentario} {}
           
               // error en caso de coincidir con ningun patron
			  [^]
			  {                                               
                   LexicalError error = new LexicalError ("Error lexico: Por favor revise su codigo");
                   error.setLine (yyline + 1);
                   error.setColumn (yycolumn + 1);
                   lexicalErrorManager.lexicalFatalError (error);
               
               }
}


                         


