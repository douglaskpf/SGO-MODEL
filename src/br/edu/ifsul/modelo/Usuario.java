package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
public class Usuario extends PessoaFisica implements Serializable {
    
    @NotNull(message = "O nome do usuário não pode ser nulo")
    @NotBlank(message = "O nome do usuário deve ser informado")
    @Length(max = 20, message = "O nome do usuário não pode ter mais de {max} caracteres")
    @Column(name = "apelido", length = 20, nullable = false, unique = true)
    private String apelido;

    @NotNull(message = "A senha não pode ser nula")
    @NotBlank(message = "A senha deve ser informada")
    @Length(max = 20, message = "A senha não pode ter mais de {max} caracteres")
    @Column(name = "senha", length = 20, nullable = false)
    private String senha;

    @NotNull(message = "O administrador não pode ser nulo")
    @Column(name = "administrador", nullable = true)
    private Boolean administrador;

         
    public Usuario() {
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }
   
}
