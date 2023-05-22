package Principal;

import modelos.Menus;
import modelos.Otter;
import modelos.Post;
import modelos.Usuario;

import java.lang.reflect.Member;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        String username;
        String senha;
        Usuario usuarioLogado = null;
        boolean logado = false;
        var menus = new Menus();
        var otter = new Otter();

        otter.cadastrarUsuario("Guilherme","milegui","guilherme@gmail.com","123");
        otter.buscaUsuario("milegui").postar("vou dar unfollow em mim, to mto chata dó falo besteira e candei d ver minha cara no espelho...");
        otter.buscaUsuario("milegui").postar("descobri que comprar moveis e coisa pra casa é mais prazeroso que comprar um look novo");
        otter.buscaUsuario("milegui").postar("a dor mostra quem agente realmente é. eu sou uma viadona");

        otter.cadastrarUsuario("Fabricio", "fabricinho02","fabricinho.deus27@gmail.com", "2408");
        otter.buscaUsuario("fabricinho02").postar("e eu lá mulher d fazer back up? Perdi tudo foda-se eu");
        otter.buscaUsuario("fabricinho02").postar("mais um dia calando a boca daqueles que me elogiavam");
        otter.buscaUsuario("fabricinho02").postar("n coloco defeito em ngm foi deus que colocou eu só comento");

        otter.cadastrarUsuario("Allan", "allanbida", "soyfrantiesco@outlook.com", "24");
        otter.buscaUsuario("allanbida").postar("além d tudo mulher tem um buraco a mais p/ administrar");
        otter.buscaUsuario("allanbida").postar("Já disse e repito: ñ me levem a sério, sou falsa. manipuladora, mentirosa e filha da puta. Escrevo o q vem na cabeça, so futilidades");
        otter.buscaUsuario("allanbida").postar("Peguem seus otimismos e sumam d perto d mim. Hj eu tó em crise");

        do {
            System.out.println(menus.getLogin());
            int opcao = leitura.nextInt();
        switch (opcao){
            case 1:
                do {
                    System.out.println("Digite seu usuário");
                    username = leitura.next();
                    System.out.println("Digite sua senha");
                    senha = leitura.next();

                    if (otter.login(username, senha)){
                        System.out.println("Bem vindo de volta "+otter.buscaUsuario(username).getUsername()+" ao Otter :D");
                        usuarioLogado = otter.buscaUsuario(username);
                        logado = true;
                    }else{
                        System.out.println("Usuário ou senha inválidos, tente novamente :(");
                    }
                }while(!otter.login(username, senha));
                break;

            case 2:
                System.out.println("Digite seu nome completo");
                String nome = leitura.next();

                System.out.println("Digite seu nome de usuário, ele será único e exclusivo seu :]");
                username = leitura.next();

                System.out.println("Digite um email");
                String email = leitura.next();

                System.out.println("Digite uma senha");
                senha = leitura.next();

                otter.cadastrarUsuario(nome, username, email, senha);
                System.out.println("Seja bem vindo ao Otter XD");

                usuarioLogado = otter.buscaUsuario(username);
                logado = true;
                break;

            default:
                System.out.println("Digite um valor válido");
                break;
        }
        }while (usuarioLogado==null);

        do {
            System.out.println(menus.getMenuInicial());
            int opcao = leitura.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Escreva o que você está sentindo s2");
                    String conteudo = leitura.next();
                    usuarioLogado.postar(conteudo);
                    break;
                case 2:
                    System.out.println("Perfil de @"+usuarioLogado.getUsername());
                    usuarioLogado.imprime();
                    break;
                case 3:
                    System.out.println("Digite o usuário que deseja stalkear");
                    String buscaUsuario = leitura.next();
                    Usuario user = otter.buscaUsuario(buscaUsuario);
                    otter.imprimeUsuario(user.getUsername());
                    otter.buscaUsuario(buscaUsuario).listarPosts();
                    break;
                case 4:
                    System.out.println("Até a próxima, espero te ver em breve ;-;");
                    logado = false;
            }
        }while (logado);
    }
}