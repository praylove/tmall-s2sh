<script>
	$(function() {
		$("ul.m-pagination li.disable a").click(function() {
			return false;
		});
	})
</script>
<nav class="g-mid" style="width: 410px; padding: 30px;">
	<ul class="m-pagination">
		<li <s:if test="%{!page.hasPrevious}"> class="disable" </s:if>><a
			href="?page.currentPage=${page.startPage}"> <span
				aria-hidden="true">&laquo;</span>
		</a></li>
		<li <s:if test="%{!page.hasPrevious}"> class="disable" </s:if>><a
			href="?page.currentPage=${page.currentPage - 1}" aria-label="end">
				<span aria-hidden="true">&lsaquo;</span>
		</a></li>
		<s:iterator begin="1" end="%{page.totalPage}" var="index">
			<s:if
				test="%{page.currentPage - #index >= -2 && page.currentPage - #index <= 2}">
				<li
					<s:if test="%{#index == page.currentPage}">class="disable"</s:if>>
					<a href="?page.currentPage=${index}"> ${index} </a>
				</li>
			</s:if>
		</s:iterator>

		<%-- <s:iterator begin="0" end="${page.totalPage - 1}" varStatus="status">
			<c:if test="${page.singleCount*status.count-page.begin <= 20 && page.singleCount*status.count-page.begin >= -10}">
				<li <c:if test="${status.index*page.singleCount==page.begin}">class="disable"</c:if>>
				<a href="?page.begin=${status.index*page.singleCount}${page.param}">
					${status.count}
				</a>
				</li>
			</c:if>
		</c:forEach> --%>
		<li <s:if test="%{!page.hasNext}"> class="disable" </s:if>><a
			href="?page.currentPage=${page.currentPage + 1}" aria-label="end">
				<span aria-hidden="true">&rsaquo;</span>
		</a></li>
		<li <s:if test="%{!page.hasNext}"> class="disable" </s:if>><a
			href="?page.currentPage=${page.totalPage}" aria-label="end"> <span
				aria-hidden="true">&raquo;</span>
		</a></li>
	</ul>
</nav>
