public class Usuario extends Persona {

    private static int idSiguiente = 1;

    private int id;

    public Usuario(String nombre, String apellido, String apellido2, String contrasena) {

        super(nombre, apellido, apellido2, contrasena);
        this.id = getId();
    }

    public int getId() {

        getIdsiguiente();

        return this.id;
    }

    public void getIdsiguiente() {

        this.id = idSiguiente;
        idSiguiente++;

    }

    @Override

    public String toString() {

        return "Nombre: " + this.nombre + ". Apellido 1: " + this.apellido + ". Apellido 2: " + this.apellido2
                + ". Contraseña: " + this.contrasena;
    }

}
