<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="../api/fullcalendar-3.9.0/lib/jquery.min.js"></script>
<script>
$(document).ready(function(){    $('#content').load('<%=request.getContextPath()%>/calcontroller/test');});

</script>
<link href="../api/fullcalendar-3.9.0/fullcalendar.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}
</style>
<!-- content -->
<div class="w3-container bgimg-1" style="padding:128px 16px; " id="about">
  
  
<div class="w3-section w3-row-padding">
<div class="w3-third w3-container " >
   
      <div class="w3-container w3-white">
      <h6>실시간 토론</h6>
      </div>
     <div class="w3-card-4">
  <!--  대화내용 div  -->
      <div class="w3-container" style="height:500px; overflow:auto; background: rgba(241, 241, 241, 0.75); ">
         <ul class="w3-ul"  >
   
   <!--  다른 사람 대화  -->
   <li class="w3-large" style="border:none; width: 70%;"><i class="material-icons w3-xlarge">person</i> person1
    <span class="w3-small ">오전 11:28</span>
    <div class="w3-panel w3-round-large w3-padding " style="margin:0; background: rgba(0, 150, 136, 0.75);">
    <span class="w3-medium"><font color="white">sdgsdgsdsgd<br>sdgsdgsdgwwewㅋㅋㅋ</font></span>
  </div></li>
  <!-- 다른 사람 대화 끝 -->
  
     <!--  다른 사람 대화  -->
    <li class="w3-large" style="border:none;  width: 70%;"><i class="material-icons w3-xlarge">person</i> person1
     <span class="w3-small ">오전 11:28</span>
    <div class="w3-panel w3-round-large w3-padding " style="margin:0; background: rgba(0, 150, 136, 0.75);">
    <span class="w3-medium "><font color="white">sdgsㄴㅇㅎㄴㅇㅎㄴㅇㅎdgsdsgd..??</font></span>
  </div></li>
    <!-- 다른 사람 대화 끝 -->
  
  <!-- 내 대화  -->
   <li class="w3-large" style="border:none; " align="right">
     <span class="w3-small ">오전 11:28</span><br>
    <div class="w3-panel w3-round-large w3-padding w3-right"   style="margin:0; width: 70%; background: rgba(255, 193, 7, 0.75); ">
    <span class="w3-medium " >sdgsㄴㅇㅎㄴㅇㅎㄴㅇㅎdgsdsgd..??</span>
  </div></li>
  <br>
    <!--  내 대화 끝 --> 
    
    
      <!--  다른 사람 대화  -->
    <li class="w3-large" style="border:none;  width: 70%;"><i class="material-icons w3-xlarge">person</i> person1
     <span class="w3-small ">오전 11:28</span>
    <div class="w3-panel w3-round-large w3-padding " style="margin:0; background: rgba(0, 150, 136, 0.75);">
    <span class="w3-medium "><font color="white">sdgsㄴㅇㅎㄴㅇㅎㄴㅇㅎdgsdsgd..??</font></span>
  </div></li>
    <!-- 다른 사람 대화 끝 -->
    
         <!--  다른 사람 대화  -->
    <li class="w3-large" style="border:none;  width: 70%;"><i class="material-icons w3-xlarge">person</i> person1
     <span class="w3-small ">오전 11:28</span>
    <div class="w3-panel w3-round-large w3-padding " style="margin:0; background: rgba(0, 150, 136, 0.75);">
    <span class="w3-medium "><font color="white">sdgsㄴㅇㅎㄴㅇㅎㄴㅇㅎdgsdsgd..??</font></span>
  </div></li>
    <!-- 다른 사람 대화 끝 -->
  
  <!-- 내 대화  -->
   <li class="w3-large" style="border:none; " align="right">
     <span class="w3-small ">오전 11:28</span><br>
    <div class="w3-panel w3-round-large w3-padding w3-right"   style="margin:0; width: 70%; background: rgba(255, 193, 7, 0.75); ">
    <span class="w3-medium " >sdgsㄴㅇㅎㄴㅇㅎㄴㅇㅎdgsdsgd..??</span>
  </div></li>
  <br>
    <!--  내 대화 끝 --> 
    
  
    <!--  다른 사람 대화  -->
   <li class="w3-large" style="border:none; width: 70%;"><i class="material-icons w3-xlarge">person</i> person1
    <span class="w3-small ">오전 11:28</span>
    <div class="w3-panel w3-round-large w3-padding " style="margin:0; background: rgba(0, 150, 136, 0.75);">
    <span class="w3-medium"><font color="white">sdgsdgsdsgd<br>sdgsdgsdgwwewㅋㅋㅋ</font></span>
  </div></li>
  <!-- 다른 사람 대화 끝 -->
  
    <!--  다른 사람 대화  -->
   <li class="w3-large" style="border:none; width: 70%;"><i class="material-icons w3-xlarge">person</i> person1
    <span class="w3-small ">오전 11:28</span>
    <div class="w3-panel w3-round-large w3-padding " style="margin:0; background: rgba(0, 150, 136, 0.75);">
    <span class="w3-medium"><font color="white">sdgsdgsdsgd<br>sdgsdgsdgwwewㅋㅋㅋ</font></span>
  </div></li>
  <!-- 다른 사람 대화 끝 -->
  
  <br>
  
    
 </ul>
     <br>
      </div>
      
<!-- 전송창부분   -->    
      <div class="w3-container w3-white w3-padding">
     
      <div class="w3-panel w3-round-large w3-border w3-padding w3-margin-left" >
  
  <table style="width: 100%;"><tr><td style="width: 90%;">
  
  <textarea class="w3-input"  style="border:0; display: inline-block;">sdgsdg</textarea> </td><td>
  	<button class="w3-button  w3-teal">전송</button></td>
  </table>
   </div>
   
  </div>
  
  <!-- 전송창부분 끝 -->

    
  
      </div>
    </div>


  <div class="w3-twothird w3-container ">
  <div class="w3-container w3-white">
      
       <h6>사진 모아보기</h6>
      </div>
    <div class="w3-card-4">
      
      <!-- 내용 div -->
      <div class="w3-container " id="content" style=" background: rgba(241, 241, 241, 1); ">
 
 



      </div>
      
      <!-- 내용끝 -->
      
      <div class="w3-container w3-light-grey ">
      <span class="w3-right w3-margin-right"><p>스터디 관리</p></span><span class="w3-right w3-margin-right"><p>스터디 정보</p></span> 
      
      </div>
    </div>
  </div>
  
  
</div>
</div>
</html>