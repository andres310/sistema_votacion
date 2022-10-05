package com.votacion.sistema;

import com.votacion.sistema.models.Administradores;
import com.votacion.sistema.repositories.administradoresRepository;
import com.votacion.sistema.services.AdministradoresService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministradoresServiceUnitTest {

    @Autowired
    private AdministradoresService administradoresService;

    @Autowired
    private administradoresRepository administradoresRepository;

    @Test
    public void whenAppStartsCreateAdmin() {
        Administradores admin = new Administradores();
        admin.setId(1);
        admin.setUsuario("prueba1");
        admin.setContrasena("contra1");

        // Crea una instancia de admin
        administradoresRepository.save(admin);

        // Obtiene una lista de los administradores
        List<Administradores> list = administradoresService.list();

        // Evalua que se haya creado una instancia de administrador
        Assert.assertEquals(list.size(), 1);
    }

    @Test
    public void updateAdmin() {
        // Obtiene una lista de los administradores
        List<Administradores> list = administradoresService.list();
        Administradores admin = list.get(0); // Obtiene el primer administrador
        admin.setUsuario("update1");

        // Actualiza el registro
        // Usa el mismo metodo ya que internamente evalua si el id ya existe
        // Si es asi, corre un update en sql
        administradoresRepository.save(admin);

        // Evalua que se haya actualizado una instancia de administrador
        Assert.assertEquals(list.size(), 1);
    }

    @Test
    public void deleteAdmin() {
        // Obtiene una lista de los administradores
        List<Administradores> list = administradoresService.list();
        Administradores admin = list.get(0); // Obtiene el primer administrador

        // Elimina el registro segun instancia
        // Tambien se puede eliminar por id
        administradoresRepository.delete(admin);

        Assert.assertEquals(
                administradoresRepository.count(),
                0
        );
    }
}
