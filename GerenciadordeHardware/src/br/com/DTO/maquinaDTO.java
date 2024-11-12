
package br.com.DTO;


public class maquinaDTO {
  private int id_eq;
  private String status;
  private laboratorioDTO laboratorio;


    public int getId_eq() {
        return id_eq;
    }

    public void setId_eq(int id_eq  ) {
        this.id_eq = id_eq;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public laboratorioDTO getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(laboratorioDTO laboratorio) {
        this.laboratorio = laboratorio;
    }


  
        
}
