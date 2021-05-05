/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Purpose: Grabs information from a database containing statistics about death
 * rates, infection rates, and vaccination rates of the COVID-19 Virus.
 *
 * @author ryant
 */
public class Database {

    String className = null;
    String url = null;
    String user = null;
    String password = null;

    /**
     * constructor method for database. Loads & logs into the database.
     */
    public Database() {
        try {
            ResourceBundle resources;
            InputStream in = null;
            ResourceBundle newResources;

            in = ClassLoader.getSystemResourceAsStream("db.properties");

            resources = new PropertyResourceBundle(in);

            in.close();

            className = resources.getString("jdbc.driver");
            url = resources.getString("jdbc.url");
            System.out.println(url);
            user = resources.getString("jdbc.user");
            password = resources.getString("jdbc.password");
        } catch (Exception exp) {
            System.out.println("Couldn't load resources." + exp);
            System.exit(-1);
        }
        try {
            Class.forName(className);
        } catch (Exception e) {
            System.out.println("Failed to load  driver.");
            return;
        }
    }

    public Database(String temp) {
        try {
            //ResourceBundle resources;
            //InputStream in = null;
            //ResourceBundle newResources;

            //in = ClassLoader.getSystemResourceAsStream("db.properties");
            //resources = new PropertyResourceBundle(in);
            //in.close();
            className = "org.apache.derby.jdbc.ClientDriver";
            url = "jdbc:derby://localhost:1527/Covid";
            System.out.println(url);
            user = "app";
            password = "app";
        } catch (Exception exp) {
            System.out.println("Couldn't load resources." + exp);
            System.exit(-1);
        }
        try {
            Class.forName(className);
        } catch (Exception e) {
            System.out.println("Failed to load  driver.");
            return;
        }
    }

