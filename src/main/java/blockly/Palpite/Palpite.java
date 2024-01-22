package blockly.Palpite;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Palpite {

public static final int TIMEOUT = 300;

/**
 *
 * @param partida
 *
 * @author Matheus Portugal Ribeiro
 * @since 01/12/2022 16:55:45
 *
 */
public static Var obterPalpite(@ParamMetaData(description = "partida", id = "fce6f965") Var partida) throws Exception {
 return new Callable<Var>() {

   private Var usuario = Var.VAR_NULL;
   private Var response = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;
   private Var partidaInfo = Var.VAR_NULL;
   private Var palpite = Var.VAR_NULL;
   private Var todosPalpitesPartidda = Var.VAR_NULL;
   private Var listaPalpites = Var.VAR_NULL;
   private Var podeExibirPalpite = Var.VAR_NULL;
   private Var texto_gols_palpite = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var usuarioPalpitador = Var.VAR_NULL;
   private Var pontuacaoPalpite = Var.VAR_NULL;
   private Var palpitePenalti = Var.VAR_NULL;
   private Var selecaoVencedoraNomePalpite = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         usuario =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u \nwhere \n	u.userName = :userName"),Var.valueOf("userName",
        cronapi.util.Operations.getCurrentUserName()))));
        palpite =
        cronapi.list.Operations.getFirst((
        cronapi.json.Operations.toJson(
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("select \n	p.gols_mandante, \n	p.gols_visitante \nfrom \n	Palpite p \nwhere \n	p.usuario = :usuario AND \n	p.partida.id = :partidaId"),Var.valueOf("usuario",usuario),Var.valueOf("partidaId",partida)))));
        todosPalpitesPartidda =
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("select \n	p \nfrom \n	Palpite p \nwhere \n	p.partida.id = :partidaId"),Var.valueOf("partidaId",partida));
        listaPalpites =
        cronapi.list.Operations.newList();
        podeExibirPalpite =
        Var.VAR_TRUE;
        partidaInfo =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p \nfrom \n	Partida p \nwhere \n	p.id = :id"),Var.valueOf("id",partida))));
        if (
        Var.valueOf(
        cronapi.json.Operations.getJsonOrMapField(partidaInfo,
        Var.valueOf("status_Partida.nome_status")).equals(
        Var.valueOf("Não iniciada"))).getObjectAsBoolean()) {
            podeExibirPalpite =
            Var.VAR_FALSE;
        }
        texto_gols_palpite =
        Var.valueOf(" - ");
        for (Iterator it_i = todosPalpitesPartidda.iterator(); it_i.hasNext();) {
            i = Var.valueOf(it_i.next());
            if (
            Var.valueOf(!
            cronapi.json.Operations.getJsonOrMapField(i,
            Var.valueOf("usuario")).equals(usuario)).getObjectAsBoolean()) {
                usuarioPalpitador =
                cronapi.list.Operations.getFirst((
                cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.name \nfrom \n	User u \nwhere \n	u.id = :id"),Var.valueOf("id",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("usuario"))))));
                pontuacaoPalpite =
                Var.valueOf(0);
                if (
                cronapi.logic.Operations.isNullOrEmpty(
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("pontuacao")))
                .negate().getObjectAsBoolean()) {
                    pontuacaoPalpite =
                    cronapi.json.Operations.getJsonOrMapField(i,
                    Var.valueOf("pontuacao"));
                }
                if (podeExibirPalpite.getObjectAsBoolean()) {
                    texto_gols_palpite =
                    Var.valueOf(
                    cronapi.json.Operations.getJsonOrMapField(i,
                    Var.valueOf("gols_mandante")).getObjectAsString() +
                    Var.valueOf(" x ").getObjectAsString() +
                    cronapi.json.Operations.getJsonOrMapField(i,
                    Var.valueOf("gols_visitante")).getObjectAsString());
                    cronapi.list.Operations.addLast(listaPalpites,
                    cronapi.map.Operations.createObjectMapWith(Var.valueOf("nome",usuarioPalpitador) , Var.valueOf("texto_gols_palpite",texto_gols_palpite) , Var.valueOf("pontuacao",pontuacaoPalpite)));
                }
            }
        } // end for
        palpitePenalti =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("select \n	p.ganhador_penalidades.id \nfrom \n	Palpite p \nwhere \n	p.usuario = :usuario AND \n	p.partida.id = :partidaId"),Var.valueOf("usuario",usuario),Var.valueOf("partidaId",partida))));
        if (
        cronapi.logic.Operations.isNullOrEmpty(palpitePenalti)
        .negate().getObjectAsBoolean()) {
            selecaoVencedoraNomePalpite =
            cronapi.list.Operations.getFirst((
            cronapi.database.Operations.query(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("select \n	p.ganhador_penalidades.nome \nfrom \n	Palpite p \nwhere \n	p.usuario = :usuario AND \n	p.partida.id = :partidaId"),Var.valueOf("usuario",usuario),Var.valueOf("partidaId",partida))));
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_TRUE) , Var.valueOf("palpite",palpite) , Var.valueOf("partida",partidaInfo) , Var.valueOf("listaPalpites",listaPalpites) , Var.valueOf("penaltis",
            Var.VAR_TRUE) , Var.valueOf("vencedorPenal",palpitePenalti) , Var.valueOf("vencedorPenalNome",selecaoVencedoraNomePalpite));
        } else {
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_TRUE) , Var.valueOf("palpite",palpite) , Var.valueOf("partida",partidaInfo) , Var.valueOf("listaPalpites",listaPalpites));
        }
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro no obterPalpite"),
        Var.valueOf(""),
        Var.valueOf("Trace"), err);
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("mensagem",
        Var.valueOf("Erro ao obter partida, contate um administrador.")));
     }
    return response;
   }
 }.call();
}

