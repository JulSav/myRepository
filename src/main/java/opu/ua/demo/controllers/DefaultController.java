package opu.ua.demo.controllers;


import opu.ua.demo.model.AuthenticationRequest;
import opu.ua.demo.model.AuthenticationResponse;
import opu.ua.demo.security.MyUserDetailsService;
import opu.ua.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {


    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/hello")
    public String helloWorld(){
        return "<h1>Hello World<h1>";
    }


    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try{
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        }catch(BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
            }
        final UserDetails userDetails = myUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    //@GetMapping("/admin")
    //public String helloAdmin(){
    //   return "<h1>Hello Admin<h1>";
    //}

    //@GetMapping("/defuser")
    //public String helloUser(){
    //  return "<h1>Hello User<h1>";
    //}

}
