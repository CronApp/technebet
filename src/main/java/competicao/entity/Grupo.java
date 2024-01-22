
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
* Classe que representa a tabela GRUPO
* @generated
*/
@javax.persistence.Entity
@javax.persistence.Table(name = "\"GRUPO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("competicao.entity.Grupo")
public class Grupo implements Serializable {
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
    @Column(name = "nome_grupo", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String nome_grupo;


    /**
    * @generated
    */
    @Column(name = "quantidade_classificados", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Integer quantidade_classificados;


    /**
    * Construtor
    * @generated
    */
    public Grupo(){
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
    public Grupo setId(java.lang.String id) {
        this.id = id;
        return this;
    }
    /**
    * Obtém nome_grupo
    * return nome_grupo
    * @generated
    */
    public java.lang.String getNome_grupo() {
        return this.nome_grupo;
    }

    /**
    * Define nome_grupo
    * @param nome_grupo nome_grupo
    * @generated
    */
    public Grupo setNome_grupo(java.lang.String nome_grupo) {
        this.nome_grupo = nome_grupo;
        return this;
    }
    /**
    * Obtém quantidade_classificados
    * return quantidade_classificados
    * @generated
    */
    public java.lang.Integer getQuantidade_classificados() {
        return this.quantidade_classificados;
    }

    /**
    * Define quantidade_classificados
    * @param quantidade_classificados quantidade_classificados
    * @generated
    */
    public Grupo setQuantidade_classificados(java.lang.Integer quantidade_classificados) {
        this.quantidade_classificados = quantidade_classificados;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Grupo object = (Grupo)obj;
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