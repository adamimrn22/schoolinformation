# Postman Testing Guide for School Management API

## Environment Setup
1. Create a new environment in Postman
2. Add variable `baseUrl` with value `http://localhost:8080`

## School Endpoints Testing

### 1. Get All Schools
```
GET {{baseUrl}}/api/schools
```
Expected Response (200 OK):
```json
[
    {
        "id": 1,
        "name": "SMK Taman Universiti",
        "code": "SMK001",
        "address1": "Jalan Pendidikan 1",
        "address2": "Taman Universiti",
        "postcode": "81300",
        "district": "Skudai",
        "state": "Johor",
        "phoneNumber": "07-5557777",
        "email": "smktu@moe.edu.my",
        "fax": "07-5558888",
        "principalName": "Ahmad bin Abdullah"
    },
    {
        "id": 2,
        "name": "SK Taman Mutiara",
        "code": "SK002",
        "address1": "Jalan Mutiara 1",
        "address2": "Taman Mutiara",
        "postcode": "81300",
        "district": "Skudai",
        "state": "Johor",
        "phoneNumber": "07-5559999",
        "email": "sktm@moe.edu.my",
        "fax": "07-5550000",
        "principalName": "Siti binti Mohamed"
    }
]
```

### 2. Get School by ID
```
GET {{baseUrl}}/api/schools/1
```
Expected Response (200 OK):
```json
{
    "id": 1,
    "name": "SMK Taman Universiti",
    "code": "SMK001",
    "address1": "Jalan Pendidikan 1",
    "address2": "Taman Universiti",
    "postcode": "81300",
    "district": "Skudai",
    "state": "Johor",
    "phoneNumber": "07-5557777",
    "email": "smktu@moe.edu.my",
    "fax": "07-5558888",
    "principalName": "Ahmad bin Abdullah"
}
```

### 3. Get Schools by District
```
GET {{baseUrl}}/api/schools/district/Skudai
```

### 4. Search Schools by Name
```
GET {{baseUrl}}/api/schools/search?name=Taman
```

## Student Endpoints Testing

### 1. Get All Students
```
GET {{baseUrl}}/api/students
```
Expected Response (200 OK):
```json
[
    {
        "id": 1,
        "name": "Ali bin Abu",
        "identificationNumber": "040503149999",
        "age": 19,
        "className": "5A",
        "email": "ali@student.edu.my",
        "school": {
            "id": 1,
            "name": "SMK Taman Universiti"
        }
    },
    {
        "id": 2,
        "name": "Siti binti Rahman",
        "identificationNumber": "040708147777",
        "age": 19,
        "className": "5A",
        "email": "siti@student.edu.my",
        "school": {
            "id": 1,
            "name": "SMK Taman Universiti"
        }
    }
]
```

### 2. Get Student by ID
```
GET {{baseUrl}}/api/students/1
```

### 3. Get Students by School
```
GET {{baseUrl}}/api/students/school/1
```

### 4. Get Student by IC
```
GET {{baseUrl}}/api/students/ic/040503149999
```

### 5. Get Students by Class
```
GET {{baseUrl}}/api/students/class/5A
```

### 6. Get Students by School and Class
```
GET {{baseUrl}}/api/students/school/1/class/5A
```

## Testing Error Scenarios

### 1. Get Non-existent School
```
GET {{baseUrl}}/api/schools/999
```
Expected Response (404 Not Found):
```json
{
    "status": 404,
    "message": "School not found with id: 999",
    "timestamp": 1704384000000
}
```

### 2. Get Non-existent Student
```
GET {{baseUrl}}/api/students/999
```
Expected Response (404 Not Found):
```json
{
    "status": 404,
    "message": "Student not found with id: 999",
    "timestamp": 1704384000000
}
```
