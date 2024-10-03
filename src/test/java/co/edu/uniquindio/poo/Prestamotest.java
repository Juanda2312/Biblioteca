package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Prestamo;
import co.edu.uniquindio.poo.model.DetallesPrestamo;
import co.edu.uniquindio.poo.model.EstadoPrestamo;
import co.edu.uniquindio.poo.model.Libro;

import java.util.Date;
import java.util.LinkedList;

public class Prestamotest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    @Test
    public void contarcantidadprestamostest() {
        LOG.info("Iniciado test ");
        Date fechaprestamo = new Date(124, 2, 5);
        Date fechaentrega = new Date(124, 2, 23);
        Libro libro = new Libro(null, null, null, null, null, fechaprestamo, 20);
        DetallesPrestamo detalles1 = new DetallesPrestamo(500, 1, libro);
        DetallesPrestamo detalles2 = new DetallesPrestamo(1000, 2, libro);
        LinkedList <DetallesPrestamo> listadetalles = new LinkedList<>();
        listadetalles.add(detalles2);
        listadetalles.add(detalles1);
        Prestamo prestamo = new Prestamo("1", fechaprestamo, null, null, listadetalles);

        float resultado = prestamo.calcularcostoprestamo(fechaentrega);
        assertEquals(27000, resultado);
        assertEquals(EstadoPrestamo.ENTREGADO, prestamo.getEstado());

        LOG.info("Finalizando test ");
}
    @Test
    public void equalstest() {
        LOG.info("Iniciado test ");
        Prestamo prestamo1 = new Prestamo("1", null, null, null, null);
        Prestamo prestamo2 = new Prestamo("5", null, null, null, null);
        Prestamo prestamo3 = new Prestamo("1", null, null, null, null);

        assertTrue(prestamo1.equals(prestamo3));
        assertFalse(prestamo1.equals(prestamo2));
        LOG.info("Finalizando test ");
}
}
