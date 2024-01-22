window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.mensagem = window.blockly.js.blockly.mensagem || {};
window.blockly.js.blockly.mensagem.Mensagem = window.blockly.js.blockly.mensagem.Mensagem || {};

/**
 * @function aposInserir
 *
 * Descreva esta função...
 *
 * @param mensagem
 *
 * @author Matheus Portugal Ribeiro
 * @since 18/11/2022 09:42:18
 *
 */
window.blockly.js.blockly.mensagem.Mensagem.aposInserirArgs = [{ description: 'mensagem', id: 'fef750e9' }];
window.blockly.js.blockly.mensagem.Mensagem.aposInserir = async function(mensagem) {

  //
  if (this.cronapi.logic.isNullOrEmpty(mensagem)) {
    //
    mensagem = 'Dado inserido com sucesso';
  }
  //
  this.cronapi.screen.notify('success',mensagem);
}

/**
 * @function aposEditar
 *
 * Descreva esta função...
 *
 * @param mensagem
 *
 * @author Matheus Portugal Ribeiro
 * @since 18/11/2022 09:42:18
 *
 */
window.blockly.js.blockly.mensagem.Mensagem.aposEditarArgs = [{ description: 'mensagem', id: 'fef750e9' }];
window.blockly.js.blockly.mensagem.Mensagem.aposEditar = async function(mensagem) {

  //
  if (this.cronapi.logic.isNullOrEmpty(mensagem)) {
    //
    mensagem = 'Dado atualizado com sucesso';
  }
  //
  this.cronapi.screen.notify('success',mensagem);
}

/**
 * @function aposExcluir
 *
 * Descreva esta função...
 *
 * @param mensagem
 *
 * @author Matheus Portugal Ribeiro
 * @since 18/11/2022 09:42:18
 *
 */
window.blockly.js.blockly.mensagem.Mensagem.aposExcluirArgs = [{ description: 'mensagem', id: 'fef750e9' }];
window.blockly.js.blockly.mensagem.Mensagem.aposExcluir = async function(mensagem) {

  //
  if (this.cronapi.logic.isNullOrEmpty(mensagem)) {
    //
    mensagem = 'Dado excluído com sucesso';
  }
  //
  this.cronapi.screen.notify('success',mensagem);
}
