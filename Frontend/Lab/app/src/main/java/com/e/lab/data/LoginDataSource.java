package com.e.lab.data;

import com.e.lab.AccesoDatos.ModelData;
import com.e.lab.LogicaNeg.Usuario;
import com.e.lab.data.model.LoggedInUser;

import java.io.IOException;
import java.util.List;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            boolean bandera = validarUsuario(username, password);

            if (bandera) {
                Usuario validadoCorrecto = obtenerDatos(username, password);
                LoggedInUser fakeUser = new LoggedInUser(java.util.UUID.randomUUID().toString(), validadoCorrecto.getPrivilegio());
                return new Result.Success<>(fakeUser);
            } else {

                Exception e = new IOException("Error logging in");
                return new Result.Error(e);
            }

        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }


    }

    public void logout() {
        // TODO: revoke authentication
    }

    public boolean validarUsuario(String u, String p) {
        ModelData model = new ModelData();
        List<Usuario> listaU = model.getUsuariosList();

        boolean bandera = false;

        for (Usuario a : listaU) {
            if (a.getCorreo().equals(u) && a.getContraseña().equals(p)) {
                bandera = true;
            }
        }
        return bandera;

    }

    public Usuario obtenerDatos(String u, String p) {
        ModelData model = new ModelData();
        List<Usuario> listaU = model.getUsuariosList();
        Usuario x = new Usuario("X", "X", "X", "X");

        for (Usuario a : listaU) {
            if (a.getCorreo().equals(u) && a.getContraseña().equals(p)) {
                x.setPrivilegio(a.getPrivilegio());

            }
        }
        return x;
    }

}
