<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 2/22/16
  Time: 1:12 AM
  To change this template use File | Settings | File Templates.
--%>
<div class="ui-widget">
    <div id="register">
        <h3>Sign up!</h3>
        <form id="register-form" action="/login" method="post">
            <table>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" id="register-email" name="field1"></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" id="register-name" name="field2"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" id="register-password" name="field3"></td>
                </tr>
                <tr>
                    <td>Confirm password:</td>
                    <td><input type="password" id="register-password-confirm" name="field4"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" id="register-submit" value="Register"></td>
                </tr>
            </table>
        </form>
    </div>
</div>