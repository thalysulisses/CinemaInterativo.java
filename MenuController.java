import java.util.ArrayList;
import java.util.Scanner;

public class MenuController {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Filme> filmes = new ArrayList<>();
        filmes.add(new Filme("Caramelo", "Diego Freitas", "História emocionante de superação.", "Drama", "1h 41min"));
        filmes.add(new Filme("Frankenstein", "Guillermo del Toro", "Um clássico reinventado com novos efeitos.", "Terror", "2h 32min"));
        filmes.add(new Filme("Shrek", "Andrew Adamson e Vicky Jenson", "O ogro mais querido das telonas!", "Animação", "1h 30min"));

        String[] sessoes = {"10:00", "15:30", "18:00"};

        int opcao = 1;

        System.out.println("Bem-vindo ao Cinema Cesmac!");

        while (opcao != 0) {

            System.out.println("\nFilmes disponíveis:");
            for (int i = 0; i < filmes.size(); i++) {
                System.out.println((i + 1) + " - " + filmes.get(i).getNome());
            }

            System.out.print("\nDigite o número do filme desejado (ou 0 para sair): ");
            int escolhaFilme = input.nextInt();

            if (escolhaFilme == 0) {
                System.out.println("\nObrigado por usar o Cinema Cesmac!");
                break;
            }

            Filme filmeSelecionado = filmes.get(escolhaFilme - 1);
            filmeSelecionado.exibirDetalhes();

            System.out.println("\nEscolha a sessão");
            for (int i = 0; i <sessoes.length; i++) {
                System.out.println((i + 1) + " - " + sessoes[i]);
            }
            int escolhaSessao = input.nextInt();
            String horario = sessoes[escolhaSessao - 1];

            System.out.print("\nDigite o tipo de ingresso (1 - Inteira/2 - Meia): ");
            int tipoOpcao = input.nextInt();

            String tipo = (tipoOpcao == 1) ? "inteira" : "meia";

            Ingresso ingresso = new Ingresso(filmeSelecionado, tipo, horario);
            ingresso.exibirResumo();

            System.out.print("\nDeseja comprar outro ingresso? (1 - Sim / 0 - Não): ");
            opcao = input.nextInt();
        }

        input.close();

    }

}
