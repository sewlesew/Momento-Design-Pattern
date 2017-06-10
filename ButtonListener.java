/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Momento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author USER
 */
public class ButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        System.out.println(ae.getActionCommand());
        
        if(ae.getActionCommand().equals("Load")){
            
        }

  
    }
    
}
