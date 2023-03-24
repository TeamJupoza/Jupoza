INSERT INTO `user_account` (`user_id`, `created_at`, `created_by`, `modified_at`, `modified_by`, `user_password`, `email`, `nick_name`)
VALUES
    ('minsang', '2023-03-16 15:21:58.000000', 'minsang', '2023-03-16 15:21:58.000000', 'minsang', '{noop}minsang', 'minsang@naver.com', 'ganghal');

INSERT INTO `user_account_roles` (`user_account_user_id`, `roles`)
VALUES
    ('minsang', 'USER');


INSERT INTO `port_folio` (`port_folio_id`, `created_at`, `created_by`, `modified_at`, `modified_by`, `user_id`)
VALUES
    (1, '2023-03-13 15:32:32.479332', 'minsang', '2023-03-13 15:32:32.479332', 'minsang', 'minsang');


INSERT INTO `article` (`id`, `created_at`, `created_by`, `modified_at`, `modified_by`, `content`, `title`, `user_account_user_id`)
VALUES
    (1, '2023-03-16 15:18:36.063404', 'minsang', '2023-03-16 15:18:36.063404', 'minsang', 'testContent', 'testTitle', 'minsang');

INSERT INTO `article` (`id`, `created_at`, `created_by`, `modified_at`, `modified_by`, `content`, `title`, `user_account_user_id`)
VALUES
    (2, '2023-03-16 15:18:36.063404', 'minsang', '2023-03-16 15:18:36.063404', 'minsang', 'testContent', 'testTitle', 'minsang');


INSERT INTO `article` (`id`, `created_at`, `created_by`, `modified_at`, `modified_by`, `content`, `title`, `user_account_user_id`)
VALUES
    (3, '2023-03-16 15:18:36.063404', 'minsang', '2023-03-16 15:18:36.063404', 'minsang', 'testContent', 'testTitle', 'minsang');

INSERT INTO `article` (`id`, `created_at`, `created_by`, `modified_at`, `modified_by`, `content`, `title`, `user_account_user_id`)
VALUES
    (4, '2023-03-16 15:18:36.063404', 'minsang', '2023-03-16 15:18:36.063404', 'minsang', 'testContent', 'testTitle', 'minsang');

INSERT INTO `article` (`id`, `created_at`, `created_by`, `modified_at`, `modified_by`, `content`, `title`, `user_account_user_id`)
VALUES
    (5, '2023-03-16 15:18:36.063404', 'minsang', '2023-03-16 15:18:36.063404', 'minsang', 'testContent', 'testTitle', 'minsang');

INSERT INTO `article` (`id`, `created_at`, `created_by`, `modified_at`, `modified_by`, `content`, `title`, `user_account_user_id`)
VALUES
    (6, '2023-03-16 15:18:36.063404', 'minsang', '2023-03-16 15:18:36.063404', 'minsang', 'testContent', 'testTitle', 'minsang');



INSERT INTO `my_stock` (`id`, `stock_id`, `weight`, `port_folio_port_folio_id`,`user_id`)
VALUES
    (1, 33780, 46.14, 1,'minsang'),
    (2, 326030, 13.66, 1,'minsang'),
    (3, 68270, 10.68, 1,'minsang'),
    (4, 137310, 12.27, 1,'minsang'),
    (5, 35420, 17.25, 1,'minsang');



INSERT INTO `article_stock` (`id`, `stock_id`, `user_id`, `weight`, `article_id`)
VALUES
    (1, 60, 'minsang', 15, 1),
    (2, 6400, 'minsang', 20, 1),
    (3, 660, 'minsang', 25, 1),
    (4, 3490, 'minsang', 30, 1),
    (5, 15760, 'minsang', 10, 1);


INSERT INTO `article_stock` (`id`, `stock_id`, `user_id`, `weight`, `article_id`)
VALUES
    (6, 60, 'minsang', 15, 2),
    (7, 6400, 'minsang', 20, 2),
    (8, 660, 'minsang', 25, 2),
    (9, 3490, 'minsang', 30, 2),
    (10, 15760, 'minsang', 10, 2);

