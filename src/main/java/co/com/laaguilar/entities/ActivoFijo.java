package co.com.laaguilar.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Clase que modela la entidad ACTIVO_FIJO
 *
 * @author laaguilar
 */
@Entity
@Table(name = "ACTIVO_FIJO")
@EntityListeners(AuditingEntityListener.class)
public class ActivoFijo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador activo fijo
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @SequenceGenerator(name = "seq-gen", sequenceName = "MY_SEQ_GEN", initialValue = 1, allocationSize = 12)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-gen")
    private Long id;
    /**
     * Nombre del activo fijo
     */
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    /**
     * Descrición del activo fijo
     */
    @Column(name = "DESCRIPCION")
    private String descripcion;
    /**
     * Tipo de activo fijo
     */
    @Basic(optional = false)
    @Column(name = "TIPO")
    private String tipo;
    /**
     * Serial del activo fijo
     */
    @Column(name = "SERIAL")
    private String serial;
    /**
     * Numero de inventario asignado al activo fijo
     */
    @Basic(optional = false)
    @Column(name = "NUM_INVENTARIO")
    private String numInventario;
    /**
     * Peso del activo fijo en Kg
     */
    @Column(name = "PESO")
    private BigInteger peso;
    /**
     * Alto del activo fijo en cms
     */
    @Column(name = "ALTO")
    private BigInteger alto;
    /**
     * Ancho del activo fijo en cms
     */
    @Column(name = "ANCHO")
    private BigInteger ancho;
    /**
     * Largo del activo fijo en cms
     */
    @Column(name = "LARGO")
    private BigInteger largo;
    /**
     * Valor de compra del activo fijo en pesos
     */
    @Basic(optional = false)
    @Column(name = "VALOR_COMPRA")
    private BigInteger valorCompra;
    /**
     * Fecha de compra del activo fijo
     */
    @Basic(optional = false)
    @Column(name = "FECHA_COMPRA")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    /**
     * Fecha de baja del activo fijo
     */
    @Column(name = "FECHA_BAJA")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    /**
     * Estado actual del activo fijo
     */
    @Basic(optional = false)
    @Column(name = "ESTADO_ACTUAL")
    private String estadoActual;
    /**
     * Color del activo fijo
     */
    @Basic(optional = false)
    @Column(name = "COLOR")
    private String color;

    public ActivoFijo() {
    }

    public ActivoFijo(Long id) {
        this.id = id;
    }

    public ActivoFijo(Long id, String nombre, String tipo, String numInventario, BigInteger valorCompra, Date fechaCompra, String estadoActual, String color) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.numInventario = numInventario;
        this.valorCompra = valorCompra;
        this.fechaCompra = fechaCompra;
        this.estadoActual = estadoActual;
        this.color = color;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getNumInventario() {
        return numInventario;
    }

    public void setNumInventario(String numInventario) {
        this.numInventario = numInventario;
    }

    public BigInteger getPeso() {
        return peso;
    }

    public void setPeso(BigInteger peso) {
        this.peso = peso;
    }

    public BigInteger getAlto() {
        return alto;
    }

    public void setAlto(BigInteger alto) {
        this.alto = alto;
    }

    public BigInteger getAncho() {
        return ancho;
    }

    public void setAncho(BigInteger ancho) {
        this.ancho = ancho;
    }

    public BigInteger getLargo() {
        return largo;
    }

    public void setLargo(BigInteger largo) {
        this.largo = largo;
    }

    public BigInteger getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigInteger valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaCompra);
        cal.add(Calendar.DATE, 1);
        this.fechaCompra = cal.getTime();
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public Date getFechaBajaAut() {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaBaja);
            cal.add(Calendar.DATE, -1);
            return cal.getTime();
        } catch (Exception ex) {
            return fechaBaja;
        }
    }

    public void setFechaBaja(Date fechaBaja) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaBaja);
            cal.add(Calendar.DATE, 1);
            this.fechaBaja = cal.getTime();
        } catch (Exception ex) {
            this.fechaBaja = fechaBaja;
        }
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        if (!(object instanceof ActivoFijo)) {
            return false;
        }
        ActivoFijo other = (ActivoFijo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.laaguilar.entities.ActivoFijo[ id=" + id + " ]";
    }

}
