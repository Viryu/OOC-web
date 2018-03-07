<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Selamat Datang Ke TernakQ</title>
    <link href="img/portfolio/thumbnails/LOGO.ico" rel="shortcut icon">
    <!-- Bootstrap core CSS -->
    <link href="css2/bootstrap.min.css" rel="stylesheet">
    <link href="css2/style.css" rel="stylesheet">
    <script src="http://cdn.ckeditor.com/4.6.1/standard/ckeditor.js"></script>
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Ternak-Q</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/utama">Dashboard</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Selamat Datang, __null__</a></li>
                <li><a href="/">Logout</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<header id="header">
    <div class="container">
        <div class="row">
            <div class="col-md-10">
                <h1><span class="fa fa-1x fa-home text-primary mb-1 sr-icons" aria-hidden="true" style="color: #F05F40"></span> Halaman Utama <small>Beli Ternak, Jual Ternak Semuanya Disini</small></h1>
            </div>
        </div>
    </div>
</header>

<section id="breadcrumb">
    <div class="container">
        <ol class="breadcrumb">
            <li class="active"><span><a>Ternaq-Q menyediakan layanan terbaik untuk berinvestasi.&nbsp&nbsp&nbsp&nbsp&nbsp</a><a href="/info:InvestasiQ">Pelajari Selengkapnya!</a></span> </li>
        </ol>
    </div>
</section>

