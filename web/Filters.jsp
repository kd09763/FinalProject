<%-- 
    Document   : Filters
    Created on : Apr 26, 2021, 7:17:32 PM
    Author     : kld09
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>COVID - 19 Statistics</h1>
        <p>Select the following filters to filter COVID-19 Statistics under the following filters</p>
        <form>
            <!-- Age filter -->
            <label for="ageLabel">Age</label>
            <select name="age" id ="age">
                <option value="allAges" selected="selected">All Ages</option>
                <option value="eighteen">18+</option>
                <option value="sixty">60+</option>
            </select>

            <!-- State Filter -->
            <label for="stateLabel">State</label>
            <select name="state" id="state">
                <option value="all" selected="selected">All States</option>
                <option value="AL">Alabama</option>
                <option value="AK">Alaska</option>
                <option value="AZ">Arizona</option>
                <option value="AR">Arkansas</option>
                <option value="CA">California</option>
                <option value="CO">Colorado</option>
                <option value="CT">Connecticut</option>
                <option value="DE">Delaware</option>
                <option value="DC">District Of Columbia</option>
                <option value="FL">Florida</option>
                <option value="GA">Georgia</option>
                <option value="HI">Hawaii</option>
                <option value="ID">Idaho</option>
                <option value="IL">Illinois</option>
                <option value="IN">Indiana</option>
                <option value="IA">Iowa</option>
                <option value="KS">Kansas</option>
                <option value="KY">Kentucky</option>
                <option value="LA">Louisiana</option>
                <option value="ME">Maine</option>
                <option value="MD">Maryland</option>
                <option value="MA">Massachusetts</option>
                <option value="MI">Michigan</option>
                <option value="MN">Minnesota</option>
                <option value="MS">Mississippi</option>
                <option value="MO">Missouri</option>
                <option value="MT">Montana</option>
                <option value="NE">Nebraska</option>
                <option value="NV">Nevada</option>
                <option value="NH">New Hampshire</option>
                <option value="NJ">New Jersey</option>
                <option value="NM">New Mexico</option>
                <option value="NY">New York</option>
                <option value="NC">North Carolina</option>
                <option value="ND">North Dakota</option>
                <option value="OH">Ohio</option>
                <option value="OK">Oklahoma</option>
                <option value="OR">Oregon</option>
                <option value="PA">Pennsylvania</option>
                <option value="RI">Rhode Island</option>
                <option value="SC">South Carolina</option>
                <option value="SD">South Dakota</option>
                <option value="TN">Tennessee</option>
                <option value="TX">Texas</option>
                <option value="UT">Utah</option>
                <option value="VT">Vermont</option>
                <option value="VA">Virginia</option>
                <option value="WA">Washington</option>
                <option value="WV">West Virginia</option>
                <option value="WI">Wisconsin</option>
                <option value="WY">Wyoming</option>
            </select>

            <!-- Gender Filter -->
            <label for="gender">Gender</label>
            <select name="gender" id="gender">
                <option value="allGender">All Genders</option>
                <option value="female">female</option>
                <option value="male">male</option>
            </select>

            <!-- Percentage Checkbox -->
            <input type="checkbox" id="percentage" name="percentage" value="percentage">
            <label for="percentCheckboxLabel"> Display as %?</label><br>
            
            <!-- Submit Button -->
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
