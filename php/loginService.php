<?php
require_once 'config.php';

$response = array();

if (isset($_GET['apicall'])) {

    switch ($_GET['apicall']) {

        case 'signup':
            //checking the parameters required are available or not 
            if (isTheseParametersAvailable(array('username', 'email', 'password', 'gender'))) {

                //getting the values 
                $username = $_POST['username'];
                $email = $_POST['email'];
                $password = md5($_POST['password']);
                $gender = $_POST['gender'];

                //checking if the user is already exist with this username or email
                //as the email and username should be unique for every user 
                $stmt = $conn->prepare("SELECT id FROM login WHERE username = ? OR email = ?");
                $stmt->bind_param("ss", $username, $email);
                $stmt->execute();
                $stmt->store_result();

                //if the user already exist in the database 
                if ($stmt->num_rows > 0) {
                    $response['error'] = true;
                    $response['message'] = 'User already registered';
                    $stmt->close();
                } else if ($stmt->num_rows == "0") {

                    //if user is new creating an insert query 
                    $stmt = $conn->prepare("INSERT INTO login (username, email, password, gender) VALUES (?, ?, ?, ?)");
                    $stmt->bind_param("ssss", $username, $email, $password, $gender);

                    //if the user is successfully added to the database 
                    if ($stmt->execute()) {

                        //fetching the user back 
                        $stmt = $conn->prepare("SELECT id, id, username, email, gender FROM login WHERE username = ?");
                        $stmt->bind_param("s", $username);
                        $stmt->execute();
                        $stmt->bind_result($userid, $id, $username, $email, $gender);
                        $stmt->fetch();

                        $user = array(
                            'id' => $id,
                            'username' => $username,
                            'email' => $email,
                            'gender' => $gender
                        );

                        $stmt->close();

                        //adding the user data in response 
                        $response['error'] = false;
                        $response['message'] = 'User registered successfully';
                        $response['user'] = $user;
                    }
                }
            } else {
                $response['error'] = true;
                $response['message'] = 'required parameters are not available';
            }

            break;
        case 'login':

            if (isTheseParametersAvailable(array('username', 'password'))) {

                $username = $_POST['username'];
                $password = md5($_POST['password']);

                $stmt = $conn->prepare("SELECT id, username, email, gender FROM login WHERE username = ? AND password = ?");
                $stmt->bind_param("ss", $username, $password);

                $stmt->execute();

                $stmt->store_result();

                if ($stmt->num_rows > 0) {

                    $stmt->bind_result($id, $username, $email, $gender);
                    $stmt->fetch();

                    $user = array(
                        'id' => $id,
                        'username' => $username,
                        'email' => $email,
                        'gender' => $gender
                    );

                    $response['error'] = false;
                    $response['message'] = 'Login successfull';
                    $response['user'] = $user;
                } else {
                    //if the user not found 
                    $response['error'] = false;
                    $response['message'] = 'Invalid username or password';
                }
            }
            break;

        default:
            $response['error'] = true;
            $response['message'] = 'Invalid Operation Called';
    }
} else {
    $response['error'] = true;
    $response['message'] = 'Invalid API Call';
    phpinfo();
}

echo json_encode($response);


function isTheseParametersAvailable($params)
{

    foreach ($params as $param) {
        if (!isset($_POST[$param])) {
            return false;
        }
    }
    return true;
}
