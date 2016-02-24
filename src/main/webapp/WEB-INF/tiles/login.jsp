<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 2/22/16
  Time: 12:45 AM
  To change this template use File | Settings | File Templates.
--%>
<div class="ui-widget">
    <div id="login">
        <h3>Login with your email and password</h3>
        <form name='f' action='/login' method='POST'>
            <table>
                <tr>
                    <td>Email:</td>
                    <td><input type='text' name='username' id="login-email"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type='password' name='password' id="login-password"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td colspan='2'><input name="submit" type="submit" value="Login"/></td>
                </tr>
                <input name="_csrf" type="hidden" value="982d7ddb-3b5b-4480-8a39-ffae2f3dd875"/>
            </table>
        </form>
    </div>
    <br><br>

    <h4>Or sign up <a href="/register">here</a></h4>
</div>