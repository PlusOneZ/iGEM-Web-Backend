package cn.edu.tongji.software_igem2021.igemwebbackend.Controller;

import cn.edu.tongji.software_igem2021.igemwebbackend.Entity.BacteriaPhageScoreEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.Entity.BacteriaTaxonEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.Entity.PhageEntity;
import cn.edu.tongji.software_igem2021.igemwebbackend.Repository.BacteriaTaxonRepository;
import cn.edu.tongji.software_igem2021.igemwebbackend.Repository.FinderRepository;
import cn.edu.tongji.software_igem2021.igemwebbackend.Repository.PhageTaxonRepository;
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

    @Resource
    FinderRepository finderRepository;

    @Resource
    BacteriaTaxonRepository bacteriaTaxonRepository;

    @Resource
    PhageTaxonRepository phageTaxonRepository;

    @RequestMapping(value = "/search/bacteria", method = RequestMethod.GET)
    @ResponseBody
    public List<BacteriaPhageScoreEntity> getBacteriaSearchResult(@RequestParam(name = "key") String key) {
        String sqlSearchKey = '%' + key.strip().replace(' ', '%') + '%';
        System.out.println(sqlSearchKey);
        List<BacteriaTaxonEntity> nameList = bacteriaTaxonRepository.getBacteriaTaxonBySearchName(sqlSearchKey);
        System.out.println(nameList);

        List<BacteriaPhageScoreEntity> result = new ArrayList<>();
        // 通过细菌 Taxon 查找到相关的记录值
        for (BacteriaTaxonEntity bt: nameList
             ) {
            if(result.size() > 500) break;
            System.out.println(finderRepository.findAllByBacteriaTxidOrderByScoreDesc(bt.getTaxonId()));
            result.addAll(finderRepository.findAllByBacteriaTxidOrderByScoreDesc(bt.getTaxonId()));
        }

        // 输入值为细菌 Taxon 的情况
        try {
            int taxon_id = Integer.parseInt(key);
            if (("" + taxon_id).length() == key.strip().length()) {
                result.addAll(finderRepository.findAllByBacteriaTxidOrderByScoreDesc(taxon_id));
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        System.out.println(result);
        return result;
    }

    @RequestMapping(value = "/search/phage", method = RequestMethod.GET)
    @ResponseBody
    public List<BacteriaPhageScoreEntity> getPhageSearchResult(@RequestParam(name = "key") String key) {
        String sqlSearchKey = '%' + key.strip().replace(' ', '%') + '%';
        System.out.println(sqlSearchKey);
        List<PhageEntity> nameList = phageTaxonRepository.getPhageTaxonBySearchName(sqlSearchKey);
        System.out.println(nameList);

        List<BacteriaPhageScoreEntity> result = new ArrayList<>();
        // 通过细菌 Taxon 查找到相关的记录值
        for (PhageEntity bt: nameList
        ) {
            if (result.size() > 500) break;
            System.out.println(finderRepository.findAllByPhageTxidOrderByScoreDesc(bt.getTaxonId()));
            result.addAll(finderRepository.findAllByPhageTxidOrderByScoreDesc(bt.getTaxonId()));
        }

        // 输入值为细菌 Taxon 的情况
        try {
            int taxon_id = Integer.parseInt(key);
            if (("" + taxon_id).length() == key.strip().length()) {
                result.addAll(finderRepository.findAllByPhageTxidOrderByScoreDesc(taxon_id));
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        System.out.println(result);
        return result;
    }

}
