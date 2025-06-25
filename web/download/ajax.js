function ajax() {
	var xhr = new XMLHttpRequest(); //第一步  
	//post方式  
	xhr.open('POST', '/download'); //第二步骤  

	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	//发送请求
	xhr.send(`fileId=` + $('#fileId').val() + `&password=` + $("#password").val());
	//发送请求  
	//ajax返回  
	xhr.onreadystatechange = function() { //第四步
		// alert(xhr.responseText);
		// console.log(xhr.responseText);
		if (xhr.readyState == 4 && xhr.status == 200 && xhr.responseText != "") {
			$("#result").val(xhr.responseText);
		} else {
			$("#result").val("Download Error.");
		}
	};
	//设置超时时间  
	/*    xhr.timeout = 10000;  
	    xhr.ontimeout = function(event){  
	　　　　alert('请求超时！');  
	　　}
	*/
}
