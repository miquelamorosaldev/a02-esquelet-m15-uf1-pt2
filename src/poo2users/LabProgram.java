package poo2users;

import adnmanagers.ADN_Manager;
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
    
     public static final String[] MENU_ADN = {
        "Sortir",
        "Donar la volta a una cadena de ADN ",
        "Trobar la base més repetida",
        "Trobar la base menys repetida",
        "Fer recompte de bases i mostrarles.",
        "Convertir ARN a ADN.",
        "Convertir ARN a ADN"
     };
     public static final String ERROR_ADN_INCORRECTE = 
             "Error! La cadena ADN introduïda té un format vàlid";
    
    public static UserManagerDAOInterface usersDAO;
    public static ADN_Manager ADNManager;
    
    public static void main(String[] args) {
        
        // UserList labUsers = new UserList();
         usersDAO = new 
                UserManagerDAOMemory();
         ADNManager = new 
                ADN_Manager();
         
        Scanner scanner = new Scanner(System.in);
         
        // 1. Read username and the password from the console.
        System.out.println("Enter username ");    
        String username = scanner.nextLine();
        System.out.println("Enter password ");  
        String password = scanner.nextLine();
        
        // 2. Try to login.
        boolean loginOK = usersDAO.login(username, password);
        if(loginOK) {
            System.out.println("Login correct. Welcome to ADNManager!");
        // 2a. If the username and the password are correct.
        // Program ADNManager starts.
        int option = 1;
        while (option != 0) {
                showMenu();
                option = scanner.nextInt();
                // Es necessari ficar un nextLine després d'un nextInt.
                scanner.nextLine();
                
                System.out.println("Introdueix una cadena d'ADN o ARN per operar.");
                String cadenaADN = scanner.nextLine();
                switch (option) {
                    case 0: // Exit
                      System.out.println(
                          "Gràcies per usar la aplicació ADNManager. ");
                    case 1: // Donar la volta a una cadena de ADN 
                        System.out.println(ADNManager.invertADN(cadenaADN));
                        break;
                    case 2: // Trobar la base més repetida
                        // cadenaADN = askAndValidateADN();
                        if(!cadenaADN.equals(ERROR_ADN_INCORRECTE))
                            System.out.println(ADNManager.baseADNMesRepetida(cadenaADN));
                        break;
                    default: 
                        System.out.println(
                          "La opció triada no està disponible");
                }
            }
        // 2b. If the username and the password are not in system, exit.
        } else {
            System.out.println("You are not in database. Bye!");
        }
        
    }
    
    /**
      * Method to read a menu
      */
     private static void showMenu() {
        System.out.println("Selecciona una opció del menú");  
        for (int i = 0; i < MENU_ADN.length; i++) {
            System.out.println(i + " - " + MENU_ADN[i]);
        }
     }
     
     private static String askAndValidateADN(Scanner sc) {
        System.out.println("Introdueix una cadena d'ADN vàlida.");  
        String ADN = sc.nextLine();
        System.out.println("Gràcies. Calculant ... " + ADN);
        if(ADNManager.validarADN(ADN)) {
            return ADN;
        } 
        System.out.println(ERROR_ADN_INCORRECTE);
        return ERROR_ADN_INCORRECTE;
     }
}
