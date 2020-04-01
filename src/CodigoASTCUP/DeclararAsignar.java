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
    
        System.out.println("---------------------------------------->entramos a declarair asiganrx");
        System.out.println("->xx" + this.Hijos.get(1).Nombre);
        if(this.Hijos.get(1).Nombre.contains("VectorDragonBallBeatles")){
                int TotalHijos = this.Hijos.get(1).Hijos.size();
                System.out.println("EL HIJO PERDIDO DEL DRAGON->" + TotalHijos + "<->");
                int eluno = 0;
                int eltercero = 0;
                for(int xx = 0 ; xx < TotalHijos; xx++){
                    String MC = this.Hijos.get(1).Hijos.get(xx).Ejecutar(entorno, salida);
                    if(MC.contains("RomeoAxpuac")){
                        
                        eluno = 1;
                    }
                    if(xx == 2){
                            if(this.Hijos.get(1).Hijos.get(xx).TipoDato.contains("id")){
                                 eltercero = 1;
                             }
                            
                     }
                    System.out.println("DEJAME->" + MC);
                }
                //this.Hijos.get(1).Nombre = "RomeoAxpuac";
                System.out.println("TAN SOLO POR UN BESO AMOR");
                if(eltercero == 1 ){
                    String NombreVectrox = this.Hijos.get(1).Hijos.get(2).Ejecutar(entorno, salida);
                    System.out.println("YA DIME SI ME QUIERES");
                    this.Expresiones.clear();
                    String ElTipoDelVector = "";
                     if(TotalHijos==3){
                         
                         int entero = 0, decimal = 0, cadena = 0, booleano = 0;
                            for(int xx = 0; xx < entorno.ObtenerLista(NombreVectrox).size();xx++){
                                String Valor2 = entorno.ObtenerLista(NombreVectrox).get(xx).Ejecutar(entorno, salida);
                                String TipoValor2 =   entorno.ObtenerLista(NombreVectrox).get(xx).TipoDato;
                                String Simbolo = this.Hijos.get(1).Hijos.get(1).Nombre;
                                String ElValor = this.Hijos.get(1).Hijos.get(0).Ejecutar(entorno, salida);
                                String  Tipo = this.Hijos.get(1).Hijos.get(0).TipoDato;
                                 System.out.println("PIENSA DOS VECES2->" + ElValor + "<->" + Tipo + " " + Simbolo +
                                        " " + Valor2 + "<->Tipo:" + TipoValor2);
                                        if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                //Resultado = Integer.toString(Integer.valueOf(ElValor) + Integer.valueOf(Valor2));
                                                entero = 1;
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                //Resultado = String.valueOf(Double.parseDouble(ElValor) + Double.parseDouble(Valor2));
                                                decimal = 1;
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                //Resultado = ElValor + Valor2;
                                                cadena = 1;
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                //Resultado = ElValor + Valor2;
                                                cadena = 1;
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             booleano = 1;
                                        }
                                
                            }
                            if(cadena == 1){
                                ElTipoDelVector = "cadena";
                            }else if (decimal == 1){
                                  ElTipoDelVector = "decimal";
                            }
                            else if (entero == 1){
                                  ElTipoDelVector = "entero";
                            }
                            else if(booleano == 1){
                                ElTipoDelVector = "booleano";
                            }
                     }
                    System.out.println("EL TIPO DEL VECTOR SERIA .>" +  ElTipoDelVector);
                    for(int xx = 0; xx < entorno.ObtenerLista(NombreVectrox).size();xx++){
                                String Valor2 = entorno.ObtenerLista(NombreVectrox).get(xx).Ejecutar(entorno, salida);
                                String TipoValor2 =   entorno.ObtenerLista(NombreVectrox).get(xx).TipoDato;
                                String Simbolo = this.Hijos.get(1).Hijos.get(1).Nombre;
                                String ElValor = this.Hijos.get(1).Hijos.get(0).Ejecutar(entorno, salida);
                                String  Tipo = this.Hijos.get(1).Hijos.get(0).TipoDato;
                                String Resultado = "";
                                
                                switch(Simbolo){
                                    case "+":
                                        if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                Resultado = Integer.toString(Integer.valueOf(ElValor) + Integer.valueOf(Valor2));
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                Resultado = String.valueOf(Double.parseDouble(ElValor) + Double.parseDouble(Valor2));
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                Resultado = ElValor + Valor2;
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                Resultado = ElValor + Valor2;
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }
                                        
                                        else{
                                            salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                            return "#ERROR";
                                        }
                                        break;
                                case "-":
                                     if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                Resultado = Integer.toString(Integer.valueOf(ElValor) - Integer.valueOf(Valor2));
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                Resultado = String.valueOf(Double.parseDouble(ElValor) - Double.parseDouble(Valor2));
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }
                                        
                                        else{
                                            salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                            return "#ERROR";
                                        }
                                        break;
                                  
                                case "/":
                                     if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                Resultado = Integer.toString(Integer.valueOf(ElValor) / Integer.valueOf(Valor2));
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                Resultado = String.valueOf(Double.parseDouble(ElValor) / Double.parseDouble(Valor2));
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }
                                        
                                        else{
                                            salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                            return "#ERROR";
                                        }
                                        break;    
                                 case "*":
                                     if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                Resultado = Integer.toString(Integer.valueOf(ElValor) * Integer.valueOf(Valor2));
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                Resultado = String.valueOf(Double.parseDouble(ElValor) * Double.parseDouble(Valor2));
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }
                                        
                                        else{
                                            salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                            return "#ERROR";
                                        }
                                        break;
                                     case "%":
                                         if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                Resultado = Integer.toString(Integer.valueOf(ElValor) % Integer.valueOf(Valor2));
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                Resultado = String.valueOf(Double.parseDouble(ElValor) % Double.parseDouble(Valor2));
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }
                                        
                                        else{
                                            salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                            return "#ERROR";
                                        }
                                        break;
                                    case "^":
                                        if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                Resultado = String.valueOf((double) Math.pow((Double.parseDouble(ElValor)),(Double.parseDouble(Valor2))));
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                               Resultado = String.valueOf((double) Math.pow((Double.parseDouble(ElValor)),(Double.parseDouble(Valor2))));
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }
                                        
                                        else{
                                            salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                            return "#ERROR";
                                        }
                                        break;
                               case "==":
                                            if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                    if(ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }
                                            else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                    if(ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }
                                            else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                     if(ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                    if(ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                                 
                                            }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                 if(ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }

                                            else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                                 case "!=":
                                            if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                    if(!ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }
                                            else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                    if(!ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }
                                            else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                     if(!ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                    if(!ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                                 return "#ERROR";
                                            }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                 if(!ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }

                                            else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                                case ">":
                                       if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                if(Integer.valueOf(ElValor) > Integer.valueOf(Valor2)){
                                                    Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                if(Double.parseDouble(ElValor) > Double.parseDouble(Valor2)){
                                                   Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                     if(ElValor.length() > Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                     if(ElValor.length() > Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }

                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }

                                        else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                                case "<":
                                       if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                if(Integer.valueOf(ElValor) < Integer.valueOf(Valor2)){
                                                    Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                if(Double.parseDouble(ElValor) < Double.parseDouble(Valor2)){
                                                   Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                     if(ElValor.length() < Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                     if(ElValor.length() < Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }

                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }

                                        else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                               case ">=":
                                       if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                if(Integer.valueOf(ElValor) >= Integer.valueOf(Valor2)){
                                                    Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                if(Double.parseDouble(ElValor) >= Double.parseDouble(Valor2)){
                                                   Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                     if(ElValor.length() >= Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                     if(ElValor.length() >= Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }

                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }

                                        else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                             case "<=":
                                       if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                if(Integer.valueOf(ElValor) <= Integer.valueOf(Valor2)){
                                                    Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                if(Double.parseDouble(ElValor) <= Double.parseDouble(Valor2)){
                                                   Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                     if(ElValor.length() <= Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                     if(ElValor.length() <= Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }

                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }

                                        else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                                    case "&&":
                                        if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                if(ElValor.equalsIgnoreCase(Valor2)){
                                                    Resultado = "true";                                                
                                                }else{
                                                    Resultado = "false";
                                                }
                                            }

                                        else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                                     case "||":
                                        if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                if(ElValor.equalsIgnoreCase("true") | Valor2.equalsIgnoreCase("true")){
                                                    Resultado = "true";                                                
                                                }else{
                                                    Resultado = "false";
                                                }
                                            }

                                        else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                                }
                            //AHRA A OBTENER EL TIPO DEL VECTOR    
                            
                            System.out.println("EL RESULTADO DE LA OPERACION222 ES:" + Resultado + "<->NUVOTIPO->" +ElTipoDelVector);
                            NodoAbstracto nuevo = new Nodo("Cadena");
                            NodoAbstracto nuevovalor = new Nodo( Resultado);
                            nuevo.Hijos.add(nuevovalor);
                            nuevo.TipoDato = ElTipoDelVector;
                            this.Expresiones.add(nuevo);
                            
                    
                      }
                        boolean ExisteVector =  entorno.ExisteVector(Identificador); 
                
                        if(!ExisteVector == true){
                            entorno.Agregar2(Identificador, this.Expresiones, ElTipoDelVector, "prit2");
                        }else{
                            entorno.ModificarValorLista(Identificador, this.Expresiones, ElTipoDelVector, "prit2");
                        }
                    
                    
                    return "FIN DCA";
                    
                
                }
                
                
                
                
                if(eluno == 1){
                    System.out.println("SI ENTRO ROMEO AXPUAC");
                    this.Expresiones.clear();
                    String ElTipoDelVector = "";
                     if(TotalHijos==3){
                         
                         int entero = 0, decimal = 0, cadena = 0, booleano = 0;
                            for(int xx = 0; xx < entorno.ObtenerLista("VectorDragonBallBeatles").size();xx++){
                                String ElValor = entorno.ObtenerLista("VectorDragonBallBeatles").get(xx).Ejecutar(entorno, salida);
                                String Tipo =   entorno.ObtenerLista("VectorDragonBallBeatles").get(xx).TipoDato;
                                String Simbolo = this.Hijos.get(1).Hijos.get(1).Nombre;
                                String Valor2 = this.Hijos.get(1).Hijos.get(2).Ejecutar(entorno, salida);
                                
                                String  TipoValor2 = this.Hijos.get(1).Hijos.get(2).TipoDato;
                                if(TipoValor2.contains("id")){
                                    Valor2 = entorno.ObtenerValor(this.Hijos.get(1).Hijos.get(2).Ejecutar(entorno, salida));
                                    Tipo = entorno.ObtenerTipo(this.Hijos.get(1).Hijos.get(2).Ejecutar(entorno, salida));
                                }
                                
                                
                                        if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                //Resultado = Integer.toString(Integer.valueOf(ElValor) + Integer.valueOf(Valor2));
                                                entero = 1;
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                //Resultado = String.valueOf(Double.parseDouble(ElValor) + Double.parseDouble(Valor2));
                                                decimal = 1;
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                //Resultado = ElValor + Valor2;
                                                cadena = 1;
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                //Resultado = ElValor + Valor2;
                                                cadena = 1;
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             booleano = 1;
                                        }
                                
                            }
                            if(cadena == 1){
                                ElTipoDelVector = "cadena";
                            }else if (decimal == 1){
                                  ElTipoDelVector = "decimal";
                            }
                            else if (entero == 1){
                                  ElTipoDelVector = "entero";
                            }
                            else if(booleano == 1){
                                ElTipoDelVector = "booleano";
                            }
                          //  sdfadsf
                            
                            for(int xx = 0; xx < entorno.ObtenerLista("VectorDragonBallBeatles").size();xx++){
                                String ElValor = entorno.ObtenerLista("VectorDragonBallBeatles").get(xx).Ejecutar(entorno, salida);
                                String Tipo =   entorno.ObtenerLista("VectorDragonBallBeatles").get(xx).TipoDato;
                                String Simbolo = this.Hijos.get(1).Hijos.get(1).Nombre;
                                String Valor2 = this.Hijos.get(1).Hijos.get(2).Ejecutar(entorno, salida);
                                String  TipoValor2 = this.Hijos.get(1).Hijos.get(2).TipoDato;
                                System.out.println("PIENSA DOS VECES->" + ElValor + "<->" + Tipo + " " + Simbolo +
                                        " " + Valor2 + "<->Tipo:" + TipoValor2);
                                String Resultado = "";
                                 if(TipoValor2.contains("id")){
                                    Valor2 = entorno.ObtenerValor(this.Hijos.get(1).Hijos.get(2).Ejecutar(entorno, salida));
                                    Tipo = entorno.ObtenerTipo(this.Hijos.get(1).Hijos.get(2).Ejecutar(entorno, salida));
                                }
                                
                                switch(Simbolo){
                                    case "+":
                                        if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                Resultado = Integer.toString(Integer.valueOf(ElValor) + Integer.valueOf(Valor2));
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                Resultado = String.valueOf(Double.parseDouble(ElValor) + Double.parseDouble(Valor2));
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                Resultado = ElValor + Valor2;
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                Resultado = ElValor + Valor2;
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }
                                        
                                        else{
                                            salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                            return "#ERROR";
                                        }
                                        break;
                                case "-":
                                     if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                Resultado = Integer.toString(Integer.valueOf(ElValor) - Integer.valueOf(Valor2));
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                Resultado = String.valueOf(Double.parseDouble(ElValor) - Double.parseDouble(Valor2));
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }
                                        
                                        else{
                                            salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                            return "#ERROR";
                                        }
                                        break;
                                  
                                case "/":
                                     if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                Resultado = Integer.toString(Integer.valueOf(ElValor) / Integer.valueOf(Valor2));
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                Resultado = String.valueOf(Double.parseDouble(ElValor) / Double.parseDouble(Valor2));
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }
                                        
                                        else{
                                            salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                            return "#ERROR";
                                        }
                                        break;    
                                 case "*":
                                     if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                Resultado = Integer.toString(Integer.valueOf(ElValor) * Integer.valueOf(Valor2));
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                Resultado = String.valueOf(Double.parseDouble(ElValor) * Double.parseDouble(Valor2));
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }
                                        
                                        else{
                                            salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                            return "#ERROR";
                                        }
                                        break;
                                     case "%":
                                         if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                Resultado = Integer.toString(Integer.valueOf(ElValor) % Integer.valueOf(Valor2));
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                Resultado = String.valueOf(Double.parseDouble(ElValor) % Double.parseDouble(Valor2));
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }
                                        
                                        else{
                                            salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                            return "#ERROR";
                                        }
                                        break;
                                    case "^":
                                        if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                Resultado = String.valueOf((double) Math.pow((Double.parseDouble(ElValor)),(Double.parseDouble(Valor2))));
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                               Resultado = String.valueOf((double) Math.pow((Double.parseDouble(ElValor)),(Double.parseDouble(Valor2))));
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }
                                        
                                        else{
                                            salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                            return "#ERROR";
                                        }
                                        break;
                               case "==":
                                            if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                    if(ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }
                                            else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                    if(ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }
                                            else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                     if(ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                    if(ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                                 
                                            }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                 if(ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }

                                            else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                                 case "!=":
                                            if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                    if(!ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }
                                            else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                    if(!ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }
                                            else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                     if(!ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                    if(!ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                                 return "#ERROR";
                                            }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                 if(!ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }

                                            else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                                case ">":
                                       if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                if(Integer.valueOf(ElValor) > Integer.valueOf(Valor2)){
                                                    Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                if(Double.parseDouble(ElValor) > Double.parseDouble(Valor2)){
                                                   Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                     if(ElValor.length() > Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                     if(ElValor.length() > Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }

                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }

                                        else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                                case "<":
                                       if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                if(Integer.valueOf(ElValor) < Integer.valueOf(Valor2)){
                                                    Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                if(Double.parseDouble(ElValor) < Double.parseDouble(Valor2)){
                                                   Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                     if(ElValor.length() < Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                     if(ElValor.length() < Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }

                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }

                                        else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                               case ">=":
                                       if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                if(Integer.valueOf(ElValor) >= Integer.valueOf(Valor2)){
                                                    Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                if(Double.parseDouble(ElValor) >= Double.parseDouble(Valor2)){
                                                   Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                     if(ElValor.length() >= Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                     if(ElValor.length() >= Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }

                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }

                                        else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                             case "<=":
                                       if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                if(Integer.valueOf(ElValor) <= Integer.valueOf(Valor2)){
                                                    Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                if(Double.parseDouble(ElValor) <= Double.parseDouble(Valor2)){
                                                   Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                     if(ElValor.length() <= Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                     if(ElValor.length() <= Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }

                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }

                                        else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                                    case "&&":
                                        if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                if(ElValor.equalsIgnoreCase(Valor2)){
                                                    Resultado = "true";                                                
                                                }else{
                                                    Resultado = "false";
                                                }
                                            }

                                        else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                                     case "||":
                                        if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                if(ElValor.equalsIgnoreCase("true") | Valor2.equalsIgnoreCase("true")){
                                                    Resultado = "true";                                                
                                                }else{
                                                    Resultado = "false";
                                                }
                                            }

                                        else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                                }
                            //AHRA A OBTENER EL TIPO DEL VECTOR    
                            
                            System.out.println("EL RESULTADO DE LA OPERACION ES:" + Resultado + "<->NUVOTIPO->" +ElTipoDelVector);
                          //ACA SE TENDRÍA QUE PROBAR ESTA ONDA DE LOS VECTORES EN SEGUNDA VUELTA
                            NodoAbstracto nuevo = new Nodo("Cadena");
                            NodoAbstracto nuevovalor = new Nodo( Resultado);
                            nuevo.Hijos.add(nuevovalor);
                            nuevo.TipoDato = ElTipoDelVector;
                            this.Expresiones.add(nuevo);
                            }
                      }
                        boolean ExisteVector =  entorno.ExisteVector(Identificador); 
                
                        if(!ExisteVector == true){
                            entorno.Agregar2(Identificador, this.Expresiones, ElTipoDelVector, "prit2");
                        }else{
                            entorno.ModificarValorLista(Identificador, this.Expresiones, ElTipoDelVector, "prit2");
                        }
                      
                }else{
                        System.out.println("PUTA VIDA-------------------------->" + this.Hijos.get(1).Hijos.get(0).Nombre);
                        String NombreVector =  this.Hijos.get(1).Hijos.get(0).Nombre;
                        this.Expresiones.clear();
                        String ElTipoDelVector = "";
                        if(TotalHijos==3){
                         
                         int entero = 0, decimal = 0, cadena = 0, booleano = 0;
                            for(int xx = 0; xx < entorno.ObtenerLista(NombreVector).size();xx++){
                                String ElValor = entorno.ObtenerLista(NombreVector).get(xx).Ejecutar(entorno, salida);
                                String Tipo =   entorno.ObtenerLista(NombreVector).get(xx).TipoDato;
                                String Simbolo = this.Hijos.get(1).Hijos.get(1).Nombre;
                                String Valor2 = this.Hijos.get(1).Hijos.get(2).Ejecutar(entorno, salida);
                                String  TipoValor2 = this.Hijos.get(1).Hijos.get(2).TipoDato;
                                System.out.println("PIENSA DOS VECES->" + ElValor + "<->" + Tipo + " " + Simbolo +
                                        " " + Valor2 + "<->Tipo:" + TipoValor2);
                                String Resultado = "";
                                        if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                //Resultado = Integer.toString(Integer.valueOf(ElValor) + Integer.valueOf(Valor2));
                                                entero = 1;
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                //Resultado = String.valueOf(Double.parseDouble(ElValor) + Double.parseDouble(Valor2));
                                                decimal = 1;
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                //Resultado = ElValor + Valor2;
                                                cadena = 1;
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                //Resultado = ElValor + Valor2;
                                                cadena = 1;
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             booleano = 1;
                                        }
                                
                            
                                        if(cadena == 1){
                                            ElTipoDelVector = "cadena";
                                        }else if (decimal == 1){
                                              ElTipoDelVector = "decimal";
                                        }
                                        else if (entero == 1){
                                              ElTipoDelVector = "entero";
                                        }
                                        else if(booleano == 1){
                                            ElTipoDelVector = "booleano";
                                        }
                            
                            }
                            for(int xx = 0; xx < entorno.ObtenerLista(NombreVector).size();xx++){
                                String ElValor = entorno.ObtenerLista(NombreVector).get(xx).Ejecutar(entorno, salida);
                                String Tipo =   entorno.ObtenerLista(NombreVector).get(xx).TipoDato;
                                String Simbolo = this.Hijos.get(1).Hijos.get(1).Nombre;
                                String Valor2 = this.Hijos.get(1).Hijos.get(2).Ejecutar(entorno, salida);
                                String  TipoValor2 = this.Hijos.get(1).Hijos.get(2).TipoDato;
                                System.out.println("PIENSA DOS VECES->" + ElValor + "<->" + Tipo + " " + Simbolo +
                                        " " + Valor2 + "<->Tipo:" + TipoValor2);
                                String Resultado = "";
                                
                                switch(Simbolo){
                                    case "+":
                                        if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                Resultado = Integer.toString(Integer.valueOf(ElValor) + Integer.valueOf(Valor2));
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                Resultado = String.valueOf(Double.parseDouble(ElValor) + Double.parseDouble(Valor2));
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                Resultado = ElValor + Valor2;
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                Resultado = ElValor + Valor2;
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }
                                        
                                        else{
                                            salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                            return "#ERROR";
                                        }
                                        break;
                                case "-":
                                     if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                Resultado = Integer.toString(Integer.valueOf(ElValor) - Integer.valueOf(Valor2));
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                Resultado = String.valueOf(Double.parseDouble(ElValor) - Double.parseDouble(Valor2));
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }
                                        
                                        else{
                                            salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                            return "#ERROR";
                                        }
                                        break;
                                  
                                case "/":
                                     if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                Resultado = Integer.toString(Integer.valueOf(ElValor) / Integer.valueOf(Valor2));
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                Resultado = String.valueOf(Double.parseDouble(ElValor) / Double.parseDouble(Valor2));
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }
                                        
                                        else{
                                            salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                            return "#ERROR";
                                        }
                                        break;    
                                 case "*":
                                     if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                Resultado = Integer.toString(Integer.valueOf(ElValor) * Integer.valueOf(Valor2));
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                Resultado = String.valueOf(Double.parseDouble(ElValor) * Double.parseDouble(Valor2));
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }
                                        
                                        else{
                                            salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                            return "#ERROR";
                                        }
                                        break;
                                     case "%":
                                         if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                Resultado = Integer.toString(Integer.valueOf(ElValor) % Integer.valueOf(Valor2));
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                Resultado = String.valueOf(Double.parseDouble(ElValor) % Double.parseDouble(Valor2));
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }
                                        
                                        else{
                                            salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                            return "#ERROR";
                                        }
                                        break;
                                    case "^":
                                        if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                Resultado = String.valueOf((double) Math.pow((Double.parseDouble(ElValor)),(Double.parseDouble(Valor2))));
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                               Resultado = String.valueOf((double) Math.pow((Double.parseDouble(ElValor)),(Double.parseDouble(Valor2))));
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                 salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                             salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                             return "#ERROR";
                                        }
                                        
                                        else{
                                            salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                            return "#ERROR";
                                        }
                                        break;
                               case "==":
                                            if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                    if(ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }
                                            else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                    if(ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }
                                            else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                     if(ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                    if(ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                                 
                                            }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                 if(ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }

                                            else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                                 case "!=":
                                            if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                    if(!ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }
                                            else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                    if(!ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }
                                            else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                     if(!ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                    if(!ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                                 return "#ERROR";
                                            }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                 if(!ElValor.equalsIgnoreCase(Valor2)){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                            }

                                            else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                                case ">":
                                       if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                if(Integer.valueOf(ElValor) > Integer.valueOf(Valor2)){
                                                    Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                if(Double.parseDouble(ElValor) > Double.parseDouble(Valor2)){
                                                   Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                     if(ElValor.length() > Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                     if(ElValor.length() > Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }

                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }

                                        else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                                case "<":
                                       if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                if(Integer.valueOf(ElValor) < Integer.valueOf(Valor2)){
                                                    Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                if(Double.parseDouble(ElValor) < Double.parseDouble(Valor2)){
                                                   Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                     if(ElValor.length() < Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                     if(ElValor.length() < Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }

                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }

                                        else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                               case ">=":
                                       if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                if(Integer.valueOf(ElValor) >= Integer.valueOf(Valor2)){
                                                    Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                if(Double.parseDouble(ElValor) >= Double.parseDouble(Valor2)){
                                                   Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                     if(ElValor.length() >= Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                     if(ElValor.length() >= Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }

                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }

                                        else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                             case "<=":
                                       if(Tipo.contains("entero") && (TipoValor2.contains("entero"))){
                                                if(Integer.valueOf(ElValor) <= Integer.valueOf(Valor2)){
                                                    Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("decimal") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero"))){
                                                if(Double.parseDouble(ElValor) <= Double.parseDouble(Valor2)){
                                                   Resultado = "true";
                                                }else{
                                                    Resultado = "false";
                                                }
                                        }
                                        else if(Tipo.contains("cadena") && (TipoValor2.contains("decimal")|TipoValor2.contains("entero")|TipoValor2.contains("cadena") | TipoValor2.contains("booleano"))){
                                                     if(ElValor.length() <= Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }
                                        }else  if(Tipo.contains("booleano") && (TipoValor2.contains("cadena"))){
                                                     if(ElValor.length() <= Valor2.length()){
                                                        Resultado = "true";
                                                    }else{
                                                        Resultado = "false";
                                                    }

                                        }else if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }

                                        else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                                    case "&&":
                                        if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                if(ElValor.equalsIgnoreCase(Valor2)){
                                                    Resultado = "true";                                                
                                                }else{
                                                    Resultado = "false";
                                                }
                                            }

                                        else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                                     case "||":
                                        if(Tipo.contains("booleano") && (TipoValor2.contains("booleano"))){
                                                if(ElValor.equalsIgnoreCase("true") | Valor2.equalsIgnoreCase("true")){
                                                    Resultado = "true";                                                
                                                }else{
                                                    Resultado = "false";
                                                }
                                            }

                                        else{
                                                salida.append("ERROR EN LA OPERACIÓN DEL VECTOR");
                                                return "#ERROR";
                                            }
                                        break;
                                }
                            //AHRA A OBTENER EL TIPO DEL VECTOR    
                            
                            System.out.println("EL RESULTADO DE LA OPERACION ES:" + Resultado + "<->NUVOTIPO->" +ElTipoDelVector);
                          //ACA SE TENDRÍA QUE PROBAR ESTA ONDA DE LOS VECTORES EN SEGUNDA VUELTA
                            NodoAbstracto nuevo = new Nodo("Cadena");
                            NodoAbstracto nuevovalor = new Nodo( Resultado);
                            nuevo.Hijos.add(nuevovalor);
                            nuevo.TipoDato = ElTipoDelVector;
                            this.Expresiones.add(nuevo);
                            }
                            System.out.println("EL VALOR DEL VECTOR SERA" + ElTipoDelVector);
                            boolean ExisteVector =  entorno.ExisteVector(Identificador); 
                
                                if(!ExisteVector == true){
                                    entorno.Agregar2(Identificador, this.Expresiones, ElTipoDelVector, "prit2");
                                }else{
                                    entorno.ModificarValorLista(Identificador, this.Expresiones, ElTipoDelVector, "prit2");
                                }
                        }
                       
                        
                        /*
                         boolean ExisteVector =  entorno.ExisteVector(Identificador); 
      
                        if(!ExisteVector == true){
                            entorno.Agregar2(Identificador, entorno.ObtenerLista(this.Hijos.get(1).Hijos.get(0).Nombre), entorno.ObtenerTipo("VectorDragonBallBeatles"), "prit2");
                        }else{
                            entorno.ModificarValorLista(Identificador, entorno.ObtenerLista(this.Hijos.get(1).Hijos.get(0).Nombre), entorno.ObtenerTipo("VectorDragonBallBeatles"), "prit2");
                        }*/
                        return "salida";
                }
                /*
                boolean ExisteVector =  entorno.ExisteVector(Identificador); 
                
                if(!ExisteVector == true){
                    entorno.Agregar2(Identificador, entorno.ObtenerLista("VectorDragonBallBeatles"), entorno.ObtenerTipo("VectorDragonBallBeatles"), "prit2");
                }else{
                    entorno.ModificarValorLista(Identificador, entorno.ObtenerLista("VectorDragonBallBeatles"), entorno.ObtenerTipo("VectorDragonBallBeatles"), "prit2");
                }
               */
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
        System.out.println("QUE PEDO CAHCORORSSDFSD");
    
      //DECLARAR LISTAS Lista
      if("Lista".equals(this.Hijos.get(1).TipoDato)){
      System.out.println("VAMOS A DECLARAR UNA LSITA");
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
      System.out.println("VAMOS A DECLARAR UNA LISTA-> coso?" + NombreLista);
      System.out.println("VAMOS A DECLARAR UNA LISTA-> tamanio?" + NombreCoso);
      for(int i = 0; i < tamanio1; i ++){
            String Resultado = this.Expresiones.get(i).Ejecutar(entorno, salida);
            String Tipo = this.Expresiones.get(i).TipoDato;
            System.out.println("HOLASADFASD->xd->"+Resultado + "<->" + Tipo);
            
            if(Tipo.contains("FuncionC")){
                System.out.println("VA UNA FUNCION C dentro de una lista");
                        NodoAbstracto nuevo = new Nodo("FuncionC");
                        NodoAbstracto nuevoid = new Nodo(this.Expresiones.get(i).Nombre);
                        nuevo.Hijos.add(nuevoid);
                        for(int ix = 0; ix < this.Expresiones.get(i).Hijos.get(1).Hijos.size();ix++ ){
                            //System.out.println("hijo de la funcion c" + this.Expresiones.get(i).Hijos.get(1).Hijos.get(i).Ejecutar(entorno, salida));
                            String Salida = this.Expresiones.get(i).Hijos.get(1).Hijos.get(ix).Ejecutar(entorno, salida);
                            if(Salida.contains("c(")){
                                 //nuevo.Expresiones.add(this.Expresiones.get(i).Hijos.get(1).Hijos.get(ix).Hijos.get(0));
                                 this.Expresiones.get(i).Hijos.get(1).Hijos.get(ix).Hijos.add(this.Expresiones.get(i).Hijos.get(1).Hijos.get(ix).Hijos.get(0));
                            }
                                nuevo.Hijos.add(this.Expresiones.get(i).Hijos.get(1).Hijos.get(ix));
                            
                            //nuevo.Expresiones.add(this.Expresiones.get(i).Hijos.get(1).Hijos.get(ix));
                        }
                        nuevo.TipoDato = "FuncionC";
                        //for(int ip = 0; ip < nuevo.Expresiones.size();ip++){
                        //    String gyf = nuevo.Expresiones.get(ip).Ejecutar(entorno, salida);
                        //    System.out.println("gyf->" + gyf);
                       // }
                        this.Expresiones3.add(nuevo);
                continue;
            }
            if(Tipo.contains("id")){
                        if(entorno.ExisteVector(Resultado)==false){
                            salida.append("ERROR NO EXISTE EL VECTOR " + this.Expresiones.get(i).Nombre);
                            TError ERRORES = new TError(NombreLista,this.linea,this.columna,"Semantico","ERROR NO EXISTE EL VECTOR " + this.Expresiones.get(i).Nombre );
                              TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                            return "ERROR NO EXISTE EL VECTOR " + this.Expresiones.get(i).Nombre;
                        }
                        NodoAbstracto nuevo = new Nodo("Cadena");
                        NodoAbstracto nuevoid = new Nodo(Resultado);
                        nuevo.Hijos.add(nuevoid);
                        nuevo.TipoDato = "id";
                        this.Expresiones3.add(nuevo);
                        System.out.println("NUEBO AGREGADO");
                continue;
            }
            this.Expresiones3.add( this.Expresiones.get(i));
      
      }
      for(int i = 0; i < this.Expresiones3.size();i++){
          String Resultado = this.Expresiones3.get(i).Ejecutar(entorno, salida);
          System.out.println("ASI DE ENMARODA->" + Resultado);
      }
      
            boolean ExisteVector =  entorno.ExisteVector(Identificador); 
           if(ExisteVector == false){
               entorno.Agregar2(NombreLista, this.Expresiones3, "Lista", "ListaArit");
               
           }else{
               entorno.ModificarValorLista(NombreLista, this.Expresiones3, "Lista", "ListaArit");
           }
            System.out.println("-ASDFJLADSKJFADS");
            entorno.MostrarVectores();
            entorno.MostrarVectoresLista(entorno,salida);
            ReporteTS SIMBOLO = new ReporteTS(NombreLista,this.linea,this.columna,"Lista",ElTipoDeAmbitoRomeo);
            TABLA_ReporteTS .add(SIMBOLO);
            System.out.println("FIN");
           
      /*
      for(int i = 0; i < tamanio1; i ++){
          
          String Resultado = this.Expresiones.get(i).Ejecutar(entorno, salida);
          String Tipo = this.Expresiones.get(i).TipoDato;
          System.out.println("HOLASADFASD->xd->"+Resultado + "<->" + Tipo);
          
          
          boolean Aviccio = entorno.ExisteVector(Resultado);
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
                System.out.println("AVICCI TRUE" + Resultado);
                        NodoAbstracto nuevo = new Nodo("Cadena");
                        NodoAbstracto nuevoid = new Nodo(Resultado);
                        nuevo.Hijos.add(nuevoid);
                        nuevo.TipoDato = "id";
                        this.Expresiones3.add(nuevo);
                        System.out.println("NUEBO AGREGADO");
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
          System.out.println("-ASDFJLADSKJFADS");
      entorno.MostrarVectores();
      entorno.MostrarVectoresLista(entorno,salida);
      ReporteTS SIMBOLO = new ReporteTS(NombreLista,this.linea,this.columna,"Lista",ElTipoDeAmbitoRomeo);
      TABLA_ReporteTS .add(SIMBOLO);
      System.out.println("FIN");
      
      */
        return "FIN DECLISTA";
      }
        
        
        
        System.out.println("hollynsdfsad");
      
      //DECLARAR VECTORES :D
      if("FuncionC".equals(this.Hijos.get(1).TipoDato)){
      //this.Expresiones.clear();
      //this.Expresiones2x.clear();
      this.Expresiones3.clear();
      ArrayList <NodoAbstracto> Expresionesx = new ArrayList();
      ArrayList <NodoAbstracto> Expresiones2x = new ArrayList();
      ArrayList <NodoAbstracto> Expresiones3x = new ArrayList();
     for(int x = 0; x < this.Hijos.get(1).Hijos.get(1).Hijos.size();x++){
         System.out.println("JUAN CALABERA->" + this.Hijos.get(1).Hijos.get(1).Hijos.get(x).Nombre);
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
                                 Expresionesx.add(this.Hijos.get(1).Hijos.get(1).Hijos.get(x).Hijos.get(1).Hijos.get(y).Hijos.get(1).Hijos.get(u).Hijos.get(1).Hijos.get(t));
                                 }
                             }
                         }else{
                             Expresionesx.add(this.Hijos.get(1).Hijos.get(1).Hijos.get(x).Hijos.get(1).Hijos.get(y).Hijos.get(1).Hijos.get(u));
                         }
                     }
                 }else{
                     Expresionesx.add(this.Hijos.get(1).Hijos.get(1).Hijos.get(x).Hijos.get(1).Hijos.get(y));
                 }
                 //System.out.println("Hijo->" + NOmbreHijo);
             }
             System.out.println("FIN HIJOS FUNCION C");
         }else{
             Expresionesx.add(this.Hijos.get(1).Hijos.get(1).Hijos.get(x));
         }
          
         
          
      }
      //AGRANGANDO LOS VALORES xd
      Expresiones2x.clear();
      
      System.out.println("paz");
         System.out.println("----asdjflTOYFELIZX1sdafdsfasd");
            entorno.MostrarVectoresLista(entorno, salida);
            System.out.println("----asdjflTOYFELIZX2->romeo");
            System.out.println("\n\nseguridad");
      for(int i = 0; i < Expresionesx.size(); i++){
          String Resultado = Expresionesx.get(i).Ejecutar(entorno, salida);
          String TipoDelResultado = Expresionesx.get(i).TipoDato;
          //System.out.println("HOLA MUNDO->" + Resultado + " TipoDelResultado->" + TipoDelResultado);
         
          if(TipoDelResultado.contains("id")){
            
              if(entorno.ExisteVector( Expresionesx.get(i).Nombre)){
                  
                  if(entorno.ObtenerListaN(Expresionesx.get(i).Nombre)==0){
                      System.out.println("SOLO VALORCITO");
                        NodoAbstracto nuevo = new Nodo(entorno.ObtenerValor(Expresionesx.get(i).Nombre));
                        NodoAbstracto nuevoid = new Nodo(entorno.ObtenerValor(Expresionesx.get(i).Nombre));
                        nuevo.Hijos.add(nuevoid);
                        nuevo.TipoDato = entorno.ObtenerTipo(Expresionesx.get(i).Nombre);
                        Expresiones2x.add(nuevo);
                        continue;
                  }else{
                      System.out.println("MAS QUE SOLO UN VALOR");
                      if(entorno.ObtenerTipo(Expresionesx.get(i).Nombre).toUpperCase().contains("LIST")){
                      
                      }else{
                          //Expresiones3x.clear();
                          Expresiones3x = entorno.ObtenerLista(Expresionesx.get(i).Nombre);
                          for(int er = 0; er < Expresiones3x.size(); er++){
                              Expresiones2x.add(Expresiones3x.get(er));
                          }
                         
                          continue;
                      }
                  }
                   
                 
              }else{
                  salida.append( "NO EXISTE EL VECTOR" + Expresionesx.get(i).Nombre);
                  TError ERRORES = new TError(Identificador,this.linea,this.columna,"Semantico", "NO EXISTE EL VECTOR" + this.Expresiones.get(i).Nombre );
                    TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
          
                    return "ERROR AL DECLRAR VECTOR";
              }
          }
           
         Expresiones2x.add(Expresionesx.get(i));
      }
      
      
      
          String Tipo1y = "";
        // this.Expresiones3.clear();
        ArrayList <NodoAbstracto> Expresiones4 = new ArrayList();
      for(int i = 0; i < Expresiones2x.size();i++){
          
          String Resultado = Expresiones2x.get(i).Ejecutar(entorno, salida);
          String TipoDelResultado = Expresiones2x.get(i).TipoDato;
          //System.out.println("HOLA MUNDO->" + Resultado + " TipoDelResultado->" + TipoDelResultado);
          if(!Resultado.equals("#Error")){
                   //
                   //System.out.println("aheuvo---->" + Resultado);
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
      
            //entorno = entorno.ModificandoEntornos(Temporal,entorno);
            
          System.out.println("\n\n\nFIN DEL LOS ULTIMOS ELEMENTOS el tipo del vector será->" + Tipo1y );
           System.out.println("----asdjflTOYFELIZX1");
            entorno.MostrarVectoresLista(entorno, salida);
            System.out.println("----asdjflTOYFELIZX2");
          
          for(int i = 0; i < Expresiones2x.size(); i ++){
              String Valorxd = Expresiones2x.get(i).Ejecutar(entorno, salida);
              String TipoVector = Expresiones2x.get(i).TipoDato;
              if("decimal".equals(Tipo1y) && "entero".equals(TipoVector)){
                                  Valorxd = Valorxd + ".0";
              }
              else if("decimal".equals(Tipo1y) && "booleano".equals(TipoVector)){
                   if("true".equals(Valorxd)){
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
              Expresiones4.add(nuevo);
          }
          
          if(entorno.ExisteVector(Identificador)==false){
            entorno.Agregar2(Identificador, Expresiones4, Tipo1y, "SADf");
             ReporteTS SIMBOLO = new ReporteTS(Identificador,this.linea,this.columna,"Vector: "+ Tipo1y,ElTipoDeAmbitoRomeo);
             TABLA_ReporteTS .add(SIMBOLO);
          }else{
          entorno.ModificarValorLista(Identificador, Expresiones4, Tipo1y, "SADf");
          }
            // entorno.Agregar2(Identificador, this.Expresiones3, Tipo1y, "SADf");
          entorno.MostrarVectoresLista(entorno, salida);
      

      
          
          
         
           
          
      return "FIN C";
      }
      
        System.out.println("leaaaad-------------------------->");
       
       String val1 = this.Hijos.get(1).Ejecutar(entorno, salida);
       String Tipo1 = this.Hijos.get(1).TipoDato;
       System.out.println("Se esta declarando el vector:" + Identificador + " Tipo->" + Tipo1 + "<-Valor->" + val1);
        System.out.println("oooooh"); 
        
        if(Tipo1.contains("KAMIKAZE")){
            System.out.println("VAMOS A DECLARAR [[]] [[]]");
            System.out.println("EL VALOR ES->" + val1);
            ArrayList <NodoAbstracto> Expresiones4x = new ArrayList();
            ArrayList <NodoAbstracto> Expresiones5x = new ArrayList();
            String Tiposss = "";
            for(int i = 0; i < this.Hijos.get(1).Expresiones.size(); i++){
                String Hola = this.Hijos.get(1).Expresiones.get(i).Ejecutar(entorno, salida);
                String HolaTipo = this.Hijos.get(1).Expresiones.get(i).TipoDato;
                System.out.println("Hola->" + Hola + "Tipo->" + HolaTipo);
                if(HolaTipo.contains("id")){
                    if(entorno.ObtenerListaN(Hola)==0){
                        if(entorno.ExisteVector(Identificador)==false){
                             entorno.Agregar(Identificador, entorno.ObtenerTipo(Hola),entorno.ObtenerValor(Hola));
                            ReporteTS SIMBOLO = new ReporteTS(Identificador,this.linea,this.columna,"Vector: "+ Tiposss,ElTipoDeAmbitoRomeo);
                            TABLA_ReporteTS .add(SIMBOLO);
                        }else{
                            entorno.ModificarValor(Identificador, entorno.ObtenerValor(Hola),entorno.ObtenerTipo(Hola));
                        }
                        return "FINDECASADFASDF";
                    }else{
                             Expresiones4x = entorno.ObtenerLista(Hola);
                             Tiposss = entorno.ObtenerTipo(Hola);
                             
                    }
                }else{
                    Expresiones4x.add(this.Hijos.get(1).Expresiones.get(i));
                    Tiposss = HolaTipo;
                }
            }
             if(entorno.ExisteVector(Identificador)==false){
                        entorno.Agregar2(Identificador,  Expresiones4x, Tiposss, "sdaf");
                         ReporteTS SIMBOLO = new ReporteTS(Identificador,this.linea,this.columna,"Vector: "+ Tiposss,ElTipoDeAmbitoRomeo);
                         TABLA_ReporteTS .add(SIMBOLO);
                    }else{
                        entorno.ModificarValorLista(Identificador,  Expresiones4x, Tiposss, "sdaf");
            }
            
            entorno.MostrarVectores();
            entorno.MostrarVectoresLista(entorno,salida);
            System.out.println("VAMOS A DECLARAR [[]] [[]] FIN");
            return "FINDECA[][][";
        }
        
        
        if(Tipo1.contains("VectorSlushi")){
            System.out.println("VAMOS A VER QUE PEDOslushi");
            System.out.println("IDENTIFICADOR->" + Identificador);
            System.out.println("val1->" + val1);
            for(int i = 0; i< this.Hijos.get(1).Expresiones.size();i++){
                String Salida = this.Hijos.get(1).Expresiones.get(i).Ejecutar(entorno, salida);
                String Tipo1s = this.Hijos.get(1).Expresiones.get(i).TipoDato;
                System.out.println("SADFA->" + Salida + "<->"+ Tipo1s);
                ArrayList <NodoAbstracto> ExpresionesSSSS = new ArrayList();
                if(Tipo1s.contains("id")){
                   if(entorno.ObtenerListaN(Salida)==0){
                       System.out.println("NO TIENE LISTA");
                   String Valor = entorno.ObtenerValor(Salida);
                   String Tipos = entorno.ObtenerTipo(Salida);
                            if(entorno.ExisteVector(Identificador)==false){
                                entorno.Agregar(Identificador, "Lista", Valor);
                            }else{
                                entorno.ModificarValor(Identificador, Valor, "Lista");
                            }
                   
                    }else{
                       System.out.println("SI TIENE LISTA");
                        ExpresionesSSSS = entorno.ObtenerLista(Salida);
                    }
                    System.out.println("TAMANI.>" + ExpresionesSSSS.size());
                    if(entorno.ExisteVector(Identificador)==false){
                        entorno.Agregar2(Identificador, ExpresionesSSSS, "Lista", "sdaf");
                         ReporteTS SIMBOLO = new ReporteTS(Identificador,this.linea,this.columna,"Vector: "+ "Lista",ElTipoDeAmbitoRomeo);
                         TABLA_ReporteTS .add(SIMBOLO);
                    }else{
                        entorno.ModificarValorLista(Identificador, ExpresionesSSSS, "Lista", "sdaf");
                    }
                    entorno.MostrarVectores();
                    entorno.MostrarVectoresLista(entorno,salida);
                    System.out.println("FIN DEL VAMOS A VER QUE PEDO slushis.>");
                      return "FINDECASADF";
                }
            }
            if(entorno.ExisteVector(Identificador)==false){
                        entorno.Agregar2(Identificador, this.Hijos.get(1).Expresiones, "Lista", "sdaf");
                         ReporteTS SIMBOLO = new ReporteTS(Identificador,this.linea,this.columna,"Vector: "+ "Lista",ElTipoDeAmbitoRomeo);
                         TABLA_ReporteTS .add(SIMBOLO);
                    }else{
                        entorno.ModificarValorLista(Identificador, this.Hijos.get(1).Expresiones, "Lista", "sdaf");
            }
            
            System.out.println("FIN DEL VAMOS A VER PEDOslushi");
            
            
            entorno.MostrarVectores();
            entorno.MostrarVectoresLista(entorno,salida);
            return "FIN";
           
        }
        
        
       if(Tipo1.contains("id")){
           ArrayList <NodoAbstracto> Expresionesxxx = new ArrayList();
           if(entorno.ExisteVector(val1)){
               if(entorno.ObtenerListaN(val1)==0){
                   String Valor = entorno.ObtenerValor(val1);
                   String Tipos = entorno.ObtenerTipo(val1);
                    if(entorno.ExisteVector(Identificador)==false){
                        entorno.Agregar(Identificador, Tipos, Valor);
                    }else{
                        entorno.ModificarValor(Identificador, Valor, Tipos);
                    }
                   
               }else{
                   Expresionesxxx = entorno.ObtenerLista(val1);
               }
           }else{
               salida.append("ERROR AL INVOCOAR AL VECTOR" + val1 +"\n");
                //System.out.println("-------->"+  val1    +"<----------------Columna: " + this.columna + "**Fila: " + this.linea+1);
                TError ERRORES = new TError(Identificador,this.linea,this.columna,"Semantico", "ERROR AL INVOCOAR AL VECTOR" + val1 );
                TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                return "#Error";
           }
           if(entorno.ExisteVector(Identificador)==false){
               entorno.Agregar2(Identificador, Expresionesxxx, entorno.ObtenerTipo(val1), "sdaf");
                ReporteTS SIMBOLO = new ReporteTS(Identificador,this.linea,this.columna,"Vector: "+ "Lista",ElTipoDeAmbitoRomeo);
                TABLA_ReporteTS .add(SIMBOLO);
           }else{
               entorno.ModificarValorLista(Identificador, Expresionesxxx, entorno.ObtenerTipo(val1), "sdaf");
           }
           System.out.println("VAMOS A VER QUE PEDO.>");
           entorno.MostrarVectores();
         entorno.MostrarVectoresLista(entorno,salida);
         System.out.println("FIN DEL VAMOS A VER QUE PEDO.>");
           return "FINDECASADF";
       }
       
       if(Tipo1.contains("PERRASOLA")){
        String Pena = Tipo1.replaceAll("PERRASOLA", "");
        entorno.ModificarValorLista(Identificador, entorno.ObtenerLista(Pena), "Lista", "GACHO");
        return "FINDECA";
       }
       
       if(Tipo1.contains("Lista")| Tipo1.contains("SHAKA") | Tipo1.contains("ELHOUR")){
           System.out.println("es una lista" + val1 + "<-NUM>"+ this.Hijos.get(1).id );
           if(val1.contains("ELHOUR")){
               ArrayList <NodoAbstracto> ExpresionesELHOUR = new ArrayList();
               ExpresionesELHOUR = entorno.ObtenerLista("ELHOUR");
               System.out.println("ExpresionesELHOUR->" + ExpresionesELHOUR.size());
               for(int i = 0; i < ExpresionesELHOUR.size(); i++){
                   String Salida = ExpresionesELHOUR.get(i).Ejecutar(entorno, salida);
                   System.out.println("PUMPU.M->" + Salida);
               }
               
               //entorno.MostrarVectoresLista(entorno, salida);
               if(entorno.ExisteVector(Identificador)==false){
                               entorno.Agregar2(Identificador, ExpresionesELHOUR, "cadena", "AF");
                            }else{
                              entorno.ModificarValorLista(Identificador, ExpresionesELHOUR, "cadena", "AF");
                            }
               entorno.MostrarVectoresLista(entorno, salida);
               return "FINDECA";
           }
           if(val1.contains("SHAKALACA")){
               ArrayList <NodoAbstracto> ExpresionesSHAKA = new ArrayList();
               ExpresionesSHAKA = entorno.ObtenerLista("SHAKALAKA");
               System.out.println("ExpresionesSHAAK->" + ExpresionesSHAKA.size());
               for(int i = 0; i < ExpresionesSHAKA.size(); i++){
                   String Salida = ExpresionesSHAKA.get(i).Ejecutar(entorno, salida);
                   System.out.println("PUMPU.M->" + Salida);
               }
               
               //entorno.MostrarVectoresLista(entorno, salida);
               if(entorno.ExisteVector(Identificador)==false){
                               entorno.Agregar2(Identificador, ExpresionesSHAKA, "cadena", "AF");
                            }else{
                              entorno.ModificarValorLista(Identificador, ExpresionesSHAKA, "cadena", "AF");
                            }
               entorno.MostrarVectoresLista(entorno, salida);
               return "FINDECA";
           }
           
           
           ArrayList <NodoAbstracto> Expresionesxxx = new ArrayList();
           if(entorno.ExisteVector(val1)){
               if(entorno.ObtenerListaN(val1)==0){
                   String Valor = entorno.ObtenerValor(val1);
                   String Tipos = entorno.ObtenerTipo(val1);
                    if(entorno.ExisteVector(Identificador)==false){
                        entorno.Agregar(Identificador, Tipos, Valor);
                    }else{
                        entorno.ModificarValor(Identificador, Valor, Tipos);
                    }
                   
               }else{
                   Expresionesxxx = entorno.ObtenerLista(val1);
               }
           }else if(this.Hijos.get(1).id==0){
                if(entorno.ExisteVector(Identificador)==false){
                    entorno.Agregar(Identificador, "Lista", val1);
                    ReporteTS SIMBOLO = new ReporteTS(Identificador,this.linea,this.columna,"Vector: "+ "Lista",ElTipoDeAmbitoRomeo);
                    TABLA_ReporteTS .add(SIMBOLO);
                }else{
                    entorno.ModificarValor(Identificador, val1, "Lista");
                }
                  entorno.MostrarVectores();
         entorno.MostrarVectoresLista(entorno,salida);
                return "findeca";
           }
           else{
               salida.append("ERROR AL INVOCOAR AL VECTOR " + val1 +"\n");
                //System.out.println("-------->"+  val1    +"<----------------Columna: " + this.columna + "**Fila: " + this.linea+1);
                TError ERRORES = new TError(Identificador,this.linea,this.columna,"Semantico", "ERROR AL INVOCOAR AL VECTOR " + val1 );
                TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                return "#Error";
           }
           if(entorno.ExisteVector(Identificador)==false){
               entorno.Agregar2(Identificador, Expresionesxxx, "Lista", "sdaf");
                ReporteTS SIMBOLO = new ReporteTS(Identificador,this.linea,this.columna,"Vector: "+ "Lista",ElTipoDeAmbitoRomeo);
                TABLA_ReporteTS .add(SIMBOLO);
           }else{
               entorno.ModificarValorLista(Identificador, Expresionesxxx, "Lista", "sdaf");
           }
           entorno.MostrarVectores();
         entorno.MostrarVectoresLista(entorno,salida);
           return "FINDECASADF";
       }
       
       if(Tipo1.contains("FuncionC")){
           System.out.println("---->los hijos son->"+  this.Hijos.get(1).Expresiones.size());
           for(int i = 0; i < this.Hijos.get(1).Expresiones.size(); i++){
               String Taza = this.Hijos.get(1).Expresiones.get(i).Ejecutar(entorno, salida);
               System.out.println("ARDER->"+ Taza);
           }
           
           if(entorno.ExisteVector(Identificador)==false){
               entorno.Agregar2(Identificador, this.Hijos.get(1).Expresiones, "Lista", "sdaf");
                ReporteTS SIMBOLO = new ReporteTS(Identificador,this.linea,this.columna,"Vector: "+ "Lista",ElTipoDeAmbitoRomeo);
                TABLA_ReporteTS .add(SIMBOLO);
           }else{
               entorno.ModificarValorLista(Identificador, this.Hijos.get(1).Expresiones, "Lista", "sdaf");
           }
           entorno.MostrarVectores();
         entorno.MostrarVectoresLista(entorno,salida);
           return "FINDEC";
       }
       
       if(Tipo1.contains("CasteoC")){
           System.out.println("vamos a castenar de nuevo <V");
           System.out.println("---->los hijos son->"+  this.Hijos.get(1).Expresiones.size());
           String Tipo1y;
           for(int i = 0; i < this.Hijos.get(1).Expresiones.size(); i++){
               String Taza = this.Hijos.get(1).Expresiones.get(i).Ejecutar(entorno, salida);
               String TipoDelResultado = this.Hijos.get(1).Expresiones.get(i).TipoDato;
               System.out.println("IRONMANR->"+ Taza);
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
             
         
                String SSSSSS = "";
                    if(valor1 == 1){
                        SSSSSS = "Lista";
                    }else if(valor2 == 1){
                        SSSSSS = "cadena";
                    }
                    else if(valor3 == 1){
                        SSSSSS = "decimal";
                    }
                    else if(valor4 == 1){
                        SSSSSS = "entero";
                    }
                    else if(valor5 == 1){
                        SSSSSS = "booleano";
                    }
                    System.out.println("EL FINAL DEL CASETEO ES->" + SSSSSS);
                    ArrayList <NodoAbstracto> Expresiones4 = new ArrayList();
             for(int i = 0; i < this.Hijos.get(1).Expresiones.size(); i ++){
                 String Valorxd = this.Hijos.get(1).Expresiones.get(i).Ejecutar(entorno, salida);
                 String TipoVector = this.Hijos.get(1).Expresiones.get(i).TipoDato;
                 if("decimal".equals(SSSSSS) && "entero".equals(TipoVector)){
                                  Valorxd = Valorxd + ".0";
                }
                else if("decimal".equals(SSSSSS) && "booleano".equals(TipoVector)){
                   if("true".equals(Valorxd)){
                         Valorxd = "1.0";
                    }
                    else{
                         Valorxd = "0.0";
                    }

              }
              else if("entero".equals(SSSSSS) && "booleano".equals(TipoVector)){
                if("true".equals(Valorxd))
                  Valorxd = "1";
                else
                 Valorxd = "0";
              }
              NodoAbstracto nuevo = new Nodo("Cadena");
              NodoAbstracto nuevovalor = new Nodo(Valorxd);
              nuevo.Hijos.add(nuevovalor);
              nuevo.TipoDato = SSSSSS;
              Expresiones4.add(nuevo);
          }
             
              boolean ExisteVector =  entorno.ExisteVector(Identificador); 
      
        if(!ExisteVector == true){
            entorno.Agregar2(Identificador, Expresiones4, SSSSSS, "prit2");
        }else{
            entorno.ModificarValorLista(Identificador, Expresiones4, SSSSSS, "prit2");
        }
         
         entorno.MostrarVectores();
         entorno.MostrarVectoresLista(entorno,salida);
         System.out.println("---------");
             
           return "FINDECA";
       }
       
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
            System.out.println("AGREGAMOS EL VECTOR NUEVO->" + Identificador);
            entorno.Agregar(Identificador, Tipo1, val1);
        }else{
            entorno.EliminarVector(Identificador);
            entorno.Agregar(Identificador, Tipo1, val1);
            //entorno.ModificarValor(Identificador, val1, Tipo1);
        }
        
        entorno.MostrarVectores();
         entorno.MostrarVectoresLista(entorno,salida);
         System.out.println("DONT TOUCH ME");
         ReporteTS SIMBOLO = new ReporteTS(Identificador,this.linea,this.columna,"Vector: "+ Tipo1,ElTipoDeAmbitoRomeo);
          TABLA_ReporteTS .add(SIMBOLO);
        System.out.println("---------");
      return "FIN DECLARAR ASGINAR";
    }
    
}
