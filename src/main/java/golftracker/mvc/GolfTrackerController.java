package golftracker.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import golftracker.entities.Golftracker;

@Controller
public class GolfTrackerController {
    
    @RequestMapping(value = "/test", method=RequestMethod.POST )
    public @ResponseBody Golftracker test(@RequestBody Golftracker golftracker) {
        
        return golftracker;
    }

}
