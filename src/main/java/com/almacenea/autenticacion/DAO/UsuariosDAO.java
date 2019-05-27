package com.almacenea.autenticacion.DAO;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.almacenea.autenticacion.modelo.Usuario;Usuario;
import com.mongo.db;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class UsuariosDAO {

	private MongoClient conexion;
	private DB db;
	private DBCollection coleccion;
	
	public List<Usuario> consultarTodos(){
		List<Usuario> lista = new ArrayList<>();
		
		try {
			abrirConexion();
			DBCursor rs = coleccion.find();
			while (rs.hasNext()) {
				BasicDBObject json = (BasicDBObject) rs.next();
				lista.add(new Usuario(json.getInt("id"), 
						json.getString("nombre"), 
						json.getString("apellidos"), 
						json.getString("dni"), 
						json.getInt("numContacto"), 
						json.getString("email"),  
						json.getBoolean("alias")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		return lista;
	}
	
	public void insertar(Usuario nuevo) {
		try {
			abrirConexion();
			
			// Construir el objeto JSON
			BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
			docBuilder.append("_id", nuevo.getId());
			docBuilder.append("nombre", nuevo.getNombre());
			docBuilder.append("apellidos", nuevo.getApellidos());
			docBuilder.append("dni", nuevo.getDni());
			docBuilder.append("numContacto", nuevo.getNumContacto());
			docBuilder.append("email", nuevo.getEmail());
			docBuilder.append("alias", nuevo.getAliasUsuario());
			
			// Obtenemos el documento
			DBObject documento = docBuilder.get();
			
			// Insertamos en la coleccion
			coleccion.insert(documento);
			
		}catch(Exception ex) {
			ex.printStackTrace();	
		}finally {
			cerrarConexion();
		}
		
	}
	
	public void inicio() throws UnknownHostException {
		abrirConexion();
		crearColeccion();
	}
	
	private void crearColeccion() {
		// Tabla -> Coleccion
		// Registro -> Documento
		coleccion = db.getCollection("usuarios");
	}

	private void abrirConexion() throws UnknownHostException {
		// Abre la conedxion en el servidor y puerto predeterminado
		conexion = new MongoClient("localhost",27017);
//		conexion = new MongoClient("OtroHost");
//		conexion = new MongoClient("OtroHost", 99999);
//		conexion = new MongoClient(Arrays.asList(new ServerAddress("Host1", 90), new ServerAddress("Host2", 91),
//				new ServerAddress("Host3", 92)));
		
		// Conectamos con la base de datos
		db = conexion.getDB("usuariosDB");
		
	}

	private void cerrarConexion() {
		conexion.close();
	}

}
