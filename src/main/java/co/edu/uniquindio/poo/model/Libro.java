package co.edu.uniquindio.poo.model;

import java.util.Date;
import java.util.LinkedList;

public class Libro {
    private String codigo;
    private String isbn;
    private String autor;
    private String titulo;
    private String editorial;
    private Date fechapublicacion;
    private int unidadesdisp;
    private LinkedList<DetallesPrestamo> detalles;

    public Libro(String codigo, String isbn, String autor, String titulo, String editorial, Date fechapublicacion,
            int unidadesdisp) {
        this.codigo = codigo;
        this.isbn = isbn;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fechapublicacion = fechapublicacion;
        this.unidadesdisp = unidadesdisp;
        detalles = new LinkedList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Date getFechapublicacion() {
        return fechapublicacion;
    }

    public void setFechapublicacion(Date fechapublicacion) {
        this.fechapublicacion = fechapublicacion;
    }

    public int getUnidadesdisp() {
        return unidadesdisp;
    }

    public void setUnidadesdisp(int unidadesdisp) {
        this.unidadesdisp = unidadesdisp;
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
     * Compara dado el código del libro
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Libro other = (Libro) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    /**
     * Cuenta en cuantos detalles de prestamo se encuentra
     * 
     * @return
     */
    public int contarcantidadprestamos() {
        return detalles.size();
    }

    /**
     * disminuye la cantidad de unidades disponibles del libro
     */
    public void disminuircantidaddisponible(int unidadesprestadas) {
        unidadesdisp -= unidadesprestadas;
    }

    /**
     * aumenta la cantidad de unidades disponibles del libro
     */
    public void aumentarcantidaddisponible(int unidadesprestadas) {
        unidadesdisp+= unidadesprestadas;
    }
}
