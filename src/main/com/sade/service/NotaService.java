package main.com.sade.service;

import main.com.sade.model.Atividade;

import java.math.BigDecimal;
import java.util.List;

public class NotaService {
    public BigDecimal calculaNotaDeAtividade(Atividade atividade) {
        BigDecimal pontuacao = new BigDecimal(atividade.getPontuacao());
        BigDecimal quantidade = new BigDecimal(atividade.getQuantidade());
        BigDecimal divisor = new BigDecimal(atividade.getDivisor());

        BigDecimal limitePontuacao = new BigDecimal(atividade.getLimitePontuacao());

        BigDecimal nota = (pontuacao.multiply(quantidade)).divide(divisor);
        if (primeiroEhMaiorQueSegundo(nota, limitePontuacao)) {
            nota = limitePontuacao;
        }

        return nota;
    }

    public BigDecimal calculeNota(List<Atividade> atividades) {
        BigDecimal notaTotal = BigDecimal.ZERO;

        for(Atividade atividade : atividades)
            notaTotal = notaTotal.add(calculaNotaDeAtividade(atividade));

        return notaTotal;
    }

    private boolean primeiroEhMaiorQueSegundo(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) == 1;
    }
}
