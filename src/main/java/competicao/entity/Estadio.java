
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
* Classe que representa a tabela ESTADIO
* @generated
*/
@javax.persistence.Entity
@javax.persistence.Table(name = "\"ESTADIO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("competicao.entity.Estadio")
public class Estadio implements Serializable {
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
    @Column(name = "nome_estadio", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String nome_estadio;


    /**
    * @generated
    */
    @Column(name = "cidade", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String cidade;


    /**
    * Construtor
    * @generated
    */
    public Estadio(){
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
    public Estadio setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém nome_estadio
    * return nome_estadio
    * @generated
    */
    public java.lang.String getNome_estadio() {
        return this.nome_estadio;
    }

    /**
    * Define nome_estadio
    * @param nome_estadio nome_estadio
    * @generated
    */
    public Estadio setNome_estadio(java.lang.String nome_estadio) {
        this.nome_estadio = nome_estadio;
        return this;
    }
    /**
    * Obtém cidade
    * return cidade
    * @generated
    */
    public java.lang.String getCidade() {
        return this.cidade;
    }

    /**
    * Define cidade
    * @param cidade cidade
    * @generated
    */
    public Estadio setCidade(java.lang.String cidade) {
        this.cidade = cidade;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Estadio object = (Estadio)obj;
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