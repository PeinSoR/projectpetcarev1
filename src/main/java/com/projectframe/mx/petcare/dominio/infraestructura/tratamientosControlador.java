package com.projectframe.mx.petcare.dominio.infraestructura;

import com.projectframe.mx.petcare.dominio.aplicacion.tratamientosServicio;
import com.projectframe.mx.petcare.dominio.aplicacion.usuariosServicio;
import com.projectframe.mx.petcare.dominio.entidades.tratamientos;
import com.projectframe.mx.petcare.dominio.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/petcare")
public class tratamientosControlador {
    @Autowired
    private tratamientosServicio tratamientosServicio;

    @Autowired
    private usuariosServicio usuariosServicio;
    @Autowired
    private EmailService emailService;

    @GetMapping("/alltratamientos")
    @ResponseStatus(HttpStatus.OK)
    public List<tratamientos> obtenerAllTratamientos(){
        return tratamientosServicio.obtenerTratamientosServicio();
    }

    @GetMapping("/tratamiento/{id}")
    @ResponseStatus(HttpStatus.OK)
    public tratamientos obtenerTratamiento(@PathVariable Long id){
        return tratamientosServicio.obtenerTratamientosPorId(id);
    }

    @PostMapping("/create-tratamiento")
    @ResponseStatus(HttpStatus.OK)
    public tratamientos guardarTratamiento(@RequestBody tratamientos tratamiento){
        return tratamientosServicio.guardarTratamientos(tratamiento);
    }

    @PutMapping("/update-tratamiento/{id}")
    @ResponseStatus(HttpStatus.OK)
    public tratamientos actualizarTratamiento(@RequestBody tratamientos tratamiento, @PathVariable Long id){
        tratamientos tr =  tratamientosServicio.obtenerTratamientosPorId(id);
        tr.setCosto(tratamiento.getCosto());
        tr.setTipoTratamiento(tratamiento.getTipoTratamiento());
        tr.setDescripcion(tratamiento.getDescripcion());
        tr.setMascotaId(tratamiento.getMascotaId());
        tr.setUsuarioId(tratamiento.getUsuarioId());
        tr.setVeterinario(tratamiento.getVeterinario());
        tr.setFecha(tratamiento.getFecha());
        tr.setCreatedAt(tratamiento.getCreatedAt());
        return tratamientosServicio.guardarTratamientos(tr);
    }

    @DeleteMapping("/delete-tratamiento/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarTratamiento(@PathVariable Long id){
        tratamientosServicio.eliminarTratamientosServicio(id);
    }


}
