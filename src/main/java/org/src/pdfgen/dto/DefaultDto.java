package org.src.pdfgen.dto;

import lombok.*;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class DefaultDto {
    @NonNull
    @Getter
    @Setter
    private String id;
    @NonNull
    @Getter
    @Setter
    private String hello;
}
