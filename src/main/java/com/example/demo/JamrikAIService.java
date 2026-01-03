package com.example.demo;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class JamrikAIService {
    private final ChatClient chatclient;
    public JamrikAIService(ChatClient.Builder builder){
        this.chatclient = builder.build();
    }
//    public String getHSCode(String productName,String description){
//        String SystemPrompt= """
//        Based on the official customs website,give me the three most fitting
//              HS Codes for the specified product, based on its description.
//                """;
//        String UserPrompt= """
//                Product Name: {name}
//                Description: {desc}
//                """;
//        return chatclient.prompt().system(SystemPrompt)
//                .user(u->u.text(UserPrompt)
//                .param("name",productName)
//                .param("desc",description))
//                .call().content();
//    }
    public String getHSCode(String productName, String description) {
        try {
         ChatResponse response = chatclient.prompt()
         .system("You are an HS Code expert.") // Simpler system prompt
          .user(u -> u.text("Product: {name}, Description: {desc}")
           .param("name", productName)
           .param("desc", description))
           .call()
            .chatResponse();

            // If Gemini blocks the answer, response will be valid but result will be empty
    if (response.getResult() == null || response==null) {
      return "Gemini blocked this response. MetaData: " + response.getMetadata().toString();
            }
            return response.getResult().getOutput().getText();
        } catch (Exception e) {
            // This will print the full error in your Docker logs
            e.printStackTrace();
            return "Internal Error: " + e.getMessage();
        }
    }
}
