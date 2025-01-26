import java.util.Arrays;

public class GestorUsuario {

    private Usuario[] listaUsuario;
    private final int tam = 500;
    private int contadorListaUsuario;

    public GestorUsuario() {

        this.listaUsuario = new Usuario[tam];
        contadorListaUsuario = 0;

    }

    public Usuario[] getlistaUser() {

        return this.listaUsuario;

    }

    public void setCuentaUsuario() {

        contadorListaUsuario++;
    }

    public int getCuentaUsuario() {

        return this.contadorListaUsuario;
    }

    public void consultaDatosUsuario() {

        for (int i = 0; i < contadorListaUsuario; i++) {

            System.out.println(listaUsuario[i].toString());

        }

    }

    public void registroUser(String nombre, String ape1, String ape2,
            String contra, Tipo tipo) {

        boolean existe = false;

        if (contadorListaUsuario == 0) {

            this.listaUsuario[contadorListaUsuario] = new Usuario(nombre, ape1, ape2, contra, tipo);
            contadorListaUsuario++;
        } else {

            if (contadorListaUsuario <= tam) {

                for (int j = 0; j < contadorListaUsuario; j++) {

                    if (nombre.equals(this.listaUsuario[j].getNombre())
                            && ape1.equals(this.listaUsuario[j].getApellido())
                            && ape2.equals(this.listaUsuario[j].getApellido2())
                            && contra.equals(this.listaUsuario[j].getContrasena())) {

                        existe = true;
                    }

                }

                if (!existe) {

                    this.listaUsuario[contadorListaUsuario] = new Usuario(nombre, ape1, ape2, contra, tipo);
                    contadorListaUsuario++;

                }

            }

        }

    }

    // Lista de los usuarios ordenador por el número de préstamos que tienen,
    // mostrando luego solo los 10 primeros

    public Usuario[] usuariosPorPrestamos() {

        boolean seguir = true;

        while (seguir) {

            int cambios = 0;
            Usuario aux = null;

            for (int i = 0; i < contadorListaUsuario - 1; i++) {

                if (listaUsuario[i].getContLibrosPrestamoUsuarios() < listaUsuario[i + 1]
                        .getContLibrosPrestamoUsuarios()) {

                    aux = this.listaUsuario[i];
                    listaUsuario[i] = listaUsuario[i + 1];
                    listaUsuario[i + 1] = aux;
                    cambios++;

                }

            }

            if (cambios == 0) {
                seguir = false;
            }

        }

        return Arrays.copyOf(listaUsuario, 10);

    }

}
