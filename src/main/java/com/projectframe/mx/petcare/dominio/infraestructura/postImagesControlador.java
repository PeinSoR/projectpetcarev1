package com.projectframe.mx.petcare.dominio.infraestructura;

import com.projectframe.mx.petcare.dominio.aplicacion.postImagesServicio;
import java.util.List;
import com.projectframe.mx.petcare.dominio.entidades.postImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/petcare")
public class postImagesControlador {
    @Autowired
    private postImagesServicio  postImagesServicio;

    @GetMapping("/allpost-images")
    @ResponseStatus(HttpStatus.OK)
    public List<postImages> obtenerAllPostImages() {
        return postImagesServicio.obtenerPostImages();
    }
    @GetMapping("/postimages/{id}")
    @ResponseStatus(HttpStatus.OK)
    public postImages obtenerPostImage(@PathVariable Long id){
        return postImagesServicio.obtenerPostImagesPorId(id);
    }

    @PostMapping("/create-postimage")
    @ResponseStatus(HttpStatus.CREATED)
    public postImages createPostImage(@RequestBody postImages postImages){
        return postImagesServicio.guardarPostImages(postImages);
    }

    @PutMapping("/update-postimage/{id}")
    @ResponseStatus(HttpStatus.OK)
    public postImages updatePostImage(@RequestBody postImages postImages, @PathVariable Long id){
        postImages pimg = postImagesServicio.obtenerPostImagesPorId(id);
        pimg.setPostId(postImages.getPostId());
        pimg.setImagePath(postImages.getImagePath());
        pimg.setUsuarioId(postImages.getUsuarioId());
        pimg.setFechaCreacion(postImages.getFechaCreacion());
        return postImagesServicio.guardarPostImages(pimg);
    }

    @DeleteMapping("/delete-postimage/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePostImage(@PathVariable Long id){
        postImagesServicio.eliminarPostImagesPorId(id);
    }

}
