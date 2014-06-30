package com.sade.service

import com.sade.model.Atividade
import spock.lang.Specification

/**
 * Created by Felipe on 27/06/2014.
 */
class NotaServiceTestSpec extends Specification {
    def "CalculaNotaDeAtividade"() {
        setup:
        Atividade atividadeTeste = new Atividade();
        atividadeTeste.setPontuacao(pontuacao);
        atividadeTeste.setQuantidade(quantidade);
        atividadeTeste.setDivisor(divisor);
        atividadeTeste.setLimitePontuacao(limitePontuacao);

        NotaService notaTeste = new NotaService();

        expect:
        notaTeste.calculaNotaDeAtividade(atividadeTeste) == resutlado;

        where:
        pontuacao | quantidade | divisor | limitePontuacao || resutlado
        1.5       | 2          | 2       | 5               || 1.5
        5         | 2          | 2       | 5               || 5
        10        | 1          | 1       | 5               || 5
    }

    def "CalculeNota"() {
        setup:
        List atividades;

        Atividade atividadeTeste1 = new Atividade();
        atividadeTeste1.setPontuacao(pontuacao);
        atividadeTeste1.setQuantidade(quantidade);
        atividadeTeste1.setDivisor(divisor);
        atividadeTeste1.setLimitePontuacao(limitePontuacao);

        Atividade atividadeTeste2 = new Atividade();
        atividadeTeste2.setPontuacao(pontuacao);
        atividadeTeste2.setQuantidade(quantidade);
        atividadeTeste2.setDivisor(divisor);
        atividadeTeste2.setLimitePontuacao(limitePontuacao);

        atividades= [atividadeTeste1, atividadeTeste2];

        NotaService notaTeste = new NotaService();

        expect:
        notaTeste.calculeNota(atividades) == resutlado;

        where:
        pontuacao | quantidade | divisor | limitePontuacao || resutlado
        1.5       | 2          | 2       | 5               || 3
        5         | 2          | 2       | 5               || 10
        10        | 1          | 1       | 5               || 10
    }
}
