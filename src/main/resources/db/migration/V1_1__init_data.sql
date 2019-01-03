# --------------- Mysql ---------------

# 用户信息
INSERT INTO user_info (
  user_name, cellphone, wechat_open_id, avatar_url, nick_name
) VALUES (
  'olIcM5KAax4vDCGbc-6R5Oyuvv_I', '18930061430', 'olIcM5KAax4vDCGbc-6R5Oyuvv_I',
  'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqJVZ7GAyickbcvHPc0cac9jeSajCmxVhLKevLBYibN1L7dWDYVHX9AI3vvKqian4lqW6j0YKaHRK4hQ/132',
  '阔爱'
);

INSERT INTO user_info (
  user_name, cellphone, wechat_open_id, avatar_url, nick_name
) VALUES (
  'admin', '18930061430', NULL ,
  'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqJVZ7GAyickbcvHPc0cac9jeSajCmxVhLKevLBYibN1L7dWDYVHX9AI3vvKqian4lqW6j0YKaHRK4hQ/132',
  '阔爱'
);

INSERT INTO user_account (username, score, account)
VALUES ('olIcM5KAax4vDCGbc-6R5Oyuvv_I', 0, 0.0);

# 主页滚动图片
INSERT INTO slide_container (goods_id, pic_url, is_remove, indexs, type)
VALUES ('30164', 'https://cdn.it120.cc/apifactory/2018/05/09/2e8638183135b207c97490ed95fb44ba.jpg', FALSE, 1, 'HOME');

INSERT INTO slide_container (goods_id, pic_url, is_remove, indexs, type)
VALUES ('30164', 'https://cdn.it120.cc/apifactory/2018/05/09/d1cbc05833c4fa09b1fae15593df1b63.jpg', FALSE, 1, 'HOME');

INSERT INTO slide_container (goods_id, pic_url, is_remove, indexs, type)
VALUES ('30164', 'https://cdn.it120.cc/apifactory/2018/05/09/dc11f00add7f97ee549b41b97134fe65.jpg', FALSE, 1, 'HOME');

INSERT INTO slide_container (goods_id, pic_url, is_remove, indexs, type)
VALUES ('30164', 'https://cdn.it120.cc/apifactory/2018/05/09/62c5fb354ced6e13c06d554cde479679.jpg', FALSE, 1, 'HOME');



INSERT INTO slide_container (goods_id, pic_url, is_remove, indexs, type)
VALUES ('30164', 'https://cdn.it120.cc/apifactory/2018/07/04/c98865950e4684c9f793574db58c814d.jpg', FALSE, 1, 'MENU');

INSERT INTO slide_container (goods_id, pic_url, is_remove, indexs, type)
VALUES ('30164', 'https://cdn.it120.cc/apifactory/2018/07/04/aa0f5223d156185bff69b47a0ba4189e.jpg', FALSE, 1, 'MENU');


-- 签到按钮
INSERT INTO function_menus (link_url, pic_url, is_remove, title, orders)
VALUES
  ('/pages/score/index', 'https://cdn.it120.cc/apifactory/2018/05/09/0630c87c94e2f1a4f213f7ffb5845e6d.png', FALSE, '签到',
   '1');

INSERT INTO function_menus (link_url, pic_url, is_remove, title, orders)
VALUES
  ('/pages/newcoupons/index', 'https://cdn.it120.cc/apifactory/2018/05/09/1ba413178d361771f25332ebd04f3bf7.png', FALSE,
   '礼券', '1');

INSERT INTO function_menus (link_url, pic_url, is_remove, title, orders)
VALUES
  ('/pages/kanjia-list/index', 'https://cdn.it120.cc/apifactory/2018/05/09/496a0c3e4042afbb688837358217f501.png', FALSE,
   '砍价', '1');

INSERT INTO function_menus (link_url, pic_url, is_remove, title, orders)
VALUES
  ('/pages/topic-list/index', 'https://cdn.it120.cc/apifactory/2018/05/09/88f45bf6e95ec010f1f945c414e6df03.png', FALSE,
   '专栏', '1');


INSERT INTO coupons (coupon_id, pic_url, link_url, coupon_name, amount_of_money, requirement_consumption, expiry_time_at, validity_day, remarks, is_available, type)
VALUES ('88f45bf6e95ec010f1f945c414e6df03',
        'https://cdn.it120.cc/apifactory/2018/06/26/f1e90deac271101c805f1db52f9ba5da.png',
        'https://cdn.it120.cc/apifactory/2018/05/18/8b5875faf90d1b2fdc353dfbc5d6d1b3.png', '新人优惠券', 5, 35, '2037-09-09', 30,
        '新人优惠券,满35元可用', TRUE, 'WELCOME');

INSERT INTO coupons (coupon_id, pic_url, link_url, coupon_name, amount_of_money, requirement_consumption, expiry_time_at, validity_day, remarks, is_available, type)
VALUES ('1ba413178d361771f25332ebd04f3bf7',
        'https://cdn.it120.cc/apifactory/2018/05/18/8b5875faf90d1b2fdc353dfbc5d6d1b3.png',
        'https://cdn.it120.cc/apifactory/2018/06/26/f1e90deac271101c805f1db52f9ba5da.png', '惊喜优惠券', 5, 35, '2037-09-09', 30,
        '普通通用性优惠券', TRUE, 'DISCOUNT');