INSERT INTO `article_stock` (`id`, `stock_id`, `user_id`, `weight`, `article_id`)
VALUES
    (11, 60, 'minsang', 15, 3),
    (12, 6400, 'minsang', 20, 3),
    (13, 660, 'minsang', 25, 3),
    (14, 3490, 'minsang', 30, 3),
    (15, 15760, 'minsang', 10, 3);

INSERT INTO `article_stock` (`id`, `stock_id`, `user_id`, `weight`, `article_id`)
VALUES
    (16, 60, 'minsang', 15, 4),
    (17, 6400, 'minsang', 20, 4),
    (18, 660, 'minsang', 25, 4),
    (19, 3490, 'minsang', 30, 4),
    (20, 15760, 'minsang', 10, 4);

INSERT INTO `article_stock` (`id`, `stock_id`, `user_id`, `weight`, `article_id`)
VALUES
    (21, 60, 'minsang', 15, 5),
    (22, 6400, 'minsang', 20, 5),
    (23, 660, 'minsang', 25, 5),
    (24, 3490, 'minsang', 30, 5),
    (25, 15760, 'minsang', 10, 5);

INSERT INTO `article_stock` (`id`, `stock_id`, `user_id`, `weight`, `article_id`)
VALUES
    (26, 60, 'minsang', 15, 6),
    (27, 6400, 'minsang', 20, 6),
    (28, 660, 'minsang', 25, 6),
    (29, 3490, 'minsang', 30, 6),
    (30, 15760, 'minsang', 10, 6);






# INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (1, '메리츠화재', 31450, 6.13, -2.89, 53.0565, 9.56164, 1.97, 8.65, 0, 0, 1056.04, 0, 0.0265062, 142.11, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/000060.png?sidcode=1668661886079');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (60, '메리츠화재', 31450, 6.13, -2.89, 53.0565, 9.56164, 1.97, 8.65, 0, 0, 1056.04, 0, 0.0265062, 142.11, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/000060.png?sidcode=1668661886079');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (100, '유한양행', 59800, 43.07, 7.04, -47.9382, 4.19449, 0.67, 78.57, 283.37, 179.82, 27.27, 8, 0.0131764, -16.36, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/000100.png?sidcode=1668661886531');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (270, '기아', 66300, 7, 160, 220.003, 18.0744, 4.52, 52.23, 135.44, 69.25, 91.48, 3, 0.0170999, 29.06, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/000270.png?sidcode=1668661886736');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (660, 'SK하이닉스', 82700, 9.93, 34.35, 102.067, 34.7876, 1.86, 64.52, 181.93, 52.5, 54.98, 4, 0.021219, 1.98, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/000660.png?sidcode=1668661886928');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (720, '현대건설', 34900, 12.19, -71.19, 143.471, 6.45032, 1.72, 48.02, 190.81, 135.27, 108.26, 4, 0.024442, 24.01, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/000720.png?sidcode=1668661887115');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (810, '삼성화재', 200000, 9.1, -1.76, 48.5151, 0.463543, 6, 16.32, 0, 0, 512.78, 0, 0.0174867, 11.75, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/000810.png?sidcode=1668661887291');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (3490, '대한항공', 23100, 16.33, -4.47, 351.624, 18.4783, 0, 25.74, 78.64, 30.52, 288.48, 0, 0.0200735, 37.59, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/003490.png?sidcode=1668661887452');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (3550, 'LG', 79200, 5.22, 14.74, 74.2096, 31.9276, 3.54, 85.47, 196.79, 147.31, 17, 6, 0.0181736, -11.51, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/003550.png?sidcode=1668661887624');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (3670, '포스코케미칼', 199500, 82.49, 14.02, 349.657, 27.027, 0.15, 62.17, 328.41, 110.76, 60.86, 6, 0.0300204, 21.61, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/003670.png?sidcode=1668661887775');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (4020, '현대제철', 28100, 3.74, -288.63, 441.988, 26.7792, 3.56, 49.3, 171.1, 32.19, 102.86, 3, 0.0226335, 0.85, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/004020.png?sidcode=1668661887950');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (5380, '현대차', 164500, 11.71, -8.29, 195.813, 13.0897, 3.04, 35.31, 82.99, 27.53, 183.17, 1, 0.0163915, 1.45, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/005380.png?sidcode=1668661888140');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (5490, 'POSCO홀딩스', 249000, 3.62, 39.67, 302.42, 32.0793, 6.83, 59.91, 221.13, 85.65, 66.9, 5, 0.0200477, 2.56, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (5830, 'DB손해보험', 56300, 4.4, -1.7, 57.4256, 6.03855, 6.22, 10.4, 0, 0, 861.78, 0, 0.0222816, 26.32, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/005830.png?sidcode=1668661888484');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (5930, '삼성전자', 59400, 13.55, 21.79, 51.1198, 18.0729, 2.43, 71.47, 247.58, 145.23, 39.92, 7, 0.0140979, -5.3, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/005930.png?sidcode=1668661888569');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (6360, 'GS건설', 21700, 8.3, -7.88, 30.0682, -10.7316, 5.99, 32.09, 121.06, 65.15, 211.61, 1, 0.0243301, 5.26, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/006360.png?sidcode=1668661888737');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (6400, '삼성SDI', 737000, 39.41, 27.42, 98.1725, 19.9955, 0.14, 58.83, 115.22, 46.61, 69.99, 3, 0.0238619, -3.13, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/006400.png?sidcode=1668661888905');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (6800, '미래에셋증권', 6350, 5.94, -1.35, 41.8442, 20.344, 4.72, 9.77, 0, 0, 923.96, 0, 0.0169143, -10, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/006800.png?sidcode=1668661889071');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (8770, '호텔신라', 65000, 115.28, -1.8, 109.55, 18.5399, 0.31, 21.72, 107.46, 22.19, 360.47, 0, 0.0179261, -5.33, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/008770.png?sidcode=1668661889213');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (9150, '삼성전기', 121000, 17.17, 24.08, 46.7483, 24.7867, 1.74, 69.12, 205.77, 90.54, 44.68, 6, 0.0218495, 8.06, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/009150.png?sidcode=1668661889365');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (9540, '한국조선해양', 72700, -7.2, 46.29, -36.6421, 3.95691, 0, 45.48, 129.02, 87.42, 119.86, 2, 0.0224494, -14.55, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/009540.png?sidcode=1668661889519');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (9830, '한화솔루션', 47200, 10.72, -17.1, 104.27, 16.6415, 0, 40.99, 104.94, 32.55, 143.96, 2, 0.0321932, -25.46, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/009830.png?sidcode=1668661889699');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (10060, 'OCI', 102000, 3.83, 119.97, 359.621, 61.996, 1.96, 54.76, 270.04, 67.21, 82.6, 5, 0.0324121, 5.08, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/010060.png?sidcode=1668661889860');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (10130, '고려아연', 640000, 11.95, 14.74, 41.104, 31.5863, 3.12, 77.62, 321.32, 124.67, 28.83, 7, 0.0210858, 27.18, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/010130.png?sidcode=1668661890020');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (10140, '삼성중공업', 5150, -2.7, 36.82, 2.72194, -3.47384, 0, 33.75, 79.25, 51.06, 196.26, 1, 0.0197139, -17.57, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/010140.png?sidcode=1668661890174');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (10950, 'S-Oil', 86400, 7.25, -29.22, 273.16, 63.1874, 4.4, 37.38, 98.5, 41.28, 167.5, 1, 0.0241132, 22.19, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/010950.png?sidcode=1668661890327');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (11070, 'LG이노텍', 296500, 9.7, -79.81, 276.187, 56.6332, 1.01, 42.81, 124.26, 61.47, 133.58, 2, 0.0304962, 92.47, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/011070.png?sidcode=1668661890490');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (11170, '롯데케미칼', 148000, 5.53, 17.75, 713.012, 48.2485, 5.61, 67.56, 205.95, 89.47, 48.01, 6, 0.0219712, -22.36, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/011170.png?sidcode=1668661890645');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (11200, 'HMM', 19100, 2.46, 187.9, 4205.33, 115.088, 3.14, 57.94, 347.29, 113.25, 72.58, 6, 0.0297152, 64.95, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/011200.png?sidcode=1668661890798');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (11780, '금호석유', 131000, 2.83, 95.88, 237.159, 75.9388, 7.63, 62.63, 145.97, 87.87, 59.67, 3, 0.0241263, 10.6, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/011780.png?sidcode=1668661890939');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (11790, 'SKC', 103500, 29.92, -21.19, 365.004, 37.7236, 1.06, 36.93, 105.81, 33.47, 170.78, 1, 0.0282002, 67, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/011790.png?sidcode=1668661890999');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (12330, '현대모비스', 219000, 10.25, 12.28, 54.7286, 13.8579, 1.83, 68.68, 233.72, 119.55, 45.61, 7, 0.0187623, -10.63, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/012330.png?sidcode=1668661891157');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (15760, '한국전력', 16750, -2.67, 6.5, -349.907, 3.42416, 0, 30.94, 69.49, 9.91, 223.23, 1, 0.0183861, -16.91, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/015760.png?sidcode=1668661891308');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (16360, '삼성증권', 31750, 4.15, -1.8, 90.1068, 50.1894, 11.97, 9.25, 0, 0, 980.55, 0, 0.01614, 8.33, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/016360.png?sidcode=1668661891461');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (17670, 'SK텔레콤', 50100, 8.46, -38.76, 61.2081, 4.10771, 13.29, 39.9, 91.27, 33.1, 150.6, 1, 0.015824, 39.88, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/017670.png?sidcode=1668661891605');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (18260, '삼성에스디에스', 125000, 19.81, 14.49, 39.8474, 23.7131, 1.92, 70.77, 319.62, 245.03, 41.29, 8, 0.0169526, -15.86, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/018260.png?sidcode=1668661891746');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (18880, '한온시스템', 7800, 23.27, -9.47, 173.864, 6.96352, 4.62, 30.08, 126.24, 47.62, 232.45, 1, 0.0207449, -18.48, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/018880.png?sidcode=1668661891889');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (20150, '일진머티리얼즈', 60600, 99.16, 6.69, 47.8333, 28.3052, 0.5, 76.94, 645.8, 203.95, 29.96, 8, 0.032488, 150.48, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/020150.png?sidcode=1668661892023');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (21240, '코웨이', 55300, 11.79, 5644.05, 15.017, 13.1849, 2.26, 50.11, 85.56, 45.96, 99.57, 3, 0.0179396, 0.27, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/021240.png?sidcode=1668661892179');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (24110, '기업은행', 10450, 3.4, -0.71, 56.7228, 0.411029, 7.46, 6.92, 0, 0, 1345.75, 0, 0.0136101, 20.07, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/024110.png?sidcode=1668661892332');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (28050, '삼성엔지니어링', 23850, 12.05, -16.42, 39.2392, 10.9276, 0, 32.36, 115.31, 108.4, 209.04, 2, 0.024994, 69.63, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/028050.png?sidcode=1668661892467');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (28260, '삼성물산', 118500, 13.72, 15.96, 57.5912, 14.0291, 3.54, 60.37, 129.71, 56.34, 65.64, 3, 0.0178921, -18.4, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/028260.png?sidcode=1668661892624');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (28300, 'HLB', 40500, -37.03, -39.76, -25.802, 24.2955, 0, 68.87, 154.44, 75.3, 45.2, 5, 0.0385307, -22.29, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/028300.png?sidcode=1668661892760');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (28670, '팬오션', 4300, 5.26, 77.93, 505.482, 84.8543, 2.33, 55.43, 118.21, 43.24, 80.4, 3, 0.0268657, 3.72, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/028670.png?sidcode=1668661892906');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (30200, 'KT', 36600, 5.89, -36.26, 107.48, 4.10316, 5.22, 44.58, 117.73, 55.09, 124.3, 2, 0.0135467, 27.52, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/030200.png?sidcode=1668661893044');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (32640, 'LG유플러스', 11450, 8.34, -20.97, 51.4894, 3.23088, 4.8, 41.09, 101.79, 43.14, 143.39, 2, 0.0138961, 15.19, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/032640.png?sidcode=1668661893183');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (32830, '삼성생명', 67400, 8.72, -0.61, 16.5779, -0.588098, 4.45, 11.61, 0, 0, 761.53, 0, 0.0158457, -17.31, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/032830.png?sidcode=1668661893339');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (33780, 'KT&G', 95700, 11.1, 14.33, -17.0602, 3.42294, 5.02, 79.13, 303.1, 159.8, 26.37, 8, 0.00784712, -3.78, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/033780.png?sidcode=1668661893518');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (34020, '두산에너빌리티', 13250, 18.9, -10.58, 177.026, 23.0289, 0, 37.13, 83.13, 44.45, 169.32, 1, 0.0308966, 56.16, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/034020.png?sidcode=1668661893578');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (34220, 'LG디스플레이', 12750, 7.42, -15.45, 1851.28, 23.1497, 5.1, 38.69, 94.23, 42.05, 158.46, 1, 0.0244748, 29.66, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/034220.png?sidcode=1668661893760');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (34730, 'SK', 214000, 9.08, -16.7, 5373.74, 21.6611, 3.74, 39.64, 109.38, 38.58, 152.24, 1, 0.0189834, 2.4, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/034730.png?sidcode=1668661893927');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (35250, '강원랜드', 23000, -486.94, -0.4, 96.1642, 64.7446, 0, 84.99, 326.99, 287.85, 17.66, 8, 0.0169666, 3.64, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/035250.png?sidcode=1668661894078');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (35420, 'NAVER', 169500, 3.77, 114.72, 1850.02, 28.5334, 0.3, 71.32, 140.9, 57.14, 40.22, 4, 0.0218866, 28.33, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/035420.png?sidcode=1668661894240');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (35720, '카카오', 50700, 35.92, 37.41, 849.56, 47.6291, 0.1, 59.66, 154.44, 87.17, 67.62, 4, 0.0243336, 44.05, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/035720.png?sidcode=1668661894383');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (35760, 'CJ ENM', 73400, 15.73, 48.83, 246.738, 4.75387, 2.86, 52.93, 114.53, 68.9, 88.91, 3, 0.024753, -1.41, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/035760.png?sidcode=1668661894536');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (36460, '한국가스공사', 34800, 3.8, -3.79, 700.264, 32.0972, 7.84, 20.88, 93.77, 27.68, 378.87, 0, 0.0261823, 24.51, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/036460.png?sidcode=1668661894715');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (36570, '엔씨소프트', 390000, 35.57, 23, -32.539, -4.44365, 1.5, 68.78, 369.72, 170.99, 45.4, 8, 0.033226, -31.8, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/036570.png?sidcode=1668661894884');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (42660, '대우조선해양', 18300, -1.45, 27.47, -2063.47, -36.181, 0, 20.87, 86.83, 63.55, 379.04, 0, 0.03635, -17.59, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/042660.png?sidcode=1668661895032');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (47810, '한국항공우주', 47350, 49.5, -1.63, -26.3316, -9.30406, 0.42, 22.16, 131.46, 51.7, 351.29, 0, 0.0286852, 22.3, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/047810.png?sidcode=1668661895198');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (51900, 'LG생활건강', 510000, 23.01, 25.03, 5.90661, 3.14877, 2.35, 72.77, 162.07, 71.56, 37.42, 5, 0.0249392, -31.51, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/051900.png?sidcode=1668661895355');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (51910, 'LG화학', 626000, 13.12, -83.85, 479.405, 41.9039, 1.92, 45.39, 135.53, 43.44, 120.32, 2, 0.0294503, -30.48, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/051910.png?sidcode=1668661895503');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (55550, '신한지주', 36300, 4.89, -0.75, 17.5683, -0.336849, 5.4, 7.64, 0, 0, 1208.38, 0, 0.0153657, 18.07, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/055550.png?sidcode=1668661895638');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (66570, 'LG전자', 81600, 24.19, -10.65, -31.4382, 28.7019, 1.04, 37.58, 116.38, 53.12, 166.1, 1, 0.0230373, -1.76, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/066570.png?sidcode=1668661895764');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (66970, '엘앤에프', 225000, -64.22, 42.88, -647.518, 172.605, 0, 41.46, 268.81, 90.2, 141.22, 4, 0.0354963, 183.38, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/066970.png?sidcode=1668661895820');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (68270, '셀트리온', 192000, 47.11, 24.55, 13.3301, 3.37922, 0.39, 71.38, 253.99, 153.74, 40.09, 8, 0.0262527, -41.8, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/068270.png?sidcode=1668661895952');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (68760, '셀트리온제약', 67800, 131.46, 132.72, 65.1349, 70.7158, 0, 52.04, 127.4, 87.36, 92.15, 3, 0.0293154, -41.29, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/068760.png?sidcode=1668661896089');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (71050, '한국금융지주', 49550, 2.82, -2.63, 105.17, 6.47593, 12.41, 9.05, 0, 0, 1004.41, 0, 0.0193443, -3.04, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/071050.png?sidcode=1668661896245');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (78930, 'GS', 46000, 2.56, -57.97, 959.898, 31.0529, 4.35, 45.53, 97.95, 28.02, 119.61, 2, 0.0175372, 4.23, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/078930.png?sidcode=1668661896405');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (86280, '현대글로비스', 174000, 8.05, -143.41, 29.2065, 31.8386, 2.18, 47.76, 176.73, 88.04, 109.4, 3, 0.0204057, -9.21, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/086280.png?sidcode=1668661896550');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (86790, '하나금융지주', 41250, 3.58, -0.83, 33.3983, 1.51604, 7.52, 7.07, 0, 0, 1315.37, 0, 0.0193859, 26.61, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/086790.png?sidcode=1668661896671');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (90430, '아모레퍼시픽', 92700, 59.52, 5.36, 727.004, 9.7232, 1.06, 77.56, 174.39, 111.14, 28.93, 6, 0.0261698, -17.24, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/090430.png?sidcode=1668661896814');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (91990, '셀트리온헬스케어', 69500, 81.47, 51.4, -36.5379, 10.8681, 0.37, 53.79, 225.2, 90.5, 85.9, 5, 0.0274591, -45.95, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/091990.png?sidcode=1668661896961');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (96530, '씨젠', 28700, 5.94, 79.35, 6.83965, 21.8285, 3.48, 72.74, 367.39, 206.62, 37.48, 8, 0.0364566, -33.42, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/096530.png?sidcode=1668661897102');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (96770, 'SK이노베이션', 173000, 73.38, -4.87, 123.338, 35.5803, 0, 39.62, 148.02, 45.56, 152.42, 1, 0.0273374, 7.36, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/096770.png?sidcode=1668661897239');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (97950, 'CJ제일제당', 414000, 10.36, -17.02, 13.4746, 8.4283, 1.21, 40.24, 97.6, 32.34, 148.51, 2, 0.0179755, -1.3, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/097950.png?sidcode=1668661897371');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (105560, 'KB금융', 48050, 5.19, -0.77, 24.7129, 5.00582, 6.12, 7.27, 0, 0, 1274.7, 0, 0.0191973, 30.27, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/105560.png?sidcode=1668661897510');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (128940, '한미약품', 253000, 49.74, -101.58, 371.253, 11.8354, 0.2, 47.93, 108.48, 45, 108.64, 2, 0.0216341, -18.62, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/128940.png?sidcode=1668661897567');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (137310, '에스디바이오센서', 29550, 5.14, 75.94, 71.2369, 73.765, 4.28, 73.32, 330.57, 281.09, 36.39, 8, 0.0373051, -10.82, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/137310.png?sidcode=1668661897999');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (139480, '이마트', 84600, 2.68, -24.67, 338.277, 13.1606, 2.36, 39.69, 52.85, 19.26, 151.95, 1, 0.0189956, -0.66, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/139480.png?sidcode=1668661898155');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (161390, '한국타이어앤테크놀로지', 36550, 8.23, 12.84, 56.8866, 10.6626, 1.92, 70.11, 294.74, 103.25, 42.64, 7, 0.0215622, 9.49, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/161390.png?sidcode=1668661898293');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (196170, '알테오젠', 36700, -711.55, -122.4, 49.7043, -3.0706, 0, 51.44, 172.25, 167.04, 94.39, 6, 0.0358231, -35.13, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/196170.png?sidcode=1668661898429');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (207940, '삼성바이오로직스', 877000, 150.02, 19.56, 63.3322, 34.6187, 0, 62.62, 254.96, 60.77, 59.68, 5, 0.0184725, 9.89, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/207940.png?sidcode=1668661898559');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (241560, '두산밥캣', 33500, 10.59, 626.12, 55.9438, 35.8272, 3.58, 50.36, 176.6, 35.04, 98.57, 4, 0.024492, 38.1, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/241560.png?sidcode=1668661898681');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (247540, '에코프로비엠', 115100, 26.62, -41.87, 109.587, 73.8088, 0.8, 41.81, 120.6, 48.18, 139.18, 2, 0.0369849, 156.41, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/247540.png?sidcode=1668661898826');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (251270, '넷마블', 44600, 44.71, 18.44, -26.2889, 0.891086, 1.18, 56.34, 64.22, 42.07, 77.5, 3, 0.0266287, -2.67, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/251270.png?sidcode=1668661898971');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (259960, '크래프톤', 177500, 40.19, 14.52, -6.54174, 12.9241, 0, 81.78, 572.52, 355.82, 22.28, 8, 0.031392, 1.32, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/259960.png?sidcode=1668661899089');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (263750, '펄어비스', 41600, 154.13, 72.94, -41.1371, -17.3864, 0, 53, 263.25, 113.19, 88.68, 6, 0.0368617, 165.87, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/263750.png?sidcode=1668661899220');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (267250, 'HD현대', 60900, -32.06, -1.54, 123.554, 48.9016, 9.11, 33.19, 114.69, 31.44, 201.29, 1, 0.0172497, -3.07, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/267250.png?sidcode=1668661899359');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (271560, '오리온', 101500, 15.88, 18, -3.97012, 5.63632, 0.74, 73.47, 219.62, 113.27, 36.11, 7, 0.0192178, -15.45, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/271560.png?sidcode=1668661899497');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (293490, '카카오게임즈', 39550, 12.89, 97.05, 670.475, 104.326, 0, 56.22, 136.61, 57.9, 77.86, 3, 0.0354034, 102.17, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/293490.png?sidcode=1668661899627');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (302440, 'SK바이오사이언스', 75600, 46.58, 32.51, 979.788, 311.772, 0, 75.89, 399.56, 334.65, 31.77, 8, 0.0391991, 35.8, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/302440.png?sidcode=1668661899773');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (316140, '우리금융지주', 11750, 3.56, -0.72, 85.2746, 3.89439, 7.66, 6.45, 0, 0, 1450.02, 0, 0.0197714, 34.6, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/316140.png?sidcode=1668661899918');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (323410, '카카오뱅크', 17100, 126.3, -0.82, 79.6297, 31.1308, 0, 15.32, 0, 0, 552.74, 0, 0.0285054, -15.33, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/323410.png?sidcode=1668661900059');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (326030, 'SK바이오팜', 58100, 117.39, 26.5, 126.209, 1510.23, 0, 69.01, 317.74, 210.21, 44.91, 8, 0.0221254, -36.31, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/326030.png?sidcode=1668661900196');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (329180, '현대중공업', 109000, -8.92, 20.93, -88.7208, -0.00882938, 0, 37.1, 111.88, 73.67, 169.55, 1, 0.0293212, -12.47, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/329180.png?sidcode=1668661900344');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (352820, '하이브', 121000, 96.87, 13.49, 61.7652, 57.7236, 0, 61.04, 341.47, 104.21, 63.82, 6, 0.0349738, 124.08, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/352820.png?sidcode=1668661900493');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (361610, 'SK아이이테크놀로지', 52000, 120.54, 7.64, 8.15305, 28.6502, 0, 69.59, 247.41, 118.46, 43.69, 7, 0.0332467, 6.47, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/361610.png?sidcode=1668661900634');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (373220, 'LG에너지솔루션', 528000, 0, -14.81, 305.827, 1121.84, 0, 36.79, 100.65, 37.55, 171.83, 1, 0.026557, 0, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/373220.png?sidcode=1668661900770');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (377300, '카카오페이', 35350, -881.67, -21.36, -35.1787, 61.2848, 0, 52.31, 271.42, 140.01, 91.17, 6, 0.0406495, -8.55, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/377300.png?sidcode=1668661900885');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (383220, 'F&F', 145500, 6.24, -449.04, 0, 0, 3.78, 47.75, 103.61, 57.04, 109.43, 2, 0.0289502, 129.09, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/383220.png?sidcode=1668661901021');
INSERT INTO JUPOZA.stock (stockid, name, price, per, roe, net, sale, dividend, bis, current, quick, debt, score, std, rate, img) VALUES (402340, 'SK스퀘어', 36950, 25.04, 3.28, 0, 0, 0, 74.45, 117.87, 50.66, 34.31, 4, 0.0273435, -12.5, 'https://ssl.pstatic.net/imgfinance/chart/item/area/day/402340.png?sidcode=1668661901077');
