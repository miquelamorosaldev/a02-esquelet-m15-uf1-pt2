package poo2users;

import java.util.Scanner;

/**
 *
 * Ens han demanat crear un programa mitjançant la consola de Java que gestionarà l’accés als usuaris d’un laboratori.
 * El programa demanarà per consola el nom d’usuari i la contrassenya (que tindrem guardats prèviament), si són correctes; s’accedirà a un menú on l’usuari registrat podrà:
 * Veure la seva informació d’usuari.
	Només si és admin, podrà crear un nou usuari.
	Fer logout (tancar la sessió)
	Tancar el programa.
Al fer logout, tornarem al punt inicial, on el programa demana les credencials de l’usuari.
Si el nom d’usuari o contrassenya són incorrectes; es mostrarà un missatge d’error i es tancarà el programa.  
 * @author alumne
 */
public class LabProgram {
    
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        UserList labUsers = new UserList();
    
        // 1. Read username and the password from the console.
        System.out.println("Enter username ");    
        String username = sc.nextLine();
        System.out.println("Enter password ");  
        String password = sc.nextLine();
        
        // 2. Try to login.
        boolean loginOK = labUsers.loginUser(username, password);
        if(loginOK) {
            System.out.println("Login correct. Welcome!");
        // 2a. If the username and the password are correct.
        // Check if the user is admin or not.
        
        // 2b. If the username and the password are not in system, exit.
        } else {
            System.out.println("You are not in database. Bye!");
        }
        
    }
}
