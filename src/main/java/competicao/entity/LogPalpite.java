
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
* Classe que representa a tabela LOGPALPITE
* @generated
*/
@javax.persistence.Entity
@javax.persistence.Table(name = "\"LOGPALPITE\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("competicao.entity.LogPalpite")
public class LogPalpite implements Serializable {
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
    @Column(name = "email", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String email;


    /**
    * @generated
    */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_insercao", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.util.Date data_insercao;


    /**
    * Construtor
    * @generated
    */
    public LogPalpite(){
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
    public LogPalpite setId(java.lang.String id) {
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
    public LogPalpite setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
        return this;
    }
    /**
    * Obtém email
    * return email
    * @generated
    */
    public java.lang.String getEmail() {
        return this.email;
    }

    /**
    * Define email
    * @param email email
    * @generated
    */
    public LogPalpite setEmail(java.lang.String email) {
        this.email = email;
        return this;
    }
    /**
    * Obtém data_insercao
    * return data_insercao
    * @generated
    */
    public java.util.Date getData_insercao() {
        return this.data_insercao;
    }

    /**
    * Define data_insercao
    * @param data_insercao data_insercao
    * @generated
    */
    public LogPalpite setData_insercao(java.util.Date data_insercao) {
        this.data_insercao = data_insercao;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
LogPalpite object = (LogPalpite)obj;
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