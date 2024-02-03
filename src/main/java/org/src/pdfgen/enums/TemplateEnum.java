package org.src.pdfgen.enums;

public enum TemplateEnum {
    DEFAULT_TEMPLATE("default_template");
    String templateName;

    TemplateEnum(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateName() {
        return templateName;
    }
}
