# golem-rule-based-assignment
Play project using Spring Boot to test configuration-based waterfall logic implementation

## How-to
### Step 1:
Start Spring Boot Service

### Step 2:
Test ping endpoint:
  `GET http://localhost:8080/api/v1/ping`
  
### Step 3:
Test assignment endpoint:
  `POST http://localhost:8080/api/v1/classAssignment`
  
  POST body:
  `{
    "name": "Samson",
    "materials": [
        "STEEL"
    ],
    "heart": {
        "leftGem": "OPAL",
        "rightGem": "EMERALD"
    },
    "elementType": "WATER",
    "shem": [
        "DALET",
        "GIMEL",
        "CHET",
        "ALEF"
    ],
    "weight": 5000
}`

