/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import CodigoASTCUP.NodoAbstracto;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author Bayyron
 */
public class Entorno {
    public Hashtable<String,Simbolo> Elementos;

    public Entorno() {
        Elementos = new Hashtable<>();
    }
    
    public boolean Agregar(String id, String tipo, String valor){
        if (!Elementos.containsKey(id)) {
            Simbolo sim = new Simbolo(id, valor, tipo);
            Elementos.put(id, sim);
            System.out.println("La variables se agregó -> "+id);
            return true;
        }else{
            System.out.println("La variables ya existe -> "+id);
            return false;
        }
    }
    
    public boolean Agregar2(String id, ArrayList <NodoAbstracto> Expresiones, String Tipo,String Borrador){
        if (!Elementos.containsKey(id)) {
            Simbolo sim = new Simbolo(id, Expresiones, Tipo,Borrador);
            Elementos.put(id, sim);
            System.out.println("La variables se agregó -> "+id);
            return true;
        }else{
            System.out.println("La variables ya existe -> "+id);
            return false;
        }
    }
    
       public boolean AgregarFuncion(String id, ArrayList <NodoAbstracto> Parametros, ArrayList <NodoAbstracto> Expresiones, String Tipo,String Borrador){
        if (!Elementos.containsKey(id)) {
            Simbolo sim = new Simbolo(id,Parametros, Expresiones, Tipo,Borrador);
            Elementos.put(id, sim);
            System.out.println("La funcion se agregó -> "+id);
            return true;
        }else{
            System.out.println("La funcion ya existe -> "+id);
            return false;
        }
    }
       public ArrayList <NodoAbstracto> ListaParetros(String ID){
            if (Elementos.containsKey(ID)) {
                return Elementos.get(ID).RetornarParametros();
            }
            return null;
       }
       public ArrayList <NodoAbstracto> ListaSentenciasFuncion(String ID){
           if (Elementos.containsKey(ID)) {
                return Elementos.get(ID).RetornarLista();
            }
           return null;
       }
    
    public boolean AgregarLista(String id, ArrayList <NodoAbstracto> Expresiones, String Tipo,String Borrador){
        if (!Elementos.containsKey(id)) {
            Simbolo sim = new Simbolo(id, Expresiones, Tipo,Borrador);
            Elementos.put(id, sim);
            System.out.println("La variables se agregó -> "+id);
            return true;
        }else{
            System.out.println("La variables ya existe -> "+id);
            return false;
        }
    }
    
    public boolean ExisteVector(String id){
         return(Elementos.containsKey(id));
          
    }
    public void EliminarVector(String id){
        System.out.println("vamos a eliminar id"+ id);
        Elementos.remove(id);
    }
    
    public String ObtenerValor(String id){
        if (Elementos.containsKey(id)) {
            return Elementos.get(id).ObtenerValor();
        } else{
            return "#Error";
        }
    }
    
    public String Borrador(String id){
        if (Elementos.containsKey(id)) {
            return Elementos.get(id).Borrador();
        } else{
            return "#Error";
        }
    }
    public String ObtenerTipo(String id){
        if (Elementos.containsKey(id)) {
            return Elementos.get(id).ObtenerTipo();
        } else{
            return "#Error";
        }
    }
    
    public String ObtenerBorrador(String id){
        if (Elementos.containsKey(id)) {
            return Elementos.get(id).getBorrador();
        } else{
            return "#Error";
        }
    }
    
    public ArrayList <NodoAbstracto> ObtenerLista(String id){
        if (Elementos.containsKey(id)) {
            return Elementos.get(id).RetornarLista();
        } else{
            return null;
        }
    }
    
    public void ModificarValor(String id, String Valor, String Tipo){
     if (Elementos.containsKey(id)) {
           Elementos.get(id).ModificarValor(Valor, Tipo);
        }
    }
    public void ModificarValorLista(String id, ArrayList <NodoAbstracto> Expresiones, String Tipo, String Borrador){
     if (Elementos.containsKey(id)) {
           Elementos.get(id).ModificarValorLista(Expresiones, Tipo,Borrador);
        }
    }
    
    public void MostrarVectores(){
       Enumeration e = Elementos.keys();
        Object clave;
        while( e.hasMoreElements() ) {
            clave = e.nextElement();
            String Clave2 = (String) clave;
            if(ObtenerListaN(Clave2) ==0 && !"Funcion".equals(ObtenerTipo(Clave2))){
            System.out.println( "Vector : " + clave + " Valor:" + ObtenerValor(Clave2) + " Tipo:" + ObtenerTipo(Clave2));
        }
        }
    }
    
