/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Momento;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class CareTaker {
    
    List<Momento> savedEditorText=new ArrayList<Momento>();
    
    public void add(Momento momento){
        savedEditorText.add(momento);
    }
    
    public Momento get(int index){
        return savedEditorText.get(index);
    }
    
    public void remove(int pos){
       
        for(int i=pos+1;i<savedEditorText.size();i++){
            savedEditorText.remove(i);
        }
        
    }
}
