package com.example.demo;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class JamrikAIService {
    //Autowiring via constructor injection
    private final ChatClient chatclient;
    public JamrikAIService(ChatClient.Builder builder){
        this.chatclient = builder.build();
    }
    public String getHSCode(String productName, String description) {
        //exception handling the request to not crash in case of an internal error
        try {
         ChatResponse response = chatclient.prompt()
        //system prompt
         .system("""
                 You are an HS Code expert, give me the 11 digit HS code 
                 based on the information on the jordanian customs website,
                 only return the correct code with no explanation""")
      .user(u -> u.text("Product: {name}, Description: {desc}")//user request
        .param("name", productName).param("desc", description))
           .call()
            .chatResponse();
       // If Gemini blocks the answer, response will be valid but result will be empty
    if (response.getResult() == null || response==null) {
      return "Gemini blocked this response. MetaData: " + response.getMetadata().toString();
            }
            return response.getResult().getOutput().getText();
        } catch (Exception e) {
            // This will print the full error in docker logs
            e.printStackTrace();
            return "Internal Error: " + e.getMessage();
        }
    }
}
