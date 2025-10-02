public class Aluno{
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
}
