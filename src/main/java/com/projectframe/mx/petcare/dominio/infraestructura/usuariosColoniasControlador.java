package com.projectframe.mx.petcare.dominio.infraestructura;

import com.projectframe.mx.petcare.dominio.aplicacion.coloniasServicio;
import com.projectframe.mx.petcare.dominio.aplicacion.usuariosColoniasServicio;
import com.projectframe.mx.petcare.dominio.entidades.colonias;
import com.projectframe.mx.petcare.dominio.entidades.usuariosColonias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/petcare")
public class usuariosColoniasControlador {
    @Autowired
    private usuariosColoniasServicio  usuariosColoniasServicio;

    @Autowired
    private coloniasServicio coloniasServicio;

    @GetMapping("/allusuarios-colonias")
    @ResponseStatus(HttpStatus.OK)
    public List<usuariosColonias> obtenerAllUsuariosColonias(){
        return usuariosColoniasServicio.obtenerUsuariosColonias();
    }

    @GetMapping("/usuarios-colonias/{id}")
    @ResponseStatus(HttpStatus.OK)
    public usuariosColonias obtenerUsuariosColonias(@PathVariable Long id){
        return usuariosColoniasServicio.obtenerUsuariosColoniasPorId(id);
    }

    @PostMapping("/create-usuarios-colonias")
    @ResponseStatus(HttpStatus.OK)
    public usuariosColonias guardarUsuariosColonias(@RequestBody usuariosColonias usuariosColonias){
        colonias col = coloniasServicio.obtenerColoniaPorId(usuariosColonias.getColoniaId());
        if (col == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La colonia no existe");
        }
        return usuariosColoniasServicio.guardarUsuariosColonias(usuariosColonias);
    }

    @PutMapping("/update-usuarios-colonias/{id}")
    @ResponseStatus(HttpStatus.OK)
    public usuariosColonias actualizarUsuarioColonia(@RequestBody usuariosColonias usuariosColonias, @PathVariable Long id){
        usuariosColonias uc =  usuariosColoniasServicio.obtenerUsuariosColoniasPorId(id);
        uc.setColoniaId(usuariosColonias.getColoniaId());
        uc.setUsuarioId(usuariosColonias.getUsuarioId());
        uc.setFechaRegistro(usuariosColonias.getFechaRegistro());
        return usuariosColoniasServicio.guardarUsuariosColonias(uc);
    }

    @DeleteMapping("/delete-usuarios-colonias/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarUsuarioColonia(@PathVariable Long id){
        usuariosColoniasServicio.eliminarUsuariosColonias(id);
    }
}
