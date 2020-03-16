/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoASTCUP;

import static Analizadores.IDE.ElTipoDeAmbitoRomeo;
import static Analizadores.IDE.TABLA_DE_ERRORES_SINTACTICOS;
import static Analizadores.IDE.TABLA_ReporteTS;
import Analizadores.ReporteTS;
import Analizadores.TError;
import Codigo.Entorno;
import javax.swing.JTextArea;

/**
 *
 * @author Bayyron
 */
public class Funciones1 extends NodoAbstracto{

    public Funciones1 (String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String NombreFuncion = this.Hijos.get(0).Nombre;
        if(entorno.ExisteVector(NombreFuncion)== true){
                     salida.append("#ERROR: la Funcion " + NombreFuncion +"Ya existe \n");
                    //salida.append("#ERROR: En sentencias de Funciones \n");
                    TError ERRORES = new TError("FUNCION",this.linea,this.columna,"Semantico", "#ERROR: la Funcion " + NombreFuncion +"Ya existe"  );
                    TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                    return "#ERROR";
        }
        
        int TotalSentencias = this.Hijos.get(1).Hijos.size();
        
        
         Entorno Temporal = new Entorno();
         entorno.AgregarElementosANuevoEntorno(entorno,Temporal);
         String Texto = salida.getText();
         salida.setText("");
         ElTipoDeAmbitoRomeo = "Funcion";
        for(int i = 0; i < TotalSentencias; i ++){
         String Resultado = this.Hijos.get(1).Hijos.get(i).Ejecutar(Temporal, salida);
            ElTipoDeAmbitoRomeo = "Funcion";
            //System.out.println("RESULTADO:" + Resultado);
          salida.setText("");
            if(Resultado.toUpperCase().contains("ERROR") || Resultado.contains("FINFUNCIONES")){
                    salida.setText("");
                    Texto = Texto + "#ERROR: En sentencias de Funciones \n";
                    //salida.append("#ERROR: En sentencias de Funciones \n");
                    TError ERRORES = new TError("FUNCION",this.linea,this.columna,"Semantico", "#ERROR: En sentencias de Funciones"  );
                    TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                    //salida.append(Texto);
                   
                   salida.append(Texto);
                    return "ERROR EN FUNCIONES";
            }
            
        }
     
       
        System.out.println("Vamos a declarar la funcion NombreFuncion:" + NombreFuncion
        + "TOTAL SENTENCIAS" + TotalSentencias);
       
        
        for(int i = 0; i < TotalSentencias; i ++){
             salida.setText("");
            this.Expresiones.add(this.Hijos.get(1).Hijos.get(i));
             salida.setText("");
        }
        
        salida.append(Texto);
        System.out.println("agregaremos la funcion entonces 111111111111111111111111111111111");
        //entorno = entorno.ModificandoEntornos(Temporal,entorno);
        entorno.AgregarFuncion(NombreFuncion, null, this.Expresiones, "Funcion", "");
        
        entorno.MostrarVectores();
        entorno.MostrarVectoresLista(entorno, salida);
        entorno.MostrarVectoresFuncion(entorno, salida);
        ElTipoDeAmbitoRomeo = "Global";
        ReporteTS SIMBOLO = new ReporteTS(NombreFuncion,this.linea,this.columna,"Funcion Sin Parametros",ElTipoDeAmbitoRomeo);
        TABLA_ReporteTS .add(SIMBOLO);
        salida.setText("");
        salida.append(Texto);   
        System.out.println("fin ff1");
        return "FINFUNCIONES";
    }

    
}
