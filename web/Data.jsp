<%-- 
    Document   : Data
    Created on : Apr 26, 2021, 7:17:45 PM
    Author     : kld09
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data</title>
    </head>
    <body>
        <table>
            <tr>
                <th>State</th>
                <th>Cases</th>
                <th>Deaths</th>
                <th>Vaccinated</th>
            </tr>
            <%
                Integer stateNum = (Integer) request.getAttribute("stateNum");
                String stateArray[] = (String[]) request.getAttribute("stateArray");
                int caseArray[] = (int[]) request.getAttribute("caseArray");
                int deathArray[] = (int[]) request.getAttribute("deathArray");
                int vaccineArray[] = (int[]) request.getAttribute("vaccineArray");
                if (stateNum != 0) {
                    out.print(String.format("<tr>" + "<td>%s</td>" + "<td>%o</td>" + "<td>%o</td>" + "<td>%o</td>" + "<\tr>", stateArray[stateNum-1], caseArray[stateNum-1], deathArray[stateNum-1], vaccineArray[stateNum-1]));
                } else {
                    for (int i = 0; i < stateArray.length; i++) {
                        out.print(String.format("<tr>" + "<td>%s</td>" + "<td>%o</td>" + "<td>%o</td>" + "<td>%o</td>" + "<\tr>", stateArray[i], caseArray[i], deathArray[i], vaccineArray[i]));
                    }
                }
            %>
        </table>
        <!--<p>${state}</p>-->
    </body>
</html>