<section id="main">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="list-group">
                    <button class="fa fa-1x fa-cogs text-primary mb-1 sr-icons main-color-bg" aria-hidden="true" style="color: #FFFFFF; min-width: 100%; height: 40px; background-color: transparent; border: none; text-align: left; padding: 10px;" onclick="changeVisibilityfordashboard()"><span>&nbsp&nbsp  Dashboard</span></button>
                    <button class="list-group-item" aria-hidden="true" style="color: #000000; min-width: 100%; height: 40px; background-color: #FFFFFF; border-width: 0.5px; text-align: left; padding: 10px;" onclick="changeVisibilityforisi()"><span class="fa fa-1x fa-pencil-square-o text-primary mb-1 sr-icons" aria-hidden="true" style="color: #F05F40"></span><span>&nbsp&nbsp  Isi Saldo</span></button>
                    <button class="list-group-item" aria-hidden="true" style="color: #000000; min-width: 100%; height: 40px; background-color: #FFFFFF; border-width: 0.5px; text-align: left; padding: 10px;" onclick="changeVisibilityfortarik()"><span class="fa fa-1x fa-check-square-o text-primary mb-1 sr-icons" aria-hidden="true" style="color: #F05F40"></span><span>&nbsp&nbsp  Tarik Saldo</span></button>
                    <button class="list-group-item" aria-hidden="true" style="color: #000000; min-width: 100%; height: 40px; background-color: #FFFFFF; border-width: 0.5px; text-align: left; padding: 10px;"><span class="fa fa-1x fa-crosshairs text-primary mb-1 sr-icons" aria-hidden="true" style="color: #F05F40"></span><span>&nbsp&nbsp  Pasar Ternak</span></button>
                    <button class="list-group-item" aria-hidden="true" style="color: #000000; min-width: 100%; height: 40px; background-color: #FFFFFF; border-width: 0.5px; text-align: left; padding: 10px;"><span class="fa fa-1x fa-balance-scale text-primary mb-1 sr-icons" aria-hidden="true" style="color: #F05F40"></span><span>&nbsp&nbsp  Investasi Ternak</span></button>
                </div>

                <div class="well">

                    <h4><span class="fa fa-1x fa-battery-full text-primary mb-1 sr-icons" style="color: #F05F40"></span><br><span>Bunga yang anda dapatkan dalam setahun dari saldo anda saat ini</span></h4>
                    <div class="progress">
                        <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 15%">
                            15%
                        </div>
                    </div>
                </div>
            </div>





            <div class="col-md-9">



                <!-- Website Overview -->
                <div id="Dashboard">
                    <div class="panel panel-default">
                        <div class="panel-heading main-color-bg">
                            <h3 class="panel-title" > <span class="fa fa-1x fa-bank text-primary mb-1 sr-icons" style="color: #FFFFFF"></span> <span>Informasi Akun Anda</span></h3>
                        </div>
                        <div class="panel-body">
                            <div class="col-md-3">
                                <div class="well dash-box">
                                    <h3><span class="fa fa-1x fa-sheqel text-primary mb-1 sr-icons" style="color: #F05F40"></span> <br>Saldo Anda</h3>
                                    <h4>1.700.000</h4>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="well dash-box">
                                    <h3><span class="fa fa-1x fa-balance-scale text-primary mb-1 sr-icons" style="color: #F05F40"></span> <br>Total Investasi Aktif</h3>
                                    <h4>10 Lembar</h4>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="well dash-box">
                                    <h3><span class="fa fa-1x fa-calendar-times-o text-primary mb-1 sr-icons" aria-hidden="true" style="color: #F05F40"></span> <br>Member Sejak</h3>
                                    <h4>2013</h4>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="well dash-box">
                                    <h3><span class="fa fa-1x fa-credit-card text-primary mb-1 sr-icons" aria-hidden="true" style="color: #F05F40"></span> <br>Info Bunga Saat Ini</h3>
                                    <h4>20% Pertahun</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div id="isisaldo">
                    <div class="panel panel-default">
                        <div class="panel-heading main-color-bg">
                            <h3 class="panel-title" > <span class="fa fa-1x fa-bank text-primary mb-1 sr-icons" style="color: #FFFFFF"></span> <span>Isi Saldo</span></h3>
                        </div>
                        <div class="panel-body">
                            <form action="/action_page.php"  method="post">
                                <div>
                                    <label for="Label-top-up"> Jumlah Top Up</label>
                                </div>
                                <div class="input-saldo" >
                                    <input type="number" id="number" min="0">
                                </div>
                                <div>
                                    <label for="Label-no-rekening"> Nomor Rekening</label>
                                </div>
                                <div>
                                    <input type="text" id="1.1">
                                </div>
                                <div>
                                    <label for="Label-pemilik-rekening" >Pemilik Rekening</label>
                                </div>
                                <div>
                                    <input type="text" id="1.2">
                                </div>
                                <div>
                                    <label for="Label-tanggal-transfer" >Tanggal Transfer</label>
                                </div>
                                <div>
                                    <input type="date" id="1.3">
                                </div>
                                <br>
                                <div>
                                    <input type="submit" value="Konfirmasi Saldo Saldo">
                                </div>
                            </form>
                            <button onclick="clear1()">Batalkan</button>
                        </div>
                    </div>
                </div>
                <div id="tariksaldo" >
                    <div class="panel panel-default">
                        <div class="panel-heading main-color-bg">
                            <h3 class="panel-title" > <span class="fa fa-1x fa-bank text-primary mb-1 sr-icons" style="color: #FFFFFF"></span> <span>Tarik Saldo</span></h3>
                        </div>
                        <div class="panel-body">
                            <form action="/action_page.php"  method="post">
                                <div>
                                    <label for="Label-top-up" > Jumlah Saldo Yang Ingin Di Tarik</label>
                                </div>
                                <div class="tarik-saldo" id="">
                                    <input type="number" id="2.0 number2" min="0" max="100000" style="min-width: 175px">
                                </div>
                                <div>
                                    <label for="Label-no-rekening"> Nomor Rekening</label>
                                </div>
                                <div>
                                    <input type="text" id="2.1">
                                </div>
                                <div>
                                    <label for="Label-pemilik-rekening">Pemilik Rekening</label>
                                </div>
                                <div>
                                    <input type="text" id="2.2">
                                </div>
                                <div>
                                    <label for="Label-Kata-Sandi">Kata Sandi Akun</label>
                                </div>
                                <div>
                                    <input type="password" id="2.3">
                                </div>
                                <br>
                                <div>
                                    <input type="submit" value="Cairkan Saldo">

                                </div>
                            </form>
                            <button onclick="clear2()">Batalkan</button>
                        </div>
                    </div>
                </div>

























                <!-- Latest Users -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Logs Dana Transaksi</h3>
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped table-hover">
                            <tr>
                                <th>Jenis</th>
                                <th>Keterangan</th>
                                <th>Tanggal - Waktu</th>
                            </tr>
                            <tr>
                                <td>TP</td>
                                <td>Top Up Dana 1,700,000</td>
                                <td>2017-11-18 10:20:47</td>
                            </tr>
                            <tr>
                                <td>IT-K</td>
                                <td>Investasi Ternak Kambing 1 Bilyet Sisa Dana 0</td>
                                <td>2017-11-17 15:29:21</td>
                            </tr>
                            <tr>
                                <td>IT-K</td>
                                <td>Investasi Ternak Kambing 1 Bilyet Sisa Dana 2,000,000</td>
                                <td>2017-11-17 15:28:23</td>
                            </tr>
                            <tr>
                                <td>IT-K</td>
                                <td>Investasi Ternak Kambing 1 Bilyet Sisa Dana 4,000,000</td>
                                <td>2017-11-17 15:27:26</td>
                            </tr>
                            <tr>
                                <td>IT-K</td>
                                <td>Investasi Ternak Kambing 1 Bilyet Sisa Dana 6,000,000</td>
                                <td>2017-11-17 15:26:30</td>
                            </tr>
                            <tr>
                                <td>IT-K</td>
                                <td>Investasi Ternak Kambing 1 Bilyet Sisa Dana 8,000,000</td>
                                <td>2017-11-17 15:25:36</td>
                            </tr>
                            <tr>
                                <td>IT-K</td>
                                <td>Investasi Ternak Kambing 1 Bilyet Sisa Dana 10,000,000</td>
                                <td>2017-11-17 15:24:50</td>
                            </tr>
                            <tr>
                                <td>IT-K</td>
                                <td>Investasi Ternak Kambing 1 Bilyet Sisa Dana 12,000,000</td>
                                <td>2017-11-17 15:22:21</td>
                            </tr>
                            <tr>
                                <td>IT-K</td>
                                <td>Investasi Ternak Kambing 1 Bilyet Sisa Dana 14,000,000</td>
                                <td>2017-11-17 15:21:38</td>
                            </tr>
                            <tr>
                                <td>IT-K</td>
                                <td>Investasi Ternak Kambing 1 Bilyet Sisa Dana 16,000,000</td>
                                <td>2017-11-17 15:21:01</td>
                            </tr>
                            <tr>
                                <td>IT-K</td>
                                <td>Investasi Ternak Kambing 1 Bilyet Sisa Dana 18,000,000</td>
                                <td>2017-11-17 15:20:21</td>
                            </tr>
                            <tr>
                                <td>TP</td>
                                <td>Top Up Dana 20,000,000</td>
                                <td>2017-11-16 20:39:28</td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<footer id="footer">
    <p>Copyright AdminStrap, &copy; 2017</p>
