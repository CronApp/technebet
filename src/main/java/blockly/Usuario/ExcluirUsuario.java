package blockly.Usuario;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ExcluirUsuario {

public static final int TIMEOUT = 300;

/**
 *
 * ExcluirUsuario
 *
 * @param usuarioId
 *
 * @author Lucas Oliveira Da Silva
 * @since 08/12/2022 11:07:16
 *
 */
public static Var excluirUsuario(@ParamMetaData(description = "usuarioId", id = "e656d06b") Var usuarioId) throws Exception {
 return new Callable<Var>() {

   private Var erro = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         cronapi.database.Operations.execute(Var.valueOf("competicao.entity.Palpite"), Var.valueOf("delete from \n	\n	Palpite  \nwhere \n	usuario = :usuario"),Var.valueOf("usuario",usuarioId));
        cronapi.database.Operations.execute(Var.valueOf("competicao.entity.MinhaFinal"), Var.valueOf("delete from \n	\n	MinhaFinal  \nwhere \n	usuario = :usuario"),Var.valueOf("usuario",usuarioId));
        cronapi.database.Operations.execute(Var.valueOf("app.entity.UserSecurable"), Var.valueOf("delete from \n	\n	UserSecurable  \nwhere \n	user.id = :id"),Var.valueOf("id",usuarioId));
        cronapi.database.Operations.execute(Var.valueOf("app.entity.UserRole"), Var.valueOf("delete from \n	\n	UserRole  \nwhere \n	user.id = :id"),Var.valueOf("id",usuarioId));
        cronapi.database.Operations.execute(Var.valueOf("app.entity.ApplicationUser"), Var.valueOf("delete from \n	\n	ApplicationUser  \nwhere \n	user.id = :id"),Var.valueOf("id",usuarioId));
        cronapi.database.Operations.execute(Var.valueOf("app.entity.User"), Var.valueOf("delete from \n	\n	User  \nwhere \n	id = :id"),Var.valueOf("id",usuarioId));
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
        Var.valueOf("Usuário excluído com sucesso"));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"),
        Var.valueOf("User"),
        Var.valueOf("true"));
     } catch (Exception erro_exception) {
          erro = Var.valueOf(erro_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro ao excluir usuário"),
        Var.valueOf(""),
        Var.valueOf("Trace"),
        cronapi.util.Operations.getExceptionMessage(erro));
     }
    return Var.VAR_NULL;
   }
 }.call();
}

}

