package com.projectframe.mx.petcare.dominio.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.projectframe.mx.petcare.dominio.entidades.solicitudesAdopcion;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class SolicitudPdfService {

    public byte[] generarPdf(solicitudesAdopcion solicitud) {
        try {
            Document document = new Document();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, out);

            document.open();

            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font bodyFont = new Font(Font.FontFamily.HELVETICA, 12);

            document.add(new Paragraph("Solicitud de Adopción", titleFont));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Folio Solicitud: " + solicitud.getId(), bodyFont));
            document.add(new Paragraph("Folio Adopción: " + solicitud.getAdopcionId(), bodyFont));
            // document.add(new Paragraph("ID Solicitante: " + solicitud.getSolicitanteId(), bodyFont));
            document.add(new Paragraph("Estado de adopción: " + solicitud.getEstado(), bodyFont));
            document.add(new Paragraph("Mensaje del solicitante: " + solicitud.getMensaje(), bodyFont));
            document.add(new Paragraph("Fecha de solicitud: " + solicitud.getFechaSolicitud(), bodyFont));
            //document.add(new Paragraph("Creado el: " + solicitud.getCreatedAt(), bodyFont));

            document.close();

            return out.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
