package com.projectframe.mx.petcare.dominio.aplicacion.impl;

import com.projectframe.mx.petcare.dominio.aplicacion.usuariosServicio;
import com.projectframe.mx.petcare.dominio.entidades.usuarios;
import com.projectframe.mx.petcare.dominio.repositorios.usuariosRepositorio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class usuariosServicioImpl implements usuariosServicio {
    @Autowired
    private usuariosRepositorio usersRepo;

    @Override
    @Transactional
    public usuarios guardarUsuario(usuarios user) {
        return usersRepo.save(user);
    }

    @Override
    public List<usuarios> obtenerUsuarios() {
        return (List<usuarios>) usersRepo.findAll();
    }

    @Override
    public usuarios obtenerUsuarioPorId(Long id) {
        return usersRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usersRepo.deleteById(id);
        return;
    }
}
