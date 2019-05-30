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
/*import javax.validation.constraints.Max;
import javax.validation.constraints.Min;*/
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;



/*@Data
@NoArgsConstructor
@AllArgsConstructor*/
@Entity
@Table(name="USUARIOS2")
@XmlRootElement
/*@NamedQueries({
	//@NamedQuery(name="Usuario.findAll",query="select u from Usuarios u"),
	//@NamedQuery(name="Usuario.delete",query="delete p from Usuario u where u.id = :id"),
	//@NamedQuery(name="")
})*/
public class Usuario2 implements Serializable {


	@Id
	@Column(name="ID_USER")
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name = "NOMBRE")
	private String nombre;	
	@Column(name = "APELLIDOS")
	private String apellidos;
	@Column(name = "DNI")
	@NotNull
	@Size(min = 9, max = 10)
	private String dni;
	@Column(name = "NUMERO_CONTACTO")
	/*@Min(value=1)
	@Max(value=9)*/
	private int numContacto;
	@Column(name = "EMAIL")
	@Size(max = 30)
	private String email;
	@Column(name = "ALIAS")
	@Size(max = 30)
	private String aliasUsuario;
	
	public Usuario2() {
		}
	
	public Usuario2(String nombre, String apellidos, String dni,int numContacto, String email,
			String aliasUsuario) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.numContacto = numContacto;
		this.email = email;
		this.aliasUsuario = aliasUsuario;
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
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", numContacto="
				+ numContacto + ", email=" + email + ", aliasUsuario=" + aliasUsuario + "]";
	}
}
