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
    <link rel="stylesheet" href="${base}/css/sanpham2.css">
    <link rel="stylesheet" href="${base}/css/header1.css">
    <link rel="stylesheet" href="${base }/icon/themify-icons/themify-icons.css">
    <link rel="stylesheet" href="${base }/css/simplePagination.css">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>Sản phẩm</title>
</head>
<body>

	<div id="tenloaiao">
        <form action="${base }/san-pham" method="get">\
        	<input type="text" name="tenloai" value="${tenDM1 }" style="display: block;">
        	<c:forEach items="${danhmucb2 }" var="dm">
	        <div class="loaiao">
	        	
	            <input type="submit" value="${dm.tenDanhMuc}" name="tendm">
	        </div>
        </c:forEach>
        </form>
<%--        <div class="sapxep">--%>
<%--            <p>Sắp xếp</p>--%>
<%--            <i class="ti-list"></i>--%>
<%--            <div class="clear"></div>--%>
<%--        </div>--%>
    </div>

    <div class="clear"></div>

    <div id="noidung"  style="width: 90%; margin: 0 auto">
    	
    	<div id="loaisanpham" class="wrapper-item">

            <c:set var="counter" value="0"/>
            <c:forEach items="${sanPhams.data}" var="sp">
                <c:if test="${sp.status == 1}">
                    <c:if test="${counter % 4 == 0}">
                        <div class="row">
                    </c:if>

                    <div class="sanpham" onclick="ChiTietSanPham('${sp.id}')">
                        <img src="${base}/image/${sp.hinhAnh}" alt="">
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
	        <div class="clear"></div>
        <!-- <div id="loaisanpham">
            <p class="tenloai">ÁO SƠ MI</p>
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
        <div class="clear"></div>
        <div id="loaisanpham">
            <p class="tenloai">ÁO POLO</p>
                <div class="sanpham">
                    <img src="./image/aopolo1.png" alt="">
                    <p class="tensp">Áo polo golf dài tay Aristino ALPG02W2</p>
                    <p class="gia">1.650.000đ</p>
                </div>
                <div class="sanpham">
                    <img src="./image/aopolo2.png" alt="">
                    <p class="tensp">Áo polo nam Aristino Boss 1PS018S2</p>
                    <p class="gia">1.300.000đ</p>
                </div>
                <div class="sanpham">
                    <img src="./image/aopolo3.png" alt="">
                    <p class="tensp">Áo polo nam Aristino Boss 1PS040S2</p>
                    <p class="gia">950.000đ</p>
                </div>
                <div class="sanpham">
                    <img src="./image/aopolo4.png" alt="">
                    <p class="tensp">Áo polo nam Aristino APS196S2</p>
                    <p class="gia">650.000đ</p>
                </div>
           
        </div>
        <div class="clear"></div>
    
        <div id="loaisanpham">
            <p class="tenloai">QUẦN ÂU</p>
                <div class="sanpham">
                    <img src="./image/quanau1.png" alt="">
                    <p class="tensp">Quần âu Aristino ATR03402 màu đen</p>
                    <p class="gia">950.000đ</p>
                </div>
                <div class="sanpham">
                    <img src="./image/quanau2.png" alt="">
                    <p class="tensp">Quần âu nam Aristino Boss 1TR00502 màu đen</p>
                    <p class="gia">1.800.000đ</p>
                </div>
                <div class="sanpham">
                    <img src="./image/quanau3.png" alt="">
                    <p class="tensp">Quần Khaki Aristino Boss 1KK00402</p>
                    <p class="gia">1.450.000đ</p>
                </div>
                <div class="sanpham">
                    <img src="./image/quanau4.png" alt="">
                    <p class="tensp">Quần âu nam Aristino ATR04202</p>
                    <p class="gia">895.000đ</p>
                </div>
            
        </div>
        <div class="clear"></div>
    
        <div id="loaisanpham">
            <p class="tenloai">QUẦN JEANS</p>
                <div class="sanpham">
                    <img src="./image/quanjean1.png" alt="">
                    <p class="tensp">Quần jeans Aristino AJNR04</p>
                    <p class="gia">895.000đ</p>
                </div>
                <div class="sanpham">
                    <img src="./image/quanjean2.png" alt="">
                    <p class="tensp">Quần jeans nam Aristino AJNR03</p>
                    <p class="gia">895.000đ</p>
                </div>
                <div class="sanpham">
                    <img src="./image/quanjean3.png" alt="">
                    <p class="tensp">Quần jeans nam Aristino AJN02702</p>
                    <p class="gia">795.000đ</p>
                </div>
                <div class="sanpham">
                    <img src="./image/quanjean4.png" alt="">
                    <p class="tensp">Quần jeans nam Aristino AJN03402</p>
                    <p class="gia">795.000đ</p>
                </div>
           
        </div>
        <div class="clear"></div>
     -->
    </div>
    
    <div class="phantrang">
        <form action="${base }/san-pham" method="post">
        	<input type="submit" name="sotrang" id="sotrang" value="" style="display: none;">
        </form>
        <div id="paging"></div>
    </div>


   
    <jsp:include page="/WEB-INF/views/customer/layout/footer.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/customer/layout/header.jsp"></jsp:include>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    
</body>
</html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<script src="${base }/js/jquery.simplePagination.js"></script>

<script type="text/javascript">

	function ChiTietSanPham(id) {
		window.location = "/chi-tiet-san-pham?id="+id;
	}
	
	
	$(document).ready(function() {
		$("#paging").pagination({
			currentPage: ${sanPhams.currentPage},
	        items: ${sanPhams.totalItems},
	        itemsOnPage: ${sanPhams.sizeOfPage},
	        cssStyle: 'light-theme',
	        onPageClick: function(pageNumber, event) {
				$('#sotrang').val(pageNumber);
				$('#sotrang').trigger('click');
			}
	    });
	})
	
</script>
