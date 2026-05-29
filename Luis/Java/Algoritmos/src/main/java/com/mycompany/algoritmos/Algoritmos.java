/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.algoritmos;

/**
 *
 * @author Luis Mendoza
 */
public class Algoritmos {
    
    public static void insertionSort(int[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            int key = arreglo[i];
            int j = i - 1;

            // Mover los elementos mayores que key a una posición adelante
            while (j >= 0 && arreglo[j] > key) {
                arreglo[j + 1] = arreglo[j];
                j--;
                System.out.println("\n\nArreglo SIENDO ordenado POR insertion sort:");
                for (int num : arreglo) {
                    System.out.print(num + " ");
                }
            }
            
            arreglo[j + 1] = key;
            System.out.println("\n\nArreglo SIENDO ordenado POR insertion sort:");
            for (int num : arreglo) {
                System.out.print(num + " ");
            }
        }
    }
    
    public static void bubbleSort(int[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {

            for (int j = 0; j < arreglo.length - 1 - i; j++) {

                // Comparar elementos adyacentes
                if (arreglo[j] > arreglo[j + 1]) {

                    // Intercambiar valores
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }
    
    // Método principal de Merge Sort
    public static void mergeSort(int[] arreglo, int izquierda, int derecha) {

        if (izquierda < derecha) {

            // Punto medio
            int medio = (izquierda + derecha) / 2;
            
            System.out.println("\nmedio: " + medio);

            // Ordenar mitad izquierda
            mergeSort(arreglo, izquierda, medio);
            System.out.print("\nOrdenamiento en izquierda ");
            for (int num : arreglo) {
                System.out.print(num + " ");
            }
            
            // Ordenar mitad derecha
            mergeSort(arreglo, medio + 1, derecha);
            System.out.print("\nOrdenamiento en derecha ");
            for (int num : arreglo) {
                System.out.print(num + " ");
            }
            
            // Combinar ambas mitades
            merge(arreglo, izquierda, medio, derecha);
            System.out.print("\nCombinacion de ambas mitades ");
            for (int num : arreglo) {
                System.out.print(num + " ");
            }
        }
    }
    
    // Método para combinar los arreglos
    public static void merge(int[] arreglo, int izquierda, int medio, int derecha) {

        // Tamaños de los subarreglos
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        // Arreglos temporales
        int[] izquierdaArray = new int[n1];
        int[] derechaArray = new int[n2];

        // Copiar datos al arreglo izquierdo
        for (int i = 0; i < n1; i++) {
            izquierdaArray[i] = arreglo[izquierda + i];
        }

        // Copiar datos al arreglo derecho
        for (int j = 0; j < n2; j++) {
            derechaArray[j] = arreglo[medio + 1 + j];
        }

        // Índices
        int i = 0;
        int j = 0;
        int k = izquierda;

        // Combinar los arreglos ordenados
        while (i < n1 && j < n2) {

            if (izquierdaArray[i] <= derechaArray[j]) {
                arreglo[k] = izquierdaArray[i];
                i++;
            } else {
                arreglo[k] = derechaArray[j];
                j++;
            }

            k++;
        }

        // Copiar elementos restantes del arreglo izquierdo
        while (i < n1) {
            arreglo[k] = izquierdaArray[i];
            i++;
            k++;
        }

        // Copiar elementos restantes del arreglo derecho
        while (j < n2) {
            arreglo[k] = derechaArray[j];
            j++;
            k++;
        }
    }

    
    public static void main(String[] args) {
        int[] numeros = {38, 27, 43, 3, 9, 9, 82, 10 , 67};

        System.out.println("Arreglo original:");

        for (int num : numeros) {
            System.out.print(num + " ");
        }

        // Llamada al Merge Sort
        //mergeSort(numeros, 0, numeros.length - 1);

        //System.out.println("\n\nArreglo ordenado por merge sort:");

        /*for (int num : numeros) {
            System.out.print(num + " ");
        }*/
        
        insertionSort(numeros); // Llamada al método
        System.out.println("\n\nArreglo ordenado POR insertion sort:");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        
        
        /*bubbleSort(numeros);

        System.out.println("\n\nArreglo ordenado POR BUBBLE SORT:");

        for (int num : numeros) {
            System.out.print(num + " ");
        }*/
    }
}
