package blockly.Partida;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Partida {

public static final int TIMEOUT = 300;

/**
 *
 * Partida
 *
 * @author Matheus Portugal Ribeiro
 * @since 25/11/2022 15:19:40
 *
 */
public static Var buscarProximasPartidas() throws Exception {
 return new Callable<Var>() {

   private Var partidasEmAndamento = Var.VAR_NULL;
   private Var listaRetorno = Var.VAR_NULL;
   private Var quantidadeComplementar = Var.VAR_NULL;
   private Var usuario_logado = Var.VAR_NULL;
   private Var periodoEntreDatas = Var.VAR_NULL;
   private Var proximoInicio = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var palpite = Var.VAR_NULL;
   private Var dataHoraPartida = Var.VAR_NULL;
   private Var dataHoraLimitePalpite = Var.VAR_NULL;
   private Var dataHoraAtual = Var.VAR_NULL;
   private Var possuiPalpite = Var.VAR_NULL;
   private Var partidasComplementares = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var response = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         partidasEmAndamento =
        cronapi.database.Operations.queryPaged(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p \nfrom \n	Partida p \nwhere \n	p.status_Partida.nome_status = \'Em andamento\'"),Var.valueOf(false),Var.valueOf("limit",
        Var.valueOf(4)),Var.valueOf("offset",
        Var.valueOf(0)));
        listaRetorno =
        cronapi.list.Operations.newList();
        quantidadeComplementar =
        cronapi.math.Operations.subtract(
        Var.valueOf(4),
        cronapi.list.Operations.size(partidasEmAndamento));
        usuario_logado =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u \nwhere \n	u.userName = :userName"),Var.valueOf("userName",
        cronapi.util.Operations.getCurrentUserName()))));
        if (
        Var.valueOf(periodoEntreDatas.compareTo(
        Var.valueOf(3600)) <= 0).getObjectAsBoolean()) {
            proximoInicio =
            Var.VAR_TRUE;
        } else {
            proximoInicio =
            Var.VAR_FALSE;
        }
        if (
        Var.valueOf(
        cronapi.list.Operations.size(partidasEmAndamento).compareTo(
        Var.valueOf(0)) > 0).getObjectAsBoolean()) {
            for (Iterator it_i = partidasEmAndamento.iterator(); it_i.hasNext();) {
                i = Var.valueOf(it_i.next());
                palpite =
                cronapi.list.Operations.getFirst((
                cronapi.json.Operations.toJson(
                cronapi.database.Operations.query(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("select \n	p.gols_mandante, \n	p.gols_visitante \nfrom \n	Palpite p \nwhere \n	p.partida = :partida AND \n	p.usuario = :usuario"),Var.valueOf("partida",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("id"))),Var.valueOf("usuario",usuario_logado)))));
                dataHoraPartida =
                cronapi.conversion.Operations.stringToDate(
                cronapi.json.Operations.getJsonOrMapField(i,
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
                Var.valueOf(3600)) <= 0).getObjectAsBoolean()) {
                    proximoInicio =
                    Var.VAR_TRUE;
                } else {
                    proximoInicio =
                    Var.VAR_FALSE;
                }
                if (
                Var.valueOf(
                cronapi.list.Operations.size(palpite).compareTo(
                Var.valueOf(0)) > 0).getObjectAsBoolean()) {
                    possuiPalpite =
                    Var.VAR_TRUE;
                } else {
                    possuiPalpite =
                    Var.VAR_FALSE;
                }
                cronapi.list.Operations.addLast(listaRetorno,
                cronapi.map.Operations.createObjectMapWith(Var.valueOf("id",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("id"))) , Var.valueOf("data_hora_partida",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("data_hora_partida"))) , Var.valueOf("mandante",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("mandante"))) , Var.valueOf("visitante",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("visitante"))) , Var.valueOf("estadio",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("estadio"))) , Var.valueOf("fase",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("fase"))) , Var.valueOf("gols_mandante",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("gols_mandante"))) , Var.valueOf("gols_visitante",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("gols_visitante"))) , Var.valueOf("penalidades",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("penalidades"))) , Var.valueOf("penaltis_mandante",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("penaltis_mandante"))) , Var.valueOf("penaltis_visitante",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("penaltis_visitante"))) , Var.valueOf("partida_finalizada",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("partida_finalizada"))) , Var.valueOf("status_Partida",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("status_Partida"))) , Var.valueOf("possuiPalpite",possuiPalpite) , Var.valueOf("palpiteMandante",
                cronapi.json.Operations.getJsonOrMapField(palpite,
                Var.valueOf("gols_mandante"))) , Var.valueOf("palpiteVisitante",
                cronapi.json.Operations.getJsonOrMapField(palpite,
                Var.valueOf("gols_visitante"))) , Var.valueOf("rodada",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("rodada"))) , Var.valueOf("proximoInicio",proximoInicio)));
            } // end for
        }
        if (
        Var.valueOf(quantidadeComplementar.compareTo(
        Var.valueOf(0)) > 0).getObjectAsBoolean()) {
            dataHoraAtual =
            cronapi.dateTime.Operations.formatDateTime2(
            cronapi.dateTime.Operations.incHour(
            cronapi.dateTime.Operations.getNow(),
            Var.valueOf(-3)),
            Var.valueOf("dd/MM/yyyy HH:mm:ss.SSS"),
            Var.valueOf("false"));
            partidasComplementares =
            cronapi.database.Operations.queryPaged(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p \nfrom \n	Partida p \nwhere \n	p.data_hora_partida >= :data_hora_partida    \norder by \n	p.data_hora_partida asc"),Var.valueOf(false),Var.valueOf("data_hora_partida",dataHoraAtual),Var.valueOf("limit",quantidadeComplementar),Var.valueOf("offset",
            Var.valueOf(0)));
            for (Iterator it_j = partidasComplementares.iterator(); it_j.hasNext();) {
                j = Var.valueOf(it_j.next());
                palpite =
                cronapi.list.Operations.getFirst((
                cronapi.json.Operations.toJson(
                cronapi.database.Operations.query(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("select \n	p.gols_mandante, \n	p.gols_visitante \nfrom \n	Palpite p \nwhere \n	p.partida = :partida AND \n	p.usuario = :usuario"),Var.valueOf("partida",
                cronapi.json.Operations.getJsonOrMapField(j,
                Var.valueOf("id"))),Var.valueOf("usuario",usuario_logado)))));
                if (
                Var.valueOf(
                cronapi.list.Operations.size(palpite).compareTo(
                Var.valueOf(0)) > 0).getObjectAsBoolean()) {
                    possuiPalpite =
                    Var.VAR_TRUE;
                } else {
                    possuiPalpite =
                    Var.VAR_FALSE;
                }
                cronapi.list.Operations.addLast(listaRetorno,
                cronapi.map.Operations.createObjectMapWith(Var.valueOf("id",
                cronapi.json.Operations.getJsonOrMapField(j,
                Var.valueOf("id"))) , Var.valueOf("data_hora_partida",
                cronapi.json.Operations.getJsonOrMapField(j,
                Var.valueOf("data_hora_partida"))) , Var.valueOf("mandante",
                cronapi.json.Operations.getJsonOrMapField(j,
                Var.valueOf("mandante"))) , Var.valueOf("visitante",
                cronapi.json.Operations.getJsonOrMapField(j,
                Var.valueOf("visitante"))) , Var.valueOf("estadio",
                cronapi.json.Operations.getJsonOrMapField(j,
                Var.valueOf("estadio"))) , Var.valueOf("fase",
                cronapi.json.Operations.getJsonOrMapField(j,
                Var.valueOf("fase"))) , Var.valueOf("gols_mandante",
                cronapi.json.Operations.getJsonOrMapField(j,
                Var.valueOf("gols_mandante"))) , Var.valueOf("gols_visitante",
                cronapi.json.Operations.getJsonOrMapField(j,
                Var.valueOf("gols_visitante"))) , Var.valueOf("penalidades",
                cronapi.json.Operations.getJsonOrMapField(j,
                Var.valueOf("penalidades"))) , Var.valueOf("penaltis_mandante",
                cronapi.json.Operations.getJsonOrMapField(j,
                Var.valueOf("penaltis_mandante"))) , Var.valueOf("penaltis_visitante",
                cronapi.json.Operations.getJsonOrMapField(j,
                Var.valueOf("penaltis_visitante"))) , Var.valueOf("partida_finalizada",
                cronapi.json.Operations.getJsonOrMapField(j,
                Var.valueOf("partida_finalizada"))) , Var.valueOf("status_Partida",
                cronapi.json.Operations.getJsonOrMapField(j,
                Var.valueOf("status_Partida"))) , Var.valueOf("possuiPalpite",possuiPalpite) , Var.valueOf("palpiteMandante",
                cronapi.json.Operations.getJsonOrMapField(palpite,
                Var.valueOf("gols_mandante"))) , Var.valueOf("palpiteVisitante",
                cronapi.json.Operations.getJsonOrMapField(palpite,
                Var.valueOf("gols_visitante"))) , Var.valueOf("rodada",
                cronapi.json.Operations.getJsonOrMapField(j,
                Var.valueOf("rodada")))));
            } // end for
        }
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_TRUE) , Var.valueOf("dados",listaRetorno));
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro ao buscarProximasPartidas"),
        Var.valueOf(""),
        Var.valueOf("Trace"), err);
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_TRUE) , Var.valueOf("mensagem",
        Var.valueOf("Erro ao buscar próximas partidas.")));
     }
    return response;
   }
 }.call();
}

}

