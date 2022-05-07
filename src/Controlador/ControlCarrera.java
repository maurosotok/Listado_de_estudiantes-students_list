package Controlador;

import Modelo.Carrera;
import javax.swing.JTextField;

public class ControlCarrera {
    JTextField carreraid;
    JTextField nombre;
    JTextField director;
    
    public ControlCarrera(JTextField cid, JTextField nom, JTextField dir){
        carreraid = cid;
        nombre = nom;
        director = dir;
        System.out.println("carreraid"+carreraid.getText());
    }
    public void Limpiar(){
        carreraid.setText("");nombre.setText("");director.setText("");
    }
    public void selCarrera(){
        Carrera carrera = new Carrera().selectCarrera(Integer.parseInt(carreraid.getText()));
        nombre.setText(carrera.getNombre());
        director.setText(carrera.getDirector());
    }
    public void insCarrera(){
        Carrera carrera = new Carrera();
        carrera.setCarreraID(Integer.parseInt(carreraid.getText()));
        carrera.setNombre(nombre.getText());
        carrera.setDirector(director.getText());
        carrera.insertCarrera();
        Limpiar();
    }
    public void updCarrera(){
        Carrera carrera = new Carrera(Integer.parseInt(carreraid.getText()), nombre.getText(), director.getText());
        carrera.updateCarrera();
        Limpiar();
    }
    public void delCarrera(){
        Carrera carrera = new Carrera();
        carrera.setCarreraID(Integer.parseInt(carreraid.getText()));
        carrera.deleteCarrera();
        Limpiar();
    }
}
