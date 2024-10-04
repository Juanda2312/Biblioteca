package co.edu.uniquindio.poo.model;

import java.util.HashMap;
import java.util.Date;
import java.util.LinkedList;

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
