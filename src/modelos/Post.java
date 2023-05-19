package modelos;

import java.util.ArrayList;
import java.util.Date;

public class Post {
    private String conteudo;
    private Date dataHora;
    private Usuario usuarioCriador;
    private ArrayList<Post> postResposta = new ArrayList<>();
    //private ArrayList<Likes> likes = new ArrayList<>();

    public Post(String conteudo, Usuario usuarioCriador) {
        this.conteudo = conteudo;
        this.dataHora = new Date();
        this.usuarioCriador = usuarioCriador;
    }


    //Getters e Setters ------------------------------

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public Usuario getUsuarioCriador() {
        return usuarioCriador;
    }

    public ArrayList<Post> getPostResposta() {
        return postResposta;
    }

    //Métodos ----------------------------------------


}
