
# 🎬 Watchlist Application

A simple web-based Watchlist application built using **Spring Boot**, **Thymeleaf**, **Spring Web**, **Spring Data JPA**, **H2 Database**, and **Bean Validation**. Users can add, edit, and delete movies in their watchlist with IMDb rating validation through the OMDb API.

---

## 🚀 Features

- Add, edit, and delete movies in your watchlist
- IMDb rating validation via OMDb API integration
- Thymeleaf for dynamic server-side rendering
- H2 in-memory database for easy development
- Bean validation to ensure valid input fields
- Custom error messages for validation feedback
- H2 Console enabled for debugging database contents

---

## 🌐 Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Web**
- **Thymeleaf**
- **H2 Database**
- **Spring Data JPA**
- **Hibernate**
- **Bean Validation (JSR 380)**
- **OMDb API** (for IMDb rating fetch & validation)

---

## 🔗 OMDb API Integration

This application integrates with the [OMDb API](http://www.omdbapi.com/) to fetch movie details and validate IMDb ratings when a new movie is added to the watchlist.

Make sure you have an OMDb API key. Add it to your application configuration file:

```properties
omdbapi.key=YOUR_OMDB_API_KEY
```

---

## ⚙️ Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/watchlist-springboot.git
cd watchlist-springboot
```

### 2. Open in Spring Tool Suite (STS) or IntelliJ

Import the project as a **Maven Project**.

### 3. Run the Application

Run `WatchlistApplication.java` as a **Spring Boot App**.

### 4. Access the App

Navigate to:  
`http://localhost:8080/watchlist`

---

## 📂 H2 Database Console

To access the H2 database console:

- Go to: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:tcp://localhost/~/watchlist`
- User Name: `sa`
- Password: *(leave blank)*

---

## 📸 Screenshots

_Add screenshots here (form page, watchlist page, validation errors, etc.)_

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Author

**Sanket Nivas Chopade**  
Feel free to connect on [LinkedIn](https://www.linkedin.com/) or check out other projects on [GitHub](https://github.com/your-username)
