import java.util.ArrayList;

public class Professor extends Funcionario implements IDisciplina{
    private ArrayList<Disciplina> disciplinasLecionadas;
    private int numeroRegistro;

    public Professor(String nome, double salario, int horasExtras, int totalHoras,
            ArrayList<Disciplina> disciplinasLecionadas, int numeroRegistro) {
        super(nome, salario, horasExtras, totalHoras);
        this.disciplinasLecionadas = disciplinasLecionadas;
        this.numeroRegistro = numeroRegistro;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public void obterDadosDisciplina(String nomeMateria) {
        nomeMateria = nomeMateria.substring(0, 1).toUpperCase() + nomeMateria.substring(1).toLowerCase();
        for (Disciplina disciplina : disciplinasLecionadas) {
            if (nomeMateria.equals(disciplina.getNomeMateria())) {
                System.out.println("Disciplina: " + disciplina.getNomeMateria());
                System.out.println(disciplina.getHorarios());
                return;
            }
        }
        System.out.println("Não foi possível encontrar a disciplina.");
    }

    public void obterDadosDisciplinas() {
        for (Disciplina disciplina: disciplinasLecionadas) {
            System.out.println("Disciplina: " + disciplina.getNomeMateria());
            System.out.println(disciplina.getHorarios());
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nSalário: " + salario + "\nNúmero de registro: " + numeroRegistro + "\nHoras extras: " + horasExtras +
        "\nTotal de horas trabalhadas: " + totalHoras;
    }


}