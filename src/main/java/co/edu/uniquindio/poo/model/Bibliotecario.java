package co.edu.uniquindio.poo.model;

import java.util.HashMap;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Bibliotecario extends Persona {
    private float salario;
    private HashMap<String, Prestamo> listaprestamos;
    private Date fechaingreso;

    Bibliotecario(String nombre, String cedula, String telefono, String correo, float salario, Date fechaingreso) {
        super(nombre, cedula, telefono, correo);
        this.salario = salario;
        this.fechaingreso = fechaingreso;
        listaprestamos = new HashMap<>();
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public HashMap<String, Prestamo> getListaprestamos() {
        return listaprestamos;
    }

    public void setListaprestamos(HashMap<String, Prestamo> listaprestamos) {
        this.listaprestamos = listaprestamos;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    /**
     * cuenta la cantidad de prestamos realizados por el bibliotecario
     * 
     * @return cantidad de prestamos realizados
     */
    public int contarcantidadprestamos() {
        return listaprestamos.size();
    }

    /**
     * Calcula el sueldo dependiendo de los prestamos realizados y su antiguedad
     * 
     * @return el sueldo
     */
    public float calcularsueldo() {
        float sueldo = 0;
        Date fechaactual = new Date();
        long antiguedad = fechaactual.getTime() - fechaingreso.getTime();
        TimeUnit unidad = TimeUnit.DAYS;
        long dias = unidad.convert(antiguedad, TimeUnit.MILLISECONDS);
        long años = dias / 365;
        for (String codigo : listaprestamos.keySet()) {
            Prestamo prestamo = listaprestamos.get(codigo);
            sueldo += prestamo.getCostototal() * 0.2;
        }
        sueldo += sueldo * (0.02 * años);
        return sueldo;
    }

}
