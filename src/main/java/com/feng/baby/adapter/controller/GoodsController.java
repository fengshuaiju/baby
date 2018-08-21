package com.feng.baby.adapter.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.feng.baby.application.representation.BasicInfo;
import com.feng.baby.application.representation.Category;
import com.feng.baby.application.representation.PintuanInfo;
import com.feng.baby.application.representation.PintuanUsers;
import com.feng.baby.application.service.GoodsService;
import com.feng.baby.application.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

    //商品列表
    //参数名	数据类型	备注	必填
    //page	int	获取第几页数据，不传该参数默认为1	X
    //pageSize	int	每页获取多少条数据，不传该参数默认为50	X
    //shopId	int	获取指定店铺的商品数据，不传获取全部商品；0获取未归类店铺商品；其他数字为指定的店铺编号下的商品	X
    //categoryId	int	获取指定分类下的商品	X
    //recommendStatus	int	推荐状态：不传该参数获取所有商品；0为一般商品；1为推荐商品	X
    //nameLike	String	商品名称关键词模糊搜索	X
    //barCode	String	商品条码	X
    //orderBy	String	排序规则：priceUp 商品升序，priceDown 商品倒序，ordersUp 销量升序，ordersDown 销量降序	X
    //pingtuan	Boolean	true 为拉取支持拼团的商品	X
