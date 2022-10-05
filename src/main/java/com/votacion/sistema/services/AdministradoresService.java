package com.votacion.sistema.services;

import com.votacion.sistema.models.Administradores;
import com.votacion.sistema.repositories.administradoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradoresService {

    @Autowired
    private administradoresRepository AdministradoresRepository;

    // Aqui creo que da error y debe castear a lista pq
    // en el tutorial usaban JpaRepository como Interface
    // y estoy usando la de spring q es CrudRepository
    public List<Administradores> list() {
        return (List<Administradores>) AdministradoresRepository.findAll();
    }
}
