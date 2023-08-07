import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluno {
    private String nome;
    private int matricula;
    private Turma turma;
    private LocalDate dataNascimento;

    public Aluno(String nome, int matricula, Turma turma, String dataNascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.turma = turma;
        this.setDataNascimento(dataNascimento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}