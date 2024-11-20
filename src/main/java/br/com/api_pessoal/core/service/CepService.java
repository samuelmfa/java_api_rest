package br.com.api_pessoal.core.service;

import br.com.api_pessoal.core.dto.CepDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CepService {


    public CepDTO retornarCep(String cep) {

        String URL = "https://viacep.com.br";
        String URI = "/ws/{cep}/json";

        RestTemplate restTemplate = new RestTemplate();

        return WebClient
                .create(URL)
                .get()
                .uri(URI, cep)
                .retrieve()
                .bodyToMono(CepDTO.class).block();
    }

}
