
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
* Classe que representa a tabela FASE
* @generated
*/
@javax.persistence.Entity
@javax.persistence.Table(name = "\"FASE\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("competicao.entity.Fase")
public class Fase implements Serializable {
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
    @Column(name = "nome_fase", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String nome_fase;


    /**
    * Construtor
    * @generated
    */
    public Fase(){
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
    public Fase setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém nome_fase
    * return nome_fase
    * @generated
    */
    public java.lang.String getNome_fase() {
        return this.nome_fase;
    }

    /**
    * Define nome_fase
    * @param nome_fase nome_fase
    * @generated
    */
    public Fase setNome_fase(java.lang.String nome_fase) {
        this.nome_fase = nome_fase;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Fase object = (Fase)obj;
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