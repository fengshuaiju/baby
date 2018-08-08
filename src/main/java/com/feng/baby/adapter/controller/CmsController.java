package com.feng.baby.adapter.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fengshuaiju on 2018-06-29.
 */
@Slf4j
@RestController
@RequestMapping("/cms")
public class CmsController {

    @GetMapping("/category/list")
    public JSON categoryList(){
        return JSONObject.parseArray("[{\"dateAdd\":\"2018-03-02 18:47:33\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/03/07/f62ae7a5ec69f040f801cf6ad81627f2.png\",\"id\":1561,\"isUse\":true,\"key\":\"1\",\"level\":1,\"name\":\"严选推荐\",\"paixu\":1,\"pid\":0,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-03-10 23:08:20\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/03/07/5f08c595d1d60961fecf4e68044272b4.png\",\"id\":1587,\"isUse\":true,\"key\":\"2\",\"level\":1,\"name\":\"口碑商品\",\"paixu\":2,\"pid\":0,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-03-10 23:08:58\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/03/07/31a97db0b0db6dfdf2194375b6ce4115.png\",\"id\":1588,\"isUse\":true,\"key\":\"3\",\"level\":1,\"name\":\"特色系列\",\"paixu\":3,\"pid\":0,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-03-10 23:09:49\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/03/07/eff6f231c0911442a2836f7f2c892a18.png\",\"id\":1590,\"isUse\":true,\"key\":\"4\",\"level\":1,\"name\":\"严选LOOK\",\"paixu\":4,\"pid\":0,\"type\":\"\",\"userId\":797},{\"dateAdd\":\"2018-03-10 23:09:19\",\"icon\":\"https://cdn.it120.cc/apifactory/2018/03/07/3ecd2f56395017129a0990640e18457f.png\",\"id\":1589,\"isUse\":true,\"key\":\"5\",\"level\":1,\"name\":\"十点一刻\",\"paixu\":5,\"pid\":0,\"type\":\"\",\"userId\":797}]");
    }

    @GetMapping("/news/detail")
    public JSONObject newsDetail(@RequestParam(required = false) Integer id){

        if(3473 == id){
            return JSONObject.parseObject("{\"author\":\"丸子君\",\"categoryId\":1561,\"commentNumber\":33,\"content\":\"<p>大佬云集的互联网大会刚刚落幕，一年一次的“丁磊饭局”，依然是大家津津乐道的谈资。今年丸子君给大佬们带来的是“全猪宴”，美颜脚圈、糖醋排骨、蒜蓉白肉、白封肉4道硬菜，撑起饭局的半壁江山。</p><p>如果说去年的味央黑猪肉，是大佬们才能吃到的饭局特供，那现在的黑猪，已经走进了大多数人家的餐桌。而且和去年最大的区别是，饭局上的黑猪肉，已经可以买到大佬同款了！我们上架了鲜宴礼盒、飨宴礼盒及安心猪油，这场“顶级饭局”的主食材，都在里面啦。</p><p>飨宴礼盒中人气最高的肋排部位，肉厚骨细，松软无筋，裹上调汁制成饭局上桂花小排，惊艳了四座。黑猪猪蹄，用来烹制美颜脚圈，脂肪少，胶质足，一口咬下去满满的胶原蛋白。饭局上引人注目的白封肉，最能考验猪肉的品质，黑猪们“蹲马桶、住公寓、吃液态猪粮、喝深层地下水”，慢养300天后的肌间脂肪饱满，制作出的白切肉干净透明，切下去有切慕斯的手感，如果想品尝好肉本来的味道，试试这样烹制礼盒中的五花肉，滋味一定不会让你失望。</p><p>希望大佬们品尝到的顶级舌尖美味，你也能轻松拥有。</p><p style=\\\"text-align: center;\\\"><img src=\\\"https://cdn.it120.cc/apifactory/2018/03/14/b095170fac3749a3792e6de7cfa9adbe.png\\\" title=\\\"apifactory/2018/03/14/b095170fac3749a3792e6de7cfa9adbe.png\\\" alt=\\\"111.png\\\"/>&nbsp;大佬同款黑猪肉推荐&nbsp;<img src=\\\"https://cdn.it120.cc/apifactory/2018/03/14/086760e6c89a0f4e7993eba54b60ea07.png\\\" title=\\\"apifactory/2018/03/14/086760e6c89a0f4e7993eba54b60ea07.png\\\" alt=\\\"2222.png\\\"/></p>\",\"dateAdd\":\"2018-03-12 20:20:20\",\"dateUpdate\":\"2018-08-07 19:19:22\",\"descript\":\"舌尖上的未央猪骨汤\",\"id\":3473,\"income\":\"29起\",\"isRecommend\":false,\"keywords\":\"36888,36889,36890,36891\",\"paixu\":1,\"pic\":\"https://cdn.it120.cc/apifactory/2018/03/14/eb6ac972f9dde0dfb7ff8fda01992c3e.jpg\",\"status\":2,\"statusStr\":\"审核通过\",\"tags\":\"\",\"title\":\"《舌尖》看不够？用味央猪解解馋\",\"uid\":0,\"unusefulNumber\":0,\"usefulNumber\":0,\"userId\":797,\"views\":29952}");
        }

        if(3474 == id){
            return JSONObject.parseObject("{\"author\":\"丸子君\",\"categoryId\":1561,\"commentNumber\":33,\"content\":\"<p>“无论是近几年流行‘逃离北上广’，还是备受好评的皮克斯电影《寻梦环游记》，回归故乡和家庭寻求温暖和慰藉是永恒的话题。不知道即将到来的节日，你是否能和家人团聚？如果你还未踏上回家的路，那我向你推荐一款速食鸡汤，即使你在异乡漂泊，也少吃外卖，喝一碗有家的味道的鸡汤。</p><p>除了白果炖鸡汤，我们的冰糖银耳莲子羹也是不错的，微甜，好喝，很适合女生，希望大家喜欢。”</p>\",\"dateAdd\":\"2018-03-12 21:35:07\",\"dateUpdate\":\"2018-08-07 19:22:44\",\"descript\":\"鸡汤、银耳羹即食好物\",\"id\":3474,\"income\":\"\",\"isRecommend\":false,\"keywords\":\"30164,36894\",\"paixu\":2,\"pic\":\"https://cdn.it120.cc/apifactory/2018/03/14/3417249759125d9967eb353980be0e7e.jpg\",\"status\":2,\"statusStr\":\"审核通过\",\"tags\":\"\",\"title\":\"别吃外卖了，来喝碗鸡汤\",\"uid\":0,\"unusefulNumber\":0,\"usefulNumber\":0,\"userId\":797,\"views\":28919}");
        }

        if(3489 == id){
            return JSONObject.parseObject("{\"author\":\"丸子君\",\"categoryId\":1587,\"commentNumber\":33,\"content\":\"<p><img src=\\\"https://cdn.it120.cc/apifactory/2018/03/14/e192c1e328cd894dd7e5d4dfd4125f75.jpg\\\" title=\\\"apifactory/2018/03/14/e192c1e328cd894dd7e5d4dfd4125f75.jpg\\\" alt=\\\"12312321324.jpg\\\"/>&nbsp;</p>\",\"dateAdd\":\"2018-03-14 15:03:49\",\"dateUpdate\":\"2018-08-07 19:23:26\",\"descript\":\"味道是台时光机，带我们回家\",\"id\":3489,\"income\":\"\",\"isRecommend\":false,\"keywords\":\"36907,36888,37531\",\"paixu\":3,\"pic\":\"https://cdn.it120.cc/apifactory/2018/03/14/764c5dfe2022047f08ec55fd155d2a81.jpg\",\"status\":2,\"statusStr\":\"审核通过\",\"tags\":\"\",\"title\":\"难忘的食物都有家的味道\",\"uid\":0,\"unusefulNumber\":0,\"usefulNumber\":0,\"userId\":797,\"views\":28625}");
        }

        return null;

    }

