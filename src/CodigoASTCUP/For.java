/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoASTCUP;

import static Analizadores.IDE.TABLA_DE_ERRORES_SINTACTICOS;
import static Analizadores.IDE.ElTipoDeAmbitoRomeo;
import static Analizadores.IDE.NumeroEntornosRomeo;
import Analizadores.TError;
import Codigo.Entorno;
import javax.swing.JTextArea;

/**
 *
 * @author Bayyron
 */
public class For extends NodoAbstracto{

    public For (String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        
        this.Expresiones.clear();
            for(int i = 0; i < this.Hijos.get(2).Hijos.size(); i++){
                this.Expresiones.add(this.Hijos.get(2).Hijos.get(i));
            }
            
       String NombreTemporal = this.Hijos.get(0).Nombre;
       String ExpresionTemporal =this.Hijos.get(0).Ejecutar(entorno, salida);
       String TipoTemporal = entorno.ObtenerTipo(this.Hijos.get(0).Nombre); 
        
        
       String TipoVariable1 =this.Hijos.get(0).TipoDato;
       System.out.println("Variable 1: " + TipoVariable1);
       Entorno Temporal = new Entorno();
       entorno.AgregarElementosANuevoEntorno(entorno,Temporal);
        ElTipoDeAmbitoRomeo = "Local: FOR";
        NumeroEntornosRomeo++;
        
        //trabajemos los valores de la expresion 1
        if("id".equals(TipoVariable1)){
            String NombreVariable1 = this.Hijos.get(0).Nombre;
            String NombreVariable2 = this.Hijos.get(1).Nombre;
            String TipoVariable2 = this.Hijos.get(1).TipoDato;
            String ValorVariable2 = this.Hijos.get(1).Ejecutar(Temporal, salida);
            System.out.println("NombreVariable2->" + NombreVariable2 + "Tipo2" + TipoVariable2); 
            System.out.println("NombreVariable1->" + NombreVariable1);
            if(Temporal.ExisteVector(NombreVariable1)==false){
                Temporal.Agregar(NombreVariable1, "entero", "1");
            }
            if("entero".equals(TipoVariable2) || "decimal".equals(TipoVariable2) || "cadena".equals(TipoVariable2) || "booleano".equals(TipoVariable2) ){
                Temporal.ModificarValor(NombreVariable1,ValorVariable2 , TipoVariable2);
                for(int x = 0; x < this.Expresiones.size(); x++){
                        String Resultado = this.Expresiones.get(x).Ejecutar(Temporal, salida);
                         if("break".equals(Resultado)){
                            entorno = entorno.ModificandoEntornos(Temporal,entorno);
                            System.out.println("NombreTemporal" + NombreTemporal);
                            //entorno.ModificarValor(NombreTemporal,ExpresionTemporal,TipoTemporal);
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            return "FIN FOR";
                        }
                         if("continue".equals(Resultado)){
                             x = this.Expresiones.size()-1;
                        }
                }
            }else if("id".equals(TipoVariable2)){
                if(Temporal.ObtenerListaN(NombreVariable2)==0){
                    System.out.println("ES VECTOR CORTO");
                    Temporal.ModificarValor(NombreVariable1,ValorVariable2 , Temporal.ObtenerTipo(NombreVariable2));
                    for(int x = 0; x < this.Expresiones.size(); x++){
                            String Resultado = this.Expresiones.get(x).Ejecutar(Temporal, salida);
                         if("break".equals(Resultado)){
                            entorno = entorno.ModificandoEntornos(Temporal,entorno);
                            System.out.println("NombreTemporal" + NombreTemporal);
                            //entorno.ModificarValor(NombreTemporal,ExpresionTemporal,TipoTemporal);
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            return "FIN FOR";
                        }
                         if("continue".equals(Resultado)){
                             x = this.Expresiones.size()-1;
                        }
                    }                
                }else{
                    System.out.println("ES VECTOR LARGO");
                    for(int i = 0; i< Temporal.ObtenerLista(NombreVariable2).size();i++){
                        String ValorNuevo = Temporal.ObtenerLista(NombreVariable2).get(i).Ejecutar(Temporal, salida);
                        String TipoNuevo = Temporal.ObtenerLista(NombreVariable2).get(i).TipoDato;
                        //System.out.println("El nuevo valor->" + ValorNuevo);
                        //System.out.println("El nuevo Tipo->" + TipoNuevo);
                        Temporal.ModificarValor(NombreVariable1,ValorNuevo,TipoNuevo);
                        for(int x = 0; x < this.Expresiones.size(); x++){
                            String Resultado = this.Expresiones.get(x).Ejecutar(Temporal, salida);
                        if("break".equals(Resultado)){
                            entorno = entorno.ModificandoEntornos(Temporal,entorno);
                            System.out.println("NombreTemporal" + NombreTemporal);
                            //entorno.ModificarValor(NombreTemporal,ExpresionTemporal,TipoTemporal);
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            return "FIN FOR";
                        }
                         if("continue".equals(Resultado)){
                             x = this.Expresiones.size()-1;
                        }
                        } 
                    }
                }
            }else if("vector".equals(TipoVariable2)){
                String ValorNuevo = this.Hijos.get(1).Ejecutar(Temporal, salida);
                String TipoNuevo = this.Hijos.get(1).TipoDato;
                System.out.println("VAMOS CON EL ENUEVO VALOR->" + ValorNuevo + "->Tipo" + TipoNuevo);
                Temporal.ModificarValor(NombreVariable1,ValorNuevo,TipoNuevo);
                for(int x = 0; x < this.Expresiones.size(); x++){
                    String Resultado = this.Expresiones.get(x).Ejecutar(Temporal, salida);
                     if("break".equals(Resultado)){
                            entorno = entorno.ModificandoEntornos(Temporal,entorno);
                            System.out.println("NombreTemporal" + NombreTemporal);
                            //entorno.ModificarValor(NombreTemporal,ExpresionTemporal,TipoTemporal);
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            return "FIN FOR";
                        }
                         if("continue".equals(Resultado)){
                             x = this.Expresiones.size()-1;
                        }
                } 
            }
            
        }else{
            salida.append("#ERROR: La expresion1 debe ser un vector + \n");
            TError ERRORES = new TError("FOR",this.linea,this.columna,"Semantico", "#ERROR: La expresion1 debe ser un vector");
            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
            return "#ERROR: La expresion1 debe ser un vector";
        }
               
        entorno = entorno.ModificandoEntornos(Temporal,entorno);
        System.out.println("NombreTemporal" + NombreTemporal);
        //entorno.ModificarValor(NombreTemporal,ExpresionTemporal,TipoTemporal);
       /*
       String Expresion = this.Hijos.get(0).Ejecutar(entorno, salida);
       String TipoExpresion = this.Hijos.get(0).TipoDato;
       
       String NombreTemporal = this.Hijos.get(0).Nombre;
       String ExpresionTemporal =this.Hijos.get(0).Ejecutar(entorno, salida);
       String TipoTemporal = entorno.ObtenerTipo(this.Hijos.get(0).Nombre);
       
       
       if("id".equals(TipoExpresion)){
           entorno.ModificarValor(this.Hijos.get(0).Nombre, this.Hijos.get(1).Ejecutar(entorno, salida), "entero");
           TipoExpresion = entorno.ObtenerTipo(this.Hijos.get(0).Nombre);
       }
       System.out.println("Expresion->" + Expresion + " Tipo->" + TipoExpresion);
       String ExpresionFinal = this.Hijos.get(1).Ejecutar(entorno, salida);
       String TipoExpresionFinal = this.Hijos.get(1).TipoDato;
       System.out.println("Final->" + ExpresionFinal + " Tipo->" + TipoExpresionFinal);
       System.out.println("Total de expresiones" + this.Expresiones.size());
       if("#Error".equals(TipoExpresion) || "#Error".equals(TipoExpresionFinal) || this.Expresiones.size()==0)
       {
            salida.append("#ERROR: La Sentencia del FOR es incorrecta \n");
            TError ERRORES = new TError("FOR",this.linea,this.columna,"Semantico", "ERROR: La Sentencia del FOR es incorrecta"  );
            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
            return "#Error en For";
       }
       if("entero".equals(TipoExpresion) && "entero".equals(TipoExpresionFinal)){
           int Inicio = Integer.valueOf(Expresion);
           int Final = Integer.valueOf(ExpresionFinal);
           Inicio = Final-1;
           Entorno Temporal = new Entorno();
           entorno.AgregarElementosANuevoEntorno(entorno,Temporal);
           for(int i = Inicio;i < Final;i++){
               for(int x = 0; x < this.Expresiones.size(); x++){
                   String Resultado = this.Expresiones.get(x).Ejecutar(Temporal, salida);
            }
            entorno = entorno.ModificandoEntornos(Temporal,entorno);
               System.out.println("NombreTemporal" + NombreTemporal);
             entorno.ModificarValor(NombreTemporal,ExpresionTemporal,TipoTemporal);
           }
           
       }else{
            salida.append("#ERROR: La Sentencia del FOR es incorrecta \n");
            TError ERRORES = new TError("FOR",this.linea,this.columna,"Semantico", "ERROR: La Sentencia del FOR es incorrecta un parametro no es entero"  );
            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
            return "#Error en For";
       }
       
       */
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
       return "FINFOR";
    }
    
}
