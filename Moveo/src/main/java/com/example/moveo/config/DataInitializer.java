package com.example.moveo.config;

import com.example.moveo.model.CodeBlock;
import com.example.moveo.repository.CodeBlockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
public class DataInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @Autowired
    private CodeBlockRepository codeBlockRepository;

    @PostConstruct
    public void init() {
        logger.info("Initializing data...");

        CodeBlock block1 = new CodeBlock("Async case", "async function example() { /* code here */ }");
        CodeBlock block2 = new CodeBlock("Promise case", "function promiseExample() { /* code here */ }");
        CodeBlock block3 = new CodeBlock("Callback case", "function callbackExample() { /* code here */ }");
        CodeBlock block4 = new CodeBlock("Event case", "function eventExample() { /* code here */ }");

        codeBlockRepository.saveAll(Arrays.asList(block1, block2, block3, block4));

        logger.info("Data initialization completed.");
    }
}