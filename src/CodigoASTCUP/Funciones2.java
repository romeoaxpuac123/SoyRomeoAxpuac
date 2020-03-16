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
public class Funciones2 extends NodoAbstracto{

    public Funciones2 (String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("FUNCION CON PARAMETROS");
        String NombreFuncion = this.Hijos.get(0).Nombre;
        if(entorno.ExisteVector(NombreFuncion)== true){
                     salida.append("#ERROR: la Funcion " + NombreFuncion +"Ya existe \n");
                    //salida.append("#ERROR: En sentencias de Funciones \n");
                    TError ERRORES = new TError("FUNCION",this.linea,this.columna,"Semantico", "#ERROR: la Funcion " + NombreFuncion +"Ya existe"  );
                    TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                    return "#ERROR";
        }
        int TotalParametros = this.Hijos.get(1).Hijos.size();
        int TotalSentencias = this.Hijos.get(2).Hijos.size();
        Entorno Temporal = new Entorno();
        entorno.MostrarVectoresFuncion(entorno, salida);
        System.out.println("<-->");
       
        entorno.AgregarElementosANuevoEntorno(entorno,Temporal);
        String Texto = salida.getText();
        salida.setText("");
        
        this.Expresiones.clear();
        this.Expresiones.add(this.Hijos.get(1));
        
        for(int i = 0; i < TotalParametros; i ++){
        
            this.Expresiones.add( this.Hijos.get(1).Hijos.get(i));
        }
       
        
        //VAMOS A PROBAR LOS PARAMETROS :D
       
        
        //Temporal.MostrarVectores();
        //Temporal.MostrarVectoresLista(Temporal, salida);
        System.out.println("FUNCION:->" + NombreFuncion + "<PARAMETROAS->" + TotalParametros + "<-SENTENCIAS->" + TotalSentencias);
        //VAMOS A PROBAR LAS EXPRESIONES
        ElTipoDeAmbitoRomeo = "Funcion";
        for(int i = 0; i < TotalSentencias; i ++){
         String Resultado = this.Hijos.get(2).Hijos.get(i).Ejecutar(Temporal, salida);
        ElTipoDeAmbitoRomeo = "Funcion";
            System.out.println("RESULTADO:" + Resultado);
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
        //entorno = entorno.ModificandoEntornos(Temporal,entorno);
        for(int i = 0; i < TotalSentencias; i ++){
             salida.setText("");
            this.Expresiones2.add(this.Hijos.get(2).Hijos.get(i));
             salida.setText("");
        }
        
         salida.append(Texto);
        System.out.println("agregaremos la funcion entonces----------------------------------------");
        entorno.AgregarFuncion(NombreFuncion,  this.Expresiones, this.Expresiones2, "Funcion", "");
       
        entorno.MostrarVectores();
        entorno.MostrarVectoresLista(entorno, salida);
        entorno.MostrarVectoresFuncion(entorno, salida);
        ElTipoDeAmbitoRomeo = "Global";
         ReporteTS SIMBOLO = new ReporteTS(NombreFuncion,this.linea,this.columna,"Funcion Con Parametros",ElTipoDeAmbitoRomeo);
        TABLA_ReporteTS .add(SIMBOLO);
        salida.setText("");
        salida.append(Texto);

        return "FINFUNCIONES";
        
    }

}
