<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <link href="/resources/css/header.css" rel="stylesheet" type="text/css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</head>
<body>
    <div class="navbar navbar-expand-lg navbar-light bg-light header-div" >
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <img class="logo-image" src="/resources/png/logo.jpg">

        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <a class="navbar-brand" style="font-size : 23px">  <spring:message code="text.websiteTitle"> </spring:message> </a>
            <div class="navbar-nav">
                <a href="/problemList?page=1" methods="GET" class="nav-item nav-link" id="problem-link"> <spring:message code="text.problem"> </spring:message> </a>
                <a href="/boardList" methods="GET" class="nav-item nav-link" id="board-link">  <spring:message code="text.board"> </spring:message> </a>
                <a href="/submissionList" methods="GET" class="nav-item nav-link" id="submission-link">  <spring:message code="text.submission"> </spring:message> </a>
                <a href="/rankingPage" methods="GET" class="nav-item nav-link" id="ranking-link">  <spring:message code="text.ranking"> </spring:message> </a>
            </div>
            <div class="navbar-nav">

                <sec:authorize access="isAnonymous()">
                    <a href="/login" methods="GET" class="nav-item nav-link" id="login-link">  <spring:message code="text.login"> </spring:message> </a>
                    <a href="/join" methods="GET" class="nav-item nav-link" id="join-link">   <spring:message code="text.join"> </spring:message> </a>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <a href="/profilePage" methods="GET" class="nav-item nav-link" id="profile-link">  <spring:message code="text.profile"> </spring:message> </a>
                    <sec:authorize access="hasRole('ADMIN')">
                        <a href="/problem-write" methods="GET" class="nav-item nav-link" id="login-link">  <spring:message code="text.problemWrite"> </spring:message> </a>
                    </sec:authorize>
                    <a href="/logout" methods="GET" class="nav-item nav-link" id="join-link"> <spring:message code="text.logout"> </spring:message> </a>
                </sec:authorize>


            </div>
        </div>
    </div>
</body>
</html>