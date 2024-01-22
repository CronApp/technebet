package blockly.Palpite;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Pelnatis {

public static final int TIMEOUT = 300;

/**
 *
 * Pelnatis
 *
 * @param idPartida
 *
 * @author Lucas Oliveira Da Silva
 * @since 12/12/2022 12:29:24
 *
 */
public static Var obterSiglaVencedorPenaltis(@ParamMetaData(description = "idPartida", id = "eb0b2e99") Var idPartida) throws Exception {
 return new Callable<Var>() {

   private Var err = Var.VAR_NULL;
   private Var vencedoPenaltis = Var.VAR_NULL;
   private Var penaltis_mandante = Var.VAR_NULL;
   private Var penaltis_visitante = Var.VAR_NULL;
   private Var mandante_sigla = Var.VAR_NULL;
   private Var visitante_sigla = Var.VAR_NULL;
   private Var response = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         vencedoPenaltis =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p.penalidades \nfrom \n	Partida p \nwhere \n	p.id = :idPartida"),Var.valueOf("idPartida",idPartida))));
        penaltis_mandante =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p.penaltis_mandante \nfrom \n	Partida p \nwhere \n	p.id = :idPartida"),Var.valueOf("idPartida",idPartida))));
        penaltis_visitante =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p.penaltis_visitante \nfrom \n	Partida p \nwhere \n	p.id = :idPartida"),Var.valueOf("idPartida",idPartida))));
        mandante_sigla =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p.mandante.sigla \nfrom \n	Partida p \nwhere \n	p.id = :idPartida"),Var.valueOf("idPartida",idPartida))));
        visitante_sigla =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p.visitante.sigla \nfrom \n	Partida p \nwhere \n	p.id = :idPartida"),Var.valueOf("idPartida",idPartida))));
        if (
        Var.valueOf(penaltis_mandante.compareTo(penaltis_visitante) > 0).getObjectAsBoolean()) {
            vencedoPenaltis = mandante_sigla;
        } else {
            vencedoPenaltis = visitante_sigla;
        }
        response = vencedoPenaltis;
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro na função obterSiglaVencedorPenaltis"),
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
 * @author Lucas Oliveira Da Silva
 * @since 12/12/2022 12:29:24
 *
 */
public static Var retornaIdMandante() throws Exception {
 return new Callable<Var>() {

   private Var idMandante = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         idMandante =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p.mandante.id \nfrom \n	Partida p \nwhere \n	p.mandante.nome = :mandanteNome"),Var.valueOf("mandanteNome",
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("vars.partida.mandante.nome"))))));
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro na função retornaIdMandante"),
        Var.valueOf(""),
        Var.valueOf("Trace"),
        cronapi.util.Operations.getExceptionMessage(err));
        idMandante =
        cronapi.util.Operations.getExceptionMessage(err);
     }
    return idMandante;
   }
 }.call();
}

/**
 *
 * @author Lucas Oliveira Da Silva
 * @since 12/12/2022 12:29:24
 *
 */
public static Var retornaIdVisitante() throws Exception {
 return new Callable<Var>() {

   private Var err = Var.VAR_NULL;
   private Var idVisitante = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         idVisitante =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Partida"),Var.valueOf("select \n	p.visitante.id \nfrom \n	Partida p \nwhere \n	p.visitante.nome = :visitanteNome"),Var.valueOf("visitanteNome",
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("vars.partida.visitante.nome"))))));
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro na função retornaIdMandante"),
        Var.valueOf(""),
        Var.valueOf("Trace"),
        cronapi.util.Operations.getExceptionMessage(err));
        idVisitante =
        cronapi.util.Operations.getExceptionMessage(err);
     }
    return idVisitante;
   }
 }.call();
}

/**
 *
 * Pelnatis
 *
 * @author Lucas Oliveira Da Silva
 * @since 12/12/2022 12:29:24
 *
 */
public static Var verificaPalpiteEmpate() throws Exception {
 return new Callable<Var>() {

   private Var err = Var.VAR_NULL;
   private Var response = Var.VAR_NULL;
   private Var existePalpiteEmpate = Var.VAR_NULL;
   private Var saldoPalpite = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         existePalpiteEmpate =
        Var.VAR_FALSE;
        saldoPalpite =
        cronapi.math.Operations.subtract(
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("vars.gols_mandante")),
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("vars.gols_visitante")));
        if (
        Var.valueOf(saldoPalpite.equals(
        Var.valueOf(0))).getObjectAsBoolean()) {
            existePalpiteEmpate =
            Var.VAR_TRUE;
        }
        response =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_TRUE) , Var.valueOf("palpite",existePalpiteEmpate));
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro na função verificaPalpiteEmpate"),
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

}

