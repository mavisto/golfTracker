package golftracker.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Link;

import golftracker.core.entities.Golftracker;
import golftracker.rest.mvc.GolfTrackerController;
import golftracker.rest.resources.GolftrackerResource;

public class GolftrackerResourceAsm extends ResourceAssemblerSupport<Golftracker, GolftrackerResource> {

    public GolftrackerResourceAsm( ) {
        super( GolfTrackerController.class, GolftrackerResource.class );
    }

    @Override
    public GolftrackerResource toResource( Golftracker golftracker ) {
        GolftrackerResource res = new GolftrackerResource();
        res.setTitle( golftracker.getTitle() );
        
        Link link = linkTo( GolfTrackerController.class ).slash( golftracker.getId() ).withSelfRel();
        
        res.add( link.withSelfRel() );

        return res;
    }

}
