/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginus;

import com.mycompany.loginus.conexion.*;
import com.mycompany.loginus.dao.*;
import com.mycompany.loginus.modelo.*;
import java.util.ArrayList;

/**
 *
 * @author Luis Mendoza
 */
public class LoginUs {

    public static void main(String[] args) {
        // crear usuario
        /*UsuarioDAO dao = new UsuarioDAO();

            Usuario u = new Usuario(
                    "Andres",
                    "Mendoza",
                    "Andres8612",
                    "Andres8612@gmail.com",
                    "8612"
            );

            boolean resultado = dao.insertar(u);

            if(resultado) {

                System.out.println("Usuario registrado");

            } else {

                System.out.println("Error");

        }*/
        
        // Ingresar con usuario y contraseña
        /*UsuarioDAO dao = new UsuarioDAO();

            boolean login =
                    dao.login(
                            "luis123",
                            "1234"
                    );

            if(login) {

                System.out.println("LOGIN CORRECTO");

            } else {

                System.out.println("USUARIO O CONTRASEÑA INCORRECTOS");

        }*/


        // listar usuarios
        UsuarioDAO dao = new UsuarioDAO();

        ArrayList<Usuario> lista =
                dao.listar();

        for(Usuario u : lista) {

            System.out.println(
                    u.getId()
                    + " - "
                    + u.getNombre()
                    + " - "
                    + u.getApellido()
                    + " - "
                    + u.getUsuario()
            );

        }
        
        // eliminar usuario
        /*UsuarioDAO dao = new UsuarioDAO();

            boolean eliminado =
                    dao.eliminar(1);

            if(eliminado) {

                System.out.println(
                        "USUARIO ELIMINADO"
                );

            } else {

                System.out.println(
                        "NO EXISTE EL ID"
                );

        }*/
        
        // actualizar usuario
        /*UsuarioDAO dao = new UsuarioDAO();

            Usuario u = new Usuario();

            u.setId(3);

            u.setNombre("Carlos");

            u.setApellido("Lopez");

            u.setUsuario("carlos123");

            u.setCorreo("carlos@gmail.com");

            u.setContraseña("9999");

            boolean actualizado =
                    dao.actualizar(u);

            if(actualizado) {

                System.out.println(
                        "USUARIO ACTUALIZADO"
                );

            } else {

                System.out.println(
                        "NO EXISTE EL ID"
                );

        }*/
        
    }
}
