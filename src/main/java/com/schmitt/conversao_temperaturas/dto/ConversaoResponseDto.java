package com.schmitt.conversao_temperaturas.dto;

import com.schmitt.conversao_temperaturas.enuns.TemperaturasUnidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConversaoResponseDto {
    private double temperatura;
    private TemperaturasUnidade unidade;

}
