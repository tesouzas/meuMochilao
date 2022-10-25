package br.com.meumochilao.controllers;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.meumochilao.model.Usuario;
import br.com.meumochilao.repository.UsuarioRepository;
import br.com.meumochilao.enums.RoleName; 

import java.util.List;

@Controller
@RequestMapping(path = "/admin/usuario")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping(path = "/select")
    public String select(Model model){
        try{
            List<Usuario> usuarios = usuarioRepository.findAll();
            model.addAttribute("usuarios",usuarios);
            model.addAttribute("usuario",new Usuario());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "usuarios/cadastro-usuario";
    }

    @GetMapping(path = "/delete/{id}")
    public String select(@PathVariable(name = "id") Long id){
        try{
            usuarioRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/usuario/select";
    }

    @GetMapping(path = "/edit/{id}")
    public String edit(Model model, @PathVariable(name = "id") Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        model.addAttribute("usuario",usuario);
        return "admin/usuarios/editar-usuario";
    }

    @PostMapping(path = "/insert")
    public String insert(@ModelAttribute Usuario usuario,@RequestParam(name = "id") Long id){
        try{
            String passwordEncoder = PasswordEncoderUtils.encode(usuario.getPassword());
            usuario.setPassword(passwordEncoder);

            Usuario usuario = new Usuario();
            usuario.setId(id_usuario);
            if(id_usuario == 1){
                usuario.setNome(RoleName.ROLE_ADMIN);
            }else if(id_usuario == 2){
                usuario.setNome(RoleName.ROLE_USER);
            }
            usuario.setUsuario(usuario);
            usuarioRepository.save(usuario);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/usuario/select";
    }

    @PostMapping(path = "/update")
    public String update(@ModelAttribute Usuario usuario,@RequestParam(name = "id_usuario") Long id_usuario){
        try {
            String passwordEncoder = PasswordEncoderUtils.encode(usuario.getPassword());
            usuario.setPassword(passwordEncoder);

            Usuario usuario = new Usuario();
            usuario.setId(id_usuario);
            if(id_usuario == 1){
                usuario.setNome(RoleName.ROLE_ADMIN);
            }else if(id_usuario == 2){
                usuario.setNome(RoleName.ROLE_USER);
            }
            usuario.setUsuario(usuario);
            usuarioRepository.save(usuario);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/usuario/select";
    }
}
