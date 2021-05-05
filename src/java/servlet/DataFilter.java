/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import database.Database;

/**
 *
 * @author kld09
 */
public class DataFilter {

    private int filter;
    private int state;
    static Database db;

    public DataFilter(int state, int filter) {
        db = new Database("");
        this.state = state;
        this.filter = filter;
    }

    public static String[] getStateArray(int stateNum, int filterNum) {
        String[] states = db.getStates();
        String state;
        return states;
    }

    public static int[] getCaseArray(int stateNum, int filterNum) {
        int[] cases;
        if (filterNum == 0) {
            cases = db.getCasesAll();
        } else if (filterNum == 1) {
            cases = getCasesUnder18();
        } else if (filterNum == 2) {
            cases = db.getCases18();
        } else if (filterNum == 3) {
            cases = db.getCases65();
        } else if (filterNum == 4) {
            cases = db.getCasesMale();
        } else {
            cases = db.getCasesFemale();
        }
        return cases;
    }

    public static int[] getDeathArray(int stateNum, int filterNum) {
        int[] deaths;
        if (filterNum == 0) {
            deaths = db.getDeathsAll();
        } else if (filterNum == 1) {
            deaths = getDeathsUnder18();
        } else if (filterNum == 2) {
            deaths = db.getDeaths18();
        } else if (filterNum == 3) {
            deaths = db.getDeaths65();
        } else if (filterNum == 4) {
            deaths = db.getDeathsMale();
        } else {
            deaths = db.getDeathsFemale();
        }
        return deaths;
    }

    public static int[] getVaccineArray(int stateNum, int filterNum) {
        int[] vaccines;
        if (filterNum == 0) {
            vaccines = getVaccinatedAll();
        } else if (filterNum == 1) {
            vaccines = getVaccinatedUnder18();
        } else if (filterNum == 2) {
            vaccines = db.getVaccinated18();
        } else if (filterNum == 3) {
            vaccines = db.getVaccinated65();
        } else if (filterNum == 4) {
            vaccines = db.getVaccinatedMale();
        } else {
            vaccines = db.getVaccinatedFemale();
        }
        return vaccines;
    }

    public static int[] getCasesUnder18() {
        int[] caseunder18 = new int[50];
        int[] casesAll = db.getCasesAll();
        int[] cases18 = db.getCases18();
        int[] cases65 = db.getCases65();

        for (int i = 0; i < 50; i++) {
            caseunder18[i] = casesAll[i] - (cases18[i] + cases65[i]);
        }
        return caseunder18;
    }

    public static int[] getDeathsUnder18() {
        int[] deathunder18 = new int[50];
        int[] deathsAll = db.getDeathsAll();
        int[] deaths18 = db.getDeaths18();
        int[] deaths65 = db.getDeaths65();

        for (int i = 0; i < 50; i++) {
            deathunder18[i] = deathsAll[i] - (deaths18[i] + deaths65[i]);
        }
        return deathunder18;
    }

    public static int[] getVaccinatedAll() {
        int[] vaccineAll = new int[50];
        int[] vaccine18 = db.getVaccinated18();
        int[] vaccine65 = db.getVaccinated65();

        for (int i = 0; i < 50; i++) {
            vaccineAll[i] = (vaccine18[i] + vaccine65[i]);
        }
        return vaccineAll;
    }

    public static int[] getVaccinatedUnder18() {
        int[] vaccineunder18 = new int[50];
        int[] vaccineAll = getVaccinatedAll();
        int[] vaccine18 = db.getVaccinated18();
        int[] vaccine65 = db.getVaccinated65();

        for (int i = 0; i < 50; i++) {
            vaccineunder18[i] = vaccineAll[i] - (vaccine18[i] + vaccine65[i]);
        }
        return vaccineunder18;
    }
}
