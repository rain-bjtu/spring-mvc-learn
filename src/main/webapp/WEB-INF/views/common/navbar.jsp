<!-- Fixed navbar -->
<div class="navbar navbar-inverse navbar-fixed-top headroom">
    <div class="container">
        <div class="navbar-header">
            <!-- Button for smallest screens -->
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value='/index'/>"><img src="<c:url value='/resources/images/logo.png' />" alt="home logo"></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul id="navbar-active" class="nav navbar-nav pull-right">
                <li><a href="<c:url value='/index'/>">Home</a></li>
                <li><a href="<c:url value='/about'/>">About</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">More Pages <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value='/home/a'/>">A Page</a></li>
                        <li><a href="<c:url value='/home/b'/>">B Page</a></li>
                    </ul>
                </li>
                <li><a href="<c:url value='/contact'/>">Contact</a></li>
                <li><a class="btn" href="<c:url value='/login'/>">SIGN IN / SIGN UP</a></li>
                <li><a href="<c:url value='/logout'/>">LOGOUT</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>
<!-- /.navbar -->
