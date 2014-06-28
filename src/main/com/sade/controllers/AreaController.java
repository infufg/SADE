package main.com.sade.controllers;

import main.com.sade.model.Area;
import java.util.List;

/**
 *
 * @author Julliano
 */
public class AreaController {
    
    AreaService service = new AreaService();
    
    public Area save(Area area){
        service.save(area);
    }
    
    public Area update(Area area){
        //TODO esperando service
        return null;
    }
    
    public boolean delete(Area area){
        //TODO esperando service
        return false;
    }
    
    public List<Area> list(){
        //TODO esperando service
        return null;
    }
    
    public Area get(Long idArea){
        //TODO esperando service
        return null;
    }
    
    
}
