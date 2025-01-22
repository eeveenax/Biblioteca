public class Libro {

    private String titulo;
    private String autor;
    private String categoria;
    private boolean disponible;
    private int contadoLP = 0;

    public Libro(String titulo, String autor, String categoria, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.disponible = disponible;
        this.contadoLP = getContadorLP();
    }

    public Libro() {
        this.titulo = " ";
        this.autor = " ";
        this.categoria = " ";
        this.disponible = true;
        this.contadoLP = 0;
    }

    public void aumentoContadorLP() {

        this.contadoLP = contadoLP++;

    }

    public int getContadorLP() {

        return contadoLP;

    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setDisponible(boolean disponible) {

        this.disponible = disponible;

    }

    public boolean getDisponible() {

        return this.disponible;
    }

    @Override

    public String toString() {

        return "Título: " + this.titulo + ". Autor: " + this.autor + ". Categoría: " + this.categoria;
    }

}
