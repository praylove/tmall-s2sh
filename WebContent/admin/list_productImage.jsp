<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>

<%@ include file="../include/admin/adminheader.jsp" %>
<%@ include file="../include/admin/adminNavigator.jsp" %>

<title>产品图片管理</title>

<div>
	<ul class="m-admin-title">
		<li>
			<a href="category_list">所有分类 </a>
		</li>
		<li>/</li>
		<li>
			<a href="category_list">${product.category.name}</a>
		</li>
		<li>/</li>
		<li>
			<a href="product_list?cid=${product.category.id}">${product.name}</a>
		</li>
		<li>/</li>
		<li>产品管理</li>
	</ul>
</div>

<div class="g-mid m-product-image">
	<div class="m-product-preview">
		<div class="panel panel-warning">
			<div class="panel-heading">新增产品<span style="color: #ff0036;">预览</span>图片</div>
			<div class="panel-body">
				<form class="submit1" method="post" action="productImage_add" enctype="multipart/form-data">
					<table border="0" class="addtable">
					<tr>
						<td>请选择本地图片 尺寸400X400 为佳</td>
						<td><input id="type" name="image.type" type="hidden" value="single"/></td>
					</tr>
					<tr>
						<td><input id="productpic1" type="file" accept="image/*" name="filepath" /></td>
						<td><input id="pid" name="pid" type="hidden" value="${product.id}"/></td>
					</tr>
					<tr>
						<td class="addButton">
							<button id="submitButton" type="submit" class="btn btn-success">提交</button>
						</td>
					</tr>
					</table>
				</form>
			</div>
		</div>
		<table border="1" class="m-list">
			<thead>
				<tr>
					<th>id</th>
					<th>产品预览图片缩略图</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="%{product.productSingleImages}" var="si">
					<tr>
						<td>${si.id}</td>
						<td><img width="50px" height="50px" src="../image/product/${product.id}/${si.id}.jpg" alt="" /></td>
						<td>
							<a class="delete" href="productImage_delete?image.id=${si.id}&pid=${product.id}"><span class="glyphicon glyphicon-trash"></span></a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	<div class="m-product-details">
		<div class="panel panel-warning">
			<div class="panel-heading">新增产品<span style="color: #ff0036;">详情</span>图片</div>
			<div class="panel-body">
				<form class="submit2" method="post" action="productImage_add" enctype="multipart/form-data">
					<table border="0" class="addtable">
					<tr>
						<td>请选择本地图片 宽度800 为佳</td>
						<td><input id="type" name="image.type" type="hidden" value="details"/></td>
					</tr>
					<tr>
						<td><input id="productpic2" type="file" accept="image/*" name="filepath" /></td>
						<td><input id="pid" name="pid" type="hidden" value="${product.id}"/></td>
					</tr>
					<tr>
						<td class="addButton">
							<button id="submitButton" type="submit" class="btn btn-success">提交</button>
						</td>
					</tr>
					</table>
				</form>
			</div>
		</div>
		<table border="1" class="m-list">
			<thead>
				<tr>
					<th>id</th>
					<th>产品详情图片缩略图</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="%{product.productDetailsImages}" var="di">
					<tr>
						<td>${di.id}</td>
						<td><img width="50px" height="50px" src="../image/product/${product.id}/${di.id}.jpg" alt="" /></td>
						<td>
							<a class="delete" href="productImage_delete?image.id=${di.id}&pid=${product.id}"><span class="glyphicon glyphicon-trash"></span></a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</div>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel">删除属性</h4>
			</div>
			<div class="modal-body">
				<p>删除操作不可逆转</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消删除</button>
				<button type="button" class="btn btn-primary">
        	<a id="deleteConfirm" href="#5" style="color: white;">继续删除</a>
        </button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(".delete").click(function() {
		var link = $(this).prop("href");
		$("#deleteConfirm").prop("href", link);
		$("#myModal").modal("show");
		return false;
	})
	$(".submit1").submit(function() {
		if(checkEmpty("productpic1", "产品图片"))
			return false;
		return true;
	})
	$(".submit2").submit(function() {
		if(checkEmpty("productpic2", "产品图片"))
			return false;
		return true;
	})
</script>
<%@ include file="../include/admin/adminFooter.jsp" %>