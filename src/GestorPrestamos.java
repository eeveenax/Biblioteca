public class GestorPrestamos {

    private Libro[] listaLibrosPrestamos;
    private int contadorLibrosPrestados;
    private int tam = 100;
    private int prestamosTotales = 0;

    public GestorPrestamos() {

        this.listaLibrosPrestamos = new Libro[tam];

        contadorLibrosPrestados = 0;

    }

    public Libro[] getListaLibrosPrestados() {

        return this.listaLibrosPrestamos;

    }

    public int getPrestamosTotales() {

        return this.prestamosTotales;
    }

    public int getPrestamosActivos() {

        return this.contadorLibrosPrestados;
    }

    // Ver la lista de todos los libros en préstamo que tiene la biblioteca

    public void librosPrestados() {

        for (int i = 0; i < contadorLibrosPrestados; i++) {

            System.out.println(listaLibrosPrestamos[i].toString());

        }

    }

    public void prestarL(Libro[] listaLibro, String titulo, String autor, String categoria, Usuario usuario,
            int contadorLibro) {

        boolean seguir = true;

        for (int i = 0; i < contadorLibro && seguir; i++) {

            if (listaLibro[i].getTitulo().equals(titulo) && listaLibro[i].getAutor().equals(autor)
                    && listaLibro[i].getCategoria().equals(categoria)) {

                if (listaLibro[i].getDisponible() == true) {

                    System.out.println(
                            "El libro " + listaLibro[i].getTitulo() + " está disponible para su préstamos");

                    listaLibro[i].setDisponible(false);

                    usuario.aumentaLibrosUsuarioPrestados(listaLibro[i]);

                    this.listaLibrosPrestamos[contadorLibrosPrestados] = listaLibro[i];
                    prestamosTotales++;
                    contadorLibrosPrestados++;
                    seguir = false;

                } else {

                    System.out
                            .println(" El libro " + listaLibro[i].getTitulo() + " no está disponible para su préstamo");
                }

            } else {

                System.out.println("El libro no existe");
            }

        }

    }

    public void devolverL(String titulo, String autor, String categoria, Usuario usuario) {

        if (contadorLibrosPrestados > 0) {

            boolean seguirD = true;

            for (int i = 0; i < contadorLibrosPrestados && seguirD; i++) {

                if (this.listaLibrosPrestamos[i].getTitulo().equals(titulo)
                        && this.listaLibrosPrestamos[i].getAutor().equals(autor)
                        && this.listaLibrosPrestamos[i].getCategoria().equals(categoria)) {

                    System.out.println("El libro " + listaLibrosPrestamos[i].getTitulo() + " ha sido devuelto");
                    listaLibrosPrestamos[i].setDisponible(true);
                    contadorLibrosPrestados--;

                    // eliminar libro lista usuario

                    usuario.restaLibrosUsuarioPrestados(listaLibrosPrestamos[i]);

                    for (int j = i; j < contadorLibrosPrestados - 1; j++) {

                        listaLibrosPrestamos[i] = listaLibrosPrestamos[i + 1];

                    }

                    seguirD = false;

                }

            }

        }

    }

}
