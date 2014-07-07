package com.sade.util;

import com.sade.model.Atividade;
import com.sade.model.Docente;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viniciusmaboni
 * Classe responsável por tratar o XML de um docente específico;
 */
public class DocentesXMLParser {

    private final String ATIVIDADE = "atividade";
    private final String NOME = "nome";
    private final String QUANTIDADE = "quantidade";
    private final String CODIGO = "codigo";

    private Node node;

    public DocentesXMLParser(Node nodeDocente) {

        this.node = nodeDocente;

    }

    /**
     * Lê um nó xml e converte para um objeto com.sade.model.Docente
     *
     * @return com.sade.model.Docente
     */
    public Docente nodeParaDocente() {

        Docente docente = new Docente();
        List<Atividade> atividades = new ArrayList<Atividade>();

        NamedNodeMap map = node.getAttributes();
        docente.setId(map.getNamedItem(CODIGO).getTextContent());
        docente.setNome(map.getNamedItem(NOME).getTextContent());

        NodeList nodeList = node.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {

            Node currentElement = nodeList.item(i);

            if (currentElement != null) {

                if (currentElement.getNodeName().equals(ATIVIDADE)) {

                    atividades.add(nodeParaAtividade(currentElement));
                }

            }

        }

        docente.setAtividades(atividades);

		return docente;
    }

    /**
     * Converte um nó em um com.sade.model.Atividade
     *
     * @param node nó que representa a atividade
     * @return com.sade.model.Atividade
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

