<%-- 
    Document   : regester
    Created on : Oct 30, 2016, 10:55:08 PM
    Author     : sasan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rejister Users </title>
    </head>
    <body>
        <form action="GetUserInformationServelet" method="POST">
        <table width="271" border=0">
            <tr>
                <td witdth="69"> First Name</td>
                <td width="192">
                    <input name="fname" type="text" size="25"> </td>
            </tr>
            <tr>
                <td witdth="69"> Last Name</td>
                <td width="192">
                    <input name="lname" type="text" size="25"> </td>
            </tr>
            <tr>
                <td witdth="69"> Type</td>
                <td>
                    <select name="state">
                        <option value="Worker" selected>Worker</option>
                        <option value="Owner">Owner</option>
                    </select> </td>
            </tr>
            <tr>
                <td witdth="69"> Tel</td>
                <td width="192">
                    <input name="tel" type="text" size="25"> </td>
            </tr>
            <tr>
                <td witdth="69"> Email</td>
                <td width="192">
                    <input name="email" type="text" size="25"> </td>
            </tr>
            <tr>
                <td valign="top"> Address</td>
                <td><textarea name="address" cols="30" rows="10"> </textarea></td>
            </tr>
            <tr>
                <td witdth="69"> Zip Code</td>
                <td width="192">
                    <input name="zip" type="text" size="25"> </td>
            </tr>
            <tr>
                <td><input type="submit" name="Submit" value="Insert"></td>
                <td width="192">
                   </td>
            </tr>
        </table>  
     </form>
    </body>
</html>
