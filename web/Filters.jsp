Document   : Filters
Created on : Apr 26, 2021, 7:17:32 PM
Author     : kld09
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="Filters.css"/> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>COVID-19 Stats</title>
    </head>
    <body>
        <div class ="header">
            <h1>COVID - 19 Statistics</h1>
            <h3>Select the following filters to filter COVID-19 Statistics</h3>
        </div>
        <div class="row">
            <div class="column side">
            </div>
            <div class="column middle">
                <form action="Servlet" method="post">
                    <div class="labelrow">
                        <label class="labelrow element" id="stateLabel" for="stateLabel">State</label>
                        <label class="labelrow element" id="filterLabel" for="filterLabel">Filters</label>
                    </div>

                    <div class="filterrow">
                        <!-- State Filter -->
                        <select class="filterrow element" name="state" id="state">
                            <option value="allStates" selected="selected">All States</option>
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

                        <!-- Filter Filter -->
                        <select class="filterrow element" name="filters" id="filters">
                            <option value="nofilter">No Filter</option>
                            <option value="under18">Under 18</option>
                            <option value="18+">18+</option>
                            <option value="65+">65+</option>
                            <option value="male">male</option>
                            <option value="female">Female</option>
                        </select>

                    </div>
                    <div class="submitrow">
                        <!-- Percentage Checkbox -->
                        <input class="submitrow checkbox" type="checkbox" id="percentage" name="percentage" value="percentage">
                        <label for="percentCheckboxLabel"> Display as %?</label><br>

                        <!-- Submit Button -->
                        <input class="submitrow submitButton" type="submit" value="Submit">
                    </div>
                </form>
            </div >
            <div class="column side">
            </div>
        </div>
    </body>
</html>
