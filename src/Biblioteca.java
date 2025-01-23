import java.util.Scanner;

/**
 * @author Evelia Gil Paredes
 * @author María Ceballos Mesñias
 */

public class Biblioteca {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean loggedAdmin = false;
        boolean loggeado = false;
        boolean encontrado = false;

        // Elementos
        GestorUsuario gestorUsuario1 = new GestorUsuario();
        GestorPrestamos gestorPrestamo1 = new GestorPrestamos();
        GestorLibros gestorLibro1 = new GestorLibros();

        // Usuarios
        gestorUsuario1.registroUser("eve", "gil", "paredes", "123eve", Tipo.administrador);
        gestorUsuario1.registroUser("maria", "ceballos", "mesías", "123maria", Tipo.administrador);
        gestorUsuario1.registroUser("maria", "ceballos", "mesías", "123maria", Tipo.administrador);
        gestorUsuario1.registroUser("laura", "lopez", "pino", "123laura123", Tipo.usuario);
        gestorUsuario1.registroUser("ana", "carmona", "carmona", "123ana", Tipo.usuario);

        // Libros

        gestorLibro1.agregarLibro("el nombre del viento", "patrick", "fantasia");
        gestorLibro1.agregarLibro("cien años de soledad", "garcia marquez", "historia");
        gestorLibro1.agregarLibro("harry potter", "jk rowling", "fantasia");
        gestorLibro1.agregarLibro("harry potter 2", "jk rowling", "fantasia");
        gestorLibro1.agregarLibro("el resplandor", "stephen king", "miedo");

        // Biblioteca
        System.out.println(
                "Bienvenid@ a la Biblioteca, introduzca su usuario: Nombre, Apellido1, Apellido2 y Contraseña .`_´.");

        System.out.println("Nombre: ");
        String n = sc.nextLine().toLowerCase();
        System.out.println("Apellido 1: ");
        String ape1 = sc.nextLine().toLowerCase();
        System.out.println("Apellido 2: ");
        String ape2 = sc.nextLine().toLowerCase();
        System.out.println("Contraseña: ");
        String c = sc.nextLine().toLowerCase();

        String nombre = " ";
        Usuario usuario = null;

        Usuario[] listaUsuario = gestorUsuario1.getlistaUser();

        int longitudListaUsuario = listaUsuario.length;

        for (int i = 0; i < longitudListaUsuario && !encontrado; i++) {

            if (n.equals(listaUsuario[i].getNombre()) && ape1.equals(listaUsuario[i].getApellido())
                    && ape2.equals(listaUsuario[i].getApellido2()) && c.equals(listaUsuario[i].getContrasena())) {

                System.out.println("¡Te has loggeado con éxito!");
                loggeado = true;
                nombre = listaUsuario[i].getNombre();
                usuario = listaUsuario[i];

                if (listaUsuario[i].getTipo() == Tipo.administrador) {
                    loggedAdmin = true;

                }

                encontrado = true;

            }

        }

