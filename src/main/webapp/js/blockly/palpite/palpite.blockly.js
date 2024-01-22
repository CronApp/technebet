window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.palpite = window.blockly.js.blockly.palpite || {};
window.blockly.js.blockly.palpite.Palpite = window.blockly.js.blockly.palpite.Palpite || {};

/**
 * @function salvarPalpite
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 02/12/2022 13:28:54
 *
 */
window.blockly.js.blockly.palpite.Palpite.salvarPalpiteArgs = [];
window.blockly.js.blockly.palpite.Palpite.salvarPalpite = async function() {
 var ganhadorPenalidades, response;
  //
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.gols_mandante")) || this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.gols_visitante"))) {
    //
    this.cronapi.notification.customNotify('error', 'Você deve preencher o placar completo', 'fade', 'top', 'right', 'true');
  } else {
    //
    if (this.cronapi.screen.getValueOfField("vars.existeEmpate")) {
      //
      ganhadorPenalidades = this.cronapi.screen.getValueOfField("vars.vencedorPenaltis");
    } else {
      //
      ganhadorPenalidades = null;
    }
    //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.Palpite.Palpite:salvarPalpite', async function(sender_response) {
        response = sender_response;
      //
      if (this.cronapi.json.getProperty(response, 'sucesso')) {
        //
        this.cronapi.notification.customNotify('success', this.cronapi.json.getProperty(response, 'mensagem'), 'fade', 'top', 'right', 'true');
        //
        this.cronapi.screen.changeView("#/home/logged/todas.partidas",[  ]);
      } else {
        //
        this.cronapi.notification.customNotify('error', this.cronapi.json.getProperty(response, 'mensagem'), 'fade', 'top', 'right', 'true');
      }
    }.bind(this), this.cronapi.util.getSessionStorage('__p'), this.cronapi.screen.getValueOfField("vars.gols_mandante"), this.cronapi.screen.getValueOfField("vars.gols_visitante"), ganhadorPenalidades);
  }
}

/**
 * @function verificaPalpiteNulo
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 02/12/2022 13:28:54
 *
 */
window.blockly.js.blockly.palpite.Palpite.verificaPalpiteNuloArgs = [];
window.blockly.js.blockly.palpite.Palpite.verificaPalpiteNulo = async function() {
 var ganhadorPenalidades, response;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Palpite.Palpite:palpiteNulo', async function(sender_retorno) {
      retorno = sender_retorno;
    //
    if (this.cronapi.json.getProperty(retorno, 'sucesso')) {
      //
      this.cronapi.screen.changeValueOfField("vars.existePalpite", this.cronapi.json.getProperty(retorno, 'palpite'));
    }
  }.bind(this), this.cronapi.util.getSessionStorage('__p'));
}

/**
 * @function irTelaPalpite
 *
 * Descreva esta função...
 *
 * @param partida
 *
 * @author Matheus Portugal Ribeiro
 * @since 02/12/2022 13:28:54
 *
 */
window.blockly.js.blockly.palpite.Palpite.irTelaPalpiteArgs = [{ description: 'partida', id: 'e6a763e5' }];
window.blockly.js.blockly.palpite.Palpite.irTelaPalpite = async function(partida) {
 var ganhadorPenalidades;
  //
  this.cronapi.util.setSessionStorage('__p', partida);
  //
  this.cronapi.screen.changeView("#/home/logged/ver.palpite",[  ]);
}

/**
 * @function retornar
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 02/12/2022 13:28:54
 *
 */
window.blockly.js.blockly.palpite.Palpite.retornarArgs = [];
window.blockly.js.blockly.palpite.Palpite.retornar = async function() {
 var ganhadorPenalidades, response;
  //
  if (this.cronapi.util.getSessionStorage('g_m') != this.cronapi.screen.getValueOfField("vars.gols_mandante") || this.cronapi.util.getSessionStorage('g_v') != this.cronapi.screen.getValueOfField("vars.gols_visitante")) {
    //
    if (!this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.gols_mandante")) && !this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.gols_visitante"))) {
      //
      this.cronapi.notification.confirmDialogAlert('warning', 'Salve seu palpite', '<b>Deseja salvar palpite antes de sair?</b>', [this.cronapi.notification.buttonConfirmDialogAlert('true', 'Sim, salvar', async function() {
         //
        (await this.blockly.js.blockly.palpite.Palpite.salvarPalpite());
       }.bind(this)), this.cronapi.notification.buttonConfirmDialogAlert('false', 'Não, cancelar', async function() {
         //
        this.cronapi.screen.back();
       }.bind(this))]);
    } else {
      //
      this.cronapi.screen.back();
    }
  } else {
    //
    this.cronapi.screen.back();
  }
}

/**
 * @function obterPalpite
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 02/12/2022 13:28:54
 *
 */
window.blockly.js.blockly.palpite.Palpite.obterPalpiteArgs = [];
window.blockly.js.blockly.palpite.Palpite.obterPalpite = async function() {
 var ganhadorPenalidades, response;
  //
  this.cronapi.screen.changeValueOfField("vars.existeEmpate", false);
  //
  this.cronapi.screen.changeValueOfField("vars.ultima_vencedora", null);
  //
  this.cronapi.screen.changeValueOfField("vars.vencedorPenaltis", null);
  //
  (await this.blockly.js.blockly.palpite.Palpite.verificaPalpiteNulo());
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Palpite.Palpite:obterPalpite', async function(sender_res) {
      res = sender_res;
    //
    if (this.cronapi.json.getProperty(res, 'sucesso')) {
      //
      this.cronapi.screen.changeValueOfField("vars.partida", this.cronapi.json.getProperty(res, 'partida'));
      //
      this.cronapi.screen.changeValueOfField("vars.palpites_usuarios", this.cronapi.json.getProperty(res, 'listaPalpites'));
      //
      if (this.cronapi.json.getProperty(res, 'penaltis')) {
        //
        this.cronapi.screen.changeValueOfField("vars.existeEmpate", true);
        //
        this.cronapi.screen.changeValueOfField("vars.vencedorPenaltis", this.cronapi.json.getProperty(res, 'vencedorPenal'));
        //
        this.cronapi.screen.changeValueOfField("vars.ultima_vencedora", this.cronapi.json.getProperty(res, 'vencedorPenalNome'));
      }
      //
      if (!this.cronapi.logic.isNullOrEmpty(this.cronapi.json.getProperty(res, 'palpite'))) {
        //
        this.cronapi.util.setSessionStorage('g_m', this.cronapi.json.getProperty(res, 'palpite.gols_mandante'));
        //
        this.cronapi.util.setSessionStorage('g_v', this.cronapi.json.getProperty(res, 'palpite.gols_visitante'));
        //
        this.cronapi.screen.changeValueOfField("vars.gols_mandante", this.cronapi.json.getProperty(res, 'palpite.gols_mandante'));
        //
        this.cronapi.screen.changeValueOfField("vars.gols_visitante", this.cronapi.json.getProperty(res, 'palpite.gols_visitante'));
      }
      //
      if (this.cronapi.json.getProperty(res, 'partida.partida_finalizada') || this.cronapi.json.getProperty(res, 'partida.status_Partida.nome_status') != 'Não iniciada') {
        //
        this.cronapi.screen.changeAttrValue("placarA", 'readOnly', '');
        //
        this.cronapi.screen.changeAttrValue("placarB", 'readOnly', '');
        //
        this.cronapi.screen.hideComponent("container-info-footer-btns");
      }
    }
  }.bind(this), this.cronapi.util.getSessionStorage('__p'));
}
