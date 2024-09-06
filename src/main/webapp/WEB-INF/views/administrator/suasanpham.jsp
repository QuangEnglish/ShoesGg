<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
    <link rel="stylesheet" href="${base }/css/themsanpham_admin.css">
    <link rel="stylesheet" href="${base }/css/menu.css">
    <title>Document</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/administrator/layout/menu.jsp"></jsp:include>

   
   <sf:form modelAttribute="sanPham" action="${base }/admin/sua-san-pham-spring" method="post" enctype="multipart/form-data">
   	<div class="content-them">
   <h1>Thêm sản phẩm</h1>
   <div id="upanh">
    <p><img src="${base }/image/${sanPham.hinhAnh}" alt="" class="hienthianh"></p>
    <p><input type="file" name="anhSanPham" id="" class="chonanh"></p>
   </div>

   <div class="content-body">
        <p>Tên sản phẩm <br>
        <sf:input path="tenSanPham" type="text" name="tensp" id=""></sf:input>
        </p>
        <p>Màu sắc <br>
        <sf:input path="mauSac" type="text" name="mausac" id="" ></sf:input>
        </p>
        
        <p>Size <br>
            <sf:input path="size" type="text" name="size" id="" ></sf:input>
        </p>
        <p>Số lượng <br>
            <sf:input path="soLuong" type="text" name="soluong" id=""></sf:input>
        </p>
        <p>Đơn giá <br>
            <sf:input path="gia" type="text" name="dongia" id=""></sf:input>
        </p>
        
        <%-- <p> Danh mục sản phẩm <br>
            <select class="chonloaisp" id="chon" onchange="ThayDoi()">
            	<option>-------</option>
            	<c:forEach items="${danhBac1s}" var="b1">
            		<option value="${b1 }">${b1.tenDanhMuc }</option>
            	</c:forEach>
                
                
            </select>
        </p> --%>
		
		
        <%-- <p> Loại sản phẩm <br>
            <select class="chonsp" id="chonloai">
                <c:forEach items="${danhBac1s}" var="b1">
            		<c:forEach items="${b1.listDanhMucSanPhamBac2}" var="b2">
            			<option value="${b2.id }">${b2.tenDanhMuc }</option>
            		</c:forEach>
            	</c:forEach>
            </select>
        </p>
         --%>
         <p>Loại sản phẩm</p>
         <sf:select path="danhMucSanPhamBac2.id">
         	<sf:options items="${danhMucSanPhamBac2 }" itemValue="id" itemLabel="tenDanhMuc"/>
         </sf:select>
         
        <p>Form dáng <br>
            <sf:input path="formDang" type="text" name="" id=""></sf:input>
        </p>
        <p>Phiên bản <br>
            <sf:textarea path="thietKe" name="" id="" cols="30" rows="10"></sf:textarea>
        </p>
        <p>Chất liệu <br>
            <sf:textarea path="chatLieu" name="" id="" cols="30" rows="10"></sf:textarea>
        </p>
        <p>
            <input type="submit" name="nutchon" class="nut" value="Thêm">
            <input type="submit" name="nutchon" class="nut" value="Hủy">
        </p>
        </div>
        </div>
   </sf:form>
        
    
</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
    var c = document.querySelector(".chonanh");
    var ht = document.querySelector(".hienthianh");
    c.addEventListener("change", () => {
        ht.src = URL.createObjectURL(c.files[0]);
    })
    
    function LoaiSP() {
		
	}
    
    
    
    function ThayDoi(){
		
		
	}
    
    function HienThi(arr) {
		for(let i = 0; i < arr.length; i++){
			alert(i);
		}
		
	}
    
    
    
</script>
</html>