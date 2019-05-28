package com.almacenea.autenticacion.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;



/*@Data
@NoArgsConstructor
@AllArgsConstructor*/
@Entity
@Table(name="USUARIOS")
@XmlRootElement
/*@NamedQueries({
	//@NamedQuery(name="Usuario.findAll",query="select u from Usuarios u"),
	//@NamedQuery(name="sexoSQL",query="select p from Persona p where p.sexo = :sexo"),
	//@NamedQuery(name="")
})*/
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5598447667872520203L;
	@Id
	@Column(name = "ID_USER")
	@NotNull
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private String id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "APELLIDOS")
	private String apellidos;
	@Column(name = "DNI")
	@NotNull
	//@Size(min = 9, max = 10)
	private String dni;
	@Column(name = "NUMERO_CONTACTO")
	//@Size(min = 9, max = 9)
	private int numContacto;
	@Column(name = "EMAIL")
	//@Size(max = 30)
	private String email;
	@Column(name = "ALIAS")
	//@Size(max = 30)
	private String aliasUsuario;
	
	public Usuario() {
		}
	
	public Usuario(String id) {
		super();
		this.id = id;
	}
	public Usuario(String id, String nombre, String apellidos, String dni,
	int numContacto, String email,
			String aliasUsuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.numContacto = numContacto;
		this.email = email;
		this.aliasUsuario = aliasUsuario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getNumContacto() {
		return numContacto;
	}

	public void setNumContacto(int numContacto) {
		this.numContacto = numContacto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAliasUsuario() {
		return aliasUsuario;
	}

	public void setAliasUsuario(String aliasUsuario) {
		this.aliasUsuario = aliasUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni
				+ ", numContacto=" + numContacto + ", email=" + email + ", aliasUsuario=" + aliasUsuario + "]";
	}

}
