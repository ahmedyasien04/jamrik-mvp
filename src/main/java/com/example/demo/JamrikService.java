package com.example.demo;
import org.springframework.stereotype.Service;

@Service
public class JamrikService {
    private final JamrikRepository jamrikRepo;
    public JamrikService(JamrikRepository jamrikRepo){
        this.jamrikRepo = jamrikRepo;
    }
public User register(User user){
if(jamrikRepo.findByUserName(user.getUserName()).isPresent()){
    throw new RuntimeException("Username already exists");
}
     return jamrikRepo.save(user);
}
public User login(String username,String password){
        return jamrikRepo.findByUserName(username)
             .filter(u->u.getPassword().equals(password))
             .orElseThrow(()->new RuntimeException("Invalid username or password"));
}

}
