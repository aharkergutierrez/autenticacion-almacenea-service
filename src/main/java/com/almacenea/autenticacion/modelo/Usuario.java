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



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="USUARIOS")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="Usuario.findAll",query="select u from Usuarios u"),
	@NamedQuery(name="sexoSQL",query="select p from Persona p where p.sexo = :sexo"),
	//@NamedQuery(name="")
})
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5598447667872520203L;
	@Id
	@Column(name = "ID_USER")
	@NotNull
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "APELLIDOS")
	private String apellidos;
	@Column(name = "DNI")
	@NotNull
	@Size(min = 10, max = 10)
	private String dni;
	@Column(name = "NUMERO_CONTACTO")
	@Size(min = 9, max = 9)
	private int numContacto;
	@Column(name = "EMAIL")
	@Size(max = 20)
	private String email;
	@Column(name = "ALIAS")
	@Size(min = 5, max = 10)
	private String aliasUsuario;
	
	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni
				+ ", numContacto=" + numContacto + ", email=" + email + ", aliasUsuario=" + aliasUsuario + "]";
	}

}
