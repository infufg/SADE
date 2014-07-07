package com.sade.view;

import com.sade.controllers.AtividadeController;
import com.sade.model.Area;
import com.sade.model.Atividade;
import com.sade.service.AreaService;
import com.sade.service.AtividadeService;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 * @author Eurismar
 */
public class Main {
	public static void main(String[] args) {

        AtividadeController atividadeController = new AtividadeController();


        for (int i = 1; i < 11; i++) {
            Atividade atividade = new Atividade();

            atividade.setCodigo(String.valueOf(i));
            atividade.setPontuacao(20.0);
            atividade.setDivisor(2);
            atividade.setDescricao("Atividade de teste");

            atividadeController.save(atividade);

        }

        /*
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe\n1 - Para testar a AreaService\n"
				                   + "2 - Para testar a AtividadeService\n"
				                   + "3 - Para testar a VersaoService\n"
				                   + "4 - Para testar a NotaService");
		int nextInt = sc.nextInt();

		String msgCrud = "Informe\n1 - Para salvar\n"
				                 + "2 - Para Listar\n"
				                 + "3 - Para Atualizar\n"
				                 + "4 - Para Deletar\n"
				                 + "5 - Para obter uma área\n";
		int opcao = 0;
		switch(nextInt){
			case 1:{
				System.out.println(msgCrud);
				opcao = sc.nextInt();
				switch(opcao){
					case 1:{
						testarInsertAreaService();
						break;
					}
					case 2:{
						testarListarAreaService();
						break;
					}
					case 3:{
						break;
					}
					case 4:{
						break;
					}
				}
				break;
			}
			case 2:{
				System.out.println(msgCrud);
				break;
			}
			case 3:{
				System.out.println(msgCrud);
				break;
			}
			case 4:{
				System.out.println(msgCrud);
				break;
			}
		}
		*/
	}
	public static void testarInsertAreaService(){
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
			int opcao =  sc.nextInt();
			if(opcao != 1){
				inserirMais = false;
			}
		} while (inserirMais);
	}
	public static void testarListarAreaService(){
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
            System.out.println("Digite o nome da Area para atualizar");
            String nomeArea = sc.nextLine();
            List<Area> areas;
            areas = areaService.list();

            for (Area area1 : areas) {
                if (area1.equals(nomeArea)) {
                    System.out.println(area1.getId() + " - " + area1.getNome());
                    existeArea = true;
                    areaService.update(area1);
                    System.out.println("Area " + nomeArea + " atualizada");
                }
            }

            if (existeArea == false) {
                System.out.println("Area " + nomeArea + " inexistente!");
            }

            areaService.save(area);
            System.out.println("Se Deseja atualizar outra Area digite 1 ou digite outra tecla para sair");
            int opcao = sc.nextInt();
            if (opcao != 1) {
                atualizarMais = false;
            }

        } while (atualizarMais);
    }

    public static void testarInsertAtividadeService() throws IOException {

        AtividadeService atividadeService = new AtividadeService();
        Atividade atividade = null;

        boolean inserirMais = true;
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


        do {

            atividade = new Atividade();

            System.out.println("Digite o nome da atividade");
            String nomeAtivadade = bufferedReader.readLine();

            atividade.setNome(nomeAtivadade);

            atividadeService.save(atividade);

            System.out.println("Se Deseja inserir outra ativadade digite 1 ou digite outra tecla para sair");


        } while (inserirMais);




    }
}
