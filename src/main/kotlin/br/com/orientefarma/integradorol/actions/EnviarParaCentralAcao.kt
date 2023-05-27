package br.com.orientefarma.integradorol.actions

import br.com.orientefarma.integradorol.controller.IntegradorOLController
import br.com.orientefarma.integradorol.controller.dto.PedidoOLDto
import br.com.sankhya.extensions.actionbutton.AcaoRotinaJava
import br.com.sankhya.extensions.actionbutton.ContextoAcao

@Suppress("unused")
class EnviarParaCentralAcao : AcaoRotinaJava {

    /**
     * Na tela "Integra��o OL" o pedido importado do operador log�stico,
     * pode ser enviado para a central de vendas atrav�s deste bot�o.
     * S� depois disso, o pedido importado estar� apto a ser faturado.
     */
    override fun doAction(contextoAcao: ContextoAcao) {
        Thread.currentThread().name = "IntegradorOL"

        if(contextoAcao.linhas.isEmpty()){
            contextoAcao.setMensagemRetorno("Selecione ao menos um pedido.")
            return
        }

        if(contextoAcao.linhas.size > 1){
            contextoAcao.setMensagemRetorno("Selecione um pedido por vez.")
            return
        }

        val pedidoOlDto = PedidoOLDto.fromLinhas(contextoAcao.linhas[0])

        IntegradorOLController().enviarParaCentral(pedidoOlDto)

        if(pedidoOlDto.size > 1 || pedidoOlDto.isEmpty() || pedidoOlDto.first().nuNotaEnviado == null){
            contextoAcao.setMensagemRetorno("Processamento conclu�do.")
            return
        }else{
            contextoAcao.setMensagemRetorno("Pedido ${pedidoOlDto.first().nuNotaEnviado} criado.")
        }
    }
}