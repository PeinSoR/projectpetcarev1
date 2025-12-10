package com.projectframe.mx.petcare.dominio.infraestructura;

import com.projectframe.mx.petcare.dominio.aplicacion.likesServicio;
import com.projectframe.mx.petcare.dominio.aplicacion.usuariosServicio;
import com.projectframe.mx.petcare.dominio.entidades.likes;
import com.projectframe.mx.petcare.dominio.entidades.usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/petcare")
public class likesControlador {
    @Autowired
    private likesServicio likesServicio;

    @Autowired
    private usuariosServicio usuariosServicio;

    @GetMapping("/alllikes")
    @ResponseStatus(HttpStatus.OK)
    public List<likes> obtenerAllLikes() {
        return likesServicio.obtenerLikes();
    }

    @GetMapping("/like/{id}")
    @ResponseStatus(HttpStatus.OK)
    public likes obtenerLikesPorId(@PathVariable Long id) {
        return likesServicio.obtenerLikesPorId(id);
    }

    @PostMapping("/create-like")
    @ResponseStatus(HttpStatus.OK)
    public likes crearLikes(@RequestBody likes likes) {
        usuarios user = usuariosServicio.obtenerUsuarioPorId(likes.getUserId());
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe");
        }
        return likesServicio.guardarLikes(likes);
    }

    @PutMapping("/update-like/{id}")
    @ResponseStatus(HttpStatus.OK)
    public likes updateLikes(@RequestBody likes likes,
                            @PathVariable Long id) {
        likes li = likesServicio.obtenerLikesPorId(id);
        li.setPostId(likes.getPostId());
        li.setUserId(likes.getUserId());
        return likesServicio.guardarLikes(li);
    }

    @DeleteMapping("delete-likes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarLikesPorId(@PathVariable Long id) {
        likesServicio.eliminarLikes(id);
    }
}
