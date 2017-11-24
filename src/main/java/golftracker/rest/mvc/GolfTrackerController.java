package golftracker.rest.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import golftracker.core.entities.Golftracker;
import golftracker.core.services.GolftrackerService;
import golftracker.rest.resources.GolftrackerResource;
import golftracker.rest.resources.asm.GolftrackerResourceAsm;

@Controller
@RequestMapping("rest/golftracker-entries")
public class GolfTrackerController {
    private GolftrackerService service;

    public GolfTrackerController( GolftrackerService service ) {
        this.service = service;
    }

    @RequestMapping( value = "/{golftrackerId}", method = RequestMethod.GET )
    public ResponseEntity<GolftrackerResource> getGolftracker( @PathVariable Long golftrackerId ) {

        Golftracker golftracker = service.find( golftrackerId );
        if ( golftracker != null ) {
            GolftrackerResource res = new GolftrackerResourceAsm().toResource( golftracker );

            return new ResponseEntity<GolftrackerResource>( res, HttpStatus.OK );
        } else {
            return new ResponseEntity<GolftrackerResource>( HttpStatus.NOT_FOUND );

        }
    }

}
