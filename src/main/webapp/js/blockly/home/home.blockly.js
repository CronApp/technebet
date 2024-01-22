window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.home = window.blockly.js.blockly.home || {};
window.blockly.js.blockly.home.Home = window.blockly.js.blockly.home.Home || {};

/**
 * @function abrirModalSenha
 *
 * Descreva esta função...
 *
 *
 * @author Lucas Oliveira Da Silva
 * @since 07/12/2022 14:10:12
 *
 */
window.blockly.js.blockly.home.Home.abrirModalSenhaArgs = [];
window.blockly.js.blockly.home.Home.abrirModalSenha = async function() {
 var res;
  //
  this.cronapi.screen.showModal("modalPassword");
}

/**
 * @function obterPalpiteFinal
 *
 * Descreva esta função...
 *
 *
 * @author Lucas Oliveira Da Silva
 * @since 07/12/2022 14:10:12
 *
 */
window.blockly.js.blockly.home.Home.obterPalpiteFinalArgs = [];
window.blockly.js.blockly.home.Home.obterPalpiteFinal = async function() {
 var res;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.MinhaFinal.ObterPalpiteFinal:obterPalpiteFinal', async function(sender_res) {
      res = sender_res;
    //
    if (this.cronapi.json.getProperty(res, 'sucesso')) {
      //
      this.cronapi.notification.confirmDialogAlert('info', 'Palpite sua Final', 'Corre que ainda dá tempo de palpitar na sua final! Você tem até <b>08/12/22 às 20:00h.</b>', [this.cronapi.notification.buttonConfirmDialogAlert('true', 'Ir para \"Minha Final\"', async function() {
         //
        this.cronapi.screen.changeView("#/home/logged/minha-final",[  ]);
       }.bind(this)), this.cronapi.notification.buttonConfirmDialogAlert('false', 'Palpitar depois!', async function() {
        }.bind(this))]);
    }
  }.bind(this));
}

/**
 * @function minhaPontuacao
 *
 * Descreva esta função...
 *
 *
 * @author Lucas Oliveira Da Silva
 * @since 07/12/2022 14:10:12
 *
 */
window.blockly.js.blockly.home.Home.minhaPontuacaoArgs = [];
window.blockly.js.blockly.home.Home.minhaPontuacao = async function() {
 var res;
  //
  this.cronapi.util.executeJavascriptNoReturn('sessionStorage.removeItem(\"__urcl\")');
  //
  this.cronapi.util.executeJavascriptNoReturn('sessionStorage.removeItem(\"__pos\")');
  //
  this.cronapi.screen.changeView("#/home/logged/historico",[  ]);
}

/**
 * @function validarCampoSenha
 *
 * Descreva esta função...
 *
 * @param password
 *
 * @author Lucas Oliveira Da Silva
 * @since 07/12/2022 14:10:12
 *
 */
window.blockly.js.blockly.home.Home.validarCampoSenhaArgs = [{ description: 'password', id: '6928ded6' }];
window.blockly.js.blockly.home.Home.validarCampoSenha = async function(password) {

  //
  if (password.indexOf('$') + 1 != 0 || password.indexOf(')') + 1 != 0 || password.indexOf('(') + 1 != 0 || password.indexOf('#') + 1 != 0 || password.indexOf('*') + 1 != 0 || password.indexOf('&') + 1 != 0 || password.indexOf('%') + 1 != 0) {
    //
    this.cronapi.screen.disableComponent("btn-save-reset-password");
    //
    this.cronapi.screen.showComponent("invalid-password-error");
  } else {
    //
    this.cronapi.screen.hideComponent("invalid-password-error");
    //
    this.cronapi.screen.enableComponent("btn-save-reset-password");
  }
}
