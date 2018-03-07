<?php

use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateMembermodelsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('ternakq', function (Blueprint $table) {
            $table->increments('member_id');
            $table->string('nama',50);
            $table->string('email',40);
            $table->string('password',60);
            $table->string('nomor_telepon',14);
            $table->string('jenis_kelamin',6);
            $table->rememberToken();
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::drop('membermodels');
    }
}
