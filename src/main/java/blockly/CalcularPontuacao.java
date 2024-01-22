package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class CalcularPontuacao {

public static final int TIMEOUT = 300;

/**
 *
 * calcularPontuacao
 *
 * @param idPartida
 *
 * @author Matheus Portugal Ribeiro
 * @since 02/12/2022 09:57:46
 *
 */
public static Var TestePontuarUsuarios(@ParamMetaData(description = "idPartida", id = "faadb1ee") Var idPartida) throws Exception {
 return new Callable<Var>() {

   private Var offset = Var.VAR_NULL;
   private Var limit = Var.VAR_NULL;
   private Var countPalpites = Var.VAR_NULL;
   private Var novaListaPalpite = Var.VAR_NULL;
   private Var palpites = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var listaRestantePalpites = Var.VAR_NULL;
   private Var k = Var.VAR_NULL;
   private Var partidaEncerrada = Var.VAR_NULL;
   private Var aux = Var.VAR_NULL;
   private Var listaRetorno = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var totalPontos = Var.VAR_NULL;
   private Var resultadoMandante = Var.VAR_NULL;
   private Var resultadoVisitante = Var.VAR_NULL;
   private Var palpiteMandante = Var.VAR_NULL;
   private Var palpiteVisitante = Var.VAR_NULL;
   private Var saldoResultado = Var.VAR_NULL;
   private Var saldoPalpite = Var.VAR_NULL;
   private Var vencedorPartida = Var.VAR_NULL;
   private Var vencedorPalpite = Var.VAR_NULL;
   private Var ganhadorPenaltis = Var.VAR_NULL;
   private Var response = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         offset =
        Var.valueOf(0);
        limit =
        Var.valueOf(100);
        countPalpites =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("select \n	COUNT(p) \nfrom \n	Palpite p \nwhere \n	p.partida.id = :partidaId"),Var.valueOf("partidaId",idPartida))));
        if (
        Var.valueOf(countPalpites.compareTo(
        Var.valueOf(100)) > 0).getObjectAsBoolean()) {
            novaListaPalpite =
            cronapi.list.Operations.newList();
            palpites =
            cronapi.database.Operations.queryPaged(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("select \n	p \nfrom \n	Palpite p \nwhere \n	p.partida.id = :partidaId"),Var.valueOf(false),Var.valueOf("partidaId",idPartida),Var.valueOf("limit",limit),Var.valueOf("offset",offset));
            if (
            Var.valueOf(
            cronapi.list.Operations.size(palpites).compareTo(countPalpites) < 0).getObjectAsBoolean()) {
                for (Iterator it_j = palpites.iterator(); it_j.hasNext();) {
                    j = Var.valueOf(it_j.next());
                    cronapi.list.Operations.addLast(novaListaPalpite,j);
                } // end for
                offset =
                Var.valueOf(100);
                limit =
                Var.valueOf(100);
                listaRestantePalpites =
                cronapi.database.Operations.queryPaged(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("select \n	p \nfrom \n	Palpite p \nwhere \n	p.partida.id = :partidaId"),Var.valueOf(false),Var.valueOf("partidaId",idPartida),Var.valueOf("limit",limit),Var.valueOf("offset",offset));
                for (Iterator it_k = listaRestantePalpites.iterator(); it_k.hasNext();) {
                    k = Var.valueOf(it_k.next());
                    cronapi.list.Operations.addLast(novaListaPalpite,k);
                } // end for
            }
            palpites = novaListaPalpite;
        } else {
            palpites =
            cronapi.database.Operations.query(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("select \n	p \nfrom \n	Palpite p \nwhere \n	p.partida.id = :partidaId"),Var.valueOf("partidaId",idPartida));
        }
        partidaEncerrada =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p.status_Partida.nome_status \nfrom \n	Partida p \nwhere \n	p.id = :id"),Var.valueOf("id",idPartida))));
        if (
        Var.valueOf(partidaEncerrada.equals(
        Var.valueOf("Encerrada"))).getObjectAsBoolean()) {
            aux =
            Var.valueOf(0);
            listaRetorno =
            cronapi.list.Operations.newList();
            for (Iterator it_i = palpites.iterator(); it_i.hasNext();) {
                i = Var.valueOf(it_i.next());
                totalPontos =
                Var.valueOf(1);
                resultadoMandante =
                cronapi.list.Operations.getFirst((
                cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p.gols_mandante \nfrom \n	Partida p \nwhere \n	p.id = :id"),Var.valueOf("id",idPartida))));
                resultadoVisitante =
                cronapi.list.Operations.getFirst((
                cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p.gols_visitante \nfrom \n	Partida p \nwhere \n	p.id = :id"),Var.valueOf("id",idPartida))));
                palpiteMandante =
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("gols_mandante"));
                palpiteVisitante =
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("gols_visitante"));
                saldoResultado =
                cronapi.math.Operations.subtract(resultadoMandante,resultadoVisitante);
                saldoPalpite =
                cronapi.math.Operations.subtract(palpiteMandante,palpiteVisitante);
                if (
                Var.valueOf(
                Var.valueOf(resultadoMandante.equals(palpiteMandante)).getObjectAsBoolean() &&
                Var.valueOf(resultadoVisitante.equals(palpiteVisitante)).getObjectAsBoolean()).getObjectAsBoolean()) {
                    totalPontos =
                    cronapi.math.Operations.sum(totalPontos,
                    Var.valueOf(10));
                }
                if (
                Var.valueOf(saldoResultado.compareTo(
                Var.valueOf(0)) > 0).getObjectAsBoolean()) {
                    vencedorPartida =
                    Var.valueOf("Mandante");
                } else if (
                Var.valueOf(saldoResultado.compareTo(
                Var.valueOf(0)) < 0).getObjectAsBoolean()) {
                    vencedorPartida =
                    Var.valueOf("Visitante");
                } else {
                    vencedorPartida =
                    Var.valueOf("Empate");
                }
                if (
                Var.valueOf(saldoPalpite.compareTo(
                Var.valueOf(0)) > 0).getObjectAsBoolean()) {
                    vencedorPalpite =
                    Var.valueOf("Mandante");
                } else if (
                Var.valueOf(saldoPalpite.compareTo(
                Var.valueOf(0)) < 0).getObjectAsBoolean()) {
                    vencedorPalpite =
                    Var.valueOf("Visitante");
                } else {
                    vencedorPalpite =
                    Var.valueOf("Empate");
                }
                if (
                Var.valueOf(vencedorPartida.equals(vencedorPalpite)).getObjectAsBoolean()) {
                    totalPontos =
                    cronapi.math.Operations.sum(totalPontos,
                    Var.valueOf(5));
                }
                if (
                Var.valueOf(resultadoMandante.equals(palpiteMandante)).getObjectAsBoolean()) {
                    totalPontos =
                    cronapi.math.Operations.sum(totalPontos,
                    Var.valueOf(4));
                }
                if (
                Var.valueOf(resultadoVisitante.equals(palpiteVisitante)).getObjectAsBoolean()) {
                    totalPontos =
                    cronapi.math.Operations.sum(totalPontos,
                    Var.valueOf(4));
                }
                if (
                Var.valueOf(
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("partida.penalidades")).equals(
                Var.VAR_TRUE)).getObjectAsBoolean()) {
                    if (
                    Var.valueOf(palpiteMandante.equals(palpiteVisitante)).getObjectAsBoolean()) {
                        if (
                        Var.valueOf(
                        cronapi.json.Operations.getJsonOrMapField(i,
                        Var.valueOf("partida.penaltis_mandante")).compareTo(
                        cronapi.json.Operations.getJsonOrMapField(i,
                        Var.valueOf("partida.penaltis_visitante"))) > 0).getObjectAsBoolean()) {
                            ganhadorPenaltis =
                            cronapi.json.Operations.getJsonOrMapField(i,
                            Var.valueOf("partida.mandante.id"));
                        } else {
                            ganhadorPenaltis =
                            cronapi.json.Operations.getJsonOrMapField(i,
                            Var.valueOf("partida.visitante.id"));
                        }
                        if (
                        cronapi.logic.Operations.isNullOrEmpty(
                        cronapi.json.Operations.getJsonOrMapField(i,
                        Var.valueOf("ganhador_penalidades")))
                        .negate().getObjectAsBoolean()) {
                            if (
                            Var.valueOf(ganhadorPenaltis.equals(
                            cronapi.json.Operations.getJsonOrMapField(i,
                            Var.valueOf("ganhador_penalidades.id")))).getObjectAsBoolean()) {
                                totalPontos =
                                cronapi.math.Operations.sum(totalPontos,
                                Var.valueOf(6));
                            }
                        }
                    }
                }
                cronapi.list.Operations.addLast(listaRetorno,
                cronapi.map.Operations.createObjectMapWith(Var.valueOf("pontuacao",totalPontos) , Var.valueOf("idPalpite",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("id")))));
            } // end for
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_TRUE) , Var.valueOf("mensagem",
            Var.valueOf("Pontos lançados com sucesso")) , Var.valueOf("dadosTeste",listaRetorno));
        } else {
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_FALSE) , Var.valueOf("mensagem",
            Var.valueOf("Partida ainda não foi encerrada")));
        }
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro ao pontuarUsuarios"),
        Var.valueOf(""),
        Var.valueOf("Trace"),
        Var.valueOf(""));
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("mensagem",
        Var.valueOf("Falha ao lançar pontos, verifique o log da aplicação")));
     }
    return response;
   }
 }.call();
}

