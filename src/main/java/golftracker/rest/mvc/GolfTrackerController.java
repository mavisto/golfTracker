package golftracker.rest.mvc;

import org.springframework.stereotype.Controller;
import golftracker.core.services.GolftrackerService;

@Controller
public class GolfTrackerController {
    private GolftrackerService service;
    
    public GolfTrackerController(GolftrackerService service) {
        this.service = service;
    }

}
