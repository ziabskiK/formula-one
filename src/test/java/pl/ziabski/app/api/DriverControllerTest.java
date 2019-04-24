package pl.ziabski.app.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.ziabski.app.data_model.Driver;
import pl.ziabski.app.service.DriverServiceImplementation;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DriverController.class)
public class DriverControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DriverServiceImplementation driverService;
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

        String uri = "/api/driver";
        when(driverService.findAll()).thenReturn(drivers);

        String input = this.toJson(drivers);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String output = result.getRequest().getContentAsString();

        assertThat(input, is(output));
    }

    @Test
    public void addNewDriver() {
    }

    @Test
    public void deleteDriver() {
    }

    private String toJson(Object o) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(o);
    }
}