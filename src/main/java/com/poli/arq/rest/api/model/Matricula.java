package com.poli.arq.rest.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matricula {
    private Long id;
    private Long estudianteId;
    private Long cursoId;
}
