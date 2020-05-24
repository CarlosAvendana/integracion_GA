package com.e.lab.AccesoDatos;

import com.e.lab.LogicaNeg.Carrera;
import com.e.lab.LogicaNeg.Curso;
import com.e.lab.LogicaNeg.Usuario;

import java.util.ArrayList;
import java.util.List;


public class ModelData {


    private List<Carrera> carreraList;
    private List<Curso> cursoList;

    public ModelData() {
        carreraList = new ArrayList<>();
        cursoList = new ArrayList<>();
        prepareCarreraData();
        prepareCursoData();
    }

    public void prepareCarreraData() {
        Carrera carrera = new Carrera("EIF", "Ingenieria en sistemas");
        carrera.addCurso(new Curso("ST", "Soporte", 3, 4));
        carrera.addCurso(new Curso("FD", "Fundamentos", 3, 4));
        carrera.addCurso(new Curso("PG1", "Programacion I", 3, 4));
        carrera.addCurso(new Curso("PG2", "Programacion II", 3, 4));
        carrera.addCurso(new Curso("PG3", "Programacion III", 3, 4));
        carrera.addCurso(new Curso("PG4", "Programacion IV", 3, 4));
        carrera.addCurso(new Curso("EDA", "Estructuras Datos", 3, 4));
        carrera.addCurso(new Curso("EDI", "Estructuras Discretas", 3, 4));
        carrera.addCurso(new Curso("MV", "Moviles", 3, 4));
        carrera.addCurso(new Curso("PP", "Paradigmas", 3, 4));
        carrera.addCurso(new Curso("AQ", "Arquitectura", 3, 4));
        carrera.addCurso(new Curso("RD", "Redes", 3, 4));
        carreraList.add(carrera);

        carrera = new Carrera("ADM", "Administracion");
        carrera.addCurso(new Curso("FAD", "Fundamentos de Administracion", 3, 4));
        carrera.addCurso(new Curso("C1", "Contabilidad I", 3, 4));
        carreraList.add(carrera);

        carrera = new Carrera("FIS", "Fisica");
        carrera.addCurso(new Curso("FF", "Fundamentos de Fisica", 3, 4));
        carrera.addCurso(new Curso("F1", "Fisica I", 3, 4));
        carreraList.add(carrera);

        carrera = new Carrera("MAT", "Matematica");
        carrera.addCurso(new Curso("FM", "Fundamentos de Matematica", 3, 4));
        carrera.addCurso(new Curso("HB1", "Historia Basica I", 3, 4));
        carreraList.add(carrera);

    }

    public void prepareCursoData() {
        Curso curso = new Curso("ST", "Soporte", 3, 4);
        cursoList.add(curso);
        curso = new Curso("FD", "Fundamentos", 3, 4);
        cursoList.add(curso);
        curso = new Curso("PG1", "Programacion I", 3, 4);
        cursoList.add(curso);
        curso = new Curso("PG2", "Programacion II", 3, 4);
        cursoList.add(curso);
        curso = new Curso("PG3", "Programacion III", 3, 4);
        cursoList.add(curso);
        curso = new Curso("PG4", "Programacion IV", 3, 4);
        cursoList.add(curso);
        curso = new Curso("EDA", "Estructuras Datos", 3, 4);
        cursoList.add(curso);
        curso = new Curso("EDI", "Estructuras Discretas", 3, 4);
        cursoList.add(curso);

        curso = new Curso("MV", "Moviles", 3, 4);
        cursoList.add(curso);
        curso = new Curso("PP", "Paradigmas", 3, 4);
        cursoList.add(curso);

        curso = new Curso("AQ", "Arquitectura", 3, 4);
        cursoList.add(curso);

        curso = new Curso("RD", "Redes", 3, 4);
        cursoList.add(curso);
        // de adm
        curso = new Curso("FAD", "Fundamentos de Administracion", 3, 4);
        cursoList.add(curso);
        curso = new Curso("C1", "Contabilidad I", 3, 4);
        cursoList.add(curso);
        // de fisica
        curso = new Curso("FF", "Fundamentos de Fisica", 3, 4);
        cursoList.add(curso);
        curso = new Curso("F1", "Fisica I", 3, 4);
        cursoList.add(curso);
        // de matematica
        curso = new Curso("FM", "Fundamentos de Matematica", 3, 4);
        cursoList.add(curso);
        curso = new Curso("HB1", "Historia Basica I", 3, 4);
        cursoList.add(curso);

    }

    public List<Carrera> getCarreraList() {
        return carreraList;
    }

    public void setCarreraList(List<Carrera> carreraList) {
        this.carreraList = carreraList;
    }

    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    public List<Usuario> getUsuariosList() {
        List<Usuario> users = new ArrayList<>();

        users.add(new Usuario("admin", "admin", "Administrador", "111"));
        users.add(new Usuario("carlos", "carlos", "Carlos Obando", "111"));
        users.add(new Usuario("felipe", "felipe", "Felipe Piedra", "111"));

        return users;
    }
}