# 分类页面

INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('69abffa2-8b1b-4f8d-8bb8-630f4a044d69', 1, '家居生活', '0', TRUE, '', 1);


INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('a21fdb8c-6f7e-4691-ade7-caf82453f33f', 1, '配件装饰', '0', TRUE, '', 2);


INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('b37bcf75-ae1c-4d29-9419-d1af1f1e317e', 1, '新品服装', '0', TRUE, '', 3);


INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('43274803-428e-450a-9dc5-176ccbdfb53d', 2, '床品', '69abffa2-8b1b-4f8d-8bb8-630f4a044d69', TRUE, 'https://cdn.it120.cc/apifactory/2018/05/24/772862baa0197b71c5eee745542c956f.png', 1);

INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('ced892ca-1a8f-4c27-beb3-396a46f94f50', 2, '布艺', '69abffa2-8b1b-4f8d-8bb8-630f4a044d69', TRUE, 'https://cdn.it120.cc/apifactory/2018/05/24/fd91b4091346a46acdabe22712a969c4.png', 2);


INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('d3f5ca54-0489-4d56-879a-3a94af33bc02', 2, '收纳', '69abffa2-8b1b-4f8d-8bb8-630f4a044d69', TRUE, 'https://cdn.it120.cc/apifactory/2018/05/24/4d951246d110116e16ca028437664a27.png', 3);


INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('ee922d51-9323-4abe-aaf6-e037211c91f2', 2, '宠物', '69abffa2-8b1b-4f8d-8bb8-630f4a044d69', TRUE, 'https://cdn.it120.cc/apifactory/2018/04/02/f8a757674a02ed90bd7be8f20302d043.png', 4);


INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('59bb9742-5546-41f9-8d2a-eecd204f7937', 2, '装饰', '69abffa2-8b1b-4f8d-8bb8-630f4a044d69', TRUE, 'https://cdn.it120.cc/apifactory/2018/04/02/9657ee1e7cff3c65b696b05dc9ff5ad2.png', 5);


INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('76c44658-9e36-4289-be17-ab9c9a4df32a', 2, '家具', '69abffa2-8b1b-4f8d-8bb8-630f4a044d69', TRUE, 'https://cdn.it120.cc/apifactory/2018/04/02/ccbb08b5dec9146e69bad924516bbe43.png', 6);


INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('454e9448-5118-4b71-811c-e5c20cd5b8d3', 2, '男包', 'a21fdb8c-6f7e-4691-ade7-caf82453f33f', TRUE, 'https://cdn.it120.cc/apifactory/2018/04/02/9b48f6a3c770cdc91cebe594d1c9dc9c.png', 1);

INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('453198bf-52e7-48c5-aadb-2553a494ea6c', 2, '女包', 'a21fdb8c-6f7e-4691-ade7-caf82453f33f', TRUE, 'https://cdn.it120.cc/apifactory/2018/04/02/f47c4a127a2252fb7ddda391fa439bfa.png', 2);

INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('fa4dd13c-6145-45dd-bde5-56333dc6df4f', 2, '围巾', 'a21fdb8c-6f7e-4691-ade7-caf82453f33f', TRUE, 'https://cdn.it120.cc/apifactory/2018/04/02/6ba34412fdbb97a11346c36545b1e946.png', 3);

INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('7dbe93cc-8637-444b-8cd3-d8920c54cc74', 2, '拖鞋', 'a21fdb8c-6f7e-4691-ade7-caf82453f33f', TRUE, 'https://cdn.it120.cc/apifactory/2018/04/02/ba9b544de8f486ebb3ba4044d77ff323.png', 4);

INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('44c90aae-4d5b-4dfd-9c4c-2bcfa5df7053', 2, '眼镜', 'a21fdb8c-6f7e-4691-ade7-caf82453f33f', TRUE, 'https://cdn.it120.cc/apifactory/2018/04/02/64237e0b117f7880a8b711ce72e32bf2.png', 5);


INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('e85da35d-3c9a-4201-a0fa-5c94efd7da6c', 2, '衬衫', 'b37bcf75-ae1c-4d29-9419-d1af1f1e317e', TRUE, 'https://cdn.it120.cc/apifactory/2018/04/02/f236825564bc5a27becdf26fa856782e.png', 1);

INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('d0570f6d-7e93-4d40-843b-bf4fe06d906e', 2, 'T恤', 'b37bcf75-ae1c-4d29-9419-d1af1f1e317e', TRUE, 'https://cdn.it120.cc/apifactory/2018/04/02/d0353c59382cbd8a6ff7c0e7d365b813.png', 2);

INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('37ca112c-09c3-4529-b423-b499c1f86c51',2, '卫衣', 'b37bcf75-ae1c-4d29-9419-d1af1f1e317e', TRUE, 'https://cdn.it120.cc/apifactory/2018/04/02/70f0ab3b4d26c3da3e42a65e4ce0fcac.png', 3);

INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('13ed39bc-333d-49b8-a123-6d6f9daa5294', 2, '针织', 'b37bcf75-ae1c-4d29-9419-d1af1f1e317e', TRUE, 'https://cdn.it120.cc/apifactory/2018/04/02/33f86e8983a60ca971e1a5f3d7c78bb4.png', 4);

INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('eb28254c-a804-4fa8-ad6f-d1e8aa35114e', 2, '内衣', 'b37bcf75-ae1c-4d29-9419-d1af1f1e317e', TRUE, 'https://cdn.it120.cc/apifactory/2018/04/02/982ab7b5cdd9c11b22d31c39429e190d.png', 5);

INSERT INTO category (category_id, level, name, pid, is_used, icon, indexs)
VALUES ('63ff9a09-758b-44e1-a7eb-f84bf8dd3cc6',2, '内裤', 'b37bcf75-ae1c-4d29-9419-d1af1f1e317e', TRUE, 'https://cdn.it120.cc/apifactory/2018/04/02/a59e6679df4618800d74515d29b8267c.png', 6);

# 商品信息
INSERT INTO goods (
  goods_id, category_id, name, characteristic, main_pic,  is_sales, is_support_group, remark, content, views, number_fav, number_reputation, stores, number_orders
) VALUES (
  '30164', '43274803-428e-450a-9dc5-176ccbdfb53d', '清欢严选商城小程序端模版（API工厂授权版）', '全场模版使用优惠券立减88元',
           'https://cdn.it120.cc/apifactory/2018/05/19/84833eee6df34fa550cd7644b2242cf5.png', TRUE , FALSE ,
           '提供接口服务',
  '<p style=\"text-align: left;\"><span style=\"color: rgb(255, 0, 0);\">虚拟产品因为具备可复制性，所以一经售出概不退换！</span><br/></p><p style=\"text-align: left;\"><span style=\"color: rgb(255, 0, 0); font-size: 16px;\">虚拟产品因为具备可复制性，所以一经售出概不<span style=\"color: rgb(255, 0, 0); font-size: 16px;\"><span style=\"color: rgb(255, 0, 0);\">退换</span>！</span></span></p><p style=\"text-align: left;\"><span style=\"color: rgb(255, 0, 0); font-size: 16px;\">虚拟产品因为具备可复制性，所以一经售出概不<span style=\"color: rgb(255, 0, 0); font-size: 16px;\"><span style=\"color: rgb(255, 0, 0);\">退换</span>！</span></span></p><p><br/></p><p><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">购买须知（购买模版证明您知悉并同意以下条件）：</span></p><p><span style=\"font-size: 14px;\"><span style=\"font-size: 14px; color: rgb(255, 0, 0);\">1、</span><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">技术支持仅限对于现有代码，部署或配置有疑问的解答服务（不包含远程支持服务）；</span></span></p><p style=\"white-space: normal;\"><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">2、技术支持不包含页面源码修改或者新增功能的服务；</span></p><p style=\"white-space: normal;\"><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">3、购买后只要已经发送源码给您，不接受任何理由的退款和换货行为；</span></p><p><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">4、版本更新属于bug修复更新，不包括功能更新，各个功能接口属于增值项目，需要单独购买；</span></p><p><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">5、该版本为授权版本，一个工厂后台对应一套模版，如果您要多个小程序使用，需要单独购买授权；</span></p><p><br/></p><p><span style=\"font-size: 14px; color: rgb(0, 0, 0);\">购买此模版您可以得到：</span></p><p><span style=\"font-size: 14px; color: rgb(0, 0, 0);\">1、清欢严选商城小程序端整套模版源码（<strong>不包含服务端源码</strong>）；</span></p><p><span style=\"font-size: 14px; color: rgb(0, 0, 0);\">2、清欢严选商城API工厂后台配置说明文档；</span></p><p><span style=\"font-size: 14px; color: rgb(0, 0, 0);\">3、清欢模版VIP微信群加入权限；</span></p><p><span style=\"color: rgb(0, 0, 0);\"><span style=\"font-size: 14px;\">4、一周</span><strong><span style=\"font-size: 14px; text-decoration: none;\">QQ或微信在线解答模版配置相关问题</span></strong><span style=\"font-size: 14px;\">的技术支持服务；</span></span></p><p><br/></p><p><span style=\"font-size: 14px;\">怎么样购买这套模版？</span></p><p><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;1、小程序体验该模版的整个交互流程和呈现界面；<br/></span></p><p><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;2、在首页领取优惠券，或者去礼券中心领取优惠券；<br/></span></p><p><span style=\"font-size: 14px;\">&nbsp; &nbsp; 3、您有两种购买方式：一是直接购买，二是拼团购买；</span></p><p><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;4、拼团只有拼团成功后才进行发货，否则视为拼团失败；<br/></span></p><p><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;5、购买后请保存好订单付款截图，然后联系丸子君；</span><br/></p><p><br/></p><p style=\"text-align: center;\"><span style=\"color: rgb(255, 0, 0); font-size: 20px;\">再次感谢您选择丸子，支持正版！</span></p><p style=\"text-align: center;\"><span style=\"color: rgb(255, 0, 0); font-size: 20px;\">丸子QQ：1172007555</span></p><p><br/></p><p><br/></p>',
  78, 66, 13, 109, 231
);

