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
public class Ternario extends NodoAbstracto{

    public Ternario(String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        String val0 = this.Hijos.get(0).Ejecutar(entorno, salida);
        String val1 = this.Hijos.get(1).Ejecutar(entorno, salida);
         String Tipo1 = this.Hijos.get(1).TipoDato; 
        String val2 = this.Hijos.get(2).Ejecutar(entorno, salida);
         String Tipo2 = this.Hijos.get(2).TipoDato; 
        if (val0.equalsIgnoreCase("#Error")||val1.equalsIgnoreCase("#Error")||val2.equalsIgnoreCase("#Error")){
            return "#Error";
        }
        if("true".equals(val0)){
                this.TipoDato = Tipo1;
                 return val1;
        }else if("false".equals(val0)){
                 this.TipoDato = Tipo2;
                 return val2;
        }else{
            return "#Error";
        }
        
    }

    
}
