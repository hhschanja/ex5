<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<form action="" method="post" id="frm">

<p>아이디: <input type="text" name="id"></p>
<p>비밀번호: <input type="text" name="pw"></p>
<p>학생<input type="radio" class="grade" name="grade" value="student" checked="checked"> &ensp; 교사<input type="radio" class="grade" name="grade" value="teacher"></p>
<button id="btn">로그인</button>
</form>

</body>
<script type="text/javascript">

$('#btn').click(function() {
	
	var path='';
	
	$('.grade').each(function() { //반복문을 돌려봐서
		if($(this).prop('checked')){ //만약 트루인놈이 있다면  (체크가 됐다면 트루인거지)
			path=$(this).val()+"Login"; //그놈의 value값 + Join을 path로
		}
	});
	
	$('#frm').attr("action",path); //그 path를 action의 속성 값으로 추가
	$('#frm').submit();
	
});

</script>
</html>