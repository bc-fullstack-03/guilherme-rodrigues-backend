package modelos;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario{
    private String nome;
    private String username;
    private String email;
    private String senha;
    private String descricao;
    private int seguidores;
    private int seguindo;
    private ArrayList<Post> posts = new ArrayList<>();
    Scanner leitura = new Scanner(System.in);

    public Usuario(String nome, String username, String email, String senha) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.senha = senha;
    }

    //Métodos ----------------------------------

    public void imprime(){
        System.out.println("Nome: "+nome);
        System.out.println("Username: "+username);
        System.out.println("descrição: "+descricao);
        System.out.println("Num. Seguidores: "+seguidores);
        System.out.println("Num. seguindo: "+seguindo);
    }

    public void postar(String conteudo){
        Post post = new Post(conteudo, this);
        posts.add(post);
    }

    public Post getPost(int indexDoPost){
        return posts.get(indexDoPost);
    }

    public void responderPost(String conteudo, Post post){
        PostResposta resposta = new PostResposta(conteudo, this, post);
        posts.add(resposta);
    }

    public void listarPosts(){
        System.out.println("");
        System.out.println("Posts do "+username);
        System.out.print("------------------------------------");
        System.out.println("");
        for (Post item:posts) {
            System.out.println("");
            item.imprime();
            System.out.println("");
            System.out.println("------------------------------------");
        }
    }

    //Getters e Setters ------------------------------

    public String getSenha() {
        return senha;
    }

    public String getUsername() {
        return username;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
