package com.projectframe.mx.petcare.dominio.infraestructura;

import com.projectframe.mx.petcare.dominio.aplicacion.mascotasServicio;
import com.projectframe.mx.petcare.dominio.aplicacion.usuariosServicio;
import com.projectframe.mx.petcare.dominio.entidades.mascotas;
import com.projectframe.mx.petcare.dominio.entidades.usuarios;


import com.projectframe.mx.petcare.dominio.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/petcare")
public class mascotasControlador {
    @Autowired
    private EmailService emailService;
    @Autowired
    private mascotasServicio mascotasServicio;
    @Autowired
    private usuariosServicio usuariosServicio;

    @GetMapping("/allmascotas")
    @ResponseStatus(HttpStatus.OK)
    public List<mascotas> allMascotas() { return mascotasServicio.obtenerMascotas(); }

    @GetMapping("/mascota/{id}")
    @ResponseStatus(HttpStatus.OK)
    public mascotas obtenerMascotas(@PathVariable Long id) {
        return mascotasServicio.obtenerMascotasPorId(id);
    }

    @PostMapping("/create-mascota")
    @ResponseStatus(HttpStatus.OK)
    public mascotas guardarMascotas(@RequestBody mascotas mascotas) {
        usuarios user = usuariosServicio.obtenerUsuarioPorId(mascotas.getUsuarioId());
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe");
        }

        String texto = "Se ha registrado tu mascota exitosamente en nuestra base de datos";
        String to = user.getEmail();
        String subject = "Registro de Mascota en Petcare";

        emailService.sendEmail(to,subject,texto);

        return mascotasServicio.guardarMascotas(mascotas);
    }

    @DeleteMapping("/delete-mascota/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarMascotas(@PathVariable Long id) {
        mascotasServicio.eliminarMascotas(id);
    }

    @PutMapping("/update-mascota/{id}")
    @ResponseStatus(HttpStatus.OK)
    public mascotas actualizarMascotas (
            @RequestBody mascotas mascotas,
            @PathVariable Long id) {
        mascotas masc =  mascotasServicio.obtenerMascotasPorId(id);
        masc.setNombre(mascotas.getNombre());
        masc.setEspecie(mascotas.getEspecie());
        masc.setRaza(mascotas.getRaza());
        masc.setGenero(mascotas.getGenero());
        masc.setPeso(mascotas.getPeso());
        masc.setVacunado(mascotas.getVacunado());
        masc.setEsterilizado(mascotas.getEsterilizado());
        masc.setDescripcion(mascotas.getDescripcion());
        masc.setTieneSeguro(mascotas.getTieneSeguro());

        String texto = "La información de tu mascota se ha actualizado exitosamente en nuestra base de datos";
        usuarios user = usuariosServicio.obtenerUsuarioPorId(mascotas.getUsuarioId());
        String to = user.getEmail();
        String subject = "Actualizacion de Mascota en Petcare";

        emailService.sendEmail(to,subject,texto);
        return mascotasServicio.guardarMascotas(masc);
    }

}
