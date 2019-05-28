/*package com.almacenea.autenticacion.DAO;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.almacenea.autenticacion.modelo.Usuario;
import com.mongodb.MongoClient;

public class UsuariosDAO {

	private MongoClient conexion;
	private MongoOperations opMongo;

	public void eliminarUsuario(int id) {
		//inicio();
		Usuario usuario = opMongo.findById(id, Usuario.class);
		opMongo.remove(usuario);
		cerrarConexion();
	}

	public void modificarUsuario(int id, String nuevoAlias) {
		//inicio();
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		Update update = new Update();
		update.set("aliasUsuario", nuevoAlias);
		opMongo.updateFirst(query, update, Usuario.class);
		cerrarConexion();
	}

	public Usuario buscarUsuario(int id) {
		//inicio();
		Usuario usuario = opMongo.findById(id, Usuario.class); 
		cerrarConexion();	
		return usuario;
	}

	public List<Usuario> consultarTodos() {		
		inicio();
		List<Usuario> lista = opMongo.findAll(Usuario.class);
		cerrarConexion();
		return lista;
	}

	public void insertar(Usuario nuevo) {
		inicio();
		opMongo.insert(nuevo);
		cerrarConexion();
	}

	public void inicio() {
		try {
			conexion = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		// obtener la plantilla de Mongo
		opMongo = new MongoTemplate(conexion, "usuariosDB");
	}

	private void cerrarConexion() {
		conexion.close();
	}

}*/

