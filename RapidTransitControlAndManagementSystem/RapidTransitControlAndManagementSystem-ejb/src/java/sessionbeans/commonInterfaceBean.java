/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Employee;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class commonInterfaceBean implements commonInterfaceBeanLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override //HASH NEEDED
    public boolean employeeLogin(String username, String password){
        Employee employee = em.find(Employee.class, username);
        if (employee != null) {
            //try-catch Hash password
            String hashPassword = "";
            try {
                hashPassword = hash(password);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(commonInterfaceBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(employee.getPassword().equals(hashPassword)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String findEmployee(String nric){
        Employee employee = em.find(Employee.class, nric);
        if(employee!=null) return "0";
        return employee.getEmployeeID().toString();
    }
    
    @Override //HASH DONE
    public int createAccount (Long employeeID, String username, String password){
        Employee employee = em.find(Employee.class, employeeID);
        if (employee != null) {
            if(!employee.getPassword().equals("")){
                if(!employee.getUsername().equals("")){
                    return 2; //usernmae is already filled
                }else{//username and password is empty. Can create account.
                    try{
                        employee.setUsername(username);
                        employee.setPassword(hash(password));
                        return 0; //account created.
                    }catch(Exception e){
                        return -2; //if catch fails.
                    }
                }
            }else {
                return 1; //password is already filled
            }
        }
        return -1; //Employee not found
    }
    
    @Override //HASH NEEDED
    public int updatePassword (Long employeeID, String oldPassword, String newPassword, String confirmPassword){
        Employee employee = em.find(Employee.class, employeeID);
        String oldHashed = "";
        try {
            oldHashed = hash(oldPassword);//<--
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(commonInterfaceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(oldHashed.equals(employee.getPassword())){
            if(newPassword.equals(confirmPassword)){
                try {
                    employee.setPassword(hash(newPassword));//<--
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(commonInterfaceBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                return 0;//Update successfullys
            }else{
                return 1;//newPassword and confirmPassword doesn't match
            }
        }else{
            return 2;//incorrect oldHashed does not match
        }
    }
    
    @Override
    public List<String> listAccessibleSystems(Long employeeID){
        List<String> newList = new ArrayList<String>();
        return newList;
    }
    
    private String hash(String password) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<bytes.length; i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
