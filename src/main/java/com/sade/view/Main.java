package com.sade.view;

import com.sade.model.Area;
import com.sade.model.Atividade;
import com.sade.model.Versao;
import com.sade.service.AreaService;
import com.sade.service.AtividadeService;
import com.sade.service.VersaoService;
import java.util.List;
import java.util.Scanner;

/**
 * @author Eurismar
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe\n1 - Para testar a AreaService\n"
                + "2 - Para testar a AtividadeService\n"
                + "3 - Para testar a VersaoService\n"
                + "4 - Para testar a NotaService");
        int nextInt = sc.nextInt();

        String msgCrud = "Informe\n1 - Para salvar\n"
                + "2 - Para Listar\n"
                + "3 - Para Atualizar\n"
                + "4 - Para Deletar\n" /*+ "5 - Para obter uma área\n"*/;
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
                    default: {
                        System.err.println("Comando \"" + opcao + "\" não é reconhecido como um comando interno.");
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
                    default: {
                        System.err.println("Comando \"" + opcao + "\" não é reconhecido como um comando interno.");
                    }
                }
                break;
            }
            case 3: {
                System.out.println(msgCrud);
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1: {
                        testarInsertVersaoService();
                        break;
                    }
                    case 2: {
                        testarListarVersaoService();
                        break;
                    }
                    case 3: {
                        testarAtualizarVersaoService();
                        break;
                    }
                    case 4: {
                        testarDeletarVersaoService();
                        break;
                    }
                    default: {
                        System.err.println("Comando \"" + opcao + "\" não é reconhecido como um comando interno.");
                    }
                }
                break;
            }
            case 4: {
                System.out.println(msgCrud);
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1: {
                        //testarInsertNotaService();
                        break;
                    }
                    case 2: {
                        //testarListarNotaService();
                        break;
                    }
                    case 3: {
                        //testarAtualizarNotaService();
                        break;
                    }
                    case 4: {
                        //testarDeletarNotaService();
                        break;
                    }
                    default: {
                        System.err.println("Comando \"" + opcao + "\" não é reconhecido como um comando interno.");
                    }
                }
                break;
            }
            default: {
                System.err.println("Comando \"" + nextInt + "\" não é reconhecido como um comando interno.");
            }
        }
    }

    //Inserir area
    public static void testarInsertAreaService() {
        boolean inserirMais = true;
        Scanner sc = new Scanner(System.in);
        do {
            AreaService areaService = new AreaService();
            Area area = new Area();
            System.out.println("Digite o nome da área");
            String nomeArea = sc.nextLine();
            area.setNome(nomeArea);
            areaService.save(area);
            

            System.out.println("Se Deseja inserir outra área digite 1 ou digite outra tecla para sair");
            int opcao = sc.nextInt();
            if (opcao != 1) {
                inserirMais = false;
            }
        } while (inserirMais);
    }

    //Listar area
    public static void testarListarAreaService() {
        AreaService areaService = new AreaService();
        List<Area> areas;
        areas = areaService.list();
        for (Area area1 : areas) {
            System.out.println(area1.getId() + " - " + area1.getNome());
        }
    }

    //Atualizar area
    public static void testarAtualizarAreaService() {
        boolean atualizarMais = true;
        Scanner sc = new Scanner(System.in);
        do {
            boolean existeArea = false;
            AreaService areaService = new AreaService();
            Area area = new Area();
            System.out.println("Digite o nome da área para atualizar");
            String nomeArea = sc.nextLine();
            List<Area> areas;
            areas = areaService.list();

            for (Area area1 : areas) {
                if (area1.equals(nomeArea)) {
                    System.out.println(area1.getId() + " - " + area1.getNome());
                    existeArea = true;
                    areaService.update(area1);
                    System.out.println("Área " + nomeArea + " atualizada");
                }
            }

            if (existeArea == false) {
                System.out.println("Área " + nomeArea + " inexistente!");
            }

            areaService.save(area);
            System.out.println("Se Deseja atualizar outra área digite 1 ou digite outra tecla para sair");
            int opcao = sc.nextInt();
            if (opcao != 1) {
                atualizarMais = false;
            }
        } while (atualizarMais);
    }

    //Deletar area
    public static void testarDeletarAreaService() {
        boolean deletarMais = true;
        Scanner sc = new Scanner(System.in);
        do {
            boolean existeArea = false;
            AreaService areaService = new AreaService();
            System.out.println("Digite o nome da área");
            String nomeArea = sc.nextLine();
            List<Area> areas;
            areas = areaService.list();

            for (Area area1 : areas) {
                if (area1.equals(nomeArea)) {
                    existeArea = true;
                    areaService.delete(area1);
                    System.out.println("Área " + nomeArea + " deletada");
                    break;
                }
            }

            if (existeArea == false) {
                System.out.println("Área " + nomeArea + " inexistente!");
            }

            System.out.println("Se Deseja deletar outra área digite 1 ou digite outra tecla para sair");
            int opcao = sc.nextInt();
            if (opcao != 1) {
                deletarMais = false;
            }
        } while (deletarMais);
    }

    //Inserir Atividade
    public static void testarInsertAtividadeService() {
        boolean inserirMais = true;
        Scanner sc = new Scanner(System.in);
        do {
            AtividadeService atividadeService = new AtividadeService();
            Atividade atividade = new Atividade();

            //Nome 
            System.out.println("Escreva o nome da atividade");
            String nomeAtividade = sc.nextLine();
            atividade.setNome(nomeAtividade);
            atividadeService.save(atividade);

            System.out.println("Se Deseja inserir outra atividade digite 1 ou digite outra tecla para sair");
            int opcao = sc.nextInt();
            if (opcao != 1) {
                inserirMais = false;
            }
        } while (inserirMais);
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
    public static void testarAtualizarAtividadeService() {
        boolean atualizarMais = true;
        Scanner sc = new Scanner(System.in);
        do {
            boolean existeAtividade = false;
            AtividadeService atividadeService = new AtividadeService();
            System.out.println("Digite o nome da atividade para atualizar");
            String nomeAtividade = sc.nextLine();
            List<Atividade> atividades;
            atividades = atividadeService.list();

            for (Atividade atividade1 : atividades) {
                if (atividade1.equals(nomeAtividade)) {
                    existeAtividade = true;
                    atividadeService.update(atividade1);
                    System.out.println("Atividade " + nomeAtividade + " atualizada");
                    break;
                }
            }

            if (existeAtividade == false) {
                System.out.println("Atividade " + nomeAtividade + " inexistente!");
            }

            System.out.println("Se Deseja atualizar outra atividade digite 1 ou digite outra tecla para sair");
            int opcao = sc.nextInt();
            if (opcao != 1) {
                atualizarMais = false;
            }
        } while (atualizarMais);
    }

    //Deletar atividade
    public static void testarDeletarAtividadeService() {
        boolean deletarMais = true;
        Scanner sc = new Scanner(System.in);
        do {
            boolean existeAtividade = false;
            AtividadeService atividadeService = new AtividadeService();

            System.out.println("Digite o nome da atividade");
            String nomeAtividade = sc.nextLine();
            List<Atividade> atividades;
            atividades = atividadeService.list();

            for (Atividade atividade1 : atividades) {
                if (atividade1.equals(nomeAtividade)) {
                    existeAtividade = true;
                    atividadeService.delete(atividade1);
                    System.out.println("Atividade " + nomeAtividade + " deletada");
                    break;
                }
            }

            if (existeAtividade == false) {
                System.out.println("Atividade " + nomeAtividade + " inexistente!");
            }

            System.out.println("Se Deseja deletar outra Atividade digite 1 ou digite outra tecla para sair");
            int opcao = sc.nextInt();
            if (opcao != 1) {
                deletarMais = false;
            }
        } while (deletarMais);
    }

    //Inserir Versao
    public static void testarInsertVersaoService() {
        boolean inserirMais = true;
        Scanner sc = new Scanner(System.in);
        do {
            VersaoService versaoService = new VersaoService();
            Versao versao = new Versao();
            System.out.println("Digite o nome da versao");
            String nomeVersao = sc.nextLine();
            versao.setCodigoVersao(nomeVersao);
            versaoService.save(versao);

            System.out.println("Se Deseja inserir outra versao digite 1 ou digite outra tecla para sair");
            int opcao = sc.nextInt();
            if (opcao != 1) {
                inserirMais = false;
            }
        } while (inserirMais);
    }

    //Listar versao
    public static void testarListarVersaoService() {
        VersaoService versaoService = new VersaoService();
        List<Versao> versaos;
        versaos = versaoService.list();
        for (Versao versao1 : versaos) {
            System.out.println(versao1.getId() + " - " + versao1.getCodigoVersao());
        }
    }

    //Atualizar versao
    public static void testarAtualizarVersaoService() {
        boolean atualizarMais = true;
        Scanner sc = new Scanner(System.in);
        do {
            boolean existeVersao = false;
            VersaoService versaoService = new VersaoService();
            System.out.println("Digite o nome da versao para atualizar");
            String nomeVersao = sc.nextLine();
            List<Versao> versaos;
            versaos = versaoService.list();

            for (Versao versao1 : versaos) {
                if (versao1.equals(nomeVersao)) {
                    existeVersao = true;
                    versaoService.update(versao1);
                    System.out.println("Versao " + nomeVersao + " atualizada");
                    break;
                }
            }

            if (existeVersao == false) {
                System.out.println("Versao " + nomeVersao + " inexistente!");
            }

            System.out.println("Se Deseja atualizar outra versão digite 1 ou digite outra tecla para sair");
            int opcao = sc.nextInt();
            if (opcao != 1) {
                atualizarMais = false;
            }
        } while (atualizarMais);
    }

    //Deletar versao
    public static void testarDeletarVersaoService() {
        boolean deletarMais = true;
        Scanner sc = new Scanner(System.in);
        do {
            boolean existeVersao = false;
            VersaoService versaoService = new VersaoService();

            System.out.println("Digite o nome da versão");
            String nomeVersao = sc.nextLine();
            List<Versao> versaos;
            versaos = versaoService.list();

            for (Versao versao1 : versaos) {
                if (versao1.equals(nomeVersao)) {
                    existeVersao = true;
                    versaoService.delete(versao1);
                    System.out.println("Versão " + nomeVersao + "deletada");
                    break;
                }
            }

            if (existeVersao == false) {
                System.out.println("Versão " + nomeVersao + " inexistente!");
            }

            System.out.println("Se Deseja deletar outra versão digite 1 ou digite outra tecla para sair");
            int opcao = sc.nextInt();
            if (opcao != 1) {
                deletarMais = false;
            }
        } while (deletarMais);
    }
}
