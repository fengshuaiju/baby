package com.feng.baby.adapter.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.feng.baby.application.command.CouponsRepresentation;
import com.feng.baby.application.representation.FunctionMenus;
import com.feng.baby.application.representation.SlideContainer;
import com.feng.baby.application.service.BannerService;
import com.feng.baby.application.service.DiscountsService;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by fengshuaiju on 2018-06-29.
 */
@Slf4j
@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @Autowired
    private DiscountsService discountsService;

    //App Banner管理接口
    //参数名	数据类型	备注	必填
    //type	String	Banner类型，后台自定义	X
    //key
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public JSON list(@RequestParam(required = false) String type, @RequestParam(required = false) String key){

//        //key=mallName&type=start
//        if("mallName".equals(key) && "start".equals(type)){
//            return JSONObject.parseArray("[{\"businessId\":30164,\"dateAdd\":\"2018-03-12 17:48:47\",\"dateUpdate\":\"2018-05-19 11:24:33\",\"id\":5581,\"linkUrl\":\"\",\"paixu\":0,\"picUrl\":\"https://cdn.it120.cc/apifactory/2018/05/19/4e72a11f1b291f4cacd72262ca6e96f0.png\",\"remark\":\"丸子君原创作品\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"清欢严选\",\"type\":\"start\",\"userId\":797}]");
//        }

//        //type=topLogo
//        if("topLogo".equals(type)){
//            return JSON.parseObject("{\"businessId\":0,\"dateAdd\":\"2018-05-11 00:11:41\",\"dateUpdate\":\"2018-05-13 01:08:29\",\"id\":8291,\"linkUrl\":\"\",\"paixu\":1,\"picUrl\":\"https://cdn.it120.cc/apifactory/2018/05/09/6b5df91e8a1eadae5dd9009ed18edde3.png\",\"remark\":\"\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"首页Logo\",\"type\":\"topLogo\",\"userId\":797}");
//        }

//        if("home".equals(type)){
//            return JSON.parseArray("[{\"businessId\":30164,\"dateAdd\":\"2018-05-10 18:50:18\",\"dateUpdate\":\"2018-05-13 22:02:21\",\"id\":8253,\"linkUrl\":\"\",\"paixu\":2,\"picUrl\":\"https://cdn.it120.cc/apifactory/2018/05/09/2e8638183135b207c97490ed95fb44ba.jpg\",\"remark\":\"\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"30164\",\"type\":\"home\",\"userId\":797},{\"businessId\":30164,\"dateAdd\":\"2018-05-10 18:49:55\",\"dateUpdate\":\"2018-05-13 22:02:27\",\"id\":8252,\"linkUrl\":\"\",\"paixu\":3,\"picUrl\":\"https://cdn.it120.cc/apifactory/2018/05/09/d1cbc05833c4fa09b1fae15593df1b63.jpg\",\"remark\":\"\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"30164\",\"type\":\"home\",\"userId\":797},{\"businessId\":30164,\"dateAdd\":\"2018-05-10 19:17:46\",\"dateUpdate\":\"2018-05-13 22:02:33\",\"id\":8255,\"linkUrl\":\"\",\"paixu\":4,\"picUrl\":\"https://cdn.it120.cc/apifactory/2018/05/09/dc11f00add7f97ee549b41b97134fe65.jpg\",\"remark\":\"\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"30164\",\"type\":\"home\",\"userId\":797},{\"businessId\":30164,\"dateAdd\":\"2018-05-10 19:18:06\",\"dateUpdate\":\"2018-05-13 22:02:38\",\"id\":8256,\"linkUrl\":\"\",\"paixu\":5,\"picUrl\":\"https://cdn.it120.cc/apifactory/2018/05/09/62c5fb354ced6e13c06d554cde479679.jpg\",\"remark\":\"\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"30164\",\"type\":\"home\",\"userId\":797}]");
//        }

//        if("mallName".equals(key) && "sale".equals(type)){
//            return JSON.parseArray("[{\"businessId\":0,\"dateAdd\":\"2018-03-01 17:15:21\",\"dateUpdate\":\"2018-05-11 00:44:59\",\"id\":5296,\"linkUrl\":\"/pages/score/index\",\"paixu\":5,\"picUrl\":\"https://cdn.it120.cc/apifactory/2018/05/09/0630c87c94e2f1a4f213f7ffb5845e6d.png\",\"remark\":\"\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"签到\",\"type\":\"sale\",\"userId\":797},{\"businessId\":0,\"dateAdd\":\"2018-03-01 17:17:29\",\"dateUpdate\":\"2018-05-11 00:45:07\",\"id\":5297,\"linkUrl\":\"/pages/newcoupons/index\",\"paixu\":6,\"picUrl\":\"https://cdn.it120.cc/apifactory/2018/05/09/1ba413178d361771f25332ebd04f3bf7.png\",\"remark\":\"\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"礼券\",\"type\":\"sale\",\"userId\":797},{\"businessId\":0,\"dateAdd\":\"2018-03-01 17:19:13\",\"dateUpdate\":\"2018-05-14 17:48:52\",\"id\":5298,\"linkUrl\":\"/pages/kanjia-list/index\",\"paixu\":7,\"picUrl\":\"https://cdn.it120.cc/apifactory/2018/05/09/496a0c3e4042afbb688837358217f501.png\",\"remark\":\"\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"砍价\",\"type\":\"sale\",\"userId\":797},{\"businessId\":0,\"dateAdd\":\"2018-05-10 20:54:20\",\"dateUpdate\":\"2018-05-11 00:45:23\",\"id\":8262,\"linkUrl\":\"/pages/topic-list/index\",\"paixu\":8,\"picUrl\":\"https://cdn.it120.cc/apifactory/2018/05/09/88f45bf6e95ec010f1f945c414e6df03.png\",\"remark\":\"\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"专栏\",\"type\":\"sale\",\"userId\":797}]");
//        }

        //是否弹出领取优惠券窗口
//        if("mallName".equals(key) && "newcoupons".equals(type)){
//            return JSONObject.parseObject("{\"businessId\":2495,\"dateAdd\":\"2018-03-05 19:36:54\",\"dateUpdate\":\"2018-06-26 10:09:07\",\"id\":5385,\"linkUrl\":\"https://cdn.it120.cc/apifactory/2018/05/18/8b5875faf90d1b2fdc353dfbc5d6d1b3.png\",\"paixu\":0,\"picUrl\":\"https://cdn.it120.cc/apifactory/2018/06/26/f1e90deac271101c805f1db52f9ba5da.png\",\"remark\":\"\",\"status\":0,\"statusStr\":\"显示\",\"title\":\"优惠券弹窗\",\"type\":\"newcoupons\",\"userId\":797}");
//        }

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


    @GetMapping("/top-logo")
    public Map<String, String> topLogo(){
        return ImmutableMap.of(
               "picUrl", "https://cdn.it120.cc/apifactory/2018/05/09/6b5df91e8a1eadae5dd9009ed18edde3.png"
        );
    }

    @GetMapping("/slide-container")
    public List<SlideContainer> slideContainer(){
        return bannerService.slideContainer();
    }

    @GetMapping("/function-menus")
    public List<FunctionMenus> functionMenus(){
        return bannerService.functionMenus();
    }

    @GetMapping("/newcoupons")
    public CouponsRepresentation availableNewCoupons(@RequestParam String openId){
        return discountsService.availableNewCoupons(openId);
    }

}
