<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
    <link rel="stylesheet" href="${base }/css/chitietsanpham.css">
    <link rel="stylesheet" href="${base }/css/header1.css">
    <link rel="stylesheet" href="${base }/css/footer1.css">
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <link rel="stylesheet" href="./icon/themify-icons/themify-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/fontawesome.min.css" integrity="sha512-B46MVOJpI6RBsdcU307elYeStF2JKT87SsHZfRSkjVi4/iZ3912zXi45X5/CBr/GbCyLx6M1GQtTKYRd52Jxgw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Document</title>
</head>
<body>

    <div id="chitetsanpham">
        <div class="tren">
            <div class="right">
                <img src="${base }/image/${sanPham.hinhAnh}" alt="">
            </div>
            <div class="left">
                <p class="ten">${sanPham.tenSanPham }</p>
                <i class="ti-heart" class="yeuthich"></i>
                <div class="clear"></div>
                <p class="gia">${sanPham.getEpGia()}đ</p>
                <p class="mau">Màu: ${sanPham.mauSac }</p>
                <p class="size">Chọn size
                    <ul class="si" style="margin-top: 0; padding: 0;">
                    	<c:forEach items="${size }" var="s">
                    		<li class="loaisize" id="${s }" onclick="gachChan('${s }')"><c:out value="${s }"></c:out></li>
                    	</c:forEach>
                        
                    </ul>
              
                <div class="soluong">Số lượng
                    <div>
                        <ul class="sl" style="margin-top: 0; padding: 0;">
                            <li class="tang" id="giam" onclick="Giam()">-</li>
                            <li id="soluong">1</li>
                            <li class="tang" id="tang" onclick="Tang()">+</li>
                        </ul>
                    </div>
                </div>
                <div class="clear"></div>
                <p class="themgh" onclick="ThemSanPhamGH('${base}',${sanPham.id })"><i class="ti-shopping-cart" ></i>Thêm vào giỏ hàng</p>
                <p class="mua" onclick="MuaHang('${base}','${sanPham.id }')">Mua ngay</p>
            </div>
            <div class="clear"></div>
        </div>
        <div class="duoi">
            <p class="thongtin">Thông tin sản phẩm</p>
            <hr>
            <%-- <p class="nd"><strong>Kiểu dáng: </strong>${sanPham.formDang }</p> --%>
            <p class="nd"><strong>Phiên bản:</strong></p>
            <p>${sanPham.thietKe }</p>
            <%-- <c:forEach begin="1" items="${thietKe }" var="t">
            	<p>- ${t}</p>
            </c:forEach> --%>
            <!-- <p>- Áo polo dài tay phom dáng Tech Golf được tinh chỉnh các thông số đem lại sự thoải mái tối đa theo từng cử động của golfer. Áo được nâng cấp tính năng Anti UV, giúp bảo vệ làn da với chỉ số kháng tia UV lên tới 98% và bền bỉ trong suốt thời gian sử dụng. Công nghệ sợi vải Moisture Wicking giúp áo thấm hút tốt, đồng thời khô nhanh hơn.</p>
            <p>- Thiết kế khỏe khoắn, màu sắc nam tính, cùng họa tiết đại bàng độc đáo, sáng tạo trên ngực trái áo đem đến diện mạo trẻ trung và lịch lãm cho người mặc.</p> -->
            <p class="nd"><strong>Mô tả:</strong></p>
            <p>${sanPham.chatLieu }</p>
            <%-- <c:forEach begin="1" items="${chatLieu }" var="c">
            	<p>-${c }</p>
            </c:forEach> --%>
            <!-- <p>- 77% Nylon cho bề mặt vải độ mịn mượt, mỏng nhẹ</p>
            <p>- 23% Spandex tạo độ co giãn tốt, thoải mái tối đa khi mặc.</p> -->
            <p class="nd"><strong>Màu sắc: </strong>${sanPham.mauSac }</p>
            <p class="nd"><strong>Size: </strong>${sanPham.size }</p>
        </div>
        <div class="duoi">
            <p class="thongtin">Bình Luận</p>
            <hr>
            <div class="row d-flex justify-content-center mt-100 mb-100">
                <div class="col-lg-12" style="margin-bottom: 15px;">
                    <div class="card">
                        <div class="card-body text-center">
                            <h4 class="card-title">Bình luận mới nhất</h4>
                        </div>
                        <div class="comment-widgets">
                        	<c:forEach items="${binhLuans }" var="binhLuan">
                        		<div class="d-flex flex-row comment-row m-t-0" style="margin-bottom: 20px;">
                                <div class="p-2"><img src="./image/anhDaiDienMacDinh.jpg" alt="user" width="50" class="rounded-circle"></div>
                                <div class="comment-text w-100">
                                    <div class="d-flex" style="justify-content: space-between">
                                        <h6 class="font-medium">${binhLuan.userName }<span>(${binhLuan.rating }☆)</span></h6>
                                        <div class="comment-footer"> <span class="text-muted float-right">${binhLuan.createdAt }</span></div>
                                    </div>
                                    <span class="m-b-15 d-block">${binhLuan.content } </span>
                                </div>
                            </div> <!-- Comment Row -->
                        	</c:forEach>
                            <!-- Comment Row -->
                            
                            <!-- <div class="d-flex flex-row comment-row" style="margin-bottom: 20px;">
                                <div class="p-2"><img src="https://i.imgur.com/8RKXAIV.jpg" alt="user" width="50" class="rounded-circle"></div>
                                <div class="comment-text active w-100">
                                    <div class="d-flex" style="justify-content: space-between">
                                        <h6 class="font-medium">James Thomas<span>(5☆)</span></h6>
                                        <div class="comment-footer"> <span class="text-muted float-right">April 14, 2019</span></div>
                                    </div>
                                    <span class="m-b-15 d-block">This is awesome website. I would love to comeback again. </span>
                                </div>
                            </div> Comment Row
                            <div class="d-flex flex-row comment-row" style="margin-bottom: 20px;">
                                <div class="p-2"><img src="https://i.imgur.com/J6l19aF.jpg" alt="user" width="50" class="rounded-circle"></div>
                                <div class="comment-text w-100">
                                    <div class="d-flex" style="justify-content: space-between">
                                        <h6 class="font-medium">James Thomas<span>(5☆)</span></h6>
                                        <div class="comment-footer"> <span class="text-muted float-right">April 14, 2019</span></div>
                                    </div>
                                    <span class="m-b-15 d-block">This is awesome website. I would love to comeback again. </span>
                                </div>
                            </div> -->
                        </div>
                    </div>
                </div>
            </div>
            <c:if test="${isLogined }">
            	<form action="${base }/gui-binh-luan" method="post">
            		<div class="card">
                <div class="row">
                    <div class="col-2">
                        <img src="./image/anhDaiDienMacDinh.jpg" width="70" class="rounded-circle mt-2">
                    </div>
                    <div class="col-10">
                        <div class="comment-box ml-2">
                            <h4>Thêm bình luận</h4>
                            <input type="text" name="idSanPham" value="${sanPham.id }" style="display: none;"/>
                            <div class="rating">
                                <input type="radio" name="rating" value="5" id="5"><label for="5">☆</label>
                                <input type="radio" name="rating" value="4" id="4"><label for="4">☆</label>
                                <input type="radio" name="rating" value="3" id="3"><label for="3">☆</label>
                                <input type="radio" name="rating" value="2" id="2"><label for="2">☆</label>
                                <input type="radio" name="rating" value="1" id="1"><label for="1">☆</label>
                            </div>
                            <div class="comment-area">
                                <textarea class="form-control" name="content" placeholder="Bạn nghĩ sản phẩm thế nào?" rows="4"></textarea>
                            </div>
                            <div class="comment-btns mt-2">
                                <div class="row">
                                    <div class="col-6">
                                        <div class="pull-left">
                                            <button class="btn btn-danger btn-sm">Hủy</button>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="pull-right">
                                            <button class="btn btn-success send btn-sm" style="float: right; width: 170px;">Gửi<i class="fa fa-long-arrow-right ml-1" style="margin-left: 10px;"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            	</form>
            </c:if>
        </div>
    </div>

    <div id="sanphamlienquan">
        <p>SẢN PHẨM LIÊN QUAN</p>
        <div class="danhsachsanphamlienquan">

            <c:set var="itemsPerRow" value="4" />

            <c:forEach var="rowIndex" begin="0" end="${fn:length(sanPhamLienQuan) / itemsPerRow - 1}">
                <div id="loaisanpham">
                    <c:forEach items="${sanPhamLienQuan}" var="splq" begin="${rowIndex * itemsPerRow}" end="${rowIndex * itemsPerRow + itemsPerRow - 1}">
                        <div class="sanpham">
                            <img src="${base }/image/${splq.hinhAnh}" alt="">
                            <p class="tensp">${splq.tenSanPham }</p>
                            <p class="gia">${splq.getEpGia() }</p>
                        </div>
                    </c:forEach>
                </div>
            </c:forEach>
        
            <!-- <div id="loaisanpham">
                <div class="sanpham">
                    <img src="./image/aosomi1.png" alt="">
                    <p class="tensp">Áo sơ mi nam Aristino 1SSR14</p>
                    <p class="gia">1.470.000đ</p>
                </div>
                <div class="sanpham">
                    <img src="./image/aosomi2.png" alt="">
                    <p class="tensp">ÁO SƠ MI NAM ARISTINO 1SS101S2</p>
                    <p class="gia">1.600.000đ</p>
                </div>
                <div class="sanpham">
                    <img src="./image/aosomi3.png" alt="">
                    <p class="tensp">Áo sơ mi ngắn tay Aristino Boss 1SS125S2</p>
                    <p class="gia">1.250.000đ</p>
                </div>
                <div class="sanpham">
                    <img src="./image/aosomi4.png" alt="">
                    <p class="tensp">Áo sơ mi ngắn tay Aristino Boss 1SS118S2</p>
                    <p class="gia">1.200.000đ</p>
                </div>
                
            </div>
            <div id="loaisanpham">
                <div class="sanpham">
                    <img src="./image/aosomi1.png" alt="">
                    <p class="tensp">Áo sơ mi nam Aristino 1SSR14</p>
                    <p class="gia">1.470.000đ</p>
                </div>
                <div class="sanpham">
                    <img src="./image/aosomi2.png" alt="">
                    <p class="tensp">ÁO SƠ MI NAM ARISTINO 1SS101S2</p>
                    <p class="gia">1.600.000đ</p>
                </div>
                <div class="sanpham">
                    <img src="./image/aosomi3.png" alt="">
                    <p class="tensp">Áo sơ mi ngắn tay Aristino Boss 1SS125S2</p>
                    <p class="gia">1.250.000đ</p>
                </div>
                <div class="sanpham">
                    <img src="./image/aosomi4.png" alt="">
                    <p class="tensp">Áo sơ mi ngắn tay Aristino Boss 1SS118S2</p>
                    <p class="gia">1.200.000đ</p>
                </div>
                
            </div>
            <div id="loaisanpham">
                <div class="sanpham">
                    <img src="./image/aosomi1.png" alt="">
                    <p class="tensp">Áo sơ mi nam Aristino 1SSR14</p>
                    <p class="gia">1.470.000đ</p>
                </div>
                <div class="sanpham">
                    <img src="./image/aosomi2.png" alt="">
                    <p class="tensp">ÁO SƠ MI NAM ARISTINO 1SS101S2</p>
                    <p class="gia">1.600.000đ</p>
                </div>
                <div class="sanpham">
                    <img src="./image/aosomi3.png" alt="">
                    <p class="tensp">Áo sơ mi ngắn tay Aristino Boss 1SS125S2</p>
                    <p class="gia">1.850.000đ</p>
                </div>
                <div class="sanpham">
                    <img src="./image/aosomi4.png" alt="">
                    <p class="tensp">Áo sơ mi ngắn tay Aristino Boss 1SS118S2</p>
                    <p class="gia">1.900.000đ</p>
                </div>
                
            </div> -->
            
        </div>

        <div class="button_chuyen_sanphamlienquan">
            <i class="ti-arrow-circle-left btn_san_pham_lien_quan_trai"></i>
            <i class="ti-arrow-circle-right btn_san_pham_lien_quan_phai"></i>
        </div>
        

    </div>


    <jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>

    <jsp:include page="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>
    
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="${base }/js/cart.js"></script>

