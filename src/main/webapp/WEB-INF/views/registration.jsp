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
            line-height: 1.6;
            min-height: 100vh;
        }
        
        /* En-tête */
        .futuristic-header {
            background: linear-gradient(135deg, #16213e 0%, #0f172a 100%);
            color: #f5f5dc;
            padding: 1.5rem;
            text-align: center;
            box-shadow: 0 4px 12px rgba(22, 33, 62, 0.3);
        }
        
        .futuristic-header h1 {
            margin: 0;
            font-size: 2.5rem;
            font-weight: bold;
            letter-spacing: 2px;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
        }
        
        .futuristic-nav ul {
            list-style: none;
            padding: 0;
            display: flex;
            justify-content: center;
            gap: 2rem;
            margin: 1.5rem 0 0;
        }
        
        .futuristic-nav a {
            color: #f5f5dc;
            text-decoration: none;
            font-size: 1.1rem;
            padding: 0.5rem 1rem;
            border: 2px solid transparent;
            border-radius: 25px;
            transition: all 0.3s ease;
        }
        
        .futuristic-nav a:hover {
            border-color: #f5f5dc;
            background-color: rgba(245, 245, 220, 0.1);
        }
        
        /* Contenu principal */
        .futuristic-main {
            display: flex;
            justify-content: center;
            padding: 3rem 1rem;
        }
        
        .futuristic-container {
            width: 100%;
            max-width: 700px;
        }
        
        .futuristic-content {
            background: rgba(245, 245, 220, 0.95);
            padding: 3rem;
            border-radius: 20px;
            box-shadow: 0 8px 32px rgba(22, 33, 62, 0.2);
            backdrop-filter: blur(10px);
            border: 2px solid rgba(22, 33, 62, 0.1);
        }
        
        .section-title {
            text-align: center;
            margin-bottom: 2.5rem;
            color: #16213e;
            font-size: 2rem;
            font-weight: bold;
        }
        
        /* Formulaire */
        .futuristic-form {
            display: flex;
            flex-direction: column;
            gap: 2rem;
        }
        
        .input-group {
            position: relative;
        }
        
        .input-group input,
        .input-group select {
            width: 100%;
            padding: 1rem;
            border: 2px solid #d4c5a9;
            border-radius: 10px;
            font-size: 1rem;
            background-color: rgba(255, 255, 255, 0.8);
            color: #16213e;
            transition: all 0.3s ease;
            box-sizing: border-box;
        }
        
        .input-group input:focus,
        .input-group select:focus {
            outline: none;
            border-color: #16213e;
            background-color: rgba(255, 255, 255, 0.95);
            box-shadow: 0 0 10px rgba(22, 33, 62, 0.2);
        }
        
        .input-group label {
            display: block;
            margin-bottom: 0.5rem;
            color: #16213e;
            font-weight: bold;
            font-size: 1.1rem;
        }
        
        .input-group input::placeholder {
            color: #7a6c57;
            font-style: italic;
        }
        
        /* Masquer le highlight futuriste */
        .input-highlight {
            display: none;
        }
        
        /* Bouton */
        .futuristic-btn {
            background: linear-gradient(135deg, #16213e 0%, #0f172a 100%);
            color: #f5f5dc;
            border: none;
            padding: 1.2rem 2rem;
            font-size: 1.2rem;
            font-weight: bold;
            cursor: pointer;
            border-radius: 25px;
            margin-top: 1rem;
            transition: all 0.3s ease;
            box-shadow: 0 4px 15px rgba(22, 33, 62, 0.3);
        }
        
        .futuristic-btn:hover {
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
    <header class="futuristic-header">
        <h1>BIBLIOTHÈQUE</h1>
        <nav class="futuristic-nav">
            <ul>
                <li><a href="home">Accueil</a></li>
            </ul>
        </nav>
    </header>
    <main class="futuristic-main">
        <div class="futuristic-container">
            <div class="futuristic-content">
                <h3 class="section-title">Formulaire d'inscription en tant que membre</h3>
                    <!-- Message d'erreur -->
                <c:if test="${not empty error}">
                    <div class="error-message">
                        ${error}
                    </div>
                </c:if>

            <form id="futuristicForm" action="add-member" method="post" class="futuristic-form">
                <div class="input-group">
                    <label for="email">Email</label>
                    <input type="email" name="email" id="email" placeholder="Ex : jean@mail.com" required>
                </div>
                <div class="input-group">
                    <label for="username">Nom d'utilisateur</label>
                    <input type="text" name="username" id="username" placeholder="Ex : Jean" required>
                </div>
                <div class="input-group">
                    <label for="birth">Date de naissance</label>
                    <input type="date" name="birth" id="birth" required>
                    
                </div>
                <div class="input-group">
                    <label for="member_type">Type de membre</label>
                    <select name="member_type" id="member_type" required>
                        <option value="">Sélectionner le type de membre</option>
                        <c:forEach var="type" items="${memberTypes}">
                            <option value="${type.id}">${type.value}</option>
                        </c:forEach>
                    </select>
                    
                </div>
                <div class="input-group">
                    <label for="subscription_type">Type d'abonnement</label>
                    <select name="subscription_type" id="subscription_type" required>
                        <option value="">Sélectionner le type d'abonnement</option>
                        <c:forEach var="sub" items="${subscriptionTypes}">
                            <option value="${sub.id}">${sub.name}--${sub.duration}</option>
                        </c:forEach>
                    </select>
                    
                </div>
                <div class="input-group">
                    <label for="password">Mot de passe</label>
                    <input type="password" name="password" id="password" required>
                    
                </div>
                <div class="input-group">
                    <label for="confirm_password">Confirmer le mot de passe</label>
                    <input type="password" name="confirm_password" id="confirm_password" required>
                    
                </div>
                <button type="submit" class="futuristic-btn">S'inscrire</button>
            </form>
            </div>
        </div>
    </main>


</body>
</html>