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
                <li>
                    <a href="<c:url value='/index'/>">
                        <spring:message code="common.home" />
                    </a>
                </li>
                <li>
                    <a href="<c:url value='/about'/>">
                        <spring:message code="common.about" />
                    </a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <spring:message code="common.more.pages" /><b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value='/home/a'/>">A Page</a></li>
                        <li><a href="<c:url value='/home/b'/>">B Page</a></li>
                    </ul>
                </li>
                <li>
                    <a href="<c:url value='/contact'/>">
                        <spring:message code="common.contact" />
                    </a>
                </li>
                <li>
                    <a class="btn" href="<c:url value='/login'/>">
                        <spring:message code="common.sign.in.up" />
                    </a>
                </li>
                <li>
                    <a href="<c:url value='/logout'/>">
                        <spring:message code="common.logout" />
                    </a>
                </li>
                <li class="active">
                    <a id="language-link" href="#" target="_parent">
                        <spring:message code="common.language" />
                    </a>
                </li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>
<!-- /.navbar -->
