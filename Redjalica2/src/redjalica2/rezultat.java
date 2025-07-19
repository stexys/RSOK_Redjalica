/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package redjalica2;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Laki
 */
public class rezultat extends javax.swing.JFrame {

    int asocijacijePoeniCovek,asocijacijePoeniKompjuter;
     int koznaznaPoeniCovek,koznaznaPoeniKompjuter;
      int mojbrojPoeniCovek,mojbrojPoeniKompjuter;
       int slagalicaPoeniCovek,slagalicaPoeniKompjuter;
        int spojnicePoeniCovek,spojnicePoeniKompjuter;
         int skockoPoeniCovek,skockoPoeniKompjuter;
          int ukupnoPoeniCovek,ukupnoPoeniKompjuter;
    /**
     * Creates new form rezultat
     */
          public rezultat(){
                  initComponents();
                      this.setSize(1100, 750);
    this.setResizable(false);
    }
    public rezultat(rezultat r) {
        this.asocijacijePoeniCovek = r.asocijacijePoeniCovek;
        this.asocijacijePoeniKompjuter = r.asocijacijePoeniKompjuter;
        
        this.koznaznaPoeniCovek = r.koznaznaPoeniCovek;
        this.koznaznaPoeniKompjuter = r.koznaznaPoeniKompjuter;
        
        this.mojbrojPoeniCovek = r.mojbrojPoeniCovek;
        this.mojbrojPoeniKompjuter = r.mojbrojPoeniKompjuter;
        
        this.slagalicaPoeniCovek = r.slagalicaPoeniCovek;
        this.slagalicaPoeniKompjuter = r.slagalicaPoeniKompjuter;
        
        this.spojnicePoeniCovek = r.spojnicePoeniCovek;
        this.spojnicePoeniKompjuter = r.spojnicePoeniKompjuter;
        
        this.skockoPoeniCovek = r.skockoPoeniCovek;
        this.skockoPoeniKompjuter = r.skockoPoeniKompjuter;
        
        this.ukupnoPoeniCovek = r.asocijacijePoeniCovek + r.koznaznaPoeniCovek + r.mojbrojPoeniCovek + r.slagalicaPoeniCovek + r.spojnicePoeniCovek + r.skockoPoeniCovek;
        this.ukupnoPoeniKompjuter = r.asocijacijePoeniKompjuter + r.koznaznaPoeniKompjuter + r.mojbrojPoeniKompjuter + r.slagalicaPoeniKompjuter + r.spojnicePoeniKompjuter + r.skockoPoeniKompjuter;
        
        initComponents(); //prvo inicijalizuje komponente pa ih popunjava
        
               this.labelaAsocijacijePoeniCovek.setText(String.valueOf(this.asocijacijePoeniCovek));
        this.labelaAsocijacijePoeniKompjuter.setText(String.valueOf(this.asocijacijePoeniKompjuter));
        
        this.labelaSkockoPoeniCovek.setText(String.valueOf(this.skockoPoeniCovek));
        this.labelaSkockoPoeniKompjuter.setText(String.valueOf(this.skockoPoeniKompjuter));
        
        this.labelaZnaSePoeniCovek.setText(String.valueOf(this.koznaznaPoeniCovek));
        this.labelaZnaSePoeniKompjuter.setText(String.valueOf(this.koznaznaPoeniKompjuter));
        
        this.labelaMojBrojPoeniCovek.setText(String.valueOf(this.mojbrojPoeniCovek));
        this.labelaMojBrojPoeniKompjuter.setText(String.valueOf(this.mojbrojPoeniKompjuter));
        
        this.labelaSpojnicePoeniCovek.setText(String.valueOf(this.spojnicePoeniCovek));
        this.labelaSpojnicePoeniKompjuter.setText(String.valueOf(this.spojnicePoeniKompjuter));
        
        this.labelaSlagalicaPoeniCovek.setText(String.valueOf(this.slagalicaPoeniCovek));
        this.labelaSlagalicaPoeniKompjuter.setText(String.valueOf(this.slagalicaPoeniKompjuter));
        
        this.labelaUkupnoPoeniCovek.setText(String.valueOf(this.ukupnoPoeniCovek));
        this.labelaUkupnoPoeniKompjuter.setText(String.valueOf(this.ukupnoPoeniKompjuter));
         
              
        
        

        
        
                      this.setSize(1100, 750);
                      
    this.setResizable(false);
    }

