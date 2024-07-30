package com.example.moveo.controller;

import com.example.moveo.model.CodeBlock;
import com.example.moveo.repository.CodeBlockRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/codeblocks")
public class CodeBlockController {
    @Autowired
    private CodeBlockRepository codeBlockRepository;

    @GetMapping
    public List<CodeBlock> getAllCodeBlocks() {
        return codeBlockRepository.findAll();
    }

    @GetMapping("/{id}")
    public CodeBlock getCodeBlock(@PathVariable Long id) {
        return codeBlockRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CodeBlock not found"));
    }

    @PostMapping
    public CodeBlock createCodeBlock(@RequestBody CodeBlock codeBlock) {
        return codeBlockRepository.save(codeBlock);
    }



}
