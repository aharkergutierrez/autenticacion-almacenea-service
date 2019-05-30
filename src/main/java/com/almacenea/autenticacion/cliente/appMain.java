package com.almacenea.autenticacion.cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.almacenea.autenticacion.modelo.Usuario;

public class appMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		
		//Obtener el EntityManager(conexion)
		EntityManager em = emf.createEntityManager();

		Usuario usuario1 = new Usuario("Carlos", "Romero", "51648885-A", 684757894, "carlos@almacenea.com", "Carlangas");
		Usuario usuario2 = new Usuario("German", "Tequilla","52569742-B", 658745987, "germa@almacenea.com", "German-15");
		Usuario usuario3 = new Usuario("Mariano", "Ticias", "32547859-C", 612354879, "mariano@almacenea.com", "Mariano66");
		Usuario usuario4 = new Usuario("Chema", "Pamundi", "21547854-D", 632614728, "chema@almacenea.com", "Chemita");
		Usuario usuario5 = new Usuario("Gema", "Castillo", "12478593-E", 612914357, "gema@almacenea.com", "Gemita_29");
	
	
	EntityTransaction tx = em.getTransaction();
	
	//Persistir los datos
	try {
		tx.begin();
		em.persist(usuario1);
		em.persist(usuario2);
		em.persist(usuario3);
		em.persist(usuario4);
		em.persist(usuario5);
		
		
		tx.commit();
	}catch (Exception e) {
		tx.rollback();
		e.printStackTrace();
	
	}finally {
		em.close();
	}
}

}