/**
 *
 * @param partida
 *
 * @author Matheus Portugal Ribeiro
 * @since 01/12/2022 16:55:45
 *
 */
public static Var palpiteNulo(@ParamMetaData(description = "partida", id = "dd70be53") Var partida) throws Exception {
 return new Callable<Var>() {

   private Var statusPartida = Var.VAR_NULL;
   private Var usuario = Var.VAR_NULL;
   private Var palpiteUsuario = Var.VAR_NULL;
   private Var existePalpite = Var.VAR_NULL;
   private Var response = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         statusPartida =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p.status_Partida.nome_status \nfrom \n	Partida p \nwhere \n	p.id = :id"),Var.valueOf("id",partida))));
        usuario =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u \nwhere \n	u.userName = :userName"),Var.valueOf("userName",
        cronapi.util.Operations.getCurrentUserName()))));
        palpiteUsuario =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("select \n	p \nfrom \n	Palpite p \nwhere \n	p.usuario = :usuario AND \n	p.partida.id = :partidaId"),Var.valueOf("usuario",usuario),Var.valueOf("partidaId",partida))));
        existePalpite =
        Var.valueOf(1);
        if (
        Var.valueOf(
        Var.valueOf(!statusPartida.equals(
        Var.valueOf("Não iniciada"))).getObjectAsBoolean() &&
        cronapi.logic.Operations.isNullOrEmpty(palpiteUsuario).getObjectAsBoolean()).getObjectAsBoolean()) {
            existePalpite =
            Var.valueOf(0);
        }
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_TRUE) , Var.valueOf("palpite",existePalpite));
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro no PalpiteNulo"),
        Var.valueOf(""),
        Var.valueOf("Trace"),
        cronapi.util.Operations.getExceptionMessage(err));
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("mensagem",
        cronapi.util.Operations.getExceptionMessage(err)));
     }
    return response;
   }
 }.call();
}

/**
 *
 * @param partida
 * @param gols_mandante
 * @param gols_visitante
 * @param ganhador_penalidades
 *
 * @author Matheus Portugal Ribeiro
 * @since 01/12/2022 16:55:45
 *
 */
