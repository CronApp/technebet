window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.historico = window.blockly.js.blockly.historico || {};
window.blockly.js.blockly.historico.Historico = window.blockly.js.blockly.historico.Historico || {};

/**
 * @function historicoUsuario
 *
 * Descreva esta função...
 *
 *
 * @author Lucas Oliveira Da Silva
 * @since 15/12/2022 14:05:38
 *
 */
window.blockly.js.blockly.historico.Historico.historicoUsuarioArgs = [];
window.blockly.js.blockly.historico.Historico.historicoUsuario = async function() {
 var urcl, pos, res, nomeEditado, item;
  //
  urcl = this.cronapi.util.getSessionStorage('__urcl');
  //
  pos = this.cronapi.util.getSessionStorage('__pos');
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Historico.Historico:obterHistoricoPartidas', async function(sender_res) {
      res = sender_res;
    //
    if (this.cronapi.json.getProperty(res, 'sucesso')) {
      //
      if (!this.cronapi.logic.isNullOrEmpty(pos)) {
        //
        this.cronapi.screen.changeValueOfField("vars.position", (this.cronapi.util.executeJavascriptReturn(['parseInt(\"',pos,'\")'].join('')) + 1));
      }
      //
      this.cronapi.screen.changeValueOfField("vars.historico", this.cronapi.json.getProperty(res, 'dados'));
      //
      this.cronapi.screen.changeValueOfField("vars.infoUsuario", this.cronapi.json.getProperty(res, 'usuario'));
      //
      this.cronapi.util.callServerBlocklyAsynchronous('blockly.Ranking.Ranking:getFirstLastName', async function(sender_nomeEditado) {
          nomeEditado = sender_nomeEditado;
        //
        this.cronapi.screen.changeValueOfField("vars.nomeEditado", nomeEditado);
      }.bind(this), this.cronapi.json.getProperty(res, 'usuario.name'));
      //
      this.cronapi.util.callServerBlocklyAsynchronous('blockly.MinhaFinal.PontuacaoMinhaFinal:obterDadosFinalHistorico', async function(sender_item) {
          item = sender_item;
        //
        this.cronapi.screen.changeValueOfField("vars.minhaFinal", item);
      }.bind(this), this.cronapi.json.getProperty(res, 'usuario.id'));
    }
  }.bind(this), urcl);
}

/**
 * @function visualizarHistoricoUsuario
 *
 * Descreva esta função...
 *
 * @param pos
 * @param usr
 *
 * @author Lucas Oliveira Da Silva
 * @since 15/12/2022 14:05:38
 *
 */
window.blockly.js.blockly.historico.Historico.visualizarHistoricoUsuarioArgs = [{ description: 'pos', id: 'e16587b5' }, { description: 'usr', id: '39af6aa1' }];
window.blockly.js.blockly.historico.Historico.visualizarHistoricoUsuario = async function(pos, usr) {
 var urcl, res, nomeEditado;
  //
  this.cronapi.util.setSessionStorage('__pos', pos);
  //
  this.cronapi.util.setSessionStorage('__urcl', usr);
  //
  this.cronapi.screen.changeView("#/home/logged/historico",[  ]);
}
