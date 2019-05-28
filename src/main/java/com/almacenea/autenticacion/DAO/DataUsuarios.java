package com.almacenea.autenticacion.DAO;

import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.almacenea.autenticacion.modelo.Usuario;



public interface DataUsuarios extends MongoRepository<Usuario, String>{

}
