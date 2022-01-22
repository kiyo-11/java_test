<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>マイページ</title>
		<link href="style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
	 <div id="main">
	<h1>確認画面</h1>
		 <form action="confirm" method="post">

                    <label for="email">Email</label>
                    <input type="text" id="email=" name="email" value ="${customer.email}">
                    <label for="password">Passowrd</label>
                    <input type="text" id="password" name="password" value ="${customer.password}">
                    <label for="name">氏名</label>
                    <input type="text" id="name=" name="name" value="${customer.name}">
                    <label for="gender">性別</label>
                    <c:if test="${customer.gender == 0}">
                        <input type="radio" name="gender" value="0" checked=checked>男
                        <input type="radio" name="gender" value="1">女
                    </c:if>
                    <c:if test="${customer.gender == 1}">
                        <input type="radio" name="gender" value="0">男
                        <input type="radio" name="gender" value="1" checked=checked>女
                    </c:if>
                    <label for="blood">血液型</label>
                    <select name="blood">
                        <option value="${customer.blood}">${customer.blood}型</option>
                        <option value="A">A型</option>
                        <option value="B">B型</option>
                        <option value="O">O型</option>
                        <option value="AB">AB型</option>
                    </select>
                    <label for="old">年齢</label>
					<input type="text" id="old" name="old" value ="${customer.old}">
                    <label for="memo">メモ</label>
                    <textarea name="memo" rows="4" cols="41" maxlength="100">${customer.memo}</textarea>
                    <input type="hidden" name="id" value="${customer.id}">
                    <input type="submit" value="登録">

            </form>

               		 <form action="insert.jsp" method="post">

                    <input type="hidden" name="email" value="${customer.email}">
                    <input type="hidden" name="password" value="${customer.password}">
                    <input type="hidden" name="name" value="${customer.name}">
                    <input type="hidden" name="gender" value="${customer.gender}">
                    <input type="hidden" name="blood" value="${customer.blood}">
                    <input type="hidden" name="old" value="${customer.old}">
                    <input type="hidden" name="memo" value="${customer.memo}">
                    <input type="submit" value="修正">

            </form>
            </div>
	</body>
</html>