
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "servico")
public class Servico implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_servico", sequenceName = "seq_servico_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_servico", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome deve ter até {max} caracteres")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
   
    @NotBlank(message = "O tipo deve ser informado")
    @Length(max = 50, message = "O tipo deve ter até {max} caracteres")
    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;
    
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor_servico", nullable = false, 
            columnDefinition = "numeric(12,2)")
    private Double valorServico;
    
    @NotNull(message = "O usuario deve ser informado")
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = true)
    private Usuario usuario;
    
    
    
    @OneToMany(mappedBy = "servico", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ServicoInsumo> itens = new ArrayList<>();
    // o valor em mappedBy refere-se ao atributo 
    // da classe parcela que faz referencia a classe servico
    // no caso ele se encontra dentro do atributo parcelaID
    
/*    @ManyToMany
        @JoinTable(name = "desejos",
            joinColumns = 
            @JoinColumn(name = "servico", referencedColumnName = "id", 
                    nullable = false), 
            inverseJoinColumns = 
            @JoinColumn(name = "pessoa_fisica", referencedColumnName = "id", 
                    nullable = false))
    private List<PessoaFisica> desejam = new ArrayList<>();
    
    */
    public Servico(){
        this.valorServico = 0.0;
    }
    
    
    
    public void adicionarItem(ServicoInsumo obj){
        obj.setServico(this);// seto a servico do objeto servicoInsumo
        this.valorServico += obj.getValorTotal(); // atualizo o valor
        this.itens.add(obj); // adiciono o item no servico
    }
    
    public void removerItem(int index){
        ServicoInsumo obj = this.itens.get(index);
        this.valorServico -= obj.getValorTotal();
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
      public Double getValorServico() {
        return valorServico;
    }

    public void setValorServico(Double valorServico) {
        this.valorServico = valorServico;
    }

    public List<ServicoInsumo> getItens() {
        return itens;
    }

    public void setItens(List<ServicoInsumo> itens) {
        this.itens = itens;
    }
     

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   
   @Override
    public String toString() {
        return nome;
    }

  

       
    
}
