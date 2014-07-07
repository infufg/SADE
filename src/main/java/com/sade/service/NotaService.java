package com.sade.service;

import com.sade.model.Atividade;
import com.sade.model.Docente;

import java.math.BigDecimal;
import java.util.List;

public class NotaService implements Runnable {

	private NotaServiceDelegate delegate;
	private Docente docente;

	public NotaService() {

	}

	public NotaService(NotaServiceDelegate delegate, Docente docente) {

		this.delegate = delegate;
		this.docente = docente;
	}

	public BigDecimal calculaEAtualizaNotaDeDocente() {

		BigDecimal nota = calculeNota(docente.getAtividades());
		docente.setNota(nota.doubleValue());
		delegate.notaDeDocenteCalculada(docente);
		return nota;
	}

	public BigDecimal calculaNotaDeAtividade(Atividade atividade) {

		BigDecimal pontuacao = atividade.getPontuacao() != null ? new BigDecimal(atividade.getPontuacao()) : BigDecimal.ZERO;
		BigDecimal quantidade = atividade.getQuantidade() != null ? new BigDecimal(atividade.getQuantidade()) : BigDecimal.ZERO;
		BigDecimal divisor = atividade.getDivisor() != null ? new BigDecimal(atividade.getDivisor()) : BigDecimal.ONE;

		BigDecimal limitePontuacao = atividade.getLimitePontuacao() != null ? new BigDecimal(atividade.getLimitePontuacao()) : null;

		BigDecimal nota = (pontuacao.multiply(quantidade)).divide(divisor);
		if (primeiroEhMaiorQueSegundo(nota, limitePontuacao)) {
			nota = limitePontuacao;
		}

		return nota;
	}

	public BigDecimal calculeNota(List<Atividade> atividades) {

		BigDecimal notaTotal = BigDecimal.ZERO;

		for (Atividade atividade : atividades)
			notaTotal = notaTotal.add(calculaNotaDeAtividade(atividade));

		return notaTotal;
	}

	private boolean primeiroEhMaiorQueSegundo(BigDecimal a, BigDecimal b) {

		return b != null && a.compareTo(b) == 1;
	}

	@Override
	public void run() {

		if (delegate != null && docente != null) calculaEAtualizaNotaDeDocente();
	}
}
