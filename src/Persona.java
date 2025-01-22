public class Persona {

    String nombre;
    String apellido;
    String apellido2;
    String contrasena;
    Tipo tipo;

    public Persona(String nombre, String apellido, String apellido2, String contrasena, Tipo tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.apellido2 = apellido2;
        this.tipo = tipo;
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

    @Override
    public String toString() {

        return "El nombre de la persona es " + this.nombre + ". El apellido es: " + this.apellido + ". Su Id es "
                + this.contrasena;
    }

}
