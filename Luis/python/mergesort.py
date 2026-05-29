import random
import time


def merge_sort(arr):
    if len(arr) <= 1:
        return arr

    mitad = len(arr) // 2
    izquierda = merge_sort(arr[:mitad])
    derecha = merge_sort(arr[mitad:])

    return merge(izquierda, derecha)


def merge(izquierda, derecha):
    resultado = []
    i = 0
    j = 0

    while i < len(izquierda) and j < len(derecha):
        if izquierda[i] < derecha[j]:
            resultado.append(izquierda[i])
            i += 1
        else:
            resultado.append(derecha[j])
            j += 1

    resultado.extend(izquierda[i:])
    resultado.extend(derecha[j:])

    return resultado


# Tamaños de prueba
tamaños = [10, 100, 1000, 10000, 100000, 1000000 , 10000000]

print("PRUEBAS DE RENDIMIENTO MERGE SORT\n")

for tamaño in tamaños:
    # Generar lista aleatoria
    datos = [random.randint(1, 1000000) for _ in range(tamaño)]

    # Medir tiempo
    inicio = time.time()

    merge_sort(datos)

    fin = time.time()

    tiempo = fin - inicio

    print(f"Tamaño: {tamaño:,} -> Tiempo: {tiempo:.6f} segundos")

    tiempo = 0