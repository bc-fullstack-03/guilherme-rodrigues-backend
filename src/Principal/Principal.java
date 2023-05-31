package Principal;

import modelos.Otter;
import modelos.Usuario;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        Usuario usuarioLogado = null;
        boolean logado = false;
        boolean dentroDoSite;
        var otter = new Otter();

        // mockando(mock) usuarios para teste
        otter.cadastrarUsuario("Guilherme", "milegui", "guilherme@gmail.com", "123");
        otter.buscaUsuario("milegui").postar("vou dar unfollow em mim, to mto chata dó falo besteira e candei d ver minha cara no espelho...");
        otter.buscaUsuario("milegui").postar("descobri que comprar moveis e coisa pra casa é mais prazeroso que comprar um look novo");
        otter.buscaUsuario("milegui").postar("a dor mostra quem agente realmente é. eu sou uma viadona");

        otter.cadastrarUsuario("Fabricio", "fabricinho02", "fabricinho.deus27@gmail.com", "2408");
        otter.buscaUsuario("fabricinho02").postar("e eu lá mulher d fazer back up? Perdi tudo foda-se eu");
        otter.buscaUsuario("fabricinho02").postar("mais um dia calando a boca daqueles que me elogiavam");
        otter.buscaUsuario("fabricinho02").postar("n coloco defeito em ngm foi deus que colocou eu só comento");

        otter.cadastrarUsuario("Allan", "allanbida", "soyfrantiesco@outlook.com", "24");
        otter.buscaUsuario("allanbida").postar("além d tudo mulher tem um buraco a mais p/ administrar");
        otter.buscaUsuario("allanbida").postar("Já disse e repito: ñ me levem a sério, sou falsa. manipuladora, mentirosa e filha da puta. Escrevo o q vem na cabeça, so futilidades");
        otter.buscaUsuario("allanbida").postar("Peguem seus otimismos e sumam d perto d mim. Hj eu tó em crise");

        do { //logar ou criar conta
            dentroDoSite = true;
            System.out.println("*** Seja bem vindo ao Otter! ***");
            System.out.println("Opção 1 - Entrar");
            System.out.println("Opção 2 - Cadastrar");
            System.out.println("Opção 0 - Sair");
            System.out.println("_________________________________");
            System.out.print("Digite aqui sua opção: ");

            int opcaoDentroDoSite = Integer.parseInt(leitura.nextLine());
            System.out.println();

            switch (opcaoDentroDoSite) {
                //Logar
                case 1 -> {
                    do {
                        System.out.print("Digite seu usuário: ");
                        String loginUsername = leitura.nextLine();
                        System.out.print("Digite sua senha: ");
                        String loginSenha = leitura.nextLine();
                        System.out.println();

                        if (otter.login(loginUsername, loginSenha)) {
                            System.out.println("Bem vindo de volta " + otter.buscaUsuario(loginUsername).getUsername() + " ao Otter :D");
                            usuarioLogado = otter.buscaUsuario(loginUsername);
                            logado = true;
                        } else {
                            System.out.println("Usuário ou senha inválidos, tente novamente :(");
                            System.out.println();
                        }

                    } while (!logado);
                }

                //Cadastrar
                case 2 -> {
                    System.out.print("Digite seu nome completo: ");
                    String cadastroNome = leitura.nextLine();

                    System.out.print("Digite seu nome de usuário: ");
                    String cadastroUsername = leitura.nextLine();

                    System.out.print("Digite um email: ");
                    String cadastroEmail = leitura.nextLine();

                    System.out.print("Digite uma senha: ");
                    String cadastroSenha = leitura.nextLine();

                    otter.cadastrarUsuario(cadastroNome, cadastroUsername, cadastroEmail, cadastroSenha);
                    usuarioLogado = otter.buscaUsuario(cadastroUsername);
                    logado = true;

                    System.out.println();
                    System.out.println("Seja bem vinde @" + usuarioLogado.getUsername() + " ao Otter XD");
                    System.out.println();
                }
                case 0 -> {
                    System.out.println("Até a próxima, espero te ver em breve ;-;");
                    dentroDoSite = false;
                }

                default -> System.out.println("Digite um valor válido");
            }

            if (logado) {
                //Otter logado
                do {
                    System.out.println("Olá @" + usuarioLogado.getUsername() + ", o que deseja fazer?");
                    System.out.println("Opção 1 - Ver o feed");
                    System.out.println("Opção 2 - Postar");
                    System.out.println("Opção 3 - Ver seu perfil");
                    System.out.println("Opção 4 - Procurar algum perfil");
                    System.out.println("Opção 0 - Logout");
                    System.out.println("_________________________________");

                    System.out.print("Digite aqui sua opção: ");
                    int opcaoLogado = Integer.parseInt(leitura.nextLine());
                    System.out.println();

                    switch (opcaoLogado) {
                        case 1 -> { // ver o feed
                            System.out.println("Feed ainda não disponível :c");
                            System.out.println();
                        }

                        case 2 -> { // postar
                            System.out.println("Escreva o que você está sentindo:");
                            usuarioLogado.postar(leitura.nextLine());
                            System.out.println();
                        }

                        case 3 -> { // ver seu perfil
                            int opcaoPerfil;
                            boolean dentroDoPerfil = true;
                            System.out.println("*** Perfil de @" + usuarioLogado.getUsername() + " ***");
                            usuarioLogado.imprime();
                            System.out.println("_________________________________");
                            System.out.println();

                            do {
                                System.out.println("## Escolha uma das opções abaixo ##");
                                System.out.println("Opção 1 - Ver seu perfil");
                                System.out.println("Opção 2 - Editar sua descrição");
                                System.out.println("Opção 3 - Mudar seu nome de usuário");
                                System.out.println("Opção 4 - Ver seus posts");
                                System.out.println("Opção 5 - Ver pessoas que te seguem");
                                System.out.println("Opção 6 - Ver pessoas que você segue");
                                System.out.println("Opção 0 - Voltar");
                                System.out.println("___________________________________");

                                System.out.print("Digite aqui sua opção: ");
                                opcaoPerfil = Integer.parseInt(leitura.nextLine());
                                System.out.println();

                                switch (opcaoPerfil) {
                                    case 1 -> { // ver seu perfil
                                        System.out.println("*** Perfil de @" + usuarioLogado.getUsername() + " ***");
                                        usuarioLogado.imprime();
                                        System.out.println("_________________________________");
                                    }

                                    case 2 -> { // editar sua descrição
                                        System.out.println("Escreva aquela descrição f0d@");
                                        usuarioLogado.setDescricao(leitura.nextLine());
                                        System.out.println("""
                                                Descrição atualizada!
                                                """);
                                    }

                                    case 3 -> { // mudar seu nome de usuário
                                        System.out.print("Escreva um novo nome de usuário: ");
                                        String mudarUsername = leitura.nextLine();

                                        if (mudarUsername.equals(usuarioLogado.getUsername())) {
                                            System.out.println("Você já está usando este nome de usuário");
                                        } else if (otter.validarNomeUsuario(mudarUsername)) {
                                            usuarioLogado.setUsername(mudarUsername);
                                            System.out.println("Nome de usuário alterado!");
                                        } else {
                                            System.out.println("Nome de usuário já está em uso");
                                        }
                                        System.out.println();
                                    }

                                    case 4 -> // listar posts do usuário
                                            usuarioLogado.listarPosts();

                                    case 5 -> { // ver pessoas que te seguem
                                        usuarioLogado.mostrarSeguidores(usuarioLogado);
                                        System.out.println();
                                    }

                                    case 6 -> { // ver pessoas que você segue
                                        usuarioLogado.mostrarPessoasQueSegue(usuarioLogado);
                                        System.out.println();
                                    }

                                    case 0 -> // voltar
                                            dentroDoPerfil = false;

                                    default -> {
                                        System.out.println("Digite um valor válido");
                                        System.out.println();
                                    }
                                }
                            } while (dentroDoPerfil);
                        }

                        case 4 -> { // Procurar algum perfil
                            int opcaoProcurarPerfil;
                            boolean dentroProcurarPerfil = true;

                            System.out.println("Digite o usuário que deseja stalkear");
                            String usernameUsuarioAlvo = leitura.nextLine();
                            Usuario usuarioAlvo = otter.buscaUsuario(usernameUsuarioAlvo);
                            System.out.println();

                            if (usuarioAlvo != null) {
                                System.out.println("Perfil do @" + usuarioAlvo.getUsername());
                                usuarioAlvo.imprime();
                                System.out.println();
                                do {
                                    System.out.println("## Escolha uma das opções abaixo ##");
                                    System.out.println("Opção 1 - Ver perfil do @" + usuarioAlvo.getUsername());
                                    System.out.println("Opção 2 - Mostrar posts do @" + usuarioAlvo.getUsername());
                                    if (usuarioLogado.validaSegueUsuario(usuarioAlvo)) {
                                        System.out.println("Opção 3 - Parar de seguir @" + usuarioAlvo.getUsername());
                                    } else {
                                        System.out.println("Opção 3 - Seguir @" + usuarioAlvo.getUsername());
                                    }
                                    System.out.println("Opção 4 - Mostrar seguidores de @" + usuarioAlvo.getUsername());
                                    System.out.println("Opção 5 - Mostrar pessoas que @" + usuarioAlvo.getUsername() + " segue");
                                    System.out.println("Opção 0 - Voltar");
                                    System.out.println("___________________________________");

                                    System.out.print("Digite aqui sua opção: ");
                                    opcaoProcurarPerfil = Integer.parseInt(leitura.nextLine());
                                    System.out.println();

                                    switch (opcaoProcurarPerfil) {

                                        case 1 -> { // mostra dados do usuario
                                            System.out.println("Perfil do @" + usuarioAlvo.getUsername());
                                            usuarioAlvo.imprime();

                                            if (usuarioLogado.validaSegueUsuario(usuarioAlvo)) {
                                                System.out.println();
                                                System.out.println("Você segue @" + usuarioAlvo.getUsername());
                                            }
                                            System.out.println();
                                        }

                                        case 2 -> { // mostra os posts do usuario
                                            usuarioAlvo.listarPosts();
                                            System.out.println();
                                        }

                                        case 3 -> { // segue ou para de seguir o usuario
                                            if (usuarioLogado.validaSegueUsuario(usuarioAlvo)) {
                                                otter.pararDeSeguir(usuarioLogado, usuarioAlvo);
                                                System.out.println("Você parou de seguir @" + usuarioAlvo.getUsername() + "!");
                                            } else {
                                                otter.seguir(usuarioLogado, usuarioAlvo);
                                                System.out.println("Você está Seguindo @" + usuarioAlvo.getUsername() + "!");
                                            }
                                            System.out.println();
                                        }

                                        case 4 -> { // mostra lista de seguidores do usuario
                                            usuarioAlvo.mostrarSeguidores(usuarioLogado);
                                            System.out.println();
                                        }

                                        case 5 -> { // mostra lista de pessoas que o usuario segue
                                            usuarioAlvo.mostrarPessoasQueSegue(usuarioLogado);
                                            System.out.println();
                                        }

                                        case 0 -> // voltar
                                                dentroProcurarPerfil = false;

                                        default -> {
                                            System.out.println("Digite um valor válido");
                                            System.out.println();
                                        }
                                    }
                                } while (dentroProcurarPerfil);
                            }
                        }

                        case 0 -> { // sair
                            System.out.println("Até a próxima @" + usuarioLogado.getUsername());
                            System.out.println();
                            logado = false;
                        }
                        default -> System.out.println("Digite um valor válido");
                    }
                } while (logado);
            }
        } while (dentroDoSite);

    }
}