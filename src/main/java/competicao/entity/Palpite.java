
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
* Classe que representa a tabela PALPITE
* @generated
*/
@javax.persistence.Entity
@javax.persistence.Table(name = "\"PALPITE\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("competicao.entity.Palpite")
public class Palpite implements Serializable {
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
    @Column(name = "usuario", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String usuario;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="partida", nullable = false, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Partida partida;


    /**
    * @generated
    */
    @Column(name = "gols_mandante", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Integer gols_mandante;


    /**
    * @generated
    */
    @Column(name = "gols_visitante", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Integer gols_visitante;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="ganhador_penalidades", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Equipe ganhador_penalidades;


    /**
    * @generated
    */
    @Column(name = "pontuacao", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Integer pontuacao;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_logPalpite", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private LogPalpite logPalpite;


    /**
    * Construtor
    * @generated
    */
    public Palpite(){
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
    public Palpite setId(java.lang.String id) {
        this.id = id;
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
    public Palpite setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
        return this;
    }
    /**
    * Obtém partida
    * return partida
    * @generated
    */
    public Partida getPartida() {
        return this.partida;
    }

    /**
    * Define partida
    * @param partida partida
    * @generated
    */
    public Palpite setPartida(Partida partida) {
        this.partida = partida;
        return this;
    }
    /**
    * Obtém gols_mandante
    * return gols_mandante
    * @generated
    */
    public java.lang.Integer getGols_mandante() {
        return this.gols_mandante;
    }

    /**
    * Define gols_mandante
    * @param gols_mandante gols_mandante
    * @generated
    */
    public Palpite setGols_mandante(java.lang.Integer gols_mandante) {
        this.gols_mandante = gols_mandante;
        return this;
    }
    /**
    * Obtém gols_visitante
    * return gols_visitante
    * @generated
    */
    public java.lang.Integer getGols_visitante() {
        return this.gols_visitante;
    }

    /**
    * Define gols_visitante
    * @param gols_visitante gols_visitante
    * @generated
    */
    public Palpite setGols_visitante(java.lang.Integer gols_visitante) {
        this.gols_visitante = gols_visitante;
        return this;
    }
    /**
    * Obtém ganhador_penalidades
    * return ganhador_penalidades
    * @generated
    */
    public Equipe getGanhador_penalidades() {
        return this.ganhador_penalidades;
    }

    /**
    * Define ganhador_penalidades
    * @param ganhador_penalidades ganhador_penalidades
    * @generated
    */
    public Palpite setGanhador_penalidades(Equipe ganhador_penalidades) {
        this.ganhador_penalidades = ganhador_penalidades;
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
    public Palpite setPontuacao(java.lang.Integer pontuacao) {
        this.pontuacao = pontuacao;
        return this;
    }
    /**
    * Obtém logPalpite
    * return logPalpite
    * @generated
    */
    public LogPalpite getLogPalpite() {
        return this.logPalpite;
    }

    /**
    * Define logPalpite
    * @param logPalpite logPalpite
    * @generated
    */
    public Palpite setLogPalpite(LogPalpite logPalpite) {
        this.logPalpite = logPalpite;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Palpite object = (Palpite)obj;
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