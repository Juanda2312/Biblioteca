package co.edu.uniquindio.poo.model;

public class DetallesPrestamo {
    private float costoprestamo;
    private int unidadesprestadas;
    private Libro libro;

    public DetallesPrestamo(float costoprestamo, int unidadesprestadas, Libro libro) {
        this.costoprestamo = costoprestamo;
        this.unidadesprestadas = unidadesprestadas;
        this.libro = libro;
        libro.disminuircantidaddisponible(unidadesprestadas);
    }

    public float getCostoprestamo() {
        return costoprestamo;
    }

    public void setCostoprestamo(float costoprestamo) {
        this.costoprestamo = costoprestamo;
    }

    public int getUnidadesprestadas() {
        return unidadesprestadas;
    }

    public void setUnidadesprestadas(int unidadesprestadas) {
        this.unidadesprestadas = unidadesprestadas;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

}
