window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.palpite = window.blockly.js.blockly.palpite || {};
window.blockly.js.blockly.palpite.Penaltis = window.blockly.js.blockly.palpite.Penaltis || {};

/**
 * @function verificaPalpiteEmpate
 *
 * Penaltis
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 01/12/2022 17:09:49
 *
 */
window.blockly.js.blockly.palpite.Penaltis.verificaPalpiteEmpateArgs = [];
window.blockly.js.blockly.palpite.Penaltis.verificaPalpiteEmpate = async function() {
 var existePalpiteEmpate, fase, saldoPalpite;
  //
  existePalpiteEmpate = false;
  //
  fase = this.cronapi.json.getProperty(this.cronapi.screen.getValueOfField("vars.partida"), 'fase.nome_fase');
  //
  if (fase != 'Fase de Grupos') {
    //
    saldoPalpite = (this.cronapi.screen.getValueOfField("vars.gols_mandante") - this.cronapi.screen.getValueOfField("vars.gols_visitante"));
    //
    if (saldoPalpite == 0) {
      //
      existePalpiteEmpate = true;
    }
    //
    this.cronapi.screen.changeValueOfField("vars.existeEmpate", existePalpiteEmpate);
    //
    if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.gols_mandante") || this.cronapi.screen.getValueOfField("vars.gols_visitante"))) {
      //
      existePalpiteEmpate = false;
    }
  }
}
