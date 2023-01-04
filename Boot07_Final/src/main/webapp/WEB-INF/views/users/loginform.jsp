<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/views/users/loginform.jsp</title>
<!-- bootstrap css 로딩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<!-- custom css -->
<style>
   	html,
	body {
	  height: 100%;
	}
	
	body {
	  display: flex;
	  align-items: center;
	  padding-top: 40px;
	  padding-bottom: 40px;
	  background-color: #f5f5f5;
	}
	
	.form-signin {
	  max-width: 330px;
	  padding: 15px;
	}
	
	.form-signin .form-floating:focus-within {
	  z-index: 2;
	}
	
	.form-signin input[type="email"] {
	  margin-bottom: -1px;
	  border-bottom-right-radius: 0;
	  border-bottom-left-radius: 0;
	}
	
	.form-signin input[type="password"] {
	  margin-bottom: 10px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
    
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }
    </style>
    <link href="sign-in.css" rel="stylesheet">
</head>
<body class="text-center">
<main class="form-signin w-100 m-auto">
	<form action="${pageContext.request.contextPath}/users/login" method="post">
      <c:choose>
         <c:when test="${ empty param.url }">
            <input type="hidden" name="url" value="${pageContext.request.contextPath}/"/>
         </c:when>
         <c:otherwise>
            <input type="hidden" name="url" value="${param.url }"/>
         </c:otherwise>
      </c:choose>
       
      <h1 class="h3 mb-3 fw-normal">로그인 폼</h1>
   
      <div class="form-floating">
         <input name="id" value="${cookie.savedId.value }" type="text" class="form-control" id="floatingInput" placeholder="아이디 입력...">
         <label for="floatingInput">아이디</label>
      </div>
      <div class="form-floating">
         <input name="pwd" value="${cookie.savedPwd.value }" type="password" class="form-control" id="floatingPassword" placeholder="비밀번호 입력...">
         <label for="floatingPassword">비밀번호</label>
      </div>
   
      <div class="checkbox mb-3">
         <label>
         	<!-- 체크박스를 체크하지 않으면 isSave라는 파라미터 값으로 넘어오는 문자열이 null이고 
         		체크를 하면 isSave라는 파라미터 값으로 넘어오는 문자열은 "yes"dlek.-->
           <input name="isSave" type="checkbox" value="yes" ${empty cookie.savedId ? '' : 'checked' }>로그인 정보 저장
         </label>
      </div>
      <button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2017–2022</p>
	</form>
   </main>


<!-- 
   <div class="container">
      <h1 class="h3 mb-3 fw-normal">로그인 폼</h1>
      
      <main class="form-signin w-100 m-auto">
	      <form action="${pageContext.request.contextPath}/users/login" method="post">
	         <c:choose>
	            <c:when test="${ empty param.url }">
	               <input type="hidden" name="url" value="${pageContext.request.contextPath}/"/>
	            </c:when>
	            <c:otherwise>
	               <input type="hidden" name="url" value="${param.url }"/>
	            </c:otherwise>
	         </c:choose>
	         <div class="form-floating">	            
	            <input class="form-control" type="text" name="id" id="id" placeholder="아이디 입력..."/>
	            <label class="form-floating" for="id">아이디</label>
	         </div>
	         <div class="form-floating">	            
	            <input class="form-control" type="password" name="pwd" id="pwd" placeholder="비밀번호 입력..."/>
	            <label class="form-floating" for="pwd">비밀번호</label>
	         </div>
	         
	         <div class="checkbox mb-3">
			    <label>
			       <input type="checkbox" id="checkId" value="remember-me"> Remember me
			    </label>
			 </div>
	         <button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
	      </form>
      </main>
   </div>
-->

</body>
</html>