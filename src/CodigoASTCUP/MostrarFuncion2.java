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
        System.out.println("aosdaomeo");
      
         System.out.println("aosdaomeo2");
      if(ElNombre.contains("addNode")){
          System.out.println("---------------------------------------->roust");
          entorno.MostrarVectoresLista(entorno, salida);
          String Vector = this.Hijos.get(1).Hijos.get(0).Ejecutar(entorno, salida);
          String Mejor =  this.Hijos.get(1).Hijos.get(0).TipoDato;
          String Resultadox = this.Hijos.get(1).Hijos.get(1).Ejecutar(entorno, salida);
          System.out.println("PASAMOAS->"+ Vector + "<-tipo->" + Mejor);
          System.out.println("PASAMOS2.>" + Resultadox);
          if(Mejor.contains("id")){
              ArrayList <NodoAbstracto> Expresiones2x = new ArrayList();
              ArrayList <NodoAbstracto> Expresiones2xx = new ArrayList();
             ArrayList <NodoAbstracto> Pokemon = new ArrayList();
              if(entorno.ExisteVector(Vector)==true){
                  System.out.println("SI EXISTE EL VECTOR");
                  if(entorno.ObtenerListaN(Vector)==1){
                      if(entorno.ExisteVector(Vector+"addNode1")==false ){
                          for(int ix = 0; ix < entorno.ObtenerLista(Vector).size(); ix++){
                          String Salida =entorno.ObtenerLista(Vector).get(ix).Ejecutar(entorno, salida);
                          System.out.println("HASTA 10->" + Salida);
                          Expresiones2x.add(entorno.ObtenerLista(Vector).get(ix));
                      }
                     
                          
                      NodoAbstracto nuevo = new Nodo("Cadena");
                      NodoAbstracto nuevovalor = new Nodo(Vector+"addNode1");
                      nuevo.Hijos.add(nuevovalor);
                      nuevo.TipoDato = "id";
                      entorno.Agregar2((Vector+"addNode1"),Expresiones2x, "Lista", "AS");
                      Pokemon.add(nuevo);
                      }else{
                          for(int u = 0; u < entorno.ObtenerLista(Vector).size(); u++){
                              Pokemon.add(entorno.ObtenerLista(Vector).get(u));
                          }
                      
                      }
                      
                  }
                  
                  for(int ix = 0; ix < entorno.ObtenerLista("SHAKALAKA").size(); ix++){
                          String Salida =entorno.ObtenerLista("SHAKALAKA").get(ix).Ejecutar(entorno, salida);
                          System.out.println("HASTA 10 SHAKALAKA->" + Salida);
                          Expresiones2xx.add(entorno.ObtenerLista("SHAKALAKA").get(ix));
                      }
                      NodoAbstracto nuevo = new Nodo("Cadena");
                      NodoAbstracto nuevovalor = new Nodo((Vector+"addNode") + (entorno.ObtenerLista(Vector).size()+1));
                      nuevo.Hijos.add(nuevovalor);
                      nuevo.TipoDato = "id";
                      entorno.Agregar2((Vector+"addNode") + (entorno.ObtenerLista(Vector).size()+1),Expresiones2xx, "Lista", "AS");
                      Pokemon.add(nuevo);
                      entorno.ModificarValorLista(Vector,Pokemon, "Lista", "List");
                      this.TipoDato = "PERRASOLA" + Vector;
                      System.out.println("el perro te encanta");
                      entorno.MostrarVectoresLista(entorno, salida);
                      System.out.println("EL PERRO TE ENCANTA FN");
                      return "FIN";
              }else{
              
              }
               /*
              for(int p = 0; p < Expresiones2x.size();p++){
                  String FlowCelestial = Expresiones2x.get(p).Ejecutar(entorno, salida);
                  System.out.println("OROOOO->" + FlowCelestial);
              }
              */
          }else{
                salida.append("ERROR, LA FUNCION " + ElNombre + " NO UTILIZA PARAMETROS" + "\n");
                        TError ERRORES = new TError(ElNombre,this.linea,this.columna,"Semantico","ERROR, LA FUNCION " + ElNombre + " NO UTILIZA PARAMETROS" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#ERROR EN FUNCIONES LLAMDA";
          }
          System.out.println("CORA->" + Vector);
          return "MOF2";
      
      }
      
      //LO NORMAL
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
             String ParametroLLamadaTipo = ListaParetrosDeLlamada.get(i).TipoDato;
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
                      System.out.println("PIEZA->" + TipoParametroLLamada);
                      Temporal.ModificarValor(ParametroVector,  ParametroLLamada, TipoParametroLLamada);
                  }else{
                        System.out.println("asdafa>" +ParametroVector + "." + TipoParametroLLamada + "." + ParametroLLamada);
                     /*   if(TipoParametroLLamada.contains("SHAKA")){
                            System.out.println("el sahaja haajaespin");
                            ArrayList <NodoAbstracto> ExpresionesS = new ArrayList();
                            ExpresionesS = Temporal.ObtenerLista("SHAKALACA");
                            Temporal.Agregar2(ParametroVector, ExpresionesS, "Lista", "AF");
                        }else{
                            Temporal.Agregar(ParametroVector, TipoParametroLLamada, ParametroLLamada);
                        }
                    */
                     if(TipoParametroLLamada.contains("Lista")){
                         Temporal.Agregar2(ParametroVector,Temporal.ObtenerLista(ParametroLLamada), "Lista", "AF");
                     }else if(TipoParametroLLamada.contains("id")){
                         Temporal.Agregar2(ParametroVector,Temporal.ObtenerLista(ParametroLLamada), entorno.ObtenerTipo(ParametroLLamada), "AF");
                     }
                     else{
                         Temporal.Agregar(ParametroVector, TipoParametroLLamada, ParametroLLamada);
                     }
                   
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
                  System.out.println("RESULTADO++A++->" + Resultado);
                 
                    if(Resultado.toUpperCase().contains("#ERROR")){
                        //vamos a ver que pedo con los errores 
                         salida.append("ERROR  EXISTE UN ERROR EN FUNCION " + ElNombre + "\n");
                        TError ERRORES = new TError(ElNombre,this.linea,this.columna,"Semantico","ERROR NO EXISTE EL VECTOR " + "ERROR NO EXISTE UN ERROR EN FUNCION " + ElNombre );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#ERROR EN FUNCIONES LLAMDA";
                    }
                   
                    if(Resultado.toUpperCase().contains("ESTOESUNRETORNOROMEO")){
                        
                        if(Resultado.toUpperCase().contains("ESTOESUNRETORNOROMEOELHOUR")){
                            System.out.println("-----------------> ELHOURELHOURELHOURELHOUR");
                            ArrayList <NodoAbstracto> Expresionesx = new ArrayList();
                            Expresionesx = Temporal.ObtenerLista("SHAKALAKA");
                             if(entorno.ExisteVector("ELHOUR")==false){
                                System.out.println("LET GO-sELHOUR");
                               entorno.Agregar2("ELHOUR", Expresionesx, "Lista", "AF");
                            }else{
                                System.out.println("NO LET GOELHOUR");
                              entorno.ModificarValorLista("ELHOUR", Expresionesx, "Lista", "AF");
                            }
                             entorno.MostrarVectoresLista(entorno, salida);
                             System.out.println("FIN DEL HOUR");
                        }
                        
                        if(Resultado.contains("ESTOESUNRETORNOROMEOSHAKALAKA")){
                            System.out.println("-----------------> shajajajajajakaala");
                            ArrayList <NodoAbstracto> Expresionesx = new ArrayList();
                            Expresionesx = Temporal.ObtenerLista("SHAKALAKA");
                            if(entorno.ExisteVector("SHAKALAKA")==false){
                                System.out.println("LET GO-s");
                               entorno.Agregar2("SHAKALAKA", Expresionesx, "Vector", "AF");
                            }else{
                                System.out.println("NO LET GO");
                              entorno.ModificarValorLista("SHAKALAKA", Expresionesx, "Vector", "AF");
                            }
                        }
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
