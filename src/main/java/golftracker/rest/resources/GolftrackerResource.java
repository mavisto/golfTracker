package golftracker.rest.resources;

import org.springframework.hateoas.ResourceSupport;

public class GolftrackerResource extends ResourceSupport {
    private String title;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle( String title ) {
        this.title = title;
    }

}
