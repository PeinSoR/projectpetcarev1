package com.projectframe.mx.petcare.dominio.infraestructura;

import com.projectframe.mx.petcare.dominio.aplicacion.likesColoniaServicio;
import com.projectframe.mx.petcare.dominio.entidades.likesColonia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/petcare")
public class likesColoniaControlador {
    @Autowired
    private likesColoniaServicio likesColoniaServicio;

    @GetMapping("/alllikes-colonia")
    @ResponseStatus(HttpStatus.OK)
    public List<likesColonia> allLikesColonia() {
        return likesColoniaServicio.obtenerLikesColonia();
    }

    @GetMapping("/likes-colonia/{id}")
    @ResponseStatus(HttpStatus.OK)
    public likesColonia obtenerLikesColonia(@PathVariable Long id) {
        return likesColoniaServicio.obtenerLikesPorId(id);
    }

    @PostMapping("/create-likes-colonia")
    @ResponseStatus(HttpStatus.OK)
    public likesColonia crearLikesColonia(@RequestBody likesColonia likesColonia) {
        return likesColoniaServicio.guardarLikesColonia(likesColonia);
    }

    @PutMapping("/update-likes-colonia/{id}")
    @ResponseStatus(HttpStatus.OK)
    public likesColonia actualizarLikesColonia(@RequestBody likesColonia likesColonia, @PathVariable Long id) {
        likesColonia liCol = likesColoniaServicio.obtenerLikesPorId(id);
        liCol.setPostColoniaId(likesColonia.getPostColoniaId());
        liCol.setUserId(likesColonia.getUserId());
        liCol.setFechaCreacion(likesColonia.getFechaCreacion());
        return likesColoniaServicio.guardarLikesColonia(liCol);
    }

    @DeleteMapping("/delete-likes-colonia/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarLikesColonia(@PathVariable Long id) {
        likesColoniaServicio.eliminarLikesColonia(id);
    }
}
