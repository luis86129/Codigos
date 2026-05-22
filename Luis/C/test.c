#include <stdio.h>
#include <string.h>

int main(void) {
    char nombre[100];
    char apellido[100];
    int edad;

    printf("Ingrese su nombre: ");
    if (!fgets(nombre, sizeof(nombre), stdin)) return 1;
    nombre[strcspn(nombre, "\n")] = '\0';

    printf("Ingrese su apellido: ");
    if (!fgets(apellido, sizeof(apellido), stdin)) return 1;
    apellido[strcspn(apellido, "\n")] = '\0';

    printf("Ingrese su edad: ");
    if (scanf("%d", &edad) != 1) return 1;

    printf("Nombre: %s\nApellido: %s\nEdad: %d\n", nombre, apellido, edad);
    return 0;
}
