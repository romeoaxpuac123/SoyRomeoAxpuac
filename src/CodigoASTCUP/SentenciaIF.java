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
public class SentenciaIF extends NodoAbstracto{

    public SentenciaIF (String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        System.out.println("Se esta ejecutando el if");
        String ValorExpresion = this.Hijos.get(0).Ejecutar(entorno, salida);
        System.out.println("->"+ ValorExpresion);
        //if(!"true".equals(ValorExpresion) || !"false".equals(ValorExpresion)){
        //    System.out.println("ERROR EN LA EXPRESION");
        //     return "#Error";
        // }
        
        switch (ValorExpresion.toLowerCase()) {
            case "true":
                System.out.println("PUES SI ENTRO AL IF");
                if(this.Expresiones.size() == 0){
                    salida.append("#ERROR: La Sentencia del IF es incorrecta \n");
                    TError ERRORES = new TError("IF",this.linea,this.columna,"Semantico", "ERROR: La Sentencia del IF es incorrecta"  );
                    TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                }else{
                    System.out.println("ejecutemos sentencias");
                    //String ValorExpresion2 = this.Hijos.get(1).Ejecutar(entorno, salida);
                    //String nombre = this.Hijos.get(1).Nombre;
                    System.out.println("-><-" + this.Expresiones.size() + "<->");
                    for(int i = 0; i < this.Expresiones.size();i++){
                        this.Expresiones.get(i).Ejecutar(entorno, salida);
                    }
                }
                break;
            case "false":
                System.out.println("PUES NO ENTRO AL IF");
                if(this.Hijos.get(2)!= null){
                    System.out.println("-><-" + this.Expresiones2.size() + "<->");
                    for(int i = 0; i < this.Expresiones2.size();i++){
                        this.Expresiones2.get(i).Ejecutar(entorno, salida);
                    }
                }
                break;
            default:
                salida.append("#ERROR: La Expresión del IF es incorrecta \n");
                TError ERRORES = new TError("IF",this.linea,this.columna,"Semantico", "La Expresión del IF es incorrecta"  );
                TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                System.out.println("ERROR");
                break;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return "Fin IF";
    }
    
    
}
