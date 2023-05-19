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

    //Getters e Setters ------------------------------

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getUsername() {
        return username;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public int getSeguindo() {
        return seguindo;
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
        System.out.println(post.getConteudo());
        System.out.println(post.getDataHora());
        System.out.println(post.getUsuarioCriador().getUsername());
        posts.add(post);
    }

    public void listarPosts(){
        System.out.println("""
                    ------------------------------------
                    
                    """);
        System.out.println("Posts do "+username);
        for (Post item:posts) {
            System.out.println(item.getConteudo());
            System.out.println(item.getDataHora());
            System.out.println("""
                    
                    ------------------------------------
                    
                    """);
        }
    }
}