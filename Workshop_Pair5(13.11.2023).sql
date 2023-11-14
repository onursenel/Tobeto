--85. Kaç farklı ülkeye ihracat yapıyorum..?
select count(distinct country) as "Number of export countries" from customers;

--86. a.Bu ülkeler hangileri..?
select distinct country from customers;

--87. En Pahalı 5 ürün?
select product_name, unit_price from Products order by unit_price DESC limit 5;

--88. ALFKI CustomerID’sine sahip müşterimin sipariş sayısı..?
select c.customer_id, count(od.quantity) as quantity_count from customers c
left join orders o on c.customer_id = o.customer_id
left join order_details od on o.order_id = od.order_id
where c.customer_id = 'ALFKI' group by c.customer_id; v

--89. Ürünlerimin toplam maliyeti?
SELECT SUM(unit_price * units_in_stock) AS "Toplam Maliyet" FROM products;

--90. Şirketim, şimdiye kadar ne kadar ciro yapmış..?
select sum((od.unit_price * od.quantity) - (od.unit_price * od.quantity * od.discount)) 
as total_proceeds from order_details od inner join orders o on od.order_id = o.order_id;

--91. Ortalama Ürün Fiyatım?
select avg(unit_price) from products;

--92. En Pahalı Ürünün Adı?
select product_name from products order by unit_price DESC LIMIT 1;

--93. En az kazandıran sipariş?
select order_id, sum(od.unit_price * od.quantity) as least_proceeds_order from order_details od
group by order_id order by least_proceeds_order asc limit 1;

--94. Müşterilerimin içinde en uzun isimli müşteri?
select contact_name from customers order by length(contact_name) desc limit 1;

--95. Çalışanlarımın Ad, Soyad ve Yaşları?
select first_name, last_name, extract(year from age(now(), birth_date)) as age from employees; 

--96. Hangi üründen toplam kaç adet alınmış..?
select p.product_id, p.product_name, sum(od.quantity) as total_number from order_details od
inner join products p on od.product_id = p.product_id group by p.product_id, p.product_name
order by total_number desc;

--97. Hangi siparişte toplam ne kadar kazanmışım..?
select order_id, sum(unit_price * quantity * (1 - discount)) from order_details group by order_id;

--98. Hangi kategoride toplam kaç adet ürün bulunuyor..?
select category_id, count(*) as total_products from products group by category_id;

--99. 1000 Adetten fazla satılan ürünler?
select product_id, sum(quantity) from order_details 
where product_id in (select product_id from order_details group by product_id having sum(quantity) > 1000)
group by product_id;

--100. Hangi Müşterilerim hiç sipariş vermemiş..?
select c.customer_id, c.company_name from customers c
where not exists (select 1 from orders o where c.customer_id = o.customer_id);

--101. Hangi tedarikçi hangi ürünü sağlıyor ?
select s.company_name, p.product_name
from suppliers s, products p
where s.supplier_id = p.supplier_id
order by s.company_name, p.product_name;

--102. Hangi sipariş hangi kargo şirketi ile ne zaman gönderilmiş..?
select o.order_id, sh.company_name, o.shipped_date as sending_date
from orders o inner join shippers sh on o.ship_via = sh.shipper_id;

--103. Hangi siparişi hangi müşteri verir..?
select o.order_id, c.company_name from orders o
join customers c on o.customer_id = c.customer_id;

--104. Hangi çalışan, toplam kaç sipariş almış..?
select e.employee_id, e.first_name, e.last_name, count(o.order_id) as total_order_count from employees e
left join orders o on e.employee_id = o.employee_id
group by e.employee_id, e.first_name, e.last_name
order by total_order_count desc;

--105. En fazla siparişi kim almış..?
select e.employee_id, e.first_name, e.last_name, count(o.order_id) as total_order_count from employees e
join orders o on e.employee_id = o.employee_id
group by e.employee_id, e.first_name, e.last_name
order by total_order_count desc limit 1;

--106. Hangi siparişi, hangi çalışan, hangi müşteri vermiştir..?
select o.order_id, concat(e.first_name , ' ' , e.last_name) as employeer_name, c.company_name from orders o
inner join customers c on o.customer_id = c.customer_id
inner join employees e on o.employee_id = e.employee_id;

--107. Hangi ürün, hangi kategoride bulunmaktadır..? Bu ürünü kim tedarik etmektedir..?
select p.product_name, c.category_name, s.company_name from products p
join categories c on p.category_id = c.category_id
join suppliers s on p.supplier_id = s.supplier_id;

