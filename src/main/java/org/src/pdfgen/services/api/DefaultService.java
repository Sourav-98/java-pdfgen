package org.src.pdfgen.services.api;

import com.lowagie.text.DocumentException;
import org.src.pdfgen.enums.TemplateEnum;

import java.io.ByteArrayOutputStream;

public interface DefaultService {

    public String pdfHtmlPreview(TemplateEnum template);

    public ByteArrayOutputStream pdfGenerate(TemplateEnum templateEnum) throws DocumentException;
}
