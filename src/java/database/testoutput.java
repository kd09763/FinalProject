/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 *
 * @author Gabe
 */
public class testoutput {
    public static void main(String[] args) {
        Database db = new Database();
        int test[] = db.getStateInfo("Maryland");
        
        for(int i=0; i < test.length; i++) {
            System.out.print(test[i] + "\n");
            
        }
    }
}
