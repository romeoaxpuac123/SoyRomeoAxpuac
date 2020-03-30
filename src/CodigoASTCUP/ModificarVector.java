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
public class ModificarVector extends NodoAbstracto{

    public ModificarVector(String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
         String Vector = this.Hijos.get(0).Nombre; // this.Hijos.get(0).Ejecutar(entorno, salida);
         String Posicion =  this.Hijos.get(1).Ejecutar(entorno, salida);// .Ejecutar(entorno, salida);
         String NuevoValor = this.Hijos.get(2).Ejecutar(entorno, salida);
         String NuevoTipo = this.Hijos.get(2).TipoDato;
         // System.out.println("MODIFICANDO VECTOR->" + Vector + " Posición->" + Posicion + " Nuevoalor->" + NuevoValor);
         int boludo = 0;
         if(entorno.ExisteVector(Vector)){
             if(entorno.ObtenerTipo(Vector).contains("Lista")){
                 System.out.println("VAMOS A MODIFICAR UNA LISTA->" + Posicion);
                 System.out.println("VAMOS A MODIFICAR UNA LISTA->" + NuevoValor);
                 System.out.println("VAMOS A MODIFICAR UNA LISTA->" + NuevoTipo);
                 
                 /*esto no va en el otro2*/
                 if(NuevoTipo.contains("id") && this.id != 765){
                     if(entorno.ObtenerListaN(NuevoValor) == 1){
                        salida.append("#ERROR: Modificacion no permitida en el  " + Vector +"\n");
                        //System.out.println("-------->"+  val1    +"<----------------Columna: " + this.columna + "**Fila: " + this.linea+1);
                        TError ERRORES = new TError(Vector,this.linea,this.columna,"Semantico", "#ERROR: Modificacion no permitida en el  " + Vector );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#ERROR: No Existe el Vector";
                     }
                 }   
                 
                 if(NuevoTipo.contains("FuncionC")){
                     int Hijos = this.Hijos.get(2).Hijos.get(1).Hijos.size();
                     
                     System.out.println("Viene una funcion c con un totl de hijos de ->" + Hijos);
                     if(Hijos > 1 && this.id != 765){
                           
                               salida.append("#ERROR: Modificacion no permitida en el  " + Vector +"\n");
                               //System.out.println("-------->"+  val1    +"<----------------Columna: " + this.columna + "**Fila: " + this.linea+1);
                               TError ERRORES = new TError(Vector,this.linea,this.columna,"Semantico", "#ERROR: Modificacion no permitida en el  " + Vector );
                               TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                               return "#ERROR: No Existe el Vector";
                           
                     
                     }else{
                         //salida.append("VAMOS A VER QUE PEDO");
                         NodoAbstracto nuevoxY = new Nodo("FuncionC");
                         NodoAbstracto nuevoid = new Nodo("FuncionC");
                         nuevoxY.Hijos.add(nuevoid);
                         for (int x = 0; x < Hijos; x++){
                             String Valor = this.Hijos.get(2).Hijos.get(1).Hijos.get(x).Ejecutar(entorno, salida);
                             System.out.println("VAMOS HIJOS------>" + Valor);
                             nuevoxY.Hijos.add(this.Hijos.get(2).Hijos.get(1).Hijos.get(x));
                         }
                         nuevoxY.TipoDato = "FuncionC";
                         
                         boludo = 1;
                            NodoAbstracto nuevox = new Nodo("Cadena");
                            NodoAbstracto nuevovalorx = new Nodo("null");
                            nuevox.Hijos.add(nuevovalorx);
                            nuevox.TipoDato = "cadena";
                            ArrayList <NodoAbstracto> Expresionesx = new ArrayList();
                            ArrayList <NodoAbstracto> Expresiones2x = new ArrayList();
                            Expresionesx = entorno.ObtenerLista(Vector);
                            System.out.println("ACA EMPIEZA LA AÑADIDIURA->" + Expresionesx.size());
                            System.out.println("INICIOS DEL FOR->" + (Integer.parseInt(Posicion) - 1));
                            if((Integer.parseInt(Posicion))-1 > Expresionesx.size()){
                                System.out.println("ACA SI INSERTA CUANDO ES MAS GRANDE .d");
                                 for(int i = 0; i < (Integer.parseInt(Posicion)) ; i++){
                                      System.out.println("--> el valor del i->"+ i);
                                      if( i == (Integer.parseInt(Posicion) - 1)){
                                          System.out.println("ACA INSERTO EL NUEVO->");
                                          Expresiones2x.add(nuevoxY);
                                      }else if( i >= Expresionesx.size()){
                                          System.out.println("ACA INSERTO EL NULL");
                                          Expresiones2x.add(nuevox);
                                      }else{
                                          System.out.println("ACA INSERTO LOS NORMALES");
                                          Expresiones2x.add(Expresionesx.get(i));
                                      }
                                }

                            }else{
                                System.out.println("cuando la posciion esta dentro.");
                                  for(int i = 0; i < Expresionesx.size()  ; i++){
                                      System.out.println("--> el valor del i->"+ i);
                                      if( i == (Integer.parseInt(Posicion) - 1)){
                                          System.out.println("ACA INSERTO EL NUEVO->");
                                          Expresiones2x.add(nuevoxY);
                                      }else{
                                          System.out.println("inserto la expreions");
                                          Expresiones2x.add(Expresionesx.get(i));
                                      }

                                  }

                            }
                  
                 
                        entorno.ModificarValorLista(Vector, Expresiones2x, "Lista", "Lista");
                     }
                     
                     return "FIN MODFICARVEC";
                 
                 }
                 
                 
                 
                 /*Esto no va en el otro fin */
                 
                  NodoAbstracto nuevox = new Nodo("Cadena");
                  NodoAbstracto nuevovalorx = new Nodo("null");
                  nuevox.Hijos.add(nuevovalorx);
                  nuevox.TipoDato = "cadena";
                  ArrayList <NodoAbstracto> Expresionesx = new ArrayList();
                  ArrayList <NodoAbstracto> Expresiones2x = new ArrayList();
                  Expresionesx = entorno.ObtenerLista(Vector);
                  System.out.println("ACA EMPIEZA LA AÑADIDIURA->" + Expresionesx.size());
                  System.out.println("INICIOS DEL FOR->" + (Integer.parseInt(Posicion) - 1));
                  if((Integer.parseInt(Posicion))-1 > Expresionesx.size()){
                      System.out.println("ACA SI INSERTA CUANDO ES MAS GRANDE .d");
                       for(int i = 0; i < (Integer.parseInt(Posicion)) ; i++){
                            System.out.println("--> el valor del i->"+ i);
                            if( i == (Integer.parseInt(Posicion) - 1)){
                                System.out.println("ACA INSERTO EL NUEVO->");
                                Expresiones2x.add(this.Hijos.get(2));
                            }else if( i >= Expresionesx.size()){
                                System.out.println("ACA INSERTO EL NULL");
                                Expresiones2x.add(nuevox);
                            }else{
                                System.out.println("ACA INSERTO LOS NORMALES");
                                Expresiones2x.add(Expresionesx.get(i));
                            }
                      }
                  
                  }else{
                      System.out.println("cuando la posciion esta dentro.");
                        for(int i = 0; i < Expresionesx.size()  ; i++){
                            System.out.println("--> el valor del i->"+ i);
                            if( i == (Integer.parseInt(Posicion) - 1)){
                                System.out.println("ACA INSERTO EL NUEVO->");
                                Expresiones2x.add(this.Hijos.get(2));
                            }else{
                                System.out.println("inserto la expreions");
                                Expresiones2x.add(Expresionesx.get(i));
                            }
                        
                        }
                  
                  }
                  
                 
                  entorno.ModificarValorLista(Vector, Expresiones2x, "Lista", "Lista");
                  
                  
                 return "FINMODV";
             }
         
         }
        
        
        if(NuevoValor.equalsIgnoreCase("FuncionC")){
            System.out.println("VIENE UNA FUNCION C--------->");
            int TotalHijosDeC = this.Hijos.get(2).Hijos.size();
            System.out.println("VIENE UNA FUNCION C--------->" + TotalHijosDeC);
            if( TotalHijosDeC >2){
                 salida.append("#ERROR: La funcion C traeme más parametros para el vector: " + Vector +"\n");
            //System.out.println("-------->"+  val1    +"<----------------Columna: " + this.columna + "**Fila: " + this.linea+1);
                TError ERRORES = new TError(Vector,this.linea,this.columna,"Semantico", "#ERROR: La funcion C traeme más parametros para el vector: " + Vector );
                TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                return "#ERROR: No Existe el Vector";
            }
            /*
            for(int i = 0; i < TotalHijosDeC; i++){
                String Salida = this.Hijos.get(2).Hijos.get(i).Ejecutar(entorno, salida);
                NuevoValor = Salida;
                System.out.println("SALIDA->" + Salida);
            }*/
            NuevoValor = this.Hijos.get(2).Hijos.get(1).Hijos.get(0).Ejecutar(entorno, salida);
            NuevoTipo =  this.Hijos.get(2).Hijos.get(1).Hijos.get(0).TipoDato;
            System.out.println("FIN->" + NuevoValor);
        }
        System.out.println("FIN->" + NuevoValor);
        boolean ExisteVector =  entorno.ExisteVector(Vector); 
      
        if(ExisteVector == true){
                        System.out.println("FIN->" + NuevoValor);
                        System.out.println("modificando vector maor2->" + Posicion);
                        String TipoDelVectorXD1 = entorno.ObtenerTipo(Vector);
                        System.out.println("VEAMOS QUE PEDO CON EL VALOR DE LA COSA");
                        String ValorDelVector = entorno.ObtenerValor(Vector);
                        System.out.println("VAMOS A VER NUESTROS PARAMETROS->");
                        System.out.println("NombreVector->" + Vector);
                        System.out.println("TipoVector->" + TipoDelVectorXD1);
                        System.out.println("NuevoElemento->" + NuevoValor);
                        System.out.println("TipoNuevoElemento->" + NuevoTipo);
                        String ElTipoDelCasteo1 = "";
                        if(TipoDelVectorXD1.equalsIgnoreCase(NuevoTipo)){
                            ElTipoDelCasteo1 = NuevoTipo;
                        }
                        else if(TipoDelVectorXD1.equalsIgnoreCase("cadena") && (
                                NuevoTipo.equalsIgnoreCase("cadena")
                               | NuevoTipo.equalsIgnoreCase("entero")
                                |NuevoTipo.equalsIgnoreCase("decimal")
                                | NuevoTipo.equalsIgnoreCase("booleano"))){
                             ElTipoDelCasteo1 = "cadena";
                        
                        }else if(( TipoDelVectorXD1.equalsIgnoreCase("entero") | 
                                    TipoDelVectorXD1.equalsIgnoreCase("decimal") 
                                    | TipoDelVectorXD1.equalsIgnoreCase("booleano")
                                )
                                && (
                                    NuevoTipo.equalsIgnoreCase("cadena")
                              
                                )){
                             ElTipoDelCasteo1 = "cadena";
                        
                        }else if((TipoDelVectorXD1.equalsIgnoreCase("decimal")| TipoDelVectorXD1.equalsIgnoreCase("entero")) && (
                               
                                 NuevoTipo.equalsIgnoreCase("entero")
                                | NuevoTipo.equalsIgnoreCase("decimal")
                                | NuevoTipo.equalsIgnoreCase("booleano"))){
                             ElTipoDelCasteo1 = "decimal";
                        
                        }
                        else if(TipoDelVectorXD1.equalsIgnoreCase("entero") && (
                               
                                 NuevoTipo.equalsIgnoreCase("entero")
                                | NuevoTipo.equalsIgnoreCase("booleano"))){
                             ElTipoDelCasteo1 = "entero";
                        
                        }
                       
                        else if(TipoDelVectorXD1.equalsIgnoreCase("booleano") && (
                                NuevoTipo.equalsIgnoreCase("booleano"))){
                             ElTipoDelCasteo1 = "booleano";
                        
                        }
                        else if(TipoDelVectorXD1.equalsIgnoreCase("booleano") && (
                                NuevoTipo.equalsIgnoreCase("cadena"))){
                             ElTipoDelCasteo1 = "cadena";
                        
                        }
                        else if(TipoDelVectorXD1.equalsIgnoreCase("booleano") && (
                                NuevoTipo.equalsIgnoreCase("decimal"))){
                             ElTipoDelCasteo1 = "decimal";
                        
                        }
                        else if(TipoDelVectorXD1.equalsIgnoreCase("booleano") && (
                                NuevoTipo.equalsIgnoreCase("entero"))){
                             ElTipoDelCasteo1 = "entero";
                        
                        }
                           
                        System.out.println("EL TIPO DEL CASTEO SERÍA1: "+ ElTipoDelCasteo1);
                        
                        System.out.println("FIN DE LOS PARAMETROS1->" + Vector);
             ///sdjfljasldf
                          if("decimal".equals(NuevoTipo) && "entero".equals(ElTipoDelCasteo1)){
                                     ValorDelVector = ValorDelVector + ".0";
                                }
                                else  if("entero".equals(NuevoTipo) && "decimal".equals(ElTipoDelCasteo1)){
                                     ValorDelVector = ValorDelVector + ".0";
                                }
                                else if("decimal".equals(NuevoTipo) && "booleano".equals(ElTipoDelCasteo1)){
                                     if("true".equals(ValorDelVector)){
                                           ValorDelVector = "1.0";
                                      }
                                      else{
                                           ValorDelVector = "0.0";
                                      }

                                }
                                 else if("booleano".equals(NuevoTipo) && "decimal".equals(ElTipoDelCasteo1)){
                                     if("true".equals(ValorDelVector)){
                                           ValorDelVector = "1.0";
                                      }
                                      else{
                                           ValorDelVector = "0.0";
                                      }

                                }
                                else if("entero".equals(NuevoTipo) && "booleano".equals(ElTipoDelCasteo1)){
                                  if("true".equals(ValorDelVector))
                                    ValorDelVector = "1";
                                  else
                                   ValorDelVector = "0";
                                }
                                else if("booleano".equals(NuevoTipo) && "entero".equals(ElTipoDelCasteo1)){
                                  if("true".equals(ValorDelVector))
                                    ValorDelVector = "1";
                                  else
                                   ValorDelVector = "0";
                                }
                          ///el valor
                           if("decimal".equals(NuevoTipo) && "entero".equals(ElTipoDelCasteo1)){
                                     NuevoValor = ValorDelVector + ".0";
                                }
                                else  if("entero".equals(NuevoTipo) && "decimal".equals(ElTipoDelCasteo1)){
                                     NuevoValor = ValorDelVector + ".0";
                                }
                                else if("decimal".equals(NuevoTipo) && "booleano".equals(ElTipoDelCasteo1)){
                                     if("true".equals(NuevoValor)){
                                          NuevoValor  = "1.0";
                                      }
                                      else{
                                           NuevoValor = "0.0";
                                      }

                                }
                                 else if("booleano".equals(NuevoTipo) && "decimal".equals(ElTipoDelCasteo1)){
                                     if("true".equals(NuevoValor)){
                                           NuevoValor = "1.0";
                                      }
                                      else{
                                           NuevoValor = "0.0";
                                      }

                                }
                                else if("entero".equals(NuevoTipo) && "booleano".equals(ElTipoDelCasteo1)){
                                  if("true".equals(NuevoValor))
                                   NuevoValor= "1";
                                  else
                                  NuevoValor= "0";
                                }
                                else if("booleano".equals(NuevoTipo) && "entero".equals(ElTipoDelCasteo1)){
                                  if("true".equals(NuevoValor))
                                    NuevoValor = "1";
                                  else
                                   NuevoValor = "0";
                                }
                          
                           System.out.println("---------------->");
                           System.out.println("NODO INICIA->" + ValorDelVector + "<->" + ElTipoDelCasteo1);
                           System.out.println("NUEVO SNODO->" + NuevoValor + "<->" + ElTipoDelCasteo1);
                           String ValorSS = "";
                           if(ElTipoDelCasteo1.contains("entero")){
                             ValorSS  = "0";
                            }else if (ElTipoDelCasteo1.contains("decimal")){
                               ValorSS  = "0.0";
                            }else  if (ElTipoDelCasteo1.contains("cadena")){
                                ValorSS  = "null";
                            } else if (ElTipoDelCasteo1.contains("booleano")){
                                ValorSS  = "false";
                            }else {
                                return "#ERROR";
                            }
                           
              //el que se añadire en los vacios
              NodoAbstracto nuevox = new Nodo("Cadena");
             NodoAbstracto nuevovalorx = new Nodo(ValorSS);
             nuevox.Hijos.add(nuevovalorx);
              nuevox.TipoDato = ElTipoDelCasteo1;
                  
              
               //el que se añadire en los mero mero
              NodoAbstracto nuevoyx = new Nodo("Cadena");
             NodoAbstracto nuevovaloryx = new Nodo(NuevoValor);
             nuevoyx.Hijos.add(nuevovaloryx);
              nuevoyx.TipoDato = ElTipoDelCasteo1;
             
            //entorno.Agregar(Identificador, Tipo1, val1);
            // System.out.println("MODIFICANDO VECTOR->" + Vector + " Posición->" + Posicion + " Nuevoalor->" + NuevoValor);
              ArrayList <NodoAbstracto> ExpresionesRomeo = new ArrayList();
              //ExpresionesRomeo = entorno.ObtenerLista(Vector);
                if(entorno.ObtenerListaN(Vector) ==0){
                    //vectores de una posicion
                    if(Integer.parseInt(Posicion) == 1){
                        entorno.ModificarValor(Vector, NuevoValor, ElTipoDelCasteo1);
                    }
                    else{
                        
                        for(int i = 0; i < Integer.parseInt(Posicion);i++ ){
                            
                            if(i == 0){
                                //System.out.println("entramos" + ExpresionesRomeo.size());
                                NodoAbstracto nuevo2 = new Nodo("Cadena");
                                NodoAbstracto nuevovalor2 = new Nodo(entorno.ObtenerValor(Vector));
                                nuevo2.Hijos.add(nuevovalor2);
                                nuevo2.TipoDato = entorno.ObtenerTipo(Vector);
                                ExpresionesRomeo.add(nuevo2);
                            }
                            else if(i== Integer.parseInt(Posicion)-1){
                                ExpresionesRomeo.add( nuevoyx);
                            }else{
                                ExpresionesRomeo.add(nuevox);
                            }
                        }
                        entorno.ModificarValorLista(Vector, ExpresionesRomeo, entorno.ObtenerTipo(Vector),"asdfasd");
                    }
                 }else{
                    //Vectores de 2 o más posciones
                        System.out.println("modificando vector maor2->" + Posicion);
                        String TipoDelVectorXD = entorno.ObtenerTipo(Vector);
                        System.out.println("VEAMOS QUE PEDO CON EL VALOR DE LA COSA");
                       
                        System.out.println("VAMOS A VER NUESTROS PARAMETROS->");
                        System.out.println("NombreVector->" + Vector);
                        System.out.println("TipoVector->" + TipoDelVectorXD);
                        System.out.println("NuevoElemento->" + NuevoValor);
                        System.out.println("TipoNuevoElemento->" + NuevoTipo);
                        String ElTipoDelCasteo = "";
                        if(TipoDelVectorXD.equalsIgnoreCase(NuevoTipo)){
                            ElTipoDelCasteo = NuevoTipo;
                        }
                        else if(TipoDelVectorXD.equalsIgnoreCase("cadena") && (
                                NuevoTipo.equalsIgnoreCase("cadena")
                               | NuevoTipo.equalsIgnoreCase("entero")
                                |NuevoTipo.equalsIgnoreCase("decimal")
                                | NuevoTipo.equalsIgnoreCase("booleano"))){
                             ElTipoDelCasteo = "cadena";
                        
                        }else if(( TipoDelVectorXD.equalsIgnoreCase("entero") | 
                                    TipoDelVectorXD.equalsIgnoreCase("decimal") 
                                    | TipoDelVectorXD.equalsIgnoreCase("booleano")
                                )
                                && (
                                    NuevoTipo.equalsIgnoreCase("cadena")
                              
                                )){
                             ElTipoDelCasteo = "cadena";
                        
                        }else if((TipoDelVectorXD.equalsIgnoreCase("decimal")| TipoDelVectorXD.equalsIgnoreCase("entero")) && (
                               
                                 NuevoTipo.equalsIgnoreCase("entero")
                                | NuevoTipo.equalsIgnoreCase("decimal")
                                | NuevoTipo.equalsIgnoreCase("booleano"))){
                             ElTipoDelCasteo = "decimal";
                        
                        }
                        else if(TipoDelVectorXD.equalsIgnoreCase("entero") && (
                               
                                 NuevoTipo.equalsIgnoreCase("entero")
                                | NuevoTipo.equalsIgnoreCase("booleano"))){
                             ElTipoDelCasteo = "entero";
                        
                        }
                       
                        else if(TipoDelVectorXD.equalsIgnoreCase("booleano") && (
                                NuevoTipo.equalsIgnoreCase("booleano"))){
                             ElTipoDelCasteo = "booleano";
                        
                        }
                        else if(TipoDelVectorXD.equalsIgnoreCase("booleano") && (
                                NuevoTipo.equalsIgnoreCase("cadena"))){
                             ElTipoDelCasteo = "cadena";
                        
                        }
                        else if(TipoDelVectorXD.equalsIgnoreCase("booleano") && (
                                NuevoTipo.equalsIgnoreCase("decimal"))){
                             ElTipoDelCasteo = "decimal";
                        
                        }
                        else if(TipoDelVectorXD.equalsIgnoreCase("booleano") && (
                                NuevoTipo.equalsIgnoreCase("entero"))){
                             ElTipoDelCasteo = "entero";
                        
                        }
                           
                        System.out.println("EL TIPO DEL CASTEO SERÍA: "+ ElTipoDelCasteo);
                        
                        System.out.println("FIN DE LOS PARAMETROS->" + Vector);
                         
                        ExpresionesRomeo = entorno.ObtenerLista(Vector);
                        ArrayList <NodoAbstracto> ExpresionesRomeo2 = new ArrayList();
                        this.Expresiones.clear();
                        for(int i = 0; i < ExpresionesRomeo.size();i++){
                            String Valorxd = ExpresionesRomeo.get(i).Ejecutar(entorno, salida);
                            System.out.println("EL VALOR->" + Valorxd);
                                if("decimal".equals(TipoDelVectorXD) && "entero".equals(ElTipoDelCasteo)){
                                     Valorxd = Valorxd + ".0";
                                }
                                else  if("entero".equals(TipoDelVectorXD) && "decimal".equals(ElTipoDelCasteo)){
                                     Valorxd = Valorxd + ".0";
                                }
                                else if("decimal".equals(TipoDelVectorXD) && "booleano".equals(ElTipoDelCasteo)){
                                     if("true".equals(Valorxd)){
                                           Valorxd = "1.0";
                                      }
                                      else{
                                           Valorxd = "0.0";
                                      }

                                }
                                 else if("booleano".equals(TipoDelVectorXD) && "decimal".equals(ElTipoDelCasteo)){
                                     if("true".equals(Valorxd)){
                                           Valorxd = "1.0";
                                      }
                                      else{
                                           Valorxd = "0.0";
                                      }

                                }
                                else if("entero".equals(TipoDelVectorXD) && "booleano".equals(ElTipoDelCasteo)){
                                  if("true".equals(Valorxd))
                                    Valorxd = "1";
                                  else
                                   Valorxd = "0";
                                }
                                else if("booleano".equals(TipoDelVectorXD) && "entero".equals(ElTipoDelCasteo)){
                                  if("true".equals(Valorxd))
                                    Valorxd = "1";
                                  else
                                   Valorxd = "0";
                                }
                                
                                //creamos el vector
                                System.out.println("EL VALOR DEPUES->" + Valorxd);
                                NodoAbstracto nuevo = new Nodo("Cadena");
                                NodoAbstracto nuevovalor = new Nodo(Valorxd);
                                nuevo.Hijos.add(nuevovalor);
                                nuevo.TipoDato = ElTipoDelCasteo;
                                this.Expresiones.add(nuevo);
                        }
                        System.out.println("TIPO->" + ElTipoDelCasteo);
                        System.out.println("VECTOR->" + Vector);
                        System.out.println("EL TOTAL DE LISTA->" + this.Expresiones.size());
                        entorno.ModificarValorLista(Vector, this.Expresiones, ElTipoDelCasteo,"asdfasd");
                        System.out.println("SE CAMBIO LA LIASTA");
                        String Valor = "null";
                        if(ElTipoDelCasteo.contains("entero")){
                             Valor = "0";
                        }else if (ElTipoDelCasteo.contains("decimal")){
                            Valor = "0.0";
                        }else  if (ElTipoDelCasteo.contains("cadena")){
                            Valor = "null";
                        } else if (ElTipoDelCasteo.contains("booleano")){
                            Valor = "false";
                        }else {
                            return "#ERROR";
                        }
                        
                        /*Este es el nodo para los vacios*/
                        NodoAbstracto nuevo = new Nodo("Cadena");
                        NodoAbstracto nuevovalor = new Nodo(Valor);
                        nuevo.Hijos.add(nuevovalor);
                        nuevo.TipoDato = TipoDelVectorXD;
                        
                        /*Este es el nodo nuevo*/
                        if(NuevoTipo.contains("entero") && TipoDelVectorXD.contains("decimal")){
                            NuevoValor = NuevoValor + ".0";
                        }else if(NuevoTipo.contains("booleano") && TipoDelVectorXD.contains("decimal")){
                            if(NuevoValor.contains("true")){
                                NuevoValor = "1.0";
                            }else{
                                NuevoValor = "0.0";
                            }
                        }
                        else if(NuevoTipo.contains("booleano") && TipoDelVectorXD.contains("entero")){
                            if(NuevoValor.contains("true")){
                                NuevoValor = "1";
                            }else{
                                NuevoValor = "0";
                            }
                        }
                        
                        NodoAbstracto nuevo2 = new Nodo("Cadena");
                        NodoAbstracto nuevovalor2 = new Nodo(NuevoValor);
                        nuevo2.Hijos.add(nuevovalor2);
                        nuevo2.TipoDato = TipoDelVectorXD;
                        
                        
                        
                        ExpresionesRomeo2.clear();
                        ExpresionesRomeo = entorno.ObtenerLista(Vector);
                       System.out.println("Viendo el total->" + ExpresionesRomeo.size());
                        if(ExpresionesRomeo.size()>=Integer.parseInt(Posicion)){
                            System.out.println("entro if");
                            for(int i = 0; i < ExpresionesRomeo.size();i++ ){
                                if(i == Integer.parseInt(Posicion)-1){
                                    ExpresionesRomeo2.add( nuevo2);
                                }else{
                                    ExpresionesRomeo2.add(ExpresionesRomeo.get(i));
                                }
                                
                            }
                        }
                        
                        else{
                            System.out.println("entro else");
                            for(int i = 0; i < Integer.parseInt(Posicion);i++){
                                if(i== Integer.parseInt(Posicion)-1){
                                    ExpresionesRomeo2.add(nuevo2);
                                }
                                else if(ExpresionesRomeo.size()>i){
                                    //ExpresionesRomeo2.add(nuevo);
                                    ExpresionesRomeo2.add(ExpresionesRomeo.get(i));
                                }else{
                                    ExpresionesRomeo2.add(nuevo);
                                }
                            }
                        }
                      
                        entorno.ModificarValorLista(Vector, ExpresionesRomeo2, ElTipoDelCasteo,"asdfasd");
                }
        }else{
            //entorno.ModificarValor(Identificador, val1, Tipo1);
            System.out.println("#ERROR: No Existe el Vector " + Vector);
            salida.append("#ERROR: No Existe el Vector " + Vector +"\n");
            //System.out.println("-------->"+  val1    +"<----------------Columna: " + this.columna + "**Fila: " + this.linea+1);
            TError ERRORES = new TError(Vector,this.linea,this.columna,"Semantico", "No Existe el Vector " + Vector );
            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
            return "#ERROR: No Existe el Vector";
        }
        System.out.println("-------------->");
        entorno.MostrarVectores();
        entorno.MostrarVectoresLista(entorno,salida);
        System.out.println("-------------->");
         return "Vector Modificado";
    }
    
}
