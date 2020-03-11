/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoASTCUP;

import static Analizadores.IDE.TABLA_DE_ERRORES_SINTACTICOS;
import Analizadores.TError;
import Codigo.Entorno;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Bayyron
 */
public class DeclararAsignar extends NodoAbstracto{

    public DeclararAsignar(String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
    
        
        
        
      String Identificador = this.Hijos.get(0).Nombre;
      int valor1 = 0 ,valor2= 0 ,valor3= 0 ,valor4= 0 ,valor5 = 0,valor6 = 0;
      //DECLARAR LISTAS Lista
      if("Lista".equals(this.Hijos.get(1).TipoDato)){
        this.Expresiones.clear();
      this.Expresiones2.clear();
      this.Expresiones3.clear();
      for(int x = 0; x < this.Hijos.get(1).Hijos.get(1).Hijos.size();x++){
          this.Expresiones.add(this.Hijos.get(1).Hijos.get(1).Hijos.get(x));
          //System.out.println("JUAN CALABERA");
      }  
      String NombreLista = this.Hijos.get(0).Nombre;
      String NombreCoso = this.Hijos.get(1).Nombre;
      int tamanio1 = Expresiones.size();
      System.out.println("VAMOS A DECLARAR UNA LISTA->" + NombreLista);
   
      for(int i = 0; i < tamanio1; i ++){
          
          String Resultado = "";//this.Expresiones.get(i).Ejecutar(entorno, salida);
          String Tipo = this.Expresiones.get(i).TipoDato;
          System.out.println("HOLA->xd->"+Resultado + "<->" + Tipo);
          boolean Aviccio = entorno.ExisteVector(this.Expresiones.get(i).Nombre);
            if("FuncionC".equals(Tipo)){
                System.out.println("VA UNA FUNCION C dentro de una lista");
                        NodoAbstracto nuevo = new Nodo("FUNCIONC");
                        NodoAbstracto nuevoid = new Nodo(this.Expresiones.get(i).Nombre);
                        nuevo.Hijos.add(nuevoid);
                        for(int ix = 0; ix < this.Expresiones.get(i).Hijos.get(1).Hijos.size();ix++ ){
                            System.out.println("hijo de la funcion c");
                            nuevo.Expresiones.add(this.Expresiones.get(i).Hijos.get(1).Hijos.get(i));
                        }
                        nuevo.TipoDato = "id";
                        this.Expresiones3.add(nuevo);
                        //aca es el rollo de la funcion c dentro de una lista.
                        continue;
                
            }
             if("Lista".equals(Tipo)){
                System.out.println("VA UNA FUNCION C dentro de una lista");
                        NodoAbstracto nuevo = new Nodo("LISTA");
                        NodoAbstracto nuevoid = new Nodo(this.Expresiones.get(i).Nombre);
                        nuevo.Hijos.add(nuevoid);
                        for(int ix = 0; ix < this.Expresiones.get(i).Hijos.get(1).Hijos.size();ix++ ){
                            System.out.println("hijo de la funcion c");
                            nuevo.Expresiones.add(this.Expresiones.get(i).Hijos.get(1).Hijos.get(i));
                        }
                        nuevo.TipoDato = "id";
                        this.Expresiones3.add(nuevo);
                        //aca es el rollo de la funcion c dentro de una lista.
                        continue;
                
            }
          if("id".equals(Tipo) || "Lista".equals(Tipo)){
            if(Aviccio == false){
                salida.append("ERROR NO EXISTE EL VECTOR " + this.Expresiones.get(i).Nombre);
                TError ERRORES = new TError(NombreLista,this.linea,this.columna,"Semantico","ERROR NO EXISTE EL VECTOR " + this.Expresiones.get(i).Nombre );
                  TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                return "ERROR NO EXISTE EL VECTOR " + this.Expresiones.get(i).Nombre;
            }
            
            else{
                        NodoAbstracto nuevo = new Nodo("EXP");
                        NodoAbstracto nuevoid = new Nodo(this.Expresiones.get(i).Nombre);
                        nuevo.Hijos.add(nuevoid);
                        nuevo.TipoDato = "id";
                        this.Expresiones3.add(nuevo);
            }
          }else{
            this.Expresiones3.add(this.Expresiones.get(i));
          }
          //this.Expresiones3.add(this.Expresiones.get(i));

          System.out.println("");
      }
           boolean ExisteVector =  entorno.ExisteVector(Identificador); 
           if(ExisteVector == false){
               entorno.Agregar2(NombreLista, this.Expresiones3, "Lista", "ListaArit");
           }else{
               entorno.ModificarValorLista(NombreLista, this.Expresiones3, "Lista", "ListaArit");
           }
      
      entorno.MostrarVectores();
      entorno.MostrarVectoresLista(entorno,salida);
      System.out.println("FIN");
        return "FIN DECLISTA";
      }
        
        
        
      
      
      //DECLARAR VECTORES :D
      if("FuncionC".equals(this.Hijos.get(1).TipoDato)){
          
       
          
            this.Expresiones.clear();
      this.Expresiones2.clear();
      this.Expresiones3.clear();
      
      for(int x = 0; x < this.Hijos.get(1).Hijos.get(1).Hijos.size();x++){
          this.Expresiones.add(this.Hijos.get(1).Hijos.get(1).Hijos.get(x));
         
          //System.out.println("JUAN CALABERA");
      }  
         int bandera = 0;
          ArrayList <NodoAbstracto> Expresiones4 = new ArrayList();
          for (int i = 0; i < this.Expresiones.size();i++){
              //String Valor = this.Expresiones.get(i).Ejecutar(entorno, salida);
              String Nombre =  this.Expresiones.get(i).Nombre;
              String eltipo = entorno.ObtenerTipo(Nombre);
              System.out.println("el tipo es.>"+ eltipo);
              System.out.println("SALDFJALDSKJFLKJADS->" + Nombre);
              if(Nombre.contains("FuncionC")){
                        NodoAbstracto nuevo = new Nodo("LISTA");
                        NodoAbstracto nuevoid = new Nodo(this.Expresiones.get(i).Nombre);
                        nuevo.Hijos.add(nuevoid);
                        for(int ix = 0; ix < this.Expresiones.get(i).Hijos.get(1).Hijos.size();ix++ ){
                            System.out.println("hijo de la LISTA C");
                            nuevo.Expresiones.add(this.Expresiones.get(i).Hijos.get(1).Hijos.get(i));
                        }
                        nuevo.TipoDato = "id";
                        Expresiones4.add(nuevo);
                        bandera = 1;
              }else if(Nombre.contains("Lista")){
              
               
                        NodoAbstracto nuevo = new Nodo("FUNCIONC");
                        NodoAbstracto nuevoid = new Nodo(this.Expresiones.get(i).Nombre);
                        nuevo.Hijos.add(nuevoid);
                        for(int ix = 0; ix < this.Expresiones.get(i).Hijos.get(1).Hijos.size();ix++ ){
                            System.out.println("hijo de la LISTA C");
                            nuevo.Expresiones.add(this.Expresiones.get(i).Hijos.get(1).Hijos.get(i));
                        }
                        nuevo.TipoDato = "id";
                        Expresiones4.add(nuevo);
                        bandera = 1;
              
              }
               //System.out.println("SALDFJALDSKJFLKJADS->" + eltipo);
              else if(eltipo.contains("Lista")){
                  System.out.println("vamos a ver las litas dentro de la funcion c");
                        NodoAbstracto nuevo = new Nodo("EXP");
                        NodoAbstracto nuevoid = new Nodo(this.Expresiones.get(i).Nombre);
                        nuevo.Hijos.add(nuevoid);
                        nuevo.TipoDato = "id";
                        Expresiones4.add(nuevo);
                  bandera = 1;
              }else{
                  Expresiones4.add(this.Expresiones.get(i));
              }
          }
          if(bandera == 1){
              System.out.println("SI ES UNA MEGA LISTA");
              boolean ExisteVector =  entorno.ExisteVector(Identificador); 
                if(ExisteVector == false){
                    entorno.Agregar2(Identificador, Expresiones4, "Lista", "ListaArit");
                }else{
                    entorno.ModificarValorLista(Identificador, Expresiones4, "Lista", "ListaArit");
                }
                 entorno.MostrarVectores();
                entorno.MostrarVectoresLista(entorno,salida);
                System.out.println("aaaaa");
                return "AA";
          }
          System.out.println("SE ESTE DECLARANDO UN VECTOR CON LA FUNCION C");
          for(int i = 0; i < this.Expresiones.size();i++){
              String Valor = this.Expresiones.get(i).Ejecutar(entorno, salida);
              //System.out.println("cafexd->" + Valor);
               System.out.println("cafe2xd->" + this.Expresiones.get(i).TipoDato);
              String TipoDelParametro = this.Expresiones.get(i).TipoDato;
              if("id".equals(this.Expresiones.get(i).TipoDato)){
                  Valor = entorno.ObtenerValor(this.Expresiones.get(i).Nombre);
                  TipoDelParametro = entorno.ObtenerTipo(this.Expresiones.get(i).Nombre);
              }
              
              if(!Valor.equals("#Error")){
                   System.out.println("aheuvo---->" + Valor);
                   //VAMOS A BUSCAR LA PRIORIDAD
                   
                   switch (TipoDelParametro){
                        case "Lista":
                            valor1 = 1;
                            break;
                        case "cadena":
                            valor2 = 1;
                            break;
                        case "entero":
                            valor4 = 1;
                            break;
                        case "decimal":
                            valor3 = 1;
                            break;
                        case "booleano":
                            valor5 = 1;
                            break;
                           
                        }
                }
             
         }
          String Tipo1y = "";
                    if(valor1 == 1){
                        Tipo1y = "Lista";
                    }else if(valor2 == 1){
                        Tipo1y = "cadena";
                    }
                    else if(valor3 == 1){
                        Tipo1y = "decimal";
                    }
                    else if(valor4 == 1){
                        Tipo1y = "entero";
                    }
                    else if(valor5 == 1){
                        Tipo1y = "booleano";
                    }
          System.out.println("EL TIPO DEL VECTOR SERA:" + Tipo1y );
          
          // ahora empezamos con el puto casteo
          for(int i = 0; i < this.Expresiones.size();i++){
              String Valor = this.Expresiones.get(i).Ejecutar(entorno, salida);
              if(!Valor.equals("#Error")){
                 // NodoAbstracto nuevo = new Nodo(this.Expresiones.get(i).Nombre);
                  String ValorNodo = this.Expresiones.get(i).Ejecutar(entorno, salida);
                  String TipoNodo = this.Expresiones.get(i).TipoDato ;
                  //System.out.println("TIPOVECOTOR->" + Tipo1y + "<-TIPONODO->" + TipoNodo);
                  if("id".equals(TipoNodo)){
                      if(entorno.ObtenerListaN(this.Expresiones.get(i).Nombre)==0){
                        TipoNodo = entorno.ObtenerTipo(this.Expresiones.get(i).Nombre);
                        ValorNodo = entorno.ObtenerValor(this.Expresiones.get(i).Nombre);
                      }else{
                          System.out.println("ACA IRIA UN PROCESO PARA SACAR LOS DATOS DEL VECTOR");
                          this.Expresiones3 = entorno.ObtenerLista(this.Expresiones.get(i).Nombre);
                          for(int p = 0; p < this.Expresiones3.size(); p ++){
                              String Valorxd = this.Expresiones3.get(p).Ejecutar(entorno, salida);
                              String TipoVector = entorno.ObtenerTipo(this.Expresiones.get(i).Nombre);
                              System.out.println("THORValorNodo:->" + Valorxd + "<-TipoVector->" + TipoVector + "<-TipoNuevoVector->"+Tipo1y );
                              if("decimal".equals(Tipo1y) && "entero".equals(TipoVector)){
                                  Valorxd = Valorxd + ".0";
                              }
                              else if("decimal".equals(Tipo1y) && "booleano".equals(TipoVector)){
                                //System.out.println("generacion->"+ValorNodo+"<->");
                                if("true".equals(TipoVector)){
                                    Valorxd = "1.0";
                                }

                                else{
                                    Valorxd = "0.0";
                                }

                             }else if("entero".equals(Tipo1y) && "booleano".equals(TipoVector)){
                              if("true".equals(Valorxd))
                                Valorxd = "1.0";
                                else
                                    Valorxd = "0.0";
                             }
                                NodoAbstracto nuevo = new Nodo("Cadena");
                                NodoAbstracto nuevovalor = new Nodo(Valorxd);
                                nuevo.Hijos.add(nuevovalor);
                                nuevo.TipoDato = Tipo1y;
                                this.Expresiones2.add(nuevo);
                          }
                          System.out.println("FIN DEL PROCESO");
                          continue;
                      }
                  }
                   // System.out.println("TIPOVECOTOR->" + Tipo1y + "<-TIPONODO->" + TipoNodo+"<->"+ValorNodo+"<->");                  
                  if("decimal".equals(Tipo1y) && "entero".equals(TipoNodo)){
                      ValorNodo = ValorNodo + ".0";
                  }
                  else if("decimal".equals(Tipo1y) && "booleano".equals(TipoNodo)){
                      //System.out.println("generacion->"+ValorNodo+"<->");
                      if("true".equals(ValorNodo)){
                          ValorNodo = "1.0";
                      }
                      
                      else{
                          ValorNodo = "0.0";
                      }
                          
                  }else if("entero".equals(Tipo1y) && "booleano".equals(TipoNodo)){
                    if("true".equals(ValorNodo))
                      ValorNodo = "1.0";
                      else
                          ValorNodo = "0.0";
                  }
                  //System.out.println("Caracteristicas del Nodo del Vector");
                  //System.out.println("DATO:"+ ValorNodo);
                  //System.out.println("NOMBRE NODO:" + this.Expresiones.get(i).Nombre);
                  //System.out.println("TIPO DEL NODO" + Tipo1y);
                  NodoAbstracto nuevo = new Nodo("Cadena");
                  NodoAbstracto nuevovalor = new Nodo(ValorNodo);
                  nuevo.Hijos.add(nuevovalor);
                  nuevo.TipoDato = Tipo1y;
                  this.Expresiones2.add(nuevo);
                  
              }
          
          }
           boolean ExisteVector =  entorno.ExisteVector(Identificador); 
           if(ExisteVector == false){
               entorno.Agregar2(Identificador, Expresiones2, Tipo1y, "sadfsad");
           }else{
               entorno.ModificarValorLista(Identificador, Expresiones2, Tipo1y, "sadfsad");
           }
          
         entorno.MostrarVectores();
         entorno.MostrarVectoresLista(entorno,salida);
          return "FIN C";
          
      }
      
      
      
       String val1 = this.Hijos.get(1).Ejecutar(entorno, salida);
       String Tipo1 = this.Hijos.get(1).TipoDato;
         System.out.println("Se esta declarando el vector:" + Identificador + " Tipo->" + Tipo1 + " Valor->" + val1);
      if("RomeoAxpuac".equals(val1)){
        System.out.println("SUMA DE DOS VECTORES");
        ArrayList <NodoAbstracto> ExpresionesLola = new ArrayList();
        ArrayList <NodoAbstracto> ExpresionesLola2 = new ArrayList();
        boolean ExisteVector =  entorno.ExisteVector(Identificador); 
      
        if(!ExisteVector == true){
            entorno.Agregar2(Identificador, entorno.ObtenerLista("VectorDragonBallBeatles"), entorno.ObtenerTipo("VectorDragonBallBeatles"), "prit2");
        }else{
            entorno.ModificarValorLista(Identificador, entorno.ObtenerLista("VectorDragonBallBeatles"), entorno.ObtenerTipo("VectorDragonBallBeatles"), "prit2");
        }
         entorno.ModificarValorLista("VectorDragonBallBeatles",ExpresionesLola, "cadena", "prit");
         entorno.MostrarVectores();
         entorno.MostrarVectoresLista(entorno,salida);
         System.out.println("---------");
          return "Fin";
      }else if(val1.indexOf("#ERROR: El vector ")==0){
          salida.append(val1 +"\n");
          System.out.println("-------->"+  val1    +"<----------------Columna: " + this.columna + "**Fila: " + this.linea+1);
          TError ERRORES = new TError(Identificador,this.linea,this.columna,"Semantico", val1  );
          TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
          
          return "ERROR AL DECLRAR VECTOR";
          
      }else if(val1.indexOf("#Error")==0){
          salida.append("#ERROR Aritmetico: El vector no puede ser asignado" +"\n");
          System.out.println("-------->"+  "Error en operación aritmetica"    +"<----------------Columna: " + this.columna + "**Fila: " + this.linea+1);
          TError ERRORES2 = new TError(Identificador,this.linea,this.columna,"Semantico", "Error en operación aritmetica"  );
          TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES2);
          return "ERROR AL DECLRAR VECTOR";
      }
      
        System.out.println("BUENO TOCA ESTA MAMADA:");
      boolean ExisteVector =  entorno.ExisteVector(Identificador); 
      
        if(!ExisteVector == true){
            entorno.Agregar(Identificador, Tipo1, val1);
        }else{
            entorno.EliminarVector(Identificador);
            entorno.Agregar(Identificador, Tipo1, val1);
            //entorno.ModificarValor(Identificador, val1, Tipo1);
        }
        
        entorno.MostrarVectores();
         entorno.MostrarVectoresLista(entorno,salida);
        System.out.println("---------");
      return "FIN DECLARAR ASGINAR";
    }
    
}
