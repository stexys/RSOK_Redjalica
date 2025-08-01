package redjalica2;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.ThreadLocalRandom;
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
public class skocko extends javax.swing.JFrame {

    /**
     * Creates new form skocko
     */
     private Timer timer ;
     boolean igraKompjuter,kompjuterOdigrao;
     boolean igraCovek = true;
     int pCovek,pKompjuter; 
     int brojac = 1; //do 24
     int i = 60;
     double tezina;//0.45 ua lak, 0.65 za srednji, 0.85 za teski nivo
     rezultat r;
    //public static String[] elementi = {"sivo","ljubicasto","zeleno","plavo","crveno","narandzasto"};
    //public static String[] varijacije = new String[4];
    //public static List<String> rezultat = new ArrayList<>();
    //int[] rez = new int[4];
     ArrayList<Integer> rez = new ArrayList<Integer>(4);

    public skocko(double tezina, rezultat r) {
       
        initComponents();
        this.tezina = tezina;
        this.r = new rezultat(r);
        
            stanje11.setVisible(false);
            stanje12.setVisible(false);
            stanje13.setVisible(false);
            stanje14.setVisible(false);
            
            stanje21.setVisible(false);
            stanje22.setVisible(false);
            stanje23.setVisible(false);
            stanje24.setVisible(false);
            
            stanje31.setVisible(false);
            stanje32.setVisible(false);
            stanje33.setVisible(false);
            stanje34.setVisible(false);
            
            stanje41.setVisible(false);
            stanje42.setVisible(false);
            stanje43.setVisible(false);
            stanje44.setVisible(false);
            
            stanje51.setVisible(false);
            stanje52.setVisible(false);
            stanje53.setVisible(false);
            stanje54.setVisible(false);
            
            stanje61.setVisible(false);
            stanje62.setVisible(false);
            stanje63.setVisible(false);
            stanje64.setVisible(false);

                        //varijacije();
            rez.add(0, ThreadLocalRandom.current().nextInt(1, 6 + 1)); //prvi broj 1 - sivo, 2- ljubicasto, 3- zeleno, 4-plavo, 5-crveno, 6 - narandzasto
            rez.add(1, ThreadLocalRandom.current().nextInt(1, 6 + 1));
            rez.add(2, ThreadLocalRandom.current().nextInt(1, 6 + 1));
            rez.add(3, ThreadLocalRandom.current().nextInt(1, 6 + 1));
            tacno.setVisible(false);
            netacno.setVisible(false);
            nijeNaMestu.setVisible(false);
        
            timer = new Timer(1000, new ActionListener() { // 5000 is five Second
            
                
                
                @Override
            public void actionPerformed(ActionEvent e) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           
            countme();

            
            

            }
        });
      
