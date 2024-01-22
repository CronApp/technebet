window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.UserControl = window.blockly.js.blockly.UserControl || {};

/**
 * @function resetPassword
 *
 * Descreva esta função...
 *
 * @param email
 *
 * @author Matheus Portugal Ribeiro
 * @since 18/11/2022 16:25:39
 *
 */
window.blockly.js.blockly.UserControl.resetPasswordArgs = [{ description: 'email', id: '7afdf898' }];
window.blockly.js.blockly.UserControl.resetPassword = async function(email) {
 var name, password, confirmPassword, response;
  //
  this.cronapi.authentication.resetPassword(email);
}

/**
 * @function signUp
 *
 * Descreva esta função...
 *
 * @param name
 * @param email
 * @param password
 * @param confirmPassword
 *
 * @author Matheus Portugal Ribeiro
 * @since 18/11/2022 16:25:39
 *
 */
window.blockly.js.blockly.UserControl.signUpArgs = [{ description: 'name2', id: '3a3ca4e0' }, { description: 'email', id: '04d8e9d1' }, { description: 'password', id: '164870cd' }, { description: 'confirmPassword', id: 'b019c901' }];
window.blockly.js.blockly.UserControl.signUp = async function(name2, email, password, confirmPassword) {
 var name;
  //
  if (this.cronapi.logic.isNullOrEmpty(email)) {
    //
    this.cronapi.notification.customNotify('error', 'Campo e-mail é obrigatório', 'fade', 'top', 'center', 'true');
  } else if (this.cronapi.logic.isNullOrEmpty(name2)) {
    //
    this.cronapi.notification.customNotify('error', 'Campo nome é obrigatório', 'fade', 'top', 'center', 'true');
  } else if (password != confirmPassword) {
    //
    this.cronapi.notification.customNotify('error', 'Senha e confirme a senha são obrigatórios e devem ser iguais', 'fade', 'top', 'center', 'true');
  } else {
    //
    if (password.indexOf('$') + 1 != 0 || password.indexOf(')') + 1 != 0 || password.indexOf('(') + 1 != 0 || password.indexOf('#') + 1 != 0 || password.indexOf('*') + 1 != 0 || password.indexOf('&') + 1 != 0 || password.indexOf('%') + 1 != 0) {
      //
      this.cronapi.notification.customNotify('error', 'Caracteres inválidos detectados #,%,),*,&,$,(', 'fade', 'top', 'center', 'true');
    } else {
      //
      this.cronapi.util.callServerBlocklyAsynchronous('blockly.Usuario.Usuario:CadastrarUsuario', async function(sender_response) {
          response = sender_response;
        //
        if (this.cronapi.json.getProperty(response, 'sucesso')) {
          //
          this.cronapi.notification.customNotify('success', this.cronapi.json.getProperty(response, 'mensagem'), 'fade', 'top', 'center', 'true');
          //
          this.cronapi.screen.changeValueOfField("vars.cadastroSucesso", true);
        } else {
          //
          this.cronapi.notification.customNotify('error', this.cronapi.json.getProperty(response, 'mensagem'), 'fade', 'top', 'center', 'true');
          //
          this.cronapi.screen.changeValueOfField("vars.cadastroSucesso", false);
        }
      }.bind(this), email, password, name2);
    }
  }
}

/**
 * @function signUpDepreceated
 *
 * Signup
 *
 * @param signupUsername
 * @param signupEmail
 * @param signupPassword
 * @param signupConfirmPassword
 *
 * @author Matheus Portugal Ribeiro
 * @since 18/11/2022 16:25:39
 *
 */
window.blockly.js.blockly.UserControl.signUpDepreceatedArgs = [{ description: 'signupUsername', id: 'ec5dbe32' }, { description: 'signupEmail', id: '62cce53e' }, { description: 'signupPassword', id: 'd42229ad' }, { description: 'signupConfirmPassword', id: 'a49023f3' }];
window.blockly.js.blockly.UserControl.signUpDepreceated = async function(signupUsername, signupEmail, signupPassword, signupConfirmPassword) {
 var name;
  //
  (await this.cronapi.authentication.signup(signupUsername, signupEmail, signupPassword, signupConfirmPassword));
}

/**
 * @function isValidSignup
 *
 * Descreva esta função...
 *
 * @param signupUsername
 * @param signupEmail
 * @param signupPassword
 * @param signupConfirmPassword
 *
 * @author Matheus Portugal Ribeiro
 * @since 18/11/2022 16:25:39
 *
 */
window.blockly.js.blockly.UserControl.isValidSignupArgs = [{ description: 'signupUsername', id: 'abf7b641' }, { description: 'signupEmail', id: '38708282' }, { description: 'signupPassword', id: 'daf1486e' }, { description: 'signupConfirmPassword', id: '3f9f5d23' }];
window.blockly.js.blockly.UserControl.isValidSignup = async function(signupUsername, signupEmail, signupPassword, signupConfirmPassword) {
 var name;
  return this.cronapi.authentication.isValidSignup(signupUsername, signupEmail, signupPassword, signupConfirmPassword);
}
