/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borradorproyecto1;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import CodigoASTCUP.*;
/**
 *
 * @author Bayyron
 */
public class Graficador 
{
    int contador;
    //Metodo para graficar un arbol
    public void graficarAST(NodoAbstracto raiz)
    {
        //Creo una carpeta en /home/usuario/SalidasDot, en donde va estar todo
        File folder = new File(System.getProperty("user.home") + File.separator +"SalidasDot");        
        if(!folder.exists())
            folder.mkdirs();
        
        //Rutas para el .dot y la imagen .png
        String ruta_dot = System.getProperty("user.home") + File.separator +"SalidasDot"+File.separator+"ast.dot"; 
        String ruta_png = System.getProperty("user.home") + File.separator +"SalidasDot"+File.separator+"ast.png"; 
        
        //Arma el contenido del .dot
        this.armar_Cuerpo_dot(raiz, ruta_dot);        
        
        //Genera el archivo .dot y su imagen .png
        this.crearGrafo(ruta_dot, ruta_png);
        System.out.println(ruta_dot);
        
        //Abre la imagen resultante .png
        this.autoAbrir(ruta_png);        
    }
        
    //Este metodo se puede usar para graficar cualquier grafo
    //debido a q solo necesita al ruta del dot y la ruta de la salida->imagen
    private void crearGrafo(String ruta_dot, String ruta_png)
    {
        String tParam = "-Tpng";    
        String tOParam = "-o";        
        
        String[] cmd = new String[5]; 
        
        //cmd[0]="dot"; para linux-unix
        //cmd[0]="dot.exe"; para windows
        //cmd[0]="dot"; para mac, creo
        cmd[0] = this.pametro_en_base_sistema_operativo();
        cmd[1] = tParam;    
        cmd[2] = ruta_dot;
        cmd[3] = tOParam;   
        cmd[4] = ruta_png;
        Runtime rt = Runtime.getRuntime();
        
        try 
        {
            //Hace la llamada al sistema y ejecuta la variable cmd
            rt.exec( cmd );                                    
        } 
        catch (IOException ex) 
        {Logger.getLogger(BorradorProyecto1.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
    //Este devuelve el parametro que va ha tener para generar la imagen
    //el parametro depende el sistema operativo
    private String pametro_en_base_sistema_operativo()
    {        
        String OS = System.getProperty("os.name").toLowerCase();		
        
        if (OS.contains("win"))
            return "dot.exe";
        else if (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0 )
            return "dot";
        else if (OS.contains("mac")) 
            return "/usr/local/bin/dot";
        else
            System.out.println("Saber :D");
        
        return "dot";
    }
    
    //Este metodo es generico
    //Por que abre un fichero, archivo, etc. en base a la ruta
    //Lo abre con el programa predeterminado por el sistema
    private void autoAbrir(String ruta)
    {
        try
        {
            File archivo = new File(ruta);
            if(archivo.exists())
            {
                Desktop.getDesktop().open(archivo);
            }
        }
        catch (IOException ex) 
        {Logger.getLogger(BorradorProyecto1.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
    //Este metodo es generico
    //Porque solo necesita un nodo para crear el .dot
    private void armar_Cuerpo_dot(NodoAbstracto raiz, String ruta_dot)
    {
        contador=0;
        StringBuffer buffer=new StringBuffer();
        buffer.append("\ndigraph G {\r\nnode [];\n");        
        this.listarNodos(raiz, buffer);
        this.enlazarNodos(raiz, buffer);        
        buffer.append("}");
        this.creararchivo(ruta_dot, buffer.toString());
    }
    
    //Este metodo es generico
    //Porque solo necesita un nodo para lista y generar una porcion
    //de lo que sera el fichero .dot
    private void listarNodos(NodoAbstracto praiz, StringBuffer buffer)
    {        
        //graphviz+="node"+contador+"[label=\""+praiz.valor+"\"];\n";
        buffer.append("node").append(contador).append("[label=\"").append(praiz.Nombre).append("\"];\n");
        praiz.id=contador;  contador++;        
        for(NodoAbstracto temp:praiz.Hijos)
        {
            listarNodos(temp,buffer);
        }
    }    
    
    //Este metodo es generico
    //Porque solo necesita un nodo para lista y generar una porcion
    //de lo que sera el fichero .dot
    private void enlazarNodos(NodoAbstracto praiz, StringBuffer bufffer)
    {        
        for(NodoAbstracto temp:praiz.Hijos)
        {            
            String relacion="\"node"+praiz.id+"\"->";
            relacion+="\"node"+temp.id+"\";\n";
            bufffer.append(relacion);
            enlazarNodos(temp, bufffer);
        }
    } 
    
    //Este metodo es generico
    //Porque crea un archivo plano en base a la ruta y el contenido que se le pase
    public synchronized void creararchivo(String pfichero,String pcontenido)
    {   
        FileWriter archivo = null;
   
        try{archivo = new FileWriter(pfichero);} 
        catch (IOException ex) 
        {Logger.getLogger(BorradorProyecto1.class.getName()).log(Level.SEVERE, null, ex);}

        File a = new File(pfichero);        
        if (!a.exists()){return;}   
        
        try(PrintWriter printwriter = new PrintWriter(archivo)) 
        {
            printwriter.print(pcontenido);
            printwriter.close();
        }
    }
}
