import java.io.Serializable;

abstract class Funcionario implements Serializable{
    protected String nome;
    protected double salario;
    protected int horasExtras;
    protected int totalHoras;

    public Funcionario(String nome, double salario, int horasExtras, int totalHoras) {
        this.nome = nome;
        this.salario = salario;
        this.horasExtras = horasExtras;
        this.totalHoras = totalHoras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void aumentarSalario(double aumento) {
        salario += aumento;
    }

    public double getSalarioAnual() {
        return salario * 12;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    static public double calcularHoraExtra(int horasExtras, int totalHoras, double salario) {
        double salarioHora = salario / (double) totalHoras;
        return salarioHora * 1.5;
    }

}