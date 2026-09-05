package com.schmitt.conversao_temperaturas.dto;

import com.schmitt.conversao_temperaturas.enuns.TemperaturasUnidade;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ConversaoResponseDto {
    private double temperatura;
    private TemperaturasUnidade unidade;
}
