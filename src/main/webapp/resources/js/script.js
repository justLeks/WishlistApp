/**
 * Created by justlex on 2/19/16.
 */
$(document).ready(function () {

    //Show all users from REST
    $("#users").click(function () {
        $.ajax({
            url: "http://localhost:8080/users/"
        }).then(function (json) {
            $("#mainHolder").empty()
                .append("<h3>List of users</h3>");
            $.each(json, function appendMessage(i, user) {
                var root = document.getElementById("mainHolder");
                if (root) {
                    if (user.idUser != $("#id-user").val()) {
                        var email_field = document.createElement('p');
                        var emailFieldId = "user-email" + i;
                        email_field.setAttribute("id", emailFieldId);
                        email_field.appendChild(document.createTextNode(user.email));
                        root.appendChild(email_field);

                        var id_field = document.createElement('input');
                        var idFieldId = "user-id" + i;
                        id_field.setAttribute("id", idFieldId);
                        id_field.setAttribute("type", "hidden");
                        id_field.appendChild(document.createTextNode(user.idUser));
                        root.appendChild(id_field);

                        var name_field = document.createElement('p');
                        var nameFieldId = "user-name" + i;
                        name_field.setAttribute("id", nameFieldId);
                        name_field.appendChild(document.createTextNode(user.name));
                        root.appendChild(name_field);

                        $.ajax({
                            url: "http://localhost:8080/friends/" + $("#id-user").val()
                        }).then(function (data) {
                            if (jQuery.inArray(user.idUser, data) == -1) {
                                var createButton = document.createElement('input');
                                createButton.type = 'button';
                                createButton.value = 'Add';
                                root.appendChild(createButton);

                                createButton.onclick = function () {
                                    var userId = $("#" + idFieldId).text();
                                    var myId = $("#id-user").val();
                                    var jsonObject = {
                                        "id1": myId,
                                        "id2": userId
                                    };
                                    $.ajax({
                                        url: "http://localhost:8080/friends/",
                                        type: "POST",
                                        contentType: 'application/json; charset=utf-8',
                                        data: JSON.stringify(jsonObject)
                                    })
                                };
                            }
                        });
                    }
                }
            });
        });
    });

    //Register new user to DB via REST
    $("#register-submit").click(function () {
        var userEmail = $("#register-email").val();
        var userName = $("#register-name").val();
        var userPassword = $("#register-password").val();

        var jsonObject = {
            "email": userEmail,
            "name": userName,
            "password": userPassword
        };

        if (userEmail == "" || userName == "" || userPassword == "") {
            alert("Fill the fields");
        } else {
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/users/",
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(jsonObject)
            });
        }
    });

    //Validation of register form
    $("#register-form").validate({
        rules: {
            field1: {
                required: true,
                email: true
            },
            field2: {
                required: true,
                minlength: 5,
                maxlength: 50
            },
            field3: {
                required: true,
                minlength: 5,
                maxlength: 20
            },
            field4: {
                required: true,
                minlength: 5,
                maxlength: 20
            }
        }
    });

    //Autocompleter
    $(function () {
        var items = new Array;
        $.ajax({
            url: "http://localhost:8080/items/"
        }).then(function (json) {
            $.each(json, function (i, item) {
                items.push(item.name);
            });
        });
        $("#items-autocomplete").autocomplete({
            source: items
        });
    });

    //Function for enter-hit
    $("#items-autocomplete").bind("enterKey", function () {
        var itemName = $("#items-autocomplete").val();
        $.ajax({
            url: "http://localhost:8080/items/name/" + itemName
        }).then(function (item) {
            $("#item-name").text(item.name);
            $("#item-description").text(item.description);
            $("#item-price").text(item.price);
            $("#item-id").val(item.iditem);
        });
    }).keyup(function (e) {
        if (e.keyCode == 13) {
            $(this).trigger("enterKey");
        }
    });

    //Add wish to wishlist
    $("#add-item-to-wishlist").click(function () {
        var userId = $("#id-user").val();
        var idItem = $("#item-id").val();

        $.ajax({
            url: "http://localhost:8080/items/id/" + idItem
        }).then(function (item) {
            var finalPrice = item.price;
            var jsonObject = {
                "idItem": idItem,
                "idUser": userId,
                "finalPrice": finalPrice
            };

            $.ajax({
                type: "POST",
                url: "http://localhost:8080/wishes/",
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(jsonObject)
            }).then(function () {
                alert("added");
            });
        });
    });

    //Add a new wish
    $("#new-wish-submit").click(function () {
        var wishName = $("#new-wish-name").val();
        var wishDescription = $("#new-wish-description").val();
        var wishPrice = $("#new-wish-price").val();

        var newWish = {
            "name": wishName,
            "description": wishDescription,
            "price": wishPrice
        };

        if (wishName == "" || wishDescription == "" || wishPrice == "") {
            alert("Fill the fields");
        } else {
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/items/",
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(newWish)
            }).then(function () {
                var info = document.getElementById("new-wish-added");
                info.innerHTML = "<h3>Wish has been added</h3>";
            });
        }
    });

    //Show my wishes
    $("#show-user-wishes").click(function () {
        var userId = $("#id-user").val();

        $.ajax({
            url: "http://localhost:8080/wishes/userid/" + userId
        }).then(function (json) {
            $("#user-wishes").empty()
                .append("<h3>My wishes</h3>");
            $.each(json, function appendMessage(i, wish) {
                var price = wish.finalPrice;
                $.ajax({
                    url: "http://localhost:8080/items/id/" + wish.idItem
                }).then(function (item) {
                    var root = document.getElementById("user-wishes");
                    if (root) {
                        //$.ajax({
                        //    //url: "http://localhost:8080/wishes/" + wish.idItem
                        //}).then(function (wish) {
                        var name_field = document.createElement('p');
                        var nameFieldId = "wish-name" + i;
                        name_field.setAttribute("id", nameFieldId);
                        name_field.appendChild(document.createTextNode(item.name));
                        root.appendChild(name_field);

                        var description_field = document.createElement('p');
                        var descriptionFieldId = "wish-description" + i;
                        description_field.setAttribute("id", descriptionFieldId);
                        description_field.appendChild(document.createTextNode(item.description));
                        root.appendChild(description_field);

                        var price_field = document.createElement('p');
                        var priceFieldId = "wish-price" + i;
                        price_field.setAttribute("id", priceFieldId);
                        price_field.appendChild(document.createTextNode(price));
                        root.appendChild(price_field);
                        //});
                    }
                });
            });
        });
    });

    //Show my friends
    $("#show-my-friends").click(function () {
        $.ajax({
            url: "http://localhost:8080/friends/" + $("#id-user").val()
        }).then(function (json) {
            $("#my-friends").empty()
                .append("<h3>Friends</h3>");
            $.each(json, function appendMessage(i, friendId) {
                $.ajax({
                    url: "http://localhost:8080/users/" + friendId
                }).then(function (friend) {
                    var root = document.getElementById("my-friends");
                    if (root) {
                        var email_field = document.createElement('p');
                        var emailFieldId = "user-email" + i;
                        email_field.setAttribute("id", emailFieldId);
                        email_field.appendChild(document.createTextNode(friend.email));
                        root.appendChild(email_field);

                        var id_field = document.createElement('input');
                        var idFieldId = "user-id" + i;
                        id_field.setAttribute("id", idFieldId);
                        id_field.setAttribute("type", "hidden");
                        id_field.appendChild(document.createTextNode(friend.idUser));
                        root.appendChild(id_field);

                        var name_field = document.createElement('p');
                        var nameFieldId = "user-name" + i;
                        name_field.setAttribute("id", nameFieldId);
                        name_field.appendChild(document.createTextNode(friend.name));
                        root.appendChild(name_field);

                        var aTag = document.createElement('a');
                        var link = document.createTextNode("User's page");
                        aTag.appendChild(link);
                        aTag.title = "User's page";
                        aTag.href = "/friend?id=" + friend.idUser;
                        root.appendChild(aTag);
                    }
                });
            });
        });
    });

    //Show my friend's wishes
    $.ajax({
        url: "http://localhost:8080/wishes/userid/" + $("#friendId").val()
    }).then(function (json) {
        if (typeof json != "undefined" && json != null && json.length > 0) {
            $("#friend-wishes").empty()
                .append("<h3>Wishes</h3>");
            $.each(json, function (i, wish) {
                var price = wish.finalPrice;
                $.ajax({
                    url: "http://localhost:8080/items/id/" + wish.idItem
                }).then(function (item) {
                    var root = document.getElementById("friend-wishes");
                    if (root) {
                        var name_field = document.createElement('p');
                        var nameFieldId = "wish-name" + i;
                        name_field.setAttribute("id", nameFieldId);
                        name_field.appendChild(document.createTextNode(item.name));
                        root.appendChild(name_field);

                        var description_field = document.createElement('p');
                        var descriptionFieldId = "wish-description" + i;
                        description_field.setAttribute("id", descriptionFieldId);
                        description_field.appendChild(document.createTextNode(item.description));
                        root.appendChild(description_field);

                        var price_field = document.createElement('p');
                        var priceFieldId = "wish-price" + i;
                        price_field.setAttribute("id", priceFieldId);
                        price_field.appendChild(document.createTextNode(price));
                        root.appendChild(price_field);

                        var createButton = document.createElement('input');
                        createButton.type = 'button';
                        createButton.value = 'Join';
                        root.appendChild(createButton);
                        createButton.onclick = function () {
                            var myId = $("#userId").val();
                            var wishId = wish.idWish;
                            var jsonObject = {
                                "idwish": wishId,
                                "iduser": myId
                            };
                            $.ajax({
                                url: "http://localhost:8080/presents/",
                                type: "POST",
                                contentType: 'application/json; charset=utf-8',
                                data: JSON.stringify(jsonObject)
                            });
                            $.ajax({
                                url: "http://localhost:8080/presents/wishid/" + wish.idWish
                            }).then(function (sameWish) {
                                if (typeof sameWish.length != "undefined" && sameWish.length != null && sameWish.length > 0) {
                                    sameWish.length + 1;
                                }
                                var newPrice = wish.finalPrice / length;
                                var wishWithNewPrice = {
                                    "idItem": wish.idItem,
                                    "idUser": wish.idUser,
                                    "finalPrice": newPrice
                                };
                                $.ajax({
                                    url: "http://localhost:8080/wishes/" + wish.idWish,
                                    type: "PUT",
                                    contentType: 'application/json; charset=utf-8',
                                    data: JSON.stringify(wishWithNewPrice)
                                })
                            });
                        };
                    }
                });
            });
        } else {
            $("#friend-wishes").empty()
                .append("<h3>No wishes :(</h3>");
        }
    });

    //Show my joins
    $("#show-joins").click(function () {
        var userId = $("#id-user").val();
        $.ajax({
            url: "http://localhost:8080/presents/userid/" + userId
        }).then(function (presents) {
            $.each(presents, function (i, present) {
                $.ajax({
                    url: "http://localhost:8080/wishes/wishid/" + present.idwish
                }).then(function (wish) {
                    var price = wish.finalPrice;
                    $.ajax({
                        url: "http://localhost:8080/items/id/" + wish.idItem
                    }).then(function (item) {
                        var root = document.getElementById("joins");
                        if (root) {
                            var name_field = document.createElement('p');
                            var nameFieldId = "wish-name" + i;
                            name_field.setAttribute("id", nameFieldId);
                            name_field.appendChild(document.createTextNode(item.name));
                            root.appendChild(name_field);

                            var description_field = document.createElement('p');
                            var descriptionFieldId = "wish-description" + i;
                            description_field.setAttribute("id", descriptionFieldId);
                            description_field.appendChild(document.createTextNode(item.description));
                            root.appendChild(description_field);

                            var price_field = document.createElement('p');
                            var priceFieldId = "wish-price" + i;
                            price_field.setAttribute("id", priceFieldId);
                            price_field.appendChild(document.createTextNode(price));
                            root.appendChild(price_field);

                            var createButton = document.createElement('input');
                            createButton.type = 'button';
                            createButton.value = 'Refuse';
                            root.appendChild(createButton);
                            createButton.onclick = function () {
                                $.ajax({
                                    url: "http://localhost:8080/presents/" + userId + "&" + wish.idWish,
                                    type: "DELETE"
                                }).then(function (){
                                    $.ajax({
                                        url: "http://localhost:8080/presents/wishid/" + wish.idWish
                                    }).then(function (sameWish) {
                                        var newPrice = item.price / (sameWish.length + 1);
                                        alert(newPrice);
                                        var wishWithNewPrice = {
                                            "idItem": wish.idItem,
                                            "idUser": wish.idUser,
                                            "finalPrice": newPrice
                                        };
                                        $.ajax({
                                            url: "http://localhost:8080/wishes/" + wish.idWish,
                                            type: "PUT",
                                            contentType: 'application/json; charset=utf-8',
                                            data: JSON.stringify(wishWithNewPrice)
                                        })
                                    });
                                });
                            };
                        }
                    });
                });
            });
        });
    });
});

