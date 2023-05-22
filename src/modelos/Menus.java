package modelos;

public class Menus {
    String login = """
                _________________________________
                *** Seja bem vindo ao Otter! ***
                
                1 - Entrar
                2 - Cadastrar
                _________________________________
                """;
    String menuInicial = """
                _________________________________
                A - Ver post 1
                B - Ver post 2
                C - Ver post 3
                D - Ver post 4
                E - Ver post 5
                
                X - Avançar
                
                1 - Postar
                2 - Seu perfil
                3 - Procurar perfil
                4 - Logout
                _________________________________
                """;

    String menuInicial2 = """
                _________________________________
                A - Ver post 1
                B - Ver post 2
                C - Ver post 3
                D - Ver post 4
                E - Ver post 5
                
                Z - Retornar
                X - Avançar
                
                1 - Postar
                2 - Seu perfil
                3 - Procurar perfil
                4 - Logout
                _________________________________
                """;

    String menuSeuPerfil = """
                _________________________________
                1 - Listar seguidores
                2 - Listar seguindo
                3 - Mudar username
                4 - Voltar
                _________________________________
                """;

    String menuPost = """
                _________________________________
                1 - Curtir / Descurtir
                2 - Responder
                3 - Voltar
                4 - Voltar ao início
                _________________________________
                """;

    public String getLogin() {
        return login;
    }

    public String getMenuInicial() {
        return menuInicial;
    }

    public String getMenuInicialAvancarRetornar() {
        return menuInicial2;
    }

    public String getMenuSeuPerfil() {
        return menuSeuPerfil;
    }

    public String getMenuPost() {
        return menuPost;
    }
}
