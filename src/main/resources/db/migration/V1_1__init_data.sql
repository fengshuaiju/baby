# --------------- Mysql ---------------
INSERT INTO slide_container (goods_id, pic_url, status, orders)
VALUES (30164, 'https://cdn.it120.cc/apifactory/2018/05/09/2e8638183135b207c97490ed95fb44ba.jpg', TRUE, 1);

INSERT INTO slide_container (goods_id, pic_url, status, orders)
VALUES (30164, 'https://cdn.it120.cc/apifactory/2018/05/09/d1cbc05833c4fa09b1fae15593df1b63.jpg', TRUE, 1);

INSERT INTO slide_container (goods_id, pic_url, status, orders)
VALUES (30164, 'https://cdn.it120.cc/apifactory/2018/05/09/dc11f00add7f97ee549b41b97134fe65.jpg', TRUE, 1);

INSERT INTO slide_container (goods_id, pic_url, status, orders)
VALUES (30164, 'https://cdn.it120.cc/apifactory/2018/05/09/62c5fb354ced6e13c06d554cde479679.jpg', TRUE, 1);


INSERT INTO function_menus (link_url, pic_url, status, title, orders)
VALUES
  ('/pages/score/index', 'https://cdn.it120.cc/apifactory/2018/05/09/0630c87c94e2f1a4f213f7ffb5845e6d.png', TRUE, '签到',
   '1');

INSERT INTO function_menus (link_url, pic_url, status, title, orders)
VALUES
  ('/pages/newcoupons/index', 'https://cdn.it120.cc/apifactory/2018/05/09/1ba413178d361771f25332ebd04f3bf7.png', TRUE,
   '礼券', '1');

INSERT INTO function_menus (link_url, pic_url, status, title, orders)
VALUES
  ('/pages/kanjia-list/index', 'https://cdn.it120.cc/apifactory/2018/05/09/496a0c3e4042afbb688837358217f501.png', TRUE,
   '砍价', '1');

INSERT INTO function_menus (link_url, pic_url, status, title, orders)
VALUES
  ('/pages/topic-list/index', 'https://cdn.it120.cc/apifactory/2018/05/09/88f45bf6e95ec010f1f945c414e6df03.png', TRUE,
   '专栏', '1');


INSERT INTO coupons (coupon_id, pic_url, link_url, coupon_name, amount_of_money, requirement_consumption, period_of_validity_to_at, remarks, available, type)
VALUES ('88f45bf6e95ec010f1f945c414e6df03', 'https://cdn.it120.cc/apifactory/2018/06/26/f1e90deac271101c805f1db52f9ba5da.png',
        'https://cdn.it120.cc/apifactory/2018/05/18/8b5875faf90d1b2fdc353dfbc5d6d1b3.png', '新人优惠券', 5, 35, '2018-09-09',
        '新人优惠券,满35元可用', TRUE, 'WELCOME');

INSERT INTO coupons (coupon_id, pic_url, link_url, coupon_name, amount_of_money, requirement_consumption, period_of_validity_to_at, remarks, available, type)
VALUES ('1ba413178d361771f25332ebd04f3bf7', 'https://cdn.it120.cc/apifactory/2018/05/18/8b5875faf90d1b2fdc353dfbc5d6d1b3.png',
        'https://cdn.it120.cc/apifactory/2018/06/26/f1e90deac271101c805f1db52f9ba5da.png', '新人优惠券', 5, 35, '2018-09-09',
        '新人优惠券,满35元可用', TRUE, 'DISCOUNT');