//    @GetMapping("/list")
//    public JSON list(@RequestParam(required = false) Integer page,
//                     @RequestParam(required = false) Integer pageSize,
//                     @RequestParam(required = false) Integer shopId,
//                     @RequestParam(required = false) Integer categoryId,
//                     @RequestParam(required = false) Integer recommendStatus,
//                     @RequestParam(required = false) String nameLike,
//                     @RequestParam(required = false) String barCode,
//                     @RequestParam(required = false) String orderBy,
//                     @RequestParam(required = false) Boolean pingtuan) {
//        return JSONObject.parseArray("[{\"barCode\":\"\",\"categoryId\":10450,\"characteristic\":\"全场模版使用优惠券立减88元\",\"commission\":0,\"commissionType\":0,\"dateAdd\":\"2018-04-19 13:02:49\",\"dateStart\":\"2018-04-19 12:57:19\",\"dateUpdate\":\"2018-08-07 19:25:07\",\"id\":43223,\"logisticsId\":1273,\"minPrice\":299,\"minScore\":0,\"name\":\"清欢素雅小程序端模版（API工厂授权版）\",\"numberFav\":27,\"numberGoodReputation\":15,\"numberOrders\":251,\"originalPrice\":550,\"paixu\":0,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/18/14569682d80bf52cd8ff4c3c116758a7.png\",\"pingtuan\":false,\"pingtuanPrice\":289,\"propertyIds\":\",5420,\",\"recommendStatus\":1,\"recommendStatusStr\":\"推荐\",\"shopId\":755,\"status\":0,\"statusStr\":\"上架\",\"stores\":92,\"userId\":797,\"videoId\":\"\",\"views\":11078,\"weight\":0},{\"barCode\":\"\",\"categoryId\":10450,\"characteristic\":\"全场模版使用优惠券立减88元\",\"commission\":0,\"commissionType\":0,\"dateAdd\":\"2018-04-12 10:51:05\",\"dateStart\":\"2018-04-12 10:36:58\",\"dateUpdate\":\"2018-08-07 19:25:07\",\"id\":40601,\"logisticsId\":1273,\"minPrice\":399,\"minScore\":0,\"name\":\"清欢食光机Plus小程序端模版（API工厂授权版）\",\"numberFav\":27,\"numberGoodReputation\":1,\"numberOrders\":268,\"originalPrice\":999,\"paixu\":0,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/12/42c001a698072b3bae9ac71f65ca2cfc.jpg\",\"pingtuan\":false,\"pingtuanPrice\":389,\"propertyIds\":\",5420,\",\"recommendStatus\":1,\"recommendStatusStr\":\"推荐\",\"shopId\":755,\"status\":0,\"statusStr\":\"上架\",\"stores\":100,\"userId\":797,\"videoId\":\"\",\"views\":10493,\"weight\":0},{\"barCode\":\"\",\"categoryId\":10450,\"characteristic\":\"全场模版使用优惠券立减88元\",\"commission\":10,\"commissionType\":0,\"dateAdd\":\"2018-03-15 14:15:56\",\"dateStart\":\"2018-03-15 14:03:47\",\"dateUpdate\":\"2018-08-07 19:25:07\",\"id\":30164,\"logisticsId\":1273,\"minPrice\":299,\"minScore\":0,\"name\":\"清欢严选商城小程序端模版（API工厂授权版）\",\"numberFav\":105,\"numberGoodReputation\":100,\"numberOrders\":326,\"originalPrice\":699,\"paixu\":0,\"pic\":\"https://cdn.it120.cc/apifactory/2018/05/19/84833eee6df34fa550cd7644b2242cf5.png\",\"pingtuan\":true,\"pingtuanPrice\":289,\"propertyIds\":\",5420,3688,\",\"recommendStatus\":1,\"recommendStatusStr\":\"推荐\",\"shopId\":755,\"status\":0,\"statusStr\":\"上架\",\"stores\":100,\"userId\":797,\"videoId\":\"\",\"views\":28721,\"weight\":0},{\"barCode\":\"\",\"categoryId\":10451,\"characteristic\":\"100%全棉，椰林自然设计\",\"commission\":10,\"commissionType\":1,\"dateAdd\":\"2018-04-04 13:18:25\",\"dateStart\":\"2018-04-04 13:10:36\",\"dateUpdate\":\"2018-08-07 18:41:08\",\"id\":36888,\"logisticsId\":1273,\"minPrice\":299,\"minScore\":0,\"name\":\"唤自然 仲夏椰香四件套\",\"numberFav\":61,\"numberGoodReputation\":1,\"numberOrders\":131,\"originalPrice\":399,\"paixu\":1,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/0eaf91e4696b51e326313efaec5e9b11.jpg\",\"pingtuan\":false,\"pingtuanPrice\":99,\"recommendStatus\":1,\"recommendStatusStr\":\"推荐\",\"shopId\":755,\"status\":0,\"statusStr\":\"上架\",\"stores\":38,\"userId\":797,\"videoId\":\"\",\"views\":8668,\"weight\":0}]");
//    }

    //获取商品详情接口
    //参数名	数据类型	备注	必填
    //id	int	商品编号	Y
    @GetMapping("/detail")
    public JSONObject detail(@RequestParam(required = false) String goodsId) {
        return JSONObject.parseObject(JSON.toJSONString(goodsService.goodsDetails(goodsId)));
    }

    //选择规格和尺寸获取商品价格
    //参数名	数据类型	备注	必填
    //goodsId	int	商品编号	Y
    //propertyChildIds	String	选择的规格尺寸信息：如：4:15,2:10,1:4 。多个规格请用英文的逗号分割，4:15 中的 4 获取代表颜色，15 或许代表 土豪金	Y
    @GetMapping("/price")
    public JSON price(@RequestParam String goodsId, @RequestParam String propertyChildIds) {
        return JSONObject.parseObject("{\"goodsId\":30164,\"id\":491964,\"originalPrice\":1999,\"pingtuanPrice\":789,\"price\":799,\"propertyChildIds\":\"5420:18212,3688:12332,\",\"score\":0,\"stores\":98,\"userId\":797}");
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


    //////////////砍价////////////////////////

    //帮忙砍价信息
    //参数名	数据类型	备注	必填
    //token	String	登录接口返回的登录凭证	Y
    //kjid	int	砍价ID	Y
    //joinerUser	int	砍价参与用户ID	Y
    @GetMapping("/kanjia/myHelp")
    public String kanjiaMyHelp(@RequestParam int kjid,
                               @RequestParam int joinerUser) {
        boolean 未帮忙砍价 = false;

        if (未帮忙砍价) {
            return "{\"code\":700,\"msg\":\"暂无数据\"}";
        } else {
            return "{\"code\":0,\"data\":{\"cutPrice\":14.77,\"goodsId\":1},\"msg\":\"success\"}";
        }
    }

    //获取砍价详情
    //参数名	数据类型	备注	必填
    //kjid	int	砍价ID	Y
    //joiner	int	参与者ID	Y
    @GetMapping("/kanjia/info")
    public String kanjiaInfo(@RequestParam int kjid,
                             @RequestParam int joinerUser) {
        return "{\"code\":0,\"data\":{\"kanjiaInfo\":{\"curPrice\":985.23,\"dateAdd\":\"2018-04-01 08:47:29\",\"dateUpdate\":\"2018-04-01 16:36:41\",\"goodsId\":1,\"helpNumber\":1,\"kjId\":2,\"minPrice\":100,\"status\":0,\"statusStr\":\"进行中\",\"uid\":4},\"joiner\":{\"nick\":\"test\"},\"helps\":[{\"nick\":\"test\",\"dateAdd\":\"2018-04-01 16:36:41\",\"remark\":\"收\",\"cutPrice\":14.77}]},\"msg\":\"success\"}";
    }

    //加入砍价
    //参数名	数据类型	备注	必填
    //kjid	int	砍价设置ID	Y
    //token	String	登录接口返回的登录凭证	Y
    @GetMapping("/kanjia/join")
    public String kanjiaJoin(@RequestParam int kjid) {
        return "{\"code\":0,\"data\":{\"curPrice\":3,\"dateAdd\":\"2018-04-01 08:47:29\",\"dateUpdate\":\"2018-04-01 08:47:29\",\"goodsId\":1,\"helpNumber\":0,\"kjId\":2,\"minPrice\":4,\"status\":0},\"msg\":\"success\"}";
    }

    //我的砍价
    //参数名	数据类型	备注	必填
    //kjid	int	砍价ID	Y
    //token	String	登录接口返回的凭证	Y
    @GetMapping("/kanjia/my")
    public String kanjiaMy(@RequestParam String kjid) {
        Boolean 参与砍价 = false;

        if (参与砍价) {
            return "{\"code\":0,\"data\":{\"curPrice\":3.00,\"goodsId\":1,\"id\":1,\"kjId\":2,\"minPrice\":4.00},\"msg\":\"success\"}\n";
        } else {
            return "{\"code\":700,\"msg\":\"暂无数据\"}\n";
        }
    }

    //帮人砍一刀
    //参数名	数据类型	备注	必填
    //token	String	登录接口返回的登录凭证	Y
    //kjid	int	砍价ID	Y
    //joinerUser	int	砍价参与用户ID	Y
    //remark	String	砍价留言，选填项	X
    @GetMapping("/kanjia/help")
    public String kanjiaHelp(@RequestParam int kjid,
                             @RequestParam int joinerUser) {
        return "{\"code\":0,\"data\":{\"cutPrice\":14.77,\"goodsId\":1},\"msg\":\"success\"}";
    }


    //获取砍价信息
    //请求参数说明:
    //参数名	数据类型	备注	必填
    //page	int	获取第几页数据，默认1	X
    //pageSize	int	每页显示多少数据，默认50	X
    @GetMapping("/kanjia/list")
    public JSONObject kanjiaList(Pageable pageable) {
        //return JSONObject.parseObject("{\"code\":0,\"data\":{\"result\":[{\"dateAdd\":\"2018-03-31 20:09:16\",\"dateEnd\":\"2018-08-31 12:00:00\",\"goodsId\":1,\"id\":2,\"minPrice\":4,\"number\":2,\"originalPrice\":3}],\"totalRow\":1,\"totalPage\":1},\"msg\":\"success\"}");
        //return JSONObject.parseObject("{\"code\":700,\"msg\":\"暂无数据\"}");
        return JSONObject.parseObject("{\"result\":[{\"dateAdd\":\"2018-05-10 12:40:35\",\"dateEnd\":\"2018-08-31 12:00:00\",\"goodsId\":38759,\"id\":149,\"minPrice\":99,\"number\":18,\"numberBuy\":8,\"originalPrice\":359},{\"dateAdd\":\"2018-05-10 12:40:05\",\"dateEnd\":\"2018-08-31 12:00:00\",\"goodsId\":38772,\"id\":148,\"minPrice\":299,\"number\":68,\"numberBuy\":6,\"originalPrice\":399},{\"dateAdd\":\"2018-05-10 12:39:23\",\"dateEnd\":\"2018-08-31 12:00:00\",\"goodsId\":38932,\"id\":147,\"minPrice\":79,\"number\":100,\"numberBuy\":3,\"originalPrice\":259}],\"totalRow\":3,\"totalPage\":1}");
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


    ///////////拼团/////////

    //加入拼团
    //参数名	数据类型	备注	必填
    //tuanId	int	团号	Y
    @GetMapping("/pingtuan/joiner")
    public void pingtuanJoiner(@RequestParam int tuanId) {

    }

    //开团
    //参数名	数据类型	备注	必填
    //token	String	登录接口返回的登录凭证	Y
    //goodsId	int	商品编号	Y
    @GetMapping("/pingtuan/open")
    public String pingtuanOpen(@RequestParam int goodsId) {
        return "{\"code\":0,\"data\":{\"dateAdd\":\"2018-04-28 08:11:13\",\"dateEnd\":\"2018-04-29 08:11:14\",\"dateUpdate\":\"2018-04-28 08:11:13\",\"goodsId\":3938,\"helpNumber\":0,\"id\":1,\"pingtuanId\":2,\"status\":0,\"statusStr\":\"进行中\"},\"msg\":\"success\"}";
    }

    //获取拼团信息
    @GetMapping("/pingtuan/info")
    public PintuanInfo pingtuanInfo(@RequestParam String goodsId) {
        return goodsService.pingtuanInfo(goodsId);
//            return JSONObject.parseObject("{\"dateAdd\":\"2018-05-03 21:09:16\",\"dateEnd\":\"2018-10-31 12:00:00\",\"id\":12,\"numberDoing\":0,\"numberPersion\":2,\"numberSucccess\":579,\"refundType\":1,\"refundTypeStr\":\"原路退回\",\"status\":0,\"statusStr\":\"正常\",\"timeoutHours\":5}");
    }

    //某商品所有的进行中团购
    @GetMapping("/pingtuan/list")
    public List<PintuanUsers> pingtuanList(@RequestParam String goodsId) {
        return goodsService.pingtuanList(goodsId);
//        return JSONObject.parseArray("[{\"apiExtUser\":{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/0GSxicfbjp6foicbXqbcbbBbCrDOgEInAhqZwATQ69LpvTia5oibN6T96rs9nib5CYkgvrEdq7ibwNZMiadmOtzqALjFg/0\",\"nick\":\"Kutche\"},\"dateAdd\":\"2018-05-02 13:04:22\",\"dateEnd\":\"2018-05-03 13:04:22\",\"helpNumber\":1,\"id\":3,\"uid\":332591},{\"apiExtUser\":{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/XOqGlHkydicVWUW5OjnvtuoJ5uDg70Bz0xiaoQRwM6h6BF74C9JRZhaIzxS7RjYrDu8VVHAE6ASCrCm2SXzQT7EA/0\",\"nick\":\"Apollo&丸子君\"},\"dateAdd\":\"2018-05-02 13:01:37\",\"dateEnd\":\"2018-05-03 13:01:37\",\"helpNumber\":2,\"id\":2,\"uid\":319056}]");
    }


    //同款推荐商品
    @GetMapping("/similar/recommend")
    public Page<BasicInfo> similar(@RequestParam Integer categoryId, Pageable pageable){
        return goodsService.similar(categoryId, pageable);
    }

    //猜你喜欢

}