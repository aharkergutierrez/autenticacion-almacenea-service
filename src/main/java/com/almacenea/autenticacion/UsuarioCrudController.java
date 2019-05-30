/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacenea.autenticacion;


import java.util.List;
import java.util.Optional;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.almacenea.autenticacion.DAO.DataUsuarios;
import com.almacenea.autenticacion.modelo.Usuario;

/**
 *
 * @author ALBERTO LUCAS
 */
@RestController
@RequestMapping(path = "/usuario")
public class UsuarioCrudController {

    @Autowired
    private DataUsuarios repository;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Usuario usuario) {

        Usuario returnValue = repository.save(usuario);

        return new ResponseEntity<Usuario>(returnValue, HttpStatus.CREATED);
    }
    
    //Todos los usuarios
    @RequestMapping(value = "/read/all", method = RequestMethod.GET)
    public ResponseEntity<?> readAll() {

        List<Usuario> returnValue = repository.findAll();

        return new ResponseEntity<List<Usuario>>(returnValue, HttpStatus.OK);
    }
    
    //Buscar por id
    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> readAll(@PathVariable("id") String id) {

        Optional<Usuario> returnValue = repository.findById(id);

        return new ResponseEntity<Usuario>(returnValue.get(), HttpStatus.OK);
    }
    
    //actualizar Alias de usuario
    @RequestMapping(value = "/update/{aliasUsuario}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("aliasUsuario") String aliasUsuario, @RequestBody Usuario usuario) {

        usuario.setAliasUsuario(aliasUsuario);
        
        Usuario returnValue = repository.save(usuario);

        return new ResponseEntity<Usuario>(returnValue, HttpStatus.OK);
    }
    
    //Borrar usuario
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") String id) {

        repository.deleteById(id);

        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}
