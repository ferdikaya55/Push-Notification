<?php
include("ayarla.php");

$kad = $_POST["kadi"];
$sifre = $_POST["sifre"];
$kod = rand(10000,100000);
$mail = $_POST["mail"];

$ekle = mysqli_query($baglan,"insert into kayitol(kadi,sifre,kod,mail,durum)
        values('$kad','$sifre','$kod','$mail','0')");
if($ekle)
{
    $mesaj ="Merhaba, mail aktif etme kodunuz:".$kod;
    sendMessage($mesaj);
}

 function sendMessage($gelenkod) {
    $content      = array(
        "en" => $gelenkod
    );
    $fields = array(
        'app_id' => "fc0b4c86-075e-43a4-91b3-c1e58ec548b7",
        'included_segments' => array(
            'All'
        ),
        'data' => array(
            "foo" => "bar"
        ),
        'contents' => $content,
        'web_buttons' => $hashes_array
    );
    
    $fields = json_encode($fields);
    print("\nJSON sent:\n");
    print($fields);
    
    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, "https://onesignal.com/api/v1/notifications");
    curl_setopt($ch, CURLOPT_HTTPHEADER, array(
        'Content-Type: application/json; charset=utf-8',
        'Authorization: Basic YWFmNzU2YzAtZWM0Yi00OWNkLTkxOTMtNTM5NjExZTk3ZGFl'
    ));
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
    curl_setopt($ch, CURLOPT_HEADER, FALSE);
    curl_setopt($ch, CURLOPT_POST, TRUE);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $fields);
    curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, FALSE);
    
    $response = curl_exec($ch);
    curl_close($ch);
    
    return $response;
}


?>