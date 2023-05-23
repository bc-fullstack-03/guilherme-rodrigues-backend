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

        //Login
        do {
            System.out.println("*** Seja bem vindo ao Otter! ***");
            System.out.println("Opção 1 - Entrar");
            System.out.println("Opção 2 - Cadastrar");
            System.out.println("_________________________________");
            System.out.print("Digite aqui sua opção: ");

            int opcao = Integer.parseInt(leitura.nextLine());
            System.out.println();

            switch (opcao) {
                //Logar
                case 1 -> {
                    do {
                        System.out.print("Digite seu usuário: ");
                        username = leitura.nextLine();
                        System.out.print("Digite sua senha: ");
                        senha = leitura.nextLine();
                        System.out.println();

                        if (otter.login(username, senha)) {
                            System.out.println("Bem vindo de volta " + otter.buscaUsuario(username).getUsername() + " ao Otter :D");
                            usuarioLogado = otter.buscaUsuario(username);
                            logado = true;
                        } else {
                            System.out.println("Usuário ou senha inválidos, tente novamente :(");
                            System.out.println();
                        }
                    } while (!otter.login(username, senha));
                }

                //Cadastrar
                case 2 -> {
                    System.out.print("Digite seu nome completo: ");
                    String nome = leitura.nextLine();
                    System.out.print("Digite seu nome de usuário: ");
                    username = leitura.nextLine();
                    System.out.print("Digite um email: ");
                    String email = leitura.nextLine();
                    System.out.print("Digite uma senha: ");
                    senha = leitura.nextLine();
                    otter.cadastrarUsuario(nome, username, email, senha);
                    System.out.println();
                    System.out.print("Seja bem vindo ao Otter XD");
                    System.out.println();
                    usuarioLogado = otter.buscaUsuario(username);
                    logado = true;
                }
                default -> System.out.println("Digite um valor válido");
            }
            System.out.println();
        }while (usuarioLogado==null);

        //Otter logado
        do {
            System.out.println("Olá @"+usuarioLogado.getUsername()+", o que deseja fazer?");
            System.out.println("Opção 1 - Ver o feed");
            System.out.println("Opção 2 - Postar");
            System.out.println("Opção 3 - Ver seu perfil");
            System.out.println("Opção 4 - Procurar algum perfil");
            System.out.println("Opção 0 - Logout");
            System.out.println("_________________________________");

            System.out.print("Digite aqui sua opção: ");
            int opcao = Integer.parseInt(leitura.nextLine());
            System.out.println();

            switch (opcao){
                case 1: // ver o feed

                    break;

                case 2: // postar
                    System.out.println("Escreva o que você está sentindo:");
                    usuarioLogado.postar(leitura.nextLine());
                    System.out.println();
                    break;

                case 3: // ver seu perfil
                    opcao = 1;
                    do {
                        switch (opcao){
                            case 1: // ver seu perfil
                                System.out.println("*** Perfil de @"+usuarioLogado.getUsername()+" ***");
                                usuarioLogado.imprime();
                                System.out.println("_________________________________");
                                break;

                            case 2: // editar sua descrição
                                System.out.println("Escreva aquela descrição f0d@");
                                usuarioLogado.setDescricao(leitura.nextLine());
                                System.out.println("""
                                    Descrição atualizada!
                                    """);
                                break;

                            case 3: // mudar seu nome de usuário
                                System.out.print("Escreva um novo nome de usuário: ");
                                username = leitura.nextLine();
                                if (username.equals(usuarioLogado.getUsername())){
                                    System.out.println("Você já está usando este nome de usuário");
                                }else if (otter.validarNomeUsuario(username)){
                                    usuarioLogado.setUsername(username);
                                    System.out.println("Nome de usuário alterado!");
                                }else {
                                    System.out.println("Nome de usuário já está em uso");
                                }
                                System.out.println();
                                break;

                            case 4: // ver pessoas que te seguem
                                System.out.println("função ainda não foi implementada :)");
                                break;

                            case 5: // ver pessoas que você segue
                                System.out.println("função ainda não foi implementada :D");
                                break;

                            case 0: // voltar
                                opcao = 0;
                                break;
                            default:
                                System.out.println("Digite um valor válido");
                                System.out.println();

                        }
                        System.out.println("## Escolha uma das opções abaixo ##");
                        System.out.println("Opção 1 - Ver seu perfil");
                        System.out.println("Opção 2 - Editar sua descrição");
                        System.out.println("Opção 3 - Mudar seu nome de usuário");
                        System.out.println("Opção 4 - Ver pessoas que te seguem");
                        System.out.println("Opção 5 - Ver pessoas que você segue");
                        System.out.println("Opção 0 - Voltar");
                        System.out.println("_________________________________");

                        System.out.print("Digite aqui sua opção: ");
                        opcao = Integer.parseInt(leitura.nextLine());
                        System.out.println();

                    }while (opcao != 0);
                    break;

                case 4: // Procurar algum perfil
                    System.out.println("Digite o usuário que deseja stalkear");
                    String buscaUsuario = leitura.nextLine();
                    Usuario user = otter.buscaUsuario(buscaUsuario);
                    otter.imprimeUsuario(user.getUsername());
                    otter.buscaUsuario(buscaUsuario).listarPosts();
                    System.out.println();
                    // opção 1 - seguir / deixar de seguir (mostrar voce segue fulano se for o caso)
                    // opção 2 - listar seguidores e seguidos e mostrar caso siga alguns deles
                    break;

                case 0: // sair
                    System.out.println("Até a próxima, espero te ver em breve ;-;");
                    System.out.println();
                    logado = false;

                default:
                    System.out.println("Digite um valor válido");
            }
        }while (logado);
    }
}