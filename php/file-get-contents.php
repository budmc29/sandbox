<?php
ini_set('display_errors', 1);

$url = "http://www.imdb.com/title/tt1037705";
$use_include_path = false;
$context = NULL; 
$offset = -1;

$contents = file_get_contents($url, $use_include_path, $context, $offset);

return var_dump($contents);

