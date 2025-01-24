import java.util.Scanner;

/**
 * @author Evelia Gil Paredes
 * @author María Ceballos Mesñias
 */

public class Biblioteca {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Elementos
        GestorUsuario gestorUsuario1 = new GestorUsuario();
        GestorPrestamos gestorPrestamo1 = new GestorPrestamos();
        GestorLibros gestorLibro1 = new GestorLibros();

        // Usuarios
        gestorUsuario1.registroUser("eve", "gil", "paredes", "123eve", Tipo.administrador);
        gestorUsuario1.registroUser("juajesu", "espinosa", "martinez", "123juajesu", Tipo.administrador);
        gestorUsuario1.registroUser("maria", "ceballos", "mesías", "123maria", Tipo.administrador);
        gestorUsuario1.registroUser("maria", "ceballos", "mesías", "123maria", Tipo.administrador);
        gestorUsuario1.registroUser("uxue", "lopez", "pino", "123uxue123", Tipo.usuario);
        gestorUsuario1.registroUser("pablo", "mala", "leche", "123pablo", Tipo.usuario);
        gestorUsuario1.registroUser("eve", "lopez", "gil", "eve345", Tipo.usuario);
        gestorUsuario1.registroUser("marina", "lopez", "paredes", "marina345", Tipo.usuario);
        gestorUsuario1.registroUser("leon", "lopez", "ceballos", "123leon", Tipo.usuario);
        gestorUsuario1.registroUser("marco", "lopez", "mesias", "123marco", Tipo.usuario);
        gestorUsuario1.registroUser("aitor", "lopez", "mora", "aitor123", Tipo.usuario);
        gestorUsuario1.registroUser("juan", "lopez", "tejeda", "juan456", Tipo.usuario);
        gestorUsuario1.registroUser("jesús", "lopez", "martinez", "123jesus123", Tipo.usuario);
        gestorUsuario1.registroUser("joghe", "alegre", "triste", "joghe123", Tipo.usuario);
        gestorUsuario1.registroUser("gaia", "lopez", "ceballos", "gaia123", Tipo.usuario);
        gestorUsuario1.registroUser("pablo", "lopez", "gonzalez", "pablo123", Tipo.usuario);
        gestorUsuario1.registroUser("jose", "lopez", "cerrato", "jose123", Tipo.usuario);
        gestorUsuario1.registroUser("victoria", "lopez", "guisado", "victoria123", Tipo.usuario);
        gestorUsuario1.registroUser("lucia", "lopez", "guerrero", "lucia890", Tipo.usuario);
        gestorUsuario1.registroUser("andrea", "guerreri", "guisado", "123andrea", Tipo.usuario);
        gestorUsuario1.registroUser("ángel", "guisado", "lopez", "123angel", Tipo.usuario);
        gestorUsuario1.registroUser("luis", "reseco", "paredes", "luis890", Tipo.usuario);
        gestorUsuario1.registroUser("ana", "lopez", "pino", "ana890", Tipo.usuario);
        gestorUsuario1.registroUser("azahara", "lopez", "pineda", "azahara123", Tipo.usuario);

        // Libros

        gestorLibro1.agregarLibro("el nombre del viento", "patrick", "fantasia");
        gestorLibro1.agregarLibro("cien años de soledad", "garcia marquez", "historia");
        gestorLibro1.agregarLibro("harry potter", "jk rowling", "fantasia");
        gestorLibro1.agregarLibro("harry potter 2", "jk rowling", "fantasia");
        gestorLibro1.agregarLibro("harry potter 3", "jk rowling", "fantasia");
        gestorLibro1.agregarLibro("harry potter 4", "jk rowling", "fantasia");
        gestorLibro1.agregarLibro("harry potter 5", "jk rowling", "fantasia");
        gestorLibro1.agregarLibro("el resplandor", "stephen king", "miedo");
        gestorLibro1.agregarLibro("el diario de ana frank", "ana frank", "biografia");
        gestorLibro1.agregarLibro("el misterio de la mansión", "agatha christie", "misterio");
        gestorLibro1.agregarLibro("el código da vinci", "dan brown", "misterio");
        gestorLibro1.agregarLibro("steve jobs", "walter isaacson", "biografía");
        gestorLibro1.agregarLibro("orgullo y prejuicio", "jane austen", "romance");
        gestorLibro1.agregarLibro("bajo la misma estrella", "john green", "romance");
        gestorLibro1.agregarLibro("posdata: te amo", "cecelia ahern", "romance");

        // Biblioteca

