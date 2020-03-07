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
public class Aritmetica extends NodoAbstracto{

    public Aritmetica(String Nombre) {
        super(Nombre);
    }
    
    

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        int total = 0;
        double totald = 0;
        String totalc = "";
        String val1 = this.Hijos.get(0).Ejecutar(entorno, salida);
        String val2 = this.Hijos.get(2).Ejecutar(entorno, salida);
        
        String Tipo1 = this.Hijos.get(0).TipoDato;
        String Tipo2 = this.Hijos.get(2).TipoDato;
        System.out.println("hijos->" + this.Hijos.get(0).Hijos.size());
        if("FuncionC".equals(Tipo1)){
            System.out.println("dragon ball" + this.Hijos.get(0).Nombre);
            int valor1 = 0 ,valor2= 0 ,valor3= 0 ,valor4= 0 ,valor5 = 0,valor6 = 0;
             for(int i = 0; i < this.Hijos.get(0).Expresiones2.size();i++){
                 
                 String Resultado = this.Hijos.get(0).Expresiones2.get(i).Ejecutar(entorno, salida);
                 String TipoDatox = this.Hijos.get(0).Expresiones2.get(i).TipoDato;
                 System.out.println("Valor->"+ Resultado + "<->Tipo->" + TipoDatox);
               if("id".equals(this.Hijos.get(0).Expresiones2.get(i).TipoDato)){
                  Resultado = entorno.ObtenerValor(this.Hijos.get(0).Expresiones2.get(i).Nombre);
                  TipoDatox = entorno.ObtenerTipo(this.Hijos.get(0).Expresiones2.get(i).Nombre);
              }
              
              if(!Resultado.equals("#Error")){
                   System.out.println("aheuvo---->" + Resultado);
                   //VAMOS A BUSCAR LA PRIORIDAD
                   
                   switch (TipoDatox){
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

                 }
                    String Tipo1y = "";
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
            System.out.println("EL TIPO DEL VECTOR SERA:" + Tipo1y );
            entorno.Agregar2("VectorC1DeRomeo", this.Hijos.get(0).Expresiones2,  Tipo1y, "se me olvido");
            Tipo1 = "id";
            this.Hijos.get(0).Nombre = "VectorC1DeRomeo";
            System.out.println("Dragon BAll" + this.Hijos.get(0).Expresiones2.size());    
        }
        
        if("FuncionC".equals(Tipo2)){
            System.out.println("dragon ball" + this.Hijos.get(2).Nombre);
            int valor1 = 0 ,valor2= 0 ,valor3= 0 ,valor4= 0 ,valor5 = 0,valor6 = 0;
             for(int i = 0; i < this.Hijos.get(2).Expresiones2.size();i++){
                 
                 String Resultado = this.Hijos.get(2).Expresiones2.get(i).Ejecutar(entorno, salida);
                 String TipoDatox = this.Hijos.get(2).Expresiones2.get(i).TipoDato;
                 System.out.println("Valor->"+ Resultado + "<->Tipo->" + TipoDatox);
               if("id".equals(this.Hijos.get(2).Expresiones2.get(i).TipoDato)){
                  Resultado = entorno.ObtenerValor(this.Hijos.get(2).Expresiones2.get(i).Nombre);
                  TipoDatox = entorno.ObtenerTipo(this.Hijos.get(2).Expresiones2.get(i).Nombre);
              }
              
              if(!Resultado.equals("#Error")){
                   System.out.println("aheuvo---->" + Resultado);
                   //VAMOS A BUSCAR LA PRIORIDAD
                   
                   switch (TipoDatox){
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

                 }
                    String Tipo1y = "";
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
            System.out.println("EL TIPO DEL VECTOR SERA:" + Tipo1y );
            entorno.Agregar2("VectorC2DeRomeo", this.Hijos.get(2).Expresiones2,  Tipo1y, "se me olvido");
            Tipo2 = "id";
            this.Hijos.get(2).Nombre = "VectorC2DeRomeo";
            System.out.println("Dragon BAll" + this.Hijos.get(2).Expresiones2.size());    
        }
        
        
        
        System.out.println("TIPOS:" + Tipo1 + "-" + Tipo2);
        if("id".equals(Tipo1) && !"id".equals(Tipo2)){
            String Vector = this.Hijos.get(0).Nombre;
            //System.out.println("VectorAritmetica:" + Vector);
            boolean ExisteVector =  entorno.ExisteVector(Vector); 
            if(ExisteVector == true){
                //aca la suma del vector 
                if(entorno.ObtenerListaN(Vector) ==0){
                    String TipoVector = entorno.ObtenerTipo(Vector);
                    String ValorVector = entorno.ObtenerValor(Vector);
                    System.out.println("VectorAritmetica:" + Vector + "Tipo->" + TipoVector + "Valor->" + ValorVector);
                    Tipo1 = TipoVector;
                    val1 = ValorVector;
                }else{                                
                    ArrayList <NodoAbstracto> ExpresionesRomeo = new ArrayList();
                    ArrayList <NodoAbstracto> ExpresionesLola = new ArrayList();
                    boolean ExisteVectorx =   entorno.ExisteVector("VectorDragonBallBeatles"); 
                    if(!ExisteVectorx == true){
                         entorno.Agregar2("VectorDragonBallBeatles", entorno.ObtenerLista(Vector), entorno.ObtenerTipo(Vector), "ss");
                    }else{
                        entorno.ModificarValorLista("VectorDragonBallBeatles", entorno.ObtenerLista(Vector), entorno.ObtenerTipo(Vector), "ss");
                    }
                    ExpresionesRomeo = entorno.ObtenerLista("VectorDragonBallBeatles");
                    //veamos el verdadero tipo del vector XD
                    int valor1 = 0 ,valor2= 0 ,valor3= 0 ,valor4= 0 ,valor5 = 0,valor6 = 0;
                    for(int i= 0; i < ExpresionesRomeo.size();i++){
                    String Tipo1x =  ExpresionesRomeo.get(i).TipoDato;
                        switch (Tipo1x){
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
                        }
                    }
                    String Tipo1y = "";
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
                    for(int i = 0 ; i < ExpresionesRomeo.size();i++){
                        String ValorVectori = ExpresionesRomeo.get(i).Ejecutar(entorno, salida);
                        String TipoVector1 = entorno.ObtenerTipo("VectorDragonBallBeatles");
                        String TipoNodo = ExpresionesRomeo.get(i).TipoDato;
                        //System.out.println("Vector"+i+":" + Vector + " Valor->"+ ValorVectori + " Operacion" + this.Hijos.get(1).Nombre  + " TipoVector-> " + TipoVector1 + "TipoDato->" + TipoNodo );
                        if("cadena".equals(Tipo1y)){
                          
                            //System.out.println("Aca Operamos Cadenas" + ValorVectori + "Dato2->" + val2);
                            NodoAbstracto nuevo = new Nodo("Cadena");
                            String Resultadox = Resultado(ValorVectori,Tipo1y,val2,Tipo2,nuevo);
                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                            nuevo.Hijos.add(nuevovalor);
                           // nuevo.TipoDato = "cadena";
                            ExpresionesLola.add(nuevo);
                                                             
                        }else if("entero".equals(Tipo1y)){
                          
                           // System.out.println("Aca Operamos Cadenas" + ValorVectori + "Dato2->" + val2);
                            NodoAbstracto nuevo = new Nodo("Entero");
                            String Resultadox = Resultado(ValorVectori,Tipo1y,val2,Tipo2,nuevo);
                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                            nuevo.Hijos.add(nuevovalor);
                           // nuevo.TipoDato = "cadena";
                            ExpresionesLola.add(nuevo);
                        } else if("decimal".equals(Tipo1y)){
                            //System.out.println("Aca Operamos Cadenas->" + ValorVectori + "Tipo->" + Tipo1y + "Dato2->" + val2);
                            NodoAbstracto nuevo = new Nodo("Decimal");
                            String Resultadox = Resultado(ValorVectori,Tipo1y,val2,Tipo2,nuevo);
                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                            nuevo.Hijos.add(nuevovalor);
                           // nuevo.TipoDato = "cadena";
                            ExpresionesLola.add(nuevo);
                        }else if ("booleano".equals(Tipo1y)){
                            System.out.println("Aca Operamos Cadenas->" + ValorVectori + "Tipo->" + Tipo1y + "Dato2->" + val2);
                             NodoAbstracto nuevo = new Nodo("Booleano");
                            String Resultadox = Resultado(ValorVectori,Tipo1y,val2,Tipo2,nuevo);
                            System.out.println("Resultado" + Resultadox);
                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                            nuevo.Hijos.add(nuevovalor);
                           // nuevo.TipoDato = "cadena";
                            ExpresionesLola.add(nuevo);
                        }
                        this.TipoDato = "id";
                        this.Nombre = "VectorDragonBallBeatles";
                        
                    }
                    entorno.ModificarValorLista("VectorDragonBallBeatles", ExpresionesLola,Tipo1y, "prit");
                    
                    return "RomeoAxpuac";
                }
            }else{
                salida.append("#ERROR: El vector "+ Vector + " No Existe "  +"\n");
                return "#ERROR: El vector "+ Vector + " No Existe " ;
            }
            
            
           // return "Go";
        }
        
        if("id".equals(Tipo2) && !"id".equals(Tipo1)){
            String Vector = this.Hijos.get(2).Nombre;
            //System.out.println("VectorAritmetica:" + Vector);
            boolean ExisteVector =  entorno.ExisteVector(Vector); 
            if(ExisteVector == true){
                //aca la suma del vector 
                if(entorno.ObtenerListaN(Vector) ==0){
                    String TipoVector = entorno.ObtenerTipo(Vector);
                    String ValorVector = entorno.ObtenerValor(Vector);
                    System.out.println("VectorAritmetica:" + Vector + "Tipo->" + TipoVector + "Valor->" + ValorVector);
                    Tipo2 = TipoVector;
                    val2 = ValorVector;
                }else{
                    System.out.println("Enramos EEEE");
                    ArrayList <NodoAbstracto> ExpresionesRomeo = new ArrayList();
                    ArrayList <NodoAbstracto> ExpresionesLola = new ArrayList();
                    boolean ExisteVectorx =   entorno.ExisteVector("VectorDragonBallBeatles"); 
                    if(!ExisteVectorx == true){
                         entorno.Agregar2("VectorDragonBallBeatles", entorno.ObtenerLista(Vector), entorno.ObtenerTipo(Vector), "ss");
                    }else{
                        entorno.ModificarValorLista("VectorDragonBallBeatles", entorno.ObtenerLista(Vector), entorno.ObtenerTipo(Vector), "ss");
                    }
                    ExpresionesRomeo = entorno.ObtenerLista("VectorDragonBallBeatles");
                    //veamos el verdadero tipo del vector XD
                    int valor1 = 0 ,valor2= 0 ,valor3= 0 ,valor4= 0 ,valor5 = 0,valor6 = 0;
                    for(int i= 0; i < ExpresionesRomeo.size();i++){
                    String Tipo1x =  ExpresionesRomeo.get(i).TipoDato;
                        switch (Tipo1x){
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
                        }
                    }
                    String Tipo1y = "";
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
                      for(int i = 0 ; i < ExpresionesRomeo.size();i++){
                        String ValorVectori = ExpresionesRomeo.get(i).Ejecutar(entorno, salida);
                        String TipoVector1 = entorno.ObtenerTipo("VectorDragonBallBeatles");
                        String TipoNodo = ExpresionesRomeo.get(i).TipoDato;
                        //System.out.println("Vector"+i+":" + Vector + " Valor->"+ ValorVectori + " Operacion" + this.Hijos.get(1).Nombre  + " TipoVector-> " + TipoVector1 + "TipoDato->" + TipoNodo );
                        if("cadena".equals(Tipo1y)){
                          
                            //System.out.println("Aca Operamos Cadenas" + ValorVectori + "Dato2->" + val2);
                            NodoAbstracto nuevo = new Nodo("Cadena");
                            String Resultadox = Resultado(ValorVectori,Tipo1y,val1,Tipo1,nuevo);
                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                            nuevo.Hijos.add(nuevovalor);
                           // nuevo.TipoDato = "cadena";
                            ExpresionesLola.add(nuevo);
                                                             
                        }else if("entero".equals(Tipo1y)){
                          
                           // System.out.println("Aca Operamos Cadenas" + ValorVectori + "Dato2->" + val2);
                            NodoAbstracto nuevo = new Nodo("Entero");
                            String Resultadox = Resultado(ValorVectori,Tipo1y,val1,Tipo1,nuevo);
                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                            nuevo.Hijos.add(nuevovalor);
                           // nuevo.TipoDato = "cadena";
                            ExpresionesLola.add(nuevo);
                        } else if("decimal".equals(Tipo1y)){
                            //System.out.println("Aca Operamos Cadenas->" + ValorVectori + "Tipo->" + Tipo1y + "Dato2->" + val2);
                            NodoAbstracto nuevo = new Nodo("Decimal");
                            String Resultadox = Resultado(ValorVectori,Tipo1y,val1,Tipo1,nuevo);
                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                            nuevo.Hijos.add(nuevovalor);
                           // nuevo.TipoDato = "cadena";
                            ExpresionesLola.add(nuevo);
                        }else if ("booleano".equals(Tipo1y)){
                            System.out.println("Aca Operamos Cadenas->" + ValorVectori + "Tipo->" + Tipo1y + "Dato2->" + val2);
                             NodoAbstracto nuevo = new Nodo("Booleano");
                            String Resultadox = Resultado(ValorVectori,Tipo1y,val1,Tipo1,nuevo);
                            System.out.println("Resultado" + Resultadox);
                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                            nuevo.Hijos.add(nuevovalor);
                           // nuevo.TipoDato = "cadena";
                            ExpresionesLola.add(nuevo);
                        }
                        this.TipoDato = "id";
                        this.Nombre = "VectorDragonBallBeatles";
                        
                    }
                    entorno.ModificarValorLista("VectorDragonBallBeatles", ExpresionesLola,Tipo1y, "prit");
               
                    return "RomeoAxpuac";
                    
                }
                
                
            }else{
                salida.append("#ERROR: El vector "+ Vector + " No Existe "  +"\n");
                return "#ERROR: El vector "+ Vector + " No Existe " ;
            }
            
            
           // return "Go";
        }
        if("id".equals(Tipo2) && "id".equals(Tipo1)){
            String Vector1 = this.Hijos.get(0).Nombre;
            String Vector2 = this.Hijos.get(2).Nombre;
            //System.out.println("VectorAritmetica:" + Vector1+"->"+ Vector2);
            boolean ExisteVector1 =  entorno.ExisteVector(Vector1); 
            boolean ExisteVector2 =  entorno.ExisteVector(Vector2); 
            if(ExisteVector1 == true && ExisteVector2 == true){
                //aca la suma del vector 
                if(entorno.ObtenerListaN(Vector1) ==0 && entorno.ObtenerListaN(Vector2) ==0){
                    String TipoVector = entorno.ObtenerTipo(Vector1);
                    String ValorVector = entorno.ObtenerValor(Vector1);
                    String TipoVector2 = entorno.ObtenerTipo(Vector2);
                    String ValorVecto2 = entorno.ObtenerValor(Vector2);
                    System.out.println("VectorAritmetica:" + Vector1 + "Tipo->" + TipoVector + "Valor->" + ValorVector);
                    Tipo1 = TipoVector;
                    val1 = ValorVector;
                    Tipo2 = TipoVector2;
                    val2 = ValorVecto2;
                }else{
                    //cuando alguno de los vectores tiene mas de un lado XD
                    String TipoVector = entorno.ObtenerTipo(Vector1);
                    String TipoVector2 = entorno.ObtenerTipo(Vector2);
                    System.out.println("VectorAritmetica:" + Vector1 + "Tipo->" + TipoVector + "Valor->" 
                                        + "---VectorAritmetica:" + Vector2 + "Tipo->" + TipoVector2 + "Valor->");
                  if(entorno.ObtenerListaN(Vector1) ==0 && entorno.ObtenerListaN(Vector2) !=0){
                      return "#Error";
                      /*
                      //Vector1 tiene solo un lado y vector 2 muchos lados
                    ArrayList <NodoAbstracto> ExpresionesRomeo = new ArrayList();
                    ArrayList <NodoAbstracto> ExpresionesLola = new ArrayList();
                    boolean ExisteVectorx =   entorno.ExisteVector("VectorDragonBallBeatles"); 
                    if(!ExisteVectorx == true){
                         entorno.Agregar2("VectorDragonBallBeatles", entorno.ObtenerLista(Vector2), entorno.ObtenerTipo(Vector2), "ss");
                    }else{
                        entorno.ModificarValorLista("VectorDragonBallBeatles", entorno.ObtenerLista(Vector2), entorno.ObtenerTipo(Vector2), "ss");
                    }
                    ExpresionesRomeo = entorno.ObtenerLista("VectorDragonBallBeatles");
                    //veamos el verdadero tipo del vector XD
                    int valor1 = 0 ,valor2= 0 ,valor3= 0 ,valor4= 0 ,valor5 = 0,valor6 = 0;
                    for(int i= 0; i < ExpresionesRomeo.size();i++){
                    String Tipo1x =  ExpresionesRomeo.get(i).TipoDato;
                        switch (Tipo1x){
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
                        case "id":
                            if(entorno.ObtenerListaN(this.Expresiones.get(i).Nombre)==1){
                                String TipoVectorx = entorno.ObtenerTipo(this.Expresiones.get(i).Nombre);
                                    switch (TipoVectorx){
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
                        }
                    }
                    String Tipo1y = "";
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
                   System.out.println("El vector tiene tipo: " + Tipo1y);
                   for(int i = 0 ; i < ExpresionesRomeo.size();i++){
                        String ValorVectori = ExpresionesRomeo.get(i).Ejecutar(entorno, salida);
                        String TipoVector1 = entorno.ObtenerTipo("VectorDragonBallBeatles");
                        String TipoNodo = ExpresionesRomeo.get(i).TipoDato;
                        Tipo1 = entorno.ObtenerTipo(Vector1);
                        val1 = entorno.ObtenerValor(Vector1);
                        //System.out.println("Vector"+i+":" + Vector + " Valor->"+ ValorVectori + " Operacion" + this.Hijos.get(1).Nombre  + " TipoVector-> " + TipoVector1 + "TipoDato->" + TipoNodo );
                        if("cadena".equals(Tipo1y)){
                            
                            //System.out.println("Aca Operamos Cadenas" + ValorVectori + "Dato2->" + val2);
                            NodoAbstracto nuevo = new Nodo("Cadena");
                            String Resultadox = Resultado(val1,Tipo1,ValorVectori,Tipo1y,nuevo);
                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                            nuevo.Hijos.add(nuevovalor);
                           // nuevo.TipoDato = "cadena";
                            ExpresionesLola.add(nuevo);
                                                             
                        }else if("entero".equals(Tipo1y)){
                          
                           // System.out.println("Aca Operamos Cadenas" + ValorVectori + "Dato2->" + val2);
                            NodoAbstracto nuevo = new Nodo("Entero");
                             String Resultadox = Resultado(val1,Tipo1,ValorVectori,Tipo1y,nuevo);
                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                            nuevo.Hijos.add(nuevovalor);
                           // nuevo.TipoDato = "cadena";
                            ExpresionesLola.add(nuevo);
                        } else if("decimal".equals(Tipo1y)){
                            //System.out.println("Aca Operamos Cadenas->" + ValorVectori + "Tipo->" + Tipo1y + "Dato2->" + val2);
                            NodoAbstracto nuevo = new Nodo("Decimal");
                             String Resultadox = Resultado(val1,Tipo1,ValorVectori,Tipo1y,nuevo);
                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                            nuevo.Hijos.add(nuevovalor);
                           // nuevo.TipoDato = "cadena";
                            ExpresionesLola.add(nuevo);
                        }else if ("booleano".equals(Tipo1y)){
                            System.out.println("Aca Operamos Cadenas->" + ValorVectori + "Tipo->" + Tipo1y + "Dato2->" + val2);
                             NodoAbstracto nuevo = new Nodo("Booleano");
                             String Resultadox = Resultado(val1,Tipo1,ValorVectori,Tipo1y,nuevo);
                            System.out.println("Resultado" + Resultadox);
                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                            nuevo.Hijos.add(nuevovalor);
                           // nuevo.TipoDato = "cadena";
                            ExpresionesLola.add(nuevo);
                        }
                        this.TipoDato = "id";
                        this.Nombre = "VectorDragonBallBeatles";
                        
                    }
                    entorno.ModificarValorLista("VectorDragonBallBeatles", ExpresionesLola,Tipo1y, "prit");
                    return "RomeoAxpuac";
                   */
                  }else if(entorno.ObtenerListaN(Vector1) !=0 && entorno.ObtenerListaN(Vector2) ==0){
                      //Vector1 tiene muchos lados y vector dos solo 1
                      return "#Error";
                      /*
                    ArrayList <NodoAbstracto> ExpresionesRomeo = new ArrayList();
                    ArrayList <NodoAbstracto> ExpresionesLola = new ArrayList();
                    boolean ExisteVectorx =   entorno.ExisteVector("VectorDragonBallBeatles"); 
                    if(!ExisteVectorx == true){
                         entorno.Agregar2("VectorDragonBallBeatles", entorno.ObtenerLista(Vector1), entorno.ObtenerTipo(Vector1), "ss");
                    }else{
                        entorno.ModificarValorLista("VectorDragonBallBeatles", entorno.ObtenerLista(Vector1), entorno.ObtenerTipo(Vector1), "ss");
                    }
                    ExpresionesRomeo = entorno.ObtenerLista("VectorDragonBallBeatles");
                    //veamos el verdadero tipo del vector XD
                    int valor1 = 0 ,valor2= 0 ,valor3= 0 ,valor4= 0 ,valor5 = 0,valor6 = 0;
                    for(int i= 0; i < ExpresionesRomeo.size();i++){
                    String Tipo1x =  ExpresionesRomeo.get(i).TipoDato;
                        switch (Tipo1x){
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
                        case "id":
                            if(entorno.ObtenerListaN(this.Expresiones.get(i).Nombre)==1){
                                String TipoVectorx = entorno.ObtenerTipo(this.Expresiones.get(i).Nombre);
                                    switch (TipoVectorx){
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
                        }
                    }
                    String Tipo1y = "";
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
                   System.out.println("El vector tiene tipo: " + Tipo1y);
                   for(int i = 0 ; i < ExpresionesRomeo.size();i++){
                        String ValorVectori = ExpresionesRomeo.get(i).Ejecutar(entorno, salida);
                        String TipoVector1 = entorno.ObtenerTipo("VectorDragonBallBeatles");
                        String TipoNodo = ExpresionesRomeo.get(i).TipoDato;
                        Tipo2 = entorno.ObtenerTipo(Vector2);
                        val2 = entorno.ObtenerValor(Vector2);
                        //System.out.println("Vector"+i+":" + Vector + " Valor->"+ ValorVectori + " Operacion" + this.Hijos.get(1).Nombre  + " TipoVector-> " + TipoVector1 + "TipoDato->" + TipoNodo );
                        if("cadena".equals(Tipo1y)){
                            
                            //System.out.println("Aca Operamos Cadenas" + ValorVectori + "Dato2->" + val2);
                            NodoAbstracto nuevo = new Nodo("Cadena");
                            String Resultadox = Resultado(ValorVectori,Tipo1y,val2,Tipo2,nuevo);
                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                            nuevo.Hijos.add(nuevovalor);
                           // nuevo.TipoDato = "cadena";
                            ExpresionesLola.add(nuevo);
                                                             
                        }else if("entero".equals(Tipo1y)){
                          
                           // System.out.println("Aca Operamos Cadenas" + ValorVectori + "Dato2->" + val2);
                            NodoAbstracto nuevo = new Nodo("Entero");
                             String Resultadox = Resultado(ValorVectori,Tipo1y,val2,Tipo2,nuevo);
                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                            nuevo.Hijos.add(nuevovalor);
                           // nuevo.TipoDato = "cadena";
                            ExpresionesLola.add(nuevo);
                        } else if("decimal".equals(Tipo1y)){
                            //System.out.println("Aca Operamos Cadenas->" + ValorVectori + "Tipo->" + Tipo1y + "Dato2->" + val2);
                            NodoAbstracto nuevo = new Nodo("Decimal");
                             String Resultadox = Resultado(ValorVectori,Tipo1y,val2,Tipo2,nuevo);
                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                            nuevo.Hijos.add(nuevovalor);
                           // nuevo.TipoDato = "cadena";
                            ExpresionesLola.add(nuevo);
                        }else if ("booleano".equals(Tipo1y)){
                            System.out.println("Aca Operamos Cadenas->" + ValorVectori + "Tipo->" + Tipo1y + "Dato2->" + val2);
                             NodoAbstracto nuevo = new Nodo("Booleano");
                             String Resultadox = Resultado(ValorVectori,Tipo1y,val2,Tipo2,nuevo);
                            System.out.println("Resultado" + Resultadox);
                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                            nuevo.Hijos.add(nuevovalor);
                           // nuevo.TipoDato = "cadena";
                            ExpresionesLola.add(nuevo);
                        }
                        this.TipoDato = "id";
                        this.Nombre = "VectorDragonBallBeatles";
                        
                    }
                    entorno.ModificarValorLista("VectorDragonBallBeatles", ExpresionesLola,Tipo1y, "prit");
                    return "RomeoAxpuac";
                    */
                  }else{
                      //NINGUNO DE LOS DOS VECTORES ES DE TAMAÑO 1 :(
                        ArrayList <NodoAbstracto> ExpresionesRomeo1 = new ArrayList();
                        ArrayList <NodoAbstracto> ExpresionesRomeo2= new ArrayList();
                        ExpresionesRomeo1 = entorno.ObtenerLista(Vector1);
                        ExpresionesRomeo2 = entorno.ObtenerLista(Vector2);
                        int TamanioVector1 = ExpresionesRomeo1.size();
                        int TamanioVector2 = ExpresionesRomeo2.size();
                        
                        
                             boolean ExisteVectorx =   entorno.ExisteVector("VectorDragonBallBeatles"); 
                        if(!ExisteVectorx == true){
                             entorno.Agregar2("VectorDragonBallBeatles", entorno.ObtenerLista(Vector1), entorno.ObtenerTipo(Vector1), "ss");
                        }else{
                            entorno.ModificarValorLista("VectorDragonBallBeatles", entorno.ObtenerLista(Vector1), entorno.ObtenerTipo(Vector1), "ss");
                        }
                        ExpresionesRomeo1 = entorno.ObtenerLista("VectorDragonBallBeatles");
                        //veamos el verdadero tipo del vector XD
                        int valor1 = 0 ,valor2= 0 ,valor3= 0 ,valor4= 0 ,valor5 = 0,valor6 = 0;
                        for(int i= 0; i < ExpresionesRomeo1.size();i++){
                        String Tipo1x =  ExpresionesRomeo1.get(i).TipoDato;
                            switch (Tipo1x){
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
                            case "id":
                                if(entorno.ObtenerListaN(this.Expresiones.get(i).Nombre)==1){
                                    String TipoVectorx = entorno.ObtenerTipo(this.Expresiones.get(i).Nombre);
                                        switch (TipoVectorx){
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
                            }
                        }
                        String Tipo1y = "";
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
                        valor1 = 0 ;valor2= 0 ;valor3= 0 ;valor4= 0 ;valor5 = 0;valor6 = 0;
                        for(int i= 0; i < ExpresionesRomeo2.size();i++){
                        String Tipo1x =  ExpresionesRomeo2.get(i).TipoDato;
                            switch (Tipo1x){
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
                            case "id":
                                if(entorno.ObtenerListaN(this.Expresiones.get(i).Nombre)==1){
                                    String TipoVectorx = entorno.ObtenerTipo(this.Expresiones.get(i).Nombre);
                                        switch (TipoVectorx){
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
                            }
                        }
                        String Tipo1y2 = "";
                        if(valor1 == 1){
                            Tipo1y2 = "Lista";
                        }else if(valor2 == 1){
                            Tipo1y2 = "cadena";
                        }
                        else if(valor3 == 1){
                            Tipo1y2 = "decimal";
                        }
                        else if(valor4 == 1){
                            Tipo1y2 = "entero";
                        }
                        else if(valor5 == 1){
                            Tipo1y2 = "booleano";
                        }
                        System.out.println("El vector1 tiene tipo: " + Tipo1y);
                        System.out.println("El vector2 tiene tipo: " + Tipo1y2);
                        if(TamanioVector1 == TamanioVector2){ 
                            //vecotres iguales
                             ArrayList <NodoAbstracto> ExpresionesLola = new ArrayList();
                            System.out.println("LOS VECTORES SON IGUALES PARA OPERAR XD" + TamanioVector1);
                            for(int i = 0; i < TamanioVector1 ; i ++){
                                String ValorVector1 = ExpresionesRomeo1.get(i).Ejecutar(entorno, salida);
                                String ValorVector2 = ExpresionesRomeo2.get(i).Ejecutar(entorno, salida);
                                System.out.println("LOS VECTORES SON IGUALES PARA OPERAR XD->" + i);
                                //System.out.println("Vector"+i+":" + Vector + " Valor->"+ ValorVectori + " Operacion" + this.Hijos.get(1).Nombre  + " TipoVector-> " + TipoVector1 + "TipoDato->" + TipoNodo );
                                if("cadena".equals(Tipo1y)){

                                    //System.out.println("Aca Operamos Cadenas" + ValorVectori + "Dato2->" + val2);
                                    NodoAbstracto nuevo = new Nodo("Cadena");
                                    String Resultadox = Resultado(ValorVector1,Tipo1y,ValorVector2,Tipo1y2,nuevo);
                                    NodoAbstracto nuevovalor = new Nodo(Resultadox);
                                    nuevo.Hijos.add(nuevovalor);
                                   // nuevo.TipoDato = "cadena";
                                    ExpresionesLola.add(nuevo);

                                }else if("entero".equals(Tipo1y)){

                                   // System.out.println("Aca Operamos Cadenas" + ValorVectori + "Dato2->" + val2);
                                    NodoAbstracto nuevo = new Nodo("Entero");
                                    String Resultadox = Resultado(ValorVector1,Tipo1y,ValorVector2,Tipo1y2,nuevo);
                                    NodoAbstracto nuevovalor = new Nodo(Resultadox);
                                    nuevo.Hijos.add(nuevovalor);
                                   // nuevo.TipoDato = "cadena";
                                    ExpresionesLola.add(nuevo);
                                } else if("decimal".equals(Tipo1y)){
                                    //System.out.println("Aca Operamos Cadenas->" + ValorVectori + "Tipo->" + Tipo1y + "Dato2->" + val2);
                                    NodoAbstracto nuevo = new Nodo("Decimal");
                                     String Resultadox = Resultado(ValorVector1,Tipo1y,ValorVector2,Tipo1y2,nuevo);
                                    NodoAbstracto nuevovalor = new Nodo(Resultadox);
                                    nuevo.Hijos.add(nuevovalor);
                                   // nuevo.TipoDato = "cadena";
                                    ExpresionesLola.add(nuevo);
                                }else if ("booleano".equals(Tipo1y)){
                                    //System.out.println("Aca Operamos Cadenas->" + ValorVectori + "Tipo->" + Tipo1y + "Dato2->" + val2);
                                    NodoAbstracto nuevo = new Nodo("Booleano");
                                    String Resultadox = Resultado(ValorVector1,Tipo1y,ValorVector2,Tipo1y2,nuevo);
                                    System.out.println("Resultado" + Resultadox);
                                    NodoAbstracto nuevovalor = new Nodo(Resultadox);
                                    nuevo.Hijos.add(nuevovalor);
                                   // nuevo.TipoDato = "cadena";
                                    ExpresionesLola.add(nuevo);
                                    }
                                    
                                }
                                this.TipoDato = "id";
                                this.Nombre = "VectorDragonBallBeatles";
                                entorno.ModificarValorLista("VectorDragonBallBeatles", ExpresionesLola,Tipo1y, "prit");
                                
                                return "RomeoAxpuac";
                                }else if(TamanioVector1 > TamanioVector2){
                                    //vector1 mayor
                                    return "#Error";
                                    /*
                                    System.out.println("VECTOR1 ES MAYORx");
                                    ArrayList <NodoAbstracto> ExpresionesLola = new ArrayList();
                                    System.out.println("LOS VECTORES SON IGUALES PARA OPERAR XD" + TamanioVector1);
                                    for(int i = 0; i < TamanioVector1 ; i ++){
                                        if(i>TamanioVector2-1){
                                            ExpresionesLola.add(ExpresionesRomeo1.get(i));
                                        }else{
                                        String ValorVector1 = ExpresionesRomeo1.get(i).Ejecutar(entorno, salida);
                                        String ValorVector2 = ExpresionesRomeo2.get(i).Ejecutar(entorno, salida);
                                        System.out.println("LOS VECTORES SON IGUALES PARA OPERAR XD->" + i);
                                        //System.out.println("Vector"+i+":" + Vector + " Valor->"+ ValorVectori + " Operacion" + this.Hijos.get(1).Nombre  + " TipoVector-> " + TipoVector1 + "TipoDato->" + TipoNodo );
                                        if("cadena".equals(Tipo1y)){

                                            //System.out.println("Aca Operamos Cadenas" + ValorVectori + "Dato2->" + val2);
                                            NodoAbstracto nuevo = new Nodo("Cadena");
                                            String Resultadox = Resultado(ValorVector1,Tipo1y,ValorVector2,Tipo1y2,nuevo);
                                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                                            nuevo.Hijos.add(nuevovalor);
                                           // nuevo.TipoDato = "cadena";
                                            ExpresionesLola.add(nuevo);

                                        }else if("entero".equals(Tipo1y)){

                                           // System.out.println("Aca Operamos Cadenas" + ValorVectori + "Dato2->" + val2);
                                            NodoAbstracto nuevo = new Nodo("Entero");
                                            String Resultadox = Resultado(ValorVector1,Tipo1y,ValorVector2,Tipo1y2,nuevo);
                                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                                            nuevo.Hijos.add(nuevovalor);
                                           // nuevo.TipoDato = "cadena";
                                            ExpresionesLola.add(nuevo);
                                        } else if("decimal".equals(Tipo1y)){
                                            //System.out.println("Aca Operamos Cadenas->" + ValorVectori + "Tipo->" + Tipo1y + "Dato2->" + val2);
                                            NodoAbstracto nuevo = new Nodo("Decimal");
                                             String Resultadox = Resultado(ValorVector1,Tipo1y,ValorVector2,Tipo1y2,nuevo);
                                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                                            nuevo.Hijos.add(nuevovalor);
                                           // nuevo.TipoDato = "cadena";
                                            ExpresionesLola.add(nuevo);
                                        }else if ("booleano".equals(Tipo1y)){
                                            //System.out.println("Aca Operamos Cadenas->" + ValorVectori + "Tipo->" + Tipo1y + "Dato2->" + val2);
                                            NodoAbstracto nuevo = new Nodo("Booleano");
                                            String Resultadox = Resultado(ValorVector1,Tipo1y,ValorVector2,Tipo1y2,nuevo);
                                            System.out.println("Resultado" + Resultadox);
                                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                                            nuevo.Hijos.add(nuevovalor);
                                           // nuevo.TipoDato = "cadena";
                                            ExpresionesLola.add(nuevo);
                                            }

                                        }
                                    }
                                        this.TipoDato = "id";
                                        this.Nombre = "VectorDragonBallBeatles";
                                        entorno.ModificarValorLista("VectorDragonBallBeatles", ExpresionesLola,Tipo1y, "prit");
                                        return "RomeoAxpuac";
                                    */
                                }else if(TamanioVector1 < TamanioVector2){
                                    //vector 2 es mayor
                                    return "#Error";
                                    /*
                                    System.out.println("VECTOR2 ES MAYOR");
                                    ArrayList <NodoAbstracto> ExpresionesLola = new ArrayList();
                                    System.out.println("LOS VECTORES SON IGUALES PARA OPERAR XD" + TamanioVector1);
                                    for(int i = 0; i < TamanioVector2 ; i ++){
                                         if(i>TamanioVector1-1){
                                            ExpresionesLola.add(ExpresionesRomeo2.get(i));
                                        }else{
                                        String ValorVector1 = ExpresionesRomeo1.get(i).Ejecutar(entorno, salida);
                                        String ValorVector2 = ExpresionesRomeo2.get(i).Ejecutar(entorno, salida);
                                        System.out.println("LOS VECTORES SON IGUALES PARA OPERAR XD->" + i);
                                        //System.out.println("Vector"+i+":" + Vector + " Valor->"+ ValorVectori + " Operacion" + this.Hijos.get(1).Nombre  + " TipoVector-> " + TipoVector1 + "TipoDato->" + TipoNodo );
                                        if("cadena".equals(Tipo1y)){

                                            //System.out.println("Aca Operamos Cadenas" + ValorVectori + "Dato2->" + val2);
                                            NodoAbstracto nuevo = new Nodo("Cadena");
                                            String Resultadox = Resultado(ValorVector1,Tipo1y,ValorVector2,Tipo1y2,nuevo);
                                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                                            nuevo.Hijos.add(nuevovalor);
                                           // nuevo.TipoDato = "cadena";
                                            ExpresionesLola.add(nuevo);

                                        }else if("entero".equals(Tipo1y)){

                                           // System.out.println("Aca Operamos Cadenas" + ValorVectori + "Dato2->" + val2);
                                            NodoAbstracto nuevo = new Nodo("Entero");
                                            String Resultadox = Resultado(ValorVector1,Tipo1y,ValorVector2,Tipo1y2,nuevo);
                                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                                            nuevo.Hijos.add(nuevovalor);
                                           // nuevo.TipoDato = "cadena";
                                            ExpresionesLola.add(nuevo);
                                        } else if("decimal".equals(Tipo1y)){
                                            //System.out.println("Aca Operamos Cadenas->" + ValorVectori + "Tipo->" + Tipo1y + "Dato2->" + val2);
                                            NodoAbstracto nuevo = new Nodo("Decimal");
                                             String Resultadox = Resultado(ValorVector1,Tipo1y,ValorVector2,Tipo1y2,nuevo);
                                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                                            nuevo.Hijos.add(nuevovalor);
                                           // nuevo.TipoDato = "cadena";
                                            ExpresionesLola.add(nuevo);
                                        }else if ("booleano".equals(Tipo1y)){
                                            //System.out.println("Aca Operamos Cadenas->" + ValorVectori + "Tipo->" + Tipo1y + "Dato2->" + val2);
                                            NodoAbstracto nuevo = new Nodo("Booleano");
                                            String Resultadox = Resultado(ValorVector1,Tipo1y,ValorVector2,Tipo1y2,nuevo);
                                            System.out.println("Resultado" + Resultadox);
                                            NodoAbstracto nuevovalor = new Nodo(Resultadox);
                                            nuevo.Hijos.add(nuevovalor);
                                           // nuevo.TipoDato = "cadena";
                                            ExpresionesLola.add(nuevo);
                                            }

                                        }
                                    }
                                        this.TipoDato = "id";
                                        this.Nombre = "VectorDragonBallBeatles";
                                        entorno.ModificarValorLista("VectorDragonBallBeatles", ExpresionesLola,Tipo1y, "prit");
                                        return "RomeoAxpuac";
                                    */
                                }
                                
                                
                  }
                }
            }else{
                salida.append("#ERROR: El vector "+ Vector1 + "o" + Vector2 + " No Existe "  +"\n");
                return "#ERROR: El vector "+ Vector1 + "o" + Vector2 + " No Existe " ;
            }
            
        
        }
        
        if (val1.equalsIgnoreCase("#Error") || val2.equalsIgnoreCase("#Error")){
            return "#Error";
        }
        
        if("entero".equals(Tipo1) && "entero".equals(Tipo2)){        
            int valor1 = Integer.parseInt(val1);
            int valor2 = Integer.parseInt(val2);
            this.TipoDato = "entero";
            switch(this.Hijos.get(1).Nombre){
                case "+":
                    total = valor1 + valor2;
                  //  System.out.println("Paso por una suma");
                    break;
                case "-":
                    total = valor1 - valor2;
               //     System.out.println("Paso por una resta");
                    break;
                case "/":
                    if(valor2==0){
                        salida.append("#Error: Se está intentando dividir por 0 \n");
                        return "#Error";
                    }
                    total = valor1 / valor2;
                 //   System.out.println("Paso por una division");
                    break;
                case "*":
                    total = valor1 * valor2;
                  //  System.out.println("Paso por una multiplicacion");
                    break;
              case "^":
                    total =  (int) Math.pow(valor1,valor2);
                    this.TipoDato = "decimal";
                 //   System.out.println("Paso por una potencia");
                    break;
              case "%%":
                    total =  valor1  % valor2;
                 //   System.out.println("Paso por una potencia");
                    break;
              case "==":
                    if(valor1 == valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                  
                case "!=":
                    if(valor1 != valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case ">":
                    if(valor1 > valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case "<":
                    if(valor1 < valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                 case ">=":
                    if(valor1 >= valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case "<=":
                    if(valor1 <= valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case "&&":
                     return "#Error";
                case "||":
                     return "#Error";
                default:

            }

            return Integer.toString(total);
        }
        else if(("decimal".equals(Tipo1)||"entero".equals(Tipo1)) && "decimal".equals(Tipo2)){   
            this.TipoDato="decimal";
            double valor1 = Double.parseDouble(val1);
            double valor2 =  Double.parseDouble(val2);
            switch(this.Hijos.get(1).Nombre){
                case "+":
                    totald = valor1 + valor2;
                   // System.out.println("Paso por una suma");
                    break;
                case "-":
                    totald = valor1 - valor2;
                  //  System.out.println("Paso por una resta");
                    break;
                case "/":
                    if(valor2==0){
                        salida.append("#Error: Se está intentando dividir por 0 \n");
                        return "#Error";
                    }
                    totald = valor1 / valor2;
                 //   System.out.println("Paso por una division");
                    break;
                case "*":
                    totald = valor1 * valor2;
                 //   System.out.println("Paso por una multiplicacion");
                    break;
              case "^":
                    totald =  (double) Math.pow(valor1,valor2);
                    this.TipoDato = "decimal";
                    System.out.println("Paso por una potencia");
                    break;
              case "%%":
                    totald =  valor1  % valor2;
                    System.out.println("Paso por una potencia");
                    break;
              case "==":
                    if(valor1 == valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                  
                case "!=":
                    if(valor1 != valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case ">":
                    if(valor1 > valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case "<":
                    if(valor1 < valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                    case ">=":
                    if(valor1 >= valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case "<=":
                    if(valor1 <= valor2){
                        return "true";
                    }else{
                        return "false";
                    }
              case "&&":
                     return "#Error";
                case "||":
                     return "#Error";
                default:

            }

            return String.valueOf(totald);
        }
        else if(("cadena".equals(Tipo1)||"decimal".equals(Tipo1)||"entero".equals(Tipo1)) && "cadena".equals(Tipo2)){        
            String valor1 = val1;
            String valor2 =  val2;
            this.TipoDato = "cadena";
            switch(this.Hijos.get(1).Nombre){
                case "+":
                    totalc = valor1 + valor2;
                    System.out.println("Paso por una suma");
                    break;
                case "-":
                    return "#Error";
                case "/":
                   return "#Error";
                case "*":
                   return "#Error";
              case "^":
                    return "#Error";
               case "%%":
                    return "#Error";
               case "==":
                  if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                       if(valor1.equals(valor2)){
                        return "true";
                    }else{
                        return "false";
                    }
                  }else{
                    return "#Error";
                  }
                   
                  
                case "!=":
                    if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(!valor1.equals(valor2)){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }
                    
                case ">":
                    System.out.println("ENTRO");
                   if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(valor1.compareTo(valor2) > 0){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }
                case "<":
                    if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(valor1.compareTo(valor2) < 0){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }
                    
                    
             case ">=":
                    System.out.println("ENTRO");
                   if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(valor1.compareTo(valor2) >= 0){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }
                case "<=":
                    if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(valor1.compareTo(valor2) <= 0){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }  
             case "&&":
                     return "#Error";
                case "||":
                     return "#Error";
                default:

            }

            return String.valueOf(totalc);
        }
        else if("decimal".equals(Tipo1) && ("decimal".equals(Tipo2)||"entero".equals(Tipo2))){        
            double valor1 = Double.parseDouble(val1);
            double valor2 =  Double.parseDouble(val2);
            this.TipoDato = "decimal";
            switch(this.Hijos.get(1).Nombre){
                case "+":
                    totald = valor1 + valor2;
                    System.out.println("Paso por una suma");
                    break;
                case "-":
                    totald = valor1 - valor2;
                    System.out.println("Paso por una resta");
                    break;
                case "/":
                    if(valor2==0){
                        salida.append("#Error: Se está intentando dividir por 0 \n");
                        return "#Error";
                    }
                    totald = valor1 / valor2;
                    System.out.println("Paso por una division");
                    break;
                case "*":
                    totald = valor1 * valor2;
                    System.out.println("Paso por una multiplicacion");
                    break;
              case "^":
                    totald =  (double) Math.pow(valor1,valor2);
                    this.TipoDato = "decimal";
                    System.out.println("Paso por una potencia");
                    break;
              case "%%":
                    totald =  valor1  % valor2;
                    System.out.println("Paso por una potencia");
                    break;
              case "==":
                    if(valor1 == valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                  
                case "!=":
                    if(valor1 != valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case ">":
                    if(valor1 > valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case "<":
                    if(valor1 < valor2){
                        return "true";
                    }else{
                        return "false";
                    }
             case ">=":
                    if(valor1 >= valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case "<=":
                    if(valor1 <= valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                    
               case "&&":
                     return "#Error";
                case "||":
                     return "#Error";
                default:

            }

            return String.valueOf(totald);
        }
        else if("cadena".equals(Tipo1) && ("cadena".equals(Tipo2)||"decimal".equals(Tipo2)||"entero".equals(Tipo2))){ 
            String valor1 = val1;
            String valor2 =  val2;
            this.TipoDato = "cadena";
            switch(this.Hijos.get(1).Nombre){
                case "+":
                    totalc = valor1 + valor2;
                    System.out.println("Paso por una suma");
                    break;
                case "-":
                    System.out.println("Paso por una suma");
                    return "#Error";
                case "/":
                   return "#Error";
                case "*":
                   return "#Error";
              case "^":
                    return "#Error";
               case "%%":
                    return "#Error";
                default:
            case "==":
                  if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                       if(valor1.equals(valor2)){
                        return "true";
                    }else{
                        return "false";
                    }
                  }else{
                    return "#Error";
                  }
                   
                  
                case "!=":
                    if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(!valor1.equals(valor2)){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }
                case ">":
                    System.out.println("ENTRO");
                   if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(valor1.compareTo(valor2) > 0){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }
                case "<":
                    if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(valor1.compareTo(valor2) < 0){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }
                case ">=":
                    System.out.println("ENTRO");
                   if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(valor1.compareTo(valor2) >= 0){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }
                case "<=":
                    if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(valor1.compareTo(valor2) <= 0){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }
                    
                    
                    case "&&":
                     return "#Error";
                case "||":
                     return "#Error";
        
        }
            return String.valueOf(totalc);
        }
        else if("booleano".equals(Tipo1) && ("cadena".equals(Tipo2))){ 
            String valor1 = val1;
            String valor2 =  val2;
            this.TipoDato = "cadena";
            switch(this.Hijos.get(1).Nombre){
                case "+":
                    totalc = valor1 + valor2;
                    System.out.println("Paso por una suma");
                    break;
                case "-":
                    return "#Error";
                case "/":
                   return "#Error";
                case "*":
                   return "#Error";
              case "^":
                    return "#Error";
               case "%%":
                    return "#Error";
               case "==":
                    return "#Error";
               case "!=":
                    return "#Error";
                 case ">":
                   return "#Error";
                case "<":
                    return "#Error";
                    case ">=":
                   return "#Error";
                case "<=":
                    return "#Error";
                    
                    case "&&":
                     return "#Error";
                case "||":
                     return "#Error";
                default:
        
        }
            return String.valueOf(totalc);
        }
        else if("cadena".equals(Tipo1) && ("booleano".equals(Tipo2))){ 
            String valor1 = val1;
            String valor2 =  val2;
            this.TipoDato = "cadena";
            switch(this.Hijos.get(1).Nombre){
                case "+":
                    totalc = valor1 + valor2;
                    System.out.println("Paso por una suma");
                    break;
                case "-":
                    return "#Error";
                case "/":
                   return "#Error";
                case "*":
                   return "#Error";
              case "^":
                    return "#Error";
               case "%%":
                    return "#Error";
                default:
              case "==":
                    return "#Error";
               case "!=":
                    return "#Error";
                 case ">":
                   return "#Error";
                case "<":
                    return "#Error";
              case ">=":
                   return "#Error";
                case "<=":
                    return "#Error";
                    
                    case "&&":
                     return "#Error";
                case "||":
                     return "#Error";
        
        }
            return String.valueOf(totalc);
        }
         else if("booleano".equals(Tipo1) && ("booleano".equals(Tipo2))){ 
            String valor1 = val1;
            String valor2 =  val2;
            this.TipoDato = "booleano";
            switch(this.Hijos.get(1).Nombre){
                case "+":
                    return "#Error";
                case "-":
                    return "#Error";
                case "/":
                   return "#Error";
                case "*":
                   return "#Error";
              case "^":
                    return "#Error";
               case "%%":
                    return "#Error";
                default:
               case "==":
                    if(valor1.equals(valor2)){
                        return "true";
                    }else{
                        return "false";
                    }
                  
                case "!=":
                     if(!valor1.equals(valor2)){
                        return "true";
                    }else{
                        return "false";
                    }
               case ">":
                   return "#Error";
                case "<":
                    return "#Error";
               case ">=":
                   return "#Error";
                case "<=":
                    return "#Error";
              case "&&":
                    if(valor1.equals(valor2)){
                        return "true";
                    }else{
                        return "false";
                    }
                case "||":
                     if(!valor1.equals(valor2)){
                        return "true";
                    }else{
                        return "false";
                    }
        
        }
        }
        
       
        return "#Error";
    }
    
    public String Resultado(String Valor1, String Tipo1x, String Valor2, String Tipo2x, NodoAbstracto Nodo){
        int total = 0;
        double totald = 0;
        String totalc = "";
        String val1 = Valor1;
        String val2 = Valor2;
        
        String Tipo1 = Tipo1x;
        String Tipo2 = Tipo2x;
        
        if("entero".equals(Tipo1) && "entero".equals(Tipo2)){        
            int valor1 = Integer.parseInt(val1);
            int valor2 = Integer.parseInt(val2);
            Nodo.TipoDato = "entero";
            switch(this.Hijos.get(1).Nombre){
                case "+":
                    total = valor1 + valor2;
                  //  System.out.println("Paso por una suma");
                    break;
                case "-":
                    total = valor1 - valor2;
               //     System.out.println("Paso por una resta");
                    break;
                case "/":
                    if(valor2==0){
                        //salida.append("#Error: Se está intentando dividir por 0 \n");
                        return "#Error";
                    }
                    total = valor1 / valor2;
                 //   System.out.println("Paso por una division");
                    break;
                case "*":
                    total = valor1 * valor2;
                  //  System.out.println("Paso por una multiplicacion");
                    break;
              case "^":
                    total =  (int) Math.pow(valor1,valor2);
                    this.TipoDato = "decimal";
                 //   System.out.println("Paso por una potencia");
                    break;
              case "%%":
                    total =  valor1  % valor2;
                 //   System.out.println("Paso por una potencia");
                    break;
              case "==":
                    if(valor1 == valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                  
                case "!=":
                    if(valor1 != valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case ">":
                    if(valor1 > valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case "<":
                    if(valor1 < valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                 case ">=":
                    if(valor1 >= valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case "<=":
                    if(valor1 <= valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case "&&":
                     return "#Error";
                case "||":
                     return "#Error";
                default:

            }

            return Integer.toString(total);
        }
        else if(("decimal".equals(Tipo1)||"entero".equals(Tipo1)) && "decimal".equals(Tipo2)){   
            Nodo.TipoDato="decimal";
            double valor1 = Double.parseDouble(val1);
            double valor2 =  Double.parseDouble(val2);
            switch(this.Hijos.get(1).Nombre){
                case "+":
                    totald = valor1 + valor2;
                   // System.out.println("Paso por una suma");
                    break;
                case "-":
                    totald = valor1 - valor2;
                  //  System.out.println("Paso por una resta");
                    break;
                case "/":
                    if(valor2==0){
                        //salida.append("#Error: Se está intentando dividir por 0 \n");
                        return "#Error";
                    }
                    totald = valor1 / valor2;
                 //   System.out.println("Paso por una division");
                    break;
                case "*":
                    totald = valor1 * valor2;
                 //   System.out.println("Paso por una multiplicacion");
                    break;
              case "^":
                    totald =  (double) Math.pow(valor1,valor2);
                    System.out.println("Paso por una potencia");
                    this.TipoDato = "decimal";
                    break;
              case "%%":
                    totald =  valor1  % valor2;
                    System.out.println("Paso por una potencia");
                    break;
              case "==":
                    if(valor1 == valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                  
                case "!=":
                    if(valor1 != valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case ">":
                    if(valor1 > valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case "<":
                    if(valor1 < valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                    case ">=":
                    if(valor1 >= valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case "<=":
                    if(valor1 <= valor2){
                        return "true";
                    }else{
                        return "false";
                    }
              case "&&":
                     return "#Error";
                case "||":
                     return "#Error";
                default:

            }

            return String.valueOf(totald);
        }
        else if(("cadena".equals(Tipo1)||"decimal".equals(Tipo1)||"entero".equals(Tipo1)) && "cadena".equals(Tipo2)){        
            String valor1 = val1;
            String valor2 =  val2;
           Nodo.TipoDato = "cadena";
            switch(this.Hijos.get(1).Nombre){
                case "+":
                    totalc = valor1 + valor2;
                    System.out.println("Paso por una suma");
                    break;
                case "-":
                    return "#Error";
                case "/":
                   return "#Error";
                case "*":
                   return "#Error";
              case "^":
                    return "#Error";
               case "%%":
                    return "#Error";
               case "==":
                  if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                       if(valor1.equals(valor2)){
                        return "true";
                    }else{
                        return "false";
                    }
                  }else{
                    return "#Error";
                  }
                   
                  
                case "!=":
                    if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(!valor1.equals(valor2)){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }
                    
                case ">":
                    System.out.println("ENTRO");
                   if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(valor1.compareTo(valor2) > 0){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }
                case "<":
                    if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(valor1.compareTo(valor2) < 0){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }
                    
                    
             case ">=":
                    System.out.println("ENTRO");
                   if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(valor1.compareTo(valor2) >= 0){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }
                case "<=":
                    if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(valor1.compareTo(valor2) <= 0){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }  
             case "&&":
                     return "#Error";
                case "||":
                     return "#Error";
                default:

            }

            return String.valueOf(totalc);
        }
        else if("decimal".equals(Tipo1) && ("decimal".equals(Tipo2)||"entero".equals(Tipo2))){        
            double valor1 = Double.parseDouble(val1);
            double valor2 =  Double.parseDouble(val2);
            Nodo.TipoDato = "decimal";
            switch(this.Hijos.get(1).Nombre){
                case "+":
                    totald = valor1 + valor2;
                    System.out.println("Paso por una suma");
                    break;
                case "-":
                    totald = valor1 - valor2;
                    System.out.println("Paso por una resta");
                    break;
                case "/":
                    if(valor2==0){
                       // salida.append("#Error: Se está intentando dividir por 0 \n");
                        return "#Error";
                    }
                    totald = valor1 / valor2;
                    System.out.println("Paso por una division");
                    break;
                case "*":
                    totald = valor1 * valor2;
                    System.out.println("Paso por una multiplicacion");
                    break;
              case "^":
                    totald =  (double) Math.pow(valor1,valor2);
                    this.TipoDato = "decimal";
                    System.out.println("Paso por una potencia");
                    break;
              case "%%":
                    totald =  valor1  % valor2;
                    System.out.println("Paso por una potencia");
                    break;
              case "==":
                    if(valor1 == valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                  
                case "!=":
                    if(valor1 != valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case ">":
                    if(valor1 > valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case "<":
                    if(valor1 < valor2){
                        return "true";
                    }else{
                        return "false";
                    }
             case ">=":
                    if(valor1 >= valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                case "<=":
                    if(valor1 <= valor2){
                        return "true";
                    }else{
                        return "false";
                    }
                    
               case "&&":
                     return "#Error";
                case "||":
                     return "#Error";
                default:

            }

            return String.valueOf(totald);
        }
        else if("cadena".equals(Tipo1) && ("cadena".equals(Tipo2)||"decimal".equals(Tipo2)||"entero".equals(Tipo2))){ 
            String valor1 = val1;
            String valor2 =  val2;
            Nodo.TipoDato = "cadena";
            switch(this.Hijos.get(1).Nombre){
                case "+":
                    totalc = valor1 + valor2;
                    System.out.println("Paso por una suma");
                    break;
                case "-":
                    System.out.println("Paso por una suma");
                    return "#Error";
                case "/":
                   return "#Error";
                case "*":
                   return "#Error";
              case "^":
                    return "#Error";
               case "%%":
                    return "#Error";
                default:
            case "==":
                  if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                       if(valor1.equals(valor2)){
                        return "true";
                    }else{
                        return "false";
                    }
                  }else{
                    return "#Error";
                  }
                   
                  
                case "!=":
                    if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(!valor1.equals(valor2)){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }
                case ">":
                    System.out.println("ENTRO");
                   if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(valor1.compareTo(valor2) > 0){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }
                case "<":
                    if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(valor1.compareTo(valor2) < 0){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }
                case ">=":
                    System.out.println("ENTRO");
                   if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(valor1.compareTo(valor2) >= 0){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }
                case "<=":
                    if("cadena".equals(Tipo2) && "cadena".equals(Tipo1)){
                        if(valor1.compareTo(valor2) <= 0){
                            return "true";
                        }else{
                            return "false";
                        }
                    }else{
                        return "#Error";
                    }
                    
                    
                    case "&&":
                     return "#Error";
                case "||":
                     return "#Error";
        
        }
            return String.valueOf(totalc);
        }
        else if("booleano".equals(Tipo1) && ("cadena".equals(Tipo2))){ 
            String valor1 = val1;
            String valor2 =  val2;
            Nodo.TipoDato = "cadena";
            switch(this.Hijos.get(1).Nombre){
                case "+":
                    totalc = valor1 + valor2;
                    System.out.println("Paso por una suma");
                    break;
                case "-":
                    return "#Error";
                case "/":
                   return "#Error";
                case "*":
                   return "#Error";
              case "^":
                    return "#Error";
               case "%%":
                    return "#Error";
               case "==":
                    return "#Error";
               case "!=":
                    return "#Error";
                 case ">":
                   return "#Error";
                case "<":
                    return "#Error";
                    case ">=":
                   return "#Error";
                case "<=":
                    return "#Error";
                    
                    case "&&":
                     return "#Error";
                case "||":
                     return "#Error";
                default:
        
        }
            return String.valueOf(totalc);
        }
        else if("cadena".equals(Tipo1) && ("booleano".equals(Tipo2))){ 
            String valor1 = val1;
            String valor2 =  val2;
            Nodo.TipoDato = "cadena";
            switch(this.Hijos.get(1).Nombre){
                case "+":
                    totalc = valor1 + valor2;
                    System.out.println("Paso por una suma");
                    break;
                case "-":
                    return "#Error";
                case "/":
                   return "#Error";
                case "*":
                   return "#Error";
              case "^":
                    return "#Error";
               case "%%":
                    return "#Error";
                default:
              case "==":
                    return "#Error";
               case "!=":
                    return "#Error";
                 case ">":
                   return "#Error";
                case "<":
                    return "#Error";
              case ">=":
                   return "#Error";
                case "<=":
                    return "#Error";
                    
                    case "&&":
                     return "#Error";
                case "||":
                     return "#Error";
        
        }
            return String.valueOf(totalc);
        }
         else if("booleano".equals(Tipo1) && ("booleano".equals(Tipo2))){ 
            String valor1 = val1;
            String valor2 =  val2;
            Nodo.TipoDato = "booleano";
            switch(this.Hijos.get(1).Nombre){
                case "+":
                    return "#Error";
                case "-":
                    return "#Error";
                case "/":
                   return "#Error";
                case "*":
                   return "#Error";
              case "^":
                    return "#Error";
               case "%%":
                    return "#Error";
                default:
               case "==":
                    if(valor1.equals(valor2)){
                        return "true";
                    }else{
                        return "false";
                    }
                  
                case "!=":
                     if(!valor1.equals(valor2)){
                        return "true";
                    }else{
                        return "false";
                    }
               case ">":
                   return "#Error";
                case "<":
                    return "#Error";
               case ">=":
                   return "#Error";
                case "<=":
                    return "#Error";
              case "&&":
                    if(valor1.equals(valor2)){
                        return "true";
                    }else{
                        return "false";
                    }
                case "||":
                     if(!valor1.equals(valor2)){
                        return "true";
                    }else{
                        return "false";
                    }
        
        }
        }
        return "#Error";
    }
    
}