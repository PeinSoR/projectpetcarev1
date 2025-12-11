package com.projectframe.mx.petcare.dominio.infraestructura;

import com.projectframe.mx.petcare.dominio.aplicacion.solicitudesAdopcionServicio;
import com.projectframe.mx.petcare.dominio.aplicacion.usuariosServicio;
import com.projectframe.mx.petcare.dominio.entidades.solicitudesAdopcion;
import com.projectframe.mx.petcare.dominio.entidades.usuarios;
import com.projectframe.mx.petcare.dominio.service.EmailService;
import com.projectframe.mx.petcare.dominio.service.SolicitudPdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/petcare")
public class solicitudesAdopcionControlador {
    @Autowired
    private solicitudesAdopcionServicio solicitudesAdopcionServicio;

    @Autowired
    private usuariosServicio usuariosServicio;
    @Autowired
    private EmailService emailService;
    @Autowired
    private SolicitudPdfService pdfService;


    @GetMapping("/allsolicitudes-adopcion")
    @ResponseStatus(HttpStatus.OK)
    public List<solicitudesAdopcion> obtenerSolicitudesAdopcion() {
        return solicitudesAdopcionServicio.obtenerSolicitudesServicio();
    }

    @GetMapping("/solicitud-adopcion/{id}")
    @ResponseStatus(HttpStatus.OK)
    public solicitudesAdopcion  obtenerSolicitudAdopcion(@PathVariable Long id) {
        return solicitudesAdopcionServicio.obtenerSolicitudesServicioPorId(id);
    }

    @PostMapping("/create-solicitud-adopcion")
    @ResponseStatus(HttpStatus.OK)
    public solicitudesAdopcion guardarSolicitudAdopcion(@RequestBody solicitudesAdopcion solicitud) {
        solicitudesAdopcion nuevaSolicitud = solicitudesAdopcionServicio.guardarSolicitudesAdopcionServicio(solicitud);
        usuarios user = usuariosServicio.obtenerUsuarioPorId(solicitud.getSolicitanteId());
        String emailUsuario = user.getEmail();

        byte[] pdf = pdfService.generarPdf(nuevaSolicitud);

        String asunto = "Solicitud de adopción registrada";
        String contenido = "Hola " + user.getNombre() + " :)"
                + "Tu solicitud de adopción ha sido registrada correctamente."
                + "Se adjunta un PDF con los detalles.";

        emailService.sendEmailWithAttachment(
                emailUsuario,
                asunto,
                contenido,
                pdf,
                "solicitud_adopcion_" + nuevaSolicitud.getId() + ".pdf"
        );
    return nuevaSolicitud;
    }

    @PutMapping("/update-solicitud-adopcion/{id}")
    @ResponseStatus(HttpStatus.OK)
    public solicitudesAdopcion  actualizarSolicitudAdopcion(@PathVariable Long id, @RequestBody solicitudesAdopcion solicitud) {
        solicitudesAdopcion sa = solicitudesAdopcionServicio.obtenerSolicitudesServicioPorId(id);
        sa.setAdopcionId(solicitud.getAdopcionId());
        sa.setSolicitanteId(solicitud.getSolicitanteId());
        sa.setEstado(solicitud.getEstado());
        sa.setMensaje(solicitud.getMensaje());
        sa.setFechaSolicitud(solicitud.getFechaSolicitud());
        sa.setCreatedAt(solicitud.getCreatedAt());
        return solicitudesAdopcionServicio.guardarSolicitudesAdopcionServicio(sa);
    }

    @DeleteMapping("/delete-solicitud-adopcion/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarSolicitud(@PathVariable Long id){
        solicitudesAdopcionServicio.eliminarSolicitudesServicio(id);
    }
}
