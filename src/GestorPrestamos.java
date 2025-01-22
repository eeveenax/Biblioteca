public class GestorPrestamos {

    private Libro[] listaLibrosPrestamos;
    private int llenoP;
    private int tam = 100;
    private int prestamosTotales = 0;

    public GestorPrestamos() {

        this.listaLibrosPrestamos = new Libro[tam];
        llenoP = 0;

    }

    // recibe la lista de libros completos

    public void prestarL(Libro[] listaLibros, String titulo, String autor, String categoria) {

        boolean seguir = true;

        for (int i = 0; i < listaLibros.length && seguir; i++) {

            if (titulo.equals(listaLibros[i].getTitulo()) && autor.equals(listaLibros[i].getAutor())
                    && categoria.equals(listaLibros[i].getCategoria())) {

                if (listaLibros[i].getDisponible() == true) {

                    System.out.println("El libro " + listaLibros[i].getTitulo() + " está disponible para su préstamos");
                    listaLibros[i].setDisponible(false);

                    listaLibrosPrestamos[llenoP] = new Libro(titulo, autor, categoria, false);
                    llenoP++;
                    prestamosTotales++;
                    seguir = false;

                }

            }

        }

    }

    // recibe la lista de libros prestados

    public void devolverL(String titulo, String autor, String categoria) {

        for (int i = 0; i < llenoP; i++) {

            if (titulo.equals(listaLibrosPrestamos[i].getTitulo()) && autor.equals(listaLibrosPrestamos[i].getAutor())
                    && categoria.equals(listaLibrosPrestamos[i].getCategoria())) {

                if (listaLibrosPrestamos[i].getDisponible() == false) {

                    System.out.println("El libro " + listaLibrosPrestamos[i].getTitulo() + " ha sido devuelto");
                    listaLibrosPrestamos[i].setDisponible(true);
                    prestamosTotales--;

                    for (int j = 0; j < llenoP - 1; j++) {

                        listaLibrosPrestamos[i] = listaLibrosPrestamos[i + 1];
                        llenoP--;

                    }

                }

            }

        }

    }

    public void librosPrestados() {

        for (int i = 0; i < llenoP; i++) {

            System.out.println(listaLibrosPrestamos[i].toString());

        }

    }

    public int getPrestamostotales() {

        return this.prestamosTotales;
    }

}
