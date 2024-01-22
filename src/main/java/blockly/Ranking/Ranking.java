package blockly.Ranking;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Ranking {

public static final int TIMEOUT = 300;

/**
 *
 * Ranking
 *
 * @param name
 *
 * @author Lucas Oliveira Da Silva
 * @since 09/12/2022 10:32:48
 *
 */
public static Var getFirstLastName(@ParamMetaData(description = "name", id = "190dfe5b") Var name) throws Exception {
 return new Callable<Var>() {

   private Var fullName = Var.VAR_NULL;
   private Var editedName = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         fullName =
        cronapi.list.Operations.getListFromText(name,
        Var.valueOf(" "));
        if (
        Var.valueOf(
        cronapi.list.Operations.size(fullName).compareTo(
        Var.valueOf(1)) > 0).getObjectAsBoolean()) {
            editedName =
            Var.valueOf(
            cronapi.list.Operations.getFirst(fullName).getObjectAsString() +
            Var.valueOf(" ").getObjectAsString() +
            cronapi.list.Operations.getLast(fullName).getObjectAsString());
        } else {
            editedName =
            cronapi.list.Operations.getFirst(fullName);
        }
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro na função verificaPalpiteEmpate"),
        Var.valueOf(""),
        Var.valueOf("Trace"),
        cronapi.util.Operations.getExceptionMessage(err));
     }
    return editedName;
   }
 }.call();
}

}

