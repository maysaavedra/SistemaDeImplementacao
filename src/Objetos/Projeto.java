
package Objetos;

public class Projeto {
    
    private Long cd_projeto;
    private String nome_projeto;
    private String desc_projeto;

    public Projeto() {
    }

    public Projeto(Long cd_projeto, String nome_projeto, String desc_projeto) {
        this.cd_projeto = cd_projeto;
        this.nome_projeto = nome_projeto;
        this.desc_projeto = desc_projeto;
    }

    public Long getCd_projeto() {
        return cd_projeto;
    }

    public void setCd_projeto(Long cd_projeto) {
        this.cd_projeto = cd_projeto;
    }

    public String getNome_projeto() {
        return nome_projeto;
    }

    public void setNome_projeto(String nome_projeto) {
        this.nome_projeto = nome_projeto;
    }

    public String getDesc_projeto() {
        return desc_projeto;
    }

    public void setDesc_projeto(String desc_projeto) {
        this.desc_projeto = desc_projeto;
    }

    @Override
    public String toString() {
        return "Projetos{" + "cd_projeto=" + cd_projeto + ", nome_projeto=" + nome_projeto + ", desc_projeto=" + desc_projeto + '}';
    }
    
    
    
            
    
}
