window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.CalcularPontos = window.blockly.js.blockly.CalcularPontos || {};

/**
 * @function calcularPontos
 *
 * calcularPontos
 *
 *
 * @author Paula Regina Tironi
 * @since 14/11/2022 13:46:37
 *
 */
window.blockly.js.blockly.CalcularPontos.calcularPontosArgs = [];
window.blockly.js.blockly.CalcularPontos.calcularPontos = async function() {
 var totalPontos, palpiteCadastrado, pontuacaoMandante, palpiteMandante, pontuacaoVisitante, palpiteVisitante, numGolPalpite, vencedorPenaltisPalpite, vencPartidaPenaltis, acertarVencedorPartida, vencedorPartida;
  //
  totalPontos = 0;
  //
  if (palpiteCadastrado) {
    //
    totalPontos = (totalPontos + 1);
  }
  //
  console.log('1');
  //
  if (pontuacaoMandante == palpiteMandante && pontuacaoVisitante == palpiteVisitante) {
    //
    totalPontos = (totalPontos + 10);
  }
  //
  console.log('2');
  //
  if (numGolPalpite == (pontuacaoVisitante + pontuacaoMandante)) {
    //
    totalPontos = (totalPontos + 8);
  }
  //
  console.log('3');
  //
  if (vencedorPenaltisPalpite == vencPartidaPenaltis) {
    //
    totalPontos = (totalPontos + 6);
  }
  //
  console.log('4');
  //
  if (acertarVencedorPartida == vencedorPartida) {
    //
    totalPontos = (totalPontos + 5);
  }
  //
  console.log('passou');
}
