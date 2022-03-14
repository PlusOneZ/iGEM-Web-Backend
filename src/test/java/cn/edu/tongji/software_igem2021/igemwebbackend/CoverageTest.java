package cn.edu.tongji.software_igem2021.igemwebbackend;

import cn.edu.tongji.software_igem2021.igemwebbackend.dto.BacAndPhageInfo;
import cn.edu.tongji.software_igem2021.igemwebbackend.service.FinderService;
import cn.edu.tongji.software_igem2021.igemwebbackend.service.impl.FinderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * CoverageTest
 *
 * @author 卓正一
 * @since 2022/3/10 1:58 PM
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class CoverageTest {

    @Resource
    private FinderServiceImpl finderService;

    @Test
    void finderTest() {
        List<BacAndPhageInfo> suggestion =  finderService.querySuggestionForAll("Ab", 1);
        assertThat(suggestion).isNotNull();
    }
}
