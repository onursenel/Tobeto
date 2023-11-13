--26. Stokta bulunmayan ürünlerin ürün listesiyle birlikte tedarikçilerin ismi ve iletişim numarasını (`ProductID`, `ProductName`, `CompanyName`, `Phone`) 
--almak için bir sorgu yazın
select p.product_id, p.product_name,s.company_name, s.phone from products p
inner join suppliers s on s.supplier_id = p.supplier_id
where p.units_in_stock =0
order by product_id

--27. 1998 yılı mart ayındaki siparişlerimin adresi, siparişi alan çalışanın adı, çalışanın soyadı
select o.order_date,o.ship_address, e.first_name || ' ' || e.last_name as "Adı ve Soyadı" from orders o
inner join employees e on e.employee_id = o.employee_id
where extract(month from order_date)= 03 and extract(year from order_date)= 1998

--28. 1997 yılı şubat ayında kaç siparişim var?
select count(*) as "1997 Şubat ayı Top. Sipariş sayısı" from orders
where extract(month from order_date)= 02 and extract(year from order_date)= 1997

--29. London şehrinden 1998 yılında kaç siparişim var?
select count(*) as "London şehrinden 1998 yılındaki sipariş sayısı" from orders o
where extract(year from o.order_date)= 1998 and o.ship_city = 'London'

--30. 1997 yılında sipariş veren müşterilerimin contactname ve telefon numarası
select c.contact_name,c.phone  from orders o
inner join customers c on c.customer_id = o.customer_id
where extract(year from o.order_date)= 1997

--31. Taşıma ücreti 40 üzeri olan siparişlerim
select * from orders
where freight > 40

--32. Taşıma ücreti 40 ve üzeri olan siparişlerimin şehri, müşterisinin adı
select c.contact_name,o.ship_city from orders o
inner join customers c on c.customer_id = o.customer_id
where o.freight >= 40

--33.1997 yılında verilen siparişlerin tarihi, şehri, çalışan adı -soyadı ( ad soyad birleşik olacak ve büyük harf),
select o.order_date,o.ship_city,upper(e.first_name || ' ' || e.last_name) as "AD-SOYAD" from orders o
inner join employees e on e.employee_id = o.employee_id
where extract(year from order_date) = 1997

--34.1997 yılında sipariş veren müşterilerin contactname i, ve telefon numaraları ( telefon formatı 2223322 gibi olmalı )
select c.contact_name,regexp_replace(right(c.phone,8), '[^0-9]','','')  from orders o
inner join customers c on c.customer_id = o.customer_id
where extract(year from order_date) = 1997

--35.Sipariş tarihi, müşteri contact name, çalışan ad, çalışan soyad
select o.order_date,c.contact_name,e.first_name,e.last_name from orders o 
inner join employees e on e.employee_id = o.employee_id
inner join customers c on c.customer_id = o.customer_id

--36. Geciken siparişlerim?
select * from orders
where shipped_date > required_date

--37.Geciken siparişlerimin tarihi, müşterisinin adı
select o.order_date, c.contact_name from orders o
inner join customers c on c.customer_id = o.customer_id
where shipped_date >required_date

--38. 10248 nolu siparişte satılan ürünlerin adı, kategorisinin adı, adedi
select p.product_name,c.category_name,od.quantity from order_details od
inner join products p on p.product_id = od.product_id
inner join categories c on c.category_id = p.category_id
where od.order_id = 10248

--39. 10248 nolu siparişin ürünlerinin adı , tedarikçi adı
select p.product_name,s.company_name from order_details od 
inner join products p on p.product_id = od.product_id
inner join suppliers s on s.supplier_id = p.supplier_id

--40. 3 numaralı ID ye sahip çalışanın 1997 yılında sattığı ürünlerin adı ve adeti
select p.product_name,od.quantity from orders o
inner join order_details od on od.order_id = o.order_id
inner join products p on p.product_id = od.product_id
where o.employee_id = 3 and extract(year from o.order_date) = 1997

