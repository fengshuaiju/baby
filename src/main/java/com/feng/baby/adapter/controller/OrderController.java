package com.feng.baby.adapter.controller;

import com.feng.baby.application.command.CreateOrderCommand;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fengshuaiju on 2018-06-03.
 */
@RestController
@RequestMapping("/order")
public class OrderController {


    //获取用户所有的订单列表
    //参数名	数据类型	备注	必填
    //token	String	登录接口返回的登录凭证	Y
    //page	int	获取第几页的数据，不传该参数默认为1	X
    //pageSize	int	每页获取多少条数据，不传该参数默认获取50条数据	X
    //status	int	订单状态，-1 已关闭 0 待支付 1 已支付待发货 2 已发货待确认 3 确认收货待评价 4 已评价	X
    //orderNumber	String	订单编号，如：OD1703281618955938	X
    //goodReputation	int	评价状态：0 差评 1 中评 2 好评	X
    @GetMapping("/list")
    public String list(@RequestParam(required = false) int status,
                       @RequestParam(required = false) String orderNumber,
                       @RequestParam(required = false) int goodReputation){
        return "{\"code\":0,\"data\":{\"logisticsMap\":{\"11\":{\"address\":\"详细地址\",\"cityId\":330100,\"code\":\"310009\",\"dateUpdate\":\"2017-03-28 18:54:37\",\"districtId\":330108,\"id\":11,\"linkMan\":\"张飞\",\"mobile\":\"13500000001\",\"provinceId\":330000,\"status\":-1},\"12\":{\"address\":\"详细地址\",\"cityId\":330100,\"code\":\"310009\",\"dateUpdate\":\"2017-03-29 16:55:02\",\"districtId\":330108,\"id\":12,\"linkMan\":\"张飞\",\"mobile\":\"13500000001\",\"provinceId\":330000,\"shipperCode\":\"SF\",\"shipperName\":\"顺丰快递\",\"status\":3,\"traces\":\"[{\\\"AcceptStation\\\":\\\"顺丰速运 已收取快件\\\",\\\"AcceptTime\\\":\\\"2017-03-23 16:57:44\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件在【阜阳颍泉区汽车北站营业点】已装车，准备发往 【阜阳开发区集散中心】\\\",\\\"AcceptTime\\\":\\\"2017-03-23 17:21:05\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件到达 【阜阳开发区集散中心】\\\",\\\"AcceptTime\\\":\\\"2017-03-23 19:05:43\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件在【阜阳开发区集散中心】已装车，准备发往 【蚌埠龙子湖集散中心】\\\",\\\"AcceptTime\\\":\\\"2017-03-23 19:05:43\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件到达 【蚌埠龙子湖集散中心】\\\",\\\"AcceptTime\\\":\\\"2017-03-23 22:57:21\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件在【蚌埠龙子湖集散中心】已装车，准备发往 【杭州下沙中转场】\\\",\\\"AcceptTime\\\":\\\"2017-03-23 23:25:26\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件到达 【杭州下沙中转场】\\\",\\\"AcceptTime\\\":\\\"2017-03-24 07:52:11\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件在【杭州下沙中转场】已装车，准备发往 【杭州拱墅小河路营业点】\\\",\\\"AcceptTime\\\":\\\"2017-03-24 10:55:43\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件到达 【杭州拱墅小河路营业点】\\\",\\\"AcceptTime\\\":\\\"2017-03-24 14:13:42\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"正在派送途中,请您准备签收(派件人:王XX,电话:13555555555)\\\",\\\"AcceptTime\\\":\\\"2017-03-24 14:26:07\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件交给繆XX，正在派送途中（联系电话：15000000000）\\\",\\\"AcceptTime\\\":\\\"2017-03-24 15:42:15\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"已签收,感谢使用顺丰,期待再次为您服务\\\",\\\"AcceptTime\\\":\\\"2017-03-24 15:42:20\\\",\\\"Remark\\\":\\\"\\\"}]\",\"trackingNumber\":\"974259022676\"},\"13\":{\"address\":\"详细地址\",\"cityId\":330100,\"code\":\"310009\",\"dateUpdate\":\"2017-03-29 16:55:02\",\"districtId\":330108,\"id\":13,\"linkMan\":\"张飞\",\"mobile\":\"13500000001\",\"provinceId\":330000,\"shipperCode\":\"SF\",\"shipperName\":\"顺丰快递\",\"status\":3,\"traces\":\"[{\\\"AcceptStation\\\":\\\"顺丰速运 已收取快件\\\",\\\"AcceptTime\\\":\\\"2017-03-23 16:57:44\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件在【阜阳颍泉区汽车北站营业点】已装车，准备发往 【阜阳开发区集散中心】\\\",\\\"AcceptTime\\\":\\\"2017-03-23 17:21:05\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件到达 【阜阳开发区集散中心】\\\",\\\"AcceptTime\\\":\\\"2017-03-23 19:05:43\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件在【阜阳开发区集散中心】已装车，准备发往 【蚌埠龙子湖集散中心】\\\",\\\"AcceptTime\\\":\\\"2017-03-23 19:05:43\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件到达 【蚌埠龙子湖集散中心】\\\",\\\"AcceptTime\\\":\\\"2017-03-23 22:57:21\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件在【蚌埠龙子湖集散中心】已装车，准备发往 【杭州下沙中转场】\\\",\\\"AcceptTime\\\":\\\"2017-03-23 23:25:26\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件到达 【杭州下沙中转场】\\\",\\\"AcceptTime\\\":\\\"2017-03-24 07:52:11\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件在【杭州下沙中转场】已装车，准备发往 【杭州拱墅小河路营业点】\\\",\\\"AcceptTime\\\":\\\"2017-03-24 10:55:43\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件到达 【杭州拱墅小河路营业点】\\\",\\\"AcceptTime\\\":\\\"2017-03-24 14:13:42\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"正在派送途中,请您准备签收(派件人:王xx,电话:15000000000)\\\",\\\"AcceptTime\\\":\\\"2017-03-24 14:26:07\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件交给繆xx，正在派送途中（联系电话：15000000000）\\\",\\\"AcceptTime\\\":\\\"2017-03-24 15:42:15\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"已签收,感谢使用顺丰,期待再次为您服务\\\",\\\"AcceptTime\\\":\\\"2017-03-24 15:42:20\\\",\\\"Remark\\\":\\\"\\\"}]\",\"trackingNumber\":\"974259022676\"},\"14\":{\"address\":\"详细地址\",\"cityId\":330100,\"code\":\"310009\",\"dateUpdate\":\"2017-03-30 09:40:02\",\"districtId\":330108,\"id\":14,\"linkMan\":\"张飞\",\"mobile\":\"13500000001\",\"provinceId\":330000,\"status\":-1}},\"orderList\":[{\"amount\":2748,\"amountLogistics\":6,\"amountReal\":2754,\"dateAdd\":\"2017-03-30 09:40:02\",\"goodsNumber\":5,\"id\":14,\"orderNumber\":\"OD1703300265689969\",\"remark\":\"买家备注信息\",\"status\":0,\"statusStr\":\"待支付\",\"type\":0,\"uid\":4,\"userId\":2},{\"amount\":2748,\"amountLogistics\":6,\"amountReal\":2,\"dateAdd\":\"2017-03-29 09:16:11\",\"dateUpdate\":\"2017-03-30 10:49:54\",\"goodReputation\":2,\"goodReputationRemark\":\"淡饭黄齑桑德环境\",\"goodReputationStr\":\"好评\",\"goodsNumber\":5,\"id\":13,\"orderNumber\":\"OD1703290114478775\",\"remark\":\"买家备注信息\",\"status\":4,\"statusStr\":\"交易成功\",\"type\":0,\"uid\":4,\"userId\":2},{\"amount\":2748,\"amountLogistics\":6,\"amountReal\":1,\"dateAdd\":\"2017-03-29 09:16:05\",\"dateUpdate\":\"2017-03-29 15:26:56\",\"goodsNumber\":5,\"id\":12,\"orderNumber\":\"OD1703290811892547\",\"remark\":\"买家备注信息\",\"status\":2,\"statusStr\":\"已发货待确认\",\"type\":0,\"uid\":4,\"userId\":2},{\"amount\":2748,\"amountLogistics\":6,\"amountReal\":2754,\"dateAdd\":\"2017-03-28 18:54:37\",\"goodsNumber\":5,\"id\":11,\"orderNumber\":\"OD1703281618955938\",\"remark\":\"买家备注信息\",\"status\":0,\"statusStr\":\"待支付\",\"type\":0,\"uid\":4,\"userId\":2},{\"amount\":1998,\"amountLogistics\":0,\"amountReal\":0.01,\"dateAdd\":\"2017-03-28 18:35:09\",\"dateUpdate\":\"2017-03-30 09:11:48\",\"goodsNumber\":2,\"id\":8,\"orderNumber\":\"OD1703282059887810\",\"remark\":\"买家备注信息\",\"status\":3,\"statusStr\":\"待评价\",\"type\":0,\"uid\":4,\"userId\":2},{\"amount\":1998,\"amountLogistics\":0,\"amountReal\":1998,\"dateAdd\":\"2017-03-28 18:32:48\",\"dateUpdate\":\"2017-03-28 18:34:58\",\"goodsNumber\":2,\"id\":7,\"orderNumber\":\"OD1703280893481880\",\"remark\":\"买家备注信息\",\"status\":-1,\"statusStr\":\"订单关闭\",\"type\":0,\"uid\":4,\"userId\":2},{\"amount\":1998,\"amountLogistics\":0,\"amountReal\":1998,\"dateAdd\":\"2017-03-28 17:46:12\",\"dateUpdate\":\"2017-03-28 18:32:31\",\"goodsNumber\":2,\"id\":6,\"orderNumber\":\"OD1703281293549779\",\"status\":-1,\"statusStr\":\"订单关闭\",\"type\":0,\"uid\":4,\"userId\":2},{\"amount\":1998,\"amountLogistics\":0,\"amountReal\":1998,\"dateAdd\":\"2017-03-28 17:37:25\",\"dateUpdate\":\"2017-03-28 17:39:29\",\"goodsNumber\":2,\"id\":4,\"orderNumber\":\"OD1703280543837800\",\"status\":-1,\"statusStr\":\"订单关闭\",\"type\":0,\"uid\":4,\"userId\":2}],\"goodsMap\":{\"4\":[{\"amount\":1998,\"goodsId\":11,\"goodsName\":\"无物流无规格商品测试\",\"id\":4,\"number\":2,\"orderId\":4}],\"6\":[{\"amount\":1998,\"goodsId\":11,\"goodsName\":\"无物流无规格商品测试\",\"id\":6,\"number\":2,\"orderId\":6}],\"7\":[{\"amount\":1998,\"goodsId\":11,\"goodsName\":\"无物流无规格商品测试\",\"id\":7,\"number\":2,\"orderId\":7}],\"8\":[{\"amount\":1998,\"goodsId\":11,\"goodsName\":\"无物流无规格商品测试\",\"id\":8,\"number\":2,\"orderId\":8}],\"11\":[{\"amount\":1998,\"goodsId\":11,\"goodsName\":\"无物流无规格商品测试\",\"id\":13,\"number\":2,\"orderId\":11},{\"amount\":750,\"goodsId\":8,\"goodsName\":\"Mac 2016新款\",\"id\":14,\"number\":3,\"orderId\":11}],\"12\":[{\"amount\":1998,\"goodsId\":11,\"goodsName\":\"无物流无规格商品测试\",\"id\":15,\"number\":2,\"orderId\":12},{\"amount\":750,\"goodsId\":8,\"goodsName\":\"Mac 2016新款\",\"id\":16,\"number\":3,\"orderId\":12,\"property\":\"内存容量:256G\"}],\"13\":[{\"amount\":1998,\"goodsId\":11,\"goodsName\":\"无物流无规格商品测试\",\"id\":17,\"number\":2,\"orderId\":13},{\"amount\":750,\"goodsId\":8,\"goodsName\":\"Mac 2016新款\",\"id\":18,\"number\":3,\"orderId\":13,\"property\":\"内存容量:256G\"}],\"14\":[{\"amount\":1998,\"goodsId\":11,\"goodsName\":\"无物流无规格商品测试\",\"id\":19,\"number\":2,\"orderId\":14,\"pic\":\"https://cdn.it120.cc/apifactory/2017/03/27/dce24d7c6f0f6e8256fdbf9c43b84d9e.jpeg\"},{\"amount\":750,\"goodsId\":8,\"goodsName\":\"Mac 2016新款\",\"id\":20,\"number\":3,\"orderId\":14,\"pic\":\"https://cdn.it120.cc/apifactory/2017/03/26/e56a0c6e0443d416b279bcb07a890e43.png\",\"property\":\"内存容量:256G\"}]}},\"msg\":\"success\"}";
    }

