package br.com.DTO;

// Classe DTO para representar os dados de um usuário
public class UsuarioDTO {
    
    // Atributos privados do usuário
    private int id_usu;          // Identificador único do usuário
    private String nome_usu;     // Nome do usuário
    private String email_usu;    // E-mail do usuário
    private String senha_usu;    // Senha do usuário
    private String perfil_usu;   // Perfil ou papel do usuário (ex.: administrador, usuário comum)

    // Método getter para obter o ID do usuário
    public int getId_usu() {
        return id_usu;
    }

    // Método setter para definir o ID do usuário
    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    // Método getter para obter o nome do usuário
    public String getNome_usu() {
        return nome_usu;
    }

    // Método setter para definir o nome do usuário
    public void setNome_usu(String nome_usu) {
        this.nome_usu = nome_usu;
    }

    // Método getter para obter o e-mail do usuário
    public String getEmail_usu() {
        return email_usu;
    }

    // Método setter para definir o e-mail do usuário
    public void setEmail_usu(String email_usu) {
        this.email_usu = email_usu;
    }

    // Método getter para obter a senha do usuário
    public String getSenha_usu() {
        return senha_usu;
    }

    // Método setter para definir a senha do usuário
    public void setSenha_usu(String senha_usu) {
        this.senha_usu = senha_usu;
    }

    // Método getter para obter o perfil do usuário
    public String getPerfil_usu() {
        return perfil_usu;
    }

    // Método setter para definir o perfil do usuário
    public void setPerfil_usu(String perfil_usu) {
        this.perfil_usu = perfil_usu;
    }
}
