package com.schmitt.conversao_temperaturas.dto;

import com.schmitt.conversao_temperaturas.enuns.TemperaturasUnidade;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ConversaoRequestDto {
    private double valor;
    private TemperaturasUnidade unidadeOrigem;
    private TemperaturasUnidade unidadeDestino;
}
