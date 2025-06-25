function download() {
	if (document.getElementById("fileId").value == "") {
		$("#result").val("Error: Text Id is empty.");
		return ;
	}
	ajax();
	return true;
}