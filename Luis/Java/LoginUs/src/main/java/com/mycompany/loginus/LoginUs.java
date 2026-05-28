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
        
    }
}
