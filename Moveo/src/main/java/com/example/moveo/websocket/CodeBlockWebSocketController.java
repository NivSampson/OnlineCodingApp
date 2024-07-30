package com.example.moveo.websocket;


import com.example.moveo.model.CodeBlock;
import com.example.moveo.repository.CodeBlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
@Controller
public class CodeBlockWebSocketController {

    @Autowired
    private CodeBlockRepository codeBlockRepository;

    @MessageMapping("/updateCodeBlock")
    @SendTo("/topic/codeblocks")
    public CodeBlock updateCodeBlock(CodeBlock codeBlock) {
        return codeBlockRepository.save(codeBlock);
    }
}