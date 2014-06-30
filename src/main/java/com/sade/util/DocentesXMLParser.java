package com.sade.util;

import com.sade.model.Atividade;
import com.sade.model.Docente;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vinicius on 27/06/2014.
 * Classe responsavel por tratar o xml de um docente especifico;
 */
public class DocentesXMLParser extends Thread {

    private final String ATIVIDADE = "atividade";
    private final String NOME = "nome";
    private final String QUANTIDADE = "quantidade";
    private final String CODIGO = "codigo";

    private Node nodeDocente;
    Docente docenteResultante;
    private DocenteXMLParserDelegate delegate;

    public DocentesXMLParser(Node nodeDocente, Docente docente, DocenteXMLParserDelegate delegate) {

        this.nodeDocente = nodeDocente;
        this.docenteResultante = docente;
        this.delegate = delegate;

    }

    @Override
    public void run() {

        nodeParaDocente(nodeDocente);

    }

    /**
     * Lê um nó xml e converte para um objeto Docente
     * @param node só de um docente.
     * @return DOcente
     */
    public void nodeParaDocente(Node node) {
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
        delegate.parsedDocente(docente);

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

