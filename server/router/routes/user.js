//Import Modules
var express = require('express'); 
var router = express.Router();
var DBConnection = require('../../node_modules/database/DBPool');
var con = new DBConnection(); 

//Create new user
router.post('/', function(req,res){
	//Currently this is being used for testing purposes, these requests will be replaced soon
	var firstPart = "insert into users (id, first_name, last_name, age, location)\n";
	var secondPart = " values (NULL, 'charles', 'barkley', '55', 'tt');";

	con.sendQuery((firstPart+secondPart), queryResponse, res); //Sends a query to the database. (queryString, queryResponse)
});

//Update user profile information
router.put('/', function(req,res){
	res.send('PUT: Update user info');
	var query = "";
});

//Deletes user from database
router.delete('/', function(req,res) {
	res.send('DELETE: Delete User details');
	var query = "";
});

//Fetches user profile information
router.get('/', function(req,res) {
	res.send('GET: Return user details');
	var query = "";
});

//HTTP Response callback function
function queryResponse(thing, res) {
	res.send(thing); //Sends the passed in response back to the server
}

//This is used to expose the routers to the api.js (main module)
module.exports = router;

