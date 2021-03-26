package co.com.laaguilar.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Clase que modela la entidad CIUDAD
 *
 * @author laaguilar
 */
@Entity
@Table(name = "CIUDAD")
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Codigo DANE asignado a la ciudad
     */
    @Id
    @Basic(optional = false)
    @Column(name = "COD_DANE")
    private String codDane;
    /**
     * Nombre de la ciudad
     */
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    /**
     * Areas ubicadas en la ciudad
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCiudad")
    private List<Area> areaList;

    public Ciudad() {
    }

    public Ciudad(String codDane) {
        this.codDane = codDane;
    }

    public Ciudad(String codDane, String nombre) {
        this.codDane = codDane;
        this.nombre = nombre;
    }

    public String getCodDane() {
        return codDane;
    }

    public void setCodDane(String codDane) {
        this.codDane = codDane;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDane != null ? codDane.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.codDane == null && other.codDane != null) || (this.codDane != null && !this.codDane.equals(other.codDane))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.laaguilar.entities.Ciudad[ codDane=" + codDane + " ]";
    }

}
