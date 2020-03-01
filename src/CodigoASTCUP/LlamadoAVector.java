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
public class LlamadoAVector extends NodoAbstracto{
    public LlamadoAVector(String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String Identificador = this.Hijos.get(0).Nombre;
        System.out.println("DATOS LLAMADO-> Vector:" + Identificador + " POSICION->" + this.id + " TipoDato->" + entorno.ObtenerTipo(Identificador));
        if(entorno.ObtenerListaN(Identificador) ==0 && this.id ==0){
           
            this.TipoDato = entorno.ObtenerTipo(Identificador);
            
        }
        return "#ERROR: la posición no existe\n";
    }
    
}
