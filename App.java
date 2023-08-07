import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String nome, diaSemana, horarioInicio, horarioFinal, nomeMateria, decisaoString, salarioString, horasExtraString, totalHorasString, numeroRegistroString,
        decisao1String;
        double salario;
        int horasExtras, totalHoras, numeroRegistro, decisao, decisao1;

        HorarioDisciplina horario;
        Disciplina disciplina;
        Professor professor;
        ArrayList<Object> professores = new ArrayList<>();
        try {
            professores = Serializador.ler("professores.dat");
        } catch (ClassNotFoundException | IOException e) {

            e.printStackTrace();
        }
        

        ArrayList<Disciplina> disciplinas;
        ArrayList<HorarioDisciplina> horarios;

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Adicionar professor\n2 - Consultar professor/a \n0 - Parar execução");
            decisao1String = s.nextLine();
            decisao1 = Integer.parseInt(decisao1String);
            
            if (decisao1 == 1) {
                disciplinas = new ArrayList<>();

                System.out.print("Digite o nome do professor: ");
                nome = s.nextLine();

                System.out.print("\nDigite o salario do professor: ");
                salarioString = s.nextLine();
                salario = Double.parseDouble(salarioString);

                System.out.print("\nDigite a quantidade de horas extras, se não tiver digite 0: ");
                horasExtraString = s.nextLine();
                horasExtras = Integer.parseInt(horasExtraString);

                System.out.print("\nDigite a quantidade de horas trabalhadas mensalmente: ");
                totalHorasString = s.nextLine();
                totalHoras = Integer.parseInt(totalHorasString);

                System.out.print("\nDigite o número de registro do professor/a: ");
                numeroRegistroString = s.nextLine();
                numeroRegistro = Integer.parseInt(numeroRegistroString);

                while (true) {
                    horarios = new ArrayList<>();
                    System.out.print("\nDigite o nome da matéria que o professor/a leciona: ");
                    nomeMateria = s.nextLine();

                    while (true) {
                        System.out.printf("\nDigite o dia da semana que tem aula desse matéria: ");
                        diaSemana = s.nextLine();

                        System.out.printf("\nDigite o horário de incio da matéria nesse dia da semana: (Hora:minuto a formatação)");
                        horarioInicio = s.nextLine();

                        System.out.print("\nDigite o horário final da matéria nesse dia da semana: (Hora:minuto a formatação)");
                        horarioFinal = s.nextLine();

                        horario = new HorarioDisciplina(diaSemana, horarioInicio, horarioFinal);
                        horarios.add(horario);

                        System.out.print("\nDeseja adicionar outro horário para essa matéria (1 - Sim, 2 - Não): ");
                        decisaoString = s.nextLine();
                        decisao = Integer.parseInt(decisaoString);

                        if (decisao == 2) {
                            break;
                        }

                    }
                    disciplina = new Disciplina(nomeMateria, horarios);
                    disciplinas.add(disciplina);

                    System.out.print("\nDeseja adicionar outra matéria (1 - Sim, 2 - Não): ");
                    decisaoString = s.nextLine();
                    decisao = Integer.parseInt(decisaoString);
                    if (decisao == 1) {
                        continue;
                    }

                    professor = new Professor(nome, salario, horasExtras, totalHoras, disciplinas, numeroRegistro);
                    professores.add(professor);
                    try {
                        Serializador.gravar(professores, "professores.dat");
                    } catch (IOException ex) {
                        System.out.println("Iniciando novo banco de dados para professores.\n");
                    }
                    break;

                }
            } else if (decisao1 == 2) {
                System.out.print("\nDigite o número de registro do professor: ");
                numeroRegistroString = s.nextLine();
                numeroRegistro = Integer.parseInt(numeroRegistroString);

                boolean achou = false;
                for (Object professorProcurado : professores) {
                    if (((Professor) professorProcurado).getNumeroRegistro() == numeroRegistro) {
                        professor = (Professor) professorProcurado;
                        System.out.println(professor);
                        while (true) {
                            System.out.print("\nDeseja consultar as matérias que o professor leciona, uma matéria específica ou parar a consulta (1 - Consultar todas as matérias, 2 - Consultar matéria específica, 0 - Parar consulta): ");
                            decisaoString = s.nextLine();
                            decisao = Integer.parseInt(decisaoString);

                            if (decisao == 0) {
                                break;
                            } else if (decisao == 1) {
                                professor.obterDadosDisciplinas();
                            } else {
                                System.out.print("\nDigite a matéria que deseja consultar: ");
                                nomeMateria = s.nextLine();
                                professor.obterDadosDisciplina(nomeMateria);
                            }
                        }
                        achou = true;
                        break;
                    }
                }

                if (achou == false) {
                    System.out.println("Registro não encontrado.");
                    continue;
                }

            } else if (decisao1 == 0) {
                break;
            }

        }
        s.close();
        
    }
}