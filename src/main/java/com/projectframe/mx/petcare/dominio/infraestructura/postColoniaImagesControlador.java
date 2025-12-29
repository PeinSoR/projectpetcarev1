package com.projectframe.mx.petcare.dominio.infraestructura;

import com.projectframe.mx.petcare.dominio.aplicacion.coloniasServicio;
import com.projectframe.mx.petcare.dominio.aplicacion.postColoniaImagesServicio;
import com.projectframe.mx.petcare.dominio.aplicacion.postsColoniaServicio;
import com.projectframe.mx.petcare.dominio.aplicacion.usuariosServicio;
import com.projectframe.mx.petcare.dominio.entidades.colonias;
import com.projectframe.mx.petcare.dominio.entidades.postColoniaImages;
import com.projectframe.mx.petcare.dominio.entidades.usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.projectframe.mx.petcare.dominio.entidades.postsColonia;

import java.util.List;

@RestController
@RequestMapping("api/petcare")
public class postColoniaImagesControlador {
    @Autowired
    private postColoniaImagesServicio postColoniaImagesServicio;

    @Autowired
    private usuariosServicio usuariosServicio;
    @Autowired
    private postsColoniaServicio postsColoniaServicio;

    @GetMapping("/allpost-colonia-images")
    @ResponseStatus(HttpStatus.OK)
    public List<postColoniaImages> obtenerPostColoniaImages() {
        return postColoniaImagesServicio.obtenerPostColoniaImages();
    }

    @GetMapping("/post-colonia-images/{id}")
    @ResponseStatus(HttpStatus.OK)
    public postColoniaImages obtenerPostColoniaImages(@PathVariable Long id) {
        return postColoniaImagesServicio.obtenerPostColoniaImagesPorId(id);
    }

    @PostMapping("/create-post-colonia-images")
    @ResponseStatus(HttpStatus.OK)
    public postColoniaImages guardarPostColoniaImages(@RequestBody postColoniaImages postColoniaImages) {
        usuarios user = usuariosServicio.obtenerUsuarioPorId(postColoniaImages.getUsuarioId());
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe");
        }
        postsColonia col = postsColoniaServicio.obtenerPostsPorId(postColoniaImages.getPostColoniaId());
        if (col == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La colonia no existe");
        }
        return postColoniaImagesServicio.guardarPostColoniaImages(postColoniaImages);
    }

    @PutMapping("/update-post-colonia-images/{id}")
    @ResponseStatus(HttpStatus.OK)
    public postColoniaImages actualizarPostColoniaImages(@PathVariable Long id, @RequestBody postColoniaImages postColoniaImages) {
        postColoniaImages pci = postColoniaImagesServicio.obtenerPostColoniaImagesPorId(id);
        pci.setPostColoniaId(postColoniaImages.getPostColoniaId());
        pci.setUsuarioId(postColoniaImages.getUsuarioId());
        pci.setImagePath(postColoniaImages.getImagePath());
        pci.setFechaCreacion(postColoniaImages.getFechaCreacion());
        return postColoniaImagesServicio.guardarPostColoniaImages(pci);
    }

    @DeleteMapping("/delete-post-colonia-images/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePostColoniaImages(@PathVariable Long id) {
        postColoniaImagesServicio.eliminarPostColoniaImages(id);
    }
}
