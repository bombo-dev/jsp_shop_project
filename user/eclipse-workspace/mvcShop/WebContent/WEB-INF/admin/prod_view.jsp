<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<%@ include file="top.jsp"%>
<form name="f" action="prod_list.mall" method="post">
	<table class="outline" width="75%">
	<caption>��ǰ�󼼺���</caption>
		<tr>
			<th width="15%" class="m2">ī�װ�</th>
			<td width="35%" align="center">${getProd.pcategory_fk}</td>
			<th width="15%" class="m2">��ǰ��ȣ</th>
			<td width="35%" align="center">${getProd.pnum}</td>
		</tr>
		<tr>
			<th width="15%" class="m2">��ǰ��</th>
			<td width="35%" align="center">${getProd.pname}</td>
			<th width="15%" class="m2">����ȸ��</th>
			<td width="35%" align="center">${getProd.pcompany}</td>
		</tr>
		<tr>
			<th width="15%" class="m2">��ǰ�̹���</th>
			<td width="35%" align="center" colspan="3">
				<img src="${upPath}/${getProd.pimage}" border="0" width="140" height="140">
			</td>
		</tr>
		<tr>
			<th width="15%" class="m2">��ǰ����</th>
			<td width="35%" align="center">${getProd.pqty}</td>
			<th width="15%" class="m2">��ǰ����</th>
			<td width="35%" align="center">${getProd.price}</td>
		</tr>
		<tr>
			<th width="15%" class="m2">��ǰ����</th>
			<td width="35%" align="center">${getProd.pspec}</td>
			<th width="15%" class="m2">��ǰ����Ʈ</th>
			<td width="35%" align="center">${getProd.point}</td>
		</tr>
		<tr>
			<th width="15%" class="m2">��ǰ�Ұ�</th>
			<td width="35%" align="center" colspan="3">
				<textarea name="pcontents" rows="5" cols="50" readOnly>${getProd.pcontents}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4" class="m1" align="center">
				<input type="submit" value="���ư���">
			</td>
		</tr>
	</table>
</form>	
<%@ include file="bottom.jsp"%>










