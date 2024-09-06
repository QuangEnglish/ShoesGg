function AddToCart(_baseUrl, _productId, _quanlity, _size) {
	alert("Bạn đang chọn mua sản phẩm có ID = " + _productId + " với số lượng là " + _quanlity);
	// tạo javascript object để binding với data bên phía controller  
	var requestBody = {
		productId: _productId,
		quanlity: _quanlity,
		size: _size
	};
	
	// $ === jQuery
	// json == javascript object
	jQuery.ajax({
		url: _baseUrl + "/ajax/addToCart", //-> request mapping định nghĩa bên controller
		type: "post",					   //-> method type của Request Mapping	
		contentType: "application/json",   //-> nội dung gửi lên dạng json <=> javascript object
		data: JSON.stringify(requestBody), //-> chuyển 1 javascript object thành string json
	
		dataType: "json", 				   // kiểu dữ liệu trả về từ Controller
		success: function(jsonResult) {    // gọi ajax thành công
			alert(jsonResult.status + ", Số lượng trong giỏ hàng là: " + jsonResult.totalItems);
			$("#soluongsanphamtronggiohang").html(jsonResult.totalItems);
		},
		error: function(jqXhr, textStatus, errorMessage) { // gọi ajax thất bại
			alert("error");
		}
	});
}

function Tang(_baseUrl, _productId, _id, s){
	var soLuong =  document.getElementById(_id).innerHTML;
	soLuong = parseInt(soLuong) + 1;
	document.getElementById(_id).innerHTML = soLuong;
	TangGiamSanPham(_baseUrl, _productId, parseInt(soLuong), s);
}

function Giam(_baseUrl, _productId, _id, s){
	var soLuong =  document.getElementById(_id).innerHTML;
	soLuong = parseInt(soLuong) - 1;
	if(parseInt(soLuong) < 1){
		soLuong = 1;
	}
	document.getElementById(_id).innerHTML = soLuong;
	TangGiamSanPham(_baseUrl, _productId, parseInt(soLuong), s);
}

function TangGiamSanPham(_baseUrl, _productId, _quanlity, _size) {
	//alert("Bạn đang chọn mua sản phẩm có ID = " + _productId + " với số lượng là " + _quanlity);
	// tạo javascript object để binding với data bên phía controller  
	var requestBody = {
		productId: _productId,
		quanlity: _quanlity,
		size: _size
	};
	
	// $ === jQuery
	// json == javascript object
	jQuery.ajax({
		url: _baseUrl + "/ajax/tangGiamSanPham", //-> request mapping định nghĩa bên controller
		type: "post",					   //-> method type của Request Mapping	
		contentType: "application/json",   //-> nội dung gửi lên dạng json <=> javascript object
		data: JSON.stringify(requestBody), //-> chuyển 1 javascript object thành string json
	
		dataType: "json", 				   // kiểu dữ liệu trả về từ Controller
		success: function(jsonResult) {    // gọi ajax thành công
			window.location = '/gio-hang';
			//alert(jsonResult.status + ", Số lượng trong giỏ hàng là: " + jsonResult.totalItems);
			$("#soluongsanphamtronggiohang").html(jsonResult.totalItems);
		},
		error: function(jqXhr, textStatus, errorMessage) { // gọi ajax thất bại
			alert("error");
		}
	});
	
}


function XoaSanPham(_baseUrl, _productId) {
	//alert("Bạn đang chọn mua sản phẩm có ID = " + _productId + " với số lượng là " + _quanlity);
	// tạo javascript object để binding với data bên phía controller  
	var requestBody = {
		productId: _productId
	};
	
	// $ === jQuery
	// json == javascript object
	jQuery.ajax({
		url: _baseUrl + "/ajax/xoaSanPhamGH", //-> request mapping định nghĩa bên controller
		type: "post",					   //-> method type của Request Mapping	
		contentType: "application/json",   //-> nội dung gửi lên dạng json <=> javascript object
		data: JSON.stringify(requestBody), //-> chuyển 1 javascript object thành string json
	
		dataType: "json", 				   // kiểu dữ liệu trả về từ Controller
		success: function(jsonResult) {
			alert(jsonResult.message);    // gọi ajax thành công
			window.location = '/gio-hang';
			//alert(jsonResult.status + ", Số lượng trong giỏ hàng là: " + jsonResult.totalItems);
			$("#soluongsanphamtronggiohang").html(jsonResult.totalItems);
		},
		error: function(jqXhr, textStatus, errorMessage) { // gọi ajax thất bại
			alert("error");
		}
	});
}