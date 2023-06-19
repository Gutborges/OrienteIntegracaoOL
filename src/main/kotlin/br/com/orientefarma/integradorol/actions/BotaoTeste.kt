package br.com.orientefarma.integradorol.actions

import br.com.sankhya.extensions.actionbutton.AcaoRotinaJava
import br.com.sankhya.extensions.actionbutton.ContextoAcao
import br.com.sankhya.modelcore.auth.AuthenticationInfo
import br.com.sankhya.modelcore.comercial.BarramentoRegra
import br.com.sankhya.modelcore.comercial.CentralFaturamento
import br.com.sankhya.modelcore.comercial.ConfirmacaoNotaHelper

class BotaoTeste: AcaoRotinaJava {
    override fun doAction(contextoAcao: ContextoAcao) {
        val nuNota = contextoAcao.getParam("NUNOTA").toString().toBigDecimal()
        simularConfirmacaoCentral(nuNota.toInt())
    }

    fun simularConfirmacaoCentral(nuNota: Int) {
        val barramento = BarramentoRegra.build(
            CentralFaturamento::class.java,
            "regrasConfirmacaoSilenciosa.xml", AuthenticationInfo.getCurrent())
        ConfirmacaoNotaHelper.confirmarNota(nuNota.toBigDecimal(), barramento,
            false, true)
    }
}