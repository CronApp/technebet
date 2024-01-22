package blockly.Historico;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Historico {

public static final int TIMEOUT = 300;

/**
 *
 * Historico
 *
 * @param usuario
 *
 * @author Lucas Oliveira Da Silva
 * @since 15/12/2022 13:03:55
 *
 */
public static Var obterHistoricoPartidas(@ParamMetaData(description = "param_usuario", id = "381d52d7") Var param_usuario) throws Exception {
 return new Callable<Var>() {

   // param
   private Var usuario = param_usuario;
   // end
   private Var datasPartidas = Var.VAR_NULL;
   private Var infoUsuario = Var.VAR_NULL;
   private Var listaRetorno = Var.VAR_NULL;
   private Var data = Var.VAR_NULL;
   private Var ano = Var.VAR_NULL;
   private Var mes = Var.VAR_NULL;
   private Var dia = Var.VAR_NULL;
   private Var dataInicio = Var.VAR_NULL;
   private Var dataFim = Var.VAR_NULL;
   private Var listaPartidas = Var.VAR_NULL;
   private Var jaExisteData = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var response = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         if (
        cronapi.logic.Operations.isNullOrEmpty(usuario).getObjectAsBoolean()) {
            usuario =
            cronapi.list.Operations.getFirst((
            cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u \nwhere \n	u.userName = :userName"),Var.valueOf("userName",
            cronapi.util.Operations.getCurrentUserName()))));
        }
        datasPartidas =
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("select \n	p.partida.data_hora_partida \nfrom \n	Palpite p \nwhere \n	p.usuario = :usuario AND \n	p.partida.status_Partida.nome_status = \'Encerrada\'"),Var.valueOf("usuario",usuario));
        infoUsuario =
        cronapi.json.Operations.toJson(
        cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.name, \n	u.pontuacao, \n	u.id \nfrom \n	User u \nwhere \n	u.id = :id"),Var.valueOf("id",usuario)));
        listaRetorno =
        cronapi.list.Operations.newList();
        if (
        Var.valueOf(
        cronapi.list.Operations.size(datasPartidas).compareTo(
        Var.valueOf(0)) > 0).getObjectAsBoolean()) {
            for (Iterator it_data = datasPartidas.iterator(); it_data.hasNext();) {
                data = Var.valueOf(it_data.next());
                ano =
                cronapi.dateTime.Operations.getYear(
                cronapi.conversion.Operations.stringToDate(data,
                Var.valueOf("dd-MM-yyyy HH:mm:ss.SSS")));
                mes =
                cronapi.dateTime.Operations.getMonth(
                cronapi.conversion.Operations.stringToDate(data,
                Var.valueOf("dd-MM-yyyy HH:mm:ss.SSS")));
                dia =
                cronapi.dateTime.Operations.getDay(
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
                listaPartidas =
                cronapi.database.Operations.query(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("select \n	p \nfrom \n	Palpite p \nwhere \n	p.partida.data_hora_partida >= :dataInicio AND \n	p.partida.data_hora_partida <= :data_fim AND \n	p.usuario = :usuario AND \n	p.partida.status_Partida.nome_status = \'Encerrada\'"),Var.valueOf("dataInicio",dataInicio),Var.valueOf("data_fim",dataFim),Var.valueOf("usuario",usuario));
                jaExisteData =
                Var.VAR_FALSE;
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
                            jaExisteData =
                            Var.VAR_TRUE;
                        }
                    } // end for
                }
                if (
                Var.valueOf(jaExisteData.equals(
                Var.VAR_FALSE)).getObjectAsBoolean()) {
                    cronapi.list.Operations.addLast(listaRetorno,
                    cronapi.map.Operations.createObjectMapWith(Var.valueOf("data",
                    cronapi.conversion.Operations.stringToDate(data,
                    Var.valueOf("dd-MM-yyyy HH:mm:ss.SSS"))) , Var.valueOf("partidas",listaPartidas)));
                }
            } // end for
        }
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_TRUE) , Var.valueOf("dados",listaRetorno) , Var.valueOf("usuario",
        cronapi.list.Operations.getFirst(infoUsuario)));
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro ao obterHistoricoPartidas"),
        Var.valueOf(""),
        Var.valueOf("Trace"), err);
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("mensagem",
        Var.valueOf("Erro ao obterHistoricoPartidas")));
     }
    return response;
   }
 }.call();
}

}

