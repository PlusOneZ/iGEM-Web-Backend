package cn.edu.tongji.software_igem2021.igemwebbackend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * ControllerTest
 *
 * @author 卓正一
 * @since 2022/3/10 2:42 PM
 */

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = IgemWebBackendApplication.class
)
@AutoConfigureMockMvc
class ControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testForAPI() throws Exception {
        mvc.perform(get("/api/comment/getall")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

}
