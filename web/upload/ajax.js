function ajax() {
	var xhr = new XMLHttpRequest(); //第一步  
	//新建一个FormData对象  
	// var formData = new FormData(); //++++++++++  
	// //追加文件数据  
	// formData.append('text', txt.value);
	// formData.append('password', $("#password").val());
	//post方式  
	xhr.open('POST', '/upload'); //第二步骤  

	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
	//发送请求
	var str = txt.value;
	for (var i = 0; i < str.length; ++i)
		if (str[i] == '%') str = str.slice(0, i + 1) + "25" + str.slice(i + 1), i += 2;
		else if (str[i] == '&') str = str.slice(0, i) + "%26" + str.slice(i + 1), i += 2;
		else if (str[i] == '+') str = str.slice(0, i) + "%2B" + str.slice(i + 1), i += 2;

	xhr.send(`text=` + str + `&password=` + $("#password").val());
	//ajax返回  
	xhr.onreadystatechange = function() { //第四步
		// alert(xhr.responseText);
		// console.log(xhr.responseText);
		if (xhr.readyState == 4 && xhr.status == 200 && xhr.responseText != 0) {
			$("#result").text("Success. Text Id : " + xhr.responseText);
		} else {
			$("#result").text("Upload Error.");
		}
	};
	//设置超时时间  
	/*    xhr.timeout = 10000;  
	    xhr.ontimeout = function(event){  
	　　　　alert('请求超时！');  
	　　}
	*/
}
