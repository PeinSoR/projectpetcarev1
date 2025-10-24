package com.projectframe.mx.petcare.dominio.aplicacion;

import com.projectframe.mx.petcare.dominio.entidades.usuarios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface usuariosServicio {
    public usuarios guardarUsuario(usuarios user);
    public List<usuarios> obtenerUsuarios();
    public usuarios obtenerUsuarioPorId(Long id);
    public void eliminarUsuario(Long id);
}
