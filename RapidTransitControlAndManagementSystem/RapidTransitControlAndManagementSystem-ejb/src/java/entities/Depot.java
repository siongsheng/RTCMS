/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Julian 
 */
@Entity
public class Depot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer depotID;
    
    private String depotName;
    
    private int capacity;
    
    @OneToOne
    private Station nearestStation;

    public Depot() {
    }
    
    
    
    
    /**
     * Get the value of nearestStation
     *
     * @return the value of nearestStation
     */
    public Station getNearestStation() {
        return nearestStation;
    }

    /**
     * Set the value of nearestStation
     *
     * @param nearestStation new value of nearestStation
     */
    public void setNearestStation(Station nearestStation) {
        this.nearestStation = nearestStation;
    }

    /**
     * Get the value of capacity
     *
     * @return the value of capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Set the value of capacity
     *
     * @param capacity new value of capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Get the value of depotName
     *
     * @return the value of depotName
     */
    public String getDepotName() {
        return depotName;
    }

    /**
     * Set the value of depotName
     *
     * @param depotName new value of depotName
     */
    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }

    public Integer getDepotID() {
        return depotID;
    }

    public void setDepotID(Integer depotID) {
        this.depotID = depotID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depotID != null ? depotID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the depotID fields are not set
        if (!(object instanceof Depot)) {
            return false;
        }
        Depot other = (Depot) object;
        if ((this.depotID == null && other.depotID != null) || (this.depotID != null && !this.depotID.equals(other.depotID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Depot[ id=" + depotID + " ]";
    }
    
}
