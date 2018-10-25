package dmi.com.myapplication;

public class Usuario {


    private String uid;
    private String nombre;
    private String correo;
    private String pass;

    public Usuario(String nombre, String correo, String pass) {
        this.nombre = nombre;
        this.correo = correo;
        this.pass = pass;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
