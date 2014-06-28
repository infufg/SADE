package main.com.sade.util;

import main.com.sade.model.Atividade;
import main.com.sade.model.Docente;
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

/**
 * Created by Vinicius on 25/06/2014.
 * Classe responsavel por ler um arquivo xml e ler
 */
public class ParserXML {

    private final String DOCUMENT0 = "doc";
    private final String ATIVIDADE = "atividade";
    private final String DOCENTE = "docente";
    private final String CODIGO = "codigo";
    private final String NOME = "nome";
    private final String QUANTIDADE = "quantidade";

    /**
     * Recupera todoas as atividades para cada docente contido no arquivo XML especificado.
     *
     * @return Lit<Docente> contendo todos os docentes encontrados.
     * @throws java.io.FileNotFoundException
     */
    public List<Docente> getDocentesXML(File file) throws FileNotFoundException {

        List<Docente> docentesEncontrados = new ArrayList<Docente>();
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
                        docentesEncontrados.add(nodeParaDocente(currentElement));
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


        return docentesEncontrados;
    }

    /**
     * Sobrecarga.Recupera todas as atividades para cada docente contido no arquivo XML especificado.
     *
     * @return List<Docente> contendo todos os docentes encontrados.
     * @throws java.io.FileNotFoundException
     */
    public List<Docente> getDocentesXML(String filePath) throws FileNotFoundException {

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

    /**
     * Lê um nó xml e converte para um objeto Docente
     * @param node só de um docente.
     * @return DOcente
     */
    public Docente nodeParaDocente(Node node) {
        Docente docente = new Docente();
        List<Atividade> atividades = new ArrayList<Atividade>();

        NamedNodeMap map = node.getAttributes();
        docente.setId(map.getNamedItem(CODIGO).getTextContent());
        docente.setNome(map.getNamedItem(NOME).getTextContent());

        NodeList nodeList = node.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {

            Element currentElement = (Element) nodeList.item(i);

            if (currentElement.getNodeName().equals(ATIVIDADE)) {

                if (currentElement.getNodeName().equals(ATIVIDADE)) {

                    atividades.add(nodeParaAtividade(currentElement));
                }

            }

        }

        docente.setAtividades(atividades);

        return docente;
    }

    /**
     * Converte um nó em um objeto atividade
     *
     * @param node nó que representa a atividade
     * @return Objeto Atividade
     */
    public Atividade nodeParaAtividade(Node node) {
        Atividade atividade = new Atividade();

        NamedNodeMap map = node.getAttributes();

        //pega os atributos da tag e usa como valores pra atividade
        atividade.setCodigo(map.getNamedItem(CODIGO).getTextContent());
        int quantidade = Integer.parseInt(map.getNamedItem(QUANTIDADE).getTextContent());
        atividade.setQuantidade(quantidade);


        return atividade;
    }


}
