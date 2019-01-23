/**
 * 
 */

function check() {
	
	var id = document.getElementById("id").value
	var name = document.getElementById("name").value
	var detail = document.getElementById("detail").value
	var price = document.getElementById("price").value

	if(id == "" || name == "" || detail == "" || price == ""){
		alert("입력되지 않은 항목이 있습니다.")
	}else{
		document.getElementById("form").submit();
	}
}
