package co.edu.uniquindio.poo.model;

import java.util.HashMap;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.LinkedList;

public class Bibliotecario extends Persona {
    private float salario;
    private HashMap<String, Prestamo> listaprestamos;
    private Date fechaingreso;

    public Bibliotecario(String nombre, String cedula, String telefono, String correo, float salario, Date fechaingreso) {
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
 
    /**
     * Agrega un prestamo siempre y cuando este no este ya creado
     * 
     * @param prestamo
     * @return un mensaje indicando si ya existe o si se agregó
     */
    public String AgregarPrestamo(Prestamo prestamo) {
        String mensaje = "El prestamo ya existe";
        if (prestamo != null) {
            boolean existe = BuscarPrestamo(prestamo.getCodigo());
        if (!existe) {
            listaprestamos.put(prestamo.getCodigo(), prestamo);
            mensaje = "El prestamo ha sido agregado correctamente";
        }
        }else{
            mensaje = "El prestamo no puede ser null";
        }
        
        return mensaje;
    }

    /**
     * Busca un prestamo mediante su código
     * 
     * @param codigo
     * @return true si ya existe, false si no
     */
    public boolean BuscarPrestamo(String codigo) {
        return listaprestamos.containsKey(codigo);
    }

    /**
     * Elimina un prestamo siempre y cuando exista
     * 
     * @param prestamo
     * @return un mensaje indicando si el prestamo no existe o si se eliminó
     */
    public String Eliminarprestamo(Prestamo prestamo) {
        String mensaje = "El prestamo no existe";
        boolean existe = BuscarPrestamo(prestamo.getCodigo());
        if (existe) {
            listaprestamos.remove(prestamo.getCodigo());
            mensaje = "El prestamo ha sido eliminado correctamente";
        }
        return mensaje;
    }

    /**
     * Actualiza la información de un prestamo si este existe
     * 
     * @param prestamo
     * @param codigo
     * @param fechaprestamo
     * @param estudiante
     * @param bibliotecario
     * @param detalles
     * @return un mensaje indicando si el prestamo no existe o si se actualizo su
     *         información
     */
    public String actualizarprestamo(Prestamo prestamo, String codigo, Date fechaprestamo, Estudiante estudiante,
            Bibliotecario bibliotecario, LinkedList<DetallesPrestamo> detalles, Date fechaentrega,
            EstadoPrestamo estado, float costototal) {
        String mensaje = "El prestamo no existe";
        boolean existe = BuscarPrestamo(prestamo.getCodigo());
        if (existe) {
            Prestamo prestamoaux = listaprestamos.get(prestamo.getCodigo());
            prestamoaux.setCodigo(codigo);
            prestamoaux.setDetalles(detalles);
            prestamoaux.setFechaprestamo(fechaprestamo);
            prestamoaux.setBibliotecario(bibliotecario);
            prestamoaux.setEstudiante(estudiante);
            prestamoaux.setFechaentrega(fechaentrega);
            prestamoaux.setEstado(estado);
            prestamoaux.setCostototal(costototal);

            if (!prestamo.getCodigo().equals(codigo)) {
                listaprestamos.remove(prestamo.getCodigo());
                listaprestamos.put(codigo, prestamoaux);
            }

            mensaje = "La información del prestamo ha sido actualizada";
        }
        return mensaje;
    }
}
