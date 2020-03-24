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
public class MostrarFuncion2 extends NodoAbstracto{

    public MostrarFuncion2(String Nombre) {
        super(Nombre);
    }
    public static String Resultadox;
    public static String TipoPPPP;
    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
    //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      System.out.println("FUNCION CON PARAMETROS COMO SENTENCIA");
      String ElNombre = this.Hijos.get(0).Nombre;
      int totalParmetros = this.Hijos.get(1).Hijos.size();
      ArrayList <NodoAbstracto> ListaParetrosDeLlamada = new ArrayList <NodoAbstracto>();
      ArrayList <NodoAbstracto> ListaParetrosDeLaFuncion = entorno.ListaParetros(ElNombre);
      ArrayList <NodoAbstracto> ListaSentencias = entorno.ListaSentenciasFuncion(ElNombre);
      System.out.println("NOMBRE FUNCION:->" + ElNombre + "<->" + totalParmetros);
     
     
     
      
      
      
      System.out.println("NOMBRE FUNCION:->" + ElNombre + "<->" + totalParmetros);
      if(ListaParetrosDeLaFuncion == null){
                     salida.append("ERROR, LA FUNCION " + ElNombre + " NO UTILIZA PARAMETROS" + "\n");
                        TError ERRORES = new TError(ElNombre,this.linea,this.columna,"Semantico","ERROR, LA FUNCION " + ElNombre + " NO UTILIZA PARAMETROS" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#ERROR EN FUNCIONES LLAMDA";
      }
      for(int i = 0; i < totalParmetros; i ++){
            ListaParetrosDeLlamada.add(this.Hijos.get(1).Hijos.get(i));
      }
      if(ListaParetrosDeLlamada.size() != ListaParetrosDeLaFuncion.size()){
                        salida.append("ERROR, LA FUNCION " + ElNombre + " NO CONCUERDA CON LOS PARAMETROS" + "\n");
                        TError ERRORES = new TError(ElNombre,this.linea,this.columna,"Semantico","ERROR, LA FUNCION " + ElNombre + " NO CONCUERDA CON LOS PARAMETROS" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#ERROR EN FUNCIONES LLAMDA";
      }else{
          Entorno Temporal = new Entorno();
          Temporal.AgregarElementosANuevoEntorno(entorno,Temporal);
          System.out.println("DELCARACION DE PARAMETROS----------------");
          ElTipoDeAmbitoRomeo = "FUNCION";
          for(int i = 0; i < totalParmetros; i ++){
              
             String ParametroLLamada = ListaParetrosDeLlamada.get(i).Ejecutar(Temporal, salida);
             String TipoParametroLLamada = ListaParetrosDeLlamada.get(i).TipoDato;
             String ParametroVector = ListaParetrosDeLaFuncion.get(i).Ejecutar(Temporal, salida);
              System.out.println("*************************************+LLAMADA->" + ParametroLLamada + "<->FUNCION" + ParametroVector);
             
              if(ParametroVector.contains("FIN DECLARAR ASGINAR")){
                  //SI ESA ONDA ES DEFAULT :X
                  System.out.println("------------------------------->" + ParametroVector);
                  if(!ParametroLLamada.toUpperCase().contains("DEFAULT")){
                        salida.append("ERROR, LA FUNCION " + ElNombre + " TIENE UNA EXPRESIÓN CUANDO YA TIENE UN VALOR ASIGNADO" + "\n");
                        TError ERRORES = new TError(ElNombre,this.linea,this.columna,"Semantico","ERROR, LA FUNCION " + ElNombre + " TIENE UNA EXPRESIÓN CUANDO YA TIENE UN VALOR ASIGNADO" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#ERROR EN FUNCIONES LLAMDA";
                  }
              }else{
                  //ASIGNACION DE VECTORES
                  System.out.println("moficando valores");
                  if(Temporal.ExisteVector(ParametroVector)==true){
                      Temporal.ModificarValor(ParametroVector,  ParametroLLamada, TipoParametroLLamada);
                  }else{
                        System.out.println("asdafa>" +ParametroVector + "." + TipoParametroLLamada + "." + ParametroLLamada);
                    Temporal.Agregar(ParametroVector, TipoParametroLLamada, ParametroLLamada);
                   
                  }
       
            
           }
                       System.out.println("puta");
                      // Temporal.MostrarVectores();
                      // Temporal.MostrarVectoresLista(Temporal, salida);
                       System.out.println("---");
              }
              //expresiones
              for(int i = 0; i < ListaSentencias.size();i++){
                  String Resultado = ListaSentencias.get(i).Ejecutar(Temporal, salida);
                  String tipoxx = ListaSentencias.get(i).TipoDato;
                  System.out.println("RESULTADO++++->" + Resultado);
                 
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
                        
                        System.out.println("Valor a RetornarMF2->" + Resultado + "Tipo->" + this.TipoDato);
                        Temporal.MostrarVectores();
                        Temporal.MostrarVectoresLista(Temporal, salida);
                         System.out.println("--");
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
                         //Resultadox = Resultado;
                         //TipoPPPP = this.TipoDato;
                        System.out.println("ROMEOOOOOOOOOOOOO");
                        entorno.MostrarVectoresLista(entorno, salida);
                        System.out.println("Resultado:" + Resultado+"<->");
                        System.out.println("Tipo->" + this.TipoDato);
                       //this.TipoDato = "cadena";
                       //entorno = entorno.ModificandoEntornos(Temporal,entorno);
                        return Resultado;
                        //break;
                    }
                   // entorno = entorno.ModificandoEntornos(Temporal,entorno);
              }
      }
      
        System.out.println("salimos ");
        
          this.TipoDato = TipoPPPP;
          ElTipoDeAmbitoRomeo = "GLOBAL";
      return "";
    }
    
}
