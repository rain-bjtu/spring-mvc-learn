<!-- Fixed navbar -->
<div class="navbar navbar-inverse navbar-fixed-top headroom">
    <div class="container">
        <div class="navbar-header">
            <!-- Button for smallest screens -->
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${indexUrl }"><img src="${logoUrl }" alt="home logo"></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul id="navbar-active" class="nav navbar-nav pull-right">
                <li>
                    <a href="${indexUrl }">
                        <spring:message code="common.home" />
                    </a>
                </li>
                <li>
                    <a href="${aboutUrl }">
                        <spring:message code="common.about" />
                    </a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <spring:message code="common.more.pages" /><b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="${homeAUrl }">A Page</a></li>
                        <li><a href="${homeBUrl }">B Page</a></li>
                        <li><a href="${changePasswordUrl }">Chang Password</a></li>
                    </ul>
                </li>
                <li>
                    <a href="${contactUrl }">
                        <spring:message code="common.contact" />
                    </a>
                </li>
                <li>
                    <a class="btn" href="${loginUrl }">
                        <spring:message code="common.sign.in.up" />
                    </a>
                </li>
                <li>
                    <a href="${logoutUrl }">
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
