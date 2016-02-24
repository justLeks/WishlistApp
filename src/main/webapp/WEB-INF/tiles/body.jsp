<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 2/19/16
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

Welcome to home page!
<br/>
<script type="text/javascript">
    $(document).ready(function () {
        $.ajax({
            url: "http://localhost:8080/users/"
        }).then(function (data) {
            $.each(data, function (i, user) {
                $(".users").append(
                        $('.user-email').append(user.email);
                $('.user-name').append(user.name);
                $('.user-password').append(user.password);
                $('.user-authority').append(user.authority);
                $('.user-enabled').append(user.enabled);
            });
        });
    });
    var deleteUser = function (id) {
        $.ajax({
            url: "http://localhost:8080/users/" + id,
            type: "DELETE"
        }).then(function () {
            alert("DELETED");
        });
    };
</script>
<div>
    <p class="users"></p>
</div>