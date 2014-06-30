package com.sade.controllers;

import com.sade.model.Atividade;
import com.sade.service.AtividadeService;
import java.util.List;

/**
 *
 * @author Julliano
 */
public class AtividadeController {
    
    public Atividade save(Atividade atividade){        
        return new AtividadeService().save(atividade);
    }
    
    public Atividade update(Atividade atividade){
        return new AtividadeService().update(atividade);
    }
    
    public boolean delete(Atividade atividade){        
        return new AtividadeService().delete(atividade);
    }
    
    public List<Atividade> list(){        
        return new AtividadeService().list();
    }
    
    public Atividade get(Long idAtividade){        
        return new AtividadeService().get(idAtividade);
    }
    
}
