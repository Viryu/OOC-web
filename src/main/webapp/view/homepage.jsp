<link href="htmldata/css/bootstrap.css" rel="stylesheet" id="bootstrap-css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.3/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="htmldata/js/bootstrap.js"></script>
<link href="htmldata/css/bootstrap.css" rel="stylesheet" id="bootstrap-css">
<link href="htmldata/css2/home.css" rel="stylesheet" id="bootstrap-css">
<script src="htmldata/js2/home.js"></script>
<script src="htmldata/js/bootstrap.js"></script>
<!-- <script src="//code.jquery.com/jquery-1.11.1.min.js"></script> -->
<!------ Include the above in your HEAD tag ---------->
<head>
    <style>
        .fade-carousel {
            position: relative;
            height: 100vh;
        }
        .fade-carousel .carousel-inner .item {
            height: 100vh;
        }
        .fade-carousel .carousel-indicators > li {
            margin: 0 2px;
            background-color: #f39c12;
            border-color: #f39c12;
            opacity: .7;
        }
        .fade-carousel .carousel-indicators > li.active {
            width: 10px;
            height: 10px;
            opacity: 1;
        }

        /********************************/
        /*          Hero Headers        */
        /********************************/
        .hero {
            position: absolute;
            top: 50%;
            left: 50%;
            z-index: 3;
            color: #fff;
            text-align: center;
            text-transform: uppercase;
            text-shadow: 1px 1px 0 rgba(0,0,0,.75);
            -webkit-transform: translate3d(-50%,-50%,0);
            -moz-transform: translate3d(-50%,-50%,0);
            -ms-transform: translate3d(-50%,-50%,0);
            -o-transform: translate3d(-50%,-50%,0);
            transform: translate3d(-50%,-50%,0);
        }
        .hero h1 {
            font-size: 6em;
            font-weight: bold;
            margin: 0;
            padding: 0;
        }

        .fade-carousel .carousel-inner .item .hero {
            opacity: 0;
            -webkit-transition: 2s all ease-in-out .1s;
            -moz-transition: 2s all ease-in-out .1s;
            -ms-transition: 2s all ease-in-out .1s;
            -o-transition: 2s all ease-in-out .1s;
            transition: 2s all ease-in-out .1s;
        }
        .fade-carousel .carousel-inner .item.active .hero {
            opacity: 1;
            -webkit-transition: 2s all ease-in-out .1s;
            -moz-transition: 2s all ease-in-out .1s;
            -ms-transition: 2s all ease-in-out .1s;
            -o-transition: 2s all ease-in-out .1s;
            transition: 2s all ease-in-out .1s;
        }

        /********************************/
        /*          Custom Buttons      */
        /********************************/
        .btn.btn-lg {padding: 10px 40px;}
        .btn.btn-hero,
        .btn.btn-hero:hover,
        .btn.btn-hero:focus {
            color: #f5f5f5;
            background-color: #1abc9c;
            border-color: #1abc9c;
            outline: none;
            margin: 20px auto;
        }

        /********************************/
        /*       Slides backgrounds     */
        /********************************/
        .fade-carousel .slides .slide-1,
        .fade-carousel .slides .slide-2,
        .fade-carousel .slides .slide-3 {
            height: 100vh;
            background-size: cover;
            background-position: center center;
            background-repeat: no-repeat;
        }
        .fade-carousel .slides .slide-1 {
            background-image: url('htmldata/img/1.jpg');
        }
        .fade-carousel .slides .slide-2 {
            background-image: url('htmldata/img/2.jpg');
        }
        .fade-carousel .slides .slide-3 {
            background-image: url('htmldata/img/3.JPG');
        }

        /********************************/
        /*          Media Queries       */
        /********************************/
        @media screen and (min-width: 980px){
            .hero { width: 980px; }
        }
        @media screen and (max-width: 640px){
            .hero h1 { font-size: 4em; }
        }

        .hotheader{
            width: 99%;
            padding: 0;
            padding-bottom: 10px;
            background-color: #0a6ebd;
            text-align: center;
            font-family: "Calibri";
            font-size: 20px;
            height: 30px;
            color: white;
        }
        .hotbody{
            width: 99%;
            background-color: lightgrey;
        }

        .hotbody li{
            text-decoration: none;
            color: black;
            font-size: 15px;
            padding: 2px;
            list-style: none;
            text-align: justify;
        }

        .hotbody :hover{
            color: #2aabd2;
        }

    </style>
    <div class="collapse navbar-collapse" id="app-navbar-collapse">
        <!-- Left Side Of Navbar -->
        <ul class="nav navbar-nav">
            <li><img src="htmldata/img/logo.jpg" alt="Logo" style="width:100px;height:50px"></li>
            <li><a href="/">Home</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/login">Login</a></li>
            <li><a href="/register">Register</a></li>
        </ul>
    </div>
