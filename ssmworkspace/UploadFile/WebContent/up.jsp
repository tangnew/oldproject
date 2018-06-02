<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script>
    var fileName = "<%=request.getParameter("fileName")%>";
	if (fileName) {
		var img = parent.document.getElementById("myImg");
		img.src = "http://128.160.184.82:8081/imgs/imgs/" + fileName;
	}
</script>
<form id="form" method="post" action="/UploadFile/up"
	enctype="multipart/form-data">
	<input id="imgFile" type="file" name="fileName" accept="image/*" />
</form>
<script>
	var file = document.getElementById("imgFile");
	var form = document.getElementById("form");
	file.onchange = function() {
		form.submit();
	}
</script>