    //商城订单详情接口
    //参数名	数据类型	备注	必填
    //token	String	登录接口返回的登录凭证	Y
    //id	int	订单编号	Y
    @GetMapping("/detail")
    public String detail(@RequestParam int id){
        return "{\"code\":0,\"data\":{\"orderInfo\":{\"amount\":2748,\"amountLogistics\":6,\"amountReal\":2,\"dateAdd\":\"2017-03-29 09:16:11\",\"dateUpdate\":\"2017-03-30 10:49:54\",\"goodReputation\":2,\"goodReputationRemark\":\"淡饭黄齑桑德环境\",\"goodReputationStr\":\"好评\",\"goodsNumber\":5,\"id\":13,\"orderNumber\":\"OD1703290114478775\",\"remark\":\"买家备注信息\",\"status\":4,\"statusStr\":\"交易成功\",\"type\":0,\"uid\":4,\"userId\":2},\"goods\":[{\"amount\":1998,\"goodsId\":11,\"goodsName\":\"无物流无规格商品测试\",\"id\":17,\"number\":2,\"orderId\":13},{\"amount\":750,\"goodsId\":8,\"goodsName\":\"Mac 2016新款\",\"id\":18,\"number\":3,\"orderId\":13,\"property\":\"内存容量:256G\"}],\"logistics\":{\"address\":\"详细地址\",\"cityId\":330100,\"code\":\"310009\",\"dateUpdate\":\"2017-03-29 16:55:02\",\"districtId\":330108,\"id\":13,\"linkMan\":\"张飞\",\"mobile\":\"13500000001\",\"provinceId\":330000,\"shipperCode\":\"SF\",\"shipperName\":\"顺丰快递\",\"status\":3,\"traces\":\"[{\\\"AcceptStation\\\":\\\"顺丰速运 已收取快件\\\",\\\"AcceptTime\\\":\\\"2017-03-23 16:57:44\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件在【阜阳颍泉区汽车北站营业点】已装车，准备发往 【阜阳开发区集散中心】\\\",\\\"AcceptTime\\\":\\\"2017-03-23 17:21:05\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件到达 【阜阳开发区集散中心】\\\",\\\"AcceptTime\\\":\\\"2017-03-23 19:05:43\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件在【阜阳开发区集散中心】已装车，准备发往 【蚌埠龙子湖集散中心】\\\",\\\"AcceptTime\\\":\\\"2017-03-23 19:05:43\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件到达 【蚌埠龙子湖集散中心】\\\",\\\"AcceptTime\\\":\\\"2017-03-23 22:57:21\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件在【蚌埠龙子湖集散中心】已装车，准备发往 【杭州下沙中转场】\\\",\\\"AcceptTime\\\":\\\"2017-03-23 23:25:26\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件到达 【杭州下沙中转场】\\\",\\\"AcceptTime\\\":\\\"2017-03-24 07:52:11\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件在【杭州下沙中转场】已装车，准备发往 【杭州拱墅小河路营业点】\\\",\\\"AcceptTime\\\":\\\"2017-03-24 10:55:43\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件到达 【杭州拱墅小河路营业点】\\\",\\\"AcceptTime\\\":\\\"2017-03-24 14:13:42\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"正在派送途中,请您准备签收(派件人:王XX,电话:13500000000)\\\",\\\"AcceptTime\\\":\\\"2017-03-24 14:26:07\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"快件交给繆xx，正在派送途中（联系电话：13500000000）\\\",\\\"AcceptTime\\\":\\\"2017-03-24 15:42:15\\\",\\\"Remark\\\":\\\"\\\"},{\\\"AcceptStation\\\":\\\"已签收,感谢使用顺丰,期待再次为您服务\\\",\\\"AcceptTime\\\":\\\"2017-03-24 15:42:20\\\",\\\"Remark\\\":\\\"\\\"}]\",\"trackingNumber\":\"974259022676\"},\"logs\":[{\"dateAdd\":\"2017-03-29 09:16:11\",\"id\":17,\"orderId\":13,\"type\":0,\"typeStr\":\"下单\"},{\"dateAdd\":\"2017-03-29 09:38:26\",\"id\":18,\"orderId\":13,\"type\":5,\"typeStr\":\"卖家修改价格\"},{\"dateAdd\":\"2017-03-29 13:59:58\",\"id\":24,\"orderId\":13,\"type\":1,\"typeStr\":\"支付\"},{\"dateAdd\":\"2017-03-29 14:00:07\",\"id\":25,\"orderId\":13,\"type\":2,\"typeStr\":\"发货\"},{\"dateAdd\":\"2017-03-30 10:26:35\",\"id\":31,\"orderId\":13,\"type\":3,\"typeStr\":\"确认收货\"},{\"dateAdd\":\"2017-03-30 10:49:56\",\"id\":32,\"orderId\":13,\"type\":4,\"typeStr\":\"评价\"}]},\"msg\":\"success\"}";
    }

