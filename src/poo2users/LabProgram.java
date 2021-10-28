package poo2users;

import daousers.UserManagerDAOInterface;
import daousers.UserManagerDAOMemory;
import java.util.Scanner;

/**
 *Volem crear un programa per consola que llegeixi 
 * la llista d’usuaris d’un sistema 
 * (login i password) per fitxer (pot ser text pla, JSON o CSV) i 
 * un cop l’usuari ha introduït les seves credencials correctament 
 * podrà realitzar operacions sobre cadenes d’ADN.
Es valorarà positivament que les credencials del fitxer estiguin encriptades. 
* 
Un cop l’usuari ha accedit al sistema, podrà realitzar les següents operacions en una cadena ADN o ARN:
- Donar la volta a una cadena ADN. (retorn String) (*3)
- Trobar la base més repetida. (retorn caràcter)
- Trobar la base menys repetida. (retorn caràcter)
- Fer recompte de bases i mostrar-lo. (1*)
- Convertir un ADN a ARN (2*)
- Convertir un ARN a ADN (2*)
- Sortir.
Segons l'opció escollida podrem visualitzar un o altre resultat, o bé, sortir de l'aplicació.

Atenció! Si la cadena d’ADN no és vàlida (té almenys 1 
* caràcter que no és vàlid), s’informarà a l’usuari.
Recomanable usar un mètode apart per a fer aquesta validació.

 * @author alumne
 */
public class LabProgram {
    
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        // UserList labUsers = new UserList();
         UserManagerDAOInterface usersDAO = new 
                UserManagerDAOMemory();
         
        // 1. Read username and the password from the console.
        System.out.println("Enter username ");    
        String username = sc.nextLine();
        System.out.println("Enter password ");  
        String password = sc.nextLine();
        
        // 2. Try to login.
        boolean loginOK = usersDAO.login(username, password);
        if(loginOK) {
            System.out.println("Login correct. Welcome!");
        // 2a. If the username and the password are correct.
        // Program ADNManager starts.
        
        // 2b. If the username and the password are not in system, exit.
        } else {
            System.out.println("You are not in database. Bye!");
        }
        
    }
}
