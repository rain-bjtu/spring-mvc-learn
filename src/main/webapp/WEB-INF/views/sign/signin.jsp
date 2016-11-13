<%@ include file="../common/include.jsp"%>

    <!DOCTYPE html>
    <html>

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Sign in - Welcome to my APP</title>

        <%@ include file="../common/css.jsp"%>
    </head>

    <body OnLoad="document.getElementById('username').focus();">

        <!-- Fixed navbar -->
        <div class="navbar navbar-inverse navbar-fixed-top headroom">
            <div class="container">
                <div class="navbar-header">
                    <!-- Button for smallest screens -->
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                    <a class="navbar-brand" href="<c:url value='/index'/>"><img src="<c:url value='/resources/images/logo.png' />" alt="My APP"></a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav pull-right">
                        <li><a href="<c:url value='/index'/>">Home</a></li>
                        <li><a href="<c:url value='/about'/>">About</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">More Pages <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="<c:url value='/common/a'/>">A Page</a></li>
                                <li><a href="<c:url value='/common/b'/>">B Page</a></li>
                            </ul>
                        </li>
                        <li><a href="<c:url value='/common/contact'/>">Contact</a></li>
                        <li class="active"><a class="btn" href="signin">SIGN IN / SIGN UP</a></li>
                    </ul>
                </div>
                <!--/.nav-collapse -->
            </div>
        </div>
        <!-- /.navbar -->

        <header id="head" class="secondary"></header>

        <!-- container -->
        <div class="container">

            <ol class="breadcrumb">
                <li><a href="<c:url value='/index'/>">Home</a></li>
                <li class="active">User access</li>
            </ol>

            <div class="row">

                <!-- Article main content -->
                <article class="col-xs-12 maincontent">
                    <header class="page-header">
                        <h1 class="page-title">Sign in</h1>
                    </header>

                    <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <h3 class="thin text-center">Sign in to your account</h3>
                                <p class="text-center text-muted">If you don't have an account, click &quot;<a href="signup">Register</a>&quot; to register one. </p>
                                <hr>

                                <form action="j_spring_security_check" method="post">
                                    <div class="top-margin">
                                        <label>Username/Email <span class="text-danger">*</span></label>
                                        <input id="username" name="username" type="text" class="form-control">
                                    </div>
                                    <div class="top-margin">
                                        <label>Password <span class="text-danger">*</span></label>
                                        <input id="password" name="password" type="password" class="form-control">
                                    </div>

                                    <hr>

                                    <div class="row">
                                        <div class="col-lg-8">
                                            <b><a href="password-find">Forgot password?</a></b>
                                        </div>
                                        <div class="col-lg-4 text-right">
                                            <button class="btn btn-action" type="submit">Sign in</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>

                    </div>

                </article>
                <!-- /Article -->

            </div>
        </div>
        <!-- /container -->


        <footer id="footer" class="top-space">

            <div class="footer1">
                <div class="container">
                    <div class="row">

                        <div class="col-md-3 widget">
                            <h3 class="widget-title">Contact</h3>
                            <div class="widget-body">
                                <p>+234 23 12345678<br>
                                    <a href="mailto:#">123456789@qq.com</a><br>
                                    <br> 234 LiShui Road, Beijing City, 100000 P.R.China
                                </p>
                            </div>
                        </div>

                        <div class="col-md-3 widget">
                            <h3 class="widget-title">Follow me</h3>
                            <div class="widget-body">
                                <p class="follow-me-icons clearfix">
                                    <a href=""><i class="fa fa-twitter fa-2"></i></a>
                                    <a href=""><i class="fa fa-dribbble fa-2"></i></a>
                                    <a href=""><i class="fa fa-github fa-2"></i></a>
                                    <a href=""><i class="fa fa-facebook fa-2"></i></a>
                                </p>
                            </div>
                        </div>

                        <div class="col-md-6 widget">
                            <h3 class="widget-title">Text widget</h3>
                            <div class="widget-body">
                                <p>This is my APP.</p>
                                <p>Welcome to use this web site, and hope you enjoy it.</p>
                            </div>
                        </div>

                    </div>
                    <!-- /row of widgets -->
                </div>
            </div>

            <div class="footer2">
                <div class="container">
                    <div class="row">

                        <div class="col-md-6 widget">
                            <div class="widget-body">
                                <p class="simplenav">
                                    <a href="<c:url value='/index'/>">Home</a> |
                                    <a href="<c:url value='/common/about'/>">About</a> |
                                    <a href="<c:url value='/common/b'/>">Sidebar</a> |
                                    <a href="<c:url value='/common/contact'/>">Contact</a> |
                                    <b><a href="signup">Sign up</a></b>
                                </p>
                            </div>resource
                        </div>

                        <div class="col-md-6 widget">
                            <div class="widget-body">
                                <p class="text-right">
                                    Copyright &copy; 2016, Flysnow. Designed by <a href="<c:url value='/index'/>" rel="designer">Rain</a>
                                </p>
                            </div>
                        </div>

                    </div>
                    <!-- /row of widgets -->
                </div>
            </div>
        </footer>

        <%@ include file="../common/js.jsp"%>
    </body>

    </html>
