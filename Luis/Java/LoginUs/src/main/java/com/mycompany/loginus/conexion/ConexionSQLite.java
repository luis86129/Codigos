package com.mycompany.loginus.conexion;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConexionSQLite {

    // RUTA DE LA CARPETA
    private static final String CARPETA =
            System.getProperty("user.home")
            + "\\Documents\\BD";

    // RUTA COMPLETA DE LA DB
    private static final String URL =
            "jdbc:sqlite:"
            + CARPETA
            + "\\loginus.db";

    public static Connection conectar() {

        Connection con = null;

        try {

            // CREAR CARPETA SI NO EXISTE
            File carpeta = new File(CARPETA);

            if(!carpeta.exists()) {

                carpeta.mkdirs();

                System.out.println("Carpeta BD creada");

            }

            // CONEXION
            con = DriverManager.getConnection(URL);

            System.out.println("Conexion exitosa");

            crearTablaUsuarios(con);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return con;

    }

    private static void crearTablaUsuarios(Connection con) {

        String sql = """
                CREATE TABLE IF NOT EXISTS usuarios (

                    id INTEGER PRIMARY KEY AUTOINCREMENT,

                    nombre TEXT NOT NULL,

                    apellido TEXT NOT NULL,

                    usuario TEXT UNIQUE NOT NULL,

                    correo TEXT UNIQUE NOT NULL,

                    contrasena TEXT NOT NULL

                )
                """;

        try {

            Statement st = con.createStatement();

            st.execute(sql);

            System.out.println("Tabla usuarios creada");

            st.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}