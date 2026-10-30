package RA2.Practica2;

public class Carrera {

    public static void main(String[] args) {
        final int NUM_CARACOLES = 5; //para decir el maximo de caracoles que van a participar en la carrera
        String[] nombres = { // Lista de nombres para los caracoles
                "Antonio", "María", "José", "Carmen", "Manuel", "Ana", "Francisco", "Laura", "David", "Marta",
                "Javier", "Lucía", "Daniel", "Paula", "Carlos", "Elena", "Miguel", "Sara", "Rafael", "Isabel",
                "Pedro", "Cristina", "Ángel", "Patricia", "Alejandro", "Raquel", "Fernando", "Beatriz", "Sergio", "Pilar",
                "Pablo", "Rosa", "Jorge", "Julia", "Alberto", "Teresa", "Luis", "Andrea", "Álvaro", "Sofía",
                "Adrián", "Natalia", "Diego", "Irene", "Rubén", "Alba", "Iván", "Silvia", "Raúl", "Noelia",
                "Óscar", "Claudia", "Hugo", "Eva", "Mario", "Nuria", "Víctor", "Rocío", "Enrique", "Inés",
                "Jesús", "Mónica", "Andrés", "Lorena", "Ramón", "Sonia", "Ignacio", "Verónica", "Guillermo", "Lidia",
                "Marcos", "Ainhoa", "Tomás", "Celia", "Gonzalo", "Marina", "Samuel", "Yolanda", "Bruno", "Olga",
                "Nicolás", "Esther", "Joaquín", "Alicia", "Emilio", "Carla", "Héctor", "Gloria", "Lucas", "Lola",
                "Ismael", "Rebeca", "Eduardo", "Amparo", "Félix", "Mercedes", "Gabriel", "Dolores", "Martín", "Valeria", "Jarvy Sanchez Niño"
        };
        Caracol[] caracoles = new Caracol[NUM_CARACOLES]; //un array de caracoles para almacenas a los Caracol que van a participar en la carrera
        System.out.println("¡Comienza la carrera de caracoles!\n");
        for (int i = 0; i < NUM_CARACOLES; i++) { // crear a los caraloes y asignarles un nombre único
            int nombreIndex = (int) (Math.random() * nombres.length);
            String nombre = nombres[nombreIndex];
            caracoles[i] = new Caracol(nombre);
        }
        for (Caracol c : caracoles) {
            c.start();
        }
        // La carrera espera a que terminen todos los hilos
        for (Caracol c : caracoles) {
            try {
                c.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n¡La carrera ha terminado!");
    }
}