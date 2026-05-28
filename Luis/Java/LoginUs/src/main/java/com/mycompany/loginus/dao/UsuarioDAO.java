package com.mycompany.loginus.dao;

import com.mycompany.loginus.conexion.ConexionSQLite;
import com.mycompany.loginus.modelo.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    
    public boolean login(String usuario, String contraseña) {

        String sql = """
                SELECT *
                FROM usuarios
                WHERE usuario = ?
                AND contraseña = ?
                """;

        try {

            Connection con =
                    ConexionSQLite.conectar();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, contraseña);

            var rs = ps.executeQuery();

            boolean existe = rs.next();

            rs.close();
            ps.close();
            con.close();

            return existe;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }
    
    public ArrayList<Usuario> listar() {

        ArrayList<Usuario> lista =
                new ArrayList<>();

        String sql = """
                SELECT *
                FROM usuarios
                """;

        try {

            Connection con =
                    ConexionSQLite.conectar();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                Usuario u = new Usuario();

                u.setId(
                        rs.getInt("id")
                );

                u.setNombre(
                        rs.getString("nombre")
                );

                u.setApellido(
                        rs.getString("apellido")
                );

                u.setUsuario(
                        rs.getString("usuario")
                );

                u.setCorreo(
                        rs.getString("correo")
                );

                u.setContraseña(
                        rs.getString("contraseña")
                );

                lista.add(u);

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return lista;

    }
    
    public boolean eliminar(int id) {

        String sql = """
                DELETE FROM usuarios
                WHERE id = ?
                """;

        try {

            Connection con =
                    ConexionSQLite.conectar();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            int filas =
                    ps.executeUpdate();

            ps.close();
            con.close();

            return filas > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

}