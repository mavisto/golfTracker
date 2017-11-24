package golftracker.mvc;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import golftracker.core.entities.Golftracker;
import golftracker.core.services.GolftrackerService;
import golftracker.rest.mvc.GolfTrackerController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;


public class GolfTrackerControllerTest {
    
    @InjectMocks 
    private GolfTrackerController controller;
    
    @Mock
    private GolftrackerService service;
    
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        
        MockitoAnnotations.initMocks( this );
        
        mockMvc = MockMvcBuilders.standaloneSetup( controller).build();
        
    }

    @Test
    public void getExistingGolftrackerEntry()  throws Exception{
        
        Golftracker golftracker = new Golftracker();
        
        golftracker.setId( 1L );
        golftracker.setTitle( "Golf Tracker Test" );
        
        when(service.find( 1L )).thenReturn(golftracker);
        
        mockMvc.perform( get("/rest/golftracker-entries/1") )
                    .andDo( print() )
                    .andExpect(jsonPath("$.title", is(golftracker.getTitle())))
                    .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/golftracker-entries/1"))))
                    .andExpect(status().isOk());

    }
    
    @Test
    public void getNonExistingGolftrackerEntry()  throws Exception{
                
        when(service.find( 1L )).thenReturn(null);
        
        mockMvc.perform( get("/rest/golftracker-entries/1") )
                    .andExpect(status().isNotFound());

    }

}

