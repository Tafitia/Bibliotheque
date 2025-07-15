<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BIBLIOTHÈQUE</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&family=Playfair+Display:wght@700;800&display=swap">
    <style>
        :root {
            --navy-dark: #16213e;
            --navy-light: #1e3a8a;
            --beige-light: #f5f5dc;
            --beige-dark: #e6dcc7;
            --accent: #c8a97e;
            --text-dark: #111827;
            --shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Montserrat', sans-serif;
            background-color: var(--beige-light);
            color: var(--text-dark);
            line-height: 1.6;
        }

        /* HEADER */
        header {
            background-color: var(--navy-dark);
            padding: 2rem 0;
            box-shadow: var(--shadow);
        }

        .header-content {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 1.5rem;
            text-align: center;
        }

        .header-title {
            font-family: 'Playfair Display', serif;
            font-size: 2.5rem;
            color: var(--beige-light);
            margin-bottom: 1.5rem;
            position: relative;
            display: inline-block;
        }

        .header-title::after {
            content: '';
            position: absolute;
            bottom: -8px;
            left: 50%;
            transform: translateX(-50%);
            width: 60px;
            height: 3px;
            background-color: var(--accent);
        }

        /* NAVIGATION */
        .nav-list {
            list-style: none;
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            gap: 1rem;
        }

        .nav-link {
            color: var(--beige-light);
            text-decoration: none;
            font-size: 0.95rem;
            font-weight: 500;
            padding: 0.5rem 1rem;
            border-radius: 4px;
            transition: background-color 0.2s ease;
        }

        .nav-link:hover {
            background-color: rgba(255, 255, 255, 0.1);
        }

        /* MAIN CONTENT */
        .main-container {
            max-width: 1200px;
            margin: 2rem auto;
            padding: 0 1.5rem;
        }

        .content-layout {
            display: grid;
            grid-template-columns: 280px 1fr;
            gap: 2rem;
        }

        /* FILTERS */
        .filter-panel {
            background-color: white;
            border-radius: 8px;
            box-shadow: var(--shadow);
            padding: 1.5rem;
            height: fit-content;
        }

        .panel-title {
            font-family: 'Playfair Display', serif;
            font-size: 1.5rem;
            color: var(--navy-dark);
            margin-bottom: 0.5rem;
        }

        .panel-subtitle {
            font-size: 0.85rem;
            color: #666;
            margin-bottom: 1.5rem;
        }

        .form-group {
            margin-bottom: 1.25rem;
        }

        .form-label {
            display: block;
            font-size: 0.85rem;
            font-weight: 600;
            color: var(--navy-dark);
            margin-bottom: 0.5rem;
        }

        .form-control {
            width: 100%;
            padding: 0.75rem;
            background-color: #f9f9f9;
            border: 1px solid #e0e0e0;
            border-radius: 4px;
            font-family: 'Montserrat', sans-serif;
            font-size: 0.95rem;
            color: var(--text-dark);
            transition: border-color 0.2s ease;
        }

        .form-control:focus {
            outline: none;
            border-color: var(--navy-light);
        }

        /* Correction pour les dates d'édition */
        .date-field {
            margin-bottom: 0.75rem;
        }

        .date-field:last-child {
            margin-bottom: 0;
        }

        .btn-filter {
            width: 100%;
            padding: 0.75rem 1rem;
            background-color: var(--navy-dark);
            color: white;
            border: none;
            border-radius: 4px;
            font-family: 'Montserrat', sans-serif;
            font-weight: 600;
            font-size: 0.95rem;
            cursor: pointer;
            transition: background-color 0.2s ease;
        }

        .btn-filter:hover {
            background-color: var(--navy-light);
        }

        /* BOOK GRID */
        .books-container {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
            gap: 1.5rem;
        }

        .book-card {
            background-color: white;
            border-radius: 8px;
            box-shadow: var(--shadow);
            overflow: hidden;
            transition: transform 0.2s ease;
        }

        .book-card:hover {
            transform: translateY(-5px);
        }

        .book-header {
            background-color: var(--navy-dark);
            padding: 1.25rem;
            position: relative;
        }

        .book-id {
            position: absolute;
            top: 0.75rem;
            right: 0.75rem;
            background-color: var(--navy-light);
            color: white;
            padding: 0.25rem 0.5rem;
            border-radius: 4px;
            font-size: 0.75rem;
            font-weight: 600;
        }

        .book-title {
            color: white;
            font-size: 1.25rem;
            font-family: 'Playfair Display', serif;
            margin-bottom: 0.75rem;
            line-height: 1.3;
        }

        .book-meta {
            display: flex;
            align-items: center;
            gap: 1rem;
            color: var(--beige-light);
            font-size: 0.85rem;
        }

        .meta-item {
            display: flex;
            align-items: center;
            gap: 0.35rem;
        }

        .meta-icon {
            width: 14px;
            height: 14px;
            fill: var(--accent);
        }

        .book-content {
            padding: 1.25rem;
        }

        .book-detail {
            margin-bottom: 1rem;
            font-size: 0.9rem;
        }

        .book-label {
            font-weight: 600;
            color: var(--navy-dark);
            margin-right: 0.25rem;
        }

        .book-value {
            color: #555;
        }

        .availability-section {
            margin-top: 1rem;
            padding: 0.75rem;
            background-color: #f9f9f9;
            border-radius: 4px;
        }

        .availability-title {
            font-weight: 600;
            color: var(--navy-dark);
            margin-bottom: 0.5rem;
            font-size: 0.9rem;
        }

        .availability-list {
            list-style-type: none;
            font-size: 0.85rem;
        }

        .availability-item {
            margin-bottom: 0.4rem;
            padding-left: 1rem;
            position: relative;
        }

        .availability-item::before {
            content: '•';
            position: absolute;
            left: 0;
            top: 0;
            color: var(--accent);
        }

        .status-available {
            color: #22c55e;
            font-weight: 600;
        }

        .status-unavailable {
            color: #ef4444;
            font-weight: 600;
        }

        .book-actions {
            margin-top: 1.25rem;
            border-top: 1px solid #eee;
            padding-top: 1.25rem;
        }

        .action-form {
            margin-bottom: 0.75rem;
        }

        .action-label {
            display: block;
            font-size: 0.85rem;
            font-weight: 600;
            color: var(--navy-dark);
            margin-bottom: 0.5rem;
        }

        .action-input {
            width: 100%;
            padding: 0.65rem;
            border: 1px solid #e0e0e0;
            border-radius: 4px;
            margin-bottom: 0.75rem;
            font-family: 'Montserrat', sans-serif;
            font-size: 0.85rem;
        }

        .btn-action {
            width: 100%;
            padding: 0.65rem 1rem;
            background-color: var(--navy-dark);
            color: white;
            border: none;
            border-radius: 4px;
            font-weight: 500;
            font-size: 0.85rem;
            cursor: pointer;
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 0.4rem;
            transition: background-color 0.2s ease;
        }

        .btn-action:hover {
            background-color: var(--navy-light);
        }

        .btn-secondary {
            background-color: transparent;
            color: var(--navy-dark);
            border: 1px solid var(--navy-dark);
        }

        .btn-secondary:hover {
            background-color: rgba(30, 58, 138, 0.05);
        }

        .action-message {
            margin-top: 0.75rem;
            text-align: center;
        }

        .action-link {
            color: var(--navy-dark);
            text-decoration: none;
            font-weight: 600;
            font-size: 0.85rem;
        }

        .action-link:hover {
            text-decoration: underline;
        }

        /* RESPONSIVE */
        @media (max-width: 900px) {
            .content-layout {
                grid-template-columns: 1fr;
            }

            .filter-panel {
                margin-bottom: 1.5rem;
            }
        }

        @media (max-width: 480px) {
            .header-title {
                font-size: 2rem;
            }

            .books-container {
                grid-template-columns: 1fr;
            }
        }
    </style>
