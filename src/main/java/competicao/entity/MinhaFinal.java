
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
* Classe que representa a tabela MINHAFINAL
* @generated
*/
@javax.persistence.Entity
@javax.persistence.Table(name = "\"MINHAFINAL\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("competicao.entity.MinhaFinal")
public class MinhaFinal implements Serializable {
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
    @ManyToOne
    @JoinColumn(name="palpiteSelecaoA", nullable = false, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Equipe palpiteSelecaoA;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="palpiteSelecaoB", nullable = false, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Equipe palpiteSelecaoB;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="selecaoCampea", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Equipe selecaoCampea;


    /**
    * @generated
    */
    @Column(name = "pontuacao", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Integer pontuacao;


    /**
    * @generated
    */
    @Column(name = "usuario", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String usuario;


    /**
    * Construtor
    * @generated
    */
    public MinhaFinal(){
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
    public MinhaFinal setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém palpiteSelecaoA
    * return palpiteSelecaoA
    * @generated
    */
    public Equipe getPalpiteSelecaoA() {
        return this.palpiteSelecaoA;
    }

    /**
    * Define palpiteSelecaoA
    * @param palpiteSelecaoA palpiteSelecaoA
    * @generated
    */
    public MinhaFinal setPalpiteSelecaoA(Equipe palpiteSelecaoA) {
        this.palpiteSelecaoA = palpiteSelecaoA;
        return this;
    }
    /**
    * Obtém palpiteSelecaoB
    * return palpiteSelecaoB
    * @generated
    */
    public Equipe getPalpiteSelecaoB() {
        return this.palpiteSelecaoB;
    }

    /**
    * Define palpiteSelecaoB
    * @param palpiteSelecaoB palpiteSelecaoB
    * @generated
    */
    public MinhaFinal setPalpiteSelecaoB(Equipe palpiteSelecaoB) {
        this.palpiteSelecaoB = palpiteSelecaoB;
        return this;
    }
    /**
    * Obtém selecaoCampea
    * return selecaoCampea
    * @generated
    */
    public Equipe getSelecaoCampea() {
        return this.selecaoCampea;
    }

    /**
    * Define selecaoCampea
    * @param selecaoCampea selecaoCampea
    * @generated
    */
    public MinhaFinal setSelecaoCampea(Equipe selecaoCampea) {
        this.selecaoCampea = selecaoCampea;
        return this;
    }
    /**
    * Obtém pontuacao
    * return pontuacao
    * @generated
    */
    public java.lang.Integer getPontuacao() {
        return this.pontuacao;
    }

    /**
    * Define pontuacao
    * @param pontuacao pontuacao
    * @generated
    */
    public MinhaFinal setPontuacao(java.lang.Integer pontuacao) {
        this.pontuacao = pontuacao;
        return this;
    }
    /**
    * Obtém usuario
    * return usuario
    * @generated
    */
    public java.lang.String getUsuario() {
        return this.usuario;
    }

    /**
    * Define usuario
    * @param usuario usuario
    * @generated
    */
    public MinhaFinal setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
MinhaFinal object = (MinhaFinal)obj;
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