/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteraramosrodriguez;

import java.util.Scanner;

/**
 *
 * @author juan
 */
public class Deposito {
    private static int cafe;
    private static int leche;
    private static int azucar;
    private static int chocolate;
    private static int agua;
    private static final int MAXIMO = 2000;
    private static final int UMBRAL = 400;

    public Deposito() {
    }
    
    public static void inicializarDeposito(){
        cafe = MAXIMO;
        leche = MAXIMO;
        azucar = MAXIMO;
        chocolate = MAXIMO;
        agua = MAXIMO;
    }
    
    public static String advertenciaUmbral(){
        String advertencia = "";
        if (cafe < UMBRAL){
            advertencia+= "\t - Café está a " + Integer.toString(cafe) + "\n";
        }
        if (leche < UMBRAL){
            advertencia+= "\t - Leche está a " + Integer.toString(leche) + "\n";
        }
        if (azucar < UMBRAL){
            advertencia+= "\t - Azúcar está a " + Integer.toString(azucar) + "\n";
        }
        if (chocolate < UMBRAL){
            advertencia+= "\t - Chocolate está a " + Integer.toString(chocolate) + "\n";
        }
        if (agua < UMBRAL){
            advertencia+= "\t - Agua está a " + Integer.toString(agua) + "\n";
        }
        if (advertencia.equals("")){
            advertencia = "Están todos por encima del umbral.";
        }
        return advertencia;
    }
    
    public static void rellenarCantidad (int eleccion){
        Scanner teclado = new Scanner (System.in);
        System.out.println("Presiona 1 para rellenar al completo. Presiona 2 para rellenar parcialmente: ");
        int eleccionRelleno = teclado.nextInt();
        teclado.nextLine();
        
        if (eleccionRelleno == 1){
            switch (eleccion){
                case 1:
                    cafe = MAXIMO;
                    break;
                case 2:
                    leche = MAXIMO;
                    break;
                case 3:
                    azucar = MAXIMO;
                    break;
                case 4:
                    chocolate = MAXIMO;
                    break;
                case 5:
                    agua = MAXIMO;
                    break;
            }
        } else if (eleccionRelleno == 2){
            System.out.println("¿Por cuánto lo quieres rellenar? La capacidad máxima es " + MAXIMO);
            int cantidad = teclado.nextInt();
            teclado.nextLine();
            switch(eleccion){
                case 1:
                    cafe += cantidad;
                    cafe = (cafe>2000) ? 2000 : cafe;
                    break;
                case 2:
                    leche += cantidad;
                    leche = (leche>2000) ? 2000 : leche;
                    break;
                case 3:
                    azucar += cantidad;
                    azucar = (azucar>2000) ? 2000 : azucar;
                    break;
                case 4:
                    chocolate += cantidad;
                    chocolate = (chocolate>2000) ? 2000 : chocolate;
                    break;
                case 5:
                    agua += cantidad;
                    agua = (agua>2000) ? 2000 : agua;
                    break;
            }
        }
    }
    
    public static void reducirCafe(int reduccion){
        cafe -= reduccion;
    }
    
    public static void reducirLeche(int reduccion){
        leche -= reduccion;
    }
    
    public static void reducirAzucar(int reduccion){
        azucar -= reduccion;
    }
    
    public static void reducirChocolate(int reduccion){
        chocolate -= reduccion;
    }
    
    public static void aumentarCafe(int aumento){
        cafe += aumento;
    }
    
    public static void aumentarLeche(int aumento){
        leche += aumento;
    }
    
    public static void aumentarAzucar(int aumento){
        azucar += aumento;
    }
    
    public static void aumentarChocolate(int aumento){
        chocolate += aumento;
    }
    
    public static int getCafe() {
        return cafe;
    }

    public static void setCafe(int cafe) {
        Deposito.cafe = cafe;
    }

    public static int getLeche() {
        return leche;
    }

    public static void setLeche(int leche) {
        Deposito.leche = leche;
    }

    public static int getAzucar() {
        return azucar;
    }

    public static void setAzucar(int azucar) {
        Deposito.azucar = azucar;
    }


    public static int getChocolate() {
        return chocolate;
    }

    public static void setChocolate(int chocolate) {
        Deposito.chocolate = chocolate;
    }

    public static int getAgua() {
        return agua;
    }

    public static void setAgua(int agua) {
        Deposito.agua = agua;
    }

    public static int getUmbral() {
        return UMBRAL;
    }
}
