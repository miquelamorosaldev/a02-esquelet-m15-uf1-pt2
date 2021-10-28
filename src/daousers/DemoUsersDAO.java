/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daousers;

import adnmanagers.ADN_Manager;

/**
 *
 * @author alumne
 */
public class DemoUsersDAO {
    
    public static void main(String[] args) {
        
        UserManagerDAOInterface usersDAO = new 
                UserManagerDAOMemory();
        
        System.out.println("Test login users. ");
        
        // Usuari que existeix.
        boolean loginPga = usersDAO.login("pga","123456");
        System.out.println(loginPga?"SÍ":"NO");
        
        // Usuari que no existeix.
        boolean loginNew = usersDAO.login("new","1234");
        System.out.println(loginNew?"SÍ":"NO");
        
        // Usuari que existeix però password incorrecte.
        boolean loginMam = usersDAO.login("mam","1234errt");
        System.out.println(loginMam?"SÍ":"NO");
        
        ADN_Manager adnManager = new ADN_Manager();
        System.out.println(adnManager.validarADN("AGAT"));
        System.out.println(adnManager.validarADN("agax"));
    }
    
}
