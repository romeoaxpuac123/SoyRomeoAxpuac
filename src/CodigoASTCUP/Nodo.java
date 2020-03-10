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
public class Nodo extends NodoAbstracto{

    
    @Override
    public void Ejecutar() {
        System.out.println("Ejecutar nodo");
    }
    
    public Nodo(String val)
    {
        this.Nombre = val;
        this.id=0;
        this.linea=0;
        this.columna=0;
        this.Hijos = new ArrayList<>();
    }
    
    public Nodo(String val, int lin, int col)
    {
        this.Nombre = val;
        this.id=0;
        this.linea=lin;
        this.columna=col;
        this.Hijos = new ArrayList<>();
    }

    @Override
    public String Ejecutar(Entorno entorno,JTextArea salida) {
        String sali = "";
        if(this.Nombre.contains("#Error")){
             sali = this.Hijos.get(0).Nombre;
        }
    //  System.out.println("nombre...........>" + this.Nombre);
        switch(this.Nombre){
            case "TypeOF":
                Entorno Temporal = new Entorno();
                entorno.AgregarElementosANuevoEntorno(entorno,Temporal);
                String Tipo = this.Hijos.get(0).TipoDato;
                if(Tipo.contains("id")){
                    Tipo = Temporal.ObtenerTipo(this.Hijos.get(0).Nombre);
                }
                if(Tipo.contains("entero")){
                    Tipo = "Integer";
                }else  if(Tipo.contains("decimal")){
                    Tipo = "Numeric";
                }
                else if(Tipo.contains("booleano")){
                    Tipo = "Boolean";
                }else  if(Tipo.contains("cadena")){
                    Tipo = "String";
                }else  if(Tipo.contains("Lista")){
                    Tipo = "List";
                }
                
                //System.out.println("el valor es->" + Valor);
                sali= Tipo;
            break;
            case "Length":
                Entorno Tempora2l = new Entorno();
                entorno.AgregarElementosANuevoEntorno(entorno,Tempora2l);
                String TipoL = this.Hijos.get(0).TipoDato;
                if(!TipoL.contains("id")){
                    salida.append("#ERROR: la función Length usa un parametro incorrecto");
                    TError ERRORES = new TError("Lenght",this.linea,this.columna,"Semantico", "#ERROR: la función Length usa un parametro incorrecto" );
                    TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                    return "#Error";
                }
                int tamanio = Tempora2l.ObtenerLista(this.Hijos.get(0).Nombre).size();
                sali = tamanio + "";
                break;
            case "StringLength":
                Entorno Temporalx = new Entorno();
                entorno.AgregarElementosANuevoEntorno(entorno,Temporalx);
                String TipoLx = this.Hijos.get(0).TipoDato;
                String Valor = this.Hijos.get(0).Ejecutar(Temporalx, salida);
                if(TipoLx.contains("cadena")){
                    sali = Valor.length() + "";
                }else if (TipoLx.contains("id")){
                    if(Temporalx.ObtenerListaN(this.Hijos.get(0).Nombre) ==0 && Temporalx.ObtenerTipo(this.Hijos.get(0).Nombre).contains("cadena")){
                        Valor = Temporalx.ObtenerValor(this.Hijos.get(0).Nombre).length() + "";
                        sali = Valor;
                    }else{
                        salida.append("#ERROR: la función Length usa un parametro incorrecto");
                        TError ERRORES = new TError("Lenght",this.linea,this.columna,"Semantico", "#ERROR: la función Length usa un parametro incorrecto" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                    }
                }else{
                        salida.append("#ERROR: la función String Length usa un parametro incorrecto");
                        TError ERRORES = new TError("Lenght",this.linea,this.columna,"Semantico", "#ERROR: la función String Length usa un parametro incorrecto" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                }
                
                break;
            case "Entero":
                sali = this.Hijos.get(0).Nombre;
                break;
            case "Decimal":
                sali = this.Hijos.get(0).Nombre;
                break;
            case "Cadena":
                sali = this.Hijos.get(0).Nombre;
             case "Booleano":
                sali = this.Hijos.get(0).Nombre;
                break;
            case "id":
                
                sali = entorno.ObtenerValor(this.Hijos.get(0).Nombre);
                
                
                if("".equals(sali)){
                    sali = entorno.ObtenerValor(this.Nombre);
                }
                if ("#Error".equalsIgnoreCase(sali)){
                    salida.append("#Error: No se ha encontrado la variables -> "+this.Hijos.get(0).Nombre+"\n");
                }
                break;
            case "Vector":
                String Identificador = this.Hijos.get(0).Nombre;
                if(entorno.ExisteVector(Identificador)==false){
                    System.out.println("El vector" + Identificador + "No Existe");
                    salida.append("#Error: No se ha encontrado el vector -> "+Identificador+"\n");
                    TError ERRORES = new TError(Identificador,this.linea,this.columna,"Semantico", "No se ha encontrado el vector -> "+Identificador );
                    TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                    return "#Error";
                }
               System.out.println("DATOS LLAMADO-> Vector:" + Identificador + " POSICION->" + this.id + " TipoDato->" + entorno.ObtenerTipo(Identificador));
                if(entorno.ObtenerListaN(Identificador) ==0){
                    sali = entorno.ObtenerValor(Identificador);
                    this.TipoDato = entorno.ObtenerTipo(Identificador);
                 }else{
                  String limite = this.Hijos.get(1).Ejecutar(entorno, salida);
                  //  System.out.println("limite es:" + limite + "--------------------");
                  String Tipo1 = this.Hijos.get(1).TipoDato;
                  String val1 = entorno.NodoLista(Identificador, Integer.parseInt(limite)-1).Ejecutar(entorno, salida);
                  this.TipoDato = entorno.ObtenerTipo(Identificador);
                  sali = val1;
                    
                }
                //sali = this.Hijos.get(0).Nombre;
                break;
            case "x":
                
                break;
            default:
                if(entorno.ObtenerListaN(this.Nombre)==1){
                    String hola = "[";
                    this.Expresiones = entorno.ObtenerLista(this.Nombre);
                    for(int i = 0; i < this.Expresiones.size();i++){
                        hola = hola +this.Expresiones.get(i).Ejecutar(entorno, salida) + ",";
                    }
                    hola = hola.substring(0, hola.length()-1) + "]";
                    sali = hola;
                    this.Expresiones.clear();
                    return sali;
                }
                sali = entorno.ObtenerValor(this.Nombre);
        }
        return sali;
    }
    
    
}
