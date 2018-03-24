var number=1;
function addPassenger(input){
	var div = document.createElement('div');
	var element = document.getElementById('addPassengerBtn');
	element.remove();
	number++;
	div.className='panel-body';
	div.setAttribute("id","passengerNumber"+number);
	div.innerHTML='<label for="passenger">Passenger Name</label>\
                        <form class="form-horizontal">\
                            <div class="form-group">\
                            <div class="col-sm-2">\
                                <select class="form-control" id="namePrefix" name="prefix">\
                                <option>Mr.</option>\
                                <option>Ms.</option>\
                                <option>Mrs.</option>\
                            </select> \
                            </div>\
                            <div class="col-sm-8">\
                                <input type="text" class="form-control" id="passengerName" placeholder="Passenger Name">\
                            </div>\
                        </div>\
                        <label for="idType">Identification Type</label>\
                        <div class="form-group">\
                            <div class="col-sm-2">\
                                <select class="form-control" id="idType">\
                                    <option>Identity Card</option>\
                                    <option>Passport</option>\
                                    <option>Driving License</option>\
                                </select>\
                            </div>\
                            <div class="col-sm-8">\
                                <input type="text" class="form-control" id="idNumber" placeholder="Identification Number">\
                            </div>\
                        </div>\
                        <div class="col-sm-2">\
                                <button type="button" class="btn btn-primary" onclick="addPassenger()" id="addPassengerBtn">Add New Passenger</button>\
                            </div>\
                        </form>';
    document.getElementById('passengerContainer').appendChild(div);


}

