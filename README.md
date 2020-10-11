# Shop (REST)

Приложение позволяет создавать информацию о продуктах компании и информационные статьи об их продуктах. 
Данные хранятся в базе данных.


## Getting Started
Создаём базу данных в postgresql под именем "company". <br>
Стартуем проект.

<h4>API for product:</h4><br>
<b>Получение всех продуктов: (GET) http://localhost:8080/api/product/</b><br><br>

<b>Получение всех статей по id продукта: (GET) http://localhost:8080/api/product/{id}</b><br><br>

<b>Сохранение продукта (В тело подаём Product в JSON формате): (POST) http://localhost:8080/api/product/<br>
Пример:  {<br>
                 "id": 100,<br>
                 "productName": "Apple mobile",<br>
                 "description": "description",<br>
                 "salary": 7500,<br>
                 "articles": []<br>
             }</b><br><br>
<b>Обновление продукта (В тело подаём Product в JSON формате): (PUT) http://localhost:8080/api/product/{id}<br><br>

<b>Удаление продукта: (DELETE) http://localhost:8080/api/product/{id}<br><br>

<b>Сортировка продуктов по имени: (GET) http://localhost:8080/api/product/sort?param=name<br><br>
<b>Сортировка продуктов по стоимости: (GET) http://localhost:8080/api/product/sort?param=salary<br><br>

<b>Фильтр продуктов по имени: (GET) http://localhost:8080/api/product/filter?name={text}<br><br>
<b>Фильтр продуктов по стоимости: (GET) http://localhost:8080/api/product/filter?salary={number}<br><br>



---
<h4>API for article:</h4><br>
<b>Получение всех статей: (GET) http://localhost:8080/api/article/</b><br><br>

<b>Получение определённой статьи по id: (GET) http://localhost:8080/api/article/{id}</b><br><br>

<b>Сохранение статьи (В тело подаём Article в JSON формате): (POST) http://localhost:8080/api/article/<br>
Пример:  {<br>
             "id": 4,<br>
             "articleName": "About Laptop N1",<br>
             "content": "here is the content",<br>
             "date": "2020-10-08T14:22:33.000+00:00",<br>
             "product": {<br>
                 "id": 3,<br>
                 "productName": "PC",<br>
                 "description": "description",<br>
                 "salary": 10000,<br>
                 "articles": []<br>
             }<br>
         }</b><br><br>
<b>Обновление статьи (В тело подаём Article в JSON формате): (PUT) http://localhost:8080/api/article/{id}<br><br>

<b>Удаление статьи: (DELETE) http://localhost:8080/api/article/{id}<br><br>

<b>Сортировка статей по имени: (GET) http://localhost:8080/api/article/sort?param=name<br><br>
<b>Сортировка статей по дате: (GET) http://localhost:8080/api/article/sort?param=date<br><br>

<b>Фильтр статей по имени: (GET) http://localhost:8080/api/article/filter?name={text}<br><br>
<b>Фильтр статей по имени продукта: (GET) http://localhost:8080/api/article/filter?product={text}<br><br>
