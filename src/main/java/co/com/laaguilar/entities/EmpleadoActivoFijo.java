package co.com.laaguilar.entities;

import java.io.Serializable;
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
 * Clase que modela la entidad EMPLEADO_ACTIVO_FIJO
 *
 * @author laaguilar
 */
@Entity
@Table(name = "EMPLEADO_ACTIVO_FIJO")
public class EmpleadoActivoFijo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identificador del registro Empleado-Activo Fijo
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Identificador del Activo Fijo
     */    
    @JoinColumn(name = "ID_ACTIVO_FIJO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ActivoFijo idActivoFijo;
    /**
     * Identificador del Empleado
     */    
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Empleado idEmpleado;

    public EmpleadoActivoFijo() {
    }

    public EmpleadoActivoFijo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ActivoFijo getIdActivoFijo() {
        return idActivoFijo;
    }

    public void setIdActivoFijo(ActivoFijo idActivoFijo) {
        this.idActivoFijo = idActivoFijo;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
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
        if (!(object instanceof EmpleadoActivoFijo)) {
            return false;
        }
        EmpleadoActivoFijo other = (EmpleadoActivoFijo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.laaguilar.entities.EmpleadoActivoFijo[ id=" + id + " ]";
    }

}
