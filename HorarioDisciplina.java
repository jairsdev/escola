import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HorarioDisciplina implements Serializable{
    private String diaSemana;
    private LocalTime horarioInicio;
    private LocalTime horarioFinal;
    
    public HorarioDisciplina(String diaSemana, String horarioInicio, String horarioFinal) {
        this.diaSemana = diaSemana;
        setHorarioInicio(horarioInicio);
        setHorarioFinal(horarioFinal);
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public void setHorarioInicio(String horarioInicio) {
        try {
            this.horarioInicio = LocalTime.parse(horarioInicio, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (Exception DateTimeParseException) {
            this.horarioInicio = LocalTime.parse(horarioInicio, DateTimeFormatter.ofPattern("H:mm"));
        }    
    }

    public void setHorarioFinal(String horarioFinal) {
        try {
            this.horarioFinal = LocalTime.parse(horarioFinal, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (Exception DateTimeParseException) {
            this.horarioFinal = LocalTime.parse(horarioFinal, DateTimeFormatter.ofPattern("H:mm"));
        }
    }

    public String getHorario() {
        String horario  = diaSemana + ": " + horarioInicio + " - " + horarioFinal + "\n";
        return horario;
    }
}