<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="tieude">
    <div></div>
</div>
<div>
    <div id="content">
        <div id="content-left">
            <div class="avatar">
                <img src="${base }/image/logoOff.png" alt="">
                <p class="admin">ADMIN</p>
            </div>
            <hr class="nganavt">
            <div id="menu">
                <ul>
                    <li><a href="${base }/admin/trang-chu">Quản lý sản phẩm</a></li>
                    <li><a href="${base }/admin/quan-ly-danh-muc-san-pham">Quản lý hãng sản phẩm</a></li>
                    <li><a href="/admin/quan-ly-hoa-don">Quản lý hóa đơn</a></li>
                    <li><a href="/admin/quan-ly-tai-khoan">Quản lý tài khoản</a></li>

                </ul>
            </div>

            <div id="other">
                <p id="showMockupBtn">Tạo tài khoản admin</p>
                <p><a href="${base }/logout">Đăng xuất (${userLogined.email })</a></p>
            </div>
        </div>
    </div>
</div>


<div class="overlay"></div>

<!-- Mockup register form -->
<div id="mockup" class="mockup-hidden">
    <div class="mockup-content">
        <span class="close-icon" id="closeMockupBtn">&times;</span>
        <p>
        <form action="${base }/dang-ky-admin" method="post" id="form-dang-ky-admin" style="width: 100%;
                                display: flex;justify-content: center;align-items: center;">
            <div id="dangky">
                <img src="./image/logoOff.png" alt="" class="logo-center">
                <p>ĐĂNG KÝ ADMIN</p>
                <div class="tendangnhap">
                    <label style="float: left;">Tên đăng nhập</label>
                    <input type="text" name="tendangnhap" placeholder="Tên đăng nhập" required="required">
                </div>
                <div class="matkhau">
                    <label style="float: left;">Mật khẩu</label>
                    <input type="password" name="matkhau" placeholder="Mật khẩu" required="required">
                </div>

                <div class="hoten">
                    <label style="float: left;">Họ tên</label>
                    <input type="text" name="hoten" placeholder="Họ tên" required="required">
                </div>

                <div class="email">
                    <label style="float: left;">Email</label>
                    <input type="text" name="email" placeholder="Email" required="required">
                </div>

                <div class="sodienthoai">
                    <label style="float: left;">Số điện thoại</label>
                    <input type="text" name="sodienthoai" placeholder="Số điện thoại" required="required">
                </div>

                <div class="dangky" onclick="dangKyAdmin()">
                    ĐĂNG KÝ
                </div>
            </div>
        </form>
        </p>
    </div>
</div>

