import java.util.Arrays;

public class GestorLibros {

    private Libro[] libros;
    private static int lleno;
    private static final int TAM = 100;

    public GestorLibros() {
        libros = new Libro[TAM];
        lleno = 0;
    }

    public void agregarLibro(String t, String a, String c) {

        if (this.libros[0] == null) {

            this.libros[0] = new Libro(t, a, c);
            lleno++;

        } else {

            boolean existe = false;

            for (int i = 0; i < lleno; i++) {

                if (this.libros[i].getTitulo().equals(t) && this.libros[i].getAutor().equals(a)
                        && this.libros[i].getCategoria().equals(c)) {

                    existe = true;
                }

            }

            if (!existe) {

                this.libros[lleno] = new Libro(t, a, c);
                lleno++;
                System.out.println("Libro agregado exitosamente");

            } else {

                System.out.println("Ya existe");
            }
        }

    }

    public static void setLleno() {
        lleno++;

    }

    public Libro[] getListaLibros() {

        return this.libros;

    }

    public Libro[] buscartituloLibro(String titulo) {
        Libro[] titulos = new Libro[TAM];
        int titulolleno = 0;
        for (int i = 0; i < libros.length; i++) {

            if (libros[i].getTitulo().equals(titulo)) {

                titulos[titulolleno] = libros[i];
                titulolleno++;

            }
        }

        return Arrays.copyOf(titulos, titulolleno);
    }

    public Libro[] buscarPorAutor(String autor) {
        Libro[] resultado = new Libro[TAM];
        int autorLleno = 0;
        for (int i = 0; i < libros.length; i++) {
            if (libros[i].getAutor().equals(autor)) {
                resultado[autorLleno] = libros[i];
                autorLleno++;
            }
        }
        return Arrays.copyOf(resultado, autorLleno);
    }

    public Libro[] buscarPorCategoria(String categorialibro) {
        Libro[] resultado = new Libro[TAM];
        int categoriaLleno = 0;
        for (int i = 0; i < libros.length; i++) {
            if (libros[i].getCategoria().equals(categorialibro)) {
                resultado[categoriaLleno] = libros[i];
                categoriaLleno++;
            }
        }
        return Arrays.copyOf(resultado, categoriaLleno);
    }

    // Elimina los libros

    public void librosTotales() {

        boolean seguir = true;

        for (int i = 0; i < libros.length && seguir; i++) {

            if (libros[i] != null) {

                String info = libros[i].toString();
                System.out.println(info);

            } else {
                seguir = false;
            }

        }

    }

}
