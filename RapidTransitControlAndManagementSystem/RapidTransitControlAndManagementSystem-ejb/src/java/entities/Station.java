/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Julian 
 */
@Entity
public class Station implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer stationID;
    
    @ManyToOne
    private Line line;
    
    private Timestamp lastMaintenanceDate;
    
    @OneToMany(mappedBy = "station")
    private List<Block> blocks;
    
    @OneToOne(mappedBy = "nearestStation")
    private Depot depot;

    public Station() {
        this.blocks = new ArrayList<Block>();
    }

    
    
    
    public Integer getStationID() {
        return stationID;
    }

    public void setStationID(Integer stationID) {
        this.stationID = stationID;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    /**
     * Get the value of lastMaintenanceDate
     *
     * @return the value of lastMaintenanceDate
     */
    public Timestamp getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    /**
     * Set the value of lastMaintenanceDate
     *
     * @param lastMaintenanceDate new value of lastMaintenanceDate
     */
    public void setLastMaintenanceDate(Timestamp lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stationID != null ? stationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the stationID fields are not set
        if (!(object instanceof Station)) {
            return false;
        }
        Station other = (Station) object;
        return !((this.stationID == null && other.stationID != null) || (this.stationID != null && !this.stationID.equals(other.stationID)));
    }

    @Override
    public String toString() {
        return "entities.Stations[ id=" + stationID + " ]";
    }

}
