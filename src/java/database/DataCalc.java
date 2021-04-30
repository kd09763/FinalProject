/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author kld09
 */
public class DataCalc {

    //Default unused constructor
    public DataCalc() {
    }

    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //factory static method
    public static int ageFilter(String ageString) {
        int ageFilterNum;
        if (ageString == "allAges") {
            ageFilterNum = 0;
        } else if (ageString == "eighteen") {
            ageFilterNum = 1;
        } else {
            ageFilterNum = 2;
        }
        return ageFilterNum;
    }

    //factory static method
    public static int stateFilter(String stateString) {
        int stateFilterNum = 52;
        String[] states = {"allStates", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "HI", "ID", "IL", "IN",
            "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH",
            "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};

        for (int i = 0; i < states.length; i++) {
            if (stateString == states[i]) {
                stateFilterNum = i;
            }
        }

        return stateFilterNum;
    }

    //factory static method
    public static int genderFilter(String genderString) {
        int genderFilterNum;
        if (genderString == "allGenders") {
            genderFilterNum = 0;
        } else if (genderString == "female") {
            genderFilterNum = 1;
        } else {
            genderFilterNum = 2;
        }
        return genderFilterNum;
    }
}
