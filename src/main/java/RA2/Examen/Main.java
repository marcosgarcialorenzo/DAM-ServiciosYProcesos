package RA2.Examen;

public class Main {
    public static void main(String[] args) {
        Cruce cruce = new Cruce();
        
        Vehiculo vehiculo1 = new Vehiculo("Vehiculo-1",1,cruce);
        Vehiculo vehiculo2 = new Vehiculo("Vehiculo-2",2,cruce);
        Vehiculo vehiculo3 = new Vehiculo("Vehiculo-3",1,cruce);
        Vehiculo vehiculo4 = new Vehiculo("Vehiculo-4",2,cruce);
        Ambulancia ambulancia1 = new Ambulancia("Ambulancia-1",cruce);
        ambulancia1.setPriority(Thread.MAX_PRIORITY);    // 10

        vehiculo1.start();
        vehiculo2.start();
        vehiculo3.start();
        vehiculo4.start();
        ambulancia1.start();
    }
}