INSERT INTO goods (
  goods_id, category_id, name, characteristic, main_pic, is_sales, is_support_group, remark, content, views, number_fav, number_reputation, stores, number_orders
) VALUES (
  '36888', '43274803-428e-450a-9dc5-176ccbdfb53d', '唤自然 仲夏椰香四件套', '100%全棉，椰林自然设计',
           'https://cdn.it120.cc/apifactory/2018/04/02/0eaf91e4696b51e326313efaec5e9b11.jpg', TRUE,
           FALSE, '让您有舒适睡眠',
  '<p style=\"text-align: left;\"><span style=\"color: rgb(255, 0, 0);\">虚拟产品因为具备可复制性，所以一经售出概不退换！</span><br/></p><p style=\"text-align: left;\"><span style=\"color: rgb(255, 0, 0); font-size: 16px;\">虚拟产品因为具备可复制性，所以一经售出概不<span style=\"color: rgb(255, 0, 0); font-size: 16px;\"><span style=\"color: rgb(255, 0, 0);\">退换</span>！</span></span></p><p style=\"text-align: left;\"><span style=\"color: rgb(255, 0, 0); font-size: 16px;\">虚拟产品因为具备可复制性，所以一经售出概不<span style=\"color: rgb(255, 0, 0); font-size: 16px;\"><span style=\"color: rgb(255, 0, 0);\">退换</span>！</span></span></p><p><br/></p><p><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">购买须知（购买模版证明您知悉并同意以下条件）：</span></p><p><span style=\"font-size: 14px;\"><span style=\"font-size: 14px; color: rgb(255, 0, 0);\">1、</span><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">技术支持仅限对于现有代码，部署或配置有疑问的解答服务（不包含远程支持服务）；</span></span></p><p style=\"white-space: normal;\"><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">2、技术支持不包含页面源码修改或者新增功能的服务；</span></p><p style=\"white-space: normal;\"><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">3、购买后只要已经发送源码给您，不接受任何理由的退款和换货行为；</span></p><p><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">4、版本更新属于bug修复更新，不包括功能更新，各个功能接口属于增值项目，需要单独购买；</span></p><p><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">5、该版本为授权版本，一个工厂后台对应一套模版，如果您要多个小程序使用，需要单独购买授权；</span></p><p><br/></p><p><span style=\"font-size: 14px; color: rgb(0, 0, 0);\">购买此模版您可以得到：</span></p><p><span style=\"font-size: 14px; color: rgb(0, 0, 0);\">1、清欢严选商城小程序端整套模版源码（<strong>不包含服务端源码</strong>）；</span></p><p><span style=\"font-size: 14px; color: rgb(0, 0, 0);\">2、清欢严选商城API工厂后台配置说明文档；</span></p><p><span style=\"font-size: 14px; color: rgb(0, 0, 0);\">3、清欢模版VIP微信群加入权限；</span></p><p><span style=\"color: rgb(0, 0, 0);\"><span style=\"font-size: 14px;\">4、一周</span><strong><span style=\"font-size: 14px; text-decoration: none;\">QQ或微信在线解答模版配置相关问题</span></strong><span style=\"font-size: 14px;\">的技术支持服务；</span></span></p><p><br/></p><p><span style=\"font-size: 14px;\">怎么样购买这套模版？</span></p><p><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;1、小程序体验该模版的整个交互流程和呈现界面；<br/></span></p><p><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;2、在首页领取优惠券，或者去礼券中心领取优惠券；<br/></span></p><p><span style=\"font-size: 14px;\">&nbsp; &nbsp; 3、您有两种购买方式：一是直接购买，二是拼团购买；</span></p><p><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;4、拼团只有拼团成功后才进行发货，否则视为拼团失败；<br/></span></p><p><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;5、购买后请保存好订单付款截图，然后联系丸子君；</span><br/></p><p><br/></p><p style=\"text-align: center;\"><span style=\"color: rgb(255, 0, 0); font-size: 20px;\">再次感谢您选择丸子，支持正版！</span></p><p style=\"text-align: center;\"><span style=\"color: rgb(255, 0, 0); font-size: 20px;\">丸子QQ：1172007555</span></p><p><br/></p><p><br/></p>',
  78, 66, 13, 109, 345
);

