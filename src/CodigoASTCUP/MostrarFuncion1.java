/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoASTCUP;

import static Analizadores.IDE.ElTipoDeAmbitoRomeo;
import static Analizadores.IDE.TABLA_DE_ERRORES_SINTACTICOS;
import Analizadores.TError;
import Codigo.Entorno;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Bayyron
 */
public class MostrarFuncion1 extends NodoAbstracto{
    public static String Resultadox;
    public static String TipoPPPP;
    public MostrarFuncion1(String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String ElNombre = this.Hijos.get(0).Nombre;
        Entorno Temporal = new Entorno();
        entorno.AgregarElementosANuevoEntorno(entorno,Temporal);
        if(Temporal.ExisteVector(ElNombre)==true){
            System.out.println("vamos a correr la funcion sin parametros->" + ElNombre);
            ArrayList <NodoAbstracto> ListaParetros = Temporal.ListaParetros(ElNombre);
            ArrayList <NodoAbstracto> ListaSentencias = Temporal.ListaSentenciasFuncion(ElNombre);
            ElTipoDeAmbitoRomeo = "FUNCION";
            if(ListaParetros == null){
                for(int i = 0; i< ListaSentencias.size(); i++){
                    String Resultado = ListaSentencias.get(i).Ejecutar(Temporal, salida);
                    System.out.println("EL RESULADO DE MF1->" + Resultado);
                    int xp = ListaSentencias.get(i).id;
                    if(Resultado.toUpperCase().contains("#ERROR")){
                        //vamos a ver que pedo con los errores 
                         salida.append("ERROR  EXISTE UN ERROR EN FUNCION " + ElNombre + "\n");
                        TError ERRORES = new TError(ElNombre,this.linea,this.columna,"Semantico","ERROR NO EXISTE EL VECTOR " + "ERROR NO EXISTE UN ERROR EN FUNCION " + ElNombre );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#ERROR EN FUNCIONES LLAMDA";
                    }
                    if(Resultado.toUpperCase().contains("ESTOESUNRETORNOROMEO")){
                      
                        this.TipoDato = ListaSentencias.get(i).TipoDato;
                        Resultado = Resultado.replaceAll("ESTOESUNRETORNOROMEO", "");
                        
                        System.out.println("Valor a RetornarMF1->" + Resultado + "<-Tipo->" + this.TipoDato);
                        Temporal.MostrarVectores();
                        Temporal.MostrarVectoresLista(entorno, salida);
                         System.out.println("--");
                       
                         Resultadox = Resultado;
                         
                        if(this.TipoDato.contains("id")){
                             //if(entorno.ob)
                             if(Temporal.ObtenerListaN(Resultado)==0){
                                 System.out.println("ES 1");
                                 this.TipoDato = Temporal.ObtenerTipo(Resultado);
                                Resultado = Temporal.ObtenerValor(Resultado);
                             }else{
                                System.out.println("ES LARGO");
                                 if(Temporal.ObtenerTipo(Resultado).toUpperCase().contains("LISTA")){
                                     //SE RETORNA UNA LISTA.
                                     
                                 }else{
                                     //se retorna un vector
                                     //Resultado = "hola mundo";
                                     this.Nombre = Resultado;
                                     if(entorno.ExisteVector(Resultado)== true){
                                            entorno.ModificarValorLista(Resultado, Temporal.ObtenerLista(Resultado), Temporal.ObtenerTipo(Resultado), "adsf");
                                    }else{
                                        entorno.Agregar2(Resultado, Temporal.ObtenerLista(Resultado), Temporal.ObtenerTipo(Resultado), "adsf");
                                    
                                    }
                                 }
                             
                             }
                              
                         }
                         
                         //TipoPPPP = this.TipoDato;
                       // for(int ix = 0; ix < entorno.ObtenerLista(Resultado).size(); ix++){
                           // String Hola = entorno.ObtenerLista(Resultado).get(ix).Ejecutar(entorno, salida);
                           // System.out.println("HOLA->" + Hola);
                       // }
                        System.out.println("ROMEOOOOOOOOOOOOO");
                        System.out.println("Resultado:" + Resultado);
                        System.out.println("Tipo->" + this.TipoDato);
                        return Resultado;
                        
                        
                        
                        //break;
                    }
                    //entorno = entorno.ModificandoEntornos(Temporal,entorno);
                }
            
            }else{
                //Esta función debe tener parametros
                        salida.append("ERROR ESTA FUNCIÓN NO TIENE PARAMETROS " + ElNombre);
                        TError ERRORES = new TError(ElNombre,this.linea,this.columna,"Semantico","ERROR NO EXISTE EL VECTOR " + "ERROR ESTA FUNCIÓN NO TIENE PARAMETROS" + ElNombre );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#ERROR EN FUNCIONES LLAMDA";
            }
        }else{
                        salida.append("ERROR NO EXISTE LA FUNCION " + ElNombre);
                        TError ERRORES = new TError( ElNombre,this.linea,this.columna,"Semantico","ERROR NO EXISTE LA FUNCION " + ElNombre );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#ERROR EN FUNCIONES LLAMDA";
        }
        
        
    ElTipoDeAmbitoRomeo = "GLOBAL";
        return Resultadox;
    }

    
}
