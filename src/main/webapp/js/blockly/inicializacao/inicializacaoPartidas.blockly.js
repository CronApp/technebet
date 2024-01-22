window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.inicializacao = window.blockly.js.blockly.inicializacao || {};
window.blockly.js.blockly.inicializacao.InicializacaoPartidas = window.blockly.js.blockly.inicializacao.InicializacaoPartidas || {};

/**
 * @function carregaRodadaSelecionada
 *
 * Descreva esta função...
 *
 *
 * @author Lucas Oliveira Da Silva
 * @since 07/12/2022 13:35:31
 *
 */
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.carregaRodadaSelecionadaArgs = [];
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.carregaRodadaSelecionada = async function() {
 var faseSelecionada, retorno;
  //
  this.cronapi.screen.changeValueOfField("vars.rodadaSelecionada", this.cronapi.util.getSessionStorage('__r_s'));
}

/**
 * @function carregaSelecaoSelecionada
 *
 * Descreva esta função...
 *
 *
 * @author Lucas Oliveira Da Silva
 * @since 07/12/2022 13:35:31
 *
 */
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.carregaSelecaoSelecionadaArgs = [];
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.carregaSelecaoSelecionada = async function() {
 var faseSelecionada, retorno;
  //
  this.cronapi.screen.changeValueOfField("vars.selecaoSelecionada", this.cronapi.util.getSessionStorage('__s_s'));
}

/**
 * @function inicializaRodadas
 *
 * Descreva esta função...
 *
 *
 * @author Lucas Oliveira Da Silva
 * @since 07/12/2022 13:35:31
 *
 */
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.inicializaRodadasArgs = [];
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.inicializaRodadas = async function() {
 var faseSelecionada, retorno;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Consultas.Utilidades:listaRodadas', async function(sender_item) {
      item = sender_item;
    //
    this.cronapi.screen.changeValueOfField("vars.listaRodadas", rodadas);
    //
    (await this.blockly.js.blockly.inicializacao.InicializacaoPartidas.carregaRodadaSelecionada());
  }.bind(this));
}

/**
 * @function alterarSelecaoSelecionada
 *
 * Descreva esta função...
 *
 *
 * @author Lucas Oliveira Da Silva
 * @since 07/12/2022 13:35:31
 *
 */
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.alterarSelecaoSelecionadaArgs = [];
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.alterarSelecaoSelecionada = async function() {
 var faseSelecionada, retorno;
  //
  this.cronapi.util.setSessionStorage('__s_s', this.cronapi.screen.getValueOfField("vars.selecaoSelecionada"));
  //
  (await this.blockly.js.blockly.inicializacao.InicializacaoPartidas.partidasFaseGruposInit(true));
}

/**
 * @function partidasFaseGruposInit
 *
 * Descreva esta função...
 *
 * @param atualizar
 *
 * @author Lucas Oliveira Da Silva
 * @since 07/12/2022 13:35:31
 *
 */
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.partidasFaseGruposInitArgs = [{ description: 'atualizar', id: '8b144ef3' }];
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.partidasFaseGruposInit = async function(atualizar) {
 var faseSelecionada;
  //
  faseSelecionada = 'Fase de Grupos';
  //
  if (atualizar) {
    //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.Consultas.ListagemPartidas:partidasFaseGrupos', async function(sender_retorno) {
        retorno = sender_retorno;
      //
      this.cronapi.screen.changeValueOfField("vars.partidasFaseGrupos", retorno);
    }.bind(this), faseSelecionada, this.cronapi.screen.getValueOfField("vars.rodadaSelecionada"), this.cronapi.screen.getValueOfField("vars.selecaoSelecionada"));
  } else {
    //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.Consultas.Utilidades:listaRodadas', async function(sender_rodadas) {
        rodadas = sender_rodadas;
      //
      this.cronapi.screen.changeValueOfField("vars.listaRodadas", rodadas);
      //
      (await this.blockly.js.blockly.inicializacao.InicializacaoPartidas.carregaRodadaSelecionada());
      //
      this.cronapi.util.callServerBlocklyAsynchronous('blockly.Consultas.Utilidades:listaEquipes', async function(sender_selecoes) {
          selecoes = sender_selecoes;
        //
        this.cronapi.screen.changeValueOfField("vars.listaSelecoes", selecoes);
        //
        (await this.blockly.js.blockly.inicializacao.InicializacaoPartidas.carregaSelecaoSelecionada());
        //
        if (this.cronapi.logic.isNullOrEmpty(this.cronapi.util.getSessionStorage('__r_s')) && this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.rodadaSelecionada"))) {
          //
          this.cronapi.screen.changeValueOfField("vars.rodadaSelecionada", 'CB0AAF31-F106-4D07-88CE-346DED537D37');
        } else {
          //
          this.cronapi.screen.changeValueOfField("vars.rodadaSelecionada", this.cronapi.util.getSessionStorage('__r_s'));
        }
        //
        if (this.cronapi.logic.isNullOrEmpty(this.cronapi.util.getSessionStorage('__s_s')) && this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.selecaoSelecionada"))) {
          //
          this.cronapi.screen.changeValueOfField("vars.selecaoSelecionada", null);
        } else {
          //
          this.cronapi.screen.changeValueOfField("vars.selecaoSelecionada", this.cronapi.util.getSessionStorage('__s_s'));
        }
        //
        this.cronapi.util.callServerBlocklyAsynchronous('blockly.Consultas.ListagemPartidas:partidasFaseGrupos', async function(sender_retorno) {
            retorno = sender_retorno;
          //
          this.cronapi.screen.changeValueOfField("vars.partidasFaseGrupos", retorno);
        }.bind(this), faseSelecionada, this.cronapi.screen.getValueOfField("vars.rodadaSelecionada"), this.cronapi.screen.getValueOfField("vars.selecaoSelecionada"));
      }.bind(this));
    }.bind(this));
  }
}

