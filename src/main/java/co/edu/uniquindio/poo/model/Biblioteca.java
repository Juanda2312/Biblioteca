package co.edu.uniquindio.poo.model;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

public class Biblioteca {

    private String nombre;
    private ArrayList<Persona> listapersonas;
    private HashMap<String, Prestamo> listaprestamos;
    private LinkedList<Libro> listalibros;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        listapersonas = new ArrayList<>();
        listaprestamos = new HashMap<>();
        listalibros = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Persona> getListapersonas() {
        return listapersonas;
    }

    public void setListapersonas(ArrayList<Persona> listapersonas) {
        this.listapersonas = listapersonas;
    }

    public HashMap<String, Prestamo> getListaprestamos() {
        return listaprestamos;
    }

    public void setListaprestamos(HashMap<String, Prestamo> listaprestamos) {
        this.listaprestamos = listaprestamos;
    }

    public LinkedList<Libro> getListalibros() {
        return listalibros;
    }

    public void setListalibros(LinkedList<Libro> listalibros) {
        this.listalibros = listalibros;
    }

    /**
     * agrega a un estudiante a la lista de personas si no está agregada
     * 
     * @param estudiante
     * @return un mensaje diciendo si ya existía o si se agregó
     */
    public String Agregarestudiante(Estudiante estudiante) {
        String mensaje = "El estudiante ya existe";
        if (estudiante != null) {
            boolean existe = Buscarestudiante(estudiante);
        if (!existe) {
            listapersonas.add(estudiante);
            mensaje = "El estudiante ha sido agregado correctamente";
        }
        }else{
            mensaje = "El estudiante no puede ser nulo";
        }
        return mensaje;
    }

    /**
     * Busca si un estudiante está en la lista de personas
     * 
     * @param estudiante
     * @return true si está, false en caso contrario
     */
    public boolean Buscarestudiante(Estudiante estudiante) {
        return listapersonas.contains(estudiante);
    }

    /**
     * Elimina un estudiante siempre y cuando este exista
     * 
     * @param estudiante
     * @return un mensaje diciendo si no existe o si se eliminó
     */
    public String Eliminarestudiante(Estudiante estudiante) {
        String mensaje = "El estudiante no existe";
        boolean existe = Buscarestudiante(estudiante);
        if (existe) {
            listapersonas.remove(estudiante);
            mensaje = "El estudiante ha sido eliminado correctamente";
        }
        return mensaje;
    }

    /**
     * Actualiza la información de un estudiante si este existe
     * 
     * @param estudiante
     * @param nombre
     * @param cedula
     * @param telefono
     * @param correo
     * @param programa
     * @return un mensaje diciendo si no existe o si se actualizó la información
     */
    public String Actualizarestudiante(Estudiante estudiante, String nombre, String cedula, String telefono,
            String correo, String programa) {
        String mensaje = "El estudiante no existe";
        boolean existe = Buscarestudiante(estudiante);
        if (existe) {
            int index = listapersonas.indexOf(estudiante);
            Persona personaaux = listapersonas.get(index);
            Estudiante estudianteaux = (Estudiante) personaaux;
            estudianteaux.setCedula(cedula);
            estudianteaux.setCorreo(correo);
            estudianteaux.setNombre(nombre);
            estudianteaux.setPrograma(programa);
            estudianteaux.setTelefono(telefono);
            mensaje = "La información del estudiante ha sido actualizada";
        }
        return mensaje;
    }

    /**
     * Agrega a un bibliotecario a la lista de personas si no está agregado
     * 
     * @param bibliotecario
     * @return un mensaje diciendo si ya existía o si se agregó
     */
    public String AgregarBibliotecario(Bibliotecario bibliotecario) {
        String mensaje = "El bibliotecario ya existe";
        if (bibliotecario != null) {
            boolean existe = BuscarBibliotecario(bibliotecario);
        if (!existe) {
            listapersonas.add(bibliotecario);
            mensaje = "El bibliotecario ha sido agregado correctamente";
        }
        }else{
            mensaje = "El bibliotecario no puede ser null";
        }
        
        return mensaje;
    }

    /**
     * Busca si un bibliotecario está en la lista de personas
     * 
     * @param bibliotecario
     * @return true si está, false en caso contrario
     */
    public boolean BuscarBibliotecario(Bibliotecario bibliotecario) {
        return listapersonas.contains(bibliotecario);
    }

