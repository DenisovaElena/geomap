<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Evolution Map</title>
		<link href="resources/css/index.css" rel="stylesheet">
        <link href='https://api.tiles.mapbox.com/mapbox-gl-js/v1.3.0/mapbox-gl.css' rel='stylesheet' />
        <script src='https://api.tiles.mapbox.com/mapbox-gl-js/v1.3.0/mapbox-gl.js'></script>
        <script src='https://api.mapbox.com/mapbox-gl-js/plugins/mapbox-gl-geocoder/v4.4.1/mapbox-gl-geocoder.min.js'></script>
        <link rel='stylesheet' href='https://api.mapbox.com/mapbox-gl-js/plugins/mapbox-gl-geocoder/v4.4.1/mapbox-gl-geocoder.css' type='text/css' />
        <script src='resources/js/language.js'></script>
	</head>
	<body>
		<div id="map">
            <%--Подложка--%>
			<div id="back" class="d-none">
				<%--<div id="pointer">
					<img src="resources/img/pointer.png" alt="Курсор">
					<p>Для выполнения действий и отображения информации нажмите на объект</p>
					<button id="btnNext" class="ui-button ui-widget ui-corner-all">Продолжить</button>
				</div>--%>
			</div>
			<%--<div class="coordinates">
                <div id="longitude"></div>
				<div id="latitude"></div>
			</div>--%>
            <%--Верхнее меню--%>
            <div id="topBlock">
                <div class="macUp">
                    <div id="macpUp">
                        <div class="boofer"></div>
                        <div class='icoblock'>
                            <div class='item3 blockLeft' id="btnMinus">
                                <div class="icon"><img class="d-none" src="resources/img/top1_1.png" alt="Иконка" /></div>
                                <img class="ref d-none" src="resources/img/top11_1.png" alt="Иконка" />
                            </div>
                            <div class='item4 blockLeft' id="btnPlus">
                                <div class="icon"><img class="d-none" src="resources/img/top1_2.png" alt="Иконка" /></div>
                                <img class="ref d-none" src="resources/img/top11_2.png" alt="Иконка" />
                            </div>
                            <div class='item2'></div>
                            <div class='item1 chpok'>
                                <div class="icon block1" counter="0" data-table="0">
                                    <img src="resources/img/img0.png" alt="Проблемы с адресом" />
                                </div>
                                <img class="ref" src="resources/img/img0_1.png" alt="Проблемы с адресом" />
                                <div class="blockUp" data-block="0">
                                    <h2>Проблемы с адресом</h2>
                                    <button class="ui-button ui-widget ui-corner-all problemsValue" val="addressIssuesNoAddress">Нет адреса</button>
                                    <button class="ui-button ui-widget ui-corner-all problemsValue" val="addressIssuesIncomplete">Неполный адрес</button>
                                    <button class="ui-button ui-widget ui-corner-all problemsValue" val="addressIssuesInvalid">Некорректный адрес</button>
                                    <button class="ui-button ui-widget ui-corner-all allProblems problemsValue" val="addressIssues">Все проблемы</button>
                                </div>
                            </div>
                            <div class='item chpok'>
                                <div class="icon block1" counter="0" data-table="1">
                                    <img src="resources/img/img1.png" alt="Проблемы с оформлением ЗПО" />
                                </div>
                                <img class="ref" src="resources/img/img1_1.png" alt="Проблемы с оформлением ЗПО" />
                                <%--<div class="blockUp" data-block="1">
                                    <h2>Проблемы с оформлением ЗПО</h2>
                                    <button class="ui-button ui-widget ui-corner-all">Оформление отсутствует</button>
                                    <button class="ui-button ui-widget ui-corner-all">Некорректное оформление</button>
                                </div>--%>
                            </div>
                            <div class='item chpok'><div class="icon block1" data-table="2">
                                <img src="resources/img/img2.png" alt="Самовольная застройка" />
                            </div>
                                <img class="ref" src="resources/img/img2_1.png" alt="Самовольная застройка" />
                            </div>
                            <div class='item chpok'>
                                <div class="icon block1" data-table="3">
                                    <img src="resources/img/img3.png" alt="Нецелевое использование" />
                                </div>
                                <img class="ref" src="resources/img/img3_1.png" alt="Нецелевое использование" />
                            </div>
                            <div class='item chpok'>
                                <div class="icon block1" data-table="4">
                                    <img src="resources/img/img4.png" alt="Самозахват" />
                                </div>
                                <img class="ref" src="resources/img/img4_1.png" alt="Самозахват" />
                            </div>
                            <div class='item chpok'>
                                <div class="icon block1" data-table="5">
                                    <img src="resources/img/img5.png" alt="Превышение сроков строительства" />
                                </div>
                                <img class="ref" src="resources/img/img5_1.png" alt="Превышение сроков строительства" />
                            </div>
                            <div class='item chpok'>
                                <div class="icon block1" data-table="6">
                                    <img src="resources/img/img6.png" alt="Ненадлежащее содержание" />
                                </div>
                                <img class="ref" src="resources/img/img6_1.png" alt="Ненадлежащее содержание" />
                            </div>
                            <div class='item2'></div>
                            <div class='item4'><div class="icon blockRight"><img class="ref1" src="resources/img/top9.png" alt="Переключатель" /></div><img class="ref" src="resources/img/top91.png" alt="Переключатель" /></div>
                        </div>
                    </div>
                </div>
            </div>
            <%--Всплывающие блоки нижнего меню--%>
            <div id="bottomMenuBlock">
            <%--Всплывающие блоки верхнего меню--%>
            <%--

            <div class="blockUp" data-block="11">
                <h2>Самовольная застройка</h2>
            </div>
            <div class="blockUp" data-block="13">
                <h2>Нецелевое использование</h2>
            </div>
            <div class="blockUp" data-block="12">
                <h2>Самозахват</h2>
            </div>
            <div class="blockUp" data-block="14">
                <h2>Превышение сроков строительства</h2>
            </div>
            <div class="blockUp" data-block="15">
                <h2>Ненадлежащее содержание</h2>
            </div>--%>
            </div>
            <%--Нижнее меню--%>
			<div id="bottomBlock">
                <div class="mac">
                    <div id="macpBottom">
                        <div class="boofer"></div>
                        <div class='icoblock'>
                            <div class='item'><div class="icon block" data-bottom="1"><img src="resources/img/down1.png" alt="Адрес" /></div><img class="ref" src="resources/img/down11.png" alt="Адрес" /></div>
                            <div class='item'><div class="icon block" data-bottom="2"><img src="resources/img/down2.png" alt="Характеристики" /></div><img class="ref" src="resources/img/down21.png" alt="Характеристики" /></div>
                            <div class='item'><div class="icon block" data-bottom="3"><img src="resources/img/down3.png" alt="Назначение" /></div><img class="ref" src="resources/img/down31.png" alt="Назначение" /></div>
                            <div class='item'><div class="icon block" data-bottom="4"><img src="resources/img/down4.png" alt="Правообладание" /></div><img class="ref" src="resources/img/down41.png" alt="Правообладание" /></div>
                            <div class='item'><div class="icon block" data-bottom="5"><img src="resources/img/down5.png" alt="Оценка объекта" /></div><img class="ref" src="resources/img/down51.png" alt="Оценка объекта" /></div>
                            <div class='item'><div class="icon block" data-bottom="6"><img src="resources/img/down6.png" alt="Стоимость владения" /></div><img class="ref" src="resources/img/down61.png" alt="Стоимость владения" /></div>
                            <div class='item'><div class="icon block" data-bottom="7"><img src="resources/img/down7.png" alt="Доходы бюджета" /></div><img class="ref" src="resources/img/down71.png" alt="Доходы бюджета" /></div>
                            <div class='item'><div class="icon block" data-bottom="8"><img src="resources/img/down8.png" alt="Соблюдение законодательства" /></div><img class="ref" src="resources/img/down81.png" alt="Соблюдение законодательства" /></div>
                            <div class='item2'></div>
                            <div class='item1'><div class="icon block"><img onclick='changeLayer();' src="resources/img/down9.png" alt="Переключатель" /></div><img class="ref" src="resources/img/down91.png" alt="Переключатель" /></div>
                        </div>
                    </div>
                </div>
			</div>
            <%--Боковая панель--%>
            <div id="rightBlock" class="ui-widget-content d-none">
                <h2 class="ui-widget-header">Выбранные объекты</h2>
                <div class="saveBlock" class="d-none">
                    <div class="buttonsBlock">
                        <button id="btnCorrect1" class="ui-button ui-widget ui-corner-all">Корректировка проблем</button>
                        <button id="btnSave1" class="ui-button ui-widget ui-corner-all">Применить для всех</button>
                    </div>
                </div>
                <div class="clr"></div>
                <div id="resizable"></div>
                <div id="tabsBlock" class="d-none">
                    <h3 id="tabsTitle"></h3>
                    <div class="saveBlock" class="d-none">
                        <div class="buttonsBlock">
                            <button id="btnCorrect" class="ui-button ui-widget ui-corner-all d-none">Корректировка</button>
                            <button id="btnSave" class="ui-button ui-widget ui-corner-all">Сохранить</button>
                            <div id="controlGroup">
                                <button id="btnChange" class="ui-button ui-widget ui-corner-all">Исключить</button>
                                <div id="dropDown">
                                    <p>Нет адреса</p>
                                    <p>Неполный адрес</p>
                                    <p>Некорректный адрес</p>
                                    <p>Все проблемы</p>
                                </div>
                            </div>
                            <%--<button id="btnReset" class="ui-button ui-widget ui-corner-all">Исключить</button>--%>
                        </div>
                    </div>
                    <div class="clr"></div>
                    <div id="tabsBlock1">
                        <div id="tabs">
                            <ul>
                                <li><a href="#tabs-1" title="Адрес"><img class="miniImg" src="resources/img/mini1.png" alt="Адрес"></a></li>
                                <li><a href="#tabs-2" title="Характеристики"><img class="miniImg" src="resources/img/mini2.png" alt="Характеристики"></a></li>
                                <li><a href="#tabs-3" title="Назначение"><img class="miniImg" src="resources/img/mini3.png" alt="Назначение"></a></li>
                                <li><a href="#tabs-4" title="Правообладание"><img class="miniImg" src="resources/img/mini4.png" alt="Правообладание"></a></li>
                                <li><a href="#tabs-5" title="Оценка объекта"><img class="miniImg" src="resources/img/mini5.png" alt="Оценка объекта"></a></li>
                                <li><a href="#tabs-6" title="Стоимость владения"><img class="miniImg" src="resources/img/mini6.png" alt="Стоимость владения"></a></li>
                                <li><a href="#tabs-7" title="Доходы бюджета"><img class="miniImg" src="resources/img/mini7.png" alt="Доходы бюджета"></a></li>
                                <li><a href="#tabs-8" title="Соблюдение законодательства"><img class="miniImg" src="resources/img/mini8.png" alt="Соблюдение законодательства"></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
		</div>
        <div id="dialog-confirm" title="Сохранение информации">
            <%--<p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 12px 20px 0;"></span>Применить сохранённые изменения?</p>--%>
        </div>
        <%--<div id="alertBlcok">
            <div id="saveSuccess" class="ui-widget d-none">
                <div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
                    <p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
                        <strong>Успех!</strong> Информация успешно сохранена.</p>
                </div>
            </div>
            <div id="saveError" class="ui-widget d-none">
                <div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
                    <p><span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span>
                        <strong>Ошибка!</strong> Информация не сохранена!</p>
                </div>
            </div>
        </div>--%>
		<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
		<%--jQuery UI--%>
        <script type="text/javascript" src="resources/js/jquery-ui.min.js"></script>
        <%--<script type="text/javascript" src="resources/js/interface.js"></script>--%>
        <%--Добавление красивой полы прокрутки--%>
        <script type="text/javascript" src="resources/js/jquery.mCustomScrollbar.concat.min.js"></script>
        <%--Функции работы с картой--%>
        <script type="text/javascript" src='resources/js/functions.js'></script>
		<script>
            $(function() {
                // Включение карты и меню снизу
                /*$('#btnNext').on('click', function(e) {
                    e.preventDefault();
                    $('#back').fadeOut(4000).remove();
                });*/
                /*$('#map').on('click', function() {
                    $('#bottomBlock').css({"z-index":"10", "display":"block"});
                });*/
                // Иконки как MAC OS
                $('.icon').hover(function() {
                        $('img', this).stop().animate({
                            'width':'80px',
                            'height':'80px',
                            'margin-top':'-30px',
                            'margin-right':'-15px',
                            'margin-left':'-15px'}, 200);
                        $(this).next('img').stop().animate({
                            'width':'80px',
                            'height':'80px',
                            'margin-top':'50px',
                            'margin-left':'-15'}, 200);
                    },
                    function() {
                        $('img', this).stop().animate({
                            'width':'50px',
                            'height':'50px',
                            'margin-top':'0px',
                            'margin-right':'0px',
                            'margin-left':'0px'}, 200);
                        $(this).next('img').stop().animate({
                            'width':'50px',
                            'height':'50px',
                            'margin-top':'40px',
                            'margin-left':'0px'}, 200);
                    });
                $('.block').click(function() {
                    $('img', this).stop().animate({
                            'height':'30px',
                            'margin-top':'20px'}, 100,
                        function() {
                            $(this).animate({
                                'height':'80px',
                                'margin-top':'-30px'}, 200)
                        });
                    $(this).next('img').stop().animate({
                            'height':'30px'}, 100,
                        function() {
                            $(this).animate({'height':'80px'}, 200)
                        });
                });
                // Массив путей всех стандартных изображений верхнего меню
                /*var array_img = [];
                $('.block1').each(function() {
                    var index = $(this).attr('data-table');
                    var element = $('img', this).attr('src');
                    array_img[index] = element;
                });
                console.log(array_img[9]);*/
                // Блоки верх при наведении
                /*$('.block1').hover(function() {
                    var linc = $(this).attr("data-table");
                    $('.blockUp[data-block ='+linc+']').css({"z-index":"10", "display":"block"});
                }, function() {
                    $('.blockUp').css("z-index","0");
                });
                $('.block1').mouseenter(function() {
                    var linc = $(this).attr("data-table");
                    $('.blockUp[data-block ='+linc+']').css({"z-index":"10", "display":"block"});
                }).mouseleave(function() {
                    $('.blockUp').css("z-index","0");
                });*/
                $('.block').hover(function() {
                    var linc = $(this).attr("data-bottom");
                    $('.blockIn[data-block ='+linc+']').css({"z-index":"10", "display":"block"});
                }, function() {
                    $('.blockIn').css("z-index","0");
                });
                // Верхний блок по клику
                $('.block1').click(function() {
                    // Убираем активные классы у всех изображений
                    $('.block1 img').removeClass('imgUp').removeClass('imgUp1');
                    // Возвращаем стандартные изображения
                    $('.block1').each(function(i) {
                        $('.block1[data-table ='+i+'] img').attr('src', 'resources/img/img'+i+'.png');
                        $('.block1[data-table ='+i+'] .ref').attr('src', 'resources/img/img'+i+'_1.png');
                    });
                    // Атрибут блока
                    var linc = $(this).attr("data-table");
                    linc = parseInt(linc);
                    // Подсчитываем клики по блоку
                    var counter = $(this).attr('counter');
                    var newCounter = parseInt(counter)+1;
                    if(newCounter == 1) {
                        $(this).attr('counter', newCounter);
                        // Открываем блок кнопок плюса и минуса слева
                        $('.blockLeft img').removeClass('d-none');
                        // Открываем большое изображение сверху и снизу. Меняем его путь на активное фото
                        $('img', this).attr('src','resources/img/img'+linc+'_active.png').addClass('imgUp');
                        $('.ref', this).attr('src','resources/img/img'+linc+'_1_active.png').addClass('imgUp1');
                        // Убираем подсветку всех элементов меню
                        $('.blockUp button').removeClass('active');
                        // Подсвечиваем все элементы конкретного блока
                        /*$('.blockUp[data-block ='+linc+'] button').addClass('active');*/
                        $('.blockUp[data-block ='+linc+'] .allProblems').addClass('active');
                        // Добавляем кнопку корректировки
                        $('#btnCorrect').removeClass('d-none');
                        // Открываем правый блок
                        $('#rightBlock').removeClass('d-none');
                        $('.item4 .ref1').addClass('imgUp');
                        $('.item4 .ref').addClass('imgUp1');
                    } else if(newCounter == 2) {
                        $(this).attr('counter', 0);
                        // Прячем блок кнопок плюса и минуса слева
                        $('.blockLeft img').addClass('d-none');
                        // Прячем активное большое изображение сверху и снизу. Меняем его путь.
                        $('img', this).attr('src','resources/img/img'+linc+'.png').removeClass('imgUp');
                        $('.ref', this).attr('src','resources/img/img'+linc+'_1.png').removeClass('imgUp1');
                        // Убираем подсветку всех блоков выпадающего списка
                        $('.blockUp[data-block ='+linc+'] button').removeClass('active');
                        // Убираем кнопку корректировки
                        $('#btnCorrect').addClass('d-none');
                        // Закрываем правый блок
                        $('#rightBlock').addClass('d-none');
                        $('.item4 .ref1').removeClass('imgUp');
                        $('.item4 .ref').removeClass('imgUp1');
                    }
                });
                // Клики по элементам выпадающего списка верхнего меню
                $('.blockUp button').click(function() {
                    // Убираем подсветку всех элементов меню
                    $('.blockUp button').removeClass('active');
                    // Подсвечиваем коонкретный элемент
                    $(this).addClass('active');
                    // Получаем номер родительского блока
                    var link = $(this).parent('.blockUp').attr('data-block');
                    // Убираем активные классы у всех изображений
                    $('.block1 img').removeClass('imgUp').removeClass('imgUp1');
                    // Открываем большое изображение сверху и снизу. Меняем его путь на активное фото
                    $('.block1[data-table ='+link+'] img').attr('src','resources/img/img'+link+'_active.png').addClass('imgUp');
                    $('.block1[data-table ='+link+'] .ref').attr('src','resources/img/img'+link+'_1_active.png').addClass('imgUp1');
                    // Открываем блок кнопок плюса и минуса слева
                    $('.blockLeft img').removeClass('d-none');
                    // Добавляем кнопку корректировки
                    $('#btnCorrect').removeClass('d-none');
                    // Открываем и закрываем правый блок
                    $('#rightBlock').removeClass('d-none');
                    $('.item4 .ref1').addClass('imgUp');
                    $('.item4 .ref').addClass('imgUp1');
                });
                // Появление и исчезание боковой панели
                $('.blockRight').click(function() {
                    $('#rightBlock').toggleClass('d-none');
                    $('img', this).toggleClass('imgUp');
                    $('.item4 .ref').toggleClass('imgUp1');
                });
                // Управлнение размером контейнера
                $("#resizable").resizable({
                    containment: "#rightBlock",
                    maxHeight: 900
                }/*, function(){
                    $('#rightBlock').css('background-color','rgba(0, 0, 0, 1))'
                }*/);
                // Подстветка блоков при выделении
                $("#resizable button").click(function() {
                    var tabsTitle = $(this).html();
                    tabsTitle = "Объект: " + tabsTitle;
                    $("#tabsTitle").html(tabsTitle);
                    $("#resizable button").css({
                        "background" : "#000000",
                        "color" : "#ffffff"
                    });
                    $(this).css({
                        "background" : "#ffcc66",
                        "color" : "#000000"
                    });
                });
                // Табы в карточке объекта
                $("#tabs").tabs();
                // Полоса прокрутки для блока с табами
                $("#tabsBlock").mCustomScrollbar({
                    theme:"light-2"
                });
                // Всплывающие подсказки
                $(document).tooltip({
                    position: {
                        my: "center bottom-20",
                        at: "center top",
                        using: function( position, feedback ) {
                            $( this ).css( position );
                            $( "<div>" )
                                .addClass( "arrow" )
                                .addClass( feedback.vertical )
                                .addClass( feedback.horizontal )
                                .appendTo( this );
                        }
                    }
                });
                // Сохранение информации по объекту
                $(document).on('click','#btnSave', function() {
                    $('#back').removeClass('d-none').attr('style','display: block;');
                    $("#dialog-confirm").dialog({
                        resizable: false,
                        height: "auto",
                        width: 400,
                        modal: true,
                        buttons: {
                            "Сохранить": function() {
                                $(this).dialog("close");
                                var serverStack = JSON.stringify(createJSON());
                                var serverAjax = $.ajax({
                                    type: "POST",
                                    url: 'rest/profile/geoObjects',
                                    data: serverStack,
                                    contentType: 'application/json; charset=utf-8'
                                });
                                console.log(serverStack);
                                serverAjax.done(function() {
                                    alert("Сохранено!");
                                });
                                serverAjax.fail(function() {
                                    alert("Ошибка!");
                                });
                                $('#back').fadeOut(1000).addClass('d-none');
                            },
                            "Отмена": function() {
                                $(this).dialog("close");
                                $('#back').fadeOut(1000).addClass('d-none');
                            },
                        }
                    });
                    $('.ui-icon-closethick').click(function() {
                        $('#back').fadeOut(1000).addClass('d-none');
                    });
                });
                // Сброс всех полей объекта
                $(document).on('click','#btnReset', function() {
                    $('#back').removeClass('d-none').attr('style','display: block;');
                    $("#dialog-confirm").dialog({
                        resizable: false,
                        height: "auto",
                        width: 400,
                        modal: true,
                        title: "Удаление информации",
                        buttons: {
                            "Очистить данные": function() {
                                var objectId = $('#dataId').val();
                                $('#tabs div').remove();
                                $('#resizable button').remove();
                                getObjectInfoRight('rest/profile/geoObjects/get/'+objectId);
                                $(this).dialog("close");
                                $('#back').fadeOut(1000).addClass('d-none');
                            },
                            "Отмена": function() {
                                $(this).dialog("close");
                                $('#back').fadeOut(1000).addClass('d-none');
                            },
                        }
                    });
                    $('.ui-icon-closethick').click(function() {
                        $('#back').fadeOut(1000).addClass('d-none');
                    });
                });
                $(document).on('click','#dropDown p', function() {
                    $('#back').removeClass('d-none').attr('style','display: block;');
                    $("#dialog-confirm").dialog({
                        resizable: false,
                        height: "auto",
                        width: 400,
                        modal: true,
                        title: "Исключить объект из списка проблем?",
                        buttons: {
                            "Да": function() {
                                /*var objectId = $('#dataId').val();
                                $('#tabs div').remove();
                                $('#resizable button').remove();
                                getObjectInfoRight('rest/profile/geoObjects/get/'+objectId);*/
                                $(this).dialog("close");
                                $('#back').fadeOut(1000).addClass('d-none');
                            },
                            "Отмена": function() {
                                $(this).dialog("close");
                                $('#back').fadeOut(1000).addClass('d-none');
                            },
                        }
                    });
                    $('.ui-icon-closethick').click(function() {
                        $('#back').fadeOut(1000).addClass('d-none');
                    });
                });
                // Корректировка полей
                $(document).on('click','#btnCorrect', function() {
                    var objectId = $('#dataId').val();
                    var problemId = $('.problemsValue.active').attr('val');
                    console.log(problemId);
                    $('#tabs div').remove();
                    $('#resizable button').remove();
                    getObjectInfoRight('rest/profile/geoObjects/getAlgorithmProposals/'+objectId+'?problemType='+problemId,problemId);
                    getObjectInfoBottom('rest/profile/geoObjects/getAlgorithmProposals/'+objectId+'?problemType='+problemId);
                    /*$('#back').removeClass('d-none').attr('style','display: block;');
                    $("#dialog-confirm").dialog({
                        resizable: false,
                        height: "auto",
                        width: 400,
                        modal: true,
                        title: "Получение информации",
                        buttons: {
                            "Получить данные": function() {
                                var objectId = $('#dataId').val();
                                var problemId = $('.problemsValue.active').attr('val');
                                //console.log(problemId);
                                $('#tabs div').remove();
                                $('#resizable button').remove();
                                getObjectInfoRight('rest/profile/geoObjects/getAlgorithmProposals/'+objectId+'?problemType='+problemId,problemId);
                                getObjectInfoBottom('rest/profile/geoObjects/getAlgorithmProposals/'+objectId+'?problemType='+problemId);
                                $(this).dialog("close");
                                $('#back').fadeOut(1000).addClass('d-none');
                            },
                            "Отмена": function() {
                                $(this).dialog("close");
                                $('#back').fadeOut(1000).addClass('d-none');
                            },
                        }
                    });
                    $('.ui-icon-closethick').click(function() {
                        $('#back').fadeOut(1000).addClass('d-none');
                    });*/
                });
                //var serverStack = JSON.stringify(createJSON());
                //console.log(serverStack);
                // Модальное окно
                /*$("#dialog").dialog({
                    autoOpen: false,
                    show: {effect: "fade"},
                    hide: {effect: "fade"}
                });
                $("#orbs li").on("click", function() {
                    $("#dialog").dialog("open");
                });
                $("#dialog").on('click', function(){
                    $("#dialog").dialog("close");
                });*/

            });
        </script>
        <script>
            // Вывод карты
            mapboxgl.accessToken = 'pk.eyJ1IjoibWFraHJvdnNzIiwiYSI6ImNqengxZm0yaDBtc2wzbXBrbDl5Z205ZzQifQ.9_P1iMCPMfkhCWgLzreoOQ';
            var map = new mapboxgl.Map({
                container: 'map',
                style: 'mapbox://styles/makhrovss/ck0dtd3jh130n1cn5c1wkad7w',
                zoom: 17,
                center: [37.86702556426411, 55.817544226556805]
            });
            map.addControl(new Language({language: 'ru'}));
            var markers = [];
            map.addControl(new MapboxGeocoder({
                accessToken: mapboxgl.accessToken,
                mapboxgl: mapboxgl
            }));

            // Удалить все маркеры
            function removeAllMarkers() {
                markers.forEach(function (m) {
                    m.remove();
                })
            }

            // Поставить маркеры по longitude, latitude
            function addMarker(longitude, latitude, signle) {
                markers.push(new mapboxgl.Marker()
                    .setLngLat([longitude, latitude])
                    .addTo(map));
                // Убираем все блоки внутри элемента если это для одного объекта
                if(signle && signle == 1) {
                    $('#bottomMenuBlock .blockIn').remove();
                    $('#resizable button').remove();
                }
                // Открываем блок кнопок
                $('#saveBlock').removeClass('d-none');
                // Открываем блок с редактированием объекта
                $('#tabsBlock').removeClass('d-none');
                // Меняем высоту блока с карточками
                $('#resizable').css('height', '340px');
                // Удаляем активные классы у блоков с табами
                $('#tabs ul li').removeClass('ui-state-active ui-tabs-active ui-state-focus ui-state-hover').attr({'aria-selected':false, 'aria-expanded':false});
                $('#tabs ul li:first').addClass('ui-state-active ui-tabs-active ui-state-focus ui-state-hover').attr({'aria-selected':true, 'aria-expanded':true});
                $('#tabs input').removeClass('active');
                $('#tabs div').remove();
                // Получаем данные объекта по координатам для вывода данных в меню снизу
                getObjectInfoBottom('rest/profile/geoObjects/getByCoordinates?longitude='+longitude+'&latitude='+latitude);
                // Получаем данные объекта по координатам для вывода данных в блоке справа
                getObjectInfoRight('rest/profile/geoObjects/getByCoordinates?longitude='+longitude+'&latitude='+latitude);
            }

            // Функция, которая отрабатывает при первичной загрузке карты
            map.on('load', function() {
                changeLayer();
                // Подгружаем нижнее и верхнее меню
                $('#topBlock').css({"z-index":"10", "display":"block"});
                $('#bottomBlock').css({"z-index":"10", "display":"block"});
            });

            // Поставить много маркеров по проблеме
            var testMarker = objectArray('rest/profile/geoObjects/getAllHasProblem?problemType=addressIssues');
            console.log(testMarker);


            // По клику поставить маркер, предварительно удалив все другие + запись в левом верх углу координат
            map.on('click', '3d-buildings', function(e) {
                removeAllMarkers();
                addMarker(e.lngLat.lng, e.lngLat.lat, 1);
                $('#longitude').text("Longitude: " + e.lngLat.lng);
                $('#latitude').text("Latitude: " + e.lngLat.lat);
                //var bbox = [[e.point.x - 30, e.point.y - 30], [e.point.x + 30, e.point.y + 30]];
                //var features = map.queryRenderedFeatures(bbox, { layers: ['3d-buildings'] });
                //highlightBuildingsByFeatures(e.features);
                //highlightBuildingsByFeatures(getFeaturesFromIds(([51, 99])));
                //alert(getIdsFromFeatures(e.features));
            });

            // Не использовать
            /*function highlightBuildingsByFeatures(features) {
                map.getSource('currentBuildings').setData({
                    "type": "FeatureCollection",
                    "features": features
                });
            }*/


            // Функция смены вида 3д - 2д
            var ThreeD = false;
            function changeLayer() {
                var layers = map.getStyle().layers;
                var labelLayerId;
                for (var i = 0; i < layers.length; i++) {
                    if (layers[i].type === 'symbol' && layers[i].layout['text-field']) {
                        labelLayerId = layers[i].id;
                        break;
                    }
                }

                if (map.getLayer('highlight') != null) {
                    map.removeLayer('highlight');
                }
                if (map.getSource('currentBuildings') != null) {
                    map.removeSource('currentBuildings');
                }
                if (map.getLayer('3d-buildings') != null) {
                    map.removeLayer('3d-buildings');
                }

                ThreeD = !ThreeD;
                if (ThreeD) {
                    map.addLayer({
                        'id': '3d-buildings',
                        'source': 'composite',
                        'source-layer': 'building',
                        'filter': ['==', 'extrude', 'true'],
                        'type': 'fill-extrusion',
                        'minzoom': 15,
                        'paint': {
                            'fill-extrusion-color': '#aaa',
                            // use an 'interpolate' expression to add a smooth transition effect to the
                            // buildings as the user zooms in
                            'fill-extrusion-height': [
                                "interpolate", ["linear"], ["zoom"],
                                15, 0,
                                15.05, ["get", "height"]
                            ],
                            'fill-extrusion-base': [
                                "interpolate", ["linear"], ["zoom"],
                                15, 0,
                                15.05, ["get", "min_height"]
                            ],
                            'fill-extrusion-opacity': .6
                        }
                    }, labelLayerId);
                } else {
                    map.addLayer({
                        'id': '3d-buildings',
                        'source': 'composite',
                        'source-layer': 'building',
                        'type': 'fill',
                        'minzoom': 15,
                        'paint': {
                            'fill-color': '#aaa',
                            'fill-outline-color': '#CBC9C7'
                        }
                    }, labelLayerId);
                }

                map.addSource('currentBuildings', {
                    type: 'geojson',
                    data: {
                        "type": "FeatureCollection",
                        "features": []
                    }
                });
                map.addLayer({
                    "id": "highlight",
                    "source": "currentBuildings",
                    'type': 'fill-extrusion',
                    'minzoom': 15,
                    'paint': {
                        'fill-extrusion-color': '#f00',
                        // use an 'interpolate' expression to add a smooth transition effect to the
                        // buildings as the user zooms in
                        'fill-extrusion-height': [
                            "interpolate", ["linear"], ["zoom"],
                            15, 0,
                            15.05, ["get", "height"]
                        ],
                        'fill-extrusion-base': [
                            "interpolate", ["linear"], ["zoom"],
                            15, 0,
                            15.05, ["get", "min_height"]
                        ],
                        'fill-extrusion-opacity': .6
                    }

                }, labelLayerId);
            }
        </script>
    </body>
</html>