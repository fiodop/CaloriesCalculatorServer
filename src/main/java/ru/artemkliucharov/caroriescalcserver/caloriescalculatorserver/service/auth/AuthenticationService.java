package ru.artemkliucharov.caroriescalcserver.caloriescalculatorserver.service.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.artemkliucharov.caroriescalcserver.caloriescalculatorserver.dto.JwtAuthenticationResponse;
import ru.artemkliucharov.caroriescalcserver.caloriescalculatorserver.dto.SignInRequest;
import ru.artemkliucharov.caroriescalcserver.caloriescalculatorserver.dto.SignUpRequest;
import ru.artemkliucharov.caroriescalcserver.caloriescalculatorserver.entity.AppUser;
import ru.artemkliucharov.caroriescalcserver.caloriescalculatorserver.entity.Mail;
import ru.artemkliucharov.caroriescalcserver.caloriescalculatorserver.service.AppUserService;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AppUserService appUserService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;


    /**
     * Registration user
     *
     * @param request user's data
     * @return jwt
     */
    public JwtAuthenticationResponse signUp(SignUpRequest request){
        var user = AppUser.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        appUserService.create(user);

        Mail mail = new Mail(user.getEmail());
        emailService.sendEmail(mail);

        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }


    public JwtAuthenticationResponse signIn(SignInRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        var user = appUserService
                .userDetailsService()
                .loadUserByUsername(request.getUsername());

        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }


}
