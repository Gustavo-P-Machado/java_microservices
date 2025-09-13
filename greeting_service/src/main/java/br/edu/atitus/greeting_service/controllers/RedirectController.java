package br.edu.atitus.greeting_service.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/")
    public void redirectToSpecificPath(HttpServletResponse httpServletResponse) {
        // Set the Location header to the desired path
        httpServletResponse.setHeader("Location", "/greeting");
        // Set the status code to 302 (Found) for a temporary redirect
        httpServletResponse.setStatus(301);
    }
}
