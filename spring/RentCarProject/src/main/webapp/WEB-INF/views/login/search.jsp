<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<link rel="stylesheet" type="text/css" href="resources/style.css">    
<script type="text/javascript">
	function check(mode){
		if (f.name.value==""){
			alert("�̸��� �Է��ϼ���!!")
			f.name.focus()
			return
		}
		if (f.ssn1.value==""){
			alert("�ֹι�ȣ ���ڸ��� �Է��ϼ���!!")
			f.ssn1.focus()
			return
		}
		if (f.ssn2.value==""){
			alert("�ֹι�ȣ ���ڸ��� �Է��ϼ���!!")
			f.ssn2.focus()
			return
		}
		if (mode=="pw" && f.id.value==""){
			alert("���̵� �Է��ϼ���!!")
			f.id.focus()
			return
		}
		document.f.submit()
	}
</script>
<div align="center">
	<hr color="green" width="300">
	<c:if test="${param.mode == 'id'}">
		<h2>�� �� �� ã ��</h2>
	</c:if>	
	<c:if test="${param.mode == 'pw'}">
		<h2>�� �� �� ȣ ã ��</h2>
	</c:if>
	<hr color="green" width="300">
	<form name="f" action="login_check.do" method="post">
		<table width="500" class="outline">
			<tr>
				<th>�̸�</th>
				<td><input type="text" name="name" class="box"></td>
			</tr>
			<tr>
				<th>�ֹι�ȣ</th>
				<td><input type="text" name="ssn1" class="box" maxlength="6"> -
						<input type="password" name="ssn2" class="box" maxlength="7"></td>
			</tr>
		<c:if test="${param.mode=='pw'}">			
			<tr>
				<th>���̵�</th>
				<td><input type="text" name="id" class="box"></td>
			</tr>
		</c:if>			
			<tr>
				<td colspan="2" align="center">
					<a href="javascript:check('${param.mode}')">[����]</a>
					<a href="javascript:self.close()">[���]</a>
				</td>
			</tr>	
		</table>
	</form>
</div>









