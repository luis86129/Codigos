/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginus;
import com.mycompany.loginus.conexion.*;
import com.mycompany.loginus.dao.*;
import com.mycompany.loginus.modelo.*;
/**
 *
 * @author Luis Mendoza
 */
public class LoginUs {

    public static void main(String[] args) {
                
        UsuarioDAO dao = new UsuarioDAO();

        Usuario u = new Usuario(
                "Ricardo",
                "Fiallos",
                "rickfiall",
                "Ricardo@gmail.com",
                "1723"
        );

        boolean resultado = dao.insertar(u);

        if(resultado) {

            System.out.println("Usuario registrado");

        } else {

            System.out.println("Error");

        }
    }
}
