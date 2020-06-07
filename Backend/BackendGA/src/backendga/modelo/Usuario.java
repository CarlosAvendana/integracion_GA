package backendga.modelo;

public class Usuario {

    private int cedula;
    private String contrasena;
    private String nombre;
    private boolean isvalido;

    public Usuario() {
        this.cedula = 0;
        this.contrasena = new String();
        this.nombre = new String();
        isvalido=false;

    }

    public Usuario(int cedula, String contrasena, String nombre, boolean isvalido) {
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.isvalido = isvalido;
    }

    public Usuario(int cedula, String contrasena, String nombre) {
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.nombre = nombre;
    }
    
    public Usuario(int cedula, String contrasena) {
        this.cedula = cedula;
        this.contrasena = contrasena;
    }
    
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isIsvalido() {
        return isvalido;
    }

    public void setIsvalido(boolean isvalido) {
        this.isvalido = isvalido;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", contrasena=" + contrasena + ", nombre=" + nombre + '}';
    }

}
