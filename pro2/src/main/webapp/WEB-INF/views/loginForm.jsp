<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="/js/jquery-1.11.0.min.js"></script>

<script>
		$(function(){
			// 로그인 버튼 클릭하면 실행
			$(".loginBtn").click(function(){
				checkLoginForm();
			})
		})
		//-------------------------------------------------------------------------------------------
		//----------------------------------<함수>--------------------------------------------------
		//-------------------------------------------------------------------------------------------
		
		// 로그인, 암호 유효성체크
		function checkLoginForm(){
			//로그인 유효성
			var midObj = $("[name='mid']");
			var midVal = midObj.val();
			
			if( typeof(midVal)!="string"){midVal="";}
			
			if(midVal.split(" ").join("")==""){
				alert("아이디를 입력해 주십시오!");
				midObj.val("");
				midObj.focus();
				return;
			}
			if( midVal.indexOf(" ",0)==0){
				alert("아이디 앞에 공백이 들어있습니다!");
				midObj.val("");
				midObj.focus();
				return;
			}
			else if( midVal.substr(midVal.length-1,1)==" "){
				alert("아이디 뒤에 공백이 들어있습니다!");
				midObj.val("");
				midObj.focus();
				return;
			}
			else if( midVal.indexOf(" ",0)>0){
				alert("아이디 중간에 공백이 들어있습니다!");
				midObj.val("");
				midObj.focus();
				return;
			}
			//--------------------------------------------------
			//암호 유효성
			var pwdObj = $("[name='pwd']");
			var pwdVal = pwdObj.val();

			if( typeof(pwdVal)!="string"){pwdVal="";}

			if( pwdVal.split(" ").join("")=="" ){
				alert("암호를 입력해 주십시오!");
				pwdObj.val("");
				pwdObj.focus();
				return;
			}
			if( pwdVal.indexOf(" ",0)==0){
				alert("암호 앞에 공백이 들어있습니다!");
				pwdObj.val("");
				pwdObj.focus();
				return;
			}
			else if( pwdVal.substr(pwdVal.length-1,1)==" "){
				alert("암호 뒤에 공백이 들어있습니다!");
				pwdObj.val("");
				pwdObj.focus();
				return;
			}
			else if( pwdVal.indexOf(" ",0)>0){
				alert("암호 중간에 공백이 들어있습니다!");
				pwdObj.val("");
				pwdObj.focus();
				return;
			}
		}



</script>

</head>
<body>
	<center>
	
	<form name="loginForm" >
		
		<table border=1 cellpadding=10>
			<caption>로그인</caption>
			<tr><th>[아이디]<td><input type="text" name="mid">
			<tr><th>[암호]<td><input type="password" name="pwd">
		</table>
	
		<div style="height:5px"></div>
		
		<input type="button" value="로그인" class="loginBtn">
		
	</form>


</body>
</html>