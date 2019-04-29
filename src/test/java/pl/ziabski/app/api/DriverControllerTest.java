package pl.ziabski.app.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.ziabski.app.data_model.Driver;
import pl.ziabski.app.service.DriverServiceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    public void getDrivers() throws Exception {

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


        given(service.findAll()).willReturn(drivers);
        this.mockMvc.perform(get("/api/driver"))
                .andExpect(status().isOk())
                .andExpect(content().json(this.mapToJson(drivers)));


    }

    @Test
    public void addNewDriver() throws Exception {
        Driver driver1 = new Driver();
        driver1.setId(1);
        driver1.setFirstName("Lewis");
        driver1.setLastName("Hamilton");
        driver1.setCountry("GB");




        this.mockMvc.perform(post("/api/driver")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(driver1)))
                .andExpect(status().isOk());



    }

    @Test
    public void deleteDriver() throws Exception {
        Driver driver = new Driver("Lewis", "Hamilton", "GB");
        driver.setId(1);

       when(service.findDriverById(driver.getId())).thenReturn(Optional.of(driver));

        this.mockMvc.perform(delete("/api/driver/{id}", driver.getId())).andExpect(status().isOk());


    }

    @Test
    public void findDriverById() throws Exception {
        Driver driver = new Driver("Lewis", "Hamilton", "GB");
        driver.setId(1);

        when(service.findDriverById(driver.getId())).thenReturn(Optional.of(driver));

        mockMvc.perform(get("/api/driver/{id}", driver.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json(mapToJson(driver)));


    }

    private String mapToJson(Object o) throws Exception {
        return new ObjectMapper().writeValueAsString(o);
    }


    @Test
    public void updateDriver() throws Exception {

        Driver driver = new Driver("Lewis", "Hamilton", "GB");
        driver.setId(1);
        when(service.findDriverById(driver.getId())).thenReturn(Optional.of(driver));


        mockMvc.perform(put("/api/driver/{id}", driver.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(driver)))
                .andExpect(status().isOk());

    }
}