package Analizadores;


import CodigoASTCUP.NodoAbstracto;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.control.TextArea;

/**
 *
 * @author Pavel
 */
public class Arbol {

    private ArrayList<NodoAbstracto> instrucciones;
 
    private TextArea consola;
   

    public Arbol(ArrayList<NodoAbstracto> instrucciones) {
        this.instrucciones = instrucciones;
      
    }
    
    

    public ArrayList<NodoAbstracto> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(ArrayList<NodoAbstracto> instrucciones) {
        this.instrucciones = instrucciones;
    }

   
    public TextArea getConsola() {
        return consola;
    }

    public void setConsola(TextArea consola) {
        this.consola = consola;
    }


    
}