    //geteri i seteri su opcioni, zavise od modifikatora pristupa atributa
    public void setKoznaznaPoeniCovek(int koznaznaPoeniCovek) {
        this.koznaznaPoeniCovek = koznaznaPoeniCovek;
    }

    public void setKoznaznaPoeniKompjuter(int koznaznaPoeniKompjuter) {
        this.koznaznaPoeniKompjuter = koznaznaPoeniKompjuter;
    }

    public void setMojbrojPoeniCovek(int mojbrojPoeniCovek) {
        this.mojbrojPoeniCovek = mojbrojPoeniCovek;
    }

    public void setMojbrojPoeniKompjuter(int mojbrojPoeniKompjuter) {
        this.mojbrojPoeniKompjuter = mojbrojPoeniKompjuter;
    }

    public void setSlagalicaPoeniCovek(int slagalicaPoeniCovek) {
        this.slagalicaPoeniCovek = slagalicaPoeniCovek;
    }

    public void setSlagalicaPoeniKompjuter(int slagalicaPoeniKompjuter) {
        this.slagalicaPoeniKompjuter = slagalicaPoeniKompjuter;
    }

    public void setSpojnicePoeniCovek(int spojnicePoeniCovek) {
        this.spojnicePoeniCovek = spojnicePoeniCovek;
    }

    public void setSpojnicePoeniKompjuter(int spojnicePoeniKompjuter) {
        this.spojnicePoeniKompjuter = spojnicePoeniKompjuter;
    }

    public void setSkockoPoeniCovek(int skockoPoeniCovek) {
        this.skockoPoeniCovek = skockoPoeniCovek;
    }

    public void setSkockoPoeniKompjuter(int skockoPoeniKompjuter) {
        this.skockoPoeniKompjuter = skockoPoeniKompjuter;
    }

    public void setUkupnoPoeniCovek(int ukupnoPoeniCovek) {
        this.ukupnoPoeniCovek = ukupnoPoeniCovek;
    }

