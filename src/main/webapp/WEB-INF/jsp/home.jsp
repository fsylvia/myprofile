<!DOCTYPE html>
<html lang="en">


<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Resume</title>
<link rel='stylesheet' href='/webjars/bootstrap/css/bootstrap.min.css'>
<link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:500,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Muli:400,400i,800,800i" rel="stylesheet">
<link href="/webjars/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link rel='stylesheet' href='/css/styles.css'>
<script src="https://d3js.org/d3.v4.min.js"></script>
<script>
var skillJson = eval('('+'${skill}'+')'); 

</script>
</head>
<body id="page-top">

  <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
    <a class="navbar-brand js-scroll-trigger" href="#page-top">
      <span class="d-block d-lg-none">${profile.personal.name }</span>
      <span class="d-none d-lg-block">
        <img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="images/profile.jpg" alt="">
      </span>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="#about">About</a>
        </li>
        <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="#experience">Experience</a>
        </li>
        <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="#education">Education</a>
        </li>
        <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="#skills">Skills</a>
        </li>
        <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="#interests">Interests</a>
        </li>
        <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="#awards">Awards</a>
        </li>
      </ul>
    </div>
  </nav>

  <div class="container-fluid p-0">

    <section class="resume-section p-3 p-lg-5 d-flex align-items-center" id="about">
      <div class="w-100">
        <h1 class="mb-0">${profile.personal.name}</h1>
        <h3 class="mb-0">${profile.personal.title }</h3>
        <div class="subheading mb-5">${profile.personal.location } | ${profile.personal.contactNo} | 
          <a href="mailto:name@email.com">${profile.personal.email }</a>
        </div>
        <div>${profile.personal.visa }</div>
        <p class="lead mb-5">${profile.personal.pitch }</p>
        <div class="social-icons">
          <a href="#">
            <i class="fab fa-linkedin"></i>
          </a>
          <a href="#">
            <i class="fab fa-github"></i>
          </a>
        </div>
      </div>
    </section>

    <hr class="m-0">

    <section class="resume-section p-3 p-lg-5 d-flex justify-content-center" id="experience">
      <div class="w-100">
        <h2 class="mb-5">Experience</h2>

        <c:forEach items="${profile.company}" var="experience">
        <div class="resume-item d-flex flex-column flex-md-row justify-content-between mb-5">
          <div class="resume-content">
            <h3 class="mb-0"><c:out value="${experience.name} "/></h3>
            <div class="subheading mb-3">${experience.getDesignation()}</div>
            <p>${experience.responsibilities}</p>
          </div>
          <div class="resume-date text-md-right">
            <span class="text-primary">${experience.from} - ${experience.to}</span>
          </div>
        </div>
        </c:forEach>
        
      </div>
    </section>

    <hr class="m-0">

    <section class="resume-section p-3 p-lg-5 d-flex align-items-center" id="education">
      <div class="w-100">
        <h2 class="mb-5">Education</h2>
		<c:forEach items="${profile.education}" var="education">
        <div class="resume-item d-flex flex-column flex-md-row justify-content-between mb-5">
          <div class="resume-content">
            <h3 class="mb-0">${education.name}</h3>
            <div class="subheading mb-3">${education.degree} </div>
            <div>${education.stream }</div>
            <p>${education.grade }</p>
          </div>
          <div class="resume-date text-md-right">
            <span class="text-primary">${education.from} - ${education.to}</span>
          </div>
        </div>
		</c:forEach>
		
	  </div>
    </section>

    <hr class="m-0">

    <section class="resume-section p-3 p-lg-5 d-flex align-items-center" id="skills">
      <div class="w-100">
        <h2 class="mb-5">Skills</h2>
        
        <svg></svg>

        <div class="subheading mb-3">Programming Languages &amp; Tools</div>
        <ul class="list-inline dev-icons">
          <li class="list-inline-item">
            <i class="fab fa-html5"></i>
          </li>
          <li class="list-inline-item">
            <i class="fab fa-css3-alt"></i>
          </li>
          <li class="list-inline-item">
            <i class="fab fa-js-square"></i>
          </li>
          <li class="list-inline-item">
            <i class="fab fa-angular"></i>
          </li>
          <li class="list-inline-item">
            <i class="fab fa-react"></i>
          </li>
          <li class="list-inline-item">
            <i class="fab fa-node-js"></i>
          </li>
          <li class="list-inline-item">
            <i class="fab fa-sass"></i>
          </li>
          <li class="list-inline-item">
            <i class="fab fa-less"></i>
          </li>
          <li class="list-inline-item">
            <i class="fab fa-wordpress"></i>
          </li>
          <li class="list-inline-item">
            <i class="fab fa-gulp"></i>
          </li>
          <li class="list-inline-item">
            <i class="fab fa-grunt"></i>
          </li>
          <li class="list-inline-item">
            <i class="fab fa-npm"></i>
          </li>
        </ul>

        <div class="subheading mb-3">Paradigms</div>
        <ul class="fa-ul mb-0">
          <li>
            <i class="fa-li fa fa-check"></i>
            Test Driven Development</li>
          <li>
            <i class="fa-li fa fa-check"></i>
            Cross Functional Teams</li>
          <li>
            <i class="fa-li fa fa-check"></i>
            Agile Development &amp; Scrum</li>
        </ul>
      </div>
    </section>

    <hr class="m-0">

    <section class="resume-section p-3 p-lg-5 d-flex align-items-center" id="interests">
      <div class="w-100">
        <h2 class="mb-5">Interests</h2>
        <p>Fill details here</p>
        <p class="mb-0">Here too</p>
      </div>
    </section>

    <hr class="m-0">

    <section class="resume-section p-3 p-lg-5 d-flex align-items-center" id="awards">
      <div class="w-100">
        <h2 class="mb-5">Awards &amp; Certifications</h2>
        <ul class="fa-ul mb-0">
          <li>
            <i class="fa-li fa fa-trophy text-warning"></i>
            Fill details here </li>
        </ul>
      </div>
    </section>

  </div>

	<!-- Bootstrap core JavaScript -->
	<script src="webjars/jquery/jquery.min.js"></script>
	<script src="webjars/bootstrap/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<!-- <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
 -->
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"/>
 	<script src="https://d3js.org/d3.v4.min.js"></script>
	<!-- Custom scripts for this template -->
	<script src="js/resume.min.js"></script>
	<script src="js/sb.js"></script>
	<!-- <script src="js/hsb.js"></script> -->

</body>

</html>
