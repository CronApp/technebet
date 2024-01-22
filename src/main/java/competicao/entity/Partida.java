
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
* Classe que representa a tabela PARTIDA
* @generated
*/
@javax.persistence.Entity
@javax.persistence.Table(name = "\"PARTIDA\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("competicao.entity.Partida")
public class Partida implements Serializable {
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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora_partida", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.util.Date data_hora_partida;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="mandante", nullable = false, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Equipe mandante;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="visitante", nullable = false, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Equipe visitante;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_estadio", nullable = false, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Estadio estadio;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_fase", nullable = false, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Fase fase;


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
    @Column(name = "penalidades", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean penalidades;


    /**
    * @generated
    */
    @Column(name = "penaltis_mandante", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Integer penaltis_mandante;


    /**
    * @generated
    */
    @Column(name = "penaltis_visitante", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.Integer penaltis_visitante;


    /**
    * @generated
    */
    @Column(name = "partida_finalizada", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Boolean partida_finalizada;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_rodada", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Rodada rodada;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_status_Partida", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Status_Partida status_Partida;


    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="vencedor_penaltis", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Equipe vencedor_penaltis;


    /**
    * Construtor
    * @generated
    */
    public Partida(){
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
    public Partida setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém data_hora_partida
    * return data_hora_partida
    * @generated
    */
    public java.util.Date getData_hora_partida() {
        return this.data_hora_partida;
    }

    /**
    * Define data_hora_partida
    * @param data_hora_partida data_hora_partida
    * @generated
    */
    public Partida setData_hora_partida(java.util.Date data_hora_partida) {
        this.data_hora_partida = data_hora_partida;
        return this;
    }
    /**
    * Obtém mandante
    * return mandante
    * @generated
    */
    public Equipe getMandante() {
        return this.mandante;
    }

    /**
    * Define mandante
    * @param mandante mandante
    * @generated
    */
    public Partida setMandante(Equipe mandante) {
        this.mandante = mandante;
        return this;
    }
    /**
    * Obtém visitante
    * return visitante
    * @generated
    */
    public Equipe getVisitante() {
        return this.visitante;
    }

    /**
    * Define visitante
    * @param visitante visitante
    * @generated
    */
    public Partida setVisitante(Equipe visitante) {
        this.visitante = visitante;
        return this;
    }
    /**
    * Obtém estadio
    * return estadio
    * @generated
    */
    public Estadio getEstadio() {
        return this.estadio;
    }

    /**
    * Define estadio
    * @param estadio estadio
    * @generated
    */
    public Partida setEstadio(Estadio estadio) {
        this.estadio = estadio;
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
    public Partida setFase(Fase fase) {
        this.fase = fase;
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
    public Partida setGols_mandante(java.lang.Integer gols_mandante) {
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
    public Partida setGols_visitante(java.lang.Integer gols_visitante) {
        this.gols_visitante = gols_visitante;
        return this;
    }
    /**
    * Obtém penalidades
    * return penalidades
    * @generated
    */
    public java.lang.Boolean getPenalidades() {
        return this.penalidades;
    }

    /**
    * Define penalidades
    * @param penalidades penalidades
    * @generated
    */
    public Partida setPenalidades(java.lang.Boolean penalidades) {
        this.penalidades = penalidades;
        return this;
    }
    /**
    * Obtém penaltis_mandante
    * return penaltis_mandante
    * @generated
    */
    public java.lang.Integer getPenaltis_mandante() {
        return this.penaltis_mandante;
    }

    /**
    * Define penaltis_mandante
    * @param penaltis_mandante penaltis_mandante
    * @generated
    */
    public Partida setPenaltis_mandante(java.lang.Integer penaltis_mandante) {
        this.penaltis_mandante = penaltis_mandante;
        return this;
    }
    /**
    * Obtém penaltis_visitante
    * return penaltis_visitante
    * @generated
    */
    public java.lang.Integer getPenaltis_visitante() {
        return this.penaltis_visitante;
    }

    /**
    * Define penaltis_visitante
    * @param penaltis_visitante penaltis_visitante
    * @generated
    */
    public Partida setPenaltis_visitante(java.lang.Integer penaltis_visitante) {
        this.penaltis_visitante = penaltis_visitante;
        return this;
    }
    /**
    * Obtém partida_finalizada
    * return partida_finalizada
    * @generated
    */
    public java.lang.Boolean getPartida_finalizada() {
        return this.partida_finalizada;
    }

    /**
    * Define partida_finalizada
    * @param partida_finalizada partida_finalizada
    * @generated
    */
    public Partida setPartida_finalizada(java.lang.Boolean partida_finalizada) {
        this.partida_finalizada = partida_finalizada;
        return this;
    }
    /**
    * Obtém rodada
    * return rodada
    * @generated
    */
    public Rodada getRodada() {
        return this.rodada;
    }

    /**
    * Define rodada
    * @param rodada rodada
    * @generated
    */
    public Partida setRodada(Rodada rodada) {
        this.rodada = rodada;
        return this;
    }
    /**
    * Obtém status_Partida
    * return status_Partida
    * @generated
    */
    public Status_Partida getStatus_Partida() {
        return this.status_Partida;
    }

    /**
    * Define status_Partida
    * @param status_Partida status_Partida
    * @generated
    */
    public Partida setStatus_Partida(Status_Partida status_Partida) {
        this.status_Partida = status_Partida;
        return this;
    }
    /**
    * Obtém vencedor_penaltis
    * return vencedor_penaltis
    * @generated
    */
    public Equipe getVencedor_penaltis() {
        return this.vencedor_penaltis;
    }

    /**
    * Define vencedor_penaltis
    * @param vencedor_penaltis vencedor_penaltis
    * @generated
    */
    public Partida setVencedor_penaltis(Equipe vencedor_penaltis) {
        this.vencedor_penaltis = vencedor_penaltis;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Partida object = (Partida)obj;
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