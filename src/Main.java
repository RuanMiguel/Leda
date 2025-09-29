import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final String[] NOMES = {"Ana", "Bruno", "Carla", "Daniel", "Eduarda", "Felipe", "Gabriela", "Hugo", "Isabela", "João"};
    private static final String[] SOBRENOMES = {"Silva", "Santos", "Oliveira", "Souza", "Lima", "Ferreira", "Alves", "Pereira", "Costa", "Rodrigues"};

    public static List<Aluno> gerarAlunos(int quantidade) {
        List<Aluno> alunos = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < quantidade; i++) {
            // Gera um nome aleatório
            String nome = NOMES[random.nextInt(NOMES.length)] + " " + SOBRENOMES[random.nextInt(SOBRENOMES.length)];

            // Gera uma matrícula aleatória (ex: entre 100000 e 999999)
            int matricula = 100000 + random.nextInt(900000);

            // Gera uma nota aleatória (ex: entre 0.0 e 10.0)
            double nota = random.nextDouble() * 10;

            alunos.add(new Aluno(nome, nota, matricula));
        }

        return alunos;
    }

    public static void main(String[] args) {
        List<Aluno> alunos = gerarAlunos(10000);

        System.out.println("Exibindo os 10 primeiros: ");
        for (int i = 0; i < 10; i++) {
            System.out.println(alunos.get(i));
        }
    }
}