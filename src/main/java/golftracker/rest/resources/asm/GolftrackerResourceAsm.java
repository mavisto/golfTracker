package golftracker.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import golftracker.core.entities.Golftracker;
import golftracker.rest.mvc.GolfTrackerController;
import golftracker.rest.resources.GolftrackerResource;

public class GolftrackerResourceAsm extends ResourceAssemblerSupport<Golftracker, GolftrackerResource> {

    public GolftrackerResourceAsm( ) {
        super( GolfTrackerController.class, GolftrackerResource.class );
    }

    @Override
    public GolftrackerResource toResource( Golftracker entity ) {
        GolftrackerResource res = new GolftrackerResource();
        res.setTitle( entity.getTitle() );

        return res;
    }

}
