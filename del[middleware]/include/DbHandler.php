<?php

class DbHandler {
 
    private $conn;
 
    function __construct() {
        require_once dirname(__FILE__) . './DbConnect.php';
        // opening db connection
        $db = new DbConnect();
        $this->conn = $db->connect();
    }
 
	/**
	* Fetching hasil liga mingguan
	*/
	public function getHasil(){
		$stmt = $this->conn->prepare("SELECT id, nama_kegiatan, gambar_kegiatan, keterangan FROM kegiatan ORDER BY id ASC");
		
		$stmt->execute();
		$tasks = $stmt->get_result();
        $stmt->close();
		
        return $tasks;		

	}	
	public function getFasilitas(){
		$stmt = $this->conn->prepare("SELECT id, nama_fasilitas, gambar_fasilitas, keterangan FROM fasilitas ORDER BY id ASC");
		
		$stmt->execute();
		$tasks = $stmt->get_result();
        $stmt->close();
		
        return $tasks;		

	}	

		/**
	* Verifying required params posted or not
	*/
	
 
}
 
?>