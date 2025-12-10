package com.projectframe.mx.petcare.dominio.infraestructura;

import com.projectframe.mx.petcare.dominio.aplicacion.postsServicio;
import com.projectframe.mx.petcare.dominio.entidades.posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/petcare")
public class postsControlador {
    @Autowired
    postsServicio postsServicio;

    @GetMapping("/allposts")
    @ResponseStatus(HttpStatus.OK)
    public List<posts> obtenerAllPosts() {
        return postsServicio.obtenerPosts();
    }

    @GetMapping("/post/{id}")
    @ResponseStatus(HttpStatus.OK)
    public posts obtenerPostsPorId(@PathVariable Long id) {
        return postsServicio.obtenerPostsPorId(id);
    }

    @PostMapping("/create-post")
    @ResponseStatus(HttpStatus.CREATED)
    public posts crearPost(@RequestBody posts posts) {
        return postsServicio.guardarPosts(posts);
    }

    @PutMapping("/update-post/{id}")
    @ResponseStatus(HttpStatus.OK)
    public posts actualizarPosts(@RequestBody posts posts, @PathVariable Long id) {
        posts po = postsServicio.obtenerPostsPorId(id);
        po.setColoniaId(posts.getColoniaId());
        po.setContenido(posts.getContenido());
        po.setImagen(posts.getImagen());
        po.setUsuarioId(posts.getUsuarioId());
        po.setLikesCount(posts.getLikesCount());
        po.setCreatedAt(posts.getCreatedAt());
        return postsServicio.guardarPosts(po);
    }

    @DeleteMapping("/delete-post/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePosts(@PathVariable Long id) {
        postsServicio.eliminarPosts(id);
    }
}
