public class Usuario {

    private String nombre;
    private String apellido;
    private String apellido2;
    private String contrasena;
    private Tipo tipo;
    private int contLibrosPrestamoActivos = 0;
    private int contPrestamosUsuario = 0;

    private Libro[] listaLibrosUsuariosTienePrestado;
    private final int tam = 10;

    public Usuario(String nombre, String apellido, String apellido2, String contrasena, Tipo tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.apellido2 = apellido2;
        this.tipo = tipo;
        this.contLibrosPrestamoActivos = 0;
        this.contPrestamosUsuario = 0;
        this.listaLibrosUsuariosTienePrestado = new Libro[tam];

    }

    public Libro[] getlistaLibrosUsuariosPrestado() {

        return this.listaLibrosUsuariosTienePrestado;

    }

    public void verListaLibrosPrestados() {

        if (contLibrosPrestamoActivos == 0) {

            System.out.println("No tienes libros (0.0)");

        } else {

            System.out.println("Tus libros prestados son: ");

            for (int i = 0; i < contLibrosPrestamoActivos; i++) {

                System.out.println(listaLibrosUsuariosTienePrestado[i].toString());
            }

        }

    }

    public Usuario() {
        this.nombre = " ";
        this.apellido = " ";
        this.contrasena = " ";
        this.apellido2 = " ";
        this.tipo = Tipo.usuario;
        this.contLibrosPrestamoActivos = getContLibrosPrestamoActivos();
        this.listaLibrosUsuariosTienePrestado = new Libro[tam];

    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido2() {
        return this.apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setContLibrosPrestamoActivos(int contLibrosPrestamoActivos) {

        this.contLibrosPrestamoActivos = contLibrosPrestamoActivos;
    }

    public int getContLibrosPrestamoActivos() {
        return this.contLibrosPrestamoActivos;

    }

    public void setContPrestamosUsuario(int contadorLP) {

        this.contPrestamosUsuario = contadorLP;
    }

    public int getContLibrosPrestamoUsuarios() {
        return this.contPrestamosUsuario;

    }

    public void aumentaLibrosUsuarioPrestados(Libro libro) {

        if (this.contLibrosPrestamoActivos < this.listaLibrosUsuariosTienePrestado.length) {

            listaLibrosUsuariosTienePrestado[contLibrosPrestamoActivos] = libro;
            contLibrosPrestamoActivos++;
            contPrestamosUsuario++;

        }

    }

    public void restaLibrosUsuarioPrestados(Libro libro) {

        if (this.contLibrosPrestamoActivos > 0 && listaLibrosUsuariosTienePrestado != null) {

            boolean libroEncontrado = false;
            int pos = 0;

            for (int i = 0; i < contLibrosPrestamoActivos && !libroEncontrado; i++) {

                if (listaLibrosUsuariosTienePrestado[contLibrosPrestamoActivos] == libro) {

                    listaLibrosUsuariosTienePrestado[contLibrosPrestamoActivos] = null;
                    pos = i;

                    libroEncontrado = true;

                }

            }

            if (libroEncontrado) {

                for (int i = pos; i < contLibrosPrestamoActivos - 1; i++) {

                    listaLibrosUsuariosTienePrestado[i] = listaLibrosUsuariosTienePrestado[i + 1];

                }

                contLibrosPrestamoActivos--;

            }

        }

    }

    public Tipo getTipo() {

        return tipo;

    }

    @Override
    public String toString() {

        return "Nombre: " + this.nombre + ". Apellido 1: " + this.apellido + ". Apellido 2: " + this.apellido2
                + ". Contraseña: " + this.contrasena;
    }
}
