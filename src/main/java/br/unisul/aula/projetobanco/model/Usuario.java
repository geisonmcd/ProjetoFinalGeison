package br.unisul.aula.projetobanco.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "seq_usuario", allocationSize = 1)
public class Usuario {

    @Id
    @Column(name = "id_pessoas")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    private long id;
    
    @Column(name = "nm_pessoas")
    private String nome;
    
    @Column(name = "login")
    private String login;
    
    @Column(name = "nm_cargo")
    private String cargo;

    public Usuario(String nome, String cargo, String login) {
    	this.login = login;
        this.nome = nome;
        this.cargo = cargo;
    }

  
	public Usuario() {
    }
	
	  public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario pessoa = (Usuario) o;
        return id == pessoa.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
