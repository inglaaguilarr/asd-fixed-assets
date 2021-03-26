package co.com.laaguilar.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que modela la entidad AREA_ACTIVO_FIJO
 *
 * @author laaguilar
 */
@Entity
@Table(name = "AREA_ACTIVO_FIJO")
public class AreaActivoFijo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identificador del registro Area-Activo Fijo
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Identificador del Area
     */    
    @Basic(optional = false)
    @Column(name = "ID_AREA")
    private BigInteger idArea;
    /**
     * Identificador del Activo Fijo
     */
    @JoinColumn(name = "ID_ACTIVO_FIJO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ActivoFijo idActivoFijo;

    public AreaActivoFijo() {
    }

    public AreaActivoFijo(Long id) {
        this.id = id;
    }

    public AreaActivoFijo(Long id, BigInteger idArea) {
        this.id = id;
        this.idArea = idArea;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getIdArea() {
        return idArea;
    }

    public void setIdArea(BigInteger idArea) {
        this.idArea = idArea;
    }

    public ActivoFijo getIdActivoFijo() {
        return idActivoFijo;
    }

    public void setIdActivoFijo(ActivoFijo idActivoFijo) {
        this.idActivoFijo = idActivoFijo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaActivoFijo)) {
            return false;
        }
        AreaActivoFijo other = (AreaActivoFijo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.laaguilar.entities.AreaActivoFijo[ id=" + id + " ]";
    }

}
