window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.usuario = window.blockly.js.blockly.usuario || {};
window.blockly.js.blockly.usuario.BuscarUsuario = window.blockly.js.blockly.usuario.BuscarUsuario || {};

/**
 * @function salvarAlteracoes
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 21/11/2022 17:19:42
 *
 */
window.blockly.js.blockly.usuario.BuscarUsuario.salvarAlteracoesArgs = [];
window.blockly.js.blockly.usuario.BuscarUsuario.salvarAlteracoes = async function() {

  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Usuario.BuscarUsuario:atualizarUsuario', async function(sender_retorno) {
      retorno = sender_retorno;
    //
    if (this.cronapi.json.getProperty(retorno, 'sucesso')) {
      //
      this.cronapi.screen.notify('success','Alterações salvas com sucesso');
    }
  }.bind(this), this.cronapi.screen.getValueOfField("vars.email"), this.cronapi.screen.getValueOfField("vars.name"));
  //
  this.cronapi.screen.showComponent("crn-button-editar");
  //
  this.cronapi.screen.showComponent("crn-button-redefinir");
  //
  this.cronapi.screen.hideComponent("crn-button-cancelar");
  //
  this.cronapi.screen.disableComponent("crn-textinput-name");
  //
  this.cronapi.screen.disableComponent("crn-textinput-email");
  //
  this.cronapi.screen.hideComponent("crn-button-salvar");
}

/**
 * @function exclusaoConta
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 21/11/2022 17:19:42
 *
 */
window.blockly.js.blockly.usuario.BuscarUsuario.exclusaoContaArgs = [];
window.blockly.js.blockly.usuario.BuscarUsuario.exclusaoConta = async function() {

  //
  this.cronapi.notification.confirmDialogAlert('warning', 'Deseja realmente excluir sua conta?', 'Essa ação não poderá ser desfeita e você perderá todos os seus dados', [this.cronapi.notification.buttonConfirmDialogAlert('true', 'Cancelar', async function() {
    }.bind(this)), this.cronapi.notification.buttonConfirmDialogAlert('false', 'Excluir mesmo assim', async function() {
     //
    (await this.blockly.js.blockly.usuario.BuscarUsuario.funcaoExclusao());
   }.bind(this))]);
}

/**
 * @function funcaoExclusao
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 21/11/2022 17:19:42
 *
 */
window.blockly.js.blockly.usuario.BuscarUsuario.funcaoExclusaoArgs = [];
window.blockly.js.blockly.usuario.BuscarUsuario.funcaoExclusao = async function() {

  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Usuario.BuscarUsuario:excluirUsuario', async function(sender_retorno) {
      retorno = sender_retorno;
    //
    this.cronapi.screen.notify('success','Cadastro excluído com sucesso');
    //
    this.cronapi.screen.logout();
  }.bind(this));
}

/**
 * @function editarUsuario
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 21/11/2022 17:19:42
 *
 */
window.blockly.js.blockly.usuario.BuscarUsuario.editarUsuarioArgs = [];
window.blockly.js.blockly.usuario.BuscarUsuario.editarUsuario = async function() {

  //
  this.cronapi.screen.enableComponent("crn-textinput-name");
  //
  this.cronapi.screen.enableComponent("crn-textinput-email");
  //
  this.cronapi.screen.showComponent("crn-button-salvar");
  //
  this.cronapi.screen.showComponent("crn-button-cancelar");
  //
  this.cronapi.screen.hideComponent("crn-button-editar");
  //
  this.cronapi.screen.hideComponent("crn-button-redefinir");
}

/**
 * @function preencherInfoUsuario
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 21/11/2022 17:19:42
 *
 */
window.blockly.js.blockly.usuario.BuscarUsuario.preencherInfoUsuarioArgs = [];
window.blockly.js.blockly.usuario.BuscarUsuario.preencherInfoUsuario = async function() {

  //
  usuario = this.cronapi.json.createObjectFromString(this.cronapi.util.getLocalStorage('_u'));
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Usuario.BuscarUsuario:buscarUsuario', async function(sender_retorno) {
      retorno = sender_retorno;
    //
    if (this.cronapi.json.getProperty(retorno, 'sucesso')) {
      //
      this.cronapi.screen.changeValueOfField("vars.name", this.cronapi.json.getProperty(retorno, 'dados.name'));
      //
      this.cronapi.screen.changeValueOfField("vars.email", this.cronapi.json.getProperty(retorno, 'dados.email'));
    }
  }.bind(this), this.cronapi.json.getProperty(usuario, 'user.username'));
}

/**
 * @function cancelarEdicao
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 21/11/2022 17:19:42
 *
 */
window.blockly.js.blockly.usuario.BuscarUsuario.cancelarEdicaoArgs = [];
window.blockly.js.blockly.usuario.BuscarUsuario.cancelarEdicao = async function() {

  //
  (await this.blockly.js.blockly.usuario.BuscarUsuario.preencherInfoUsuario());
  //
  this.cronapi.screen.hideComponent("crn-button-cancelar");
  //
  this.cronapi.screen.hideComponent("crn-button-salvar");
  //
  this.cronapi.screen.showComponent("crn-button-editar");
  //
  this.cronapi.screen.showComponent("crn-button-redefinir");
  //
  this.cronapi.screen.disableComponent("crn-textinput-name");
  //
  this.cronapi.screen.disableComponent("crn-textinput-email");
}
