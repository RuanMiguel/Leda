import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final String[] NOMES = {"Ana", "Bruno", "Carla", "Daniel", "Eduarda", "Felipe", "Gabriela", "Hugo", "Isabela", "João"};
    private static final String[] SOBRENOMES = {"Silva", "Santos", "Oliveira", "Souza", "Lima", "Ferreira", "Alves", "Pereira", "Costa", "Rodrigues"};

    public static void main(String[] args) {
        final int TAMANHO = 50;
        final int REPETICOES = 20;

        TipoVetor tipo = TipoVetor.ALEATORIO;

        int[] vetorOriginal = Utilitarios.geraVetor(TAMANHO, tipo);

        long somaCounting = 0;
        for (int i = 0; i < REPETICOES; i++) {
            int[] vetorA = vetorOriginal.clone();
            int[] vetorB = new int[vetorA.length];

            long inicio = System.nanoTime();
            Sort.countingSort(vetorA, vetorB);
            long fim = System.nanoTime();

            if (i >= 5) {
                somaCounting += (fim - inicio);
                //System.out.println("Execução " + (i+1) + ": " + (fim - inicio) + " ns");
            }
        }
        long mediaCounting = somaCounting / (REPETICOES - 5);
        //System.out.println("Tempo médio: " + mediaCounting + " ns");



        List<Aluno> alunosOriginais = gerarAlunos(TAMANHO);
        List<Aluno> ultimaListaOrdenada = null;

        long somaOrdenaAlunos = 0;
        for (int i = 0; i < REPETICOES; i++) {
            List<Aluno> alunos = new ArrayList<>(alunosOriginais);

            long inicio = System.nanoTime();

            alunos.sort(
                    java.util.Comparator
                            .comparingDouble(Aluno::getNota).reversed()
                            .thenComparing(Aluno::getNome)
                            .thenComparingInt(Aluno::getMatricula)
            );

            // for (Aluno a : alunos) {
            //     System.out.println(a);
            // }

            long fim = System.nanoTime();

            if (i == REPETICOES - 1) {
                ultimaListaOrdenada = alunos;
            }

            if (i >= 5) {
                somaOrdenaAlunos += (fim - inicio);
               // System.out.println("Execução " + (i+1) + ": " + (fim - inicio) + " ns");
            }
        }
/*
        System.out.println("Lista Ordenada");
        if (ultimaListaOrdenada != null) {
            for (Aluno a : ultimaListaOrdenada) {
                System.out.println(a);
            }
        } else {
            System.out.println("Nenhuma lista foi gerada");
        }
*/

        long mediaAlunos = somaOrdenaAlunos / (REPETICOES - 5);
        System.out.println("Tempo médio: " + mediaAlunos + " ns");
    }



    public static List<Aluno> gerarAlunos(int quantidade) {
        List<Aluno> alunos = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < quantidade; i++) {
            String nome = NOMES[random.nextInt(NOMES.length)] + " " +
                    SOBRENOMES[random.nextInt(SOBRENOMES.length)];
            int matricula = 100000 + random.nextInt(900000);
            int nota = random.nextInt(11);

            alunos.add(new Aluno(nota, nome, matricula));
        }

        return alunos;
    }
}
