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
			<h1>入力画面</h1>
			<form action="insert" method="post">

					<label for="email">Email</label>
					<input type="text" id="email" name="email" value ="${customer.email}">
					<label for="password">Passowrd</label>
					<input type="password" id="password" name="password" value ="${customer.password}">
					<label for="name">氏名</label>
					<input type="text" id="name" name="name" value="${customer.name}">
					<label for="gender">性別</label>
					<input type="radio" name="gender" value="0">男
					<input type="radio" name="gender" value="1">女
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
					<input type="submit" value="確認">

			</form>
		</div>
	</body>
</html>