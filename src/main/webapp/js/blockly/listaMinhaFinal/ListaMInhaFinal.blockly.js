window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.listaMinhaFinal = window.blockly.js.blockly.listaMinhaFinal || {};
window.blockly.js.blockly.listaMinhaFinal.ListaMInhaFinal = window.blockly.js.blockly.listaMinhaFinal.ListaMInhaFinal || {};

/**
 * @function listaMinhaFinal
 *
 * ListaMInhaFinal
 *
 *
 * @author Lucas Oliveira Da Silva
 * @since 16/12/2022 11:48:07
 *
 */
window.blockly.js.blockly.listaMinhaFinal.ListaMInhaFinal.listaMinhaFinalArgs = [];
window.blockly.js.blockly.listaMinhaFinal.ListaMInhaFinal.listaMinhaFinal = async function() {
 var item;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.MinhaFinal.PontuacaoMinhaFinal:obterDadosFinalListaHistorico', async function(sender_item) {
      item = sender_item;
    //
    this.cronapi.screen.changeValueOfField("vars.listaMinhaFinal", item);
    //
    console.log(item);
  }.bind(this));
}
