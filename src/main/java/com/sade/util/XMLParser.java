package com.sade.util;

import com.sade.model.Atividade;
import com.sade.model.Docente;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by Vinicius on 25/06/2014.
 * Classe responsavel por ler um arquivo xml e ler
 */
public class XMLParser implements DocenteXMLParserDelegate {

    //constantes com os nomes das tags
    private final String DOCUMENT0 = "doc";
    private final String DOCENTE = "docente";

    ConcurrentSkipListSet<Docente> docentes;

    public ConcurrentSkipListSet<Docente> getDocentes() {
        return docentes;
    }

    public XMLParser() {
        this.docentes = new ConcurrentSkipListSet<Docente>();
    }

    /**
     * Recupera todoas as atividades para cada docente contido no arquivo XML especificado.
     *
     * @return java.util.List<Docente> contendo todos os docentes encontrados.
     * @throws java.io.FileNotFoundException
     */
    public ConcurrentSkipListSet<Docente> getDocentesXML(File file) throws FileNotFoundException {

        FileInputStream inputStream = new FileInputStream(file);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;


        try {

            builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);
            document.normalize();

            NodeList elements = encontraPrimeiroElementoPorNome(document.getDocumentElement(), DOCUMENT0).getChildNodes();

            if (elements != null) {

                for (int i = 0; i < elements.getLength(); i++) {

                    Element currentElement = (Element) elements.item(i);

                    if (currentElement.getNodeName().equals(DOCENTE)) {


                        Thread t = new DocentesXMLParser(currentElement,this);
                    }
                }

            }

        } catch (ParserConfigurationException e) {

            e.printStackTrace();

        } catch (SAXException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }


        return docentes;
    }

    /**
     * Sobrecarga.Recupera todas as atividades para cada docente contido no arquivo XML especificado.
     *
     * @return List<Docente> contendo todos os docentes encontrados.
     * @throws java.io.FileNotFoundException
     */
    public ConcurrentSkipListSet<Docente> getDocentesXML(String filePath) throws FileNotFoundException {

        File file = new File(filePath);

        if (file.exists()) {
            return getDocentesXML(file);
        } else {
            throw new FileNotFoundException();
        }

    }


    public Element encontraPrimeiroElementoPorNome(Node element, String name) throws NoSuchElementException {

        NodeList elements = element.getChildNodes();

        if (elements != null) {

            for (int i = 0; i < elements.getLength(); i++) {

                Element currentElement = (Element) elements.item(i);

                if (currentElement.getNodeName().equals(name)) {
                    //retorna a primeira ocorrencia do nó procurado
                    return currentElement;

                }
            }
        }

        throw new NoSuchElementException();

    }

    @Override
    public void parsedDocente(Docente docente) {

        docentes.add(docente);

    }
}

