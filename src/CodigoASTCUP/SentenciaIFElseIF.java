/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoASTCUP;

import static Analizadores.IDE.TABLA_DE_ERRORES_SINTACTICOS;
import Analizadores.TError;
import Codigo.Entorno;
import javax.swing.JTextArea;

/**
 *
 * @author Bayyron
 */
public class SentenciaIFElseIF extends NodoAbstracto{

    public SentenciaIFElseIF(String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        System.out.println("EJECUTANDO IF ELSE IF");
        System.out.println("Total de else if: " + this.Expresiones.size());
        String ValorExpresion = this.Hijos.get(0).Ejecutar(entorno, salida);
        System.out.println("->"+ ValorExpresion);
        switch (ValorExpresion.toLowerCase()) {
            case "true":
                    if(this.Expresiones2.size() == 0){
                    salida.append("#ERROR: La Sentencia del IF es incorrecta \n");
                    TError ERRORES = new TError("IF",this.linea,this.columna,"Semantico", "ERROR: La Sentencia del IF es incorrecta"  );
                    TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                    
                }else{
                    System.out.println("ejecutemos sentencias");
                    Entorno Temporal = new Entorno();
                    entorno.AgregarElementosANuevoEntorno(entorno,Temporal);
                    //String ValorExpresion2 = this.Hijos.get(1).Ejecutar(entorno, salida);
                    //String nombre = this.Hijos.get(1).Nombre;
                    System.out.println("-><-" + this.Expresiones2.size() + "<->");
                    for(int i = 0; i < this.Expresiones2.size();i++){
                        this.Expresiones2.get(i).Ejecutar(Temporal, salida);
                    }
                    entorno = entorno.ModificandoEntornos(Temporal,entorno);
                     return "FIN ELSE";
                }
                break;
            case "false":
                   int bander = 0;
                   for(int i = 0 ; i < this.Expresiones.size();i++){
                        String Resultado = this.Expresiones.get(i).Hijos.get(0).Ejecutar(entorno, salida);
                        int tamanioSentencia = this.Expresiones.get(i).Expresiones.size();
                        
                         switch (Resultado.toLowerCase()) {
                            case "true":
                                Entorno Temporal = new Entorno();
                                entorno.AgregarElementosANuevoEntorno(entorno,Temporal);
                                for(int x = 0; x < tamanioSentencia; x++){
                                    String Resultadox = this.Expresiones.get(i).Expresiones.get(x).Ejecutar(Temporal, salida);
                                    bander = 1;
                                }
                                entorno = entorno.ModificandoEntornos(Temporal,entorno);
                                break;
                            case "false":
                            break;
                            default:
                                salida.append("#ERROR: La Expresión del IF es incorrecta \n");
                                TError ERRORES = new TError("IF",this.linea,this.columna,"Semantico", "La Expresión del IF es incorrecta"  );
                                TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                                System.out.println("ERROR");
                                break;
                         }
                        if(bander == 1){
                            return "FIN ELSE";
                        }
                                               
                        //System.out.println("Resultado del if else" + i + "-->" + Resultado + "<>" + tamanioSentencia );
                    }
                   //System.out.println("VAMOS A HACER EL ELSE" + );
                   Entorno Temporal = new Entorno();
                       entorno.AgregarElementosANuevoEntorno(entorno,Temporal);
                   for(int i = 0 ; i < this.Expresiones3.size();i++){
                       
                        String Resultadox = this.Expresiones3.get(i).Ejecutar(Temporal, salida);
                        
                   }
                   entorno = entorno.ModificandoEntornos(Temporal,entorno);
                   return "FIN ELSE";
                
            default:
                salida.append("#ERROR: La Expresión del IF es incorrecta \n");
                TError ERRORES = new TError("IF",this.linea,this.columna,"Semantico", "La Expresión del IF es incorrecta"  );
                TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                System.out.println("ERROR");
                break;
        }
        
     
        return "FIN ELSEIF";
    }

    
}
