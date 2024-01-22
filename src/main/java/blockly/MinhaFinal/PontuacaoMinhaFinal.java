package blockly.MinhaFinal;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class PontuacaoMinhaFinal {

public static final int TIMEOUT = 300;

/**
 *
 * PontuacaoMinhaFinal
 *
 * @param usuario
 *
 * @author Matheus Portugal Ribeiro
 * @since 19/12/2022 10:13:18
 *
 */
public static Var obterDadosFinalHistorico(@ParamMetaData(description = "usuario", id = "fc4fa0a5") Var usuario) throws Exception {
 return new Callable<Var>() {

   private Var idUsuario = Var.VAR_NULL;
   private Var palpiteFinal = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         if (
        cronapi.logic.Operations.isNullOrEmpty(usuario).getObjectAsBoolean()) {
            idUsuario =
            cronapi.list.Operations.getFirst((
            cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u \nwhere \n	u.userName = :userName"),Var.valueOf("userName",
            cronapi.util.Operations.getCurrentUserName()))));
        }
        palpiteFinal =
        cronapi.list.Operations.getFirst((
        cronapi.json.Operations.toJson(
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.MinhaFinal"),Var.valueOf("select \n	m \nfrom \n	MinhaFinal m \nwhere \n	m.usuario = :usuario"),Var.valueOf("usuario",usuario)))));
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro na função obterDadosFinalHistorico"),
        Var.valueOf(""),
        Var.valueOf("Trace"),
        cronapi.util.Operations.getExceptionMessage(err));
     }
    return palpiteFinal;
   }
 }.call();
}

/**
 *
 * PontuacaoMinhaFinal
 *
 * @author Matheus Portugal Ribeiro
 * @since 19/12/2022 10:13:18
 *
 */
public static Var obterDadosFinalListaHistorico() throws Exception {
 return new Callable<Var>() {

   private Var palpiteFinal = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;
   private Var listaRetorno = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var nomeUsuario = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         listaRetorno =
        cronapi.list.Operations.newList();
        palpiteFinal =
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.MinhaFinal"),Var.valueOf("select \n	m \nfrom \n	MinhaFinal m"));
        for (Iterator it_i = palpiteFinal.iterator(); it_i.hasNext();) {
            i = Var.valueOf(it_i.next());
            nomeUsuario =
            cronapi.util.Operations.callBlockly(Var.valueOf("blockly.Ranking.Ranking:getFirstLastName"), Var.valueOf("190dfe5b",
            cronapi.list.Operations.getFirst((
            cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.name \nfrom \n	User u \nwhere \n	u.id = :id"),Var.valueOf("id",
            cronapi.json.Operations.getJsonOrMapField(i,
            Var.valueOf("usuario"))))))));
            cronapi.list.Operations.addLast(listaRetorno,
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("id",
            cronapi.json.Operations.getJsonOrMapField(i,
            Var.valueOf("id"))) , Var.valueOf("palpiteSelecaoA",
            cronapi.json.Operations.getJsonOrMapField(i,
            Var.valueOf("palpiteSelecaoA"))) , Var.valueOf("palpiteSelecaoB",
            cronapi.json.Operations.getJsonOrMapField(i,
            Var.valueOf("palpiteSelecaoB"))) , Var.valueOf("selecaoCampea",
            cronapi.json.Operations.getJsonOrMapField(i,
            Var.valueOf("selecaoCampea"))) , Var.valueOf("usuario",nomeUsuario)));
        } // end for
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro na função obterDadosFinalHistorico"),
        Var.valueOf(""),
        Var.valueOf("Trace"),
        cronapi.util.Operations.getExceptionMessage(err));
     }
    return listaRetorno;
   }
 }.call();
}

/**
 *
 * PontuacaoMinhaFinal
 *
 * @author Matheus Portugal Ribeiro
 * @since 19/12/2022 10:13:18
 *
 */
