package blockly.Usuario;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class BuscarUsuario {

public static final int TIMEOUT = 300;

/**
 *
 * BuscarUsuario
 *
 * @param email
 * @param name
 *
 * @author Lucas Oliveira Da Silva
 * @since 08/12/2022 10:34:32
 *
 */
public static Var atualizarUsuario(@ParamMetaData(description = "email", id = "0cc8c70c") Var email, @ParamMetaData(description = "name", id = "1379affe") Var name) throws Exception {
 return new Callable<Var>() {

   private Var retorno = Var.VAR_NULL;
   private Var erro = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         cronapi.database.Operations.execute(Var.valueOf("app.entity.User"), Var.valueOf("update \n	User  \nset \n	name = :name, \n	email = :email \nwhere \n	userName = :userName"),Var.valueOf("name",name),Var.valueOf("email",email),Var.valueOf("userName",
        cronapi.util.Operations.getCurrentUserName()));
        retorno =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_TRUE));
     } catch (Exception erro_exception) {
          erro = Var.valueOf(erro_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro ao buscar informações do usuário"),
        Var.valueOf(""),
        Var.valueOf("Trace"),
        cronapi.util.Operations.getExceptionMessage(erro));
        retorno =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("mensagem",
        cronapi.util.Operations.getExceptionMessage(erro)));
     }
    return retorno;
   }
 }.call();
}

/**
 *
 * BuscarUsuario
 *
 * @param username
 *
 * @author Lucas Oliveira Da Silva
 * @since 08/12/2022 10:34:32
 *
 */
public static Var buscarUsuario(@ParamMetaData(description = "username", id = "54de4b5d") Var username) throws Exception {
 return new Callable<Var>() {

   private Var retorno = Var.VAR_NULL;
   private Var erro = Var.VAR_NULL;
   private Var dadosUsuario = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         dadosUsuario =
        cronapi.list.Operations.getFirst((
        cronapi.json.Operations.toJson(
        cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.name, \n	u.email \nfrom \n	User u \nwhere \n	u.userName = :userName"),Var.valueOf("userName",
        cronapi.util.Operations.getCurrentUserName())))));
        retorno =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_TRUE) , Var.valueOf("dados",dadosUsuario));
     } catch (Exception erro_exception) {
          erro = Var.valueOf(erro_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro ao buscar informações do usuário"),
        Var.valueOf(""),
        Var.valueOf("Trace"),
        cronapi.util.Operations.getExceptionMessage(erro));
        retorno =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("mensagem",
        cronapi.util.Operations.getExceptionMessage(erro)));
     }
    return retorno;
   }
 }.call();
}

/**
 *
 * @author Lucas Oliveira Da Silva
 * @since 08/12/2022 10:34:32
 *
 */
public static Var excluirUsuario() throws Exception {
 return new Callable<Var>() {

   private Var usuarioId = Var.VAR_NULL;
   private Var retorno = Var.VAR_NULL;
   private Var erro = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         usuarioId =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u \nwhere \n	u.userName = :userName"),Var.valueOf("userName",
        cronapi.util.Operations.getCurrentUserName()))));
        cronapi.database.Operations.execute(Var.valueOf("competicao.entity.Palpite"), Var.valueOf("delete from \n	\n	Palpite  \nwhere \n	usuario = :usuario"),Var.valueOf("usuario",usuarioId));
        cronapi.database.Operations.execute(Var.valueOf("competicao.entity.MinhaFinal"), Var.valueOf("delete from \n	\n	MinhaFinal  \nwhere \n	usuario = :usuario"),Var.valueOf("usuario",usuarioId));
        cronapi.database.Operations.execute(Var.valueOf("app.entity.UserSecurable"), Var.valueOf("delete from \n	\n	UserSecurable  \nwhere \n	user.id = :id"),Var.valueOf("id",usuarioId));
        cronapi.database.Operations.execute(Var.valueOf("app.entity.UserRole"), Var.valueOf("delete from \n	\n	UserRole  \nwhere \n	user.id = :id"),Var.valueOf("id",usuarioId));
        cronapi.database.Operations.execute(Var.valueOf("app.entity.ApplicationUser"), Var.valueOf("delete from \n	\n	ApplicationUser  \nwhere \n	user.id = :id"),Var.valueOf("id",usuarioId));
        cronapi.database.Operations.execute(Var.valueOf("app.entity.User"), Var.valueOf("delete from \n	\n	User  \nwhere \n	id = :id"),Var.valueOf("id",usuarioId));
        retorno =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_TRUE));
     } catch (Exception erro_exception) {
          erro = Var.valueOf(erro_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro ao excluir usuário"),
        Var.valueOf(""),
        Var.valueOf("Trace"),
        cronapi.util.Operations.getExceptionMessage(erro));
        retorno =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("mensagem",
        cronapi.util.Operations.getExceptionMessage(erro)));
     }
    return retorno;
   }
 }.call();
}

}

