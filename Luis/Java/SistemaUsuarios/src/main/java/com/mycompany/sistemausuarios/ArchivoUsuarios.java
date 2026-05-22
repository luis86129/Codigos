/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemausuarios;

import java.io.*;
import java.util.ArrayList;

public class ArchivoUsuarios {
    
    private static final String ARCHIVO = "usuarios.dat";

    // Guardar lista
    public static void guardar(ArrayList<Usuario> usuarios) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {

            oos.writeObject(usuarios);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cargar lista
    public static ArrayList<Usuario> cargar() {

        File archivo = new File(ARCHIVO);

        // Si no existe, devuelve lista vacía
        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(ARCHIVO))) {

            return (ArrayList<Usuario>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
