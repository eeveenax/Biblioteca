public class Usuario extends Persona {

    private static int idSiguiente = 1;

    private int id;
    private int contadorUP = 0;

    public Usuario(String nombre, String apellido, String apellido2, String contrasena) {

        super(nombre, apellido, apellido2, contrasena);
        this.id = getId();
        this.contadorUP = getContadorUP();

    }

    public Usuario() {

        super();
        this.id = getId();
        this.contadorUP = getContadorUP();

    }

    public void aumentoCUP() {

        this.contadorUP = contadorUP++;
    }

    public int getContadorUP() {
        return this.contadorUP;

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
                + ". Contraseña: " + this.contrasena + ". Su id es: " + this.id;
    }

}