--41. 1997 yılında bir defasinda en çok satış yapan çalışanımın ID,Ad soyad
select e.employee_id,e.first_name || ' ' || e.last_name as "Adı ve soyadı",sum(od.quantity*od.unit_price) as "toplam sipariş" from employees e
inner join orders o on o.employee_id = e.employee_id
inner join order_details od on od.order_id = o.order_id
where extract(year from o.order_date) = 1997
group by e.employee_id
order by "toplam sipariş" desc
limit 1

--42. 1997 yılında en çok satış yapan çalışanımın ID,Ad soyad ****
select e.employee_id, e.first_name || ' ' || e.last_name as "Çalışanın Adı-Soyadı" , count(*) as "sattığı miktar" from order_details od
inner join orders o on o.order_id = od.order_id
inner join employees e on o.employee_id = e.employee_id
where extract(year from o.order_date) = 1997 
group by e.employee_id
order by "sattığı miktar" desc 
limit 1

--43. En pahalı ürünümün adı,fiyatı ve kategorisin adı nedir?
select p.product_name,p.unit_price,c.category_name from products p
inner join categories c on c.category_id = p.category_id
order by p.unit_price desc
limit 1

--44. Siparişi alan personelin adı,soyadı, sipariş tarihi, sipariş ID. Sıralama sipariş tarihine göre
select e.first_name || ' ' || e.last_name as "Personelin Adı-Soyadı",o.order_date,o.order_id from orders o
inner join employees e on e.employee_id = o.employee_id
order by o.order_date

--45. SON 5 siparişimin ortalama fiyatı ve orderid nedir?
select o.order_id, avg(p.unit_price) as "Ortalama fiyat" from orders o
inner join order_details od on od.order_id = o.order_id
inner join products p on p.product_id = od.product_id
group by o.order_id
order by o.order_date desc
limit 5

--46. Ocak ayında satılan ürünlerimin adı ve kategorisinin adı ve toplam satış miktarı nedir?
select p.product_name,c.category_name,od.quantity from orders o
inner join order_details od on od.order_id = o.order_id
inner join products p on p.product_id = od.product_id
inner join categories c on c.category_id = p.category_id
where extract(month from o.order_date) =1

--47. Ortalama satış miktarımın üzerindeki satışlarım nelerdir?
select * from order_details od
inner join orders o on o.order_id = od.order_id
where od.quantity > (select AVG(quantity) from order_details)

--48. En çok satılan ürünümün(adet bazında) adı, kategorisinin adı ve tedarikçisinin adı
select p.product_name,c.category_name,s.company_name from order_details od
inner join products p on p.product_id = od.product_id
inner join suppliers s on s.supplier_id = p.supplier_id
inner join categories c on c.category_id = p.category_id
order by od.quantity desc
limit 1

--49. Kaç ülkeden müşterim var
select count(distinct(country)) as "Kaç ülkeden Müşterim var" from customers

--50. 3 numaralı ID ye sahip çalışan (employee) son Ocak ayından BUGÜNE toplamda ne kadarlık ürün sattı?
select sum(od.quantity*od.unit_price) as "toplamda ne kadarlık ürün sattı" from orders o 
inner join order_details od on od.order_id = o.order_id
where o.employee_id = 3 and o.order_date >= date '1998-01-01' and o.order_date <= date '2023-11-13';

--51. 10248 nolu siparişte satılan ürünlerin adı, kategorisinin adı, adedi
select p.product_name,c.category_name,od.quantity from order_details od
inner join products p on p.product_id = od.product_id
inner join categories c on c.category_id = p.category_id
where od.order_id = 10248

--52. 10248 nolu siparişin ürünlerinin adı , tedarikçi adı
select p.product_name,s.company_name from order_details od 
inner join products p on p.product_id = od.product_id
inner join suppliers s on s.supplier_id = p.supplier_id