INSERT INTO goods (
  goods_id, category_id, name, characteristic, main_pic, is_sales, is_support_group, remark, content, views, number_fav, number_reputation, stores, number_orders
) VALUES (
  '40601', 'ee922d51-9323-4abe-aaf6-e037211c91f2', '清欢食光机Plus小程序端模版（API工厂授权版）', '全场模版使用优惠券立减88元',
           'https://cdn.it120.cc/apifactory/2018/04/12/42c001a698072b3bae9ac71f65ca2cfc.jpg', TRUE,
           FALSE, '我们提供点餐服务',
  '<p style=\"text-align: left;\"><span style=\"color: rgb(255, 0, 0);\">虚拟产品因为具备可复制性，所以一经售出概不退换！</span><br/></p><p style=\"text-align: left;\"><span style=\"color: rgb(255, 0, 0); font-size: 16px;\">虚拟产品因为具备可复制性，所以一经售出概不<span style=\"color: rgb(255, 0, 0); font-size: 16px;\"><span style=\"color: rgb(255, 0, 0);\">退换</span>！</span></span></p><p style=\"text-align: left;\"><span style=\"color: rgb(255, 0, 0); font-size: 16px;\">虚拟产品因为具备可复制性，所以一经售出概不<span style=\"color: rgb(255, 0, 0); font-size: 16px;\"><span style=\"color: rgb(255, 0, 0);\">退换</span>！</span></span></p><p><br/></p><p><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">购买须知（购买模版证明您知悉并同意以下条件）：</span></p><p><span style=\"font-size: 14px;\"><span style=\"font-size: 14px; color: rgb(255, 0, 0);\">1、</span><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">技术支持仅限对于现有代码，部署或配置有疑问的解答服务（不包含远程支持服务）；</span></span></p><p style=\"white-space: normal;\"><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">2、技术支持不包含页面源码修改或者新增功能的服务；</span></p><p style=\"white-space: normal;\"><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">3、购买后只要已经发送源码给您，不接受任何理由的退款和换货行为；</span></p><p><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">4、版本更新属于bug修复更新，不包括功能更新，各个功能接口属于增值项目，需要单独购买；</span></p><p><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">5、该版本为授权版本，一个工厂后台对应一套模版，如果您要多个小程序使用，需要单独购买授权；</span></p><p><br/></p><p><span style=\"font-size: 14px; color: rgb(0, 0, 0);\">购买此模版您可以得到：</span></p><p><span style=\"font-size: 14px; color: rgb(0, 0, 0);\">1、清欢严选商城小程序端整套模版源码（<strong>不包含服务端源码</strong>）；</span></p><p><span style=\"font-size: 14px; color: rgb(0, 0, 0);\">2、清欢严选商城API工厂后台配置说明文档；</span></p><p><span style=\"font-size: 14px; color: rgb(0, 0, 0);\">3、清欢模版VIP微信群加入权限；</span></p><p><span style=\"color: rgb(0, 0, 0);\"><span style=\"font-size: 14px;\">4、一周</span><strong><span style=\"font-size: 14px; text-decoration: none;\">QQ或微信在线解答模版配置相关问题</span></strong><span style=\"font-size: 14px;\">的技术支持服务；</span></span></p><p><br/></p><p><span style=\"font-size: 14px;\">怎么样购买这套模版？</span></p><p><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;1、小程序体验该模版的整个交互流程和呈现界面；<br/></span></p><p><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;2、在首页领取优惠券，或者去礼券中心领取优惠券；<br/></span></p><p><span style=\"font-size: 14px;\">&nbsp; &nbsp; 3、您有两种购买方式：一是直接购买，二是拼团购买；</span></p><p><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;4、拼团只有拼团成功后才进行发货，否则视为拼团失败；<br/></span></p><p><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;5、购买后请保存好订单付款截图，然后联系丸子君；</span><br/></p><p><br/></p><p style=\"text-align: center;\"><span style=\"color: rgb(255, 0, 0); font-size: 20px;\">再次感谢您选择丸子，支持正版！</span></p><p style=\"text-align: center;\"><span style=\"color: rgb(255, 0, 0); font-size: 20px;\">丸子QQ：1172007555</span></p><p><br/></p><p><br/></p>',
  78, 66, 13, 109, 545
);

