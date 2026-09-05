package com.schmitt.conversao_temperaturas.controller;

import com.schmitt.conversao_temperaturas.dto.ConversaoRequestDto;
import com.schmitt.conversao_temperaturas.dto.ConversaoResponseDto;
import com.schmitt.conversao_temperaturas.service.ConversaoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/temperaturas")
public class TemperaturaController {

    private final ConversaoService conversaoService;

    @PostMapping("/converter")
    public ConversaoResponseDto converteTemperatura(@RequestParam ConversaoRequestDto request){
        return conversaoService.converteTemperatura(request);
    }
}
