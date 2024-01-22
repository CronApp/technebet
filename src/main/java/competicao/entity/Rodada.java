
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
* Classe que representa a tabela RODADA
* @generated
*/
@javax.persistence.Entity
@javax.persistence.Table(name = "\"RODADA\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("competicao.entity.Rodada")
public class Rodada implements Serializable {
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
    @Column(name = "rodada", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String rodada;


    /**
    * Construtor
    * @generated
    */
    public Rodada(){
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
    public Rodada setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém rodada
    * return rodada
    * @generated
    */
    public java.lang.String getRodada() {
        return this.rodada;
    }

    /**
    * Define rodada
    * @param rodada rodada
    * @generated
    */
    public Rodada setRodada(java.lang.String rodada) {
        this.rodada = rodada;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Rodada object = (Rodada)obj;
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