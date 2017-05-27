<?php
 
require_once 'include/DbHandler.php';
require_once 'include/PassHash.php';
require 'libs/Slim/Slim.php';

\Slim\Slim::registerAutoloader();

$app = new \Slim\Slim();

/**
 * ----------- METHODS WITHOUT AUTHENTICATION ---------------------------------
 */
 
//hasil
$app->get('/kegiatan', function () {
	$response = array();

	$db = new DbHandler();

	// fetching all hasil
	$result = $db->getHasil();
		//print_r($result);


	$response["error"] = false;
	$response["kegiatan"] = array();

	// looping through result and preparing materi array
	while ($strData = $result->fetch_assoc()) {
	    $tmp = array();
	    $tmp["id"] = utf8_encode($strData["id"]);
	    $tmp["nama_kegiatan"] = utf8_encode($strData["nama_kegiatan"]);
	    $tmp["gambar_kegiatan"] = utf8_encode($strData["gambar_kegiatan"]);
	    $tmp["keterangan"] = utf8_encode($strData["keterangan"]);
	    array_push($response["kegiatan"], $tmp);
	}

	echoRespnse(200, $response);
});

$app->get('/fasilitas', function () {
	$response = array();

	$db = new DbHandler();

	// fetching all hasil
	$result = $db->getFasilitas();
		//print_r($result);


	$response["error"] = false;
	$response["fasilitas"] = array();

	// looping through result and preparing materi array
	while ($strData = $result->fetch_assoc()) {
	    $tmp = array();
	    $tmp["id"] = utf8_encode($strData["id"]);
	    $tmp["nama_fasilitas"] = utf8_encode($strData["nama_fasilitas"]);
	    $tmp["gambar_fasilitas"] = utf8_encode($strData["gambar_fasilitas"]);
	    $tmp["keterangan"] = utf8_encode($strData["keterangan"]);
	    array_push($response["fasilitas"], $tmp);
	}

	echoRespnse(200, $response);
});





/**
 * Echoing json response to client
 * @param String $status_code Http response code
 * @param Int $response Json response
 * Daftar response
 * 200	OK
 * 201	Created
 * 304	Not Modified
 * 400	Bad Request
 * 401	Unauthorized
 * 403	Forbidden
 * 404	Not Found
 * 422	Unprocessable Entity
 * 500	Internal Server Error
 */

function verifyRequiredParams($required_fields) {
		$error = false;
		$error_fields = "";
		$request_params = array();
		$request_params = $_REQUEST;
		// Handling PUT request params
		if ($_SERVER['REQUEST_METHOD'] == 'PUT') {
			$app = \Slim\Slim::getInstance();
			parse_str($app->request()->getBody(), $request_params);
		}
		foreach ($required_fields as $field) {
			if  (!isset($request_params[$field])  || strlen(trim($request_params[$field])) <= 0) {
				$error = true;
				$error_fields .= $field . ', ';
			}
		}
		if ($error) {
		// Required field(s) are missing or empty
		// echo error json and stop the app
			$response = array();
			$app = \Slim\Slim::getInstance();
			$response["error"] = true;
			$response["message"]  =  'Required  field(s)  '  . substr($error_fields, 0, -2) . ' is missing or empty';
			echoRespnse(400, $response);
			$app->stop();
		}
}

function echoRespnse($status_code, $response) {
    $app = \Slim\Slim::getInstance();
    // Http response code
    $app->status($status_code);

    // setting response content type to json
    $app->contentType('application/json');

	//print_r($response);
    echo json_encode($response);
}


$app->run();
?>