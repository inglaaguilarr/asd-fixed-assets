package co.com.laaguilar.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que modela la entidad AREA
 *
 * @author laaguilar
 */
@Entity
@Table(name = "AREA")
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Identificador del Area
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Nombre del Area
     */
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    /**
     * Descripción del Area
     */    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    /**
     * Codigo asignado al Area
     */
    @Column(name = "CODIGO")
    private String codigo;
    /**
     * Codigo de ciudad donde se encuentra ubicada el Area
     */
    @Column(name = "COD_CIUDAD")
    private String codCiudad;

    public Area() {
    }

    public Area(Long id) {
        this.id = id;
    }

    public Area(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(String codCiudad) {
        this.codCiudad = codCiudad;
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
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.laaguilar.entities.Area[ id=" + id + " ]";
    }

}
