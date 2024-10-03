package co.edu.uniquindio.poo.model;

import java.util.HashMap;

public class Estudiante extends Persona {

    private String programa;
    private HashMap<String, Prestamo> listaprestamos;

    public Estudiante(String nombre, String cedula, String telefono, String correo, String programa) {
        super(nombre, cedula, telefono, correo);
        this.programa = programa;
        listaprestamos = new HashMap<>();
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public HashMap<String, Prestamo> getListaprestamos() {
        return listaprestamos;
    }

    public void setListaprestamos(HashMap<String, Prestamo> listaprestamos) {
        this.listaprestamos = listaprestamos;
    }

    /**
     * cuenta la cantidad de prestamos realizados por el estudiante
     * 
     * @return
     */
    public int contarcantidadprestamos() {
        return listaprestamos.size();
    }

}
