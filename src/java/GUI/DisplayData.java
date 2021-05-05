/*
 * CMPSC 221
 * DisplayData.java
 * Purpose: Displays COVID-19 Statistics based on filters user has selected
 *

 * Author: Gabe Le
 * @Version 1.0 5/4/21
 */
package GUI;

import database.Database;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class DisplayData extends javax.swing.JFrame {

    /**
     * Creates new form DisplayData
     */
    public DisplayData() {
        initComponents();
        
        
        
    }
    
    /*
     * Adds data into the table given filters that user has selected
     * 
     * @param state, filter, percent
     */
    public void addData(int state, int filter, boolean percent) {
        Database db = new Database();
        String states[] = db.getStates();
        double test = 31.213;
        final int rows = 51;
        
        //Allows data to be added into the table
        DefaultTableModel dt = 
                        (DefaultTableModel) displayTable.getModel();
        dt.setRowCount(0);
        
        if (state == 0) { //Checks to see if no filter for state is selected
            for (int i = 1; i < rows; i++) {
                //Obtains data for state based on parameter given
                int values[] = db.getStateInfo(states[i-1]); 
                
                //Creates a vector to input into the table
                Vector info = new Vector();
                
                //Adds state name to first column/vector
                info.add(states[i-1]);
                
                /*Filters for which statistic is needed and calculates
                 * percentage and rounds up if need be
                 */
                if (percent) {
                    info.add(Math.round(((double)deathFilter(filter, values) / 
                            (double)values[0]) * 10000.0) / 100.00 + "%");
                    info.add(Math.round(((double)caseFilter(filter, values) / 
                            (double)values[0]) * 10000.0) / 100.00 + "%");
                    info.add(Math.round(((double)vacFilter(filter, values) / 
                            (double)values[0]) * 10000.0) / 100.00 + "%");
                }
                else {
                    info.add(deathFilter(filter, values));
                    info.add(caseFilter(filter, values));
                    info.add(vacFilter(filter, values));
                }
                dt.addRow(info);
            }
            //Displays data based on filter
            this.setVisible(true);
        }
        else {
            int values[] = db.getStateInfo(states[state-1]);
                Vector info = new Vector();
                
                info.add(states[state-1]);
                if (percent) {
                    info.add(Math.round(((double)deathFilter(filter, values) / 
                            (double)values[0]) * 10000.0) / 100.00 + "%");
                    info.add(Math.round(((double)caseFilter(filter, values) / 
                            (double)values[0]) * 10000.0) / 100.00 + "%");
                    info.add(Math.round(((double)vacFilter(filter, values) / 
                            (double)values[0]) * 10000.0) / 100.00 + "%");
                }
                else {
                    info.add(deathFilter(filter, values));
                    info.add(caseFilter(filter, values));
                    info.add(vacFilter(filter, values));
                }
                
                dt.addRow(info);
                
            this.setVisible(true);
        }
            
    }
    /*
     * Returns death statistic based on filter
     * 
     * @param filter, values
     * @return count
     */
    public int deathFilter(int filter, int[] values) {
        int count = values[1];
        
        //Assigns count to be appropriate value based on filter
        switch (filter) {
            case 1:
                count = (count - values[2]);
                break;
            case 2:
                count = values[2];
                break;
            case 3:
                count = values[3];
                break;
            case 4:
                count = values[4];
                break;
            case 5:
                count = values[5];
                break;
            default:
                break;
        }
        return count;
    }
    
    /*
     * Returns case statistic based on filter
     * 
     * @param filter, values
     * @return count
     */
    public int caseFilter(int filter, int[] values) {
        int count = values[6];
        
        switch (filter) {
            case 1:
                count = (count - values[7]);
                break;
            case 2:
                count = values[7];
                break;
            case 3:
                count = values[8];
                break;
            case 4:
                count = values[9];
                break;
            case 5:
                count = values[10];
                break;
            default:
                break;
        }
        return count;
    }
    
    /*
     * Returns vaccination statistic based on filter
     * 
     * @param filter, values
     * @return count
     */
    public int vacFilter(int filter, int[] values) {
        int count = (values[13] + values[14]);
        
        switch (filter) {
            case 1:
                count = (count - values[7]);
                break;
            case 2:
                count = values[11];
                break;
            case 3:
                count = values[12];
                break;
            case 4:
                count = values[13];
                break;
            case 5:
                count = values[14];
                break;
            default:
                break;
        }
        return count;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "State", "Dead", "Cases", "Vaccinated"
            }
        ));
        jScrollPane2.setViewportView(displayTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable displayTable;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
