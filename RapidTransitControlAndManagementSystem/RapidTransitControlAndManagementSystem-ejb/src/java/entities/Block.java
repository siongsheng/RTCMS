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
public class Block implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer blockID;
    
    @ManyToOne
    private Line line;
    
    @ManyToOne
    private Station station;

    public Block() {
    }

    
    /**
     * Get the value of station
     *
     * @return the value of station
     */
    public Station getStation() {
        return station;
    }

    /**
     * Set the value of station
     *
     * @param station new value of station
     */
    public void setStation(Station station) {
        this.station = station;
    }

    /**
     * Get the value of line
     *
     * @return the value of line
     */
    public Line getLine() {
        return line;
    }

    /**
     * Set the value of line
     *
     * @param line new value of line
     */
    public void setLine(Line line) {
        this.line = line;
    }

    public Integer getBlockID() {
        return blockID;
    }

    public void setBlockID(Integer blockID) {
        this.blockID = blockID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (blockID != null ? blockID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the blockID fields are not set
        if (!(object instanceof Block)) {
            return false;
        }
        Block other = (Block) object;
        if ((this.blockID == null && other.blockID != null) || (this.blockID != null && !this.blockID.equals(other.blockID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Blocks[ id=" + blockID + " ]";
    }
    
}
