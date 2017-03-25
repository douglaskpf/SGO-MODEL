
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public abstract class Pessoa implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_pessoa",sequenceName = "seq_pessoa_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome deve ter até {max} caracteres")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    
    @NotBlank(message = "O telefone deve ser informado")
    @Length(max = 15, message = "O numero não deve ultrapassar {max} caracteres")
    @Column(name = "telefone", nullable = false, length = 15)    
    private String telefone;   
    
    @Email(message = "Informe um email valido")
    @NotBlank(message = "O email deve ser informado")
    @Length(max = 50, message = "O email deve ter até {max} caracteres")
    @Column(name = "email", nullable = false, length = 50)    
    private String email;
    
    @NotBlank(message = "O endereço deve ser informado")
    @Length(max = 50, message = "O endereço deve ter até {max} caracteres")
    @Column(name = "endereco", nullable = false, length = 50)    
    private String endereco;
     
    
    @NotBlank(message = "O bairro deve ser informado")
    @Length(max = 30, message = "O bairro deve ter até {max} caracteres")
    @Column(name = "bairro", nullable = false, length = 30)      
    private String bairro;
    
    @NotBlank(message = "O cep deve ser informado")
    @Length(max = 9, message = "O cep deve ter até {max} caracteres")
    @Column(name = "cep", nullable = false, length = 9)      
    private String cep;
    
    @Length(max = 30, message = "O complemento deve ter até {max} caracteres")
    @Column(name = "complemento", length = 30)        
    private String complemento;
    
    @NotNull(message = "A Cidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "cidade", referencedColumnName = "id", nullable = false)        
     private Cidade cidade;

    public Pessoa() {
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
    
     public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String numero) {
        this.telefone = numero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Pessoa other = (Pessoa) obj;
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