public static Var obterDadosMinhaFinal() throws Exception {
 return new Callable<Var>() {

   private Var err = Var.VAR_NULL;
   private Var palpitesMinhaFinal = Var.VAR_NULL;
   private Var idFaseFinal = Var.VAR_NULL;
   private Var partidaFinal = Var.VAR_NULL;
   private Var mandanteFinal = Var.VAR_NULL;
   private Var visitanteFinal = Var.VAR_NULL;
   private Var campeao = Var.VAR_NULL;
   private Var res = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         palpitesMinhaFinal =
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.MinhaFinal"),Var.valueOf("select \n	m \nfrom \n	MinhaFinal m"));
        idFaseFinal =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Fase"),Var.valueOf("select \n	f.id \nfrom \n	Fase f \nwhere \n	f.nome_fase = \'Final\'"))));
        partidaFinal =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p \nfrom \n	Partida p \nwhere \n	p.fase = :idFase"),Var.valueOf("idFase",idFaseFinal))));
        mandanteFinal =
        cronapi.json.Operations.getJsonOrMapField(partidaFinal,
        Var.valueOf("mandante.id"));
        visitanteFinal =
        cronapi.json.Operations.getJsonOrMapField(partidaFinal,
        Var.valueOf("visitante.id"));
        if (
        Var.valueOf(
        cronapi.json.Operations.getJsonOrMapField(partidaFinal,
        Var.valueOf("gols_mandante")).compareTo(
        cronapi.json.Operations.getJsonOrMapField(partidaFinal,
        Var.valueOf("gols_visitante"))) > 0).getObjectAsBoolean()) {
            campeao =
            cronapi.json.Operations.getJsonOrMapField(partidaFinal,
            Var.valueOf("mandante.id"));
        } else {
            campeao =
            cronapi.json.Operations.getJsonOrMapField(partidaFinal,
            Var.valueOf("visitante.id"));
        }
        if (
        Var.valueOf(
        cronapi.json.Operations.getJsonOrMapField(partidaFinal,
        Var.valueOf("gols_mandante")).equals(
        cronapi.json.Operations.getJsonOrMapField(partidaFinal,
        Var.valueOf("gols_visitante")))).getObjectAsBoolean()) {
            campeao =
            cronapi.json.Operations.getJsonOrMapField(partidaFinal,
            Var.valueOf("vencedor_penaltis.id"));
        }
        res =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_TRUE) , Var.valueOf("palpitesMinhaFinal",palpitesMinhaFinal) , Var.valueOf("partidaFinal",partidaFinal) , Var.valueOf("mandanteFinal",mandanteFinal) , Var.valueOf("visitanteFinal",visitanteFinal) , Var.valueOf("campeao",campeao));
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro na função obterDadosMinhaFinal"),
        Var.valueOf(""),
        Var.valueOf("Trace"),
        cronapi.util.Operations.getExceptionMessage(err));
        res =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("mensagem",
        Var.valueOf("Erro na função obterDadosMinhaFinal")));
     }
    return res;
   }
 }.call();
}

/**
 *
 * @author Matheus Portugal Ribeiro
 * @since 19/12/2022 10:13:18
 *
 */