    public NodoAbstracto NodoLista(String id, int posicion){
    
        if (Elementos.containsKey(id)) {
            for(int i = 0; i < Elementos.get(id).RetornarLista().size();i++){
                if(i == posicion){
                    return Elementos.get(id).RetornarLista().get(i);
                }
            }
        } 
        return null;
    }
  
    public int ObtenerListaN(String id){
        if (Elementos.containsKey(id)) {
            return Elementos.get(id).ObtenerLista();
        } else{
            return 0;
        }
    }

    public void MostrarVectoresLista(){
       Enumeration e = Elementos.keys();
        Object clave;
        while( e.hasMoreElements() ) {
            clave = e.nextElement();
            String Clave2 = (String) clave;
            if(ObtenerListaN(Clave2) ==1){
            System.out.println( "Vector : " + clave + " Valor:" + ObtenerBorrador(Clave2) + " Tipo:" + ObtenerTipo(Clave2));
            }
          }
    }
    public Entorno  ModificandoEntornos(Entorno entorno1,Entorno Global){
        Entorno entorno3 = new Entorno();
        Enumeration e = entorno1.Elementos.keys();
        Object clave;
        while( e.hasMoreElements() ) {
            clave = e.nextElement();
            String Clave2 = (String) clave;
            if(Global.Elementos.containsKey(Clave2)==true){
                System.out.println("Este Vector: " + Clave2 + " Si se agrega al Global(3x)" + "<->Valor->" + Global.Elementos.get(Clave2).ObtenerValor());
                System.out.println("VECATOR->" + Clave2 + "<->valor2->" + entorno1.Elementos.get(Clave2).ObtenerValor());
                System.out.println("VECATOR->" + Clave2 + "<->valor2->" + Global.Elementos.get(Clave2).ObtenerValor());
                //entorno1.Elementos.get(Clave2).ModificarValor(entorno1.Elementos.get(Clave2).ObtenerValor(), entorno1.Elementos.get(Clave2).ObtenerTipo());
                
                entorno3.Elementos.put(Clave2,entorno1.Elementos.get(Clave2));
                System.out.println("VAMOS A VER QUE PEDO CON 3->" + entorno3.Elementos.get(Clave2).ObtenerValor());
            
            } 
          }
        return entorno3;
    }
    public ArrayList  ModificandoEntornosVectorLista(Entorno entorno1,Entorno Global){
         ArrayList<String> ejemploLista = new ArrayList<String>(); 
        Entorno entorno3 = new Entorno();
        Enumeration e = entorno1.Elementos.keys();
        Object clave;
        while( e.hasMoreElements() ) {
            clave = e.nextElement();
            String Clave2 = (String) clave;
            if(Global.Elementos.containsKey(Clave2)==true){
                System.out.println("Este Vector: " + Clave2 + " Si se agrega al Global(3x)" + "<->Valor->" + Global.Elementos.get(Clave2).ObtenerValor());
                System.out.println("VECATOR->" + Clave2 + "<->valor2->" + entorno1.Elementos.get(Clave2).ObtenerValor());
                System.out.println("VECATOR->" + Clave2 + "<->valor2->" + Global.Elementos.get(Clave2).ObtenerValor());
                //entorno1.Elementos.get(Clave2).ModificarValor(entorno1.Elementos.get(Clave2).ObtenerValor(), entorno1.Elementos.get(Clave2).ObtenerTipo());
                entorno3.Elementos.put(Clave2,entorno1.Elementos.get(Clave2));
                String Textolista = Clave2;
                if(entorno3.ObtenerListaN(Clave2)==1 && entorno3.ObtenerTipo(Clave2).contains("Funcion")==false){
                    Textolista = Textolista  + ";" +  entorno3.ObtenerTipo(Clave2) ;
                    ejemploLista.add(Textolista);
                }
                
                System.out.println("VAMOS A VER QUE PEDO CON 3->" + entorno3.Elementos.get(Clave2).ObtenerValor());
            
            } 
          }
    
        return ejemploLista;
    }
    
    
     public ArrayList  ModificandoEntornosLista(Entorno entorno1,Entorno Global){
        	
        ArrayList<String> ejemploLista = new ArrayList<String>(); 
        Entorno entorno3 = new Entorno();
        Enumeration e = entorno1.Elementos.keys();
        Object clave;
        while( e.hasMoreElements() ) {
            clave = e.nextElement();
            String Clave2 = (String) clave;
            if(Global.Elementos.containsKey(Clave2)==true){
                System.out.println("Este Vector: " + Clave2 + " Si se agrega al Global(3x)" + "<->Valor->" + Global.Elementos.get(Clave2).ObtenerValor());
                System.out.println("VECATOR->" + Clave2 + "<->valor2->" + entorno1.Elementos.get(Clave2).ObtenerValor());
                System.out.println("VECATOR->" + Clave2 + "<->valor2->" + Global.Elementos.get(Clave2).ObtenerValor());
                //entorno1.Elementos.get(Clave2).ModificarValor(entorno1.Elementos.get(Clave2).ObtenerValor(), entorno1.Elementos.get(Clave2).ObtenerTipo());
                entorno3.Elementos.put(Clave2,entorno1.Elementos.get(Clave2));
                String Textolista = Clave2;
                if(entorno3.ObtenerListaN(Clave2)==0 && entorno3.ObtenerTipo(Clave2).contains("Funcion")==false){
                    Textolista = Textolista  + ";" +  entorno3.ObtenerValor(Clave2) + ";" + entorno3.ObtenerTipo(Clave2) ;
                    ejemploLista.add(Textolista);
                }
                
                System.out.println("VAMOS A VER QUE PEDO CON 3->" + entorno3.Elementos.get(Clave2).ObtenerValor());
            
            } 
          }
        return ejemploLista;
    }
    
