package org.src.pdfgen.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.src.pdfgen.enums.TemplateEnum;
import org.src.pdfgen.services.api.DefaultService;
import java.io.ByteArrayInputStream;

@RestController
public class DefaultController {

    @Autowired
    DefaultService defaultService;

    @GetMapping("/preview-default-pdf-html")
    public ResponseEntity<String> viewDefaultPdfHtml() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(defaultService.pdfHtmlPreview(TemplateEnum.DEFAULT_TEMPLATE));
    }

    @GetMapping("/preview-default-pdf")
    public ResponseEntity viewDefaultPdf(@RequestParam("fileId") String fileId) throws Exception {
        byte[] pdfData = defaultService.pdfGenerate(TemplateEnum.DEFAULT_TEMPLATE).toByteArray();
        InputStreamResource inputStreamResource = new InputStreamResource(new ByteArrayInputStream(pdfData));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentLength(pdfData.length);
        headers.setContentDisposition(ContentDisposition.inline().filename("receipt_" + fileId + ".pdf").build());
        return ResponseEntity.ok()
                .headers(headers)
                .body(inputStreamResource);
    }

    @GetMapping("/download-default-pdf")
    public ResponseEntity<InputStreamResource> downloadDefaultPdf(@RequestParam("fileId") String fileId, HttpServletResponse response) throws Exception {
        byte[] pdfData = defaultService.pdfGenerate(TemplateEnum.DEFAULT_TEMPLATE).toByteArray();
        InputStreamResource inputStreamResource = new InputStreamResource(new ByteArrayInputStream(pdfData));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentLength(pdfData.length);
        headers.setContentDisposition(ContentDisposition.attachment().filename("receipt_" + fileId + ".pdf").build());
        return ResponseEntity.ok()
                .headers(headers)
                .body(inputStreamResource);
    }
}
