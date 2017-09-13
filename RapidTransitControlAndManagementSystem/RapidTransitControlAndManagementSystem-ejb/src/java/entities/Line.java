/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Julian 
 */
@Entity
public class Line implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String lineID;
    
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy = "line")
    private List<Station> stations;
    
    @OneToMany(mappedBy = "line")
    private List<Block> blocks;
    
    public Line() {
        this.stations = new ArrayList<Station>();
    }

    
    
    
    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public String getLineID() {
        return lineID;
    }

    public void setLineID(String lineID) {
        this.lineID = lineID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lineID != null ? lineID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the lineID fields are not set
        if (!(object instanceof Line)) {
            return false;
        }
        Line other = (Line) object;
        if ((this.lineID == null && other.lineID != null) || (this.lineID != null && !this.lineID.equals(other.lineID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Lines[ id=" + lineID + " ]";
    }
    
}
