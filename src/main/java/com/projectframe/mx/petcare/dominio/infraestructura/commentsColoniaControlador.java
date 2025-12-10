package com.projectframe.mx.petcare.dominio.infraestructura;

import com.projectframe.mx.petcare.dominio.aplicacion.commentsColoniaServicio;
import com.projectframe.mx.petcare.dominio.entidades.commentsColonia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/petcare")
public class commentsColoniaControlador {
    @Autowired
    private commentsColoniaServicio commentsColoniaServicio;

    @GetMapping("allcomments-colonia")
    @ResponseStatus(HttpStatus.OK)
    public List<commentsColonia> allCommentsColonia() {
        return commentsColoniaServicio.obtenerCommentsColonia();
    }

    @GetMapping("/comment-colonia/{id}")
    @ResponseStatus(HttpStatus.OK)
    public commentsColonia commentColonia(@PathVariable long id) {
        return commentsColoniaServicio.obtenerCommentsColoniaPorId(id);
    }

    @PostMapping("/create-comment-colonia")
    @ResponseStatus(HttpStatus.OK)
    public commentsColonia guardarCommentColonia(@RequestBody commentsColonia commentColonia) {
        return commentsColoniaServicio.guardarCommentsColonia(commentColonia);
    }

    @PutMapping("/update-comment-colonia/{id}")
    @ResponseStatus(HttpStatus.OK)
    public commentsColonia actualizarCommentColonia(@RequestBody commentsColonia commentColonia, @PathVariable Long id) {
        commentsColonia commCol = commentsColoniaServicio.obtenerCommentsColoniaPorId(id);
        commCol.setContenido(commentColonia.getContenido());
        commCol.setUserId(commentColonia.getUserId());
        commCol.setPostColoniaId(commentColonia.getPostColoniaId());
        commCol.setFechaCreacion(commentColonia.getFechaCreacion());
        return commentsColoniaServicio.guardarCommentsColonia(commCol);
    }

    @DeleteMapping("/delete-comment-colonia/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarCommentColonia(@PathVariable long id) {
        commentsColoniaServicio.eliminarCommentsColonia(id);
    }
}
