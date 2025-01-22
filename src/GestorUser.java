public class GestorUser {

    private Usuario[] listaUser;
    private int tam = 500;
    private static int lleno;
    private static int contadorUs;

    public GestorUser() {

        this.listaUser = new Usuario[tam];
        lleno = 0;

    }

    public void consultaDatosUsuario() {

        for (int i = 0; i < lleno; i++) {

            System.out.println(listaUser[i].toString());

        }

    }

    public void registroUser(String nombre, String ape1, String ape2,
            String contra) {
        boolean existe = false;

        if (lleno == 0) {

            this.listaUser[lleno] = new Usuario(nombre, ape1, ape2, contra);
            lleno++;
        } else {

            for (int i = 0; i < lleno; i++) {

                if (this.listaUser[i] == null) {

                    for (int j = 0; j < lleno; j++) {

                        if (nombre.equals(this.listaUser[j].getNombre()) && ape1.equals(this.listaUser[j].getApellido())
                                && ape2.equals(this.listaUser[j].getApellido2())
                                && contra.equals(this.listaUser[j].getContrasena())) {

                            existe = true;
                        }

                    }

                    if (!existe) {

                        this.listaUser[i] = new Usuario(nombre, ape1, ape2, contra);
                        lleno++;
                        contadorUs++;
                    }

                }

            }

        }

    }

    public Usuario[] getlistaUser() {

        return this.listaUser;

    }

    public static int cuentaUsuario() {

        return contadorUs;
    }

}

/*
 * Registrar nuevos usuarios.(admin)
 * Consultar información de usuarios registrados.(admin)
 */