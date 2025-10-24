package com.projectframe.mx.petcare.dominio.infraestructura;

import com.projectframe.mx.petcare.dominio.aplicacion.usuariosServicio;
import com.projectframe.mx.petcare.dominio.entidades.usuarios;
import com.projectframe.mx.petcare.dominio.repositorios.usuariosRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("petcare/api")
public class usuariosControlador {
    @Autowired
    private usuariosRepositorio usersRepo;
    @Autowired
    private usuariosServicio  usuariosServicio;

    @GetMapping("/allusers")
    @ResponseStatus(HttpStatus.OK)
    public List<usuarios> obtenerUsuarios() {
        return usuariosServicio.obtenerUsuarios();
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public usuarios obtenerUsuarioPorId(@PathVariable Long id) {
        return usuariosServicio.obtenerUsuarioPorId(id);
    }

    @PostMapping("/create-user")
    @ResponseStatus(HttpStatus.CREATED)
    public usuarios crearUsuario(@RequestBody usuarios usuario) {
        return usuariosServicio.guardarUsuario(usuario);
    }

    @DeleteMapping("/delete-users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarUsuarios(@RequestBody Long id) {
        usuariosServicio.eliminarUsuario(id);
        return;
    }

    @PutMapping("/update-user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public usuarios actualizarUsuario(
            @RequestBody usuarios usuario,
            @PathVariable Long id) {
        usuarios u = usuariosServicio.obtenerUsuarioPorId(id);
        u.setNombre(usuario.getNombre());
        u.setEmail(usuario.getEmail());
        u.setPassword(usuario.getPassword());
        u.setCurp(usuario.getCurp());
        u.setTelefonoCelular(usuario.getTelefonoCelular());
        return usuariosServicio.guardarUsuario(u);
    }
    @PutMapping("/create-user/photo-profile/{id}")
    @ResponseStatus(HttpStatus.OK)
    public usuarios actualizarUsuarioPhoto(
            @RequestBody usuarios usuario,
            @PathVariable Long id) {
        usuarios u = usuariosServicio.obtenerUsuarioPorId(id);
        u.setFotoPerfil(usuario.getFotoPerfil());
        return usuariosServicio.guardarUsuario(u);
    }



}
