package com.wojcik.stringgenerator.service;

import com.wojcik.stringgenerator.Generator;
import com.wojcik.stringgenerator.dto.GenerateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@RequiredArgsConstructor
public class GeneratorService {

    int processCounter = 0;

    public String generateStrings(GenerateRequest request) {
        if (request.getMin() > request.getMax())
            throw new IllegalArgumentException("Min value is bigger than max value");

        processCounter++;
        String generatedStrings = Generator.generate(request);

        return createFile(generatedStrings);
    }

    public String createFile(String data) {
        int fileIndex = 1;
        Path filePath = Path.of(String.format("%s\\file%s.txt", System.getProperty("user.dir"), fileIndex));
        while (Files.exists(filePath)) {
            fileIndex++;
            filePath = Path.of(String.format("%s\\file%s.txt", System.getProperty("user.dir"), fileIndex));
        }
        try (PrintWriter out = new PrintWriter(String.format("file%s.txt", fileIndex))) {
            out.println(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        processCounter--;
        return String.format("file%s.txt", fileIndex);
    }

    public String getProcessCounter() {
        return "Active processes: " + processCounter;
    }


}
