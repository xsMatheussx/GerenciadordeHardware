package br.com.DTO;

import br.com.DTO.maquinaDTO; // Importação da classe relacionada `maquinaDTO`
import java.sql.Date;

// Classe DTO para representar os dados de uma manutenção
public class manutencaoDTO {

    // Atributos privados da manutenção
    private int id_mn;         // Identificador único da manutenção
    private Date data_mn;      // Data da manutenção
    private String status_mn;  // Status atual da manutenção (por exemplo, "pendente" ou "concluída")
    private String hora_mn;    // Horário da manutenção
    private String tipo_mn;    // Tipo de manutenção (por exemplo, "preventiva" ou "corretiva")
    private maquinaDTO maquina; // Objeto `maquinaDTO` associado à manutenção

    // Método getter para obter o ID da manutenção
    public int getId_mn() {
        return id_mn;
    }

    // Método setter para definir o ID da manutenção
    public void setId_mn(int id_mn) {
        this.id_mn = id_mn;
    }

    // Método getter para obter a data da manutenção
    public Date getData_mn() {
        return data_mn;
    }

    // Método setter para definir a data da manutenção
    public void setData_mn(Date data_mn) {
        this.data_mn = data_mn;
    }

    // Método getter para obter o status da manutenção
    public String getStatus_mn() {
        return status_mn;
    }

    // Método setter para definir o status da manutenção
    public void setStatus_mn(String status_mn) {
        this.status_mn = status_mn;
    }

    // Método getter para obter o horário da manutenção
    public String getHora_mn() {
        return hora_mn;
    }

    // Método setter para definir o horário da manutenção
    public void setHora_mn(String hora_mn) {
        this.hora_mn = hora_mn;
    }

    // Método getter para obter o tipo de manutenção
    public String getTipo_mn() {
        return tipo_mn;
    }

    // Método setter para definir o tipo de manutenção
    public void setTipo_mn(String tipo_mn) {
        this.tipo_mn = tipo_mn;
    }

    // Método getter para obter a máquina associada à manutenção
    public maquinaDTO getMaquina() {
        return maquina;
    }

    // Método setter para definir a máquina associada à manutenção
    public void setMaquina(maquinaDTO maquina) {
        this.maquina = maquina;
    }

    // Construtor padrão que inicializa o atributo `maquina` com um novo objeto `maquinaDTO`
    public manutencaoDTO() {
        this.maquina = new maquinaDTO();
    }
}
