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
        System.out.println("entrmos a la llamada de un vector");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String Identificador = this.Hijos.get(0).Nombre;
        if(entorno.ExisteVector(Identificador) == false){
            System.out.println("El Vector: " + Identificador + "No Existe");
                salida.append("#ERROR1: Al llamar miembro del vector "+ Identificador + " se produjo un error, revisar posición o nombre del mismo \n");
                TError ERRORES = new TError(Identificador,this.linea,this.columna,"Semantico", "#ERROR: Al llamar miembro del vector "+ Identificador + " se produjo un error, revisar posición o nombre del mismo"  );
                TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                System.out.println("ERROR");
            return "#Error el vector no existe";
        }
        System.out.println("DATOS LLAMADO-> Vector:" + Identificador + " POSICION->" + this.id + " TipoDato->" + entorno.ObtenerTipo(Identificador));
        if(entorno.ObtenerListaN(Identificador) ==0 && this.id !=0){
           
            this.TipoDato = entorno.ObtenerTipo(Identificador);
            return "FINLLAMADOVECTOR";
            
        }
                salida.append("#ERROR: Al llamar miembro del vector "+ Identificador + " se produjo un error, revisar posición o nombre del mismo \n");
                TError ERRORES = new TError(Identificador,this.linea,this.columna,"Semantico", "#ERROR: Al llamar miembro del vector "+ Identificador + " se produjo un error, revisar posición o nombre del mismo"  );
                TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                System.out.println("ERROR");
        
        return "#ERROR: la posición no existe\n";
    }
    
}
