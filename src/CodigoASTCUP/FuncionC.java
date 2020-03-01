/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoASTCUP;

import Codigo.Entorno;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Bayyron
 */
public class FuncionC extends NodoAbstracto{
    public FuncionC (String Nombre) {
        super(Nombre);
    }
    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        String Identificador = this.Hijos.get(0).Nombre;
        //System.out.println(this.Expresiones.size());
        ArrayList <NodoAbstracto> ExpresionesRomeo = new ArrayList();
        this.EsVector = 1;
        int valor1 = 0 ,valor2= 0 ,valor3= 0 ,valor4= 0 ,valor5 = 0,valor6 = 0;
        String CadenaBorrador = "";
        // valores
        for(int i= 0; i < this.Expresiones.size();i++){
            String val1 = this.Expresiones.get(i).Ejecutar(entorno, salida); // this.Hijos.get(0).Ejecutar(entorno, salida);
            String Tipo1 =  this.Expresiones.get(i).TipoDato;// .Ejecutar(entorno, salida);
            if("".equals(val1)){
                 CadenaBorrador = CadenaBorrador + this.Expresiones.get(i).Nombre;
            }
            CadenaBorrador = CadenaBorrador + val1 + ",";
           // System.out.println("For" + i + "->" + this.Expresiones.get(i).Nombre + "->" + this.Expresiones.get(i).TipoDato); 
            switch (Tipo1){
                case "Lista":
                    ExpresionesRomeo.add(this.Expresiones.get(i));
                    valor1 = 1;
                    break;
                case "cadena":
                    ExpresionesRomeo.add(this.Expresiones.get(i));
                    valor2 = 1;
                    break;
                case "entero":
                    ExpresionesRomeo.add(this.Expresiones.get(i));
                    valor3 = 1;
                    break;
                case "decimal":
                    ExpresionesRomeo.add(this.Expresiones.get(i));
                    valor4 = 1;
                    break;
                case "booleano":
                    ExpresionesRomeo.add(this.Expresiones.get(i));
                    valor5 = 1;
                    break;
                case "id":
                    if(entorno.ObtenerListaN(this.Expresiones.get(i).Nombre)==1){
                        String TipoVector = entorno.ObtenerTipo(this.Expresiones.get(i).Nombre);
                            switch (TipoVector){
                            case "Lista":
                                valor1 = 1;
                                break;
                            case "cadena":
                                valor2 = 1;
                                break;
                            case "entero":
                                valor3 = 1;
                                break;
                            case "decimal":
                                valor4 = 1;
                                break;
                            case "booleano":
                                valor5 = 1;
                                break;
                        }
                        ArrayList <NodoAbstracto> ExpresionesRomeo2 = new ArrayList();
                        ExpresionesRomeo2 = entorno.ObtenerLista(this.Expresiones.get(i).Nombre);
                        for(int ix = 0; ix<ExpresionesRomeo2.size() ; ix++){
                            ExpresionesRomeo.add(ExpresionesRomeo2.get(ix));
                        }
                            
                    }else{
                        String TipoVector = entorno.ObtenerTipo(this.Expresiones.get(i).Nombre);
                            switch (TipoVector){
                            case "Lista":
                                valor1 = 1;
                                break;
                            case "cadena":
                                valor2 = 1;
                                break;
                            case "entero":
                                valor3 = 1;
                                break;
                            case "decimal":
                                valor4 = 1;
                                break;
                            case "booleano":
                                valor5 = 1;
                                break;
                        }
                        
                        ExpresionesRomeo.add(this.Expresiones.get(i));
                    }
                    valor6 = 1;
                    break;
                           
            }
        }
        //System.out.println("Se esta declarando el vector:" + Identificador);// + " Tipo->" + Tipo1 + " Valor->" + val1);
        System.out.println("finalizo for------");
        String Tipo1 = "";
        if(valor1 == 1){
            Tipo1 = "Lista";
        }else if(valor2 == 1){
            Tipo1 = "cadena";
        }
        else if(valor3 == 1){
            Tipo1 = "entero";
        }
        else if(valor4 == 1){
            Tipo1 = "decimal";
        }
        else if(valor5 == 1){
            Tipo1 = "booleano";
        }
        System.out.println("Se esta declarando el vector:" + Identificador + " Tipo->" + Tipo1);
        
        boolean ExisteVector =  entorno.ExisteVector(Identificador); 
      
        if(!ExisteVector == true){
            entorno.Agregar2(Identificador, ExpresionesRomeo, Tipo1,CadenaBorrador);
            System.out.println("total elementos en el vector:" + ExpresionesRomeo.size());
        }else{
            entorno.ModificarValorLista(Identificador, ExpresionesRomeo, Tipo1,CadenaBorrador);
              System.out.println("total elementos en el vector:" + ExpresionesRomeo.size());
        }
        
        entorno.MostrarVectores();
        //entorno.MostrarVectoresLista();
        entorno.MostrarVectoresLista(entorno,salida);
        System.out.println("---------");
        return "RegistroCasteo";
    }
    
}
