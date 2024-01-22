package blockly.Consultas;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Utilidades {

public static final int TIMEOUT = 300;

/**
 *
 * @author Matheus Portugal Ribeiro
 * @since 25/11/2022 13:30:49
 *
 */
public static Var listaEquipes() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return
cronapi.database.Operations.query(Var.valueOf("competicao.entity.Equipe"),Var.valueOf("select \n	e \nfrom \n	Equipe e    \norder by \n	e.nome asc"));
   }
 }.call();
}

/**
 *
 * Utilidades
 *
 * @author Matheus Portugal Ribeiro
 * @since 25/11/2022 13:30:49
 *
 */
public static Var listaRodadas() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return
cronapi.database.Operations.query(Var.valueOf("competicao.entity.Rodada"),Var.valueOf("select \n	r \nfrom \n	Rodada r    \norder by \n	r.rodada asc"));
   }
 }.call();
}

}

