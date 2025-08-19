package com.alura.foro_hub.controller;

import com.alura.foro_hub.domain.usuario.DatosLogin;
import com.alura.foro_hub.domain.usuario.Usuario;
import com.alura.foro_hub.infra.security.DatosJWTToken;
import com.alura.foro_hub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosLogin datosLogin) {
        var authToken = new UsernamePasswordAuthenticationToken(datosLogin.email(), datosLogin.contrasena());
        var authentication = authenticationManager.authenticate(authToken);

        var JWTtoken = tokenService.generarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}