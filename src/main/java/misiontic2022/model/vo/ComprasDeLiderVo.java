package misiontic2022.model.vo;

public class ComprasDeLiderVo {
    
    private String id;
    private Double valor;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    @Override
    public String toString() {
        return "ComprasDeLiderVo [id=" + id + ", valor=" + valor + "]";
    }

    
}
