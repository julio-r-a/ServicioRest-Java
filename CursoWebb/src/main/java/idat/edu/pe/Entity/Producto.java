package idat.edu.pe.Entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="Producto")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
	, @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto =: idProducto")
	, @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre =: nombre ")
	, @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion =: descripcion")
	, @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio =: precio")
	, @NamedQuery(name = "Producto.findByEstado", query = "SELECT p FROM Producto p WHERE p.estado =: estado")
	
})
public class Producto implements Serializable{
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="idProducto")
	private Integer idProducto;	
	@Column(name="nombre")
	private String nombre;	
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="precio")
	private Double precio;
	@Column(name="estado")
	private String estado;
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
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
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Producto(Integer idProducto, String nombre, String descripcion, Double precio, String estado) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.estado = estado;
	}
	
}
