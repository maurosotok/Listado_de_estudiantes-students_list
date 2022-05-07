package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Carrera {
    private int CarreraID;
    private String Nombre;
    private String Director;
    public Carrera(){
        CarreraID = -1; Nombre = ""; Director= "";
    }
    public Carrera(int CarreraID, String Nombre, String Director) {
        this.CarreraID = CarreraID;
        this.Nombre = Nombre;
        this.Director = Director;
    }
    public int getCarreraID() {
        return CarreraID;
    }
    public void setCarreraID(int CarreraID) {
        this.CarreraID = CarreraID;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getDirector() {
        return Director;
    }
    public void setDirector(String Director) {
        this.Director = Director;
    }
    
    public Carrera selectCarrera(int CarreraID){
        try {
            String sql = "select * from Carrera where CarreraID = "+CarreraID;
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                Nombre = rs.getString("Nombre");
                Director = rs.getString("Director");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    public void insertCarrera(){
        try {
            String sql = "insert into Carrera values (?, ?, ?)";
            PreparedStatement ps = new Conexion().getConexion().prepareStatement(sql);
            ps.setInt(1, CarreraID);
            ps.setString(2, Nombre);
            ps.setString(3, Director);
            ps.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void updateCarrera(){
        try {
            String sql = "update Carrera set nombre = ?, director = ? where carreraID = ?";
            PreparedStatement ps = new Conexion().getConexion().prepareStatement(sql);
            ps.setString(1, Nombre);
            ps.setString(2, Director);
            ps.setInt(3, CarreraID);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void deleteCarrera(){
        try {
            String sql = "delete from Carrera where Carreraid = ?";
            PreparedStatement ps = new Conexion().getConexion().prepareStatement(sql);
            ps.setInt(1, CarreraID);
            ps.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
