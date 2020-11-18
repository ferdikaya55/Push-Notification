<?php
include("ayarla.php");

$mail =$_POST["mail"];
$kod = $_POST["kod"];
$kontrolet = mysqli_query($baglan,"select * from kayitol where mail='$mail' and durum='0' and kod='$kod' ");
$say = mysqli_num_rows($kontrolet);
if(($say)>0)
{
    $guncelle = mysqli_query($baglan,"update kayitol set durum='1' where mail='$mail' and durum='0' and kod='$kod' ");
    if($guncelle)
    {
        $mesaj = "Tebrikler mailiniz aktif edildi.";
        sendMessage($mesaj);
    }
}
else
    {
         $hata = "Kullanıcı kaydınız aktif edilmedi.";
         sendMessage($hata);
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