/**
 *
 * calcularPontuacao
 *
 * @param idPartida
 *
 * @author Matheus Portugal Ribeiro
 * @since 02/12/2022 09:57:46
 *
 */
public static Var pontuarUsuarios(@ParamMetaData(description = "idPartida", id = "faadb1ee") Var idPartida) throws Exception {
 return new Callable<Var>() {

   private Var offset = Var.VAR_NULL;
   private Var limit = Var.VAR_NULL;
   private Var countPalpites = Var.VAR_NULL;
   private Var novaListaPalpite = Var.VAR_NULL;
   private Var palpites = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var listaRestantePalpites = Var.VAR_NULL;
   private Var k = Var.VAR_NULL;
   private Var partidaEncerrada = Var.VAR_NULL;
   private Var aux = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var totalPontos = Var.VAR_NULL;
   private Var resultadoMandante = Var.VAR_NULL;
   private Var resultadoVisitante = Var.VAR_NULL;
   private Var palpiteMandante = Var.VAR_NULL;
   private Var palpiteVisitante = Var.VAR_NULL;
   private Var saldoResultado = Var.VAR_NULL;
   private Var saldoPalpite = Var.VAR_NULL;
   private Var vencedorPartida = Var.VAR_NULL;
   private Var vencedorPalpite = Var.VAR_NULL;
   private Var ganhadorPenaltis = Var.VAR_NULL;
   private Var response = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;
   private Var pontuacaoUsuario = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         offset =
        Var.valueOf(0);
        limit =
        Var.valueOf(100);
        countPalpites =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("select \n	COUNT(p) \nfrom \n	Palpite p \nwhere \n	p.partida.id = :partidaId"),Var.valueOf("partidaId",idPartida))));
        if (
        Var.valueOf(countPalpites.compareTo(
        Var.valueOf(100)) > 0).getObjectAsBoolean()) {
            novaListaPalpite =
            cronapi.list.Operations.newList();
            palpites =
            cronapi.database.Operations.queryPaged(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("select \n	p \nfrom \n	Palpite p \nwhere \n	p.partida.id = :partidaId"),Var.valueOf(false),Var.valueOf("partidaId",idPartida),Var.valueOf("limit",limit),Var.valueOf("offset",offset));
            if (
            Var.valueOf(
            cronapi.list.Operations.size(palpites).compareTo(countPalpites) < 0).getObjectAsBoolean()) {
                for (Iterator it_j = palpites.iterator(); it_j.hasNext();) {
                    j = Var.valueOf(it_j.next());
                    cronapi.list.Operations.addLast(novaListaPalpite,j);
                } // end for
                offset =
                Var.valueOf(100);
                limit =
                Var.valueOf(100);
                listaRestantePalpites =
                cronapi.database.Operations.queryPaged(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("select \n	p \nfrom \n	Palpite p \nwhere \n	p.partida.id = :partidaId"),Var.valueOf(false),Var.valueOf("partidaId",idPartida),Var.valueOf("limit",limit),Var.valueOf("offset",offset));
                for (Iterator it_k = listaRestantePalpites.iterator(); it_k.hasNext();) {
                    k = Var.valueOf(it_k.next());
                    cronapi.list.Operations.addLast(novaListaPalpite,k);
                } // end for
            }
            palpites = novaListaPalpite;
        } else {
            palpites =
            cronapi.database.Operations.query(Var.valueOf("competicao.entity.Palpite"),Var.valueOf("select \n	p \nfrom \n	Palpite p \nwhere \n	p.partida.id = :partidaId"),Var.valueOf("partidaId",idPartida));
        }
        aux =
        Var.valueOf(0);
        partidaEncerrada =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p.status_Partida.nome_status \nfrom \n	Partida p \nwhere \n	p.id = :id"),Var.valueOf("id",idPartida))));
        if (
        Var.valueOf(partidaEncerrada.equals(
        Var.valueOf("Encerrada"))).getObjectAsBoolean()) {
            for (Iterator it_i = palpites.iterator(); it_i.hasNext();) {
                i = Var.valueOf(it_i.next());
                totalPontos =
                Var.valueOf(1);
                resultadoMandante =
                cronapi.list.Operations.getFirst((
                cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p.gols_mandante \nfrom \n	Partida p \nwhere \n	p.id = :id"),Var.valueOf("id",idPartida))));
                resultadoVisitante =
                cronapi.list.Operations.getFirst((
                cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p.gols_visitante \nfrom \n	Partida p \nwhere \n	p.id = :id"),Var.valueOf("id",idPartida))));
                palpiteMandante =
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("gols_mandante"));
                palpiteVisitante =
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("gols_visitante"));
                saldoResultado =
                cronapi.math.Operations.subtract(resultadoMandante,resultadoVisitante);
                saldoPalpite =
                cronapi.math.Operations.subtract(palpiteMandante,palpiteVisitante);
                if (
                Var.valueOf(
                Var.valueOf(resultadoMandante.equals(palpiteMandante)).getObjectAsBoolean() &&
                Var.valueOf(resultadoVisitante.equals(palpiteVisitante)).getObjectAsBoolean()).getObjectAsBoolean()) {
                    totalPontos =
                    cronapi.math.Operations.sum(totalPontos,
                    Var.valueOf(10));
                }
                if (
                Var.valueOf(saldoResultado.compareTo(
                Var.valueOf(0)) > 0).getObjectAsBoolean()) {
                    vencedorPartida =
                    Var.valueOf("Mandante");
                } else if (
                Var.valueOf(saldoResultado.compareTo(
                Var.valueOf(0)) < 0).getObjectAsBoolean()) {
                    vencedorPartida =
                    Var.valueOf("Visitante");
                } else {
                    vencedorPartida =
                    Var.valueOf("Empate");
                }
                if (
                Var.valueOf(saldoPalpite.compareTo(
                Var.valueOf(0)) > 0).getObjectAsBoolean()) {
                    vencedorPalpite =
                    Var.valueOf("Mandante");
                } else if (
                Var.valueOf(saldoPalpite.compareTo(
                Var.valueOf(0)) < 0).getObjectAsBoolean()) {
                    vencedorPalpite =
                    Var.valueOf("Visitante");
                } else {
                    vencedorPalpite =
                    Var.valueOf("Empate");
                }
                if (
                Var.valueOf(vencedorPartida.equals(vencedorPalpite)).getObjectAsBoolean()) {
                    totalPontos =
                    cronapi.math.Operations.sum(totalPontos,
                    Var.valueOf(5));
                }
                if (
                Var.valueOf(resultadoMandante.equals(palpiteMandante)).getObjectAsBoolean()) {
                    totalPontos =
                    cronapi.math.Operations.sum(totalPontos,
                    Var.valueOf(4));
                }
                if (
                Var.valueOf(resultadoVisitante.equals(palpiteVisitante)).getObjectAsBoolean()) {
                    totalPontos =
                    cronapi.math.Operations.sum(totalPontos,
                    Var.valueOf(4));
                }
                if (
                Var.valueOf(
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("partida.penalidades")).equals(
                Var.VAR_TRUE)).getObjectAsBoolean()) {
                    if (
                    Var.valueOf(palpiteMandante.equals(palpiteVisitante)).getObjectAsBoolean()) {
                        if (
                        Var.valueOf(
                        cronapi.json.Operations.getJsonOrMapField(i,
                        Var.valueOf("partida.penaltis_mandante")).compareTo(
                        cronapi.json.Operations.getJsonOrMapField(i,
                        Var.valueOf("partida.penaltis_visitante"))) > 0).getObjectAsBoolean()) {
                            ganhadorPenaltis =
                            cronapi.json.Operations.getJsonOrMapField(i,
                            Var.valueOf("partida.mandante.id"));
                        } else {
                            ganhadorPenaltis =
                            cronapi.json.Operations.getJsonOrMapField(i,
                            Var.valueOf("partida.visitante.id"));
                        }
                        if (
                        cronapi.logic.Operations.isNullOrEmpty(
                        cronapi.json.Operations.getJsonOrMapField(i,
                        Var.valueOf("ganhador_penalidades")))
                        .negate().getObjectAsBoolean()) {
                            if (
                            Var.valueOf(ganhadorPenaltis.equals(
                            cronapi.json.Operations.getJsonOrMapField(i,
                            Var.valueOf("ganhador_penalidades.id")))).getObjectAsBoolean()) {
                                totalPontos =
                                cronapi.math.Operations.sum(totalPontos,
                                Var.valueOf(6));
                            }
                        }
                    }
                }
                pontuacaoUsuario =
                cronapi.list.Operations.getFirst((
                cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.pontuacao \nfrom \n	User u \nwhere \n	u.id = :id"),Var.valueOf("id",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("usuario"))))));
                if (
                cronapi.logic.Operations.isNullOrEmpty(pontuacaoUsuario).getObjectAsBoolean()) {
                    pontuacaoUsuario =
                    Var.valueOf(0);
                }
                cronapi.database.Operations.execute(Var.valueOf("app.entity.User"), Var.valueOf("update \n	User  \nset \n	pontuacao = :pontuacao \nwhere \n	id = :id"),Var.valueOf("pontuacao",
                cronapi.math.Operations.sum(pontuacaoUsuario,totalPontos)),Var.valueOf("id",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("usuario"))));
                cronapi.database.Operations.execute(Var.valueOf("competicao.entity.Palpite"), Var.valueOf("update \n	Palpite  \nset \n	pontuacao = :pontuacao \nwhere \n	id = :idPalpite"),Var.valueOf("pontuacao",totalPontos),Var.valueOf("idPalpite",
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("id"))));
            } // end for
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_TRUE) , Var.valueOf("mensagem",
            Var.valueOf("Pontos lançados com sucesso")));
        } else {
            response =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_FALSE) , Var.valueOf("mensagem",
            Var.valueOf("Partida ainda não foi encerrada")));
        }
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro ao pontuarUsuarios"),
        Var.valueOf(""),
        Var.valueOf("Trace"),
        Var.valueOf(""));
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("mensagem",
        Var.valueOf("Falha ao lançar pontos, verifique o log da aplicação")));
     }
    return response;
   }
 }.call();
}

}

