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
    private static int sacarina;
    private static int chocolate;

    public Deposito() {
        cafe = 100;
        leche = 100;
        azucar = 100;
        sacarina = 100;
        chocolate = 100;
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
    
    public static void reducirSacarina(int reduccion){
        sacarina -= reduccion;
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
    
    public static void aumentarSacarina(int aumento){
        sacarina += aumento;
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

    public static int getSacarina() {
        return sacarina;
    }

    public static void setSacarina(int sacarina) {
        Deposito.sacarina = sacarina;
    }

    public static int getChocolate() {
        return chocolate;
    }

    public static void setChocolate(int chocolate) {
        Deposito.chocolate = chocolate;
    }
}
