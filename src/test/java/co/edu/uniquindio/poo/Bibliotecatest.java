package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Biblioteca;
import co.edu.uniquindio.poo.model.Estudiante;
import co.edu.uniquindio.poo.model.Libro;

public class Bibliotecatest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    @Test
    public void Agregarestudiantetest() {
        LOG.info("Iniciado test ");

        Biblioteca biblioteca = new Biblioteca("biblioteca ");
        String resultado = biblioteca.Agregarestudiante(null);
        assertEquals("El estudiante no puede ser nulo", resultado);

        Estudiante estudiante1 = new Estudiante("Juan", "150", "54564654", "ijdkjsakdjwid", "Ingenieria");
        Estudiante estudiante2 = new Estudiante("Paco", "150", "54545468484", "ij5499dkjsakdjwid", "Ingenieria");

        resultado = biblioteca.Agregarestudiante(estudiante1);
        assertEquals("El estudiante ha sido agregado correctamente", resultado);

        resultado = biblioteca.Agregarestudiante(estudiante2);
        assertEquals("El estudiante ya existe", resultado);

        LOG.info("Finalizando test ");
    }

    @Test
    public void ActualizarLibrotest() {
        LOG.info("Iniciado test ");

        Biblioteca biblioteca = new Biblioteca("biblioteca ");
        String resultado = biblioteca.ActualizarLibro(null, null, null, null, null, null, null, 0);
        assertEquals("El libro no existe", resultado);

        Libro libro = new Libro("45698", "54684", "Gabriel", "SI", "Tambien", null, 12);
        resultado = biblioteca.AgregarLibro(libro);
        assertEquals("El libro ha sido agregado correctamente", resultado);

        resultado = biblioteca.ActualizarLibro(libro, "26546", "5498448", "Antonio", "No", "Tampoco", null, 25);
        assertEquals("La información del libro ha sido actualizada",resultado);

        LOG.info("Finalizando test ");
    }
}