    @GetMapping("/news/list")
    public JSON newsList(){
        return JSONObject.parseArray("[{\"author\":\"丸子君\",\"categoryId\":1561,\"commentNumber\":36,\"dateAdd\":\"2018-03-12 20:20:20\",\"dateUpdate\":\"2018-08-08 16:31:28\",\"descript\":\"舌尖上的未央猪骨汤\",\"id\":3473,\"income\":\"29起\",\"isRecommend\":false,\"keywords\":\"36888,36889,36890,36891\",\"paixu\":1,\"pic\":\"https://cdn.it120.cc/apifactory/2018/03/14/eb6ac972f9dde0dfb7ff8fda01992c3e.jpg\",\"status\":2,\"statusStr\":\"审核通过\",\"tags\":\"\",\"title\":\"《舌尖》看不够？用味央猪解解馋\",\"uid\":0,\"unusefulNumber\":0,\"usefulNumber\":0,\"userId\":797,\"views\":30378},{\"author\":\"丸子君\",\"categoryId\":1561,\"commentNumber\":36,\"dateAdd\":\"2018-03-12 21:35:07\",\"dateUpdate\":\"2018-08-08 16:31:28\",\"descript\":\"鸡汤、银耳羹即食好物\",\"id\":3474,\"income\":\"\",\"isRecommend\":false,\"keywords\":\"30164,36894\",\"paixu\":2,\"pic\":\"https://cdn.it120.cc/apifactory/2018/03/14/3417249759125d9967eb353980be0e7e.jpg\",\"status\":2,\"statusStr\":\"审核通过\",\"tags\":\"\",\"title\":\"别吃外卖了，来喝碗鸡汤\",\"uid\":0,\"unusefulNumber\":0,\"usefulNumber\":0,\"userId\":797,\"views\":29337},{\"author\":\"丸子君\",\"categoryId\":1587,\"commentNumber\":36,\"dateAdd\":\"2018-03-14 15:03:49\",\"dateUpdate\":\"2018-08-08 16:31:28\",\"descript\":\"味道是台时光机，带我们回家\",\"id\":3489,\"income\":\"\",\"isRecommend\":false,\"keywords\":\"36907,36888,37531\",\"paixu\":3,\"pic\":\"https://cdn.it120.cc/apifactory/2018/03/14/764c5dfe2022047f08ec55fd155d2a81.jpg\",\"status\":2,\"statusStr\":\"审核通过\",\"tags\":\"\",\"title\":\"难忘的食物都有家的味道\",\"uid\":0,\"unusefulNumber\":0,\"usefulNumber\":0,\"userId\":797,\"views\":29041}]");
    }

}
