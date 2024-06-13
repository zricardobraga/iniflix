import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Funcionario maria = new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador");
        Funcionario joao = new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador");
        Funcionario caio = new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador");
        Funcionario miguel = new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor");
        Funcionario alice = new Funcionario("Alice", LocalDate.of(1995, 1, 05), new BigDecimal("2234.68"), "Recepcionista");
        Funcionario heitor = new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador");
        Funcionario arthur = new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador");
        Funcionario laura = new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente");
        Funcionario heloisa = new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista");
        Funcionario helena = new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente");

        RecursosHumanos rh = new RecursosHumanos();

        //adiciona os funcionários
        rh.cadastrarFuncionario(maria);
        rh.cadastrarFuncionario(joao);
        rh.cadastrarFuncionario(caio);
        rh.cadastrarFuncionario(miguel);
        rh.cadastrarFuncionario(alice);
        rh.cadastrarFuncionario(heitor);
        rh.cadastrarFuncionario(arthur);
        rh.cadastrarFuncionario(laura);
        rh.cadastrarFuncionario(heloisa);
        rh.cadastrarFuncionario(helena);

        //remove o funcionário pelo nome
        rh.removerFuncionarioPorNome("João");

        //dar um aumento conforme o valor desejado
        rh.aumentarSalarioDeTodosOsFuncionarios(10);

        //lista todos os funcionários
        rh.listarFuncionarios();

        //chamado do método que agrupa e lista os funcionários por função
        System.out.println(rh.agruparFuncionariosPorFuncao());

        //lista os funcionários pelo período determinado
        rh.listarFuncionariosPeloPeriodoDeNascimento(10, 12);

        //lista o funcionário com a maior idade
        rh.listarFuncionarioComMaiorIdade();

        //chamado do método que agrupa e lista os funcionários por ordem alfabética
        System.out.println(rh.listarOsFuncionariosPorOrdemAlfabetica());

        //lista os funcionários mostrando quandos salários mínimos cada um recebe
        rh.quantosSalariosMinimosCadaFuncionarioRecebe();

        ////chamado do método que agrupa e lista o valor total de todos os funcionários
        System.out.println("Valor total dos salários de todos os funcionários: " + rh.totalDosSalarios());

    }
}