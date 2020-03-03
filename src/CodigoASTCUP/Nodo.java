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
      // System.out.println("nombre...........>" + this.Nombre);
        switch(this.Nombre){
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
                sali = entorno.ObtenerValor(this.Nombre);
        }
        return sali;
    }
    
    
}
