<%@ page import="member.MemberDTO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-10
  Time: PM 1:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- memberAll.jsp -->
<%@ include file="top.jsp"%>
<%
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="mbdao" class="member.MemberDAO"/>
<jsp:setProperty name="mbdao" property="*"/>
<div align="center">
    <hr color="green" width="300">
    <h2>검 색 회 원 보 기</h2>
    <hr color="green" width="300">
    <table border="1" width="100%">
        <tr bgcolor="yellow">
            <th>번호</th>
            <th width="20%">이름</th>
            <th>아이디</th>
            <th>이메일</th>
            <th width="20%">전화번호</th>
            <th>가입일</th>
            <th>수정|삭제</th>
        </tr>
        <%		//여기에 DB에서 자료를 가져와 출력하는 프로그램 만들어야 한다
            MemberDTO dto = mbdao.selectOneMember();
            if (dto==null){%>
        <tr>
            <td colspan="7">등록된 회원이 없습니다.</td>
        </tr>
        <% 		}else {
            %>
        <tr>
            <td><%=dto.getNo()%></td>
            <td><%=dto.getName()%></td>
            <td><%=dto.getId()%></td>
            <td><%=dto.getEmail()%></td>
            <td><%=dto.getHp1()%>-<%=dto.getHp2()%>-<%=dto.getHp3()%></td>
            <td><%=dto.getJoindate()%></td>
            <td><a href="member_update.jsp?no=<%=dto.getNo()%>">수정</a> | <a href="member_delete.jsp?no=<%=dto.getNo()%>">삭제</a></td>

        </tr>
        <%
            }
        %>

    </table>
</div>
<%@ include file="bottom.jsp"%>
