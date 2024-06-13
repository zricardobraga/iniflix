import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public String getSalarioFormatado() {
        DecimalFormat formatter = new DecimalFormat("#,###,##0.00");
        String salarioFormatado = formatter.format(this.salario);
        return salarioFormatado;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSalário: R$ " + getSalarioFormatado() + "\nFunção: " + funcao;
    }
}

