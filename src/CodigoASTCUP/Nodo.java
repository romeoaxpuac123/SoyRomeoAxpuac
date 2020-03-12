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
import java.util.Arrays;
import java.util.Collections;
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
             case "Mean":
                  Entorno TemporalMean = new Entorno();
                    entorno.AgregarElementosANuevoEntorno(entorno,TemporalMean);
                    String TipoMean = this.Hijos.get(0).TipoDato;
                    String TipoMean2 = TemporalMean.ObtenerTipo(this.Hijos.get(0).Nombre);
                    System.out.println("NOMBRE MEAN->" + TipoMean + "<-TIPO DEL VECOTR->" + TipoMean2);
                    if(TipoMean.contains("id")){
                        if(TipoMean2.contains("entero") || TipoMean2.contains("decimal")){
                            System.out.println("VAMOS A VERIFICAR SI ES UNO O VARIOS");
                            if(this.Hijos.get(1)== null){
                                //trabajamos la media sin limites;
                                int EsLista = TemporalMean.ObtenerListaN(this.Hijos.get(0).Nombre);
                                if(EsLista == 1 ){
                                    //obtenemos la lista
                                    ArrayList <NodoAbstracto> DatosASumar = new ArrayList();
                                    DatosASumar = TemporalMean.ObtenerLista(this.Hijos.get(0).Nombre);
                                    double result = 0;
                                    for (int i = 0; i < DatosASumar.size(); i ++){
                                        result = result + Double.parseDouble(DatosASumar.get(i).Ejecutar(TemporalMean, salida));
                                    }
                                    result = result / DatosASumar.size();
                                    sali = String.valueOf(result);
                                }else{
                                    String ResultadoMedia = TemporalMean.ObtenerValor(this.Hijos.get(0).Nombre);
                                    double result = Double.parseDouble(ResultadoMedia);
                                    sali = String.valueOf(result);
                                }
                            }else{
                                //trabajamos la media con una limites
                                System.out.println("ESAMOS ENTRNADO AL LIMITE");
                                int EsLista = TemporalMean.ObtenerListaN(this.Hijos.get(0).Nombre);
                                String ValorNodo2 = this.Hijos.get(1).Ejecutar(TemporalMean, salida);
                                String TipoNodo2 = this.Hijos.get(1).TipoDato;
                                if(TipoNodo2.contains("id")){
                                     System.out.println("VAMOS A VER EL TIPOsss->" + TipoNodo2);
                                    String TipoVector = TemporalMean.ObtenerTipo(this.Hijos.get(1).Nombre);
                                    int LargoVector = TemporalMean.ObtenerListaN(this.Hijos.get(1).Nombre);
                                    if((TipoVector.contains("entero")|| TipoVector.contains("decimal"))
                                            && LargoVector == 1){
                                        ValorNodo2 = TemporalMean.ObtenerValor(this.Hijos.get(1).Nombre);
                                    }else{
                                        salida.append("#ERROR: la función mean usa un parametro incorrecto" + "\n");
                                        TError ERRORES = new TError("mean",this.linea,this.columna,"Semantico", "#ERROR: la función mean usa un parametro incorrecto" );
                                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                                        return "#Error";
                                    }
                                }else {
                                    System.out.println("VAMOS A VER EL TIPOzzz->" + TipoNodo2);
                                    ValorNodo2 = this.Hijos.get(1).Ejecutar(TemporalMean, salida);
                                }
                                System.out.println("VAMOS A VER EL TIPOpp->" + TipoNodo2);
                                if (TipoNodo2.contains("entero")|| TipoNodo2.contains("decimal")){
                                    ValorNodo2 = this.Hijos.get(1).Ejecutar(TemporalMean, salida);
                                }
                                else{
                                        salida.append("#ERROR: la función mean usa un parametro incorrecto" + "\n");
                                        TError ERRORES = new TError("mean",this.linea,this.columna,"Semantico", "#ERROR: la función mean usa un parametro incorrecto" );
                                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                                        return "#Error";
                                }
                                System.out.println("tipo nodo2->" + TipoNodo2);
                                double limite = Double.parseDouble(ValorNodo2);
                                System.out.println("EL LIMITE ES--------->" + limite);
                                if(EsLista == 1 ){
                                    //obtenemos la lista
                                    ArrayList <NodoAbstracto> DatosASumar = new ArrayList();
                                    DatosASumar = TemporalMean.ObtenerLista(this.Hijos.get(0).Nombre);
                                    double result = 0;
                                    int totalfors = 0;
                                    for (int i = 0; i < DatosASumar.size(); i ++){
                                        if(Double.parseDouble(DatosASumar.get(i).Ejecutar(TemporalMean, salida))>limite){
                                             result = result + Double.parseDouble(DatosASumar.get(i).Ejecutar(TemporalMean, salida));
                                             totalfors ++;
                                        }
                                       
                                    }
                                     if(result == 0){
                                        salida.append("#ERROR: la función mean usa un parametro incorrecto, el limite es mayor que todos los elementos" + "\n");
                                        TError ERRORES = new TError("mean",this.linea,this.columna,"Semantico", "#ERROR: la función mean usa un parametro incorrecto, el limite es mayor que todos los elementos" );
                                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                                        return "#Error";
                                    }
                                    result = result / totalfors ;
                                   
                                    sali = String.valueOf(result);
                                }else{
                                    String ResultadoMedia = TemporalMean.ObtenerValor(this.Hijos.get(0).Nombre);
                                    double result = Double.parseDouble(ResultadoMedia);
                                    if(result > limite){
                                        sali = String.valueOf(result);
                                    }else{
                                        sali = "0.0";
                                    }
                                    
                                }
                            }
                        }else{
                            salida.append("#ERROR: la función mean usa un parametro incorrecto" + "\n");
                            TError ERRORES = new TError("mean",this.linea,this.columna,"Semantico", "#ERROR: la función mean usa un parametro incorrecto" );
                            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                            return "#Error";
                        }
                    }else{
                        salida.append("#ERROR: la función mean usa un parametro incorrecto" + "\n");
                        TError ERRORES = new TError("mean",this.linea,this.columna,"Semantico", "#ERROR: la función mean usa un parametro incorrecto" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#Error";
                    }
                 break;
             case "Median":
                    Entorno TemporalMedian = new Entorno();
                    entorno.AgregarElementosANuevoEntorno(entorno,TemporalMedian);
                    String TipoMedian = this.Hijos.get(0).TipoDato;
                    String TipoMedian2 = TemporalMedian.ObtenerTipo(this.Hijos.get(0).Nombre);
                    System.out.println("NOMBRE MEDIAN->" + TipoMedian + "<-TIPO DEL VECOTR->" + TipoMedian2);
                    if(TipoMedian.contains("id")){
                        if(TipoMedian2.contains("entero") || TipoMedian2.contains("decimal")){
                            System.out.println("VAMOS A VERIFICAR SI ES UNO O VARIOS");
                            if(this.Hijos.get(1)== null){
                                
                                //trabajamos la media sin limites;
                                int EsLista = TemporalMedian.ObtenerListaN(this.Hijos.get(0).Nombre);
                                if(EsLista == 1 ){
                                    //obtenemos la lista
                                    ArrayList <NodoAbstracto> DatosASumar = new ArrayList();
                                    DatosASumar = TemporalMedian.ObtenerLista(this.Hijos.get(0).Nombre);
                                    double result = 0;
                                    int numElementos = DatosASumar.size();
                                    double arrayListInt [] = new double[numElementos];
                                    for(int ix = 0; ix < DatosASumar.size();ix++){
                                        arrayListInt[ix]  = Double.parseDouble(DatosASumar.get(ix).Ejecutar(TemporalMedian, salida));
                                    }
                                    for(int sk = 0; sk < arrayListInt.length; sk++){
                                        System.out.println("CALCULANDO LA MEDIANA DE ->" + arrayListInt[sk]);
                                    }                        
                                    Arrays.sort(arrayListInt);
                                    double mediana;
                                   
                                    if(numElementos % 2 == 0){
                                       double sumaMedios = arrayListInt[numElementos/2] + arrayListInt[numElementos/2 - 1]; 
                                        mediana = (double)sumaMedios / 2; 
                                    } else {
                                        mediana = arrayListInt[numElementos/2];
                                    }
                                    
                                    sali = String.valueOf(mediana);
                                }else{
                                    String ResultadoMedia = TemporalMedian.ObtenerValor(this.Hijos.get(0).Nombre);
                                    double result = Double.parseDouble(ResultadoMedia);
                                    sali = String.valueOf(result);
                                    System.out.println("FIN MEDIANA SIN LIMITE" + sali);
                                }
                            }else{
                                //trabajamos la media con una limites
                                System.out.println("ESAMOS ENTRNADO AL LIMITE");
                                int EsLista = TemporalMedian.ObtenerListaN(this.Hijos.get(0).Nombre);
                                String ValorNodo2 = this.Hijos.get(1).Ejecutar(TemporalMedian, salida);
                                String TipoNodo2 = this.Hijos.get(1).TipoDato;
                                if(TipoNodo2.contains("id")){
                                     System.out.println("VAMOS A VER EL TIPOsss->" + TipoNodo2);
                                    String TipoVector = TemporalMedian.ObtenerTipo(this.Hijos.get(1).Nombre);
                                    int LargoVector = TemporalMedian.ObtenerListaN(this.Hijos.get(1).Nombre);
                                    if((TipoVector.contains("entero")|| TipoVector.contains("decimal"))
                                            && LargoVector == 1){
                                        ValorNodo2 = TemporalMedian.ObtenerValor(this.Hijos.get(1).Nombre);
                                    }else{
                                        salida.append("#ERROR: la función mean usa un parametro incorrecto" + "\n");
                                        TError ERRORES = new TError("mean",this.linea,this.columna,"Semantico", "#ERROR: la función mean usa un parametro incorrecto" );
                                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                                        return "#Error";
                                    }
                                }else {
                                    System.out.println("VAMOS A VER EL TIPOzzz->" + TipoNodo2);
                                    ValorNodo2 = this.Hijos.get(1).Ejecutar(TemporalMedian, salida);
                                }
                                System.out.println("VAMOS A VER EL TIPOpp->" + TipoNodo2);
                                if (TipoNodo2.contains("entero")|| TipoNodo2.contains("decimal")){
                                    ValorNodo2 = this.Hijos.get(1).Ejecutar(TemporalMedian, salida);
                                }
                                else{
                                        salida.append("#ERROR: la función mean usa un parametro incorrecto" + "\n");
                                        TError ERRORES = new TError("mean",this.linea,this.columna,"Semantico", "#ERROR: la función mean usa un parametro incorrecto" );
                                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                                        return "#Error";
                                }
                                System.out.println("tipo nodo2->" + TipoNodo2);
                                double limite = Double.parseDouble(ValorNodo2);
                                System.out.println("EL LIMITE ES--------->" + limite);
                                //trabajamos la media sin limites;
                                EsLista = TemporalMedian.ObtenerListaN(this.Hijos.get(0).Nombre);
                                if(EsLista == 1 ){
                                    //obtenemos la lista
                                    ArrayList <NodoAbstracto> DatosASumar = new ArrayList();
                                    DatosASumar = TemporalMedian.ObtenerLista(this.Hijos.get(0).Nombre);
                                    double result = 0;
                                    int numElementos = DatosASumar.size();
                                    //double arrayListInt [] = new double[numElementos];
                                    
                                    int tamaniox = 0;
                                    for(int ix = 0; ix < DatosASumar.size();ix++){
                                        if(Double.parseDouble(DatosASumar.get(ix).Ejecutar(TemporalMedian, salida)) >limite){
                                            //arrayListInt[ix]  = Double.parseDouble(DatosASumar.get(ix).Ejecutar(TemporalMedian, salida));
                                            tamaniox++;
                                        }
                                        
                                    }
                                    System.out.println("pasan el valor ES--------->" + tamaniox);
                                    double arrayListInt [] = new double[tamaniox];
                                    int tamanioxx = 0;
                                    for(int ix = 0; ix < DatosASumar.size();ix++){
                                        if(Double.parseDouble(DatosASumar.get(ix).Ejecutar(TemporalMedian, salida)) > limite){
                                            arrayListInt[tamanioxx]  = Double.parseDouble(DatosASumar.get(ix).Ejecutar(TemporalMedian, salida));
                                            tamanioxx++;
                                        }
                                        
                                    }
                                    System.out.println("pasan el del vector ES--------->" + arrayListInt.length);
                                    
                                      if(arrayListInt.length == 0){
                                        salida.append("#ERROR: la función median usa un parametro incorrecto, el limite es mayor que todos los elementos" + "\n");
                                        TError ERRORES = new TError("mean",this.linea,this.columna,"Semantico", "#ERROR: la función median usa un parametro incorrecto, el limite es mayor que todos los elementos" );
                                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                                        return "#Error";
                                    }
                                    
                                    Arrays.sort(arrayListInt);
                                    for(int sk = 0; sk < arrayListInt.length; sk++){
                                        System.out.println("CALCULANDO LA MEDIANA DE ->" + arrayListInt[sk]);
                                    }   
                                    double mediana;
                                   
                                    if(tamanioxx % 2 == 0){
                                        System.out.println("afrutunados" + arrayListInt[tamanioxx/2] + "<->" + arrayListInt[tamanioxx/2 - 1]);
                                       double sumaMedios = arrayListInt[tamanioxx/2] + arrayListInt[tamanioxx/2 - 1]; 
                                        mediana = (double)sumaMedios / 2; 
                                    } else {
                                            System.out.println("no aformtuans");
                                        mediana = arrayListInt[tamanioxx/2];
                                    }
                                    
                                    sali = String.valueOf(mediana);
                                }else{
                                    String ResultadoMedia = TemporalMedian.ObtenerValor(this.Hijos.get(0).Nombre);
                                    double result = Double.parseDouble(ResultadoMedia);
                                    if(result>limite){
                                        sali = String.valueOf(result);
                                    }else{
                                        sali = "0.0";
                                    }
                                    
                                    System.out.println("FIN MEDIANA SIN LIMITE" + sali);
                                }
                            }
                        }else{
                            salida.append("#ERROR: la función mean usa un parametro incorrecto" + "\n");
                            TError ERRORES = new TError("mean",this.linea,this.columna,"Semantico", "#ERROR: la función mean usa un parametro incorrecto" );
                            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                            return "#Error";
                        }
                    }else{
                        salida.append("#ERROR: la función mean usa un parametro incorrecto" + "\n");
                        TError ERRORES = new TError("mean",this.linea,this.columna,"Semantico", "#ERROR: la función mean usa un parametro incorrecto" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#Error";
                    }
                 break;
             case "Mode":
                    Entorno TemporalMode = new Entorno();
                    entorno.AgregarElementosANuevoEntorno(entorno,TemporalMode);
                    String TipoMode = this.Hijos.get(0).TipoDato;
                    String TipoMode2 = TemporalMode.ObtenerTipo(this.Hijos.get(0).Nombre);
                    System.out.println("NOMBRE MEDIAN->" + TipoMode + "<-TIPO DEL VECOTR->" + TipoMode2);
                    if(TipoMode.contains("id")){
                        if(TipoMode2.contains("entero") || TipoMode2.contains("decimal")){
                            System.out.println("VAMOS A VERIFICAR SI ES UNO O VARIOS");
                            if(this.Hijos.get(1)== null){
                                
                                //trabajamos la media sin limites;
                                int EsLista = TemporalMode.ObtenerListaN(this.Hijos.get(0).Nombre);
                                if(EsLista == 1 ){
                                    //obtenemos la lista
                                    ArrayList <NodoAbstracto> DatosASumar = new ArrayList();
                                    DatosASumar = TemporalMode.ObtenerLista(this.Hijos.get(0).Nombre);
                                    double result = 0;
                                    int numElementos = DatosASumar.size();
                                    double arrayListInt [] = new double[numElementos];
                                    for(int ix = 0; ix < DatosASumar.size();ix++){
                                        arrayListInt[ix]  = Double.parseDouble(DatosASumar.get(ix).Ejecutar(TemporalMode, salida));
                                    }
                                   double moda = 0;
                                   double maximoNumRepeticiones = 0;
                                    for(int i=0; i< arrayListInt.length; i++)
    {
                                        int numRepeticiones= 0;
                                        for(int j=0; j< arrayListInt.length; j++)
                                        {
                                            if( arrayListInt[i]== arrayListInt[j])
                                            {
                                                numRepeticiones++;
                                            }   //fin if
                                            if(numRepeticiones>maximoNumRepeticiones)
                                            {
                                                moda =  arrayListInt[i];
                                                maximoNumRepeticiones= numRepeticiones;
                                            }   //fin if
                                        }
    }
                                    
                                    sali = String.valueOf(moda);
                                }else{
                                    String ResultadoMedia = TemporalMode.ObtenerValor(this.Hijos.get(0).Nombre);
                                    double result = Double.parseDouble(ResultadoMedia);
                                    sali = String.valueOf(result);
                                    System.out.println("FIN MEDIANA SIN LIMITE" + sali);
                                }
                            }else{
                                //trabajamos la media con una limites
                                System.out.println("ESAMOS ENTRNADO AL LIMITE");
                                int EsLista = TemporalMode.ObtenerListaN(this.Hijos.get(0).Nombre);
                                String ValorNodo2 = this.Hijos.get(1).Ejecutar(TemporalMode, salida);
                                String TipoNodo2 = this.Hijos.get(1).TipoDato;
                                if(TipoNodo2.contains("id")){
                                     System.out.println("VAMOS A VER EL TIPOsss->" + TipoNodo2);
                                    String TipoVector = TemporalMode.ObtenerTipo(this.Hijos.get(1).Nombre);
                                    int LargoVector = TemporalMode.ObtenerListaN(this.Hijos.get(1).Nombre);
                                    if((TipoVector.contains("entero")|| TipoVector.contains("decimal"))
                                            && LargoVector == 1){
                                        ValorNodo2 = TemporalMode.ObtenerValor(this.Hijos.get(1).Nombre);
                                    }else{
                                        salida.append("#ERROR: la función mode usa un parametro incorrecto" + "\n");
                                        TError ERRORES = new TError("mean",this.linea,this.columna,"Semantico", "#ERROR: la función mode usa un parametro incorrecto" );
                                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                                        return "#Error";
                                    }
                                }else {
                                    System.out.println("VAMOS A VER EL TIPOzzz->" + TipoNodo2);
                                    ValorNodo2 = this.Hijos.get(1).Ejecutar(TemporalMode, salida);
                                }
                                System.out.println("VAMOS A VER EL TIPOpp->" + TipoNodo2);
                                if (TipoNodo2.contains("entero")|| TipoNodo2.contains("decimal")){
                                    ValorNodo2 = this.Hijos.get(1).Ejecutar(TemporalMode, salida);
                                }
                                else{
                                        salida.append("#ERROR: la función mode usa un parametro incorrecto" + "\n");
                                        TError ERRORES = new TError("mode",this.linea,this.columna,"Semantico", "#ERROR: la función mode usa un parametro incorrecto" );
                                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                                        return "#Error";
                                }
                                System.out.println("tipo nodo2->" + TipoNodo2);
                                double limite = Double.parseDouble(ValorNodo2);
                                System.out.println("EL LIMITE ES--------->" + limite);
                                //trabajamos la media sin limites;
                                EsLista = TemporalMode.ObtenerListaN(this.Hijos.get(0).Nombre);
                                if(EsLista == 1 ){
                                    //obtenemos la lista
                                    ArrayList <NodoAbstracto> DatosASumar = new ArrayList();
                                    DatosASumar = TemporalMode.ObtenerLista(this.Hijos.get(0).Nombre);
                                    double result = 0;
                                    int numElementos = DatosASumar.size();
                                    //double arrayListInt [] = new double[numElementos];
                                    
                                    int tamaniox = 0;
                                    for(int ix = 0; ix < DatosASumar.size();ix++){
                                        if(Double.parseDouble(DatosASumar.get(ix).Ejecutar(TemporalMode, salida)) >limite){
                                            //arrayListInt[ix]  = Double.parseDouble(DatosASumar.get(ix).Ejecutar(TemporalMedian, salida));
                                            tamaniox++;
                                        }
                                        
                                    }
                                    System.out.println("pasan el valor ES--------->" + tamaniox);
                                    double arrayListInt [] = new double[tamaniox];
                                    int tamanioxx = 0;
                                    for(int ix = 0; ix < DatosASumar.size();ix++){
                                        if(Double.parseDouble(DatosASumar.get(ix).Ejecutar(TemporalMode, salida)) > limite){
                                            arrayListInt[tamanioxx]  = Double.parseDouble(DatosASumar.get(ix).Ejecutar(TemporalMode, salida));
                                            tamanioxx++;
                                        }
                                        
                                    }
                                    System.out.println("pasan el del vector ES--------->" + arrayListInt.length);
                                    
                                      if(arrayListInt.length == 0){
                                        salida.append("#ERROR: la función mode usa un parametro incorrecto, el limite es mayor que todos los elementos" + "\n");
                                        TError ERRORES = new TError("mean",this.linea,this.columna,"Semantico", "#ERROR: la función mode usa un parametro incorrecto, el limite es mayor que todos los elementos" );
                                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                                        return "#Error";
                                    }
                                    
                                    //Arrays.sort(arrayListInt);
                                    for(int sk = 0; sk < arrayListInt.length; sk++){
                                        System.out.println("CALCULANDO LA moda de DE ->" + arrayListInt[sk]);
                                    }   
                                    double moda = 0;
                                    double maximoNumRepeticiones = 0;
                                  for(int i=0; i<arrayListInt.length; i++)
    {
                                        int numRepeticiones= 0;
                                        for(int j=0; j<arrayListInt.length; j++)
                                        {
                                            if(arrayListInt[i]==arrayListInt[j])
                                            {
                                                numRepeticiones++;
                                            }   //fin if
                                            if(numRepeticiones>maximoNumRepeticiones)
                                            {
                                                moda= arrayListInt[i];
                                                maximoNumRepeticiones= numRepeticiones;
                                            }   //fin if
                                        }
    }
                                    
                                    sali = String.valueOf(moda);
                                }else{
                                    String ResultadoMedia = TemporalMode.ObtenerValor(this.Hijos.get(0).Nombre);
                                    double result = Double.parseDouble(ResultadoMedia);
                                    if(result>limite){
                                        sali = String.valueOf(result);
                                    }else{
                                        sali = "0.0";
                                    }
                                    
                                    System.out.println("FIN MEDIANA SIN LIMITE" + sali);
                                }
                            }
                        }else{
                            salida.append("#ERROR: la función mode usa un parametro incorrecto" + "\n");
                            TError ERRORES = new TError("mean",this.linea,this.columna,"Semantico", "#ERROR: la función mode usa un parametro incorrecto" );
                            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                            return "#Error";
                        }
                    }else{
                        salida.append("#ERROR: la función mode usa un parametro incorrecto" + "\n");
                        TError ERRORES = new TError("mean",this.linea,this.columna,"Semantico", "#ERROR: la función mode usa un parametro incorrecto" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                        return "#Error";
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
                sali =this.Nombre;
        }
        return sali;
    }
    
    
}
