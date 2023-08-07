import java.io.Serializable;
import java.util.ArrayList;

public class Disciplina implements Serializable{
    private String nomeMateria;
    private ArrayList<HorarioDisciplina> horariosDisciplina;

    public Disciplina(String nomeMateria, ArrayList<HorarioDisciplina> horarioDisciplinas) {
        nomeMateria = nomeMateria.substring(0, 1).toUpperCase() + nomeMateria.substring(1).toLowerCase();
        this.nomeMateria = nomeMateria;
        this.horariosDisciplina = horarioDisciplinas;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public String getHorarios() {
        String horarios = "";
        for (HorarioDisciplina horarioDisciplina : horariosDisciplina) {
            horarios += horarioDisciplina.getHorario();
        }
        return horarios;
    }
}