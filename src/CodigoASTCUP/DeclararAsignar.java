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
    
        System.out.println("---------------------------------------->entramos a declarair asiganr");
        System.out.println("->xx" + this.Hijos.get(1).Nombre);
        if(this.Hijos.get(1).Nombre.contains("VectorDragonBallBeatles")){
                int TotalHijos = this.Hijos.get(1).Hijos.size();
                System.out.println("EL HIJO PERDIDO DEL DRAGON->" + TotalHijos + "<->");
                int eluno = 0;
                for(int xx = 0 ; xx < TotalHijos; xx++){
                    String MC = this.Hijos.get(1).Hijos.get(xx).Ejecutar(entorno, salida);
                    if(MC.contains("RomeoAxpuac")){
                        eluno = 1;
                    }
                    System.out.println("DEJAME->" + MC);
                }
                //this.Hijos.get(1).Nombre = "RomeoAxpuac";
                System.out.println("TAN SOLO POR UN BESO AMOR");
                if(eluno == 1){
                    System.out.println("SI ENTRO ROMEO AXPUAC");
                       for(int xx = 0; xx < entorno.ObtenerLista("VectorDragonBallBeatles").size();xx++){
                           System.out.println("PIENSA DOS VECES");
                          //ACA SE TENDRÍA QUE PROBAR ESTA ONDA DE LOS VECTORES EN SEGUNDA VUELTA
                       }
                }
                boolean ExisteVector =  entorno.ExisteVector(Identificador); 
      
                if(!ExisteVector == true){
                    entorno.Agregar2(Identificador, entorno.ObtenerLista("VectorDragonBallBeatles"), entorno.ObtenerTipo("VectorDragonBallBeatles"), "prit2");
                }else{
                    entorno.ModificarValorLista(Identificador, entorno.ObtenerLista("VectorDragonBallBeatles"), entorno.ObtenerTipo("VectorDragonBallBeatles"), "prit2");
                }
                System.out.println("TAN SOLO POR UN BESO AMORX3");
                //String Salida = this.Hijos.get(1).Ejecutar(entorno, salida);
               // System.out.println("---->" + Salida);
               return "salida";
        }
        
     if("id".equals(this.Hijos.get(1).TipoDato)){
         //salida.append("VAMOS A IGUAL UN VECTOR CON OTRO VECTOR");
         String NombreVector = this.Hijos.get(1).Nombre;
         System.out.println("El vector que será asignado->" + NombreVector);
         if(entorno.ExisteVector(NombreVector)){
             if(entorno.ObtenerListaN(NombreVector)==0){
                 String ElNuevoValor = entorno.ObtenerValor(NombreVector);
                 String ElNuevoTipo = entorno.ObtenerTipo(NombreVector);
                 System.out.println("SE AGREGARÁ ESTE VALOR AL VECTOR" + Identificador + "->" + ElNuevoValor);
                 if(entorno.ExisteVector(Identificador)==false){
                     entorno.Agregar(Identificador,ElNuevoTipo , ElNuevoValor);
                 }else{
                     entorno.ModificarValor(Identificador,ElNuevoValor, ElNuevoTipo);
                 }
             
             }else{
                 this.Expresiones = entorno.ObtenerLista(NombreVector);
                 System.out.println("SE AGREGARÁ EL VECTOR CON LA LISTA->" + this.Expresiones.size());
                 String ElNuevoTipo = entorno.ObtenerTipo(NombreVector);
                 if(entorno.ExisteVector(Identificador)==false){
                     entorno.Agregar2(Identificador,this.Expresiones, ElNuevoTipo, "bos");
                 }else{
                     entorno.ModificarValorLista(Identificador,this.Expresiones, ElNuevoTipo, "bos");
                 }
             }
         }else{
              System.out.println("EL VECTOR NO EXISTE");
              salida.append("ERROR NO EXISTE EL VECTOR " + NombreVector + "\n");
              TError ERRORES = new TError(NombreVector,this.linea,this.columna,"Semantico","ERROR NO EXISTE EL VECTOR " + NombreVector );
              TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
              return "ERROR NO EXISTE EL VECTOR " + NombreVector;
             
         }
         entorno.MostrarVectores();
         entorno.MostrarVectoresLista(entorno, salida);
   
         return "FIN DECLARARASIGNAR";
     }   
        
    
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
      ReporteTS SIMBOLO = new ReporteTS(NombreLista,this.linea,this.columna,"Lista",ElTipoDeAmbitoRomeo);
      TABLA_ReporteTS .add(SIMBOLO);
      System.out.println("FIN");
        return "FIN DECLISTA";
      }
        
        
        
      
      
      //DECLARAR VECTORES :D
      if("FuncionC".equals(this.Hijos.get(1).TipoDato)){
      this.Expresiones.clear();
      this.Expresiones2.clear();
      this.Expresiones3.clear();
      
     for(int x = 0; x < this.Hijos.get(1).Hijos.get(1).Hijos.size();x++){
         //System.out.println("JUAN CALABERA->" + this.Hijos.get(1).Hijos.get(1).Hijos.get(x).Nombre);
         String Nombre = this.Hijos.get(1).Hijos.get(1).Hijos.get(x).Nombre;
         if(Nombre.contains("FuncionC")){
             System.out.println("Viejo los hijos de la funicon C");
             for(int y = 0; y < this.Hijos.get(1).Hijos.get(1).Hijos.get(x).Hijos.get(1).Hijos.size(); y++){
                 
                 String NOmbreHijo = this.Hijos.get(1).Hijos.get(1).Hijos.get(x).Hijos.get(1).Hijos.get(y).Nombre;
                 if(NOmbreHijo.contains("FuncionC")){
                     //etandno al segundo Funcion c
                     for(int u = 0; u < this.Hijos.get(1).Hijos.get(1).Hijos.get(x).Hijos.get(1).Hijos.get(y).Hijos.get(1).Hijos.size();u++){
                         String NombreHijo2 = this.Hijos.get(1).Hijos.get(1).Hijos.get(x).Hijos.get(1).Hijos.get(y).Hijos.get(1).Hijos.get(u).Nombre;
                         System.out.println("HIJO2->FUNCIONC->" + NombreHijo2);
                         if(NombreHijo2.contains("FuncionC")){
                             for(int t = 0; t < this.Hijos.get(1).Hijos.get(1).Hijos.get(x).Hijos.get(1).Hijos.get(y).Hijos.get(1).Hijos.get(u).Hijos.get(1).Hijos.size(); t++){
                                 String NombreHijo3 = this.Hijos.get(1).Hijos.get(1).Hijos.get(x).Hijos.get(1).Hijos.get(y).Hijos.get(1).Hijos.get(u).Hijos.get(1).Hijos.get(t).Nombre;
                                 System.out.println("HIJO2->FUNCIONC->FUNCIONC->" + NombreHijo3);
                                 if(NombreHijo3.contains("FuncionC")){
                                   //por si queire añadira otra lectura de C
                                 }else{
                                 this.Expresiones.add(this.Hijos.get(1).Hijos.get(1).Hijos.get(x).Hijos.get(1).Hijos.get(y).Hijos.get(1).Hijos.get(u).Hijos.get(1).Hijos.get(t));
                                 }
                             }
                         }else{
                             this.Expresiones.add(this.Hijos.get(1).Hijos.get(1).Hijos.get(x).Hijos.get(1).Hijos.get(y).Hijos.get(1).Hijos.get(u));
                         }
                     }
                 }else{
                     this.Expresiones.add(this.Hijos.get(1).Hijos.get(1).Hijos.get(x).Hijos.get(1).Hijos.get(y));
                 }
                 //System.out.println("Hijo->" + NOmbreHijo);
             }
             System.out.println("FIN HIJOS FUNCION C");
         }else{
             this.Expresiones.add(this.Hijos.get(1).Hijos.get(1).Hijos.get(x));
         }
          
         
          
      }
      //AGRANGANDO LOS VALORES xd
      this.Expresiones2.clear();
      for(int i = 0; i < this.Expresiones.size(); i++){
          String Resultado = this.Expresiones.get(i).Ejecutar(entorno, salida);
          String TipoDelResultado = this.Expresiones.get(i).TipoDato;
          //System.out.println("HOLA MUNDO->" + Resultado + " TipoDelResultado->" + TipoDelResultado);
          if(TipoDelResultado.contains("id")){
              if(entorno.ExisteVector( this.Expresiones.get(i).Nombre)){
                  if(entorno.ObtenerListaN(this.Expresiones.get(i).Nombre)==0){
                        NodoAbstracto nuevo = new Nodo(entorno.ObtenerValor(this.Expresiones.get(i).Nombre));
                        NodoAbstracto nuevoid = new Nodo(entorno.ObtenerValor(this.Expresiones.get(i).Nombre));
                        nuevo.Hijos.add(nuevoid);
                        nuevo.TipoDato = entorno.ObtenerTipo(this.Expresiones.get(i).Nombre);
                        this.Expresiones2.add(nuevo);
                        continue;
                  }else{
                      if(entorno.ObtenerTipo(this.Expresiones.get(i).Nombre).toUpperCase().contains("LIST")){
                      
                      }else{
                          this.Expresiones3.clear();
                          this.Expresiones3 = entorno.ObtenerLista(this.Expresiones.get(i).Nombre);
                          for(int er = 0; er < this.Expresiones3.size(); er++){
                              this.Expresiones2.add(this.Expresiones3.get(er));
                          }
                          continue;
                      }
                  }
              }else{
                  salida.append( "NO EXISTE EL VECTOR" + this.Expresiones.get(i).Nombre);
                  TError ERRORES = new TError(Identificador,this.linea,this.columna,"Semantico", "NO EXISTE EL VECTOR" + this.Expresiones.get(i).Nombre );
                    TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
          
                    return "ERROR AL DECLRAR VECTOR";
              }
          }
          
          this.Expresiones2.add(this.Expresiones.get(i));
      }
          System.out.println("AHORA SI TODOS LOS ELEMENTOS XD");
          String Tipo1y = "";
          this.Expresiones3.clear();
      for(int i = 0; i < this.Expresiones2.size();i++){
          String Resultado = this.Expresiones2.get(i).Ejecutar(entorno, salida);
          String TipoDelResultado = this.Expresiones2.get(i).TipoDato;
          //System.out.println("HOLA MUNDO->" + Resultado + " TipoDelResultado->" + TipoDelResultado);
          if(!Resultado.equals("#Error")){
                   //System.out.println("aheuvo---->" + Valor);
                   //VAMOS A BUSCAR LA PRIORIDAD
                   
                   switch (TipoDelResultado){
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
          
      }
          System.out.println("FIN DEL LOS ULTIMOS ELEMENTOS el tipo del vector será->" + Tipo1y );
          for(int i = 0; i < this.Expresiones2.size(); i ++){
              String Valorxd = this.Expresiones2.get(i).Ejecutar(entorno, salida);
              String TipoVector = this.Expresiones2.get(i).TipoDato;
              if("decimal".equals(Tipo1y) && "entero".equals(TipoVector)){
                                  Valorxd = Valorxd + ".0";
              }
              else if("decimal".equals(Tipo1y) && "booleano".equals(TipoVector)){
                   if("true".equals(TipoVector)){
                         Valorxd = "1.0";
                    }
                    else{
                         Valorxd = "0.0";
                    }

              }
              else if("entero".equals(Tipo1y) && "booleano".equals(TipoVector)){
                if("true".equals(Valorxd))
                  Valorxd = "1";
                else
                 Valorxd = "0";
              }
              NodoAbstracto nuevo = new Nodo("Cadena");
              NodoAbstracto nuevovalor = new Nodo(Valorxd);
              nuevo.Hijos.add(nuevovalor);
              nuevo.TipoDato = Tipo1y;
              this.Expresiones3.add(nuevo);
          }
          if(entorno.ExisteVector(Identificador)==false){
            entorno.Agregar2(Identificador, this.Expresiones3, Tipo1y, "SADf");
             ReporteTS SIMBOLO = new ReporteTS(Identificador,this.linea,this.columna,"Vector: "+ Tipo1y,ElTipoDeAmbitoRomeo);
             TABLA_ReporteTS .add(SIMBOLO);
          }else{
          entorno.ModificarValorLista(Identificador, this.Expresiones3, Tipo1y, "SADf");
          }
            // entorno.Agregar2(Identificador, this.Expresiones3, Tipo1y, "SADf");
          entorno.MostrarVectoresLista(entorno, salida);
      
      /*
      
          
          
         
           
          */
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
         entorno.ModificarValorLista("VectorDragonBallBeatles",null, "cadena", "prit");
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
         ReporteTS SIMBOLO = new ReporteTS(Identificador,this.linea,this.columna,"Vector: "+ Tipo1,ElTipoDeAmbitoRomeo);
          TABLA_ReporteTS .add(SIMBOLO);
        System.out.println("---------");
      return "FIN DECLARAR ASGINAR";
    }
    
}
