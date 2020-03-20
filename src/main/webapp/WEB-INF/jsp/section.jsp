<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html>
<ui:header/>

    <div class="container">
        <h2 style="text-align: center;" id="hikes" >Доступные секции</h2>
        <hr style="width: 30%;">
        <table id="tableHike" class="table table-hover table-active" style="width: 80%;margin: auto;">
            <thead>
            <tr>
                <th scope="col">Секция</th>
                <th scope="col">ФИО Инструктора</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="section" items="${sections}">
                <tr class="table-secondary">
                    <th scope="row">${section.section_name}</th>
                    <td>${section.supervisor.last_name} ${section.supervisor.name} ${section.supervisor.patronymic}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <hr>
    </div>
    </div>

<ui:footer/>
</ui:html>