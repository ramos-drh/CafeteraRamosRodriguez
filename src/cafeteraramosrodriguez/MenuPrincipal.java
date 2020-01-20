/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteraramosrodriguez;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class MenuPrincipal {
    
    ZonaAdmin zonaAdministrador;
    
    public MenuPrincipal(){
        this.zonaAdministrador = new ZonaAdmin();
    }

    public void ejecucion() {
       
        Scanner teclado = new Scanner(System.in);
        do {
            boolean repetir = true;
            System.out.println("Bienvenido a la cafetera. Presione 1 para zona administrador, o 2"
                    + "para zona de comprador.");
            do {
                int eleccion = teclado.nextInt();
                teclado.nextLine();
                if (eleccion == 1) {
                    this.admin();
                    repetir = false;
                } else if (eleccion == 2) {
                    this.comprador();
                    repetir = false;
                } else {
                    System.out.println("Has elegido un número incorrecto. Inténtelo de nuevo."
                            + "\nPresione 1 para zona administrador, o 2 para zona de comprador.");
                }
            } while (repetir);
        } while (true);

    }

    public void admin() {
        Scanner teclado = new Scanner(System.in);
        if (!this.zonaAdministrador.loggear()) {
            System.out.println("El logging ha fallado. Volviendo al menú principal.");
        } else {
            boolean repetir = false;
            do {
                System.out.println("¿Qué deseas hacer? :"
                        + "\n\t1. Comprobar depósitos"
                        + "\n\t2. Comprobar estado general"
                        + "\n\t3. Consultar saldo de ventas realizadas"
                        + "\n\t4. Rellenar depósitos");
                int seleccion = teclado.nextInt();
                switch (seleccion) {
                    case 1:
                        zonaAdministrador.comprobarDepositos();
                        break;
                    case 2:
                        zonaAdministrador.comprobarEstadoGeneral();
                        break;
                    case 3:
                        zonaAdministrador.consultarSaldo();
                        break;
                    case 4:
                        zonaAdministrador.rellenarDepositos();
                        break;
                    default:
                        System.out.println("Número incorrecto.");
                        break;
                }
                System.out.println("¿Quieres realizar otra acción? 1 = sí, 2 = no");
                int repetirSeleccion = teclado.nextInt();
                switch (repetirSeleccion) {
                    case 1:
                        repetir = true;
                        break;
                    case 2:
                        repetir = false;
                        break;
                    default:
                        System.out.println("Número incorrecto. Volverá al menú administrador.");
                        repetir = true;
                }

            } while (repetir);
        }
    }

    public void comprador() {

    }

    public static void main(String[] args) {
        MenuPrincipal.ejecucion();
    }
}
