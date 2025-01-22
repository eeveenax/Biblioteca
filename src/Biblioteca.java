import java.util.Scanner;

/**
 * @author Evelia Gil Paredes
 * @author María Ceballos Mesñias
 */

public class Biblioteca {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int contadorAdmins = 0;
        boolean loggedAdmin = false;
        boolean loggeado = false;
        boolean encontrado = false;

        // Elementos
        GestorUser g1 = new GestorUser();
        GestorPrestamos gp1 = new GestorPrestamos();
        GestorLibros gl1 = new GestorLibros();

        // lista de administradores
        Administrador[] listaAdmins = new Administrador[500];
        listaAdmins[0] = new Administrador("Eve", "Gil", "Paredes", "400");
        contadorAdmins++;
        listaAdmins[1] = new Administrador("María", "Mesias", "Ceballos", "500");
        contadorAdmins++;

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

        for (int i = 0; i < contadorAdmins && !encontrado; i++) {

            if (n.equals(listaAdmins[i].getNombre()) && ape1.equals(listaAdmins[i].getApellido())
                    && ape2.equals(listaAdmins[i].getApellido2()) && c.equals(listaAdmins[i].getContrasena())) {

                System.out.println("¡Te has loggeado con éxito!");
                nombre = listaAdmins[i].getNombre();
                loggeado = true;
                encontrado = true;
                loggedAdmin = true;

            }

        }

        Usuario[] listaUsuario = g1.getlistaUser();

        for (int i = 0; i < GestorUser.cuentaUsuario()
                && !encontrado; i++) {

            if (n.equals(listaUsuario[i].getNombre()) && ape1.equals(listaUsuario[i].getApellido())
                    && ape2.equals(listaUsuario[i].getApellido2()) && c.equals(listaUsuario[i].getContrasena())) {

                System.out.println("¡Te has loggeado con éxito!");
                nombre = listaUsuario[i].getNombre();

                loggeado = true;
                encontrado = true;

            }

        }

        if (loggedAdmin && loggeado && encontrado) {

            boolean seguirA = true;

            while (seguirA) {
                System.out.println("Bienvenid@ " + nombre + " elija una opción: ");
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

                        gl1.agregarLibro(t, a, cat);

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

                        g1.registroUser(nom, a1, a2, ac);

                        break;

                    case 4:

                        g1.consultaDatosUsuario();

                        break;

                    case 5:

                        System.out.println("Elige si quieres buscar por: 1.Titulo, 2.Autor, 3.Categoría");
                        int o = Integer.parseInt(sc.nextLine());

                        switch (o) {
                            case 1:

                                System.out.println("Introduce el tíutlo");
                                String titutloB = sc.nextLine().toLowerCase();

                                gl1.buscartituloLibro(titutloB);

                                break;

                            case 2:

                                System.out.println("Introduce el autor");
                                String autoB = sc.nextLine().toLowerCase();

                                gl1.buscarPorAutor(autoB);

                                break;

                            case 3:
                                System.out.println("Introduce la categoría");
                                String catB = sc.nextLine().toLowerCase();

                                gl1.buscarPorCategoria(catB);
                                break;

                            default:

                                System.out.println("No hay más opciones");
                                break;
                        }

                        break;

                    case 6:

                        gl1.librosTotales();

                        break;

                    case 7:

                        Libro[] listalibro = gl1.getListaLibros();

                        System.out.println("Introduzca el libro que quieres prestar");

                        System.out.println("Título: ");

                        String titulop = sc.nextLine();

                        System.out.println("Autor: ");

                        String autorp = sc.nextLine();

                        System.out.println("Categoría: ");

                        String catp = sc.nextLine();

                        gp1.prestarL(listalibro, titulop, autorp, catp);

                        break;

                    case 8:

                        System.out.println("Introduzca el libro a devolver");
                        System.out.println("Título: ");

                        String titulod = sc.nextLine();

                        System.out.println("Autor: ");

                        String autord = sc.nextLine();

                        System.out.println("Categoría: ");

                        String catd = sc.nextLine();

                        gp1.devolverL(titulod, autord, catd);

                        break;

                    case 9:

                        gp1.librosPrestados();

                        break;
                    default:

                        seguirA = false;
                        break;
                }

            }
        } else if (loggeado && encontrado) {

            boolean seguirU = true;
            while (seguirU) {

                System.out.println("Bienvenid@ " + nombre + " elija una opción: ");
                System.out.println("1.Buscar libros por titulo, autor o categoría");
                System.out.println("2.Mostrar todos los libros disponibles");
                System.out.println("3.Realizar Préstamos");
                System.out.println("4.Devolver Préstamos");

                int opAdmni = Integer.parseInt(sc.nextLine());

                switch (opAdmni) {
                    case 1:

                        break;
                    case 2:

                        gl1.librosTotales();

                        break;

                    case 3:

                        Libro[] listalibro = gl1.getListaLibros();

                        System.out.println("Introduzca el libro que quieres prestar");

                        System.out.println("Título: ");

                        String titulop = sc.nextLine();

                        System.out.println("Autor: ");

                        String autorp = sc.nextLine();

                        System.out.println("Categoría: ");

                        String catp = sc.nextLine();

                        gp1.prestarL(listalibro, titulop, autorp, catp);
                        // gp1.prestarL(titulop, autorp, catp);
                        // Lista de libros completa
                        Usuario persona = new Usuario(n, ape1, ape2, c);
                        Libro libroprestado = new Libro(titulop, autorp, catp);
                        persona.aumentoCUP();
                        libroprestado.aumentoContadorLP();

                        // libroprestado.aumentoCLP();
                        System.out.println("Préstamo realizado con éxito. Préstamos realizados por: "
                                + persona.getNombre() + ". Este usuario ha realzia un total de: "
                                + persona.getContadorUP() + " préstamos." + " El libro que ha sido prestado es el: "
                                + libroprestado.getTitulo());

                        break;

                    case 4:

                        System.out.println("Introduzca el libro a devolver");
                        System.out.println("Título: ");

                        String titulod = sc.nextLine();

                        System.out.println("Autor: ");

                        String autord = sc.nextLine();

                        System.out.println("Categoría: ");

                        String catd = sc.nextLine();

                        gp1.devolverL(titulod, autord, catd);

                        break;

                    default:

                        seguirU = false;
                        break;
                }

            }

        } else {

            System.out.println("No existes (-_-) ");

        }

        int prestamosTotales = gp1.getPrestamostotales();
        System.out.println("Los préstamos totales y activos son de: " + prestamosTotales);

        sc.close();
    }
}
