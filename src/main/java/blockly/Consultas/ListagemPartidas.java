package blockly.Consultas;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ListagemPartidas {

public static final int TIMEOUT = 300;

/**
 *
 * listagemPartidas
 *
 * @param faseSelecionada
 * @param rodadaSelecionada
 * @param selecaoSelecionada
 *
 * @author Matheus Portugal Ribeiro
 * @since 02/12/2022 13:28:03
 *
 */
public static Var partidasFaseGrupos(@ParamMetaData(description = "faseSelecionada", id = "59c35391") Var faseSelecionada, @ParamMetaData(description = "rodadaSelecionada", id = "394ab2e2") Var rodadaSelecionada, @ParamMetaData(description = "selecaoSelecionada", id = "7ec4d27d") Var selecaoSelecionada) throws Exception {
 return new Callable<Var>() {

   private Var usuario_logado = Var.VAR_NULL;
   private Var datasPartidas = Var.VAR_NULL;
   private Var listaRetorno = Var.VAR_NULL;
   private Var data = Var.VAR_NULL;
   private Var dia = Var.VAR_NULL;
   private Var mes = Var.VAR_NULL;
   private Var ano = Var.VAR_NULL;
   private Var dataInicio = Var.VAR_NULL;
   private Var dataFim = Var.VAR_NULL;
   private Var partidas = Var.VAR_NULL;
   private Var dataExiste = Var.VAR_NULL;
   private Var listaPartidaPorDia = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var dataHoraPartida = Var.VAR_NULL;
   private Var dataHoraLimitePalpite = Var.VAR_NULL;
   private Var dataHoraAtual = Var.VAR_NULL;
   private Var periodoEntreDatas = Var.VAR_NULL;
   private Var proximoInicio = Var.VAR_NULL;
   private Var palpite = Var.VAR_NULL;
   private Var retorno = Var.VAR_NULL;
   private Var error = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         usuario_logado =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u \nwhere \n	u.userName = :userName"),Var.valueOf("userName",
        cronapi.util.Operations.getCurrentUserName()))));
        if (
        Var.valueOf(!faseSelecionada.equals(
        Var.valueOf("Fase de Grupos"))).getObjectAsBoolean()) {
            datasPartidas =
            cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p.data_hora_partida \nfrom \n	Partida p \nwhere \n	p.fase.nome_fase = :faseNome_fase"),Var.valueOf("faseNome_fase",faseSelecionada));
        } else {
            if (
            cronapi.logic.Operations.isNullOrEmpty(selecaoSelecionada).getObjectAsBoolean()) {
                datasPartidas =
                cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p.data_hora_partida \nfrom \n	Partida p \nwhere \n	p.fase.nome_fase = :faseNome_fase AND \n	p.rodada.id = :rodadaId"),Var.valueOf("faseNome_fase",faseSelecionada),Var.valueOf("rodadaId",rodadaSelecionada));
            } else {
                datasPartidas =
                cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p.data_hora_partida \nfrom \n	Partida p \nwhere \n	p.fase.nome_fase = :faseNome_fase AND \n	p.rodada.id = :rodadaId AND ( \n	p.mandante.id = :mandanteId OR \n	p.visitante.id = :visitanteId )"),Var.valueOf("faseNome_fase",faseSelecionada),Var.valueOf("rodadaId",rodadaSelecionada),Var.valueOf("mandanteId",selecaoSelecionada),Var.valueOf("visitanteId",selecaoSelecionada));
            }
        }
        listaRetorno =
        cronapi.list.Operations.newList();
        if (
        Var.valueOf(
        cronapi.list.Operations.size(datasPartidas).compareTo(
        Var.valueOf(0)) > 0).getObjectAsBoolean()) {
            for (Iterator it_data = datasPartidas.iterator(); it_data.hasNext();) {
                data = Var.valueOf(it_data.next());
                dia =
                cronapi.dateTime.Operations.getDay(
                cronapi.conversion.Operations.stringToDate(data,
                Var.valueOf("dd-MM-yyyy HH:mm:ss.SSS")));
                mes =
                cronapi.dateTime.Operations.getMonth(
                cronapi.conversion.Operations.stringToDate(data,
                Var.valueOf("dd-MM-yyyy HH:mm:ss.SSS")));
                ano =
                cronapi.dateTime.Operations.getYear(
                cronapi.conversion.Operations.stringToDate(data,
                Var.valueOf("dd-MM-yyyy HH:mm:ss.SSS")));
                dataInicio =
                Var.valueOf(
                Var.valueOf(
                ano.getObjectAsString() +
                Var.valueOf("-").getObjectAsString() +
                mes.getObjectAsString() +
                Var.valueOf("-").getObjectAsString() +
                dia.getObjectAsString()).getObjectAsString() +
                Var.valueOf(" 00:00:00").getObjectAsString());
                dataFim =
                Var.valueOf(
                Var.valueOf(
                ano.getObjectAsString() +
                Var.valueOf("-").getObjectAsString() +
                mes.getObjectAsString() +
                Var.valueOf("-").getObjectAsString() +
                dia.getObjectAsString()).getObjectAsString() +
                Var.valueOf(" 23:59:59").getObjectAsString());
                if (
                Var.valueOf(!faseSelecionada.equals(
                Var.valueOf("Fase de Grupos"))).getObjectAsBoolean()) {
                    partidas =
                    cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p \nfrom \n	Partida p \nwhere \n	p.fase.nome_fase = :faseNome_fase AND \n	p.data_hora_partida >= :dataInicio AND \n	p.data_hora_partida <= :dataFim    \norder by \n	p.data_hora_partida asc"),Var.valueOf("faseNome_fase",faseSelecionada),Var.valueOf("dataInicio",dataInicio),Var.valueOf("dataFim",dataFim));
                } else {
                    if (
                    cronapi.logic.Operations.isNullOrEmpty(selecaoSelecionada).getObjectAsBoolean()) {
                        partidas =
                        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p \nfrom \n	Partida p \nwhere \n	p.fase.nome_fase = :faseNome_fase AND \n	p.data_hora_partida >= :dataInicio AND \n	p.data_hora_partida <= :dataFim AND \n	p.rodada.id = :rodadaId    \norder by \n	p.data_hora_partida asc"),Var.valueOf("faseNome_fase",faseSelecionada),Var.valueOf("dataInicio",dataInicio),Var.valueOf("dataFim",dataFim),Var.valueOf("rodadaId",rodadaSelecionada));
                    } else {
                        partidas =
                        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p \nfrom \n	Partida p \nwhere \n	p.fase.nome_fase = :faseNome_fase AND \n	p.data_hora_partida >= :dataInicio AND \n	p.data_hora_partida <= :dataFim AND \n	p.rodada.id = :rodadaId AND ( \n	p.mandante.id = :mandanteId OR \n	p.visitante.id = :visitanteId )     \norder by \n	p.data_hora_partida asc"),Var.valueOf("faseNome_fase",faseSelecionada),Var.valueOf("dataInicio",dataInicio),Var.valueOf("dataFim",dataFim),Var.valueOf("rodadaId",rodadaSelecionada),Var.valueOf("mandanteId",selecaoSelecionada),Var.valueOf("visitanteId",selecaoSelecionada));
                    }
                }
                dataExiste =
                Var.VAR_FALSE;
                listaPartidaPorDia =
                cronapi.list.Operations.newList();
                if (
                Var.valueOf(
                cronapi.list.Operations.size(listaRetorno).compareTo(
                Var.valueOf(0)) > 0).getObjectAsBoolean()) {
                    for (Iterator it_j = listaRetorno.iterator(); it_j.hasNext();) {
                        j = Var.valueOf(it_j.next());
                        if (
                        Var.valueOf(
                        Var.valueOf(
                        ano.getObjectAsString() +
                        Var.valueOf("-").getObjectAsString() +
                        mes.getObjectAsString() +
                        Var.valueOf("-").getObjectAsString() +
                        dia.getObjectAsString()).equals(
                        Var.valueOf(
                        cronapi.dateTime.Operations.getYear(
                        cronapi.conversion.Operations.stringToDate(
                        cronapi.json.Operations.getJsonOrMapField(j,
                        Var.valueOf("data")),
                        Var.valueOf("dd-MM-yyyy HH:mm:ss.SSS"))).getObjectAsString() +
                        Var.valueOf("-").getObjectAsString() +
                        cronapi.dateTime.Operations.getMonth(
                        cronapi.conversion.Operations.stringToDate(
                        cronapi.json.Operations.getJsonOrMapField(j,
                        Var.valueOf("data")),
                        Var.valueOf("dd-MM-yyyy HH:mm:ss.SSS"))).getObjectAsString() +
                        Var.valueOf("-").getObjectAsString() +
                        cronapi.dateTime.Operations.getDay(
                        cronapi.conversion.Operations.stringToDate(
                        cronapi.json.Operations.getJsonOrMapField(j,
                        Var.valueOf("data")),
                        Var.valueOf("dd-MM-yyyy HH:mm:ss.SSS"))).getObjectAsString()))).getObjectAsBoolean()) {
                            dataExiste =
                            Var.VAR_TRUE;
                        }
                    } // end for
                }
                for (Iterator it_i = partidas.iterator(); it_i.hasNext();) {
                    i = Var.valueOf(it_i.next());
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
                    Var.valueOf(0)) <= 0).getObjectAsBoolean()) {
                        proximoInicio =
                        Var.VAR_TRUE;
                    } else {
                        proximoInicio =
                        Var.VAR_FALSE;
                    }
                    palpite =
                    cronapi.json.Operations.toJson(
                    cronapi.database.Operations.query(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("select \n	p.gols_mandante, \n	p.gols_visitante \nfrom \n	Palpite p \nwhere \n	p.partida = :partida AND \n	p.usuario = :usuario"),Var.valueOf("partida",
                    cronapi.json.Operations.getJsonOrMapField(i,
                    Var.valueOf("id"))),Var.valueOf("usuario",usuario_logado)));
                    palpite =
                    cronapi.list.Operations.getFirst(palpite);
                    if (
                    Var.valueOf(
                    cronapi.list.Operations.size(palpite).compareTo(
                    Var.valueOf(0)) > 0).getObjectAsBoolean()) {
                        cronapi.list.Operations.addLast(listaPartidaPorDia,
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
                        Var.valueOf("status_Partida"))) , Var.valueOf("possuiPalpite",
                        Var.VAR_TRUE) , Var.valueOf("palpiteMandante",
                        cronapi.json.Operations.getJsonOrMapField(palpite,
                        Var.valueOf("gols_mandante"))) , Var.valueOf("palpiteVisitante",
                        cronapi.json.Operations.getJsonOrMapField(palpite,
                        Var.valueOf("gols_visitante"))) , Var.valueOf("rodada",
                        cronapi.json.Operations.getJsonOrMapField(i,
                        Var.valueOf("rodada"))) , Var.valueOf("proximoInicio",proximoInicio)));
                    } else {
                        cronapi.list.Operations.addLast(listaPartidaPorDia,
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
                        Var.valueOf("status_Partida"))) , Var.valueOf("possuiPalpite",
                        Var.VAR_FALSE) , Var.valueOf("rodada",
                        cronapi.json.Operations.getJsonOrMapField(i,
                        Var.valueOf("rodada"))) , Var.valueOf("proximoInicio",proximoInicio)));
                    }
                } // end for
                if (
                Var.valueOf(dataExiste.equals(
                Var.VAR_FALSE)).getObjectAsBoolean()) {
                    cronapi.list.Operations.addLast(listaRetorno,
                    cronapi.map.Operations.createObjectMapWith(Var.valueOf("data",
                    cronapi.conversion.Operations.stringToDate(data,
                    Var.valueOf("dd-MM-yyyy HH:mm:ss.SSS"))) , Var.valueOf("partidas",listaPartidaPorDia)));
                }
            } // end for
        }
        retorno =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_TRUE) , Var.valueOf("dados",listaRetorno));
     } catch (Exception error_exception) {
          error = Var.valueOf(error_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Não foi possível buscar as partidas da fase de grupos"),
        Var.valueOf(""),
        Var.valueOf("Trace"), error);
        retorno =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("mensagem",
        Var.valueOf("Erro ao obter partidas, se o erro persistir, contate um administrador")));
     }
    return retorno;
   }
 }.call();
}

}

