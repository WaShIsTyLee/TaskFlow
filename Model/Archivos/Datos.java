package Model.Archivos;

import IO.Teclado;
import Model.Entitys.Usuario;
import Model.Proyectos.Proyectos;
import Model.Repository.RepoProjectos;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Datos {

    public static void guardarEnArchivo(String nombre, String nombreUsuario, String correo, String contraseña, String usuariosRegistrados) {

        if (usuarioRegistrado(nombreUsuario, correo, usuariosRegistrados)) {
            System.out.println("El nombre de usuario o el correo ya están registrados.");

        } else {
            try (FileWriter writer = new FileWriter(usuariosRegistrados, true)) {
                writer.write(nombre + "," + nombreUsuario + "," + contraseña + "," + correo + "\n");
                System.out.println("Usuario registrado correctamente.");

            } catch (IOException e) {
                System.out.println("Error al guardar usuario en el archivo: " + e.getMessage());
            }
        }

    }

    private static boolean usuarioRegistrado(String nombreUsuario, String correo, String usuariosRegistrados) {
        boolean usuarioRegistrado = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(usuariosRegistrados))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[1].equals(nombreUsuario) || datos[3].equals(correo)) {
                    usuarioRegistrado = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return usuarioRegistrado;
    }

    public static boolean verificarCredenciales(String usuariosRegistrados, String nombreUsuario, String contraseña) {
        boolean credencialesValidas = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(usuariosRegistrados))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 3) {
                    String usuarioRegistrado = partes[1].trim();
                    String contraseñaRegistrada = partes[2].trim();
                    if (usuarioRegistrado.equals(nombreUsuario) && contraseñaRegistrada.equals(contraseña)) {
                        credencialesValidas = true;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return credencialesValidas;
    }

    public static String obtenerUltimoUsuario(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            String ultimoUsuario = null;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                ultimoUsuario = partes[1];
            }

            return ultimoUsuario;
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

    public static void listarUsuarios(String usuariosRegistrados) {

        try (BufferedReader reader = new BufferedReader(new FileReader(usuariosRegistrados))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");

                Teclado.imprimirCadena("-----------Usuario-----------");
                Teclado.imprimirCadena("Nombre: "+partes[0].trim());
                Teclado.imprimirCadena("Usuario: "+partes[1].trim());
                Teclado.imprimirCadena("-----------------------------");


            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }


    public static void listarProjectos(ArrayList<Proyectos> projectos) {

        for (Proyectos proyecto : projectos) {
            System.out.println(projectos);
        }


    }

    public static void listarProyectoporNombre(ArrayList <Proyectos>proyectos) {
        String a;
        do {
            a=Teclado.leeString("meta el nombre a buscar");
            for (Proyectos projecto : proyectos) {
                if (projecto.equals(a)) {
                    System.out.println(projecto);
                } else {
                    System.out.println("no existe ningun pryecto con ese nombre");
                }
            }
        }while (!a.equalsIgnoreCase("salir"));
    }

}