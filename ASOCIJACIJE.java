/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package redjalica2;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;

/**
 *
 * @author Laki
 */
public class ASOCIJACIJE extends javax.swing.JFrame {

    /**
     * Creates new form ASOCIJACIJE
     */
    
        //konstruktor treba da prima tezinu(npr int broj 0,1,2), treba na kraju runde da prosledjuje bodove.. pCovek i a2.pKompjuter za neku statistiku
        //objekat statistika.. pa ima bodoviCovek, bodoviKompjuter za svaku igru.. objekat se prosledjuje konstruktorom u ostale igrice
       private Timer timer ;
       private String[] resenja;
       rezultat r;
       int i = 60;
       double tezina;
       int pCovek = 0,pKompjuter = 0;
       boolean igraKompjuter = false;
       boolean igraCovek = true;
       boolean aKolonaPogodjena,bKolonaPogodjena,cKolonaPogodjena,dKolonaPogodjena;
       
    public ASOCIJACIJE(double tezina, rezultat r) throws Exception {
        initComponents();
        this.tezina = tezina;
        this.r = new rezultat(r);
            getRandomLineFromTheFile("C:\\Users\\PC\\Desktop\\asocijacije.txt");
            timer = new Timer(1000, new ActionListener() { // 5000 is five Second
            @Override
            public void actionPerformed(ActionEvent e) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           
            countme();
            }
        });
      
