package com.appclientes.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min=3, max=18)
	@Column(nullable = false)
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	@Email
	@Column(nullable=false, unique=true)
	private String email;
	
	@NotNull(message = "La fecha no puede estar vacia")
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	private String foto;
	
	
	@NotNull(message="La region no puede ser vacia")
//	Relacionamos a traves del atributo la region
//	Many to one da la relacion un cliente solo puede tener una region. Una region puede tener muchos clientes
//	El metodo de carga (fetch) es lazy, osea carga perezosa
	@ManyToOne(fetch=FetchType.LAZY)
//	Le damos la llave foranea, esto se puede omitir y spring lo genera
	@JoinColumn(name="region_id")
//	Ahora ignoramos unos atributos del JSON para evitar error
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Region region;
	
//	@PrePersist
//	public void prePersist() {
//		createAt = new Date();
//	}
	
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	
//	Getters y setters de la region
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}



	private static final long serialVersionUID = 1L;

}
