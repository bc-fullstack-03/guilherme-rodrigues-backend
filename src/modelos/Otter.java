package modelos;

import java.util.ArrayList;

public class Otter {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void cadastrarUsuario(String nome, String username, String email, String senha){
        Usuario usuario = new Usuario(nome, username, email, senha);
        usuarios.add(usuario);
    }

    public void listarUsuarios(){
        for (Usuario item: usuarios) {
            System.out.println(item.getUsername());
        }
    }

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

    public boolean login(String username, String senha){
        Usuario usuario = buscaUsuario(username);
        if (usuario == null){
            return false;
        } else return usuario.getSenha().equals(senha);
    }
}