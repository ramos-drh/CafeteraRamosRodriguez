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

    // Atributos 
    private String nombreUsuario;
    private String contraseniaUsuario;
    Scanner teclado = new Scanner(System.in);
    private static int saldo;

    // Instanciación del nombre y la contraseña de usuarios
    public ZonaAdmin() {
        this.nombreUsuario = "pepito";
        this.contraseniaUsuario = "1daw";
    }

    // Devuelve un boolean según el nombre de usuario y contraseña introducidos son correctos
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

    // Usa método para comprobar el estado de los depósitos
    public void comprobarDepositos() {
        System.out.println("- COMPROBACIÓN DE DEPÓSITOS -");
        System.out.println(Deposito.advertenciaUmbral());
    }

    // Muestra por pantalla el estado de cada parte relevante de la cafetera
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

    // Consulta el saldo total de la cafetera
    public void consultarSaldo() {
        System.out.println(" - CONSULTAR SALDO - ");
        System.out.println("El saldo actual es: " + (saldo / 100.0) + "€");
    }

    // Rellena con el método rellenarCantidad en la clase Depósito
    public void rellenarDepositos() {
        System.out.println(" - RELLENAR DEPOSITOS - ");
        System.out.println("¿Cuál quieres rellenar? (1-5)");
        int seleccion = teclado.nextInt();
        if (seleccion < 0 || seleccion > 6) {
            System.out.println("Selección incorrecta.");
        } else {
            Deposito.rellenarCantidad(seleccion);
        }
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseniaUsuario() {
        return contraseniaUsuario;
    }

    public static int getSaldo() {
        return saldo;
    }

    public static void setSaldo(int saldo) {
        ZonaAdmin.saldo = saldo;
    }
}