    //商城订单创建接口
    //参数名	数据类型	备注	必填
    //token	String	登录接口返回的登录凭证	Y
    //provinceId	int	收货地址省份编码	X
    //cityId	int	收货地址城市编码	X
    //districtId	int	收货地址区县编码	X
    //address	String	收货地址详细地址	X
    //linkMan	String	收货地址联系人信息	X
    //mobile	String	收货地址联系人手机号码	X
    //code	String	收货地址邮政编码	X
    //remark	String	下单备注信息	X
    //couponId	int	使用的优惠券编号	X
    //calculate	Boolean	true 不实际下单，而是返回价格计算	X
    //idcard	String	身份证号码【国际件使用】	X
    //goodsJsonStr	String	购买的商品、规格尺寸、数量信息的数组，如：[{"goodsId":11,"number":2,"propertyChildIds":"","logisticsType":0}, {"goodsId":8,"number":3,"propertyChildIds":"2:9","logisticsType":0, "inviter_id":邀请用户ID}]	Y
    //payOnDelivery	int	1 为货到付款，其他数字为先支付	X
    //expireMinutes	int	多少分钟未支付自动关闭本订单，传0不自动关闭订单	X
    //kjid	int	砍价编号，可直接购买砍价商品	X
    //pingtuanOpenId	int	拼团购买的团号	X
    //isCanHx	Boolean	是否支持核销，true 支持，默认不支持	X
    @PostMapping("/create")
    public String orders(@RequestBody CreateOrderCommand createOrderCommand){
        return "{\"code\":0,\"data\":{\"amountLogistics\":5,\"goodsNumber\":3,\"isNeedLogistics\":true,\"amountTotle\":1662},\"msg\":\"success\"}";
    }

