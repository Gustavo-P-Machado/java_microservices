package br.edu.atitus.greeting_service.controllers;

import br.edu.atitus.greeting_service.configs.GreetingConfig;
import br.edu.atitus.greeting_service.entities.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("greeting")
public class GreetingController {

//    @Value("${greeting-service.greeting}")
//    private String greeting;
//    @Value("${greeting-service.default.name}")
//    private String defaultName;

    private final GreetingConfig config;

    public GreetingController(GreetingConfig config) {
        this.config = config;
    }

    @GetMapping
    // Recebe o nome do usuário como parâmetro
    public ResponseEntity<String> greet(
            @RequestParam(required = false) String name) {

        String greetingReturn = config.getGreeting();
        String nameReturn = name != null ? name : config.getDefaultName();
        String textReturn = String.format("%s, %s!!!", greetingReturn, nameReturn);
        return ResponseEntity.ok(textReturn);

    }

    @GetMapping
    @RequestMapping("/{name}")
    // Recebe o nome do usuário pela URL
    public  ResponseEntity<String> pathGreet(@PathVariable String name) {

        String greetingReturn = config.getGreeting();
        String nameReturn = name != null ? name : config.getDefaultName();
        String textReturn = String.format("%s, %s!!!", greetingReturn, nameReturn);
        return ResponseEntity.ok(textReturn);

    }

    @PostMapping
    // Recebe o nome do usuário como JSON pelo body
    public  ResponseEntity<String> bodyGreet(@RequestBody UserEntity user) {

        String greetingReturn = config.getGreeting();
        String nameReturn = user.getName() != null ? user.getName() : config.getDefaultName();
        String textReturn = String.format("%s, %s!!!", greetingReturn, nameReturn);
        return ResponseEntity.ok(textReturn);
    }

}