    public void AgregarElementosANuevoEntorno(Entorno Global, Entorno nuevo){
        Enumeration e = Global.Elementos.keys();
        Object clave;
        while( e.hasMoreElements() ) {
            clave = e.nextElement();
            String Clave2 = (String) clave;
            Simbolo S = new Simbolo("1","1","1");
            nuevo.Elementos.put(Clave2, Global.Elementos.get(Clave2));
          }
    }
    
    
     public void MostrarVectoresLista(Entorno entorno,JTextArea salida){
       Enumeration e = Elementos.keys();
        Object clave;
        while( e.hasMoreElements() ) {
            clave = e.nextElement();
            String Clave2 = (String) clave;
            //!"VectorDragonBallBeatles".equals(Clave2)
            if(ObtenerListaN(Clave2) ==1 && !"VectorDragonBallBeatles".equals(Clave2)
               && !"VectorC2DeRomeo".equals(Clave2) && !"VectorC1DeRomeo".equals(Clave2)   && !"Funcion".equals(ObtenerTipo(Clave2))  ){ //
            ArrayList <NodoAbstracto> Lista =  ObtenerLista(clave.toString());
            String Valores = "";
            for(int i = 0; i < Lista.size();i++){
                String val1 = Lista.get(i).Ejecutar(entorno, salida);
                if(val1.contains("#Error")){
                    val1 = Lista.get(i).Hijos.get(0).Nombre;
                    Valores = Valores + val1 + ",";
                    continue;
                    
                }
               //System.out.println("hoaaaaaaaaaa->" + Lista.get(i).TipoDato + "->" +Lista.get(i).Nombre );
                if("id".equals(Lista.get(i).TipoDato)){
                    Valores = Valores + entorno.ObtenerValor(Lista.get(i).Nombre) + ",";
                }else{
                      Valores = Valores + val1 + ",";
                }
              
            }
            System.out.println( "Vector : " + clave + " Valor:" + Valores + " Tipo:" + ObtenerTipo(Clave2) + "<-Bo->" + Borrador(Clave2) +
                    "<-Total elementos->" + ObtenerLista(Clave2).size() );
            }
          }
    }
     
     
     
       public void MostrarVectoresFuncion(Entorno entorno,JTextArea salida){
       Enumeration e = Elementos.keys();
        Object clave;
        while( e.hasMoreElements() ) {
            clave = e.nextElement();
            String Clave2 = (String) clave;
            //!"VectorDragonBallBeatles".equals(Clave2)
            if(ObtenerTipo(Clave2).contains("Funcion")){ //
            ArrayList <NodoAbstracto> Lista =  ObtenerLista(clave.toString());
          
            System.out.println( "Vector : " + clave +  " Tipo:" + ObtenerTipo(Clave2) + "<-Bo->" + Borrador(Clave2) +
                    "<-Total elementos->" + ObtenerLista(Clave2).size() );
            }
          }
    }
       
      public void ModificandoValoresFuncion(String id, ArrayList <NodoAbstracto> Parametros,ArrayList <NodoAbstracto> Expresioens){
           if (Elementos.containsKey(id)) {
                System.out.println("-------------------------------------------------------------->MODIFICANDO VALORES F");
                Elementos.get(id).ModificarParametrosFuncion(Parametros);
                Elementos.get(id).ModificarExpresionesFuncion(Expresioens);
            }
        }
      
     
}
