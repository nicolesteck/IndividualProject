<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="LinkedIn Annotation Tool" />
<%@include file="head.jsp"%>

<html>
<body class="index">
<div id="page-wrapper">

    <!-- Header -->
    <header id="header" class="alt">
        <h1 id="logo">Connection Annotation Tool</h1>
        <nav id="nav">
            <ul>
                <li class="current"><a href="index.jsp">Welcome</a></li>
                <li class="submenu">
                <li><a href="https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id=789qxnkiciz8ny&redirect_uri=http://localhost:8080/nsindieproject/linkedInLogin&scope=r_basicprofile%20r_emailaddress">Sign In with LI</a></li>
                <li><a href="allUsers" class="button special">View All Users</a></li>
                <li><a href="allConnections" class="button">View All Connections</a></li>

                <ul>
                        <li><a href="left-sidebar.html">Left Sidebar</a></li>
                        <li><a href="right-sidebar.html">Right Sidebar</a></li>
                        <li><a href="no-sidebar.html">No Sidebar</a></li>
                        <li><a href="contact.html">Contact</a></li>
                        <li class="submenu">
                            <a href="#">Submenu</a>
                            <ul>
                                <li><a href="#">Dolore Sed</a></li>
                                <li><a href="#">Consequat</a></li>
                                <li><a href="#">Lorem Magna</a></li>
                                <li><a href="#">Sed Magna</a></li>
                                <li><a href="#">Ipsum Nisl</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><a href="#" class="button special">Sign Up</a></li>
            </ul>
        </nav>
    </header>

    <!-- Banner -->
    <section id="banner">

        <!--
            ".inner" is set up as an inline-block so it automatically expands
            in both directions to fit whatever's inside it. This means it won't
            automatically wrap lines, so be sure to use line breaks where
            appropriate (<br />).
        -->
        <div class="inner">

            <header>
                <h2>ANNOTATE</h2>
            </header>
            <p>This is <strong>Connection Annotator</strong>, a free
                tool created by Nicole Steck for Madison Area Technical College's
                Enterprise Java class, taught by Paula Waite. Spring 2018.
                .</p>

          <!--
            <footer>
                <ul class="buttons vertical">
                    <li><a href="#main" class="button fit scrolly">Tell Me More</a></li>
                </ul>
            </footer>
            -->

        </div>

    </section>

    <!-- Main -->
    <article id="main">


        <!-- One -->
        <section class="wrapper style2 container special-alt">
            <c:import url="/randomConnection"/>
        </section>

        <!-- Two -->
        <section class="wrapper style1 container special">
            <ul class="buttons">
                <li><a href="allUsers" class="button special">View All Users</a></li>
                <li><a href="allConnections" class="button">View All Connections</a></li>
            </ul>
        </section>

        <!-- Three -->
        <section class="wrapper style3 container special">
            <ul class="buttons">
                <li><a href="allUsers" class="button special">View All Users</a></li>
                <li><a href="allConnections" class="button">View All Connections</a></li>
            </ul>
        </section>

    </article>

    <!-- CTA -->
    <section id="cta">

        <header>
            <h2>Ready to do <strong>something</strong>?</h2>
            <p>Proin a ullamcorper elit, et sagittis turpis integer ut fermentum.</p>
        </header>
        <footer>
            <ul class="buttons">
                <li><a href="allUsers" class="button special">View All Users</a></li>
                <li><a href="allConnections" class="button">View All Connections</a></li>
            </ul>
        </footer>

    </section>

    <!-- Footer -->
    <footer id="footer">


    </footer>

</div>

<!-- Scripts -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.dropotron.min.js"></script>
<script src="assets/js/jquery.scrolly.min.js"></script>
<script src="assets/js/jquery.scrollgress.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
<script src="assets/js/main.js"></script>

</body>
