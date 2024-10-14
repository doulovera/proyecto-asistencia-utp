<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menú</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        nav {
            background-color: #3498db; /* Color celeste */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            position: relative;
        }
        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            display: flex; /* Usar flexbox para el menú */
            justify-content: center; /* Centrar elementos */
            flex-wrap: wrap; /* Permitir que los elementos se ajusten */
        }
        nav ul li {
            margin: 0 20px; /* Espaciado entre elementos */
        }
        nav ul li a {
            display: block;
            color: white;
            text-align: center;
            padding: 15px 20px;
            text-decoration: none;
            font-size: 16px;
            border-radius: 5px; /* Bordes redondeados */
            transition: background-color 0.3s ease, transform 0.3s ease; /* Efecto de transición */
        }
        nav ul li a:hover {
            background-color: #007bff; /* Color azul al pasar el mouse */
            transform: translateY(-2px); /* Elevar el botón */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Sombra al pasar el mouse */
        }
        nav ul li a.active {
            background-color: #16a085; /* Color de fondo para la página activa */
        }

        /* Estilos para el menú hamburguesa */
        .menu-toggle {
            display: none; /* Ocultar por defecto */
            flex-direction: column;
            cursor: pointer;
            padding: 15px;
        }
        .bar {
            height: 3px;
            width: 30px;
            background-color: white;
            margin: 4px 0;
            transition: 0.4s; /* Efecto de transición para el menú hamburguesa */
        }

        @media (max-width: 768px) {
            nav ul {
                display: none; /* Ocultar el menú en pantallas pequeñas */
                flex-direction: column; /* Mostrar en columna */
                width: 100%; /* Asegurar que el menú ocupa el ancho completo */
                background-color: #2c3e50; /* Fondo del menú */
                position: absolute; /* Posición absoluta para el menú desplegable */
                top: 60px; /* Ajustar según el alto del menú */
                left: 0;
                z-index: 1; /* Asegurar que se muestre encima */
            }
            nav ul.active {
                display: flex; /* Mostrar el menú cuando está activo */
            }
            .menu-toggle {
                display: flex; /* Mostrar el icono del menú hamburguesa */
            }
        }
    </style>
    <script>
        function toggleMenu() {
            const menu = document.getElementById('menu');
            menu.classList.toggle('active'); // Alternar la clase 'active' para mostrar/ocultar el menú
        }
    </script>
</head>
<body>
<nav>
    <div class="menu-toggle" onclick="toggleMenu()">
        <div class="bar"></div>
        <div class="bar"></div>
        <div class="bar"></div>
    </div>
    <ul id="menu">
        <li><a href="registro">Registrar usuario</a></li>
        <li><a href="datos">Consultar datos de usuario</a></li>
        <li><a href="insertar-datos">Insertar datos de usuario</a></li>
        <li><a href="horarios">Registrar salida/entrada de usuarios</a></li>
        <li><a href="graficos">Graficos</a></li>
        <li><a href="insertar-admsedes">Insertar administrador de la sede</a></li>
        <li><a href="insertar-sedes">Registrar Sede</a></li>
    </ul>
</nav>
</body>
</html>
