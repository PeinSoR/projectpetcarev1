package com.projectframe.mx.petcare.dominio.infraestructura;

import com.projectframe.mx.petcare.dominio.aplicacion.imagenesMascotaServicio;
import com.projectframe.mx.petcare.dominio.aplicacion.usuariosServicio;
import com.projectframe.mx.petcare.dominio.entidades.imagenesMascota;
import com.projectframe.mx.petcare.dominio.entidades.usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/petcare")
public class imagenesMascotaControlador {
    @Autowired
    private imagenesMascotaServicio imagenesMascotaServicio;

    @Autowired
    private usuariosServicio usuariosServicio;

    @GetMapping("/allimagenesmascotas")
    @ResponseStatus(HttpStatus.OK)
    public List<imagenesMascota> allimagenesMascotas() {
        return imagenesMascotaServicio.obtenerImagenesMascota();
    }

    @GetMapping("/imagen-mascota/{id}")
    @ResponseStatus(HttpStatus.OK)
    public imagenesMascota imagenesMascota(@PathVariable Long id) {
        return imagenesMascotaServicio.obtenerImagenesMascotaPorId(id);
    }

    @PostMapping("/create-imagen-mascota")
    @ResponseStatus(HttpStatus.OK)
    public imagenesMascota guardarImagenMascota(@RequestBody imagenesMascota imagenMascota) {
        usuarios user = usuariosServicio.obtenerUsuarioPorId(imagenMascota.getMascotaId());
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe");
        }
        return imagenesMascotaServicio.guardarImagenesMascota(imagenMascota);
    }

    @PutMapping("/update-imagen-mascota/{id}")
    @ResponseStatus(HttpStatus.OK)
    public imagenesMascota actualizarImagenesMascota(@RequestBody imagenesMascota imagenMascota, @PathVariable Long id) {
        imagenesMascota imgM = imagenesMascotaServicio.obtenerImagenesMascotaPorId(id);
        imgM.setMascotaId(imagenMascota.getMascotaId());
        imgM.setRuta(imagenMascota.getRuta());
        imgM.setFechaSubida(imagenMascota.getFechaSubida());
        return imagenesMascotaServicio.guardarImagenesMascota(imgM);
    }

    @DeleteMapping("/delete-imagen-mascota/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarImagenesMascota(@PathVariable Long id) {
        imagenesMascotaServicio.eliminarImagenesMascota(id);
    }
}
