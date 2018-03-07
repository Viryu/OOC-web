<?php

namespace App\Http\Controllers;

use App\membermodel;
use App\User;
use Illuminate\Http\Request;

use App\Http\Requests;
use Illuminate\Support\Facades\Auth;


class userController extends Controller
{
    public function insertMember(Request $request)
    {
        $data = new membermodel();

        $data->nama = $request->input('namaanda');
        $data->email = $request->input('emailanda');
        $data->password = bcrypt($request->input('kuncianda'));
        $data->nomor_telepon = $request->input('hpanda');
        $data->jenis_kelamin = $request->input('genderanda');

        $data->save();

        return redirect()->back();
    }
    public function loginMember(Request $request)
    {
        $this->validate($request,[
                'email2'=>'required|email|max:50',
                'password2'=>'required',
            ]);
        if(Auth::attempt(['email'=>$request->email2,'password'=>$request->password2])){
            return "Login success";

        }
        return "login unsuccessful";


    }


    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
    }
}