<script>
	var soloai = document.querySelectorAll('#loaisanpham').length;
	window.onload = function() {
		
		if(soloai > 1){
			document.querySelector('.button_chuyen_sanphamlienquan').style.display = 'flex';
		}
	};
	
	var size = "";
    function gachChan(id){
        var s = document.querySelectorAll(".loaisize");
        for(i = 0; i < s.length; i++){
            s[i].style.border = "none";
        }
        document.getElementById(id).style.borderBottom = "1px solid black";
        size = document.getElementById(id).innerHTML;
    }
    
    
    const btnlienquantrai = document.querySelector('.btn_san_pham_lien_quan_trai');
    const btnlienquanphai = document.querySelector('.btn_san_pham_lien_quan_phai');
    
    var indexLienQuan = 0;
    btnlienquanphai.addEventListener('click', function() {
        indexLienQuan = indexLienQuan + 1;
        if(indexLienQuan > soloai - 1){
            indexLienQuan = 0;
        }
        document.querySelector('.danhsachsanphamlienquan').style.right = indexLienQuan * 100 + '%';
    });

    btnlienquantrai.addEventListener('click', function(){
        indexLienQuan = indexLienQuan - 1;
        if(indexLienQuan < 0){
            indexLienQuan = soloai - 1;
        }
        document.querySelector('.danhsachsanphamlienquan').style.right = indexLienQuan * 100 + '%';
    })
    
    function Tang() {
    	soLuong = parseInt(document.getElementById('soluong').innerHTML);
    	soLuong = parseInt(soLuong + 1);
    	document.getElementById('soluong').innerHTML = soLuong;
	}
    
    function Giam() {
    	soLuong = parseInt(document.getElementById('soluong').innerHTML);
    	soLuong = parseInt(soLuong - 1);
    	document.getElementById('soluong').innerHTML = soLuong;
	}
    
    function ThemSanPhamGH(_baseUrl, _productId) {
		if(size == ""){
			alert("Bạn phải chọn size");
			return;
		}
		soLuong = parseInt(document.getElementById('soluong').innerHTML);
		AddToCart(_baseUrl, _productId ,soLuong, size);
	}
    
    function MuaHang(_baseUrl, _productId) {
    	if(size == ""){
			alert("Bạn phải chọn size");
			return;
		}
    	soLuong = parseInt(document.getElementById('soluong').innerHTML);
		AddToCart(_baseUrl, _productId ,soLuong, size);
    	window.location = "/thanh-toan";
	}
    
</script>

</html>