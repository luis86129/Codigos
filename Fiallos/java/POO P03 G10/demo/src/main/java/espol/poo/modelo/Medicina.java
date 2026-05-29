//Direccion
package espol.poo.modelo;
//Clase con sus atributos y constructor
public class Medicina {
    private String nombreMedicamento ;
    private int cantidadInventario;
    private String presentacionMedicamento;
    private String frecuencia;
    private int frecuenciaDia;
    private String frecuenciaHora;
    private int cantidadDosis;
    private Perfil perfil;
    
    public Medicina(String nombreMedicamento, int cantidadInventario, String presentacionMedicamento, String frecuencia,
            int frecuenciaDia, String frecuenciaHora, int cantidadDosis, Perfil perfil) {
        this.nombreMedicamento = nombreMedicamento;
        this.cantidadInventario = cantidadInventario;
        this.presentacionMedicamento = presentacionMedicamento;
        this.frecuencia = frecuencia;
        this.frecuenciaDia = frecuenciaDia;
        this.frecuenciaHora = frecuenciaHora;
        this.cantidadDosis = cantidadDosis;
        this.perfil = perfil;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public int getCantidadInventario() {
        return cantidadInventario;
    }

    public void setCantidadInventario(int cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
    }

    public String getPresentacionMedicamento() {
        return presentacionMedicamento;
    }

    public void setPresentacionMedicamento(String presentacionMedicamento) {
        this.presentacionMedicamento = presentacionMedicamento;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public int getFrecuenciaDia() {
        return frecuenciaDia;
    }

    public void setFrecuenciaDia(int frecuenciaDia) {
        this.frecuenciaDia = frecuenciaDia;
    }

    public String getFrecuenciaHora() {
        return frecuenciaHora;
    }

    public void setFrecuenciaHora(String frecuenciaHora) {
        this.frecuenciaHora = frecuenciaHora;
    }

    public int getCantidadDosis() {
        return cantidadDosis;
    }

    public void setCantidadDosis(int cantidadDosis) {
        this.cantidadDosis = cantidadDosis;
    }

    
}
