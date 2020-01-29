/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteraramosrodriguez;

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
    private static int umbral;

    public Deposito() {
    }
    
    public static void inicializarDeposito(){
        cafe = 2000;
        leche = 2000;
        azucar = 2000;
        chocolate = 2000;
        agua = 2000;
        umbral = 400;
    }
    
    public static String advertenciaUmbral(){
        String advertencia = "";
        if (cafe < umbral){
            advertencia+= "\t - Café está a " + Integer.toString(cafe) + "\n";
        }
        if (leche < umbral){
            advertencia+= "\t - Leche está a " + Integer.toString(leche) + "\n";
        }
        if (azucar < umbral){
            advertencia+= "\t - Azúcar está a " + Integer.toString(azucar) + "\n";
        }
        if (chocolate < umbral){
            advertencia+= "\t - Chocolate está a " + Integer.toString(chocolate) + "\n";
        }
        if (agua < umbral){
            advertencia+= "\t - Agua está a " + Integer.toString(agua) + "\n";
        }
        if (advertencia.equals("")){
            advertencia = "Están todos por encima del umbral.";
        }
        return advertencia;
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
}