--53. 3 numaralı ID ye sahip çalışanın 1997 yılında sattığı ürünlerin adı ve adeti
select p.product_name,od.quantity from orders o
inner join order_details od on od.order_id = o.order_id
inner join products p on p.product_id = od.product_id
where o.employee_id = 3 and extract(year from o.order_date) = 1997

--54. 1997 yılında bir defasinda en çok satış yapan çalışanımın ID,Ad soyad
select e.employee_id,e.first_name || ' ' || e.last_name as "Adı ve soyadı",sum(od.quantity*od.unit_price) as "toplam sipariş" from employees e
inner join orders o on o.employee_id = e.employee_id
inner join order_details od on od.order_id = o.order_id
where extract(year from o.order_date) = 1997
group by e.employee_id
order by "toplam sipariş" desc
limit 1

--55. 1997 yılında en çok satış yapan çalışanımın ID,Ad soyad ****
select e.employee_id, e.first_name || ' ' || e.last_name as "Çalışanın Adı-Soyadı" , count(*) as "sattığı miktar" from order_details od
inner join orders o on o.order_id = od.order_id
inner join employees e on o.employee_id = e.employee_id
where extract(year from o.order_date) = 1997 
group by e.employee_id
order by "sattığı miktar" desc 
limit 1

--56.En pahalı ürünümün adı,fiyatı ve kategorisin adı nedir?
select p.product_name,p.unit_price,c.category_name from products p
inner join categories c on c.category_id = p.category_id
order by p.unit_price desc
limit 1

--57. Siparişi alan personelin adı,soyadı, sipariş tarihi, sipariş ID. Sıralama sipariş tarihine göre
select e.first_name || ' ' || e.last_name as "Personelin Adı-Soyadı",o.order_date,o.order_id from orders o
inner join employees e on e.employee_id = o.employee_id
order by o.order_date

--58. SON 5 siparişimin ortalama fiyatı ve order id nedir?
select o.order_id, avg(p.unit_price) as "Ortalama fiyat" from orders o
inner join order_details od on od.order_id = o.order_id
inner join products p on p.product_id = od.product_id
group by o.order_id
order by o.order_date desc
limit 5

--59. Ocak ayında satılan ürünlerimin adı ve kategorisinin adı ve toplam satış miktarı nedir?
select p.product_name,c.category_name,od.quantity from orders o
inner join order_details od on od.order_id = o.order_id
inner join products p on p.product_id = od.product_id
inner join categories c on c.category_id = p.category_id
where extract(month from o.order_date) =1

--60. Ortalama satış miktarımın üzerindeki satışlarım nelerdir?
select * from order_details od
inner join orders o on o.order_id = od.order_id
where od.quantity > (select AVG(quantity) from order_details)

--61. En çok satılan ürünümün(adet bazında) adı, kategorisinin adı ve tedarikçisinin adı
select p.product_name,c.category_name,s.company_name from order_details od
inner join products p on p.product_id = od.product_id
inner join suppliers s on s.supplier_id = p.supplier_id
inner join categories c on c.category_id = p.category_id
order by od.quantity desc
limit 1

--62. Kaç ülkeden müşterim var
select count(distinct(country)) as "Kaç ülkeden Müşterim var" from customers

--63. Hangi ülkeden kaç müşterimiz var
select country, count(distinct customer_id) as "kaç müşterimiz var" from customers
group by country;

--64. 3 numaralı ID ye sahip çalışan (employee) son Ocak ayından BUGÜNE toplamda ne kadarlık ürün sattı?
select sum(od.quantity*od.unit_price) as "toplamda ne kadarlık ürün sattı" from orders o 
inner join order_details od on od.order_id = o.order_id
where o.employee_id = 3 and o.order_date >= date '1998-01-01' and o.order_date <= date '2023-11-13';

--65. 10 numaralı ID ye sahip ürünümden son 3 ayda ne kadarlık ciro sağladım?
select sum(od.unit_price * od.quantity) as "3 aylık ciro" from products p
inner join order_details od on od.product_id = p.product_id
inner join orders o on o.order_id = od.order_id
where p.product_id = 10 and o.order_date >= current_date - interval '3 months'

