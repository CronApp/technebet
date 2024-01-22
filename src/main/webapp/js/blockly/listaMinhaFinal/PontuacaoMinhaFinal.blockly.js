window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.listaMinhaFinal = window.blockly.js.blockly.listaMinhaFinal || {};
window.blockly.js.blockly.listaMinhaFinal.PontuacaoMinhaFinal = window.blockly.js.blockly.listaMinhaFinal.PontuacaoMinhaFinal || {};

/**
 * @function salvarPontosMinhaFinal
 *
 * MostrarBotaoPontosMinhaFinal
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 19/12/2022 10:09:29
 *
 */
window.blockly.js.blockly.listaMinhaFinal.PontuacaoMinhaFinal.salvarPontosMinhaFinalArgs = [];
window.blockly.js.blockly.listaMinhaFinal.PontuacaoMinhaFinal.salvarPontosMinhaFinal = async function() {
 var item;
  //
  this.cronapi.notification.confirmDialogAlert('warning', 'Deseja lançar os pontos de \"Minha Final\"?', '<b>Essa ação é irreversível, tem certeza que deseja continuar?</b>', [this.cronapi.notification.buttonConfirmDialogAlert('true', 'Sim', async function() {
     //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.MinhaFinal.PontuacaoMinhaFinal:pontuarMinhaFinal', async function(sender_item) {
        item = sender_item;
      //
      if (this.cronapi.json.getProperty(item, 'sucesso')) {
        //
        this.cronapi.screen.notify('success',this.cronapi.json.getProperty(item, 'mensagem'));
      } else {
        //
        this.cronapi.screen.notify('error',this.cronapi.json.getProperty(item, 'mensagem'));
      }
    }.bind(this));
   }.bind(this)), this.cronapi.notification.buttonConfirmDialogAlert('false', 'Não', async function() {
    }.bind(this))]);
}

/**
 * @function salvarPontosMinhaFinalTeste
 *
 * MostrarBotaoPontosMinhaFinal
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 19/12/2022 10:09:29
 *
 */
window.blockly.js.blockly.listaMinhaFinal.PontuacaoMinhaFinal.salvarPontosMinhaFinalTesteArgs = [];
window.blockly.js.blockly.listaMinhaFinal.PontuacaoMinhaFinal.salvarPontosMinhaFinalTeste = async function() {
 var item;
  //
  this.cronapi.notification.confirmDialogAlert('warning', 'Deseja lançar os pontos de \"Minha Final\"? TESTE', '<b>Essa ação é irreversível, tem certeza que deseja continuar? TESTE</b>', [this.cronapi.notification.buttonConfirmDialogAlert('true', 'Sim', async function() {
     //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.MinhaFinal.PontuacaoMinhaFinal:pontuarMinhaFinalTeste', async function(sender_item) {
        item = sender_item;
      //
      console.log(item);
      //
      if (this.cronapi.json.getProperty(item, 'sucesso')) {
        //
        this.cronapi.screen.notify('success',this.cronapi.json.getProperty(item, 'mensagem'));
      } else {
        //
        this.cronapi.screen.notify('error',this.cronapi.json.getProperty(item, 'mensagem'));
      }
    }.bind(this));
   }.bind(this)), this.cronapi.notification.buttonConfirmDialogAlert('false', 'Não', async function() {
    }.bind(this))]);
}
