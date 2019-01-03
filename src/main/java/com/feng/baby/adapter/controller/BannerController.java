package com.feng.baby.adapter.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.feng.baby.application.command.CreateBannerCommand;
import com.feng.baby.application.representation.BasicInfo;
import com.feng.baby.application.representation.FunctionMenus;
import com.feng.baby.application.representation.SlideContainer;
import com.feng.baby.application.service.BannerService;
import com.feng.baby.application.service.GoodsService;
import com.feng.baby.model.SlideContainerType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fengshuaiju on 2018-06-29.
 */
@Slf4j
@RestController
@RequestMapping("/banner")
public class BannerController {

    private final BannerService bannerService;

    private final GoodsService goodsService;

    @Autowired
    public BannerController(BannerService bannerService, GoodsService goodsService) {
        this.bannerService = bannerService;
        this.goodsService = goodsService;
    }

    //key
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public JSON list(@RequestParam(required = false) String type, @RequestParam(required = false) String key){

        if("toptuan".equals(type)){
            return JSON.parseArray("[{\"businessId\":30164,\"dateAdd\":\"2018-05-10 21:26:56\",\"dateUpdate\":\"2018-07-12 09:59:13\",\"id\":8275,\"linkUrl\":\"性价比最高\",\"paixu\":9,\"picUrl\":\"https://cdn.it120.cc/apifactory/2018/06/26/0dcfc0c9fd272718637c4a7947b4e130.png\",\"remark\":\"自助下单\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"清欢严选小程序端模版\",\"type\":\"toptuan\",\"userId\":797},{\"businessId\":43223,\"dateAdd\":\"2018-05-10 22:01:08\",\"dateUpdate\":\"2018-07-12 09:59:23\",\"id\":8279,\"linkUrl\":\"极简风格\",\"paixu\":10,\"picUrl\":\"https://cdn.it120.cc/apifactory/2018/06/26/2d8c0087f8c5e384670274c162738f11.png\",\"remark\":\"自助下单\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"清欢素雅小程序端模版\",\"type\":\"toptuan\",\"userId\":797},{\"businessId\":40601,\"dateAdd\":\"2018-05-10 22:26:07\",\"dateUpdate\":\"2018-07-12 09:59:28\",\"id\":8282,\"linkUrl\":\"多店铺功能\",\"paixu\":11,\"picUrl\":\"https://cdn.it120.cc/apifactory/2018/06/26/60e80cf7946946d494b2538d1557cf8d.png\",\"remark\":\"自助下单\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"清欢食光机Plus小程序端模版\",\"type\":\"toptuan\",\"userId\":797},{\"businessId\":36888,\"dateAdd\":\"2018-05-10 22:31:25\",\"dateUpdate\":\"2018-06-21 22:24:32\",\"id\":8283,\"linkUrl\":\"999起\",\"paixu\":12,\"picUrl\":\"https://cdn.it120.cc/apifactory/2018/05/09/aacf690ca68bd771c23360d20ce1e699.png\",\"remark\":\"测试\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"床头柜中的颜值担当\",\"type\":\"toptuan\",\"userId\":797}]");
        }

        if("mallName".equals(key) && "topkan".equals(type)){
            return JSON.parseArray("[{\"businessId\":0,\"dateAdd\":\"2018-05-10 23:35:46\",\"dateUpdate\":\"2018-05-12 07:47:39\",\"id\":8289,\"linkUrl\":\"/pages/kanjia-list/index\",\"paixu\":13,\"picUrl\":\"\",\"remark\":\"38759,38772,38932\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"全民砍价\",\"type\":\"topkan\",\"userId\":797}]");
        }

        if("mallName".equals(key) && "toptopic".equals(type)){
            return JSON.parseArray("[{\"businessId\":0,\"dateAdd\":\"2018-05-11 09:19:33\",\"id\":8297,\"linkUrl\":\"/pages/topic-list/index\",\"paixu\":14,\"picUrl\":\"\",\"remark\":\"3473,3474,3489\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"精选专题\",\"type\":\"toptopic\",\"userId\":797}]");
        }

        if("mallName".equals(key) && "goods".equals(type)){
            return JSONObject.parseArray("[{\"businessId\":30164,\"dateAdd\":\"2018-03-10 10:24:52\",\"dateUpdate\":\"2018-07-04 22:15:28\",\"id\":5506,\"linkUrl\":\"\",\"paixu\":16,\"picUrl\":\"https://cdn.it120.cc/apifactory/2018/07/04/c98865950e4684c9f793574db58c814d.jpg\",\"remark\":\"\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"一口好锅\",\"type\":\"goods\",\"userId\":797},{\"businessId\":30164,\"dateAdd\":\"2018-03-10 10:22:59\",\"dateUpdate\":\"2018-07-04 22:15:39\",\"id\":5505,\"linkUrl\":\"\",\"paixu\":17,\"picUrl\":\"https://cdn.it120.cc/apifactory/2018/07/04/aa0f5223d156185bff69b47a0ba4189e.jpg\",\"remark\":\"\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"舌尖上的猪肉\",\"type\":\"goods\",\"userId\":797}]");
        }

        if("mallName".equals(key) && "duihuan".equals(type)){
            return JSONObject.parseArray("[{\"businessId\":2375,\"dateAdd\":\"2018-03-09 08:15:15\",\"dateUpdate\":\"2018-06-06 13:21:57\",\"id\":5480,\"linkUrl\":\"\",\"paixu\":15,\"picUrl\":\"https://cdn.it120.cc/apifactory/2018/03/07/7b46e8454f97c96ae38cd5296c983143.png\",\"remark\":\"\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"兑换礼券\",\"type\":\"duihuan\",\"userId\":797}]");
        }

        return null;
    }


    //滚动图片
    @GetMapping("/slide-container")
    public List<SlideContainer> slideContainer(@RequestParam(required = false) SlideContainerType type){
        return bannerService.slideContainer(type);
    }

    //签到、礼券按钮栏
    @GetMapping("/function-menus")
    public List<FunctionMenus> functionMenus(){
        return bannerService.functionMenus();
    }

    //人气推荐商品
    @GetMapping("/topgoods")
    public Page<BasicInfo> topgoods(Pageable pageable){
        return goodsService.topgoods(pageable);
    }

    //特惠拼团
    @GetMapping("/toptuan")
    public Page<BasicInfo> toptuan(Pageable pageable){
        return goodsService.toptuan(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBanner(@RequestBody CreateBannerCommand command){
        bannerService.createBanner(command.getGoodsId(), command.getIndex(), command.getPicUrl(), command.getType());
    }

}
