public class Aluno{
    private String nome;
    private double nota;
    private int matricula;

    public Aluno(String nome, double nota, int matricula) {
        this.nome = nome;
        this.nota = nota;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    public int getMatricula() {
        return matricula;
    }

    public String toString() {
        return "Nome: " + nome + "; Nota: " + String.format("%.2f", nota) + "; Matrícula: " + matricula;
    }
}
