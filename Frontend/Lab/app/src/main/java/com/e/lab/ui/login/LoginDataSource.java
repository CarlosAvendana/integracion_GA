package com.e.lab.ui.login;

import com.e.lab.AccesoDatos.AsyncResponse;
import com.e.lab.AccesoDatos.ModelData;
import com.e.lab.AccesoDatos.NetManager;
import com.e.lab.LogicaNeg.Usuario;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {

            final Usuario isValido= new Usuario(false);
            JSONObject user = new JSONObject();
            try {
                user.put("cedula", username);
                user.put("contrasena", password);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            NetManager net = new NetManager("http://192.168.100.10:8084/GestionAcademica/Server_Movil_Usuario", new AsyncResponse() {
                @Override
                public void processFinish(String output) {
                    try {
                        JSONObject jsonUser = new JSONObject(output);
                        isValido.setIsvalido(jsonUser.getBoolean("isvalido"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
            net.execute(NetManager.POST, user.toString());

            if (isValido.isIsvalido()) {
                Usuario validadoCorrecto = obtenerDatos(username, password);
                LoggedInUser fakeUser = new LoggedInUser(java.util.UUID.randomUUID().toString(), "Usuario");
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
