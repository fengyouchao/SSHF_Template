<#include "/common/struts2Tags.ftl" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件</title>

<script type="text/javascript">

function addMore()
{

	var td = document.getElementById("more");
	
	var br = document.createElement("br");
	var input = document.createElement("input");
	var button = document.createElement("input");
	
	input.type = "file";
	input.name = "upload";
	
	button.type = "button";
	button.value = "删除";
	
	button.onclick = function(){
		td.removeChild(br);
		td.removeChild(input);
		td.removeChild(button);
	};
	td.appendChild(br);
	td.appendChild(input);
	td.appendChild(button);
}

</script>
</head>
<body>
	<center><h1>上传文件</h1></center>
	<@s.form action="fileUpload.action" theme="simple" method="post"
		enctype="multipart/form-data">

		<table align="center" width="50%" border="1">
			<tr>
				<td>上传文件</td>
				<td id="more"><@s.file name="upload"></@s.file> <input
					type="button" value="添加" onclick="addMore()"></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交" /></td>
				<td><input type="reset" value="重置" /></td>
			</tr>

		</table>

	</@s.form>
</body>
</html>