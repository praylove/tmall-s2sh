<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/admin/adminheader.jsp"%>
<%@ include file="../include/admin/adminNavigator.jsp"%>

<title>订单管理</title>

<div class="g-mid m-order">
	<table border="1" class="m-list">
		<thead>
			<tr>
				<th>ID</th>
				<th>状态</th>
				<th>金额</th>
				<th>商品数量</th>
				<th>买家名称</th>
				<th>创建时间</th>
				<th>支付时间</th>
				<th>发货时间</th>
				<th>确认收货时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${page.params}" var="o">
				<tr>
					<td>${o.id}</td>
					<td>${o.status}</td>
					<td>${o.total}</td>
					<td>${o.totalNumber}</td>
					<td>${o.user.name}</td>
					<td><fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm:ss"
							value="${o.createDate}" /></td>
					<td><fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm:ss"
							value="${o.payDate}" /></td>
					<td><fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm:ss"
							value="${o.deliveryDate}" /></td>
					<td><fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm:ss"
							value="${o.confirmDate}" /></td>
					<td class="operaty">
						<button class="btn btn-info getDetails">
							<a href="#1">查看详情</a>
						</button> <c:if test="${o.status == 'undelivery'}">
							<button class="btn btn-info">
								<a href="order_delivery?id=${o.id}&operaty=delivery">发货</a>
							</button>
						</c:if>
					</td>
				</tr>
				<tr >
					<td colspan="10" class="order-details">
						<table border="0" class="m-list">
							<thead>
								<tr>
									<th>ID</th>
									<th>商品名称</th>
									<th>商品数量</th>
									<th>原价格</th>
									<th>促销价格</th>
									<th>商品总价</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${o.orderItems}" var="oi">
									<tr>
										<td>${oi.id}</td>
										<td><img
											src="../image/product/${oi.product.id}/${oi.product.firstProductImage.id}.jpg"
											width="80px" height="80px" /> ${oi.product.name}</td>
										<td>${oi.number}</td>
										<td>￥<fmt:formatNumber value="${oi.product.orignalPrice}"
												pattern="#,#00.00#" /></td>
										<td>￥<fmt:formatNumber value="${oi.product.promotePrice}"
												pattern="#,#00.00#" /></td>
										<td>￥<fmt:formatNumber
												value="${oi.product.promotePrice * oi.number}"
												pattern="#,#00.00#" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


<div class="g-mid">
	<%@ include file="../include/admin/adminPage.jsp"%>
</div>



<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
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
	$(function(){
		$(".delete").click(function() {
	        var link = $(this).prop("href");
	        $("#deleteConfirm").prop("href", link);
	        $("#myModal").modal("show");
	        return false;
	    })
	    $(".getDetails").click(function(){
	        $(".order-details").hide();
	        $(this).parent().parent().next().find(".order-details").show();
	        return false;
	    })
	})
</script>
<%@ include file="../include/admin/adminFooter.jsp"%>