       timer.start();
    }
    
    public ASOCIJACIJE(boolean igraKompjuter, int pCovek, double tezina, rezultat r) throws Exception {
        super();
        initComponents();
            this.r = new rezultat(r);
            this.tezina = tezina;
            this.igraKompjuter = igraKompjuter;
            this.pCovek = pCovek;
            this.poeniCovek.setText(String.valueOf(pCovek));
            getRandomLineFromTheFile("C:\\Users\\PC\\Desktop\\asocijacije.txt");
            timer = new Timer(1000, new ActionListener() { // 5000 is five Second
            @Override
            public void actionPerformed(ActionEvent e) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           
            countme();
            }
        });
      
       timer.start();
    }
    
    
   public void countme(){
   
       if(i>0) i-- ;
       if(i == 0) {
           //i = -1;
           if(!igraKompjuter) //fora je da treba 2 boolean.. 1 ako covek ne resi asocijaciju.. a kompjuter nije igrao
           {igraKompjuter = true;
               ASOCIJACIJE a2;
              try {
                  dispose();
                  a2 = new ASOCIJACIJE(true,pCovek,tezina,r);
                  a2.show();
                  a2.setVisible(true);
                  a2.poeniCovek.setText(String.valueOf(pCovek));
                  
                  //Random rand = new Random();
                  //boolean val = rand.nextInt(25)==0;
                  
                  
                  
                  //u zavisnosti od tezine.. lako 0-30%
                  a2.a1.doClick();
                  //Thread.sleep(2000);
                  a2.a2.doClick();
                  //Thread.sleep(2000);
                  a2.a3.doClick();
                  //Thread.sleep(2000);
                  a2.a4.doClick();
                  //Thread.sleep(2000);
                  
                  //ako je uslov prosao, dobija poene svakako racunar.. i na kraju se diposuje..
                  if(Math.random()<tezina) //85% sanse && tezina - tesko, za lako idk koji % oko 45, srednje 65%
                  {a2.A.setText(a2.resenja[4]); //treba ti A.textChanged.. 
                      a2.pKompjuter+=10;
                      a2.poeniKompjuter.setText(String.valueOf(a2.pKompjuter));
                      //a2.r.asocijacijePoeniKompjuter = a2.pKompjuter;
                  }
                       //za tezak nivo
                  
                  a2.b1.doClick();
                  //Thread.sleep(2000);
                  a2.b2.doClick();
                  //Thread.sleep(2000);
                  a2.b3.doClick();
                  //Thread.sleep(2000);
                  a2.b4.doClick();
                  
                 
                  if(Math.random()<tezina) //85% sanse && tezina - tesko, za lako idk koji % oko 45, srednje 65%
                  {a2.B.setText(a2.resenja[9]); //treba ti A.textChanged..
                       //za tezak nivo
                       a2.pKompjuter+=10;   
                      a2.poeniKompjuter.setText(String.valueOf(a2.pKompjuter));
                      //a2.r.asocijacijePoeniKompjuter = a2.pKompjuter;
                  }

                  //u zavisnosti od tezine.. lako 0-30%
                  a2.c1.doClick();
                  //Thread.sleep(2000);
                  a2.c2.doClick();
                  //Thread.sleep(2000);
                  a2.c3.doClick();
                  //Thread.sleep(2000);
                  a2.c4.doClick();
                  //Thread.sleep(2000);
                  
               
                  if(Math.random()<tezina) //85% sanse && tezina - tesko, za lako idk koji % oko 45, srednje 65%
                  {a2.C.setText(a2.resenja[14]); //treba ti A.textChanged..
                       //za tezak nivo   
                      a2.pKompjuter+=10;
                      a2.poeniKompjuter.setText(String.valueOf(a2.pKompjuter));
                      //a2.r.asocijacijePoeniKompjuter = a2.pKompjuter;
                  }

                  //u zavisnosti od tezine.. lako 0-30%
                  a2.d1.doClick();
                  //Thread.sleep(2000);
                  a2.d2.doClick();
                  //Thread.sleep(2000);
                  a2.d3.doClick();
                  //Thread.sleep(2000);
                  a2.d4.doClick();
                  //Thread.sleep(2000);
                  
                  
                  if(Math.random()<tezina) //85% sanse && tezina - tesko, za lako idk koji % oko 45, srednje 65%
                  { a2.D.setText(a2.resenja[19]); //treba ti A.textChanged..
                       //za tezak nivo         
                      a2.pKompjuter+=10;
                      a2.poeniKompjuter.setText(String.valueOf(a2.pKompjuter));
                      //a2.r.asocijacijePoeniKompjuter = a2.pKompjuter;
                  }
  
                  
                  if(Math.random()<tezina) //85% sanse && tezina - tesko, za lako idk koji % oko 45, srednje 65%
                  {a2.resenje.setText(a2.resenja[20]); //treba ti A.textChanged..
                       //za tezak nivo                       
                      a2.pKompjuter+=10;
                      a2.poeniKompjuter.setText(String.valueOf(a2.pKompjuter));}   
                  
                  a2.poeniKompjuter.setText(String.valueOf(a2.pKompjuter));
                  a2.r.asocijacijePoeniKompjuter = a2.pKompjuter;
                 
                  if(igraKompjuter) //ovo si dodao
                {dispose();
                rezultat c = new rezultat(a2.r);
                c.show();
                c.setVisible(true);
                }
              } catch (Exception ex) {
                  Logger.getLogger(ASOCIJACIJE.class.getName()).log(Level.SEVERE, null, ex);
              }
       }
       if(igraKompjuter) 
       {dispose();
       //rezultat r = new rezultat(a2.r);
       } //i prikaz statistike pobednika
       }//this.dispose(); //kad se zavrsi tajmer... al tajmer zavisi od tezine.. treba konstruktor da prosledjuje tezinu
   
   tajmer.setText(String.valueOf(i));
   
       this.setSize(1100, 750);
    this.setResizable(false);
   
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        A = new javax.swing.JTextField();
        a4 = new javax.swing.JButton();
        a3 = new javax.swing.JButton();
        a2 = new javax.swing.JButton();
        a1 = new javax.swing.JButton();
        B = new javax.swing.JTextField();
        b4 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        c4 = new javax.swing.JButton();
        c3 = new javax.swing.JButton();
        c1 = new javax.swing.JButton();
        resenje = new javax.swing.JTextField();
        c2 = new javax.swing.JButton();
        d4 = new javax.swing.JButton();
        d3 = new javax.swing.JButton();
        d1 = new javax.swing.JButton();
        D = new javax.swing.JTextField();
        d2 = new javax.swing.JButton();
        C = new javax.swing.JTextField();
        tajmer = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        labelaCovek = new javax.swing.JLabel();
        labelaKompjuter = new javax.swing.JLabel();
        poeniKompjuter = new java.awt.TextField();
        poeniCovek = new java.awt.TextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(198, 220, 186));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        A.setBackground(new java.awt.Color(215, 228, 192));
        A.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        A.setForeground(new java.awt.Color(127, 127, 127));
        A.setText("A");
        A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AActionPerformed(evt);
            }
        });
        jPanel1.add(A, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 210, 40));

        a4.setBackground(new java.awt.Color(187, 195, 164));
        a4.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        a4.setForeground(new java.awt.Color(127, 127, 127));
        a4.setText("a4");
        a4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a4ActionPerformed(evt);
            }
        });
        jPanel1.add(a4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 210, 40));

        a3.setBackground(new java.awt.Color(187, 195, 164));
        a3.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        a3.setForeground(new java.awt.Color(127, 127, 127));
        a3.setText("a3");
        a3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a3ActionPerformed(evt);
            }
        });
        jPanel1.add(a3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 210, 40));

        a2.setBackground(new java.awt.Color(187, 195, 164));
        a2.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        a2.setForeground(new java.awt.Color(127, 127, 127));
        a2.setText("a2");
        a2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a2ActionPerformed(evt);
            }
        });
        jPanel1.add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 210, 40));

        a1.setBackground(new java.awt.Color(187, 195, 164));
        a1.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        a1.setForeground(new java.awt.Color(127, 127, 127));
        a1.setText("a1");
        a1.setToolTipText("");
        a1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a1ActionPerformed(evt);
            }
        });
        jPanel1.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 210, 40));

        B.setBackground(new java.awt.Color(215, 228, 192));
        B.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        B.setForeground(new java.awt.Color(127, 127, 127));
        B.setText("B");
        B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActionPerformed(evt);
            }
        });
        jPanel1.add(B, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 470, 210, 40));

        b4.setBackground(new java.awt.Color(187, 195, 164));
        b4.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        b4.setForeground(new java.awt.Color(127, 127, 127));
        b4.setText("b4");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });
        jPanel1.add(b4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, 210, 40));

        b3.setBackground(new java.awt.Color(187, 195, 164));
        b3.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        b3.setForeground(new java.awt.Color(127, 127, 127));
        b3.setText("b3");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        jPanel1.add(b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 210, 40));

        b2.setBackground(new java.awt.Color(187, 195, 164));
        b2.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        b2.setForeground(new java.awt.Color(127, 127, 127));
        b2.setText("b2");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        jPanel1.add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 210, 40));

        b1.setBackground(new java.awt.Color(187, 195, 164));
        b1.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        b1.setForeground(new java.awt.Color(127, 127, 127));
        b1.setText("b1");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        jPanel1.add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 210, 40));

        c4.setBackground(new java.awt.Color(187, 195, 164));
        c4.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        c4.setForeground(new java.awt.Color(127, 127, 127));
        c4.setText("c4");
        c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c4ActionPerformed(evt);
            }
        });
        jPanel1.add(c4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, 210, 40));

        c3.setBackground(new java.awt.Color(187, 195, 164));
        c3.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        c3.setForeground(new java.awt.Color(127, 127, 127));
        c3.setText("c3");
        c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c3ActionPerformed(evt);
            }
        });
        jPanel1.add(c3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, 210, 40));

        c1.setBackground(new java.awt.Color(187, 195, 164));
        c1.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        c1.setForeground(new java.awt.Color(127, 127, 127));
        c1.setText("c1");
        c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1ActionPerformed(evt);
            }
        });
        jPanel1.add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 210, 40));

        resenje.setBackground(new java.awt.Color(215, 228, 192));
        resenje.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        resenje.setForeground(new java.awt.Color(127, 127, 127));
        resenje.setText("???");
        resenje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resenjeActionPerformed(evt);
            }
        });
        jPanel1.add(resenje, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, 940, 60));

        c2.setBackground(new java.awt.Color(187, 195, 164));
        c2.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        c2.setForeground(new java.awt.Color(127, 127, 127));
        c2.setText("c2");
        c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c2ActionPerformed(evt);
            }
        });
        jPanel1.add(c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, 210, 40));

        d4.setBackground(new java.awt.Color(187, 195, 164));
        d4.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        d4.setForeground(new java.awt.Color(127, 127, 127));
        d4.setText("d4");
        d4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d4ActionPerformed(evt);
            }
        });
        jPanel1.add(d4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 420, 210, 40));

        d3.setBackground(new java.awt.Color(187, 195, 164));
        d3.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        d3.setForeground(new java.awt.Color(127, 127, 127));
        d3.setText("d3");
        d3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d3ActionPerformed(evt);
            }
        });
        jPanel1.add(d3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 370, 210, 40));

        d1.setBackground(new java.awt.Color(187, 195, 164));
        d1.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        d1.setForeground(new java.awt.Color(127, 127, 127));
        d1.setText("d1");
        d1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d1ActionPerformed(evt);
            }
        });
        jPanel1.add(d1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, 210, 40));

        D.setBackground(new java.awt.Color(215, 228, 192));
        D.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        D.setForeground(new java.awt.Color(127, 127, 127));
        D.setText("D");
        D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DActionPerformed(evt);
            }
        });
        jPanel1.add(D, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 470, 210, 40));

        d2.setBackground(new java.awt.Color(187, 195, 164));
        d2.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        d2.setForeground(new java.awt.Color(127, 127, 127));
        d2.setText("d2");
        d2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                d2ActionPerformed(evt);
            }
        });
        jPanel1.add(d2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 320, 210, 40));

        C.setBackground(new java.awt.Color(215, 228, 192));
        C.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        C.setForeground(new java.awt.Color(127, 127, 127));
        C.setText("C");
        C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CActionPerformed(evt);
            }
        });
        jPanel1.add(C, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 470, 210, 40));

        tajmer.setFont(new java.awt.Font("Comic Sans MS", 3, 48)); // NOI18N
        tajmer.setForeground(new java.awt.Color(215, 228, 192));
        tajmer.setText("0");
        jPanel1.add(tajmer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, -1));

        jButton12.setBackground(new java.awt.Color(215, 228, 192));
        jButton12.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(127, 127, 127));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/back-removebg-preview.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 680, 60, 60));

        jButton4.setBackground(new java.awt.Color(215, 228, 192));
        jButton4.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(127, 127, 127));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/close-removebg-preview.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, 60, 60));

        jButton9.setBackground(new java.awt.Color(215, 228, 192));
        jButton9.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(127, 127, 127));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/zvučnik-removebg-preview.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 680, 60, 60));

        labelaCovek.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        labelaCovek.setForeground(new java.awt.Color(215, 228, 192));
        labelaCovek.setText("ČOVEK");
        jPanel1.add(labelaCovek, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 60, -1, -1));

        labelaKompjuter.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        labelaKompjuter.setForeground(new java.awt.Color(215, 228, 192));
        labelaKompjuter.setText("KOMPJUTER");
        jPanel1.add(labelaKompjuter, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        poeniKompjuter.setBackground(new java.awt.Color(187, 195, 164));
        poeniKompjuter.setEditable(false);
        poeniKompjuter.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jPanel1.add(poeniKompjuter, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 80, 40));

        poeniCovek.setBackground(new java.awt.Color(187, 195, 164));
        poeniCovek.setEditable(false);
        poeniCovek.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jPanel1.add(poeniCovek, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 60, 80, 40));

        jLabel3.setBackground(new java.awt.Color(198, 220, 186));
        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 3, 80)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(215, 228, 192));
        jLabel3.setText("ORGANIZACIJE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 670, -1));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 3, 80)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 127, 127));
        jLabel4.setText("ORGANIZACIJE");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 710, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/vecavecaplocica643.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 1200, 630));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/pozadina1234.png"))); // NOI18N
        jLabel6.setText("jLabel2");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1100, 770));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void a1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a1ActionPerformed
     playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
     a1.setText(resenja[0]);
     //a1.setEnabled(false);

    }//GEN-LAST:event_a1ActionPerformed

    private void a2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a2ActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
    a2.setText(resenja[1]);
    //a2.setEnabled(false);


    }//GEN-LAST:event_a2ActionPerformed

    private void a3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a3ActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
    a3.setText(resenja[2]);
    //a3.setEnabled(false);

    }//GEN-LAST:event_a3ActionPerformed

    private void a4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a4ActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
    a4.setText(resenja[3]);
    //a4.setEnabled(false);

    }//GEN-LAST:event_a4ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
    b4.setText(resenja[8]);
    //b4.setEnabled(false);
    }//GEN-LAST:event_b4ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
    b3.setText(resenja[7]);
    //b3.setEnabled(false); //ovo je kad bi racunar igrao tako da klikne pa da se odigra potez racunara
    }//GEN-LAST:event_b3ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
     playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
    b2.setText(resenja[6]);
    //b2.setEnabled(false);
    
    }//GEN-LAST:event_b2ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
     playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav"); 
     b1.setText(resenja[5]); 

    }//GEN-LAST:event_b1ActionPerformed

    private void c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c4ActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
    c4.setText(resenja[13]);

    }//GEN-LAST:event_c4ActionPerformed

    private void c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c3ActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
    c3.setText(resenja[12]);

    }//GEN-LAST:event_c3ActionPerformed

    private void c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c1ActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
    c1.setText(resenja[10]); 
        
        
        
        

    }//GEN-LAST:event_c1ActionPerformed

    private void c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c2ActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
    c2.setText(resenja[11]);

    }//GEN-LAST:event_c2ActionPerformed

    private void d4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d4ActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\win2.wav");
    d4.setText(resenja[18]);
       // rezultat re1 = new rezultat();
       // re1.show();
       // dispose();
    }//GEN-LAST:event_d4ActionPerformed

    private void d3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d3ActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\izgub.wav");
    d3.setText(resenja[17]);
        //rezultat re1 = new rezultat();
        //re1.show();
        //dispose();
    }//GEN-LAST:event_d3ActionPerformed

    private void d1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d1ActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
    d1.setText(resenja[15]); 

    }//GEN-LAST:event_d1ActionPerformed

    private void d2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_d2ActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
    d2.setText(resenja[16]);

    }//GEN-LAST:event_d2ActionPerformed

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

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
  playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");

    }//GEN-LAST:event_jButton9ActionPerformed

    private void AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
    if(A.getText().equalsIgnoreCase(resenja[4]) && igraKompjuter == false && igraCovek == true)
    {
        a1.setText(resenja[0]);  // ako ovo odma postavi onda samo stavis details da je this details =.. tj kao property pa on click update..
        a2.setText(resenja[1]);
        a3.setText(resenja[2]);
        a4.setText(resenja[3]);
     
        A.setText(resenja[4]);
        pCovek += 10;
        poeniCovek.setText(String.valueOf(pCovek));
        aKolonaPogodjena = true;
        r.asocijacijePoeniCovek = pCovek;
        //igraCovek = false;
    }
    else if(A.getText().equalsIgnoreCase(resenja[4]) && igraKompjuter == true && igraCovek == false)
    {
        A.setText(resenja[4]);
        pKompjuter += 10;
        poeniKompjuter.setText(String.valueOf(pKompjuter));
        aKolonaPogodjena = true;
        r.asocijacijePoeniCovek = pCovek;
    }

    }//GEN-LAST:event_AActionPerformed

    private void BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
     if(B.getText().equalsIgnoreCase(resenja[9]))
    {
        b1.setText(resenja[5]); 
        b2.setText(resenja[6]);
        b3.setText(resenja[7]);
        b4.setText(resenja[8]);
         B.setText(resenja[9]);
        //poeniCovek.setText(Integer.toString(Integer.parseInt(poeniCovek.getText())+10));
        //int skor = Integer.parseInt(poeniCovek.getText())+10;
        //String s = String.valueOf(skor);
        pCovek += 10;
        poeniCovek.setText(String.valueOf(pCovek));
        bKolonaPogodjena = true;
        r.asocijacijePoeniCovek = pCovek;
        
    }
   

    }//GEN-LAST:event_BActionPerformed

    private void CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
         if(C.getText().equalsIgnoreCase(resenja[14]))
    {
        c1.setText(resenja[10]); 
        c2.setText(resenja[11]);
        c3.setText(resenja[12]);
        c4.setText(resenja[13]);
         C.setText(resenja[14]);
        //poeniCovek.setText(Integer.toString(Integer.parseInt(poeniCovek.getText())+10));
        //int skor = Integer.parseInt(poeniCovek.getText())+10;
        //String s = String.valueOf(skor);
        pCovek += 10;
        poeniCovek.setText(String.valueOf(pCovek));
        cKolonaPogodjena = true;
        r.asocijacijePoeniCovek = pCovek;
    }
    

    }//GEN-LAST:event_CActionPerformed

    private void DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
    if(D.getText().equalsIgnoreCase(resenja[19]))
    {
        d1.setText(resenja[15]); 
        d2.setText(resenja[16]);
        d3.setText(resenja[17]);
        d4.setText(resenja[18]);
         D.setText(resenja[19]);
        //poeniCovek.setText(Integer.toString(Integer.parseInt(poeniCovek.getText())+10));
        //int skor = Integer.parseInt(poeniCovek.getText())+10;
        //String s = String.valueOf(skor);
        pCovek += 10;
        poeniCovek.setText(String.valueOf(pCovek));
        dKolonaPogodjena = true;
        r.asocijacijePoeniCovek = pCovek;
    }

    }//GEN-LAST:event_DActionPerformed

    private void resenjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resenjeActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
    if(resenje.getText().equalsIgnoreCase(resenja[20]) && !igraKompjuter)
    {
        a1.setText(resenja[0]);  // ako ovo odma postavi onda samo stavis details da je this details =.. tj kao property pa on click update..
        a2.setText(resenja[1]);
        a3.setText(resenja[2]);
        a4.setText(resenja[3]);
        A.setText(resenja[4]);
        
        b1.setText(resenja[5]); 
        b2.setText(resenja[6]);
        b3.setText(resenja[7]);
        b4.setText(resenja[8]);
        B.setText(resenja[9]);
        
        c1.setText(resenja[10]); 
        c2.setText(resenja[11]);
        c3.setText(resenja[12]);
        c4.setText(resenja[13]);
        C.setText(resenja[14]);
        
        d1.setText(resenja[15]); 
        d2.setText(resenja[16]);
        d3.setText(resenja[17]);
        d4.setText(resenja[18]);
        D.setText(resenja[19]);
        
         resenje.setText(resenja[20]);
        //poeniCovek.setText(Integer.toString(Integer.parseInt(poeniCovek.getText())+10));
        //int skor = Integer.parseInt(poeniCovek.getText())+10;
        //String s = String.valueOf(skor);
        if(!aKolonaPogodjena && !bKolonaPogodjena && !cKolonaPogodjena && !dKolonaPogodjena) //1
            pCovek += 50;
        else if (!aKolonaPogodjena && !bKolonaPogodjena && !cKolonaPogodjena && dKolonaPogodjena) //2
            pCovek += 40;
        else if (!aKolonaPogodjena && !bKolonaPogodjena && cKolonaPogodjena && !dKolonaPogodjena) //3
            pCovek += 40;
        else if (!aKolonaPogodjena && !bKolonaPogodjena && cKolonaPogodjena && dKolonaPogodjena) //4
            pCovek += 30;
        else if (!aKolonaPogodjena && bKolonaPogodjena && !cKolonaPogodjena && !dKolonaPogodjena) //5
            pCovek += 40;
        else if (!aKolonaPogodjena && bKolonaPogodjena && !cKolonaPogodjena && dKolonaPogodjena) //6
            pCovek += 30;
        else if (!aKolonaPogodjena && bKolonaPogodjena && cKolonaPogodjena && !dKolonaPogodjena) //7
            pCovek += 30;
        else if (!aKolonaPogodjena && bKolonaPogodjena && cKolonaPogodjena && dKolonaPogodjena) //8
            pCovek += 20;
        else if (aKolonaPogodjena && !bKolonaPogodjena && !cKolonaPogodjena && !dKolonaPogodjena) ///9
            pCovek += 40;
        else if (aKolonaPogodjena && !bKolonaPogodjena && !cKolonaPogodjena && dKolonaPogodjena) //10
            pCovek += 30;
        else if (aKolonaPogodjena && !bKolonaPogodjena && cKolonaPogodjena && !dKolonaPogodjena) //11
            pCovek += 30;
        else if (aKolonaPogodjena && !bKolonaPogodjena && cKolonaPogodjena && dKolonaPogodjena) //12
            pCovek += 20;
        else if (aKolonaPogodjena && bKolonaPogodjena && !cKolonaPogodjena && !dKolonaPogodjena) //13
            pCovek += 30;
        else if (aKolonaPogodjena && bKolonaPogodjena && !cKolonaPogodjena && dKolonaPogodjena) //14
            pCovek += 20;
        else if (aKolonaPogodjena && bKolonaPogodjena && cKolonaPogodjena && !dKolonaPogodjena) //15
            pCovek += 20;
        else if (aKolonaPogodjena && bKolonaPogodjena && cKolonaPogodjena && dKolonaPogodjena) //16
            pCovek += 10;
        //if(aKolona)
        poeniCovek.setText(String.valueOf(pCovek));
        r.asocijacijePoeniCovek = pCovek;
        //igraKompjuter = true;
        i = 0;
    }
    

    }//GEN-LAST:event_resenjeActionPerformed

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
            java.util.logging.Logger.getLogger(ASOCIJACIJE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ASOCIJACIJE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ASOCIJACIJE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ASOCIJACIJE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() { //kad se ovo pokrece
            public void run() {
                try {
                    rezultat r = new rezultat();
                    new ASOCIJACIJE(0.45,r).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ASOCIJACIJE.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
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
        private void getRandomLineFromTheFile(String filePathWithFileName) throws Exception {
        File file = new File(filePathWithFileName); 
        final RandomAccessFile f = new RandomAccessFile(file, "r");
        final long randomLocation = (long) (Math.random() * f.length());
        f.seek(randomLocation);
        f.readLine(); //will move file pointer to the next line
        String randomLine = new String(f.readLine().getBytes("ISO-8859-1"), "UTF-8");
        //String utf8 = new String(randomLine.getBytes("ISO-8859-1"), "UTF-8");
        String[] details = randomLine.split("\t");
         f.close();
         resenja = details;
         /*
        
        a1.setText(details[0]);  // ako ovo odma postavi onda samo stavis details da je this details =.. tj kao property pa on click update..
        a2.setText(details[1]);
        a3.setText(details[2]);
        a4.setText(details[3]);
        A.setText(details[4]);
        
        b1.setText(details[5]); 
        b2.setText(details[6]);
        b3.setText(details[7]);
        b4.setText(details[8]);
        B.setText(details[9]);
        
        c1.setText(details[10]); 
        c2.setText(details[11]);
        c3.setText(details[12]);
        c4.setText(details[13]);
        C.setText(details[14]);
        
        d1.setText(details[15]); 
        d2.setText(details[16]);
        d3.setText(details[17]);
        d4.setText(details[18]);
        D.setText(details[19]);
        
        resenje.setText(details[20]);*/
       
        //return randomLine;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField A;
    private javax.swing.JTextField B;
    private javax.swing.JTextField C;
    private javax.swing.JTextField D;
    private javax.swing.JButton a1;
    private javax.swing.JButton a2;
    private javax.swing.JButton a3;
    private javax.swing.JButton a4;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton c1;
    private javax.swing.JButton c2;
    private javax.swing.JButton c3;
    private javax.swing.JButton c4;
    private javax.swing.JButton d1;
    private javax.swing.JButton d2;
    private javax.swing.JButton d3;
    private javax.swing.JButton d4;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelaCovek;
    private javax.swing.JLabel labelaKompjuter;
    private java.awt.TextField poeniCovek;
    private java.awt.TextField poeniKompjuter;
    private javax.swing.JTextField resenje;
    private javax.swing.JLabel tajmer;
    // End of variables declaration//GEN-END:variables
}
