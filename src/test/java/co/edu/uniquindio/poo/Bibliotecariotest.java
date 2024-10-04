package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Bibliotecario;
import co.edu.uniquindio.poo.model.DetallesPrestamo;
import co.edu.uniquindio.poo.model.Libro;
import co.edu.uniquindio.poo.model.Prestamo;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

public class Bibliotecariotest {
private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    @Test
    public void calcularsueldotest() {
        LOG.info("Iniciado test ");
        Date fechaingreso = new Date(95, 2, 5);
        Bibliotecario bibliotecario = new Bibliotecario("Paco", "5465465", "5456", "JJIOJIOJ", 5000, fechaingreso);
        float salario = bibliotecario.calcularsueldo();
        assertEquals(0 ,salario);//Da 0 por que como no tiene ningún prestamo se multiplica por 0
        
        Date fechaprestamo = new Date(124, 2, 5);
        Date fechaentrega = new Date(124, 2, 23);
        Libro libro = new Libro(null, null, null, null, null, fechaprestamo, 20);
        DetallesPrestamo detalles1 = new DetallesPrestamo(500, 1, libro);
        DetallesPrestamo detalles2 = new DetallesPrestamo(1000, 2, libro);
        LinkedList <DetallesPrestamo> listadetalles = new LinkedList<>();
        listadetalles.add(detalles2);
        listadetalles.add(detalles1);
        Prestamo prestamo = new Prestamo("1", fechaprestamo, null, null, listadetalles);

        bibliotecario.AgregarPrestamo(prestamo);
        prestamo.calcularcostoprestamo(fechaentrega);
        assertEquals(8532, bibliotecario.calcularsueldo());//Prestamo de 27000 de costo y 29 años de antiguedad.
        
        LOG.info("Finalizando test ");
    }

    @Test
    public void contarcantidadprestamostest() {
        LOG.info("Iniciado test ");
        
        Prestamo prestamo1 = new Prestamo("1", null, null, null, null);
        Prestamo prestamo2 = new Prestamo("2", null, null, null, null);
        Prestamo prestamo3 = new Prestamo("3", null, null, null, null);
        Prestamo prestamo4 = new Prestamo("4", null, null, null, null);
        Bibliotecario bibliotecario = new Bibliotecario(null, null, null, null, 0, null);
        bibliotecario.AgregarPrestamo(prestamo1);
        bibliotecario.AgregarPrestamo(prestamo2);
        bibliotecario.AgregarPrestamo(prestamo3);
        bibliotecario.AgregarPrestamo(prestamo4);
        assertEquals(4,bibliotecario.contarcantidadprestamos());

        LOG.info("Finalizando test ");
    }
}
