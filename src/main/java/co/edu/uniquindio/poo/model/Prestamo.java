package co.edu.uniquindio.poo.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Prestamo {
    private String codigo;
    private Date fechaprestamo;
    private Date fechaentrega;
    private float costototal;
    private EstadoPrestamo estado;
    private Estudiante estudiante;
    private Bibliotecario bibliotecario;
    private LinkedList<DetallesPrestamo> detalles;

    public Prestamo(String codigo, Date fechaprestamo, Estudiante estudiante, Bibliotecario bibliotecario,
            LinkedList<DetallesPrestamo> detalles) {
        this.codigo = codigo;
        this.fechaprestamo = fechaprestamo;
        this.estado = EstadoPrestamo.NOENTREGADO;
        this.estudiante = estudiante;
        this.bibliotecario = bibliotecario;
        this.detalles = detalles;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechaprestamo(Date fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public Date getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(Date fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public float getCostototal() {
        return costototal;
    }

    public void setCostototal(float costototal) {
        this.costototal = costototal;
    }

    public EstadoPrestamo getEstado() {
        return estado;
    }

    public void setEstado(EstadoPrestamo estado) {
        this.estado = estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public LinkedList<DetallesPrestamo> getDetalles() {
        return detalles;
    }

    public void setDetalles(LinkedList<DetallesPrestamo> detalles) {
        this.detalles = detalles;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    /**
     * Compara basado en el codigo
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Prestamo other = (Prestamo) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    /**
     * Calcula el costo total del prestamo basado en los días de espera y actualiza
     * los datos dandolo por entregado
     * 
     * @param fechaentregaaux
     * @return costo total del prestamo
     */
    public float calcularcostoprestamo(Date fechaentregaaux) {
        costototal = 0;
        long tiempo = fechaentregaaux.getTime() - fechaprestamo.getTime();
        TimeUnit unidad = TimeUnit.DAYS;
        long dias = unidad.convert(tiempo, TimeUnit.MILLISECONDS);
        for (DetallesPrestamo detalle : detalles) {
            costototal += detalle.getCostoprestamo();
            detalle.getLibro().aumentarcantidaddisponible(detalle.getUnidadesprestadas());
        }
        costototal = costototal * dias;
        fechaentrega = fechaentregaaux;
        estado = EstadoPrestamo.ENTREGADO;
        return costototal;
    }
}
