window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.palpite = window.blockly.js.blockly.palpite || {};
window.blockly.js.blockly.palpite.SelecionarMinhaFinal = window.blockly.js.blockly.palpite.SelecionarMinhaFinal || {};

/**
 * @function selecionarMinhaFinal
 *
 * SelecionarMinhaFinal
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 01/12/2022 15:15:13
 *
 */
window.blockly.js.blockly.palpite.SelecionarMinhaFinal.selecionarMinhaFinalArgs = [];
window.blockly.js.blockly.palpite.SelecionarMinhaFinal.selecionarMinhaFinal = async function() {
 var retorno;
  //
  selecaoA = this.cronapi.screen.getValueOfField("vars.selecaoA");
  //
  selecaoB = this.cronapi.screen.getValueOfField("vars.selecaoB");
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.MinhaFinal.SelecaoCampea:selecaoCampea', async function(sender_item) {
      item = sender_item;
  }.bind(this), selecaoA, selecaoB);
}

/**
 * @function renderizarBandeiraMandante
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 01/12/2022 15:15:13
 *
 */
window.blockly.js.blockly.palpite.SelecionarMinhaFinal.renderizarBandeiraMandanteArgs = [];
window.blockly.js.blockly.palpite.SelecionarMinhaFinal.renderizarBandeiraMandante = async function() {
 var retorno;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.MinhaFinal.SelecionarBandeira:selecionarMandante', async function(sender_retorno) {
      retorno = sender_retorno;
    //
    if (this.cronapi.json.getProperty(retorno, 'sucesso')) {
      //
      this.cronapi.screen.changeValueOfField("vars.bandeiraMandante", this.cronapi.json.getProperty(retorno, 'selecaoA'));
    } else {
      //
      this.cronapi.screen.notify('error',this.cronapi.json.getProperty(retorno, 'msgErro'));
    }
  }.bind(this), this.cronapi.screen.getValueOfField("vars.selecaoA"));
}

/**
 * @function renderizarBandeiraVisitante
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 01/12/2022 15:15:13
 *
 */
window.blockly.js.blockly.palpite.SelecionarMinhaFinal.renderizarBandeiraVisitanteArgs = [];
window.blockly.js.blockly.palpite.SelecionarMinhaFinal.renderizarBandeiraVisitante = async function() {
 var retorno;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.MinhaFinal.SelecionarBandeira:selecionarVisitante', async function(sender_retorno) {
      retorno = sender_retorno;
    //
    if (this.cronapi.json.getProperty(retorno, 'sucesso')) {
      //
      this.cronapi.screen.changeValueOfField("vars.bandeiraVisitante", this.cronapi.json.getProperty(retorno, 'selecaoB'));
    } else {
      //
      this.cronapi.screen.notify('error',this.cronapi.json.getProperty(retorno, 'msgErro'));
    }
  }.bind(this), this.cronapi.screen.getValueOfField("vars.selecaoB"));
}
