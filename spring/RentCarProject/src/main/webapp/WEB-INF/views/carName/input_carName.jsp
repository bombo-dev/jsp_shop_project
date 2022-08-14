<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<form name="f" action="carName_input.do" method="post">
	<table border="1" width="500" height="150">
	<caption>렌트카 차량 등록</caption>
	<tr>
		<th bgcolor="yellow">차량코드번호</th>
		<td><input type="text" name="carCode"></td>
	</tr>
	<tr>
		<th bgcolor="yellow">렌트차명</th>
		<td><input type="text" name="carName"></td>
	</tr>
	<tr>
		<th bgcolor="yellow">차종</th>
		<td>
			<select name="carType">
				<option>경차</option>
				<option>소형</option>
				<option>중형</option>
				<option>대형</option>
				<option>SUV</option>
				<option>승합</option>
				<option>외제</option>
			</select>
		</td>
	</tr>
	<tr>
		<th bgcolor="yellow">유종</th>
		<td>
			<select name="carFuel">
				<option>휘발유</option>
				<option>경유</option>
				<option>LPG</option>
				<option>전기</option>
				<option>수소</option>
				<option>hibrid</option>
			</select>
		</td>
	</tr>
	<tr>
		<th bgcolor="yellow">차량정보</th>
		<td><textarea name="carInfo" rows="7" cols="50"></textarea></td>
	</tr>
	<tr>
		<th bgcolor="yellow">제조사</th>
		<td><input type="text" name="carCompany"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="등록">
			<input type="reset" value="취소">
		</td>
	</tr>	
	</table>
</form>