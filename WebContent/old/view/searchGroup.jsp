<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- content -->
<div class="bgimg-1 w3-display-container w3-grayscale-min" id="home">
	<br> <br> <br> <br>
	<!--개설된 방  검색 결과 추가 -->
	<div class="w3-cell-row">
		<div class="w3-third"></div>
		<div class="w3-container w3-cell" style="width: 60%">
			<c:forEach var="room" items="${room}">
				<ul class="w3-ul w3-card-4 w3-light-grey">
					<li class="w3-bar"><span
						onclick="this.parentElement.style.display='none'"
						class="w3-bar-item w3-button w3-white w3-xlarge w3-right">×</span>
						
						<!--그룹 프로필  -->
						<c:if test="${room.study_pro==null }">
						<img src="<%=request.getContextPath()%>/imgs/groupProfile_default.jpg"
							class="w3-bar-item w3-circle w3-hide-small" style="width: 85px"> 
						</c:if>
						<c:if test="${room.study_pro!=null }">
						<img src="<%=request.getContextPath()%>/fileSave/${room.study_pro}"
							class="w3-bar-item w3-circle w3-hide-small" style="width: 85px"> 
						</c:if>
						
						
						<div class="w3-bar-item">
							<span class="w3-large">Mike</span><br> <span>Web
								Designer</span>
						</div></li>
					</ul>
			</c:forEach>
		</div>
		<div class="w3-third"></div>
	</div>

	<%-- <div class="w3-card w3-light-grey w3-round w3-margin"
			style="width: 50%;height:100%">
			
			<!--그룹 프로필  -->
			<c:if test="${room.study_pro==null }">
			<img src="<%=request.getContextPath()%>/imgs/groupProfile_default.jpg"
				class="w3-round" style="height: 80px; width: 80px"> 
			</c:if>
			<c:if test="${room.study_pro!=null }">
			<img src="<%=request.getContextPath()%>/fileSave/${room.study_pro}"
				class="w3-round" style="height: 80px; width: 80px"> 
			</c:if>
			
				<span
				class="w3-large w3-text-black w3-margin-right">${room.studyName}
				${room.study_intro}</span>
 				<c:if test="${status==null}">
				<form action="requestJoin" class="w3-right">
				<input type="hidden" name="reqNum" value="1"/>
				<input type="hidden" name="correctName" value="${room.studyName}"/>
				<input class="w3-button w3-blue w3-round " type="submit" value="가입"/>
				</form>
				</c:if> 
				
				<c:if test="${status==1}">
				<form action="cancelJoin" class="w3-right">
				<input type="hidden" name="delNum" value="1"/>
				<input type="hidden" name="correctName" value="${room.studyName}"/>
				<input class="w3-button w3-red w3-round " type="submit" value="취소"/>
				</form>
				</c:if> 


		</div> --%>

	<div class="w3-display-bottomleft w3-text-grey w3-large"
		style="padding: 24px 48px">
		<i class="fa fa-facebook-official w3-hover-opacity"></i> <i
			class="fa fa-instagram w3-hover-opacity"></i> <i
			class="fa fa-snapchat w3-hover-opacity"></i> <i
			class="fa fa-pinterest-p w3-hover-opacity"></i> <i
			class="fa fa-twitter w3-hover-opacity"></i> <i
			class="fa fa-linkedin w3-hover-opacity"></i>
	</div>
</div>


</html>