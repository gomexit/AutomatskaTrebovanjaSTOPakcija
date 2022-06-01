/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtemplate;

import javafx.scene.control.TextField;

/**
 *
 * @author bojan
 */
public class TextFormatKlasa {
    
    public void postaviIntegerFormat(TextField f)  {
          f.lengthProperty().addListener((observable, oldValue, newValue) -> {
        if(newValue.intValue() > oldValue.intValue()){
            char c = f.getText().charAt(oldValue.intValue());
            /** Check if the new character is the number or other's */
            if ( c > '9' || c < '0'  )  {
                /** if it's not number then just setText to previous one */
                f.setText(f.getText().substring(0,f.getText().length()-1));
            }
        }
    });
    }
    
        public void postaviDecimalFormat(TextField f)  {
          f.lengthProperty().addListener((observable, oldValue, newValue) -> {
        if(newValue.intValue() > oldValue.intValue()){
            char c = f.getText().charAt(oldValue.intValue());
            /** Check if the new character is the number or other's */
            if (( c > '9' || c < '0'  )&&(c!='.'))  {
                /** if it's not number then just setText to previous one */
                f.setText(f.getText().substring(0,f.getText().length()-1));
            }
        }
    });
    }
    
}
