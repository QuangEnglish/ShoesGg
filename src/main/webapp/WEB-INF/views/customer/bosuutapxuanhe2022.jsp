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
    <link rel="stylesheet" href="${base }/css/bosuutapxuanhe2022.css">
    <link rel="stylesheet" href="${base }/css/header1.css">
    <link rel="stylesheet" href="${base }/css/footer1.css">
    <link rel="stylesheet" href="${base }/icon/themify-icons/themify-icons.css">
    <title>Document</title>
</head>
<body>
    <header class="xuanhe-header">
        <img src="${base }/image/${boSuuTap.anhTieuDe}" alt="">
    </header>
    <div id="body-xuanhe2022">
        <div class="content-man">
            <div class="contentman-ten contentman-tenman">
                <p class="tenbosuutap">${boSuuTap.tenBST }</p>
                <p class="noidungbo">${moTa }</p>
            </div>
            <c:forEach begin="1" end="3" items="${sanPhams }" var="sp">
            	<div class="contentman-ten">
                <img src="${base }/image/${sp.hinhAnh}" alt="">
            </div>
            </c:forEach>
            <%-- <div class="contentman-ten">
                <img src="${base }/image/ao1.png" alt="">
            </div>
            <div class="contentman-ten">
                <img src="${base }/image/ao2.png" alt="">
            </div>
            <div class="contentman-ten">
                <img src="${base }/image/ao3.png" alt="">
            </div> --%>
        </div>
        <div class="clear"></div>

        <div id="anh-man">
            <img src="${base }/image/${boSuuTap.anhNoiDung }" alt="">
            <img src="${base }/image/${boSuuTap.anhDanhMuc }" alt="">
        </div>

        <div id="loaisanpham">
        	
        	<c:forEach begin="0" end="3" items="${sanPhams }" var="sp">
        		<div class="sanpham" onclick="chiTietSanPham('${sp.id}')">
	                <img src="${base }/image/${sp.hinhAnh}" alt="">
	                <p class="tensp">${sp.tenSanPham }</p>
	                <p class="gia">${sp.getEpGia() }đ</p>
            	</div>
        	</c:forEach>
            
            
            <%-- <div class="sanpham">
                <img src="${base }/image/aosomi2.png" alt="">
                <p class="tensp">ÁO SƠ MI NAM ARISTINO 1SS101S2</p>
                <p class="gia">1.600.000đ</p>
            </div>
            <div class="sanpham">
                <img src="${base }/image/aosomi3.png" alt="">
                <p class="tensp">Áo sơ mi ngắn tay Aristino Boss 1SS125S2</p>
                <p class="gia">1.250.000đ</p>
            </div>
            <div class="sanpham">
                <img src="${base }/image/aosomi4.png" alt="">
                <p class="tensp">Áo sơ mi ngắn tay Aristino Boss 1SS118S2</p>
                <p class="gia">1.200.000đ</p>
            </div> --%>
        </div>
        <div class="clear"></div>
        <div id="anh-man-duoi">
            <img src="${base }/image/${boSuuTap.anhPhanCuoi }" alt="">
        </div>

        <div id="man-ten-noidung">
            <p class="man-t">MAN IN OFFICITY</p>
            <p class="man-nd">Một bộ trang phục chỉn chu và lịch lãm không chỉ giúp "sạc" đầy cảm hứng làm việc, mà còn là "bước đệm" quan trọng để các quý ông ghi lại dấu ấn riêng. Lịch lãm, sang trọng, cuốn hút, BST Man in Officity với những thiết kế đẳng cấp và thời thượng là người đồng hành giúp khơi dậy sự tự tin vốn có của những người đàn ông, vươn cao bản lĩnh để chạm tới đỉnh cao sự nghiệp.</p>
        </div>
        
    </div>
    
    <jsp:include page="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>
</body>

<script type="text/javascript">
	function chiTietSanPham(id) {
		window.location = "/chi-tiet-san-pham?id=" + id;
	}
</script>

</html>