
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "servico_insumo")
public class ServicoInsumo implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_servico_insumo", 
            sequenceName = "seq_servico_insumo_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_servico_insumo", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "A quantidade deve ser informada")
    @Column(name = "quantidade", nullable = false,columnDefinition = "numeric(10,2)")
    private Double quantidade;
    
    @NotNull(message = "O valor unitario deve ser informado")
    @Column(name = "valor_unitario", nullable = false,columnDefinition = "numeric(10,2)")    
    private Double valorUnitario;
    
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor_total", nullable = false,columnDefinition = "numeric(10,2)")    
    private Double valorTotal;
    
    @NotNull(message = "O servico deve ser informado")
    @ManyToOne
    @JoinColumn(name = "servico_id",referencedColumnName = "id", nullable = false)
    private Servico servico;

    @NotNull(message = "O insumo deve ser informado")
    @ManyToOne
    @JoinColumn(name = "insumo", referencedColumnName = "id", nullable = false)
    private Insumo insumo;
    
    

    public ServicoInsumo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
    
     public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
   

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
    
     public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ServicoInsumo other = (ServicoInsumo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

     

}
