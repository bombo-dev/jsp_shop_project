<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="mall_top.jsp"%>
<script type="text/javascript">
	function goCart(){
		document.f.action="cartAdd.mall";
		document.f.submit();
	}
	function goOrder(){
		document.f.action="order.mall?mode=buynow";
		document.f.submit();
	}
</script>
<table width="99%" border="1">
	<tr class="m1">
		<td colspan="2" align="center">
			<b>[${getProd.pname}] ��ǰ ����</b>
		</td>
	</tr>
	<tr>
		<td align="center" class="m3">
			<img src="prodImage/${getProd.pimage}" width="200" height="200" border="0">
		</td>
		<td class="m3">
			<form name="f" method="post">
				��ǰ��ȣ : ${getProd.pnum}<br>
				��ǰ�̸� : ${getProd.pname}<br>
				��ǰ���� : <font color="red">${getProd.price}</font>��<br>
				��ǰ����Ʈ : <font color="red">[${getProd.point}]</font>point<br>
				��ǰ���� : <input type="text" name="qty" size="3" value="1">��<br><br>
				<input type="hidden" name="pnum" value="${getProd.pnum}">
				<input type="hidden" name="select" value="${param.select}">
				<a href="javascript:goCart()">��ٱ���</a>
				<a href="javascript:goOrder()">��ñ���</a>
			</form>	
		</td>
	</tr>	
	<tr>
		<td colspan="2" align="left">
			<b>��ǰ �� ����</b><br>
			${getProd.pcontents}
		</td>
	</tr>		
</table>
<%@ include file="mall_bottom.jsp"%>








