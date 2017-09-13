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
import javax.persistence.ManyToOne;

/**
 *
 * @author Julian 
 */
@Entity
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer carID;
    
    private String carType;

    private int capacity;
    
    @ManyToOne
    private Train train;

    public Car() {
    }

    
    
    
    
    /**
     * Get the value of train
     *
     * @return the value of train
     */
    public Train getTrain() {
        return train;
    }

    /**
     * Set the value of train
     *
     * @param train new value of train
     */
    public void setTrain(Train train) {
        this.train = train;
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
     * Get the value of carType
     *
     * @return the value of carType
     */
    public String getCarType() {
        return carType;
    }

    /**
     * Set the value of carType
     *
     * @param carType new value of carType
     */
    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Integer getCarID() {
        return carID;
    }

    public void setCarID(Integer carID) {
        this.carID = carID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carID != null ? carID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the carID fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.carID == null && other.carID != null) || (this.carID != null && !this.carID.equals(other.carID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Car[ id=" + carID + " ]";
    }
    
}