INSERT INTO goods (
  goods_id, category_id, name, characteristic, main_pic, is_sales, is_support_group, remark, content, views, number_fav, number_reputation, stores, number_orders
) VALUES (
  '43223', 'ced892ca-1a8f-4c27-beb3-396a46f94f50', '清欢素雅小程序端模版（API工厂授权版）', '全场模版使用优惠券立减88元',
           'https://cdn.it120.cc/apifactory/2018/04/18/14569682d80bf52cd8ff4c3c116758a7.png', TRUE,
           FALSE, '清新素雅供您选择',
  '<p style=\"text-align: left;\"><span style=\"color: rgb(255, 0, 0);\">虚拟产品因为具备可复制性，所以一经售出概不退换！</span><br/></p><p style=\"text-align: left;\"><span style=\"color: rgb(255, 0, 0); font-size: 16px;\">虚拟产品因为具备可复制性，所以一经售出概不<span style=\"color: rgb(255, 0, 0); font-size: 16px;\"><span style=\"color: rgb(255, 0, 0);\">退换</span>！</span></span></p><p style=\"text-align: left;\"><span style=\"color: rgb(255, 0, 0); font-size: 16px;\">虚拟产品因为具备可复制性，所以一经售出概不<span style=\"color: rgb(255, 0, 0); font-size: 16px;\"><span style=\"color: rgb(255, 0, 0);\">退换</span>！</span></span></p><p><br/></p><p><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">购买须知（购买模版证明您知悉并同意以下条件）：</span></p><p><span style=\"font-size: 14px;\"><span style=\"font-size: 14px; color: rgb(255, 0, 0);\">1、</span><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">技术支持仅限对于现有代码，部署或配置有疑问的解答服务（不包含远程支持服务）；</span></span></p><p style=\"white-space: normal;\"><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">2、技术支持不包含页面源码修改或者新增功能的服务；</span></p><p style=\"white-space: normal;\"><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">3、购买后只要已经发送源码给您，不接受任何理由的退款和换货行为；</span></p><p><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">4、版本更新属于bug修复更新，不包括功能更新，各个功能接口属于增值项目，需要单独购买；</span></p><p><span style=\"color: rgb(255, 0, 0); font-size: 14px;\">5、该版本为授权版本，一个工厂后台对应一套模版，如果您要多个小程序使用，需要单独购买授权；</span></p><p><br/></p><p><span style=\"font-size: 14px; color: rgb(0, 0, 0);\">购买此模版您可以得到：</span></p><p><span style=\"font-size: 14px; color: rgb(0, 0, 0);\">1、清欢严选商城小程序端整套模版源码（<strong>不包含服务端源码</strong>）；</span></p><p><span style=\"font-size: 14px; color: rgb(0, 0, 0);\">2、清欢严选商城API工厂后台配置说明文档；</span></p><p><span style=\"font-size: 14px; color: rgb(0, 0, 0);\">3、清欢模版VIP微信群加入权限；</span></p><p><span style=\"color: rgb(0, 0, 0);\"><span style=\"font-size: 14px;\">4、一周</span><strong><span style=\"font-size: 14px; text-decoration: none;\">QQ或微信在线解答模版配置相关问题</span></strong><span style=\"font-size: 14px;\">的技术支持服务；</span></span></p><p><br/></p><p><span style=\"font-size: 14px;\">怎么样购买这套模版？</span></p><p><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;1、小程序体验该模版的整个交互流程和呈现界面；<br/></span></p><p><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;2、在首页领取优惠券，或者去礼券中心领取优惠券；<br/></span></p><p><span style=\"font-size: 14px;\">&nbsp; &nbsp; 3、您有两种购买方式：一是直接购买，二是拼团购买；</span></p><p><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;4、拼团只有拼团成功后才进行发货，否则视为拼团失败；<br/></span></p><p><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;5、购买后请保存好订单付款截图，然后联系丸子君；</span><br/></p><p><br/></p><p style=\"text-align: center;\"><span style=\"color: rgb(255, 0, 0); font-size: 20px;\">再次感谢您选择丸子，支持正版！</span></p><p style=\"text-align: center;\"><span style=\"color: rgb(255, 0, 0); font-size: 20px;\">丸子QQ：1172007555</span></p><p><br/></p><p><br/></p>',
  78, 66, 13, 109, 901
);

INSERT INTO goods_media (
  goods_id, url, type
) VALUES (
  '30164', 'https://cdn.it120.cc/apifactory/2018/05/19/84833eee6df34fa550cd7644b2242cf5.png', 'pic'
);

INSERT INTO goods_media (
  goods_id, url, type
) VALUES (
  '30164', 'https://pic4.zhimg.com/80/v2-681077ad5f5360c910ab0f76878f94ae_hd.jpg', 'pic'
);

INSERT INTO goods_media (
  goods_id, url, type
) VALUES (
  '36888', 'https://pic2.zhimg.com/80/v2-db072225516140446442a5d0b77b477e_hd.jpg', 'pic'
);

INSERT INTO goods_media (
  goods_id, url, type
) VALUES (
  '36888', 'https://pic2.zhimg.com/80/v2-388a59d26f6b050ecd92db1d91b97683_hd.jpg', 'pic'
);

INSERT INTO goods_media (
  goods_id, url, type
) VALUES (
  '40601', 'http://pic33.photophoto.cn/20141221/0005018370483374_b.jpg', 'pic'
);

INSERT INTO goods_media (
  goods_id, url, type
) VALUES (
  '40601', 'http://pic33.photophoto.cn/20141118/0005018340560174_b.jpg', 'pic'
);

INSERT INTO goods_media (
  goods_id, url, type
) VALUES (
  '43223', 'http://pic33.photophoto.cn/20141214/0005018344537205_b.jpg', 'pic'
);

INSERT INTO goods_media (
  goods_id, url, type
) VALUES (
  '43223', 'http://pic.58pic.com/58pic/11/95/44/59n58PICEuc.jpg', 'pic'
);


INSERT INTO goods_category (
  category_id, name, is_used, icon
) VALUES (
  'ced892ca-1a8f-4c27-beb3-396a46f94f50', '布艺', TRUE, ''
);

