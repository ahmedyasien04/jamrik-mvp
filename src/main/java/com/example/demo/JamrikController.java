package com.example.demo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jamrik")
public class JamrikController {
    //Autowiring the service and AI service classes via constructor injection
    private final JamrikService jamrikService;
    private final JamrikAIService aiService;
    public JamrikController(JamrikService jamrikService, JamrikAIService aiService) {
        this.jamrikService = jamrikService;
        this.aiService = aiService;
    }
@PostMapping("/register")
    public User register(@RequestBody User user){
        return jamrikService.register(user);
}
@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        User found=jamrikService.login(user.getUserName(),user.getPassword());
        if(found!=null){
            return ResponseEntity.ok(found);
        }
           return ResponseEntity.status(401).body("Invalid username or password");
}
@GetMapping("/hs")
public String getHSCode(@RequestParam String productName,
                        @RequestParam String description){
        return aiService.getHSCode(productName,description);
}

}
