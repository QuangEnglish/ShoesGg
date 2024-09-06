<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${base }/css/dangnhap.css">
    <title>Đăng nhập Admin</title>
</head>
<body>
<div style="width: 100%; display: flex; justify-content: center;">
<%--    <div class="wrapper-banner-login" style="width: 60%;">--%>
<%--        <img src="./image/banner11.png" alt="" class="fb">--%>
<%--    </div>--%>
    <div id="dangnhap-admin"  style="width: 100%;">
        <form action="${base }/login_processing_url?loginPage=admin" method="post" id="form-login"
              style="display: flex;justify-content: center;align-items: center; height: 100vh;">
            <div id="dangky" style="position: relative;">
                <img src="./image/logoOff.png" alt="" class="logo-center-admin">
                <p>ĐĂNG NHẬP ADMIN</p>
                <div class="tendangnhap">
                    <label>Email</label>
                    <input type="email" name="username" id="username" placeholder="Email" required="required">
                </div>

                <div class="matkhau">
                    <label>Mật khẩu</label>
                    <input type="password" name="password" placeholder="Mật khẩu" required="required">
                </div>

                <div class="luumatkhau">
                    <p><input type="checkbox" name="remember-me"> Lưu đăng nhập</p>
                </div>

                <div class="dangnhap">
                    <input type="button" value="ĐĂNG NHẬP" onclick="logIn()">
                </div>

                <c:if test="${not empty param.login_error}">
                    <div class="alert alert-danger" role="alert">
                        <!-- Tên đăng nhập hoặc mật khẩu không chính xác! -->
                        <%= "1".equals(request.getParameter("message")) ? "Tên đăng nhập không chính xác!" : ""%>
                        <%= "2".equals(request.getParameter("message")) ? "Mật khẩu không chính xác!" : ""%>
                    </div>
                </c:if>

                <div class="dangky">
                    <a href="${base }/dang-ky">ĐĂNG KÝ</a>
                </div>

                <div class="icon">
                    <img src="./image/iconfb.png" alt="" class="fb">
                    <img src="./image/icongg.png" alt="" class="gg">
                    <img src="./image/icontt.png" alt="" class="tt">
                </div>
            </div>
        </form>


    </div>


</div>
<script type="text/javascript">
	
	function isValidEmail(email) {
	    // Regular expression for basic email validation
	    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	    return regex.test(email);
	}
	
	function logIn(){
		const inputElement = document.getElementById('username');
		if(isValidEmail(inputElement.value)){
			document.getElementById('form-login').submit();
		} else {
			alert("Định dạng email không hợp lệ!");
		}
	
	}

</script>

</body>
</html>