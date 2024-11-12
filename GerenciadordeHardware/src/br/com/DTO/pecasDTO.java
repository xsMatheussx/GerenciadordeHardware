
package br.com.DTO;


public class pecasDTO {
    private int id_pc;
    private String marca_pc;
    private int estoque_pc;
    private String nome_pc;
    private maquinaDTO id_eq;

    public int getId_pc() {
        return id_pc;
    }

    public void setId_pc(int id_pc) {
        this.id_pc = id_pc;
    }

    public String getMarca_pc() {
        return marca_pc;
    }

    public void setMarca_pc(String marca_pc) {
        this.marca_pc = marca_pc;
    }

    public int getEstoque_pc() {
        return estoque_pc;
    }

    public void setEstoque_pc(int estoque_pc) {
        this.estoque_pc = estoque_pc;
    }

    public String getNome_pc() {
        return nome_pc;
    }

    public void setNome_pc(String nome_pc) {
        this.nome_pc = nome_pc;
    }

    public maquinaDTO getId_eq() {
        return id_eq;
    }

    public void setId_eq(maquinaDTO id_eq) {
        this.id_eq = id_eq;
    }
    
    
}
