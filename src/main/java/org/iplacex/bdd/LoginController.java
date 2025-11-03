package org.iplacex.bdd;

import org.iplacex.Login;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final Login loginLogic = new Login();
    @PostMapping("/login")
    public String handleLogin(@RequestBody LoginRequest request) {
        return loginLogic.execute(request.getUser(), request.getPass());
    }

}

