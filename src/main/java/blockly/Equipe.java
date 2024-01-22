package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Administrators", execute = "Administrators")
public class Equipe {

public static final int TIMEOUT = 300;

/**
 *
 * Equipe
 *
 * @param response
 *
 * @author Lucas Oliveira Da Silva
 * @since 09/11/2022 13:41:03
 *
 */
public static Var Executar(@ParamMetaData(description = "response", id = "228e1172") Var response) throws Exception {
 return new Callable<Var>() {

   private Var request = Var.VAR_NULL;
   private Var selecao = Var.VAR_NULL;
   private Var inserir = Var.VAR_NULL;

   public Var call() throws Exception {
    request = response;
    for (Iterator it_selecao = request.iterator(); it_selecao.hasNext();) {
        selecao = Var.valueOf(it_selecao.next());
        inserir =
        cronapi.database.Operations.insert(Var.valueOf("competicao.entity.Equipe"),Var.valueOf("bandeira",
        cronapi.json.Operations.getJsonOrMapField(selecao,
        Var.valueOf("bandeira"))),Var.valueOf("gols_contra",
        Var.valueOf("0")),Var.valueOf("gols_pro",
        Var.valueOf("0")),Var.valueOf("nome",
        cronapi.json.Operations.getJsonOrMapField(selecao,
        Var.valueOf("nome_pais"))),Var.valueOf("pontuacao",
        Var.valueOf("0")),Var.valueOf("sigla",
        cronapi.json.Operations.getJsonOrMapField(selecao,
        Var.valueOf("iso3_br"))));
    } // end for
    return request;
   }
 }.call();
}

}

