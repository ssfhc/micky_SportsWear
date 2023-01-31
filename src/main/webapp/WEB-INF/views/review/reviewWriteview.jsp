<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>reviewWriteview</h3>
<form action="reviewWrite" method="post" enctype="multipart/form-data">
	<table>
		<!-- <tr>
			<td class="left">작성자</td>
			<td><input type="text" name="m_id" value="temp" /></td>
		</tr> -->
		<tr>
			<td class="left">제목</td>
			<td><input type="text" name="r_title" /></td>
		</tr>
		<tr>
			<td class="left">파일첨부</td>
			<td><input type="file" name="r_filesrc" /></td>
		</tr>
		<tr>
			<td class="left">내용</td>
			<td><textarea name="r_content" rows="10"></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="입력" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>