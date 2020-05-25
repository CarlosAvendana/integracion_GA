/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendga.modelo;

import backendga.modelo.dao.GestorCarrera;
import backendga.modelo.dao.GestorCurso;
import backendga.modelo.dao.GestorUsuario;
import java.util.Observable;

public class Model extends Observable {

    private Usuario user;
    
    
    GestorCurso gestorCurso;
    GestorCarrera gestorCarrera;
    
   

    public Model() {
        this.user = new Usuario();
        this.gestorCarrera = new GestorCarrera();
        this.gestorCurso = new GestorCurso();
         
    }

    public Model(Usuario user) {
        this.user = user;
    }

    
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public boolean validaUsuario(int id, String password) {
        boolean result = false;
        if (GestorUsuario.obtenerInstancia().validacionUsuario(id, password)) {
            result = true;
        }
        return result;
    }

    
    public GestorCarrera getGestorCarrera() {
        return gestorCarrera;
    }

    public void setGestorCarrera(GestorCarrera gestorCarrera) {
        this.gestorCarrera = gestorCarrera;
    }

   
    public GestorCurso getGestorCurso() {
        return gestorCurso;
    }

    public void setGestorCurso(GestorCurso gestor) {
        this.gestorCurso = gestor;
    }

  
    
    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }

    public void commit() {
        setChanged();
        notifyObservers();
    }
}
