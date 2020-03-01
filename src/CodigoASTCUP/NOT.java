/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoASTCUP;
import Codigo.Entorno;
import javax.swing.JTextArea;
/**
 *
 * @author Bayyron
 */
public class NOT extends NodoAbstracto{

    public NOT(String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
    String val1 = this.Hijos.get(1).Ejecutar(entorno, salida);
        String Tipo1 = this.Hijos.get(1).TipoDato; 
        if (val1.equalsIgnoreCase("#Error")){
            return "#Error";
        }
         if("booleano".equals(Tipo1)){        
             if("true".equals(val1)){
                 return "false";
             }
             else if("false".equals(val1)){
                 return "true";
             }
             else{
                 return "#Error";
             }
         }    
         return "#Error";
    
    }
}
