package com.feng.baby.adapter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
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
    public String categoryAll(){
        return "{\"code\":0,\"data\":[{\"dateAdd\":\"2017-03-22 09:56:43\",\"icon\":\"\",\"id\":1,\"isUse\":true,\"key\":\"cd\",\"level\":1,\"name\":\"菜单\",\"paixu\":0,\"pid\":0,\"type\":\"\",\"userId\":2},{\"dateAdd\":\"2017-03-22 10:04:11\",\"icon\":\"\",\"id\":2,\"isUse\":true,\"key\":\"cdcc\",\"level\":2,\"name\":\"炒菜\",\"paixu\":0,\"pid\":1,\"type\":\"\",\"userId\":2},{\"dateAdd\":\"2017-03-22 10:04:32\",\"icon\":\"\",\"id\":3,\"isUse\":true,\"key\":\"cdccxc\",\"level\":3,\"name\":\"湘菜\",\"paixu\":0,\"pid\":2,\"type\":\"\",\"userId\":2},{\"dateAdd\":\"2017-03-22 10:20:20\",\"icon\":\"\",\"id\":4,\"isUse\":true,\"key\":\"xcr\",\"level\":4,\"name\":\"小炒肉\",\"paixu\":0,\"pid\":3,\"type\":\"\",\"userId\":2},{\"dateAdd\":\"2017-03-22 10:22:49\",\"icon\":\"\",\"id\":5,\"isUse\":true,\"key\":\"aaaa\",\"level\":5,\"name\":\"aaa\",\"paixu\":0,\"pid\":4,\"type\":\"\",\"userId\":2},{\"dateAdd\":\"2017-03-22 10:37:43\",\"icon\":\"\",\"id\":6,\"isUse\":true,\"key\":\"jsyl\",\"level\":1,\"name\":\"酒水饮料\",\"paixu\":0,\"pid\":0,\"type\":\"\",\"userId\":2},{\"dateAdd\":\"2017-03-22 10:37:53\",\"icon\":\"\",\"id\":7,\"isUse\":true,\"key\":\"js\",\"level\":2,\"name\":\"酒水\",\"paixu\":0,\"pid\":6,\"type\":\"\",\"userId\":2},{\"dateAdd\":\"2017-03-22 10:49:29\",\"icon\":\"\",\"id\":10,\"isUse\":true,\"key\":\"bj\",\"level\":3,\"name\":\"白酒\",\"paixu\":0,\"pid\":7,\"type\":\"\",\"userId\":2},{\"dateAdd\":\"2017-03-22 10:38:02\",\"icon\":\"\",\"id\":8,\"isUse\":true,\"key\":\"yl\",\"level\":2,\"name\":\"饮料\",\"paixu\":0,\"pid\":6,\"type\":\"\",\"userId\":2},{\"dateAdd\":\"2017-03-22 10:38:20\",\"icon\":\"\",\"id\":9,\"isUse\":true,\"key\":\"yl\",\"level\":2,\"name\":\"果汁\",\"paixu\":0,\"pid\":6,\"type\":\"\",\"userId\":2}],\"msg\":\"success\"}";
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
    public String list(@RequestParam(required = false) int page,
                       @RequestParam(required = false) int pageSize,
                       @RequestParam(required = false) int shopId,
                       @RequestParam(required = false) int categoryId,
                       @RequestParam(required = false) int recommendStatus,
                       @RequestParam(required = false) String nameLike,
                       @RequestParam(required = false) String barCode,
                       @RequestParam(required = false) String orderBy,
                       @RequestParam(required = false) boolean pingtuan){
        return "{\"code\":0,\"data\":[{\"categoryId\":1,\"characteristic\":\"\",\"dateAdd\":\"2017-03-27 09:43:34\",\"id\":9,\"logisticsId\":0,\"minPrice\":0,\"name\":\"没有规格尺寸\",\"numberFav\":0,\"numberGoodReputation\":0,\"numberOrders\":0,\"originalPrice\":0,\"paixu\":0,\"pic\":\"https://cdn.it120.cc/apifactory/2017/03/26/235e62727a2e46b75530764bd4eccbcf.jpeg\",\"recommendStatus\":0,\"recommendStatusStr\":\"普通\",\"shopId\":0,\"status\":0,\"statusStr\":\"上架\",\"stores\":0,\"userId\":2,\"views\":0},{\"categoryId\":3,\"characteristic\":\"测试商品\",\"dateAdd\":\"2017-03-26 20:46:39\",\"dateUpdate\":\"2017-03-26 20:47:30\",\"id\":8,\"logisticsId\":8,\"minPrice\":50,\"name\":\"Mac 2016新款\",\"numberFav\":0,\"numberGoodReputation\":0,\"numberOrders\":0,\"originalPrice\":100,\"paixu\":0,\"pic\":\"https://cdn.it120.cc/apifactory/2017/03/26/e56a0c6e0443d416b279bcb07a890e43.png\",\"propertyIds\":\",2,\",\"recommendStatus\":0,\"recommendStatusStr\":\"普通\",\"shopId\":1,\"status\":0,\"statusStr\":\"上架\",\"stores\":10,\"userId\":2,\"views\":0},{\"categoryId\":10,\"characteristic\":\"\",\"dateAdd\":\"2017-03-26 16:03:38\",\"dateUpdate\":\"2017-03-26 21:00:51\",\"id\":7,\"logisticsId\":0,\"minPrice\":0,\"name\":\"1111\",\"numberFav\":0,\"numberGoodReputation\":0,\"numberOrders\":0,\"originalPrice\":0,\"paixu\":0,\"pic\":\"https://cdn.it120.cc/apifactory/2017/03/26/9ade208ed4b8db9155d4bd6cb82401ea.png\",\"propertyIds\":\",1,2,4,\",\"recommendStatus\":1,\"recommendStatusStr\":\"推荐\",\"shopId\":0,\"status\":0,\"statusStr\":\"上架\",\"stores\":0,\"userId\":2,\"views\":0},{\"categoryId\":1,\"characteristic\":\"\",\"dateAdd\":\"2017-03-26 16:03:27\",\"id\":6,\"logisticsId\":0,\"minPrice\":0,\"name\":\"1111\",\"numberFav\":0,\"numberGoodReputation\":0,\"numberOrders\":0,\"originalPrice\":0,\"paixu\":0,\"pic\":\"https://cdn.it120.cc/apifactory/2017/03/26/9ade208ed4b8db9155d4bd6cb82401ea.png\",\"propertyIds\":\",1,2,4,\",\"recommendStatus\":0,\"recommendStatusStr\":\"普通\",\"shopId\":0,\"status\":0,\"statusStr\":\"上架\",\"stores\":0,\"userId\":2,\"views\":0},{\"categoryId\":1,\"characteristic\":\"\",\"dateAdd\":\"2017-03-26 16:02:24\",\"id\":5,\"logisticsId\":0,\"minPrice\":0,\"name\":\"1111\",\"numberFav\":0,\"numberGoodReputation\":0,\"numberOrders\":0,\"originalPrice\":0,\"paixu\":0,\"pic\":\"https://cdn.it120.cc/apifactory/2017/03/26/9ade208ed4b8db9155d4bd6cb82401ea.png\",\"propertyIds\":\",1,2,4,\",\"recommendStatus\":0,\"recommendStatusStr\":\"普通\",\"shopId\":0,\"status\":0,\"statusStr\":\"上架\",\"stores\":0,\"userId\":2,\"views\":0}],\"msg\":\"success\"}";
    }

    //获取商品详情接口
    //参数名	数据类型	备注	必填
    //id	int	商品编号	Y
    @GetMapping("/detail")
    public String detail(@RequestParam int id){
        return "{\"code\":0,\"data\":{\"logistics\":{\"isFree\":false,\"feeType\":0,\"feeTypeStr\":\"按件数\",\"details\":[{\"addAmount\":1,\"addNumber\":1,\"firstAmount\":1,\"firstNumber\":1,\"type\":2},{\"addAmount\":1,\"addNumber\":1,\"firstAmount\":1,\"firstNumber\":1,\"type\":1},{\"addAmount\":1,\"addNumber\":1,\"firstAmount\":1,\"firstNumber\":1,\"type\":0}]},\"category\":{\"dateAdd\":\"2017-04-02 16:01:25\",\"icon\":\"https://cdn.it120.cc/apifactory/2017/04/01/11d741126d4764129d0512a07a4fa8a9.jpeg\",\"id\":19,\"isUse\":true,\"key\":\"naifen\",\"name\":\"宝宝奶粉\",\"paixu\":0,\"pid\":0,\"type\":\"demo1\",\"userId\":2},\"pics\":[{\"goodsId\":728,\"id\":4754,\"pic\":\"https://cdn.it120.cc/apifactory/2017/06/30/2be1859c58ed3276bd0bf173336ca6aa.jpeg\"}],\"content\":\"<p>啊但是所</p>\",\"basicInfo\":{\"categoryId\":19,\"characteristic\":\"\",\"dateAdd\":\"2017-06-30 09:01:07\",\"id\":728,\"logisticsId\":3,\"minPrice\":111,\"name\":\"商品名称\",\"numberFav\":0,\"numberGoodReputation\":0,\"numberOrders\":0,\"originalPrice\":111,\"paixu\":0,\"pic\":\"https://cdn.it120.cc/apifactory/2017/06/30/2be1859c58ed3276bd0bf173336ca6aa.jpeg\",\"recommendStatus\":0,\"recommendStatusStr\":\"普通\",\"shopId\":0,\"status\":0,\"statusStr\":\"上架\",\"stores\":1111,\"userId\":2,\"views\":4}},\"msg\":\"success\"}";
    }


    //选择规格和尺寸获取商品价格
    //参数名	数据类型	备注	必填
    //goodsId	int	商品编号	Y
    //propertyChildIds	String	选择的规格尺寸信息：如：4:15,2:10,1:4 。多个规格请用英文的逗号分割，4:15 中的 4 获取代表颜色，15 或许代表 土豪金	Y
    @GetMapping("/price")
    public String price(){
        return "{\"code\":0,\"data\":{\"goodsId\":8,\"id\":214,\"originalPrice\":1000,\"price\":500,\"propertyChildIds\":\"2:10,\",\"stores\":2},\"msg\":\"success\"}";
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
    public String reputation(@RequestParam int goodsId,
                             Page page){
        return "{\"code\":0,\"data\":[{\"goods\":{\"amount\":1998,\"goodsId\":11,\"goodsName\":\"无物流无规格商品测试\",\"id\":19,\"number\":2,\"orderId\":14,\"pic\":\"https://cdn.it120.cc/apifactory/2017/03/27/dce24d7c6f0f6e8256fdbf9c43b84d9e.jpeg\"}},{\"goods\":{\"amount\":1998,\"goodsId\":11,\"goodsName\":\"无物流无规格商品测试\",\"id\":17,\"number\":2,\"orderId\":13}},{\"goods\":{\"amount\":1998,\"goodsId\":11,\"goodsName\":\"无物流无规格商品测试\",\"id\":15,\"number\":2,\"orderId\":12}},{\"goods\":{\"amount\":1998,\"goodsId\":11,\"goodsName\":\"无物流无规格商品测试\",\"id\":13,\"number\":2,\"orderId\":11,\"uid\":3},\"user\":{\"avatarUrl\":\"https://cdn.it120.cc/apifactory/2017/03/27/dce24d7c6f0f6e8256fdbf9c43b84d9e.jpeg\",\"city\":\"Hangzhou\",\"dateAdd\":\"2017-02-16 14:47:02\",\"dateLogin\":\"2017-04-26 19:18:36\",\"id\":3,\"ipAdd\":\"127.0.0.1\",\"ipLogin\":\"122.233.161.18\",\"nick\":\"张三\",\"province\":\"Zhejiang\",\"source\":0,\"sourceStr\":\"小程序\",\"status\":0,\"statusStr\":\"默认\"}},{\"goods\":{\"amount\":1998,\"goodsId\":11,\"goodsName\":\"无物流无规格商品测试\",\"id\":8,\"number\":2,\"orderId\":8,\"uid\":3},\"user\":{\"avatarUrl\":\"https://cdn.it120.cc/apifactory/2017/03/27/dce24d7c6f0f6e8256fdbf9c43b84d9e.jpeg\",\"city\":\"Hangzhou\",\"dateAdd\":\"2017-02-16 14:47:02\",\"dateLogin\":\"2017-04-26 19:18:36\",\"id\":3,\"ipAdd\":\"127.0.0.1\",\"ipLogin\":\"122.233.161.18\",\"nick\":\"张三\",\"province\":\"Zhejiang\",\"source\":0,\"sourceStr\":\"小程序\",\"status\":0,\"statusStr\":\"默认\"}},{\"goods\":{\"amount\":1998,\"goodsId\":11,\"goodsName\":\"无物流无规格商品测试\",\"id\":7,\"number\":2,\"orderId\":7,\"uid\":3},\"user\":{\"avatarUrl\":\"https://cdn.it120.cc/apifactory/2017/03/27/dce24d7c6f0f6e8256fdbf9c43b84d9e.jpeg\",\"city\":\"Hangzhou\",\"dateAdd\":\"2017-02-16 14:47:02\",\"dateLogin\":\"2017-04-26 19:18:36\",\"id\":3,\"ipAdd\":\"127.0.0.1\",\"ipLogin\":\"122.233.161.18\",\"nick\":\"张三\",\"province\":\"Zhejiang\",\"source\":0,\"sourceStr\":\"小程序\",\"status\":0,\"statusStr\":\"默认\"}},{\"goods\":{\"amount\":1998,\"goodsId\":11,\"goodsName\":\"无物流无规格商品测试\",\"id\":6,\"number\":2,\"orderId\":6,\"uid\":3},\"user\":{\"avatarUrl\":\"https://cdn.it120.cc/apifactory/2017/03/27/dce24d7c6f0f6e8256fdbf9c43b84d9e.jpeg\",\"city\":\"Hangzhou\",\"dateAdd\":\"2017-02-16 14:47:02\",\"dateLogin\":\"2017-04-26 19:18:36\",\"id\":3,\"ipAdd\":\"127.0.0.1\",\"ipLogin\":\"122.233.161.18\",\"nick\":\"张三\",\"province\":\"Zhejiang\",\"source\":0,\"sourceStr\":\"小程序\",\"status\":0,\"statusStr\":\"默认\"}},{\"goods\":{\"amount\":1998,\"goodsId\":11,\"goodsName\":\"无物流无规格商品测试\",\"id\":4,\"number\":2,\"orderId\":4,\"uid\":3},\"user\":{\"avatarUrl\":\"https://cdn.it120.cc/apifactory/2017/03/27/dce24d7c6f0f6e8256fdbf9c43b84d9e.jpeg\",\"city\":\"Hangzhou\",\"dateAdd\":\"2017-02-16 14:47:02\",\"dateLogin\":\"2017-04-26 19:18:36\",\"id\":3,\"ipAdd\":\"127.0.0.1\",\"ipLogin\":\"122.233.161.18\",\"nick\":\"张三\",\"province\":\"Zhejiang\",\"source\":0,\"sourceStr\":\"小程序\",\"status\":0,\"statusStr\":\"默认\"}}],\"msg\":\"success\"}";
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
    public String kanjiaList(Page page){
        return "{\"code\":0,\"data\":{\"result\":[{\"dateAdd\":\"2018-03-31 20:09:16\",\"dateEnd\":\"2018-08-31 12:00:00\",\"goodsId\":1,\"id\":2,\"minPrice\":4,\"number\":2,\"originalPrice\":3}],\"totalRow\":1,\"totalPage\":1},\"msg\":\"success\"}";
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
    public String pingtuanList(@RequestParam int goodsId){
        return "{\"code\":0,\"data\":[{\"apiExtUser\":{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/0GSxicfbjp6foicbXqbcbbBbCrDOgEInAhqZwATQ69LpvTia5oibN6T96rs9nib5CYkgvrEdq7ibwNZMiadmOtzqALjFg/0\",\"nick\":\"Kutche\"},\"dateAdd\":\"2018-05-02 13:04:22\",\"dateEnd\":\"2018-05-03 13:04:22\",\"helpNumber\":1,\"id\":3,\"uid\":332591},{\"apiExtUser\":{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/XOqGlHkydicVWUW5OjnvtuoJ5uDg70Bz0xiaoQRwM6h6BF74C9JRZhaIzxS7RjYrDu8VVHAE6ASCrCm2SXzQT7EA/0\",\"nick\":\"Apollo&丸子君\"},\"dateAdd\":\"2018-05-02 13:01:37\",\"dateEnd\":\"2018-05-03 13:01:37\",\"helpNumber\":2,\"id\":2,\"uid\":319056}],\"msg\":\"success\"}";
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
    public String pingtuanSet(@RequestParam int goodsId){
        return "{\"code\":0,\"data\":{\"dateAdd\":\"2018-05-02 13:00:33\",\"dateEnd\":\"2018-05-31 12:00:00\",\"id\":3,\"numberDoing\":2,\"numberPersion\":2,\"numberSucccess\":199,\"refundType\":1,\"refundTypeStr\":\"禁用\",\"status\":0,\"statusStr\":\"正常\",\"timeoutHours\":24},\"msg\":\"success\"}";
    }



}