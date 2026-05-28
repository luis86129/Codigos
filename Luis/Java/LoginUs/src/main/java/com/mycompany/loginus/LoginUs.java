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

        boolean login =
                dao.login(
                        "luis123",
                        "1234"
                );

        if(login) {

            System.out.println("LOGIN CORRECTO");

        } else {

            System.out.println("USUARIO O CONTRASEÑA INCORRECTOS");

        }
        
    }
}
