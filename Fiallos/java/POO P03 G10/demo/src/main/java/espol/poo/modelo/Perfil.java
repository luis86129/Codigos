//Direccion
package espol.poo.modelo;
//Clase con sus atributos y constructor
public class Perfil {
    private String nombreUsuario ;
    private String relacion; 
    private String email;
    
    public Perfil(String nombreUsuario, String relacion) {
        this.nombreUsuario = nombreUsuario;
        this.relacion = relacion;
    }

    public Perfil(String nombreUsuario, String relacion, String email) {
        this.nombreUsuario = nombreUsuario;
        this.relacion = relacion;
        this.email = email;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getRelacion() {
        return relacion;
    }
    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
