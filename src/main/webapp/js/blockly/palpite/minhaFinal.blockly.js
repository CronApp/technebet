window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.palpite = window.blockly.js.blockly.palpite || {};
window.blockly.js.blockly.palpite.MinhaFinal = window.blockly.js.blockly.palpite.MinhaFinal || {};

/**
 * @function acrescentarMandanteListaFinal
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 01/12/2022 15:11:20
 *
 */
window.blockly.js.blockly.palpite.MinhaFinal.acrescentarMandanteListaFinalArgs = [];
window.blockly.js.blockly.palpite.MinhaFinal.acrescentarMandanteListaFinal = async function() {
 var res;
  //
  this.cronapi.screen.getValueOfField("vars.listaFinais").push(this.cronapi.screen.getValueOfField("vars.selecaoA"));
  //
  (await this.cronapi.client('blockly.js.blockly.palpite.SelecionarMinhaFinal.renderizarBandeiraMandante').run());
}

/**
 * @function acrescentarVisitanteListaFinal
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 01/12/2022 15:11:20
 *
 */
window.blockly.js.blockly.palpite.MinhaFinal.acrescentarVisitanteListaFinalArgs = [];
window.blockly.js.blockly.palpite.MinhaFinal.acrescentarVisitanteListaFinal = async function() {
 var res;
  //
  item = this.cronapi.json.createObjectFromString('{}');
  //
  this.cronapi.screen.getValueOfField("vars.listaFinais").push(this.cronapi.screen.getValueOfField("vars.selecaoB"));
  //
  (await this.cronapi.client('blockly.js.blockly.palpite.SelecionarMinhaFinal.renderizarBandeiraVisitante').run());
}

/**
 * @function salvarMinhaFinal
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 01/12/2022 15:11:20
 *
 */
window.blockly.js.blockly.palpite.MinhaFinal.salvarMinhaFinalArgs = [];
window.blockly.js.blockly.palpite.MinhaFinal.salvarMinhaFinal = async function() {
 var res;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.MinhaFinal.SelecaoCampea:SalvarSelecaoCampea', async function(sender_res) {
      res = sender_res;
    //
    if (this.cronapi.json.getProperty(res, 'sucesso')) {
      //
      this.cronapi.screen.notify('success',this.cronapi.json.getProperty(res, 'mensagem'));
    } else {
      //
      this.cronapi.screen.notify('error',this.cronapi.json.getProperty(res, 'mensagem'));
    }
  }.bind(this), this.cronapi.screen.getValueOfField("vars.selecaoA"), this.cronapi.screen.getValueOfField("vars.selecaoB"), this.cronapi.screen.getValueOfField("vars.selecaoCampea"));
}

/**
 * @function iniciarListaFinal
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 01/12/2022 15:11:20
 *
 */
window.blockly.js.blockly.palpite.MinhaFinal.iniciarListaFinalArgs = [];
window.blockly.js.blockly.palpite.MinhaFinal.iniciarListaFinal = async function() {
 var res;
  //
  this.cronapi.screen.changeValueOfField("vars.listaFinais", []);
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.MinhaFinal.SelecaoCampea:obterPalpiteSelecao', async function(sender_res) {
      res = sender_res;
    //
    if (this.cronapi.json.getProperty(res, 'sucesso')) {
      //
      this.cronapi.screen.changeValueOfField("vars.selecaoA", this.cronapi.json.getProperty(res, 'dados.palpiteSelecaoA.nome'));
      //
      this.cronapi.screen.changeValueOfField("vars.selecaoB", this.cronapi.json.getProperty(res, 'dados.palpiteSelecaoB.nome'));
      //
      this.cronapi.screen.changeValueOfField("vars.selecaoCampea", this.cronapi.json.getProperty(res, 'dados.selecaoCampea.nome'));
      //
      this.cronapi.screen.changeValueOfField("vars.bandeiraMandante", this.cronapi.json.getProperty(res, 'dados.palpiteSelecaoA.bandeira'));
      //
      this.cronapi.screen.changeValueOfField("vars.bandeiraVisitante", this.cronapi.json.getProperty(res, 'dados.palpiteSelecaoB.bandeira'));
    }
  }.bind(this));
}
