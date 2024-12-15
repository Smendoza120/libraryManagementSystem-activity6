package biblioteca;

import java.util.Scanner;

public class Menu {

    public final Scanner entrada;

    public Menu() {
        this.entrada = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {
        System.out.println("1. Menu libreria");
        System.out.println("2. Menu usuarios");
        System.out.println("3. Gestionar relaciones");
        System.out.println("4. Salir");

    }

    public int leerOpcion() {
        System.out.println("Ingresa una opcion");

        try {
            return Integer.parseInt(entrada.nextLine());
        } catch (Exception e) {
            System.out.println("Porfavor ingrese un numero valido");

            return -1;
        }
    }

    public void mostrarMenuLibros() {
        System.out.println("-----Menu Libros-----");
        System.out.println("1. Agregar libro");
        System.out.println("2. Listar libros");
        System.out.println("3. Volver");
    }

    public void mostrarMenuUsuarios() {
        System.out.println("-----Menu Usuarios-----");
        System.out.println("1. Agregar usuario");
        System.out.println("2. Listar usuarios");
        System.out.println("3. Volver");
    }

    public void mostrarMenuRelaciones() {
        System.out.println("-----Menu Relaciones-----");
        System.out.println("1. Agregar relacion");
        System.out.println("2. Eliminar relacion");
        System.out.println("3. Listar relacion");
        System.out.println("4. Volver");
    }
}
