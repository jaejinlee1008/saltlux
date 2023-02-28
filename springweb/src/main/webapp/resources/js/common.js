
function myFunc(){
	
	let url=$("#myForm>select>option:selected").text();
	
	$("#myForm").attr("action",url);
	
}