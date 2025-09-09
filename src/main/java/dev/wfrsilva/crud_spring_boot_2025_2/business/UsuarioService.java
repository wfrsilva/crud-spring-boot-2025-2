package dev.wfrsilva.crud_spring_boot_2025_2.business;

import org.springframework.stereotype.Service;

import dev.wfrsilva.crud_spring_boot_2025_2.infrastructure.entity.Usuario;
import dev.wfrsilva.crud_spring_boot_2025_2.infrastructure.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    //injetar dependencia repository
    //03 opcoes: 1- autowired, 2- args lombok, 3- construtor manual
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }//injecao de dependencia via construtor

    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
    }//salvarUsuario

    public Usuario buscarUsuarioPorEmail(String email){
        return repository.findByEmail(email).orElseThrow(
            () -> new RuntimeException("E-mail não encontrado.")
        );
    }//buscarUsuarioPorEmail

    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }//deletarUsuarioPorEmail


}//UsuarioService
