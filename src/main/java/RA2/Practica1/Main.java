package RA2.Practica1;

public class Main extends Thread {
    public static void main(String[] args) {
        CalculadoraSuma suma = new CalculadoraSuma();
        suma.a = 8;
        suma.b = 3;
        CalculadoraResta resta = new CalculadoraResta();
        resta.a = 8;
        resta.b = 3;
        resta.start(); //esto son hilos, esto ejecuta el metodo run
        suma.start();
    }
}