public class Aluno implements Comparable<Aluno>{
    private String nome;
    private int nota;
    private int matricula;

    public Aluno(int nota, String nome, int matricula) {
        this.nota = nota;
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public int getNota() {
        return nota;
    }

    public int getMatricula() {
        return matricula;
    }

    public String toString() {
        return "Nota: " + nota + "; Nome: " + nome + "; Matrícula: " + matricula;
    }

    @Override
    public int compareTo(Aluno outro) {
        int comparacaoNota = Integer.compare(outro.nota, this.nota);
        if (comparacaoNota != 0) {
            return comparacaoNota;
        }

        int comparacaoNome = this.nome.compareTo(outro.nome);
        if (comparacaoNome != 0) {
            return comparacaoNome;
        }
        return Integer.compare(this.matricula, outro.matricula);
    }
}
