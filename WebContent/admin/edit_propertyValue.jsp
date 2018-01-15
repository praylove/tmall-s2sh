<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../include/admin/adminheader.jsp" %>
<%@ include file="../include/admin/adminNavigator.jsp" %>

<title>单品属性管理</title>

<div>
	<ul class="m-admin-title">
		<li>
			<a href="category_list">所有分类 </a>
		</li>
		<li>/</li>
		<li>
			<a href="category_list">${p.category.name}</a>
		</li>
		<li>/</li>
		<li>
			<a href="product_list?cid=${p.category.id}">${p.name}</a>
		</li>
		<li>/</li>
		<li>产品属性管理</li>
	</ul>
</div>

<div class="g-mid m-propertyValue-edit">
	<form id="submit" action="propertyValue_update" method="post">
		<table border="0" class="propertyValue">
		  <s:iterator value="%{ptvs}" var="ptv" status="status">
				<s:if test="%{#status.odd}">
					<tr>
					   <td>${ptv.property.name}</td>
					   <td><input id="${ptv.property.id}" type="text" name="ptvs[${status.index}].value" placeholder="${ptv.value}" /></td>
				</s:if>
				<s:else>
					   <td>${ptv.property.name}</td>
					   <td><input id="${ptv.property.id}" type="text" name="ptvs[${status.index}].value" placeholder="${ptv.value}" /></td>
					</tr>
				</s:else>
            </s:iterator>
			<tr>
				<input id="cid" name="cid" type="hidden" value="${p.category.id}" />
				<input id="pid" name="pid" type="hidden" value="${p.id}" />
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-success">提交</button>
				</td>
			</tr>
		</table>
	</form>
</div>

<script type="text/javascript">
	$("#submit").submit(function() {
		var flag = true;
		$(".propertyValue input[type=text]").each(function() {
			var value = $(this).val();
			var re = /\s{1,}/g;
			if (value.length === 0){
				var s = $(this).prop("placeholder");
				if (s.length !== 0){
					$(this).prop("value", s);
					
				} else{
					alert("属性值不能为空");
					$(this).focus();
					flag = false;
					return false;
				}
			} else if(re.test(value)){
				alert("属性值不能含有空白");
				$(this).focus();
				flag = false;
				return false;
			}
		});
		
		return flag;
	})

</script>
<%@ include file="../include/admin/adminFooter.jsp" %>