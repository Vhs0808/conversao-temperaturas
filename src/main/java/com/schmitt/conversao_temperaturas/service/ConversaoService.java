package com.schmitt.conversao_temperaturas.service;

import com.schmitt.conversao_temperaturas.dto.ConversaoRequestDto;
import com.schmitt.conversao_temperaturas.dto.ConversaoResponseDto;
import com.schmitt.conversao_temperaturas.enuns.TemperaturasUnidade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ConversaoService {

    private final TemperaturasUnidade unidade;

    public ConversaoResponseDto converteTemperatura(ConversaoRequestDto request) {
        final TemperaturasUnidade unidadeOrigem = request.getUnidadeOrigem();
        final TemperaturasUnidade unidadeDestino = request.getUnidadeDestino();
        final double valor = request.getValor();

        if (unidadeOrigem == unidadeDestino)
            return new ConversaoResponseDto(valor, unidadeDestino);

        return unidadeOrigem == TemperaturasUnidade.CELSIUS ?
            new ConversaoResponseDto((valor) * 9 / 5 + 32, TemperaturasUnidade.FAHRENHEIT) :
            new ConversaoResponseDto((valor - 32) * 5 / 9, TemperaturasUnidade.CELSIUS);

    }
}
