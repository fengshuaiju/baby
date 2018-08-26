package com.feng.baby.adapter.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.feng.baby.application.representation.BasicInfo;
import com.feng.baby.application.representation.Category;
import com.feng.baby.application.service.CategoryService;
import com.feng.baby.application.service.GoodsService;
import com.feng.baby.model.GoodPriceType;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by fengshuaiju on 2018-06-29.
 */
@Slf4j
@RestController
@RequestMapping("/shop/goods")
public class GoodsController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GoodsService goodsService;

    //商品类别无限级接口
    @GetMapping("/category/all")
    public List<Category> categoryAll() {
        return categoryService.allTypes();
//        return JSONObject.parseArray("[{\"dateAdd\":\"2018-04-04 12:46:54\",\"icon\":\"\",\"id\":10450,\"isUse\":true,\"key\":\"1\",\"level\":1,\"name\":\"居家生活\",\"paixu\":1,\"pid\":0,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:47:47\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/05/24/772862baa0197b71c5eee745542c956f.png\",\"id\":10451,\"isUse\":true,\"key\":\"2\",\"level\":2,\"name\":\"床品\",\"paixu\":2,\"pid\":10450,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:48:20\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/05/24/fd91b4091346a46acdabe22712a969c4.png\",\"id\":10452,\"isUse\":true,\"key\":\"3\",\"level\":2,\"name\":\"布艺\",\"paixu\":3,\"pid\":10450,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:48:53\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/05/24/4d951246d110116e16ca028437664a27.png\",\"id\":10453,\"isUse\":true,\"key\":\"4\",\"level\":2,\"name\":\"收纳\",\"paixu\":4,\"pid\":10450,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:49:27\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/f8a757674a02ed90bd7be8f20302d043.png\",\"id\":10454,\"isUse\":true,\"key\":\"5\",\"level\":2,\"name\":\"宠物\",\"paixu\":5,\"pid\":10450,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:50:48\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/9657ee1e7cff3c65b696b05dc9ff5ad2.png\",\"id\":10455,\"isUse\":true,\"key\":\"6\",\"level\":2,\"name\":\"装饰\",\"paixu\":6,\"pid\":10450,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:51:25\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/ccbb08b5dec9146e69bad924516bbe43.png\",\"id\":10456,\"isUse\":true,\"key\":\"7\",\"level\":2,\"name\":\"家具\",\"paixu\":7,\"pid\":10450,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:52:47\",\"icon\":\"\",\"id\":10457,\"isUse\":true,\"key\":\"2\",\"level\":1,\"name\":\"配件装饰\",\"paixu\":2,\"pid\":0,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:53:39\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/9b48f6a3c770cdc91cebe594d1c9dc9c.png\",\"id\":10458,\"isUse\":true,\"key\":\"1\",\"level\":2,\"name\":\"男包\",\"paixu\":1,\"pid\":10457,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:53:57\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/f47c4a127a2252fb7ddda391fa439bfa.png\",\"id\":10459,\"isUse\":true,\"key\":\"2\",\"level\":2,\"name\":\"女包\",\"paixu\":2,\"pid\":10457,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:55:00\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/6ba34412fdbb97a11346c36545b1e946.png\",\"id\":10460,\"isUse\":true,\"key\":\"3\",\"level\":2,\"name\":\"围巾\",\"paixu\":3,\"pid\":10457,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:55:21\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/ba9b544de8f486ebb3ba4044d77ff323.png\",\"id\":10461,\"isUse\":true,\"key\":\"4\",\"level\":2,\"name\":\"拖鞋\",\"paixu\":4,\"pid\":10457,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:55:41\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/64237e0b117f7880a8b711ce72e32bf2.png\",\"id\":10462,\"isUse\":true,\"key\":\"5\",\"level\":2,\"name\":\"眼镜\",\"paixu\":5,\"pid\":10457,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 13:02:01\",\"icon\":\"\",\"id\":10463,\"isUse\":true,\"key\":\"3\",\"level\":1,\"name\":\"新品服装\",\"paixu\":3,\"pid\":0,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 13:03:07\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/f236825564bc5a27becdf26fa856782e.png\",\"id\":10464,\"isUse\":true,\"key\":\"1\",\"level\":2,\"name\":\"衬衫\",\"paixu\":1,\"pid\":10463,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 13:03:51\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/d0353c59382cbd8a6ff7c0e7d365b813.png\",\"id\":10465,\"isUse\":true,\"key\":\"2\",\"level\":2,\"name\":\"T恤\",\"paixu\":2,\"pid\":10463,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 13:04:19\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/70f0ab3b4d26c3da3e42a65e4ce0fcac.png\",\"id\":10466,\"isUse\":true,\"key\":\"3\",\"level\":2,\"name\":\"卫衣\",\"paixu\":3,\"pid\":10463,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 13:05:18\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/33f86e8983a60ca971e1a5f3d7c78bb4.png\",\"id\":10467,\"isUse\":true,\"key\":\"4\",\"level\":2,\"name\":\"针织\",\"paixu\":4,\"pid\":10463,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 13:06:08\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/982ab7b5cdd9c11b22d31c39429e190d.png\",\"id\":10468,\"isUse\":true,\"key\":\"5\",\"level\":2,\"name\":\"内衣\",\"paixu\":5,\"pid\":10463,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 13:06:44\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/a59e6679df4618800d74515d29b8267c.png\",\"id\":10469,\"isUse\":true,\"key\":\"6\",\"level\":2,\"name\":\"内裤\",\"paixu\":6,\"pid\":10463,\"type\":\"\",\"userId\":797}]");
    }


    //获取商品详情接口
    //参数名	数据类型	备注	必填
    //id	int	商品编号	Y
    @GetMapping("/detail")
    public JSONObject detail(@RequestParam(required = false) String goodsId) {
        return JSONObject.parseObject(JSON.toJSONString(goodsService.goodsDetails(goodsId)));
    }

    //计算价格
    @GetMapping("/price")
    public Map<String, Double> price(@RequestParam String goodsId, @RequestParam String propertyChildIds,
                      @RequestParam GoodPriceType shopType) {

        propertyChildIds = Arrays.asList(propertyChildIds.split(":")).stream().sorted(String::compareTo).collect(Collectors.joining(";"));

        return goodsService.getPrice(goodsId, propertyChildIds, shopType);

        //return JSONObject.parseObject("{\"goodsId\":30164,\"id\":491964,\"originalPrice\":1999,\"pingtuanPrice\":789,\"price\":799,\"propertyChildIds\":\"5420:18212,3688:12332,\",\"score\":0,\"stores\":98,\"userId\":797}");
    }


    //获取物流费用接口
    //参数名	数据类型	备注	必填
    //templateId	int	运费模板编号，可通过商品列表、商品详情接口获取	Y
    //type	int	快递方式：0 快递 1 EMS 2 平邮	Y
    //provinceId	int	用户省份编号	X
    //cityId	int	用户城市编号	X
    //districtId	int	用户区县编号	X
    @GetMapping("/price/freight")
    public String freight(@RequestParam int templateId,
                          @RequestParam int type,
                          @RequestParam(required = false) int provinceId,
                          @RequestParam(required = false) int cityId,
                          @RequestParam(required = false) int districtId) {
        return "{\"code\":0,\"data\":{\"firstNumber\":9,\"addAmount\":12,\"firstAmount\":10,\"addNumber\":11},\"msg\":\"success\"}";
    }

    //商品评价
    //    参数名	数据类型	备注	必填
    //    goodsId	int	商品编号数字id	Y
    //    page	int	获取第几页数据，不传默认为1	X
    //    pageSize	int	每页显示多少条数据，不传默认50	X
    @GetMapping("/reputation")
    public JSON reputation(@RequestParam int goodsId,
                           Pageable page) {
        return JSONObject.parseArray("[{\"goods\":{\"amount\":699,\"dateReputation\":\"2018-08-04 13:20:00\",\"goodReputation\":2,\"goodReputationRemark\":\"系统默认好评\",\"goodReputationStr\":\"好评\",\"goodsId\":30164,\"goodsName\":\"清欢严选商城小程序端模版（API工厂授权版）\",\"id\":143452,\"number\":1,\"orderId\":129093,\"pic\":\"https://cdn.it120.cc/apifactory/2018/05/19/84833eee6df34fa550cd7644b2242cf5.png\",\"property\":\"选择版本:开发版（未加密版本）,选择服务:不要服务\",\"score\":0,\"uid\":479628,\"userId\":797},\"user\":{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqauia5D89LQ2ibFteJJibxtlIdibmubJwAvNJVtqZia8BcuZXGKT30Re5GR890Se5hGp3qxZnI0ByEV6A/132\",\"city\":\"Ningbo\",\"dateAdd\":\"2018-07-20 00:08:21\",\"dateLogin\":\"2018-07-27 22:33:16\",\"id\":479628,\"ipAdd\":\"58.39.4.73\",\"ipLogin\":\"124.160.218.153\",\"isIdcardCheck\":false,\"nick\":\"烧不死的鸟\",\"province\":\"Zhejiang\",\"source\":0,\"sourceStr\":\"小程序\",\"status\":0,\"statusStr\":\"默认\"}},{\"goods\":{\"amount\":299,\"dateReputation\":\"2018-08-02 17:20:00\",\"goodReputation\":2,\"goodReputationRemark\":\"系统默认好评\",\"goodReputationStr\":\"好评\",\"goodsId\":30164,\"goodsName\":\"清欢严选商城小程序端模版（API工厂授权版）\",\"id\":142978,\"number\":1,\"orderId\":128654,\"pic\":\"https://cdn.it120.cc/apifactory/2018/05/19/84833eee6df34fa550cd7644b2242cf5.png\",\"property\":\"选择版本:授权版（加密版本）,选择服务:不要服务\",\"score\":0,\"uid\":440164,\"userId\":797},\"user\":{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epdCL3iarl80qbBCyU1yb5CVGzgfw60vKq3RUwUwkKdibuIJ7aAibCQZBFfVjNhYrG6tiaqiadvzWvCkQg/132\",\"city\":\"Datong\",\"dateAdd\":\"2018-06-20 18:43:01\",\"dateLogin\":\"2018-07-25 14:23:15\",\"id\":440164,\"ipAdd\":\"221.218.168.106\",\"ipLogin\":\"223.20.70.155\",\"isIdcardCheck\":false,\"nick\":\"\uD83D\uDC7F林大爷\uD83D\uDE08\",\"province\":\"Shanxi\",\"source\":0,\"sourceStr\":\"小程序\",\"status\":0,\"statusStr\":\"默认\"}},{\"goods\":{\"amount\":699,\"dateReputation\":\"2018-08-02 15:20:00\",\"goodReputation\":2,\"goodReputationRemark\":\"系统默认好评\",\"goodReputationStr\":\"好评\",\"goodsId\":30164,\"goodsName\":\"清欢严选商城小程序端模版（API工厂授权版）\",\"id\":142955,\"number\":1,\"orderId\":128632,\"pic\":\"https://cdn.it120.cc/apifactory/2018/05/19/84833eee6df34fa550cd7644b2242cf5.png\",\"property\":\"选择版本:开发版（未加密版本）,选择服务:不要服务\",\"score\":0,\"uid\":473308,\"userId\":797},\"user\":{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/vicPQEWfsMEL4Ak4710UevZm6q1g7CBWaaNmeDfdfJFglOucambtIW16eAoicBAb3krBEj99RVoXPz6f3fGd5VicQ/132\",\"city\":\"Wuhan\",\"dateAdd\":\"2018-07-15 15:28:26\",\"dateLogin\":\"2018-07-27 09:13:36\",\"id\":473308,\"ipAdd\":\"14.127.249.250\",\"ipLogin\":\"112.97.59.146\",\"isIdcardCheck\":false,\"nick\":\"彭雪峰\",\"province\":\"Hubei\",\"source\":0,\"sourceStr\":\"小程序\",\"status\":0,\"statusStr\":\"默认\"}},{\"goods\":{\"amount\":299,\"dateReputation\":\"2018-07-31 21:20:00\",\"goodReputation\":2,\"goodReputationRemark\":\"系统默认好评\",\"goodReputationStr\":\"好评\",\"goodsId\":30164,\"goodsName\":\"清欢严选商城小程序端模版（API工厂授权版）\",\"id\":142506,\"number\":1,\"orderId\":128209,\"pic\":\"https://cdn.it120.cc/apifactory/2018/05/19/84833eee6df34fa550cd7644b2242cf5.png\",\"property\":\"选择版本:授权版（加密版本）,选择服务:不要服务\",\"score\":0,\"uid\":476371,\"userId\":797},\"user\":{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqJVZ7GAyickbcvHPc0cac9jeSajCmxVhLKevLBYibN1L7dWDYVHX9AI3vvKqian4lqW6j0YKaHRK4hQ/132\",\"city\":\"Shenzhen\",\"dateAdd\":\"2018-07-17 13:47:41\",\"dateLogin\":\"2018-07-19 14:58:28\",\"id\":476371,\"ipAdd\":\"113.104.193.107\",\"ipLogin\":\"113.104.192.220\",\"isIdcardCheck\":false,\"nick\":\"AAA 王老吉 - 小程序搜索数码黑市\",\"province\":\"Guangdong\",\"source\":0,\"sourceStr\":\"小程序\",\"status\":0,\"statusStr\":\"默认\"}},{\"goods\":{\"amount\":699,\"dateReputation\":\"2018-07-28 23:10:47\",\"goodReputation\":2,\"goodReputationRemark\":\"非常愉快的一次购物！\",\"goodReputationStr\":\"好评\",\"goodsId\":30164,\"goodsName\":\"清欢严选商城小程序端模版（API工厂授权版）\",\"id\":144727,\"number\":1,\"orderId\":130318,\"pic\":\"https://cdn.it120.cc/apifactory/2018/05/19/84833eee6df34fa550cd7644b2242cf5.png\",\"property\":\"选择版本:开发版（未加密版本）,选择服务:不要服务\",\"score\":0,\"uid\":409613,\"userId\":797},\"user\":{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKF4iaHDMSx6icLHonC7Bs0zJyEc9xqKRHX9j2BLXpP0yhM7woSxlPRoLb8iaib2K0zh2f80QFZKlGJMQ/132\",\"city\":\"Fuzhou\",\"dateAdd\":\"2018-05-30 10:41:36\",\"dateLogin\":\"2018-08-07 14:37:29\",\"id\":409613,\"ipAdd\":\"120.40.86.200\",\"ipLogin\":\"111.147.216.211\",\"isIdcardCheck\":false,\"nick\":\"蒋佳龙\",\"province\":\"Fujian\",\"source\":0,\"sourceStr\":\"小程序\",\"status\":0,\"statusStr\":\"默认\"}},{\"goods\":{\"amount\":699,\"dateReputation\":\"2018-07-27 10:20:00\",\"goodReputation\":2,\"goodReputationRemark\":\"系统默认好评\",\"goodReputationStr\":\"好评\",\"goodsId\":30164,\"goodsName\":\"清欢严选商城小程序端模版（API工厂授权版）\",\"id\":141092,\"number\":1,\"orderId\":126867,\"pic\":\"https://cdn.it120.cc/apifactory/2018/05/19/84833eee6df34fa550cd7644b2242cf5.png\",\"property\":\"选择版本:开发版（未加密版本）,选择服务:不要服务\",\"score\":0,\"uid\":393611,\"userId\":797},\"user\":{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83erSEPq6PFPicKkFsgvnK8mgOrnKgYicQS24pgs3b362IuELD8upkh0W7UbnCI6z1HEvl2hvfOII6BIg/132\",\"city\":\"\",\"dateAdd\":\"2018-05-21 15:08:09\",\"dateLogin\":\"2018-07-30 13:58:49\",\"id\":393611,\"ipAdd\":\"180.169.134.134\",\"ipLogin\":\"180.97.201.17\",\"isIdcardCheck\":false,\"nick\":\"Anla® stackoverflow from dayday\",\"province\":\"\",\"source\":0,\"sourceStr\":\"小程序\",\"status\":0,\"statusStr\":\"默认\"}}]");
    }


    /////////////收藏///////////


    //添加收藏
    //参数名	数据类型	备注	必填
    //token	String	调用登录接口获取的登录凭证	Y
    //goodsId	int	收藏的商品编号	Y
    @GetMapping("/fav/add")
    public String favAdd(@RequestParam int goodsId) {
        return "{\"code\":0,\"msg\":\"success\"}";
    }

    //删除收藏
    //参数名	数据类型	备注	必填
    //token	String	调用登录接口获取的登录凭证	Y
    //goodsId	int	id 和 goodsId 参数至少传一个	X
    //id	int	id 和 goodsId 参数至少传一个	X
    @GetMapping("/fav/delete")
    public String favDelete(@RequestParam int goodsId) {
        return "{\"code\":0,\"msg\":\"success\"}";
    }

    //获取我的收藏列别
    //    参数名	数据类型	备注	必填
    //    token	String	调用登录接口返回的登录凭证	Y
    //    page	int	获取第几页的数据，不传默认为1	X
    //    pageSize	int	每页显示多少条数据，不传默认50	X
    //    nameLike	String	商品标题模糊搜索关键词	X
    @GetMapping("/fav/list")
    public String favList(@RequestParam(required = false) String nameLike) {
        return "{\"code\":0,\"data\":[{\"dateAdd\":\"2017-03-31 10:35:30\",\"goodsId\":11,\"goodsName\":\"无物流无规格商品测试\",\"id\":1,\"pic\":\"https://cdn.it120.cc/apifactory/2017/03/27/dce24d7c6f0f6e8256fdbf9c43b84d9e.jpeg\",\"uid\":4,\"userId\":2}],\"msg\":\"success\"}";
    }


    @GetMapping("/fav/check")
    public Map<String, Boolean> favCheck(@RequestParam String goodsId) {
        return goodsService.checkFav(goodsId);
    }


    //同款推荐商品
    @GetMapping("/similar/recommend")
    public Page<BasicInfo> similar(@RequestParam Integer categoryId, Pageable pageable){
        return goodsService.similar(categoryId, pageable);
    }

    //猜你喜欢

}