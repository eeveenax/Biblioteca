public class GestorPrestamos {

    private Libro[] listaLibrosPrestamos;
    private int contadorLibrosPrestados;
    private int tam = 100;
    private int prestamosTotales = 0;
    private int prestamosActivos = 0;

    public GestorPrestamos() {

        this.listaLibrosPrestamos = new Libro[tam];

        contadorLibrosPrestados = 0;

    }

    public Libro[] getListaLibrosPrestados() {

        return this.listaLibrosPrestamos;

    }

    public void prestarL(Libro[] listaLibros, Libro libro) {

        boolean seguir = true;

        if (listaLibros[0] != null) {

            for (int i = 0; i < listaLibros.length && seguir; i++) {

                if (listaLibros[i] == libro) {

                    if (listaLibros[i].getDisponible() == true) {

                        System.out.println(
                                "El libro " + listaLibros[i].getTitulo() + " está disponible para su préstamos");

                        listaLibros[i].setDisponible(false);

                        listaLibrosPrestamos[contadorLibrosPrestados] = libro;
                        contadorLibrosPrestados++;
                        prestamosTotales++;
                        prestamosActivos++;
                        seguir = false;

                    }

                }

            }

        } else {

            System.out.println("No hay libros.");
        }

    }

    // recibe la lista de libros prestados

    public void devolverL(Libro libro) {

        if (contadorLibrosPrestados > 0) {

        }

        for (int i = 0; i < contadorLibrosPrestados; i++) {

            if (listaLibrosPrestamos[i] == libro) {

                if (listaLibrosPrestamos[i].getDisponible() == false) {

                    System.out.println("El libro " + listaLibrosPrestamos[i].getTitulo() + " ha sido devuelto");
                    listaLibrosPrestamos[i].setDisponible(true);
                    prestamosActivos--;

                    for (int j = i; j < contadorLibrosPrestados - 1; j++) {

                        listaLibrosPrestamos[i] = listaLibrosPrestamos[i + 1];

                    }

                    contadorLibrosPrestados--;

                }

            }

        }

    }

    public void librosPrestados() {

        for (int i = 0; i < contadorLibrosPrestados; i++) {

            System.out.println(listaLibrosPrestamos[i].toString());

        }

    }

    public int getPrestamosTotales() {

        return this.prestamosTotales;
    }

    public int getPrestamosActivos() {

        return this.prestamosActivos;
    }

}
