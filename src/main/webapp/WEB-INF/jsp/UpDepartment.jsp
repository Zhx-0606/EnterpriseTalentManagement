<%--
  Created by IntelliJ IDEA.
  User: 周海鑫
  Date: 2020/5/9
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
    <h1>修改人才信息</h1>
    <form action="${pageContext.request.contextPath}/enter/UpdateDepartment" method="post">
        <input type="hidden" name="id" value="${enterprisetalents[0].id}" />
        <table border="1">
            <tr>
                <td><label>人才姓名</label></td>
                <td><input type="text" name="name" value="${enterprisetalents[0].name}" /></td>
            </tr>
            <tr>
                <td><label>工作年限</label></td>
                <td><input type="text" name="workingLife" value="${enterprisetalents[0].workingLife}" /></td>
            </tr>
            <tr>
                <td><label>所属部门</label></td>
                <td>
                    <select name="departmentId">
                        <c:forEach items="${departmentList}" var="dep">
                                <c:if test="${dep.id==enterprisetalents[0].departmentId}">
                                    <option value="${dep.id}" selected="selected">${dep.name}</option>
                                </c:if>
                                <c:if test="${dep.id!=enterprisetalents[0].departmentId}">
                                    <option value="${dep.id}">${dep.name}</option>
                                </c:if>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>个人简介</label></td>
                <td>
                    <textarea cols="20" rows="5" name="personalProfile">${enterprisetalents[0].personalProfile}</textarea>
                </td>
            </tr>
            <tr>
                <td><label>工作经历</label></td>
                <td>
                    <textarea cols="20" rows="5" name="workExperience">${enterprisetalents[0].workExperience}</textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="提交" />
                    <input type="button" value="返回" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
