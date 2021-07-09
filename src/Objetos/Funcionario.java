
package Objetos;


public class Funcionario {
    private Long matricula;
    private String nome;
    private String data_nasc;
    private String endereco;
    private String telefone;
    private String email;
    public Funcionario(){}
    public Funcionario(Long matricula, String nome, String data_nasc, String endereco, String telefone, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    
    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "matricula=" + matricula + ", nome=" + nome + ", data_nasc=" + data_nasc + ", endereco=" + endereco + ", telefone=" + telefone + ", email=" + email + '}';
    }
    
    
    
    
    
    
    
}
