window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.usuario = window.blockly.js.blockly.usuario || {};
window.blockly.js.blockly.usuario.Usuario = window.blockly.js.blockly.usuario.Usuario || {};

/**
 * @function login
 *
 * Descreva esta função...
 *
 *
 * @author Wesley Miranda De Oliveira
 * @since 05/05/2026, 09:43:19
 *
 */
window.blockly.js.blockly.usuario.Usuario.loginArgs = [];
window.blockly.js.blockly.usuario.Usuario.login = async function() {
  //
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("username.value")) || this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("password.value"))) {
    //
    this.cronapi.screen.notify('error','Campos e-mail e senha são obrigatórios');
  } else {
    this.cronapi.authentication.login(this.cronapi.screen.getValueOfField("username.value"), this.cronapi.screen.getValueOfField("password.value"), null);
  }
}
