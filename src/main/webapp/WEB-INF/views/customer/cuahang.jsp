<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
    <link rel="stylesheet" href="${base }/css/header1.css">
    <link rel="stylesheet" href="${base }/css/footer1.css">
    <link rel="stylesheet" href="${base }/css/cuahang.css">
    <link rel="stylesheet" href="${base }/icon/themify-icons/themify-icons.css">
    <title>Document</title>
</head>
<body>
    <div id="cua-hang-content">
        <div class="he-thong-cua-hang">
            <h2>HỆ THỐNG CỬA HÀNG</h2>
            <div class="tim-kiem-cua-hang">
                <p><strong>Nhập vị trí để tìm kiếm</strong></p>
                <form action="${base }/cua-hang" method="post">
                    <p><input type="search" name="diachicuahang" id="" placeholder="Nhập vị trí..." class="o-tim-kiem" value="${tenCuaHang }"></p>
                    <p><input type="submit" value="Tìm kiếm" class="nut-tim-kiem"></p>
                </form>
            </div>
            <div class="cua-hang">
                <p>Có ${cuaHangs.size() } cửa hàng tìm thấy</p>
                <div class="danh-sach-cua-hang">
                <c:forEach items="${cuaHangs }" var="ch">
                	<div class="thong-tin-cua-hang">
                        <p><strong>${ch.tenCuaHang }</strong></p>
                        <p>${ch.diaChi }</p>
                        <p>Điện thoại: ${ch.dienThoai }</p>
                    </div>
                </c:forEach>
                    
                    <!-- <div class="thong-tin-cua-hang">
                        <p><strong>Aristino Time City</strong></p>
                        <p>Địa chỉ: D7 -11-13 đường Thời đại, TTTM Times City, 458 Minh Khai, Hai Bà Trưng, HN</p>
                        <p>Điện thoại: 02439924999</p>
                    </div>
                    <div class="thong-tin-cua-hang">
                        <p><strong>Aristino Time City</strong></p>
                        <p>Địa chỉ: D7 -11-13 đường Thời đại, TTTM Times City, 458 Minh Khai, Hai Bà Trưng, HN</p>
                        <p>Điện thoại: 02439924999</p>
                    </div>
                    <div class="thong-tin-cua-hang">
                        <p><strong>Aristino Time City</strong></p>
                        <p>Địa chỉ: D7 -11-13 đường Thời đại, TTTM Times City, 458 Minh Khai, Hai Bà Trưng, HN</p>
                        <p>Điện thoại: 02439924999</p>
                    </div>
                    <div class="thong-tin-cua-hang">
                        <p><strong>Aristino Time City</strong></p>
                        <p>Địa chỉ: D7 -11-13 đường Thời đại, TTTM Times City, 458 Minh Khai, Hai Bà Trưng, HN</p>
                        <p>Điện thoại: 02439924999</p>
                    </div> -->
                </div>
            </div>
        </div>
        <div id="ban-do-cua-hang" class="ban-do-cua-hang">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3723.4095184151392!2d105.7270430745142!3d21.056299980599974!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31345457295f8455%3A0x6424aee229448841!2zTmjhu5VuIENpdHk!5e0!3m2!1svi!2s!4v1685092386428!5m2!1svi!2s" height="500px" width="700px" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            
        </div>
    </div>
    <div class="clear"></div>
    <jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>
</body>
<!-- <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap" async defer></script>
<script>
    function initMap() {
  var latLng = { lat: 21.0168864, lng: 105.7855574 }

  // create map with center is latLng
  // code

  // each marker define one point
  var marker = new google.maps.Marker({
    position: latLng,
    map: map,
  });
}
</script> -->
</html>