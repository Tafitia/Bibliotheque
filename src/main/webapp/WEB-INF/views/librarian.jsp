<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
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
    }

    header {
        background: linear-gradient(135deg, #16213e 0%, #0f172a 100%);
        color: #f5f5dc;
        padding: 1.5rem;
        box-shadow: 0 4px 12px rgba(22, 33, 62, 0.3);
    }

    header h1 {
        margin: 0;
        text-align: center;
        font-size: 2.5rem;
        font-weight: bold;
        letter-spacing: 2px;
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
    }

    header nav ul {
        list-style: none;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        gap: 2rem;
        margin-top: 1rem;
    }

    header nav a {
        color: #f5f5dc;
        text-decoration: none;
        font-size: 1.1rem;
        padding: 0.5rem 1rem;
        border: 2px solid transparent;
        border-radius: 25px;
        transition: all 0.3s ease;
    }
    
    header nav a:hover {
        border-color: #f5f5dc;
        background-color: rgba(245, 245, 220, 0.1);
    }

    main {
        padding: 30px;
        max-width: 1200px;
        margin: auto;
    }

    h3 {
        color: #16213e;
        font-size: 1.8rem;
        font-weight: bold;
        margin-bottom: 25px;
        padding-bottom: 10px;
        border-bottom: 3px solid #d4c5a9;
    }

    #loans, #notifications, #read, #loan, #subscribe {
        background: rgba(245, 245, 220, 0.9);
        border-radius: 15px;
        padding: 25px;
        margin-bottom: 30px;
        box-shadow: 0 6px 20px rgba(22, 33, 62, 0.15);
        backdrop-filter: blur(10px);
        border: 2px solid rgba(22, 33, 62, 0.1);
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 15px;
        background-color: rgba(255, 255, 255, 0.8);
        border-radius: 10px;
        overflow: hidden;
        margin-bottom: 20px;
    }

    th, td {
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid rgba(22, 33, 62, 0.1);
    }

    th {
        background: linear-gradient(135deg, #16213e 0%, #0f172a 100%);
        color: #f5f5dc;
        font-weight: bold;
    }

    tr:hover {
        background-color: rgba(22, 33, 62, 0.05);
    }

    .notification-card {
        background: rgba(255, 255, 255, 0.8);
        border-radius: 10px;
        padding: 20px;
        margin-bottom: 20px;
        border: 2px solid rgba(22, 33, 62, 0.1);
        box-shadow: 0 3px 10px rgba(22, 33, 62, 0.1);
    }

    .notification-card h5 {
        color: #16213e;
        font-size: 1.3rem;
        margin-bottom: 15px;
        font-weight: bold;
        margin-top: 0;
    }

    .notification-card p {
        margin: 8px 0;
        color: #16213e;
    }

    .notification-card strong {
        color: #0f172a;
    }

    .notification-card ul {
        margin: 10px 0;
        padding-left: 20px;
    }

    .notification-card li {
        margin: 5px 0;
        color: #16213e;
    }

    form {
        margin: 15px 0;
        padding: 20px;
        background: rgba(255, 255, 255, 0.6);
        border: 2px solid rgba(22, 33, 62, 0.1);
        border-radius: 10px;
    }

    .form-group {
        margin-bottom: 15px;
    }

    label {
        display: block;
        margin-bottom: 8px;
        color: #16213e;
        font-weight: bold;
        font-size: 1.1rem;
    }

    input, select, button {
        margin-bottom: 10px;
        padding: 12px;
        border: 2px solid #d4c5a9;
        border-radius: 8px;
        font-size: 1rem;
        background-color: rgba(255, 255, 255, 0.8);
        color: #16213e;
        transition: all 0.3s ease;
        box-sizing: border-box;
    }

    input:focus, select:focus {
        outline: none;
        border-color: #16213e;
        background-color: rgba(255, 255, 255, 0.95);
        box-shadow: 0 0 8px rgba(22, 33, 62, 0.2);
    }

    button {
        background: linear-gradient(135deg, #16213e 0%, #0f172a 100%);
        color: #f5f5dc;
        border: none;
        padding: 12px 20px;
        border-radius: 20px;
        font-weight: bold;
        cursor: pointer;
        transition: all 0.3s ease;
        box-shadow: 0 3px 10px rgba(22, 33, 62, 0.3);
        width: auto;
    }

    button:hover {
        transform: translateY(-1px);
        box-shadow: 0 4px 12px rgba(22, 33, 62, 0.4);
    }

    input[type="radio"] {
        width: auto;
        margin-right: 8px;
        margin-left: 10px;
    }

    input[type="radio"] + label {
        display: inline;
        margin-right: 15px;
        font-weight: normal;
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

    .form-group ul {
        margin: 0;
        padding-left: 20px;
    }

    .form-group li {
        margin-bottom: 5px;
        color: #16213e;
    }

    .action-link {
        color: #16213e;
        text-decoration: none;
        font-weight: bold;
    }

    .action-link:hover {
        text-decoration: underline;
    }
</style>

</head>
<body>
<header>
    <h1>BIBLIOTHÈQUE</h1>
    <nav>
        <ul>
            <li><a href="home">Accueil</a></li>
            <li><a href="disconnect">Déconnexion</a></li>
        </ul>
    </nav>
</header>

<main>
    <c:if test="${not empty error}">
        <div class="error-message">
            ${error}
        </div>
    </c:if>
    <!-- Zone des emprunts -->
<div id="loans">
    <h3>Emprunts actifs</h3>
<c:choose>
    <c:when test="${empty loans}">
        <p>Aucun emprunt actif.</p>
    </c:when>
    <c:otherwise>
        <table>
            <thead>
            <tr>
                <th>ID Emprunt</th>
                <th>Membre</th>
                <th>ID Copie</th>
                <th>Bibliothécaire</th>
                <th>Date d'emprunt</th>
                <th>Date de début</th>
                <th>Date d'échéance</th>
                <th>Retourné</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="loan" items="${loans}">
                <tr>
                    <td>${loan.id}</td>
                    <td>${loan.member.username}</td>
                    <td>${loan.copy.id}</td>
                    <td>${loan.librarianLoan.username}</td>
                    <td>${loan.loanDate}</td>
                    <td>${loan.startDate}</td>
                    <td>${loan.dueDate}</td>
                    <td>
                        <c:choose>
                            <c:when test="${empty loan.returnDate}">
                                <form action="return-loan" method="post" class="return-loan-form">
                                    <input type="hidden" name="loan" value="${loan.id}" />
                                    <div style="display: flex; flex-direction: column; gap: 5px;">
                                        <label for="return_date_${loan.id}" style="font-size: 0.9rem; color: #16213e; margin-bottom: 2px;">Date de retour :</label>
                                        <input type="date" name="return_date" id="return_date_${loan.id}" required 
                                               style="padding: 6px; border: 1px solid #d4c5a9; border-radius: 4px; font-size: 0.9rem; margin-bottom: 5px;" />
                                        <button type="submit" style="padding: 8px 12px; font-size: 0.9rem;">Marquer comme retourné</button>
                                    </div>
                                </form>
                            </c:when>
                            <c:otherwise>
                                ${loan.returnDate}
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

</div>

<!-- Zone des notifications -->
<div id="notifications">
    <h3>Demandes d'extension d'emprunt</h3>
    <c:choose>
        <c:when test="${empty extensions}">
            <p>Aucune demande d'extension.</p>
        </c:when>
        <c:otherwise>
            <c:forEach var="ext" items="${extensions}">
                <div class="notification-card">
                    <h5>Extension #${ext.id}</h5>
                    <p><strong>Date d'échéance demandée :</strong> ${ext.askDueDate}</p>
                    <p><strong>Date d'extension :</strong> ${ext.extensionDate}</p>

                    <p><strong>Emprunt :</strong> #${ext.loan.id} par ${ext.loan.member.username}</p>
                    <ul>
                        <li>Titre du livre : ${ext.loan.copy.book.title}</li>
                        <li>Auteur : ${ext.loan.copy.book.author.name}</li>
                        <li>Genre : ${ext.loan.copy.book.bookGenre.value}</li>
                    </ul>
                    <p><strong>Date d'échéance originale :</strong> ${ext.loan.dueDate}</p>

                    <form action="extension-librarian" method="post">
                        <input type="hidden" name="extension" value="${ext.id}">
                        <label><input type="radio" name="decision" value="approve" required> Approuver</label>
                        <label><input type="radio" name="decision" value="decline"> Refuser</label>
                        <button type="submit">Valider</button>
                    </form>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>

    <h3>Demandes de réservation</h3>
    <c:choose>
        <c:when test="${empty reservations}">
            <p>Aucune demande de réservation.</p>
        </c:when>
        <c:otherwise>
            <c:forEach var="res" items="${reservations}">
                <div class="notification-card">
                    <h5>Réservation #${res.id}</h5>
                    <p><strong>Membre :</strong> ${res.member.username}</p>
                    <ul>
                        <li>Livre : ${res.book.title}</li>
                        <li>Auteur : ${res.book.author.name}</li>
                        <li>Genre : ${res.book.bookGenre.value}</li>
                    </ul>
                    <p><strong>Date de réservation :</strong> ${res.reservationDate}</p>
                    <p><strong>Date de début demandée :</strong> ${res.askStartDate}</p>
                    <p><strong>Date d'échéance demandée :</strong> ${res.askDueDate}</p>

                    <form action="reservation-librarian" method="post">
                        <input type="hidden" name="reservation" value="${res.id}">
                        <label><input type="radio" name="decision" value="approve" required> Approuver</label>
                        <label><input type="radio" name="decision" value="decline"> Refuser</label>
                        <button type="submit">Valider</button>
                    </form>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>

    <div id="read">
        <h3>Formulaire pour lire un livre dans la bibliothèque</h3>
        <form action="read" method="post">
            <c:choose>
                <c:when test="${not empty book_read}">
                    <div class="form-group">
                        <strong>Livre :</strong>
                        <ul>
                            <li><strong>ID du livre :</strong> ${book_read.id}</li>
                            <li><strong>Titre :</strong> ${book_read.title}</li>
                            <li><strong>Auteur :</strong> ${book_read.author.name}</li>
                            <li><strong>Genre du livre :</strong> ${book_read.bookGenre.value}</li>
                        </ul>
                        <input type="hidden" name="book" value="${book_read.id}">
                    </div>
                </c:when>
                <c:otherwise>
                    <p><a href="home" class="action-link">Vous voulez lire un livre ? Choisissez-en un d'abord</a></p>
                </c:otherwise>
            </c:choose>
            <label for="username">Nom d'utilisateur :</label>
            <input list="usernames" id="username" name="username" required />
            <datalist id="usernames">
                <c:forEach var="member" items="${members}">
                    <option value="${member.username}">${member.username}</option>
                </c:forEach>
            </datalist>
            <button type="submit">Lire</button>
        </form>
    </div>

    <div id="loan">
        <h3>Formulaire pour emprunter un livre dans la bibliothèque</h3>
        <form action="loan" method="post">
            <c:choose>
                <c:when test="${not empty book}">
                    <div class="form-group">
                        <strong>Livre :</strong>
                        <ul>
                            <li><strong>ID du livre :</strong> ${book.id}</li>
                            <li><strong>Titre :</strong> ${book.title}</li>
                            <li><strong>Auteur :</strong> ${book.author.name}</li>
                            <li><strong>Genre du livre :</strong> ${book.bookGenre.value}</li>
                        </ul>
                        <input type="hidden" name="book" value="${book.id}">
                    </div>
                </c:when>
                <c:otherwise>
                    <p><a href="home" class="action-link">Vous voulez emprunter un livre ? Choisissez-en un d'abord</a></p>
                </c:otherwise>
            </c:choose>
            <label for="username">Nom d'utilisateur :</label>
            <input list="usernames" id="username" name="username" required />
            <datalist id="usernames">
                <c:forEach var="member" items="${members}">
                    <option value="${member.username}">${member.username}</option>
                </c:forEach>
            </datalist>
            <label for="loan_date">Date d'emprunt :</label>
            <input type="date" name="loan_date" id="loan_date" required>
            <label for="duration">Durée :</label>
            <input type="number" name="duration" id="duration" min="1" required>
            <button type="submit">Emprunter</button>
        </form>
    </div>

    <div id="subscribe">
        <h3>Formulaire d'abonnement à la bibliothèque</h3>
        <form action="subscribe" method="post">
            <label for="username">Nom d'utilisateur :</label>
            <input list="usernames" id="username" name="username" required />
            <datalist id="usernames">
                <c:forEach var="member" items="${members}">
                    <option value="${member.username}">${member.username}</option>
                </c:forEach>
            </datalist>
            <label for="subscription_type">Type d'abonnement :</label>
            <select name="subscription_type" id="subscription_type" required>
                <option value="">Sélectionner le type d'abonnement</option>
                <c:forEach var="sub" items="${subscriptionTypes}">
                    <option value="${sub.id}">${sub.name}--${sub.duration}</option>
                </c:forEach>
            </select>
            <label for="start_date">Date de début :</label>
            <input type="date" name="start_date" id="start_date" required><br>
            <button type="submit">S'abonner</button>
        </form>
    </div>
</main>
</body>
</html>
<script>
    // Pré-remplir les champs de date avec la date actuelle
    document.addEventListener('DOMContentLoaded', function() {
        const today = new Date().toISOString().split('T')[0];
        
        // Pré-remplir la date d'emprunt
        const loanDateInput = document.getElementById('loan_date');
        if (loanDateInput) {
            loanDateInput.value = today;
        }
        
        // Pré-remplir la date de début d'abonnement
        const startDateInput = document.getElementById('start_date');
        if (startDateInput) {
            startDateInput.value = today;
        }
        
        // Pré-remplir toutes les dates de retour
        document.querySelectorAll('input[name="return_date"]').forEach(function(input) {
            input.value = today;
        });
    });
</script>
