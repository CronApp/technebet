package blockly.MinhaFinal;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class SelecionarBandeira {

public static final int TIMEOUT = 300;

/**
 *
 * SelecionarBandeira
 *
 * @param equipeA
 *
 * @author Matheus Portugal Ribeiro
 * @since 01/12/2022 14:22:06
 *
 */
public static Var selecionarMandante(@ParamMetaData(description = "equipeA", id = "0ac1d9f9") Var equipeA) throws Exception {
 return new Callable<Var>() {

   private Var retorno = Var.VAR_NULL;
   private Var erro = Var.VAR_NULL;
   private Var selecaoA = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         selecaoA =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Equipe"),Var.valueOf("select \n	e.bandeira \nfrom \n	Equipe e \nwhere \n	e.nome = :nome"),Var.valueOf("nome",equipeA))));
        retorno =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_TRUE) , Var.valueOf("selecaoA",selecaoA));
     } catch (Exception erro_exception) {
          erro = Var.valueOf(erro_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro selecionarMandante"),
        Var.valueOf(""),
        Var.valueOf("Trace"), erro);
        retorno =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("msgErro",
        cronapi.util.Operations.getExceptionMessage(erro)));
     }
    return retorno;
   }
 }.call();
}

/**
 *
 * SelecionarBandeira
 *
 * @param equipeB
 *
 * @author Matheus Portugal Ribeiro
 * @since 01/12/2022 14:22:06
 *
 */
public static Var selecionarVisitante(@ParamMetaData(description = "equipeB", id = "0ac1d9f9") Var equipeB) throws Exception {
 return new Callable<Var>() {

   private Var selecaoB = Var.VAR_NULL;
   private Var retorno = Var.VAR_NULL;
   private Var erro = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         selecaoB =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("competicao.entity.Equipe"),Var.valueOf("select \n	e.bandeira \nfrom \n	Equipe e \nwhere \n	e.nome = :nome"),Var.valueOf("nome",equipeB))));
        retorno =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_TRUE) , Var.valueOf("selecaoB",selecaoB));
     } catch (Exception erro_exception) {
          erro = Var.valueOf(erro_exception);
         cronapi.util.Operations.audit(
        Var.valueOf("Erro selecionarVisitante"),
        Var.valueOf(""),
        Var.valueOf("Trace"), erro);
        retorno =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("msgErro",
        cronapi.util.Operations.getExceptionMessage(erro)));
     }
    return retorno;
   }
 }.call();
}

}