    //关闭订单
    //参数名	数据类型	备注	必填
    //token	String	登录接口返回的登录凭证	Y
    //orderId	int	订单编号	Y
    @GetMapping("/close")
    public String close(@RequestParam int orderId){
        return "{\"code\":0,\"msg\":\"success\"}";
    }

    //确认收货接口
    //参数名	数据类型	备注	必填
    //token	String	登录接口返回的登录凭证	Y
    //orderId	int	订单编号	Y
    @GetMapping("/delivery")
    public String delivery(@RequestParam int orderId){
        return "{\"code\":0,\"msg\":\"success\"}";
    }

    //订单数据统计接口
    //统计每种订单状态的订单数量
    @GetMapping("/statistics")
    public String statistics(){
        return "{\"code\":0,\"data\":{\"count_id_no_transfer\":0,\"count_id_no_pay\":9,\"count_id_no_confirm\":0,\"count_id_success\":4},\"msg\":\"success\"}";
    }


    //获取某订单的退款记录
    //通过订单接口的 hasRefund 字段，判断该订单有误退款，有退款的话调用本接口获取详细退款信息
    //参数名	数据类型	备注	必填
    //token	String	登录接口返回的登录凭证	Y
    //orderId	int	订单数字ID，不是订单编号	Y
    @GetMapping("/refund")
    public String refund(@RequestParam int orderId){
        return "{\"code\":0,\"data\":[{\"dateAdd\":\"2017-08-21 13:53:30\",\"dateUpdate\":\"2017-08-23 06:05:30\",\"id\":15,\"moneyPay\":1,\"moneyRefund\":0.1,\"orderId\":2777,\"payNo\":\"ZF1708212042025468\",\"refundNo\":\"TK1708210711784395\",\"remark\":\"\",\"status\":3},{\"dateAdd\":\"2017-08-21 13:32:12\",\"dateUpdate\":\"2017-08-23 06:05:30\",\"id\":14,\"moneyPay\":1,\"moneyRefund\":0.1,\"orderId\":2777,\"payNo\":\"ZF1708212042025468\",\"refundNo\":\"TK1708210191572551\",\"remark\":\"测试\",\"status\":3},{\"dateAdd\":\"2017-08-21 13:31:25\",\"dateUpdate\":\"2017-08-21 13:31:20\",\"id\":13,\"moneyPay\":1,\"moneyRefund\":1,\"orderId\":2777,\"payNo\":\"ZF1708212042025468\",\"refundNo\":\"TK1708210722285448\",\"remark\":\" 累计退款金额大于支付金额\",\"status\":4},{\"dateAdd\":\"2017-08-21 13:31:00\",\"dateUpdate\":\"2017-08-23 06:05:30\",\"id\":12,\"moneyPay\":1,\"moneyRefund\":0.1,\"orderId\":2777,\"payNo\":\"ZF1708212042025468\",\"refundNo\":\"TK1708211097832772\",\"remark\":\"\",\"status\":3},{\"dateAdd\":\"2017-08-21 13:30:05\",\"dateUpdate\":\"2017-08-21 13:29:59\",\"id\":11,\"moneyPay\":1,\"moneyRefund\":0.1,\"orderId\":2777,\"payNo\":\"ZF1708211864709228\",\"refundNo\":\"TK1708210756239382\",\"remark\":\" 订单不存在\",\"status\":4},{\"dateAdd\":\"2017-08-21 13:28:07\",\"dateUpdate\":\"2017-08-21 13:28:01\",\"id\":10,\"moneyPay\":1,\"moneyRefund\":0.1,\"orderId\":2777,\"payNo\":\"ZF1708211864709228\",\"refundNo\":\"TK1708211031987115\",\"remark\":\" 订单不存在\",\"status\":4},{\"dateAdd\":\"2017-08-21 13:27:44\",\"dateUpdate\":\"2017-08-21 13:27:38\",\"id\":9,\"moneyPay\":1,\"moneyRefund\":0.1,\"orderId\":2777,\"payNo\":\"ZF1708211864709228\",\"refundNo\":\"TK1708210590178166\",\"remark\":\" 订单不存在\",\"status\":4},{\"dateAdd\":\"2017-08-21 13:26:22\",\"dateUpdate\":\"2017-08-21 13:26:18\",\"id\":8,\"moneyPay\":1,\"moneyRefund\":0.1,\"orderId\":2777,\"payNo\":\"ZF1708211864709228\",\"refundNo\":\"TK1708211943066641\",\"remark\":\" 订单不存在\",\"status\":4},{\"dateAdd\":\"2017-08-21 13:24:43\",\"dateUpdate\":\"2017-08-21 13:24:38\",\"id\":7,\"moneyPay\":1,\"moneyRefund\":0.1,\"orderId\":2777,\"payNo\":\"ZF1708211864709228\",\"refundNo\":\"TK1708211857532872\",\"remark\":\" 订单不存在\",\"status\":4},{\"dateAdd\":\"2017-08-21 13:23:50\",\"dateUpdate\":\"2017-08-21 13:23:44\",\"id\":6,\"moneyPay\":1,\"moneyRefund\":0.1,\"orderId\":2777,\"payNo\":\"ZF1708211864709228\",\"refundNo\":\"TK1708211489218394\",\"remark\":\" 订单不存在\",\"status\":4},{\"dateAdd\":\"2017-08-21 13:20:15\",\"dateUpdate\":\"2017-08-21 13:20:09\",\"id\":5,\"moneyPay\":1,\"moneyRefund\":0.1,\"orderId\":2777,\"payNo\":\"ZF1708211864709228\",\"refundNo\":\"TK1708211393598210\",\"remark\":\" 无法调用小程序支付退款接口\",\"status\":4},{\"dateAdd\":\"2017-08-21 13:19:46\",\"dateUpdate\":\"2017-08-21 13:19:40\",\"id\":4,\"moneyPay\":1,\"moneyRefund\":0.1,\"orderId\":2777,\"payNo\":\"ZF1708211864709228\",\"refundNo\":\"TK1708211859922823\",\"remark\":\" 无法调用小程序支付退款接口\",\"status\":4},{\"dateAdd\":\"2017-08-21 13:18:29\",\"dateUpdate\":\"2017-08-21 13:18:22\",\"id\":3,\"moneyPay\":1,\"moneyRefund\":0.1,\"orderId\":2777,\"refundNo\":\"TK1708212038014867\",\"remark\":\"测试 已退至用户可用余额\",\"status\":3},{\"dateAdd\":\"2017-08-21 13:17:07\",\"dateUpdate\":\"2017-08-21 13:17:01\",\"id\":2,\"moneyPay\":1,\"moneyRefund\":0.1,\"orderId\":2777,\"refundNo\":\"TK1708211239989852\",\"remark\":\" 已退至用户可用余额\",\"status\":3}],\"msg\":\"success\"}";
    }


    //用户钱包支付订单
    //参数名	数据类型	备注	必填
    //token	String	登录接口返回的登录凭证	Y
    //orderId	int	订单数字ID	Y
    @GetMapping("/pay")
    public String pay(@RequestParam int orderId){
        return "{\"code\":0,\"msg\":\"success\"}";
    }

    //
    @GetMapping("/reputation")
    public void reputation(){

    }

}
