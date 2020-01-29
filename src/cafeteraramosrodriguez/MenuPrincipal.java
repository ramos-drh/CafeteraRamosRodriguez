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
    ZonaCliente zonaCli;

    public MenuPrincipal() {
        this.zonaAdministrador = new ZonaAdmin();
        this.zonaCli = new ZonaCliente();
        Deposito.inicializarDeposito();
    }

    public void ejecucion() {
        Scanner teclado = new Scanner(System.in);
        do {
            boolean repetir = true;
            System.out.println("Bienvenido a la cafetera. Presione 1 para zona administrador, o 2"
                    + " para zona de comprador.");
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
        //Primero solicitará dinero para poder empezar;
        //Sigue pidiendo hasta alcanzar como mínimo el precio del producto + barato
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduzca dinero (céntimos) para poder operar.");
        zonaCli.setSaldoCliente(zonaCli.getSaldoCliente() + teclado.nextInt());
        //Lectura adelantada para poder poner un sout diferente en cada iteración del bucle,
        //informando del saldo actual

        while(zonaCli.getSaldoCliente() < Producto.LECHE.getPrecio()){
            System.out.println("Introduzca mínimo 50 céntimos para poder operar.\n"
                    + "Saldo actual: " + zonaCli.getSaldoCliente());
            zonaCli.setSaldoCliente(zonaCli.getSaldoCliente() + teclado.nextInt());
        }
        //Habría que cambiar la condición de salida si se introduce un producto más barato que la leche
        
        //Mostramos los productos, sus precios y sus códigos MEJORAR ESTILO OUTPUT
        System.out.println("- MENÚ DE VENTA -");
        System.out.println
                ("Código: " + Producto.CAFE_SOLO.getCodigo()+ " " + Producto.CAFE_SOLO.getNombre() + " Precio: " + Producto.CAFE_SOLO.getPrecio() + " céntimos\n"
                + "Código: " + Producto.CHOCOLATE.getCodigo() + " " + Producto.CHOCOLATE.getNombre() + " Precio: " + Producto.CHOCOLATE.getPrecio() + " céntimos\n"
                + "Código: " + Producto.CON_LECHE.getCodigo() + " " + Producto.CON_LECHE.getNombre() + " Precio: " + Producto.CON_LECHE.getPrecio() + " céntimos\n"
                + "Código: " + Producto.CORTADO.getCodigo() + " " +  Producto.CORTADO.getNombre() + " Precio: " + Producto.CORTADO.getPrecio() + " céntimos\n"
                + "Código: " + Producto.LECHE.getCodigo() + " " +  Producto.LECHE.getNombre() + " Precio: " + Producto.LECHE.getPrecio() + " céntimos\n"
                + "Código: " + Producto.SOLO_LARGO.getCodigo() + " " +  Producto.SOLO_LARGO.getNombre() + " Precio: " + Producto.SOLO_LARGO.getPrecio() + "céntimos");
        /*- Modificación del main
        - Instanciación zonaCliente
        - comprador(): Pedir saldo mínimo y mostrar menú productos*/
    }

    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        
        menu.ejecucion();
    }
}