    /**
     * Elimina un bibliotecario siempre y cuando este exista
     * 
     * @param bibliotecario
     * @return un mensaje diciendo si no existe o si se eliminó
     */
    public String EliminarBibliotecario(Bibliotecario bibliotecario) {
        String mensaje = "El bibliotecario no existe";
        boolean existe = BuscarBibliotecario(bibliotecario);
        if (existe) {
            listapersonas.remove(bibliotecario);
            mensaje = "El bibliotecario ha sido eliminado correctamente";
        }
        return mensaje;
    }

    /**
     * Actualiza la información de un bibliotecario si este existe
     * 
     * @param bibliotecario
     * @param nombre
     * @param cedula
     * @param telefono
     * @param correo
     * @param salario
     * @return un mensaje diciendo si no existe o si se actualizó la información
     */
    public String ActualizarBibliotecario(Bibliotecario bibliotecario, String nombre, String cedula, String telefono,
            String correo, float salario) {
        String mensaje = "El bibliotecario no existe";
        boolean existe = BuscarBibliotecario(bibliotecario);
        if (existe) {
            int index = listapersonas.indexOf(bibliotecario);
            Persona personaaux = listapersonas.get(index);
            Bibliotecario bibliotecarioaux = (Bibliotecario) personaaux;
            bibliotecarioaux.setCedula(cedula);
            bibliotecarioaux.setCorreo(correo);
            bibliotecarioaux.setNombre(nombre);
            bibliotecarioaux.setSalario(salario);
            bibliotecarioaux.setTelefono(telefono);
            mensaje = "La información del bibliotecario ha sido actualizada";
        }
        return mensaje;
    }

    /**
     * Agrega un libro a la lista si no está agregado
     * 
     * @param libro
     * @return un mensaje diciendo si ya existía o si se agregó
     */
    public String AgregarLibro(Libro libro) {
        String mensaje = "El libro ya existe";
        if (libro != null) {
            boolean existe = BuscarLibro(libro);
            if (!existe) {
                listalibros.add(libro);
                mensaje = "El libro ha sido agregado correctamente";
            }
        }else{
            mensaje = "El libro no puede ser null";
        }
       
        return mensaje;
    }

    /**
     * Busca si un libro está en la lista
     * 
     * @param libro
     * @return true si está, false en caso contrario
     */
    public boolean BuscarLibro(Libro libro) {
        return listalibros.contains(libro);
    }

    /**
     * Elimina un libro siempre y cuando este exista
     * 
     * @param libro
     * @return un mensaje diciendo si no existe o si se eliminó
     */
    public String EliminarLibro(Libro libro) {
        String mensaje = "El libro no existe";
        boolean existe = BuscarLibro(libro);
        if (existe) {
            listalibros.remove(libro);
            mensaje = "El libro ha sido eliminado correctamente";
        }
        return mensaje;
    }

