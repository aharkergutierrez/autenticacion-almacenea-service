package com.almacenea.autenticacion.cliente;

import java.net.UnknownHostException;

import com.almacenea.autenticacion.DAO.UsuariosDAO;
import com.almacenea.autenticacion.modelo.Usuario;


public class mainMongo {

	public static void main(String[] args) throws UnknownHostException {
		
		UsuariosDAO dao = new UsuariosDAO();
		dao.inicio();
		
		// Alta
		Usuario user1 = new Usuario("Alberto", "Mate", "15478453-F", 625415789, "alberto@almacenea", "Maverick");
		
	//	dao.insertar(user1);
//		dao.insertar(user2);
		
		// Consultar todos
		for (Usuario user : dao.consultarTodos()) {
			System.out.println(user);
		}
	}

}
