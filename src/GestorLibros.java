import java.util.Arrays;

public class GestorLibros {

    private Libro[] libros;

    private static int contadorLibros;
    private static final int tam = 100;

    public GestorLibros() {
        libros = new Libro[tam];
        contadorLibros = 0;
    }

    public void agregarLibro(String titulo, String autor, String categoria) {

        if (contadorLibros == 0) {

            this.libros[0] = new Libro(titulo, autor, categoria, true);
            contadorLibros++;

        } else {

            boolean existe = false;

            if (contadorLibros <= tam) {

                for (int i = 0; i < contadorLibros; i++) {

                    if (this.libros[i].getTitulo().equals(titulo) && this.libros[i].getAutor().equals(autor)
                            && this.libros[i].getCategoria().equals(categoria)) {

                        existe = true;
                    }
                }

                if (!existe) {

                    this.libros[contadorLibros] = new Libro(titulo, autor, categoria, true);
                    contadorLibros++;
                    System.out.println("Libro agregado exitosamente");

                } else {

                    System.out.println("Ya existe");
                }

            }

        }

    }

    public Libro[] getListaLibros() {

        return this.libros;

    }

    public Libro[] buscarTituloLibro(String titulo) {
        Libro[] titulos = new Libro[tam];
        int contadorTitulo = 0;
        for (int i = 0; i < libros.length; i++) {

            if (libros[i].getTitulo().equals(titulo)) {

                titulos[contadorTitulo] = libros[i];
                contadorTitulo++;

            }
        }

        return Arrays.copyOf(titulos, contadorTitulo);
    }

    public Libro[] buscarPorAutor(String autor) {
        Libro[] resultado = new Libro[tam];
        int contadorAutor = 0;
        for (int i = 0; i < libros.length; i++) {
            if (libros[i].getAutor().equals(autor)) {
                resultado[contadorAutor] = libros[i];
                contadorAutor++;
            }
        }
        return Arrays.copyOf(resultado, contadorAutor);
    }

    public Libro[] buscarPorCategoria(String categorialibro) {
        Libro[] resultado = new Libro[tam];
        int contadorCategoria = 0;
        for (int i = 0; i < libros.length; i++) {
            if (libros[i].getCategoria().equals(categorialibro)) {
                resultado[contadorCategoria] = libros[i];
                contadorCategoria++;
            }
        }
        return Arrays.copyOf(resultado, contadorCategoria);
    }

    // Elimina los libros

    public Libro[] eliminaLibro(Libro libro) {

        boolean eliminado = false;
        int pos = 0;

        for (int i = 0; i < contadorLibros; i++) {

            if (libros[i] == libro) {

                libros[i] = null;
                eliminado = true;
                pos = i;

            }

        }

        if (eliminado) {

            for (int i = pos; i < contadorLibros; i++) {

                libros[i] = libros[i + 1];

            }

            System.out.println("Libro eliminado con éxito");
            contadorLibros--;

        }

        return libros;

    }

    public void librosTotales() {

        for (int i = 0; i < contadorLibros; i++) {

            String info = libros[i].toString();
            System.out.println(info);

        }

    }

    public Libro[] librosMasPrestados() {

        boolean seguirC = true;

        while (seguirC) {

            int cambios = 0;

            for (int i = 0; i < contadorLibros - 1; i++) {

                Libro aux = null;

                if (this.libros[i].getContadorLP() < libros[i].getContadorLP()) {

                    aux = this.libros[i];
                    this.libros[i] = this.libros[i + 1];
                    this.libros[i + 1] = aux;
                    cambios++;

                }

            }

            if (cambios == 0) {

                seguirC = false;

            }

        }

        Libro[] listaMasPrestados = Arrays.copyOf(libros, 10);

        return listaMasPrestados;

    }

}
