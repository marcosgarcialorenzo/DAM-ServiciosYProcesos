package RA1.Practica1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClaseHija {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Error: No se indicó el fichero de entrada.");
            System.exit(1);
        }

        String nombreFichero = args[0];
        File fichero = new File(nombreFichero);

        if (!fichero.exists() || !fichero.isFile()) {
            System.err.println("Error: El fichero " + nombreFichero + " no existe.");
            System.exit(2);
        }

        try {
            String contenido = new String(Files.readAllBytes(Paths.get(nombreFichero)));

            String mensajeCifrado = new StringBuilder(contenido).reverse().toString();

            System.out.println(mensajeCifrado);
            System.exit(0);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(3);
        }
    }
}