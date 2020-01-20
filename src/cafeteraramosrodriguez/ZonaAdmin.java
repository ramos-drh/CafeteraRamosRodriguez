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
    
    public ZonaAdmin(){
        this.nombreUsuario = "pepito";
        this.contraseniaUsuario = "1daw";
    }
    
    public boolean loggear(){
        System.out.println("¿Cuál es el nombre de usuario?");
        String nombre = teclado.nextLine();
        System.out.println("¿Y la contrasenia?");
        String contrasenia = teclado.nextLine();
        if (nombre.equals(this.nombreUsuario) && contrasenia.equals(this.contraseniaUsuario)){
            return true;
        } else return false;
    }
    
    public void comprobarDepositos(){
        
    }
}
