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
public class Momento {
    private String previousText;
    
    public Momento(String previousText){
        this.previousText=previousText;
    }
    
    public String getText(){
        return previousText;
              }
    
    
    
}
