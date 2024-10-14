<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Gráficos</title>
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <script src="${pageContext.request.contextPath}/js/Chart.min.js"></script>

    <style>
        .card {
            max-width: 1000px;
            width: 100%;
            min-width: 375px;
            margin: 20px;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .card h3 {
            margin-bottom: 20px;
            font-size: 24px;
            font-weight: 600;
            text-align: center;
        }
    </style>
</head>
<body>
    <%@ include file="/WEB-INF/views/includes/menu.jsp" %>

    <div class="card">
        <h3>Trabajadores por sede</h3>
        <canvas id="trab_sede"></canvas>
    </div>

    <div class="card">
        <h3>Otro graf</h3>
        <canvas id="otro_graf"></canvas>
    </div>

    <script>
        let sedes = []

        <c:forEach items="${sedes}" var="sede">
            sedes.push("${sede.nombreSede}")
        </c:forEach>

        var ctx = document.getElementById("trab_sede").getContext("2d");
        var myChart = new Chart(ctx, {
            type: "pie",
            data: {
                labels: sedes,
                datasets: [
                    {
                        label: "Trabajadores por sede",
                        data: [2, 9, 3],
                        backgroundColor: "rgba(52, 140, 158)",
                    },
                ],
            },
        });
    </script>


    <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
    </body>
</html>
