package com.example.learn_spring_security.Controller;

import com.example.learn_spring_security.Service.UserService;
import com.example.learn_spring_security.dto.CreateNewUserDTO;
import com.example.learn_spring_security.model.AuthResponse;
import com.example.learn_spring_security.ulti.CrossOriginSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JwtEncoder jwtEncoder;

    @CrossOrigin(origins = CrossOriginSite.CORS_SITE)
    @PostMapping("/register")
    public ResponseEntity<?> registerNewUser(@RequestBody CreateNewUserDTO body) {
        return this.userService.addNewUser(body);
    }

    @CrossOrigin(origins = CrossOriginSite.CORS_SITE)
    @PostMapping("login")
    public ResponseEntity<AuthResponse> Login(Authentication authentication) {
        return ResponseEntity.ok(new AuthResponse(CreateToken(authentication)));
    }

    private String CreateToken(Authentication authentication){
        var jwtClaimSet = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(60*30))
                .subject(authentication.getName())
                .claim("role",authentication.getAuthorities())
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimSet)).getTokenValue();
    }

    @CrossOrigin(origins = CrossOriginSite.CORS_SITE)
    @GetMapping("/hello")
    public String test(@RequestBody CreateNewUserDTO body) {
        return "Hello World";
    }
}
