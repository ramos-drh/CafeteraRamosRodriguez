/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteraramosrodriguez;

/**
 *
 * @author Usuario
 */
public class Deposito {
    Producto [] catalogo;

    public Deposito() {
        this.catalogo = new Producto[6];
        catalogo[0].setNombre("Café solo");
        catalogo[0].setPrecio(0.80);
        catalogo[1].setNombre("Solo largo");
        catalogo[1].setPrecio(0.90);
        catalogo[2].setNombre("Con leche");
        catalogo[2].setPrecio(1.10);
        catalogo[3].setNombre("Cortado");
        catalogo[3].setPrecio(1.0);
        catalogo[4].setNombre("Chocolate");
        catalogo[4].setPrecio(1.40);
        catalogo[5].setNombre("Leche fría o caliente");
        catalogo[5].setPrecio(0.50);
    }
    
    
}
