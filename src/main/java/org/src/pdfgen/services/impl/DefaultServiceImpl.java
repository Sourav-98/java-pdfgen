package org.src.pdfgen.services.impl;

import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.src.pdfgen.dto.DefaultDto;
import org.src.pdfgen.enums.TemplateEnum;
import org.src.pdfgen.services.api.DefaultService;
import org.src.pdfgen.util.api.PdfUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.ByteArrayOutputStream;

@Service
public class DefaultServiceImpl implements DefaultService {

    @Autowired
    TemplateEngine templateEngine;

    @Autowired
    PdfUtil pdfUtil;

    public String pdfHtmlPreview(TemplateEnum template) {

        DefaultDto defaultDto = DefaultDto.builder().id("92302395235").hello("alskdfjasdfasf").build();
        Context context = new Context();
        context.setVariable("hello", defaultDto.getHello());
        context.setVariable("id", defaultDto.getId());

        return templateEngine.process(template.getTemplateName(), context);
    }

    @Override
    public ByteArrayOutputStream pdfGenerate(TemplateEnum templateEnum) throws DocumentException {
        DefaultDto defaultDto = DefaultDto.builder().id("92302395235").hello("alskdfjasdfasf").build();
        Context context = new Context();
        context.setVariable("hello", defaultDto.getHello());
        context.setVariable("id", defaultDto.getId());
        return pdfUtil.exportPdf(templateEngine.process(templateEnum.getTemplateName(), context));
    }
}
