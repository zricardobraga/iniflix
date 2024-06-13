import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa {

    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        String dataNascimentoFormatada = this.dataNascimento.format(dateTimeFormatter);
        return dataNascimentoFormatada;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nData de nascimento: " + getDataNascimento();
    }
}
