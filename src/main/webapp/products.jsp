
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
    <div class="row">

            <div class="col-sm-10">
                <div class="menu">

                    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">

                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarText">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item">
                                    <a class="nav-link" href="addProduct">Add Product</a>
                                </li>
                                <li class="nav-item active">
                                    <a class="nav-link" href="products">Product List</a>
                                </li>

                            </ul>
                            <span class="navbar-text">

                            </span>
                        </div>
                    </nav>


                </div>
                <div class="card">
                    <div class="card-body">
                        <h3 class="card-title"><p class="text-center">The list of the Products</p></h3>
                        <table class="table table-striped table-hover">

                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Group</th>
                                <th>Parchase price</th>
                                <th>Sale Price</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            <c:forEach items="${products}" var="pro">
                                <tr>
                                    <td>${pro.getId()}</td>
                                    <td>${pro.getName()}</td>
                                    <td>${pro.getProductGroup()}</td>
                                    <td>${pro.getParchasePrice()}</td>
                                    <td>${pro.getSalePrice()}</td>

                                    <td><input class="btn btn-primary" type="submit" value="Edit" data-toggle="modal" data-target="#pro${pro.getId()}"></td>

                                    <form action="deleteProduct" method="post">
                                        <input type="hidden" name="id" value="${pro.getId()}">
                                        <td><input class="btn btn-danger" type="submit" value="Delete"></td>
                                    </form>
                                </tr>

                                <div class="modal fade" id="pro${pro.getId()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <form action="editProduct" method="post">
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Id</label>
                                                        <input type="text" class="form-control" id="exampleInputEmail0" name="id" value="${pro.getId()}" aria-describedby="emailHelp" placeholder="Product Id">

                                                    </div>
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Name</label>
                                                        <input type="text" class="form-control" id="exampleInputEmail1" name="name" value="${pro.getName()}" aria-describedby="emailHelp" placeholder="Product Name">

                                                    </div>
                                                    <div class="form-group">
                                                        <label for="exampleInputPassword1">Product Group</label>
                                                        <input type="text" class="form-control" id="exampleInputPassword1" name="productGroup" value="${pro.getProductGroup()}" placeholder="Product Group">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="exampleInputPassword1">Parchese Price</label>
                                                        <input type="text" class="form-control" id="exampleInputPassword3" name="parchasePrice" value="${pro.getParchasePrice()}" placeholder="Product Group">
                                                    </div>

                                                    <div class="form-group">
                                                        <label for="exampleInputPassword1">Sale Price</label>
                                                        <input type="text" class="form-control" id="exampleInputPassword2" name="salePrice" value="${pro.getSalePrice()}" placeholder="Product Group">
                                                    </div>


                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                <button type="submit" class="btn btn-primary">Save changes</button>
                                            </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                            </c:forEach>

                        </table>


                        <!-- Modal -->


                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>