# ##############################
INSERT INTO properties (
  properties_id, indexs, name, goods_id
)
VALUES (
  '1', 1, '选择版本', '30164'
);
INSERT INTO properties (
  properties_id, indexs, name, goods_id
)
VALUES (
  '2', 2, '选择服务', '30164'
);

INSERT INTO properties (
  properties_id, indexs, name, goods_id
)
VALUES (
  '3', 1, '选择尺寸', '36888'
);
INSERT INTO properties (
  properties_id, indexs, name, goods_id
)
VALUES (
  '4', 2, '选择颜色', '36888'
);

INSERT INTO properties (
  properties_id, indexs, name, goods_id
)
VALUES (
  '5', 1, '选择箱型', '40601'
);
INSERT INTO properties (
  properties_id, indexs, name, goods_id
)
VALUES (
  '6', 2, '选择日期', '40601'
);

INSERT INTO properties (
  properties_id, indexs, name, goods_id
)
VALUES (
  '7', 1, '选择等级', '43223'
);
INSERT INTO properties (
  properties_id, indexs, name, goods_id
)
VALUES (
  '8', 2, '选择毛色', '43223'
);

# ##############
INSERT INTO properties_detail (
  detail_id, properties_id, indexs, name, remark
) VALUES (
  'AA', '1', 1, '授权版（加密版本）', ''
);
INSERT INTO properties_detail (
  detail_id, properties_id, indexs, name, remark
) VALUES (
  'BB', '1', 2, '开发版（未加密版本）', ''
);
INSERT INTO properties_detail (
  detail_id, properties_id, indexs, name, remark
) VALUES (
  'CC', '2', 1, '不要服务', ''
);
INSERT INTO properties_detail (
  detail_id, properties_id, indexs, name, remark
) VALUES (
  'DD', '2', 2, '部署上线一条龙服务', ''
);

INSERT INTO properties_detail (
  detail_id, properties_id, indexs, name, remark
) VALUES (
  'EE', '3', 1, '50寸', ''
);
INSERT INTO properties_detail (
  detail_id, properties_id, indexs, name, remark
) VALUES (
  'FF', '3', 2, '60寸', ''
);
INSERT INTO properties_detail (
  detail_id, properties_id, indexs, name, remark
) VALUES (
  'GG', '4', 1, '红色', ''
);
INSERT INTO properties_detail (
  detail_id, properties_id, indexs, name, remark
) VALUES (
  'HH', '4', 2, '蓝色', ''
);

INSERT INTO properties_detail (
  detail_id, properties_id, indexs, name, remark
) VALUES (
  'II', '5', 1, '20GP', ''
);
INSERT INTO properties_detail (
  detail_id, properties_id, indexs, name, remark
) VALUES (
  'JJ', '5', 2, '40GP', ''
);
INSERT INTO properties_detail (
  detail_id, properties_id, indexs, name, remark
) VALUES (
  'KK', '6', 1, '2018-10-10', ''
);
INSERT INTO properties_detail (
  detail_id, properties_id, indexs, name, remark
) VALUES (
  'LL', '6', 2, '2018-11-11', ''
);

INSERT INTO properties_detail (
  detail_id, properties_id, indexs, name, remark
) VALUES (
  'MM', '7', 1, '999级', ''
);
INSERT INTO properties_detail (
  detail_id, properties_id, indexs, name, remark
) VALUES (
  'NN', '7', 2, '无限级', ''
);
INSERT INTO properties_detail (
  detail_id, properties_id, indexs, name, remark
) VALUES (
  'OO', '8', 1, '棕红色', ''
);
INSERT INTO properties_detail (
  detail_id, properties_id, indexs, name, remark
) VALUES (
  'PP', '8', 2, '深蓝色', ''
);

# 商品价格
INSERT INTO goods_price (
  goods_id, properties_joint, price, type, goods_label
) VALUES (
  '30164', 'AA:CC', 667.9, 'GROUP', '授权版（加密版本） 不要服务'
);

INSERT INTO goods_price (
  goods_id, properties_joint, price, type, goods_label
) VALUES (
  '30164', 'AA:DD', 223.3, 'GROUP', '授权版（加密版本） 部署上线一条龙服务'
);

INSERT INTO goods_price (
  goods_id, properties_joint, price, type, goods_label
) VALUES (
  '30164', 'BB:CC', 248.4, 'GROUP', '开发版（未加密版本） 不要服务'
);

INSERT INTO goods_price (
  goods_id, properties_joint, price, type, goods_label
) VALUES (
  '30164', 'BB:DD', 430.8, 'GROUP', '开发版（未加密版本） 部署上线一条龙服务'
);




INSERT INTO goods_price (
  goods_id, properties_joint, price, type, goods_label
) VALUES (
  '30164', 'AA:CC', 794.9, 'NORMAL', '授权版（加密版本） 不要服务'
);

