<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- view_carName.jsp -->

<form name="f" action="carName_update.do" method="post">
	<input type="hidden" name="num" value="${getCarName.num}">
	<table border="1" width="500" height="150">
	<caption>렌트카 차량 보기</caption>
	<tr>
		<th bgcolor="yellow">차량코드번호</th>
		<td>${getCarName.carCode}</td>
	</tr>
	<tr>
		<th bgcolor="yellow">렌트차명</th>
		<td>${getCarName.carName}</td>
	</tr>
	<tr>
		<th bgcolor="yellow">차종</th>
		<td>${getCarName.carType}</td>
	</tr>
	<tr>
		<th bgcolor="yellow">유종</th>
		<td>${getCarName.carFuel}</td>
	</tr>
	<tr>
		<th bgcolor="yellow">차량정보</th>
		<td><textarea name="carInfo" rows="7" cols="50">${getCarName.carInfo}</textarea></td>
	</tr>
	<tr>
		<th bgcolor="yellow">제조사</th>
		<td>${getCarName.carCompany}</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="수정">
			<input type="button" value="목록" onclick="location.href='carName_list.do'">
		</td>
	</tr>	
	</table>
</form>