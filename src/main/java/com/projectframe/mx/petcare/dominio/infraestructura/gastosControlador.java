package com.projectframe.mx.petcare.dominio.infraestructura;

import com.projectframe.mx.petcare.dominio.aplicacion.gastosServicio;
import com.projectframe.mx.petcare.dominio.aplicacion.usuariosServicio;
import com.projectframe.mx.petcare.dominio.entidades.gastos;
import com.projectframe.mx.petcare.dominio.entidades.usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/petcare")
public class gastosControlador {
    @Autowired
    private gastosServicio gastosServicio;

    @Autowired
    private usuariosServicio usuariosServicio;

    @GetMapping("/allgastos")
    @ResponseStatus(HttpStatus.OK)
    public List<gastos> obtenerGastos() {
        return gastosServicio.obtenerGastos();
    }

    @GetMapping("gasto/{id}")
    @ResponseStatus(HttpStatus.OK)
    public gastos obtenerGastos(@PathVariable Long id) {
        return gastosServicio.obtenerGastosPorId(id);
    }

    @PostMapping("/create-gasto")
    @ResponseStatus(HttpStatus.OK)
    public gastos guardarGastos(@RequestBody gastos gastos) {
        usuarios user = usuariosServicio.obtenerUsuarioPorId(gastos.getUsuarioId());
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe");
        }
        return gastosServicio.guardarGastos(gastos);
    }

    @PutMapping("/update-gasto/{id}")
    @ResponseStatus(HttpStatus.OK)
    public gastos actualizarGasto(@RequestBody gastos gastos, @PathVariable Long id){
        gastos gas = gastosServicio.obtenerGastosPorId(id);
        gas.setCategoria(gastos.getCategoria());
        gas.setMonto(gastos.getMonto());
        gas.setProveedor(gastos.getProveedor());
        gas.setMascotaId(gastos.getMascotaId());
        gas.setUsuarioId(gastos.getUsuarioId());
        gas.setFecha(gastos.getFecha());
        gas.setFechaRecordatorio(gastos.getFechaRecordatorio());
        gas.setFechaCreacion(gastos.getFechaCreacion());
        return gastosServicio.guardarGastos(gas);
    }

    @DeleteMapping("/delete-gasto/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarGastos(@PathVariable Long id) {
        gastosServicio.eliminarGastos(id);
    }
}
