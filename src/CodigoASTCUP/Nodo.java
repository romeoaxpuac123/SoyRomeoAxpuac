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
                if(sali.length() == 0 ){
                    return "#Error";
                }
            break;
            case "Length":
                Entorno Tempora2l = new Entorno();
                entorno.AgregarElementosANuevoEntorno(entorno,Tempora2l);
                String TipoL = this.Hijos.get(0).TipoDato;
                if(!TipoL.contains("id")){
                    salida.append("#ERROR: la función Length usa un parametro incorrecto" + "\n");
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
                        salida.append("#ERROR: la función Length usa un parametro incorrecto" + "\n");
                        TError ERRORES = new TError("Lenght",this.linea,this.columna,"Semantico", "#ERROR: la función Length usa un parametro incorrecto" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#Error";
                    }
                }else{
                        salida.append("#ERROR: la función String Length usa un parametro incorrecto" + "\n");
                        TError ERRORES = new TError("Lenght",this.linea,this.columna,"Semantico", "#ERROR: la función String Length usa un parametro incorrecto" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#Error";
                }
                
                break;
            case "Remove":
                Entorno Temporalx2 = new Entorno();
                entorno.AgregarElementosANuevoEntorno(entorno,Temporalx2);
                String TipoLx2 = this.Hijos.get(0).TipoDato;
                String Valor2 = this.Hijos.get(0).Ejecutar(Temporalx2, salida);
                String CadenaEliminar = this.Hijos.get(1).Ejecutar(Temporalx2, salida);
                System.out.println("sad...>" + Valor2 + "-->" + CadenaEliminar);
                if(TipoLx2.contains("cadena")){
                    sali = Valor2.replace(CadenaEliminar , "");
                }else if (TipoLx2.contains("id")){
                    if(Temporalx2.ObtenerListaN(this.Hijos.get(0).Nombre) ==0 && Temporalx2.ObtenerTipo(this.Hijos.get(0).Nombre).contains("cadena") 
                            && Temporalx2.ObtenerListaN(this.Hijos.get(1).Nombre) ==0 && Temporalx2.ObtenerTipo(this.Hijos.get(1).Nombre).contains("cadena")  ){
                        Valor = Temporalx2.ObtenerValor(this.Hijos.get(0).Nombre).replace(CadenaEliminar , "");
                        sali = Valor;
                    }else{
                        salida.append("#ERROR: la función Remove usa un parametro incorrecto" +  "\n");
                        TError ERRORES = new TError("Lenght",this.linea,this.columna,"Semantico", "#ERROR: la función Remove usa un parametro incorrecto" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#Error";
                    }
                }else{
                        salida.append("#ERROR: la función String Length usa un parametro incorrecto" + "\n");
                        TError ERRORES = new TError("Lenght",this.linea,this.columna,"Semantico", "#ERROR: la función Remove usa un parametro incorrecto" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#Error";
                }
                break;
            case "ToLowerCase":
                Entorno Temporalxx = new Entorno();
                entorno.AgregarElementosANuevoEntorno(entorno,Temporalxx);
                String TipoLxx = this.Hijos.get(0).TipoDato;
                String Valorx = this.Hijos.get(0).Ejecutar(Temporalxx, salida);
                if(TipoLxx.contains("cadena")){
                    sali = Valorx.toLowerCase();
                }else if (TipoLxx.contains("id")){
                    if(Temporalxx.ObtenerListaN(this.Hijos.get(0).Nombre) ==0 && Temporalxx.ObtenerTipo(this.Hijos.get(0).Nombre).contains("cadena")){
                        Valor = Temporalxx.ObtenerValor(this.Hijos.get(0).Nombre).toLowerCase();
                        sali = Valor;
                    }else{
                        salida.append("#ERROR: la función ToLowerCase usa un parametro incorrecto" +  "\n");
                        TError ERRORES = new TError("Lenght",this.linea,this.columna,"Semantico", "#ERROR: la función ToLowerCase usa un parametro incorrecto" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#Error";
                    }
                }else{
                        salida.append("#ERROR: la función String ToLowerCase usa un parametro incorrecto" +  "\n");
                        TError ERRORES = new TError("Lenght",this.linea,this.columna,"Semantico", "#ERROR: la función ToLowerCase usa un parametro incorrecto" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#Error";
                }
                break;
            case "ToUpperCase":
                Entorno Temporalxxx = new Entorno();
                entorno.AgregarElementosANuevoEntorno(entorno,Temporalxxx);
                String TipoLxxx = this.Hijos.get(0).TipoDato;
                String Valorxx = this.Hijos.get(0).Ejecutar(Temporalxxx, salida);
                if(TipoLxxx.contains("cadena")){
                    sali = Valorxx.toUpperCase();
                }else if (TipoLxxx.contains("id")){
                    if(Temporalxxx.ObtenerListaN(this.Hijos.get(0).Nombre) ==0 && Temporalxxx.ObtenerTipo(this.Hijos.get(0).Nombre).contains("cadena")){
                        Valor = Temporalxxx.ObtenerValor(this.Hijos.get(0).Nombre).toUpperCase();
                        sali = Valor;
                    }else{
                        salida.append("#ERROR: la función ToUpperCase usa un parametro incorrecto"+  "\n");
                        TError ERRORES = new TError("Lenght",this.linea,this.columna,"Semantico", "#ERROR: la función toUpperCase usa un parametro incorrecto" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#Error";
                    }
                }else{
                        salida.append("#ERROR: la función String ToUpperCase usa un parametro incorrecto"+  "\n");
                        TError ERRORES = new TError("Lenght",this.linea,this.columna,"Semantico", "#ERROR: la función toUpperCase usa un parametro incorrecto" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#Error";
                }
                break;
            case "Trunk":
                Entorno Temporalxxxxp = new Entorno();
                entorno.AgregarElementosANuevoEntorno(entorno,Temporalxxxxp);
                String TipoLxxxx = this.Hijos.get(0).TipoDato;
                
                //System.out.println("-->" + Valorxxxx + "<->" + TipoLxxxx);
                if(TipoLxxxx.contains("decimal")){
                    String Valorxxxx = this.Hijos.get(0).Ejecutar(Temporalxxxxp, salida);
                    System.out.println("HACIENDO CONVERSACION");
                    //sali = String. Valorxxx.toUpperCase();
                    long xp =  (long) Double.parseDouble(Valorxxxx);
                    sali =  String.valueOf(xp);
                    System.out.println("HACIENDO CONVERSACION" + sali);
                }else if (TipoLxxxx.contains("id")){
                    if(Temporalxxxxp.ObtenerListaN(this.Hijos.get(0).Nombre) ==0 && Temporalxxxxp.ObtenerTipo(this.Hijos.get(0).Nombre).contains("decimal")){
                         long xp =  (long) Double.parseDouble(Temporalxxxxp.ObtenerValor(this.Hijos.get(0).Nombre));
                        sali =  String.valueOf(xp);
                    }else{
                        salida.append("#ERROR: la función trunk usa un parametro incorrecto" +  "\n");
                        TError ERRORES = new TError("Lenght",this.linea,this.columna,"Semantico", "#ERROR: la función Trunk usa un parametro incorrecto" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#Error";
                    }
                }else{
                        salida.append("#ERROR: la función String trunk usa un parametro incorrecto" + "\n");
                        TError ERRORES = new TError("Lenght",this.linea,this.columna,"Semantico", "#ERROR: la función Trunk usa un parametro incorrecto" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#Error";
                }
                System.out.println("HACIENDO CONVERSACION fin"  );
                break;
                    
            case "Round":
                Entorno Temporalxxxxp2 = new Entorno();
                entorno.AgregarElementosANuevoEntorno(entorno,Temporalxxxxp2);
                String TipoLxxxx2 = this.Hijos.get(0).TipoDato;
                //String Valorxxxx2 = this.Hijos.get(0).Ejecutar(Temporalxxxxp2, salida);
                //System.out.println("-->" + Valorxxxx2 + "<->" + TipoLxxxx2);
                if(TipoLxxxx2.contains("decimal")){
                    String Valorxxxx2 = this.Hijos.get(0).Ejecutar(Temporalxxxxp2, salida);
                    System.out.println("HACIENDO CONVERSACION" + Valorxxxx2);
                    //sali = String. Valorxxx.toUpperCase();
                    if(Valorxxxx2.contains(".0")|Valorxxxx2.contains(".1")|Valorxxxx2.contains(".2")|Valorxxxx2.contains(".3")
                            | Valorxxxx2.contains(".4")){
                         String xp = String.valueOf(Math.round(Double.parseDouble(Valorxxxx2)));
                         sali = xp + "";
                    }else if (Valorxxxx2.contains(".5")|Valorxxxx2.contains(".6")|Valorxxxx2.contains(".7")|Valorxxxx2.contains(".8")
                            | Valorxxxx2.contains(".9")){
                            String xp = String.valueOf(Math.round(Double.parseDouble(Valorxxxx2)));
                            sali = xp + "";
                    }
                    //sali =  String.valueOf(xp);
                    System.out.println("HACIENDO CONVERSACION" + sali);
                }else if (TipoLxxxx2.contains("id")){
                    if(Temporalxxxxp2.ObtenerListaN(this.Hijos.get(0).Nombre) ==0 && Temporalxxxxp2.ObtenerTipo(this.Hijos.get(0).Nombre).contains("decimal")){
                         double xp =   Double.parseDouble(Temporalxxxxp2.ObtenerValor(this.Hijos.get(0).Nombre));
                         String Valorxxxx2 = xp + "";
                         System.out.println("PISDFADSF->" + Valorxxxx2);
                         if(Valorxxxx2.contains(".0")|Valorxxxx2.contains(".1")|Valorxxxx2.contains(".2")|Valorxxxx2.contains(".3")
                            | Valorxxxx2.contains(".4")){
                         String xp2 = String.valueOf(Math.round(Double.parseDouble(Valorxxxx2)));
                         sali = xp2 + "";
                    }else if (Valorxxxx2.contains(".5")|Valorxxxx2.contains(".6")|Valorxxxx2.contains(".7")|Valorxxxx2.contains(".8")
                            | Valorxxxx2.contains(".9")){
                            String xp2 = String.valueOf(Math.round(Double.parseDouble(Valorxxxx2)));
                            sali = xp2 + "";
                    }
                         
                    }else{
                        salida.append("#ERROR: la función round usa un parametro incorrecto" +  "\n");
                        TError ERRORES = new TError("Lenght",this.linea,this.columna,"Semantico", "#ERROR: la función round usa un parametro incorrecto" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#Error";
                    }
                }else{
                        salida.append("#ERROR: la función String round usa un parametro incorrecto" + "\n");
                        TError ERRORES = new TError("Lenght",this.linea,this.columna,"Semantico", "#ERROR: la función round usa un parametro incorrecto" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#Error";
                }
                System.out.println("HACIENDO CONVERSACION fin"  );
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
