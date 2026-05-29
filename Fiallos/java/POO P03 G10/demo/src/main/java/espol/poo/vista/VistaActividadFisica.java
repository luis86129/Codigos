//Direccion
package espol.poo.vista;
//librerias
import java.util.ArrayList;
//archivos usados
import espol.poo.modelo.ActividadFisica;
import espol.poo.modelo.Perfil;
//print de lo que se necesite
public abstract class VistaActividadFisica {
    public static void mostrarActividadFisica(ArrayList<ActividadFisica> actividadFisica , Perfil usuarioIngresado){
        int num = 1 ;
        ArrayList<ActividadFisica> actividadUsuario = new ArrayList<ActividadFisica>(); 
        for (ActividadFisica actividad : actividadFisica) {
            if(actividad.getPerfil().equals(usuarioIngresado) ){
                actividadUsuario.add(0, actividad);
            }
        }
        for (ActividadFisica af : actividadUsuario){
            System.err.println(num + ". El usuario " + af.getPerfil().getNombreUsuario() + " en la fecha " + af.getFecha() +" realizo la actividad fisica: " + af.getActividad() + " Con la duracion de " + af.getDuracion() + " minutos.");
            num ++ ;
        }
    }
}
