<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Inicio</title>
    <meta name="description" content="Cardio is a free one page template made exclusively for Codrops by Luka Cvetinovic" />
    <meta name="keywords" content="html template, css, free, one page, gym, fitness, web design" />
    <meta name="author" content="Luka Cvetinovic for Codrops" />
    <!-- Favicons (created with http://realfavicongenerator.net/)-->
    <link rel="apple-touch-icon" sizes="57x57" href="img/favicons/apple-touch-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="img/favicons/apple-touch-icon-60x60.png">
    <link rel="icon" type="image/png" href="img/favicons/favicon-32x32.png" sizes="32x32">
    <link rel="icon" type="image/png" href="img/favicons/favicon-16x16.png" sizes="16x16">
    <link rel="manifest" href="img/favicons/manifest.json">
    <link rel="shortcut icon" href="img/favicons/favicon.ico">
    <meta name="msapplication-TileColor" content="#00a8ff">
    <meta name="msapplication-config" content="img/favicons/browserconfig.xml">
    <meta name="theme-color" content="#ffffff">
    <!-- Normalize -->
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <!-- Owl -->
    <link rel="stylesheet" type="text/css" href="css/owl.css">
    <!-- Animate.css -->
    <link rel="stylesheet" type="text/css" href="css/animate.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.1.0/css/font-awesome.min.css">
    <!-- Elegant Icons -->
    <link rel="stylesheet" type="text/css" href="fonts/eleganticons/et-icons.css">
    <!-- Main style -->
    <link rel="stylesheet" type="text/css" href="css/cardio.css">

</head>

<body>
<div class="preloader">
    <img src="img/loader.gif" alt="Preloader image">
</div>
<nav class="navbar">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><img id="logo" src="img/logo%20circulo.png"  alt=""></a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right main-nav">
                <li><a href="#intro">Inicio</a></li>
                <li><a href="#services">Especialidades</a></li>
                <li><a href="#team">Especialistas</a></li>
                <li><a href="#" data-toggle="modal" data-target="#modal1" class="btn btn-blue">Inicio de Sesion</a></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
<header id="intro">
    <div class="container">
        <div class="table">
            <div class="header-text">
                <div class="row">
                    <div class="col-md-12 text-center">
                        <h3 class="light white">DocApp</h3>
                        <h1 class="white typed">La web de tu centro de salud</h1>
                        <span class="typed-cursor">|</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

<%@ include file="FormLogin.jsp"%>

<!--Especialidades-->

<section id="services" class="section section-padded">
    <div class="container">
        <div class="row text-center title">
            <h2>Especialidades</h2>
            <h4 class="light muted">Encuentra la especialidad que necesitas</h4>
        </div>
        <div class="row services">
        <c:forEach items="${especialidades}" var="esp">
        	<%@ include file="indexEspecialidades.jsp"%>
       	</c:forEach>
   		</div>
    <div class="cut cut-bottom"></div>
</section>

<!--Fin Especialidad-->

<!--Especialistas-->
<section id="team" class="section gray-bg">
    <div class="container">
        <div class="row title text-center">
            <h2 class="margin-top">Especialistas</h2>
            <h4 class="light muted">Los mejores especialistas a tu servicios</h4>
        </div>
        <div class="row">            
            <div class="col-md-4">
                <div class="popup-form">
                    <div class="dropdown">
                        <button id="dLabel" class="form-control muted dropdown" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Elija especialidad
                        </button>
                        <ul class="dropdown-menu animated fadeIn" role="menu" aria-labelledby="dLabel">
                        	<p class="animated lightSpeedIn"><a href="index"> Todas </a></p>
                            <c:forEach items="${especialidades}" var="esp">
								<p class="animated lightSpeedIn"><a href="index?&esp=${esp.name }"> ${esp.name } </a></p>				
							</c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
        	<c:forEach items="${medicos}" var="medico">
        		<%@ include file="indexMedicos.jsp"%>
       		</c:forEach>            
        </div>
    </div>
</section>

<!--Fin Especialistas-->

<footer>
    <%@ include file="Footer.jsp"%>
</footer>
<!-- Holder for mobile navigation -->
<div class="mobile-nav">
    <ul>
    </ul>
    <a href="#" class="close-link"><i class="arrow_up"></i></a>
</div>
<!-- Scripts -->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/typewriter.js"></script>
<script src="js/jquery.onepagenav.js"></script>
<script src="js/main.js"></script>
</body>

</html>