</head>
<body>
    <header>
        <div class="header-content">
            <h1 class="header-title">BIBLIOTHÈQUE</h1>
            <nav class="main-nav">
                <ul class="nav-list">
                    <c:choose>
                        <c:when test="${not empty sessionScope.sessionLibrarian}">
                            <li><a href="" class="nav-link">Accueil</a></li>
                            <li><a href="librarian" class="nav-link">Menu Bibliothécaire</a></li>
                            <li><a href="disconnect" class="nav-link">Déconnexion</a></li>
                        </c:when>
                        <c:when test="${not empty sessionScope.sessionMember}">
                            <li><a href="" class="nav-link">Accueil</a></li>
                            <li><a href="member" class="nav-link">Menu Membre</a></li>
                            <li><a href="disconnect" class="nav-link">Déconnexion</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="librarian-login" class="nav-link">Connexion Bibliothécaire</a></li>
                            <li><a href="member-login" class="nav-link">Connexion Membre</a></li>
                            <li><a href="registration" class="nav-link">Inscription</a></li>   
                        </c:otherwise>
                    </c:choose>
                </ul>
            </nav>
        </div>
    </header>

    <main class="main-container">
        <div class="content-layout">
            <!-- Filters Panel -->
            <aside class="filter-panel">
                <h2 class="panel-title">Filtres</h2>
                <p class="panel-subtitle">Affinez votre recherche</p>
                <form action="home" method="get" class="filter-form">
                    <div class="form-group">
                        <label class="form-label" for="book_genre">Genre littéraire</label>
                        <select class="form-control" name="book_genre" id="book_genre">
                            <option value="">Tous les genres</option>
                            <c:forEach var="genre" items="${bookGenres}">
                                <option value="${genre.id}">${genre.value}</option>
                            </c:forEach>
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <label class="form-label" for="author">Auteur</label>
                        <select class="form-control" name="author" id="author">
                            <option value="">Tous les auteurs</option>
                            <c:forEach var="author" items="${authors}">
                                <option value="${author.id}">${author.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    
                    <div class="form-group">
                        <label class="form-label">Période d'édition</label>
                        <div class="date-field">
                            <label class="form-label" for="edition_date_min">Du</label>
                            <input type="date" class="form-control" name="edition_date_min" id="edition_date_min">
                        </div>
                        <div class="date-field">
                            <label class="form-label" for="edition_date_max">Au</label>
                            <input type="date" class="form-control" name="edition_date_max" id="edition_date_max">
                        </div>
                    </div>
                    
                    <button type="submit" class="btn-filter">Appliquer les filtres</button>
                </form>
            </aside>

            <!-- Books Grid -->
            <div class="books-container">
                <c:forEach var="book" items="${books}">
                    <article class="book-card">
                        <div class="book-header">
                            <span class="book-id">#${book.id}</span>
                            <h3 class="book-title">${book.title}</h3>
                            <div class="book-meta">
                                <div class="meta-item">
                                    <svg class="meta-icon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                        <path d="M12 12c2.21 0 4-1.79 4-4s-1.79-4-4-4-4 1.79-4 4 1.79 4 4 4zm0 2c-2.67 0-8 1.34-8 4v2h16v-2c0-2.66-5.33-4-8-4z"/>
                                    </svg>
                                    <span>${book.author.name}</span>
                                </div>
                                <div class="meta-item">
                                    <svg class="meta-icon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                        <path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 18c-4.41 0-8-3.59-8-8s3.59-8 8-8 8 3.59 8 8-3.59 8-8 8zm.5-13H11v6l5.25 3.15.75-1.23-4.5-2.67z"/>
                                    </svg>
                                    <span>${book.editionDate}</span>
                                </div>
                            </div>
                        </div>
                        
                        <div class="book-content">
                            <div class="book-detail">
                                <span class="book-label">Genre:</span>
                                <span class="book-value">${book.bookGenre.value}</span>
                            </div>
                            
                            <div class="availability-section">
                                <h4 class="availability-title">Disponibilité</h4>
                                <ul class="availability-list">
                                    <c:if test="${not empty book.checkDate}">
                                        <li class="availability-item">
                                            Dernière vérification: ${book.checkDate}
                                        </li>
                                        <li class="availability-item">
                                            Statut: 
                                            <c:choose>
                                                <c:when test="${book.available}">
                                                    <span class="status-available">Disponible</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="status-unavailable">Indisponible</span>
                                                </c:otherwise>
                                            </c:choose>
                                        </li>
                                    </c:if>
                                    <c:if test="${empty book.checkDate}">
                                        <li class="availability-item">Vérification non effectuée</li>
                                    </c:if>
                                </ul>
                            </div>
                            
                            <div class="book-actions">
                                <form action="avalaibility" method="get" class="action-form">
                                    <input type="hidden" name="book" value="${book.id}">
                                    <label class="action-label" for="date_start_${book.id}">Date de début souhaitée:</label>
                                    <input type="date" class="action-input" name="date_start" id="date_start_${book.id}" required>
                                    <button type="submit" class="btn-action">
                                        <svg width="14" height="14" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                            <path d="M12 2C6.48 2 2 6.48 2 12C2 17.52 6.48 22 12 22C17.52 22 22 17.52 22 12C22 6.48 17.52 2 12 2ZM12 20C7.59 20 4 16.41 4 12C4 7.59 7.59 4 12 4C16.41 4 20 7.59 20 12C20 16.41 16.41 20 12 20ZM11 7H13V13H11V7ZM11 15H13V17H11V15Z" fill="currentColor"/>
                                        </svg>
                                        Vérifier la disponibilité
                                    </button>
                                </form>

                                <c:choose>
                                    <c:when test="${not empty sessionScope.sessionLibrarian}">
                                        <form action="form-loan" method="post" class="action-form">
                                            <input type="hidden" name="book" value="${book.id}">
                                            <button type="submit" class="btn-action">
                                                <svg width="14" height="14" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                    <path d="M14 5C13.4477 5 13 4.55228 13 4C13 3.44772 13.4477 3 14 3H20C20.5523 3 21 3.44772 21 4V10C21 10.5523 20.5523 11 20 11C19.4477 11 19 10.5523 19 10V6.41421L11.7071 13.7071C11.3166 14.0976 10.6834 14.0976 10.2929 13.7071C9.90237 13.3166 9.90237 12.6834 10.2929 12.2929L17.5858 5H14Z" fill="currentColor"/>
                                                    <path d="M3 7C3 5.89543 3.89543 5 5 5H10C10.5523 5 11 5.44772 11 6C11 6.55228 10.5523 7 10 7H5V19H17V14C17 13.4477 17.4477 13 18 13C18.5523 13 19 13.4477 19 14V19C19 20.1046 18.1046 21 17 21H5C3.89543 21 3 20.1046 3 19V7Z" fill="currentColor"/>
                                                </svg>
                                                Emprunter
                                            </button>
                                        </form>
                                        
                                        <form action="form-read" method="post" class="action-form">
                                            <input type="hidden" name="book_read" value="${book.id}">
                                            <button type="submit" class="btn-action btn-secondary">
                                                <svg width="14" height="14" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                    <path d="M12 5C8.13401 5 5 8.13401 5 12C5 15.866 8.13401 19 12 19C15.866 19 19 15.866 19 12C19 8.13401 15.866 5 12 5ZM3 12C3 7.02944 7.02944 3 12 3C16.9706 3 21 7.02944 21 12C21 16.9706 16.9706 21 12 21C7.02944 21 3 16.9706 3 12Z" fill="currentColor"/>
                                                    <path d="M16.9497 7.05015C17.3402 7.44067 17.3402 8.07384 16.9497 8.46436L11.9497 13.4644C11.5592 13.8549 10.926 13.8549 10.5355 13.4644C10.145 13.0739 10.145 12.4407 10.5355 12.0502L15.5355 7.05015C15.926 6.65962 16.5592 6.65962 16.9497 7.05015Z" fill="currentColor"/>
                                                </svg>
                                                Consulter sur place
                                            </button>
                                        </form>
                                    </c:when>
                                    
                                    <c:when test="${not empty sessionScope.sessionMember}">
                                        <form action="form-reservation" method="post" class="action-form">
                                            <input type="hidden" name="book" value="${book.id}">
                                            <button type="submit" class="btn-action">
                                                <svg width="14" height="14" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                    <path d="M9 2C7.89543 2 7 2.89543 7 4V20C7 21.1046 7.89543 22 9 22H18C19.1046 22 20 21.1046 20 20V8L14 2H9Z" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                                    <path d="M14 2V8H20" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                                    <path d="M12 18V12" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                                    <path d="M9 15H15" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                                </svg>
                                                Réserver
                                            </button>
                                        </form>
                                    </c:when>
                                    
                                    <c:otherwise>
                                        <div class="action-message">
                                            <a href="member-login" class="action-link">Connectez-vous pour emprunter ou réserver</a>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </article>
                </c:forEach>
            </div>
        </div>
    </main>

    <script>
        // Initialiser la date du jour pour les inputs date
        document.addEventListener('DOMContentLoaded', function() {
            const today = new Date().toISOString().split('T')[0];
            
            // Pour les champs de vérification de disponibilité
            document.querySelectorAll('[id^="date_start_"]').forEach(input => {
                input.value = today;
            });
        });
    </script>
</body>
</html>