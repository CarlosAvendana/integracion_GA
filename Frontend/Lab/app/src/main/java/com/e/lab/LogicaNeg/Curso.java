package com.e.lab.LogicaNeg;

import java.io.Serializable;


public class Curso implements Serializable {

    private String codigo;
    private String carrera_codigo;
    private String anio;
    private String ciclo;
    private String nombre;
    private int creditos;
    private int horas;


    public Curso(String codigo, String carrera_codigo, String anio, String ciclo, String nombre, int creditos, int horas) {
        this.codigo = codigo;
        this.carrera_codigo = carrera_codigo;
        this.anio = anio;
        this.ciclo = ciclo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horas = horas;
    }

    public Curso(String codigo, String nombre, int creditos, int horas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horas = horas;
    }

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = 0;
        this.horas = 0;
    }

    public Curso() {

    }

    public String getCarrera_codigo() {
        return carrera_codigo;
    }

    public void setCarrera_codigo(String carrera_codigo) {
        this.carrera_codigo = carrera_codigo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return nombre;
        /*
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", creditos=" + creditos +
                ", horas=" + horas +
                '}';
                */
    }

}
