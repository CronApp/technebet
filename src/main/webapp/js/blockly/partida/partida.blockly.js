window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.partida = window.blockly.js.blockly.partida || {};
window.blockly.js.blockly.partida.Partida = window.blockly.js.blockly.partida.Partida || {};

/**
 * @function buscarProximasPartidas
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 25/11/2022 15:11:31
 *
 */
window.blockly.js.blockly.partida.Partida.buscarProximasPartidasArgs = [];
window.blockly.js.blockly.partida.Partida.buscarProximasPartidas = async function() {
 var res;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Partida.Partida:buscarProximasPartidas', async function(sender_res) {
      res = sender_res;
    //
    if (this.cronapi.json.getProperty(res, 'sucesso')) {
      //
      this.cronapi.screen.changeValueOfField("vars.proximasPartidas", this.cronapi.json.getProperty(res, 'dados'));
    }
  }.bind(this));
}

/**
 * @function pontuarPartida
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 25/11/2022 15:11:31
 *
 */
window.blockly.js.blockly.partida.Partida.pontuarPartidaArgs = [];
window.blockly.js.blockly.partida.Partida.pontuarPartida = async function() {
 var res;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.CalcularPontuacao:pontuarUsuarios', async function(sender_res) {
      res = sender_res;
    //
    if (this.cronapi.json.getProperty(res, 'sucesso')) {
      //
      this.cronapi.screen.notify('success',this.cronapi.json.getProperty(res, 'mensagem'));
    } else {
      //
      this.cronapi.screen.notify('error',this.cronapi.json.getProperty(res, 'mensagem'));
    }
  }.bind(this), this.cronapi.screen.getValueOfField("Partida.active.id"));
}

/**
 * @function abrirPontuarPalpite
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 25/11/2022 15:11:31
 *
 */
window.blockly.js.blockly.partida.Partida.abrirPontuarPalpiteArgs = [];
window.blockly.js.blockly.partida.Partida.abrirPontuarPalpite = async function() {
 var res;
  //
  this.cronapi.notification.confirmDialogAlert('warning', 'Deseja continuar?', 'Deseja realmente lançar os pontos dessa partida?', [this.cronapi.notification.buttonConfirmDialogAlert('true', 'Sim', async function() {
     //
    (await this.blockly.js.blockly.partida.Partida.pontuarPartida());
   }.bind(this)), this.cronapi.notification.buttonConfirmDialogAlert('false', 'Não', async function() {
    }.bind(this))]);
}

/**
 * @function TestePontuarPartida
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 25/11/2022 15:11:31
 *
 */
window.blockly.js.blockly.partida.Partida.TestePontuarPartidaArgs = [];
window.blockly.js.blockly.partida.Partida.TestePontuarPartida = async function() {
 var res;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.CalcularPontuacao:TestePontuarUsuarios', async function(sender_res) {
      res = sender_res;
    //
    console.log(res);
    //
    if (this.cronapi.json.getProperty(res, 'sucesso')) {
      //
      this.cronapi.screen.notify('success',this.cronapi.json.getProperty(res, 'mensagem'));
    } else {
      //
      this.cronapi.screen.notify('error',this.cronapi.json.getProperty(res, 'mensagem'));
    }
  }.bind(this), this.cronapi.screen.getValueOfField("Partida.active.id"));
}

/**
 * @function TesteAbrirPontuar
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 25/11/2022 15:11:31
 *
 */
window.blockly.js.blockly.partida.Partida.TesteAbrirPontuarArgs = [];
window.blockly.js.blockly.partida.Partida.TesteAbrirPontuar = async function() {
 var res;
  //
  this.cronapi.notification.confirmDialogAlert('warning', 'Deseja continuar? TESTE', 'Deseja realmente lançar os pontos dessa partida? TESTE', [this.cronapi.notification.buttonConfirmDialogAlert('true', 'Sim', async function() {
     //
    (await this.blockly.js.blockly.partida.Partida.TestePontuarPartida());
   }.bind(this)), this.cronapi.notification.buttonConfirmDialogAlert('false', 'Não', async function() {
    }.bind(this))]);
}
