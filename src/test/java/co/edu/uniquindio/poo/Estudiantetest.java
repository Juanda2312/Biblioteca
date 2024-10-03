package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Estudiante;
import co.edu.uniquindio.poo.model.Prestamo;
import java.util.HashMap;

public class Estudiantetest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

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
        Estudiante estudiante = new Estudiante(null, null, null, null, null);
        estudiante.setListaprestamos(listaprestamos);

        assertEquals(4,estudiante.contarcantidadprestamos());

        LOG.info("Finalizando test ");
}
    @Test
    public void getListaprestamos(){
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
        Estudiante estudiante = new Estudiante(null, null, null, null, null);
        estudiante.setListaprestamos(listaprestamos);

        assertEquals(listaprestamos, estudiante.getListaprestamos());
        
        LOG.info("Finalizando test ");
    }
}
