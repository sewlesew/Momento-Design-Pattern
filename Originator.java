/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Momento;

/**
 *
 * @author USER
 */
public class Originator {
    String editorText;
    
    public void setText(String editorText){
        this.editorText=editorText;
                  }
    
    public Momento storeIntoMomento(){
        return new Momento(editorText);
    }
    
    public String retrieveFromMomento(Momento momento){
       editorText=momento.getText();
       return editorText;
    }
    
}
