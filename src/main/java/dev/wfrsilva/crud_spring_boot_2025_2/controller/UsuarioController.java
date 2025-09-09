package dev.wfrsilva.crud_spring_boot_2025_2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import dev.wfrsilva.crud_spring_boot_2025_2.business.UsuarioService;
import dev.wfrsilva.crud_spring_boot_2025_2.infrastructure.entity.Usuario;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    //injetar dependecia service
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){
       /* RequestBody da entity, nao eh o mais recomendado,
       // pois expoe a entity, o recomendado eh DTO, para nao expor dados sensiveis como senha */
       usuarioService.salvarUsuario(usuario);
       return ResponseEntity.ok().build();
    }//salvarUsuario


    @GetMapping("/email/{email}")
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@PathVariable String email){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }//buscarUsuarioPorEmail

    @GetMapping("/id/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Integer id){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }//buscarUsuarioPorId

    @DeleteMapping("/email/{email}")
    public ResponseEntity<Void> deletarUsuarioPorEmail(@PathVariable String email){
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }//deletarUsuarioPorEmail

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deletarUsuarioPorId(@PathVariable Integer id){
        usuarioService.deletarUsuarioPorId(id);
        return ResponseEntity.ok().build();
    }//deletarUsuarioPorId


    @PutMapping("/email/{email}")
    public ResponseEntity<Void> atualizarUsuarioPorEmail(@PathVariable String email, @RequestBody Usuario usuario){
        usuarioService.atualizarUsuarioPorEmail(email, usuario);
        return ResponseEntity.ok().build();
    }//atualizarUsuarioPorEmail

    @PutMapping("/id/{id}")
    public ResponseEntity<Void> atualizarUsuarioPorId(@PathVariable Integer id, @RequestBody Usuario usuario){
        usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }//atualizarUsuarioPorId

    


}//UsuarioController
