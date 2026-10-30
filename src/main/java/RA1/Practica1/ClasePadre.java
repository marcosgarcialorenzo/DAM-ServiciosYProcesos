package RA1.Practica1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClasePadre {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java RA1.Practica1.ClasePadre <fichero_entrada> <fichero_respuesta>");
            return;
        }

        String ficheroEntrada = args[0];
        String ficheroRespuesta = args[1];

        try {
            ProcessBuilder pb = new ProcessBuilder("java", "RA1.Practica1.ClaseHija", ficheroEntrada);
            Process procesoHijo = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));
            StringBuilder mensajeCifrado = new StringBuilder();
            String linea;

            while ((linea = reader.readLine()) != null) {
                mensajeCifrado.append(linea).append("\n");
            }

            int codigoSalida = procesoHijo.waitFor();

            if (codigoSalida == 0) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(ficheroRespuesta))) {
                    writer.write(mensajeCifrado.toString().trim());
                }
                System.out.println("Ejecución correcta. Mensaje cifrado guardado en: " + ficheroRespuesta);
            } else {
                System.err.println("El subproceso hijo finalizó con errores. Código: " + codigoSalida);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}