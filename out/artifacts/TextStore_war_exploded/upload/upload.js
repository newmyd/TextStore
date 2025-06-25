function upload() {
	if (txt.value == '') {
		$("#result").text("Error: Text is empty.");
		return false;
	}
	ajax();
	return false;
}
