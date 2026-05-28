package com.mycompany.loginus.dao;

import com.mycompany.loginus.conexion.ConexionSQLite;
import com.mycompany.loginus.modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuarioDAO {

    public boolean insertar(Usuario u) {

        String sql = """
                INSERT INTO usuarios
                (
                    nombre,
                    apellido,
                    usuario,
                    correo,
                    contraseña
                )
                VALUES (?, ?, ?, ?, ?)
                """;

        try {

            Connection con =
                    ConexionSQLite.conectar();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido());
            ps.setString(3, u.getUsuario());
            ps.setString(4, u.getCorreo());
            ps.setString(5, u.getContraseña());

            ps.executeUpdate();

            ps.close();
            con.close();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

}