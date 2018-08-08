package com.feng.baby.adapter.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fengshuaiju on 2018-06-29.
 */
@Slf4j
@RestController
@RequestMapping("/shop/goods")
public class GoodsController {

    //商品类别无限级接口
    @GetMapping("/category/all")
    public JSON categoryAll(){
        return JSONObject.parseArray("[{\"dateAdd\":\"2018-04-04 12:46:54\",\"icon\":\"\",\"id\":10450,\"isUse\":true,\"key\":\"1\",\"level\":1,\"name\":\"居家生活\",\"paixu\":1,\"pid\":0,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:47:47\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/05/24/772862baa0197b71c5eee745542c956f.png\",\"id\":10451,\"isUse\":true,\"key\":\"2\",\"level\":2,\"name\":\"床品\",\"paixu\":2,\"pid\":10450,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:48:20\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/05/24/fd91b4091346a46acdabe22712a969c4.png\",\"id\":10452,\"isUse\":true,\"key\":\"3\",\"level\":2,\"name\":\"布艺\",\"paixu\":3,\"pid\":10450,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:48:53\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/05/24/4d951246d110116e16ca028437664a27.png\",\"id\":10453,\"isUse\":true,\"key\":\"4\",\"level\":2,\"name\":\"收纳\",\"paixu\":4,\"pid\":10450,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:49:27\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/f8a757674a02ed90bd7be8f20302d043.png\",\"id\":10454,\"isUse\":true,\"key\":\"5\",\"level\":2,\"name\":\"宠物\",\"paixu\":5,\"pid\":10450,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:50:48\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/9657ee1e7cff3c65b696b05dc9ff5ad2.png\",\"id\":10455,\"isUse\":true,\"key\":\"6\",\"level\":2,\"name\":\"装饰\",\"paixu\":6,\"pid\":10450,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:51:25\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/ccbb08b5dec9146e69bad924516bbe43.png\",\"id\":10456,\"isUse\":true,\"key\":\"7\",\"level\":2,\"name\":\"家具\",\"paixu\":7,\"pid\":10450,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:52:47\",\"icon\":\"\",\"id\":10457,\"isUse\":true,\"key\":\"2\",\"level\":1,\"name\":\"配件装饰\",\"paixu\":2,\"pid\":0,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:53:39\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/9b48f6a3c770cdc91cebe594d1c9dc9c.png\",\"id\":10458,\"isUse\":true,\"key\":\"1\",\"level\":2,\"name\":\"男包\",\"paixu\":1,\"pid\":10457,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:53:57\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/f47c4a127a2252fb7ddda391fa439bfa.png\",\"id\":10459,\"isUse\":true,\"key\":\"2\",\"level\":2,\"name\":\"女包\",\"paixu\":2,\"pid\":10457,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:55:00\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/6ba34412fdbb97a11346c36545b1e946.png\",\"id\":10460,\"isUse\":true,\"key\":\"3\",\"level\":2,\"name\":\"围巾\",\"paixu\":3,\"pid\":10457,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:55:21\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/ba9b544de8f486ebb3ba4044d77ff323.png\",\"id\":10461,\"isUse\":true,\"key\":\"4\",\"level\":2,\"name\":\"拖鞋\",\"paixu\":4,\"pid\":10457,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 12:55:41\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/64237e0b117f7880a8b711ce72e32bf2.png\",\"id\":10462,\"isUse\":true,\"key\":\"5\",\"level\":2,\"name\":\"眼镜\",\"paixu\":5,\"pid\":10457,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 13:02:01\",\"icon\":\"\",\"id\":10463,\"isUse\":true,\"key\":\"3\",\"level\":1,\"name\":\"新品服装\",\"paixu\":3,\"pid\":0,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 13:03:07\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/f236825564bc5a27becdf26fa856782e.png\",\"id\":10464,\"isUse\":true,\"key\":\"1\",\"level\":2,\"name\":\"衬衫\",\"paixu\":1,\"pid\":10463,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 13:03:51\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/d0353c59382cbd8a6ff7c0e7d365b813.png\",\"id\":10465,\"isUse\":true,\"key\":\"2\",\"level\":2,\"name\":\"T恤\",\"paixu\":2,\"pid\":10463,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 13:04:19\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/70f0ab3b4d26c3da3e42a65e4ce0fcac.png\",\"id\":10466,\"isUse\":true,\"key\":\"3\",\"level\":2,\"name\":\"卫衣\",\"paixu\":3,\"pid\":10463,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 13:05:18\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/33f86e8983a60ca971e1a5f3d7c78bb4.png\",\"id\":10467,\"isUse\":true,\"key\":\"4\",\"level\":2,\"name\":\"针织\",\"paixu\":4,\"pid\":10463,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 13:06:08\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/982ab7b5cdd9c11b22d31c39429e190d.png\",\"id\":10468,\"isUse\":true,\"key\":\"5\",\"level\":2,\"name\":\"内衣\",\"paixu\":5,\"pid\":10463,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-04-04 13:06:44\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/a59e6679df4618800d74515d29b8267c.png\",\"id\":10469,\"isUse\":true,\"key\":\"6\",\"level\":2,\"name\":\"内裤\",\"paixu\":6,\"pid\":10463,\"type\":\"\",\"userId\":797}]");
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
    @GetMapping("/list")
    public JSON list(@RequestParam(required = false) Integer page,
                     @RequestParam(required = false) Integer pageSize,
                     @RequestParam(required = false) Integer shopId,
                     @RequestParam(required = false) Integer categoryId,
                     @RequestParam(required = false) Integer recommendStatus,
                     @RequestParam(required = false) String nameLike,
                     @RequestParam(required = false) String barCode,
                     @RequestParam(required = false) String orderBy,
                     @RequestParam(required = false) Boolean pingtuan){
        return JSONObject.parseArray("[{\"barCode\":\"\",\"categoryId\":10450,\"characteristic\":\"全场模版使用优惠券立减88元\",\"commission\":0,\"commissionType\":0,\"dateAdd\":\"2018-04-19 13:02:49\",\"dateStart\":\"2018-04-19 12:57:19\",\"dateUpdate\":\"2018-08-07 19:25:07\",\"id\":43223,\"logisticsId\":1273,\"minPrice\":299,\"minScore\":0,\"name\":\"清欢素雅小程序端模版（API工厂授权版）\",\"numberFav\":27,\"numberGoodReputation\":15,\"numberOrders\":251,\"originalPrice\":550,\"paixu\":0,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/18/14569682d80bf52cd8ff4c3c116758a7.png\",\"pingtuan\":false,\"pingtuanPrice\":289,\"propertyIds\":\",5420,\",\"recommendStatus\":1,\"recommendStatusStr\":\"推荐\",\"shopId\":755,\"status\":0,\"statusStr\":\"上架\",\"stores\":92,\"userId\":797,\"videoId\":\"\",\"views\":11078,\"weight\":0},{\"barCode\":\"\",\"categoryId\":10450,\"characteristic\":\"全场模版使用优惠券立减88元\",\"commission\":0,\"commissionType\":0,\"dateAdd\":\"2018-04-12 10:51:05\",\"dateStart\":\"2018-04-12 10:36:58\",\"dateUpdate\":\"2018-08-07 19:25:07\",\"id\":40601,\"logisticsId\":1273,\"minPrice\":399,\"minScore\":0,\"name\":\"清欢食光机Plus小程序端模版（API工厂授权版）\",\"numberFav\":27,\"numberGoodReputation\":1,\"numberOrders\":268,\"originalPrice\":999,\"paixu\":0,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/12/42c001a698072b3bae9ac71f65ca2cfc.jpg\",\"pingtuan\":false,\"pingtuanPrice\":389,\"propertyIds\":\",5420,\",\"recommendStatus\":1,\"recommendStatusStr\":\"推荐\",\"shopId\":755,\"status\":0,\"statusStr\":\"上架\",\"stores\":100,\"userId\":797,\"videoId\":\"\",\"views\":10493,\"weight\":0},{\"barCode\":\"\",\"categoryId\":10450,\"characteristic\":\"全场模版使用优惠券立减88元\",\"commission\":10,\"commissionType\":0,\"dateAdd\":\"2018-03-15 14:15:56\",\"dateStart\":\"2018-03-15 14:03:47\",\"dateUpdate\":\"2018-08-07 19:25:07\",\"id\":30164,\"logisticsId\":1273,\"minPrice\":299,\"minScore\":0,\"name\":\"清欢严选商城小程序端模版（API工厂授权版）\",\"numberFav\":105,\"numberGoodReputation\":100,\"numberOrders\":326,\"originalPrice\":699,\"paixu\":0,\"pic\":\"https://cdn.it120.cc/apifactory/2018/05/19/84833eee6df34fa550cd7644b2242cf5.png\",\"pingtuan\":true,\"pingtuanPrice\":289,\"propertyIds\":\",5420,3688,\",\"recommendStatus\":1,\"recommendStatusStr\":\"推荐\",\"shopId\":755,\"status\":0,\"statusStr\":\"上架\",\"stores\":100,\"userId\":797,\"videoId\":\"\",\"views\":28721,\"weight\":0},{\"barCode\":\"\",\"categoryId\":10451,\"characteristic\":\"100%全棉，椰林自然设计\",\"commission\":10,\"commissionType\":1,\"dateAdd\":\"2018-04-04 13:18:25\",\"dateStart\":\"2018-04-04 13:10:36\",\"dateUpdate\":\"2018-08-07 18:41:08\",\"id\":36888,\"logisticsId\":1273,\"minPrice\":299,\"minScore\":0,\"name\":\"唤自然 仲夏椰香四件套\",\"numberFav\":61,\"numberGoodReputation\":1,\"numberOrders\":131,\"originalPrice\":399,\"paixu\":1,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/0eaf91e4696b51e326313efaec5e9b11.jpg\",\"pingtuan\":false,\"pingtuanPrice\":99,\"recommendStatus\":1,\"recommendStatusStr\":\"推荐\",\"shopId\":755,\"status\":0,\"statusStr\":\"上架\",\"stores\":38,\"userId\":797,\"videoId\":\"\",\"views\":8668,\"weight\":0}]");
    }

    //获取商品详情接口
    //参数名	数据类型	备注	必填
    //id	int	商品编号	Y
    @GetMapping("/detail")
    public JSONObject detail(@RequestParam(required = false) Integer id){
        //38759,38772,38932
        if(38759 == id){
            return JSONObject.parseObject("{\"logistics\":{\"isFree\":true,\"feeType\":0,\"feeTypeStr\":\"按件数\",\"details\":[]},\"extJson\":{},\"category\":{\"dateAdd\":\"2018-04-04 12:48:53\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/05/24/4d951246d110116e16ca028437664a27.png\",\"id\":10453,\"isUse\":true,\"key\":\"4\",\"name\":\"收纳\",\"paixu\":4,\"pid\":10450,\"type\":\"\",\"userId\":797},\"pics\":[{\"goodsId\":38759,\"id\":332924,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/10/8e544c0b26e53302969552c3308c1c1f.jpg\",\"userId\":797},{\"goodsId\":38759,\"id\":332925,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/10/36b4a9d8b5bbf08d427da644e32787d8.jpg\",\"userId\":797},{\"goodsId\":38759,\"id\":332926,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/10/c2592f048925c6a864d682a35825d32c.jpg\",\"userId\":797},{\"goodsId\":38759,\"id\":332927,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/10/7be52e5aa09d56c9b4565978a56c931b.jpg\",\"userId\":797}],\"content\":\"<p><img src=\\\"https://cdn.it120.cc/apifactory/2018/04/10/93d3f7cc67acfbd49d8185e87ed93846.jpg\\\" title=\\\"apifactory/2018/04/10/93d3f7cc67acfbd49d8185e87ed93846.jpg\\\" alt=\\\"5.jpg\\\"/></p>\",\"basicInfo\":{\"barCode\":\"\",\"categoryId\":10453,\"characteristic\":\"连盖收纳盒 大小组合装\",\"commission\":0,\"commissionType\":0,\"dateAdd\":\"2018-04-10 14:57:25\",\"dateStart\":\"2018-04-10 14:52:16\",\"dateUpdate\":\"2018-08-07 18:28:52\",\"id\":38759,\"logisticsId\":1273,\"minPrice\":0,\"minScore\":0,\"name\":\"连盖收纳盒两件组合装\",\"numberFav\":1,\"numberGoodReputation\":1,\"numberOrders\":247,\"originalPrice\":298,\"paixu\":9,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/10/8e544c0b26e53302969552c3308c1c1f.jpg\",\"pingtuan\":false,\"pingtuanPrice\":0,\"recommendStatus\":0,\"recommendStatusStr\":\"普通\",\"shopId\":755,\"status\":0,\"statusStr\":\"上架\",\"stores\":98,\"userId\":797,\"videoId\":\"\",\"views\":46014,\"weight\":0}}");
        }

        if(38772 == id){
            return JSONObject.parseObject("{\"logistics\":{\"isFree\":true,\"feeType\":0,\"feeTypeStr\":\"按件数\",\"details\":[]},\"extJson\":{},\"category\":{\"dateAdd\":\"2018-04-04 12:49:27\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/f8a757674a02ed90bd7be8f20302d043.png\",\"id\":10454,\"isUse\":true,\"key\":\"5\",\"name\":\"宠物\",\"paixu\":5,\"pid\":10450,\"type\":\"\",\"userId\":797},\"pics\":[{\"goodsId\":38772,\"id\":198050,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/10/e2460be8d498b121a405bc53c59f02d4.jpg\",\"userId\":797},{\"goodsId\":38772,\"id\":198051,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/10/11b7e2e38810902ac89e8b0aa28e84c2.jpg\",\"userId\":797},{\"goodsId\":38772,\"id\":198052,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/10/f592cf81a1fead341339532f937eaa74.jpg\",\"userId\":797},{\"goodsId\":38772,\"id\":198053,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/10/387e7b35001c51523110db8106cb9244.jpg\",\"userId\":797}],\"content\":\"<p><img src=\\\"https://cdn.it120.cc/apifactory/2018/04/10/6f37ea50fe7634bcf4985e0704ca7c0c.jpg\\\" title=\\\"apifactory/2018/04/10/6f37ea50fe7634bcf4985e0704ca7c0c.jpg\\\" alt=\\\"5.jpg\\\"/></p>\",\"basicInfo\":{\"barCode\":\"\",\"categoryId\":10454,\"characteristic\":\"封闭式设计猫咪独享\",\"commission\":0,\"commissionType\":0,\"dateAdd\":\"2018-04-10 15:07:04\",\"dateStart\":\"2018-04-10 15:02:45\",\"dateUpdate\":\"2018-08-07 18:34:26\",\"id\":38772,\"logisticsId\":1273,\"minPrice\":99,\"minScore\":0,\"name\":\"方形封闭式宠物窝\",\"numberFav\":0,\"numberGoodReputation\":0,\"numberOrders\":121,\"originalPrice\":159,\"paixu\":10,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/10/e2460be8d498b121a405bc53c59f02d4.jpg\",\"pingtuan\":false,\"pingtuanPrice\":0,\"recommendStatus\":0,\"recommendStatusStr\":\"普通\",\"shopId\":755,\"status\":1,\"statusStr\":\"下架\",\"stores\":50,\"userId\":797,\"videoId\":\"\",\"views\":44082,\"weight\":0}}");
        }

        if(38932 == id){
            return JSONObject.parseObject("{\"logistics\":{\"isFree\":true,\"feeType\":0,\"feeTypeStr\":\"按件数\",\"details\":[]},\"extJson\":{},\"category\":{\"dateAdd\":\"2018-04-04 12:49:27\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/04/02/f8a757674a02ed90bd7be8f20302d043.png\",\"id\":10454,\"isUse\":true,\"key\":\"5\",\"name\":\"宠物\",\"paixu\":5,\"pid\":10450,\"type\":\"\",\"userId\":797},\"pics\":[{\"goodsId\":38932,\"id\":198046,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/10/86601d1a2488a67d005fd813954769a0.jpg\",\"userId\":797},{\"goodsId\":38932,\"id\":198047,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/10/56231f2926f5cbbf6b0205535047b118.jpg\",\"userId\":797},{\"goodsId\":38932,\"id\":198048,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/10/8d0a585123b3aeaf401369ad44487d9e.jpg\",\"userId\":797},{\"goodsId\":38932,\"id\":198049,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/10/2466eff69567fbc8c3be8fce6753b29d.jpg\",\"userId\":797}],\"content\":\"<p><img src=\\\"https://cdn.it120.cc/apifactory/2018/04/10/d5bd3f0c7d9f6c8e311cd848f55b9476.jpg\\\" title=\\\"apifactory/2018/04/10/d5bd3f0c7d9f6c8e311cd848f55b9476.jpg\\\" alt=\\\"5.jpg\\\"/></p>\",\"basicInfo\":{\"barCode\":\"\",\"categoryId\":10454,\"characteristic\":\"隔绝异味，拒绝带砂，洁净卫生\",\"commission\":0,\"commissionType\":0,\"dateAdd\":\"2018-04-10 21:22:13\",\"dateStart\":\"2018-04-10 21:16:41\",\"dateUpdate\":\"2018-08-07 18:34:59\",\"id\":38932,\"logisticsId\":1273,\"minPrice\":189,\"minScore\":0,\"name\":\"多功能封闭式环保除臭猫砂盆\",\"numberFav\":0,\"numberGoodReputation\":0,\"numberOrders\":256,\"originalPrice\":259,\"paixu\":11,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/10/86601d1a2488a67d005fd813954769a0.jpg\",\"pingtuan\":false,\"pingtuanPrice\":0,\"recommendStatus\":0,\"recommendStatusStr\":\"普通\",\"shopId\":755,\"status\":1,\"statusStr\":\"下架\",\"stores\":75,\"userId\":797,\"videoId\":\"\",\"views\":35085,\"weight\":0}}");
        }

        //购物车猜你喜欢
        //"30164,43223,40601,30164"
        if(30164 == id){
            return JSONObject.parseObject("{\"logistics\":{\"isFree\":true,\"feeType\":0,\"feeTypeStr\":\"按件数\",\"details\":[]},\"extJson\":{},\"category\":{\"dateAdd\":\"2018-04-04 12:46:54\",\"icon\":\"\",\"id\":10450,\"isUse\":true,\"key\":\"1\",\"name\":\"居家生活\",\"paixu\":1,\"pid\":0,\"type\":\"\",\"userId\":797},\"pics\":[{\"goodsId\":30164,\"id\":322321,\"pic\":\"https://cdn.it120.cc/apifactory/2018/05/19/84833eee6df34fa550cd7644b2242cf5.png\",\"userId\":797},{\"goodsId\":30164,\"id\":322322,\"pic\":\"https://cdn.it120.cc/apifactory/2018/05/19/84833eee6df34fa550cd7644b2242cf5.png\",\"userId\":797}],\"content\":\"<p style=\\\"text-align: left;\\\"><span style=\\\"color: rgb(255, 0, 0);\\\">虚拟产品因为具备可复制性，所以一经售出概不退换！</span><br/></p><p style=\\\"text-align: left;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 16px;\\\">虚拟产品因为具备可复制性，所以一经售出概不<span style=\\\"color: rgb(255, 0, 0); font-size: 16px;\\\"><span style=\\\"color: rgb(255, 0, 0);\\\">退换</span>！</span></span></p><p style=\\\"text-align: left;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 16px;\\\">虚拟产品因为具备可复制性，所以一经售出概不<span style=\\\"color: rgb(255, 0, 0); font-size: 16px;\\\"><span style=\\\"color: rgb(255, 0, 0);\\\">退换</span>！</span></span></p><p><br/></p><p><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\">购买须知（购买模版证明您知悉并同意以下条件）：</span></p><p><span style=\\\"font-size: 14px;\\\"><span style=\\\"font-size: 14px; color: rgb(255, 0, 0);\\\">1、</span><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\">技术支持仅限对于现有代码，部署或配置有疑问的解答服务（不包含远程支持服务）；</span></span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\">2、技术支持不包含页面源码修改或者新增功能的服务；</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\">3、购买后只要已经发送源码给您，不接受任何理由的退款和换货行为；</span></p><p><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\">4、版本更新属于bug修复更新，不包括功能更新，各个功能接口属于增值项目，需要单独购买；</span></p><p><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\">5、该版本为授权版本，一个工厂后台对应一套模版，如果您要多个小程序使用，需要单独购买授权；</span></p><p><br/></p><p><span style=\\\"font-size: 14px; color: rgb(0, 0, 0);\\\">购买此模版您可以得到：</span></p><p><span style=\\\"font-size: 14px; color: rgb(0, 0, 0);\\\">1、清欢严选商城小程序端整套模版源码（<strong>不包含服务端源码</strong>）；</span></p><p><span style=\\\"font-size: 14px; color: rgb(0, 0, 0);\\\">2、清欢严选商城API工厂后台配置说明文档；</span></p><p><span style=\\\"font-size: 14px; color: rgb(0, 0, 0);\\\">3、清欢模版VIP微信群加入权限；</span></p><p><span style=\\\"color: rgb(0, 0, 0);\\\"><span style=\\\"font-size: 14px;\\\">4、一周</span><strong><span style=\\\"font-size: 14px; text-decoration: none;\\\">QQ或微信在线解答模版配置相关问题</span></strong><span style=\\\"font-size: 14px;\\\">的技术支持服务；</span></span></p><p><br/></p><p><span style=\\\"font-size: 14px;\\\">怎么样购买这套模版？</span></p><p><span style=\\\"font-size: 14px;\\\">&nbsp;&nbsp;&nbsp;&nbsp;1、小程序体验该模版的整个交互流程和呈现界面；<br/></span></p><p><span style=\\\"font-size: 14px;\\\">&nbsp;&nbsp;&nbsp;&nbsp;2、在首页领取优惠券，或者去礼券中心领取优惠券；<br/></span></p><p><span style=\\\"font-size: 14px;\\\">&nbsp; &nbsp; 3、您有两种购买方式：一是直接购买，二是拼团购买；</span></p><p><span style=\\\"font-size: 14px;\\\">&nbsp;&nbsp;&nbsp;&nbsp;4、拼团只有拼团成功后才进行发货，否则视为拼团失败；<br/></span></p><p><span style=\\\"font-size: 14px;\\\">&nbsp;&nbsp;&nbsp;&nbsp;5、购买后请保存好订单付款截图，然后联系丸子君；</span><br/></p><p><br/></p><p style=\\\"text-align: center;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 20px;\\\">再次感谢您选择丸子，支持正版！</span></p><p style=\\\"text-align: center;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 20px;\\\">丸子QQ：1172007555</span></p><p><br/></p><p><br/></p>\",\"properties\":[{\"childsCurGoods\":[{\"dateAdd\":\"2018-06-06 13:09:31\",\"id\":18213,\"name\":\"授权版（加密版本）\",\"paixu\":1,\"propertyId\":5420,\"remark\":\"\",\"userId\":797},{\"dateAdd\":\"2018-06-06 13:09:20\",\"id\":18212,\"name\":\"开发版（未加密版本）\",\"paixu\":2,\"propertyId\":5420,\"remark\":\"\",\"userId\":797}],\"dateAdd\":\"2018-06-06 13:07:49\",\"id\":5420,\"name\":\"选择版本\",\"paixu\":0,\"userId\":797},{\"childsCurGoods\":[{\"dateAdd\":\"2018-04-10 20:01:31\",\"id\":8930,\"name\":\"不要服务\",\"paixu\":0,\"propertyId\":3688,\"remark\":\"\",\"userId\":797},{\"dateAdd\":\"2018-05-04 10:01:03\",\"id\":12332,\"name\":\"部署上线一条龙服务\",\"paixu\":1,\"propertyId\":3688,\"remark\":\"\",\"userId\":797}],\"dateAdd\":\"2018-04-10 20:01:15\",\"dateUpdate\":\"2018-06-06 13:08:11\",\"id\":3688,\"name\":\"选择服务\",\"paixu\":1,\"userId\":797}],\"basicInfo\":{\"barCode\":\"\",\"categoryId\":10450,\"characteristic\":\"全场模版使用优惠券立减88元\",\"commission\":10,\"commissionType\":0,\"dateAdd\":\"2018-03-15 14:15:56\",\"dateStart\":\"2018-03-15 14:03:47\",\"dateUpdate\":\"2018-08-08 12:04:09\",\"gotScore\":0,\"id\":30164,\"logisticsId\":1273,\"minPrice\":299,\"minScore\":0,\"name\":\"清欢严选商城小程序端模版（API工厂授权版）\",\"numberFav\":105,\"numberGoodReputation\":100,\"numberOrders\":326,\"originalPrice\":699,\"paixu\":0,\"pic\":\"https://cdn.it120.cc/apifactory/2018/05/19/84833eee6df34fa550cd7644b2242cf5.png\",\"pingtuan\":true,\"pingtuanPrice\":289,\"propertyIds\":\",5420,3688,\",\"recommendStatus\":1,\"recommendStatusStr\":\"推荐\",\"shopId\":755,\"status\":0,\"statusStr\":\"上架\",\"stores\":100,\"userId\":797,\"videoId\":\"\",\"views\":28885,\"weight\":0}}");
        }

        if(43223 == id){
            return JSONObject.parseObject("{\"logistics\":{\"isFree\":true,\"feeType\":0,\"feeTypeStr\":\"按件数\",\"details\":[]},\"extJson\":{},\"category\":{\"dateAdd\":\"2018-04-04 12:46:54\",\"icon\":\"\",\"id\":10450,\"isUse\":true,\"key\":\"1\",\"name\":\"居家生活\",\"paixu\":1,\"pid\":0,\"type\":\"\",\"userId\":797},\"pics\":[{\"goodsId\":43223,\"id\":322328,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/18/14569682d80bf52cd8ff4c3c116758a7.png\",\"userId\":797},{\"goodsId\":43223,\"id\":322329,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/19/a67af59694a6ad877a0e68fbdbbaca05.png\",\"userId\":797}],\"content\":\"<p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\"></span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0);\\\">虚拟产品因为具备可复制性，所以一经售出概不退换！</span><br/></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0);\\\">虚拟产品因为具备可复制性，所以一经售出概不退换！</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0);\\\">虚拟产品因为具备可复制性，所以一经售出概不退换！</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\"><br/></span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\"></span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\">购买须知（购买模版证明您知悉并同意以下条件）：</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"font-size: 14px; color: rgb(255, 0, 0);\\\">1、技术支持仅限对于现有代码，部署或配置有疑问的解答服务（不包含远程支持服务）；</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\">2、技术支持不包含页面源码修改或者新增功能的服务；</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\">3、购买后只要已经发送源码给您，不接受任何理由的退款和换货行为；</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\">4、版本更新属于bug修复更新，不包括功能更新，各个功能接口属于增值项目，需要单独购买；</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\">5、该版本为授权版本，一个工厂后台对应一套模版，如果您要多个小程序使用，需要单独购买授权；</span></p><p><br/></p><p style=\\\"white-space: normal;\\\"><span style=\\\"font-size: 14px;\\\">购买此模版您可以得到：</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"font-size: 14px;\\\"></span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"font-size: 14px;\\\">1、<span style=\\\"font-size: 14px;\\\">清欢素雅</span>小程序端整套模版源码（<strong>不包含服务端源码</strong>）；</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"font-size: 14px;\\\">2、<span style=\\\"font-size: 14px;\\\">清欢素雅</span>API工厂后台配置说明文档；</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"font-size: 14px;\\\">3、清欢模版VIP微信群加入权限；</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"font-size: 14px;\\\">4、一周</span><strong><span style=\\\"font-size: 14px;\\\">QQ或微信在线解答模版配置相关问题</span></strong><span style=\\\"font-size: 14px;\\\">的技术支持服务；</span></p><p><br/></p><p style=\\\"white-space: normal; text-align: center;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 20px;\\\">再次感谢您选择丸子，支持正版！</span></p><p style=\\\"white-space: normal; text-align: center;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 20px;\\\">丸子QQ：1172007555</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 20px;\\\"><br/></span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 20px;\\\"><img src=\\\"https://cdn.it120.cc/apifactory/2018/04/19/d6a969c7c6a3f9209ecf6d9d5286b598.png\\\" title=\\\"apifactory/2018/04/19/d6a969c7c6a3f9209ecf6d9d5286b598.png\\\" alt=\\\"775suya.png\\\"/></span></p>\",\"properties\":[{\"childsCurGoods\":[{\"dateAdd\":\"2018-06-06 13:09:31\",\"id\":18213,\"name\":\"授权版（加密版本）\",\"paixu\":1,\"propertyId\":5420,\"remark\":\"\",\"userId\":797},{\"dateAdd\":\"2018-06-06 13:09:20\",\"id\":18212,\"name\":\"开发版（未加密版本）\",\"paixu\":2,\"propertyId\":5420,\"remark\":\"\",\"userId\":797}],\"dateAdd\":\"2018-06-06 13:07:49\",\"id\":5420,\"name\":\"选择版本\",\"paixu\":0,\"userId\":797}],\"basicInfo\":{\"barCode\":\"\",\"categoryId\":10450,\"characteristic\":\"全场模版使用优惠券立减88元\",\"commission\":0,\"commissionType\":0,\"dateAdd\":\"2018-04-19 13:02:49\",\"dateStart\":\"2018-04-19 12:57:19\",\"dateUpdate\":\"2018-08-08 12:07:14\",\"gotScore\":0,\"id\":43223,\"logisticsId\":1273,\"minPrice\":299,\"minScore\":0,\"name\":\"清欢素雅小程序端模版（API工厂授权版）\",\"numberFav\":27,\"numberGoodReputation\":15,\"numberOrders\":251,\"originalPrice\":550,\"paixu\":0,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/18/14569682d80bf52cd8ff4c3c116758a7.png\",\"pingtuan\":false,\"pingtuanPrice\":289,\"propertyIds\":\",5420,\",\"recommendStatus\":1,\"recommendStatusStr\":\"推荐\",\"shopId\":755,\"status\":0,\"statusStr\":\"上架\",\"stores\":92,\"userId\":797,\"videoId\":\"\",\"views\":11147,\"weight\":0}}");
        }

        if(40601 == id){
            return JSONObject.parseObject("{\"logistics\":{\"isFree\":true,\"feeType\":0,\"feeTypeStr\":\"按件数\",\"details\":[]},\"extJson\":{},\"category\":{\"dateAdd\":\"2018-04-04 12:46:54\",\"icon\":\"\",\"id\":10450,\"isUse\":true,\"key\":\"1\",\"name\":\"居家生活\",\"paixu\":1,\"pid\":0,\"type\":\"\",\"userId\":797},\"pics\":[{\"goodsId\":40601,\"id\":344992,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/12/42c001a698072b3bae9ac71f65ca2cfc.jpg\",\"userId\":797}],\"content\":\"<p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\"></span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0);\\\">虚拟产品因为具备可复制性，所以一经售出概不退换！</span><br/></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0);\\\">虚拟产品因为具备可复制性，所以一经售出概不退换！</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0);\\\">虚拟产品因为具备可复制性，所以一经售出概不退换！</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\"><br/></span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\"></span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\"></span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\">购买须知（购买模版证明您知悉并同意以下条件）：</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"font-size: 14px; color: rgb(255, 0, 0);\\\">1、技术支持仅限对于现有代码，部署或配置有疑问的解答服务（不包含远程支持服务）；</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\">2、技术支持不包含页面源码修改或者新增功能的服务；</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\">3、购买后只要已经发送源码给您，不接受任何理由的退款和换货行为；</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\">4、版本更新属于bug修复更新，不包括功能更新，各个功能接口属于增值项目，需要单独购买；</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 14px;\\\">5、该版本为授权版本，一个工厂后台对应一套模版，如果您要多个小程序使用，需要单独购买授权；</span></p><p><br/></p><p style=\\\"white-space: normal;\\\"><span style=\\\"font-size: 14px;\\\">购买此模版您可以得到：</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"font-size: 14px;\\\">1、清欢食光机Plus小程序端整套模版源码（<strong>不包含服务端源码</strong>）；</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"font-size: 14px;\\\">2、清欢<span style=\\\"font-size: 14px;\\\">食光机Plus&nbsp;</span>API工厂后台配置说明文档；</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"font-size: 14px;\\\">3、清欢模版VIP微信群加入权限；</span></p><p style=\\\"white-space: normal;\\\"><span style=\\\"font-size: 14px;\\\">4、一周</span><strong><span style=\\\"font-size: 14px;\\\">QQ或微信在线解答模版配置相关问题</span></strong><span style=\\\"font-size: 14px;\\\">的技术支持服务；</span></p><p style=\\\"white-space: normal;\\\"><br/></p><p style=\\\"white-space: normal; text-align: center;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 20px;\\\">再次感谢您选择丸子，支持正版！</span></p><p style=\\\"white-space: normal; text-align: center;\\\"><span style=\\\"color: rgb(255, 0, 0); font-size: 20px;\\\">丸子QQ：1172007555</span></p><p><br/></p>\",\"properties\":[{\"childsCurGoods\":[{\"dateAdd\":\"2018-06-06 13:09:31\",\"id\":18213,\"name\":\"授权版（加密版本）\",\"paixu\":1,\"propertyId\":5420,\"remark\":\"\",\"userId\":797},{\"dateAdd\":\"2018-06-06 13:09:20\",\"id\":18212,\"name\":\"开发版（未加密版本）\",\"paixu\":2,\"propertyId\":5420,\"remark\":\"\",\"userId\":797}],\"dateAdd\":\"2018-06-06 13:07:49\",\"id\":5420,\"name\":\"选择版本\",\"paixu\":0,\"userId\":797}],\"basicInfo\":{\"barCode\":\"\",\"categoryId\":10450,\"characteristic\":\"全场模版使用优惠券立减88元\",\"commission\":0,\"commissionType\":0,\"dateAdd\":\"2018-04-12 10:51:05\",\"dateStart\":\"2018-04-12 10:36:58\",\"dateUpdate\":\"2018-08-08 12:08:10\",\"gotScore\":0,\"id\":40601,\"logisticsId\":1273,\"minPrice\":399,\"minScore\":0,\"name\":\"清欢食光机Plus小程序端模版（API工厂授权版）\",\"numberFav\":28,\"numberGoodReputation\":1,\"numberOrders\":268,\"originalPrice\":999,\"paixu\":0,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/12/42c001a698072b3bae9ac71f65ca2cfc.jpg\",\"pingtuan\":false,\"pingtuanPrice\":389,\"propertyIds\":\",5420,\",\"recommendStatus\":1,\"recommendStatusStr\":\"推荐\",\"shopId\":755,\"status\":0,\"statusStr\":\"上架\",\"stores\":100,\"userId\":797,\"videoId\":\"\",\"views\":10560,\"weight\":0}}");
        }

        if(36888 == id){
            return JSONObject.parseObject("{\"logistics\":{\"isFree\":true,\"feeType\":0,\"feeTypeStr\":\"按件数\",\"details\":[]},\"extJson\":{},\"category\":{\"dateAdd\":\"2018-04-04 12:47:47\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/05/24/772862baa0197b71c5eee745542c956f.png\",\"id\":10451,\"isUse\":true,\"key\":\"2\",\"name\":\"床品\",\"paixu\":2,\"pid\":10450,\"type\":\"\",\"userId\":797},\"pics\":[{\"goodsId\":36888,\"id\":307657,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/0eaf91e4696b51e326313efaec5e9b11.jpg\",\"userId\":797},{\"goodsId\":36888,\"id\":307658,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/2b3810a35d854c5bb77ff85dc79e8200.jpg\",\"userId\":797},{\"goodsId\":36888,\"id\":307659,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/78cc21576a6c0392afb390e839b393ee.jpg\",\"userId\":797},{\"goodsId\":36888,\"id\":307660,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/8eaf570fac1d2b33bad15c037c2de531.jpg\",\"userId\":797},{\"goodsId\":36888,\"id\":307661,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/35a55d0b5c3424c4de67f6f86abdb39c.jpg\",\"userId\":797}],\"content\":\"<p><img src=\\\"https://cdn.it120.cc/apifactory/2018/04/02/fca25a56fdcf817fa9ebabeaadece67c.jpg\\\" title=\\\"apifactory/2018/04/02/fca25a56fdcf817fa9ebabeaadece67c.jpg\\\" alt=\\\"6.jpg\\\"/></p>\",\"basicInfo\":{\"barCode\":\"\",\"categoryId\":10451,\"characteristic\":\"100%全棉，椰林自然设计\",\"commission\":10,\"commissionType\":1,\"dateAdd\":\"2018-04-04 13:18:25\",\"dateStart\":\"2018-04-04 13:10:36\",\"dateUpdate\":\"2018-08-08 15:43:08\",\"gotScore\":0,\"id\":36888,\"logisticsId\":1273,\"minPrice\":299,\"minScore\":0,\"name\":\"唤自然 仲夏椰香四件套\",\"numberFav\":61,\"numberGoodReputation\":1,\"numberOrders\":131,\"originalPrice\":399,\"paixu\":1,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/0eaf91e4696b51e326313efaec5e9b11.jpg\",\"pingtuan\":false,\"pingtuanPrice\":99,\"recommendStatus\":1,\"recommendStatusStr\":\"推荐\",\"shopId\":755,\"status\":0,\"statusStr\":\"上架\",\"stores\":38,\"userId\":797,\"videoId\":\"\",\"views\":8693,\"weight\":0}}");
        }

        if(36889 == id){
            return JSONObject.parseObject("{\"logistics\":{\"isFree\":false,\"feeType\":0,\"feeTypeStr\":\"按件数\",\"details\":[{\"addAmount\":0,\"addNumber\":1,\"firstAmount\":10,\"firstNumber\":1,\"type\":0,\"userId\":797}]},\"extJson\":{},\"category\":{\"dateAdd\":\"2018-04-04 12:47:47\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/05/24/772862baa0197b71c5eee745542c956f.png\",\"id\":10451,\"isUse\":true,\"key\":\"2\",\"name\":\"床品\",\"paixu\":2,\"pid\":10450,\"type\":\"\",\"userId\":797},\"pics\":[{\"goodsId\":36889,\"id\":295804,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/a6f0202a6dbcf9d99a98176148a26c6c.jpg\",\"userId\":797},{\"goodsId\":36889,\"id\":295805,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/cfbcabf7fe4c3b768228b0f93c694891.jpg\",\"userId\":797},{\"goodsId\":36889,\"id\":295806,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/b573c244e52b119a2f98ff97c1307516.jpg\",\"userId\":797},{\"goodsId\":36889,\"id\":295807,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/fbe4ddcb73fa94a9b43f23c329a66d91.jpg\",\"userId\":797},{\"goodsId\":36889,\"id\":295808,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/e51524253aad08b70f222c391c2f1877.jpg\",\"userId\":797}],\"content\":\"<p><img src=\\\"https://cdn.it120.cc/apifactory/2018/04/02/1f8ef5fe36cb85b5eecb1114ea394279.jpg\\\" title=\\\"apifactory/2018/04/02/1f8ef5fe36cb85b5eecb1114ea394279.jpg\\\" alt=\\\"6.jpg\\\"/></p>\",\"basicInfo\":{\"barCode\":\"\",\"categoryId\":10451,\"characteristic\":\"狗年定制款，高支高密棉\",\"commission\":10,\"commissionType\":1,\"dateAdd\":\"2018-04-04 13:23:46\",\"dateStart\":\"2018-04-04 13:19:38\",\"dateUpdate\":\"2018-08-08 15:45:00\",\"gotScore\":0,\"id\":36889,\"logisticsId\":2065,\"minPrice\":359,\"minScore\":0,\"name\":\"趣味萌宠定制款四件套\",\"numberFav\":18,\"numberGoodReputation\":0,\"numberOrders\":159,\"originalPrice\":499,\"paixu\":2,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/a6f0202a6dbcf9d99a98176148a26c6c.jpg\",\"pingtuan\":false,\"pingtuanPrice\":0.01,\"recommendStatus\":0,\"recommendStatusStr\":\"普通\",\"shopId\":755,\"status\":0,\"statusStr\":\"上架\",\"stores\":76,\"userId\":797,\"videoId\":\"\",\"views\":4317,\"weight\":0}}");
        }

        if(36890 == id){
            return JSONObject.parseObject("{\"logistics\":{\"isFree\":true,\"feeType\":0,\"feeTypeStr\":\"按件数\",\"details\":[]},\"extJson\":{},\"category\":{\"dateAdd\":\"2018-04-04 12:47:47\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/05/24/772862baa0197b71c5eee745542c956f.png\",\"id\":10451,\"isUse\":true,\"key\":\"2\",\"name\":\"床品\",\"paixu\":2,\"pid\":10450,\"type\":\"\",\"userId\":797},\"pics\":[{\"goodsId\":36890,\"id\":249086,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/281fd28838d0ca70c173c468ac8d5803.jpg\",\"userId\":797},{\"goodsId\":36890,\"id\":249087,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/12378c44b8fb81bfd7a1d16ae2598e8c.jpg\",\"userId\":797},{\"goodsId\":36890,\"id\":249088,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/9e0636154bb6b71208f4a26a34c19a7e.jpg\",\"userId\":797},{\"goodsId\":36890,\"id\":249089,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/477534be559957dfa69da15371b61c94.jpg\",\"userId\":797},{\"goodsId\":36890,\"id\":249090,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/0d9340a1a2d35bf78f7be308bf08c595.jpg\",\"userId\":797}],\"content\":\"<p><img src=\\\"https://cdn.it120.cc/apifactory/2018/04/02/ec92a0c1ee7dd6c80290e89e34e40b67.jpg\\\" title=\\\"apifactory/2018/04/02/ec92a0c1ee7dd6c80290e89e34e40b67.jpg\\\" alt=\\\"6.jpg\\\"/></p>\",\"basicInfo\":{\"barCode\":\"\",\"categoryId\":10451,\"characteristic\":\"双层呼吸纱，纯棉超柔亲肤\",\"commission\":10,\"commissionType\":1,\"dateAdd\":\"2018-04-04 13:29:10\",\"dateStart\":\"2018-04-04 13:28:10\",\"dateUpdate\":\"2018-08-08 15:46:10\",\"gotScore\":0,\"id\":36890,\"logisticsId\":1273,\"minPrice\":0.01,\"minScore\":0,\"name\":\"透气呼吸纱四件套\",\"numberFav\":7,\"numberGoodReputation\":0,\"numberOrders\":125,\"originalPrice\":680,\"paixu\":3,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/281fd28838d0ca70c173c468ac8d5803.jpg\",\"pingtuan\":false,\"pingtuanPrice\":0,\"recommendStatus\":0,\"recommendStatusStr\":\"普通\",\"shopId\":755,\"status\":0,\"statusStr\":\"上架\",\"stores\":6,\"userId\":797,\"videoId\":\"\",\"views\":2933,\"weight\":0}}");
        }

        if(36891 == id){
            return JSONObject.parseObject("{\"logistics\":{\"isFree\":true,\"feeType\":0,\"feeTypeStr\":\"按件数\",\"details\":[]},\"extJson\":{},\"category\":{\"dateAdd\":\"2018-04-04 12:47:47\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/05/24/772862baa0197b71c5eee745542c956f.png\",\"id\":10451,\"isUse\":true,\"key\":\"2\",\"name\":\"床品\",\"paixu\":2,\"pid\":10450,\"type\":\"\",\"userId\":797},\"pics\":[{\"goodsId\":36891,\"id\":246178,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/b665d22fb894e44bebf83129d90244ed.jpg\",\"userId\":797},{\"goodsId\":36891,\"id\":246179,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/d560279a730b6f9a4136854400441804.jpg\",\"userId\":797},{\"goodsId\":36891,\"id\":246180,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/33e58e1d29871f9695dc78edff567bd7.jpg\",\"userId\":797},{\"goodsId\":36891,\"id\":246181,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/912a260ed9b5c59f570a0e0d2b73bf0b.jpg\",\"userId\":797},{\"goodsId\":36891,\"id\":246182,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/41ced609d19c1fd69a8205d5e0c1e31d.jpg\",\"userId\":797}],\"content\":\"<p><img src=\\\"https://cdn.it120.cc/apifactory/2018/04/02/6473057d4d122cb483048d36a5854c86.jpg\\\" title=\\\"apifactory/2018/04/02/6473057d4d122cb483048d36a5854c86.jpg\\\" alt=\\\"6.jpg\\\"/></p>\",\"properties\":[{\"childsCurGoods\":[{\"dateAdd\":\"2018-05-13 18:32:02\",\"id\":13439,\"name\":\"测试2\",\"paixu\":0,\"propertyId\":4548,\"remark\":\"\",\"userId\":797},{\"dateAdd\":\"2018-05-13 18:31:55\",\"id\":13438,\"name\":\"测试1\",\"paixu\":1,\"propertyId\":4548,\"remark\":\"\",\"userId\":797}],\"dateAdd\":\"2018-05-13 18:31:25\",\"id\":4548,\"name\":\"测试规格\",\"paixu\":2,\"userId\":797}],\"basicInfo\":{\"barCode\":\"\",\"categoryId\":10451,\"characteristic\":\"天然竹醌成分，抑菌爽滑健康睡眠\",\"commission\":10,\"commissionType\":1,\"dateAdd\":\"2018-04-04 13:34:00\",\"dateStart\":\"2018-04-04 13:31:24\",\"dateUpdate\":\"2018-08-08 15:47:11\",\"gotScore\":0,\"id\":36891,\"logisticsId\":1273,\"minPrice\":429,\"minScore\":0,\"name\":\"竹语初棉撞色四件套【测试拼团，不发货】\",\"numberFav\":36,\"numberGoodReputation\":0,\"numberOrders\":179,\"originalPrice\":459,\"paixu\":4,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/b665d22fb894e44bebf83129d90244ed.jpg\",\"pingtuan\":true,\"pingtuanPrice\":0.1,\"propertyIds\":\",4548,\",\"recommendStatus\":0,\"recommendStatusStr\":\"普通\",\"shopId\":755,\"status\":0,\"statusStr\":\"上架\",\"stores\":77,\"userId\":797,\"videoId\":\"\",\"views\":7343,\"weight\":0}}");
        }

        return JSONObject.parseObject("{\"logistics\":{\"isFree\":true,\"feeType\":0,\"feeTypeStr\":\"按件数\",\"details\":[]},\"extJson\":{},\"category\":{\"dateAdd\":\"2018-04-04 12:47:47\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/05/24/772862baa0197b71c5eee745542c956f.png\",\"id\":10451,\"isUse\":true,\"key\":\"2\",\"name\":\"床品\",\"paixu\":2,\"pid\":10450,\"type\":\"\",\"userId\":797},\"pics\":[{\"goodsId\":36888,\"id\":307657,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/0eaf91e4696b51e326313efaec5e9b11.jpg\",\"userId\":797},{\"goodsId\":36888,\"id\":307658,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/2b3810a35d854c5bb77ff85dc79e8200.jpg\",\"userId\":797},{\"goodsId\":36888,\"id\":307659,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/78cc21576a6c0392afb390e839b393ee.jpg\",\"userId\":797},{\"goodsId\":36888,\"id\":307660,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/8eaf570fac1d2b33bad15c037c2de531.jpg\",\"userId\":797},{\"goodsId\":36888,\"id\":307661,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/35a55d0b5c3424c4de67f6f86abdb39c.jpg\",\"userId\":797}],\"content\":\"<p><img src=\\\"https://cdn.it120.cc/apifactory/2018/04/02/fca25a56fdcf817fa9ebabeaadece67c.jpg\\\" title=\\\"apifactory/2018/04/02/fca25a56fdcf817fa9ebabeaadece67c.jpg\\\" alt=\\\"6.jpg\\\"/></p>\",\"basicInfo\":{\"barCode\":\"\",\"categoryId\":10451,\"characteristic\":\"100%全棉，椰林自然设计\",\"commission\":10,\"commissionType\":1,\"dateAdd\":\"2018-04-04 13:18:25\",\"dateStart\":\"2018-04-04 13:10:36\",\"dateUpdate\":\"2018-08-08 14:25:24\",\"gotScore\":0,\"id\":36888,\"logisticsId\":1273,\"minPrice\":299,\"minScore\":0,\"name\":\"唤自然 仲夏椰香四件套\",\"numberFav\":61,\"numberGoodReputation\":1,\"numberOrders\":131,\"originalPrice\":399,\"paixu\":1,\"pic\":\"https://cdn.it120.cc/apifactory/2018/04/02/0eaf91e4696b51e326313efaec5e9b11.jpg\",\"pingtuan\":false,\"pingtuanPrice\":99,\"recommendStatus\":1,\"recommendStatusStr\":\"推荐\",\"shopId\":755,\"status\":0,\"statusStr\":\"上架\",\"stores\":38,\"userId\":797,\"videoId\":\"\",\"views\":8687,\"weight\":0}}");
    }


    //选择规格和尺寸获取商品价格
    //参数名	数据类型	备注	必填
    //goodsId	int	商品编号	Y
    //propertyChildIds	String	选择的规格尺寸信息：如：4:15,2:10,1:4 。多个规格请用英文的逗号分割，4:15 中的 4 获取代表颜色，15 或许代表 土豪金	Y
    @GetMapping("/price")
    public JSON price(@RequestParam String goodsId, @RequestParam String propertyChildIds){
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
                          @RequestParam(required = false) int districtId){
        return "{\"code\":0,\"data\":{\"firstNumber\":9,\"addAmount\":12,\"firstAmount\":10,\"addNumber\":11},\"msg\":\"success\"}";
    }

    //商品评价
    //    参数名	数据类型	备注	必填
    //    goodsId	int	商品编号数字id	Y
    //    page	int	获取第几页数据，不传默认为1	X
    //    pageSize	int	每页显示多少条数据，不传默认50	X
    @GetMapping("/reputation")
    public JSON reputation(@RequestParam int goodsId,
                             Pageable page){
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
                               @RequestParam int joinerUser){
        boolean 未帮忙砍价 = false;

        if(未帮忙砍价){
            return "{\"code\":700,\"msg\":\"暂无数据\"}";
        }else {
            return "{\"code\":0,\"data\":{\"cutPrice\":14.77,\"goodsId\":1},\"msg\":\"success\"}";
        }
    }

    //获取砍价详情
    //参数名	数据类型	备注	必填
    //kjid	int	砍价ID	Y
    //joiner	int	参与者ID	Y
    @GetMapping("/kanjia/info")
    public String kanjiaInfo(@RequestParam int kjid,
                             @RequestParam int joinerUser){
        return  "{\"code\":0,\"data\":{\"kanjiaInfo\":{\"curPrice\":985.23,\"dateAdd\":\"2018-04-01 08:47:29\",\"dateUpdate\":\"2018-04-01 16:36:41\",\"goodsId\":1,\"helpNumber\":1,\"kjId\":2,\"minPrice\":100,\"status\":0,\"statusStr\":\"进行中\",\"uid\":4},\"joiner\":{\"nick\":\"test\"},\"helps\":[{\"nick\":\"test\",\"dateAdd\":\"2018-04-01 16:36:41\",\"remark\":\"收\",\"cutPrice\":14.77}]},\"msg\":\"success\"}";
    }

    //加入砍价
    //参数名	数据类型	备注	必填
    //kjid	int	砍价设置ID	Y
    //token	String	登录接口返回的登录凭证	Y
    @GetMapping("/kanjia/join")
    public String kanjiaJoin(@RequestParam int kjid){
        return "{\"code\":0,\"data\":{\"curPrice\":3,\"dateAdd\":\"2018-04-01 08:47:29\",\"dateUpdate\":\"2018-04-01 08:47:29\",\"goodsId\":1,\"helpNumber\":0,\"kjId\":2,\"minPrice\":4,\"status\":0},\"msg\":\"success\"}";
    }

    //我的砍价
    //参数名	数据类型	备注	必填
    //kjid	int	砍价ID	Y
    //token	String	登录接口返回的凭证	Y
    @GetMapping("/kanjia/my")
    public String kanjiaMy(@RequestParam String kjid){
        Boolean 参与砍价 = false;

        if(参与砍价){
            return "{\"code\":0,\"data\":{\"curPrice\":3.00,\"goodsId\":1,\"id\":1,\"kjId\":2,\"minPrice\":4.00},\"msg\":\"success\"}\n";
        }else {
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
                           @RequestParam int joinerUser){
        return "{\"code\":0,\"data\":{\"cutPrice\":14.77,\"goodsId\":1},\"msg\":\"success\"}";
    }


    //获取砍价信息
    //请求参数说明:
    //参数名	数据类型	备注	必填
    //page	int	获取第几页数据，默认1	X
    //pageSize	int	每页显示多少数据，默认50	X
    @GetMapping("/kanjia/list")
    public JSONObject kanjiaList(Pageable pageable){
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
    public String favAdd(@RequestParam int goodsId){
        return "{\"code\":0,\"msg\":\"success\"}";
    }

    //删除收藏
    //参数名	数据类型	备注	必填
    //token	String	调用登录接口获取的登录凭证	Y
    //goodsId	int	id 和 goodsId 参数至少传一个	X
    //id	int	id 和 goodsId 参数至少传一个	X
    @GetMapping("/fav/delete")
    public String favDelete(@RequestParam int goodsId){
        return "{\"code\":0,\"msg\":\"success\"}";
    }

    //获取我的收藏列别
    //    参数名	数据类型	备注	必填
    //    token	String	调用登录接口返回的登录凭证	Y
    //    page	int	获取第几页的数据，不传默认为1	X
    //    pageSize	int	每页显示多少条数据，不传默认50	X
    //    nameLike	String	商品标题模糊搜索关键词	X
    @GetMapping("/fav/list")
    public String favList(@RequestParam(required = false) String nameLike){
        return "{\"code\":0,\"data\":[{\"dateAdd\":\"2017-03-31 10:35:30\",\"goodsId\":11,\"goodsName\":\"无物流无规格商品测试\",\"id\":1,\"pic\":\"https://cdn.it120.cc/apifactory/2017/03/27/dce24d7c6f0f6e8256fdbf9c43b84d9e.jpeg\",\"uid\":4,\"userId\":2}],\"msg\":\"success\"}";
    }

    ///////////拼团/////////

    //加入拼团
    //参数名	数据类型	备注	必填
    //tuanId	int	团号	Y
    @GetMapping("/pingtuan/joiner")
    public void pingtuanJoiner(@RequestParam int tuanId){

    }

    //某商品所有的进行中团购
    //参数名	数据类型	备注	必填
    //goodsId	int	商品编号	Y
    @GetMapping("/pingtuan/list")
    public JSON pingtuanList(@RequestParam(required = false) Integer goodsId){
        return JSONObject.parseArray("[{\"apiExtUser\":{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/0GSxicfbjp6foicbXqbcbbBbCrDOgEInAhqZwATQ69LpvTia5oibN6T96rs9nib5CYkgvrEdq7ibwNZMiadmOtzqALjFg/0\",\"nick\":\"Kutche\"},\"dateAdd\":\"2018-05-02 13:04:22\",\"dateEnd\":\"2018-05-03 13:04:22\",\"helpNumber\":1,\"id\":3,\"uid\":332591},{\"apiExtUser\":{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/XOqGlHkydicVWUW5OjnvtuoJ5uDg70Bz0xiaoQRwM6h6BF74C9JRZhaIzxS7RjYrDu8VVHAE6ASCrCm2SXzQT7EA/0\",\"nick\":\"Apollo&丸子君\"},\"dateAdd\":\"2018-05-02 13:01:37\",\"dateEnd\":\"2018-05-03 13:01:37\",\"helpNumber\":2,\"id\":2,\"uid\":319056}]");
    }


    //开团
    //参数名	数据类型	备注	必填
    //token	String	登录接口返回的登录凭证	Y
    //goodsId	int	商品编号	Y
    @GetMapping("/pingtuan/open")
    public String pingtuanOpen(@RequestParam int goodsId){
        return "{\"code\":0,\"data\":{\"dateAdd\":\"2018-04-28 08:11:13\",\"dateEnd\":\"2018-04-29 08:11:14\",\"dateUpdate\":\"2018-04-28 08:11:13\",\"goodsId\":3938,\"helpNumber\":0,\"id\":1,\"pingtuanId\":2,\"status\":0,\"statusStr\":\"进行中\"},\"msg\":\"success\"}";
    }

    //获取拼团设置
    //参数名	数据类型	备注	必填
    //goodsId	int	商品编号	Y
    @GetMapping("/pingtuan/set")
    public JSON pingtuanSet(@RequestParam(required = false) Integer goodsId){
        if(30164 == goodsId){
            return JSONObject.parseObject("{\"dateAdd\":\"2018-05-03 21:09:16\",\"dateEnd\":\"2018-10-31 12:00:00\",\"id\":12,\"numberDoing\":0,\"numberPersion\":2,\"numberSucccess\":579,\"refundType\":1,\"refundTypeStr\":\"原路退回\",\"status\":0,\"statusStr\":\"正常\",\"timeoutHours\":5}");
        }
        return JSONObject.parseObject("{\"dateAdd\":\"2018-05-03 21:09:16\",\"dateEnd\":\"2018-10-31 12:00:00\",\"id\":12,\"numberDoing\":0,\"numberPersion\":2,\"numberSucccess\":579,\"refundType\":1,\"refundTypeStr\":\"原路退回\",\"status\":0,\"statusStr\":\"正常\",\"timeoutHours\":5}");
    }



}