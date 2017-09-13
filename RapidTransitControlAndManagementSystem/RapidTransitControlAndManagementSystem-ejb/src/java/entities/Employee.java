/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Julian 
 */
@Entity(name="Users")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeID;
    private String username;
    private String name;
    private String password;
    private int salary;
    private String jobRole;
    private int yearsOfExp;
    private String NRIC;
    private String email;
    private String contact;
    private String address;
    private int age;
    @ManyToMany
    private List<Role> roles;

    public Employee() {
        this.roles = new ArrayList<Role>();
    }
    
    public void create( String username, String name, String password, int salary, String jobRole, int yearsOfExp, String NRIC, String email, String contact, String address, int age){
        this.username = username;
        this.name = name;
        this.password = password;
        this.salary = salary;
        this.jobRole = jobRole;
        this.yearsOfExp = yearsOfExp;
        this.NRIC = NRIC;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.age = age;
    }

    
    
    
    
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    /**
     * Get the value of age
     *
     * @return the value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the value of age
     *
     * @param age new value of age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the value of contact
     *
     * @return the value of contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * Set the value of contact
     *
     * @param contact new value of contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the value of NRIC
     *
     * @return the value of NRIC
     */
    public String getNRIC() {
        return NRIC;
    }

    /**
     * Set the value of NRIC
     *
     * @param NRIC new value of NRIC
     */
    public void setNRIC(String NRIC) {
        this.NRIC = NRIC;
    }

    /**
     * Get the value of yearsOfExp
     *
     * @return the value of yearsOfExp
     */
    public int getYearsOfExp() {
        return yearsOfExp;
    }

    /**
     * Set the value of yearsOfExp
     *
     * @param yearsOfExp new value of yearsOfExp
     */
    public void setYearsOfExp(int yearsOfExp) {
        this.yearsOfExp = yearsOfExp;
    }

    /**
     * Get the value of jobRole
     *
     * @return the value of jobRole
     */
    public String getJobRole() {
        return jobRole;
    }

    /**
     * Set the value of jobRole
     *
     * @param jobRole new value of jobRole
     */
    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    /**
     * Get the value of salary
     *
     * @return the value of salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Set the value of salary
     *
     * @param salary new value of salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeID != null ? employeeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the employeeID fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeID == null && other.employeeID != null) || (this.employeeID != null && !this.employeeID.equals(other.employeeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Users[ id=" + employeeID + " ]";
    }
    
}
