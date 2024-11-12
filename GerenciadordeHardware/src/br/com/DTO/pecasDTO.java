package br.com.DTO;

// Classe DTO para representar os dados de uma peça
public class pecasDTO {

    // Atributos privados da peça
    private int id_pc;            // Identificador único da peça
    private String marca_pc;      // Marca da peça
    private int estoque_pc;       // Quantidade de peças em estoque
    private String nome_pc;       // Nome da peça
    private maquinaDTO id_eq;     // Objeto `maquinaDTO` associado à peça (a máquina relacionada à peça)

    // Método getter para obter o ID da peça
    public int getId_pc() {
        return id_pc;
    }

    // Método setter para definir o ID da peça
    public void setId_pc(int id_pc) {
        this.id_pc = id_pc;
    }

    // Método getter para obter a marca da peça
    public String getMarca_pc() {
        return marca_pc;
    }

    // Método setter para definir a marca da peça
    public void setMarca_pc(String marca_pc) {
        this.marca_pc = marca_pc;
    }

    // Método getter para obter a quantidade de peças em estoque
    public int getEstoque_pc() {
        return estoque_pc;
    }

    // Método setter para definir a quantidade de peças em estoque
    public void setEstoque_pc(int estoque_pc) {
        this.estoque_pc = estoque_pc;
    }

    // Método getter para obter o nome da peça
    public String getNome_pc() {
        return nome_pc;
    }

    // Método setter para definir o nome da peça
    public void setNome_pc(String nome_pc) {
        this.nome_pc = nome_pc;
    }

    // Método getter para obter a máquina associada à peça
    public maquinaDTO getId_eq() {
        return id_eq;
    }

    // Método setter para definir a máquina associada à peça
    public void setId_eq(maquinaDTO id_eq) {
        this.id_eq = id_eq;
    }
}
