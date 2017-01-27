<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="shortcut icon" href="<c:url value="/resources/images/logo.ico"/>">
  <link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet" type="text/css" />
  <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.2.min.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/jcarousellite-1.0.1.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>
  <title>Магазин</title>
</head>
<body>
  <div id="block-body">
    <div id="block-header">

      <div id="header-top-block">

        <ul id="header-top-menu">

          <li>Ваш город - <span>Москва</span></li>
          <li><a href="o-nas">О нас</a></li>
          <li><a href="magaziny">Магазины</a></li>
          <li><a href="contacts">Контакты</a></li>

        </ul>

        <p id="req-auth-title" align="right"><a class="top-auth" href="auth">Вход</a><a href="registration">Регистрация</a></p>

      </div>

      <img src="<c:url value="/resources/images/logo.png"/>" width="165" height="155" style="float:left" />
      <p id="text-about-logo"><b>Интернет-Магазин</b><br><span>Цифровой техники</span></p>

      <div id="info-right">

        <p>Звонок бесплатный</p>
        <p><b>8-(952)-817-65-91</b></p>
        <p>Режим работы:</p>
        <p>Будние дни: с 8 до 19</p>
        <p>Выходные: Суббота, Воскресенье</p>
      </div>
      <div id="img-right-info">

        <img src="<c:url value="/resources/images/phone.png"/>" height="35" width="30" />
        <img src="<c:url value="/resources/images/time.png"/>" height="45" width="45" />

      </div>

      <div id="block-search">

        <form method="" action="">

          <input type="text" id="input-search" name="" placeholder="Поиск товара" />

          <input type="submit" id="button-search" value="Поиск" />

        </form>

      </div>

      <img src="<c:url value="/resources/images/search.png"/>" id="img-search" />

      <div id="top-menu">

        <ul>

          <li><a href=""><img src="<c:url value="/resources/images/home.png"/>" width="25" height="25" />Главная</a></li>
          <li><a href=""><img src="<c:url value="/resources/images/new.png"/>" width="25" height="25" />Новинки</a></li>
          <li><a href=""><img src="<c:url value="/resources/images/best-price.png"/>" width="25" height="25" />Лидеры продаж</a></li>
          <li><a href=""><img src="<c:url value="/resources/images/sale.png"/>" width="25" height="25" />Распродажа</a></li>

        </ul>

        <p align="right" id="nav-crashed"><a href=""><img src="<c:url value="/resources/images/crashed.png"/>" width="25" height="25" /><b>Корзина пуста</b></a></p>

      </div>

    </div>
    <div id="block-right">

      <!--Категории -->
      <div id="block-category">

        <p class="category-title">Категория товаров</p>

        <ul>

          <li><a><img src="<c:url value="/resources/images/smartphone.png"/>" width="15" height="20" id="mobile-img" />Мобильные телефоны</a>

            <ul class="category-section">

              <c:if test="${!empty mobiles}">
                <li><a href="<c:url value="/"/>"><b>Все модели</b></a></li>
                <c:forEach items="${mobiles}" var="mobile">
                  <li><a href="<c:url value="/sort/${mobile.type}/${mobile.brand}"/>">${mobile.brand}</a></li>
                </c:forEach>
              </c:if>

            </ul>

          </li>

          <li><a><img src="<c:url value="/resources/images/planshet.png"/>" width="20" height="15" id="planshet-img" />Планшеты</a>

            <ul class="category-section">

              <c:if test="${!empty notepads}">
                <li><a href="<c:url value="/"/>"><b>Все модели</b></a></li>
                <c:forEach items="${notepads}" var="notepad">
                  <li><a href="<c:url value="/sort/${notepad.type}/${notepad.brand}"/>">${notepad.brand}</a></li>
                </c:forEach>
              </c:if>

            </ul>

          </li>

          <li><a><img src="<c:url value="/resources/images/notebook.png"/>" width="23" height="23" id="notebook-img" />Ноутбуки</a>

            <ul class="category-section">

              <c:if test="${!empty notebooks}">
                <li><a href="<c:url value="/"/>"><b>Все модели</b></a></li>
                <c:forEach items="${notebooks}" var="notebook">
                  <li><a href="<c:url value="/sort/${notebook.type}/${notebook.brand}"/>">${notebook.brand}</a></li>
                </c:forEach>
              </c:if>

            </ul>

          </li>

        </ul>

      </div>

      <!--Параметры-->
      <div id="block-parameter">

        <p class="category-title">Поиск по параметрам</p>

        <p class="title-filter">Стоимость</p>

        <form method="" action="">

          <div id="block-input-price">

            <ul>

              <li><p>от</p></li>
              <li><input type="text" id="start-price" name="start_price" value="1000" /></li>
              <li><p>до</p></li>
              <li><input type="text" id="end-price" name="end_price" value="30000" /></li>
            </ul>

          </div>
          <div id="block-track-bar"></div>

          <p class="title-filter">Производители</p>

          <ul class="checkbox-brand">

            <li><input type="checkbox" id="checkbrand1" /><label for="checkbrand1">Бренд1</label></li>
            <li><input type="checkbox" id="checkbrand2" /><label for="checkbrand2">Бренд2</label></li>
            <li><input type="checkbox" id="checkbrand3" /><label for="checkbrand3">Бренд3</label></li>

          </ul>
          <center><input type="submit" name="submit" id="button-param-search" value="Найти" /></center>

        </form>

      </div>
      <!--Новости -->
      <div id="block-news">

        <center><img id="news-img-up" src="<c:url value="/resources/images/up.png"/>" width="17" height="17" /></center>
        <div id="newsticker">

          <ul>

            <li>

              <span>25.03.2015</span>
              <a href="">Скидка на какую то хрень</a>
              <p>С апреля до мая будет скидка на всякую хрень</p>

            </li>

            <li>

              <span>25.03.2015</span>
              <a href="">Скидка на какую то хрень</a>
              <p>С апреля до мая будет скидка на всякую хрень</p>

            </li>

            <li>

              <span>25.03.2015</span>
              <a href="">Скидка на какую то хрень</a>
              <p>С апреля до мая будет скидка на всякую хрень</p>

            </li>

          </ul>

        </div>
        <center><img id="news-img-down" src="<c:url value="/resources/images/down.png"/>" width="17" height="17" /></center>

      </div>

    </div>
    <!--Контент -->
    <div id="block-content">

      <div id="block-sorting">

        <p id="nav-breadcrumbs"><a href="">Главная страница</a> \ <span>Все товары</span></p>

        <ul id="options-list">

          <li>Вид: </li>
          <li><img id="style-grid" src="<c:url value="/resources/images/sort-grid-active.png"/>" width="20" height="20" /></li>
          <li><img id="style-list" src="<c:url value="/resources/images/sort-list.png"/>" width="20" height="20" /></li>

          <li>Сортировать:</li>
          <li><a id="select-sort">${sort}</a>

            <ul id="sorting-list">

              <li><a href="<c:url value="/sort/ascPrice"/>">От дешовых к дорогим</a></li>
              <li><a href="<c:url value="/sort/descPrice"/>">От дорогих к дешовым</a></li>
              <li><a href="<c:url value="/sort/popular"/>">Популярное</a></li>
              <li><a href="<c:url value="/sort/new"/>">Новинки</a></li>
              <li><a href="<c:url value="/sort/asc"/>">От А до Я</a></li>


            </ul>
          </li>

        </ul>

      </div>
      <ul id="block-tovar-grid">
        <c:if test="${!empty listProducts}">
          <c:forEach items="${listProducts}" var="product">
            <li>
              <div class="block-images-grid">
                <img src="<c:url value="/resources/upload_img/${product.image}.jpg"/>" width="110" height="200" />
              </div>
              <p class="style-title-grid"><a href="">${product.title}</a></p>
              <ul class="reviews-and-com-grid">
                <li><img src="<c:url value="/resources/images/eye.png"/>" /><p>0</p></li>
                <li><img src="<c:url value="/resources/images/comment.png"/>"/><p>0</p></li>
              </ul>
              <a class="add-cart-style-grid"></a>
              <p class="style-price-grid"><strong>${product.price}</strong> руб.</p>
              <div class="mini-features">
                ${product.mini_descr}
              </div>
            </li>
          </c:forEach>
        </c:if>
        <c:if test="${empty listProducts}">
          <h2>Товаров нет</h2>
        </c:if>
      </ul>
      <ul id="block-tovar-list">
        <c:if test="${!empty listProducts}">
          <c:forEach items="${listProducts}" var="product">
            <li>
              <div class="block-images-list">
                <img src="<c:url value="/resources/upload_img/${product.image}.jpg"/>" width="80" height="150" />
              </div>
              <ul class="reviews-and-com-list">
                <li><img src="<c:url value="/resources/images/eye.png"/>" /><p>0</p></li>
                <li><img src="<c:url value="/resources/images/comment.png"/>"/><p>0</p></li>
              </ul>
              <p class="style-title-grid"><a href="">${product.title}</a></p>
              <a class="add-cart-style-grid"></a>
              <p class="style-price-list"><strong>${product.price}</strong> руб.</p>
              <div class="style-text-list">
                  ${product.mini_descr}
              </div>
            </li>
          </c:forEach>
        </c:if>
        <c:if test="${empty listProducts}">
          <h2>Товаров нет</h2>
        </c:if>
      </ul>
    </div>

    <!--Футер отдельно -->
    <div id="block-footer">

      <div id="footer-phone">

        <h4>Служба поддержки</h4>
        <h3>8-(952)-817-65-91</h3>

        <p>

          Режим работы: <br/>
          Будние дни: с 9 до 18 <br/>
          Выходные дни: Суббота, Воскресенье

        </p>

      </div>

      <div class="footer-list">

        <p>Сервис и Помощь</p>
        <ul>

          <li><a href="">Как сделать заказ</a></li>
          <li><a href="">Способы оплаты</a></li>
          <li><a href="">Возврат</a></li>
          <li><a href="">Публичная оферта</a></li>

        </ul>

      </div>

      <div class="footer-list">

        <p>О Компании:</p>
        <ul>

          <li><a href="">О нас</a></li>
          <li><a href="">Вакансии</a></li>
          <li><a href="">Партнерам</a></li>
          <li><a href="">Контакты</a></li>

        </ul>

      </div>

      <div class="footer-list">

        <p>Навигация</p>
        <ul>

          <li><a href="">Главная страница</a></li>
          <li><a href="">Обратная связь</a></li>

        </ul>

        <p>Рассказать о сайте</p>

        <script type="text/javascript">(function() {
          if (window.pluso)if (typeof window.pluso.start == "function") return;
          if (window.ifpluso==undefined) { window.ifpluso = 1;
            var d = document, s = d.createElement('script'), g = 'getElementsByTagName';
            s.type = 'text/javascript'; s.charset='UTF-8'; s.async = true;
            s.src = ('https:' == window.location.protocol ? 'https' : 'http')  + '://share.pluso.ru/pluso-like.js';
            var h=d[g]('body')[0];
            h.appendChild(s);
          }})();</script>
        <div class="pluso" data-background="#ebebeb" data-options="small,square,line,horizontal,nocounter,theme=08" data-services="vkontakte,odnoklassniki,facebook,twitter,google,moimir,email,print"></div>

      </div>

    </div>
  </div>
</body>
</html>
