/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author User
 */
@Local
public interface commonInterfaceBeanLocal {
    public boolean employeeLogin(String username, String password);
    
    public String findEmployee(String nric);
    
    public int createAccount (Long employeeID, String username, String password);
    
    public int updatePassword (Long employeeID, String oldPassword, String newPassword, String confirmPassword);
    
    List<String> listAccessibleSystems(Long employeeID);
}
