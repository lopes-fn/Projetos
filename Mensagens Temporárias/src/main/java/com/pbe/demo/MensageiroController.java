package main.java.com.pbe.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/mensageiro")
public class MensageiroController {

    private final Map<String, Queue<String>> mensagens = new HashMap<>();

    // POST /mensageiro/publica/{chave}
    @PostMapping("/publica/{chave}")
    public ResponseEntity<String> publicar(
            @PathVariable String chave,
            @RequestBody String mensagem) {

        mensagens.putIfAbsent(chave, new LinkedList<>());
        mensagens.get(chave).add(mensagem);

        return ResponseEntity.ok("Mensagem armazenada com sucesso");
    }

    // GET /mensageiro/acessa/{chave}
    @GetMapping("/acessa/{chave}")
    public ResponseEntity<String> acessar(@PathVariable String chave) {

        Queue<String> fila = mensagens.get(chave);

        if (fila == null || fila.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não há mensagens para esta chave");
        }

        String mensagem = fila.poll(); // remove a próxima mensagem
        return ResponseEntity.ok(mensagem);
    }
}