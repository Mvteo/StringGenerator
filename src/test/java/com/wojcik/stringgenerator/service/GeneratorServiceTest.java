package com.wojcik.stringgenerator.service;

import com.wojcik.stringgenerator.dto.GenerateRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GeneratorServiceTest {

    GeneratorService generatorService = new GeneratorService();

    @Test
    void shouldReturnFileName() {
        //given
        GenerateRequest request = GenerateRequest.builder()
                .max(5)
                .min(3)
                .numberOfStrings(5)
                .chars("abcd")
                .build();

        //when
        String result = generatorService.generateStrings(request);

        //should
        assertTrue(result.contains("file"));

    }

    @Test
    void shouldThrowExceptionWhenGivenTooSmallCombinationOfChars() {
        //given
        GenerateRequest request = GenerateRequest.builder()
                .max(5)
                .min(2)
                .numberOfStrings(300)
                .chars("ab")
                .build();
        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            generatorService.generateStrings(request);
        });
        //then
        assertTrue(exception.getMessage().contains("Expected number of strings:300"));
    }
}
