package com.projectframe.mx.petcare.dominio.repositorios;

import com.projectframe.mx.petcare.dominio.entidades.mascotas;
import org.springframework.data.repository.CrudRepository;

public interface mascotasRepositorio extends CrudRepository<mascotas, Long> {
}
