package blockly.MinhaFinal;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ObterPalpiteFinal {

public static final int TIMEOUT = 300;

/**
 *
 * ObterPalpiteFinal
 *
 * @author Lucas Oliveira Da Silva
 * @since 07/12/2022 14:30:06
 *
 */
public static Var obterPalpiteFinal() throws Exception {
 return new Callable<Var>() {

   private Var usuarioLogado = Var.VAR_NULL;
   private Var existePalpiteFinal = Var.VAR_NULL;
   private Var dataHoraLimite = Var.VAR_NULL;
   private Var dataHoraAtual = Var.VAR_NULL;
   private Var periodoEntreDatas = Var.VAR_NULL;
   private Var response = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         usuarioLogado =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u \nwhere \n	u.userName = :userName"),Var.valueOf("userName",
        cronapi.util.Operations.getCurrentUserName()))));
        existePalpiteFinal =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.MinhaFinal"),Var.valueOf("select \n	COUNT(m) \nfrom \n	MinhaFinal m \nwhere \n	m.usuario = :usuario"),Var.valueOf("usuario",usuarioLogado))));
        dataHoraLimite =
        cronapi.conversion.Operations.stringToDate(
        Var.valueOf("2022-12-08T20:00:00Z"),
        Var.valueOf(""));
        dataHoraAtual =
        cronapi.dateTime.Operations.incHour(
        cronapi.dateTime.Operations.getNow(),
        Var.valueOf(-3));
        periodoEntreDatas =
        cronapi.dateTime.Operations.getSecondsBetweenDates(dataHoraLimite, dataHoraAtual);
        if (
        Var.valueOf(periodoEntreDatas.compareTo(
        Var.valueOf(0)) >= 0).getObjectAsBoolean()) {
            if (
            Var.valueOf(existePalpiteFinal.compareTo(
            Var.valueOf(0)) > 0).getObjectAsBoolean()) {
                response =
                cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
                Var.VAR_FALSE));
            } else {
                response =
                cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
                Var.VAR_TRUE));
            }
        } else {
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_FALSE));
        }
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro ao obterPalpiteFinal"),
        Var.valueOf(""),
        Var.valueOf("Trace"), err);
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE));
     }
    return response;
   }
 }.call();
}

}

