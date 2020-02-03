/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteraramosrodriguez;

import java.util.Scanner;

/**
 *
 * @author david
 */
public class ZonaAdmin {

    private String nombreUsuario;
    private String contraseniaUsuario;
    Scanner teclado = new Scanner(System.in);
    private static int saldo;

    public ZonaAdmin() {
        this.nombreUsuario = "pepito";
        this.contraseniaUsuario = "1daw";
    }

    public boolean loggear() {
        System.out.println("¿Cuál es el nombre de usuario?");
        String nombre = teclado.nextLine();
        System.out.println("¿Y la contrasenia?");
        String contrasenia = teclado.nextLine();
        if (nombre.equals(this.nombreUsuario) && contrasenia.equals(this.contraseniaUsuario)) {
            return true;
        } else {
            return false;
        }
    }

    public void comprobarDepositos() {
        System.out.println("- COMPROBACIÓN DE DEPÓSITOS -");
        System.out.println(Deposito.advertenciaUmbral());
    }

    public void comprobarEstadoGeneral() {
        System.out.println(" - COMPROBAR ESTADO GENERAL - ");
        System.out.println("Nombre de usuario: " + this.nombreUsuario);
        System.out.println("Contraseña: " + this.contraseniaUsuario);
        System.out.println("Cantidad de café: " + Deposito.getCafe());
        System.out.println("Cantidad de leche: " + Deposito.getLeche());
        System.out.println("Cantidad de azúcar: " + Deposito.getAzucar());
        System.out.println("Cantidad de chocolate: " + Deposito.getChocolate());
        System.out.println("Cantidad de agua: " + Deposito.getAgua());
    }

    public void consultarSaldo() {
        System.out.println(" - CONSULTAR SALDO - ");
        System.out.println("El saldo actual es: " + (saldo/100.0) + "€");
    }

    public void rellenarDepositos() {
        System.out.println(" - RELLENAR DEPOSITOS - ");
        boolean repetir = true;
        do {
            System.out.println("¿Cuál quieres rellenar?"
                    + " 1. Café"
                    + " 2. Leche"
                    + " 3. Azúcar"
                    + " 4. Chocolate"
                    + " 5. Agua");
            int eleccion = teclado.nextInt();
            teclado.nextLine();
            
            switch (eleccion){
                case 1:
                    Deposito.setCafe(Deposito.getMaximo());
                    break;
                case 2:
                    Deposito.setLeche(Deposito.getMaximo());
                    break;
                case 3:
                    Deposito.setAzucar(Deposito.getMaximo());
                    break;
                case 4:
                    Deposito.setChocolate(Deposito.getMaximo());
                    break;
                case 5:
                    Deposito.setAgua(Deposito.getMaximo());
                    break;
                default:
                    System.out.println("Número fuera del rango.");
            }
            System.out.println("Presiona 1 para salir. Presiona 2 para rellenar otro depósito.");
            int salir = teclado.nextInt();
            if (salir == 1){
                repetir = false;
            }
        } while (repetir);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseniaUsuario() {
        return contraseniaUsuario;
    }

    public void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }

    public static int getSaldo() {
        return saldo;
    }

    public static void setSaldo(int saldo) {
        ZonaAdmin.saldo = saldo;
    }
}
