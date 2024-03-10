package Tablas;

// default package
// Generated 28 feb 2024, 16:15:03 by Hibernate Tools 6.3.1.Final

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

/**
 * Compras generated by hbm2java
 */
@Entity
@Table(name = "compras")
public class Compras implements java.io.Serializable {
	@Id
	@Column(name = "id_com")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCom;
	@ManyToOne
	@JoinColumn(name = "id_use")
	private Usuario usuario;
	@OneToMany(mappedBy = "compras")
	private Set<Factura> facturas = new HashSet(0);

	public Compras() {
	}

	public Compras(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getIdCom() {
		return this.idCom;
	}

	public void setIdCom(Integer idCom) {
		this.idCom = idCom;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set getFacturas() {
		return this.facturas;
	}

	public void setFacturas(Set facturas) {
		this.facturas = facturas;
	}

}
