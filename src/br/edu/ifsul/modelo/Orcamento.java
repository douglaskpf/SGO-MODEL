
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "orcamento")
public class Orcamento implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_orcamento", sequenceName = "seq_orcamento_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_orcamento", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não deve ultrapassar {max} caracteres")    
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
     
    @NotNull(message = "A data deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Calendar data;
    
    @Column(name = "descricao", columnDefinition = "text")
    private String descricao;
    
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor_total", nullable = true, 
            columnDefinition = "numeric(12,2)")
    private Double valorTotal;
    
    @NotNull(message = "Ativo não pode ser nulo")
    @Column(name = "ativo", nullable = false)
    private Boolean status;
    
    @NotNull(message = "O usuario deve ser informado")
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)
    private Usuario usuario;
    
    @NotNull(message = "A pessoa fisica deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa_fisica", referencedColumnName = "id", nullable = false)
    private PessoaFisica pessoaFisica;
    
    @OneToMany(mappedBy = "orcamento", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<OrcamentoItem> itens = new ArrayList<>();
    

    
    public Orcamento(){
        this.valorTotal = 0.0;
    }
    
     
    public void adicionarItem(OrcamentoItem obj){
        obj.setOrcamento(this);// seto o orcamento do objeto orcamento itens
        this.valorTotal += obj.getValorTotal(); // atualizo o valor
        this.itens.add(obj); // adiciono o item no orcamento
    }
    
    public void removerItem(int index){
        OrcamentoItem obj = this.itens.get(index);
        this.valorTotal -= obj.getValorTotal();
        this.itens.remove(obj);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public Calendar getData() {
        return data;
    }
    
    public void setData(Calendar data) {
        this.data = data;
    }
    
      public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
      public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

  
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    
    public List<OrcamentoItem> getItens() {
        return itens;
    }

    public void setItens(List<OrcamentoItem> itens) {
        this.itens = itens;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Orcamento other = (Orcamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Orcamento{" + "id=" + id + ", data=" + data + '}';
    }

       
         
    
}