       timer.start();
    }
    
        public skocko(boolean igraKompjuter, int pCovek,double tezina, rezultat r) throws Exception {
        super();
        initComponents();
            this.r = new rezultat(r); 
            this.tezina = tezina;
            this.stanje11.setVisible(false);
            this.stanje12.setVisible(false);
            this.stanje13.setVisible(false);
            this.stanje14.setVisible(false);
            
            this.stanje21.setVisible(false);
            this.stanje22.setVisible(false);
            this.stanje23.setVisible(false);
            this.stanje24.setVisible(false);
            
            this.stanje31.setVisible(false);
            this.stanje32.setVisible(false);
            this.stanje33.setVisible(false);
            this.stanje34.setVisible(false);
            
            this.stanje41.setVisible(false);
            this.stanje42.setVisible(false);
            this.stanje43.setVisible(false);
            this.stanje44.setVisible(false);
            
            this.stanje51.setVisible(false);
            this.stanje52.setVisible(false);
            this.stanje53.setVisible(false);
            this.stanje54.setVisible(false);
            
            this.stanje61.setVisible(false);
            this.stanje62.setVisible(false);
            this.stanje63.setVisible(false);
            this.stanje64.setVisible(false);

                        //varijacije();
            this.rez.add(0, ThreadLocalRandom.current().nextInt(1, 6 + 1)); //prvi broj 1 - sivo, 2- ljubicasto, 3- zeleno, 4-plavo, 5-crveno, 6 - narandzasto
            this.rez.add(1, ThreadLocalRandom.current().nextInt(1, 6 + 1));
            this.rez.add(2, ThreadLocalRandom.current().nextInt(1, 6 + 1));
            this.rez.add(3, ThreadLocalRandom.current().nextInt(1, 6 + 1));
            this.tacno.setVisible(false);
            this.netacno.setVisible(false);
            this.nijeNaMestu.setVisible(false);
            
            this.igraCovek = false;
            this.igraKompjuter = igraKompjuter;
            this.pCovek = pCovek;
            this.poeniCovek.setText(String.valueOf(pCovek));
            
         /*ova linija moze biti problem posle*/   //this.r = new rezultat(r); //ili this.r = new rezultat(r) ili this.r = r;
            
            timer = new Timer(1000, new ActionListener() { // 5000 is five Second
            @Override
            public void actionPerformed(ActionEvent e) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           
            countme();
            }
        });
      
       timer.start();
    }
    
    
    /*private void varijacije()
   {
    
    permutiraj(0);
    
    final int indeks = (int) (Math.random() * rezultat.size());
    rezultat.indexOf(indeks);
    System.out.println(rezultat);



   }

   private static void permutiraj(int index) {
if (index >= varijacije.length) {
            rezultat.add(String.join(" ", varijacije));
        } else {
            for (int j = 0; j < elementi.length; j++) {
                varijacije[index] = elementi[j];
                permutiraj(index + 1);
            }
        }
    }
    */
    
    
   public void countme(){ //if i == 0 onda ide resenje za bota.. generise rezultat u 
   
   if(i>0)i-- ;
   if(i>0 && brojac == 25) i = 0;
    if(i == 0) {
           i = -1;
           if(!igraKompjuter) //fora je da treba 2 boolean.. 1 ako covek ne resi asocijaciju.. a kompjuter nije igrao
           {igraKompjuter = true;
               skocko a2;
              try {
                  this.dispose(); //bez this?
                  a2 = new skocko(true,pCovek,tezina,r);
                  a2.show();
                  a2.setVisible(true);
                  Random rand = new Random();
                  int nasumicniIzbor;
                  //for(int j =0; i<6;j++)
                  //{      
                  if(Math.random()<tezina) //umesto 0.45 stavis tezina.. a tezina je 0.45, 0.65, 0.85  za tezak nivo
                  {switch (a2.rez.get(0)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }
                  }
                          
                    if(Math.random()<tezina)
                  {switch (a2.rez.get(1)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }}
                          
                   if(Math.random()<tezina)
                  {switch (a2.rez.get(2)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }}
                       
                   if(Math.random()<tezina)
                  {switch (a2.rez.get(3)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }                                
                          //}   
                   
                  }

           if(a2.stanje11.getIcon().equals(a2.tacno.getIcon()) && a2.stanje12.getIcon().equals(a2.tacno.getIcon())&&a2.stanje13.getIcon().equals(a2.tacno.getIcon())&& a2.stanje14.getIcon().equals(a2.tacno.getIcon()))
                     {a2.pKompjuter = 20; a2.poeniKompjuter.setText(String.valueOf(a2.pKompjuter));a2.i = 0; kompjuterOdigrao = true; a2.r.skockoPoeniKompjuter = a2.pKompjuter;}  //dodaj kompjuter
           
         //       if(stanje11.getIcon().equals(tacno.getIcon()) && stanje12.getIcon().equals(tacno.getIcon())&&stanje13.getIcon().equals(tacno.getIcon())&& stanje14.getIcon().equals(tacno.getIcon()))
        //            {pKompjuter = 20; poeniKompjuter.setText(String.valueOf(pKompjuter)); i = 0;kompjuterOdigrao = true;} //moze bez i = 0.. 
                   
 //2
 
                   if(Math.random()<tezina) //umesto 0.45 stavis tezina.. a tezina je 0.45, 0.65, 0.85  za tezak nivo
                  {switch (a2.rez.get(0)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }
                  }
                          
                    if(Math.random()<tezina)
                  {switch (a2.rez.get(1)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }}
                          
                   if(Math.random()<tezina)
                  {switch (a2.rez.get(2)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }}
                       
                   if(Math.random()<tezina)
                  {switch (a2.rez.get(3)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }                                
                          //}   
                   
                  }
      
                              if(a2.stanje21.getIcon().equals(a2.tacno.getIcon()) && a2.stanje22.getIcon().equals(a2.tacno.getIcon())&&a2.stanje23.getIcon().equals(a2.tacno.getIcon())&& a2.stanje24.getIcon().equals(a2.tacno.getIcon()))
                     {a2.pKompjuter = 20; a2.poeniKompjuter.setText(String.valueOf(a2.pKompjuter));a2.i = 0; kompjuterOdigrao = true;a2.r.skockoPoeniKompjuter = a2.pKompjuter;}  //dodaj kompjuter
                // if(stanje21.getIcon().equals(tacno.getIcon()) && stanje22.getIcon().equals(tacno.getIcon())&&stanje23.getIcon().equals(tacno.getIcon())&& stanje24.getIcon().equals(tacno.getIcon()))
                  //   {pKompjuter = 20; poeniKompjuter.setText(String.valueOf(pKompjuter));i = 0;kompjuterOdigrao = true;}               

//3
                  if(Math.random()<tezina) //umesto 0.45 stavis tezina.. a tezina je 0.45, 0.65, 0.85  za tezak nivo
                  {switch (a2.rez.get(0)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }
                  }
                          
                    if(Math.random()<tezina)
                  {switch (a2.rez.get(1)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }}
                          
                   if(Math.random()<tezina)
                  {switch (a2.rez.get(2)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }}
                       
                   if(Math.random()<tezina)
                  {switch (a2.rez.get(3)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }                                
                          //}   
                   
                  }
    
           if(a2.stanje31.getIcon().equals(a2.tacno.getIcon()) && a2.stanje32.getIcon().equals(a2.tacno.getIcon())&&a2.stanje33.getIcon().equals(a2.tacno.getIcon())&& a2.stanje34.getIcon().equals(a2.tacno.getIcon()))
                     {a2.pKompjuter = 20; a2.poeniKompjuter.setText(String.valueOf(a2.pKompjuter));a2.i = 0; kompjuterOdigrao = true;a2.r.skockoPoeniKompjuter = a2.pKompjuter;}  //dodaj kompjuter
           
       //             if(stanje31.getIcon().equals(tacno.getIcon()) && stanje32.getIcon().equals(tacno.getIcon())&&stanje33.getIcon().equals(tacno.getIcon())&& stanje34.getIcon().equals(tacno.getIcon()))
     //                {pKompjuter = 20; poeniKompjuter.setText(String.valueOf(pKompjuter));i = 0;kompjuterOdigrao = true;}                 
                   
//4

                  if(Math.random()<tezina) //umesto 0.45 stavis tezina.. a tezina je 0.45, 0.65, 0.85  za tezak nivo
                  {switch (a2.rez.get(0)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }
                  }
                          
                    if(Math.random()<tezina)
                  {switch (a2.rez.get(1)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }}
                          
                   if(Math.random()<tezina)
                  {switch (a2.rez.get(2)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }}
                       
                   if(Math.random()<tezina)
                  {switch (a2.rez.get(3)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }                                
                          //}   
                   
                  }

            if(a2.stanje41.getIcon().equals(a2.tacno.getIcon()) && a2.stanje42.getIcon().equals(a2.tacno.getIcon())&&a2.stanje43.getIcon().equals(a2.tacno.getIcon())&& a2.stanje44.getIcon().equals(a2.tacno.getIcon()))
                     {a2.pKompjuter = 20; a2.poeniKompjuter.setText(String.valueOf(a2.pKompjuter));a2.i = 0; kompjuterOdigrao = true;a2.r.skockoPoeniKompjuter = a2.pKompjuter;}  //dodaj kompjuter                  
                   
             // if(stanje41.getIcon().equals(tacno.getIcon()) && stanje42.getIcon().equals(tacno.getIcon())&&stanje43.getIcon().equals(tacno.getIcon())&& stanje44.getIcon().equals(tacno.getIcon()))
                 //    {pKompjuter = 20; poeniKompjuter.setText(String.valueOf(pKompjuter));i = 0;kompjuterOdigrao = true;} 
                   
 //5
                   if(Math.random()<tezina) //umesto 0.45 stavis tezina.. a tezina je 0.45, 0.65, 0.85  za tezak nivo
                  {switch (a2.rez.get(0)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }
                  }
                          
                    if(Math.random()<tezina)
                  {switch (a2.rez.get(1)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }}
                          
                   if(Math.random()<tezina)
                  {switch (a2.rez.get(2)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }}
                       
                   if(Math.random()<tezina)
                  {switch (a2.rez.get(3)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }                                
                          //}   
                   
                  }
       
      //                           if(stanje51.getIcon().equals(tacno.getIcon()) && stanje52.getIcon().equals(tacno.getIcon())&&stanje53.getIcon().equals(tacno.getIcon())&& stanje54.getIcon().equals(tacno.getIcon()))
       //              {pKompjuter = 20; poeniKompjuter.setText(String.valueOf(pKompjuter));i = 0;kompjuterOdigrao = true;} 
       
           if(a2.stanje51.getIcon().equals(a2.tacno.getIcon()) && a2.stanje52.getIcon().equals(a2.tacno.getIcon())&&a2.stanje53.getIcon().equals(a2.tacno.getIcon())&& a2.stanje54.getIcon().equals(a2.tacno.getIcon()))
                     {a2.pKompjuter = 20; a2.poeniKompjuter.setText(String.valueOf(a2.pKompjuter));a2.i = 0; kompjuterOdigrao = true;a2.r.skockoPoeniKompjuter = a2.pKompjuter;}  //dodaj kompjuter       
       
       
 //6 -- odradi 6 poteza ali mi izgenerise odma sledecu igru (otvori prozor)..
 
                   if(Math.random()<tezina) //umesto 0.45 stavis tezina.. a tezina je 0.45, 0.65, 0.85  za tezak nivo
                  {switch (a2.rez.get(0)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }
                  }
                          
                    if(Math.random()<tezina)
                  {switch (a2.rez.get(1)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }}
                          
                   if(Math.random()<tezina)
                  {switch (a2.rez.get(2)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }}
                       
                   if(Math.random()<tezina)
                  {switch (a2.rez.get(3)) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;                           
                          default:
                              throw new AssertionError();
                      }
                  }
                  
                  else{ 
                          nasumicniIzbor = rand.nextInt(1,7);
                          switch (nasumicniIzbor) {
                          case 1: a2.sivo.doClick(); break;
                          case 2: a2.ljubicasto.doClick(); break;
                          case 3: a2.zeleno.doClick(); break;
                          case 4: a2.plavo.doClick(); break;
                          case 5: a2.crveno.doClick(); break;
                          case 6: a2.narandzasto.doClick(); break;
                          default:
                              throw new AssertionError();
                      }                                
                          //}   
                   
                  }
              if(a2.stanje61.getIcon().equals(a2.tacno.getIcon()) && a2.stanje62.getIcon().equals(a2.tacno.getIcon())&&a2.stanje63.getIcon().equals(a2.tacno.getIcon())&& a2.stanje64.getIcon().equals(a2.tacno.getIcon()))
                     {a2.pKompjuter = 20; a2.poeniKompjuter.setText(String.valueOf(a2.pKompjuter));a2.i = 0; kompjuterOdigrao = true;a2.r.skockoPoeniKompjuter = a2.pKompjuter;}  //dodaj kompjuterOdigrao = true; ?                  
                   
                   
                   kompjuterOdigrao = true;
                      if(kompjuterOdigrao) //ovaj deo koda nije potreban
       {      
            //treba a2 dispose?
           //ovaj kod ne ide tu
        //  a2.dispose(); //treba neki counter mozda prosledi u konstruktor pa posle dispose
        KOZNAZNA k1 = new KOZNAZNA(tezina,a2.r);//ovde se prosledjuje tezina, poeni igraca i poeni kompjutera, 
        //a u ovom slucaju i a2 skocko.. posle se terminiraju zajedno na kraju
        k1.show();
        k1.setVisible(true);
        
        
       }    
                   /*long t= System.currentTimeMillis();
                   long end = t+15000;
                   KOZNAZNA k1 = new KOZNAZNA();
                   k1.show();
                   while(System.currentTimeMillis() < end) {
                    }*/
                   
                     //a2.dispose(); //treba a2 dispose?
           //ovaj kod ne ide tu


                    //a2.dispose(); //ova linija
                    //
                    
                    
                  //Collections.shuffle(Arrays.asList());
                  //a2.rez;
                  
                  
                  
                  //Random rand = new Random();
                  //boolean val = rand.nextInt(25)==0;
                  
                  
                  
                  //u zavisnosti od tezine.. lako 0-30%
                 /* a2.a1.doClick();
                  //Thread.sleep(2000);
                  a2.a2.doClick();
                  //Thread.sleep(2000);
                  a2.a3.doClick();
                  //Thread.sleep(2000);
                  a2.a4.doClick();
                  //Thread.sleep(2000);
                  
                  //ako je uslov prosao, dobija poene svakako racunar.. i na kraju se diposuje..
                  if(Math.random()<0.45) //85% sanse && tezina - tesko, za lako idk koji % oko 45, srednje 65%
                  {a2.A.setText(a2.resenja[4]); //treba ti A.textChanged.. 
                      a2.pKompjuter+=10;
                      a2.poeniKompjuter.setText(String.valueOf(a2.pKompjuter));}
                       //za tezak nivo
                  
                  a2.b1.doClick();
                  //Thread.sleep(2000);
                  a2.b2.doClick();
                  //Thread.sleep(2000);
                  a2.b3.doClick();
                  //Thread.sleep(2000);
                  a2.b4.doClick();
                  
                 
                  if(Math.random()<0.45) //85% sanse && tezina - tesko, za lako idk koji % oko 45, srednje 65%
                  {a2.B.setText(a2.resenja[9]); //treba ti A.textChanged..
                       //za tezak nivo
                       a2.pKompjuter+=10;   
                      a2.poeniKompjuter.setText(String.valueOf(a2.pKompjuter));
                      
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
                  
               
                  if(Math.random()<0.45) //85% sanse && tezina - tesko, za lako idk koji % oko 45, srednje 65%
                  {a2.C.setText(a2.resenja[14]); //treba ti A.textChanged..
                       //za tezak nivo   
                      a2.pKompjuter+=10;
                      a2.poeniKompjuter.setText(String.valueOf(a2.pKompjuter));}

                  //u zavisnosti od tezine.. lako 0-30%
                  a2.d1.doClick();
                  //Thread.sleep(2000);
                  a2.d2.doClick();
                  //Thread.sleep(2000);
                  a2.d3.doClick();
                  //Thread.sleep(2000);
                  a2.d4.doClick();
                  //Thread.sleep(2000);
                  
                  
                  if(Math.random()<0.45) //85% sanse && tezina - tesko, za lako idk koji % oko 45, srednje 65%
                  { a2.D.setText(a2.resenja[19]); //treba ti A.textChanged..
                       //za tezak nivo         
                      a2.pKompjuter+=10;
                      a2.poeniKompjuter.setText(String.valueOf(a2.pKompjuter));}
  
                  
                  if(Math.random()<0.45) //85% sanse && tezina - tesko, za lako idk koji % oko 45, srednje 65%
                  {a2.resenje.setText(a2.resenja[20]); //treba ti A.textChanged..
                       //za tezak nivo                       
                      a2.pKompjuter+=10;
                      a2.poeniKompjuter.setText(String.valueOf(a2.pKompjuter));}   
                  
                  a2.poeniKompjuter.setText(String.valueOf(a2.pKompjuter));*/
                  
              } catch (Exception ex) {
                  Logger.getLogger(skocko.class.getName()).log(Level.SEVERE, null, ex);
              }
       }
         /*  
       if(kompjuterOdigrao) //ovaj deo koda nije potreban
       {      
           dispose(); //treba a2 dispose?
           //ovaj kod ne ide tu
        KOZNAZNA k1 = new KOZNAZNA();
        k1.show();
       }
           */
       
            //i prikaz statistike pobednika
       }
   
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

        jPanel50 = new javax.swing.JPanel();
        tajmer = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        plavo = new javax.swing.JButton();
        crveno = new javax.swing.JButton();
        ljubicasto = new javax.swing.JButton();
        zeleno = new javax.swing.JButton();
        sivo = new javax.swing.JButton();
        narandzasto = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        pokusaj11 = new javax.swing.JButton();
        pokusaj13 = new javax.swing.JButton();
        pokusaj14 = new javax.swing.JButton();
        pokusaj12 = new javax.swing.JButton();
        pokusaj22 = new javax.swing.JButton();
        pokusaj23 = new javax.swing.JButton();
        pokusaj24 = new javax.swing.JButton();
        pokusaj21 = new javax.swing.JButton();
        pokusaj32 = new javax.swing.JButton();
        pokusaj33 = new javax.swing.JButton();
        pokusaj34 = new javax.swing.JButton();
        pokusaj31 = new javax.swing.JButton();
        pokusaj42 = new javax.swing.JButton();
        pokusaj43 = new javax.swing.JButton();
        pokusaj44 = new javax.swing.JButton();
        pokusaj41 = new javax.swing.JButton();
        pokusaj52 = new javax.swing.JButton();
        pokusaj53 = new javax.swing.JButton();
        pokusaj54 = new javax.swing.JButton();
        pokusaj51 = new javax.swing.JButton();
        pokusaj62 = new javax.swing.JButton();
        pokusaj63 = new javax.swing.JButton();
        pokusaj64 = new javax.swing.JButton();
        pokusaj61 = new javax.swing.JButton();
        labelaCovek = new javax.swing.JLabel();
        labelaKompjuter = new javax.swing.JLabel();
        poeniKompjuter = new java.awt.TextField();
        poeniCovek = new java.awt.TextField();
        stanje23 = new javax.swing.JLabel();
        stanje24 = new javax.swing.JLabel();
        stanje22 = new javax.swing.JLabel();
        stanje11 = new javax.swing.JLabel();
        stanje21 = new javax.swing.JLabel();
        stanje13 = new javax.swing.JLabel();
        stanje41 = new javax.swing.JLabel();
        stanje42 = new javax.swing.JLabel();
        stanje43 = new javax.swing.JLabel();
        stanje44 = new javax.swing.JLabel();
        stanje54 = new javax.swing.JLabel();
        stanje53 = new javax.swing.JLabel();
        stanje52 = new javax.swing.JLabel();
        stanje51 = new javax.swing.JLabel();
        stanje61 = new javax.swing.JLabel();
        stanje62 = new javax.swing.JLabel();
        stanje63 = new javax.swing.JLabel();
        stanje64 = new javax.swing.JLabel();
        stanje14 = new javax.swing.JLabel();
        stanje12 = new javax.swing.JLabel();
        stanje33 = new javax.swing.JLabel();
        stanje34 = new javax.swing.JLabel();
        stanje32 = new javax.swing.JLabel();
        stanje31 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nijeNaMestu = new javax.swing.JLabel();
        tacno = new javax.swing.JLabel();
        netacno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel50.setBackground(new java.awt.Color(198, 220, 186));
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tajmer.setFont(new java.awt.Font("Comic Sans MS", 3, 48)); // NOI18N
        tajmer.setForeground(new java.awt.Color(215, 228, 192));
        tajmer.setText("0");
        jPanel50.add(tajmer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, -1));

        jButton12.setBackground(new java.awt.Color(215, 228, 192));
        jButton12.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(127, 127, 127));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/back-removebg-preview.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel50.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 680, 60, 60));

        jButton4.setBackground(new java.awt.Color(215, 228, 192));
        jButton4.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(127, 127, 127));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/close-removebg-preview.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel50.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, 60, 60));

        plavo.setBackground(new java.awt.Color(215, 228, 192));
        plavo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja2-removebg-preview.png"))); // NOI18N
        plavo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plavoActionPerformed(evt);
            }
        });
        jPanel50.add(plavo, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 440, 50, 50));

        crveno.setBackground(new java.awt.Color(215, 228, 192));
        crveno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja1-Photoroom.png"))); // NOI18N
        crveno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crvenoActionPerformed(evt);
            }
        });
        jPanel50.add(crveno, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 500, 50, 50));

        ljubicasto.setBackground(new java.awt.Color(215, 228, 192));
        ljubicasto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/BOJA4-removebg-preview.png"))); // NOI18N
        ljubicasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ljubicastoActionPerformed(evt);
            }
        });
        jPanel50.add(ljubicasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 320, 50, 50));

        zeleno.setBackground(new java.awt.Color(215, 228, 192));
        zeleno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/bojA3-removebg-preview.png"))); // NOI18N
        zeleno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zelenoActionPerformed(evt);
            }
        });
        jPanel50.add(zeleno, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 50, 50));

        sivo.setBackground(new java.awt.Color(215, 228, 192));
        sivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja6-removebg-preview.png"))); // NOI18N
        sivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sivoActionPerformed(evt);
            }
        });
        jPanel50.add(sivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 50, 50));

        narandzasto.setBackground(new java.awt.Color(215, 228, 192));
        narandzasto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja5-removebg-preview.png"))); // NOI18N
        narandzasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                narandzastoActionPerformed(evt);
            }
        });
        jPanel50.add(narandzasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 560, 50, 50));

        jButton9.setBackground(new java.awt.Color(215, 228, 192));
        jButton9.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(127, 127, 127));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/zvučnik-removebg-preview.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel50.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 680, 60, 60));

        pokusaj11.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja6-removebg-preview.png"))); // NOI18N
        pokusaj11.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pokusaj11StateChanged(evt);
            }
        });
        pokusaj11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj11ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 50, 50));

        pokusaj13.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja6-removebg-preview.png"))); // NOI18N
        pokusaj13.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pokusaj13StateChanged(evt);
            }
        });
        pokusaj13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj13ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj13, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 50, 50));

        pokusaj14.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja6-removebg-preview.png"))); // NOI18N
        pokusaj14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj14ActionPerformed(evt);
            }
        });
        pokusaj14.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                pokusaj14PropertyChange(evt);
            }
        });
        jPanel50.add(pokusaj14, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 50, 50));

        pokusaj12.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja6-removebg-preview.png"))); // NOI18N
        pokusaj12.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pokusaj12StateChanged(evt);
            }
        });
        pokusaj12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj12ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 50, 50));

        pokusaj22.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/BOJA4-removebg-preview.png"))); // NOI18N
        pokusaj22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj22ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj22, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 50, 50));

        pokusaj23.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/BOJA4-removebg-preview.png"))); // NOI18N
        pokusaj23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj23ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj23, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 50, 50));

        pokusaj24.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/BOJA4-removebg-preview.png"))); // NOI18N
        pokusaj24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj24ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj24, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 50, 50));

        pokusaj21.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/BOJA4-removebg-preview.png"))); // NOI18N
        pokusaj21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj21ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj21, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 50, 50));

        pokusaj32.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/bojA3-removebg-preview.png"))); // NOI18N
        pokusaj32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj32ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj32, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, 50, 50));

        pokusaj33.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/bojA3-removebg-preview.png"))); // NOI18N
        pokusaj33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj33ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj33, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 50, 50));

        pokusaj34.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/bojA3-removebg-preview.png"))); // NOI18N
        pokusaj34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj34ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj34, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 50, 50));

        pokusaj31.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/bojA3-removebg-preview.png"))); // NOI18N
        pokusaj31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj31ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj31, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 50, 50));

        pokusaj42.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja2-removebg-preview.png"))); // NOI18N
        pokusaj42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj42ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj42, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, 50, 50));

        pokusaj43.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja2-removebg-preview.png"))); // NOI18N
        pokusaj43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj43ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj43, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 50, 50));

        pokusaj44.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja2-removebg-preview.png"))); // NOI18N
        pokusaj44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj44ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj44, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 440, 50, 50));

        pokusaj41.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja2-removebg-preview.png"))); // NOI18N
        pokusaj41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj41ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj41, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, 50, 50));

        pokusaj52.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja1-Photoroom.png"))); // NOI18N
        pokusaj52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj52ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj52, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 50, 50));

        pokusaj53.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja1-Photoroom.png"))); // NOI18N
        pokusaj53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj53ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj53, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 500, 50, 50));

        pokusaj54.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja1-Photoroom.png"))); // NOI18N
        pokusaj54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj54ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj54, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 500, 50, 50));

        pokusaj51.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja1-Photoroom.png"))); // NOI18N
        pokusaj51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj51ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj51, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 50, 50));

        pokusaj62.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja5-removebg-preview.png"))); // NOI18N
        pokusaj62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj62ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj62, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 560, 50, 50));

        pokusaj63.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja5-removebg-preview.png"))); // NOI18N
        pokusaj63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj63ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj63, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 560, 50, 50));

        pokusaj64.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja5-removebg-preview.png"))); // NOI18N
        pokusaj64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj64ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj64, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 560, 50, 50));

        pokusaj61.setBackground(new java.awt.Color(187, 195, 164));
        pokusaj61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/boja5-removebg-preview.png"))); // NOI18N
        pokusaj61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokusaj61ActionPerformed(evt);
            }
        });
        jPanel50.add(pokusaj61, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, 50, 50));

        labelaCovek.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        labelaCovek.setForeground(new java.awt.Color(215, 228, 192));
        labelaCovek.setText("ČOVEK");
        jPanel50.add(labelaCovek, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 60, -1, -1));

        labelaKompjuter.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        labelaKompjuter.setForeground(new java.awt.Color(215, 228, 192));
        labelaKompjuter.setText("KOMPJUTER");
        jPanel50.add(labelaKompjuter, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        poeniKompjuter.setBackground(new java.awt.Color(187, 195, 164));
        poeniKompjuter.setEditable(false);
        poeniKompjuter.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jPanel50.add(poeniKompjuter, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 80, 40));

        poeniCovek.setBackground(new java.awt.Color(187, 195, 164));
        poeniCovek.setEditable(false);
        poeniCovek.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jPanel50.add(poeniCovek, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 60, 80, 40));

        stanje23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/tacno-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje23, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, -1, 30));

        stanje24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/tacno-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje24, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, -1, 30));

        stanje22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/tacno-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje22, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, -1, 30));

        stanje11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/nijenamestu-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, -1, 30));

        stanje21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/tacno-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje21, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, -1, 30));

        stanje13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/nijenamestu-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje13, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, -1, 30));

        stanje41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/nijenamestu-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje41, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, -1, 30));

        stanje42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/nijenamestu-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje42, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, -1, 30));

        stanje43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/nijenamestu-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje43, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, -1, 30));

        stanje44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/nijenamestu-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje44, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 440, -1, 30));

        stanje54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/tacno-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje54, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 500, -1, 30));

        stanje53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/tacno-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje53, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 500, -1, 30));

        stanje52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/tacno-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje52, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 500, -1, 30));

        stanje51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/tacno-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje51, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, -1, 30));

        stanje61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/netacno-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje61, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 560, 30, 30));

        stanje62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/netacno-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje62, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 560, 30, 30));

        stanje63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/netacno-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje63, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 560, 30, 30));

        stanje64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/netacno-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje64, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 560, 30, 30));

        stanje14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/nijenamestu-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje14, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, -1, 30));

        stanje12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/nijenamestu-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje12, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, -1, 30));

        stanje33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/netacno-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje33, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, 30, 30));

        stanje34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/netacno-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje34, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 30, 30));

        stanje32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/netacno-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje32, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 30, 30));

        stanje31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/netacno-removebg-preview.png"))); // NOI18N
        jPanel50.add(stanje31, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, 30, 30));

        jLabel3.setBackground(new java.awt.Color(198, 220, 186));
        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 3, 80)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(215, 228, 192));
        jLabel3.setText("MIŠ");
        jPanel50.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 180, -1));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 3, 80)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 127, 127));
        jLabel4.setText("MIŠ");
        jPanel50.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 190, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/vecavecaplocica643.png"))); // NOI18N
        jPanel50.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 1200, 630));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/pozadina1234.png"))); // NOI18N
        jLabel6.setText("jLabel2");
        jPanel50.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1100, 770));

        nijeNaMestu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/nijenamestu-removebg-preview.png"))); // NOI18N
        jPanel50.add(nijeNaMestu, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, -1, 30));

        tacno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/tacno-removebg-preview.png"))); // NOI18N
        jPanel50.add(tacno, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, -1, 30));

        netacno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/redjalica/slike/netacno-removebg-preview.png"))); // NOI18N
        jPanel50.add(netacno, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, 30, 30));

        getContentPane().add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void crvenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crvenoActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
        switch (brojac) {
             case 1 -> {pokusaj11.setIcon(crveno.getIcon()); if(rez.get(0) == 5) {stanje11.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje11.setIcon(nijeNaMestu.getIcon());} else{stanje11.setIcon(netacno.getIcon());} brojac++; break;} //ovo ne valja
             case 2 -> {pokusaj12.setIcon(crveno.getIcon());  if(rez.get(1) == 5) {stanje12.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje12.setIcon(nijeNaMestu.getIcon());} else{stanje12.setIcon(netacno.getIcon());} brojac++; break;}
             case 3 -> {pokusaj13.setIcon(crveno.getIcon()); if(rez.get(2) == 5) {stanje13.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje13.setIcon(nijeNaMestu.getIcon());} else{stanje13.setIcon(netacno.getIcon());} brojac++; break;}
             case 4 -> {
                 stanje11.setVisible(true);
                 stanje12.setVisible(true);
                 stanje13.setVisible(true);
                 stanje14.setVisible(true);
                 
                 pokusaj14.setIcon(crveno.getIcon()); if(rez.get(3) == 5) {stanje14.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje14.setIcon(nijeNaMestu.getIcon());} else{stanje14.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje11.getIcon().equals(tacno.getIcon()) && stanje12.getIcon().equals(tacno.getIcon())&&stanje13.getIcon().equals(tacno.getIcon())&& stanje14.getIcon().equals(tacno.getIcon()))
                    {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek)); i = 0; r.skockoPoeniCovek = pCovek;}                  
                 break;} //pogodio je, treba staviti varijablu da igra racunar, i dispose..
             case 5 -> {pokusaj21.setIcon(crveno.getIcon()); if(rez.get(0) == 5) {stanje21.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje21.setIcon(nijeNaMestu.getIcon());} else{stanje21.setIcon(netacno.getIcon());} brojac++; break;}
             case 6 -> {pokusaj22.setIcon(crveno.getIcon()); if(rez.get(1) == 5) {stanje22.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje22.setIcon(nijeNaMestu.getIcon());} else{stanje22.setIcon(netacno.getIcon());} brojac++; break;}
             case 7 -> {pokusaj23.setIcon(crveno.getIcon()); if(rez.get(2) == 5) {stanje23.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje23.setIcon(nijeNaMestu.getIcon());} else{stanje23.setIcon(netacno.getIcon());} brojac++; break;}
             case 8 -> {
                 stanje21.setVisible(true);
                 stanje22.setVisible(true);
                 stanje23.setVisible(true);
                 stanje24.setVisible(true);                 
                 
                 pokusaj24.setIcon(crveno.getIcon()); if(rez.get(3) == 5) {stanje24.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje24.setIcon(nijeNaMestu.getIcon());} else{stanje24.setIcon(netacno.getIcon());} brojac++; 
                  if(igraCovek && stanje21.getIcon().equals(tacno.getIcon()) && stanje22.getIcon().equals(tacno.getIcon())&&stanje23.getIcon().equals(tacno.getIcon())&& stanje24.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                
                 break;}
             case 9 -> {pokusaj31.setIcon(crveno.getIcon()); if(rez.get(0) == 5) {stanje31.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje31.setIcon(nijeNaMestu.getIcon());} else{stanje31.setIcon(netacno.getIcon());} brojac++; break;}
             case 10 -> {pokusaj32.setIcon(crveno.getIcon()); if(rez.get(1) == 5) {stanje32.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje32.setIcon(nijeNaMestu.getIcon());} else{stanje32.setIcon(netacno.getIcon());} brojac++; break;}
             case 11 -> {pokusaj33.setIcon(crveno.getIcon()); if(rez.get(2) == 5) {stanje33.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje33.setIcon(nijeNaMestu.getIcon());} else{stanje33.setIcon(netacno.getIcon());} brojac++; break;}
             case 12 -> {
                 stanje31.setVisible(true);
                 stanje32.setVisible(true);
                 stanje33.setVisible(true);
                 stanje34.setVisible(true);                 
                 
                 pokusaj34.setIcon(crveno.getIcon()); if(rez.get(3) == 5) {stanje34.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje34.setIcon(nijeNaMestu.getIcon());} else{stanje34.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje31.getIcon().equals(tacno.getIcon()) && stanje32.getIcon().equals(tacno.getIcon())&&stanje33.getIcon().equals(tacno.getIcon())&& stanje34.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             case 13 -> {pokusaj41.setIcon(crveno.getIcon()); if(rez.get(0) == 5) {stanje41.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje41.setIcon(nijeNaMestu.getIcon());} else{stanje41.setIcon(netacno.getIcon());} brojac++; break;}
             case 14 ->{pokusaj42.setIcon(crveno.getIcon()); if(rez.get(1) == 5) {stanje42.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje42.setIcon(nijeNaMestu.getIcon());} else{stanje42.setIcon(netacno.getIcon());} brojac++; break;}
             case 15 -> {pokusaj43.setIcon(crveno.getIcon()); if(rez.get(2) == 5) {stanje43.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje43.setIcon(nijeNaMestu.getIcon());} else{stanje43.setIcon(netacno.getIcon());} brojac++; break;}
             case 16 -> {
                 stanje41.setVisible(true);
                 stanje42.setVisible(true);
                 stanje43.setVisible(true);
                 stanje44.setVisible(true);    
                 
                 pokusaj44.setIcon(crveno.getIcon()); if(rez.get(3) == 5) {stanje44.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje44.setIcon(nijeNaMestu.getIcon());} else{stanje44.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje41.getIcon().equals(tacno.getIcon()) && stanje42.getIcon().equals(tacno.getIcon())&&stanje43.getIcon().equals(tacno.getIcon())&& stanje44.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             case 17 -> {pokusaj51.setIcon(crveno.getIcon()); if(rez.get(0) == 5) {stanje51.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje51.setIcon(nijeNaMestu.getIcon());} else{stanje51.setIcon(netacno.getIcon());} brojac++; break;}
             case 18 -> {pokusaj52.setIcon(crveno.getIcon()); if(rez.get(1) == 5) {stanje52.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje52.setIcon(nijeNaMestu.getIcon());} else{stanje52.setIcon(netacno.getIcon());} brojac++; break;}
             case 19 -> {pokusaj53.setIcon(crveno.getIcon()); if(rez.get(2) == 5) {stanje53.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje53.setIcon(nijeNaMestu.getIcon());} else{stanje53.setIcon(netacno.getIcon());} brojac++; break;}
             case 20 -> {
                 stanje51.setVisible(true);
                 stanje52.setVisible(true);
                 stanje53.setVisible(true);
                 stanje54.setVisible(true);                
                 
                 pokusaj54.setIcon(crveno.getIcon()); if(rez.get(3) == 5) {stanje54.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje54.setIcon(nijeNaMestu.getIcon());} else{stanje54.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje51.getIcon().equals(tacno.getIcon()) && stanje52.getIcon().equals(tacno.getIcon())&&stanje53.getIcon().equals(tacno.getIcon())&& stanje54.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             case 21 -> {pokusaj61.setIcon(crveno.getIcon()); if(rez.get(0) == 5) {stanje61.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje61.setIcon(nijeNaMestu.getIcon());} else{stanje61.setIcon(netacno.getIcon());} brojac++; break;}
             case 22 -> {pokusaj62.setIcon(crveno.getIcon()); if(rez.get(1) == 5) {stanje62.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje62.setIcon(nijeNaMestu.getIcon());} else{stanje62.setIcon(netacno.getIcon());} brojac++; break;}
             case 23 -> {pokusaj63.setIcon(crveno.getIcon()); if(rez.get(2) == 5) {stanje63.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje63.setIcon(nijeNaMestu.getIcon());} else{stanje63.setIcon(netacno.getIcon());} brojac++; break;}
             case 24 -> {
                 stanje61.setVisible(true);
                 stanje62.setVisible(true);
                 stanje63.setVisible(true);
                 stanje64.setVisible(true);       
                 
                 pokusaj64.setIcon(crveno.getIcon()); if(rez.get(3) == 5) {stanje64.setIcon(tacno.getIcon());} else if (rez.contains(5)){stanje64.setIcon(nijeNaMestu.getIcon());} else{stanje64.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje61.getIcon().equals(tacno.getIcon()) && stanje62.getIcon().equals(tacno.getIcon())&&stanje63.getIcon().equals(tacno.getIcon())&& stanje64.getIcon().equals(tacno.getIcon()))
                 {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             
             default -> {
             }
         }

    }//GEN-LAST:event_crvenoActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
       //Icon ikona = new Icon()
       stanje31.setIcon(stanje13.getIcon());

    }//GEN-LAST:event_jButton9ActionPerformed

    private void narandzastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_narandzastoActionPerformed
playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
switch (brojac) {
             case 1 -> {pokusaj11.setIcon(narandzasto.getIcon()); if(rez.get(0) == 6) {stanje11.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje11.setIcon(nijeNaMestu.getIcon());} else{stanje11.setIcon(netacno.getIcon());} brojac++; break;} //ovo ne valja
             case 2 -> {pokusaj12.setIcon(narandzasto.getIcon());  if(rez.get(1) == 6) {stanje12.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje12.setIcon(nijeNaMestu.getIcon());} else{stanje12.setIcon(netacno.getIcon());} brojac++; break;}
             case 3 -> {pokusaj13.setIcon(narandzasto.getIcon()); if(rez.get(2) == 6) {stanje13.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje13.setIcon(nijeNaMestu.getIcon());} else{stanje13.setIcon(netacno.getIcon());} brojac++; break;}
             case 4 -> {
                 stanje11.setVisible(true);
                 stanje12.setVisible(true);
                 stanje13.setVisible(true);
                 stanje14.setVisible(true);                 
                 
                 pokusaj14.setIcon(narandzasto.getIcon()); if(rez.get(3) == 6) {stanje14.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje14.setIcon(nijeNaMestu.getIcon());} else{stanje14.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje11.getIcon().equals(tacno.getIcon()) && stanje12.getIcon().equals(tacno.getIcon())&&stanje13.getIcon().equals(tacno.getIcon())&& stanje14.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             case 5 -> {pokusaj21.setIcon(narandzasto.getIcon()); if(rez.get(0) == 6) {stanje21.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje21.setIcon(nijeNaMestu.getIcon());} else{stanje21.setIcon(netacno.getIcon());} brojac++; break;}
             case 6 -> {pokusaj22.setIcon(narandzasto.getIcon()); if(rez.get(1) == 6) {stanje22.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje22.setIcon(nijeNaMestu.getIcon());} else{stanje22.setIcon(netacno.getIcon());} brojac++; break;}
             case 7 -> {pokusaj23.setIcon(narandzasto.getIcon()); if(rez.get(2) == 6) {stanje23.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje23.setIcon(nijeNaMestu.getIcon());} else{stanje23.setIcon(netacno.getIcon());} brojac++; break;}
             case 8 -> {
                 stanje21.setVisible(true);
                 stanje22.setVisible(true);
                 stanje23.setVisible(true);
                 stanje24.setVisible(true);
                 
                 pokusaj24.setIcon(narandzasto.getIcon()); if(rez.get(3) == 6) {stanje24.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje24.setIcon(nijeNaMestu.getIcon());} else{stanje24.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje21.getIcon().equals(tacno.getIcon()) && stanje22.getIcon().equals(tacno.getIcon())&&stanje23.getIcon().equals(tacno.getIcon())&& stanje24.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             case 9 -> {pokusaj31.setIcon(narandzasto.getIcon()); if(rez.get(0) == 6) {stanje31.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje31.setIcon(nijeNaMestu.getIcon());} else{stanje31.setIcon(netacno.getIcon());} brojac++; break;}
             case 10 -> {pokusaj32.setIcon(narandzasto.getIcon()); if(rez.get(1) == 6) {stanje32.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje32.setIcon(nijeNaMestu.getIcon());} else{stanje32.setIcon(netacno.getIcon());} brojac++; break;}
             case 11 -> {pokusaj33.setIcon(narandzasto.getIcon()); if(rez.get(2) == 6) {stanje33.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje33.setIcon(nijeNaMestu.getIcon());} else{stanje33.setIcon(netacno.getIcon());} brojac++; break;}
             case 12 -> {
                 stanje31.setVisible(true);
                 stanje32.setVisible(true);
                 stanje33.setVisible(true);
                 stanje34.setVisible(true);
                 
                 pokusaj34.setIcon(narandzasto.getIcon()); if(rez.get(3) == 6) {stanje34.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje34.setIcon(nijeNaMestu.getIcon());} else{stanje34.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje31.getIcon().equals(tacno.getIcon()) && stanje32.getIcon().equals(tacno.getIcon())&&stanje33.getIcon().equals(tacno.getIcon())&& stanje34.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             case 13 -> {pokusaj41.setIcon(narandzasto.getIcon()); if(rez.get(0) == 6) {stanje41.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje41.setIcon(nijeNaMestu.getIcon());} else{stanje41.setIcon(netacno.getIcon());} brojac++; break;}
             case 14 ->{pokusaj42.setIcon(narandzasto.getIcon()); if(rez.get(1) == 6) {stanje42.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje42.setIcon(nijeNaMestu.getIcon());} else{stanje42.setIcon(netacno.getIcon());} brojac++; break;}
             case 15 -> {pokusaj43.setIcon(narandzasto.getIcon()); if(rez.get(2) == 6) {stanje43.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje43.setIcon(nijeNaMestu.getIcon());} else{stanje43.setIcon(netacno.getIcon());} brojac++; break;}
             case 16 -> {
                 stanje41.setVisible(true);
                 stanje42.setVisible(true);
                 stanje43.setVisible(true);
                 stanje44.setVisible(true);                
                 
                 pokusaj44.setIcon(narandzasto.getIcon()); if(rez.get(3) == 6) {stanje44.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje44.setIcon(nijeNaMestu.getIcon());} else{stanje44.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje41.getIcon().equals(tacno.getIcon()) && stanje42.getIcon().equals(tacno.getIcon())&&stanje43.getIcon().equals(tacno.getIcon())&& stanje44.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             case 17 -> {pokusaj51.setIcon(narandzasto.getIcon()); if(rez.get(0) == 6) {stanje51.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje51.setIcon(nijeNaMestu.getIcon());} else{stanje51.setIcon(netacno.getIcon());} brojac++; break;}
             case 18 -> {pokusaj52.setIcon(narandzasto.getIcon()); if(rez.get(1) == 6) {stanje52.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje52.setIcon(nijeNaMestu.getIcon());} else{stanje52.setIcon(netacno.getIcon());} brojac++; break;}
             case 19 -> {pokusaj53.setIcon(narandzasto.getIcon()); if(rez.get(2) == 6) {stanje53.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje53.setIcon(nijeNaMestu.getIcon());} else{stanje53.setIcon(netacno.getIcon());} brojac++; break;}
             case 20 -> {
                 stanje51.setVisible(true);
                 stanje52.setVisible(true);
                 stanje53.setVisible(true);
                 stanje54.setVisible(true);                 
                 
                 pokusaj54.setIcon(narandzasto.getIcon()); if(rez.get(3) == 6) {stanje54.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje54.setIcon(nijeNaMestu.getIcon());} else{stanje54.setIcon(netacno.getIcon());} brojac++; 
                  if(igraCovek && stanje51.getIcon().equals(tacno.getIcon()) && stanje52.getIcon().equals(tacno.getIcon())&&stanje53.getIcon().equals(tacno.getIcon())&& stanje54.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                
                 break;}
             case 21 -> {pokusaj61.setIcon(narandzasto.getIcon()); if(rez.get(0) == 6) {stanje61.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje61.setIcon(nijeNaMestu.getIcon());} else{stanje61.setIcon(netacno.getIcon());} brojac++; break;}
             case 22 -> {pokusaj62.setIcon(narandzasto.getIcon()); if(rez.get(1) == 6) {stanje62.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje62.setIcon(nijeNaMestu.getIcon());} else{stanje62.setIcon(netacno.getIcon());} brojac++; break;}
             case 23 -> {pokusaj63.setIcon(narandzasto.getIcon()); if(rez.get(2) == 6) {stanje63.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje63.setIcon(nijeNaMestu.getIcon());} else{stanje63.setIcon(netacno.getIcon());} brojac++; break;}
             case 24 -> {
                 stanje61.setVisible(true);
                 stanje62.setVisible(true);
                 stanje63.setVisible(true);
                 stanje64.setVisible(true);                 
                 
                 pokusaj64.setIcon(narandzasto.getIcon()); if(rez.get(3) == 6) {stanje64.setIcon(tacno.getIcon());} else if (rez.contains(6)){stanje64.setIcon(nijeNaMestu.getIcon());} else{stanje64.setIcon(netacno.getIcon());} brojac++; 
                  if(igraCovek && stanje61.getIcon().equals(tacno.getIcon()) && stanje62.getIcon().equals(tacno.getIcon())&&stanje63.getIcon().equals(tacno.getIcon())&& stanje64.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                
                 break;}
             
             default -> {
             }
         }

    }//GEN-LAST:event_narandzastoActionPerformed

    private void sivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sivoActionPerformed
        playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
          switch (brojac) {
             case 1 -> {pokusaj11.setIcon(sivo.getIcon()); if(rez.get(0) == 1 && pokusaj11.getIcon().equals(sivo.getIcon())) {stanje11.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje11.setIcon(nijeNaMestu.getIcon());} else{stanje11.setIcon(netacno.getIcon());} brojac++; break;} //ovo ne valja?
             case 2 -> {pokusaj12.setIcon(sivo.getIcon());  if(rez.get(1) == 1 && pokusaj12.getIcon().equals(sivo.getIcon())) {stanje12.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje12.setIcon(nijeNaMestu.getIcon());} else{stanje12.setIcon(netacno.getIcon());} brojac++; break;}
             case 3 -> {pokusaj13.setIcon(sivo.getIcon()); if(rez.get(2) == 1&& pokusaj13.getIcon().equals(sivo.getIcon())) {stanje13.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje13.setIcon(nijeNaMestu.getIcon());} else{stanje13.setIcon(netacno.getIcon());} brojac++; break;}
             case 4 -> {
                 stanje11.setVisible(true);
                 stanje12.setVisible(true);
                 stanje13.setVisible(true);
                 stanje14.setVisible(true);                 
                 pokusaj14.setIcon(sivo.getIcon()); if(rez.get(3) == 1&& pokusaj14.getIcon().equals(sivo.getIcon())) {stanje14.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje14.setIcon(nijeNaMestu.getIcon());} else{stanje14.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje11.getIcon().equals(tacno.getIcon()) && stanje12.getIcon().equals(tacno.getIcon())&&stanje13.getIcon().equals(tacno.getIcon())&& stanje14.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek)); i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             case 5 -> {pokusaj21.setIcon(sivo.getIcon()); if(rez.get(0) == 1&& pokusaj21.getIcon().equals(sivo.getIcon())) {stanje21.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje21.setIcon(nijeNaMestu.getIcon());} else{stanje21.setIcon(netacno.getIcon());} brojac++; break;}
             case 6 -> {pokusaj22.setIcon(sivo.getIcon()); if(rez.get(1) == 1&& pokusaj22.getIcon().equals(sivo.getIcon())) {stanje22.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje22.setIcon(nijeNaMestu.getIcon());} else{stanje22.setIcon(netacno.getIcon());} brojac++; break;}
             case 7 -> {pokusaj23.setIcon(sivo.getIcon()); if(rez.get(2) == 1&& pokusaj23.getIcon().equals(sivo.getIcon())) {stanje23.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje23.setIcon(nijeNaMestu.getIcon());} else{stanje23.setIcon(netacno.getIcon());} brojac++; break;}
             case 8 -> {
                 stanje21.setVisible(true);
                 stanje22.setVisible(true);
                 stanje23.setVisible(true);
                 stanje24.setVisible(true);                
                 
                 pokusaj24.setIcon(sivo.getIcon()); if(rez.get(3) == 1&& pokusaj24.getIcon().equals(sivo.getIcon())) {stanje24.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje24.setIcon(nijeNaMestu.getIcon());} else{stanje24.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje21.getIcon().equals(tacno.getIcon()) && stanje22.getIcon().equals(tacno.getIcon())&&stanje23.getIcon().equals(tacno.getIcon())&& stanje24.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             case 9 -> {pokusaj31.setIcon(sivo.getIcon()); if(rez.get(0) == 1&& pokusaj31.getIcon().equals(sivo.getIcon())) {stanje31.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje31.setIcon(nijeNaMestu.getIcon());} else{stanje31.setIcon(netacno.getIcon());} brojac++; break;}
             case 10 -> {pokusaj32.setIcon(sivo.getIcon()); if(rez.get(1) == 1&& pokusaj32.getIcon().equals(sivo.getIcon())) {stanje32.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje32.setIcon(nijeNaMestu.getIcon());} else{stanje32.setIcon(netacno.getIcon());} brojac++; break;}
             case 11 -> {pokusaj33.setIcon(sivo.getIcon()); if(rez.get(2) == 1&& pokusaj33.getIcon().equals(sivo.getIcon())) {stanje33.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje33.setIcon(nijeNaMestu.getIcon());} else{stanje33.setIcon(netacno.getIcon());} brojac++; break;}
             case 12 -> {
                 stanje31.setVisible(true);
                 stanje32.setVisible(true);
                 stanje33.setVisible(true);
                 stanje34.setVisible(true);
                 
                 pokusaj34.setIcon(sivo.getIcon()); if(rez.get(3) == 1&& pokusaj34.getIcon().equals(sivo.getIcon())) {stanje34.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje34.setIcon(nijeNaMestu.getIcon());} else{stanje34.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje31.getIcon().equals(tacno.getIcon()) && stanje32.getIcon().equals(tacno.getIcon())&&stanje33.getIcon().equals(tacno.getIcon())&& stanje34.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             case 13 -> {pokusaj41.setIcon(sivo.getIcon()); if(rez.get(0) == 1&& pokusaj41.getIcon().equals(sivo.getIcon())) {stanje41.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje41.setIcon(nijeNaMestu.getIcon());} else{stanje41.setIcon(netacno.getIcon());} brojac++; break;}
             case 14 ->{pokusaj42.setIcon(sivo.getIcon()); if(rez.get(1) == 1&& pokusaj42.getIcon().equals(sivo.getIcon())) {stanje42.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje42.setIcon(nijeNaMestu.getIcon());} else{stanje42.setIcon(netacno.getIcon());} brojac++; break;}
             case 15 -> {pokusaj43.setIcon(sivo.getIcon()); if(rez.get(2) == 1&& pokusaj43.getIcon().equals(sivo.getIcon())) {stanje43.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje43.setIcon(nijeNaMestu.getIcon());} else{stanje43.setIcon(netacno.getIcon());} brojac++; break;}
             case 16 -> {
                 stanje41.setVisible(true);
                 stanje42.setVisible(true);
                 stanje43.setVisible(true);
                 stanje44.setVisible(true);                
                 
                 pokusaj44.setIcon(sivo.getIcon()); if(rez.get(3) == 1&& pokusaj44.getIcon().equals(sivo.getIcon())) {stanje44.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje44.setIcon(nijeNaMestu.getIcon());} else{stanje44.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje41.getIcon().equals(tacno.getIcon()) && stanje42.getIcon().equals(tacno.getIcon())&&stanje43.getIcon().equals(tacno.getIcon())&& stanje44.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             case 17 -> {pokusaj51.setIcon(sivo.getIcon()); if(rez.get(0) == 1&& pokusaj51.getIcon().equals(sivo.getIcon())) {stanje51.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje51.setIcon(nijeNaMestu.getIcon());} else{stanje51.setIcon(netacno.getIcon());} brojac++; break;}
             case 18 -> {pokusaj52.setIcon(sivo.getIcon()); if(rez.get(1) == 1&& pokusaj52.getIcon().equals(sivo.getIcon())) {stanje52.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje52.setIcon(nijeNaMestu.getIcon());} else{stanje52.setIcon(netacno.getIcon());} brojac++; break;}
             case 19 -> {pokusaj53.setIcon(sivo.getIcon()); if(rez.get(2) == 1&& pokusaj53.getIcon().equals(sivo.getIcon())) {stanje53.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje53.setIcon(nijeNaMestu.getIcon());} else{stanje53.setIcon(netacno.getIcon());} brojac++; break;}
             case 20 -> {
                 stanje51.setVisible(true);
                 stanje52.setVisible(true);
                 stanje53.setVisible(true);
                 stanje54.setVisible(true);                
                 
                 pokusaj54.setIcon(sivo.getIcon()); if(rez.get(3) == 1&& pokusaj54.getIcon().equals(sivo.getIcon())) {stanje54.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje54.setIcon(nijeNaMestu.getIcon());} else{stanje54.setIcon(netacno.getIcon());} brojac++; 
                  if(igraCovek && stanje51.getIcon().equals(tacno.getIcon()) && stanje52.getIcon().equals(tacno.getIcon())&&stanje53.getIcon().equals(tacno.getIcon())&& stanje54.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                
                 break;}
             case 21 -> {pokusaj61.setIcon(sivo.getIcon()); if(rez.get(0) == 1&& pokusaj61.getIcon().equals(sivo.getIcon())) {stanje61.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje61.setIcon(nijeNaMestu.getIcon());} else{stanje61.setIcon(netacno.getIcon());} brojac++; break;}
             case 22 -> {pokusaj62.setIcon(sivo.getIcon()); if(rez.get(1) == 1&& pokusaj62.getIcon().equals(sivo.getIcon())) {stanje62.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje62.setIcon(nijeNaMestu.getIcon());} else{stanje62.setIcon(netacno.getIcon());} brojac++; break;}
             case 23 -> {pokusaj63.setIcon(sivo.getIcon()); if(rez.get(2) == 1&& pokusaj63.getIcon().equals(sivo.getIcon())) {stanje63.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje63.setIcon(nijeNaMestu.getIcon());} else{stanje63.setIcon(netacno.getIcon());} brojac++; break;}
             case 24 -> {
                 stanje61.setVisible(true);
                 stanje62.setVisible(true);
                 stanje63.setVisible(true);
                 stanje64.setVisible(true);                
                 
                 pokusaj64.setIcon(sivo.getIcon()); if(rez.get(3) == 1&& pokusaj64.getIcon().equals(sivo.getIcon())) {stanje64.setIcon(tacno.getIcon());} else if (rez.contains(1)){stanje64.setIcon(nijeNaMestu.getIcon());} else{stanje64.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje61.getIcon().equals(tacno.getIcon()) && stanje62.getIcon().equals(tacno.getIcon())&&stanje63.getIcon().equals(tacno.getIcon())&& stanje64.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             
             default -> {
             }
         }
       

    }//GEN-LAST:event_sivoActionPerformed

    private void ljubicastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ljubicastoActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
      switch (brojac) {
             case 1 -> {pokusaj11.setIcon(ljubicasto.getIcon()); if(rez.get(0) == 2&& pokusaj11.getIcon().equals(ljubicasto.getIcon())) {stanje11.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje11.setIcon(nijeNaMestu.getIcon());} else{stanje11.setIcon(netacno.getIcon());} brojac++; break;} //ovo ne valja
             case 2 -> {pokusaj12.setIcon(ljubicasto.getIcon());  if(rez.get(1) == 2&& pokusaj12.getIcon().equals(ljubicasto.getIcon())) {stanje12.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje12.setIcon(nijeNaMestu.getIcon());} else{stanje12.setIcon(netacno.getIcon());} brojac++; break;}
             case 3 -> {pokusaj13.setIcon(ljubicasto.getIcon()); if(rez.get(2) == 2&& pokusaj13.getIcon().equals(ljubicasto.getIcon())) {stanje13.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje13.setIcon(nijeNaMestu.getIcon());} else{stanje13.setIcon(netacno.getIcon());} brojac++; break;}
             case 4 -> {
                 stanje11.setVisible(true);
                 stanje12.setVisible(true);
                 stanje13.setVisible(true);
                 stanje14.setVisible(true);                
                 
                 pokusaj14.setIcon(ljubicasto.getIcon()); if(rez.get(3) == 2&& pokusaj14.getIcon().equals(ljubicasto.getIcon())) {stanje14.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje14.setIcon(nijeNaMestu.getIcon());} else{stanje14.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje11.getIcon().equals(tacno.getIcon()) && stanje12.getIcon().equals(tacno.getIcon())&&stanje13.getIcon().equals(tacno.getIcon())&& stanje14.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             case 5 -> {pokusaj21.setIcon(ljubicasto.getIcon()); if(rez.get(0) == 2&& pokusaj21.getIcon().equals(ljubicasto.getIcon())) {stanje21.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje21.setIcon(nijeNaMestu.getIcon());} else{stanje21.setIcon(netacno.getIcon());} brojac++; break;}
             case 6 -> {pokusaj22.setIcon(ljubicasto.getIcon()); if(rez.get(1) == 2&& pokusaj22.getIcon().equals(ljubicasto.getIcon())) {stanje22.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje22.setIcon(nijeNaMestu.getIcon());} else{stanje22.setIcon(netacno.getIcon());} brojac++; break;}
             case 7 -> {pokusaj23.setIcon(ljubicasto.getIcon()); if(rez.get(2) == 2&& pokusaj23.getIcon().equals(ljubicasto.getIcon())) {stanje23.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje23.setIcon(nijeNaMestu.getIcon());} else{stanje23.setIcon(netacno.getIcon());} brojac++; break;}
             case 8 -> {
                 stanje21.setVisible(true);
                 stanje22.setVisible(true);
                 stanje23.setVisible(true);
                 stanje24.setVisible(true);
                 
                 pokusaj24.setIcon(ljubicasto.getIcon()); if(rez.get(3) == 2&& pokusaj24.getIcon().equals(ljubicasto.getIcon())) {stanje24.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje24.setIcon(nijeNaMestu.getIcon());} else{stanje24.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje21.getIcon().equals(tacno.getIcon()) && stanje22.getIcon().equals(tacno.getIcon())&&stanje23.getIcon().equals(tacno.getIcon())&& stanje24.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             case 9 -> {pokusaj31.setIcon(ljubicasto.getIcon()); if(rez.get(0) == 2&& pokusaj31.getIcon().equals(ljubicasto.getIcon())) {stanje31.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje31.setIcon(nijeNaMestu.getIcon());} else{stanje31.setIcon(netacno.getIcon());} brojac++; break;}
             case 10 -> {pokusaj32.setIcon(ljubicasto.getIcon()); if(rez.get(1) == 2&& pokusaj32.getIcon().equals(ljubicasto.getIcon())) {stanje32.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje32.setIcon(nijeNaMestu.getIcon());} else{stanje32.setIcon(netacno.getIcon());} brojac++; break;}
             case 11 -> {pokusaj33.setIcon(ljubicasto.getIcon()); if(rez.get(2) == 2&& pokusaj33.getIcon().equals(ljubicasto.getIcon())) {stanje33.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje33.setIcon(nijeNaMestu.getIcon());} else{stanje33.setIcon(netacno.getIcon());} brojac++; break;}
             case 12 -> {
                 stanje31.setVisible(true);
                 stanje32.setVisible(true);
                 stanje33.setVisible(true);
                 stanje34.setVisible(true);
                 
                 pokusaj34.setIcon(ljubicasto.getIcon()); if(rez.get(3) == 2&& pokusaj34.getIcon().equals(ljubicasto.getIcon())) {stanje34.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje34.setIcon(nijeNaMestu.getIcon());} else{stanje34.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje31.getIcon().equals(tacno.getIcon()) && stanje32.getIcon().equals(tacno.getIcon())&&stanje33.getIcon().equals(tacno.getIcon())&& stanje34.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}
                 break;}
             case 13 -> {pokusaj41.setIcon(ljubicasto.getIcon()); if(rez.get(0) == 2&& pokusaj41.getIcon().equals(ljubicasto.getIcon())) {stanje41.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje41.setIcon(nijeNaMestu.getIcon());} else{stanje41.setIcon(netacno.getIcon());} brojac++; break;}
             case 14 ->{pokusaj42.setIcon(ljubicasto.getIcon()); if(rez.get(1) == 2&& pokusaj42.getIcon().equals(ljubicasto.getIcon())) {stanje42.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje42.setIcon(nijeNaMestu.getIcon());} else{stanje42.setIcon(netacno.getIcon());} brojac++; break;}
             case 15 -> {pokusaj43.setIcon(ljubicasto.getIcon()); if(rez.get(2) == 2&& pokusaj43.getIcon().equals(ljubicasto.getIcon())) {stanje43.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje43.setIcon(nijeNaMestu.getIcon());} else{stanje43.setIcon(netacno.getIcon());} brojac++; break;}
             case 16 -> {
                 stanje41.setVisible(true);
                 stanje42.setVisible(true);
                 stanje43.setVisible(true);
                 stanje44.setVisible(true);
                 
                 pokusaj44.setIcon(ljubicasto.getIcon()); if(rez.get(3) == 2&& pokusaj44.getIcon().equals(ljubicasto.getIcon())) {stanje44.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje44.setIcon(nijeNaMestu.getIcon());} else{stanje44.setIcon(netacno.getIcon());} brojac++; 
                  if(igraCovek && stanje41.getIcon().equals(tacno.getIcon()) && stanje42.getIcon().equals(tacno.getIcon())&&stanje43.getIcon().equals(tacno.getIcon())&& stanje44.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                
                 
                 break;}
             case 17 -> {pokusaj51.setIcon(ljubicasto.getIcon()); if(rez.get(0) == 2&& pokusaj51.getIcon().equals(ljubicasto.getIcon())) {stanje51.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje51.setIcon(nijeNaMestu.getIcon());} else{stanje51.setIcon(netacno.getIcon());} brojac++; break;}
             case 18 -> {pokusaj52.setIcon(ljubicasto.getIcon()); if(rez.get(1) == 2&& pokusaj52.getIcon().equals(ljubicasto.getIcon())) {stanje52.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje52.setIcon(nijeNaMestu.getIcon());} else{stanje52.setIcon(netacno.getIcon());} brojac++; break;}
             case 19 -> {pokusaj53.setIcon(ljubicasto.getIcon()); if(rez.get(2) == 2&& pokusaj53.getIcon().equals(ljubicasto.getIcon())) {stanje53.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje53.setIcon(nijeNaMestu.getIcon());} else{stanje53.setIcon(netacno.getIcon());} brojac++; break;}
             case 20 -> {
                 stanje51.setVisible(true);
                 stanje52.setVisible(true);
                 stanje53.setVisible(true);
                 stanje54.setVisible(true);               
                 pokusaj54.setIcon(ljubicasto.getIcon()); if(rez.get(3) == 2&& pokusaj54.getIcon().equals(ljubicasto.getIcon())) {stanje54.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje54.setIcon(nijeNaMestu.getIcon());} else{stanje54.setIcon(netacno.getIcon());} brojac++; 
                  if(igraCovek && stanje51.getIcon().equals(tacno.getIcon()) && stanje52.getIcon().equals(tacno.getIcon())&&stanje53.getIcon().equals(tacno.getIcon())&& stanje54.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                
                 break;}
             case 21 -> {pokusaj61.setIcon(ljubicasto.getIcon()); if(rez.get(0) == 2&& pokusaj61.getIcon().equals(ljubicasto.getIcon())) {stanje61.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje61.setIcon(nijeNaMestu.getIcon());} else{stanje61.setIcon(netacno.getIcon());} brojac++; break;}
             case 22 -> {pokusaj62.setIcon(ljubicasto.getIcon()); if(rez.get(1) == 2&& pokusaj62.getIcon().equals(ljubicasto.getIcon())) {stanje62.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje62.setIcon(nijeNaMestu.getIcon());} else{stanje62.setIcon(netacno.getIcon());} brojac++; break;}
             case 23 -> {pokusaj63.setIcon(ljubicasto.getIcon()); if(rez.get(2) == 2&& pokusaj63.getIcon().equals(ljubicasto.getIcon())) {stanje63.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje63.setIcon(nijeNaMestu.getIcon());} else{stanje63.setIcon(netacno.getIcon());} brojac++; break;}
             case 24 -> {
                 stanje61.setVisible(true);
                 stanje62.setVisible(true);
                 stanje63.setVisible(true);
                 stanje64.setVisible(true);              
                 
                 pokusaj64.setIcon(ljubicasto.getIcon()); if(rez.get(3) == 2&& pokusaj64.getIcon().equals(ljubicasto.getIcon())) {stanje64.setIcon(tacno.getIcon());} else if (rez.contains(2)){stanje64.setIcon(nijeNaMestu.getIcon());} else{stanje64.setIcon(netacno.getIcon());} brojac++; 
                  if(igraCovek && stanje61.getIcon().equals(tacno.getIcon()) && stanje62.getIcon().equals(tacno.getIcon())&&stanje63.getIcon().equals(tacno.getIcon())&& stanje64.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                
                 break;}
             
             default -> {
             }
         }


    }//GEN-LAST:event_ljubicastoActionPerformed

    private void zelenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zelenoActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
    switch (brojac) {
             case 1 -> {pokusaj11.setIcon(zeleno.getIcon()); if(rez.get(0) == 3) {stanje11.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje11.setIcon(nijeNaMestu.getIcon());} else{stanje11.setIcon(netacno.getIcon());} brojac++; break;} //ovo ne valja
             case 2 -> {pokusaj12.setIcon(zeleno.getIcon());  if(rez.get(1) == 3) {stanje12.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje12.setIcon(nijeNaMestu.getIcon());} else{stanje12.setIcon(netacno.getIcon());} brojac++; break;}
             case 3 -> {pokusaj13.setIcon(zeleno.getIcon()); if(rez.get(2) == 3) {stanje13.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje13.setIcon(nijeNaMestu.getIcon());} else{stanje13.setIcon(netacno.getIcon());} brojac++; break;}
             case 4 -> {

                 stanje11.setVisible(true);
                 stanje12.setVisible(true);
                 stanje13.setVisible(true);
                 stanje14.setVisible(true);
                 
                 pokusaj14.setIcon(zeleno.getIcon()); if(rez.get(3) == 3) {stanje14.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje14.setIcon(nijeNaMestu.getIcon());} else{stanje14.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje11.getIcon().equals(tacno.getIcon()) && stanje12.getIcon().equals(tacno.getIcon())&&stanje13.getIcon().equals(tacno.getIcon())&& stanje14.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             case 5 -> {pokusaj21.setIcon(zeleno.getIcon()); if(rez.get(0) == 3) {stanje21.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje21.setIcon(nijeNaMestu.getIcon());} else{stanje21.setIcon(netacno.getIcon());} brojac++; break;}
             case 6 -> {pokusaj22.setIcon(zeleno.getIcon()); if(rez.get(1) == 3) {stanje22.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje22.setIcon(nijeNaMestu.getIcon());} else{stanje22.setIcon(netacno.getIcon());} brojac++; break;}
             case 7 -> {pokusaj23.setIcon(zeleno.getIcon()); if(rez.get(2) == 3) {stanje23.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje23.setIcon(nijeNaMestu.getIcon());} else{stanje23.setIcon(netacno.getIcon());} brojac++; break;}
             case 8 -> {
                 stanje21.setVisible(true);
                 stanje22.setVisible(true);
                 stanje23.setVisible(true);
                 stanje24.setVisible(true);                 
                 
                 pokusaj24.setIcon(zeleno.getIcon()); if(rez.get(3) == 3) {stanje24.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje24.setIcon(nijeNaMestu.getIcon());} else{stanje24.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje21.getIcon().equals(tacno.getIcon()) && stanje22.getIcon().equals(tacno.getIcon())&&stanje23.getIcon().equals(tacno.getIcon())&& stanje24.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             case 9 -> {pokusaj31.setIcon(zeleno.getIcon()); if(rez.get(0) == 3) {stanje31.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje31.setIcon(nijeNaMestu.getIcon());} else{stanje31.setIcon(netacno.getIcon());} brojac++; break;}
             case 10 -> {pokusaj32.setIcon(zeleno.getIcon()); if(rez.get(1) == 3) {stanje32.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje32.setIcon(nijeNaMestu.getIcon());} else{stanje32.setIcon(netacno.getIcon());} brojac++; break;}
             case 11 -> {pokusaj33.setIcon(zeleno.getIcon()); if(rez.get(2) == 3) {stanje33.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje33.setIcon(nijeNaMestu.getIcon());} else{stanje33.setIcon(netacno.getIcon());} brojac++; break;}
             case 12 -> {
                 stanje31.setVisible(true);
                 stanje32.setVisible(true);
                 stanje33.setVisible(true);
                 stanje34.setVisible(true);                 
                 
                 pokusaj34.setIcon(zeleno.getIcon()); if(rez.get(3) == 3) {stanje34.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje34.setIcon(nijeNaMestu.getIcon());} else{stanje34.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje31.getIcon().equals(tacno.getIcon()) && stanje32.getIcon().equals(tacno.getIcon())&&stanje33.getIcon().equals(tacno.getIcon())&& stanje34.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             case 13 -> {pokusaj41.setIcon(zeleno.getIcon()); if(rez.get(0) == 3) {stanje41.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje41.setIcon(nijeNaMestu.getIcon());} else{stanje41.setIcon(netacno.getIcon());} brojac++; break;}
             case 14 ->{pokusaj42.setIcon(zeleno.getIcon()); if(rez.get(1) == 3) {stanje42.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje42.setIcon(nijeNaMestu.getIcon());} else{stanje42.setIcon(netacno.getIcon());} brojac++; break;}
             case 15 -> {pokusaj43.setIcon(zeleno.getIcon()); if(rez.get(2) == 3) {stanje43.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje43.setIcon(nijeNaMestu.getIcon());} else{stanje43.setIcon(netacno.getIcon());} brojac++; break;}
             case 16 -> {
                 stanje41.setVisible(true);
                 stanje42.setVisible(true);
                 stanje43.setVisible(true);
                 stanje44.setVisible(true);                
                 
                 pokusaj44.setIcon(zeleno.getIcon()); if(rez.get(3) == 3) {stanje44.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje44.setIcon(nijeNaMestu.getIcon());} else{stanje44.setIcon(netacno.getIcon());} brojac++; 
                  if(igraCovek && stanje41.getIcon().equals(tacno.getIcon()) && stanje42.getIcon().equals(tacno.getIcon())&&stanje43.getIcon().equals(tacno.getIcon())&& stanje44.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                
                 break;}
             case 17 -> {pokusaj51.setIcon(zeleno.getIcon()); if(rez.get(0) == 3) {stanje51.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje51.setIcon(nijeNaMestu.getIcon());} else{stanje51.setIcon(netacno.getIcon());} brojac++; break;}
             case 18 -> {pokusaj52.setIcon(zeleno.getIcon()); if(rez.get(1) == 3) {stanje52.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje52.setIcon(nijeNaMestu.getIcon());} else{stanje52.setIcon(netacno.getIcon());} brojac++; break;}
             case 19 -> {pokusaj53.setIcon(zeleno.getIcon()); if(rez.get(2) == 3) {stanje53.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje53.setIcon(nijeNaMestu.getIcon());} else{stanje53.setIcon(netacno.getIcon());} brojac++; break;}
             case 20 -> {
                 stanje51.setVisible(true);
                 stanje52.setVisible(true);
                 stanje53.setVisible(true);
                 stanje54.setVisible(true);                 
                 
                 pokusaj54.setIcon(zeleno.getIcon()); if(rez.get(3) == 3) {stanje54.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje54.setIcon(nijeNaMestu.getIcon());} else{stanje54.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje51.getIcon().equals(tacno.getIcon()) && stanje52.getIcon().equals(tacno.getIcon())&&stanje53.getIcon().equals(tacno.getIcon())&& stanje54.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             case 21 -> {pokusaj61.setIcon(zeleno.getIcon()); if(rez.get(0) == 3) {stanje61.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje61.setIcon(nijeNaMestu.getIcon());} else{stanje61.setIcon(netacno.getIcon());} brojac++; break;}
             case 22 -> {pokusaj62.setIcon(zeleno.getIcon()); if(rez.get(1) == 3) {stanje62.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje62.setIcon(nijeNaMestu.getIcon());} else{stanje62.setIcon(netacno.getIcon());} brojac++; break;}
             case 23 -> {pokusaj63.setIcon(zeleno.getIcon()); if(rez.get(2) == 3) {stanje63.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje63.setIcon(nijeNaMestu.getIcon());} else{stanje63.setIcon(netacno.getIcon());} brojac++; break;}
             case 24 -> {
                 stanje61.setVisible(true);
                 stanje62.setVisible(true);
                 stanje63.setVisible(true);
                 stanje64.setVisible(true);                
                 
                 pokusaj64.setIcon(zeleno.getIcon()); if(rez.get(3) == 3) {stanje64.setIcon(tacno.getIcon());} else if (rez.contains(3)){stanje64.setIcon(nijeNaMestu.getIcon());} else{stanje64.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje61.getIcon().equals(tacno.getIcon()) && stanje62.getIcon().equals(tacno.getIcon())&&stanje63.getIcon().equals(tacno.getIcon())&& stanje64.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             
             default -> {
             }
         }

    }//GEN-LAST:event_zelenoActionPerformed

    private void plavoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plavoActionPerformed
    playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
    switch (brojac) {
             case 1 -> {pokusaj11.setIcon(plavo.getIcon()); if(rez.get(0) == 4) {stanje11.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje11.setIcon(nijeNaMestu.getIcon());} else{stanje11.setIcon(netacno.getIcon());} brojac++; break;} //ovo ne valja
             case 2 -> {pokusaj12.setIcon(plavo.getIcon());  if(rez.get(1) == 4) {stanje12.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje12.setIcon(nijeNaMestu.getIcon());} else{stanje12.setIcon(netacno.getIcon());} brojac++; break;}
             case 3 -> {pokusaj13.setIcon(plavo.getIcon()); if(rez.get(2) == 4) {stanje13.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje13.setIcon(nijeNaMestu.getIcon());} else{stanje13.setIcon(netacno.getIcon());} brojac++; break;}
             case 4 -> {
                 stanje11.setVisible(true);
                 stanje12.setVisible(true);
                 stanje13.setVisible(true);
                 stanje14.setVisible(true);                 
                 
                 pokusaj14.setIcon(plavo.getIcon()); if(rez.get(3) == 4) {stanje14.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje14.setIcon(nijeNaMestu.getIcon());} else{stanje14.setIcon(netacno.getIcon());} brojac++; 
                  if(igraCovek && stanje11.getIcon().equals(tacno.getIcon()) && stanje12.getIcon().equals(tacno.getIcon())&&stanje13.getIcon().equals(tacno.getIcon())&& stanje14.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                
                 
                 break;}
             case 5 -> {pokusaj21.setIcon(plavo.getIcon()); if(rez.get(0) == 4) {stanje21.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje21.setIcon(nijeNaMestu.getIcon());} else{stanje21.setIcon(netacno.getIcon());} brojac++; break;}
             case 6 -> {pokusaj22.setIcon(plavo.getIcon()); if(rez.get(1) == 4) {stanje22.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje22.setIcon(nijeNaMestu.getIcon());} else{stanje22.setIcon(netacno.getIcon());} brojac++; break;}
             case 7 -> {pokusaj23.setIcon(plavo.getIcon()); if(rez.get(2) == 4) {stanje23.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje23.setIcon(nijeNaMestu.getIcon());} else{stanje23.setIcon(netacno.getIcon());} brojac++; break;}
             case 8 -> {
                 stanje21.setVisible(true);
                 stanje22.setVisible(true);
                 stanje23.setVisible(true);
                 stanje24.setVisible(true);                 
                 
                 pokusaj24.setIcon(plavo.getIcon()); if(rez.get(3) == 4) {stanje24.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje24.setIcon(nijeNaMestu.getIcon());} else{stanje24.setIcon(netacno.getIcon());} brojac++; 
                  if(igraCovek && stanje21.getIcon().equals(tacno.getIcon()) && stanje22.getIcon().equals(tacno.getIcon())&&stanje23.getIcon().equals(tacno.getIcon())&& stanje24.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                
                 break;}
             case 9 -> {pokusaj31.setIcon(plavo.getIcon()); if(rez.get(0) == 4) {stanje31.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje31.setIcon(nijeNaMestu.getIcon());} else{stanje31.setIcon(netacno.getIcon());} brojac++; break;}
             case 10 -> {pokusaj32.setIcon(plavo.getIcon()); if(rez.get(1) == 4) {stanje32.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje32.setIcon(nijeNaMestu.getIcon());} else{stanje32.setIcon(netacno.getIcon());} brojac++; break;}
             case 11 -> {pokusaj33.setIcon(plavo.getIcon()); if(rez.get(2) == 4) {stanje33.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje33.setIcon(nijeNaMestu.getIcon());} else{stanje33.setIcon(netacno.getIcon());} brojac++; break;}
             case 12 -> {
                 stanje31.setVisible(true);
                 stanje32.setVisible(true);
                 stanje33.setVisible(true);
                 stanje34.setVisible(true);                 
                 
                 pokusaj34.setIcon(plavo.getIcon()); if(rez.get(3) == 4) {stanje34.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje34.setIcon(nijeNaMestu.getIcon());} else{stanje34.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje31.getIcon().equals(tacno.getIcon()) && stanje32.getIcon().equals(tacno.getIcon())&&stanje33.getIcon().equals(tacno.getIcon())&& stanje34.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}
                 break;}
             case 13 -> {pokusaj41.setIcon(plavo.getIcon()); if(rez.get(0) == 4) {stanje41.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje41.setIcon(nijeNaMestu.getIcon());} else{stanje41.setIcon(netacno.getIcon());} brojac++; break;}
             case 14 ->{pokusaj42.setIcon(plavo.getIcon()); if(rez.get(1) == 4) {stanje42.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje42.setIcon(nijeNaMestu.getIcon());} else{stanje42.setIcon(netacno.getIcon());} brojac++; break;}
             case 15 -> {pokusaj43.setIcon(plavo.getIcon()); if(rez.get(2) == 4) {stanje43.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje43.setIcon(nijeNaMestu.getIcon());} else{stanje43.setIcon(netacno.getIcon());} brojac++; break;}
             case 16 -> {
                 stanje41.setVisible(true);
                 stanje42.setVisible(true);
                 stanje43.setVisible(true);
                 stanje44.setVisible(true);                 
                 
                 pokusaj44.setIcon(plavo.getIcon()); if(rez.get(3) == 4) {stanje44.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje44.setIcon(nijeNaMestu.getIcon());} else{stanje44.setIcon(netacno.getIcon());} brojac++; 
                  if(igraCovek && stanje41.getIcon().equals(tacno.getIcon()) && stanje42.getIcon().equals(tacno.getIcon())&&stanje43.getIcon().equals(tacno.getIcon())&& stanje44.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                
                 break;}
             case 17 -> {pokusaj51.setIcon(plavo.getIcon()); if(rez.get(0) == 4) {stanje51.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje51.setIcon(nijeNaMestu.getIcon());} else{stanje51.setIcon(netacno.getIcon());} brojac++; break;}
             case 18 -> {pokusaj52.setIcon(plavo.getIcon()); if(rez.get(1) == 4) {stanje52.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje52.setIcon(nijeNaMestu.getIcon());} else{stanje52.setIcon(netacno.getIcon());} brojac++; break;}
             case 19 -> {pokusaj53.setIcon(plavo.getIcon()); if(rez.get(2) == 4) {stanje53.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje53.setIcon(nijeNaMestu.getIcon());} else{stanje53.setIcon(netacno.getIcon());} brojac++; break;}
             case 20 -> {
                 stanje51.setVisible(true);
                 stanje52.setVisible(true);
                 stanje53.setVisible(true);
                 stanje54.setVisible(true);                 
                 
                 pokusaj54.setIcon(plavo.getIcon()); if(rez.get(3) == 4) {stanje54.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje54.setIcon(nijeNaMestu.getIcon());} else{stanje54.setIcon(netacno.getIcon());} brojac++; 
                 if(igraCovek && stanje51.getIcon().equals(tacno.getIcon()) && stanje52.getIcon().equals(tacno.getIcon())&&stanje53.getIcon().equals(tacno.getIcon())&& stanje54.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                 
                 break;}
             case 21 -> {pokusaj61.setIcon(plavo.getIcon()); if(rez.get(0) == 4) {stanje61.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje61.setIcon(nijeNaMestu.getIcon());} else{stanje61.setIcon(netacno.getIcon());} brojac++; break;}
             case 22 -> {pokusaj62.setIcon(plavo.getIcon()); if(rez.get(1) == 4) {stanje62.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje62.setIcon(nijeNaMestu.getIcon());} else{stanje62.setIcon(netacno.getIcon());} brojac++; break;}
             case 23 -> {pokusaj63.setIcon(plavo.getIcon()); if(rez.get(2) == 4) {stanje63.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje63.setIcon(nijeNaMestu.getIcon());} else{stanje63.setIcon(netacno.getIcon());} brojac++; break;}
             case 24 -> {
                 stanje61.setVisible(true);
                 stanje62.setVisible(true);
                 stanje63.setVisible(true);
                 stanje64.setVisible(true);                
                 
                 pokusaj64.setIcon(plavo.getIcon()); if(rez.get(3) == 4) {stanje64.setIcon(tacno.getIcon());} else if (rez.contains(4)){stanje64.setIcon(nijeNaMestu.getIcon());} else{stanje64.setIcon(netacno.getIcon());} brojac++;
                  if(igraCovek && stanje61.getIcon().equals(tacno.getIcon()) && stanje62.getIcon().equals(tacno.getIcon())&&stanje63.getIcon().equals(tacno.getIcon())&& stanje64.getIcon().equals(tacno.getIcon()))
                     {pCovek = 20; poeniCovek.setText(String.valueOf(pCovek));i = 0;r.skockoPoeniCovek = pCovek;}                
                 break;}
             
             default -> {
             }
         }

    }//GEN-LAST:event_plavoActionPerformed

    private void pokusaj11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj11ActionPerformed
       playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");

    }//GEN-LAST:event_pokusaj11ActionPerformed

    private void pokusaj13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj13ActionPerformed

    private void pokusaj14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj14ActionPerformed

    private void pokusaj12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj12ActionPerformed

    private void pokusaj22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj22ActionPerformed

    private void pokusaj23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj23ActionPerformed

    private void pokusaj24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj24ActionPerformed

    private void pokusaj21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj21ActionPerformed

    private void pokusaj32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj32ActionPerformed

    private void pokusaj33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj33ActionPerformed

    private void pokusaj34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj34ActionPerformed

    private void pokusaj31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj31ActionPerformed

    private void pokusaj42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj42ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj42ActionPerformed

    private void pokusaj43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj43ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj43ActionPerformed

    private void pokusaj44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj44ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj44ActionPerformed

    private void pokusaj41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj41ActionPerformed

    private void pokusaj52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj52ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj52ActionPerformed

    private void pokusaj53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj53ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj53ActionPerformed

    private void pokusaj54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj54ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj54ActionPerformed

    private void pokusaj51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj51ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj51ActionPerformed

    private void pokusaj62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj62ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj62ActionPerformed

    private void pokusaj63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj63ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj63ActionPerformed

    private void pokusaj64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj64ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj64ActionPerformed

    private void pokusaj61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokusaj61ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokusaj61ActionPerformed

    private void pokusaj11StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pokusaj11StateChanged
        // TODO add your handling code here:
        playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
        //pokusaj11.setEnabled(false);
        
    }//GEN-LAST:event_pokusaj11StateChanged

    private void pokusaj12StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pokusaj12StateChanged
        // TODO add your handling code here:
        playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
        //pokusaj12.setEnabled(false);
    }//GEN-LAST:event_pokusaj12StateChanged

    private void pokusaj13StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pokusaj13StateChanged
        // TODO add your handling code here:
                playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
       // pokusaj13.setEnabled(false);
    }//GEN-LAST:event_pokusaj13StateChanged

    private void pokusaj14PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_pokusaj14PropertyChange
        // TODO add your handling code here:
          playSound("C:\\Users\\Laki\\Documents\\NetBeansProjects\\Redjalica2\\src\\com\\mycompany\\redjalica\\slike\\klikati.wav");
        //pokusaj14.setEnabled(false);
    }//GEN-LAST:event_pokusaj14PropertyChange

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
            java.util.logging.Logger.getLogger(skocko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(skocko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(skocko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(skocko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { // main ne treba ovde
                
                new skocko(0.45,new rezultat()).setVisible(true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crveno;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JLabel labelaCovek;
    private javax.swing.JLabel labelaKompjuter;
    private javax.swing.JButton ljubicasto;
    private javax.swing.JButton narandzasto;
    private javax.swing.JLabel netacno;
    private javax.swing.JLabel nijeNaMestu;
    private javax.swing.JButton plavo;
    private java.awt.TextField poeniCovek;
    private java.awt.TextField poeniKompjuter;
    private javax.swing.JButton pokusaj11;
    private javax.swing.JButton pokusaj12;
    private javax.swing.JButton pokusaj13;
    private javax.swing.JButton pokusaj14;
    private javax.swing.JButton pokusaj21;
    private javax.swing.JButton pokusaj22;
    private javax.swing.JButton pokusaj23;
    private javax.swing.JButton pokusaj24;
    private javax.swing.JButton pokusaj31;
    private javax.swing.JButton pokusaj32;
    private javax.swing.JButton pokusaj33;
    private javax.swing.JButton pokusaj34;
    private javax.swing.JButton pokusaj41;
    private javax.swing.JButton pokusaj42;
    private javax.swing.JButton pokusaj43;
    private javax.swing.JButton pokusaj44;
    private javax.swing.JButton pokusaj51;
    private javax.swing.JButton pokusaj52;
    private javax.swing.JButton pokusaj53;
    private javax.swing.JButton pokusaj54;
    private javax.swing.JButton pokusaj61;
    private javax.swing.JButton pokusaj62;
    private javax.swing.JButton pokusaj63;
    private javax.swing.JButton pokusaj64;
    private javax.swing.JButton sivo;
    private javax.swing.JLabel stanje11;
    private javax.swing.JLabel stanje12;
    private javax.swing.JLabel stanje13;
    private javax.swing.JLabel stanje14;
    private javax.swing.JLabel stanje21;
    private javax.swing.JLabel stanje22;
    private javax.swing.JLabel stanje23;
    private javax.swing.JLabel stanje24;
    private javax.swing.JLabel stanje31;
    private javax.swing.JLabel stanje32;
    private javax.swing.JLabel stanje33;
    private javax.swing.JLabel stanje34;
    private javax.swing.JLabel stanje41;
    private javax.swing.JLabel stanje42;
    private javax.swing.JLabel stanje43;
    private javax.swing.JLabel stanje44;
    private javax.swing.JLabel stanje51;
    private javax.swing.JLabel stanje52;
    private javax.swing.JLabel stanje53;
    private javax.swing.JLabel stanje54;
    private javax.swing.JLabel stanje61;
    private javax.swing.JLabel stanje62;
    private javax.swing.JLabel stanje63;
    private javax.swing.JLabel stanje64;
    private javax.swing.JLabel tacno;
    private javax.swing.JLabel tajmer;
    private javax.swing.JButton zeleno;
    // End of variables declaration//GEN-END:variables
}
