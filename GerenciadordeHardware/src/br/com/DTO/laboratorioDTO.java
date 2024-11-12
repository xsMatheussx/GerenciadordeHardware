package br.com.DTO;

// Classe DTO para representar os dados de um laboratório
public class laboratorioDTO {
    
    // Atributos privados do laboratório
    private int id_lab;        // Identificador único do laboratório
    private String letra_lab;  // Letra ou nome identificador do laboratório

    // Método getter para obter o ID do laboratório
    public int getId_lab() {
        return id_lab;
    }

    // Método setter para definir o ID do laboratório
    public void setId_lab(int id_lab) {
        this.id_lab = id_lab;
    }

    // Método getter para obter a letra identificadora do laboratório
    public String getLetra_lab() {
        return letra_lab;
    }

    // Método setter para definir a letra identificadora do laboratório
    public void setLetra_lab(String letra_lab) {
        this.letra_lab = letra_lab;
    }
}