public static Var pontuarMinhaFinal() throws Exception {
 return new Callable<Var>() {

   private Var err = Var.VAR_NULL;
   private Var palpitesMinhaFinal = Var.VAR_NULL;
   private Var partidaFinal = Var.VAR_NULL;
   private Var mandanteFinal = Var.VAR_NULL;
   private Var visitanteFinal = Var.VAR_NULL;
   private Var campeao = Var.VAR_NULL;
   private Var res = Var.VAR_NULL;
   private Var dadosMinhaFinal = Var.VAR_NULL;
   private Var palpite = Var.VAR_NULL;
   private Var pontos = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         dadosMinhaFinal =
        Var.valueOf(obterDadosMinhaFinal());
        if (
        cronapi.json.Operations.getJsonOrMapField(dadosMinhaFinal,
        Var.valueOf("sucesso")).getObjectAsBoolean()) {
            palpitesMinhaFinal =
            cronapi.json.Operations.getJsonOrMapField(dadosMinhaFinal,
            Var.valueOf("palpitesMinhaFinal"));
            partidaFinal =
            cronapi.json.Operations.getJsonOrMapField(dadosMinhaFinal,
            Var.valueOf("partidaFinal"));
            mandanteFinal =
            cronapi.json.Operations.getJsonOrMapField(dadosMinhaFinal,
            Var.valueOf("mandanteFinal"));
            visitanteFinal =
            cronapi.json.Operations.getJsonOrMapField(dadosMinhaFinal,
            Var.valueOf("visitanteFinal"));
            campeao =
            cronapi.json.Operations.getJsonOrMapField(dadosMinhaFinal,
            Var.valueOf("campeao"));
            if (
            Var.valueOf(
            cronapi.json.Operations.getJsonOrMapField(partidaFinal,
            Var.valueOf("status_partida.nome_status")).equals(
            Var.valueOf("Encerrada"))).getObjectAsBoolean()) {
                for (Iterator it_palpite = palpitesMinhaFinal.iterator(); it_palpite.hasNext();) {
                    palpite = Var.valueOf(it_palpite.next());
                    pontos =
                    Var.valueOf(0);
                    if (
                    Var.valueOf(
                    Var.valueOf(
                    cronapi.json.Operations.getJsonOrMapField(palpite,
                    Var.valueOf("palpiteSelecaoA.id")).equals(mandanteFinal)).getObjectAsBoolean() &&
                    Var.valueOf(
                    cronapi.json.Operations.getJsonOrMapField(palpite,
                    Var.valueOf("palpiteSelecaoB.id")).equals(visitanteFinal)).getObjectAsBoolean()).getObjectAsBoolean()) {
                        pontos =
                        cronapi.math.Operations.sum(pontos,
                        Var.valueOf(50));
                    }
                    if (
                    Var.valueOf(
                    cronapi.json.Operations.getJsonOrMapField(palpite,
                    Var.valueOf("selecaoCampea.id")).equals(campeao)).getObjectAsBoolean()) {
                        pontos =
                        cronapi.math.Operations.sum(pontos,
                        Var.valueOf(50));
                    }
                    if (
                    Var.valueOf(pontos.compareTo(
                    Var.valueOf(0)) > 0).getObjectAsBoolean()) {
                        cronapi.database.Operations.execute(Var.valueOf("competicao.entity.MinhaFinal"), Var.valueOf("update \n	MinhaFinal  \nset \n	pontuacao = :pontuacao \nwhere \n	usuario = :usuario"),Var.valueOf("pontuacao",pontos),Var.valueOf("usuario",
                        cronapi.json.Operations.getJsonOrMapField(palpite,
                        Var.valueOf("usuario"))));
                    }
                } // end for
            }
        }
        res =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_TRUE) , Var.valueOf("mensagem",
        Var.valueOf("Dados Cadastrados com sucesso!")));
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro na função pontuarMinhaFinal"),
        Var.valueOf(""),
        Var.valueOf("Trace"),
        cronapi.util.Operations.getExceptionMessage(err));
        res =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("mensagem",
        Var.valueOf("Erro ao cadastrar os dados!")));
     }
    return res;
   }
 }.call();
}

/**
 *
 * @author Matheus Portugal Ribeiro
 * @since 19/12/2022 10:13:18
 *
 */
