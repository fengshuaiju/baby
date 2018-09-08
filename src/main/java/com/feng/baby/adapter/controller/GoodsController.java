package com.feng.baby.adapter.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.feng.baby.application.command.AddShopCar;
import com.feng.baby.application.command.GoodFavChanged;
import com.feng.baby.application.command.ShopCarDel;
import com.feng.baby.application.command.ShopCarUpdate;
import com.feng.baby.application.representation.BasicInfo;
import com.feng.baby.application.representation.Category;
import com.feng.baby.application.representation.GoodsFav;
import com.feng.baby.application.service.CategoryService;
import com.feng.baby.application.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/search")
    public Page<BasicInfo> search(@RequestParam(required = false) String keyWord,
                                  @RequestParam(required = false) String categoryId,
                                  Pageable pageable) {
        return goodsService.search(keyWord, categoryId, pageable);
    }

    //获取商品详情接口
    @GetMapping("/detail")
    public JSONObject detail(@RequestParam(required = false) String goodsId) {
        return JSONObject.parseObject(JSON.toJSONString(goodsService.goodsDetails(goodsId)));
    }

    //商品评价
    //    参数名	数据类型	备注	必填
    //    goodsId	int	商品编号数字id	Y
    //    page	int	获取第几页数据，不传默认为1	X
    //    pageSize	int	每页显示多少条数据，不传默认50	X
    @GetMapping("/reputation")
    public JSON reputation(@RequestParam int goodsId, Pageable page) {
        return JSONObject.parseArray("[{\"goods\":{\"amount\":699,\"dateReputation\":\"2018-08-04 13:20:00\",\"goodReputation\":2,\"goodReputationRemark\":\"系统默认好评\",\"goodReputationStr\":\"好评\",\"goodsId\":30164,\"goodsName\":\"清欢严选商城小程序端模版（API工厂授权版）\",\"id\":143452,\"number\":1,\"orderId\":129093,\"pic\":\"https://cdn.it120.cc/apifactory/2018/05/19/84833eee6df34fa550cd7644b2242cf5.png\",\"property\":\"选择版本:开发版（未加密版本）,选择服务:不要服务\",\"score\":0,\"uid\":479628,\"userId\":797},\"user\":{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqauia5D89LQ2ibFteJJibxtlIdibmubJwAvNJVtqZia8BcuZXGKT30Re5GR890Se5hGp3qxZnI0ByEV6A/132\",\"city\":\"Ningbo\",\"dateAdd\":\"2018-07-20 00:08:21\",\"dateLogin\":\"2018-07-27 22:33:16\",\"id\":479628,\"ipAdd\":\"58.39.4.73\",\"ipLogin\":\"124.160.218.153\",\"isIdcardCheck\":false,\"nick\":\"烧不死的鸟\",\"province\":\"Zhejiang\",\"source\":0,\"sourceStr\":\"小程序\",\"status\":0,\"statusStr\":\"默认\"}},{\"goods\":{\"amount\":299,\"dateReputation\":\"2018-08-02 17:20:00\",\"goodReputation\":2,\"goodReputationRemark\":\"系统默认好评\",\"goodReputationStr\":\"好评\",\"goodsId\":30164,\"goodsName\":\"清欢严选商城小程序端模版（API工厂授权版）\",\"id\":142978,\"number\":1,\"orderId\":128654,\"pic\":\"https://cdn.it120.cc/apifactory/2018/05/19/84833eee6df34fa550cd7644b2242cf5.png\",\"property\":\"选择版本:授权版（加密版本）,选择服务:不要服务\",\"score\":0,\"uid\":440164,\"userId\":797},\"user\":{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83epdCL3iarl80qbBCyU1yb5CVGzgfw60vKq3RUwUwkKdibuIJ7aAibCQZBFfVjNhYrG6tiaqiadvzWvCkQg/132\",\"city\":\"Datong\",\"dateAdd\":\"2018-06-20 18:43:01\",\"dateLogin\":\"2018-07-25 14:23:15\",\"id\":440164,\"ipAdd\":\"221.218.168.106\",\"ipLogin\":\"223.20.70.155\",\"isIdcardCheck\":false,\"nick\":\"\uD83D\uDC7F林大爷\uD83D\uDE08\",\"province\":\"Shanxi\",\"source\":0,\"sourceStr\":\"小程序\",\"status\":0,\"statusStr\":\"默认\"}},{\"goods\":{\"amount\":699,\"dateReputation\":\"2018-08-02 15:20:00\",\"goodReputation\":2,\"goodReputationRemark\":\"系统默认好评\",\"goodReputationStr\":\"好评\",\"goodsId\":30164,\"goodsName\":\"清欢严选商城小程序端模版（API工厂授权版）\",\"id\":142955,\"number\":1,\"orderId\":128632,\"pic\":\"https://cdn.it120.cc/apifactory/2018/05/19/84833eee6df34fa550cd7644b2242cf5.png\",\"property\":\"选择版本:开发版（未加密版本）,选择服务:不要服务\",\"score\":0,\"uid\":473308,\"userId\":797},\"user\":{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/vicPQEWfsMEL4Ak4710UevZm6q1g7CBWaaNmeDfdfJFglOucambtIW16eAoicBAb3krBEj99RVoXPz6f3fGd5VicQ/132\",\"city\":\"Wuhan\",\"dateAdd\":\"2018-07-15 15:28:26\",\"dateLogin\":\"2018-07-27 09:13:36\",\"id\":473308,\"ipAdd\":\"14.127.249.250\",\"ipLogin\":\"112.97.59.146\",\"isIdcardCheck\":false,\"nick\":\"彭雪峰\",\"province\":\"Hubei\",\"source\":0,\"sourceStr\":\"小程序\",\"status\":0,\"statusStr\":\"默认\"}},{\"goods\":{\"amount\":299,\"dateReputation\":\"2018-07-31 21:20:00\",\"goodReputation\":2,\"goodReputationRemark\":\"系统默认好评\",\"goodReputationStr\":\"好评\",\"goodsId\":30164,\"goodsName\":\"清欢严选商城小程序端模版（API工厂授权版）\",\"id\":142506,\"number\":1,\"orderId\":128209,\"pic\":\"https://cdn.it120.cc/apifactory/2018/05/19/84833eee6df34fa550cd7644b2242cf5.png\",\"property\":\"选择版本:授权版（加密版本）,选择服务:不要服务\",\"score\":0,\"uid\":476371,\"userId\":797},\"user\":{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqJVZ7GAyickbcvHPc0cac9jeSajCmxVhLKevLBYibN1L7dWDYVHX9AI3vvKqian4lqW6j0YKaHRK4hQ/132\",\"city\":\"Shenzhen\",\"dateAdd\":\"2018-07-17 13:47:41\",\"dateLogin\":\"2018-07-19 14:58:28\",\"id\":476371,\"ipAdd\":\"113.104.193.107\",\"ipLogin\":\"113.104.192.220\",\"isIdcardCheck\":false,\"nick\":\"AAA 王老吉 - 小程序搜索数码黑市\",\"province\":\"Guangdong\",\"source\":0,\"sourceStr\":\"小程序\",\"status\":0,\"statusStr\":\"默认\"}},{\"goods\":{\"amount\":699,\"dateReputation\":\"2018-07-28 23:10:47\",\"goodReputation\":2,\"goodReputationRemark\":\"非常愉快的一次购物！\",\"goodReputationStr\":\"好评\",\"goodsId\":30164,\"goodsName\":\"清欢严选商城小程序端模版（API工厂授权版）\",\"id\":144727,\"number\":1,\"orderId\":130318,\"pic\":\"https://cdn.it120.cc/apifactory/2018/05/19/84833eee6df34fa550cd7644b2242cf5.png\",\"property\":\"选择版本:开发版（未加密版本）,选择服务:不要服务\",\"score\":0,\"uid\":409613,\"userId\":797},\"user\":{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKF4iaHDMSx6icLHonC7Bs0zJyEc9xqKRHX9j2BLXpP0yhM7woSxlPRoLb8iaib2K0zh2f80QFZKlGJMQ/132\",\"city\":\"Fuzhou\",\"dateAdd\":\"2018-05-30 10:41:36\",\"dateLogin\":\"2018-08-07 14:37:29\",\"id\":409613,\"ipAdd\":\"120.40.86.200\",\"ipLogin\":\"111.147.216.211\",\"isIdcardCheck\":false,\"nick\":\"蒋佳龙\",\"province\":\"Fujian\",\"source\":0,\"sourceStr\":\"小程序\",\"status\":0,\"statusStr\":\"默认\"}},{\"goods\":{\"amount\":699,\"dateReputation\":\"2018-07-27 10:20:00\",\"goodReputation\":2,\"goodReputationRemark\":\"系统默认好评\",\"goodReputationStr\":\"好评\",\"goodsId\":30164,\"goodsName\":\"清欢严选商城小程序端模版（API工厂授权版）\",\"id\":141092,\"number\":1,\"orderId\":126867,\"pic\":\"https://cdn.it120.cc/apifactory/2018/05/19/84833eee6df34fa550cd7644b2242cf5.png\",\"property\":\"选择版本:开发版（未加密版本）,选择服务:不要服务\",\"score\":0,\"uid\":393611,\"userId\":797},\"user\":{\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83erSEPq6PFPicKkFsgvnK8mgOrnKgYicQS24pgs3b362IuELD8upkh0W7UbnCI6z1HEvl2hvfOII6BIg/132\",\"city\":\"\",\"dateAdd\":\"2018-05-21 15:08:09\",\"dateLogin\":\"2018-07-30 13:58:49\",\"id\":393611,\"ipAdd\":\"180.169.134.134\",\"ipLogin\":\"180.97.201.17\",\"isIdcardCheck\":false,\"nick\":\"Anla® stackoverflow from dayday\",\"province\":\"\",\"source\":0,\"sourceStr\":\"小程序\",\"status\":0,\"statusStr\":\"默认\"}}]");
    }


    ////////////////////
    //添加购物车
    @PostMapping("/shop-car")
    @ResponseStatus(HttpStatus.CREATED)
    public void addShopCar(@RequestBody AddShopCar shopCar) {
        goodsService.addShopCar(shopCar.getShoppingCartId(), shopCar.getUsername(), shopCar.getGoodsId(), shopCar.getPropertyChildIds(), shopCar.getBuyNumber());
    }

    @GetMapping("/shop-car")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getShopCar(@RequestParam String username) {
        return goodsService.getShopCar(username);
    }

    @PutMapping("/shop-car")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateShopCar(@RequestBody ShopCarUpdate shopCarUpdate) {
        goodsService.updateShopCar(shopCarUpdate.getUsername(), shopCarUpdate.getShoppingCartId(), shopCarUpdate.getBuyNumber());
    }

    @DeleteMapping("/shop-car")
    @ResponseStatus(HttpStatus.OK)
    public void deleteShopCar(@RequestBody ShopCarDel shopCarDel) {
        goodsService.deleteShopCar(shopCarDel.getUsername(), shopCarDel.getGoodsIds());
    }


    //商品类别无限级接口
    @GetMapping("/category/all")
    public List<Category> categoryAll() {
        return categoryService.allTypes();
    }


    /////////////收藏///////////

    //添加收藏
    @PostMapping("/fav/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void newFav(@RequestBody GoodFavChanged goodFavChanged) {
        goodsService.newFav(goodFavChanged.getGoodsId(), goodFavChanged.getUsername());
    }

    //删除收藏
    @DeleteMapping("/fav/delete")
    @ResponseStatus(HttpStatus.OK)
    public void favDelete(@RequestBody GoodFavChanged goodFavChanged) {
        goodsService.favDelete(goodFavChanged.getGoodsId(), goodFavChanged.getUsername());
    }

    //获取我的收藏列别
    @GetMapping("/fav/list")
    @ResponseStatus(HttpStatus.OK)
    public Page<GoodsFav> favList(@RequestParam String username, Pageable pageable) {
        return goodsService.favList(username, pageable);
    }

    //检查某商品是否是我喜欢的
    @GetMapping("/fav/check")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Boolean> favCheck(@RequestParam String goodsId) {
        return goodsService.checkFav(goodsId);
    }


    ////////////////

    //同款推荐商品
    @GetMapping("/similar/recommend")
    @ResponseStatus(HttpStatus.OK)
    public Page<BasicInfo> similar(@RequestParam String categoryId, Pageable pageable) {
        return goodsService.similar(categoryId, pageable);
    }

    //猜你喜欢
    @GetMapping("/guess/like")
    @ResponseStatus(HttpStatus.OK)
    public Page<BasicInfo> guessLike(@RequestParam String username, Pageable pageable) {
        return goodsService.guessLike(username, pageable);
    }


}