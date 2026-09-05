package com.schmitt.conversao_temperaturas.dto;

import com.schmitt.conversao_temperaturas.enuns.TemperaturasUnidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ConversaoRequestDto {
    private double valor;
    private TemperaturasUnidade unidadeOrigem;
    private TemperaturasUnidade unidadeDestino;
}