public static Var pontuarMinhaFinalTeste() throws Exception {
 return new Callable<Var>() {

   private Var err = Var.VAR_NULL;
   private Var listaRetorno = Var.VAR_NULL;
   private Var palpitesMinhaFinal = Var.VAR_NULL;
   private Var partidaFinal = Var.VAR_NULL;
   private Var mandanteFinal = Var.VAR_NULL;
   private Var visitanteFinal = Var.VAR_NULL;
   private Var campeao = Var.VAR_NULL;
   private Var res = Var.VAR_NULL;
   private Var dadosMinhaFinal = Var.VAR_NULL;
   private Var palpite = Var.VAR_NULL;
   private Var pontos = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         dadosMinhaFinal =
        Var.valueOf(obterDadosMinhaFinal());
        listaRetorno =
        cronapi.list.Operations.newList();
        if (
        cronapi.json.Operations.getJsonOrMapField(dadosMinhaFinal,
        Var.valueOf("sucesso")).getObjectAsBoolean()) {
            palpitesMinhaFinal =
            cronapi.json.Operations.getJsonOrMapField(dadosMinhaFinal,
            Var.valueOf("palpitesMinhaFinal"));
            partidaFinal =
            cronapi.json.Operations.getJsonOrMapField(dadosMinhaFinal,
            Var.valueOf("partidaFinal"));
            mandanteFinal =
            cronapi.json.Operations.getJsonOrMapField(dadosMinhaFinal,
            Var.valueOf("mandanteFinal"));
            visitanteFinal =
            cronapi.json.Operations.getJsonOrMapField(dadosMinhaFinal,
            Var.valueOf("visitanteFinal"));
            campeao =
            cronapi.json.Operations.getJsonOrMapField(dadosMinhaFinal,
            Var.valueOf("campeao"));
            if (
            Var.valueOf(
            cronapi.json.Operations.getJsonOrMapField(partidaFinal,
            Var.valueOf("status_partida.nome_status")).equals(
            Var.valueOf("Encerrada"))).getObjectAsBoolean()) {
                for (Iterator it_palpite = palpitesMinhaFinal.iterator(); it_palpite.hasNext();) {
                    palpite = Var.valueOf(it_palpite.next());
                    pontos =
                    Var.valueOf(0);
                    if (
                    Var.valueOf(
                    Var.valueOf(
                    cronapi.json.Operations.getJsonOrMapField(palpite,
                    Var.valueOf("palpiteSelecaoA.id")).equals(mandanteFinal)).getObjectAsBoolean() &&
                    Var.valueOf(
                    cronapi.json.Operations.getJsonOrMapField(palpite,
                    Var.valueOf("palpiteSelecaoB.id")).equals(visitanteFinal)).getObjectAsBoolean()).getObjectAsBoolean()) {
                        pontos =
                        cronapi.math.Operations.sum(pontos,
                        Var.valueOf(50));
                    }
                    if (
                    Var.valueOf(
                    cronapi.json.Operations.getJsonOrMapField(palpite,
                    Var.valueOf("selecaoCampea.id")).equals(campeao)).getObjectAsBoolean()) {
                        pontos =
                        cronapi.math.Operations.sum(pontos,
                        Var.valueOf(50));
                    }
                    if (
                    Var.valueOf(pontos.compareTo(
                    Var.valueOf(0)) > 0).getObjectAsBoolean()) {
                        System.out.println(
                        cronapi.map.Operations.createObjectMapWith(Var.valueOf("palpite",
                        Var.valueOf(
                        cronapi.json.Operations.getJsonOrMapField(palpite,
                        Var.valueOf("usuario")).getObjectAsString() +
                        Var.valueOf("       ").getObjectAsString() +
                        cronapi.json.Operations.getJsonOrMapField(palpite,
                        Var.valueOf("pontuacao")).getObjectAsString() +
                        Var.valueOf("pontos a lançar  ").getObjectAsString() +
                        pontos.getObjectAsString()))).getObjectAsString());
                        cronapi.list.Operations.addLast(listaRetorno,
                        cronapi.map.Operations.createObjectMapWith(Var.valueOf("palpite",
                        Var.valueOf(
                        cronapi.json.Operations.getJsonOrMapField(palpite,
                        Var.valueOf("usuario")).getObjectAsString() +
                        Var.valueOf("       ").getObjectAsString() +
                        cronapi.json.Operations.getJsonOrMapField(palpite,
                        Var.valueOf("pontuacao")).getObjectAsString() +
                        Var.valueOf("pontos a lançar  ").getObjectAsString() +
                        pontos.getObjectAsString()))));
                    }
                } // end for
            }
        }
        res =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_TRUE) , Var.valueOf("dados",listaRetorno) , Var.valueOf("mensagem",
        Var.valueOf("Dados Cadastrados com sucesso!")));
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.throwException(err);
        res =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("mensagem",
        Var.valueOf("Erro ao pontuarMinhaFinalTeste")));
     }
    return res;
   }
 }.call();
}

}

