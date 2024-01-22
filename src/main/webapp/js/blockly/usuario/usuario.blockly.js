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
 * @author Lucas Oliveira Da Silva
 * @since 08/12/2022 11:04:43
 *
 */
window.blockly.js.blockly.usuario.Usuario.loginArgs = [];
window.blockly.js.blockly.usuario.Usuario.login = async function() {
 var res;
  //
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("username.value")) || this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("password.value"))) {
    //
    this.cronapi.screen.notify('error','Campos e-mail e senha são obrigatórios');
  } else {
    //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.Usuario.Usuario:login', async function(sender_res) {
        res = sender_res;
      //
      if (this.cronapi.json.getProperty(res, 'sucesso')) {
        //
        this.cronapi.util.setLocalStorage('_u', this.cronapi.object.serializeObject(this.cronapi.json.createObjectFromString(this.cronapi.json.getProperty(res, 'dados'))));
        //
        this.cronapi.screen.changeView("#/home/logged/home",[  ]);
      } else {
        //
        this.cronapi.screen.notify('error','E-mail ou Senha incorreto');
      }
    }.bind(this), this.cronapi.screen.getValueOfField("username.value"), this.cronapi.screen.getValueOfField("password.value"));
  }
}
