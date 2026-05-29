//Direccion
package espol.poo.vista;
//print de lo que se necesite
public abstract class Vista {
    public static void OpcionesIniciales(){
        System.out.println("Ingrese la opcion a realizar: \n1.Crear perfil\n2.Seleccionar perfil\n3.Salir");
    }
    public static void Menu(){
        System.out.println("1. Administrar Medicamento\n2. Administrar médicos\n3. Administrar citas médicas\n4. Administrar Actividad Física\n5. Salir");
    }
}

