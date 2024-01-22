package blockly.MinhaFinal;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class SelecaoCampea {

public static final int TIMEOUT = 300;

/**
 *
 * SelecaoCampea
 *
 * @param selecaoA
 * @param selecaoB
 * @param selecaoCampea
 *
 * @author Lucas Oliveira Da Silva
 * @since 07/12/2022 14:26:48
 *
 */
public static Var SalvarSelecaoCampea(@ParamMetaData(description = "param_selecaoA", id = "e7f68f1b") Var param_selecaoA, @ParamMetaData(description = "param_selecaoB", id = "85a17a57") Var param_selecaoB, @ParamMetaData(description = "param_selecaoCampea", id = "e4466129") Var param_selecaoCampea) throws Exception {
 return new Callable<Var>() {

   // param
   private Var selecaoA = param_selecaoA;
   private Var selecaoB = param_selecaoB;
   private Var selecaoCampea = param_selecaoCampea;
   // end
   private Var usuarioLogado = Var.VAR_NULL;
   private Var countSelecaoCampea = Var.VAR_NULL;
   private Var dataHoraLimite = Var.VAR_NULL;
   private Var dataHoraAtual = Var.VAR_NULL;
   private Var periodoEntreDatas = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
   private Var response = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         usuarioLogado =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u \nwhere \n	u.userName = :userName"),Var.valueOf("userName",
        cronapi.util.Operations.getCurrentUserName()))));
        countSelecaoCampea =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.MinhaFinal"),Var.valueOf("select \n	COUNT(m) \nfrom \n	MinhaFinal m \nwhere \n	m.usuario = :usuario"),Var.valueOf("usuario",usuarioLogado))));
        selecaoA =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Equipe"),Var.valueOf("select \n	e.id \nfrom \n	Equipe e \nwhere \n	e.nome = :nome"),Var.valueOf("nome",selecaoA))));
        selecaoB =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Equipe"),Var.valueOf("select \n	e.id \nfrom \n	Equipe e \nwhere \n	e.nome = :nome"),Var.valueOf("nome",selecaoB))));
        selecaoCampea =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Equipe"),Var.valueOf("select \n	e.id \nfrom \n	Equipe e \nwhere \n	e.nome = :nome"),Var.valueOf("nome",selecaoCampea))));
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
            Var.valueOf(countSelecaoCampea.compareTo(
            Var.valueOf(0)) > 0).getObjectAsBoolean()) {
                cronapi.database.Operations.execute(Var.valueOf("competicao.entity.MinhaFinal"), Var.valueOf("update \n	MinhaFinal  \nset \n	palpiteSelecaoA = :palpiteSelecaoA, \n	palpiteSelecaoB = :palpiteSelecaoB, \n	selecaoCampea = :selecaoCampea \nwhere \n	usuario = :usuario"),Var.valueOf("palpiteSelecaoA",selecaoA),Var.valueOf("palpiteSelecaoB",selecaoB),Var.valueOf("selecaoCampea",selecaoCampea),Var.valueOf("usuario",usuarioLogado));
            } else {
                item =
                cronapi.database.Operations.insert(Var.valueOf("competicao.entity.MinhaFinal"),Var.valueOf("palpiteSelecaoA",selecaoA),Var.valueOf("palpiteSelecaoB",selecaoB),Var.valueOf("selecaoCampea",selecaoCampea),Var.valueOf("usuario",usuarioLogado),Var.valueOf("pontuacao",
                Var.valueOf(0)));
            }
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_TRUE) , Var.valueOf("mensagem",
            Var.valueOf("Palpite salvo com sucesso")));
        } else {
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_FALSE) , Var.valueOf("mensagem",
            Var.valueOf("Tempo limite para palpitar na final excedido!")));
        }
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro ao SalvarSelecaoCampea"),
        Var.valueOf(""),
        Var.valueOf("Trace"), err);
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("mensagem",
        Var.valueOf("Falha ao salvar final, contate um administrador se o error persistir.")));
     }
    return response;
   }
 }.call();
}

/**
 *
 * SelecaoCampea
 *
 * @author Lucas Oliveira Da Silva
 * @since 07/12/2022 14:26:48
 *
 */
public static Var obterPalpiteSelecao() throws Exception {
 return new Callable<Var>() {

   private Var usuarioLogado = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
   private Var response = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         usuarioLogado =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u \nwhere \n	u.userName = :userName"),Var.valueOf("userName",
        cronapi.util.Operations.getCurrentUserName()))));
        item =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.MinhaFinal"),Var.valueOf("select \n	m \nfrom \n	MinhaFinal m \nwhere \n	m.usuario = :usuario"),Var.valueOf("usuario",usuarioLogado))));
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_TRUE) , Var.valueOf("dados",item));
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro ao obterPalpiteSelecao"),
        Var.valueOf(""),
        Var.valueOf("Trace"), err);
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("mensagem",
        Var.valueOf("Falha ao obter palpite da final, contate um administrador se o error persistir.")));
     }
    return response;
   }
 }.call();
}

}

