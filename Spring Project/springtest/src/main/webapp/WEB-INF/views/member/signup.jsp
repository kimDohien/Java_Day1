<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<style>
label.error{color:red;}
</style>

<h1>회원가입</h1>
<form action="<c:url value='/signup'></c:url>" method="post">
	<div class="form-group">
		<label for="id">아이디:</label> <input type="text" class="form-control"
			id="id" name="me_id">
	</div>
	<button class="btn btn-outline-success col-12" type="button" onclick="alert('추후구현')">아이디 중복체크</button>
	<div class="form-group">
		<label for="pw">비번:</label> <input type="password"
			class="form-control" id="pw" name="me_pw">
	</div>
	<div class="form-group">
		<label for="pw2">비번확인:</label> <input type="password"
			class="form-control" id="pw2" name="me_pw2">
	</div>
	<div class="form-group">
		<label for="email">이메일:</label> <input type="text"
			class="form-control" id="email" name="me_email">
	</div>
	<div class="form-group">
		<label for="birthday">생일:</label> <input type="text"
			class="form-control" id="birthday" name="me_birthday" placeholder="yyyy-mm-dd">
	</div>
	<button class="btn btn-outline-success col-12">회원가입</button>
</form>

<script	src="<c:url value='/resources/js/jquery.validate.min.js'></c:url>"></script>
<script	src="<c:url value='/resources/js/additional-methods.min.js'></c:url>"></script>

<script>
	$('form').validate({
		rules : { //유효성검사
			me_id : {
				required : true,
				regex : /^[a-zA-Z][a-zA-Z0-9!@#$]{4,12}/
			},
			me_pw : {
				required : true,
				regex : /^[a-zA-Z0-9!@#$]{8,20}/
			},
			me_pw2 : {
				equalTo : pw
			//equalTo에 들어가는것은 id이다. name아님.
			},
			me_email : {
				required : true,
				email : true
			},
			me_birthday : {
				required : true,
				regex : /^\d{4}-(0\d|10|11|12)-(0\d|1\d|2\d|30|31)$/
			}
		},
		messages : { //유효성검사하고 메시지
			me_id : {
				required : '필수항목 입니다',
				regex : '아이디는 영문자로 시작하며, 영문, 숫자, !@#$를 이용하여 5-13자 까지 가능합니다'
			},
			me_pw : {
				required : '필수항목 입니다',
				regex : '아이디는 영문, 숫자, !@#$를 이용하여 8-20자 까지 가능합니다'
			},
			me_pw2 : {
				equalTo : '비밀번호가 일치하지 않습니다'
			},
			me_email : {
				required : '필수항목 입니다',
				email : '이메일 형식이 아닙니다'
			},
			me_birthday : {
				required : '필수항목 입니다',
				date : '날짜가 형식이 아닙니다'
			}
		}
	});
	$.validator.addMethod("regex", function(value, element, regexp) {
		var re = new RegExp(regexp);
		return this.optional(element) || re.test(value);
	}, "Please check your input.");
	

</script>