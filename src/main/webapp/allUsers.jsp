<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="head.jsp"%>

<html><body>


<!-- Main -->
<article id="main">

    <header class="special container">
        <span class="icon fa-laptop"></span>
        <h2>View All <strong>Users</strong></h2>
    </header>

    <!-- One -->
    <section class="wrapper style4 container">

        <div class="row 150%">
            <div class="4u 12u(narrower)">

                <!-- Sidebar -->
                <div class="sidebar">
                    <section>
                        <header>
                            <h3>LEFT SIDEBAR</h3>
                        </header>
                        <c:import url="/actionItems"/>
                    </section>

                    <section>
                        <a href="#" class="image featured"><img src="images/pic03.jpg" alt="" /></a>
                        <header>
                            <h3>Amet Lorem Tempus</h3>
                        </header>
                        <p>Sed tristique purus vitae volutpat commodo suscipit amet sed nibh. Proin a ullamcorper sed blandit. Sed tristique purus vitae volutpat commodo suscipit ullamcorper sed blandit lorem ipsum dolore.</p>
                        <footer>
                            <ul class="buttons">
                                <li><a href="#" class="button small">Learn More</a></li>
                            </ul>
                        </footer>
                    </section>
                </div>

            </div>
            <div class="8u 12u(narrower) important(narrower)">

                <!-- Content -->
                <div class="content">
                    <section>
                        <a href="#" class="image featured"><img src="images/pic02.jpg" alt="" /></a>
                        <header>
                            <h3>Users</h3>
                        </header>

                        <%-- ${users} --%>
                        <table>
                            <tr>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Email</th>
                                <th>Connections</th>
                            </tr>
                            <c:forEach var="user" items="${users}">

                                <tr>
                                    <td>${user.firstName}</td>
                                    <td>${user.lastName}</td>
                                    <td>${user.email}</td>
                                    <td>
                                        <c:forEach var="connection" items="${user.connections}">
                                            ${connection.firstName} ${connection.lastName} ${connection.numberOfConnections}
                                        </c:forEach>
                                    </td>
                                </tr>

                            </c:forEach>

                        </table>
                    </section>
                </div>

            </div>
        </div>
    </section>

    <!-- Two -->
    <section class="wrapper style1 container special">
        <div class="row">
            <div class="4u 12u(narrower)">

                <section>
                    <header>
                        <h3>This is Something</h3>
                    </header>
                    <p>Sed tristique purus vitae volutpat ultrices. Aliquam eu elit eget arcu commodo suscipit dolor nec nibh. Proin a ullamcorper elit, et sagittis turpis. Integer ut fermentum.</p>
                    <footer>
                        <ul class="buttons">
                            <li><a href="#" class="button small">Learn More</a></li>
                        </ul>
                    </footer>
                </section>

            </div>
            <div class="4u 12u(narrower)">

                <section>
                    <header>
                        <h3>Also Something</h3>
                    </header>
                    <p>Sed tristique purus vitae volutpat ultrices. Aliquam eu elit eget arcu commodo suscipit dolor nec nibh. Proin a ullamcorper elit, et sagittis turpis. Integer ut fermentum.</p>
                    <footer>
                        <ul class="buttons">
                            <li><a href="#" class="button small">Learn More</a></li>
                        </ul>
                    </footer>
                </section>

            </div>
            <div class="4u 12u(narrower)">

                <section>
                    <header>
                        <h3>Probably Something</h3>
                    </header>
                    <p>Sed tristique purus vitae volutpat ultrices. Aliquam eu elit eget arcu commodo suscipit dolor nec nibh. Proin a ullamcorper elit, et sagittis turpis. Integer ut fermentum.</p>
                    <footer>
                        <ul class="buttons">
                            <li><a href="#" class="button small">Learn More</a></li>
                        </ul>
                    </footer>
                </section>

            </div>
        </div>
    </section>

</article>

<!-- Footer -->
<footer id="footer">

    <!--  <ul class="icons">
          <li><a href="#" class="icon circle fa-twitter"><span class="label">Twitter</span></a></li>
          <li><a href="#" class="icon circle fa-facebook"><span class="label">Facebook</span></a></li>
          <li><a href="#" class="icon circle fa-google-plus"><span class="label">Google+</span></a></li>
          <li><a href="#" class="icon circle fa-github"><span class="label">Github</span></a></li>
          <li><a href="#" class="icon circle fa-dribbble"><span class="label">Dribbble</span></a></li>
      </ul>

      <ul class="copyright">
          <li>&copy; Untitled</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
      </ul>
-->
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
</html>
