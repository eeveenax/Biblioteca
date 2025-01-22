import java.util.Arrays;

public class GestorLibros {

    private Libro[] libros;
    private int lleno;
    private static final int TAM = 100;

    public GestorLibros() {
        libros = new Libro[TAM];
        lleno = 0;
    }

    public void agregarLibro(String t, String a, String c) {

        int contador = 0;

        if (this.libros[0] == null) {

            this.libros[0] = new Libro(t, a, c);

        } else {

            boolean existe = false;

            for (int i = 0; i < contador; i++) {

                if (this.libros[i].getTitulo().equals(t) && this.libros[i].getAutor().equals(a)
                        && this.libros[i].getCategoria().equals(c)) {

                    existe = true;
                }

            }

            if (!existe) {

                this.libros[contador] = new Libro(t, a, c);
                contador++;
                System.out.println("Libro agregado exitosamente");

            }
        }

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

        for (int i = 0; i < libros.length; i++) {

            String info = libros[i].toString();
            System.out.println(info);

        }

    }

}
