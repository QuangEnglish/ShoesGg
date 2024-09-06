<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${base }/css/trangchu.css">
    <link rel="stylesheet" href="${base }/css/footer1.css">
    <link rel="stylesheet" href="${base }/css/header1.css">
    <link rel="stylesheet" href="${base }/icon/themify-icons/themify-icons.css">
    <link type="text/css" rel="stylesheet" href="${base }/css/simplePagination.css"/>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/fontawesome.min.css"--%>
<%--          integrity="sha512-B46MVOJpI6RBsdcU307elYeStF2JKT87SsHZfRSkjVi4/iZ3912zXi45X5/CBr/GbCyLx6M1GQtTKYRd52Jxgw=="--%>
<%--          crossorigin="anonymous" referrerpolicy="no-referrer"/>--%>
<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"--%>
<%--          integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="--%>
<%--          crossorigin="anonymous" referrerpolicy="no-referrer"/>--%>
<%--    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">--%>
    <title>Shop Gg</title>
    <style>
        html, body {
            font-family: 'Roboto', sans-serif;
        }
    </style>
</head>
<body>


<div class="clear"></div>

<div id="body">
    <div class="slide-show">
        <div class="anhthuonghieu">
            <div class="slide"><img src="./image/banner11.png" alt=""></div>
            <div class="slide"><img src="./image/banner9.jpg" alt=""></div>
            <div class="slide"><img src="./image/banner1.jpg" alt=""></div>
            <div class="slide"><img src="./image/banner8.png" alt=""></div>
        </div>
    </div>


    <div class="danhmucnoibat">
        <p class="ten-nho">Toàn bộ sản phẩm đều là hàng chính hãng</p>
        <p class="ten">DANH MỤC NỔI BẬT</p>
        <div class="danhsachsanphamnoibat fade">
            <div class="noibat fade">
                <div class="wrapper-product-special">
                    <div class="chuasanphamnoibat">
                        <div class="sanphamnoibat" onclick="ChuyenDanhMuc('Giày Addidas')">
                            <img src="./image/thuonghieu1.jpg" alt="">
                            <p>Giày Addidas</p>
                        </div>
                        <div class="sanphamnoibat" onclick="ChuyenDanhMuc('Giày Puma')">
                            <img src="./image/item2.jpg" alt="">
                            <p>Giày Puma</p>
                        </div>
                        <div class="sanphamnoibat">
                            <img src="./image/item3.jpg" alt="" onclick="ChuyenDanhMuc('Giày Nike')">
                            <p>Giày Nike</p>
                        </div>
                        <div class="sanphamnoibat">
                            <img src="./image/item4.png" alt="" onclick="ChuyenDanhMuc('Giày Bitis')">
                            <p>Giày Bitis</p>
                        </div>

                    </div>
                    <div class="chuasanphamnoibat fade">
                        <div class="sanphamnoibat fade" onclick="ChuyenDanhMuc('Giày Thượng Đỉnh')">
                            <img src="./image/item6.webp" alt="">
                            <p>Giày Thượng Đỉnh</p>
                        </div>
                        <div class="sanphamnoibat" onclick="ChuyenDanhMuc('Giày Vans')">
                            <img src="./image/item11.jpg" alt="">
                            <p>Giày Vans</p>
                        </div>
                        <div class="sanphamnoibat" onclick="ChuyenDanhMuc('Giày Reebok')">
                            <img src="./image/item21.webp" alt="">
                            <p>Giày Reebok</p>
                        </div>
                        <div class="sanphamnoibat" onclick="ChuyenDanhMuc('Giày Lười')">
                            <img src="./image/item20.jpg" alt="">
                            <p>Giày Lười</p>
                        </div>
                    </div>
                    <!-- <div class="chuasanphamnoibat fade">
                        <div class="sanphamnoibat fade">
                            <img src="./image/item22.jpg" alt="">
                            <p>Giày Jodan</p>
                        </div>
                        <div class="sanphamnoibat">
                            <img src="./image/item23.jpg" alt="">
                            <p>Giày Balenciaga</p>
                        </div>
                        <div class="sanphamnoibat">
                            <img src="./image/item24.jpg" alt="">
                            <p>Giày New Balance</p>
                        </div>
                        <div class="sanphamnoibat">
                            <img src="./image/item25.jpg" alt="">
                            <p>Giày Converse </p>
                        </div>
                    </div> -->
                </div>
            </div>


            <div class="button_chuyen_noibat">
                <i class="ti-arrow-circle-left btn_noi_bat_trai"></i>
                <i class="ti-arrow-circle-right btn_noi_bat_phai"></i>
            </div>
        </div>
        <div class="scroll-container">
            <div class="scrolling-text">
                <span><i class="fa-solid fa-bolt"></i> Tặng quà trên mỗi đơn hàng từ 500k</span>
                <span><i class="fa-solid fa-bolt"></i> Giảm 15% cho ĐH đầu tiên từ 699k</span>
                <span><i class="fa-solid fa-bolt"></i> Miễn phí vận chuyển từ ĐH 599k</span>
                <span><i class="fa-solid fa-bolt"></i> Đổi hàng trong 30 ngày</span>
                <span><i class="fa-solid fa-bolt"></i> Tặng quà trên mỗi đơn hàng từ 500k</span>
                <span><i class="fa-solid fa-bolt"></i> Giảm 15% cho ĐH đầu tiên từ 699k</span>
                <span><i class="fa-solid fa-bolt"></i> Miễn phí vận chuyển từ ĐH 599k</span>
            </div>
        </div>

        <div class="container countdown">
            <div class="danhmucnoibat">
                <p class="ten">DEAL CỰC HẤP DẪN</p>
            </div>
            <div class="row">
                <div class="col countdown-item">
                    <span id="days">00</span>
                    <label>Ngày</label>
                </div>
                <div class="col countdown-item">
                    <span id="hours">00</span>
                    <label>Giờ</label>
                </div>
                <div class="col countdown-item">
                    <span id="minutes">00</span>
                    <label>Phút</label>
                </div>
                <div class="col countdown-item">
                    <span id="seconds">00</span>
                    <label>Giây</label>
                </div>
            </div>
        </div>
    </div>
    <div class="clear"></div>

    <div id="danhsachsanpham">
        <div class="row">
            <p class="tendm">SẢN PHẨM NỔI BẬT</p>
        </div>
        <div class="chuabonsanphamnoibat">
            <c:set var="counter" value="0"/>
            <c:forEach items="${sanPhams.data}" var="sp">
                <c:if test="${sp.status == 1}">
                    <c:if test="${counter % 4 == 0}">
                        <div class="row">
                    </c:if>

                    <div class="sanpham" onclick="ChiTietSanPham('${sp.id}')">
                        <img src="${base }/image/${sp.hinhAnh}" alt="">
                        <p class="tensp">${sp.tenSanPham}</p>
                        <p class="gia">${sp.getEpGia()}đ</p>
                    </div>

                    <c:if test="${counter % 4 == 3}">
                        </div>
                    </c:if>

                    <c:set var="counter" value="${counter + 1}"/>
                </c:if>
            </c:forEach>
            <c:if test="${counter % 4 != 0}">
        </div>
        </c:if>
    </div>

    </div>
    <div class="phantrang" style="margin-bottom: 50px;">
        <form action="${base }/trang-chu" method="post">
            <input type="submit" value="" name="sotrang" id="so-trang" style="display: none;"/>
        </form>
        <div id="paging"></div>
