package com.example.demo;
import org.springframework.stereotype.Service;

@Service
public class JamrikService {
    //autowiring via constructor injection on the repo bean
    private final JamrikRepository jamrikRepo;
    public JamrikService(JamrikRepository jamrikRepo){
        this.jamrikRepo = jamrikRepo;
    }
public User register(User user){
  //check if the user is already in db
if(jamrikRepo.findByUserName(user.getUserName()).isPresent()){
    throw new RuntimeException("Username already exists");
}
//if new user, save info in db
//password won't be hashed in this stage, only saved as is the db
     return jamrikRepo.save(user);
}
public User login(String username,String password){
       // using stream to find the user from db to enable login, if valid credentials
        return jamrikRepo.findByUserName(username)
             .filter(u->u.getPassword().equals(password))
             .orElseThrow(()->new RuntimeException("Invalid username or password"));
}

}
