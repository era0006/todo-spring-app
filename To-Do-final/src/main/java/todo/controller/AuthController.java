package todo.controller;

import todo.dto.DtoLoginRequest;
import todo.dto.DtoUser;
import todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody DtoLoginRequest loginRequest) {
        return ResponseEntity.ok("Login successful (basic auth implemented in SecurityConfig)");
    }

    @PostMapping("/register")
    public ResponseEntity<DtoUser> register(@RequestBody DtoUser dtoUser) {
        try {
            DtoUser createdUser = userService.createUser(dtoUser);
            return ResponseEntity.status(201).body(createdUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}