    /**
     * Actualiza la información de un libro si este existe
     * 
     * @param libro
     * @param codigo
     * @param isbn
     * @param autor
     * @param titulo
     * @param editorial
     * @param fechapublicacion
     * @param unidadesdisp
     * @return un mensaje diciendo si no existe o si se actualizó la información
     */
    public String ActualizarLibro(Libro libro, String codigo, String isbn, String autor, String titulo,
            String editorial, Date fechapublicacion, int unidadesdisp) {
        String mensaje = "El libro no existe";
        boolean existe = BuscarLibro(libro);
        if (existe) {
            int index = listalibros.indexOf(libro);
            Libro libroAux = listalibros.get(index);
            libroAux.setCodigo(codigo);
            libroAux.setTitulo(titulo);
            libroAux.setAutor(autor);
            libroAux.setIsbn(isbn);
            libroAux.setEditorial(editorial);
            libroAux.setFechapublicacion(fechapublicacion);
            libroAux.setUnidadesdisp(unidadesdisp);
            mensaje = "La información del libro ha sido actualizada";
        }
        return mensaje;
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

    /**
     * Busca un libro y retorna su información a partir de un codigo
     * 
     * @param codigo
     * @return null si no hay ningún libro con ese código o la información del libro
     *         si si existe.
     */
    public Libro BuscarLibroCodigo(String codigo) {
        Libro libroencontrado = null;
        for (Libro libroaux : listalibros) {
            if (libroaux.getCodigo().equals(codigo)) {
                libroencontrado = libroaux;
            }
        }
        return libroencontrado;
    }

    /**
     * Busca un libro a partir de un titulo y cuenta la cantidad de prestamos en los
     * que se encuentra
     * 
     * @param titulo
     * @return la cantidad de prestamos en los que se encuentra
     */
    public int CantidadPrestamosLibro(String titulo) {
        int cantidadprestamos = 0;
        for (Libro libro : listalibros) {
            if (libro.getTitulo().equals(titulo)) {
                cantidadprestamos = libro.contarcantidadprestamos();
            }
        }
        return cantidadprestamos;
    }

    /**
     * Reemplaza la información de un libro viejo por uno nuevo
     * 
     * @param libronuevo
     * @param libroviejo
     * @return un mensaje indicando si el libro viejo no existe o si se
     *         sobreescribió el libro correctamente
     */
    public String Reemplazarlibro(Libro libronuevo, Libro libroviejo) {
        String mensaje = "El libro no existe";
        boolean existe = BuscarLibro(libroviejo);
        if (existe) {
            int index = listalibros.indexOf(libroviejo);
            Libro libroAux = listalibros.get(index);
            libroAux.setCodigo(libronuevo.getCodigo());
            libroAux.setTitulo(libronuevo.getTitulo());
            libroAux.setAutor(libronuevo.getAutor());
            libroAux.setIsbn(libronuevo.getIsbn());
            libroAux.setEditorial(libronuevo.getEditorial());
            libroAux.setFechapublicacion(libronuevo.getFechapublicacion());
            libroAux.setUnidadesdisp(libronuevo.getUnidadesdisp());
            mensaje = "La información del libro ha sido actualizada";
        }
        return mensaje;
    }

    /**
     * Mediante un codigo y la fecha de entrega realiza la entrega de un prestamo
     * 
     * @param codigo
     * @param fechaentrega
     * @return costro total del prestamo
     */
    public float Entregarprestamo(String codigo, Date fechaentrega) {
        float costo = -1;
        boolean existe = BuscarPrestamo(codigo);
        if (existe) {
            Prestamo prestamo = listaprestamos.get(codigo);
            costo = prestamo.calcularcostoprestamo(fechaentrega);
        }
        return costo;
    }

    /**
     * Realiza una cadena con el nombre del bibliotecario y su cantidad de prestamos
     * realizados
     * 
     * @return cadena con todos los nombres de los bibliotecarios y su respectiva
     *         cantidad de prestamos realizados.
     */
    public String CantidadPrestamosEmpleado() {
        String EmpleadoCantidad = "";
        for (Persona persona : listapersonas) {
            if (persona instanceof Bibliotecario) {
                Bibliotecario bibliotecario = (Bibliotecario) persona;
                int cantidad = bibliotecario.contarcantidadprestamos();
                EmpleadoCantidad += bibliotecario.getNombre() + " " + String.valueOf(cantidad) + "\n";
            }
        }
        return EmpleadoCantidad;
    }

    /**
     * Busca entre todos los estudiantes quien es el que tiene mas prestamos
     * 
     * @return el estudiante con mas prestamos realizados
     */
    public Estudiante EstudianteMasPrestamos() {
        Estudiante estudianteaux = null;
        int contador = 0;
        for (Persona persona : listapersonas) {
            if (persona instanceof Estudiante) {
                Estudiante estudiante = (Estudiante) persona;
                int cantidadprestamos = estudiante.contarcantidadprestamos();
                if (cantidadprestamos > contador) {
                    contador = cantidadprestamos;
                    estudianteaux = estudiante;
                }
            }
        }
        return estudianteaux;
    }

    /**
     * Suma el costo total de todos los prestamos para calcular el dinero total
     * recaudado
     * 
     * @return la sumatoria de todos los prestamos
     */
    public float TotalDineroRecaudado() {
        float dinerototalrecaudado = 0;
        for (String codigo : listaprestamos.keySet()) {
            Prestamo prestamo = listaprestamos.get(codigo);
            dinerototalrecaudado += prestamo.getCostototal();
        }
        return dinerototalrecaudado;
    }

    /**
     * Suma el sueldo de cada bibliotecario
     * 
     * @return sumatoria de todos los sueldos
     */
    public float TotalDineroPagarBibliotecarios() {
        float dineropagar = 0;
        for (Persona persona : listapersonas) {
            if (persona instanceof Bibliotecario) {
                Bibliotecario bibliotecario = (Bibliotecario) persona;
                dineropagar += bibliotecario.calcularsueldo();
            }
        }
        return dineropagar;
    }
}
