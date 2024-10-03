package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Bibliotecario;
import co.edu.uniquindio.poo.model.Prestamo;

import java.util.Date;
import java.util.HashMap;

public class Bibliotecariotest {
private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    @Test
    public void calcularsueldotest() {
        LOG.info("Iniciado test ");
        Date fechaingreso = new Date(95, 2, 5);
        Bibliotecario bibliotecario = new Bibliotecario("Paco", "5465465", "5456", "JJIOJIOJ", 5000, fechaingreso);
        float salario = bibliotecario.calcularsueldo();
        assertEquals(0 ,salario);//Da 0 por que como no tiene ningún prestamo se multiplica por 0
        
        LOG.info("Finalizando test ");
    }

    @Test
    public void contarcantidadprestamostest() {
        LOG.info("Iniciado test ");
        
        Prestamo prestamo1 = new Prestamo("1", null, null, null, null);
        Prestamo prestamo2 = new Prestamo("2", null, null, null, null);
        Prestamo prestamo3 = new Prestamo("3", null, null, null, null);
        Prestamo prestamo4 = new Prestamo("4", null, null, null, null);
        HashMap <String,Prestamo> listaprestamos = new HashMap<>();
        listaprestamos.put(prestamo1.getCodigo(), prestamo1);
        listaprestamos.put(prestamo2.getCodigo(), prestamo2);
        listaprestamos.put(prestamo3.getCodigo(), prestamo3);
        listaprestamos.put(prestamo4.getCodigo(), prestamo4);
        Bibliotecario bibliotecario = new Bibliotecario(null, null, null, null, 0, null);
        bibliotecario.setListaprestamos(listaprestamos);

        assertEquals(4,bibliotecario.contarcantidadprestamos());

        LOG.info("Finalizando test ");
    }
}
