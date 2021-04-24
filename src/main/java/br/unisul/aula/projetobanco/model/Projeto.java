package br.unisul.aula.projetobanco.model;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "projetos")
@SequenceGenerator(name = "seq_projeto", allocationSize = 1)
public class Projeto {

    @Id
    @Column(name = "id_projetos")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_projeto")
    private long id;

    @Column(name = "nm_descricao")
    private String nome;
    @Column(name = "dt_inicio")
    private Date dataPrevistaInicio;
    @Column(name = "dt_final")
    private Date dataPrevistaFim;


    public Projeto(String nome, Date dataPrevistaInicio, Date dataPrevistaFim) {
        this.nome = nome;
        this.dataPrevistaInicio = dataPrevistaInicio;
        this.dataPrevistaFim = dataPrevistaFim;
    }

    public Projeto(String nome, String dataIni, String dataFim) throws ParseException {
        this.nome = nome;
        setDataPrevistaInicio(dataIni);
        setDataPrevistaFim(dataFim);
    }

    public Projeto() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataPrevistaInicio() {
        return dataPrevistaInicio;
    }
    public String getDataPrevistaInicioFormatado() {
        return formatDateExibicao(dataPrevistaInicio);
    }

    public void setDataPrevistaInicio(Date dataPrevistaInicio) {
        this.dataPrevistaInicio = dataPrevistaInicio;
    }
    public void setDataPrevistaInicio(String dataPrevistaInicio) throws ParseException {
        this.dataPrevistaInicio = formatDate(dataPrevistaInicio);
    }

     public Date getDataPrevistaFim() {
        return dataPrevistaFim;
    }
    public String getDataPrevistaFimFormatado() {
        return formatDateExibicao(dataPrevistaFim);
    }

    public void setDataPrevistaFim(Date dataPrevistaFim) {
        this.dataPrevistaFim = dataPrevistaFim;
    }
    public void setDataPrevistaFim(String dataPrevistaFim) throws ParseException {
        this.dataPrevistaFim = formatDate(dataPrevistaFim);
    }

    private String formatDateExibicao(Date data){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(data);
    }
    private Date formatDate(String dataString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(dataString);
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projeto projeto = (Projeto) o;
        return id == projeto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