<%--        <div class="button_chuyen_noibat_san_pham">--%>
<%--            <i class="ti-arrow-circle-left btn_noi_bat_trai_san_pham"></i>--%>
<%--            <i class="ti-arrow-circle-right btn_noi_bat_phai_san_pham"></i>--%>
<%--        </div>--%>
</div>

<div id="cuahang">
    <div class="nen-comment">
        <p class="ht">KHÁCH HÀNG NÓI GÌ</p>

    </div>
</div>
<div id="cuahang">
    <div class="nen">
        <p class="ht">HỆ THỐNG CỬA HÀNG</p>
        <p class="tim" onclick="CuaHang()"><span>TÌM NGAY</span></p>

    </div>
</div>

<jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>
</body>


<%--<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>--%>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>--%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="${base }/js/jquery.simplePagination.js"></script>
<script>

    $(document).ready(function() {
        $("#paging").pagination({
            currentPage: ${sanPhams.currentPage},
            items: ${sanPhams.totalItems},
            itemsOnPage: ${sanPhams.sizeOfPage},
            cssStyle: 'light-theme',
            onPageClick: function (pageNumber, event) {
                $("#so-trang").val(pageNumber);
                $("#so-trang").trigger("click");
            }
        });
    });

    function ChuyenDanhMuc(tendm) {
        window.location = "/san-pham-ao?tendm=" + tendm;
    }

    function GioHang() {
        window.location = "/gio-hang";
    }

    function ChuyenTrang() {
        window.location = "/trang-chu";
    }

    const btnnoibattrai = document.querySelector('.btn_noi_bat_trai');
    const btnnoibatphai = document.querySelector('.btn_noi_bat_phai');
    const sonoibat = document.querySelectorAll('.chuasanphamnoibat').length;
    var index1 = 0;


    btnnoibatphai.addEventListener("click", function () {

        index1 = index1 + 1;
        if (index1 > sonoibat - 1) {
            index1 = 0;
        }

        document.querySelector('.noibat').style.right = index1 * 100 + "%";


    });

    btnnoibattrai.addEventListener("click", function () {


        index1 = index1 - 1;

        if (index1 < 0) {
            index1 = sonoibat - 1;
        }

        document.querySelector('.noibat').style.right = index1 * 100 + "%";
    });

    const btnsanphamtrai = document.querySelector('.btn_noi_bat_trai_san_pham');
    const btnsanphamphai = document.querySelector('.btn_noi_bat_phai_san_pham');
    const sospnoibat = document.querySelectorAll('.dongsp').length;
    var index2 = 0;

    btnsanphamphai.addEventListener("click", function () {
        index2 = index2 + 1;
        if (index2 > sospnoibat - 1) {
            index2 = 0;
        }
        document.querySelector('.chuabonsanphamnoibat').style.right = index2 * 100 + "%";
    });


    btnsanphamtrai.addEventListener("click", function () {
        index2 = index2 - 1;
        if (index2 < 0) {
            index2 = sospnoibat - 1;
        }

        document.querySelector(".chuabonsanphamnoibat").style.right = index2 * 100 + "%";
    });

    function CuaHang() {
        window.location = "/cua-hang";
    }

    function ChiTietSanPham(id) {
        window.location = "/chi-tiet-san-pham?id=" + id;
    }


</script>

<script>
    var countDownDate = new Date().getTime() + 7 * 24 * 60 * 60 * 1000;

    var x = setInterval(function () {
        var now = new Date().getTime();

        var distance = countDownDate - now;

        var days = Math.floor(distance / (1000 * 60 * 60 * 24));
        var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
        var seconds = Math.floor((distance % (1000 * 60)) / 1000);

        document.getElementById("days").innerHTML = days;
        document.getElementById("hours").innerHTML = hours;
        document.getElementById("minutes").innerHTML = minutes;
        document.getElementById("seconds").innerHTML = seconds;

        if (distance < 0) {
            clearInterval(x);
            document.getElementById("days").innerHTML = "00";
            document.getElementById("hours").innerHTML = "00";
            document.getElementById("minutes").innerHTML = "00";
            document.getElementById("seconds").innerHTML = "00";
            alert("Countdown finished!");
        }
    }, 1000);
</script>
</html>