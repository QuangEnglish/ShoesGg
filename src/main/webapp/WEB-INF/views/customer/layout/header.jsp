<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="baongoaiheader">
	<div id="header">
		<div id="logo" onclick="ChuyenTrang ()">
			<img src="${base }/image/logoOff.png" alt="">
		</div>
		<div id="menu">
			<ul>
				<li><a href="${base }/trang-chu">TRANG CHỦ</a></li>
				<!-- href="/san-pham" -->
				<li class="menusanpham"><a target="_parent">SẢN PHẨM</a>
					<ul class="menucon1">
						<li class="menuao"><a>Sản phẩm mới nhất</a>
							<ul class="menucon2 menucap2">
								<c:forEach items="${danhMucSanPhamBac2 }" var="b2">
									<c:if
										test="${b2.danhMucSanPhamBac1.id == 10 and b2.status == 1}">
										<li><a
											href="${base }/san-pham-ao?tendm=${b2.tenDanhMuc }">${b2.tenDanhMuc }</a></li>
									</c:if>
								</c:forEach>
							</ul></li>
						<li class="menuquan"><a>Sản phẩm nổi bật</a>
							<ul class="menuquan2 menucap2">
								<c:forEach items="${danhMucSanPhamBac2 }" var="b3">
									<c:if
										test="${b3.danhMucSanPhamBac1.id == 11 and b3.status == 1}">
										<li><a
											href="${base }/san-pham-ao?tendm=${b3.tenDanhMuc }">${b3.tenDanhMuc }</a></li>
									</c:if>
								</c:forEach>
							</ul></li>
						<li class="menudobo"><a>Sản phẩm bán chạy</a>
							<ul class="menudobo2 menucap2">
								<c:forEach items="${danhMucSanPhamBac2 }" var="b4">
									<c:if
										test="${b4.danhMucSanPhamBac1.id == 12 and b4.status == 1 }">
										<li><a
											href="${base }/san-pham-ao?tendm=${b4.tenDanhMuc }">${b4.tenDanhMuc }</a></li>
									</c:if>
								</c:forEach>

							</ul></li>
					</ul></li>
				<%--                    <li class="menusanpham"><a href="">PHỤ KIỆN</a>--%>
				<%--                        <ul class="menucon1">--%>
				<%--                        	<c:forEach items="${danhMucPhuKien }" var="pk">--%>
				<%--                        		<c:if test="${pk.status == 1 }">--%>
				<%--                        			<li><a href="/danh-sach-phu-kien?tendmpk=${pk.tenDanhMuc }">${pk.tenDanhMuc }</a></li>--%>
				<%--                        		</c:if>--%>
				<%--                        	</c:forEach>--%>
				<%--                            <!-- <li><a href="/danh-sach-phu-kien?tendmpk=Giày">Giày</a></li>--%>
				<%--                            <li><a href="">Cặp da</a></li>--%>
				<%--                            <li><a href="">Ví nam</a></li>--%>
				<%--                            <li><a href="">Thắt lưng</a></li>--%>
				<%--                            <li><a href="">Cà vạt</a></li>--%>
				<%--                            <li><a href="">Vali</a></li> -->--%>
				<%--                        </ul>--%>
				<%--                    </li>--%>
				<li class="menusanpham"><a href="">BỘ SƯU TẬP</a>
					<ul class="menucon1">
						<li><a href="/bo-suu-tap-xuan-he-2022?tenbst=MAN IN OFFICITY">Xuân
								Hè 2022</a></li>
						<li><a href="">Thu Đông 2022</a></li>
						<li><a href="">Xuân Hè 2023</a></li>
					</ul></li>
				<li><a href="/cua-hang">CỬA HÀNG</a></li>
				<li><a href="/cua-hang">LIÊN HỆ</a></li>
			</ul>
		</div>
		<div id="timkiem">
			<form action="${base }/tim-kiem-san-pham" method="get"
				id="form-tim-kiem">
				<p style="margin: 0; width: 100%;">
					<input type="search" placeholder="Tìm kiếm..." name="tensanpham"
						class="ten-san-pham" style="height: 28px; width: 75%;"> <i
						class="ti-search" onclick="timKiemMenu()"></i>
				</p>
			</form>
		</div>
		<div id="yeuthich">
			<i class="ti-heart"></i> <i class="ti-shopping-cart"
				onclick="GioHang()">
				<div id="soluongsanphamtronggiohang" class="so-luong-san-pham">${tongsosanphamgiohang }</div>
			</i> <i class="ti-user"> <c:choose>
					<c:when test="${isLogined }">
						<div class="dang-nhap">
							<ul>
								<li><a href="${base }/thong-tin-khach-hang">Tài khoản</a></li>
								<li><a href="${base }/lich-su-mua-hang">Đơn hàng</a></li>
								<li><a href="${base }/logout">Đăng xuất</a></li>
							</ul>
						</div>
					</c:when>
					<c:otherwise>
						<div class="dang-nhap">
							<ul>
								<li><a href="${base }/dang-ky">Đăng ký</a></li>
								<li><a href="${base }/login">Đăng nhập</a></li>
							</ul>
						</div>
					</c:otherwise>
				</c:choose>

			</i>
		</div>
	</div>
</div>

<script type="text/javascript">
	function GioHang() {
		window.location = "/gio-hang";
	}
	function ChuyenTrang() {
		window.location = "/trang-chu";
	}

	function timKiemMenu() {
		var tensp = document.querySelector('.ten-san-pham').value;

		if (tensp != "") {

			document.getElementById('form-tim-kiem').submit();
		}

	}
</script>


