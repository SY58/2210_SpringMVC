<%@page import="com.sy.spring04.gallery.dto.GalleryDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/gallery/list.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>갤러리 목록 보기</h1>
		<a href="${pageContext.request.contextPath }/gallery/uploadform">파일 업로드</a>
		<table class="table table-striped">
			<thead class="table-primary">
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>캡션</th>
					<th>이미지</th>					
					<th>등록일</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tmp" items="${list }">				
				<tr>
					<td>${tmp.num}</td>
					<td>${tmp.writer}</td>
					<td>${tmp.caption}</td>
					<td>
						<a href="${pageContext.request.contextPath }/resources/upload/${tmp.imagePath}" target="_blank">
						<img src="${pageContext.request.contextPath }/resources/upload/${tmp.imagePath}" width="100" height="100" />
						</a>
					</td>					
					<td>${tmp.regdate}</td>					
					<%-- 작성자 본인인 경우에만 노출되도록 --%>					
					<td>
					<c:if test="${tmp.writer == id}">
						<a href="${pageContext.request.contextPath}/gallery/delete?num=${tmp.num}">삭제</a>
					</c:if>										
					</td>
				</tr>
				</c:forEach>	

			</tbody>		
		</table>	
		<nav>
         <ul class="pagination">
            <%--
               startPageNum 이 1 이 아닌 경우에만 Prev 링크를 제공한다. 
               &condition=${condition}&keyword=${encodedK}
             --%>
            <c:if test="${startPageNum ne 1 }">
               <li class="page-item">
                  <a class="page-link" href="list?pageNum=${startPageNum-1 }&condition=${condition}&keyword=${encodedK}">Prev</a>
               </li>
            </c:if>
            <c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
               <li class="page-item ${pageNum eq i ? 'active' : '' }">
                  <a class="page-link" href="list?pageNum=${i }&condition=${condition}&keyword=${encodedK}">${i }</a>
               </li>
            </c:forEach>
            <%--
               마지막 페이지 번호가 전체 페이지의 갯수보다 작으면 Next 링크를 제공한다. 
             --%>
            <c:if test="${endPageNum lt totalPageCount }">
               <li class="page-item">
                  <a class="page-link" href="list?pageNum=${endPageNum+1 }&condition=${condition}&keyword=${encodedK}">Next</a>
               </li>
            </c:if>
         </ul>
      </nav>
      <!-- 검색 폼 -->
      <form action="list" method="get">
         <label for="condition">검색조건</label>   
         <select name="condition" id="condition">
            <option value="caption_filename" ${condition eq 'caption_imagePath' ? 'selected' : '' }>캡션 + 파일명</option>
            <option value="caption" ${condition eq 'caption' ? 'selected' : '' }>캡션</option>
            <option value="writer" ${condition eq 'writer' ? 'selected' : '' }>작성자</option>
         </select>
         <input type="text" name="keyword" placeholder="검색어..." value="${keyword }"/>
         <button type="submit">검색</button>
      </form>
      <c:if test="${not empty condition }">
         <p>
            <strong>${totalRow }</strong> 개의 자료가 검색 되었습니다.
            <a href="list">리셋</a>
         </p>
      </c:if>
   </div>
   <script>
      function deleteConfirm(num){
         let isDelete=confirm("삭제 하시겠습니까?");
         if(isDelete){
            location.href="delete?num="+num;
         }
      }
   </script>

</body>
</html>