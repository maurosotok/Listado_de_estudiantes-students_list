package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {
    private Connection con;
    public Conexion(){
        try {
            String url = "jdbc:mysql://localhost:3306/matricula?zeroDateTimeBehavior=convertToNull";
            con = DriverManager.getConnection(url, "root", "unahvs2021");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public Connection getConexion(){
        return con;
    }
    public Statement getStatement(){
        Statement stm = null;
        try {
            stm = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return stm;
    }
}
