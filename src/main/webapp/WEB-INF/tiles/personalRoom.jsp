<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 2/23/16
  Time: 2:18 AM
  To change this template use File | Settings | File Templates.
--%>
<input type="hidden" value="${idUser}" id="id-user">

<div class="ui-widget">
    <table>
        <tr>
            <td><label for="items-autocomplete">Items: </label></td>
            <td><input id="items-autocomplete"></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><label id="item-name"></label></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><label id="item-description"></label></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><label id="item-price"></label></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" id="add-item-to-wishlist" value="Add to wish list"></td>
        </tr>
    </table>

    <br>
    <input type="button" id="show-user-wishes" value="My wishes">
    <br>
    <div id="user-wishes"></div>
    <br>

    <input type="button" id="show-my-friends" value="My friends">
    <br>
    <div id="my-friends"></div>
    <br>

    <input type="button" id="users" value="Users">
    <br>
    <div id="mainHolder"></div>
    <br>

    <input type="button" id="joins" value="My joins">
    <br>
    <div id="show-joins"></div>
    <br>
</div>