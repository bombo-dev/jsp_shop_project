<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
	<title>���θ�Ȩ</title>
</head>
<body>
	<table border="1" align="center" width="770">
		<tr height="50">
			<td colspan="2" align="center">
				<a href="index.mall">HOME</a> |
				<a href="adminShop.mall">������Ȩ</a> |
				<a href="displayShop.mall">���θ�Ȩ</a> |
				<a href="">��ٱ���</a> |
				<a href="">ȸ��Ұ�</a>
			</td>
		</tr>
		<tr height="400">
			<td width="20%" align="center" valign="top">
				tree/view
				<table width="99%" align="center" border="1">
				<c:forEach var="cdto" items="${listCate}">
					<tr>
						<td>
							<a href="cgProdList.mall?code=${cdto.code}">
								${cdto.cname}[${cdto.code}]
							</a>
						</td>
					</tr>		
				</c:forEach>				
				</table>
			</td>
			<form name="cg" method="post">
				<input type="hidden" name="code">
				<input type="hidden" name="cname">
			</form>
			<td align="center">
			