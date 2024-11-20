package br.com.api_pessoal.core.controller;

import br.com.api_pessoal.core.dto.CepDTO;
import br.com.api_pessoal.core.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cep")
public class CepController {

    @Autowired
    private CepService cepService;

    @GetMapping("/{numero}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<CepDTO> consultarCep(@PathVariable String numero) {

        CepDTO cep = cepService.retornarCep(numero);
        return ResponseEntity.ok(cep);
    }

    @GetMapping("/test")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<String> consultarCep() {

       String data = "Samuel";
        return ResponseEntity.ok(data);
    }


}
