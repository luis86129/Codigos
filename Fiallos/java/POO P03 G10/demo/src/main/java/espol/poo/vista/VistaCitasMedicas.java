//Direccion
package espol.poo.vista;
//librerias
import java.util.ArrayList;
//archivos usados
import espol.poo.modelo.*;
//print de lo que se necesite
public abstract class VistaCitasMedicas {

    public static void mostrarCitasMedicas(ArrayList<CitasMedicas> citas , Perfil UsuarioIngresado) {
        ArrayList<CitasMedicas> citasUsuario = new ArrayList<CitasMedicas>();
        for (CitasMedicas cita : citas) {
            if (cita.getPerfil().equals(UsuarioIngresado)) {
                citasUsuario.add(0, cita);
            }
        }
        int num = 1;
        for (CitasMedicas citaUser : citasUsuario) {
            System.out.println(num + ". Cita medica de titulo: " + citaUser.getTituloCita() + " con el medico " + citaUser.getMedico().getNombre() + " fecha: " + citaUser.getFecha());
            num++;
        }
    }
}
