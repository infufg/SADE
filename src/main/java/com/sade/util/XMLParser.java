package com.sade.util;

import com.sade.model.Docente;
import com.sade.service.NotaService;
import com.sade.service.NotaServiceDelegate;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by Vinicius on 25/06/2014.
 * Classe responsavel por ler um arquivo xml e ler
 */
public class XMLParser extends Thread implements NotaServiceDelegate {

	//constantes com os nomes das tags
	private final String DOCUMENT0 = "doc";
	private final String DOCENTE = "docente";

	private File file;
	private ConcurrentSkipListSet<Docente> novosDocentes;
	private boolean terminouLeitura = false;
	private int calculosEmProgresso = 0;

	public XMLParser(File file) {

		this.file = file;
		this.novosDocentes = new ConcurrentSkipListSet<>();
	}

	public void run() {

		startParsing();
	}

	/**
	 * Recupera todoas as atividades para cada docente contido no arquivo XML especificado.
	 *
	 * @return java.util.List<Docente> contendo todos os docentes encontrados.
	 */
	public void startParsing() {

		try {

			FileInputStream inputStream = new FileInputStream(file);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = null;

			builder = factory.newDocumentBuilder();
			Document document = builder.parse(inputStream);
			document.normalize();

			NodeList elements = document.getDocumentElement().getChildNodes();

			if (elements != null) {

				for (int i = 0; i < elements.getLength(); i++) {

					Node currentElement = elements.item(i);

					if (currentElement.getNodeName().equals(DOCENTE)) {

						DocentesXMLParser docentesXMLParser = new DocentesXMLParser(currentElement);
						Docente novoDocente = docentesXMLParser.nodeParaDocente();

						calculosEmProgresso++;
						new Thread(new NotaService(this, novoDocente)).start();
					}
				}

			}

		} catch (ParserConfigurationException | SAXException  | IOException e) {

			e.printStackTrace();

		} finally {
			terminouLeitura = true;
		}
	}

	public boolean temNovosDocentes() {
		return novosDocentes.size() > 0 || !terminouLeitura || calculosEmProgresso > 0;
	}

	public synchronized List<Docente> getNovosDocentes() {

		List<Docente> docentes = new ArrayList<>();
		docentes.addAll(novosDocentes);
		novosDocentes.removeAll(docentes);
		return docentes;
	}

	@Override
	public void notaDeDocenteCalculada(Docente docenteAtualizado) {
		novosDocentes.add(docenteAtualizado);
		calculosEmProgresso--;
	}

}

