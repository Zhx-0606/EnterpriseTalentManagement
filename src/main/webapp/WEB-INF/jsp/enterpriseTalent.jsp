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
    <title>人才信息列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/enterpriseTalent.css">
</head>
<body>
    <form action="" method="post">
        <label>部门名称</label>
        <select name="departmentId">
            <c:forEach var="departmentList" items="${departmentList}">
                <option value="${departmentList.id}">${departmentList.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="查询" />
    </form>
    <a href="${pageContext.request.contextPath}/enter/department"><input type="button" value="新增人员" /></a>
    <table border="1px">
        <tr>
            <td colspan="6" class="cols">人才信息列表</td>
        </tr>
        <tr>
            <th>人才编号</th>
            <th>人才姓名</th>
            <th>工作年限</th>
            <th>所属部门</th>
            <th>毕业学院</th>
            <th>操作</th>
        </tr>
       <c:forEach items="${pageInfo.list}" var="entlist">
           <tr>
               <td>${entlist.id}</td>
               <td>${entlist.name}</td>
               <td>${entlist.workingLife}</td>
               <td>${entlist.departmentName}</td>
               <td>${entlist.graduateSchool}</td>
               <td>
                   <a href="${pageContext.request.contextPath}/enter/UpDepartment/${entlist.id}">修改</a>
                   <a href="javascript:void(0);" onclick="Del(${entlist.id})">删除</a>
               </td>
           </tr>
       </c:forEach>
    </table>
    <div>
        <a href="${pageContext.request.contextPath}/enter/enterpriseTalent?pageIndex=${1}">首页</a>
        <a href="${pageContext.request.contextPath}/enter/enterpriseTalent?pageIndex=${pageInfo.prePage}">上一页</a>
        <a href="${pageContext.request.contextPath}/enter/enterpriseTalent?pageIndex=${pageInfo.nextPage}">下一页</a>
        <a href="${pageContext.request.contextPath}/enter/enterpriseTalent?pageIndex=${pageInfo.pages}">末页</a>
        <span>第${pageInfo.pageNum}页/共${pageInfo.pages}页</span>
    </div>
</body>
</html>
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script>
    function Del(id) {
        $.ajax({
           url:"${pageContext.request.contextPath}/enter/DelEnterprisetalent",
           data:{id:id},
           dataType:"text",
           type:"POST",
           success:function (data) {
               location.reload();
           } ,
            error:function (data) {
                alert("操作失败")
            }
        });
    }
</script>
