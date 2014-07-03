package com.sade.view;

import com.sade.model.Area;
import com.sade.model.Atividade;
import com.sade.service.AreaService;
import com.sade.service.AtividadeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Eurismar
 */
public class Main {
    public static void main(String[] args) throws IOException {

        Logger.getLogger("org.hibernate").setLevel(Level.OFF);


        Scanner sc = new Scanner(System.in);
        System.out.println("Informe\n1 - Para testar a AreaService\n"
                + "2 - Para testar a AtividadeService\n"
                + "3 - Para testar a VersaoService\n");

        int nextInt = sc.nextInt();

        String msgCrud = "Informe\n1 - Para salvar\n"
                + "2 - Para Listar\n"
                + "3 - Para Atualizar\n"
                + "4 - Para Deletar\n";
        int opcao = 0;
        switch (nextInt) {
            case 1: {
                System.out.println(msgCrud);
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1: {
                        testarInsertAreaService();
                        break;
                    }
                    case 2: {
                        testarListarAreaService();
                        break;
                    }
                    case 3: {
                        testarAtualizarAreaService();
                        break;
                    }
                    case 4: {
                        testarDeletarAreaService();
                        break;
                    }
                }
                break;
            }
            case 2: {
                System.out.println(msgCrud);
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1: {
                        testarInsertAtividadeService();
                        break;
                    }
                    case 2: {
                        testarListarAtividadeService();
                        break;
                    }
                    case 3: {
                        testarAtualizarAtividadeService();
                        break;
                    }
                    case 4: {
                        testarDeletarAtividadeService();
                        break;
                    }
                }
                break;

            }
            case 3: {
                System.out.println(msgCrud);
                opcao = sc.nextInt();
                break;
            }

        }
    }

    public static void testarInsertAreaService() throws IOException {

        boolean inserirMais = true;
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);


        while(inserirMais) {

            AreaService areaService = new AreaService();
            Area area = new Area();
            System.out.println("Digite o nome da área");
            String nomeArea = reader.readLine();
            area.setNome(nomeArea);
            areaService.save(area);

            System.out.println("Se Deseja inserir outra área digite 1 ou digite outra tecla para sair");
            int opcao = Integer.parseInt(reader.readLine());
            System.out.print(">>" + opcao);

            if (opcao != 1) {
                inserirMais = false;
            }

        }
    }

    public static void testarListarAreaService() {

        AreaService areaService = new AreaService();
        List<Area> areas;
        areas = areaService.list();
        for (Area area1 : areas) {
            System.out.println(area1.getId() + " - " + area1.getNome());
        }

    }

    //Atualizar area
    public static void testarAtualizarAreaService() throws IOException {

        boolean atualizarMais = true;

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        while (atualizarMais){

            boolean existeArea = false;
            AreaService areaService = new AreaService();

            Area area = new Area();
            System.out.println("Digite o nome da Area para atualizar");
            String nomeArea = reader.readLine();
            List<Area> areas;
            areas = areaService.list();

            for (Area a : areas) {

                if (a.getNome() != null && a.getNome().equals(nomeArea)) {
                    existeArea = true;
                    System.out.println("Digite o novo nome da area.");
                    String novoNomeArea = reader.readLine();
                    a.setNome(novoNomeArea);
                    areaService.update(a);
                    System.out.println("Area " + a.getNome() + " atualizada");

                }
            }

            if (existeArea == false) {
                System.out.println("Area " + nomeArea + " inexistente!");
            }

            areaService.save(area);
            System.out.println("Se Deseja atualizar outra Area digite 1 ou digite outra tecla para sair");
            int opcao = Integer.parseInt(reader.readLine());
            if (opcao != 1) {
                atualizarMais = false;
            }
        }
    }

    //Deletar area
    public static void testarDeletarAreaService() throws IOException {
        boolean deletarMais = true;

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        while (deletarMais) {
            boolean existeArea = false;
            AreaService areaService = new AreaService();
            System.out.println("Digite o nome da area");
            String nomeArea = reader.readLine();
            List<Area> areas;
            areas = areaService.list();

            for (Area a : areas) {
                if (a.getNome() != null && a.getNome().equals(nomeArea)) {
                    existeArea = true;
                    areaService.delete(a);
                    System.out.println("area " + a.getNome() + " deletada");
                    break;
                }
            }

            if (existeArea == false) {
                System.out.println("Area " + nomeArea + " inexistente!");
            }

            System.out.println("Se Deseja deletar outra area digite 1 ou digite outra tecla para sair");
            int opcao = Integer.parseInt(reader.readLine());
            if (opcao != 1) {
                deletarMais = false;
            }
        }
    }

    //Inserir Atividade
    public static void testarInsertAtividadeService() throws IOException {

        boolean inserirMais = true;

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        while (inserirMais) {

            AtividadeService atividadeService = new AtividadeService();
            Atividade atividade = new Atividade();

            //Nome
            System.out.println("Escreva o nome da atividade");
            String nomeAtividade = reader.readLine();
            System.out.println("Escreva a pontuacao da atividade");
            double pontuacaoAtividade = Double.parseDouble(reader.readLine());
            atividade.setNome(nomeAtividade);
            atividade.setPontuacao(pontuacaoAtividade);
            atividadeService.save(atividade);

            System.out.println("Se Deseja inserir outra atividade digite 1 ou digite outra tecla para sair");
            int opcao = Integer.parseInt(reader.readLine());

            if (opcao != 1) {
                inserirMais = false;
            }

        }

    }

    //Listar atividade
    public static void testarListarAtividadeService() {

        AtividadeService atividadeService = new AtividadeService();
        List<Atividade> atividades;
        atividades = atividadeService.list();
        for (Atividade atividade1 : atividades) {
            System.out.println(atividade1.getId() + " - " + atividade1.getNome() + " - " + atividade1.getPontuacao());
        }

    }

    //Atualizar atividade
    public static void testarAtualizarAtividadeService() throws IOException {

        boolean atualizarMais = true;

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        while (atualizarMais){
            boolean existeAtividade = false;
            AtividadeService atividadeService = new AtividadeService();
            System.out.println("Digite o nome da atividade para atualizar");
            String nomeAtividade = reader.readLine();
            List<Atividade> atividades;
            atividades = atividadeService.list();

            for (Atividade a : atividades) {

                if (a.getNome() != null && a.getNome().equals(nomeAtividade)) {

                    existeAtividade = true;
                    System.out.println("Digite o novo nome da atividade");
                    String novoNome = reader.readLine();

                    a.setNome(novoNome);

                    atividadeService.update(a);
                    System.out.println("Atividade " + novoNome + " atualizada");
                    break;

                }

            }

            if (existeAtividade == false) {
                System.out.println("Atividade " + nomeAtividade + " inexistente!");
            }

            System.out.println("Se Deseja atualizar outra atividade digite 1 ou digite outra tecla para sair");
            int opcao = Integer.parseInt(reader.readLine());
            if (opcao != 1) {
                atualizarMais = false;
            }
        }
    }

    //Deletar atividade
    public static void testarDeletarAtividadeService() throws IOException {
        boolean deletarMais = true;
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        while (deletarMais) {

            boolean existeAtividade = false;
            AtividadeService atividadeService = new AtividadeService();

            System.out.println("Digite o nome da atividade");
            String nomeAtividade = reader.readLine();
            List<Atividade> atividades;
            atividades = atividadeService.list();

            for (Atividade a : atividades) {

                if (a.getNome() != null && a.getNome().equals(nomeAtividade)) {

                    existeAtividade = true;
                    atividadeService.delete(a);
                    System.out.println("Atividade " + nomeAtividade + " deletada");
                    break;
                }

            }

            if (existeAtividade == false) {
                System.out.println("Atividade " + nomeAtividade + " inexistente!");
            }

            System.out.println("Se Deseja deletar outra Atividade digite 1 ou digite outra tecla para sair");
            int opcao = Integer.parseInt(reader.readLine());
            if (opcao != 1) {
                deletarMais = false;
            }
        }
    }

}

