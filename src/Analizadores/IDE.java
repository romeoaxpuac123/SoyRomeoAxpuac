/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores;


import Codigo.Entorno;
import CodigoASTCUP.NodoAbstracto;
import borradorproyecto1.BorradorProyecto1;
import borradorproyecto1.Graficador;
import java.awt.Color;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
/**
 *
 * @author Bayyron
 */
public class IDE extends javax.swing.JFrame {

    /**
     * Creates new form IDE
     */
    public int TotalPestañas = 1;
    public static LinkedList<TError> TABLA_DE_ERRORES_SINTACTICOS = new LinkedList<TError>();
    public static LinkedList<ReporteTS> TABLA_ReporteTS = new LinkedList<ReporteTS>();
    public static String ElTipoDeAmbitoRomeo = "Global";
    public static int NumeroEntornosRomeo = 0;
    JFileChooser seleccionar1 = new JFileChooser();
    File Archivo; FileInputStream entrada; FileOutputStream salida;
    File Archivo1; 
    File Archivo2; 
    File Archivo3; 
    File Archivo4; 
    File Archivo5; 
    File Archivo6; 
    File Archivo7; 
    File Archivo8; 
    File Archivo9; 
    File Archivo10; 
    
    public IDE() {
        initComponents();
        this.getContentPane().setBackground(Color.black);
        jTabbedPane1.remove(jPanel21); //addTab("Ventana 1", panel1);
        jTabbedPane1.remove(jPanel22);
        jTabbedPane1.remove(jPanel23);
        jTabbedPane1.remove(jPanel24);
        jTabbedPane1.remove(jPanel25);
        jTabbedPane1.remove(jPanel26);
        jTabbedPane1.remove(jPanel27);
        jTabbedPane1.remove(jPanel28);
        jTabbedPane1.remove(jPanel29);
        jTabbedPane1.remove(jPanel30);
        jTabbedPane1.remove(jPanel31);
        jTabbedPane1.remove(jPanel32);
        jTabbedPane1.remove(jPanel33);
        jTabbedPane1.remove(jPanel34);
        jTabbedPane1.remove(jPanel35);
        jTabbedPane1.remove(jPanel36);
        jTabbedPane1.remove(jPanel37);
        jTabbedPane1.remove(jPanel38);
        jTabbedPane1.remove(jPanel39);
        //int currentCaretPosition = jTextArea1.getCaretPosition ();
       jTextArea1.addCaretListener(new CaretListener() {           
   
                public void caretUpdate(CaretEvent e) { 
                    JTextArea editArea = (JTextArea)e.getSource();
                    int linea = 1;
                    int columna = 1; 
                    try {
                      int caretpos = editArea.getCaretPosition();
                      linea= editArea.getLineOfOffset(caretpos);
                      columna = caretpos - editArea.getLineStartOffset(linea);
                      linea += 1;
                    } catch(Exception ex) { }
                    ///System.out.println("linea->" + linea + "Columa->" + columna);
                    jLabel2.setText("linea: " + linea + "   Columa:    " + columna);
                }
                 
       });
       //pestaña 2
       jTextArea3.addCaretListener(new CaretListener() {           
   
                public void caretUpdate(CaretEvent e) { 
                    JTextArea editArea = (JTextArea)e.getSource();
                    int linea = 1;
                    int columna = 1; 
                    try {
                      int caretpos = editArea.getCaretPosition();
                      linea= editArea.getLineOfOffset(caretpos);
                      columna = caretpos - editArea.getLineStartOffset(linea);
                      linea += 1;
                    } catch(Exception ex) { }
                    ///System.out.println("linea->" + linea + "Columa->" + columna);
                    jLabel2.setText("linea: " + linea + "   Columa:    " + columna);
                }
                 
       });
       //pestaña 3
       
        jTextArea4.addCaretListener(new CaretListener() {           
   
                public void caretUpdate(CaretEvent e) { 
                    JTextArea editArea = (JTextArea)e.getSource();
                    int linea = 1;
                    int columna = 1; 
                    try {
                      int caretpos = editArea.getCaretPosition();
                      linea= editArea.getLineOfOffset(caretpos);
                      columna = caretpos - editArea.getLineStartOffset(linea);
                      linea += 1;
                    } catch(Exception ex) { }
                    ///System.out.println("linea->" + linea + "Columa->" + columna);
                    jLabel2.setText("linea: " + linea + "   Columa:    " + columna);
                }
                 
       });
         //pestaña 4
       
        jTextArea5.addCaretListener(new CaretListener() {           
   
                public void caretUpdate(CaretEvent e) { 
                    JTextArea editArea = (JTextArea)e.getSource();
                    int linea = 1;
                    int columna = 1; 
                    try {
                      int caretpos = editArea.getCaretPosition();
                      linea= editArea.getLineOfOffset(caretpos);
                      columna = caretpos - editArea.getLineStartOffset(linea);
                      linea += 1;
                    } catch(Exception ex) { }
                    ///System.out.println("linea->" + linea + "Columa->" + columna);
                    jLabel2.setText("linea: " + linea + "   Columa:    " + columna);
                }
                 
       });
        //pestaña 5
       
        jTextArea6.addCaretListener(new CaretListener() {           
   
                public void caretUpdate(CaretEvent e) { 
                    JTextArea editArea = (JTextArea)e.getSource();
                    int linea = 1;
                    int columna = 1; 
                    try {
                      int caretpos = editArea.getCaretPosition();
                      linea= editArea.getLineOfOffset(caretpos);
                      columna = caretpos - editArea.getLineStartOffset(linea);
                      linea += 1;
                    } catch(Exception ex) { }
                    ///System.out.println("linea->" + linea + "Columa->" + columna);
                    jLabel2.setText("linea: " + linea + "   Columa:    " + columna);
                }
                 
       });
        
        //pestaña 6
       
        jTextArea7.addCaretListener(new CaretListener() {           
   
                public void caretUpdate(CaretEvent e) { 
                    JTextArea editArea = (JTextArea)e.getSource();
                    int linea = 1;
                    int columna = 1; 
                    try {
                      int caretpos = editArea.getCaretPosition();
                      linea= editArea.getLineOfOffset(caretpos);
                      columna = caretpos - editArea.getLineStartOffset(linea);
                      linea += 1;
                    } catch(Exception ex) { }
                    ///System.out.println("linea->" + linea + "Columa->" + columna);
                    jLabel2.setText("linea: " + linea + "   Columa:    " + columna);
                }
                 
       });
        
        //pestaña 7
       
        jTextArea8.addCaretListener(new CaretListener() {           
   
                public void caretUpdate(CaretEvent e) { 
                    JTextArea editArea = (JTextArea)e.getSource();
                    int linea = 1;
                    int columna = 1; 
                    try {
                      int caretpos = editArea.getCaretPosition();
                      linea= editArea.getLineOfOffset(caretpos);
                      columna = caretpos - editArea.getLineStartOffset(linea);
                      linea += 1;
                    } catch(Exception ex) { }
                    ///System.out.println("linea->" + linea + "Columa->" + columna);
                    jLabel2.setText("linea: " + linea + "   Columa:    " + columna);
                }
                 
       });
        
        
         //pestaña 8
       
        jTextArea11.addCaretListener(new CaretListener() {           
   
                public void caretUpdate(CaretEvent e) { 
                    JTextArea editArea = (JTextArea)e.getSource();
                    int linea = 1;
                    int columna = 1; 
                    try {
                      int caretpos = editArea.getCaretPosition();
                      linea= editArea.getLineOfOffset(caretpos);
                      columna = caretpos - editArea.getLineStartOffset(linea);
                      linea += 1;
                    } catch(Exception ex) { }
                    ///System.out.println("linea->" + linea + "Columa->" + columna);
                    jLabel2.setText("linea: " + linea + "   Columa:    " + columna);
                }
                 
       });
        
         //pestaña 9
       
        jTextArea12.addCaretListener(new CaretListener() {           
   
                public void caretUpdate(CaretEvent e) { 
                    JTextArea editArea = (JTextArea)e.getSource();
                    int linea = 1;
                    int columna = 1; 
                    try {
                      int caretpos = editArea.getCaretPosition();
                      linea= editArea.getLineOfOffset(caretpos);
                      columna = caretpos - editArea.getLineStartOffset(linea);
                      linea += 1;
                    } catch(Exception ex) { }
                    ///System.out.println("linea->" + linea + "Columa->" + columna);
                    jLabel2.setText("linea: " + linea + "   Columa:    " + columna);
                }
                 
       });
        
        
         //pestaña 10
       
        jTextArea13.addCaretListener(new CaretListener() {           
   
                public void caretUpdate(CaretEvent e) { 
                    JTextArea editArea = (JTextArea)e.getSource();
                    int linea = 1;
                    int columna = 1; 
                    try {
                      int caretpos = editArea.getCaretPosition();
                      linea= editArea.getLineOfOffset(caretpos);
                      columna = caretpos - editArea.getLineStartOffset(linea);
                      linea += 1;
                    } catch(Exception ex) { }
                    ///System.out.println("linea->" + linea + "Columa->" + columna);
                    jLabel2.setText("linea: " + linea + "   Columa:    " + columna);
                }
                 
       });
        
         //pestaña 11
       
        jTextArea14.addCaretListener(new CaretListener() {           
   
                public void caretUpdate(CaretEvent e) { 
                    JTextArea editArea = (JTextArea)e.getSource();
                    int linea = 1;
                    int columna = 1; 
                    try {
                      int caretpos = editArea.getCaretPosition();
                      linea= editArea.getLineOfOffset(caretpos);
                      columna = caretpos - editArea.getLineStartOffset(linea);
                      linea += 1;
                    } catch(Exception ex) { }
                    ///System.out.println("linea->" + linea + "Columa->" + columna);
                    jLabel2.setText("linea: " + linea + "   Columa:    " + columna);
                }
                 
       });
        
        
        
        
    }

     
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        jButton65 = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        jButton67 = new javax.swing.JButton();
        jButton68 = new javax.swing.JButton();
        jButton69 = new javax.swing.JButton();
        jButton70 = new javax.swing.JButton();
        jButton71 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextArea11 = new javax.swing.JTextArea();
        jButton92 = new javax.swing.JButton();
        jButton93 = new javax.swing.JButton();
        jButton94 = new javax.swing.JButton();
        jButton95 = new javax.swing.JButton();
        jButton96 = new javax.swing.JButton();
        jButton97 = new javax.swing.JButton();
        jButton98 = new javax.swing.JButton();
        jButton99 = new javax.swing.JButton();
        jButton100 = new javax.swing.JButton();
        jButton101 = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextArea12 = new javax.swing.JTextArea();
        jButton102 = new javax.swing.JButton();
        jButton103 = new javax.swing.JButton();
        jButton104 = new javax.swing.JButton();
        jButton105 = new javax.swing.JButton();
        jButton106 = new javax.swing.JButton();
        jButton107 = new javax.swing.JButton();
        jButton108 = new javax.swing.JButton();
        jButton109 = new javax.swing.JButton();
        jButton110 = new javax.swing.JButton();
        jButton111 = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTextArea13 = new javax.swing.JTextArea();
        jButton112 = new javax.swing.JButton();
        jButton113 = new javax.swing.JButton();
        jButton114 = new javax.swing.JButton();
        jButton115 = new javax.swing.JButton();
        jButton116 = new javax.swing.JButton();
        jButton117 = new javax.swing.JButton();
        jButton118 = new javax.swing.JButton();
        jButton119 = new javax.swing.JButton();
        jButton120 = new javax.swing.JButton();
        jButton121 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea14 = new javax.swing.JTextArea();
        jButton122 = new javax.swing.JButton();
        jButton123 = new javax.swing.JButton();
        jButton124 = new javax.swing.JButton();
        jButton125 = new javax.swing.JButton();
        jButton126 = new javax.swing.JButton();
        jButton127 = new javax.swing.JButton();
        jButton128 = new javax.swing.JButton();
        jButton129 = new javax.swing.JButton();
        jButton130 = new javax.swing.JButton();
        jButton131 = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextArea15 = new javax.swing.JTextArea();
        jButton132 = new javax.swing.JButton();
        jButton133 = new javax.swing.JButton();
        jButton134 = new javax.swing.JButton();
        jButton135 = new javax.swing.JButton();
        jButton136 = new javax.swing.JButton();
        jButton137 = new javax.swing.JButton();
        jButton138 = new javax.swing.JButton();
        jButton139 = new javax.swing.JButton();
        jButton140 = new javax.swing.JButton();
        jButton141 = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextArea16 = new javax.swing.JTextArea();
        jButton142 = new javax.swing.JButton();
        jButton143 = new javax.swing.JButton();
        jButton144 = new javax.swing.JButton();
        jButton145 = new javax.swing.JButton();
        jButton146 = new javax.swing.JButton();
        jButton147 = new javax.swing.JButton();
        jButton148 = new javax.swing.JButton();
        jButton149 = new javax.swing.JButton();
        jButton150 = new javax.swing.JButton();
        jButton151 = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.blue);

        jTextArea2.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea2.setColumns(20);
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTabbedPane1.setBackground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setForeground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setText("Grafica ASC");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Analizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Grafica DES");

        jButton5.setText("Tabla de Simbolos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Reporte Errores");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Abrir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Guardar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Guardar Como");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Graficas");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Cerrar Pestaña");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton9)
                        .addGap(20, 20, 20)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton11)))
                .addGap(79, 79, 79))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Inicio", jPanel1);

        jPanel21.setBackground(new java.awt.Color(0, 0, 0));

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jButton12.setText("Analizar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Abrir");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Guardar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("Grafica ASC");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Grafica DES");

        jButton17.setText("Guardar Como");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("Tabla de Simbolos");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("Graficas");

        jButton20.setText("Reporte Errores");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setText("Cerrar Pestaña");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane3)
                        .addGroup(jPanel21Layout.createSequentialGroup()
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton20)))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton17)
                        .addGap(20, 20, 20)
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton21)))
                .addGap(79, 79, 79))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab2", jPanel21);

        jPanel22.setBackground(new java.awt.Color(0, 0, 0));

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        jButton22.setText("Analizar");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setText("Abrir");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setText("Guardar");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setText("Grafica ASC");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setText("Grafica DES");

        jButton27.setText("Guardar Como");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setText("Tabla de Simbolos");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setText("Graficas");

        jButton30.setText("Reporte Errores");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setText("Cerrar Pestaña");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane4)
                        .addGroup(jPanel22Layout.createSequentialGroup()
                            .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton30)))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton27)
                        .addGap(20, 20, 20)
                        .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton31)))
                .addGap(79, 79, 79))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab3", jPanel22);

        jPanel23.setBackground(new java.awt.Color(0, 0, 0));

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane5.setViewportView(jTextArea5);

        jButton32.setText("Analizar");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setText("Abrir");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton34.setText("Guardar");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton35.setText("Grafica ASC");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton36.setText("Grafica DES");

        jButton37.setText("Guardar Como");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jButton38.setText("Tabla de Simbolos");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton39.setText("Graficas");

        jButton40.setText("Reporte Errores");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jButton41.setText("Cerrar Pestaña");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane5)
                        .addGroup(jPanel23Layout.createSequentialGroup()
                            .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton40)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton37)
                        .addGap(20, 20, 20)
                        .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton41)))
                .addGap(79, 79, 79))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton33, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab4", jPanel23);

        jPanel24.setBackground(new java.awt.Color(0, 0, 0));

        jTextArea6.setColumns(20);
        jTextArea6.setRows(5);
        jScrollPane6.setViewportView(jTextArea6);

        jButton42.setText("Analizar");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jButton43.setText("Abrir");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jButton44.setText("Guardar");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jButton45.setText("Grafica ASC");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        jButton46.setText("Grafica DES");

        jButton47.setText("Guardar Como");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jButton48.setText("Tabla de Simbolos");
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        jButton49.setText("Graficas");

        jButton50.setText("Reporte Errores");
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        jButton51.setText("Cerrar Pestaña");
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane6)
                        .addGroup(jPanel24Layout.createSequentialGroup()
                            .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton50)))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton47)
                        .addGap(20, 20, 20)
                        .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton51)))
                .addGap(79, 79, 79))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton43, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab5", jPanel24);

        jPanel25.setBackground(new java.awt.Color(0, 0, 0));

        jTextArea7.setColumns(20);
        jTextArea7.setRows(5);
        jScrollPane7.setViewportView(jTextArea7);

        jButton52.setText("Analizar");
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });

        jButton53.setText("Abrir");
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });

        jButton54.setText("Guardar");
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });

        jButton55.setText("Grafica ASC");
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });

        jButton56.setText("Grafica DES");

        jButton57.setText("Guardar Como");
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });

        jButton58.setText("Tabla de Simbolos");
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });

        jButton59.setText("Graficas");

        jButton60.setText("Reporte Errores");
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });

        jButton61.setText("Cerrar Pestaña");
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane7)
                        .addGroup(jPanel25Layout.createSequentialGroup()
                            .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton60)))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton57)
                        .addGap(20, 20, 20)
                        .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton61)))
                .addGap(79, 79, 79))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton53, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab6", jPanel25);

        jPanel26.setBackground(new java.awt.Color(0, 0, 0));

        jTextArea8.setColumns(20);
        jTextArea8.setRows(5);
        jScrollPane8.setViewportView(jTextArea8);

        jButton62.setText("Analizar");
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton62ActionPerformed(evt);
            }
        });

        jButton63.setText("Abrir");
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton63ActionPerformed(evt);
            }
        });

        jButton64.setText("Guardar");
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton64ActionPerformed(evt);
            }
        });

        jButton65.setText("Grafica ASC");
        jButton65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton65ActionPerformed(evt);
            }
        });

        jButton66.setText("Grafica DES");

        jButton67.setText("Guardar Como");
        jButton67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton67ActionPerformed(evt);
            }
        });

        jButton68.setText("Tabla de Simbolos");
        jButton68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton68ActionPerformed(evt);
            }
        });

        jButton69.setText("Graficas");

        jButton70.setText("Reporte Errores");
        jButton70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton70ActionPerformed(evt);
            }
        });

        jButton71.setText("Cerrar Pestaña");
        jButton71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton71ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane8)
                        .addGroup(jPanel26Layout.createSequentialGroup()
                            .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton65, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton66, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton68, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton70)))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jButton63, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton67)
                        .addGap(20, 20, 20)
                        .addComponent(jButton69, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton71)))
                .addGap(79, 79, 79))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton70, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton68, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton63, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab7", jPanel26);

        jPanel27.setBackground(new java.awt.Color(0, 0, 0));

        jTextArea11.setColumns(20);
        jTextArea11.setRows(5);
        jScrollPane11.setViewportView(jTextArea11);

        jButton92.setText("Analizar");
        jButton92.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton92ActionPerformed(evt);
            }
        });

        jButton93.setText("Abrir");
        jButton93.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton93ActionPerformed(evt);
            }
        });

        jButton94.setText("Guardar");
        jButton94.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton94ActionPerformed(evt);
            }
        });

        jButton95.setText("Grafica ASC");
        jButton95.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton95ActionPerformed(evt);
            }
        });

        jButton96.setText("Grafica DES");

        jButton97.setText("Guardar Como");
        jButton97.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton97ActionPerformed(evt);
            }
        });

        jButton98.setText("Graficas");

        jButton99.setText("Tabla de Simbolos");
        jButton99.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton99ActionPerformed(evt);
            }
        });

        jButton100.setText("Reporte Errores");
        jButton100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton100ActionPerformed(evt);
            }
        });

        jButton101.setText("Cerrar Pestaña");
        jButton101.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton101ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane11)
                        .addGroup(jPanel27Layout.createSequentialGroup()
                            .addComponent(jButton92, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton95, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton96, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton99, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton100)))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jButton93, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton94, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton97)
                        .addGap(20, 20, 20)
                        .addComponent(jButton98, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton101)))
                .addGap(79, 79, 79))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton92, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton100, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton99, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton93, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton94, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton97, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton98, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab8", jPanel27);

        jPanel28.setBackground(new java.awt.Color(0, 0, 0));

        jTextArea12.setColumns(20);
        jTextArea12.setRows(5);
        jScrollPane12.setViewportView(jTextArea12);

        jButton102.setText("Analizar");
        jButton102.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton102ActionPerformed(evt);
            }
        });

        jButton103.setText("Abrir");
        jButton103.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton103ActionPerformed(evt);
            }
        });

        jButton104.setText("Guardar");
        jButton104.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton104ActionPerformed(evt);
            }
        });

        jButton105.setText("Grafica ASC");
        jButton105.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton105ActionPerformed(evt);
            }
        });

        jButton106.setText("Grafica DES");

        jButton107.setText("Guardar Como");
        jButton107.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton107ActionPerformed(evt);
            }
        });

        jButton108.setText("Graficas");

        jButton109.setText("Tabla de Simbolos");
        jButton109.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton109ActionPerformed(evt);
            }
        });

        jButton110.setText("Reporte Errores");
        jButton110.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton110ActionPerformed(evt);
            }
        });

        jButton111.setText("Cerrar Pestaña");
        jButton111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton111ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane12)
                        .addGroup(jPanel28Layout.createSequentialGroup()
                            .addComponent(jButton102, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton105, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton106, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton109, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton110)))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jButton103, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton104, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton107)
                        .addGap(20, 20, 20)
                        .addComponent(jButton108, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton111)))
                .addGap(79, 79, 79))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton102, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton106, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton110, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton109, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton103, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton108, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab9", jPanel28);

        jPanel29.setBackground(new java.awt.Color(0, 0, 0));

        jTextArea13.setColumns(20);
        jTextArea13.setRows(5);
        jScrollPane13.setViewportView(jTextArea13);

        jButton112.setText("Analizar");
        jButton112.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton112ActionPerformed(evt);
            }
        });

        jButton113.setText("Abrir");
        jButton113.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton113ActionPerformed(evt);
            }
        });

        jButton114.setText("Guardar");
        jButton114.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton114ActionPerformed(evt);
            }
        });

        jButton115.setText("Grafica ASC");
        jButton115.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton115ActionPerformed(evt);
            }
        });

        jButton116.setText("Grafica DES");

        jButton117.setText("Guardar Como");
        jButton117.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton117ActionPerformed(evt);
            }
        });

        jButton118.setText("Graficas");

        jButton119.setText("Tabla de Simbolos");
        jButton119.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton119ActionPerformed(evt);
            }
        });

        jButton120.setText("Reporte Errores");
        jButton120.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton120ActionPerformed(evt);
            }
        });

        jButton121.setText("Cerrar Pestaña");
        jButton121.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton121ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane13)
                        .addGroup(jPanel29Layout.createSequentialGroup()
                            .addComponent(jButton112, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton115, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton116, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton119, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton120)))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jButton113, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton114, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton117)
                        .addGap(20, 20, 20)
                        .addComponent(jButton118, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton121)))
                .addGap(79, 79, 79))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton115, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton116, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton120, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton119, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton113, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton114, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton117, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton118, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton121, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab10", jPanel29);

        jPanel30.setBackground(new java.awt.Color(0, 0, 0));

        jTextArea14.setColumns(20);
        jTextArea14.setRows(5);
        jScrollPane14.setViewportView(jTextArea14);

        jButton122.setText("Analizar");
        jButton122.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton122ActionPerformed(evt);
            }
        });

        jButton123.setText("Abrir");
        jButton123.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton123ActionPerformed(evt);
            }
        });

        jButton124.setText("Guardar");
        jButton124.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton124ActionPerformed(evt);
            }
        });

        jButton125.setText("Grafica ASC");
        jButton125.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton125ActionPerformed(evt);
            }
        });

        jButton126.setText("Grafica DES");

        jButton127.setText("Guardar Como");
        jButton127.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton127ActionPerformed(evt);
            }
        });

        jButton128.setText("Graficas");
        jButton128.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton128ActionPerformed(evt);
            }
        });

        jButton129.setText("Tabla de Simbolos");
        jButton129.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton129ActionPerformed(evt);
            }
        });

        jButton130.setText("Reporte Errores");
        jButton130.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton130ActionPerformed(evt);
            }
        });

        jButton131.setText("Cerrar Pestaña");
        jButton131.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton131ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane14)
                        .addGroup(jPanel30Layout.createSequentialGroup()
                            .addComponent(jButton122, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton125, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton126, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton129, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton130)))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jButton123, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton124, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton127)
                        .addGap(20, 20, 20)
                        .addComponent(jButton128, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton131)))
                .addGap(79, 79, 79))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton125, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton122, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton126, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton130, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton129, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton123, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton124, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton127, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton128, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton131, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab11", jPanel30);

        jPanel31.setBackground(new java.awt.Color(0, 0, 0));

        jTextArea15.setColumns(20);
        jTextArea15.setRows(5);
        jScrollPane15.setViewportView(jTextArea15);

        jButton132.setText("Analizar");
        jButton132.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton132ActionPerformed(evt);
            }
        });

        jButton133.setText("Abrir");

        jButton134.setText("Guardar");

        jButton135.setText("Grafica ASC");
        jButton135.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton135ActionPerformed(evt);
            }
        });

        jButton136.setText("Grafica DES");

        jButton137.setText("Guardar Como");

        jButton138.setText("Graficas");

        jButton139.setText("Tabla de Simbolos");

        jButton140.setText("Reporte Errores");
        jButton140.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton140ActionPerformed(evt);
            }
        });

        jButton141.setText("Cerrar Pestaña");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane15)
                        .addGroup(jPanel31Layout.createSequentialGroup()
                            .addComponent(jButton132, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton135, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton136, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton139, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton140)))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jButton133, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton134, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton137)
                        .addGap(20, 20, 20)
                        .addComponent(jButton138, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton141)))
                .addGap(79, 79, 79))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton135, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton132, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton136, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton140, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton139, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton133, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton134, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton137, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton138, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton141, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab12", jPanel31);

        jPanel32.setBackground(new java.awt.Color(0, 0, 0));

        jTextArea16.setColumns(20);
        jTextArea16.setRows(5);
        jScrollPane16.setViewportView(jTextArea16);

        jButton142.setText("Analizar");
        jButton142.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton142ActionPerformed(evt);
            }
        });

        jButton143.setText("Abrir");

        jButton144.setText("Guardar");

        jButton145.setText("Grafica ASC");
        jButton145.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton145ActionPerformed(evt);
            }
        });

        jButton146.setText("Grafica DES");

        jButton147.setText("Guardar Como");

        jButton148.setText("Graficas");

        jButton149.setText("Tabla de Simbolos");

        jButton150.setText("Reporte Errores");
        jButton150.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton150ActionPerformed(evt);
            }
        });

        jButton151.setText("Cerrar Pestaña");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane16)
                        .addGroup(jPanel32Layout.createSequentialGroup()
                            .addComponent(jButton142, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton145, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton146, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton149, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton150)))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jButton143, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton144, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton147)
                        .addGap(20, 20, 20)
                        .addComponent(jButton148, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton151)))
                .addGap(79, 79, 79))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton145, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton142, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton146, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton150, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton149, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton143, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton144, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton147, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton148, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton151, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab13", jPanel32);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab14", jPanel33);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab15", jPanel34);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab16", jPanel35);

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab17", jPanel36);

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab18", jPanel37);

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab19", jPanel38);

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab20", jPanel39);

        jButton3.setText("Añadir Pestaña");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TABLA_DE_ERRORES_SINTACTICOS.clear();
        NumeroEntornosRomeo = 0;
        TABLA_ReporteTS.clear();
        
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter("3d.txt"));
             bw.write("");
             bw.close();
        } catch (IOException ex) {
            Logger.getLogger(IDE.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        jTextArea2.setText("");
        // RepasoCompi2 Hola = new RepasoCompi2();
       
       
        
        
        
        Analizar(jTextArea1.getText(), jTextArea2);
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // jTextArea2.setText("");
        //RepasoCompi2 Hola = new RepasoCompi2();
       Analizar2(jTextArea1.getText(), jTextArea2);
    }//GEN-LAST:event_jButton2ActionPerformed

   public String AbrirArchivo(File Archivo){
       String Documento = "";
        try{
            entrada = new FileInputStream(Archivo);
            int ascii;
            while((ascii = entrada.read())!=-1){
                char caracter  = (char)ascii;
                Documento+=caracter;
            }
        }catch(Exception e){
    
        }
        return Documento;
   }
 
   public String GuardarArchivo(File Archivo, String documento){
       String mensaje = null;
       try{
           salida = new FileOutputStream(Archivo);
           byte[] bytxt = documento.getBytes();
           salida.write(bytxt);
           mensaje = "Archivo Guardado";
       }catch(Exception e){
       
       }
       return mensaje;
   }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        switch (TotalPestañas) {
            case 1:
                jTabbedPane1.addTab("Ventana 1", jPanel21);
                TotalPestañas++;
                //jTabbedPane1.add(panel1);
                break;
            case 2:
                jTabbedPane1.addTab("Ventana 2", jPanel22);
                TotalPestañas++;
                break;
            case 3:
                 jTabbedPane1.addTab("Ventana 3", jPanel23);
                TotalPestañas++;
                break;
            case 4:
                jTabbedPane1.addTab("Ventana 4", jPanel24);
                TotalPestañas++;
                break;
            case 5:
                jTabbedPane1.addTab("Ventana 5", jPanel25);
                TotalPestañas++;
                break;
            case 6:
                jTabbedPane1.addTab("Ventana 6", jPanel26);
                TotalPestañas++;
                break;
            case 7:
                jTabbedPane1.addTab("Ventana 7", jPanel27);
                TotalPestañas++;
                break;
             case 8:
                jTabbedPane1.addTab("Ventana 8", jPanel28);
                TotalPestañas++;
                break;
            case 9:
                jTabbedPane1.addTab("Ventana 9", jPanel29);
                TotalPestañas++;
                break;
            case 10:
                jTabbedPane1.addTab("Ventana 10", jPanel30);
                TotalPestañas++;
                break;
          
            default:
                JOptionPane.showMessageDialog(null, "Ha Sobrepasado la cantidad de Pesañas");
                break;
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
       System.out.println("REPORTE DE ERROES:");
       
        for(int i = 0;i< TABLA_DE_ERRORES_SINTACTICOS.size(); i++){
            String Error = TABLA_DE_ERRORES_SINTACTICOS.get(i).lexema;
            String Tipo = TABLA_DE_ERRORES_SINTACTICOS.get(i).tipo;
            int columna = TABLA_DE_ERRORES_SINTACTICOS.get(i).columna;
            int fila = TABLA_DE_ERRORES_SINTACTICOS.get(i).linea;
            String Descripcion = TABLA_DE_ERRORES_SINTACTICOS.get(i).descripcion;
            System.out.println(i+1 + " | " +Tipo + " |" + Descripcion + " " + " | "  + columna + " | " + fila );
            
        }
        CrearReporteErrores();
        TABLA_DE_ERRORES_SINTACTICOS.clear();
        
    }//GEN-LAST:event_jButton6ActionPerformed
    public void CrearReporteTS(){
        String cad = "REPORTE TABLA DE SIMBOLOS";
       
        FileWriter filewriter = null;
        PrintWriter printw = null;
       
       try{
        filewriter = new FileWriter("Reporte_TS.html");//declarar el archivo
        printw = new PrintWriter(filewriter);//declarar un impresor

        printw.println("<html>");
        printw.println("<head><title>by Romeo Axpuac</title></head>");    
        //si queremos escribir una comilla " en el
        //archivo uzamos la diagonal invertida \"
        printw.println("<body bgcolor=\"#99CC99\">");

        //si quisieramos escribir una cadena que vide de una lista o
        //de una variable lo concatenamos
        printw.println("<center><h1><font color=\"navy\">"+cad+"</font></h1></center>");
        printw.println("<center><h4><font color=\"purple\">Organizacion de Lenguajes y Compiladores 2</font></h4></center>");
        printw.println("<center><table><tr>\n" +
                        "  <td WIDTH=\"80\" HEIGHT=\"50\"><strong>Numero</strong></td>\n" +
                        "  <td WIDTH=\"180\" HEIGHT=\"50\"><strong>Lexema</strong></td>\n" +
                        "  <td WIDTH=\"180\" HEIGHT=\"50\"><strong>Tipo</strong></td>\n" +
                        "  <td WIDTH=\"140\" HEIGHT=\"50\"><strong>Entorno</strong></td>\n" +
                        "  <td WIDTH=\"80\" HEIGHT=\"50\"><strong>Fila</strong></td>\n" +
                        "  <td WIDTH=\"80\" HEIGHT=\"50\"><strong>Columna</strong></td>\n" +
                        "</tr>\n");
        // creando contendo de la tabla
        for(int i = 0;i< TABLA_ReporteTS.size(); i++){
            String Error = TABLA_ReporteTS.get(i).lexema;
            String Tipo = TABLA_ReporteTS.get(i).tipo;
            int columna = TABLA_ReporteTS.get(i).columna;
            int fila = TABLA_ReporteTS.get(i).linea +1;
            String Descripcion = TABLA_ReporteTS.get(i).entorno;
            printw.println("<tr>\n" +
                        "  <td WIDTH=\"80\" HEIGHT=\"50\"><strong>"+(i+1)+"</strong></td>\n" +
                         "  <td WIDTH=\"180\" HEIGHT=\"50\"><strong>"+Error+"</strong></td>\n" +
                        "  <td WIDTH=\"180\" HEIGHT=\"50\"><strong>"+Tipo+"</strong></td>\n" +
                        "  <td WIDTH=\"140\" HEIGHT=\"50\"><strong>"+Descripcion+"</strong></td>\n" +
                        "  <td WIDTH=\"80\" HEIGHT=\"50\"><strong>"+fila+"</strong></td>\n" +
                        "  <td WIDTH=\"80\" HEIGHT=\"50\"><strong>"+columna+"</strong></td>\n" +
                        "</tr>\n");

            //System.out.println(i+1 + " | " +Tipo + " |" + Descripcion + " " + " | "  + columna + " | " + fila );
            //CrearReporteErrores();
        }
        
        
        printw.println("</table></center>\n");
        //podemos añadir imagenes con codigo html
        //printw.println("<center><img src=\"img/www.losiej.blogspot.com.png\" width=\"200\" height=\"150\"></center>");

        printw.println("</body>");
        printw.println("</html>");

        //no devemos olvidar cerrar el archivo para que su lectura sea correcta
        printw.close();//cerramos el archivo

        System.out.println("Generado exitosamente");//si todo sale bien mostramos un mensaje de guardado exitoso
        this.autoAbrir("Reporte_TS.html");
       }catch(Exception e){

       }
    }
    
    
    public void CrearReporteErrores(){
        String cad = "REPORTE DE ERRORES";
       
        FileWriter filewriter = null;
        PrintWriter printw = null;
       
       try{
        filewriter = new FileWriter("Reporte_Errores.html");//declarar el archivo
        printw = new PrintWriter(filewriter);//declarar un impresor

        printw.println("<html>");
        printw.println("<head><title>by Romeo Axpuac</title></head>");    
        //si queremos escribir una comilla " en el
        //archivo uzamos la diagonal invertida \"
        printw.println("<body bgcolor=\"#99CC99\">");

        //si quisieramos escribir una cadena que vide de una lista o
        //de una variable lo concatenamos
        printw.println("<center><h1><font color=\"navy\">"+cad+"</font></h1></center>");
        printw.println("<center><h4><font color=\"purple\">Organizacion de Lenguajes y Compiladores 2</font></h4></center>");
        printw.println("<center><table><tr>\n" +
                        "  <td WIDTH=\"80\" HEIGHT=\"50\"><strong>Numero</strong></td>\n" +
                        "  <td WIDTH=\"80\" HEIGHT=\"50\"><strong>Tipo</strong></td>\n" +
                        "  <td WIDTH=\"370\" HEIGHT=\"50\"><strong>Descripcion</strong></td>\n" +
                        "  <td WIDTH=\"80\" HEIGHT=\"50\"><strong>Fila</strong></td>\n" +
                        "  <td WIDTH=\"80\" HEIGHT=\"50\"><strong>Columna</strong></td>\n" +
                        "</tr>\n");
        // creando contendo de la tabla
        for(int i = 0;i< TABLA_DE_ERRORES_SINTACTICOS.size(); i++){
            String Error = TABLA_DE_ERRORES_SINTACTICOS.get(i).lexema;
            String Tipo = TABLA_DE_ERRORES_SINTACTICOS.get(i).tipo;
            int columna = TABLA_DE_ERRORES_SINTACTICOS.get(i).columna;
            int fila = TABLA_DE_ERRORES_SINTACTICOS.get(i).linea +1;
            String Descripcion = TABLA_DE_ERRORES_SINTACTICOS.get(i).descripcion;
            printw.println("<tr>\n" +
                        "  <td WIDTH=\"80\" HEIGHT=\"50\"><strong>"+(i+1)+"</strong></td>\n" +
                        "  <td WIDTH=\"80\" HEIGHT=\"50\"><strong>"+Tipo+"</strong></td>\n" +
                        "  <td WIDTH=\"370\" HEIGHT=\"50\"><strong>"+Descripcion+"</strong></td>\n" +
                        "  <td WIDTH=\"80\" HEIGHT=\"50\"><strong>"+fila+"</strong></td>\n" +
                        "  <td WIDTH=\"80\" HEIGHT=\"50\"><strong>"+columna+"</strong></td>\n" +
                        "</tr>\n");

            //System.out.println(i+1 + " | " +Tipo + " |" + Descripcion + " " + " | "  + columna + " | " + fila );
            //CrearReporteErrores();
        }
        
        
        printw.println("</table></center>\n");
        //podemos añadir imagenes con codigo html
        //printw.println("<center><img src=\"img/www.losiej.blogspot.com.png\" width=\"200\" height=\"150\"></center>");

        printw.println("</body>");
        printw.println("</html>");

        //no devemos olvidar cerrar el archivo para que su lectura sea correcta
        printw.close();//cerramos el archivo

        System.out.println("Generado exitosamente");//si todo sale bien mostramos un mensaje de guardado exitoso
        this.autoAbrir("Reporte_Errores.html");
       }catch(Exception e){

       }
    
    }
    
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
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
         TABLA_DE_ERRORES_SINTACTICOS.clear();
        NumeroEntornosRomeo = 0;
        TABLA_ReporteTS.clear();
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter("3d.txt"));
             bw.write("");
             bw.close();
        } catch (IOException ex) {
            Logger.getLogger(IDE.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        jTextArea2.setText("");
       // RepasoCompi2 Hola = new RepasoCompi2();
        Analizar(jTextArea3.getText(), jTextArea2);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        Analizar2(jTextArea3.getText(), jTextArea2);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
         System.out.println("REPORTE DE ERROES:");
        for(int i = 0;i< TABLA_DE_ERRORES_SINTACTICOS.size(); i++){
            String Error = TABLA_DE_ERRORES_SINTACTICOS.get(i).lexema;
            String Tipo = TABLA_DE_ERRORES_SINTACTICOS.get(i).tipo;
            int columna = TABLA_DE_ERRORES_SINTACTICOS.get(i).columna;
            int fila = TABLA_DE_ERRORES_SINTACTICOS.get(i).linea;
            String Descripcion = TABLA_DE_ERRORES_SINTACTICOS.get(i).descripcion;
            System.out.println(i+1 + " | " +Tipo + " |" + Descripcion + " " + " | "  + columna + " | " + fila );
            
        }
        CrearReporteErrores();
        TABLA_DE_ERRORES_SINTACTICOS.clear();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        TABLA_DE_ERRORES_SINTACTICOS.clear();
        NumeroEntornosRomeo = 0;
        TABLA_ReporteTS.clear();
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter("3d.txt"));
             bw.write("");
             bw.close();
        } catch (IOException ex) {
            Logger.getLogger(IDE.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        jTextArea2.setText("");
       // RepasoCompi2 Hola = new RepasoCompi2();
        Analizar(jTextArea4.getText(), jTextArea2);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        Analizar2(jTextArea4.getText(), jTextArea2);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
         System.out.println("REPORTE DE ERROES:");
        for(int i = 0;i< TABLA_DE_ERRORES_SINTACTICOS.size(); i++){
            String Error = TABLA_DE_ERRORES_SINTACTICOS.get(i).lexema;
            String Tipo = TABLA_DE_ERRORES_SINTACTICOS.get(i).tipo;
            int columna = TABLA_DE_ERRORES_SINTACTICOS.get(i).columna;
            int fila = TABLA_DE_ERRORES_SINTACTICOS.get(i).linea;
            String Descripcion = TABLA_DE_ERRORES_SINTACTICOS.get(i).descripcion;
            System.out.println(i+1 + " | " +Tipo + " |" + Descripcion + " " + " | "  + columna + " | " + fila );
            
        }
        CrearReporteErrores();
        TABLA_DE_ERRORES_SINTACTICOS.clear();
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        // TODO add your handling code here:
       TABLA_DE_ERRORES_SINTACTICOS.clear();
        NumeroEntornosRomeo = 0;
        TABLA_ReporteTS.clear();
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter("3d.txt"));
             bw.write("");
             bw.close();
        } catch (IOException ex) {
            Logger.getLogger(IDE.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        jTextArea2.setText("");
       // RepasoCompi2 Hola = new RepasoCompi2();
        Analizar(jTextArea5.getText(), jTextArea2);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        // TODO add your handling code here:
         Analizar2(jTextArea5.getText(), jTextArea2);
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        // TODO add your handling code here:
         System.out.println("REPORTE DE ERROES:");
        for(int i = 0;i< TABLA_DE_ERRORES_SINTACTICOS.size(); i++){
            String Error = TABLA_DE_ERRORES_SINTACTICOS.get(i).lexema;
            String Tipo = TABLA_DE_ERRORES_SINTACTICOS.get(i).tipo;
            int columna = TABLA_DE_ERRORES_SINTACTICOS.get(i).columna;
            int fila = TABLA_DE_ERRORES_SINTACTICOS.get(i).linea;
            String Descripcion = TABLA_DE_ERRORES_SINTACTICOS.get(i).descripcion;
            System.out.println(i+1 + " | " +Tipo + " |" + Descripcion + " " + " | "  + columna + " | " + fila );
         
        }
           CrearReporteErrores();
           TABLA_DE_ERRORES_SINTACTICOS.clear();
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
         TABLA_DE_ERRORES_SINTACTICOS.clear();
        NumeroEntornosRomeo = 0;
        TABLA_ReporteTS.clear();
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter("3d.txt"));
             bw.write("");
             bw.close();
        } catch (IOException ex) {
            Logger.getLogger(IDE.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        jTextArea2.setText("");
       // RepasoCompi2 Hola = new RepasoCompi2();
        Analizar(jTextArea6.getText(), jTextArea2);
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        // TODO add your handling code here:
        Analizar2(jTextArea6.getText(), jTextArea2);
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        // TODO add your handling code here:
         System.out.println("REPORTE DE ERROES:");
        for(int i = 0;i< TABLA_DE_ERRORES_SINTACTICOS.size(); i++){
            String Error = TABLA_DE_ERRORES_SINTACTICOS.get(i).lexema;
            String Tipo = TABLA_DE_ERRORES_SINTACTICOS.get(i).tipo;
            int columna = TABLA_DE_ERRORES_SINTACTICOS.get(i).columna;
            int fila = TABLA_DE_ERRORES_SINTACTICOS.get(i).linea;
            String Descripcion = TABLA_DE_ERRORES_SINTACTICOS.get(i).descripcion;
            System.out.println(i+1 + " | " +Tipo + " |" + Descripcion + " " + " | "  + columna + " | " + fila );
            
        }
        CrearReporteErrores();
        TABLA_DE_ERRORES_SINTACTICOS.clear();
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        // TODO add your handling code here:
         TABLA_DE_ERRORES_SINTACTICOS.clear();
        NumeroEntornosRomeo = 0;
        TABLA_ReporteTS.clear();
         BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter("3d.txt"));
             bw.write("");
             bw.close();
        } catch (IOException ex) {
            Logger.getLogger(IDE.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        jTextArea2.setText("");
       // RepasoCompi2 Hola = new RepasoCompi2();
        Analizar(jTextArea7.getText(), jTextArea2);
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        // TODO add your handling code here:
          Analizar2(jTextArea7.getText(), jTextArea2);
    }//GEN-LAST:event_jButton55ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        // TODO add your handling code here:
         System.out.println("REPORTE DE ERROES:");
        for(int i = 0;i< TABLA_DE_ERRORES_SINTACTICOS.size(); i++){
            String Error = TABLA_DE_ERRORES_SINTACTICOS.get(i).lexema;
            String Tipo = TABLA_DE_ERRORES_SINTACTICOS.get(i).tipo;
            int columna = TABLA_DE_ERRORES_SINTACTICOS.get(i).columna;
            int fila = TABLA_DE_ERRORES_SINTACTICOS.get(i).linea;
            String Descripcion = TABLA_DE_ERRORES_SINTACTICOS.get(i).descripcion;
            System.out.println(i+1 + " | " +Tipo + " |" + Descripcion + " " + " | "  + columna + " | " + fila );
            
            
        }
        CrearReporteErrores();
        TABLA_DE_ERRORES_SINTACTICOS.clear();
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        // TODO add your handling code here:
         TABLA_DE_ERRORES_SINTACTICOS.clear();
        NumeroEntornosRomeo = 0;
        TABLA_ReporteTS.clear();
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter("3d.txt"));
             bw.write("");
             bw.close();
        } catch (IOException ex) {
            Logger.getLogger(IDE.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        jTextArea2.setText("");
       // RepasoCompi2 Hola = new RepasoCompi2();
        Analizar(jTextArea8.getText(), jTextArea2);
    }//GEN-LAST:event_jButton62ActionPerformed

    private void jButton65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton65ActionPerformed
        // TODO add your handling code here:
        Analizar2(jTextArea8.getText(), jTextArea2);
    }//GEN-LAST:event_jButton65ActionPerformed

    private void jButton70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton70ActionPerformed
        // TODO add your handling code here:
         System.out.println("REPORTE DE ERROES:");
        for(int i = 0;i< TABLA_DE_ERRORES_SINTACTICOS.size(); i++){
            String Error = TABLA_DE_ERRORES_SINTACTICOS.get(i).lexema;
            String Tipo = TABLA_DE_ERRORES_SINTACTICOS.get(i).tipo;
            int columna = TABLA_DE_ERRORES_SINTACTICOS.get(i).columna;
            int fila = TABLA_DE_ERRORES_SINTACTICOS.get(i).linea;
            String Descripcion = TABLA_DE_ERRORES_SINTACTICOS.get(i).descripcion;
            System.out.println(i+1 + " | " +Tipo + " |" + Descripcion + " " + " | "  + columna + " | " + fila );
            //CrearReporteErrores();
        }
        CrearReporteErrores();
        TABLA_DE_ERRORES_SINTACTICOS.clear();
    }//GEN-LAST:event_jButton70ActionPerformed

    private void jButton92ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton92ActionPerformed
        // TODO add your handling code here:
         TABLA_DE_ERRORES_SINTACTICOS.clear();
        NumeroEntornosRomeo = 0;
        TABLA_ReporteTS.clear();
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter("3d.txt"));
             bw.write("");
             bw.close();
        } catch (IOException ex) {
            Logger.getLogger(IDE.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        jTextArea2.setText("");
       // RepasoCompi2 Hola = new RepasoCompi2();
        Analizar(jTextArea11.getText(), jTextArea2);
    }//GEN-LAST:event_jButton92ActionPerformed

    private void jButton95ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton95ActionPerformed
        // TODO add your handling code here:
        Analizar2(jTextArea11.getText(), jTextArea2);
    }//GEN-LAST:event_jButton95ActionPerformed

    private void jButton100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton100ActionPerformed
        // TODO add your handling code here:
         System.out.println("REPORTE DE ERROES:");
        for(int i = 0;i< TABLA_DE_ERRORES_SINTACTICOS.size(); i++){
            String Error = TABLA_DE_ERRORES_SINTACTICOS.get(i).lexema;
            String Tipo = TABLA_DE_ERRORES_SINTACTICOS.get(i).tipo;
            int columna = TABLA_DE_ERRORES_SINTACTICOS.get(i).columna;
            int fila = TABLA_DE_ERRORES_SINTACTICOS.get(i).linea;
            String Descripcion = TABLA_DE_ERRORES_SINTACTICOS.get(i).descripcion;
            System.out.println(i+1 + " | " +Tipo + " |" + Descripcion + " " + " | "  + columna + " | " + fila );
            
        }
        CrearReporteErrores();
        TABLA_DE_ERRORES_SINTACTICOS.clear();
    }//GEN-LAST:event_jButton100ActionPerformed

    private void jButton102ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton102ActionPerformed
        // TODO add your handling code here:
         TABLA_DE_ERRORES_SINTACTICOS.clear();
        NumeroEntornosRomeo = 0;
        TABLA_ReporteTS.clear();
           BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter("3d.txt"));
             bw.write("");
             bw.close();
        } catch (IOException ex) {
            Logger.getLogger(IDE.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        jTextArea2.setText("");
       // RepasoCompi2 Hola = new RepasoCompi2();
        Analizar(jTextArea12.getText(), jTextArea2);
    }//GEN-LAST:event_jButton102ActionPerformed

    private void jButton105ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton105ActionPerformed
        // TODO add your handling code here:
         Analizar2(jTextArea12.getText(), jTextArea2);
    }//GEN-LAST:event_jButton105ActionPerformed

    private void jButton110ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton110ActionPerformed
        // TODO add your handling code here:
         System.out.println("REPORTE DE ERROES:");
        for(int i = 0;i< TABLA_DE_ERRORES_SINTACTICOS.size(); i++){
            String Error = TABLA_DE_ERRORES_SINTACTICOS.get(i).lexema;
            String Tipo = TABLA_DE_ERRORES_SINTACTICOS.get(i).tipo;
            int columna = TABLA_DE_ERRORES_SINTACTICOS.get(i).columna;
            int fila = TABLA_DE_ERRORES_SINTACTICOS.get(i).linea;
            String Descripcion = TABLA_DE_ERRORES_SINTACTICOS.get(i).descripcion;
            System.out.println(i+1 + " | " +Tipo + " |" + Descripcion + " " + " | "  + columna + " | " + fila );
          
        }
          CrearReporteErrores();
          TABLA_DE_ERRORES_SINTACTICOS.clear();
    }//GEN-LAST:event_jButton110ActionPerformed

    private void jButton112ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton112ActionPerformed
        // TODO add your handling code here:
         TABLA_DE_ERRORES_SINTACTICOS.clear();
        NumeroEntornosRomeo = 0;
        TABLA_ReporteTS.clear();
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter("3d.txt"));
             bw.write("");
             bw.close();
        } catch (IOException ex) {
            Logger.getLogger(IDE.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        jTextArea2.setText("");
       // RepasoCompi2 Hola = new RepasoCompi2();
        Analizar(jTextArea13.getText(), jTextArea2);
    }//GEN-LAST:event_jButton112ActionPerformed

    private void jButton115ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton115ActionPerformed
        // TODO add your handling code here:
         Analizar2(jTextArea13.getText(), jTextArea2);
    }//GEN-LAST:event_jButton115ActionPerformed

    private void jButton120ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton120ActionPerformed
        // TODO add your handling code here:
         System.out.println("REPORTE DE ERROES:");
        for(int i = 0;i< TABLA_DE_ERRORES_SINTACTICOS.size(); i++){
            String Error = TABLA_DE_ERRORES_SINTACTICOS.get(i).lexema;
            String Tipo = TABLA_DE_ERRORES_SINTACTICOS.get(i).tipo;
            int columna = TABLA_DE_ERRORES_SINTACTICOS.get(i).columna;
            int fila = TABLA_DE_ERRORES_SINTACTICOS.get(i).linea;
            String Descripcion = TABLA_DE_ERRORES_SINTACTICOS.get(i).descripcion;
            System.out.println(i+1 + " | " +Tipo + " |" + Descripcion + " " + " | "  + columna + " | " + fila );
           
        }
         CrearReporteErrores();
         TABLA_DE_ERRORES_SINTACTICOS.clear();
    }//GEN-LAST:event_jButton120ActionPerformed

    private void jButton122ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton122ActionPerformed
        // TODO add your handling code here:
         TABLA_DE_ERRORES_SINTACTICOS.clear();
        NumeroEntornosRomeo = 0;
        TABLA_ReporteTS.clear();
                BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter("3d.txt"));
             bw.write("");
             bw.close();
        } catch (IOException ex) {
            Logger.getLogger(IDE.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        jTextArea2.setText("");
       // RepasoCompi2 Hola = new RepasoCompi2();
        Analizar(jTextArea14.getText(), jTextArea2);
    }//GEN-LAST:event_jButton122ActionPerformed

    private void jButton125ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton125ActionPerformed
        // TODO add your handling code here:
        Analizar2(jTextArea14.getText(), jTextArea2);
    }//GEN-LAST:event_jButton125ActionPerformed

    private void jButton130ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton130ActionPerformed
        // TODO add your handling code here:
         System.out.println("REPORTE DE ERROES:");
        for(int i = 0;i< TABLA_DE_ERRORES_SINTACTICOS.size(); i++){
            String Error = TABLA_DE_ERRORES_SINTACTICOS.get(i).lexema;
            String Tipo = TABLA_DE_ERRORES_SINTACTICOS.get(i).tipo;
            int columna = TABLA_DE_ERRORES_SINTACTICOS.get(i).columna;
            int fila = TABLA_DE_ERRORES_SINTACTICOS.get(i).linea;
            String Descripcion = TABLA_DE_ERRORES_SINTACTICOS.get(i).descripcion;
            System.out.println(i+1 + " | " +Tipo + " |" + Descripcion + " " + " | "  + columna + " | " + fila );
            
        }
        CrearReporteErrores();
        TABLA_DE_ERRORES_SINTACTICOS.clear();
    }//GEN-LAST:event_jButton130ActionPerformed

    private void jButton132ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton132ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton132ActionPerformed

    private void jButton135ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton135ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton135ActionPerformed

    private void jButton140ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton140ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton140ActionPerformed

    private void jButton142ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton142ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton142ActionPerformed

    private void jButton145ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton145ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton145ActionPerformed

    private void jButton150ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton150ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton150ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        JOptionPane.showMessageDialog(null, "No puede Cerrar la pestaña principal");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
         jTabbedPane1.remove(jPanel21);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
         jTabbedPane1.remove(jPanel22);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.remove(jPanel23);
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        // TODO add your handling code here:
         jTabbedPane1.remove(jPanel24);
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.remove(jPanel25);
    }//GEN-LAST:event_jButton61ActionPerformed

    private void jButton71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton71ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.remove(jPanel26);
    }//GEN-LAST:event_jButton71ActionPerformed

    private void jButton101ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton101ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.remove(jPanel27);
    }//GEN-LAST:event_jButton101ActionPerformed

    private void jButton111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton111ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.remove(jPanel28);
    }//GEN-LAST:event_jButton111ActionPerformed

    private void jButton121ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton121ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.remove(jPanel29);
    }//GEN-LAST:event_jButton121ActionPerformed

    private void jButton131ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton131ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.remove(jPanel30);
    }//GEN-LAST:event_jButton131ActionPerformed

    private void jButton123ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton123ActionPerformed
        // TODO add your handling code here:
         if(seleccionar1.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
            Archivo10 = seleccionar1.getSelectedFile();
            System.out.println("vamos a abrir un archivo" + Archivo10);
            if(Archivo10.canRead()){
                String documento = AbrirArchivo(Archivo10);
                jTextArea14.setText(documento);
            }
            
        }
        System.out.println("terminaomos de abrir el archivo");
        
        
    }//GEN-LAST:event_jButton123ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        
        if(seleccionar1.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
            Archivo = seleccionar1.getSelectedFile();
            System.out.println("vamos a abrir un archivo" + Archivo);
            if(Archivo.canRead()){
                String documento = AbrirArchivo(Archivo);
                jTextArea1.setText(documento);
            }
            
        }
        System.out.println("terminaomos de abrir el archivo");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
         if(seleccionar1.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
            Archivo1 = seleccionar1.getSelectedFile();
            System.out.println("vamos a abrir un archivo" + Archivo1);
            if(Archivo1.canRead()){
                String documento = AbrirArchivo(Archivo1);
                jTextArea3.setText(documento);
            }
            
        }
        System.out.println("terminaomos de abrir el archivo");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        if(seleccionar1.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
            Archivo2 = seleccionar1.getSelectedFile();
            System.out.println("vamos a abrir un archivo" + Archivo2);
            if(Archivo2.canRead()){
                String documento = AbrirArchivo(Archivo2);
                jTextArea4.setText(documento);
            }
            
        }
        System.out.println("terminaomos de abrir el archivo");
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        // TODO add your handling code here:
        if(seleccionar1.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
            Archivo3 = seleccionar1.getSelectedFile();
            System.out.println("vamos a abrir un archivo" + Archivo3);
            if(Archivo3.canRead()){
                String documento = AbrirArchivo(Archivo3);
                jTextArea5.setText(documento);
            }
            
        }
        System.out.println("terminaomos de abrir el archivo");
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        // TODO add your handling code here:
         if(seleccionar1.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
            Archivo4 = seleccionar1.getSelectedFile();
            System.out.println("vamos a abrir un archivo" + Archivo4);
            if(Archivo4.canRead()){
                String documento = AbrirArchivo(Archivo4);
                jTextArea6.setText(documento);
            }
            
        }
        System.out.println("terminaomos de abrir el archivo");
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        // TODO add your handling code here:
        if(seleccionar1.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
            Archivo5 = seleccionar1.getSelectedFile();
            System.out.println("vamos a abrir un archivo" + Archivo5);
            if(Archivo5.canRead()){
                String documento = AbrirArchivo(Archivo5);
                jTextArea7.setText(documento);
            }
            
        }
        System.out.println("terminaomos de abrir el archivo");
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton63ActionPerformed
        // TODO add your handling code here:
         if(seleccionar1.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
            Archivo6 = seleccionar1.getSelectedFile();
            System.out.println("vamos a abrir un archivo" + Archivo6);
            if(Archivo6.canRead()){
                String documento = AbrirArchivo(Archivo6);
                jTextArea8.setText(documento);
            }
            
        }
        System.out.println("terminaomos de abrir el archivo");
    }//GEN-LAST:event_jButton63ActionPerformed

    private void jButton93ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton93ActionPerformed
        // TODO add your handling code here:
        if(seleccionar1.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
            Archivo7 = seleccionar1.getSelectedFile();
            System.out.println("vamos a abrir un archivo" + Archivo7);
            if(Archivo7.canRead()){
                String documento = AbrirArchivo(Archivo7);
                jTextArea11.setText(documento);
            }
            
        }
        System.out.println("terminaomos de abrir el archivo");
    }//GEN-LAST:event_jButton93ActionPerformed

    private void jButton103ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton103ActionPerformed
        // TODO add your handling code here:
        if(seleccionar1.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
            Archivo8 = seleccionar1.getSelectedFile();
            System.out.println("vamos a abrir un archivo" + Archivo8);
            if(Archivo8.canRead()){
                String documento = AbrirArchivo(Archivo8);
                jTextArea12.setText(documento);
            }
            
        }
        System.out.println("terminaomos de abrir el archivo");
    }//GEN-LAST:event_jButton103ActionPerformed

    private void jButton113ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton113ActionPerformed
        // TODO add your handling code here:
         if(seleccionar1.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
            Archivo9 = seleccionar1.getSelectedFile();
            System.out.println("vamos a abrir un archivo" + Archivo9);
            if(Archivo9.canRead()){
                String documento = AbrirArchivo(Archivo9);
                jTextArea13.setText(documento);
            }
            
        }
        System.out.println("terminaomos de abrir el archivo");
    }//GEN-LAST:event_jButton113ActionPerformed

    private void jButton128ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton128ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jButton128ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
         System.out.println("Este es el archivo" + Archivo);
        System.out.println("Este es el archivo" + Archivo1);
        System.out.println("Este es el archivo" + Archivo2);
        System.out.println("Este es el archivo" + Archivo3);
        System.out.println("Este es el archivo" + Archivo4);
        System.out.println("Este es el archivo" + Archivo5);
        System.out.println("Este es el archivo" + Archivo6);
        System.out.println("Este es el archivo" + Archivo7);
        System.out.println("Este es el archivo" + Archivo8);
        System.out.println("Este es el archivo" + Archivo9);
        System.out.println("Este es el archivo" + Archivo10);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
       String Mensaje = GuardarArchivo(Archivo,jTextArea1.getText());
       if(Mensaje == null){
           JOptionPane.showMessageDialog(null, "Problemas al guardar en " + Archivo);
       }else{
           JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo);
       }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
       String Mensaje = GuardarArchivo(Archivo1,jTextArea3.getText());
       if(Mensaje == null){
           JOptionPane.showMessageDialog(null, "Problemas al guardar en " + Archivo1);
       }else{
           JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo1);
       }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
       String Mensaje = GuardarArchivo(Archivo2,jTextArea4.getText());
       if(Mensaje == null){
           JOptionPane.showMessageDialog(null, "Problemas al guardar en " + Archivo2);
       }else{
           JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo2);
       }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        // TODO add your handling code here:
       String Mensaje = GuardarArchivo(Archivo3,jTextArea5.getText());
       if(Mensaje == null){
           JOptionPane.showMessageDialog(null, "Problemas al guardar en " + Archivo3);
       }else{
           JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo3);
       }
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        // TODO add your handling code here:
       String Mensaje = GuardarArchivo(Archivo4,jTextArea6.getText());
       if(Mensaje == null){
           JOptionPane.showMessageDialog(null, "Problemas al guardar en " + Archivo4);
       }else{
           JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo4);
       }
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        // TODO add your handling code here:
        String Mensaje = GuardarArchivo(Archivo5,jTextArea7.getText());
       if(Mensaje == null){
           JOptionPane.showMessageDialog(null, "Problemas al guardar en " + Archivo5);
       }else{
           JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo5);
       }
    }//GEN-LAST:event_jButton54ActionPerformed

    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
        // TODO add your handling code here:
         String Mensaje = GuardarArchivo(Archivo6,jTextArea8.getText());
       if(Mensaje == null){
           JOptionPane.showMessageDialog(null, "Problemas al guardar en " + Archivo6);
       }else{
           JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo6);
       }
    }//GEN-LAST:event_jButton64ActionPerformed

    private void jButton94ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton94ActionPerformed
        // TODO add your handling code here:
         String Mensaje = GuardarArchivo(Archivo7,jTextArea11.getText());
       if(Mensaje == null){
           JOptionPane.showMessageDialog(null, "Problemas al guardar en " + Archivo7);
       }else{
           JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo7);
       }
    }//GEN-LAST:event_jButton94ActionPerformed

    private void jButton104ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton104ActionPerformed
        // TODO add your handling code here:
       String Mensaje = GuardarArchivo(Archivo8,jTextArea12.getText());
       if(Mensaje == null){
           JOptionPane.showMessageDialog(null, "Problemas al guardar en " + Archivo8);
       }else{
           JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo8);
       }
    }//GEN-LAST:event_jButton104ActionPerformed

    private void jButton114ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton114ActionPerformed
        // TODO add your handling code here:
         String Mensaje = GuardarArchivo(Archivo9,jTextArea13.getText());
       if(Mensaje == null){
           JOptionPane.showMessageDialog(null, "Problemas al guardar en " + Archivo9);
       }else{
           JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo9);
       }
    }//GEN-LAST:event_jButton114ActionPerformed

    private void jButton124ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton124ActionPerformed
        // TODO add your handling code here:
          String Mensaje = GuardarArchivo(Archivo10,jTextArea14.getText());
       if(Mensaje == null){
           JOptionPane.showMessageDialog(null, "Problemas al guardar en " + Archivo10);
       }else{
           JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo10);
       }
    }//GEN-LAST:event_jButton124ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        int respuesta = fc.showSaveDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            //Crear un objeto File con el archivo elegido
            Archivo = fc.getSelectedFile();
            GuardarArchivo(Archivo,jTextArea1.getText());
            //Mostrar el nombre del archvivo en un campo de texto
            JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        int respuesta = fc.showSaveDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            //Crear un objeto File con el archivo elegido
            Archivo1 = fc.getSelectedFile();
            GuardarArchivo(Archivo1,jTextArea3.getText());
            //Mostrar el nombre del archvivo en un campo de texto
            JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo1);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
         JFileChooser fc = new JFileChooser();
        int respuesta = fc.showSaveDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            //Crear un objeto File con el archivo elegido
            Archivo2 = fc.getSelectedFile();
            GuardarArchivo(Archivo2,jTextArea4.getText());
            //Mostrar el nombre del archvivo en un campo de texto
            JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo2);
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        // TODO add your handling code here:
         JFileChooser fc = new JFileChooser();
        int respuesta = fc.showSaveDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            //Crear un objeto File con el archivo elegido
            Archivo3 = fc.getSelectedFile();
            GuardarArchivo(Archivo3,jTextArea5.getText());
            //Mostrar el nombre del archvivo en un campo de texto
            JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo3);
        }
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        // TODO add your handling code here:
         JFileChooser fc = new JFileChooser();
        int respuesta = fc.showSaveDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            //Crear un objeto File con el archivo elegido
            Archivo4 = fc.getSelectedFile();
            GuardarArchivo(Archivo4,jTextArea6.getText());
            //Mostrar el nombre del archvivo en un campo de texto
            JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo4);
        }
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
        // TODO add your handling code here:
          JFileChooser fc = new JFileChooser();
        int respuesta = fc.showSaveDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            //Crear un objeto File con el archivo elegido
            Archivo5 = fc.getSelectedFile();
            GuardarArchivo(Archivo5,jTextArea7.getText());
            //Mostrar el nombre del archvivo en un campo de texto
            JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo5);
        }
    }//GEN-LAST:event_jButton57ActionPerformed

    private void jButton67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton67ActionPerformed
        // TODO add your handling code here:
         JFileChooser fc = new JFileChooser();
        int respuesta = fc.showSaveDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            //Crear un objeto File con el archivo elegido
            Archivo6 = fc.getSelectedFile();
            GuardarArchivo(Archivo6,jTextArea8.getText());
            //Mostrar el nombre del archvivo en un campo de texto
            JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo6);
        }
    }//GEN-LAST:event_jButton67ActionPerformed

    private void jButton97ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton97ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        int respuesta = fc.showSaveDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            //Crear un objeto File con el archivo elegido
            Archivo7 = fc.getSelectedFile();
            GuardarArchivo(Archivo7,jTextArea11.getText());
            //Mostrar el nombre del archvivo en un campo de texto
            JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo7);
        }
    }//GEN-LAST:event_jButton97ActionPerformed

    private void jButton107ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton107ActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        int respuesta = fc.showSaveDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            //Crear un objeto File con el archivo elegido
            Archivo8 = fc.getSelectedFile();
            GuardarArchivo(Archivo8,jTextArea12.getText());
            //Mostrar el nombre del archvivo en un campo de texto
            JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo8);
        }
    }//GEN-LAST:event_jButton107ActionPerformed

    private void jButton117ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton117ActionPerformed
        // TODO add your handling code here:
         JFileChooser fc = new JFileChooser();
        int respuesta = fc.showSaveDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            //Crear un objeto File con el archivo elegido
            Archivo9 = fc.getSelectedFile();
            GuardarArchivo(Archivo9,jTextArea13.getText());
            //Mostrar el nombre del archvivo en un campo de texto
            JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo9);
        }
    }//GEN-LAST:event_jButton117ActionPerformed

    private void jButton127ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton127ActionPerformed
        // TODO add your handling code here:
         JFileChooser fc = new JFileChooser();
        int respuesta = fc.showSaveDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            //Crear un objeto File con el archivo elegido
            Archivo10 = fc.getSelectedFile();
            GuardarArchivo(Archivo10,jTextArea14.getText());
            //Mostrar el nombre del archvivo en un campo de texto
            JOptionPane.showMessageDialog(null, "Cambios guardados en " + Archivo10);
        }
    }//GEN-LAST:event_jButton127ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
    for(int i = 0; i < TABLA_ReporteTS.size(); i++){
            System.out.println("NOMBRE SIMBOLO: " + TABLA_ReporteTS.get(i).Lexema());
            System.out.println("TIPO SIMBOLO:" + TABLA_ReporteTS.get(i).tipo());
            System.out.println("ENTORNO: " + TABLA_ReporteTS.get(i).entorno);
            System.out.println("FILA: " + TABLA_ReporteTS.get(i).linea);
            System.out.println("COLUMNA: " + TABLA_ReporteTS.get(i).columna);
             System.out.println("------------------------");
        
        }
         CrearReporteTS();
         TABLA_ReporteTS.clear();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         for(int i = 0; i < TABLA_ReporteTS.size(); i++){
            System.out.println("NOMBRE SIMBOLO: " + TABLA_ReporteTS.get(i).Lexema());
            System.out.println("TIPO SIMBOLO:" + TABLA_ReporteTS.get(i).tipo());
            System.out.println("ENTORNO: " + TABLA_ReporteTS.get(i).entorno);
            System.out.println("FILA: " + TABLA_ReporteTS.get(i).linea);
            System.out.println("COLUMNA: " + TABLA_ReporteTS.get(i).columna);
             System.out.println("------------------------");
        
        }
         CrearReporteTS();
         TABLA_ReporteTS.clear();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
   for(int i = 0; i < TABLA_ReporteTS.size(); i++){
            System.out.println("NOMBRE SIMBOLO: " + TABLA_ReporteTS.get(i).Lexema());
            System.out.println("TIPO SIMBOLO:" + TABLA_ReporteTS.get(i).tipo());
            System.out.println("ENTORNO: " + TABLA_ReporteTS.get(i).entorno);
            System.out.println("FILA: " + TABLA_ReporteTS.get(i).linea);
            System.out.println("COLUMNA: " + TABLA_ReporteTS.get(i).columna);
             System.out.println("------------------------");
        
        }
         CrearReporteTS();
         TABLA_ReporteTS.clear();
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        // TODO add your handling code here:
        for(int i = 0; i < TABLA_ReporteTS.size(); i++){
            System.out.println("NOMBRE SIMBOLO: " + TABLA_ReporteTS.get(i).Lexema());
            System.out.println("TIPO SIMBOLO:" + TABLA_ReporteTS.get(i).tipo());
            System.out.println("ENTORNO: " + TABLA_ReporteTS.get(i).entorno);
            System.out.println("FILA: " + TABLA_ReporteTS.get(i).linea);
            System.out.println("COLUMNA: " + TABLA_ReporteTS.get(i).columna);
             System.out.println("------------------------");
        
        }
         CrearReporteTS();
         TABLA_ReporteTS.clear();
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        // TODO add your handling code here:
        for(int i = 0; i < TABLA_ReporteTS.size(); i++){
            System.out.println("NOMBRE SIMBOLO: " + TABLA_ReporteTS.get(i).Lexema());
            System.out.println("TIPO SIMBOLO:" + TABLA_ReporteTS.get(i).tipo());
            System.out.println("ENTORNO: " + TABLA_ReporteTS.get(i).entorno);
            System.out.println("FILA: " + TABLA_ReporteTS.get(i).linea);
            System.out.println("COLUMNA: " + TABLA_ReporteTS.get(i).columna);
             System.out.println("------------------------");
        
        }
         CrearReporteTS();
         TABLA_ReporteTS.clear();
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        // TODO add your handling code here:
        for(int i = 0; i < TABLA_ReporteTS.size(); i++){
            System.out.println("NOMBRE SIMBOLO: " + TABLA_ReporteTS.get(i).Lexema());
            System.out.println("TIPO SIMBOLO:" + TABLA_ReporteTS.get(i).tipo());
            System.out.println("ENTORNO: " + TABLA_ReporteTS.get(i).entorno);
            System.out.println("FILA: " + TABLA_ReporteTS.get(i).linea);
            System.out.println("COLUMNA: " + TABLA_ReporteTS.get(i).columna);
             System.out.println("------------------------");
        
        }
         CrearReporteTS();
         TABLA_ReporteTS.clear();
    }//GEN-LAST:event_jButton58ActionPerformed

    private void jButton68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton68ActionPerformed
        // TODO add your handling code here:
        for(int i = 0; i < TABLA_ReporteTS.size(); i++){
            System.out.println("NOMBRE SIMBOLO: " + TABLA_ReporteTS.get(i).Lexema());
            System.out.println("TIPO SIMBOLO:" + TABLA_ReporteTS.get(i).tipo());
            System.out.println("ENTORNO: " + TABLA_ReporteTS.get(i).entorno);
            System.out.println("FILA: " + TABLA_ReporteTS.get(i).linea);
            System.out.println("COLUMNA: " + TABLA_ReporteTS.get(i).columna);
             System.out.println("------------------------");
        
        }
         CrearReporteTS();
         TABLA_ReporteTS.clear();
    }//GEN-LAST:event_jButton68ActionPerformed

    private void jButton99ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton99ActionPerformed
        // TODO add your handling code here:
        for(int i = 0; i < TABLA_ReporteTS.size(); i++){
            System.out.println("NOMBRE SIMBOLO: " + TABLA_ReporteTS.get(i).Lexema());
            System.out.println("TIPO SIMBOLO:" + TABLA_ReporteTS.get(i).tipo());
            System.out.println("ENTORNO: " + TABLA_ReporteTS.get(i).entorno);
            System.out.println("FILA: " + TABLA_ReporteTS.get(i).linea);
            System.out.println("COLUMNA: " + TABLA_ReporteTS.get(i).columna);
             System.out.println("------------------------");
        
        }
         CrearReporteTS();
         TABLA_ReporteTS.clear();
    }//GEN-LAST:event_jButton99ActionPerformed

    private void jButton109ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton109ActionPerformed
        // TODO add your handling code here:
            for(int i = 0; i < TABLA_ReporteTS.size(); i++){
            System.out.println("NOMBRE SIMBOLO: " + TABLA_ReporteTS.get(i).Lexema());
            System.out.println("TIPO SIMBOLO:" + TABLA_ReporteTS.get(i).tipo());
            System.out.println("ENTORNO: " + TABLA_ReporteTS.get(i).entorno);
            System.out.println("FILA: " + TABLA_ReporteTS.get(i).linea);
            System.out.println("COLUMNA: " + TABLA_ReporteTS.get(i).columna);
             System.out.println("------------------------");
        
        }
         CrearReporteTS();
         TABLA_ReporteTS.clear();
    }//GEN-LAST:event_jButton109ActionPerformed

    private void jButton119ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton119ActionPerformed
        // TODO add your handling code here:
        for(int i = 0; i < TABLA_ReporteTS.size(); i++){
            System.out.println("NOMBRE SIMBOLO: " + TABLA_ReporteTS.get(i).Lexema());
            System.out.println("TIPO SIMBOLO:" + TABLA_ReporteTS.get(i).tipo());
            System.out.println("ENTORNO: " + TABLA_ReporteTS.get(i).entorno);
            System.out.println("FILA: " + TABLA_ReporteTS.get(i).linea);
            System.out.println("COLUMNA: " + TABLA_ReporteTS.get(i).columna);
             System.out.println("------------------------");
        
        }
         CrearReporteTS();
         TABLA_ReporteTS.clear();
    }//GEN-LAST:event_jButton119ActionPerformed

    private void jButton129ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton129ActionPerformed
        // TODO add your handling code here:
        for(int i = 0; i < TABLA_ReporteTS.size(); i++){
            System.out.println("NOMBRE SIMBOLO: " + TABLA_ReporteTS.get(i).Lexema());
            System.out.println("TIPO SIMBOLO:" + TABLA_ReporteTS.get(i).tipo());
            System.out.println("ENTORNO: " + TABLA_ReporteTS.get(i).entorno);
            System.out.println("FILA: " + TABLA_ReporteTS.get(i).linea);
            System.out.println("COLUMNA: " + TABLA_ReporteTS.get(i).columna);
             System.out.println("------------------------");
        
        }
         CrearReporteTS();
         TABLA_ReporteTS.clear();
    }//GEN-LAST:event_jButton129ActionPerformed

     public void Analizar(String entrada,JTextArea salida){
        Analizador_Lexico Texto = new Analizador_Lexico(new BufferedReader  (new StringReader(entrada)));
        Analisis_Sintactico Sintactico = new Analisis_Sintactico (Texto);
        
        try{
            Sintactico.parse();
            this.Ejecutar(Sintactico.Raiz , salida);
        }catch(Exception e){
            
        }
    }
    
        public void Analizar2(String entrada,JTextArea salida){
        Analizador_Lexico Texto = new Analizador_Lexico(new BufferedReader  (new StringReader(entrada)));
        Analisis_Sintactico Sintactico = new Analisis_Sintactico (Texto);
        
        try{
            Sintactico.parse();
            Graficador g = new Graficador();
            g.graficarAST(Sintactico.Raiz);
            //this.Ejecutar(Sintactico.Raiz , salida);
        }catch(Exception e){
            
        }
    }
    
     public void Ejecutar(NodoAbstracto raiz,JTextArea salida){
        Entorno entorno = new Entorno();
        for (NodoAbstracto sentencia : raiz.Hijos.get(0).Hijos) {// para ejecutar solo sentencias 
            sentencia.Ejecutar(entorno,salida);
        }
    };
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IDE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IDE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton100;
    private javax.swing.JButton jButton101;
    private javax.swing.JButton jButton102;
    private javax.swing.JButton jButton103;
    private javax.swing.JButton jButton104;
    private javax.swing.JButton jButton105;
    private javax.swing.JButton jButton106;
    private javax.swing.JButton jButton107;
    private javax.swing.JButton jButton108;
    private javax.swing.JButton jButton109;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton110;
    private javax.swing.JButton jButton111;
    private javax.swing.JButton jButton112;
    private javax.swing.JButton jButton113;
    private javax.swing.JButton jButton114;
    private javax.swing.JButton jButton115;
    private javax.swing.JButton jButton116;
    private javax.swing.JButton jButton117;
    private javax.swing.JButton jButton118;
    private javax.swing.JButton jButton119;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton120;
    private javax.swing.JButton jButton121;
    private javax.swing.JButton jButton122;
    private javax.swing.JButton jButton123;
    private javax.swing.JButton jButton124;
    private javax.swing.JButton jButton125;
    private javax.swing.JButton jButton126;
    private javax.swing.JButton jButton127;
    private javax.swing.JButton jButton128;
    private javax.swing.JButton jButton129;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton130;
    private javax.swing.JButton jButton131;
    private javax.swing.JButton jButton132;
    private javax.swing.JButton jButton133;
    private javax.swing.JButton jButton134;
    private javax.swing.JButton jButton135;
    private javax.swing.JButton jButton136;
    private javax.swing.JButton jButton137;
    private javax.swing.JButton jButton138;
    private javax.swing.JButton jButton139;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton140;
    private javax.swing.JButton jButton141;
    private javax.swing.JButton jButton142;
    private javax.swing.JButton jButton143;
    private javax.swing.JButton jButton144;
    private javax.swing.JButton jButton145;
    private javax.swing.JButton jButton146;
    private javax.swing.JButton jButton147;
    private javax.swing.JButton jButton148;
    private javax.swing.JButton jButton149;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton150;
    private javax.swing.JButton jButton151;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton92;
    private javax.swing.JButton jButton93;
    private javax.swing.JButton jButton94;
    private javax.swing.JButton jButton95;
    private javax.swing.JButton jButton96;
    private javax.swing.JButton jButton97;
    private javax.swing.JButton jButton98;
    private javax.swing.JButton jButton99;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea11;
    private javax.swing.JTextArea jTextArea12;
    private javax.swing.JTextArea jTextArea13;
    private javax.swing.JTextArea jTextArea14;
    private javax.swing.JTextArea jTextArea15;
    private javax.swing.JTextArea jTextArea16;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    // End of variables declaration//GEN-END:variables
}
