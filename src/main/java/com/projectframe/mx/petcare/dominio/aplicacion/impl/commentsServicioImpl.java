package com.projectframe.mx.petcare.dominio.aplicacion.impl;

import com.projectframe.mx.petcare.dominio.aplicacion.commentsServicio;
import com.projectframe.mx.petcare.dominio.entidades.comments;
import com.projectframe.mx.petcare.dominio.repositorios.commentsRepositorio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class commentsServicioImpl implements commentsServicio {
    @Autowired
    private commentsRepositorio commRepo;

    @Override
    public comments guardarComment(comments comment) {
        return commRepo.save(comment);
    }

    @Override
    public List<comments> obtenerComments() {
        return (List<comments>) commRepo.findAll();
    }

    @Override
    public comments obtenerCommentPorId(Long id) {
        return commRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarComment(Long id) {
        commRepo.deleteById(id);
    }
}
