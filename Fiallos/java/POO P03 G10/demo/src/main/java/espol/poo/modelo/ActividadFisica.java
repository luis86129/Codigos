//Direccion
package espol.poo.modelo;
//Clase con sus atributos y constructor
public class ActividadFisica {
    private String fecha;
    private String actividad;
    private int duracion;
    private String horario;
    private Perfil perfil;
    
    public ActividadFisica(String fecha, String actividad, int duracion, String horario, Perfil perfil) {
        this.fecha = fecha;
        this.actividad = actividad;
        this.duracion = duracion;
        this.horario = horario;
        this.perfil = perfil;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getActividad() {
        return actividad;
    }
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public Perfil getPerfil() {
        return perfil;
    }
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
}
