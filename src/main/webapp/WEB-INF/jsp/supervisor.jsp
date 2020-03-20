<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html>
<ui:header/>

    <div class="container">
        <h2 style="text-align: center;" id="hikes" >Руководители секций</h2>
        <hr style="width: 30%;">
        <table id="tableHike" class="table table-hover table-active" >
            <thead>
            <tr>
                <th scope="col">Имя</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Зарплата</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="supervisor" items="${sup}">
                <tr class="table-secondary">
                    <th scope="row">${supervisor.name}</th>
                    <td>${supervisor.last_name}</td>
                    <td>${supervisor.salary}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <hr>
    </div>
    </div>

<ui:footer/>
</ui:html>