/**
 * @function partidasOitavas
 *
 * Descreva esta função...
 *
 *
 * @author Lucas Oliveira Da Silva
 * @since 07/12/2022 13:35:31
 *
 */
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.partidasOitavasArgs = [];
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.partidasOitavas = async function() {
 var faseSelecionada, retorno;
  //
  faseSelecionada = 'Oitavas de Final';
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Consultas.ListagemPartidas:partidasFaseGrupos', async function(sender_retorno) {
      retorno = sender_retorno;
    //
    this.cronapi.screen.changeValueOfField("vars.partidasOitavas", retorno);
  }.bind(this), faseSelecionada, this.cronapi.screen.getValueOfField("vars.rodadaSelecionada"), this.cronapi.screen.getValueOfField("vars.selecaoSelecionada"));
}

/**
 * @function inicializaSelecoes
 *
 * Descreva esta função...
 *
 *
 * @author Lucas Oliveira Da Silva
 * @since 07/12/2022 13:35:31
 *
 */
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.inicializaSelecoesArgs = [];
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.inicializaSelecoes = async function() {
 var faseSelecionada, retorno;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Consultas.Utilidades:listaEquipes', async function(sender_item) {
      item = sender_item;
    //
    this.cronapi.screen.changeValueOfField("vars.listaSelecoes", selecoes);
    //
    (await this.blockly.js.blockly.inicializacao.InicializacaoPartidas.carregaSelecaoSelecionada());
  }.bind(this));
}

/**
 * @function alterarRodadaSelecionada
 *
 * Descreva esta função...
 *
 *
 * @author Lucas Oliveira Da Silva
 * @since 07/12/2022 13:35:31
 *
 */
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.alterarRodadaSelecionadaArgs = [];
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.alterarRodadaSelecionada = async function() {
 var faseSelecionada, retorno;
  //
  this.cronapi.util.setSessionStorage('__r_s', this.cronapi.screen.getValueOfField("vars.rodadaSelecionada"));
  //
  (await this.blockly.js.blockly.inicializacao.InicializacaoPartidas.partidasFaseGruposInit(true));
}

/**
 * @function partidasQuartas
 *
 * Descreva esta função...
 *
 *
 * @author Lucas Oliveira Da Silva
 * @since 07/12/2022 13:35:31
 *
 */
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.partidasQuartasArgs = [];
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.partidasQuartas = async function() {
 var faseSelecionada, retorno;
  //
  faseSelecionada = 'Quartas de Final';
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Consultas.ListagemPartidas:partidasFaseGrupos', async function(sender_retorno) {
      retorno = sender_retorno;
    //
    this.cronapi.screen.changeValueOfField("vars.partidasQuartas", retorno);
  }.bind(this), faseSelecionada, this.cronapi.screen.getValueOfField("vars.rodadaSelecionada"), this.cronapi.screen.getValueOfField("vars.selecaoSelecionada"));
}

/**
 * @function partidasSemi
 *
 * Descreva esta função...
 *
 *
 * @author Lucas Oliveira Da Silva
 * @since 07/12/2022 13:35:31
 *
 */
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.partidasSemiArgs = [];
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.partidasSemi = async function() {
 var faseSelecionada, retorno;
  //
  faseSelecionada = 'Semifinais';
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Consultas.ListagemPartidas:partidasFaseGrupos', async function(sender_retorno) {
      retorno = sender_retorno;
    //
    this.cronapi.screen.changeValueOfField("vars.partidasSemi", retorno);
  }.bind(this), faseSelecionada, this.cronapi.screen.getValueOfField("vars.rodadaSelecionada"), this.cronapi.screen.getValueOfField("vars.selecaoSelecionada"));
}

/**
 * @function partidasTerceiroLugar
 *
 * Descreva esta função...
 *
 *
 * @author Lucas Oliveira Da Silva
 * @since 07/12/2022 13:35:31
 *
 */
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.partidasTerceiroLugarArgs = [];
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.partidasTerceiroLugar = async function() {
 var faseSelecionada, retorno;
  //
  faseSelecionada = 'Terceiro Lugar';
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Consultas.ListagemPartidas:partidasFaseGrupos', async function(sender_retorno) {
      retorno = sender_retorno;
    //
    this.cronapi.screen.changeValueOfField("vars.partidasTerceiroLugar", retorno);
  }.bind(this), faseSelecionada, this.cronapi.screen.getValueOfField("vars.rodadaSelecionada"), this.cronapi.screen.getValueOfField("vars.selecaoSelecionada"));
}

/**
 * @function partidasFinal
 *
 * Descreva esta função...
 *
 *
 * @author Lucas Oliveira Da Silva
 * @since 07/12/2022 13:35:31
 *
 */
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.partidasFinalArgs = [];
window.blockly.js.blockly.inicializacao.InicializacaoPartidas.partidasFinal = async function() {
 var faseSelecionada, retorno;
  //
  faseSelecionada = 'Final';
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Consultas.ListagemPartidas:partidasFaseGrupos', async function(sender_retorno) {
      retorno = sender_retorno;
    //
    this.cronapi.screen.changeValueOfField("vars.partidasFinal", retorno);
  }.bind(this), faseSelecionada, this.cronapi.screen.getValueOfField("vars.rodadaSelecionada"), this.cronapi.screen.getValueOfField("vars.selecaoSelecionada"));
}
