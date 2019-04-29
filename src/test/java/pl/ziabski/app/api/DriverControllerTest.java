package pl.ziabski.app.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.ziabski.app.data_model.Driver;
import pl.ziabski.app.service.DriverServiceImplementation;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class DriverControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DriverServiceImplementation service;

    @Test
    public void getDrivers() throws Exception{

        List<Driver> drivers = new ArrayList<>();
        Driver driver1 = new Driver();
        driver1.setId(1);
        driver1.setFirstName("Lewis");
        driver1.setLastName("Hamilton");
        driver1.setCountry("GB");

        Driver driver2 = new Driver();
        driver2.setId(2);
        driver2.setFirstName("Charles");
        driver2.setLastName("Leclerc");
        driver2.setCountry("Monaco");
        drivers.add(driver1);
        drivers.add(driver2);


        ObjectMapper mapper = new ObjectMapper();


        given(service.findAll()).willReturn(drivers);
        this.mockMvc.perform(get("/api/driver"))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(drivers)));


    }

    @Test
    public void addNewDriver() {
    }

    @Test
    public void deleteDriver() {
    }


}