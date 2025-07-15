<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 30px;
            padding: 30px;
            max-width: 1200px;
            margin: auto;
        }

        #card, #loans, #reservations {
            background: rgba(245, 245, 220, 0.9);
            border-radius: 15px;
            padding: 25px;
            box-shadow: 0 6px 20px rgba(22, 33, 62, 0.15);
            backdrop-filter: blur(10px);
            border: 2px solid rgba(22, 33, 62, 0.1);
        }

        #card {
            grid-column: 1 / 2;
        }

        #loans {
            grid-column: 2 / 3;
        }

        #reservations {
            grid-column: 1 / 3;
        }
        
        h3 {
            color: #16213e;
            font-size: 1.5rem;
            font-weight: bold;
            margin-bottom: 20px;
            text-align: center;
        }
        
        .member-card p {
            margin: 10px 0;
            color: #16213e;
            font-size: 1.1rem;
        }
        
        .member-card strong {
            color: #0f172a;
        }
        
        .member-card ul {
            margin: 10px 0;
            padding-left: 20px;
        }
        
        .member-card li {
            margin: 5px 0;
            color: #16213e;
        }
        
        .status-approved {
            color: #228b22;
            font-weight: bold;
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
            background-color: rgba(255, 255, 255, 0.8);
            border-radius: 10px;
            overflow: hidden;
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
            cursor: pointer;
        }
        
        th:hover {
            background: linear-gradient(135deg, #1e2a4a 0%, #16213e 100%);
        }
        
        tr:hover {
            background-color: rgba(22, 33, 62, 0.05);
        }
        
        .form-group {
            margin-bottom: 15px;
        }
        
        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #16213e;
            font-weight: bold;
        }
        
        .form-group input,
        .form-group select {
            width: 100%;
            padding: 10px;
            border: 2px solid #d4c5a9;
            border-radius: 8px;
            background-color: rgba(255, 255, 255, 0.8);
            color: #16213e;
            font-size: 1rem;
            box-sizing: border-box;
            transition: all 0.3s ease;
        }
        
        .form-group input:focus,
        .form-group select:focus {
            outline: none;
            border-color: #16213e;
            background-color: rgba(255, 255, 255, 0.95);
            box-shadow: 0 0 8px rgba(22, 33, 62, 0.2);
        }
        
        button {
            background: linear-gradient(135deg, #16213e 0%, #0f172a 100%);
            color: #f5f5dc;
            border: none;
            padding: 10px 20px;
            border-radius: 20px;
            font-weight: bold;
            cursor: pointer;
            transition: all 0.3s ease;
            box-shadow: 0 3px 10px rgba(22, 33, 62, 0.3);
        }
        
        button:hover {
            transform: translateY(-1px);
            box-shadow: 0 4px 12px rgba(22, 33, 62, 0.4);
        }
        
        .extension-form button {
            width: 100%;
            margin-top: 5px;
        }
        
        .action-link {
            color: #16213e;
            text-decoration: none;
            font-weight: bold;
        }
        
        .action-link:hover {
            text-decoration: underline;
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

        @media (max-width: 768px) {
            main {
                grid-template-columns: 1fr;
            }
            #card, #loans, #reservations {
                grid-column: auto;
            }
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
        <!-- Member Card Section -->
       <div id="card" >
            <div class="member-card">
                <p><strong>ID Membre :</strong> ${member.id}</p>
                <p><strong>Nom d'utilisateur :</strong> ${member.username}</p>
                <p><strong>Email :</strong> ${member.email}</p>
                <p><strong>Type de membre :</strong> ${member.memberType.value}</p>
                <p><strong>Date d'inscription :</strong> ${member.registrationDate}</p>
                <p><strong>Statut :</strong> <span class="status-approved">actif</span></p>
                <p><strong>Quota d'emprunts :</strong> ${member.memberType.quotaLoan}</p>
                <p><strong>Quota de réservations :</strong> ${member.memberType.quotaReservation}</p>
                <p><strong>Quota d'extensions :</strong> ${member.memberType.quotaExtension}</p>
                <p><strong>Abonnement :</strong></p>
                <ul>
                    <li><strong>Nom :</strong> ${subscription.subscriptionType.name}</li>
                    <li><strong>Durée :</strong> ${subscription.subscriptionType.duration} jours</li>
                    <li><strong>Date de début :</strong> ${subscription.subscriptionStart}</li>
                    <li><strong>Date de fin :</strong> ${subscription.subscriptionEnd}</li>
                </ul>
            </div>
        </div>

        
        <!-- Notifications Section -->
        <%-- <div id="notifications">
            <h3>Notifications</h3>
            
            <div class="notification-card">
                <h5>Extension ID : 6</h5>
                <p><strong>Due date ask :</strong> 2025-05-04</p>
                <p><strong>Extension date :</strong> 2025-04-30</p>
                <p><strong>Status :</strong> <span class="status-declined">Declined</span></p>
                <p><strong>Librarian :</strong> Jeanne</p>
                <p><strong>Treatment date :</strong> 2025-05-04</p>
                <div>
                    <p><strong>Loan ID :</strong> 14</p>
                    <div>
                        <strong>Copy :</strong>
                        <ul>
                            <li><strong>Copy ID :</strong> 2X</li>
                            <li><strong>Title :</strong> Harry Potter and the gobelets of fire</li>
                            <li><strong>Author :</strong> JK Rowling</li>
                            <li><strong>Book genre :</strong> Novel</li>
                        </ul>
                    </div>
                    <p><strong>Librarian loanner :</strong> Jeanne</p>
                    <p><strong>Start date :</strong> 2025-04-15</p>
                    <p><strong>Due date :</strong> 2025-05-01</p>
                </div>
            </div>
            
            <div class="notification-card">
                <h5>Reservation ID : 4</h5>
                <div>
                    <strong>Book :</strong>
                    <ul>
                        <li><strong>Book ID :</strong> 2</li>
                        <li><strong>Title :</strong> Harry Potter and the gobelets of fire</li>
                        <li><strong>Author :</strong> JK Rowling</li>
                        <li><strong>Book genre :</strong> Novel</li>
                    </ul>
                </div>
                <p><strong>Reservation date :</strong> 2025-04-29</p>
                <p><strong>Start date ask:</strong> 2025-05-20</p>
                <p><strong>Due date ask:</strong> 2025-05-30</p>
                <p><strong>Status :</strong> <span class="status-approved">Approved</span></p>
                <p><strong>Librarian :</strong> Jeanne</p>
                <p><strong>Treatment date :</strong> 2025-05-04</p>
                <div>
                    <li><strong>Copy ID :</strong> 2</li>
                    <p><strong>Start date :</strong> 2025-05-20</p>
                    <p><strong>Due date :</strong> 2025-05-30</p>
                </div>
            </div>
        </div>
         --%>
         
        <!-- Loans Section -->
        <div id="loans">
            <h3>Mes emprunts</h3>
            <table id="loansTable">
                <thead>
                    <tr>
                        <th data-sort="loanId">ID Emprunt</th>
                        <th data-sort="copyId">ID Copie</th>
                        <th data-sort="librarian">Bibliothécaire</th>
                        <th data-sort="loanDate">Date d'emprunt</th>
                        <th data-sort="startDate">Date de début</th>
                        <th data-sort="dueDate">Date d'échéance</th>
                        <th>Extensions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="loan" items="${loans}">
                        <tr>
                            <td>${loan.id}</td>
                            <td>${loan.copy.copyId}</td>
                            <td>${loan.librarianLoan.username}</td>
                            <td>${loan.loanDate}</td>
                            <td>${loan.startDate}</td>
                            <td>${loan.dueDate}</td>
                            <td>
                                <form action="extension" method="post" class="extension-form">
                                    <input type="hidden" name="loan" value="${loan.id}">
                                    <div class="form-group">
                                        <label for="extension">Extension (jours) :</label>
                                        <input type="number" name="duration" id="duration" min="1" max="7" required>
                                    </div>
                                    <button type="submit">Demander une extension</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
        
        <!-- Reservations Section -->
        <div id="reservations">
            <h3>Faire une réservation</h3>
            <form action="reservation" method="post" class="reservation-form">
                <c:if test="${not empty error}">
                    <div class="error-message">
                        ${error}
                    </div>
                </c:if>
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
                        <p><a href="home" class="action-link">Vous voulez réserver un livre ? Choisissez-en un d'abord</a></p>
                    </c:otherwise>
                </c:choose>

                <div class="form-group">
                    <label for="start_date">Date de début :</label>
                    <input type="date" name="start_date" id="start_date" required>
                </div>
                
                <div class="form-group">
                    <label for="duration">Durée (jours) :</label>
                    <input type="number" name="duration" id="duration" min="1" max="14" required>
                </div>
                
                <button type="submit">Réserver</button>
            </form>
        </div>
    </main>

    <script>
        // Tri du tableau
        document.addEventListener('DOMContentLoaded', function() {
            const table = document.getElementById('loansTable');
            if (table) {
                const headers = table.querySelectorAll('th[data-sort]');
                
                headers.forEach(header => {
                    header.addEventListener('click', () => {
                        const sortKey = header.getAttribute('data-sort');
                        const isAscending = header.classList.contains('sort-asc');
                        const newDir = isAscending ? 'desc' : 'asc';
                        
                        // Réinitialiser tous les en-têtes
                        headers.forEach(h => {
                            h.classList.remove('sort-asc', 'sort-desc');
                        });
                        
                        // Définir la nouvelle direction
                        header.classList.add(`sort-${newDir}`);
                        
                        // Trier le tableau
                        sortTable(table, sortKey, newDir);
                    });
                });
            }
            
            // Navigation entre sections
            const navLinks = document.querySelectorAll('.nav-link');
            navLinks.forEach(link => {
                link.addEventListener('click', function(e) {
                    e.preventDefault();
                    const sectionId = this.getAttribute('data-section');
                    
                    // Masquer toutes les sections
                    document.querySelectorAll('.content-section').forEach(section => {
                        section.classList.remove('active');
                    });
                    
                    // Afficher la section sélectionnée
                    document.getElementById(sectionId).classList.add('active');
                });
            });
        });
        
        function sortTable(table, sortKey, direction) {
            const tbody = table.querySelector('tbody');
            const rows = Array.from(tbody.querySelectorAll('tr'));
            
            rows.sort((a, b) => {
                const aValue = a.querySelector(`td:nth-child(${getColumnIndex(table, sortKey)})`).textContent;
                const bValue = b.querySelector(`td:nth-child(${getColumnIndex(table, sortKey)})`).textContent;
                
                // Pour les dates
                if (sortKey.includes('Date')) {
                    return direction === 'asc' 
                        ? new Date(aValue) - new Date(bValue)
                        : new Date(bValue) - new Date(aValue);
                }
                
                // Pour les nombres
                if (!isNaN(aValue)) {
                    return direction === 'asc'
                        ? parseFloat(aValue) - parseFloat(bValue)
                        : parseFloat(bValue) - parseFloat(aValue);
                }
                
                // Pour les chaînes de caractères
                return direction === 'asc'
                    ? aValue.localeCompare(bValue)
                    : bValue.localeCompare(aValue);
            });
            
            // Réattacher les lignes triées
            rows.forEach(row => tbody.appendChild(row));
        }
        
        function getColumnIndex(table, sortKey) {
            const headers = table.querySelectorAll('th');
            for (let i = 0; i < headers.length; i++) {
                if (headers[i].getAttribute('data-sort') === sortKey) {
                    return i + 1;
                }
            }
            return 1;
        }
    </script>

</body>
</html>