    public void setUkupnoPoeniKompjuter(int ukupnoPoeniKompjuter) {
        this.ukupnoPoeniKompjuter = ukupnoPoeniKompjuter;
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelaSlagalicaPoeniKompjuter = new javax.swing.JTextField();
        labelaMojBrojPoeniCovek = new javax.swing.JTextField();
        labelaMojBrojPoeniKompjuter = new javax.swing.JTextField();
        labelaSpojnicePoeniCovek = new javax.swing.JTextField();
        labelaSpojnicePoeniKompjuter = new javax.swing.JTextField();
        labelaSkockoPoeniCovek = new javax.swing.JTextField();
        labelaSkockoPoeniKompjuter = new javax.swing.JTextField();
        labelaZnaSePoeniCovek = new javax.swing.JTextField();
        labelaZnaSePoeniKompjuter = new javax.swing.JTextField();
        labelaAsocijacijePoeniCovek = new javax.swing.JTextField();
        labelaAsocijacijePoeniKompjuter = new javax.swing.JTextField();
        labelaSlagalicaPoeniCovek = new javax.swing.JTextField();
        labelaUkupnoPoeniCovek = new javax.swing.JTextField();
        labelaUkupnoPoeniKompjuter = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelaSlagalicaPoeniKompjuter.setBackground(new java.awt.Color(127, 127, 127));
        labelaSlagalicaPoeniKompjuter.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        labelaSlagalicaPoeniKompjuter.setForeground(new java.awt.Color(215, 228, 192));
        labelaSlagalicaPoeniKompjuter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelaSlagalicaPoeniKompjuterActionPerformed(evt);
            }
        });
        getContentPane().add(labelaSlagalicaPoeniKompjuter, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 90, -1));

        labelaMojBrojPoeniCovek.setBackground(new java.awt.Color(127, 127, 127));
        labelaMojBrojPoeniCovek.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        labelaMojBrojPoeniCovek.setForeground(new java.awt.Color(215, 228, 192));
        getContentPane().add(labelaMojBrojPoeniCovek, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, 90, -1));

        labelaMojBrojPoeniKompjuter.setBackground(new java.awt.Color(127, 127, 127));
        labelaMojBrojPoeniKompjuter.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        labelaMojBrojPoeniKompjuter.setForeground(new java.awt.Color(215, 228, 192));
        labelaMojBrojPoeniKompjuter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelaMojBrojPoeniKompjuterActionPerformed(evt);
            }
        });
        getContentPane().add(labelaMojBrojPoeniKompjuter, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, 90, -1));

        labelaSpojnicePoeniCovek.setBackground(new java.awt.Color(127, 127, 127));
        labelaSpojnicePoeniCovek.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        labelaSpojnicePoeniCovek.setForeground(new java.awt.Color(215, 228, 192));
        getContentPane().add(labelaSpojnicePoeniCovek, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 400, 90, -1));

        labelaSpojnicePoeniKompjuter.setBackground(new java.awt.Color(127, 127, 127));
        labelaSpojnicePoeniKompjuter.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        labelaSpojnicePoeniKompjuter.setForeground(new java.awt.Color(215, 228, 192));
        getContentPane().add(labelaSpojnicePoeniKompjuter, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, 90, -1));

        labelaSkockoPoeniCovek.setBackground(new java.awt.Color(127, 127, 127));
        labelaSkockoPoeniCovek.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        labelaSkockoPoeniCovek.setForeground(new java.awt.Color(215, 228, 192));
        getContentPane().add(labelaSkockoPoeniCovek, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 440, 90, -1));

        labelaSkockoPoeniKompjuter.setBackground(new java.awt.Color(127, 127, 127));
        labelaSkockoPoeniKompjuter.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        labelaSkockoPoeniKompjuter.setForeground(new java.awt.Color(215, 228, 192));
        getContentPane().add(labelaSkockoPoeniKompjuter, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, 90, -1));

        labelaZnaSePoeniCovek.setBackground(new java.awt.Color(127, 127, 127));
        labelaZnaSePoeniCovek.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        labelaZnaSePoeniCovek.setForeground(new java.awt.Color(215, 228, 192));
        getContentPane().add(labelaZnaSePoeniCovek, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, 90, -1));

        labelaZnaSePoeniKompjuter.setBackground(new java.awt.Color(127, 127, 127));
        labelaZnaSePoeniKompjuter.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        labelaZnaSePoeniKompjuter.setForeground(new java.awt.Color(215, 228, 192));
        getContentPane().add(labelaZnaSePoeniKompjuter, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 480, 90, -1));

        labelaAsocijacijePoeniCovek.setBackground(new java.awt.Color(127, 127, 127));
        labelaAsocijacijePoeniCovek.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        labelaAsocijacijePoeniCovek.setForeground(new java.awt.Color(215, 228, 192));
        labelaAsocijacijePoeniCovek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelaAsocijacijePoeniCovekActionPerformed(evt);
            }
        });
        getContentPane().add(labelaAsocijacijePoeniCovek, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 520, 90, -1));

        labelaAsocijacijePoeniKompjuter.setBackground(new java.awt.Color(127, 127, 127));
        labelaAsocijacijePoeniKompjuter.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        labelaAsocijacijePoeniKompjuter.setForeground(new java.awt.Color(215, 228, 192));
        getContentPane().add(labelaAsocijacijePoeniKompjuter, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 520, 90, -1));

        labelaSlagalicaPoeniCovek.setBackground(new java.awt.Color(127, 127, 127));
        labelaSlagalicaPoeniCovek.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        labelaSlagalicaPoeniCovek.setForeground(new java.awt.Color(215, 228, 192));
        getContentPane().add(labelaSlagalicaPoeniCovek, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 90, -1));

        labelaUkupnoPoeniCovek.setBackground(new java.awt.Color(127, 127, 127));
        labelaUkupnoPoeniCovek.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        labelaUkupnoPoeniCovek.setForeground(new java.awt.Color(215, 228, 192));
        getContentPane().add(labelaUkupnoPoeniCovek, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 560, 90, -1));

        labelaUkupnoPoeniKompjuter.setBackground(new java.awt.Color(127, 127, 127));
        labelaUkupnoPoeniKompjuter.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        labelaUkupnoPoeniKompjuter.setForeground(new java.awt.Color(215, 228, 192));
        getContentPane().add(labelaUkupnoPoeniKompjuter, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 560, 90, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(215, 228, 192));
        jLabel2.setText("REĐALICA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 180, 30));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(215, 228, 192));
        jLabel5.setText("NASUMIČNI BROJ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 180, -1));

        jLabel17.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(215, 228, 192));
        jLabel17.setText("REZULTAT");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 560, 180, -1));

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(215, 228, 192));
        jLabel8.setText("VEZICE");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 180, -1));

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(215, 228, 192));
        jLabel9.setText("MIŠ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 180, -1));

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(215, 228, 192));
        jLabel10.setText("ZNA SE   ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, 180, -1));

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(215, 228, 192));
        jLabel11.setText("ORGANIZACIJE");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 520, 180, -1));

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(215, 228, 192));
        jLabel12.setText("ČOVEK");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 90, -1));

        jLabel20.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(215, 228, 192));
        jLabel20.setText("RAČUNAR");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, -1, -1));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(215, 228, 192));
        jLabel1.setText("IGRAČ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 180, -1));

        jLabel3.setBackground(new java.awt.Color(198, 220, 186));
        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 3, 80)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(215, 228, 192));
        jLabel3.setText("REZULTAT");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 560, -1));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 3, 80)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 127, 127));
        jLabel4.setText("REZULTAT");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 600, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/vecavecaplocica643.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 1200, 630));

        jButton9.setBackground(new java.awt.Color(215, 228, 192));
        jButton9.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(127, 127, 127));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/zvučnik-removebg-preview.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 680, 60, 60));

        jButton12.setBackground(new java.awt.Color(215, 228, 192));
        jButton12.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(127, 127, 127));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/back-removebg-preview.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 680, 60, 60));

        jButton4.setBackground(new java.awt.Color(215, 228, 192));
        jButton4.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(127, 127, 127));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/close-removebg-preview.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, 60, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/pozadina1234.png"))); // NOI18N
        jLabel6.setText("jLabel2");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1100, 770));

        jLabel13.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(215, 228, 192));
        jLabel13.setText("jLabel1");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        jLabel14.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(215, 228, 192));
        jLabel14.setText("jLabel1");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        jLabel15.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(215, 228, 192));
        jLabel15.setText("jLabel1");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        jLabel16.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(215, 228, 192));
        jLabel16.setText("jLabel1");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        jLabel21.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(215, 228, 192));
        jLabel21.setText("jLabel1");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");

        meni m1 = new meni();
        m1.show();
        dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");

        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void labelaMojBrojPoeniKompjuterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelaMojBrojPoeniKompjuterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelaMojBrojPoeniKompjuterActionPerformed

    private void labelaSlagalicaPoeniKompjuterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelaSlagalicaPoeniKompjuterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelaSlagalicaPoeniKompjuterActionPerformed

    private void labelaAsocijacijePoeniCovekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelaAsocijacijePoeniCovekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelaAsocijacijePoeniCovekActionPerformed
       private void playSound(String soundFile) {
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFile).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        e.printStackTrace();
    }
}
      
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
            java.util.logging.Logger.getLogger(rezultat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rezultat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rezultat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rezultat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rezultat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField labelaAsocijacijePoeniCovek;
    private javax.swing.JTextField labelaAsocijacijePoeniKompjuter;
    private javax.swing.JTextField labelaMojBrojPoeniCovek;
    private javax.swing.JTextField labelaMojBrojPoeniKompjuter;
    private javax.swing.JTextField labelaSkockoPoeniCovek;
    private javax.swing.JTextField labelaSkockoPoeniKompjuter;
    private javax.swing.JTextField labelaSlagalicaPoeniCovek;
    private javax.swing.JTextField labelaSlagalicaPoeniKompjuter;
    private javax.swing.JTextField labelaSpojnicePoeniCovek;
    private javax.swing.JTextField labelaSpojnicePoeniKompjuter;
    private javax.swing.JTextField labelaUkupnoPoeniCovek;
    private javax.swing.JTextField labelaUkupnoPoeniKompjuter;
    private javax.swing.JTextField labelaZnaSePoeniCovek;
    private javax.swing.JTextField labelaZnaSePoeniKompjuter;
    // End of variables declaration//GEN-END:variables
}