</head>
<section style="margin-bottom: 10px">
    <div class="container">
        <div class="carousel fade-carousel slide" data-ride="carousel" data-interval="4000" id="bs-carousel">
            <!-- Overlay -->
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#bs-carousel" data-slide-to="0" class="active"></li>
                <li data-target="#bs-carousel" data-slide-to="1"></li>
                <li data-target="#bs-carousel" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner">
                <div class="item slides active">
                    <div class="slide-1"></div>
                    <div class="hero">
                        <hgroup>
                            <h1>Southern Malang Beach</h1>
                            <h3>Escape from the city</h3>
                        </hgroup>
                        <a href="/lounge"><button class="btn btn-hero btn-lg" role="button">Book Now!</button></a>
                    </div>

                </div>
                <div class="item slides">
                    <div class="slide-2"></div>
                    <div class="hero">
                        <hgroup>
                            <h1>Pari Island</h1>
                            <h3>Enjoy the freshness of seafoods</h3>
                        </hgroup>
                        <a href="/company"><button class="btn btn-hero btn-lg" role="button">Book Now!</button></a>
                    </div>
                </div>
                <div class="item slides">
                    <div class="slide-3"></div>
                    <div class="hero">
                        <hgroup>
                            <h1>Keraton Hill</h1>
                            <h3>Enjoy the scenery from a hill</h3>
                        </hgroup>
                        <a href="/lounge"><button class="btn btn-hero btn-lg" role="button">Book Now!</button></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<section>

    <!--   Big container   -->
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">
                <!-- Wizard container -->
                <div class="wizard-container">
                    <div class="card wizard-card" data-color="blue" id="wizard">
                        <form action="" method="">
                            <!--        You can switch " data-color="blue" "  with one of the next bright colors: "green", "orange", "red", "purple"             -->
                            <div class="wizard-header">
                                <h3 class="wizard-title">
                                    Order a Ticket
                                </h3>
                                <h5>Order your transportation ticket right here!</h5>
                            </div>
                            <div class="wizard-navigation">
                                <ul>
                                    <li><a href="#details" data-toggle="tab">Airplane</a></li>
                                    <li><a href="#captain" data-toggle="tab">Bus</a></li>
                                    <li><a href="#description" data-toggle="tab">Boat</a></li>
                                </ul>
                            </div>

                            <div class="tab-content">
                                <div class="tab-pane" id="details">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <label>Adult Passenger Amount</label>
                                                        <input id="passengeramt" name="passengeramt" type="number" placeholder="Passenger Amount" class="form-control input-md">
                                                        <label>From</label>
                                                        <input id="frombox" name="frombox" type="text" placeholder="From" class="form-control input-md">
                                                        <label>Flight Date</label>
                                                        <div class="form-group label-floating">
                                                        <input id="date" name="date" type="date" placeholder="Preferred Date" class="form-control input-md">
                                                        </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <label>Infant Passenger Amount</label>
                                                        <input id="passengeramt" name="passengeramt" type="number" placeholder="Passenger Amount" class="form-control input-md">
                                                        <label>To</label>
                                                        <input id="tobox" name="tobox" type="text" placeholder="To" class="form-control input-md">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="captain">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <label>Passenger Amount</label>
                                                        <input id="passengeramt" name="passengeramt" type="number" placeholder="Passenger Amount" class="form-control input-md">
                                                        <label>From</label>
                                                        <input id="frombox" name="frombox" type="text" placeholder="From" class="form-control input-md">
                                                        <label>Departure Date</label>
                                                        <div class="form-group label-floating">
                                                        <input id="date" name="date" type="date" placeholder="Preferred Date" class="form-control input-md">
                                                        </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <label>To</label>
                                                        <input id="tobox" name="tobox" type="text" placeholder="To" class="form-control input-md">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="description">
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <label>Passenger Amount</label>
                                                        <input id="passengeramt" name="passengeramt" type="number" placeholder="Passenger Amount" class="form-control input-md">
                                                        <label>From</label>
                                                        <input id="frombox" name="frombox" type="text" placeholder="From" class="form-control input-md">
                                                        <label>Departure Date</label>
                                                        <div class="form-group label-floating">
                                                        <input id="date" name="date" type="date" placeholder="Preferred Date" class="form-control input-md">
                                                        </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="input-group">
                                                    <span class="input-group-addon">
                                                        <label>To</label>
                                                        <input id="tobox" name="tobox" type="text" placeholder="To" class="form-control input-md">
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="wizard-footer">
                                <div class="pull-right">
                                    <input type='button' class='btn btn-next btn-fill btn-danger btn-wd' name='next' value='Next' />
                                    <input type='button' class='btn btn-finish btn-fill btn-danger btn-wd' name='finish' value='Finish' />
                                </div>
                                <!-- <div class="pull-left">
                                    <input type='button' class='btn btn-previous btn-fill btn-default btn-wd' name='previous' value='Previous' />

                                    <div class="footer-checkbox">
                                        <div class="col-sm-12">
                                          <div class="checkbox">
                                              <label>
                                                  <input type="checkbox" name="optionsCheckboxes">
                                              </label>
                                              Subscribe to our newsletter
                                          </div>
                                      </div>
                                    </div>
                                </div> -->
                                <div class="clearfix"></div>
                            </div>
                        </form>
                    </div>
                </div> <!-- wizard container -->
            </div>
        </div> <!-- row -->
    </div> <!--  big container -->

    <div class="footer">

    </div>

    <div class="container">
        <div class="col-md-6">
            <div class="row">
                <div class="hotheader">
                    Hot Destination
                </div>
                <div class="hotbody">
                    <div class="square">
                        <img src="D:/College Stuffs/6th Term (Abroad)/Object Oriented Concept/Final Project OOC/Web View/htmldata/img/4.jpg">
                    </div>


                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="row">
                <div class="hotheader">
                    Hot Promo
                </div>
                <div class="hotbody">
                    <ul>

                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>