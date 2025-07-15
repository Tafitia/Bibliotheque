<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BIBLIOTHÈQUE</title>
    <style>
        body {
            font-family: 'Georgia', serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #f5f5dc 0%, #e6dcc7 100%);
            color: #16213e;
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        
        .welcome-container {
            text-align: center;
            background: rgba(245, 245, 220, 0.9);
            padding: 3rem;
            border-radius: 20px;
            box-shadow: 0 8px 32px rgba(22, 33, 62, 0.2);
            backdrop-filter: blur(10px);
            border: 2px solid rgba(22, 33, 62, 0.1);
        }
        
        h1 {
            font-size: 3rem;
            font-weight: bold;
            letter-spacing: 3px;
            margin-bottom: 2rem;
            color: #16213e;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.1);
        }
        
        a {
            color: #f5f5dc;
            text-decoration: none;
            font-size: 1.5rem;
            font-weight: bold;
            padding: 1rem 2rem;
            background: linear-gradient(135deg, #16213e 0%, #0f172a 100%);
            border-radius: 25px;
            transition: all 0.3s ease;
            box-shadow: 0 4px 15px rgba(22, 33, 62, 0.3);
            display: inline-block;
        }
        
        a:hover {
            transform: translateY(-3px);
            box-shadow: 0 6px 20px rgba(22, 33, 62, 0.4);
            background: linear-gradient(135deg, #1e2a4a 0%, #16213e 100%);
        }
    </style>
</head>
<body>
    <div class="welcome-container">
        <h1>BIBLIOTHÈQUE</h1>
        <a href="home">Entrer dans la bibliothèque</a>
    </div>
</body>
</html>