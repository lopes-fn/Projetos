package main.java.com.pbe.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/verificador")
public class VerificadorController {

    // GET /api/verificador/{cpf}
    @GetMapping("/{cpf}")
    public ResponseEntity<String> verificarPath(@PathVariable String cpf) {

        if (CpfValidator.isValid(cpf)) {
            return ResponseEntity.ok("CPF válido");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("CPF inválido");
    }

    // GET /api/verificador?cpf=123
    @GetMapping
    public ResponseEntity<String> verificarQuery(@RequestParam String cpf) {

        if (CpfValidator.isValid(cpf)) {
            return ResponseEntity.ok("CPF válido");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("CPF inválido");
    }

    // POST /api/verificador
    @PostMapping
    public ResponseEntity<String> verificarPost(@RequestParam String cpf) {

        if (CpfValidator.isValid(cpf)) {
            return ResponseEntity.ok("CPF válido");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("CPF inválido");
    }
}