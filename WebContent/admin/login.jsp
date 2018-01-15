<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/admin/adminheader.jsp"%>
<div class="g-mid">

	<div class="panel panel-warning m-category-edit">
		<div class="panel-heading">登录</div>
		<div class="panel-body">
			<form id="submit" method="post" action=""
				enctype="multipart/form-data">
				<table border="0" class="addtable">
					<tr>
						<td>账户名：</td>
						<td><input id="name" name="category.name" type="text" /></td>
					</tr>
					<tr>
						<td>密码</td>
						<td><input id="password" type="password" name="password" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<button type="submit" class="btn btn-success">提交</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>
</body>
</html>