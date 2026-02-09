🏥 MedManager – Hospital Management System

MedManager is a full-stack hospital management application built using Spring Boot (Backend) and Angular (Frontend).
The project focuses on clean architecture, real-world workflows, and scalable design patterns commonly used in enterprise Java applications.

🚀 Key Features

🔹 Backend (Spring Boot)
  1. RESTful APIs using Controller → Service → Repository layered architecture
  2. DTO pattern to decouple API contracts from database entities
  3. Mapper classes for clean Entity ↔ DTO conversions
  4. Pagination support using Spring Data Pageable
  5. Enum usage for controlled values (e.g., Gender, Urgency)
  6. Database operations via Spring Data JPA

🔹 Frontend (Angular)
  1. Component-based architecture
  2. Template-driven forms for CRUD operations
  3. Server-side pagination integrated with backend
  4. Responsive UI using Bootstrap
  5. Separate dashboards for:
     a. Admin
     b. Doctor
  6. Read-only and update views for Patients and Medicines
  7. Clean and protected routing with Angular Router

🔐 Authentication (Current Implementation)
  1. Basic login functionality without JWT
  2. Doctor and Admin login credentials are hardcoded (for learning/demo purposes)
    Used to demonstrate:
    a. Role-based navigation
    b. Secure route planning (conceptually)

⚠️ This is intentional for learning phase and will be improved in future scope.

📊 Pagination Support
  1. Implemented using Spring Data Page<T>
  2. Angular consumes paginated responses (content, totalPages)
  3. Prev / Next navigation on dashboards
  4. Optimized for large datasets

🛠️ Tech Stack
1. Backend

  a. Java
  
  b. Spring Boot
  
  c. Spring Data JPA
  
  d. Hibernate
  
  e. PostgreSQL
  
  f. Maven

3. Frontend
   
  a. Angular
  
  b. TypeScript
  
  c. Bootstrap
  
  d. RxJS
  
  e. HTML / CSS

📁 Project Architecture


🔮 Future Enhancements (Planned)
  🔍 Search & filtering (patients, medicines)
  
  🔐 JWT-based authentication & authorization
  
  👨‍⚕️ Multiple doctors with doctor-specific data access
  
  🔄 Refresh-token based session handling
  
  📈 Sorting combined with pagination
  
  🧪 Unit & integration testing
  
  🌐 Deployment (Docker / Cloud)

🎯 Learning Outcome
  1. This project demonstrates hands-on experience with:
  2. Real-world Spring Boot application structure
  3. Angular frontend integration
  4. Pagination and data handling
  5. Clean coding practices and scalability considerations

👨‍💻 Author
  Prithviraj Koparde
  
  Java Backend Developer
  
  Actively building production-grade full-stack applications
