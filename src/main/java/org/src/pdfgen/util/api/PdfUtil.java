package org.src.pdfgen.util.api;

import com.lowagie.text.DocumentException;
import java.io.ByteArrayOutputStream;

public interface PdfUtil {

    public ByteArrayOutputStream exportPdf(String pdfHtmlString) throws DocumentException;
}
