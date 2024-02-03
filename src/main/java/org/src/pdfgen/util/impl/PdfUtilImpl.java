package org.src.pdfgen.util.impl;

import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.src.pdfgen.util.api.PdfUtil;
import org.thymeleaf.TemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;

@Component
public class PdfUtilImpl implements PdfUtil {

    @Autowired
    TemplateEngine templateEngine;

    @Override
    public ByteArrayOutputStream exportPdf(String pdfHtmlString) throws DocumentException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(pdfHtmlString);
        renderer.layout();
        renderer.createPDF(byteArrayOutputStream, false);
        renderer.finishPDF();
        return byteArrayOutputStream;
    }
}
