package Principal;

import modelos.Otter;
import modelos.Usuario;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        String menu = """
                Seja bem vindo ao Otter!
                
                1- Cadastrar usuario
                2- login
                """;

        Otter otter = new Otter();

        otter.cadastrarUsuario();
        otter.listarUsuarios();
        otter.imprimeUsuario();

        System.out.println("Qual usuario deseja postar: ");
        String usuario = leitura.next();

        System.out.println("Escreva o post: ");
        String post = leitura.next();

        otter.buscaUsuario(usuario).postar(post);
        otter.buscaUsuario(usuario).listarPosts();
    }
}
