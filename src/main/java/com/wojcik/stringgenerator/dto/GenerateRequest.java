package com.wojcik.stringgenerator.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenerateRequest {
    String chars;
    int min;
    int max;
    int numberOfStrings;
}
