package com.projectframe.mx.petcare.dominio.repositorios;

import com.projectframe.mx.petcare.dominio.entidades.posts;
import org.springframework.data.repository.CrudRepository;

public interface postsRepositorio extends CrudRepository<posts, Long> {
}
