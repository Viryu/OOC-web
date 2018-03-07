<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Ternak-Q -- Provide for Better Future</title>

    <link href="img/portfolio/thumbnails/LOGO.ico" rel="shortcut icon">

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/creative.min.css" rel="stylesheet">
  </head>

  <body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top" style="font-size:10px; font-style: italic">
          <div class="turkish">
            <div class="likiri"><img src="img/portfolio/thumbnails/LOGOSilver.png" width="80px" height="50px"></div>
            <div class="likanan">Provide for Better Future</div>
          </div>
        </a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#about">Tentang Kami</a>
            </li>
              <li class="nav-item">
                  <a class="nav-link">|</a>
              </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#services_anchor">Layanan</a>
            </li>
              <li class="nav-item">
                  <a class="nav-link">|</a>
              </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#portfolio_anchor">Portofolio</a>
            </li>
              <li class="nav-item">
                  <a class="nav-link">|</a>
              </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#investasi_anchor">Investasi</a>
            </li>
              <li class="nav-item">
                <a class="nav-link">|</a>
              </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#contact">Kontak Kami</a>
            </li>
            <button class="button button1 nav-item js-scroll-trigger" style="font-weight: bold" data-toggle="modal" data-target="#myModal">log.in</button>
          </ul>
        </div>
      </div>
    </nav>

    <script>$('#myModal').modal('show');</script>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
         aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title" id="myModalLabel">
              Formulir</h4>
          </div>


          <div class="modal-body">
            <div class="row">
              <div class="col-md-8" style="border-right: 1px dotted #C2C2C2;padding-right: 30px;">
                <!-- Nav tabs -->
                <ul class="nav nav-tabs">
                  <li class="active"><a href="#Login" data-toggle="tab">Masuk</a></li>
                  <a>&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp</a>
                  <li><a href="#Registration" data-toggle="tab">Registrasi</a></li>
                </ul>
                <!-- Tab panes -->
                <div class="tab-content">

                  <div class="tab-pane active" id="Login">
                    <form role="form" class="form-horizontal" method="post" action={{url('/loginMember')}}>
                      {{ csrf_field() }}
                      <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">
                          Email</label>
                        <div class="col-sm-10">
                          <input type="email" class="form-control" id="email1" name="email2" placeholder="Email" />
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword1" class="col-sm-2 control-label">
                          Password</label>
                        <div class="col-sm-10">
                          <input type="password" class="form-control" id="exampleInputPassword1" name="password2" placeholder="Password" />
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-sm-2">
                        </div>
                        <div class="col-sm-10">
                          <button type="submit" class="btn btn-primary btn-sm">
                            masuk</button>
                          <a href="javascript:;">&nbsp&nbsp&nbsp&nbsp | &nbsp&nbsp&nbsp&nbspLupa Password?</a>
                        </div>
                      </div>
                    </form>
                  </div>

                  <div class="tab-pane" id="Registration">

                    <form class="form-horizontal" action={{url('/insertMember')}} method="post">
                      {{csrf_field()}}
                      <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">Nama</label>
                        <div class="col-sm-10">

                          <div class="row">
                            <div class="col-md-9">
                              <input type="text" id="namaanda" name="namaanda" class="form-control" placeholder="Nama Lengkap Anda" />
                            </div>
                            <div class="col-md-5">
                              <select class="form-control" name="genderanda">
                                <option>Pria</option>
                                <option>Wanita</option>
                              </select>
                            </div>
                          </div>

                        </div>
                      </div>

                      <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">
                          Email</label>
                        <div class="col-sm-10">
                          <input type="email" id="emailanda" name="emailanda" class="form-control" id="email" placeholder="Email Anda" />
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="mobile" class="col-sm-2 control-label">
                          Nomor</label>
                        <div class="col-sm-10">
                          <input type="number" id="hpanda" name="hpanda" class="form-control" id="mobile" placeholder="Nomor yang dapat dihubungi" />
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="password" class="col-sm-2 control-label">
                          Password</label>
                        <div class="col-sm-10">
                          <input type="password" id="kuncianda" name="kuncianda" class="form-control" id="password" placeholder="Password" />
                          <input type="password" class="form-control" id="password1" placeholder="tulis ulang password" />
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-sm-2">
                        </div>
                        <div class="col-sm-10">
                          <input type="submit" value="Simpan dan lanjutkan">
                        </div>
                      </div>
                    </form>

                  </div>
                </div>
                <div id="OR" class="hidden-xs">
                  atau
                </div>
              </div>
              <div class="col-md-4">
                <div class="row text-center sign-with">
                  <div class="col-md-12">
                    <h3>
                      Login dengan</h3>
                  </div>
                  <div class="col-md-12">
                    <div class="btn-group btn-group-justified">
                      <a href="#" class="btn btn-primary">Facebook</a> <a href="#" class="btn btn-danger">
                        Google</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>


          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Tutup</button>
          </div>
        </div>
      </div>
    </div>

    <header class="masthead text-center text-white d-flex">
      <div class="container my-auto">
        <div class="row">
          <div class="col-lg-10 mx-auto">
            <h1 class="text-uppercase">
              <strong>Ternak-Q</strong>
            </h1>
            <br>
          </div>
          <div class="col-lg-8 mx-auto">
            <p class="text-faded mb-5">Pasar Online Terpercaya untuk Pembelian dan Penjualan Ternak</p>
            <a class="btn btn-primary btn-xl js-scroll-trigger" href="#about">Pelajari Lebih Lanjut</a>
          </div>
        </div>
      </div>
    </header>

      <section class="bg-primary" id="about">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
            <h2 class="section-heading text-white">Kami Menyiapkan Kebutuhan Anda!</h2>
            <hr class="light my-4">
            <p class="text-faded mb-4">Kami menyediakan hewan ternak untuk berbagai macam kebutuhan seperti untuk qurban, restoran, dsb. dengan harga yang terjangkau.<br>Pemesanan mudah hanya dengan sekali klik!</p>
            <a class="btn btn-light btn-xl js-scroll-trigger" href="#services_anchor">Lanjut Kebawah</a>
          </div>
        </div>
      </div>
    </section>

    <section id="services">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
              <div id="services_anchor">&nbsp</div>
              <br><br>
            <h2 class="section-heading">Layanan Kami</h2>
            <hr class="my-4">
          </div>
        </div>
      </div>
      <div class="container">
        <div class="row">
          <div class="col-lg-3 col-md-6 text-center">
            <div class="service-box mt-5 mx-auto">
              <i class="fa fa-4x fa-money text-primary mb-3 sr-icons"></i>
              <h3 class="mb-3">InvestasiQ</h3>
              <p class="text-muted mb-0">Apakah Anda Ingin Mendapatkan Interest >20% pertahun? <br> Cek Cara Kerjanya
                  <br><a href="/">Disini</a></p>
            </div>
          </div>
          <div class="col-lg-3 col-md-6 text-center">
            <div class="service-box mt-5 mx-auto">
              <i class="fa fa-4x fa-home text-primary mb-3 sr-icons"></i>
              <h3 class="mb-3">TernakQ Farm</h3>
              <p class="text-muted mb-0">Beli dan Jual Ternak diKami, Pasti Untung Banyak</p>
            </div>
          </div>
          <div class="col-lg-3 col-md-6 text-center">
            <div class="service-box mt-5 mx-auto">
              <i class="fa fa-4x fa-glass text-primary mb-3 sr-icons"></i>
              <h3 class="mb-3">MILK-Q</h3>
              <p class="text-muted mb-0">Apapun yang Kami Ciptakan, Khusus Untuk Susu Murni yang Segar</p>
            </div>
          </div>
          <div class="col-lg-3 col-md-6 text-center">
            <div class="service-box mt-5 mx-auto">
              <i class="fa fa-4x fa-delicious text-primary mb-3 sr-icons"></i>
              <h3 class="mb-3">SteakQ</h3>
              <p class="text-muted mb-0">Steak dengan kualitas daging nomor 1 di Indonesia, <br>All You Can Eat bung!</p>
            </div>
          </div>
        </div>
      </div>
    </section>


    <div id="portfolio_anchor">&nbsp</div>
    <br>
    <section class="p-0" id="portfolio">
      <div class="container-fluid p-0">
        <div class="row no-gutters popup-gallery">
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="img/portfolio/fullsize/1.jpg">
              <img class="img-fluid" src="img/portfolio/thumbnails/1.jpg" alt="" >
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                    Pembelian Kambing
                  </div>
                  <div class="project-name">
                    1 <br> Harga: 4.000.000 <br> Berat 80kg
                  </div>
                </div>
              </div>
            </a>
          </div>
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="img/portfolio/fullsize/2.jpg">
              <img class="img-fluid" src="img/portfolio/thumbnails/2.jpg" alt="" width="650px" height="350px">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                    Pembelian Sapi
                  </div>
                  <div class="project-name">
                    2 <br> Harga: 60.000.000 <br> Berat 240kg
                  </div>
                </div>
              </div>
            </a>
          </div>
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="img/portfolio/fullsize/3.jpg">
              <img class="img-fluid" src="img/portfolio/thumbnails/3.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                    Pembelian Sapi
                  </div>
                  <div class="project-name">
                    3 <br> Harga: 95.000.000 <br> Berat 800kg
                  </div>
                </div>
              </div>
            </a>
          </div>
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="img/portfolio/fullsize/4.jpg">
              <img class="img-fluid" src="img/portfolio/thumbnails/4.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                    Pembelian Sapi
                  </div>
                  <div class="project-name">
                      4 <br> Harga: 56.000.000 <br> Berat 560kg
                  </div>
                </div>
              </div>
            </a>
          </div>
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="img/portfolio/fullsize/5.jpg">
              <img class="img-fluid" src="img/portfolio/thumbnails/5.jpg" alt="" width="650px" height="350px">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                    Pembelian Kerbau
                  </div>
                  <div class="project-name">
                      5 <br> Harga: 43.000.000 <br> Berat 564kg
                  </div>
                </div>
              </div>
            </a>
          </div>
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="img/portfolio/fullsize/6.jpg">
              <img class="img-fluid" src="img/portfolio/thumbnails/6.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                    Pembelian Kerbau
                  </div>
                  <div class="project-name">
                      6 <br> Harga: 78.000.000 <br> Berat 950kg
                  </div>
                </div>
              </div>
            </a>
          </div>
        </div>
      </div>
    </section>



    <div id="investasi_anchor"></div>
    <section class="bg-dark text-white">
      <div class="container text-center">
        <h2 class="mb-4">Mau Ber-Investasi Ternak dan Dapatkan Bunga Melebihi Deposito Selama 2 tahun?</h2>
        <a class="btn btn-light btn-xl sr-button" href="/">Klik Disini</a>
      </div>
    </section>

    <section id="contact">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
            <h2 class="section-heading">Hubungi Kami Sekarang Juga</h2>
            <hr class="my-4">
            <p class="mb-5">Anda bisa Membeli Ternak Kami atau Berinvestasi di Kandang Kami, <br>Segera Hubungi Kami Segera Untuk Info Lebih Lanjut!</p>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-4 ml-auto text-center">
            <i class="fa fa-phone fa-3x mb-3 sr-contact"></i>
              <br>
            <a href="callto:082292670500">0822.9267.0500</a>
          </div>
          <div class="col-lg-4 mr-auto text-center">
            <i class="fa fa-envelope-o fa-3x mb-3 sr-contact"></i>
            <p>
              <a href="mailto:BalanusaIndonesia@gmail.com">BalanusaIndonesia@gmail.com</a>
            </p>
          </div>
        </div>
      </div>
    </section>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="vendor/scrollreveal/scrollreveal.min.js"></script>
    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/creative.min.js"></script>

    <script type="text/javascript">
        if (typeof document.onselectstart!="undefined") {
            document.onselectstart=new Function ("return false");
        }
        else{
            document.onmousedown=new Function ("return false");
            document.onmouseup=new Function ("return false");
        }
    </script>

  </body>
</html>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js2/bootstrap.min.js"></script>