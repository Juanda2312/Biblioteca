package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.DetallesPrestamo;
import co.edu.uniquindio.poo.model.Libro;
import co.edu.uniquindio.poo.model.Prestamo;
import java.util.Date;
import java.util.LinkedList;

public class Librotest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    @Test
    public void cantidadunidadesdisptest() {
      LOG.info("Iniciado test ");
        Date fechaprestamo = new Date(124, 2, 5);
        Date fechaentrega = new Date(124, 2, 23);
        Libro libro = new Libro(null, null, null, null, null, fechaprestamo, 20);
        assertEquals(20, libro.getUnidadesdisp());

        DetallesPrestamo detalles1 = new DetallesPrestamo(500, 1, libro);
        assertEquals(19, libro.getUnidadesdisp());//Se presta 1 quedan 19

        DetallesPrestamo detalles2 = new DetallesPrestamo(1000, 2, libro);
        LinkedList <DetallesPrestamo> listadetalles = new LinkedList<>();
        libro.setDetalles(listadetalles);
        listadetalles.add(detalles2);
        listadetalles.add(detalles1);
        assertEquals(17, libro.getUnidadesdisp());//Se presta otros 2 quedan 17

        Prestamo prestamo = new Prestamo("1", fechaprestamo, null, null, listadetalles);
        prestamo.calcularcostoprestamo(fechaentrega); //Se entregan los libros
        assertEquals(20, libro.getUnidadesdisp()); //Como se entregaron vuelven otra vez a 20

        LOG.info("Finalizando test ");
}
    @Test
    public void cantidadprestamostest() {
      LOG.info("Iniciado test ");

        Libro libro = new Libro(null, null, null, null, null, null, 20);
        DetallesPrestamo detalles1 = new DetallesPrestamo(500, 1, libro);
        DetallesPrestamo detalles2 = new DetallesPrestamo(1000, 2, libro);
        LinkedList <DetallesPrestamo> listadetalles = new LinkedList<>();
        libro.setDetalles(listadetalles);
        listadetalles.add(detalles2);
        listadetalles.add(detalles1);
        assertEquals(2,libro.contarcantidadprestamos());

        LOG.info("Finalizando test ");
}
}