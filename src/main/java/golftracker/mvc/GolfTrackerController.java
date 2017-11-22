package golftracker.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GolfTrackerController {
    
    
    
    @RequestMapping("/test")
    public String Test() {
        return "view";
    }

}
