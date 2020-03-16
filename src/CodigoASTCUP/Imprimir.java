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
public class Imprimir extends NodoAbstracto{

    @Override
    public void Ejecutar() {
         System.err.println("Se esta ejecutnado imprimir\n");
    }

    public Imprimir(String Valor) {
        super(Valor);
    }

    @Override
    public String Ejecutar(Entorno entorno,JTextArea salida) {
        
        String val = this.Hijos.get(0).Ejecutar(entorno, salida);
        //System.out.println("----------->Se esta ejecutnado imprimir \n" + val);
        
        
        if("RomeoAxpuac".equals(val)){
            //String hola = "[";
            this.Expresiones = entorno.ObtenerLista("VectorDragonBallBeatles");
            System.out.println("asdf->" + entorno.ObtenerLista("VectorDragonBallBeatles").size());
            
        }
        if (!val.toUpperCase().contains("#ERROR")){
            salida.append(val+"\n");
           
        }else{
            TError ERRORES = new TError("Imprimir",this.linea,this.columna,"Semantico", "Error en el contenido a imprimir"  );
            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
            salida.append("#Error en el contenido a imprimir: "+val +"\n");
             return "ERROR";
        }
        return "imprimir";
    }
    
    
}
