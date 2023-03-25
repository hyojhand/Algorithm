-- 우유와 요거트가 담긴 장바구니
-- 우유(Milk)와 요거트(Yogurt)를 동시에 구입한 장바구니가 있는지 알아보려 합니다.
-- 우유와 요거트를 동시에 구입한 장바구니의 아이디를 조회하는 SQL 문을 작성해주세요.
-- 이때 결과는 장바구니의 아이디 순으로 나와야 합니다.

-- group by, having count(distinct name)
SELECT CART_ID
from CART_PRODUCTS
where NAME IN ('Milk', 'Yogurt')
group by CART_ID
having count(distinct name) >= 2
order by CART_ID


-- join, subquery
SELECT distinct Y.CART_ID
from CART_PRODUCTS AS Y
         join (select distinct CART_ID from CART_PRODUCTS where NAME = 'Milk') AS M
             on M.CART_ID = Y.CART_ID
where Y.NAME = 'Yogurt'
order by Y.CART_ID


-- group by, group_concat
SELECT CART_ID
from (select CART_ID, GROUP_CONCAT(NAME) AS NAMES
      from CART_PRODUCTS
      group by CART_ID
     ) AS T
where NAMES like '%Milk%'
AND NAMES like '%Yogurt%'

