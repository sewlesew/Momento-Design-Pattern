/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Momento;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author USER
 */
public class Client extends JFrame {
    
    private JButton loadBut,undoBut,saveBut;
    private JTextArea textEditorArea=new JTextArea(10,15);
    CareTaker careTaker=new CareTaker();
    
    Originator origionator=new Originator();
    int numOfSavedFiles=0,currentArticlePos=0;
    JPanel buttonsPanel;
    
     public Client(){
         this.setTitle("Momento Design Pattern");
         this.setSize(500,400);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setResizable(false);
         setLocationRelativeTo(null);
         
//         this.setLayout(new FlowLayout());
         
         JPanel panel=new JPanel();
//         panel.setSize(400,300);
         panel.setLayout(new BorderLayout());
         
         panel.add(new JLabel("Text Editor",SwingConstants.CENTER),BorderLayout.NORTH);
         panel.add(textEditorArea,BorderLayout.CENTER);
         
         loadBut=new JButton("Load");
         undoBut=new JButton("Undo");
         saveBut=new JButton("Save");
         buttonsPanel=new JPanel();
         
         ButtonListener loadListener=new ButtonListener();
         ButtonListener undoButtonListener=new ButtonListener();
         ButtonListener saveListener=new ButtonListener();
         
         loadBut.addActionListener(loadListener);
         buttonsPanel.add(loadBut);
          
         undoBut.addActionListener(undoButtonListener);
         buttonsPanel.add(undoBut);
         
         saveBut.addActionListener(saveListener);
         buttonsPanel.add(saveBut);
         
         panel.add(buttonsPanel,BorderLayout.SOUTH);
         this.add(panel);
         this.setVisible(true);
         
         
         
     }
    
    public static void main(String[] args){        
        new Client();
           }
   
    class ButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
        
       
       
       if(ae.getSource()==loadBut){
            BufferedReader br;
            String allText="";
            
           try {
               br=new BufferedReader(new FileReader("article.txt"));
               String read;
               while((read=br.readLine())!=null){               
                 allText+=read+"\n";
                         }
           } catch (Exception ex) {
               Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
           }

           textEditorArea.setText(allText);   
           
           origionator.setText(allText);
           careTaker.add(origionator.storeIntoMomento());
            numOfSavedFiles++;
            currentArticlePos++;
            System.out.println("number of saved files 0:"+numOfSavedFiles);
             
            saveBut.setEnabled(true); 

                
                 
                  }
       
       else if(ae.getSource()==saveBut){

         
               origionator.setText(textEditorArea.getText());
               
               //importatnt when you add sth while performing undo; and want to save that.Hence, you need to remove all the
               //stored momentos after the currentArticlePos in careTaker
               if(currentArticlePos<numOfSavedFiles-1){
                   careTaker.remove(currentArticlePos);
                   numOfSavedFiles=currentArticlePos+1;
                   System.out.println("number of saved files 1:"+numOfSavedFiles);
                   System.out.println("     number of current pos :"+currentArticlePos);
                   
               }
               
               careTaker.add(origionator.storeIntoMomento());
               numOfSavedFiles++;
               currentArticlePos++;
               System.out.println("number of saved files 2:"+numOfSavedFiles);
               System.out.println("     number of current pos 2:"+currentArticlePos);
               
               
               undoBut.setEnabled(true);
               
               BufferedWriter bw;
               
               
                 try {
               bw=new BufferedWriter(new FileWriter("article.txt"));
               bw.write(textEditorArea.getText());
               bw.close();
           } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
           }
            
           
          
       }
       else if(ae.getSource()==undoBut){         
               
           if(currentArticlePos>=1){
                 currentArticlePos--;
              String previousText=origionator.retrieveFromMomento(careTaker.get(currentArticlePos));
              textEditorArea.setText(previousText);
              System.out.println("currentArticlePos 4: "+currentArticlePos);

              
           }
           else{
               undoBut.setEnabled(false);
           }
       }

       
    
}//endofInnerClass
    
    
    }
}
