package base.de.datos.alumnos;

import base.de.datos.alumnos.Estudiante;
import java.util.Scanner;

public class BaseDeDatosAlumnos {

    public static void main(String[] args) {
        //creando arreglo de estudiantes
        Estudiante datos[] = new Estudiante[10];
        int opciones = 0;
        Scanner batman = new Scanner(System.in);
        Scanner letras = new Scanner(System.in);
        while (opciones != 5) {
            System.out.println("1. Nuevo alumno");
            System.out.println("2. Ver alumno");
            System.out.println("3. Buscar alumno");
            System.out.println("4. Modificar alumno");
            System.out.println("5. Salir");
            System.out.println("Ingrese el numero de opcion: ");
            opciones = batman.nextInt();
            System.out.println("--------------------------");
            if (opciones == 1) {

                System.out.println("Ingrese clave");
                int clave = batman.nextInt();
                System.out.println("Ingrese el nombre");
                String nombre = letras.nextLine();
                System.out.println("Ingrese el grado");
                String grado = letras.nextLine();

                System.out.println(nuevoAlumno(clave, nombre, grado, datos));
            } else if (opciones == 2) {
                System.out.println(imprimirTodo(datos));
            } else if (opciones == 3) {

                System.out.println("Ingrese clave");
                int clave = batman.nextInt();
                System.out.println(buscarAlumno(clave, datos));
            } else if (opciones == 4) {
                System.out.println("Ingrese clave");
                int clave = batman.nextInt();
                if (buscarAlumnoBooleano(clave, datos)) {
                    System.out.println("Ingrese el nombre");
                    String nombre = letras.nextLine();
                    System.out.println("Ingrese el nuevo grado");
                    String grado = letras.nextLine();
                    System.out.println(modificarDatos(clave, nombre, grado, datos));

                } else {
                    System.out.println("No existe la clave");

                }

            }
        }
    }

    public static String nuevoAlumno(int clave, String nombre, String grado, Estudiante arreglo[]) {
        boolean lleno = true;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == null) {
                arreglo[i] = new Estudiante(clave, nombre, grado);
                lleno = false;
                break;

            } else if (arreglo[i].getClave() == clave) {
                return "Ya existe la clave";
            }

        }
        if (!lleno) {
            return "Se guardo con exito";
        } else {
            return "Ya no hay espacio";
        }
    }

    public static String imprimirTodo(Estudiante arreglo[]) {
        String cadena = "";
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                cadena = cadena + arreglo[i].getClave() + " | " + arreglo[i].getNombre() + " | " + arreglo[i].getGrado() + "\n";

            }

        }
        return cadena;
    }

    public static String buscarAlumno(int clave, Estudiante arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getClave() == clave) {
                return "Los datos son \n nombre: " + arreglo[i].getNombre() + " grado: " + arreglo[i].getGrado();
            }
        }
        return "No existe la clave ingresada";
    }

    public static boolean buscarAlumnoBooleano(int clave, Estudiante arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getClave() == clave) {
                return true;
            }
        }
        return false;
    }

    public static String modificarDatos(int clave, String nombre, String grado, Estudiante arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getClave() == clave) {
                arreglo[i].setNombre(nombre);
                arreglo[i].setGrado(grado);
                return "Se actualizó con exito";
            }
        }
        return "";
    }
}
