package ru.artemkliucharov.caroriescalcserver.caloriescalculatorserver.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.artemkliucharov.caroriescalcserver.caloriescalculatorserver.dto.JwtAuthenticationResponse;
import ru.artemkliucharov.caroriescalcserver.caloriescalculatorserver.dto.SignInRequest;
import ru.artemkliucharov.caroriescalcserver.caloriescalculatorserver.dto.SignUpRequest;
import ru.artemkliucharov.caroriescalcserver.caloriescalculatorserver.service.auth.AuthenticationService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;


    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody SignUpRequest request){
        return authenticationService.signUp(request);
    }

    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody SignInRequest request){
        return authenticationService.signIn(request);
    }


}
