/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Julian 
 */
@Entity
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleID;

    private String roleName;

    private Time reportingTime;

    @ManyToMany(mappedBy = "roles")
    private List<Employee> employees;
    
    public Role() {
        this.employees = new ArrayList<Employee>();
    }

    
    
    
    
    
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    /**
     * Get the value of reportingTime
     *
     * @return the value of reportingTime
     */
    public Time getReportingTime() {
        return reportingTime;
    }

    /**
     * Set the value of reportingTime
     *
     * @param reportingTime new value of reportingTime
     */
    public void setReportingTime(Time reportingTime) {
        this.reportingTime = reportingTime;
    }

    /**
     * Get the value of roleName
     *
     * @return the value of roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Set the value of roleName
     *
     * @param roleName new value of roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleID != null ? roleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the roleID fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.roleID == null && other.roleID != null) || (this.roleID != null && !this.roleID.equals(other.roleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Role[ id=" + roleID + " ]";
    }
    
}