INSERT INTO goods_price (
  goods_id, properties_joint, price, type, goods_label
) VALUES (
  '30164', 'AA:DD', 385.3, 'NORMAL', '授权版（加密版本） 部署上线一条龙服务'
);

INSERT INTO goods_price (
  goods_id, properties_joint, price, type, goods_label
) VALUES (
  '30164', 'BB:CC', 398.4, 'NORMAL', '开发版（未加密版本） 不要服务'
);

INSERT INTO goods_price (
  goods_id, properties_joint, price, type, goods_label
) VALUES (
  '30164', 'BB:DD', 562.8, 'NORMAL', '开发版（未加密版本） 部署上线一条龙服务'
);


INSERT INTO goods_price (
  goods_id, properties_joint, price, type, goods_label
) VALUES (
  '30164', 'AA:CC', 726.9, 'CHEAP', '授权版（加密版本） 不要服务'
);

INSERT INTO goods_price (
  goods_id, properties_joint, price, type, goods_label
) VALUES (
  '30164', 'AA:DD', 337.3, 'CHEAP', '授权版（加密版本） 部署上线一条龙服务'
);

INSERT INTO goods_price (
  goods_id, properties_joint, price, type, goods_label
) VALUES (
  '30164', 'BB:CC', 362.4, 'CHEAP', '开发版（未加密版本） 不要服务'
);

INSERT INTO goods_price (
  goods_id, properties_joint, price, type, goods_label
) VALUES (
  '30164', 'BB:DD', 513.8, 'CHEAP', '开发版（未加密版本） 部署上线一条龙服务'
);



INSERT INTO goods_price (
  goods_id, properties_joint, price, type, goods_label
) VALUES (
  '30164', 'AA:CC', 694.9, 'CUT_DOWN', '授权版（加密版本） 不要服务'
);

INSERT INTO goods_price (
  goods_id, properties_joint, price, type, goods_label
) VALUES (
  '30164', 'AA:DD', 311.3, 'CUT_DOWN', '授权版（加密版本） 部署上线一条龙服务'
);

INSERT INTO goods_price (
  goods_id, properties_joint, price, type, goods_label
) VALUES (
  '30164', 'BB:CC', 375.4, 'CUT_DOWN', '开发版（未加密版本） 不要服务'
);

INSERT INTO goods_price (
  goods_id, properties_joint, price, type, goods_label
) VALUES (
  '30164', 'BB:DD', 498.8, 'CUT_DOWN', '开发版（未加密版本） 部署上线一条龙服务'
);


# 喜欢的商品
INSERT INTO goods_fav (
  username, goods_id
) VALUES (
  'olIcM5KAax4vDCGbc-6R5Oyuvv_I', '30164'
);

# 拼团商品配置信息
INSERT INTO group_booking_properties (goods_id, number_require, number_success, timeout_hours, is_remove)
VALUES ('30164', 2, 234, 23, FALSE);

INSERT INTO group_booking_properties (goods_id, number_require, number_success, timeout_hours, is_remove)
VALUES ('36888', 2, 564, 23, FALSE);

INSERT INTO group_booking_properties (goods_id, number_require, number_success, timeout_hours, is_remove)
VALUES ('40601', 2, 356, 23, FALSE);

INSERT INTO group_booking_properties (goods_id, number_require, number_success, timeout_hours, is_remove)
VALUES ('43223', 2, 215, 23, FALSE);


# 推荐商品
INSERT INTO goods_recommend (goods_id) VALUES ('30164');
INSERT INTO goods_recommend (goods_id) VALUES ('36888');
INSERT INTO goods_recommend (goods_id) VALUES ('40601');
INSERT INTO goods_recommend (goods_id) VALUES ('43223');

# 砍价
INSERT INTO goods_cut_down_info (goods_id, max_amount_per_cut, min_amount_per_cut, max_helper, effective_time, max_cut_down, `status`)
VALUES ('30164', 5, 0.5, 100, 28, 120, 'FINISH');
INSERT INTO goods_cut_down_info (goods_id, max_amount_per_cut, min_amount_per_cut, max_helper, effective_time, max_cut_down, `status`)
VALUES ('36888', 5, 0.5, 100, 28, 120, 'FINISH');
INSERT INTO goods_cut_down_info (goods_id, max_amount_per_cut, min_amount_per_cut, max_helper, effective_time, max_cut_down, `status`)
VALUES ('40601', 5, 0.5, 100, 28, 120, 'FINISH');
INSERT INTO goods_cut_down_info (goods_id, max_amount_per_cut, min_amount_per_cut, max_helper, effective_time, max_cut_down, `status`)
VALUES ('43223', 5, 0.5, 100, 28, 120, 'FINISH');

# 地址信息
INSERT INTO user_address (
  user_address_id, username, province, province_code, city, city_code, area, area_code, address, is_default, link_man, mobile, is_remove, postal_code
) VALUES (
  'db072225516140446', 'olIcM5KAax4vDCGbc-6R5Oyuvv_I', '河南省', '410000', '许昌市', '411000', '禹州市', '411081', '宋庄村3组', TRUE, '冯帅炬', '18930061430', FALSE, 461670
);