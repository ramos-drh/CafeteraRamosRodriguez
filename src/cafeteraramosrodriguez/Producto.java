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
public enum Producto {

    // Los productos disponibles
    CAFE_SOLO(80, "Café solo", 100, 0, 0, 0, 50, 1),
    SOLO_LARGO(90, "Solo largo", 100, 0, 0, 0, 60, 2),
    CON_LECHE(110, "Con leche", 70, 50, 0, 0, 30, 3),
    CORTADO(100, "Cortado", 70, 20, 0, 0, 50, 4),
    CHOCOLATE(140, "Chocolate", 0, 40, 0, 60, 40, 5),
    LECHE(50, "Leche caliente o fría", 0, 50, 0, 0, 80, 6);

    // Sus atributos
    private int precio;
    private String nombre;
    private int cafeUsado;
    private int lecheUsado;
    private int azucarUsado;
    private int chocolateUsado;
    private int aguaUsada;
    private int codigo;     

    // Constructor
    private Producto(int precio, String nombre, int cafeUsado, int lecheUsado, int azucarUsado, int chocolateUsado, int aguaUsada, int codigo) {
        this.precio = precio;
        this.nombre = nombre;
        this.cafeUsado = cafeUsado;
        this.lecheUsado = lecheUsado;
        this.azucarUsado = azucarUsado;
        this.chocolateUsado = chocolateUsado;
        this.aguaUsada = aguaUsada;
        this.codigo = codigo;
    }

    // Getter y setter
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCafeUsado() {
        return cafeUsado;
    }

    public void setCafeUsado(int cafeUsado) {
        this.cafeUsado = cafeUsado;
    }

    public int getLecheUsado() {
        return lecheUsado;
    }

    public void setLecheUsado(int lecheUsado) {
        this.lecheUsado = lecheUsado;
    }

    public int getAzucarUsado() {
        return azucarUsado;
    }

    public void setAzucarUsado(int azucarUsado) {
        this.azucarUsado = azucarUsado;
    }

    public int getChocolateUsado() {
        return chocolateUsado;
    }

    public void setChocolateUsado(int chocolateUsado) {
        this.chocolateUsado = chocolateUsado;
    }

    public int getAguaUsada() {
        return aguaUsada;
    }

    public void setAguaUsada(int aguaUsada) {
        this.aguaUsada = aguaUsada;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    // Devuelve el producto correspondiente según el código introducido
    public static Producto productoDelCodigo(int codigo){
        
        //El código está seguro entre 1-6 porque se comprueba antes de llamar al método
        switch(codigo){
            case 1:
                return Producto.CAFE_SOLO;
            case 2:
                return Producto.SOLO_LARGO;
            case 3:
                return Producto.CON_LECHE;
            case 4:
                return Producto.CORTADO;
            case 5:
                return Producto.CHOCOLATE;
            case 6:
                return Producto.LECHE;
            default:
                return Producto.LECHE;
        }
    }

    // Método toString para devolver el producto y sus atributos relevantes como String
    @Override
    public String toString() {
        return "Código: " + this.getCodigo() + " \tNombre:" + this.getNombre() + " \tPrecio: " + (this.getPrecio()/100.0) + "€";
    }
}
