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
 *  Clase que modela la entidad EMPLEADO
 * @author laaguilar
 */
@Entity
@Table(name = "EMPLEADO")
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * Identificador del empleado en la compañia
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Primer nombre del empleado
     */
    @Basic(optional = false)
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    /**
     * Segundo nombre del empleado
     */
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    /**
     * Otros nombres del empleado
     */
    @Column(name = "OTROS_NOMBRES")
    private String otrosNombres;
    /**
     * * Primer apellido del empleado
     */
    @Basic(optional = false)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    /**
     * Segundo apellido del empleado
     */
    @Column(name = "SEGUNDO APELLIDO")
    private String segundoApellido;
    /**
     * Tipo de documento de identificación del empleado
     */
    @Basic(optional = false)
    @Column(name = "TIPO_DOCUMENTO")
    private String tipoDocumento;
    /**
     * Número de documento del empleado
     */
    @Basic(optional = false)
    @Column(name = "NUM_DOCUMENTO")
    private String numDocumento;
    /**
     * Area a la que pertenece el empleado
     */
    @Column(name = "ID_AREA")
    private Long idArea;

    public Empleado() {
    }

    public Empleado(Long id) {
        this.id = id;
    }

    public Empleado(Long id, String primerNombre, String primerApellido, String tipoDocumento, String numDocumento) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getOtrosNombres() {
        return otrosNombres;
    }

    public void setOtrosNombres(String otrosNombres) {
        this.otrosNombres = otrosNombres;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public Long getIdArea() {
        return idArea;
    }

    public void setIdArea(Long idArea) {
        this.idArea = idArea;
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
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.laaguilar.entities.Empleado[ id=" + id + " ]";
    }

}
