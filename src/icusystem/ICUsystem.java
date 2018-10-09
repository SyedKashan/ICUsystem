/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icusystem;
import java.sql.*;

/**
 *
 * @author kasha
 */
public class ICUsystem {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getconnection();
        firstScreen form = new firstScreen();
        form.setVisible(true);
        
        try{
        for (int i=0;i<=100;i++){
        Thread.sleep(30);
        form.percent.setText(Integer.toString(i)+"%");
        form.progressbar.setValue(i);       
        if (i == 100){
        form.setVisible(false);
        }
        }
        
        }
        catch(Exception e)
        {}                
             
    }
    
    public static void getconnection(){
       
        Connection conn = null;
        try{
            conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/checkdatabase?autoReconnect=true&useSSL=false","root","goodman997");
            System.out.println("Connected");
             
            Statement statement = (Statement) conn.createStatement();
            String Fname = "Jname";
            String Lname = "Brown";
            String insert = "Insert into users (Fname,Lname) values ('"+Fname+"','"+Lname+"');";
            statement.executeUpdate(insert);
                    
        }
                catch(SQLException e){
                    System.err.println(e);
                }    
    }
    
}