        if (loggedAdmin && loggeado && encontrado) {

            boolean seguirA = true;

            while (seguirA) {
                System.out.println("Bienvenid@ " + nombre + " Sus préstamos actuales ascienden a: "
                        + usuario.getContLibrosPrestamoActivos());

                if (usuario.getContLibrosPrestamoActivos() > 0) {

                    System.out.println("¿Quieres verlos? si o no");
                    String respuesta = sc.nextLine().toLowerCase();
                    if (respuesta.equals("no")) {
                        System.out.println("De acuerdo, ¯/_(0-0)_/¯");
                    } else {

                        usuario.getlistaLibrosUsuariosPrestado();

                    }

                }

                System.out.println(" ");
                System.out.println("Elija una opción: ");
                System.out.println("1.Agrega Libros");
                System.out.println("2.Elimina Libros");
                System.out.println("3.Registra Usuario");
                System.out.println("4.Consulta información de los usuarios");
                System.out.println("5.Buscar libros por titulo, autor o categoría");
                System.out.println("6.Mostrar todos los libros disponibles");
                System.out.println("7.Realizar Préstamos");
                System.out.println("8.Devolver Préstamos");
                System.out.println("9.Consular lista de Préstamos");

                int opAdmni = Integer.parseInt(sc.nextLine());

                switch (opAdmni) {
                    case 1:

                        System.out.println("Escribe los datos del libro a añadir: ");

                        System.out.println("Título: ");
                        String t = sc.nextLine().toLowerCase();
                        System.out.println("Autor: ");
                        String a = sc.nextLine().toLowerCase();
                        System.out.println("Categoría: ");
                        String cat = sc.nextLine().toLowerCase();

                        gestorLibro1.agregarLibro(t, a, cat);

                        break;
                    case 2:
                        // elimina libros
                        break;

                    case 3:

                        System.out.println("Escribe los datos de la persona: ");

                        System.out.println("Introduce los datos del uusario a registrar: ");
                        System.out.println("Nombre: ");
                        String nom = sc.nextLine().toLowerCase();
                        System.out.println("Apellido 1: ");
                        String a1 = sc.nextLine().toLowerCase();
                        System.out.println("Apellido 2: ");
                        String a2 = sc.nextLine().toLowerCase();
                        System.out.println("Contraseña: ");
                        String ac = sc.nextLine().toLowerCase();
                        System.out.println("Tipo: Adminstrador o Usuario");
                        String tipo = sc.nextLine().toLowerCase();
                        Tipo t2 = Tipo.administrador;

                        if (tipo.equals("administrador")) {
                            t2 = Tipo.administrador;
                        } else {

                            t2 = Tipo.usuario;
                        }

                        gestorUsuario1.registroUser(nom, a1, a2, ac, t2);

                        break;

                    case 4:

                        gestorUsuario1.consultaDatosUsuario();

                        break;

                    case 5:

                        System.out.println("Elige si quieres buscar por: 1.Titulo, 2.Autor, 3.Categoría");
                        int o = Integer.parseInt(sc.nextLine());

                        switch (o) {
                            case 1:

                                System.out.println("Introduce el tíutlo");
                                String titutloB = sc.nextLine().toLowerCase();

                                gestorLibro1.buscarTituloLibro(titutloB);

                                break;

                            case 2:

                                System.out.println("Introduce el autor");
                                String autoB = sc.nextLine().toLowerCase();

                                gestorLibro1.buscarPorAutor(autoB);

                                break;

                            case 3:
                                System.out.println("Introduce la categoría");
                                String catB = sc.nextLine().toLowerCase();

                                gestorLibro1.buscarPorCategoria(catB);
                                break;

                            default:

                                System.out.println("No hay más opciones");
                                break;
                        }

                        break;

                    case 6:

                        gestorLibro1.librosTotales();

                        break;

                    case 7:

                        Libro[] listaLibros = gestorLibro1.getListaLibros();

                        System.out.println("Introduzca el libro que quieres prestar");
                        System.out.println("Título");
                        String titulo = sc.nextLine().toLowerCase();
                        System.out.println("Autor");
                        String autor = sc.nextLine().toLowerCase();
                        System.out.println("Categoría");
                        String categ = sc.nextLine().toLowerCase();

                        Libro libroP = null;

                        for (Libro l : listaLibros) {

                            if (l.getTitulo().equals(titulo) && l.getAutor().equals(autor)
                                    && l.getCategoria().equals(categ)) {

                                libroP = l;
                            }

                        }

                        gestorPrestamo1.prestarL(listaLibros, libroP);

                        break;

                    case 8:

                        System.out.println("Introduzca el libro a devolver");
                        System.out.println("Título: ");
                        String titulod = sc.nextLine();

                        System.out.println("Autor: ");
                        String autord = sc.nextLine();

                        System.out.println("Categoría: ");
                        String catd = sc.nextLine();

                        Libro libroD = null;

                        Libro[] listaLibrosPrestados = gestorPrestamo1.getListaLibrosPrestados();

                        for (Libro l : listaLibrosPrestados) {

                            if (l.getTitulo().equals(titulod) && l.getAutor().equals(autord)
                                    && l.getCategoria().equals(catd)) {

                                libroD = l;

                            }

                        }

                        gestorPrestamo1.devolverL(libroD);

                        break;

                    case 9:

                        gestorPrestamo1.librosPrestados();

                        break;
                    default:

                        seguirA = false;
                        break;
                }

            }
        } else if (loggeado && encontrado) {

            boolean seguirU = true;
            while (seguirU) {

                System.out.println("Bienvenid@ " + nombre + " Sus préstamos actuales ascienden a: "
                        + usuario.getContLibrosPrestamoActivos());

                if (usuario.getContLibrosPrestamoActivos() > 0) {

                    System.out.println("¿Quieres verlos? si o no");
                    String respuesta = sc.nextLine().toLowerCase();
                    if (respuesta.equals("no")) {
                        System.out.println("De acuerdo, ¯/_(0-0)_/¯");
                    } else {

                        usuario.getlistaLibrosUsuariosPrestado();

                    }

                }

                System.out.println(" ");
                System.out.println("Elija una opción: ");
                System.out.println("1.Buscar libros por titulo, autor o categoría");
                System.out.println("2.Mostrar todos los libros disponibles");
                System.out.println("3.Realizar Préstamos");
                System.out.println("4.Devolver Préstamos");
                System.out.println(" ");

                int opAdmni = Integer.parseInt(sc.nextLine());

                switch (opAdmni) {
                    case 1:

                        System.out.println("Elige si quieres buscar por: 1.Titulo, 2.Autor, 3.Categoría");
                        int o = Integer.parseInt(sc.nextLine());

                        switch (o) {
                            case 1:

                                System.out.println("Introduce el tíutlo");
                                String titutloB = sc.nextLine().toLowerCase();

                                gestorLibro1.buscarTituloLibro(titutloB);

                                break;

                            case 2:

                                System.out.println("Introduce el autor");
                                String autoB = sc.nextLine().toLowerCase();

                                gestorLibro1.buscarPorAutor(autoB);

                                break;

                            case 3:
                                System.out.println("Introduce la categoría");
                                String catB = sc.nextLine().toLowerCase();

                                gestorLibro1.buscarPorCategoria(catB);
                                break;

                            default:

                                System.out.println("No hay más opciones");
                                break;
                        }

                        break;

                    case 2:

                        gestorLibro1.librosTotales();

                        break;

                    case 3:

                        Libro[] listaLibros = gestorLibro1.getListaLibros();

                        System.out.println("Introduzca el libro que quieres prestar");
                        System.out.println("Título");
                        String titulo = sc.nextLine().toLowerCase();
                        System.out.println("Autor");
                        String autor = sc.nextLine().toLowerCase();
                        System.out.println("Categoría");
                        String categ = sc.nextLine().toLowerCase();

                        Libro libroP = null;

                        for (Libro l : listaLibros) {

                            if (l.getTitulo().equals(titulo) && l.getAutor().equals(autor)
                                    && l.getCategoria().equals(categ)) {

                                libroP = l;
                            }

                        }

                        gestorPrestamo1.prestarL(listaLibros, libroP);

                        break;

                    case 4:

                        System.out.println("Introduzca el libro a devolver");
                        System.out.println("Título: ");
                        String titulod = sc.nextLine();

                        System.out.println("Autor: ");
                        String autord = sc.nextLine();

                        System.out.println("Categoría: ");
                        String catd = sc.nextLine();

                        Libro libroD = null;

                        Libro[] listaLibrosPrestados = gestorPrestamo1.getListaLibrosPrestados();

                        for (Libro l : listaLibrosPrestados) {

                            if (l.getTitulo().equals(titulod) && l.getAutor().equals(autord)
                                    && l.getCategoria().equals(catd)) {

                                libroD = l;

                            }

                        }

                        gestorPrestamo1.devolverL(libroD);

                        break;

                    default:

                        seguirU = false;
                        break;
                }

            }

        } else {

            System.out.println("No existes (-_-) ");

        }

        // Datos sobre los préstamos

        int prestamosTotales = gestorPrestamo1.getPrestamosTotales();
        System.out.println("Los préstamos totales de la bibliteca son de: " + prestamosTotales);

        int prestamosActivos = gestorPrestamo1.getPrestamosActivos();
        System.out.println("Los préstamos activos de la biblioteca son de: " + prestamosActivos);

        Libro[] listaMP = gestorLibro1.librosMasPrestados();

        System.out.println("El top 10 de los libros más prestados son: ");

        for (Libro l : listaMP) {

            System.out.println(l);

        }

        Usuario[] listaUsuariosMasPrest = gestorUsuario1.usuariosPorPrestamos();

        System.out.println("El top 10 de los usuarios con más préstamos totales: ");

        for (Usuario u : listaUsuariosMasPrest) {

            System.out.println(u);

        }

        sc.close();
    }
}
