package com.projectframe.mx.petcare.dominio.infraestructura;

import com.projectframe.mx.petcare.dominio.aplicacion.coloniasServicio;
import com.projectframe.mx.petcare.dominio.aplicacion.usuariosServicio;
import com.projectframe.mx.petcare.dominio.entidades.colonias;
import com.projectframe.mx.petcare.dominio.entidades.postsColonia;
import com.projectframe.mx.petcare.dominio.aplicacion.postsColoniaServicio;
import com.projectframe.mx.petcare.dominio.entidades.usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/petcare")
public class postsColoniaControlador {
    @Autowired
    private postsColoniaServicio postsColoniaServicio;

    @Autowired
    private usuariosServicio usuariosServicio;
    @Autowired
    private coloniasServicio coloniasServicio;

    @GetMapping("/allposts-colonia")
    @ResponseStatus(HttpStatus.OK)
    public List<postsColonia> obtenerAllPostsColonia() {
        return postsColoniaServicio.obtenerPostsColonia();
    }

    @GetMapping("/post-colonia/{id}")
    @ResponseStatus(HttpStatus.OK)
    public postsColonia obtenerPostsColonia(@PathVariable Long id) {
        return postsColoniaServicio.obtenerPostsPorId(id);
    }

    @PostMapping("/create-post-colonia")
    @ResponseStatus(HttpStatus.OK)
    public postsColonia guardarPostsColonia(@RequestBody postsColonia postsColonia) {
        usuarios user = usuariosServicio.obtenerUsuarioPorId(postsColonia.getUsuarioId());
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe");
        }
        colonias col = coloniasServicio.obtenerColoniaPorId(postsColonia.getColoniaId());
        if (col == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La colonia no existe");
        }
        return postsColoniaServicio.guardarPostsColonia(postsColonia);
    }

    @PutMapping("/update-posts-colonia/{id}")
    @ResponseStatus(HttpStatus.OK)
    public postsColonia actualizarPostColonia(@PathVariable Long id, @RequestBody postsColonia postsColonia) {
        postsColonia pocol = postsColoniaServicio.obtenerPostsPorId(id);
        pocol.setColoniaId(postsColonia.getColoniaId());
        pocol.setContenido(postsColonia.getContenido());
        pocol.setEsAlerta(postsColonia.getEsAlerta());
        pocol.setUsuarioId(postsColonia.getUsuarioId());
        pocol.setFechaCreacion(postsColonia.getFechaCreacion());
        return postsColoniaServicio.guardarPostsColonia(pocol);
    }

    @DeleteMapping("/delete-post-colonia/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarPostsColonia(@PathVariable Long id) {
        postsColoniaServicio.eliminarPostsColonia(id);
    }
}
