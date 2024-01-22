window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.auth = window.blockly.js.blockly.auth || {};
window.blockly.js.blockly.auth.UserControl = window.blockly.js.blockly.auth.UserControl || {};

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
 * @since 14/11/2022 18:33:25
 *
 */
window.blockly.js.blockly.auth.UserControl.signUpDepreceatedArgs = [{ description: 'signupUsername', id: '8df902ea' }, { description: 'signupEmail', id: '0c25d725' }, { description: 'signupPassword', id: '9c203fbf' }, { description: 'signupConfirmPassword', id: '067b073b' }];
window.blockly.js.blockly.auth.UserControl.signUpDepreceated = async function(signupUsername, signupEmail, signupPassword, signupConfirmPassword) {
 var name;
  //
  (await this.cronapi.authentication.signup(signupUsername, signupEmail, signupPassword, signupConfirmPassword));
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
 * @since 14/11/2022 18:33:25
 *
 */
window.blockly.js.blockly.auth.UserControl.signUpArgs = [{ description: 'name2', id: '3a3ca4e0' }, { description: 'email', id: '04d8e9d1' }, { description: 'password', id: '164870cd' }, { description: 'confirmPassword', id: 'b019c901' }];
window.blockly.js.blockly.auth.UserControl.signUp = async function(name2, email, password, confirmPassword) {
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
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.Usuario.Usuario:CadastrarUsuario', async function(sender_response) {
        response = sender_response;
      //
      if (this.cronapi.json.getProperty(response, 'sucesso')) {
        //
        this.cronapi.notification.customNotify('success', this.cronapi.json.getProperty(response, 'mensagem'), 'fade', 'top', 'center', 'true');
        //
        this.cronapi.screen.changeView("#/app/login",[  ]);
      } else {
        //
        this.cronapi.notification.customNotify('error', this.cronapi.json.getProperty(response, 'mensagem'), 'fade', 'top', 'center', 'true');
      }
    }.bind(this), email, password, name2);
  }
}

/**
 * @function resetPassword
 *
 * Descreva esta função...
 *
 * @param email
 *
 * @author Matheus Portugal Ribeiro
 * @since 14/11/2022 18:33:25
 *
 */
window.blockly.js.blockly.auth.UserControl.resetPasswordArgs = [{ description: 'email', id: '7b9f3909' }];
window.blockly.js.blockly.auth.UserControl.resetPassword = async function(email) {
 var name, password, confirmPassword, response;
  //
  this.cronapi.authentication.resetPasswordWithOTP(email);
}

/**
 * @function tst
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 14/11/2022 18:33:25
 *
 */
window.blockly.js.blockly.auth.UserControl.tstArgs = [];
window.blockly.js.blockly.auth.UserControl.tst = async function() {
 var name, email, password, confirmPassword, response;
  //
  this.cronapi.PWA.install(null, null);
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
 * @since 14/11/2022 18:33:25
 *
 */
window.blockly.js.blockly.auth.UserControl.isValidSignupArgs = [{ description: 'signupUsername', id: 'be2325de' }, { description: 'signupEmail', id: 'dc667925' }, { description: 'signupPassword', id: '9a49950f' }, { description: 'signupConfirmPassword', id: 'f6fdc12c' }];
window.blockly.js.blockly.auth.UserControl.isValidSignup = async function(signupUsername, signupEmail, signupPassword, signupConfirmPassword) {
 var name;
  return this.cronapi.authentication.isValidSignup(signupUsername, signupEmail, signupPassword, signupConfirmPassword);
}
