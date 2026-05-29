//Direccion
package espol.poo.modelo;
//Clase con sus atributos y constructor
public class CitasMedicas {
    private String tituloCita;
    private Medicos medico;
    private String fecha;
    private Perfil perfil;
    
  
    public CitasMedicas(String tituloCita, Medicos medico, String fecha , Perfil perfil) {
        this.tituloCita = tituloCita;
        this.medico = medico;
        this.fecha = fecha;
        this.perfil = perfil;
    }  
    
    public Perfil getPerfil() {
        return perfil;
    }
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    public String getTituloCita() {
        return tituloCita;
    }
    public void setTituloCita(String tituloCita) {
        this.tituloCita = tituloCita;
    }
    public Medicos getMedico() {
        return medico;
    }
    public void setMedico(Medicos medico) {
        this.medico = medico;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
