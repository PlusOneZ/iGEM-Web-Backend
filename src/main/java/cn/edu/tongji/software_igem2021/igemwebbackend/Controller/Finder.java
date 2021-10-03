package cn.edu.tongji.software_igem2021.igemwebbackend.Controller;

import cn.edu.tongji.software_igem2021.igemwebbackend.Entity.ScoreWithNameEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.Repository.FinderRepository;
import cn.edu.tongji.software_igem2021.igemwebbackend.Service.FinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class Finder {

    @Autowired
    private FinderService finderService;

    @Resource
    FinderRepository finderRepository;

    @RequestMapping(value = "/search/bacteria", method = RequestMethod.GET)
    @ResponseBody
    public List<ScoreWithNameEntity> getBacteriaSearchResult(@RequestParam(name = "key") String key) {
        List<ScoreWithNameEntity> result = finderService.searchForBacteria(key).subList(0, 501);
        return result.subList(0, Math.min(result.size() - 1, 501));
    }

    @RequestMapping(value = "/search/phage", method = RequestMethod.GET)
    @ResponseBody
    public List<ScoreWithNameEntity> getPhageSearchResult(@RequestParam(name = "key") String key) {
        List<ScoreWithNameEntity> result = finderService.searchForPhage(key).subList(0, 501);
        return result.subList(0, Math.min(result.size() - 1, 501));
    }

    @RequestMapping(value = "/search/all", method = RequestMethod.GET)
    @ResponseBody
    public List<ScoreWithNameEntity> getAllSearchResult(@RequestParam(name = "key") String key) {
        System.out.println(finderRepository);
        System.out.println(key);
        if (key.length() <= 3) {
            return new ArrayList();
        }
        List<ScoreWithNameEntity> result = finderService.searchForAll(key);
        return result.subList(0, Math.min(result.size() - 1, 501));
    }
}
