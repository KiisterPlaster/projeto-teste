package br.comvarejonline.projetoinicial.domain.service;

import br.comvarejonline.projetoinicial.api.model.UsuarioLoginDTO;
import br.comvarejonline.projetoinicial.domain.exception.NegocioException;
import br.comvarejonline.projetoinicial.domain.exception.UsuarioNaoEncontradoException;
import br.comvarejonline.projetoinicial.domain.model.Grupo;
import br.comvarejonline.projetoinicial.domain.model.Usuario;
import br.comvarejonline.projetoinicial.domain.repository.UsuarioRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.Charset;
import java.util.Optional;

@Service
public class CadastroUsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private CadastroGrupoService cadastroGrupo;
    
    @Transactional
    public Usuario salvar(Usuario usuario) {
        usuarioRepository.detach(usuario);

        usuario.bcryptarSenha();
       

        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        
        if (usuarioExistente.isPresent() && !usuarioExistente.get().equals(usuario)) {
            throw new NegocioException(
                    String.format("Já existe um usuário cadastrado com o e-mail %s", usuario.getEmail()));
        }
        
        usuario.setSenha(usuario.getSenha());
        
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void alterarSenha(Long usuarioId, String senhaAtual, String novaSenha) {
        Usuario usuario = buscarOuFalhar(usuarioId);

        if (usuario.senhaNaoCoincideCom(senhaAtual)) {
            throw new NegocioException("Senha atual informada não coincide com a senha do usuário.");
        }

        usuario.setSenha(novaSenha);
    }

    @Transactional
    public void desassociarGrupo(Long usuarioId, Long grupoId) {
        Usuario usuario = buscarOuFalhar(usuarioId);
        
        Grupo grupo = cadastroGrupo.buscarOuFalhar(grupoId);

        usuario.removerGrupo(grupo);
    }

    @Transactional
    public void associarGrupo(Long usuarioId, Long grupoId) {
        Usuario usuario = buscarOuFalhar(usuarioId);

        Grupo grupo = cadastroGrupo.buscarOuFalhar(grupoId);

        usuario.adicionarGrupo(grupo);
        
    }

    @Transactional
    public Optional<UsuarioLoginDTO> logar(Optional<UsuarioLoginDTO> user) {
        
        
        BCryptPasswordEncoder  encoder = new BCryptPasswordEncoder();
        Optional<Usuario> usuario = usuarioRepository.findByEmail(user.get().getEmail());

        if (usuario.isPresent()) {
            if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {

                String auth = user.get().getEmail() + ":" + user.get().getSenha();
                byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);

                user.get().setToken(authHeader);
                user.get().setId(usuario.get().getId());
                user.get().setNome(usuario.get().getNome());
                user.get().setEmail(usuario.get().getEmail());
                user.get().setGrupos(usuario.get().getGrupos().toString());
                
                return user;

            }
        }
        System.out.println(usuario);
        return Optional.empty();
    }
    
    public Usuario buscarOuFalhar(Long usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioId));
    }
   
}