    /**
     * Connects to the database and retrieves all information of a single state
     * depending on the parameter given. Parameter is the name of the state,
     * with only the first letter capitalized. Returns the numbers as an integer
     * list, organized by state alphabetical order.
     *
     * @return
     */
    public int[] getStateInfo(String state) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM COVIDSTATS WHERE"
                    + " STATE='" + state + "'");

            int count = 2;
            int info[] = new int[15];

            while (rs.next()) {
                for (int i = 2; i < info.length + 2; i++) {
                    info[i - 2] = Integer.parseInt(rs.getString(i));
                    System.out.println("");
                }
            }
            stmt.close();

            con.close();
            return info;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Connects to the database and retrieves the population number of each
     * state. Returns the population of the states as an integer list, organized
     * by state alphabetical order.
     *
     * @return
     */
    public int[] getPopulation() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT POPULATION FROM COVIDSTATS");

            ResultSetMetaData rsmd = rs.getMetaData();

            int numberOfColumns = rsmd.getColumnCount();
            int rowCount = 1;
            int population[] = new int[50];

            while (rs.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    population[rowCount - 1] = Integer.parseInt(rs.getString(i));
                }
                System.out.println("");
                rowCount++;
            }

            stmt.close();

            con.close();
            return population;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Connects to the database and retrieves the COVID-19 death number of each
     * state. Returns the death number of the states as an integer list,
     * organized by state alphabetical order.
     *
     * @return
     */
    public int[] getDeathsAll() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT DEATHS FROM COVIDSTATS");

            ResultSetMetaData rsmd = rs.getMetaData();

            int numberOfColumns = rsmd.getColumnCount();
            int rowCount = 1;
            int deaths[] = new int[50];

            while (rs.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    deaths[rowCount - 1] = Integer.parseInt(rs.getString(i));
                }
                System.out.println("");
                rowCount++;
            }

            stmt.close();

            con.close();
            return deaths;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Connects to the database and retrieves the COVID-19 deaths, age 18+, of
     * each state. Returns the deaths of the states as an integer list,
     * organized by state alphabetical order.
     *
     * @return
     */
    public int[] getDeaths18() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT DEATHS18 FROM COVIDSTATS");

            ResultSetMetaData rsmd = rs.getMetaData();

            int numberOfColumns = rsmd.getColumnCount();
            int rowCount = 1;
            int deaths[] = new int[50];

            while (rs.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    deaths[rowCount - 1] = Integer.parseInt(rs.getString(i));
                }
                System.out.println("");
                rowCount++;
            }

            stmt.close();

            con.close();
            return deaths;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Connects to the database and retrieves the COVID-19 deaths, age 65+, of
     * each state. Returns the deaths of the states as an integer list,
     * organized by state alphabetical order.
     *
     * @return
     */
    public int[] getDeaths65() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT DEATHS65 FROM COVIDSTATS");

            ResultSetMetaData rsmd = rs.getMetaData();

            int numberOfColumns = rsmd.getColumnCount();
            int rowCount = 1;
            int deaths[] = new int[50];

            while (rs.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    deaths[rowCount - 1] = Integer.parseInt(rs.getString(i));
                }
                System.out.println("");
                rowCount++;
            }

            stmt.close();

            con.close();
            return deaths;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Connects to the database and retrieves the male death number of each
     * state. Returns the deaths of the states as an integer list, organized by
     * state alphabetical order.
     *
     * @return
     */
    public int[] getDeathsMale() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT DEATHSMALE FROM COVIDSTATS");

            ResultSetMetaData rsmd = rs.getMetaData();

            int numberOfColumns = rsmd.getColumnCount();
            int rowCount = 1;
            int deaths[] = new int[50];

            while (rs.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    deaths[rowCount - 1] = Integer.parseInt(rs.getString(i));
                }
                System.out.println("");
                rowCount++;
            }

            stmt.close();

            con.close();
            return deaths;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Connects to the database and retrieves the female death number of each
     * state. Returns the death of the states as an integer list, organized by
     * state alphabetical order.
     *
     * @return
     */
    public int[] getDeathsFemale() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT DEATHSFEMALE FROM COVIDSTATS");

            ResultSetMetaData rsmd = rs.getMetaData();

            int numberOfColumns = rsmd.getColumnCount();
            int rowCount = 1;
            int deaths[] = new int[50];

            while (rs.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    deaths[rowCount - 1] = Integer.parseInt(rs.getString(i));
                }
                System.out.println("");
                rowCount++;
            }

            stmt.close();

            con.close();
            return deaths;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Connects to the database and retrieves the amt of COVID-19 cases of each
     * state. Returns the cases of the states as an integer list, organized by
     * state alphabetical order.
     *
     * @return
     */
    public int[] getCasesAll() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT CASES FROM COVIDSTATS");

            ResultSetMetaData rsmd = rs.getMetaData();

            int numberOfColumns = rsmd.getColumnCount();
            int rowCount = 1;
            int cases[] = new int[50];

            while (rs.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    cases[rowCount - 1] = Integer.parseInt(rs.getString(i));
                }
                System.out.println("");
                rowCount++;
            }

            stmt.close();

            con.close();
            return cases;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Connects to the database and retrieves the COVID-19 cases of 18+ people
     * of each state. Returns the numbers as an integer list, organized by state
     * alphabetical order.
     *
     * @return
     */
    public int[] getCases18() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT MUCASES18 FROM COVIDSTATS");

            ResultSetMetaData rsmd = rs.getMetaData();

            int numberOfColumns = rsmd.getColumnCount();
            int rowCount = 1;
            int cases[] = new int[50];

            while (rs.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    cases[rowCount - 1] = Integer.parseInt(rs.getString(i));
                }
                System.out.println("");
                rowCount++;
            }

            stmt.close();

            con.close();
            return cases;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Connects to the database and retrieves the COVID-19 cases of 65+ people
     * of each state. Returns the numbers as an integer list, organized by state
     * alphabetical order.
     *
     * @return
     */
    public int[] getCases65() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT MUCASES65 FROM COVIDSTATS");

            ResultSetMetaData rsmd = rs.getMetaData();

            int numberOfColumns = rsmd.getColumnCount();
            int rowCount = 1;
            int cases[] = new int[50];

            while (rs.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    cases[rowCount - 1] = Integer.parseInt(rs.getString(i));
                }
                System.out.println("");
                rowCount++;
            }

            stmt.close();

            con.close();
            return cases;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Connects to the database and retrieves the COVID-19 cases of males of
     * each state. Returns the numbers as an integer list, organized by state
     * alphabetical order.
     *
     * @return
     */
    public int[] getCasesMale() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT CASESMALE FROM COVIDSTATS");

            ResultSetMetaData rsmd = rs.getMetaData();

            int numberOfColumns = rsmd.getColumnCount();
            int rowCount = 1;
            int cases[] = new int[50];

            while (rs.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    cases[rowCount - 1] = Integer.parseInt(rs.getString(i));
                }
                System.out.println("");
                rowCount++;
            }

            stmt.close();

            con.close();
            return cases;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Connects to the database and retrieves the COVID-19 female deaths of each
     * state. Returns the numbers as an integer list, organized by state
     * alphabetical order.
     *
     * @return
     */
    public int[] getCasesFemale() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT CASESFEMALE FROM COVIDSTATS");

            ResultSetMetaData rsmd = rs.getMetaData();

            int numberOfColumns = rsmd.getColumnCount();
            int rowCount = 1;
            int cases[] = new int[50];

            while (rs.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    cases[rowCount - 1] = Integer.parseInt(rs.getString(i));
                }
                System.out.println("");
                rowCount++;
            }

            stmt.close();

            con.close();
            return cases;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Connects to the database and retrieves the vaccination number, 18+, of
     * each state. Returns the numbers as an integer list, organized by state
     * alphabetical order.
     *
     * @return
     */
    public int[] getVaccinated18() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT VACCINATED18 FROM COVIDSTATS");

            ResultSetMetaData rsmd = rs.getMetaData();

            int numberOfColumns = rsmd.getColumnCount();
            int rowCount = 1;
            int vacc[] = new int[50];

            while (rs.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    vacc[rowCount - 1] = Integer.parseInt(rs.getString(i));
                }
                System.out.println("");
                rowCount++;
            }

            stmt.close();

            con.close();
            return vacc;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Connects to the database and retrieves the vaccination number, 65+, of
     * each state. Returns the numbers as an integer list, organized by state
     * alphabetical order.
     *
     * @return
     */
    public int[] getVaccinated65() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT VACCINATED65 FROM COVIDSTATS");

            ResultSetMetaData rsmd = rs.getMetaData();

            int numberOfColumns = rsmd.getColumnCount();
            int rowCount = 1;
            int vacc[] = new int[50];

            while (rs.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    vacc[rowCount - 1] = Integer.parseInt(rs.getString(i));
                }
                System.out.println("");
                rowCount++;
            }

            stmt.close();

            con.close();
            return vacc;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Connects to the database and retrieves the vaccination number of males,
     * of each state. Returns the numbers as an integer list, organized by state
     * alphabetical order.
     *
     * @return
     */
    public int[] getVaccinatedMale() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT MUVACCINATEDMALE FROM COVIDSTATS");

            ResultSetMetaData rsmd = rs.getMetaData();

            int numberOfColumns = rsmd.getColumnCount();
            int rowCount = 1;
            int vacc[] = new int[50];

            while (rs.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    vacc[rowCount - 1] = Integer.parseInt(rs.getString(i));
                }
                System.out.println("");
                rowCount++;
            }

            stmt.close();

            con.close();
            return vacc;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Connects to the database and retrieves the vaccination number of females,
     * of each state. Returns the numbers as an integer list, organized by state
     * alphabetical order.
     *
     * @return
     */
    public int[] getVaccinatedFemale() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT MUVACCINATEDFEMALE FROM COVIDSTATS");

            ResultSetMetaData rsmd = rs.getMetaData();

            int numberOfColumns = rsmd.getColumnCount();
            int rowCount = 1;
            int vacc[] = new int[50];

            while (rs.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    vacc[rowCount - 1] = Integer.parseInt(rs.getString(i));
                }
                System.out.println("");
                rowCount++;
            }

            stmt.close();

            con.close();
            return vacc;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String[] getStates() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT STATE FROM COVIDSTATS");

            ResultSetMetaData rsmd = rs.getMetaData();

            int numberOfColumns = rsmd.getColumnCount();
            int rowCount = 1;
            String states[] = new String[50];

            while (rs.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    states[rowCount - 1] = rs.getString(i);
                }
                System.out.println("");
                rowCount++;
            }

            stmt.close();

            con.close();
            return states;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
