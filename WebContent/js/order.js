function orderByPrice(){
	$.ajax({
		type: "get",
		url:"/Product/cont?cmd=price"
		}).done(function(products){
//			console.log(products);
			//alert("정렬 성공");
			$("#table__contents").empty();
			renderItem(products);
			$("#table__contents").val("");
			
			
		}).fail(function(error){
			alert("정렬 실패");
		});
	
}

function orderByCount(){
	$.ajax({
		type: "get",
		url:"/Product/cont?cmd=count"
		}).done(function(products){
			console.log(products);
			//alert("정렬 성공");
			$("#table__contents").empty();
			renderItem(products);
			$("#table__contents").val("");
			
			
		}).fail(function(error){
			alert("정렬 실패");
		});
	
}

function orderById(){
	$.ajax({
		type: "get",
		url:"/Product/cont?cmd=id"
		}).done(function(products){
//			console.log(products);
			//alert("정렬 성공");
			$("#table__contents").empty();
			renderItem(products);
			$("#table__contents").val("");
			
			
		}).fail(function(error){
			alert("정렬 실패");
		});
	
}

function deleteById(id){
	$.ajax({
		type: "post",
		url:"/Product/cont?cmd=delete",
		data: "id="+id,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType:"text"
		
		}).done(function(result){
//			console.log(products);
			if(result==1){
				alert("삭제 성공");
				var deleteItem=$(".table__content__"+id);
				deleteItem.remove();
			}
			
			
		}).fail(function(error){
			alert("삭제 실패");
		});
	
}

function renderItem(products){
	for (var product of products) {
		$("#table__contents").append(makeContent(product));
	}
}

function makeContent(product) {
	
	var productItem=`<tr class="table__content__${product.id }"> `; 
    productItem+=`<td>${product.id }</td>`;
    productItem+=`<td>${product.name }</td>`;
    productItem+=`<td>${product.type }</td>`;
    productItem+=`<td>${product.price }</td>`;
    productItem+=`<td>${product.count }</td>`;
    productItem+=`<td><button onclick="deleteById(${product.id})">삭제</button></td>`;
    productItem+=`</tr>`;
    
    return productItem;
}