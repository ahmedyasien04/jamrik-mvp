package com.example.demo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jamrik")
public class JamrikController {
    private final JamrikService jamrikService;
    public JamrikController(JamrikService jamrikService) {
        this.jamrikService = jamrikService;
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

}
