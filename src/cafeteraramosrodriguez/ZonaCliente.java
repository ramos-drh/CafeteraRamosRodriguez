/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteraramosrodriguez;

/**
 *
 * @author ramos
 */
public class ZonaCliente {
    // Guarda el saldo durante esa compra del usuario
    private int saldoCliente;
    
    public ZonaCliente() {
        saldoCliente = 0;
    }

    public int getSaldoCliente() {
        return saldoCliente;
    }

    public void setSaldoCliente(int saldoCliente) {
        this.saldoCliente = saldoCliente;
    }
    
    // Devuelve el saldo en double (euros)
    public double saldoEuros(){
        return saldoCliente / 100.0;
    }

}
