<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
<style type="text/css">

#here1{

visibility: visible;

}

#here2{

visibility: visible;

}

</style>
</head>
<body>
<form action="" id="frm" method="post" enctype="multipart/form-data">
<div>
<p>학생<input type="radio" class="grade" name="grade" value="student" checked="checked"></p>
<p>교사<input type="radio" class="grade" name="grade" value="teacher"></p>
</div>

<!-- 공통 입력사항 -->
<div>
<p>아이디:<input type="text" name="id"></p>
<p>비밀번호:<input type="password" name="pw"></p>
<p>이름:<input type="text" name="name"></p>
<p>연령:<input type="number" name="age"></p>
<p>파일이름<input type="file" name="f1"></p>

</div>

<div id="here">
<p>전화번호:<input type="text" name="phone"></p>
<p>선생번호:<input type="text" name="tid"></p>
</div>


<button id="btn">버튼</button>
</form>
</body>
<script type="text/javascript">
	

		$('#btn').click(function() {
			
			var path='';
			
			$('.grade').each(function() { //반복문을 돌려봐서
				if($(this).prop('checked')){ //만약 트루인놈이 있다면  (체크가 됐다면 트루인거지)
					path=$(this).val()+"Join"; //그놈의 value값 + Join을 path로
				}
			});
			
			$('#frm').attr("action",path); //그 path를 action의 속성 값으로 추가
			$('#frm').submit();
			
		});

	

	$('.grade').click(function() {
		
		var v = $(this).attr('value');
		
		if(v=='student'){
			$('#here').html('<p>전화번호:<input type="text" name="phone"></p><p>선생번호:<input type="text" name="tid"></p>'); 
		}else{
			$('#here').html('<p>과목:<input type="text" name="subject"></p><p>입사일:<input type="date" name="hiredate"></p>');
		}
			
	})
	
	
</script>
</html>