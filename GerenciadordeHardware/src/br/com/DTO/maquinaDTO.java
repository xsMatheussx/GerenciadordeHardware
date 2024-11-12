package br.com.DTO;

// Classe DTO para representar os dados de uma máquina
public class maquinaDTO {
    
    // Atributos privados da máquina
    private int id_eq;              // Identificador único da máquina
    private String status;          // Status da máquina (por exemplo, "ativo" ou "inativo")
    private laboratorioDTO laboratorio; // Objeto `laboratorioDTO` associado à máquina

    // Método getter para obter o ID da máquina
    public int getId_eq() {
        return id_eq;
    }

    // Método setter para definir o ID da máquina
    public void setId_eq(int id_eq) {
        this.id_eq = id_eq;
    }

    // Método getter para obter o status da máquina
    public String getStatus() {
        return status;
    }

    // Método setter para definir o status da máquina
    public void setStatus(String status) {
        this.status = status;
    }

    // Método getter para obter o laboratório associado à máquina
    public laboratorioDTO getLaboratorio() {
        return laboratorio;
    }

    // Método setter para definir o laboratório associado à máquina
    public void setLaboratorio(laboratorioDTO laboratorio) {
        this.laboratorio = laboratorio;
    }
}
