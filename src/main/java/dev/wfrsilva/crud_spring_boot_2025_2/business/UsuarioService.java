package dev.wfrsilva.crud_spring_boot_2025_2.business;

import org.springframework.stereotype.Service;

import dev.wfrsilva.crud_spring_boot_2025_2.infrastructure.entity.Usuario;
import dev.wfrsilva.crud_spring_boot_2025_2.infrastructure.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    //injetar dependencia repository
    //03 opcoes: 1- autowired, 2- @requiredArgsConstructor lombok, 3- construtor manual
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

    public Usuario buscarUsuarioPorId(Integer id){
        return repository.findById(id).orElseThrow(
            () -> new RuntimeException("Id não encontrado")
        );
    }//buscarUsuarioPorEmail

    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }//deletarUsuarioPorEmail

    public void deletarUsuarioPorId(Integer id){
        repository.deleteById(id);
    }//deletarUsuarioPorId


    public void atualizarUsuarioPorEmail(String email, Usuario usuario){
        Usuario usuarioEntity = buscarUsuarioPorEmail(email);
        Usuario usuarioAtualizado = Usuario.builder()
            .email(email)
            .nome(usuario.getNome() != null ?
                        usuario.getNome() : usuarioEntity.getNome())
            .id(usuarioEntity.getId())
            .build();

            repository.saveAndFlush(usuarioAtualizado);

    }//atualizarUsuarioPorEmail


    public void atualizarUsuarioPorId(Integer id, Usuario usuario){
        Usuario usuarioEntity = repository.findById(id).orElseThrow(
            () -> new RuntimeException("Usuário não encontrado.")
        );
        Usuario usuarioAtualizado  = Usuario.builder()
            .email(usuario.getEmail() != null?
                        usuario.getEmail() : usuarioEntity.getEmail())
            .nome(usuario.getNome() != null ?
                        usuario.getNome() : usuarioEntity.getNome())
            .id(usuarioEntity.getId())
            .build();

            repository.saveAndFlush(usuarioAtualizado);

    }//atualizarUsuarioPorId

    public boolean existsByEmail(String email) {
        // Checar se o novo email já existe - tentei ERRONEAMENTE atualizar email de um usuario em outro
        return repository.existsByEmail(email);
    }//existsByEmail


}//UsuarioService
