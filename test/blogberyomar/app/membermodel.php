<?php

namespace App;

use Illuminate\Contracts\Auth\Authenticatable;
use Illuminate\Database\Eloquent\Model;

class membermodel extends Model
{

    protected $table = "ternakq";
    protected $primaryKey = 'member_id';
    protected $fillable = ['member_id', 'nama', 'email', 'password', 'nomor_telepon', 'jenis_kelamin'];
}
