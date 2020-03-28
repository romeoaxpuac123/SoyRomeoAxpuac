/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoASTCUP;

import static Analizadores.IDE.TABLA_DE_ERRORES_SINTACTICOS;
import Analizadores.TError;
import Codigo.Entorno;
import javax.swing.JTextArea;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Bayyron
 */
public class barras extends NodoAbstracto{

    public barras (String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String VectroNumeros = this.Hijos.get(0).Nombre;
        String NombreX = this.Hijos.get(1).Ejecutar(entorno, salida);
        String NombreY = this.Hijos.get(2).Ejecutar(entorno, salida);
        String Titulo = this.Hijos.get(3).Ejecutar(entorno, salida);
        String VectorDatos = this.Hijos.get(4).Nombre;
        
         if(this.Hijos.get(1).TipoDato.contains("id")){
           if(entorno.ExisteVector(NombreX)==false){
               salida.append("#ERROR: ERRORE EN UN PARAMETRO BARRAS\n");
            TError ERRORES = new TError("pie",this.linea,this.columna,"Semantico", "ERRORE EN UN PARAMETRO BARRAS"  );
            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
            return "#Error";
           }
           if(entorno.ObtenerListaN(NombreX)==0){
               NombreX = entorno.ObtenerValor(NombreX);
           }else{
               NombreX = entorno.ObtenerLista(NombreX).get(0).Ejecutar(entorno, salida);
           }
       }
        
        if(this.Hijos.get(2).TipoDato.contains("id")){
            if(entorno.ExisteVector(NombreY)==false){
               salida.append("#ERROR: ERRORE EN UN PARAMETRO BARRAS\n");
            TError ERRORES = new TError("pie",this.linea,this.columna,"Semantico", "ERRORE EN UN PARAMETRO BARRAS"  );
            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
            return "#Error";
           }
           if(entorno.ObtenerListaN(NombreY)==0){
               NombreY = entorno.ObtenerValor(NombreY);
           }else{
               NombreY = entorno.ObtenerLista(NombreY).get(0).Ejecutar(entorno, salida);
           }
       }
        
        if(this.Hijos.get(3).TipoDato.contains("id")){
            if(entorno.ExisteVector(Titulo)==false){
               salida.append("#ERROR: ERRORE EN UN PARAMETRO BARRAS\n");
            TError ERRORES = new TError("pie",this.linea,this.columna,"Semantico", "ERRORE EN UN PARAMETRO BARRAS"  );
            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
            return "#Error";
           }
           if(entorno.ObtenerListaN(Titulo)==0){
               Titulo = entorno.ObtenerValor(Titulo);
           }else{
               Titulo = entorno.ObtenerLista(Titulo).get(0).Ejecutar(entorno, salida);
           }
       }
        
        if(Titulo.equalsIgnoreCase("#Error") | NombreX.equalsIgnoreCase("#Error") | NombreY.equalsIgnoreCase("#Error") ){
             salida.append("#ERROR: ERRORE EN UN PARAMETRO BARRAS\n");
            TError ERRORES = new TError("pie",this.linea,this.columna,"Semantico", "ERRORE EN UN PARAMETRO BARRAS"  );
            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
            return "#Error";
        }
        System.out.println("VAMOS A GRAFICAR EL VECTOR:" + VectroNumeros);
        System.out.println("EJE X=" + NombreX);
        System.out.println("EJE Y=" + NombreY);
        System.out.println("TITULO GRAFICA:" + Titulo);
        System.out.println("NOMBRE COLUMNAS VECTOR:" + VectorDatos);
        String TipoVector1 = entorno.ObtenerTipo(VectroNumeros);
        this.Expresiones = entorno.ObtenerLista(VectroNumeros);
        this.Expresiones2 = entorno.ObtenerLista(VectorDatos);
        if((TipoVector1.contains("entero") || TipoVector1.contains("decimal"))
               && (this.Expresiones.size() == this.Expresiones2.size())){
                DefaultCategoryDataset ds = new DefaultCategoryDataset();
                for(int i = 0; i < this.Expresiones.size(); i ++){
                    //dataset.setValue(this.Expresiones2.get(i).Ejecutar(entorno, salida), Double.parseDouble(this.Expresiones2.get(i).Ejecutar(entorno, salida)));
                    String Lado2 = this.Expresiones2.get(i).Ejecutar(entorno, salida);
                    double Lado1 = Double.parseDouble(this.Expresiones.get(i).Ejecutar(entorno, salida));
                    System.out.println("bruja->" + Lado1 + "<->" + Lado2);
                    ds.addValue(Lado1, Lado2, "");
                    
                }
                JFreeChart jf = ChartFactory.createBarChart3D(Titulo, NombreX, NombreY, ds, PlotOrientation.VERTICAL, true, true, true);
                ChartFrame f = new ChartFrame(Titulo,jf);
                f.setSize(1000,600);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
        
        }else{
            salida.append("#ERROR: ERRORE EN UN PARAMETRO BARRAS\n");
            TError ERRORES = new TError("pie",this.linea,this.columna,"Semantico", "ERRORE EN UN PARAMETRO BARRAS"  );
            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
            return "#Error";
       }
        
        
        return "FIN BARRAS";
    }
}
