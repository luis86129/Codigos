/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemausuarios;
import java.util.ArrayList;
/**
 *
 * @author Luis Mendoza
 */
public class SistemaUsuarios {
    
    public static ArrayList<Usuario> Usuarios;
    
    public static void main(String[] args) {
        // Cargar automáticamente
        Usuarios = ArchivoUsuarios.cargar();

        System.out.println("Usuarios cargados: " + Usuarios.size());

        // Abrir JFrame
        new RegistroUsuario().setVisible(true);
        
    }
}
