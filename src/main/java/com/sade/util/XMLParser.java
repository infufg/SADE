package com.sade.util;

import com.sade.model.Docente;
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
public class XMLParser extends Thread {

	//constantes com os nomes das tags
	private final String DOCUMENT0 = "doc";
	private final String DOCENTE = "docente";

	private File file;
	private ConcurrentSkipListSet<Docente> docentes;
	private ConcurrentSkipListSet<Docente> novosDocentes;
	private boolean terminouLeitura = false;


	public XMLParser(File file) {

		this.file = file;
		this.docentes = new ConcurrentSkipListSet<>();
		this.novosDocentes = new ConcurrentSkipListSet<>();
	}

	public void run() {

		beginParse();
	}

	/**
	 * Recupera todoas as atividades para cada docente contido no arquivo XML especificado.
	 *
	 * @return java.util.List<Docente> contendo todos os docentes encontrados.
	 */
	public ConcurrentSkipListSet<Docente> beginParse() {

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
						docentes.add(novoDocente);
						novosDocentes.add(novoDocente);
					}
				}

			}

		} catch (ParserConfigurationException | SAXException  | IOException e) {

			e.printStackTrace();

		} finally {
			terminouLeitura = true;
		}

		return docentes;
	}

	public boolean temNovosDocentes() {
		return novosDocentes.size() > 0 || !terminouLeitura;
	}

	public synchronized List<Docente> getNovosDocentes() {

		List<Docente> docentes = new ArrayList<>();
		docentes.addAll(novosDocentes);
		novosDocentes.removeAll(docentes);
		return docentes;
	}

}

