<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the controller to call when that URI is requested.
|
*/

Route::get('/', function () {
    return view('index');
});

Route::get('/utama', function () {
    return view('1_utama');
});

Route::get('/pasar', function () {
    return view('2_pasarternak');
});

Route::post('insertMember', 'userController@insertMember');

Route::post('loginMember','userController@loginMember');
Route::auth();

Route::get('/home', 'HomeController@index');
