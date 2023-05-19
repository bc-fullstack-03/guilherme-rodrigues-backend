package modelos;

import java.util.ArrayList;
import java.util.Scanner;

public class Otter {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    Scanner leitura = new Scanner(System.in);

    public void cadastrarUsuario(){
//        System.out.println("Digite seu nome real: ");
//        String nome = leitura.next();
//        System.out.println("Digite seu nome de usuario: ");
//        String username = leitura.next();
//        System.out.println("Digite seu email: ");
//        String email = leitura.next();
//        System.out.println("Digite sua senha: ");
//        String senha = leitura.next();
//
//        Usuario usuario = new Usuario(nome, username, email, senha);

        var user1 = new Usuario("Guilherme","milegui","guilherme@gmail.com","123");
        var user2 = new Usuario("Fabricio", "fabricinho02","fabricinho.deus27@gmail.com", "2408");
        var user3 = new Usuario("Allan", "allanbida", "soyfrantiesco@outlook.com", "24");
        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);
    }

    public void listarUsuarios(){
        for (Usuario item: usuarios) {
            System.out.println(item.getUsername());
        }
    }

    public void imprimeUsuario(){
        System.out.println("Digite nome do usuario desejado: ");
        String username = leitura.next();
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
}