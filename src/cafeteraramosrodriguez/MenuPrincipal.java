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
        boolean volverMenuPrincipal = false;    //Para volver al menú principal
        boolean volverMenuVenta;
        int codigoSeleccionado, anadirCantidad;              //Selección del producto; selección aumentar saldo
        do {
            System.out.println("Introduzca dinero (céntimos) para poder operar.");
            zonaCli.setSaldoCliente(teclado.nextInt());
            //Lectura adelantada para poder poner un sout diferente en cada iteración del bucle,
            //informando del saldo actual
            while (zonaCli.getSaldoCliente() < Producto.LECHE.getPrecio()) {
                System.out.println("Se necesitan mínimo 50 céntimos para poder operar.\n"
                        + "Saldo actual: " + zonaCli.saldoEuros() + "€"
                        + "\nPor favor, introduzca más:");
                zonaCli.setSaldoCliente(zonaCli.getSaldoCliente() + teclado.nextInt());
            }
            //Habría que cambiar la condición de salida si se introduce un producto más barato que la leche
            do {
                //Mostramos los productos, sus precios y sus códigos MEJORAR ESTILO OUTPUT
                //Leemos hasta que el código introducido sea válido (1-6)
                System.out.println("- MENÚ DE VENTA -");
                do {
                    volverMenuVenta = false;
                    System.out.println(Producto.CAFE_SOLO.toString() + "\n"
                            + Producto.SOLO_LARGO.toString() + "\n"
                            + Producto.CON_LECHE.toString() + "\n"
                            + Producto.CORTADO.toString() + "\n"
                            + Producto.CHOCOLATE.toString() + "\n"
                            + Producto.LECHE.toString());
                    System.out.println("Introduzca uno de los códigos: ");
                    codigoSeleccionado = teclado.nextInt();
                    if (codigoSeleccionado < 1 || codigoSeleccionado > 6) {
                        System.out.println("Código incorrecto. Inténtelo de nuevo");
                    }
                } while (codigoSeleccionado < 1 || codigoSeleccionado > 6);

                //Entra si no tiene saldo suficiente
                if (zonaCli.getSaldoCliente() < Producto.productoDelCodigo(codigoSeleccionado).getPrecio()) {
                    //Avisa y pregunta si quiere introducir + dinero O Volver a Menu Venta
                    do {
                        //Se repite mientras el saldo siga siendo insuficiente & no pulse volver menú ventas
                        System.out.println("El saldo actual (" + zonaCli.saldoEuros() + "€) no es suficiente para el del producto seleccionado (" + (Producto.productoDelCodigo(codigoSeleccionado).getPrecio() / 100.0) + "€)\n"
                                + "Pulse 0 si desea volver al menú de ventas o \n"
                                + "Introduzca la cantidad a añadir en céntimos (mayor a 0) para el producto seleccionado:");
                        anadirCantidad = teclado.nextInt();
                        if (anadirCantidad > 0) {
                            zonaCli.setSaldoCliente(zonaCli.getSaldoCliente() + anadirCantidad);
                        } else if (anadirCantidad == 0) {
                            volverMenuVenta = true;
                        }
                    } while (!volverMenuVenta && !(zonaCli.getSaldoCliente() >= Producto.productoDelCodigo(codigoSeleccionado).getPrecio()));

                    //Entra aquí cuando el saldo sea suficiene para comprar el prod seleccionado
                    //Y NO haya cantidades suficientes en los DEPÓSITOS
                }
                if (!Deposito.depositosSuficientes(codigoSeleccionado)) {
                    //Si no hay ingredientes suficientes, vuelve al Menú Ventas
                    System.out.println("Lo sentimos, no hay suficientes ingredientes. Volverá al menú de ventas y podrá elegir otro producto.");
                    volverMenuVenta = true;
                    //Entra si hay producto suficiente =>                
                } else if(!volverMenuVenta){
                    zonaCli.setSaldoCliente(zonaCli.getSaldoCliente() - Producto.productoDelCodigo(codigoSeleccionado).getPrecio());
                    int azucarServida;
                    //Pregunta cant azucar y Sirve la bebida (actualizar prod y guardar importe)
                    System.out.println("¿Cuánta azúcar quiere?: \n"
                            + "0: Ninguna\n"
                            + "1: Poca (10 céntimos)\n"
                            + "2: Mucha (20 céntimos)");
                    azucarServida = teclado.nextInt();
                    boolean repetir = true;
                    if (azucarServida > 2 || azucarServida < 0) {
                        azucarServida = 0;
                    }
                    while (zonaCli.getSaldoCliente() < (azucarServida * 10) && repetir) {
                        System.out.println("Requiere " + (((azucarServida * 10) - zonaCli.getSaldoCliente()) / 100.0) + "€ más para la compra. Introduzca la diferencia (en céntimos)"
                                + ", o 0 para cancelar el azúcar:");
                        int ingreso = teclado.nextInt();
                        zonaCli.setSaldoCliente(zonaCli.getSaldoCliente() + ingreso);
                        if (ingreso == 0) {
                            repetir = false;
                        } else if (azucarServida - zonaCli.getSaldoCliente() <= ingreso) {
                            repetir = false;
                            zonaCli.setSaldoCliente(zonaCli.getSaldoCliente() - (azucarServida * 10));
                            ZonaAdmin.setSaldo(ZonaAdmin.getSaldo() + azucarServida * 10);
                        }
                    }
                    Deposito.reducirAzucar(azucarServida * 10);
                    Deposito.reducirDepositos(codigoSeleccionado);
                    volverMenuPrincipal = true;
                    System.out.println("Gracias por su pedido.");
                }
            } while (volverMenuVenta);
        } while (!volverMenuPrincipal);
        if (zonaCli.getSaldoCliente() > 0) {
            System.out.println("Se le devolverá " + zonaCli.saldoEuros() + "€");
            zonaCli.setSaldoCliente(0);
        }
        ZonaAdmin.setSaldo(ZonaAdmin.getSaldo() + Producto.productoDelCodigo(codigoSeleccionado).getPrecio());
    }

    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();

        menu.ejecucion();
    }
}
