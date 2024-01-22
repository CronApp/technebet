
package competicao.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.swagger.CronappSwagger;


/**
* Classe que representa a tabela EQUIPE
* @generated
*/
@javax.persistence.Entity
@javax.persistence.Table(name = "\"EQUIPE\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("competicao.entity.Equipe")
public class Equipe implements Serializable {
    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();


    /**
    * @generated
    */
    @Column(name = "nome", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String nome;


    /**
    * @generated
    */
    @Column(name = "pontuacao", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String pontuacao;


    /**
    * @generated
    */
    @Column(name = "classificado_eliminatoria", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean classificado_eliminatoria;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fase", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Fase fase;


    /**
    * @generated
    */
    @Column(name = "colocacao_final", nullable = true, unique = true, insertable=true, updatable=true)
        
        private java.lang.Integer colocacao_final;


    /**
    * @generated
    */
    @Column(name = "colocacao_grupo", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Integer colocacao_grupo;


    /**
    * @generated
    */
    @Column(name = "gols_pro", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String gols_pro;


    /**
    * @generated
    */
    @Column(name = "gols_contra", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String gols_contra;


    /**
    * @generated
    */
    @Column(name = "sigla", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String sigla;


    /**
    * @generated
    */
    @Column(name = "bandeira", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String bandeira;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="grupo", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Grupo grupo;


    /**
    * Construtor
    * @generated
    */
    public Equipe(){
    }

    /**
    * Obtém id
    * return id
    * @generated
    */
    public java.lang.String getId() {
        return this.id;
    }

    /**
    * Define id
    * @param id id
    * @generated
    */
    public Equipe setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém nome
    * return nome
    * @generated
    */
    public java.lang.String getNome() {
        return this.nome;
    }

    /**
    * Define nome
    * @param nome nome
    * @generated
    */
    public Equipe setNome(java.lang.String nome) {
        this.nome = nome;
        return this;
    }
    /**
    * Obtém pontuacao
    * return pontuacao
    * @generated
    */
    public java.lang.String getPontuacao() {
        return this.pontuacao;
    }

    /**
    * Define pontuacao
    * @param pontuacao pontuacao
    * @generated
    */
    public Equipe setPontuacao(java.lang.String pontuacao) {
        this.pontuacao = pontuacao;
        return this;
    }
    /**
    * Obtém classificado_eliminatoria
    * return classificado_eliminatoria
    * @generated
    */
    public java.lang.Boolean getClassificado_eliminatoria() {
        return this.classificado_eliminatoria;
    }

    /**
    * Define classificado_eliminatoria
    * @param classificado_eliminatoria classificado_eliminatoria
    * @generated
    */
    public Equipe setClassificado_eliminatoria(java.lang.Boolean classificado_eliminatoria) {
        this.classificado_eliminatoria = classificado_eliminatoria;
        return this;
    }
    /**
    * Obtém fase
    * return fase
    * @generated
    */
    public Fase getFase() {
        return this.fase;
    }

    /**
    * Define fase
    * @param fase fase
    * @generated
    */
    public Equipe setFase(Fase fase) {
        this.fase = fase;
        return this;
    }
    /**
    * Obtém colocacao_final
    * return colocacao_final
    * @generated
    */
    public java.lang.Integer getColocacao_final() {
        return this.colocacao_final;
    }

    /**
    * Define colocacao_final
    * @param colocacao_final colocacao_final
    * @generated
    */
    public Equipe setColocacao_final(java.lang.Integer colocacao_final) {
        this.colocacao_final = colocacao_final;
        return this;
    }
    /**
    * Obtém colocacao_grupo
    * return colocacao_grupo
    * @generated
    */
    public java.lang.Integer getColocacao_grupo() {
        return this.colocacao_grupo;
    }

    /**
    * Define colocacao_grupo
    * @param colocacao_grupo colocacao_grupo
    * @generated
    */
    public Equipe setColocacao_grupo(java.lang.Integer colocacao_grupo) {
        this.colocacao_grupo = colocacao_grupo;
        return this;
    }
    /**
    * Obtém gols_pro
    * return gols_pro
    * @generated
    */
    public java.lang.String getGols_pro() {
        return this.gols_pro;
    }

    /**
    * Define gols_pro
    * @param gols_pro gols_pro
    * @generated
    */
    public Equipe setGols_pro(java.lang.String gols_pro) {
        this.gols_pro = gols_pro;
        return this;
    }
    /**
    * Obtém gols_contra
    * return gols_contra
    * @generated
    */
    public java.lang.String getGols_contra() {
        return this.gols_contra;
    }

    /**
    * Define gols_contra
    * @param gols_contra gols_contra
    * @generated
    */
    public Equipe setGols_contra(java.lang.String gols_contra) {
        this.gols_contra = gols_contra;
        return this;
    }
    /**
    * Obtém sigla
    * return sigla
    * @generated
    */
    public java.lang.String getSigla() {
        return this.sigla;
    }

    /**
    * Define sigla
    * @param sigla sigla
    * @generated
    */
    public Equipe setSigla(java.lang.String sigla) {
        this.sigla = sigla;
        return this;
    }
    /**
    * Obtém bandeira
    * return bandeira
    * @generated
    */
    public java.lang.String getBandeira() {
        return this.bandeira;
    }

    /**
    * Define bandeira
    * @param bandeira bandeira
    * @generated
    */
    public Equipe setBandeira(java.lang.String bandeira) {
        this.bandeira = bandeira;
        return this;
    }
    /**
    * Obtém grupo
    * return grupo
    * @generated
    */
    public Grupo getGrupo() {
        return this.grupo;
    }

    /**
    * Define grupo
    * @param grupo grupo
    * @generated
    */
    public Equipe setGrupo(Grupo grupo) {
        this.grupo = grupo;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Equipe object = (Equipe)obj;
        if (id != null ? !id.equals(object.id) : object.id != null) return false;
        return true;
    }

    /**
    * @generated
    */
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}