</footer>


<script>
    CKEDITOR.replace( 'editor1' );
</script>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js2/bootstrap.min.js"></script>

<script type="text/javascript">
    // Select your input element.
    var number = document.getElementById('number');
    var number2 = document.getElementById('number2');

    // Listen for input event on numInput.
    number.onkeydown = function(e) {
        if(!((e.keyCode > 95 && e.keyCode < 106)
          || (e.keyCode > 47 && e.keyCode < 58) 
          || e.keyCode == 8)) {
            return false;
        }
    }
    number2.onkeydown = function(e) {
        if(!((e.keyCode > 95 && e.keyCode < 106)
                || (e.keyCode > 47 && e.keyCode < 58)
                || e.keyCode == 8)) {
            return false;
        }
    }

    function changeVisibilityfordashboard() {
        document.getElementById("isisaldo").style.display = "none";
        document.getElementById("tariksaldo").style.display = "none";
        document.getElementById("Dashboard").style.display = "block";
    }

    function changeVisibilityforisi() {
        document.getElementById("Dashboard").style.display = "none";
        document.getElementById("tariksaldo").style.display = "none";
        document.getElementById("isisaldo").style.display = "block";
    }

    function changeVisibilityfortarik() {
        document.getElementById("isisaldo").style.display = "none";
        document.getElementById("Dashboard").style.display = "none";
        document.getElementById("tariksaldo").style.display = "block";
    }
    function clear1() {
        document.getElementById('1.1').value = '';
        document.getElementById('1.2').value = '';
        document.getElementById('1.3').value = '';
    }
    function clear2() {
        document.getElementById('2.1').value = '';
        document.getElementById('2.2').value = '';
        document.getElementById('2.3').value = '';
    }

</script>
</body>
</html>