public static Var salvarPalpite(@ParamMetaData(description = "partida", id = "ce0078bd") Var partida, @ParamMetaData(description = "gols_mandante", id = "9679eb3b") Var gols_mandante, @ParamMetaData(description = "gols_visitante", id = "e0d2737e") Var gols_visitante, @ParamMetaData(description = "ganhador_penalidades", id = "b1a96bc3") Var ganhador_penalidades) throws Exception {
 return new Callable<Var>() {

   private Var existePalpite = Var.VAR_NULL;
   private Var response = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;
   private Var partidaInfo = Var.VAR_NULL;
   private Var usuarioLogado = Var.VAR_NULL;
   private Var dataHoraPartida = Var.VAR_NULL;
   private Var dataHoraLimitePalpite = Var.VAR_NULL;
   private Var dataHoraAtual = Var.VAR_NULL;
   private Var periodoEntreDatas = Var.VAR_NULL;
   private Var idLogoPalpite = Var.VAR_NULL;
   private Var logPalpite = Var.VAR_NULL;
   private Var existeEmpate = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         partidaInfo =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p \nfrom \n	Partida p \nwhere \n	p.id = :id"),Var.valueOf("id",partida))));
        usuarioLogado =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u \nwhere \n	u.userName = :userName"),Var.valueOf("userName",
        cronapi.util.Operations.getCurrentUserName()))));
        dataHoraPartida =
        cronapi.conversion.Operations.stringToDate(
        cronapi.json.Operations.getJsonOrMapField(partidaInfo,
        Var.valueOf("data_hora_partida")),
        Var.valueOf("dd/MM/yyyy HH:mm:ss.SSS"));
        dataHoraLimitePalpite =
        cronapi.dateTime.Operations.incHour(dataHoraPartida,
        Var.valueOf(-1));
        dataHoraAtual =
        cronapi.dateTime.Operations.incHour(
        cronapi.dateTime.Operations.getNow(),
        Var.valueOf(-3));
        periodoEntreDatas =
        cronapi.dateTime.Operations.getSecondsBetweenDates(dataHoraLimitePalpite, dataHoraAtual);
        if (
        Var.valueOf(periodoEntreDatas.compareTo(
        Var.valueOf(0)) < 0).getObjectAsBoolean()) {
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_FALSE) , Var.valueOf("mensagem",
            Var.valueOf("Tempo limite excedido para realizar palpite nesta partida")));
        } else {
            existePalpite =
            cronapi.list.Operations.getFirst((
            cronapi.database.Operations.query(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("select \n	COUNT(p) \nfrom \n	Palpite p \nwhere \n	p.usuario = :usuario AND \n	p.partida.id = :partidaId"),Var.valueOf("usuario",usuarioLogado),Var.valueOf("partidaId",partida))));
            idLogoPalpite =
            cronapi.util.Operations.generateUUID();
            logPalpite =
            cronapi.database.Operations.insert(Var.valueOf("competicao.entity.LogPalpite"),Var.valueOf("id",idLogoPalpite),Var.valueOf("data_insercao",
            cronapi.dateTime.Operations.getNow()),Var.valueOf("email",
            cronapi.util.Operations.getCurrentUserName()),Var.valueOf("usuario",usuarioLogado));
            if (
            Var.valueOf(existePalpite.compareTo(
            Var.valueOf(0)) > 0).getObjectAsBoolean()) {
                cronapi.database.Operations.execute(Var.valueOf("competicao.entity.Palpite"), Var.valueOf("update \n	Palpite  \nset \n	gols_mandante = :gols_mandante, \n	gols_visitante = :gols_visitante, \n	ganhador_penalidades = :ganhador_penalidades \nwhere \n	partida.id = :partidaId AND \n	usuario = :usuario"),Var.valueOf("gols_mandante",gols_mandante),Var.valueOf("gols_visitante",gols_visitante),Var.valueOf("ganhador_penalidades",ganhador_penalidades),Var.valueOf("partidaId",partida),Var.valueOf("usuario",usuarioLogado));
            } else {
                existeEmpate =
                cronapi.database.Operations.insert(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("gols_mandante",gols_mandante),Var.valueOf("gols_visitante",gols_visitante),Var.valueOf("partida",partida),Var.valueOf("usuario",usuarioLogado),Var.valueOf("logPalpite",idLogoPalpite),Var.valueOf("ganhador_penalidades",ganhador_penalidades));
            }
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_TRUE) , Var.valueOf("mensagem",
            Var.valueOf("Palpite cadastrado com sucesso")));
        }
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro ao criarPalpite"),
        Var.valueOf(""),
        Var.valueOf("Trace"), err);
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("mensagem",
        Var.valueOf("Erro ao obter partida, contate um administrador.")));
     }
    return response;
   }
 }.call();
}

}

