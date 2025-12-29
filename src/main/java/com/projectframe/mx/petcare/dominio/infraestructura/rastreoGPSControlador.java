package com.projectframe.mx.petcare.dominio.infraestructura;

import com.projectframe.mx.petcare.dominio.aplicacion.rastreoGPSServicio;
import com.projectframe.mx.petcare.dominio.entidades.rastreoGPS;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/petcare")
public class rastreoGPSControlador {
    @Autowired
    private rastreoGPSServicio rastreoGPSServicio;

    @GetMapping("/allrastreogps")
    @ResponseStatus(HttpStatus.OK)
    public List<rastreoGPS> getRastreoGPS() {
        return rastreoGPSServicio.obtenerRastreoGPS();
    }

    @GetMapping("/rastreo-gps/{id}")
    @ResponseStatus(HttpStatus.OK)
    public rastreoGPS getRastreoGPS(@PathVariable Long id) {
        return rastreoGPSServicio.obtenerRastreoGPSPorId(id);
    }

    @PostMapping("/create-rastreo-gps")
    @ResponseStatus(HttpStatus.OK)
    public rastreoGPS guardarRastreoGPS(@RequestBody rastreoGPS rastreoGPS) {
        return rastreoGPSServicio.guardarRastreoGPS(rastreoGPS);
    }

    @PutMapping("/update-rastreo-gps/{id}")
    @ResponseStatus(HttpStatus.OK)
    public rastreoGPS actualizarRastreoGPS(@RequestBody rastreoGPS rastreoGPS, @PathVariable Long id) {
        rastreoGPS rgps = rastreoGPSServicio.obtenerRastreoGPSPorId(id);
        rgps.setLongitud(rastreoGPS.getLongitud());
        rgps.setLatitud(rastreoGPS.getLatitud());
        rgps.setMascotaId(rastreoGPS.getMascotaId());
        rgps.setTimestamp(rastreoGPS.getTimestamp());
        return rastreoGPSServicio.guardarRastreoGPS(rgps);
    }

    @DeleteMapping("/delete-rastreo-gps/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarRastreoGPS(@PathVariable Long id) {
        rastreoGPSServicio.eliminarRastreoGPS(id);
    }
}
