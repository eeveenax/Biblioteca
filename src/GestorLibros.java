import java.util.Arrays;

public class GestorLibros {

private Libro[] libros;
private int lleno;
private static final int TAM = 100;

 
public GestorLibros() {
    libros = new Libro [TAM];
    lleno = 0;
 }

 public void agregarLibro(Libro c) {
    libros[lleno] = c;
    lleno++;
 }

 private int buscarIndiceLibro(String titulo) {
    int buscar = -1;
    for (int i = 0; i < lleno && buscar == -1; i++) {
        if (libros[i].getTitulo().equals(titulo)) {
            buscar = i;
        }
    }
    return buscar;
 }

 public Libro[] buscarPorAutor(String autor) {
    Libro[] resultado = new Libro[TAM];
    int autorLleno = 0;
    for (int i = 0; i < lleno; i++) {
        if (libros[i].getAutor().equals(autor)) {
            resultado[autorLleno] = libros[i];
            autorLleno++;
        }
    }
    return Arrays.copyOf(resultado, autorLleno);
 }
public Libro[] buscarPorCategoria(CategoriaLibro categorialibro) {
    Libro[] resultado = new Libro[TAM];
    int categoriaLleno = 0;
    for (int i = 0; i < lleno; i++) {
        if (libros[i].getCategoriaLibro().equals(CategoriaLibro)) {
            resultado[categoriaLleno] = libros[i];
            categoriaLleno++;
        }
    }
    return Arrays.copyOf(resultado, categoriaLleno);
    }
}


