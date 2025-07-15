<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>BIBLIOTHÈQUE</title>
    <style>
        /* Reset et couleurs principales */
        body {
            font-family: 'Georgia', serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #f5f5dc 0%, #e6dcc7 100%);
            color: #1a1a2e;
            min-height: 100vh;
        }
        
        /* En-tête */
        .cyber-header {
            background: linear-gradient(135deg, #16213e 0%, #0f172a 100%);
            color: #f5f5dc;
            padding: 1.5rem;
            text-align: center;
            box-shadow: 0 4px 12px rgba(22, 33, 62, 0.3);
        }
        
        .cyber-header h1 {
            margin: 0;
            font-size: 2.5rem;
            font-weight: bold;
            letter-spacing: 2px;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
        }
        
        .cyber-nav ul {
            list-style: none;
            padding: 0;
            display: flex;
            justify-content: center;
            gap: 2rem;
            margin: 1.5rem 0 0;
        }
        
        .cyber-nav a {
            color: #f5f5dc;
            text-decoration: none;
            font-size: 1.1rem;
            padding: 0.5rem 1rem;
            border: 2px solid transparent;
            border-radius: 25px;
            transition: all 0.3s ease;
        }
        
        .cyber-nav a:hover {
            border-color: #f5f5dc;
            background-color: rgba(245, 245, 220, 0.1);
        }
        
        /* Contenu principal */
        .cyber-main {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: calc(100vh - 140px);
            padding: 2rem;
        }
        
        /* Conteneur de login */
        .login-container {
            background: rgba(245, 245, 220, 0.95);
            padding: 3rem;
            width: 100%;
            max-width: 450px;
            border-radius: 20px;
            box-shadow: 0 8px 32px rgba(22, 33, 62, 0.2);
            backdrop-filter: blur(10px);
            border: 2px solid rgba(22, 33, 62, 0.1);
        }
        
        .scanline {
            height: 3px;
            background: linear-gradient(90deg, #16213e, #f5f5dc, #16213e);
            margin-bottom: 2rem;
            border-radius: 2px;
        }
        
        .login-title {
            text-align: center;
            margin-top: 0;
            color: #16213e;
            font-size: 1.8rem;
            font-weight: bold;
            margin-bottom: 2rem;
        }
        
        /* Formulaire */
        .cyber-form {
            display: flex;
            flex-direction: column;
            gap: 2rem;
        }
        
        .input-field {
            position: relative;
        }
        
        .input-field input {
            width: 100%;
            padding: 1rem;
            background-color: rgba(255, 255, 255, 0.8);
            border: 2px solid #d4c5a9;
            border-radius: 10px;
            box-sizing: border-box;
            font-size: 1rem;
            color: #16213e;
            transition: all 0.3s ease;
        }
        
        .input-field input:focus {
            outline: none;
            border-color: #16213e;
            background-color: rgba(255, 255, 255, 0.95);
            box-shadow: 0 0 10px rgba(22, 33, 62, 0.2);
        }
        
        .input-field label {
            position: absolute;
            left: 1rem;
            top: 1rem;
            color: #7a6c57;
            transition: all 0.3s ease;
            pointer-events: none;
            font-weight: 500;
        }
        
        .input-field input:focus + label,
        .input-field input:not(:placeholder-shown) + label {
            top: -0.7rem;
            left: 0.8rem;
            font-size: 0.85rem;
            background-color: #f5f5dc;
            padding: 0 0.5rem;
            color: #16213e;
            font-weight: bold;
            border-radius: 4px;
        }
        
        /* Bouton */
        .cyber-btn {
            background: linear-gradient(135deg, #16213e 0%, #0f172a 100%);
            color: #f5f5dc;
            border: none;
            padding: 1rem 2rem;
            cursor: pointer;
            font-size: 1.1rem;
            font-weight: bold;
            border-radius: 25px;
            transition: all 0.3s ease;
            box-shadow: 0 4px 15px rgba(22, 33, 62, 0.3);
        }
        
        .cyber-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 6px 20px rgba(22, 33, 62, 0.4);
            background: linear-gradient(135deg, #1e2a4a 0%, #16213e 100%);
        }

        .error-message {
            color: #8b0000;
            background-color: rgba(255, 182, 193, 0.3);
            border: 2px solid #cd5c5c;
            padding: 1rem;
            margin-bottom: 1rem;
            border-radius: 10px;
            text-align: center;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <header class="cyber-header">
        <h1>BIBLIOTHÈQUE</h1>
        <nav class="cyber-nav">
            <ul>
                <li><a href="home">Accueil</a></li>
            </ul>
        </nav>
    </header>
    <main class="cyber-main">
        <div class="login-container">
            <div class="scanline"></div>
            <h3 class="login-title">Se connecter en tant que bibliothécaire</h3>
            <c:if test="${not empty error}">
                    <div class="error-message">
                        ${error}
                    </div>
                </c:if>
            <form id="cyberLoginForm" action="librarian-connect" method="post" class="cyber-form">
                <div class="input-field">
                    <input type="text" name="username" id="username"  required>
                    <label for="username">Nom d'utilisateur</label>
                </div>
                <div class="input-field">
                    <input type="password" name="password" id="password"  required>
                    <label for="password">Mot de passe</label>
                </div>
                <button type="submit" class="cyber-btn">Se connecter</button>
            </form>
        </div>
    </main>

</body>
</html>