--66. Hangi çalışan şimdiye kadar toplam kaç sipariş almış..?
select e.first_name || ' ' || e.last_name as "Adı ve Soyadı", count(o.order_id) as "Toplam aldığı sipariş sayısı" from orders o
inner join order_details od on od.order_id = o.order_id
inner join employees e on e.employee_id = o.employee_id
group by "Adı ve Soyadı"

--67. 91 müşterim var. Sadece 89’u sipariş vermiş. Sipariş vermeyen 2 kişiyi bulun
select * from customers c
left join orders o on o.customer_id = c.customer_id
where o.order_id is null

--68. Brazil’de bulunan müşterilerin Şirket Adı, TemsilciAdi, Adres, Şehir, Ülke bilgileri
select c.company_name,c.contact_name,c.address,c.city,c.country from customers c
where c.country = 'Brazil'

--69. Brezilya’da olmayan müşteriler
select * from customers c
where c.country <> 'Brazil'

--70. Ülkesi (Country) YA Spain, Ya France, Ya da Germany olan müşteriler
select * from customers c
where c.country = 'Spain' or c.country = 'France'

--71. Faks numarasını bilmediğim müşteriler
select * from customers c
where fax is null

--72. Londra’da ya da Paris’de bulunan müşterilerim
select * from customers c
where c.city = 'London' or c.city = 'Paris'

--73. Hem Mexico D.F’da ikamet eden HEM DE ContactTitle bilgisi ‘owner’ olan müşteriler
select * from customers c
where c.city = 'México D.F.' and c.contact_title = 'Owner'

--74. C ile başlayan ürünlerimin isimleri ve fiyatları
select p.product_name,p.unit_price from products p
where p.product_name like 'C%'

--75. Adı (FirstName) ‘A’ harfiyle başlayan çalışanların (Employees); Ad, Soyad ve Doğum Tarihleri
select e.first_name , e.last_name ,e.birth_Date from employees e
where e.first_name like 'A%'

--76. İsminde ‘RESTAURANT’ geçen müşterilerimin şirket adları
select c.company_name from customers c
where c.company_name Ilike '%RESTAURANT%'

--77. 50$ ile 100$ arasında bulunan tüm ürünlerin adları ve fiyatları
select p.product_name,p.unit_price from products p 
where unit_price between 50 and 100

--78. 1 temmuz 1996 ile 31 Aralık 1996 tarihleri arasındaki siparişlerin (Orders), SiparişID (OrderID) ve SiparişTarihi (OrderDate) bilgileri
select o.order_id,o.order_date from orders o
where o.order_date between '1996-07-01' and '1996-12-31'

--79. Ülkesi (Country) YA Spain, Ya France, Ya da Germany olan müşteriler
select * from customers c
where c.country = 'Spain' or c.country = 'France'

--80. Faks numarasını bilmediğim müşteriler
select * from customers c
where fax is null

--81. Müşterilerimi ülkeye göre sıralıyorum:
select * from customers c
order by c.country

--82. Ürünlerimi en pahalıdan en ucuza doğru sıralama, sonuç olarak ürün adı ve fiyatını istiyoruz
select p.product_name , p.unit_price from products p
order by p.unit_price desc

--83. Ürünlerimi en pahalıdan en ucuza doğru sıralasın, ama stoklarını küçükten-büyüğe doğru göstersin sonuç olarak ürün adı ve fiyatını istiyoruz
select p.product_name , p.unit_price , p.units_in_stock from products p
order by p.unit_price desc, p.units_in_stock asc

--84. 1 Numaralı kategoride kaç ürün vardır..?
select count(*) as "ürün sayısı" from products p
where p.category_id = 1

--85. Kaç farklı ülkeye ihracat yapıyorum..?
select count(distinct country) as "İhracat yapılan ülke sayısı" from customers




