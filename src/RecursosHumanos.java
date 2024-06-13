import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class RecursosHumanos {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void cadastrarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public void removerFuncionarioPorNome(String nomeFuncionario) {
        this.funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nomeFuncionario));
    }

    public void listarFuncionarios(){
        this.funcionarios.stream().forEach(System.out::println);
    }

    public void aumentarSalarioDeTodosOsFuncionarios(int porcentagemAumento) {
        BigDecimal porcentagemAumentoBigDecimal = BigDecimal.valueOf(porcentagemAumento);
        BigDecimal aumento = porcentagemAumentoBigDecimal.divide(BigDecimal.valueOf(100));

        this.funcionarios.stream().forEach(funcionario -> {
            BigDecimal valorDoAumento = funcionario.getSalario().multiply(aumento);
            funcionario.setSalario(funcionario.getSalario().add(valorDoAumento));
        });
    }

    public Map<String, List<Funcionario>> agruparFuncionariosPorFuncao(){
        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();
        return funcionarios.stream()
                .collect(Collectors.groupingBy(funcionario -> funcionario.getFuncao(), Collectors.mapping(funcionario -> funcionario, Collectors.toList())));
    }

    public void listarFuncionariosPeloPeriodoDeNascimento(int mesInicio, int mesFinal) {
        funcionarios.stream()
                .filter(funcionario -> LocalDate.parse(funcionario.getDataNascimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).getMonthValue() >= mesInicio
                        && LocalDate.parse(funcionario.getDataNascimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).getMonthValue() <= mesFinal)
                .sorted(Comparator.comparing(funcionario -> funcionario.getDataNascimento()))
                .forEach(funcionario -> System.out.println(funcionario));
    }

    public void listarFuncionarioComMaiorIdade() {
        Optional<Funcionario> funcionarioComMaiorIdade = funcionarios.stream()
                .max(Comparator.comparingInt(funcionario ->
                        calcularIdadeDoFuncionario(LocalDate.parse(funcionario.getDataNascimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))));
        System.out.println("Nome do funcionário com a maior idade: " + funcionarioComMaiorIdade.get().getNome()
                + "\nIdade: " + calcularIdadeDoFuncionario(LocalDate.parse(funcionarioComMaiorIdade.get().getDataNascimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))) + " anos");
    }

    public List<String> listarOsFuncionariosPorOrdemAlfabetica(){
        return funcionarios.stream()
                .sorted(Comparator.comparing(funcionario -> funcionario.getNome()))
                .map(funcionario -> "\nNome: " + funcionario.getNome() + "\nFunção: " + funcionario.getFuncao())
                .collect(Collectors.toList());
    }

    public BigDecimal totalDosSalarios() {
        return funcionarios.stream()
                .map(funcionario -> funcionario.getSalario())
                .reduce(BigDecimal.ZERO, (totalDosSalarios, salarioDoFuncionario) -> totalDosSalarios.add(salarioDoFuncionario));
    }

    public void quantosSalariosMinimosCadaFuncionarioRecebe() {
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        funcionarios.stream().forEach(funcionario -> {
            BigDecimal numeroSalariosMinimos = funcionario.getSalario().divide(salarioMinimo, 1, RoundingMode.HALF_UP);
            System.out.println("Funcionário: " + funcionario.getNome() + "\nSalário: R$ " + funcionario.getSalario() + "\nSalários mínimos: " + numeroSalariosMinimos);
        });
    }

    private int calcularIdadeDoFuncionario(LocalDate dataNascimento) {
        LocalDate dataAtual = LocalDate.now();
        return Period.between(dataNascimento, dataAtual).getYears();
    }
}

