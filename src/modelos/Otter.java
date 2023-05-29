package modelos;

import java.util.ArrayList;

public class Otter {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void cadastrarUsuario(String nome, String username, String email, String senha){
        Usuario usuario = new Usuario(nome, username, email, senha);
        usuarios.add(usuario);
    }

    public boolean validarNomeUsuario(String username){
        for (Usuario item: usuarios) {
            if (username.equals(item.getUsername())){
                return false;
            }
        }
        return true;
    }

    // lista todos os usuarios da lista de usuários
    public void listarUsuarios(){
        for (Usuario item: usuarios) {
            System.out.println(item.getUsername());
        }
    }

    // imprime os dados de um usuário em específico
    public void imprimeUsuario(String username){
        Usuario alvo = null;
        for (Usuario item: usuarios) {
            if (item.getUsername().equals(username)){
                alvo = item;
            }
        }
        if (alvo != null){
            alvo.imprime();
        }else {
            System.out.println("Usuário não encontrado!");
        }
    }

    // retorna um usuário específico
    public Usuario buscaUsuario(String username){
        Usuario alvo = null;
        for (Usuario item: usuarios) {
            if (item.getUsername().equals(username)){
                alvo = item;
            }
        }
        if (alvo != null){
            return alvo;
        }else {
            System.out.println("Usuário não encontrado!");
            return null;
        }
    }

    // autenticação de um usuário
    public boolean login(String username, String senha){
        Usuario usuario = buscaUsuario(username);
        if (usuario == null){
            return false;
        } else return usuario.getSenha().equals(senha);
    }

    public void seguir(Usuario usuarioLogado, Usuario usuarioAlvo){ //guarda o nome de usuario na lista de seguidos
        usuarioLogado.seguirUsuario(usuarioAlvo);
        usuarioAlvo.adicionarSeguidor(usuarioLogado);
    }

    public void pararDeSeguir(Usuario usuarioLogado, Usuario usuarioAlvo){
        usuarioLogado.pararDeSeguir(usuarioAlvo);
        usuarioAlvo.retirarSeguidor(usuarioLogado);
    }

    // listar posts geral ou especifico

}