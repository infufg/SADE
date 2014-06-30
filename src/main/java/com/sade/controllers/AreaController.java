package com.sade.controllers;

import com.sade.model.Area;
import com.sade.service.AreaService;
import java.util.List;

/**
 *
 * @author Julliano
 */
public class AreaController {
    
    public Area save(Area area){        
        return new AreaService().save(area);          
    }
    
    public Area update(Area area){
        return new AreaService().update(area);          
    }
    
    public boolean delete(Area area){        
        return new AreaService().delete(area);
    }
    
    public List<Area> list(){        
        return new AreaService().list();
    }
    
    public Area get(Long idArea){        
        return new AreaService().get(idArea);
    }
    
    
}
