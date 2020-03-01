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
public class Negativo extends NodoAbstracto{

    public Negativo(String Nombre) {
        super(Nombre);
    }
    
    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        int total = 0;
        double totald = 0;
        String totalc = "";
        String val1 = this.Hijos.get(1).Ejecutar(entorno, salida);
        String Tipo1 = this.Hijos.get(1).TipoDato; 
        if (val1.equalsIgnoreCase("#Error")){
            return "#Error";
        }
         if("entero".equals(Tipo1)){        
            int valor1 = Integer.parseInt(val1);
            total = valor1 * -1;
              return Integer.toString(total);
         }else if("decimal".equals(Tipo1)){
             double valor1 = Double.parseDouble(val1);
             totald = valor1 * -1;
             return String.valueOf(totald);
         }
    return "#Error";      
    }
    
}
