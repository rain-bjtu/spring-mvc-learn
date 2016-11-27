<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<c:url value='/resources/js/jquery-3.1.1.min.js' />"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/resources/js/jquery.validate.min.js' />"></script>
<script src="<c:url value='/resources/js/headroom.min.js' />"></script>
<script src="<c:url value='/resources/js/jQuery.headroom.min.js' />"></script>
<script src="<c:url value='/resources/js/template.js' />"></script>

<script type="text/javascript">
    $(document).ready(function() {
        pageActive();
        addHrefForLanguage();
    });

    function addHrefForLanguage() {
        var url = location.href;
        var index = location.href.indexOf("?");
        var endLanguage = $.trim($("#language-link").text());
        if (index != -1) {
            url = location.href.substring(0, index);
        }
        if ("English" == endLanguage) {
            url = url + "?locale=en_US";
        } else {
            url = url + "?locale=zh_CN";
        }
        $("#language-link").attr("href", url);
    }

    function pageActive() {
        var home = "learn/index";
        var login = "account/login";
        var about = "learn/about";
        var contact = "learn/contact";
        if (location.href.indexOf(home) > 0) {
            $("#navbar-active").children().eq(0).addClass("active");
        } else if (location.href.indexOf(about) > 0) {
            $("#navbar-active").children().eq(1).addClass("active");
        } else if (location.href.indexOf(contact) > 0) {
            $("#navbar-active").children().eq(3).addClass("active");
        } else if (location.href.indexOf(login) > 0) {
            $("#navbar-active").children().eq(4).addClass("active");
        } else {
            $("#navbar-active").children().eq(2).addClass("active");
        }
    }

</script>
