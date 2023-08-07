import java.util.ArrayList;

public class Turma implements IDisciplina{
    private String nomeTurma;
    private ArrayList<Disciplina> disciplinas;

    public Turma(String nomeTurma, ArrayList<Disciplina> disciplinas) {
        this.nomeTurma = nomeTurma;
        this.disciplinas = disciplinas;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public void obterDadosDisciplina(String nomeMateria) {
        nomeMateria = nomeMateria.substring(0, 1).toUpperCase() + nomeMateria.substring(1).toLowerCase();
        for (Disciplina disciplina : disciplinas) {
            if (nomeMateria.equals(disciplina.getNomeMateria())) {
                System.out.println("Disciplina: " + disciplina.getNomeMateria());
                System.out.println(disciplina.getHorarios());
                return;
            }
        }
        System.out.println("Não foi possível encontrar a disciplina.");
    }

    public void obterDadosDisciplinas() {
        for (Disciplina disciplina: disciplinas) {
            System.out.println("Disciplina: " + disciplina.getNomeMateria());
            System.out.println(disciplina.getHorarios());
        }
    }
}