        boolean seguirLog = true;
        while (seguirLog) {

            boolean loggedAdmin = false;
            boolean loggeado = false;
            boolean encontrado = false;
            System.out.println("Bienvenid@ a la Biblioteca: ");
            System.out.println("1.Iniciar Sesión");
            System.out.println("2.Salir de la Biblioteca");

            int opcionB = Integer.parseInt(sc.nextLine());

            switch (opcionB) {
                case 1:

                    System.out.println(
                            "Introduzca su usuario: Nombre, Apellido1, Apellido2 y Contraseña .`_´.");

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
                                && ape2.equals(listaUsuario[i].getApellido2())
                                && c.equals(listaUsuario[i].getContrasena())) {

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
                        System.out.println("Bienvenid@ " + nombre + " Sus préstamos actuales ascienden a: "
                                + usuario.getContLibrosPrestamoActivos());

                        if (usuario.getContLibrosPrestamoActivos() > 0) {

                            System.out.println("¿Quieres verlos? si o no");
                            String respuesta = sc.nextLine().toLowerCase();
                            if (respuesta.equals("no")) {
                                System.out.println("De acuerdo, ¯/_(0-0)_/¯");
                            } else {

                                usuario.verListaLibrosPrestados();

                            }

                        }
                        while (seguirA) {

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
                            System.out.println("9.Libros prestados totales de la biblioteca");
                            System.out.println("10.Consulta tu lista de Libros en préstamo");
                            System.out.println("11.Consular Préstamos Totales");
                            System.out.println("12.Consular Préstamos Activos");
                            System.out.println("13.Top 10 libros más prestados");
                            System.out.println("14.Top Usuarios con más Préstamos");
                            System.out.println("15.Cerrar Sesión");

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
                                    System.out.println(" ");

                                    break;
                                case 2:

                                    System.out.println("Escribe los datos del libro a eliminar: ");

                                    System.out.println("Título: ");
                                    String tEliminar = sc.nextLine().toLowerCase();
                                    System.out.println("Autor: ");
                                    String aEliminar = sc.nextLine().toLowerCase();
                                    System.out.println("Categoría: ");
                                    String cateeliminar = sc.nextLine().toLowerCase();

                                    Libro libro = null;
                                    Libro[] listaLibro = gestorLibro1.getListaLibros();

                                    for (Libro libroE : listaLibro) {

                                        if (libroE.getTitulo().equals(tEliminar) && libroE.getAutor().equals(aEliminar)
                                                && libroE.getCategoria().equals(cateeliminar)) {

                                            libro = libroE;

                                        }

                                    }

                                    gestorLibro1.eliminaLibro(libro);

                                    System.out.println(" ");

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
                                    System.out.println(" ");

                                    break;

                                case 4:

                                    gestorUsuario1.consultaDatosUsuario();
                                    System.out.println(" ");

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
                                    System.out.println(" ");

                                    break;

                                case 6:

                                    gestorLibro1.librosTotales();
                                    System.out.println(" ");

                                    break;

                                case 7:

                                    Libro[] listaLibros = gestorLibro1.getListaLibros();
                                    int contadorLibro = gestorLibro1.getContadorLibros();

                                    System.out.println("Introduzca el libro que quieres coger prestado");
                                    System.out.println("Título");
                                    String titulo = sc.nextLine().toLowerCase();
                                    System.out.println("Autor");
                                    String autor = sc.nextLine().toLowerCase();
                                    System.out.println("Categoría");
                                    String categ = sc.nextLine().toLowerCase();

                                    gestorPrestamo1.prestarL(listaLibros, titulo, autor, categ, usuario, contadorLibro);
                                    System.out.println(" ");

                                    break;

                                case 8:

                                    System.out.println("Introduzca el libro que vayas a devolver");
                                    System.out.println("Título: ");
                                    String titulod = sc.nextLine();

                                    System.out.println("Autor: ");
                                    String autord = sc.nextLine();

                                    System.out.println("Categoría: ");
                                    String catd = sc.nextLine();

                                    gestorPrestamo1.devolverL(titulod, autord, catd, usuario);
                                    System.out.println(" ");

                                    break;

                                case 9:

                                    gestorPrestamo1.librosPrestados();
                                    System.out.println(" ");

                                    break;

                                case 10:

                                    if (usuario.getContLibrosPrestamoActivos() > 0) {
                                        System.out.println("Tu lista de libros Prestados son: ");

                                        usuario.verListaLibrosPrestados();
                                    }

                                    break;

                                case 11:

                                    System.out.println(" ");

                                    int prestamosTotales = gestorPrestamo1.getPrestamosTotales();
                                    System.out.println(
                                            "Los préstamos totales de la bibliteca son de: " + prestamosTotales);

                                    break;

                                case 12:

                                    int prestamosActivos = gestorPrestamo1.getPrestamosActivos();
                                    System.out.println(
                                            "Los préstamos activos de la biblioteca son de: " + prestamosActivos);

                                    break;

                                case 13:

                                    Libro[] listaMP = gestorLibro1.librosMasPrestados();

                                    System.out.println(" ");

                                    System.out.println("El top 10 de los libros más prestados son: ");

                                    for (Libro l : listaMP) {

                                        System.out.println(l);

                                    }

                                    break;

                                case 14:

                                    Usuario[] listaUsuariosMasPrest = gestorUsuario1.usuariosPorPrestamos();

                                    System.out.println(" ");

                                    System.out.println("El top 10 de los usuarios con más préstamos totales son: ");

                                    for (Usuario u : listaUsuariosMasPrest) {

                                        System.out.println(u);

                                    }
                                    System.out.println(" ");

                                    break;

                                case 15:
                                    seguirA = false;

                                    break;

                                default:

                                    break;
                            }

                        }
                    } else if (loggeado && encontrado) {

                        boolean seguirU = true;
                        System.out.println("Bienvenid@ " + nombre + " Sus préstamos actuales ascienden a: "
                                + usuario.getContLibrosPrestamoActivos());

                        if (usuario.getContLibrosPrestamoActivos() > 0) {

                            System.out.println("¿Quieres verlos? si o no");
                            String respuesta = sc.nextLine().toLowerCase();
                            if (respuesta.equals("no")) {
                                System.out.println("De acuerdo, ¯/_(0-0)_/¯");
                            } else {

                                usuario.verListaLibrosPrestados();

                            }

                        }
                        while (seguirU) {

                            System.out.println(" ");
                            System.out.println("Elija una opción: ");
                            System.out.println("1.Buscar libros por titulo, autor o categoría");
                            System.out.println("2.Mostrar todos los libros disponibles");
                            System.out.println("3.Realizar Préstamos");
                            System.out.println("4.Devolver Préstamos");
                            System.out.println("5.Consultar Lista Libros en Préstamo");
                            System.out.println("6.Top libros más prestados");
                            System.out.println("7.Cerrar sesión");

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
                                            System.out.println(" ");

                                            break;

                                        case 2:

                                            System.out.println("Introduce el autor");
                                            String autoB = sc.nextLine().toLowerCase();

                                            gestorLibro1.buscarPorAutor(autoB);
                                            System.out.println(" ");

                                            break;

                                        case 3:
                                            System.out.println("Introduce la categoría");
                                            String catB = sc.nextLine().toLowerCase();

                                            gestorLibro1.buscarPorCategoria(catB);
                                            System.out.println(" ");

                                            break;

                                        default:

                                            System.out.println("No hay más opciones");
                                            break;
                                    }

                                    break;

                                case 2:

                                    gestorLibro1.librosTotales();
                                    System.out.println(" ");

                                    break;

                                case 3:

                                    Libro[] listaLibros = gestorLibro1.getListaLibros();
                                    int contadorLibro = gestorLibro1.getContadorLibros();

                                    System.out.println("Introduzca el libro que quieres coger prestado");
                                    System.out.println("Título");
                                    String titulo = sc.nextLine().toLowerCase();
                                    System.out.println("Autor");
                                    String autor = sc.nextLine().toLowerCase();
                                    System.out.println("Categoría");
                                    String categ = sc.nextLine().toLowerCase();

                                    gestorPrestamo1.prestarL(listaLibros, titulo, autor, categ, usuario, contadorLibro);
                                    System.out.println(" ");
                                    System.out.println(" ");

                                    break;

                                case 4:

                                    System.out.println("Introduzca el libro a devolver");
                                    System.out.println("Título: ");
                                    String titulod = sc.nextLine();

                                    System.out.println("Autor: ");
                                    String autord = sc.nextLine();

                                    System.out.println("Categoría: ");
                                    String catd = sc.nextLine();

                                    gestorPrestamo1.devolverL(titulod, autord, catd, usuario);
                                    System.out.println(" ");

                                    break;

                                case 5:

                                    if (usuario.getContLibrosPrestamoActivos() > 0) {
                                        System.out.println("Tu lista de libros Prestados son: ");

                                        usuario.verListaLibrosPrestados();

                                    } else {

                                        System.out.println("No tienes libros en préstamo");
                                    }

                                    break;

                                case 6:

                                    Libro[] listaMP = gestorLibro1.librosMasPrestados();

                                    System.out.println(" ");

                                    System.out.println("El top 10 de los libros más prestados son: ");

                                    for (Libro l : listaMP) {

                                        System.out.println(l);

                                    }
                                    break;

                                case 7:
                                    seguirU = false;

                                    break;

                                default:

                                    break;
                            }

                        }

                    } else {

                        System.out.println("No existes (-_-) ");

                    }

                    break;

                case 2:

                    System.out.println("ADIÓS (-.-)");

                    seguirLog = false;

                    break;

                default:
                    break;
            }

        }

        sc.close();
    }
}
