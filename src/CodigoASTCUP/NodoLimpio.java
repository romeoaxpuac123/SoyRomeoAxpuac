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
public class NodoLimpio  extends NodoAbstracto{

     public NodoLimpio(String Nombre) {
        super(Nombre);
    }
    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String Salida = "";
        return this.Hijos.get(0).Nombre;
        //return "Salida";
    
    }
    
}
