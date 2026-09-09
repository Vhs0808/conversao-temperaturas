package com.schmitt.conversao_temperaturas.service;

import com.schmitt.conversao_temperaturas.dto.ConversaoRequestDto;
import com.schmitt.conversao_temperaturas.dto.ConversaoResponseDto;
import com.schmitt.conversao_temperaturas.enuns.TemperaturasUnidade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@AllArgsConstructor
@Service
public class ConversaoService {

    public ConversaoResponseDto converteTemperatura(ConversaoRequestDto request) {
        final TemperaturasUnidade unidadeOrigem = request.getUnidadeOrigem();
        final TemperaturasUnidade unidadeDestino = request.getUnidadeDestino();
        double valor = request.getValor();

        if (unidadeOrigem == unidadeDestino) return new ConversaoResponseDto(valor, unidadeDestino);

        ConversaoResponseDto response = switch (unidadeOrigem){
            case CELSIUS -> new ConversaoResponseDto(converterCelsius(valor, unidadeDestino), unidadeDestino);
            case FAHRENHEIT -> new ConversaoResponseDto(converterFahrenheit(valor, unidadeDestino), unidadeDestino);
            case KELVIN -> new ConversaoResponseDto(converterKelvin(valor, unidadeDestino), unidadeDestino);
        };

        double valorFormatado = Math.round(response.getTemperatura() * 100.0) / 100.0;
        response.setTemperatura(valorFormatado);

        return response;
    }

    private double converterCelsius(double valor, TemperaturasUnidade unidadeDestino) {
        switch (unidadeDestino) {
            case FAHRENHEIT:
                return (valor * 9 / 5) + 32;
            case KELVIN:
                return valor + 273.15;
            default:
                throw new IllegalArgumentException("Unidade de destino inválida: " + unidadeDestino);
        }
    }

    private double converterFahrenheit(double valor, TemperaturasUnidade unidadeDestino) {
        switch (unidadeDestino) {
            case CELSIUS:
                return (valor - 32) * 5 / 9;
            case KELVIN:
                return (valor - 32) * 5 / 9 + 273.15;
            default:
                throw new IllegalArgumentException("Unidade de destino inválida: " + unidadeDestino);
        }
    }

    private double converterKelvin(double valor, TemperaturasUnidade unidadeDestino) {
        switch (unidadeDestino) {
            case CELSIUS:
                return valor - 273.15;
            case FAHRENHEIT:
                return (valor - 273.15) * 9 / 5 + 32;
            default:
                throw new IllegalArgumentException("Unidade de destino inválida: " + unidadeDestino);
        }
    }
}
