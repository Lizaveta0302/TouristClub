<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html>
<ui:header />
<div class="container">

    <div style="text-align: right; margin-top: 10px;">
    <a href="signIn" style="color: #000000">Войти</a>
    <a href="#" style="color: #000000; padding-left: 10px; ">Зарегистрироваться</a>
    </div>

    <h1 class="title">Туристический клуб "Майорка"</h1>

    <div class="carousel">
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="images/slide3.jpg" class="d-block w-100">
                </div>
                <div class="carousel-item">
                    <img src="images/slide2.jpg" class="d-block w-100">
                </div>
                <div class="carousel-item">
                    <img src="images/slide1.jpg" class="d-block w-100">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev"> <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="sr-only">Previous</span>
            </a> <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next"> <span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="sr-only">Next</span>
            </a>
        </div>
    </div>

    <div class="jumbotron">
        <p class="lead">Здесь каждый найдет занятие по душе. Познавательные походы, тренировки, только лучшие, высококвалифицированные тренеры!</p>
        <hr class="my-4">
        <p>Присоединяйся и стань частью нашей большой и дружной команды!</p>
        <p class="lead">
            <a class="btn btn-primary btn-lg" href="info" role="button">Узнать больше</a>
        </p>
    </div>

    <h2 style="text-align: center;" id="hikes" >Проводимые походы</h2>
    <hr style="width: 30%;">
    <table id="tableHike" class="table table-hover table-active" >
        <thead>
            <tr>
                <th scope="col">Название</th>
                <th scope="col">Тип похода</th>
                <th scope="col">Дней</th>
                <th scope="col">Кол-во привалов</th>
                <th scope="col">Дата</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="type" items="${hikes}">
                <tr class="table-secondary">
                    <th scope="row">${type.hike.hike_name}</th>
                    <td>${type.unplannedHike.name} ${type.plannedHike.name}</td>
                    <td>${type.unplannedHike.route.number_of_days} ${type.plannedHike.plan.route.number_of_days} </td>
                    <td>${type.plannedHike.plan.number_of_parking}</td>
                    <td>${type.unplannedHike.route.data_start} ${type.plannedHike.plan.route.data_start}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <hr style="margin-bottom: 4%">
    <h2 style="text-align: center;" id="supervisors" >Руководители секций</h2>
    <hr style="width: 30%;margin-bottom: 2%">

    <div data-spy="scroll" data-target="#cards" data-offset="0" style="height:490px; width: 70%; margin:auto;
        overflow-x: hidden; overflow: auto; border: .2rem solid #f5f5f5; padding: 10px;">

        <div class="row">
        <!--div class="card-deck" id="cards"-->
            <c:forEach var="supervisor" items="${sup}">
            <div class="col-sm-6">
                <div id="cards" class="card bg-primary mb-3" style="max-width: 20rem;">
                    <div class="card-header text-white ">${supervisor.name}</div>
                    <div class="card-body" style="background-color: #FFFFF0;">
                        <h4 class="card-title">${supervisor.last_name} ${supervisor.name} ${supervisor.patronymic}</h4>
                        <p class="card-text">${supervisor.name} является несомненным профессионалом в своем деле. Его зарплата достигает ${supervisor.salary} руб.</p>
                    </div>
                    <div class="card-footer" style="background-color: #ffffff">
                        <a href="section">Секции</a>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>

    <hr style="margin-bottom: 7%">

</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/jszip-2.5.0/dt-1.10.20/af-2.3.4/b-1.6.0/b-flash-1.6.0/b-html5-1.6.0/b-print-1.6.0/datatables.min.css"/>
 
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/jszip-2.5.0/dt-1.10.20/af-2.3.4/b-1.6.0/b-flash-1.6.0/b-html5-1.6.0/b-print-1.6.0/datatables.min.js"></script>

<script src="javaScript/tableHike.js" type="text/javascript"></script>
<ui:footer />
</ui:html>