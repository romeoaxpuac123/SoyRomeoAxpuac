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
        // System.out.println("MODIFICANDO VECTOR->" + Vector + " Posición->" + Posicion + " Nuevoalor->" + NuevoValor);
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
            System.out.println("FIN->" + NuevoValor);
        }
        System.out.println("FIN->" + NuevoValor);
        boolean ExisteVector =  entorno.ExisteVector(Vector); 
      
        if(ExisteVector == true){
             System.out.println("FIN->" + NuevoValor);
            //entorno.Agregar(Identificador, Tipo1, val1);
            // System.out.println("MODIFICANDO VECTOR->" + Vector + " Posición->" + Posicion + " Nuevoalor->" + NuevoValor);
              ArrayList <NodoAbstracto> ExpresionesRomeo = new ArrayList();
              //ExpresionesRomeo = entorno.ObtenerLista(Vector);
                if(entorno.ObtenerListaN(Vector) ==0){
                    //vectores de una posicion
                    if(Integer.parseInt(Posicion) == 1){
                        entorno.ModificarValor(Vector, NuevoValor, entorno.ObtenerTipo(Vector));
                    }
                    else{
                        NodoAbstracto nuevo = new Nodo("Cadena");
                        NodoAbstracto nuevovalor = new Nodo("nulo");
                        nuevo.Hijos.add(nuevovalor);
                        nuevo.TipoDato = "cadena";
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
                                ExpresionesRomeo.add( this.Hijos.get(2));
                            }else{
                                ExpresionesRomeo.add(nuevo);
                            }
                        }
                        entorno.ModificarValorLista(Vector, ExpresionesRomeo, entorno.ObtenerTipo(Vector),"asdfasd");
                    }
                 }else{
                    //Vectores de 2 o más posciones
                        System.out.println("modificando vector maor2->" + Posicion);
                        String TipoDelVectorXD = entorno.ObtenerTipo(Vector);
                        String Valor = "nulo";
                        if(TipoDelVectorXD.equalsIgnoreCase("entero")){
                            Valor = "0";
                        }
                        if(TipoDelVectorXD.equalsIgnoreCase("decimal")){
                            Valor = "0.0";
                        }
                        if(TipoDelVectorXD.equalsIgnoreCase("booleano")){
                            Valor = "false";
                        }
                        System.out.println("FIN->" + NuevoValor);
                        NodoAbstracto nuevo = new Nodo("Cadena");
                        NodoAbstracto nuevovalor = new Nodo(Valor);
                        nuevo.Hijos.add(nuevovalor);
                        nuevo.TipoDato = TipoDelVectorXD;
                        ArrayList <NodoAbstracto> ExpresionesRomeo2 = new ArrayList();
                        ExpresionesRomeo = entorno.ObtenerLista(Vector);
                        if(ExpresionesRomeo.size()>=Integer.parseInt(Posicion)){
                            System.out.println("entro if");
                            for(int i = 0; i < ExpresionesRomeo.size();i++ ){
                                if(i == Integer.parseInt(Posicion)-1){
                                    ExpresionesRomeo2.add( this.Hijos.get(2).Hijos.get(1).Hijos.get(0));
                                }else{
                                    ExpresionesRomeo2.add(ExpresionesRomeo.get(i));
                                }
                                
                            }
                        }else{
                            System.out.println("entro else");
                            for(int i = 0; i < Integer.parseInt(Posicion);i++){
                                if(i== Integer.parseInt(Posicion)-1){
                                    ExpresionesRomeo2.add( this.Hijos.get(2).Hijos.get(1).Hijos.get(0));
                                }
                                else if(ExpresionesRomeo.size()>i){
                                    //ExpresionesRomeo2.add(nuevo);
                                    ExpresionesRomeo2.add(ExpresionesRomeo.get(i));
                                }else{
                                    ExpresionesRomeo2.add(nuevo);
                                }
                            }
                        }
                       
                        entorno.ModificarValorLista(Vector, ExpresionesRomeo2, entorno.ObtenerTipo(Vector),"asdfasd");
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
