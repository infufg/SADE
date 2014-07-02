package com.sade;

import com.sade.model.Area;
import com.sade.service.AreaService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Eurismar
 */
public class Sade {    
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
         List<Area> areas = new ArrayList<Area>();
         areas = areaService.list();
         for (Area area1 : areas) {
            System.out.println(area1.getId() + " - " + area1.getNome());
        }          
    }
}