--108. Hangi siparişi hangi müşteri vermiş, hangi çalışan almış, hangi tarihte, hangi kargo şirketi tarafından gönderilmiş hangi üründen kaç adet alınmış, hangi fiyattan alınmış, ürün hangi kategorideymiş bu ürünü hangi tedarikçi sağlamış?
select o.order_id,
       cu.customer_id,
       CONCAT(cu.contact_name, ' ', cu.contact_title),
       e.employee_id,
       CONCAT(e.first_name, ' ', e.last_name),
       o.order_date,
       s.company_name,
       p.product_name,
       od.quantity,
       od.unit_price,
       c.category_name,
       sup.company_name FROM orders o
join customers cu on o.customer_id = cu.customer_id
join employees e on o.employee_id = e.employee_id
join shippers s on o.ship_via = s.shipper_id
join order_details od on o.order_id = od.order_id
join products p on od.product_id = p.product_id
join categories c on p.category_id = c.category_id
join suppliers sup on p.supplier_id = sup.supplier_id;
 
--109. Altında ürün bulunmayan kategoriler?
select c.category_id, c.category_name from categories c
left join products p on c.category_id = p.category_id
where p.product_id is NULL;

--110. Manager ünvanına sahip tüm müşterileri listeleyiniz?
select customer_id, company_name,contact_name from customers where contact_title Ilike '%Manager%';

--111. FR ile başlayan 5 karekter olan tüm müşterileri listeleyiniz?
select customer_id, company_name, contact_name from customers
where customer_id like 'FR___%'; -- and length(customer_id) = 5;

--112. (171) alan kodlu telefon numarasına sahip müşterileri listeleyiniz?
select customer_id, company_name, contact_name, phone from customers
where phone like '%(171)%';

--113. BirimdekiMiktar alanında boxes geçen tüm ürünleri listeleyiniz?
select product_id, product_name, quantity_per_unit from products
where quantity_per_unit like '%boxes%';

--114. Fransa ve Almanyadaki (France,Germany) Müdürlerin (Manager) Adını ve Telefonunu listeleyiniz.(MusteriAdi,Telefon)?
select c.contact_name, c.phone from customers c
where c.country in ('France', 'Germany') and c.contact_title like '%Manager%';

--115. En yüksek birim fiyata sahip 10 ürünü listeleyiniz?
select * from products order by unit_price desc limit 10;

--116. Müşterileri ülke ve şehir bilgisine göre sıralayıp listeleyiniz?
select * from customers order by country, city;

--117. Personellerin ad,soyad ve yaş bilgilerini listeleyiniz?
select first_name, last_name, extract(year from age(now(), birth_date)) as age from employees;

--118. 35 gün içinde sevk edilmeyen satışları listeleyiniz?
select * from orders where shipped_date is NULL or (order_date - shipped_date) > 35;

--119. Birim fiyatı en yüksek olan ürünün kategori adını listeleyiniz? (Alt Sorgu)
select category_name from categories c
where exists ( select category_id from products p where p.category_id = c.category_id
order by unit_price desc) limit 1;

--120. Kategori adında 'on' geçen kategorilerin ürünlerini listeleyiniz? (Alt Sorgu)
SELECT product_name FROM products p
WHERE EXISTS ( SELECT * FROM categories c WHERE p.category_id = c.category_id
AND c.category_name LIKE '%on%');

--121. Konbu adlı üründen kaç adet satılmıştır?
select sum(quantity) as total_sold from order_details
where product_id = (select product_id from products
where product_name = 'Konbu');
					
--122. Japonyadan kaç farklı ürün tedarik edilmektedir?
select count(distinct p.product_id) from products p
join suppliers s ON p.supplier_id = s.supplier_id
where s.country = 'Japan';

--123. 1997 yılında yapılmış satışların en yüksek, en düşük ve ortalama nakliye ücretlisi ne kadardır?
select max(freight) as maximum_fee, min(freight) as minimum_fee, avg(freight) as average_fee
from orders where extract(year from order_date) = 1997;

--124. Faks numarası olan tüm müşterileri listeleyiniz?
select * from customers where fax is not NULL;

--125. 1996-07-16 ile 1996-07-30 arasında sevk edilen satışları listeleyiniz?
select order_id, customer_id, order_date, shipped_date from orders
where shipped_date between '1996-07-16' and '1996-07-30';









