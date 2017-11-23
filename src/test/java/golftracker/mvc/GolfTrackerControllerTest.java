package golftracker.mvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class GolfTrackerControllerTest {
    
    @InjectMocks 
    private GolfTrackerController controller;
    
    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        
        MockitoAnnotations.initMocks( this );
        
        mockMvc = MockMvcBuilders.standaloneSetup( controller).build();
        
    }

    @Test
    public void test() throws Exception{
        mockMvc.perform(post("/test")
                .content("{\"title\":\"Test Blog Title\"}")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andDo(print());
    }

}

