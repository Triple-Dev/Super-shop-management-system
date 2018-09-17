<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
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
                            <li class="nav-item active">
                                <a class="nav-link" href="addProduct">Add Product </a>
                            </li>
                            <li class="nav-item">
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
                    <h3 class="card-title">
                        Add product
                    </h3>
                    <form action="addProduct" method="post">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Name</label>
                            <input type="text" class="form-control" id="exampleInputEmail1" name="name" aria-describedby="emailHelp" placeholder="Product Name">

                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Product Group</label>
                            <input type="text" class="form-control" id="exampleInputPassword1" name="productGroup" placeholder="Product Group">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Parchese Price</label>
                            <input type="text" class="form-control" id="exampleInputPassword3" name="parchasePrice" placeholder="Parchase Price">
                        </div>

                        <div class="form-group">
                            <label for="exampleInputPassword1">Sale Price</label>
                            <input type="text" class="form-control" id="exampleInputPassword2" name="salePrice" placeholder="Sale price">
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>