package biblioteca;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();

        AVLTree<String> libros = new AVLTree<>();
        AVLTree<String> usuarios = new AVLTree<>();
        GrafoBiblioteca grafo = new GrafoBiblioteca();

        boolean salir = false;

        while (!salir) {
            menu.mostrarMenuPrincipal();
            int opcion = menu.leerOpcion();

            switch (opcion) {
                case 1 ->
                    manejarMenuLibros(menu, libros);
                case 2 ->
                    manejarMenuUsuarios(menu, usuarios);
                case 3 ->
                    manejarMenuRelaciones(menu, grafo, libros, usuarios);
                case 4 -> {
                    salir = true;
                    System.out.println("Saliste del menu");
                }
                default ->
                    System.out.println("Opcion no valida");

            }
        }

    }

    private static void manejarMenuLibros(Menu menu, AVLTree<String> libros) {
        boolean salir = false;

        while (!salir) {
            menu.mostrarMenuLibros();
            int opcion = menu.leerOpcion();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese el codigo del libro: ");
                    String codigo = menu.entrada.nextLine();

                    System.out.println("Ingrese el titulo del libro: ");
                    String titulo = menu.entrada.nextLine();

                    System.out.println("Ingrese el autor del libro: ");
                    String autor = menu.entrada.nextLine();

                    libros.insertar(codigo, new Libro(codigo, titulo, autor));

                    System.out.println("Libro agregado con exito");
                }
                case 2 -> {
                    System.out.println("Lista de libros");
                    libros.recorridoInOrden();
                }
                case 3 -> {
                    salir = true;
                }
                default ->
                    System.out.println("Opcion no valida");
            }
        }
    }

    private static void manejarMenuUsuarios(Menu menu, AVLTree<String> usuarios) {
        boolean salir = false;

        while (!salir) {
            menu.mostrarMenuUsuarios();
            int opcion = menu.leerOpcion();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese la cedula del usuario: ");
                    String cedula = menu.entrada.nextLine();

                    System.out.println("Ingrese el nombre del usuario: ");
                    String nombre = menu.entrada.nextLine();

                    System.out.println("Ingrese el autor del usuario: ");
                    String apellido = menu.entrada.nextLine();

                    usuarios.insertar(cedula, new Usuario(cedula, nombre, apellido));

                    System.out.println("Libro agregado con exito");
                }
                case 2 -> {
                    System.out.println("Lista de usuarios");
                    usuarios.recorridoInOrden();
                }
                case 3 -> {
                    salir = true;
                }
                default ->
                    System.out.println("Opcion no valida");
            }
        }
    }

    private static void manejarMenuRelaciones(Menu menu, GrafoBiblioteca grafo, AVLTree<String> libros, AVLTree<String> usuarios) {
        boolean salir = false;

        while (!salir) {
            menu.mostrarMenuRelaciones();
            int opcion = menu.leerOpcion();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese la cedula del usuario: ");
                    String cedula = menu.entrada.nextLine();

                    System.out.println("Ingrese el codigo del libro: ");
                    String codigo = menu.entrada.nextLine();

                    if (usuarios.buscar(cedula) != null && libros.buscar(codigo) != null) {
                        grafo.agregarRelacion(cedula, codigo);
                        System.out.println("Relacion agregada con exito");
                    } else {
                        System.out.println("Usuario no encontrado");
                    }
                }
                case 2 -> {
                    System.out.println("Ingrese la cedula del usuario: ");
                    String cedula = menu.entrada.nextLine();

                    System.out.println("Ingrese el codigo del libro: ");
                    String codigo = menu.entrada.nextLine();

                    grafo.eliminarRelacion(cedula, codigo);
                    System.out.println("Relacion eliminada con exito");
                }
                case 3 -> {
                    System.out.println("Lista de relaciones");
                    grafo.listarRelaciones();
                }
                case 4 -> {
                    salir = true;
                }
                default ->
                    System.out.println("Opcion no valida");
            }
        }
    }

}
