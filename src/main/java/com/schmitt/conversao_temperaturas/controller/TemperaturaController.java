package com.schmitt.conversao_temperaturas.controller;

import com.schmitt.conversao_temperaturas.dto.ConversaoRequestDto;
import com.schmitt.conversao_temperaturas.dto.ConversaoResponseDto;
import com.schmitt.conversao_temperaturas.service.ConversaoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/temperaturas")
public class TemperaturaController {

    private final ConversaoService conversaoService;

    @PostMapping("/converter")
    public ConversaoResponseDto converteTemperatura(@RequestBody ConversaoRequestDto request){
        return conversaoService.converteTemperatura(request);
    }
}
