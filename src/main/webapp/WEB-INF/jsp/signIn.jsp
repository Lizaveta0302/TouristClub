<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="ui"%>

<ui:html>
<ui:header/>

    <div class="container">
        <h2 style="text-align: center;margin-top: 13px;" >Вход</h2>
        <hr style="width: 30%;">
        <div style="margin: auto;text-align: center; width: 40%;">
            <form>
                <div class="form-group">
                    <label for="exampleInputEmail1">Логин</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Введите логин">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Пароль</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Введите пароль">
                    <small id="passwordHelp" class="form-text text-muted" style="font-size: small;">Не распространяйте никому ваш пароль</small>
                </div>
                <button type="submit" class="btn btn-primary">Отправить</button>
            </form>
        </div>
    </div>

<ui:footer/>
</ui:html>