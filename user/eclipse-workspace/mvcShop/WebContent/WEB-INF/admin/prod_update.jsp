<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="top.jsp" %>
<form name="f" action="prod_update_ok.mall" method="post" enctype="multipart/form-data">
	<input type="hidden" name="pnum" value="${getProd.pnum}" />
	<table border="0" class="outline" width="600">
		<caption>상품수정</caption>
		<tr>
			<th class="m2">카테고리</th>
			<td align="left">
				<input type="text" name="pcategory_fk" value="${getProd.pcategory_fk}" disabled>			
			</td>
		</tr>
		<tr>
			<th class="m2">상품번호</th>
			<td align="left">${getProd.pnum}</td>
		</tr>
		<tr>
			<th class="m2">상품명</th>
			<td align="left"><input type="text" name="pname" value="${getProd.pname}"></td>
		</tr>
		<tr>
			<th class="m2">제조회사</th>
			<td align="left"><input type="text" name="pcompany" value="${getProd.pcompany}"></td>
		</tr>
		<tr>
			<th class="m2">상품이미지</th>
			<td align="left">
				<img src="${upPath}/${getProd.pimage}" border="0" width="80" height="80">
				<input type="file" name="pimage">
				<input type="hidden" name="pimage2" value="${getProd.pimage}">
			</td>
		</tr>
		<tr>
			<th class="m2">상품수량</th>
			<td align="left"><input type="text" name="pqty" value="${getProd.pqty}"></td>
		</tr>
		<tr>
			<th class="m2">상품가격</th>
			<td align="left"><input type="text" name="price" value="${getProd.price}"></td>
		</tr>
		<tr>
			<th class="m2">상품스팩</th>
			<td align="left">
				<select name="pspec">
					<c:forTokens var="pspec" items="none,HIT,NEW,BEST" delims=",">
						<c:if test="${getProd.pspec == pspec}">
							<option value="${pspec}" selected>${pspec}</option>
						</c:if>	
						<c:if test="${getProd.pspec != pspec}">
							<option value="${pspec}">${pspec}</option>
						</c:if>
					</c:forTokens>
				</select> 
			</td>	
		</tr>
		<tr>
			<th class="m2">상품소개</th>
			<td align="left">
				<textarea name="pcontents" rows="5" cols="50">${getProd.pcontents}</textarea>
			</td>
		</tr>
		<tr>
			<th class="m2">상품포인트</th>
			<td align="left"><input type="text" name="point" value="${getProd.point}"></td>
		</tr>
		<tr>
			<td colspan="2" class="m1">
				<input type="submit" value="상품수정">
				<input type="reset" value="취소">
			</td>
		</tr>			
	</table>
</form>
<%@ include file="bottom.jsp" %>
